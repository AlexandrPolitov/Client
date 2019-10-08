package code.Conection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ThreadListner {

    private Connection connection;
    private DataAccess data;

    @Autowired
    public ThreadListner (RestConnection restConnection, DataAccess data) {
        this.connection = restConnection;
        this.data = data;
    }

    public void run() {
        Thread myThread = new Thread(new Runnable()
        {
            public void run() //Этот метод будет выполняться в побочном потоке
            {
                System.out.println("Привет из побочного потока!");
            }
        });
        myThread.start();	//Запуск потока

    }
}
