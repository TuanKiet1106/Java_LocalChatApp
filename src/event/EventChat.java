package event;

import model.ModelReceiveMessage;
import model.ModelSendMessage;

public interface EventChat {

    public void sendMessage(ModelSendMessage data);

    public void receiveMessage(ModelReceiveMessage data);
}