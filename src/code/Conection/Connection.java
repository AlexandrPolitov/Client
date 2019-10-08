package code.Conection;

import code.models.Dialogue;
import code.models.Message;
import code.models.User;
import code.models.UserInfo;

import java.util.List;

public interface Connection {
    public List<UserInfo> getUserList();
    public User authUser(String login, String password);
    public User getUserById(Integer user_id);
    public User addNewUser(String login, String password, String email);
    public List<Message> getAllMessages(Integer dialogue_id);
    public List<Message> getLastMessages(Integer dialogue_id, Integer user_id);
    public List<Dialogue> getDialogues(Integer user_id);
}
