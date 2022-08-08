package Task3;

public class General_Task3 {

    public static void main(String[] args) {

        Server server = new Server();
        Client c1 = new Client("Леха", Priority.VIP);
        Client c2 = new Client("Настя", Priority.VIP);
        Client c3 = new Client("Натали", Priority.STANDARD);
        Client c4 = new Client("Егор", Priority.LOW);
        Client c5 = new Client("Серега", Priority.STANDARD);
        Client c6 = new Client("Денис", Priority.LOW);
        Client c7 = new Client("Катя", Priority.STANDARD);
        Client c8 = new Client("Макс", Priority.VIP);
        Client c9 = new Client("Артем", Priority.STANDARD);

        server.addInQueue(c1);
        server.addInQueue(c2);
        server.addInQueue(c3);
        server.addInQueue(c4);
        server.addInQueue(c5);
        server.addInQueue(c6);
        server.addInQueue(c7);
        server.addInQueue(c8);
        server.addInQueue(c9);

        server.showQueue();
    }
}
