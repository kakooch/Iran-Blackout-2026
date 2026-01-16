package ir.nasim;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* renamed from: ir.nasim.Zp5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC9364Zp5 {
    public static final Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            AbstractC7180Qp5.a.a("Unable to find PreviewProvider '" + str + '\'', e);
            return null;
        }
    }

    public static final List b(AbstractC15886kL2 abstractC15886kL2, UA2 ua2) {
        return d(abstractC15886kL2, ua2, false, 4, null);
    }

    private static final List c(AbstractC15886kL2 abstractC15886kL2, UA2 ua2, boolean z) {
        ArrayList arrayList = new ArrayList();
        List listS = AbstractC10360bX0.s(abstractC15886kL2);
        while (!listS.isEmpty()) {
            AbstractC15886kL2 abstractC15886kL22 = (AbstractC15886kL2) AbstractC13610gX0.N(listS);
            if (((Boolean) ua2.invoke(abstractC15886kL22)).booleanValue()) {
                if (z) {
                    return AbstractC9766aX0.e(abstractC15886kL22);
                }
                arrayList.add(abstractC15886kL22);
            }
            listS.addAll(abstractC15886kL22.b());
        }
        return arrayList;
    }

    static /* synthetic */ List d(AbstractC15886kL2 abstractC15886kL2, UA2 ua2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return c(abstractC15886kL2, ua2, z);
    }

    public static final AbstractC15886kL2 e(AbstractC15886kL2 abstractC15886kL2, UA2 ua2) {
        return (AbstractC15886kL2) AbstractC15401jX0.s0(c(abstractC15886kL2, ua2, true));
    }

    public static final Object[] f(Class cls, int i) throws IllegalAccessException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (cls == null) {
            return new Object[0];
        }
        try {
            Constructor<?>[] constructors = cls.getConstructors();
            int length = constructors.length;
            int i2 = 0;
            boolean z = false;
            Constructor<?> constructor = null;
            while (true) {
                if (i2 < length) {
                    Constructor<?> constructor2 = constructors[i2];
                    if (constructor2.getParameterTypes().length == 0) {
                        if (z) {
                            break;
                        }
                        z = true;
                        constructor = constructor2;
                    }
                    i2++;
                } else if (!z) {
                }
            }
            constructor = null;
            if (constructor == null) {
                throw new IllegalArgumentException("PreviewParameterProvider constructor can not have parameters");
            }
            constructor.setAccessible(true);
            Object objNewInstance = constructor.newInstance(null);
            AbstractC13042fc3.g(objNewInstance, "null cannot be cast to non-null type androidx.compose.ui.tooling.preview.PreviewParameterProvider<*>");
            InterfaceC8121Up5 interfaceC8121Up5 = (InterfaceC8121Up5) objNewInstance;
            if (i < 0) {
                return g(interfaceC8121Up5.a(), interfaceC8121Up5.getCount());
            }
            List listE = AbstractC9766aX0.e(AbstractC11342cq6.p(interfaceC8121Up5.a(), i));
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listE, 10));
            Iterator it = listE.iterator();
            while (it.hasNext()) {
                arrayList.add(h(it.next()));
            }
            return arrayList.toArray(new Object[0]);
        } catch (C3392Ar3 unused) {
            throw new IllegalStateException("Deploying Compose Previews with PreviewParameterProvider arguments requires adding a dependency to the kotlin-reflect library.\nConsider adding 'debugImplementation \"org.jetbrains.kotlin:kotlin-reflect:$kotlin_version\"' to the module's build.gradle.");
        }
    }

    private static final Object[] g(InterfaceC23384wp6 interfaceC23384wp6, int i) {
        Iterator it = interfaceC23384wp6.iterator();
        Object[] objArr = new Object[i];
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = it.next();
        }
        return objArr;
    }

    private static final Object h(Object obj) throws NoSuchFieldException, SecurityException {
        if (obj != null) {
            for (Annotation annotation : obj.getClass().getAnnotations()) {
                if (annotation instanceof InterfaceC5932Ll3) {
                    for (Field field : obj.getClass().getDeclaredFields()) {
                        if (field.getType().isPrimitive()) {
                            Field declaredField = obj.getClass().getDeclaredField(field.getName());
                            declaredField.setAccessible(true);
                            return declaredField.get(obj);
                        }
                    }
                    throw new NoSuchElementException("Array contains no element matching the predicate.");
                }
            }
        }
        return obj;
    }
}
