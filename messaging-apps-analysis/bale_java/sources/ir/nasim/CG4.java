package ir.nasim;

import android.os.IBinder;
import ir.nasim.XZ2;
import java.lang.reflect.Field;

/* loaded from: classes3.dex */
public final class CG4 extends XZ2.a {
    private final Object a;

    private CG4(Object obj) {
        this.a = obj;
    }

    public static Object D2(XZ2 xz2) throws SecurityException {
        if (xz2 instanceof CG4) {
            return ((CG4) xz2).a;
        }
        IBinder iBinderAsBinder = xz2.asBinder();
        Field[] declaredFields = iBinderAsBinder.getClass().getDeclaredFields();
        Field field = null;
        int i = 0;
        for (Field field2 : declaredFields) {
            if (!field2.isSynthetic()) {
                i++;
                field = field2;
            }
        }
        if (i != 1) {
            throw new IllegalArgumentException("Unexpected number of IObjectWrapper declared fields: " + declaredFields.length);
        }
        AbstractC3795Cj5.j(field);
        if (field.isAccessible()) {
            throw new IllegalArgumentException("IObjectWrapper declared field not private!");
        }
        field.setAccessible(true);
        try {
            return field.get(iBinderAsBinder);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("Could not access the field in remoteBinder.", e);
        } catch (NullPointerException e2) {
            throw new IllegalArgumentException("Binder object is null.", e2);
        }
    }

    public static XZ2 E2(Object obj) {
        return new CG4(obj);
    }
}
