import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Task1_2 {
    public static Comparator<Buyer> buyerComparator = (a, b) -> {

        if (a.getAge() >= 60 && b.getAge() < 60){
            return -1;
        } else if (a.getAge() < 60 && b.getAge() >= 60) {
            return 1;
        }

        if (a.getAge() < 60 && b.getAge() < 60){
            if ((a.getDiscount() == Discount.VIP) && (b.getDiscount() != Discount.VIP)){
                return -1;
            } else if ((a.getDiscount() != Discount.VIP) && (b.getDiscount() == Discount.VIP)) {
                return 1;
            }
        }

        return 0;

    };

    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static PriorityQueue<Buyer> myQueue = new PriorityQueue<>(buyerComparator);

    public static void main(String[] args) throws IOException {
        Buyer b1 = new Buyer("Натали", 26, Discount.VIP);
        Buyer b2 = new Buyer("Настя", 60, Discount.STANDARD);
        Buyer b3 = new Buyer("Таня", 22, Discount.VIP);
        Buyer b4 = new Buyer("Лёха", 60, Discount.MEDIUM);
        Buyer b5 = new Buyer("Олеся", 35, Discount.STANDARD);
        Buyer b6 = new Buyer("Кирилл", 3, Discount.MEDIUM);
        Buyer b7 = new Buyer("Антон", 11, Discount.VIP);
        Buyer b8 = new Buyer("Артём", 65, Discount.STANDARD);
        Buyer b9 = new Buyer("Влад", 15, Discount.MEDIUM);
        Buyer b10 = new Buyer("Володя", 100, Discount.MEDIUM);
        Buyer b11 = new Buyer("Ваня", 1, Discount.STANDARD);
        Buyer b12 = new Buyer("Влад", 27, Discount.VIP);

        myQueue.add(b1);
        myQueue.add(b2);
        myQueue.add(b3);
        myQueue.add(b4);
        myQueue.add(b5);
        myQueue.add(b6);
        myQueue.add(b7);
        myQueue.add(b8);
        myQueue.add(b9);
        myQueue.add(b10);
        myQueue.add(b11);
        myQueue.add(b12);
        addInQueue();

        showQueue();
        deleteVIP();
        System.out.println("После удаления VIP:");
        showQueue();

    }
    public static void showQueue(){
        PriorityQueue<Buyer> tempQueue = new PriorityQueue<>(myQueue);
        Iterator<Buyer> myIterator = tempQueue.iterator();
        while (myIterator.hasNext())
        {
            System.out.println(tempQueue.poll());
        }
    }

    public static void addInQueue() throws IOException {
        Buyer newBuyer = new Buyer();
        System.out.print("Введите ИМЯ: ");
        newBuyer.setName(reader.readLine());
        System.out.print("Введите ВОЗРАСТ: ");
        newBuyer.setAge(Integer.parseInt(reader.readLine()));
        System.out.print("Введите ДИСКОНТ:\n1 - VIP\n2 - STANDARD\n3 - MEDIUM\n");
        int typeDiscount = Integer.parseInt(reader.readLine());
        switch (typeDiscount) {
            case 1:
                newBuyer.setDiscount(Discount.VIP);
                break;
            case 2:
                newBuyer.setDiscount(Discount.STANDARD);
                break;
            case 3:
                newBuyer.setDiscount(Discount.MEDIUM);
                break;
            default:
                System.out.println("Неверный ввод!");

        }
        myQueue.add(newBuyer);
    }

    public static void deleteVIP() {
        myQueue.removeIf(el -> el.getDiscount().equals(Discount.VIP));
    }
}
