package ir.nasim;

import android.gov.nist.javax.sip.parser.TokenNames;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.uL5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC21912uL5 {
    private static final List a;
    private static final Map b;
    private static final Map c;
    private static final Map d;

    /* renamed from: ir.nasim.uL5$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ParameterizedType invoke(ParameterizedType parameterizedType) {
            AbstractC13042fc3.i(parameterizedType, "it");
            Type ownerType = parameterizedType.getOwnerType();
            if (ownerType instanceof ParameterizedType) {
                return (ParameterizedType) ownerType;
            }
            return null;
        }
    }

    /* renamed from: ir.nasim.uL5$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        public static final b e = new b();

        b() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC23384wp6 invoke(ParameterizedType parameterizedType) {
            AbstractC13042fc3.i(parameterizedType, "it");
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            AbstractC13042fc3.h(actualTypeArguments, "it.actualTypeArguments");
            return AbstractC10242bK.P(actualTypeArguments);
        }
    }

    static {
        int i = 0;
        List listP = AbstractC10360bX0.p(AbstractC10882cM5.b(Boolean.TYPE), AbstractC10882cM5.b(Byte.TYPE), AbstractC10882cM5.b(Character.TYPE), AbstractC10882cM5.b(Double.TYPE), AbstractC10882cM5.b(Float.TYPE), AbstractC10882cM5.b(Integer.TYPE), AbstractC10882cM5.b(Long.TYPE), AbstractC10882cM5.b(Short.TYPE));
        a = listP;
        List<InterfaceC11299cm3> list = listP;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        for (InterfaceC11299cm3 interfaceC11299cm3 : list) {
            arrayList.add(AbstractC4616Fw7.a(AbstractC4762Gl3.c(interfaceC11299cm3), AbstractC4762Gl3.d(interfaceC11299cm3)));
        }
        b = AbstractC20051rO3.w(arrayList);
        List<InterfaceC11299cm3> list2 = a;
        ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(list2, 10));
        for (InterfaceC11299cm3 interfaceC11299cm32 : list2) {
            arrayList2.add(AbstractC4616Fw7.a(AbstractC4762Gl3.d(interfaceC11299cm32), AbstractC4762Gl3.c(interfaceC11299cm32)));
        }
        c = AbstractC20051rO3.w(arrayList2);
        List listP2 = AbstractC10360bX0.p(SA2.class, UA2.class, InterfaceC14603iB2.class, InterfaceC15796kB2.class, InterfaceC16978mB2.class, InterfaceC18160oB2.class, InterfaceC19342qB2.class, InterfaceC19933rB2.class, InterfaceC20542sB2.class, InterfaceC21145tB2.class, TA2.class, VA2.class, WA2.class, XA2.class, YA2.class, ZA2.class, InterfaceC9570aB2.class, InterfaceC10164bB2.class, InterfaceC10780cB2.class, InterfaceC11544dB2.class, InterfaceC12796fB2.class, InterfaceC13414gB2.class, InterfaceC14005hB2.class);
        ArrayList arrayList3 = new ArrayList(AbstractC10976cX0.x(listP2, 10));
        for (Object obj : listP2) {
            int i2 = i + 1;
            if (i < 0) {
                AbstractC10360bX0.w();
            }
            arrayList3.add(AbstractC4616Fw7.a((Class) obj, Integer.valueOf(i)));
            i = i2;
        }
        d = AbstractC20051rO3.w(arrayList3);
    }

    public static final Class a(Class cls) {
        AbstractC13042fc3.i(cls, "<this>");
        return Array.newInstance((Class<?>) cls, 0).getClass();
    }

    public static final C24948zU0 b(Class cls) {
        AbstractC13042fc3.i(cls, "<this>");
        if (cls.isPrimitive()) {
            throw new IllegalArgumentException(AbstractC13042fc3.q("Can't compute ClassId for primitive type: ", cls));
        }
        if (cls.isArray()) {
            throw new IllegalArgumentException(AbstractC13042fc3.q("Can't compute ClassId for array type: ", cls));
        }
        if (cls.getEnclosingMethod() == null && cls.getEnclosingConstructor() == null) {
            String simpleName = cls.getSimpleName();
            AbstractC13042fc3.h(simpleName, "simpleName");
            if (simpleName.length() != 0) {
                Class<?> declaringClass = cls.getDeclaringClass();
                C24948zU0 c24948zU0D = declaringClass == null ? null : b(declaringClass).d(C6432No4.p(cls.getSimpleName()));
                if (c24948zU0D == null) {
                    c24948zU0D = C24948zU0.m(new C9424Zw2(cls.getName()));
                }
                AbstractC13042fc3.h(c24948zU0D, "declaringClass?.classId?.createNestedClassId(Name.identifier(simpleName)) ?: ClassId.topLevel(FqName(name))");
                return c24948zU0D;
            }
        }
        C9424Zw2 c9424Zw2 = new C9424Zw2(cls.getName());
        return new C24948zU0(c9424Zw2.e(), C9424Zw2.k(c9424Zw2.g()), true);
    }

    public static final String c(Class cls) {
        AbstractC13042fc3.i(cls, "<this>");
        if (AbstractC13042fc3.d(cls, Void.TYPE)) {
            return TokenNames.V;
        }
        String name = a(cls).getName();
        AbstractC13042fc3.h(name, "createArrayType().name");
        String strSubstring = name.substring(1);
        AbstractC13042fc3.h(strSubstring, "(this as java.lang.String).substring(startIndex)");
        return AbstractC20153rZ6.L(strSubstring, '.', '/', false, 4, null);
    }

    public static final Integer d(Class cls) {
        AbstractC13042fc3.i(cls, "<this>");
        return (Integer) d.get(cls);
    }

    public static final List e(Type type) {
        AbstractC13042fc3.i(type, "<this>");
        if (!(type instanceof ParameterizedType)) {
            return AbstractC10360bX0.m();
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        if (parameterizedType.getOwnerType() != null) {
            return AbstractC11342cq6.K(AbstractC11342cq6.w(AbstractC9962aq6.j(type, a.e), b.e));
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        AbstractC13042fc3.h(actualTypeArguments, "actualTypeArguments");
        return AbstractC10242bK.f1(actualTypeArguments);
    }

    public static final Class f(Class cls) {
        AbstractC13042fc3.i(cls, "<this>");
        return (Class) b.get(cls);
    }

    public static final ClassLoader g(Class cls) {
        AbstractC13042fc3.i(cls, "<this>");
        ClassLoader classLoader = cls.getClassLoader();
        if (classLoader != null) {
            return classLoader;
        }
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        AbstractC13042fc3.h(systemClassLoader, "getSystemClassLoader()");
        return systemClassLoader;
    }

    public static final Class h(Class cls) {
        AbstractC13042fc3.i(cls, "<this>");
        return (Class) c.get(cls);
    }

    public static final boolean i(Class cls) {
        AbstractC13042fc3.i(cls, "<this>");
        return Enum.class.isAssignableFrom(cls);
    }
}
