package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JavaType;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/* loaded from: classes.dex */
public class BeanUtil {
    public static Object getDefaultValue(JavaType javaType) {
        Class<?> rawClass = javaType.getRawClass();
        Class<?> clsPrimitiveType = ClassUtil.primitiveType(rawClass);
        if (clsPrimitiveType != null) {
            return ClassUtil.defaultValue(clsPrimitiveType);
        }
        if (javaType.isContainerType() || javaType.isReferenceType()) {
            return JsonInclude.Include.NON_EMPTY;
        }
        if (rawClass == String.class) {
            return "";
        }
        if (javaType.isTypeOrSubTypeOf(Date.class)) {
            return new Date(0L);
        }
        if (!javaType.isTypeOrSubTypeOf(Calendar.class)) {
            return null;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTimeInMillis(0L);
        return gregorianCalendar;
    }

    public static String checkUnsupportedType(JavaType javaType) {
        String str;
        String str2;
        Class<?> rawClass = javaType.getRawClass();
        if (isJava8TimeClass(rawClass)) {
            str = "Java 8 date/time";
            str2 = "com.fasterxml.jackson.datatype:jackson-datatype-jsr310";
        } else {
            if (!isJodaTimeClass(rawClass)) {
                return null;
            }
            str = "Joda date/time";
            str2 = "com.fasterxml.jackson.datatype:jackson-datatype-joda";
        }
        return String.format("%s type %s not supported by default: add Module \"%s\" to enable handling", str, ClassUtil.getTypeDescription(javaType), str2);
    }

    public static boolean isJava8TimeClass(Class<?> cls) {
        return cls.getName().startsWith("java.time.");
    }

    public static boolean isJodaTimeClass(Class<?> cls) {
        return cls.getName().startsWith("org.joda.time.");
    }
}
