package model;

import org.json.JSONException;
import org.json.JSONObject;

public class ModelUserAccount {

    public int getUserID() {
        return userID;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public ModelUserAccount(int userID, String username, String gender, String image, boolean status) {
        this.userID = userID;
        this.username = username;
        this.gender = gender;
        this.image = image;
        this.status = status;
    }
    
    public ModelUserAccount(Object json) {
        JSONObject obj = (JSONObject) json;
        try {
            userID = obj.getInt("userID");
            username = obj.getString("username");
            gender = obj.getString("gender");
            image = obj.getString("image");
            status = obj.getBoolean("status");
        } catch (JSONException e) {
            System.err.println(e);
        }
    }
    
    private int userID;
    private String username;
    private String gender;
    private String image;
    private boolean status;
}
