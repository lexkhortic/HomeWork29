package Task3;

import java.util.*;

public class Server {

    public static Comparator<Client> clientComp = (c1, c2) -> {
        if ((c1.getPriority() == Priority.VIP) && (c2.getPriority() != Priority.VIP)){
            return -1;
        } else if ((c1.getPriority() != Priority.VIP) && (c2.getPriority() == Priority.VIP)) {
            return 1;
        }

        if ((c1.getPriority() == Priority.STANDARD) && (c2.getPriority() == Priority.LOW)){
            return -1;
        } else if ((c1.getPriority() != Priority.STANDARD) && (c2.getPriority() != Priority.LOW)) {
            return 1;
        }

        return 0;
    };

    public static PriorityQueue<Client> serverQueue = new PriorityQueue<>(clientComp);

    public void addInQueue(Client client) {
        client.setTime(new GregorianCalendar());
        serverQueue.add(client);
    }

    public void showQueue(){
        PriorityQueue<Client> tempQueue = new PriorityQueue<>(serverQueue);
        Iterator<Client> myIterator = tempQueue.iterator();
        while (myIterator.hasNext())
        {
            System.out.println(tempQueue.poll());
        }
    }
}
