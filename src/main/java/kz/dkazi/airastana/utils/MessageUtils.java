package kz.dkazi.airastana.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.CodeSignature;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

public class MessageUtils {

    public static String buildErrorMessage(JoinPoint jp, Throwable e) {
        return String.format(Constants.ERROR_MSG_TEMPLATE,
                jp.getSignature().getDeclaringTypeName(),
                jp.getSignature().getName(),
                e.getCause() != null? e.getCause() : "NULL");
    }

    public static String getDescription(JoinPoint jp, String template, boolean isAddValues) {
        var codeSignature = (CodeSignature) jp.getSignature();
        String[] methodParams = codeSignature.getParameterNames();
        Object[] methodArgs = jp.getArgs();

        Set<String> fields = new HashSet<>();
        for (int i = 0; i < methodParams.length; i++) {
            String name = methodParams[i];
            Object valueObject = methodArgs[i];

            if (valueObject == null) {
                continue;
            }
            if (isObject(valueObject)) {
                fields.addAll(getObjectFields(valueObject, isAddValues));
            } else {
                if (isAddValues) {
                    name += "=" + valueObject;
                }
                fields.add(name);
            }
        }
        try {
            return String.format(template, String.join(", ", fields));
        } catch (Exception ignored) {
        }
        return template;
    }

    private static Set<String> getObjectFields(Object obj, boolean isAddValues) {
        Set<String> result = new HashSet<>();
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true); // private -> public
            try {
                Object fieldValue = field.get(obj);
                if (fieldValue != null) {
                    String fieldName = field.getName();
                    if (isAddValues) {
                        fieldName += "=" + fieldValue;
                    }
                    result.add(fieldName);
                }
            } catch (Exception ignored) {
            }
        }
        return result;
    }

    private static boolean isObject(Object obj) {
        return obj.getClass().getPackageName().startsWith("kz.dkazi");
    }
}
