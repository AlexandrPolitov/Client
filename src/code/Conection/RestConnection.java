package code.Conection;

import code.models.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Component
public class RestConnection implements Connection {

    // GET
    private static final String GET_ALL_USERS =
            "http://localhost:8080/api/users";
    private static final String GET_USER =
            "http://localhost:8080/api/user/";
    // + user_id
    private static final String GET_LAST_MESSAGES =
            "http://localhost:8080/api/messages/getLast/";
    // + dialogue_id + / + user_id
    private static final String GET_ALL_MESSAGES =
            "http://localhost:8080/api/messages/getAll/";
    // + dialogue_id

    private static final String GET_DIALOGUES =
            "http://localhost:8080/api/dialogues/get/";
    // + user_id

    // POST
    private static final String ADD_USER =
            "http://localhost:8080/api/user/add";
    private static final String AUTH_USER =
            "http://localhost:8080/api/authUser";


    private RestTemplate restTemplate;

    @Autowired
    public RestConnection(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<UserInfo> getUserList() {
        return convertToList(restTemplate.getForObject(
                GET_ALL_USERS,
                UserInfo[].class));
    }

    public User authUser(String login, String password) {
        return restTemplate.postForObject(
                AUTH_USER,
                new LogPass(login, password),
                User.class);
    }

    public User getUserById(Integer user_id){
        return restTemplate.getForObject(
                GET_USER + user_id.toString(),
                User.class);
    }

    public User addNewUser(String login, String password, String email){
        return restTemplate.postForObject(
                ADD_USER,
                new User(1, login, password, email),
                User.class);
    }

    public List<Message> getAllMessages(Integer dialogue_id) {
        return convertToList( restTemplate.getForObject(
                GET_ALL_MESSAGES + dialogue_id.toString(),
                Message[].class));
    }

    public List<Message> getLastMessages(Integer dialogue_id, Integer user_id) {
        return convertToList( restTemplate.getForObject(
                GET_LAST_MESSAGES + dialogue_id.toString() +
                        "/" + user_id,
                Message[].class));
    }

    public List<Dialogue> getDialogues(Integer user_id) {
        return convertToList(restTemplate.getForObject(
                GET_DIALOGUES,
                Dialogue[].class));
    }

    private List<UserInfo> convertToList(UserInfo[] usersInfo) {
        List<UserInfo> list = new ArrayList<>();
        for (UserInfo userInfo: usersInfo) {
            list.add(userInfo);
        }
        return list;
    }

    private List<Dialogue> convertToList(Dialogue[] dialogues) {
        List<Dialogue> list = new ArrayList<>();
        for (Dialogue dialogue: dialogues) {
            list.add(dialogue);
        }
        return list;
    }

    private List<Message> convertToList(Message[] messages) {
        List<Message> list = new ArrayList<>();
        for (Message message: messages) {
            list.add(message);
        }
        return list;
    }
}

   /* String uri = "http://localhost:8080/api/users";
    RestTemplate restTemplate = new RestTemplate();
    UserInfo[] results = restTemplate.getForObject(uri, UserInfo[].class);
		for(UserInfo info : results)
            System.out.println(info.toString());

    uri = "http://localhost:8080/api/authUser";
    User result = restTemplate.postForObject( uri,
            new LogPass("alex", "qwedsf"),
            User.class);
		System.out.println(result.toString());

    uri = "http://localhost:8080/api/user/4";
    result = restTemplate.getForObject(uri, User.class);
		System.out.println(result.toString());

    uri = "http://localhost:8080/api/user/add";
    result = restTemplate.postForObject(uri,new User(1, "Vladimir", "QAZxsw5725", "asde@sdf.sdf"), User.class);
		System.out.println(result.toString());*/