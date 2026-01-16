package ir.nasim;

import android.gov.nist.core.Separators;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* renamed from: ir.nasim.tC6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
final class C21158tC6 {
    public static final C21158tC6 a = new C21158tC6();

    private C21158tC6() {
    }

    public final String a(Constructor constructor) {
        AbstractC13042fc3.i(constructor, "constructor");
        StringBuilder sb = new StringBuilder();
        sb.append(Separators.LPAREN);
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        AbstractC13042fc3.h(parameterTypes, "constructor.parameterTypes");
        int length = parameterTypes.length;
        int i = 0;
        while (i < length) {
            Class<?> cls = parameterTypes[i];
            i++;
            AbstractC13042fc3.h(cls, "parameterType");
            sb.append(AbstractC21912uL5.c(cls));
        }
        sb.append(")V");
        String string = sb.toString();
        AbstractC13042fc3.h(string, "sb.toString()");
        return string;
    }

    public final String b(Field field) {
        AbstractC13042fc3.i(field, "field");
        Class<?> type = field.getType();
        AbstractC13042fc3.h(type, "field.type");
        return AbstractC21912uL5.c(type);
    }

    public final String c(Method method) {
        AbstractC13042fc3.i(method, "method");
        StringBuilder sb = new StringBuilder();
        sb.append(Separators.LPAREN);
        Class<?>[] parameterTypes = method.getParameterTypes();
        AbstractC13042fc3.h(parameterTypes, "method.parameterTypes");
        int length = parameterTypes.length;
        int i = 0;
        while (i < length) {
            Class<?> cls = parameterTypes[i];
            i++;
            AbstractC13042fc3.h(cls, "parameterType");
            sb.append(AbstractC21912uL5.c(cls));
        }
        sb.append(Separators.RPAREN);
        Class<?> returnType = method.getReturnType();
        AbstractC13042fc3.h(returnType, "method.returnType");
        sb.append(AbstractC21912uL5.c(returnType));
        String string = sb.toString();
        AbstractC13042fc3.h(string, "sb.toString()");
        return string;
    }
}
