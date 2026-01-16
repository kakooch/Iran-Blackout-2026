package ir.nasim;

import java.lang.reflect.Field;

/* loaded from: classes8.dex */
public abstract class TA1 {
    private static final void a(int i, int i2) {
        if (i2 <= i) {
            return;
        }
        throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + i + ", got " + i2 + ". Please update the Kotlin standard library.").toString());
    }

    private static final SA1 b(E90 e90) {
        return (SA1) e90.getClass().getAnnotation(SA1.class);
    }

    private static final int c(E90 e90) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        try {
            Field declaredField = e90.getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(e90);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static final StackTraceElement d(E90 e90) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        String strC;
        AbstractC13042fc3.i(e90, "<this>");
        SA1 sa1B = b(e90);
        if (sa1B == null) {
            return null;
        }
        a(1, sa1B.v());
        int iC = c(e90);
        int i = iC < 0 ? -1 : sa1B.l()[iC];
        String strB = C9048Yg4.a.b(e90);
        if (strB == null) {
            strC = sa1B.c();
        } else {
            strC = strB + '/' + sa1B.c();
        }
        return new StackTraceElement(strC, sa1B.m(), sa1B.f(), i);
    }
}
