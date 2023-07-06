package model;

import org.json.JSONException;
import org.json.JSONObject;

public class ModelLogin {

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ModelLogin(String userName, String password) {
        this.username = userName;
        this.password = password;
    }

    public ModelLogin() {
    }

    private String username;
    private String password;
    
    public JSONObject toJsonObject() {
        try {
            JSONObject obj = new JSONObject();
            obj.put("userName", username);
            obj.put("password", password);
            return obj;
        } catch (JSONException e) {
            return null;
        }
    }
}