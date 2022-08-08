import java.util.Objects;

public class Buyer{
    private String name;
    private int age;
    private Discount discount;

    public Buyer(String name, int age, Discount discount) {
        this.name = name;
        this.age = age;
        this.discount = discount;
    }

    public Buyer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", age=" + age +
                ", discount=" + discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Buyer buyer = (Buyer) o;

        if (age != buyer.age) return false;
        if (!Objects.equals(name, buyer.name)) return false;
        return discount == buyer.discount;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        result = 31 * result + (discount != null ? discount.hashCode() : 0);
        return result;
    }

//    @Override
//    public int compareTo(Buyer buyer) {
//        if(this.getAge() > buyer.getAge()) {
//            return 1;
//        } else if (this.getAge() < buyer.getAge()) {
//            return -1;
//        } else {
//            return 0;
//        }
//    }
}
