package ir.nasim;

import android.app.Application;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

/* renamed from: ir.nasim.Ub6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC7996Ub6 {
    private static final List a = AbstractC10360bX0.p(Application.class, androidx.lifecycle.y.class);
    private static final List b = AbstractC9766aX0.e(androidx.lifecycle.y.class);

    public static final Constructor c(Class cls, List list) throws SecurityException {
        AbstractC13042fc3.i(cls, "modelClass");
        AbstractC13042fc3.i(list, "signature");
        Constructor<?>[] constructors = cls.getConstructors();
        AbstractC13042fc3.h(constructors, "modelClass.constructors");
        for (Constructor<?> constructor : constructors) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            AbstractC13042fc3.h(parameterTypes, "constructor.parameterTypes");
            List listF1 = AbstractC10242bK.f1(parameterTypes);
            if (AbstractC13042fc3.d(list, listF1)) {
                AbstractC13042fc3.g(constructor, "null cannot be cast to non-null type java.lang.reflect.Constructor<T of androidx.lifecycle.SavedStateViewModelFactoryKt.findMatchingConstructor>");
                return constructor;
            }
            if (list.size() == listF1.size() && listF1.containsAll(list)) {
                throw new UnsupportedOperationException("Class " + cls.getSimpleName() + " must have parameters in the proper order: " + list);
            }
        }
        return null;
    }

    public static final VW7 d(Class cls, Constructor constructor, Object... objArr) {
        AbstractC13042fc3.i(cls, "modelClass");
        AbstractC13042fc3.i(constructor, "constructor");
        AbstractC13042fc3.i(objArr, "params");
        try {
            return (VW7) constructor.newInstance(Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Failed to access " + cls, e);
        } catch (InstantiationException e2) {
            throw new RuntimeException("A " + cls + " cannot be instantiated.", e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException("An exception happened in constructor of " + cls, e3.getCause());
        }
    }
}
