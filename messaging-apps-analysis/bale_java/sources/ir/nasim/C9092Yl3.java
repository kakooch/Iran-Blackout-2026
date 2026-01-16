package ir.nasim;

import java.lang.reflect.InvocationTargetException;

/* renamed from: ir.nasim.Yl3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C9092Yl3 {
    public static final C9092Yl3 a = new C9092Yl3();

    private C9092Yl3() {
    }

    public final VW7 a(Class cls) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        AbstractC13042fc3.i(cls, "modelClass");
        try {
            Object objNewInstance = cls.getDeclaredConstructor(null).newInstance(null);
            AbstractC13042fc3.h(objNewInstance, "{\n            modelClass…).newInstance()\n        }");
            return (VW7) objNewInstance;
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Cannot create an instance of " + cls, e);
        } catch (InstantiationException e2) {
            throw new RuntimeException("Cannot create an instance of " + cls, e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("Cannot create an instance of " + cls, e3);
        }
    }
}
