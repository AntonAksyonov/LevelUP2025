package homework9.phone_directory;

public class TopNumber implements Comparable<TopNumber> {
    private String number;
    private Integer count;

    public TopNumber(String number, Integer count) {
        this.number = number;
        this.count = count;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public int compareTo(TopNumber o) {
        return -this.count.compareTo(o.count);
    }

    @Override
    public String toString() {
        return "TopNumber{" +
                "number=" + number +
                ", count=" + count +
                '}';
    }
}
