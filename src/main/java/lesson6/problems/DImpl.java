package lesson6.problems;

public class DImpl implements D {

    @Override
    public int b() {
        return 0;
    }

    @Override
    public long c() {
        return 0;
    }

    @Override
    public void a() {

    }

    @Override
    public String d() {
        return "";
    }

    @Override
    public void print() {
        D.super.print();
    }
}
