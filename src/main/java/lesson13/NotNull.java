package lesson13;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Inherited
//@Target(value = {ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER})
@Target({ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE
        , ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotNull {
}