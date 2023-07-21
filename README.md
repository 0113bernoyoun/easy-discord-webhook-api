# easy-discord-webhook-api

디스코드 웹훅에 대한 API 라이브러리입니다.


## 의존성
jdk17을 기준으로 만들었습니다.

jackson라이브러리에 대한 의존이 있습니다. 해당 라이브러리를 추가 후 사용해야합니다.
e.g.
```groovy
implementation 'com.fasterxml.jackson.core:jackson-databind:2.15.2'
```


## 사용방법
MsgAPI는 싱글턴으로 구성되어있습니다. 해당 API에 대한 초기화는 다음과 같이 이루어집니다.
```java
MsgAPI msgAPI = MsgAPI.getInstance();
```

웹훅 URL에 대한 설정이 필요합니다.
```java
MsgAPI msgAPI = MsgAPI.getInstance();
msgAPI.setWebHookUrl("WEBHOOK_URL");
```

단순 메시지만 전송하는 경우 MsgAPI의 send(String content)함수 또는 send(String content, String webhookUrl)을 호출하여 보낼 수 있습니다.

```java
MsgAPI msgAPI = MsgAPI.getInstance();
msgAPI.setWebHookUrl("WEBHOOK_URL");
msgAPI.send("테스트 메시지");
```

```java
MsgAPI msgAPI = MsgAPI.getInstance();
msgAPI.send("테스트 메시지", "WEBHOOK_URL");
```

각 필드에 대한 디테일한 설정은 Message 클래스를 통해 설정한 후 전송이 가능합니다.

```java
List<Embed> embeds = new ArrayList<>();
embeds.add(new Embed.Builder().
        setAuthor(new Author("test author", "https://www.reddit.com/r/cats/", "https://i.imgur.com/R66g1Pe.jpg"))
        .setThumbnail(new Thumbnail("https://i.imgur.com/fKL31aD.jpg"))
        .build());
Message message = new Message.Builder()
                  .setContent(content)
                  .setEmbeds(embeds)
                  .setUsername("테스터")
                  .build();
msgAPI.send(message); // 또는 msgAPI.send(message, "WEBHOOK_URL");
```

웹훅의 속성에 대한 자세한 사항은 아래 링크를 참고 부탁드립니다.

https://birdie0.github.io/discord-webhooks-guide/discord_webhook.html

https://discord.com/developers/docs/resources/webhook
