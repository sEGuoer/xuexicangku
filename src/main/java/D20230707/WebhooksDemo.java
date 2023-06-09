package D20230707;

import com.slack.api.Slack;
import com.slack.api.webhook.Payload;
import com.slack.api.webhook.WebhookResponse;

import java.io.IOException;

import static com.slack.api.webhook.WebhookPayloads.payload;
public class WebhooksDemo {
    private static final Slack SLACK = Slack.getInstance();
    private static final String WEBHOOK_URL = System.getenv("WebhookURL");

    public static void main(String[] args) throws IOException {
        WebhooksDemo.simpleText();/*
        WebhooksDemo.textWithLink();
        WebhooksDemo.lambdaPayload();*/
    }

    public static void simpleText() throws IOException {
        Payload payload = Payload.builder().text("你好吗").build();

        WebhookResponse response = SLACK.send(WEBHOOK_URL, payload);
        System.out.println(response.getCode());
        if (response.getCode() == 200) {
            System.out.println(response.getBody());
        }
    }

    public static void textWithLink() throws IOException {
        Payload payload = Payload.builder().text("Hello, World! <https://slack.com|slack>").build();

        WebhookResponse response = SLACK.send(WEBHOOK_URL, payload);

        if (response.getCode() == 200) {
            System.out.println(response.getBody());
        }
    }

    public static void lambdaPayload() throws IOException {
        WebhookResponse response = SLACK.send(WEBHOOK_URL, payload(p -> p.text("Hello, World! lambda payload")));

        if (response.getCode() == 200) {
            System.out.println(response.getBody());
        }
    }
}
