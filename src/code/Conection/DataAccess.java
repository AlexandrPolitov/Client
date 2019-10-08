package code.Conection;

import code.models.Dialogue;
import code.models.Message;
import code.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataAccess implements Data {

    private Connection connection;

    private User user;
    private List<Dialogue> dialogues;
    private List<Message> messages;

    @Autowired
    public DataAccess(RestConnection restConnection) {
        connection = restConnection;
    }

    public void loadDialogues() {
        dialogues = connection.getDialogues(user.getId());
    }

    public void addDialogue(Dialogue dialogue) {
        dialogues.add(dialogue);
    }

    public void setUser(User user) {
        this.user = user;
    }
}
