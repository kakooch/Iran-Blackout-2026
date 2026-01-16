package ir.nasim;

import ir.nasim.AbstractC7180Qp5;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* renamed from: ir.nasim.n11, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C17469n11 {
    public static final C17469n11 a = new C17469n11();

    private C17469n11() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean a(Class[] clsArr, Class[] clsArr2) {
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        ArrayList arrayList = new ArrayList(clsArr.length);
        int length = clsArr.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            boolean z = true;
            if (i >= length) {
                break;
            }
            Class cls = clsArr[i];
            int i3 = i2 + 1;
            Class cls2 = clsArr2[i2];
            if (!AbstractC13042fc3.d(AbstractC4762Gl3.e(cls), AbstractC4762Gl3.e(cls2)) && !cls.isAssignableFrom(cls2)) {
                z = false;
            }
            arrayList.add(Boolean.valueOf(z));
            i++;
            i2 = i3;
        }
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (!((Boolean) it.next()).booleanValue()) {
                    return false;
                }
            }
        }
        return true;
    }

    private final int b(int i, int i2) {
        if (i == 0) {
            return 1;
        }
        return (int) Math.ceil((i + i2) / 10.0d);
    }

    private final int c(int i) {
        return (int) Math.ceil(i / 31.0d);
    }

    private final Method d(Method[] methodArr, String str, Class... clsArr) throws NoSuchMethodException {
        Method method;
        int length = methodArr.length;
        int i = 0;
        while (true) {
            method = null;
            if (i >= length) {
                break;
            }
            Method method2 = methodArr[i];
            if (!AbstractC13042fc3.d(str, method2.getName())) {
                if (!AbstractC20153rZ6.S(method2.getName(), str + '-', false, 2, null)) {
                    continue;
                }
                i++;
            }
            if (a.a(method2.getParameterTypes(), (Class[]) Arrays.copyOf(clsArr, clsArr.length))) {
                method = method2;
                break;
            }
            i++;
        }
        if (method != null) {
            return method;
        }
        throw new NoSuchMethodException(str + " not found");
    }

    private final Method e(Class cls, String str, Object... objArr) throws SecurityException {
        Method method;
        ArrayList arrayList = new ArrayList();
        int length = objArr.length;
        int i = 0;
        while (true) {
            method = null;
            method = null;
            if (i >= length) {
                break;
            }
            Object obj = objArr[i];
            Class<?> cls2 = obj != null ? obj.getClass() : null;
            if (cls2 != null) {
                arrayList.add(cls2);
            }
            i++;
        }
        Class[] clsArr = (Class[]) arrayList.toArray(new Class[0]);
        try {
            try {
                int iB = b(clsArr.length, 0);
                Class cls3 = Integer.TYPE;
                C24411ya3 c24411ya3Y = AbstractC23053wG5.y(0, iB);
                ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(c24411ya3Y, 10));
                Iterator it = c24411ya3Y.iterator();
                while (it.hasNext()) {
                    ((AbstractC18386oa3) it).b();
                    arrayList2.add(cls3);
                }
                Class[] clsArr2 = (Class[]) arrayList2.toArray(new Class[0]);
                Method[] declaredMethods = cls.getDeclaredMethods();
                C15872kJ6 c15872kJ6 = new C15872kJ6(3);
                c15872kJ6.b(clsArr);
                c15872kJ6.a(InterfaceC22053ub1.class);
                c15872kJ6.b(clsArr2);
                return d(declaredMethods, str, (Class[]) c15872kJ6.d(new Class[c15872kJ6.c()]));
            } catch (ReflectiveOperationException unused) {
                return method;
            }
        } catch (ReflectiveOperationException unused2) {
            for (Method method2 : cls.getDeclaredMethods()) {
                if (!AbstractC13042fc3.d(method2.getName(), str)) {
                    if (!AbstractC20153rZ6.S(method2.getName(), str + '-', false, 2, null)) {
                    }
                }
                method = method2;
                break;
            }
            return method;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final Object f(Class cls) {
        String name = cls.getName();
        switch (name.hashCode()) {
            case -1325958191:
                if (name.equals("double")) {
                    return Double.valueOf(0.0d);
                }
                return null;
            case 104431:
                if (name.equals("int")) {
                    return 0;
                }
                return null;
            case 3039496:
                if (name.equals("byte")) {
                    return (byte) 0;
                }
                return null;
            case 3052374:
                if (name.equals("char")) {
                    return (char) 0;
                }
                return null;
            case 3327612:
                if (name.equals("long")) {
                    return 0L;
                }
                return null;
            case 64711720:
                if (name.equals("boolean")) {
                    return Boolean.FALSE;
                }
                return null;
            case 97526364:
                if (name.equals("float")) {
                    return Float.valueOf(0.0f);
                }
                return null;
            case 109413500:
                if (name.equals("short")) {
                    return (short) 0;
                }
                return null;
            default:
                return null;
        }
    }

    private final Object h(Method method, Object obj, InterfaceC22053ub1 interfaceC22053ub1, Object... objArr) {
        Object objF;
        Class<?>[] parameterTypes = method.getParameterTypes();
        int i = -1;
        int length = parameterTypes.length - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                if (AbstractC13042fc3.d(parameterTypes[length], InterfaceC22053ub1.class)) {
                    i = length;
                    break;
                }
                if (i2 < 0) {
                    break;
                }
                length = i2;
            }
        }
        int i3 = i + 1;
        int iB = b(i, obj != null ? 1 : 0) + i3;
        int length2 = method.getParameterTypes().length;
        if ((length2 != iB ? c(i) : 0) + iB != length2) {
            throw new IllegalStateException("params don't add up to total params".toString());
        }
        Object[] objArr2 = new Object[length2];
        int i4 = 0;
        while (i4 < length2) {
            if (i4 >= 0 && i4 < i) {
                objF = (i4 < 0 || i4 > AbstractC10242bK.l0(objArr)) ? a.f(method.getParameterTypes()[i4]) : objArr[i4];
            } else if (i4 == i) {
                objF = interfaceC22053ub1;
            } else if (i3 <= i4 && i4 < iB) {
                objF = 0;
            } else {
                if (iB > i4 || i4 >= length2) {
                    throw new IllegalStateException("Unexpected index".toString());
                }
                objF = 2097151;
            }
            objArr2[i4] = objF;
            i4++;
        }
        return method.invoke(obj, Arrays.copyOf(objArr2, length2));
    }

    public final void g(String str, String str2, InterfaceC22053ub1 interfaceC22053ub1, Object... objArr) throws Exception {
        try {
            Class<?> cls = Class.forName(str);
            Method methodE = e(cls, str2, Arrays.copyOf(objArr, objArr.length));
            if (methodE != null) {
                methodE.setAccessible(true);
                if (Modifier.isStatic(methodE.getModifiers())) {
                    h(methodE, null, interfaceC22053ub1, Arrays.copyOf(objArr, objArr.length));
                    return;
                } else {
                    h(methodE, cls.getConstructor(null).newInstance(null), interfaceC22053ub1, Arrays.copyOf(objArr, objArr.length));
                    return;
                }
            }
            throw new NoSuchMethodException("Composable " + str + '.' + str2 + " not found");
        } catch (Exception e) {
            AbstractC7180Qp5.a.c(AbstractC7180Qp5.a, "Failed to invoke Composable Method '" + str + '.' + str2 + '\'', null, 2, null);
            throw e;
        }
    }
}
