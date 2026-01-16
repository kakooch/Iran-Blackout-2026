package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.AbstractC10266bM5;
import ir.nasim.InterfaceC15194jA0;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import org.xbill.DNS.WKSRecord;

/* renamed from: ir.nasim.km3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC16142km3 implements InterfaceC17738nU0 {
    public static final a c = new a(null);
    private static final Class a = ED1.class;
    private static final C20644sM5 b = new C20644sM5("<v#(\\d+)>");

    /* renamed from: ir.nasim.km3$a */
    public static final class a {
        private a() {
        }

        public final C20644sM5 a() {
            return AbstractC16142km3.b;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.km3$b */
    public abstract class b {
        static final /* synthetic */ InterfaceC5239Im3[] c = {AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(b.class), "moduleData", "getModuleData()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;"))};
        private final AbstractC10266bM5.a a = AbstractC10266bM5.c(new a());

        /* renamed from: ir.nasim.km3$b$a */
        static final class a extends AbstractC8614Ws3 implements SA2 {
            a() {
                super(0);
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final C23560x76 invoke() {
                return AbstractC7098Qg4.a(AbstractC16142km3.this.e());
            }
        }

        public b() {
        }

        public final C23560x76 a() {
            return (C23560x76) this.a.b(this, c[0]);
        }
    }

    /* renamed from: ir.nasim.km3$c */
    protected enum c {
        DECLARED,
        INHERITED;

        public final boolean a(InterfaceC15194jA0 interfaceC15194jA0) {
            AbstractC13042fc3.i(interfaceC15194jA0, "member");
            InterfaceC15194jA0.a aVarF = interfaceC15194jA0.f();
            AbstractC13042fc3.h(aVarF, "member.kind");
            return aVarF.a() == (this == DECLARED);
        }
    }

    /* renamed from: ir.nasim.km3$d */
    static final class d extends AbstractC8614Ws3 implements UA2 {
        public static final d e = new d();

        d() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(AB2 ab2) {
            AbstractC13042fc3.i(ab2, "descriptor");
            return FI1.j.r(ab2) + " | " + A76.b.g(ab2).a();
        }
    }

    /* renamed from: ir.nasim.km3$e */
    static final class e extends AbstractC8614Ws3 implements UA2 {
        public static final e e = new e();

        e() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(InterfaceC20989sw5 interfaceC20989sw5) {
            AbstractC13042fc3.i(interfaceC20989sw5, "descriptor");
            return FI1.j.r(interfaceC20989sw5) + " | " + A76.b.f(interfaceC20989sw5).a();
        }
    }

    /* renamed from: ir.nasim.km3$f */
    static final class f implements Comparator {
        public static final f a = new f();

        f() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final int compare(RI1 ri1, RI1 ri12) {
            Integer numD = QI1.d(ri1, ri12);
            if (numD != null) {
                return numD.intValue();
            }
            return 0;
        }
    }

    /* renamed from: ir.nasim.km3$g */
    public static final class g extends C7428Rr1 {
        g(AbstractC16142km3 abstractC16142km3) {
            super(abstractC16142km3);
        }

        @Override // ir.nasim.AbstractC15795kB1, ir.nasim.InterfaceC15204jB1
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public AbstractC10536bm3 k(InterfaceC21426te1 interfaceC21426te1, C19938rB7 c19938rB7) {
            AbstractC13042fc3.i(interfaceC21426te1, "descriptor");
            AbstractC13042fc3.i(c19938rB7, "data");
            throw new IllegalStateException("No constructors should appear here: " + interfaceC21426te1);
        }
    }

    private final List B(String str) {
        int iK0;
        ArrayList arrayList = new ArrayList();
        int i = 1;
        while (str.charAt(i) != ')') {
            int i2 = i;
            while (str.charAt(i2) == '[') {
                i2++;
            }
            char cCharAt = str.charAt(i2);
            if (AbstractC20762sZ6.W("VZCBSIFJD", cCharAt, false, 2, null)) {
                iK0 = i2 + 1;
            } else {
                if (cCharAt != 'L') {
                    throw new C25175zr3("Unknown type prefix in the method signature: " + str);
                }
                iK0 = AbstractC20762sZ6.k0(str, ';', i, false, 4, null) + 1;
            }
            arrayList.add(E(str, i, iK0));
            i = iK0;
        }
        return arrayList;
    }

    private final Class C(String str) {
        return E(str, AbstractC20762sZ6.k0(str, ')', 0, false, 6, null) + 1, str.length());
    }

    private final Method D(Class cls, String str, Class[] clsArr, Class cls2, boolean z) throws NoSuchMethodException, SecurityException {
        Method methodD;
        if (z) {
            clsArr[0] = cls;
        }
        Method methodG = G(cls, str, clsArr, cls2);
        if (methodG != null) {
            return methodG;
        }
        Class superclass = cls.getSuperclass();
        if (superclass != null && (methodD = D(superclass, str, clsArr, cls2, z)) != null) {
            return methodD;
        }
        for (Class<?> cls3 : cls.getInterfaces()) {
            AbstractC13042fc3.h(cls3, "superInterface");
            Method methodD2 = D(cls3, str, clsArr, cls2, z);
            if (methodD2 != null) {
                return methodD2;
            }
            if (z) {
                Class clsA = EL5.a(AbstractC21912uL5.g(cls3), cls3.getName() + "$DefaultImpls");
                if (clsA != null) {
                    clsArr[0] = cls3;
                    Method methodG2 = G(clsA, str, clsArr, cls2);
                    if (methodG2 != null) {
                        return methodG2;
                    }
                } else {
                    continue;
                }
            }
        }
        return null;
    }

    private final Class E(String str, int i, int i2) throws ClassNotFoundException {
        char cCharAt = str.charAt(i);
        if (cCharAt == 'F') {
            return Float.TYPE;
        }
        if (cCharAt == 'L') {
            ClassLoader classLoaderG = AbstractC21912uL5.g(e());
            String strSubstring = str.substring(i + 1, i2 - 1);
            AbstractC13042fc3.h(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            Class<?> clsLoadClass = classLoaderG.loadClass(AbstractC20153rZ6.L(strSubstring, '/', '.', false, 4, null));
            AbstractC13042fc3.h(clsLoadClass, "jClass.safeClassLoader.l…d - 1).replace('/', '.'))");
            return clsLoadClass;
        }
        if (cCharAt == 'S') {
            return Short.TYPE;
        }
        if (cCharAt == 'V') {
            Class cls = Void.TYPE;
            AbstractC13042fc3.h(cls, "Void.TYPE");
            return cls;
        }
        if (cCharAt == 'I') {
            return Integer.TYPE;
        }
        if (cCharAt == 'J') {
            return Long.TYPE;
        }
        if (cCharAt == 'Z') {
            return Boolean.TYPE;
        }
        if (cCharAt == '[') {
            return AbstractC21912uL5.a(E(str, i + 1, i2));
        }
        switch (cCharAt) {
            case WKSRecord.Protocol.RVD /* 66 */:
                return Byte.TYPE;
            case 'C':
                return Character.TYPE;
            case WKSRecord.Service.BOOTPC /* 68 */:
                return Double.TYPE;
            default:
                throw new C25175zr3("Unknown type prefix in the method signature: " + str);
        }
    }

    private final Constructor F(Class cls, List list) {
        try {
            Object[] array = list.toArray(new Class[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            Class[] clsArr = (Class[]) array;
            return cls.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private final Method G(Class cls, String str, Class[] clsArr, Class cls2) throws NoSuchMethodException, SecurityException {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
            AbstractC13042fc3.h(declaredMethod, "result");
            if (AbstractC13042fc3.d(declaredMethod.getReturnType(), cls2)) {
                return declaredMethod;
            }
            Method[] declaredMethods = cls.getDeclaredMethods();
            AbstractC13042fc3.h(declaredMethods, "declaredMethods");
            for (Method method : declaredMethods) {
                AbstractC13042fc3.h(method, "method");
                if (AbstractC13042fc3.d(method.getName(), str) && AbstractC13042fc3.d(method.getReturnType(), cls2)) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    AbstractC13042fc3.f(parameterTypes);
                    if (Arrays.equals(parameterTypes, clsArr)) {
                        return method;
                    }
                }
            }
            return null;
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private final void i(List list, String str, boolean z) {
        List listB = B(str);
        list.addAll(listB);
        int size = (listB.size() + 31) / 32;
        for (int i = 0; i < size; i++) {
            Class cls = Integer.TYPE;
            AbstractC13042fc3.h(cls, "Integer.TYPE");
            list.add(cls);
        }
        Class cls2 = z ? a : Object.class;
        AbstractC13042fc3.h(cls2, "if (isConstructor) DEFAU…RKER else Any::class.java");
        list.add(cls2);
    }

    public abstract Collection A(C6432No4 c6432No4);

    public final Constructor j(String str) {
        AbstractC13042fc3.i(str, "desc");
        return F(e(), B(str));
    }

    public final Constructor l(String str) {
        AbstractC13042fc3.i(str, "desc");
        Class clsE = e();
        ArrayList arrayList = new ArrayList();
        i(arrayList, str, true);
        C19938rB7 c19938rB7 = C19938rB7.a;
        return F(clsE, arrayList);
    }

    public final Method o(String str, String str2, boolean z) {
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(str2, "desc");
        if (AbstractC13042fc3.d(str, "<init>")) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (z) {
            arrayList.add(e());
        }
        i(arrayList, str2, false);
        Class clsZ = z();
        String str3 = str + "$default";
        Object[] array = arrayList.toArray(new Class[0]);
        if (array != null) {
            return D(clsZ, str3, (Class[]) array, C(str2), z);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public final AB2 q(String str, String str2) {
        List listV;
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(str2, "signature");
        if (AbstractC13042fc3.d(str, "<init>")) {
            listV = AbstractC15401jX0.m1(t());
        } else {
            C6432No4 c6432No4P = C6432No4.p(str);
            AbstractC13042fc3.h(c6432No4P, "Name.identifier(name)");
            listV = v(c6432No4P);
        }
        Collection collection = listV;
        ArrayList arrayList = new ArrayList();
        for (Object obj : collection) {
            if (AbstractC13042fc3.d(A76.b.g((AB2) obj).a(), str2)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.size() == 1) {
            return (AB2) AbstractC15401jX0.V0(arrayList);
        }
        String strA0 = AbstractC15401jX0.A0(collection, Separators.RETURN, null, null, 0, null, d.e, 30, null);
        StringBuilder sb = new StringBuilder();
        sb.append("Function '");
        sb.append(str);
        sb.append("' (JVM signature: ");
        sb.append(str2);
        sb.append(") not resolved in ");
        sb.append(this);
        sb.append(':');
        sb.append(strA0.length() == 0 ? " no members found" : '\n' + strA0);
        throw new C25175zr3(sb.toString());
    }

    public final Method r(String str, String str2) throws NoSuchMethodException, SecurityException {
        Method methodD;
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(str2, "desc");
        if (AbstractC13042fc3.d(str, "<init>")) {
            return null;
        }
        Object[] array = B(str2).toArray(new Class[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        Class[] clsArr = (Class[]) array;
        Class clsC = C(str2);
        Method methodD2 = D(z(), str, clsArr, clsC, false);
        if (methodD2 != null) {
            return methodD2;
        }
        if (!z().isInterface() || (methodD = D(Object.class, str, clsArr, clsC, false)) == null) {
            return null;
        }
        return methodD;
    }

    public final InterfaceC20989sw5 s(String str, String str2) {
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(str2, "signature");
        OU3 ou3F = b.f(str2);
        if (ou3F != null) {
            String str3 = (String) ou3F.a().a().b().get(1);
            InterfaceC20989sw5 interfaceC20989sw5X = x(Integer.parseInt(str3));
            if (interfaceC20989sw5X != null) {
                return interfaceC20989sw5X;
            }
            throw new C25175zr3("Local property #" + str3 + " not found in " + e());
        }
        C6432No4 c6432No4P = C6432No4.p(str);
        AbstractC13042fc3.h(c6432No4P, "Name.identifier(name)");
        Collection collectionA = A(c6432No4P);
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionA) {
            if (AbstractC13042fc3.d(A76.b.f((InterfaceC20989sw5) obj).a(), str2)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            throw new C25175zr3("Property '" + str + "' (JVM signature: " + str2 + ") not resolved in " + this);
        }
        if (arrayList.size() == 1) {
            return (InterfaceC20989sw5) AbstractC15401jX0.V0(arrayList);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj2 : arrayList) {
            RI1 visibility = ((InterfaceC20989sw5) obj2).getVisibility();
            Object arrayList2 = linkedHashMap.get(visibility);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                linkedHashMap.put(visibility, arrayList2);
            }
            ((List) arrayList2).add(obj2);
        }
        Collection collectionValues = AbstractC19460qO3.j(linkedHashMap, f.a).values();
        AbstractC13042fc3.h(collectionValues, "properties\n             …                }).values");
        List list = (List) AbstractC15401jX0.B0(collectionValues);
        if (list.size() == 1) {
            AbstractC13042fc3.h(list, "mostVisibleProperties");
            return (InterfaceC20989sw5) AbstractC15401jX0.q0(list);
        }
        C6432No4 c6432No4P2 = C6432No4.p(str);
        AbstractC13042fc3.h(c6432No4P2, "Name.identifier(name)");
        String strA0 = AbstractC15401jX0.A0(A(c6432No4P2), Separators.RETURN, null, null, 0, null, e.e, 30, null);
        StringBuilder sb = new StringBuilder();
        sb.append("Property '");
        sb.append(str);
        sb.append("' (JVM signature: ");
        sb.append(str2);
        sb.append(") not resolved in ");
        sb.append(this);
        sb.append(':');
        sb.append(strA0.length() == 0 ? " no members found" : '\n' + strA0);
        throw new C25175zr3(sb.toString());
    }

    public abstract Collection t();

    public abstract Collection v(C6432No4 c6432No4);

    public abstract InterfaceC20989sw5 x(int i);

    /* JADX WARN: Removed duplicated region for block: B:12:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final java.util.Collection y(ir.nasim.W24 r8, ir.nasim.AbstractC16142km3.c r9) {
        /*
            r7 = this;
            java.lang.String r0 = "scope"
            ir.nasim.AbstractC13042fc3.i(r8, r0)
            java.lang.String r0 = "belonginess"
            ir.nasim.AbstractC13042fc3.i(r9, r0)
            ir.nasim.km3$g r0 = new ir.nasim.km3$g
            r0.<init>(r7)
            r1 = 3
            r2 = 0
            java.util.Collection r8 = ir.nasim.InterfaceC22011uW5.a.a(r8, r2, r2, r1, r2)
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r8 = r8.iterator()
        L20:
            boolean r3 = r8.hasNext()
            if (r3 == 0) goto L57
            java.lang.Object r3 = r8.next()
            ir.nasim.fB1 r3 = (ir.nasim.InterfaceC12795fB1) r3
            boolean r4 = r3 instanceof ir.nasim.InterfaceC15194jA0
            if (r4 == 0) goto L50
            r4 = r3
            ir.nasim.jA0 r4 = (ir.nasim.InterfaceC15194jA0) r4
            ir.nasim.RI1 r5 = r4.getVisibility()
            ir.nasim.RI1 r6 = ir.nasim.QI1.h
            boolean r5 = ir.nasim.AbstractC13042fc3.d(r5, r6)
            r5 = r5 ^ 1
            if (r5 == 0) goto L50
            boolean r4 = r9.a(r4)
            if (r4 == 0) goto L50
            ir.nasim.rB7 r4 = ir.nasim.C19938rB7.a
            java.lang.Object r3 = r3.q0(r0, r4)
            ir.nasim.bm3 r3 = (ir.nasim.AbstractC10536bm3) r3
            goto L51
        L50:
            r3 = r2
        L51:
            if (r3 == 0) goto L20
            r1.add(r3)
            goto L20
        L57:
            java.util.List r8 = ir.nasim.ZW0.m1(r1)
            java.util.Collection r8 = (java.util.Collection) r8
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC16142km3.y(ir.nasim.W24, ir.nasim.km3$c):java.util.Collection");
    }

    protected Class z() {
        Class clsH = AbstractC21912uL5.h(e());
        return clsH != null ? clsH : e();
    }
}
