package event;

import model.ModelLogin;
import model.ModelRegister;

public interface EventLogin {

    public void login(ModelLogin data);

    public void register(ModelRegister data, EventMessage message);

    public void goRegister();

    public void goLogin();
}