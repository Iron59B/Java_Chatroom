import java.util.ArrayList;

public class Channel {

    private ArrayList<User> connectedUsers;
    private int currUserID;

    public Channel() {
        connectedUsers = new ArrayList<User>();
        currUserID = 0;
    }

    public void connect(User user) {
        connectedUsers.add(user);
        user.setUserID(currUserID);
        currUserID++;
    }

    public void disconnect(User user) {
        connectedUsers.remove(user.getUserID());
    }

    public void notify(Message message, String sender) {
        for (User user : connectedUsers) {
            if (!sender.equals(user.getUsername())) {
                user.update(message, sender);
            }
        }
    }


}
