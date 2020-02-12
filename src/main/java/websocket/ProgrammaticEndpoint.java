package websocket;

import javax.enterprise.context.ApplicationScoped;
import javax.websocket.*;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;

@ApplicationScoped
public class ProgrammaticEndpoint extends Endpoint {

    private final ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();

    //Method to be invoked when a new conversation begins
    @Override
    public void onOpen(Session session, EndpointConfig config) {
        session.addMessageHandler((MessageHandler.Whole<String>) message -> {
            try {
                session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    //Method to be invoked on close of a conversation
    @Override
    public void onClose(Session session, CloseReason closeReason) {
        super.onClose(session, closeReason);
    }


    //Method to be invoked when there is an error
    @Override
    public void onError(Session session, Throwable thr) {
        super.onError(session, thr);
    }
}
