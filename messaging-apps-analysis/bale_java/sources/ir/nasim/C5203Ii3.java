package ir.nasim;

import ir.nasim.PJ6;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

/* renamed from: ir.nasim.Ii3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C5203Ii3 {
    public static final C5203Ii3 a;
    private static final String b;
    private static final String c;
    private static final String d;
    private static final String e;
    private static final C24948zU0 f;
    private static final C9424Zw2 g;
    private static final C24948zU0 h;
    private static final C24948zU0 i;
    private static final C24948zU0 j;
    private static final HashMap k;
    private static final HashMap l;
    private static final HashMap m;
    private static final HashMap n;
    private static final List o;

    /* renamed from: ir.nasim.Ii3$a */
    public static final class a {
        private final C24948zU0 a;
        private final C24948zU0 b;
        private final C24948zU0 c;

        public a(C24948zU0 c24948zU0, C24948zU0 c24948zU02, C24948zU0 c24948zU03) {
            AbstractC13042fc3.i(c24948zU0, "javaClass");
            AbstractC13042fc3.i(c24948zU02, "kotlinReadOnly");
            AbstractC13042fc3.i(c24948zU03, "kotlinMutable");
            this.a = c24948zU0;
            this.b = c24948zU02;
            this.c = c24948zU03;
        }

        public final C24948zU0 a() {
            return this.a;
        }

        public final C24948zU0 b() {
            return this.b;
        }

        public final C24948zU0 c() {
            return this.c;
        }

        public final C24948zU0 d() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return AbstractC13042fc3.d(this.a, aVar.a) && AbstractC13042fc3.d(this.b, aVar.b) && AbstractC13042fc3.d(this.c, aVar.c);
        }

        public int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "PlatformMutabilityMapping(javaClass=" + this.a + ", kotlinReadOnly=" + this.b + ", kotlinMutable=" + this.c + ')';
        }
    }

    static {
        C5203Ii3 c5203Ii3 = new C5203Ii3();
        a = c5203Ii3;
        StringBuilder sb = new StringBuilder();
        EnumC24185yB2 enumC24185yB2 = EnumC24185yB2.d;
        sb.append(enumC24185yB2.j().toString());
        sb.append('.');
        sb.append(enumC24185yB2.a());
        b = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        EnumC24185yB2 enumC24185yB22 = EnumC24185yB2.f;
        sb2.append(enumC24185yB22.j().toString());
        sb2.append('.');
        sb2.append(enumC24185yB22.a());
        c = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        EnumC24185yB2 enumC24185yB23 = EnumC24185yB2.e;
        sb3.append(enumC24185yB23.j().toString());
        sb3.append('.');
        sb3.append(enumC24185yB23.a());
        d = sb3.toString();
        StringBuilder sb4 = new StringBuilder();
        EnumC24185yB2 enumC24185yB24 = EnumC24185yB2.g;
        sb4.append(enumC24185yB24.j().toString());
        sb4.append('.');
        sb4.append(enumC24185yB24.a());
        e = sb4.toString();
        C24948zU0 c24948zU0M = C24948zU0.m(new C9424Zw2("kotlin.jvm.functions.FunctionN"));
        AbstractC13042fc3.h(c24948zU0M, "topLevel(FqName(\"kotlin.jvm.functions.FunctionN\"))");
        f = c24948zU0M;
        C9424Zw2 c9424Zw2B = c24948zU0M.b();
        AbstractC13042fc3.h(c9424Zw2B, "FUNCTION_N_CLASS_ID.asSingleFqName()");
        g = c9424Zw2B;
        C24948zU0 c24948zU0M2 = C24948zU0.m(new C9424Zw2("kotlin.reflect.KFunction"));
        AbstractC13042fc3.h(c24948zU0M2, "topLevel(FqName(\"kotlin.reflect.KFunction\"))");
        h = c24948zU0M2;
        C24948zU0 c24948zU0M3 = C24948zU0.m(new C9424Zw2("kotlin.reflect.KClass"));
        AbstractC13042fc3.h(c24948zU0M3, "topLevel(FqName(\"kotlin.reflect.KClass\"))");
        i = c24948zU0M3;
        j = c5203Ii3.h(Class.class);
        k = new HashMap();
        l = new HashMap();
        m = new HashMap();
        n = new HashMap();
        C24948zU0 c24948zU0M4 = C24948zU0.m(PJ6.a.O);
        AbstractC13042fc3.h(c24948zU0M4, "topLevel(FqNames.iterable)");
        C9424Zw2 c9424Zw2 = PJ6.a.W;
        C9424Zw2 c9424Zw2H = c24948zU0M4.h();
        C9424Zw2 c9424Zw2H2 = c24948zU0M4.h();
        AbstractC13042fc3.h(c9424Zw2H2, "kotlinReadOnly.packageFqName");
        C9424Zw2 c9424Zw2D = AbstractC10644bx2.d(c9424Zw2, c9424Zw2H2);
        int i2 = 0;
        a aVar = new a(c5203Ii3.h(Iterable.class), c24948zU0M4, new C24948zU0(c9424Zw2H, c9424Zw2D, false));
        C24948zU0 c24948zU0M5 = C24948zU0.m(PJ6.a.N);
        AbstractC13042fc3.h(c24948zU0M5, "topLevel(FqNames.iterator)");
        C9424Zw2 c9424Zw22 = PJ6.a.V;
        C9424Zw2 c9424Zw2H3 = c24948zU0M5.h();
        C9424Zw2 c9424Zw2H4 = c24948zU0M5.h();
        AbstractC13042fc3.h(c9424Zw2H4, "kotlinReadOnly.packageFqName");
        a aVar2 = new a(c5203Ii3.h(Iterator.class), c24948zU0M5, new C24948zU0(c9424Zw2H3, AbstractC10644bx2.d(c9424Zw22, c9424Zw2H4), false));
        C24948zU0 c24948zU0M6 = C24948zU0.m(PJ6.a.P);
        AbstractC13042fc3.h(c24948zU0M6, "topLevel(FqNames.collection)");
        C9424Zw2 c9424Zw23 = PJ6.a.X;
        C9424Zw2 c9424Zw2H5 = c24948zU0M6.h();
        C9424Zw2 c9424Zw2H6 = c24948zU0M6.h();
        AbstractC13042fc3.h(c9424Zw2H6, "kotlinReadOnly.packageFqName");
        a aVar3 = new a(c5203Ii3.h(Collection.class), c24948zU0M6, new C24948zU0(c9424Zw2H5, AbstractC10644bx2.d(c9424Zw23, c9424Zw2H6), false));
        C24948zU0 c24948zU0M7 = C24948zU0.m(PJ6.a.Q);
        AbstractC13042fc3.h(c24948zU0M7, "topLevel(FqNames.list)");
        C9424Zw2 c9424Zw24 = PJ6.a.Y;
        C9424Zw2 c9424Zw2H7 = c24948zU0M7.h();
        C9424Zw2 c9424Zw2H8 = c24948zU0M7.h();
        AbstractC13042fc3.h(c9424Zw2H8, "kotlinReadOnly.packageFqName");
        a aVar4 = new a(c5203Ii3.h(List.class), c24948zU0M7, new C24948zU0(c9424Zw2H7, AbstractC10644bx2.d(c9424Zw24, c9424Zw2H8), false));
        C24948zU0 c24948zU0M8 = C24948zU0.m(PJ6.a.S);
        AbstractC13042fc3.h(c24948zU0M8, "topLevel(FqNames.set)");
        C9424Zw2 c9424Zw25 = PJ6.a.a0;
        C9424Zw2 c9424Zw2H9 = c24948zU0M8.h();
        C9424Zw2 c9424Zw2H10 = c24948zU0M8.h();
        AbstractC13042fc3.h(c9424Zw2H10, "kotlinReadOnly.packageFqName");
        a aVar5 = new a(c5203Ii3.h(Set.class), c24948zU0M8, new C24948zU0(c9424Zw2H9, AbstractC10644bx2.d(c9424Zw25, c9424Zw2H10), false));
        C24948zU0 c24948zU0M9 = C24948zU0.m(PJ6.a.R);
        AbstractC13042fc3.h(c24948zU0M9, "topLevel(FqNames.listIterator)");
        C9424Zw2 c9424Zw26 = PJ6.a.Z;
        C9424Zw2 c9424Zw2H11 = c24948zU0M9.h();
        C9424Zw2 c9424Zw2H12 = c24948zU0M9.h();
        AbstractC13042fc3.h(c9424Zw2H12, "kotlinReadOnly.packageFqName");
        a aVar6 = new a(c5203Ii3.h(ListIterator.class), c24948zU0M9, new C24948zU0(c9424Zw2H11, AbstractC10644bx2.d(c9424Zw26, c9424Zw2H12), false));
        C9424Zw2 c9424Zw27 = PJ6.a.T;
        C24948zU0 c24948zU0M10 = C24948zU0.m(c9424Zw27);
        AbstractC13042fc3.h(c24948zU0M10, "topLevel(FqNames.map)");
        C9424Zw2 c9424Zw28 = PJ6.a.b0;
        C9424Zw2 c9424Zw2H13 = c24948zU0M10.h();
        C9424Zw2 c9424Zw2H14 = c24948zU0M10.h();
        AbstractC13042fc3.h(c9424Zw2H14, "kotlinReadOnly.packageFqName");
        a aVar7 = new a(c5203Ii3.h(Map.class), c24948zU0M10, new C24948zU0(c9424Zw2H13, AbstractC10644bx2.d(c9424Zw28, c9424Zw2H14), false));
        C24948zU0 c24948zU0D = C24948zU0.m(c9424Zw27).d(PJ6.a.U.g());
        AbstractC13042fc3.h(c24948zU0D, "topLevel(FqNames.map).createNestedClassId(FqNames.mapEntry.shortName())");
        C9424Zw2 c9424Zw29 = PJ6.a.c0;
        C9424Zw2 c9424Zw2H15 = c24948zU0D.h();
        C9424Zw2 c9424Zw2H16 = c24948zU0D.h();
        AbstractC13042fc3.h(c9424Zw2H16, "kotlinReadOnly.packageFqName");
        List listP = AbstractC10360bX0.p(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, new a(c5203Ii3.h(Map.Entry.class), c24948zU0D, new C24948zU0(c9424Zw2H15, AbstractC10644bx2.d(c9424Zw29, c9424Zw2H16), false)));
        o = listP;
        c5203Ii3.g(Object.class, PJ6.a.b);
        c5203Ii3.g(String.class, PJ6.a.h);
        c5203Ii3.g(CharSequence.class, PJ6.a.g);
        c5203Ii3.f(Throwable.class, PJ6.a.u);
        c5203Ii3.g(Cloneable.class, PJ6.a.d);
        c5203Ii3.g(Number.class, PJ6.a.r);
        c5203Ii3.f(Comparable.class, PJ6.a.v);
        c5203Ii3.g(Enum.class, PJ6.a.s);
        c5203Ii3.f(Annotation.class, PJ6.a.E);
        Iterator it = listP.iterator();
        while (it.hasNext()) {
            a.e((a) it.next());
        }
        EnumC7376Rl3[] enumC7376Rl3ArrValues = EnumC7376Rl3.values();
        int length = enumC7376Rl3ArrValues.length;
        int i3 = 0;
        while (i3 < length) {
            EnumC7376Rl3 enumC7376Rl3 = enumC7376Rl3ArrValues[i3];
            i3++;
            C5203Ii3 c5203Ii32 = a;
            C24948zU0 c24948zU0M11 = C24948zU0.m(enumC7376Rl3.u());
            AbstractC13042fc3.h(c24948zU0M11, "topLevel(jvmType.wrapperFqName)");
            PJ6 pj6 = PJ6.a;
            EnumC4809Gq5 enumC4809Gq5S = enumC7376Rl3.s();
            AbstractC13042fc3.h(enumC4809Gq5S, "jvmType.primitiveType");
            C24948zU0 c24948zU0M12 = C24948zU0.m(PJ6.c(enumC4809Gq5S));
            AbstractC13042fc3.h(c24948zU0M12, "topLevel(StandardNames.getPrimitiveFqName(jvmType.primitiveType))");
            c5203Ii32.b(c24948zU0M11, c24948zU0M12);
        }
        for (C24948zU0 c24948zU0 : C13895h01.a.a()) {
            C5203Ii3 c5203Ii33 = a;
            C24948zU0 c24948zU0M13 = C24948zU0.m(new C9424Zw2("kotlin.jvm.internal." + c24948zU0.j().h() + "CompanionObject"));
            AbstractC13042fc3.h(c24948zU0M13, "topLevel(FqName(\"kotlin.jvm.internal.\" + classId.shortClassName.asString() + \"CompanionObject\"))");
            C24948zU0 c24948zU0D2 = c24948zU0.d(AbstractC23662xI6.c);
            AbstractC13042fc3.h(c24948zU0D2, "classId.createNestedClassId(SpecialNames.DEFAULT_NAME_FOR_COMPANION_OBJECT)");
            c5203Ii33.b(c24948zU0M13, c24948zU0D2);
        }
        int i4 = 0;
        while (true) {
            int i5 = i4 + 1;
            C5203Ii3 c5203Ii34 = a;
            C24948zU0 c24948zU0M14 = C24948zU0.m(new C9424Zw2(AbstractC13042fc3.q("kotlin.jvm.functions.Function", Integer.valueOf(i4))));
            AbstractC13042fc3.h(c24948zU0M14, "topLevel(FqName(\"kotlin.jvm.functions.Function$i\"))");
            c5203Ii34.b(c24948zU0M14, PJ6.a(i4));
            c5203Ii34.d(new C9424Zw2(AbstractC13042fc3.q(c, Integer.valueOf(i4))), h);
            if (i5 >= 23) {
                break;
            } else {
                i4 = i5;
            }
        }
        while (true) {
            int i6 = i2 + 1;
            EnumC24185yB2 enumC24185yB25 = EnumC24185yB2.g;
            String str = enumC24185yB25.j().toString() + '.' + enumC24185yB25.a();
            C5203Ii3 c5203Ii35 = a;
            c5203Ii35.d(new C9424Zw2(AbstractC13042fc3.q(str, Integer.valueOf(i2))), h);
            if (i6 >= 22) {
                C9424Zw2 c9424Zw2L = PJ6.a.c.l();
                AbstractC13042fc3.h(c9424Zw2L, "nothing.toSafe()");
                c5203Ii35.d(c9424Zw2L, c5203Ii35.h(Void.class));
                return;
            }
            i2 = i6;
        }
    }

    private C5203Ii3() {
    }

    private final void b(C24948zU0 c24948zU0, C24948zU0 c24948zU02) {
        c(c24948zU0, c24948zU02);
        C9424Zw2 c9424Zw2B = c24948zU02.b();
        AbstractC13042fc3.h(c9424Zw2B, "kotlinClassId.asSingleFqName()");
        d(c9424Zw2B, c24948zU0);
    }

    private final void c(C24948zU0 c24948zU0, C24948zU0 c24948zU02) {
        HashMap map = k;
        C10027ax2 c10027ax2J = c24948zU0.b().j();
        AbstractC13042fc3.h(c10027ax2J, "javaClassId.asSingleFqName().toUnsafe()");
        map.put(c10027ax2J, c24948zU02);
    }

    private final void d(C9424Zw2 c9424Zw2, C24948zU0 c24948zU0) {
        HashMap map = l;
        C10027ax2 c10027ax2J = c9424Zw2.j();
        AbstractC13042fc3.h(c10027ax2J, "kotlinFqNameUnsafe.toUnsafe()");
        map.put(c10027ax2J, c24948zU0);
    }

    private final void e(a aVar) {
        C24948zU0 c24948zU0A = aVar.a();
        C24948zU0 c24948zU0B = aVar.b();
        C24948zU0 c24948zU0C = aVar.c();
        b(c24948zU0A, c24948zU0B);
        C9424Zw2 c9424Zw2B = c24948zU0C.b();
        AbstractC13042fc3.h(c9424Zw2B, "mutableClassId.asSingleFqName()");
        d(c9424Zw2B, c24948zU0A);
        C9424Zw2 c9424Zw2B2 = c24948zU0B.b();
        AbstractC13042fc3.h(c9424Zw2B2, "readOnlyClassId.asSingleFqName()");
        C9424Zw2 c9424Zw2B3 = c24948zU0C.b();
        AbstractC13042fc3.h(c9424Zw2B3, "mutableClassId.asSingleFqName()");
        HashMap map = m;
        C10027ax2 c10027ax2J = c24948zU0C.b().j();
        AbstractC13042fc3.h(c10027ax2J, "mutableClassId.asSingleFqName().toUnsafe()");
        map.put(c10027ax2J, c9424Zw2B2);
        HashMap map2 = n;
        C10027ax2 c10027ax2J2 = c9424Zw2B2.j();
        AbstractC13042fc3.h(c10027ax2J2, "readOnlyFqName.toUnsafe()");
        map2.put(c10027ax2J2, c9424Zw2B3);
    }

    private final void f(Class cls, C9424Zw2 c9424Zw2) {
        C24948zU0 c24948zU0H = h(cls);
        C24948zU0 c24948zU0M = C24948zU0.m(c9424Zw2);
        AbstractC13042fc3.h(c24948zU0M, "topLevel(kotlinFqName)");
        b(c24948zU0H, c24948zU0M);
    }

    private final void g(Class cls, C10027ax2 c10027ax2) {
        C9424Zw2 c9424Zw2L = c10027ax2.l();
        AbstractC13042fc3.h(c9424Zw2L, "kotlinFqName.toSafe()");
        f(cls, c9424Zw2L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C24948zU0 h(Class cls) {
        if (!cls.isPrimitive()) {
            cls.isArray();
        }
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            C24948zU0 c24948zU0M = C24948zU0.m(new C9424Zw2(cls.getCanonicalName()));
            AbstractC13042fc3.h(c24948zU0M, "topLevel(FqName(clazz.canonicalName))");
            return c24948zU0M;
        }
        C24948zU0 c24948zU0D = h(declaringClass).d(C6432No4.p(cls.getSimpleName()));
        AbstractC13042fc3.h(c24948zU0D, "classId(outer).createNestedClassId(Name.identifier(clazz.simpleName))");
        return c24948zU0D;
    }

    private final boolean k(C10027ax2 c10027ax2, String str) {
        Integer numO;
        String strB = c10027ax2.b();
        AbstractC13042fc3.h(strB, "kotlinFqName.asString()");
        String strX0 = AbstractC20762sZ6.X0(strB, str, "");
        return strX0.length() > 0 && !AbstractC20762sZ6.S0(strX0, '0', false, 2, null) && (numO = AbstractC19562qZ6.o(strX0)) != null && numO.intValue() >= 23;
    }

    public final C9424Zw2 i() {
        return g;
    }

    public final List j() {
        return o;
    }

    public final boolean l(C10027ax2 c10027ax2) {
        HashMap map = m;
        if (map != null) {
            return map.containsKey(c10027ax2);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
    }

    public final boolean m(C10027ax2 c10027ax2) {
        HashMap map = n;
        if (map != null) {
            return map.containsKey(c10027ax2);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
    }

    public final C24948zU0 n(C9424Zw2 c9424Zw2) {
        AbstractC13042fc3.i(c9424Zw2, "fqName");
        return (C24948zU0) k.get(c9424Zw2.j());
    }

    public final C24948zU0 o(C10027ax2 c10027ax2) {
        AbstractC13042fc3.i(c10027ax2, "kotlinFqName");
        return k(c10027ax2, b) ? f : k(c10027ax2, d) ? f : k(c10027ax2, c) ? h : k(c10027ax2, e) ? h : (C24948zU0) l.get(c10027ax2);
    }

    public final C9424Zw2 p(C10027ax2 c10027ax2) {
        return (C9424Zw2) m.get(c10027ax2);
    }

    public final C9424Zw2 q(C10027ax2 c10027ax2) {
        return (C9424Zw2) n.get(c10027ax2);
    }
}
