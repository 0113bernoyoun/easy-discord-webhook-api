import com.discord.api.MsgAPI;
import com.discord.model.Author;
import com.discord.model.Embed;
import com.discord.model.Message;
import com.discord.model.Thumbnail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MsgApiTest {

    MsgAPI msgAPI = MsgAPI.getInstance();

    @Test
    public void 메시지_테스트() throws Exception {
        // given
        String webhookUrl = "";
        String content = "테스트 메시지입니다.";
        String avatarUrl = "";
        List<Embed> embeds = new ArrayList<>();
        embeds.add(new Embed.Builder().
                setAuthor(new Author("test author", "https://www.reddit.com/r/cats/", "https://i.imgur.com/R66g1Pe.jpg"))
                .setThumbnail(new Thumbnail("https://i.imgur.com/fKL31aD.jpg"))
                .build());
        // when
        Message message = new Message.Builder()
                .setContent(content)
                .setEmbeds(embeds)
                .setUsername("테스터")
                .build();
        boolean result = msgAPI.send(message, webhookUrl);
        // then
        Assertions.assertEquals(result, true);
    }

}
