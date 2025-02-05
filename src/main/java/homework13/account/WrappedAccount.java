package homework13.account;

import javax.naming.OperationNotSupportedException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.math.BigDecimal;

public class WrappedAccount implements InvocationHandler {

    private Account account;

    public WrappedAccount(Account account) {
        this.account = account;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String nameMethod = method.getName();
        if (nameMethod.equals("deposit") || nameMethod.equals("withdraw")) {
            Method executingMethod = Account.class.getMethod(nameMethod, BigDecimal.class);
            boolean blockedBoolean = executingMethod.isAnnotationPresent(Blocked.class);
            if (blockedBoolean) {
                Blocked blocked = executingMethod.getAnnotation(Blocked.class);
                throw new OperationNotSupportedException(blocked.value());
            }
        }
        return method.invoke(account, args);
    }
}
