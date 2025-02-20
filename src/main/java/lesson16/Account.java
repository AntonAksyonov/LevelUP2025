package lesson16;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Getter
@AllArgsConstructor
public class Account {

//    private static final Object lock = new String();

    private final Lock lock = new ReentrantLock();
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    volatile int amount;

    public Account() {
        this(0);
    }

//    public synchronized void withdraw(int value) {
////        synchronized (lock) {
////        this.amount -= value;
//        this.amount = this.amount - value;

    /// /        }
//    }
//
//    public synchronized void deposit(int value) {
//        this.amount = this.amount + value;
//    }
    public void withdraw(int value) {
        readWriteLock.readLock().lock();
        try {
            this.amount = this.amount - value;
        }
        finally {
            readWriteLock.readLock().unlock();
        }
//        synchronized (lock) {
//        this.amount -= value;
//        }
    }

    public void deposit(int value) {
        readWriteLock.writeLock().lock();
        try {
            this.amount = this.amount + value;
        }
        finally {
            readWriteLock.writeLock().unlock();
        }
    }
}