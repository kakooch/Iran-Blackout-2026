package ir.nasim;

import android.gov.nist.core.Separators;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: ir.nasim.ru, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC20373ru {

    /* renamed from: ir.nasim.ru$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ Class e;
        final /* synthetic */ List f;
        final /* synthetic */ Map g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Class cls, List list, Map map) {
            super(1);
            this.e = cls;
            this.f = list;
            this.g = map;
        }

        public final boolean a(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            boolean zD;
            boolean z;
            InterfaceC11299cm3 interfaceC11299cm3A;
            Annotation annotation = (Annotation) (!(obj instanceof Annotation) ? null : obj);
            if (!AbstractC13042fc3.d((annotation == null || (interfaceC11299cm3A = AbstractC4762Gl3.a(annotation)) == null) ? null : AbstractC4762Gl3.b(interfaceC11299cm3A), this.e)) {
                return false;
            }
            List<Method> list = this.f;
            if ((list instanceof Collection) && list.isEmpty()) {
                z = true;
            } else {
                for (Method method : list) {
                    Object obj2 = this.g.get(method.getName());
                    Object objInvoke = method.invoke(obj, null);
                    if (obj2 instanceof boolean[]) {
                        boolean[] zArr = (boolean[]) obj2;
                        if (objInvoke == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.BooleanArray");
                        }
                        zD = Arrays.equals(zArr, (boolean[]) objInvoke);
                    } else if (obj2 instanceof char[]) {
                        char[] cArr = (char[]) obj2;
                        if (objInvoke == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.CharArray");
                        }
                        zD = Arrays.equals(cArr, (char[]) objInvoke);
                    } else if (obj2 instanceof byte[]) {
                        byte[] bArr = (byte[]) obj2;
                        if (objInvoke == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.ByteArray");
                        }
                        zD = Arrays.equals(bArr, (byte[]) objInvoke);
                    } else if (obj2 instanceof short[]) {
                        short[] sArr = (short[]) obj2;
                        if (objInvoke == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.ShortArray");
                        }
                        zD = Arrays.equals(sArr, (short[]) objInvoke);
                    } else if (obj2 instanceof int[]) {
                        int[] iArr = (int[]) obj2;
                        if (objInvoke == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.IntArray");
                        }
                        zD = Arrays.equals(iArr, (int[]) objInvoke);
                    } else if (obj2 instanceof float[]) {
                        float[] fArr = (float[]) obj2;
                        if (objInvoke == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.FloatArray");
                        }
                        zD = Arrays.equals(fArr, (float[]) objInvoke);
                    } else if (obj2 instanceof long[]) {
                        long[] jArr = (long[]) obj2;
                        if (objInvoke == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.LongArray");
                        }
                        zD = Arrays.equals(jArr, (long[]) objInvoke);
                    } else if (obj2 instanceof double[]) {
                        double[] dArr = (double[]) obj2;
                        if (objInvoke == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.DoubleArray");
                        }
                        zD = Arrays.equals(dArr, (double[]) objInvoke);
                    } else if (obj2 instanceof Object[]) {
                        Object[] objArr = (Object[]) obj2;
                        if (objInvoke == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<*>");
                        }
                        zD = Arrays.equals(objArr, (Object[]) objInvoke);
                    } else {
                        zD = AbstractC13042fc3.d(obj2, objInvoke);
                    }
                    if (!zD) {
                        z = false;
                        break;
                    }
                }
                z = true;
            }
            return z;
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return Boolean.valueOf(a(obj));
        }
    }

    /* renamed from: ir.nasim.ru$b */
    static final class b extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Map e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Map map) {
            super(0);
            this.e = map;
        }

        public final int a() {
            int iHashCode = 0;
            for (Map.Entry entry : this.e.entrySet()) {
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                iHashCode += (value instanceof boolean[] ? Arrays.hashCode((boolean[]) value) : value instanceof char[] ? Arrays.hashCode((char[]) value) : value instanceof byte[] ? Arrays.hashCode((byte[]) value) : value instanceof short[] ? Arrays.hashCode((short[]) value) : value instanceof int[] ? Arrays.hashCode((int[]) value) : value instanceof float[] ? Arrays.hashCode((float[]) value) : value instanceof long[] ? Arrays.hashCode((long[]) value) : value instanceof double[] ? Arrays.hashCode((double[]) value) : value instanceof Object[] ? Arrays.hashCode((Object[]) value) : value.hashCode()) ^ (str.hashCode() * 127);
            }
            return iHashCode;
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            return Integer.valueOf(a());
        }
    }

    /* renamed from: ir.nasim.ru$c */
    static final class c implements InvocationHandler {
        final /* synthetic */ Class a;
        final /* synthetic */ InterfaceC9173Yu3 b;
        final /* synthetic */ InterfaceC5239Im3 c;
        final /* synthetic */ InterfaceC9173Yu3 d;
        final /* synthetic */ InterfaceC5239Im3 e;
        final /* synthetic */ a f;
        final /* synthetic */ Map g;

        c(Class cls, InterfaceC9173Yu3 interfaceC9173Yu3, InterfaceC5239Im3 interfaceC5239Im3, InterfaceC9173Yu3 interfaceC9173Yu32, InterfaceC5239Im3 interfaceC5239Im32, a aVar, Map map) {
            this.a = cls;
            this.b = interfaceC9173Yu3;
            this.c = interfaceC5239Im3;
            this.d = interfaceC9173Yu32;
            this.e = interfaceC5239Im32;
            this.f = aVar;
            this.g = map;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] objArr) {
            AbstractC13042fc3.h(method, "method");
            String name = method.getName();
            if (name != null) {
                int iHashCode = name.hashCode();
                if (iHashCode != -1776922004) {
                    if (iHashCode != 147696667) {
                        if (iHashCode == 1444986633 && name.equals("annotationType")) {
                            return this.a;
                        }
                    } else if (name.equals("hashCode")) {
                        return this.d.getValue();
                    }
                } else if (name.equals("toString")) {
                    return this.b.getValue();
                }
            }
            if (AbstractC13042fc3.d(name, "equals") && objArr != null && objArr.length == 1) {
                return Boolean.valueOf(this.f.a(AbstractC10242bK.N0(objArr)));
            }
            if (this.g.containsKey(name)) {
                return this.g.get(name);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Method is not supported: ");
            sb.append(method);
            sb.append(" (args: ");
            if (objArr == null) {
                objArr = new Object[0];
            }
            sb.append(AbstractC10242bK.f1(objArr));
            sb.append(')');
            throw new C25175zr3(sb.toString());
        }
    }

    /* renamed from: ir.nasim.ru$d */
    static final class d extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Class e;
        final /* synthetic */ Map f;

        /* renamed from: ir.nasim.ru$d$a */
        static final class a extends AbstractC8614Ws3 implements UA2 {
            public static final a e = new a();

            a() {
                super(1);
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final CharSequence invoke(Map.Entry entry) {
                AbstractC13042fc3.i(entry, "entry");
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                return str + '=' + (value instanceof boolean[] ? Arrays.toString((boolean[]) value) : value instanceof char[] ? Arrays.toString((char[]) value) : value instanceof byte[] ? Arrays.toString((byte[]) value) : value instanceof short[] ? Arrays.toString((short[]) value) : value instanceof int[] ? Arrays.toString((int[]) value) : value instanceof float[] ? Arrays.toString((float[]) value) : value instanceof long[] ? Arrays.toString((long[]) value) : value instanceof double[] ? Arrays.toString((double[]) value) : value instanceof Object[] ? Arrays.toString((Object[]) value) : value.toString());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Class cls, Map map) {
            super(0);
            this.e = cls;
            this.f = map;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() throws IOException {
            StringBuilder sb = new StringBuilder();
            sb.append('@');
            sb.append(this.e.getCanonicalName());
            AbstractC15401jX0.x0(this.f.entrySet(), sb, (124 & 2) != 0 ? ", " : ", ", (124 & 4) != 0 ? "" : Separators.LPAREN, (124 & 8) == 0 ? Separators.RPAREN : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : a.e);
            String string = sb.toString();
            AbstractC13042fc3.h(string, "StringBuilder().apply(builderAction).toString()");
            return string;
        }
    }

    public static final Object c(Class cls, Map map, List list) throws IllegalArgumentException {
        AbstractC13042fc3.i(cls, "annotationClass");
        AbstractC13042fc3.i(map, "values");
        AbstractC13042fc3.i(list, "methods");
        a aVar = new a(cls, list, map);
        InterfaceC9173Yu3 interfaceC9173Yu3A = AbstractC13269fw3.a(new b(map));
        Object objNewProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new c(cls, AbstractC13269fw3.a(new d(cls, map)), null, interfaceC9173Yu3A, null, aVar, map));
        if (objNewProxyInstance != null) {
            return objNewProxyInstance;
        }
        throw new NullPointerException("null cannot be cast to non-null type T");
    }

    public static /* synthetic */ Object d(Class cls, Map map, List list, int i, Object obj) {
        if ((i & 4) != 0) {
            Set setKeySet = map.keySet();
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(setKeySet, 10));
            Iterator it = setKeySet.iterator();
            while (it.hasNext()) {
                arrayList.add(cls.getDeclaredMethod((String) it.next(), null));
            }
            list = arrayList;
        }
        return c(cls, map, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void e(int i, String str, Class cls) {
        String strN;
        InterfaceC11299cm3 interfaceC11299cm3B = AbstractC13042fc3.d(cls, Class.class) ? AbstractC10882cM5.b(InterfaceC11299cm3.class) : (cls.isArray() && AbstractC13042fc3.d(cls.getComponentType(), Class.class)) ? AbstractC10882cM5.b(InterfaceC11299cm3[].class) : AbstractC4762Gl3.e(cls);
        if (AbstractC13042fc3.d(interfaceC11299cm3B.n(), AbstractC10882cM5.b(Object[].class).n())) {
            StringBuilder sb = new StringBuilder();
            sb.append(interfaceC11299cm3B.n());
            sb.append('<');
            Class<?> componentType = AbstractC4762Gl3.b(interfaceC11299cm3B).getComponentType();
            AbstractC13042fc3.h(componentType, "kotlinClass.java.componentType");
            sb.append(AbstractC4762Gl3.e(componentType).n());
            sb.append('>');
            strN = sb.toString();
        } else {
            strN = interfaceC11299cm3B.n();
        }
        throw new IllegalArgumentException("Argument #" + i + ' ' + str + " is not of the required type " + strN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object f(Object obj, Class cls) {
        if (obj instanceof Class) {
            return null;
        }
        if (obj instanceof InterfaceC11299cm3) {
            obj = AbstractC4762Gl3.b((InterfaceC11299cm3) obj);
        } else if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr instanceof Class[]) {
                return null;
            }
            if (!(objArr instanceof InterfaceC11299cm3[])) {
                obj = objArr;
            } else {
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.reflect.KClass<*>>");
                }
                InterfaceC11299cm3[] interfaceC11299cm3Arr = (InterfaceC11299cm3[]) obj;
                ArrayList arrayList = new ArrayList(interfaceC11299cm3Arr.length);
                for (InterfaceC11299cm3 interfaceC11299cm3 : interfaceC11299cm3Arr) {
                    arrayList.add(AbstractC4762Gl3.b(interfaceC11299cm3));
                }
                obj = arrayList.toArray(new Class[0]);
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            }
        }
        if (cls.isInstance(obj)) {
            return obj;
        }
        return null;
    }
}
