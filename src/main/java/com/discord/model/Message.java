package com.discord.model;

import java.util.List;

public record Message(String content, String username, String avatar_url, Boolean tts, List<Embed> embeds, List<File> files, AllowedMentions allowed_mentions, String payload_json, List<Attachment> attachments, Integer flags, String thread_name) {
    public static class Builder{
        private String content;
        private String username;
        private String avatar_url;
        private Boolean tts;
        private List<Embed> embeds;
        private List<File> files;
        private AllowedMentions allowed_mentions;
        private String payload_json;
        private List<Attachment> attachments;
        private Integer flags;
        private String thread_name;

        public Builder(){}

        public Message build(){
            return new Message(content, username, avatar_url, tts, embeds, files, allowed_mentions, payload_json, attachments, flags, thread_name);
        }

        public Builder setContent(String content) {
            this.content = content;
            return this;
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setAvatarUrl(String avatar_url) {
            this.avatar_url = avatar_url;
            return this;
        }

        public Builder setTts(boolean tts) {
            this.tts = tts;
            return this;
        }

        public Builder setEmbeds(List<Embed> embeds) {
            this.embeds = embeds;
            return this;
        }

        public Builder setFiles(List<File> files) {
            this.files = files;
            return this;
        }

        public Builder setAllowedMentions(AllowedMentions allowed_mentions) {
            this.allowed_mentions = allowed_mentions;
            return this;
        }

        public Builder setPayloadJson(String payload_json) {
            this.payload_json = payload_json;
            return this;
        }

        public Builder setAttachments(List<Attachment> attachments) {
            this.attachments = attachments;
            return this;
        }

        public Builder setFlags(int flags) {
            this.flags = flags;
            return this;
        }

        public Builder setThreadName(String thread_name) {
            this.thread_name = thread_name;
            return this;
        }

    }
}
