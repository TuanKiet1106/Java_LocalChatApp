package event;

import model.ModelReceiveMessage;
import model.ModelSendMessage;

public interface EventRequest {

    public void sendRequest(ModelSendMessage data);

    public void receiveRequest(ModelReceiveMessage data);
}