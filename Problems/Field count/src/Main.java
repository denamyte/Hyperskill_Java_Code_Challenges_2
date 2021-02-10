import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/**
 Get number of accessible public fields for a given class.
 */
class FieldGetter {
    ElementType dumb1;
    Retention dumb2;
    RetentionPolicy dumb3;
    Target dumb4;
    Method dumb5;
    public int getNumberOfAccessibleFields(Class<?> clazz) {
        return clazz.getFields().length;
    }

}