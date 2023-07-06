package event;

import model.ModelMessage;

public interface EventMessage {

    public void callMessage(ModelMessage message);
}