package lesson13;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
public class WrappedAccount implements InvocationHandler {
    private LegalAccount account;
    public WrappedAccount(LegalAccount account) {
        this.account = account;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Этот метод начал свою работу");
        long start = System.currentTimeMillis();
        Field declaredField = Account.class.getDeclaredField("balance");
        declaredField.setAccessible(true);
        boolean nullable = !declaredField.isAnnotationPresent(NotNull.class);
        if (nullable) {
            System.out.println("Проверку на налловость осушествлять не будем!");
        }
        if (method.getName().equals("withdraw")
                && !nullable
                && account.getBalance() != null) {
            Object result = method.invoke(account, args);
            System.out.println("Метод отработал за %d мсек".formatted(System.currentTimeMillis() - start));
            System.out.println("Этот метод завершил свою работу");
            System.out.println("Текущий баланс счета %d usd".formatted(account.getBalance().intValue()));
            return result;
        }
        System.out.println("Этот метод завершил свою работу");
        return null;
    }
}