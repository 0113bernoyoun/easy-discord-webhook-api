package com.discord.api;

import com.discord.model.Message;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class MsgAPI {

    private String webhookUrl;
    private HttpURLConnection httpURLConnection;
    private int connectTimeout = 5000;
    private int readTimeout = 5000;

    private String requestMethod = "POST";

    private MsgAPI() {
    }

    private static class MsgApiHolder {
        public static final MsgAPI msgApi = new MsgAPI();
    }

    public static MsgAPI getInstance() {
        return MsgApiHolder.msgApi;
    }

    public void setWebHookUrl(String url) {
        MsgApiHolder.msgApi.webhookUrl = url;
    }

    public void setConnectTimeout(int time) {
        MsgApiHolder.msgApi.connectTimeout = time;
    }

    public void setReadTimeout(int time) {
        MsgApiHolder.msgApi.readTimeout = time;
    }

    public boolean send(Message message) {
        try {
            URL url = new URL(MsgApiHolder.msgApi.webhookUrl);
            MsgApiHolder.msgApi.httpURLConnection = (HttpURLConnection) url.openConnection();
            MsgApiHolder.msgApi.httpURLConnection.setConnectTimeout(MsgApiHolder.msgApi.connectTimeout);
            MsgApiHolder.msgApi.httpURLConnection.setReadTimeout(MsgApiHolder.msgApi.readTimeout);
            MsgApiHolder.msgApi.httpURLConnection.addRequestProperty("Content-Type", "application/json; utf-8");
            MsgApiHolder.msgApi.httpURLConnection.addRequestProperty("Accept", "application/json");
            MsgApiHolder.msgApi.httpURLConnection.setRequestMethod(MsgApiHolder.msgApi.requestMethod);
            MsgApiHolder.msgApi.httpURLConnection.setDoOutput(true);

            OutputStream outputStream = MsgApiHolder.msgApi.httpURLConnection.getOutputStream();
            ObjectMapper mapper = new ObjectMapper();
            byte[] jsonString = mapper.writeValueAsString(message).getBytes(StandardCharsets.UTF_8);
            outputStream.write(jsonString);
            outputStream.flush();
            outputStream.close();

            int status = MsgApiHolder.msgApi.httpURLConnection.getResponseCode();
            if (status >= 200 && status < 300) {
                return true;
            }

            return false;

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            MsgApiHolder.msgApi.httpURLConnection.disconnect();
        }
    }

    public boolean send(Message message, String webhookUrl) {
        MsgApiHolder.msgApi.webhookUrl = webhookUrl;
        return MsgApiHolder.msgApi.send(message);
    }

    public boolean send(String content) {
        Message message = new Message.Builder().setContent(content).build();
        return MsgApiHolder.msgApi.send(message);
    }

    public boolean send(String content, String webhookUrl) {
        MsgApiHolder.msgApi.webhookUrl = webhookUrl;
        return MsgApiHolder.msgApi.send(content);
    }

}
