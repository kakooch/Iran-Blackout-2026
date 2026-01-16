package ir.nasim;

import ir.nasim.AbstractC5284Ir3;
import ir.nasim.InterfaceC15194jA0;
import ir.nasim.InterfaceC4333Er3;
import ir.nasim.InterfaceC8487We2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.ServiceLoader;
import java.util.Set;
import org.xbill.DNS.Type;

/* renamed from: ir.nasim.dO4, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C11663dO4 {
    private static final List c = AbstractC15401jX0.m1(ServiceLoader.load(InterfaceC8487We2.class, InterfaceC8487We2.class.getClassLoader()));
    public static final C11663dO4 d;
    private static final InterfaceC4333Er3.a e;
    private final AbstractC5284Ir3 a;
    private final InterfaceC4333Er3.a b;

    /* renamed from: ir.nasim.dO4$a */
    static class a implements InterfaceC4333Er3.a {
        a() {
        }

        private static /* synthetic */ void b(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "a";
            } else {
                objArr[0] = "b";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$1";
            objArr[2] = "equals";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // ir.nasim.InterfaceC4333Er3.a
        public boolean a(InterfaceC13882gy7 interfaceC13882gy7, InterfaceC13882gy7 interfaceC13882gy72) {
            if (interfaceC13882gy7 == null) {
                b(0);
            }
            if (interfaceC13882gy72 == null) {
                b(1);
            }
            return interfaceC13882gy7.equals(interfaceC13882gy72);
        }
    }

    /* renamed from: ir.nasim.dO4$b */
    static class b implements InterfaceC14603iB2 {
        b() {
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public XV4 invoke(InterfaceC14592iA0 interfaceC14592iA0, InterfaceC14592iA0 interfaceC14592iA02) {
            return new XV4(interfaceC14592iA0, interfaceC14592iA02);
        }
    }

    /* renamed from: ir.nasim.dO4$c */
    static class c implements UA2 {
        final /* synthetic */ InterfaceC12795fB1 a;

        c(InterfaceC12795fB1 interfaceC12795fB1) {
            this.a = interfaceC12795fB1;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean invoke(InterfaceC15194jA0 interfaceC15194jA0) {
            return Boolean.valueOf(interfaceC15194jA0.b() == this.a);
        }
    }

    /* renamed from: ir.nasim.dO4$e */
    static class e implements UA2 {
        final /* synthetic */ InterfaceC21331tU0 a;

        e(InterfaceC21331tU0 interfaceC21331tU0) {
            this.a = interfaceC21331tU0;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean invoke(InterfaceC15194jA0 interfaceC15194jA0) {
            return Boolean.valueOf(!QI1.g(interfaceC15194jA0.getVisibility()) && QI1.h(interfaceC15194jA0, this.a));
        }
    }

    /* renamed from: ir.nasim.dO4$g */
    static class g implements UA2 {
        final /* synthetic */ AbstractC10899cO4 a;
        final /* synthetic */ InterfaceC15194jA0 b;

        g(AbstractC10899cO4 abstractC10899cO4, InterfaceC15194jA0 interfaceC15194jA0) {
            this.a = abstractC10899cO4;
            this.b = interfaceC15194jA0;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C19938rB7 invoke(InterfaceC15194jA0 interfaceC15194jA0) {
            this.a.b(this.b, interfaceC15194jA0);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.dO4$h */
    static /* synthetic */ class h {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;
        static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[EnumC11067cg4.valuesCustom().length];
            c = iArr;
            try {
                iArr[EnumC11067cg4.FINAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[EnumC11067cg4.SEALED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                c[EnumC11067cg4.OPEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                c[EnumC11067cg4.ABSTRACT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[i.a.values().length];
            b = iArr2;
            try {
                iArr2[i.a.OVERRIDABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[i.a.CONFLICT.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[i.a.INCOMPATIBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[InterfaceC8487We2.b.values().length];
            a = iArr3;
            try {
                iArr3[InterfaceC8487We2.b.OVERRIDABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[InterfaceC8487We2.b.CONFLICT.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[InterfaceC8487We2.b.INCOMPATIBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[InterfaceC8487We2.b.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    /* renamed from: ir.nasim.dO4$i */
    public static class i {
        private static final i c = new i(a.OVERRIDABLE, "SUCCESS");
        private final a a;
        private final String b;

        /* renamed from: ir.nasim.dO4$i$a */
        public enum a {
            OVERRIDABLE,
            INCOMPATIBLE,
            CONFLICT
        }

        public i(a aVar, String str) {
            if (aVar == null) {
                a(3);
            }
            if (str == null) {
                a(4);
            }
            this.a = aVar;
            this.b = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0031  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private static /* synthetic */ void a(int r10) {
            /*
                r0 = 4
                r1 = 3
                r2 = 2
                r3 = 1
                if (r10 == r3) goto Lf
                if (r10 == r2) goto Lf
                if (r10 == r1) goto Lf
                if (r10 == r0) goto Lf
                java.lang.String r4 = "@NotNull method %s.%s must not return null"
                goto L11
            Lf:
                java.lang.String r4 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
            L11:
                if (r10 == r3) goto L1b
                if (r10 == r2) goto L1b
                if (r10 == r1) goto L1b
                if (r10 == r0) goto L1b
                r5 = r2
                goto L1c
            L1b:
                r5 = r1
            L1c:
                java.lang.Object[] r5 = new java.lang.Object[r5]
                java.lang.String r6 = "success"
                java.lang.String r7 = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo"
                r8 = 0
                if (r10 == r3) goto L31
                if (r10 == r2) goto L31
                if (r10 == r1) goto L2e
                if (r10 == r0) goto L31
                r5[r8] = r7
                goto L35
            L2e:
                r5[r8] = r6
                goto L35
            L31:
                java.lang.String r9 = "debugMessage"
                r5[r8] = r9
            L35:
                switch(r10) {
                    case 1: goto L45;
                    case 2: goto L45;
                    case 3: goto L45;
                    case 4: goto L45;
                    case 5: goto L40;
                    case 6: goto L3b;
                    default: goto L38;
                }
            L38:
                r5[r3] = r6
                goto L47
            L3b:
                java.lang.String r6 = "getDebugMessage"
                r5[r3] = r6
                goto L47
            L40:
                java.lang.String r6 = "getResult"
                r5[r3] = r6
                goto L47
            L45:
                r5[r3] = r7
            L47:
                if (r10 == r3) goto L5a
                if (r10 == r2) goto L55
                if (r10 == r1) goto L50
                if (r10 == r0) goto L50
                goto L5e
            L50:
                java.lang.String r6 = "<init>"
                r5[r2] = r6
                goto L5e
            L55:
                java.lang.String r6 = "conflict"
                r5[r2] = r6
                goto L5e
            L5a:
                java.lang.String r6 = "incompatible"
                r5[r2] = r6
            L5e:
                java.lang.String r4 = java.lang.String.format(r4, r5)
                if (r10 == r3) goto L70
                if (r10 == r2) goto L70
                if (r10 == r1) goto L70
                if (r10 == r0) goto L70
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                r10.<init>(r4)
                goto L75
            L70:
                java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
                r10.<init>(r4)
            L75:
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C11663dO4.i.a(int):void");
        }

        public static i b(String str) {
            if (str == null) {
                a(2);
            }
            return new i(a.CONFLICT, str);
        }

        public static i d(String str) {
            if (str == null) {
                a(1);
            }
            return new i(a.INCOMPATIBLE, str);
        }

        public static i e() {
            i iVar = c;
            if (iVar == null) {
                a(0);
            }
            return iVar;
        }

        public a c() {
            a aVar = this.a;
            if (aVar == null) {
                a(5);
            }
            return aVar;
        }
    }

    /* renamed from: ir.nasim.dO4$j */
    private class j extends IU0 {
        private final Map j;

        public j(Map map) {
            super(true, true, true, C11663dO4.this.a);
            this.j = map;
        }

        private static /* synthetic */ void I0(int i) {
            Object[] objArr = new Object[3];
            if (i == 1 || i == 3) {
                objArr[0] = "b";
            } else {
                objArr[0] = "a";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverridingUtilTypeCheckerContext";
            if (i == 2 || i == 3) {
                objArr[2] = "areEqualTypeConstructorsByAxioms";
            } else {
                objArr[2] = "areEqualTypeConstructors";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        private boolean J0(InterfaceC13882gy7 interfaceC13882gy7, InterfaceC13882gy7 interfaceC13882gy72) {
            if (interfaceC13882gy7 == null) {
                I0(2);
            }
            if (interfaceC13882gy72 == null) {
                I0(3);
            }
            if (C11663dO4.this.b.a(interfaceC13882gy7, interfaceC13882gy72)) {
                return true;
            }
            Map map = this.j;
            if (map == null) {
                return false;
            }
            InterfaceC13882gy7 interfaceC13882gy73 = (InterfaceC13882gy7) map.get(interfaceC13882gy7);
            InterfaceC13882gy7 interfaceC13882gy74 = (InterfaceC13882gy7) this.j.get(interfaceC13882gy72);
            if (interfaceC13882gy73 == null || !interfaceC13882gy73.equals(interfaceC13882gy72)) {
                return interfaceC13882gy74 != null && interfaceC13882gy74.equals(interfaceC13882gy7);
            }
            return true;
        }

        @Override // ir.nasim.IU0
        public boolean G0(InterfaceC13882gy7 interfaceC13882gy7, InterfaceC13882gy7 interfaceC13882gy72) {
            if (interfaceC13882gy7 == null) {
                I0(0);
            }
            if (interfaceC13882gy72 == null) {
                I0(1);
            }
            return super.G0(interfaceC13882gy7, interfaceC13882gy72) || J0(interfaceC13882gy7, interfaceC13882gy72);
        }
    }

    static {
        a aVar = new a();
        e = aVar;
        d = new C11663dO4(aVar, AbstractC5284Ir3.a.a);
    }

    private C11663dO4(InterfaceC4333Er3.a aVar, AbstractC5284Ir3 abstractC5284Ir3) {
        if (aVar == null) {
            a(4);
        }
        if (abstractC5284Ir3 == null) {
            a(5);
        }
        this.b = aVar;
        this.a = abstractC5284Ir3;
    }

    public static i.a A(InterfaceC14592iA0 interfaceC14592iA0, InterfaceC14592iA0 interfaceC14592iA02) {
        C11663dO4 c11663dO4 = d;
        i.a aVarC = c11663dO4.G(interfaceC14592iA02, interfaceC14592iA0, null).c();
        i.a aVarC2 = c11663dO4.G(interfaceC14592iA0, interfaceC14592iA02, null).c();
        i.a aVar = i.a.OVERRIDABLE;
        if (aVarC == aVar && aVarC2 == aVar) {
            return aVar;
        }
        i.a aVar2 = i.a.CONFLICT;
        return (aVarC == aVar2 || aVarC2 == aVar2) ? aVar2 : i.a.INCOMPATIBLE;
    }

    private static EnumC11067cg4 B(Collection collection, boolean z, EnumC11067cg4 enumC11067cg4) {
        if (collection == null) {
            a(91);
        }
        if (enumC11067cg4 == null) {
            a(92);
        }
        EnumC11067cg4 enumC11067cg42 = EnumC11067cg4.ABSTRACT;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            InterfaceC15194jA0 interfaceC15194jA0 = (InterfaceC15194jA0) it.next();
            EnumC11067cg4 enumC11067cg4R = (z && interfaceC15194jA0.r() == EnumC11067cg4.ABSTRACT) ? enumC11067cg4 : interfaceC15194jA0.r();
            if (enumC11067cg4R.compareTo(enumC11067cg42) < 0) {
                enumC11067cg42 = enumC11067cg4R;
            }
        }
        if (enumC11067cg42 == null) {
            a(93);
        }
        return enumC11067cg42;
    }

    public static Set C(InterfaceC15194jA0 interfaceC15194jA0) {
        if (interfaceC15194jA0 == null) {
            a(13);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        h(interfaceC15194jA0, linkedHashSet);
        return linkedHashSet;
    }

    private static boolean D(InterfaceC19199pw5 interfaceC19199pw5, InterfaceC19199pw5 interfaceC19199pw52) {
        if (interfaceC19199pw5 == null || interfaceC19199pw52 == null) {
            return true;
        }
        return K(interfaceC19199pw5, interfaceC19199pw52);
    }

    public static boolean E(InterfaceC14592iA0 interfaceC14592iA0, InterfaceC14592iA0 interfaceC14592iA02) {
        if (interfaceC14592iA0 == null) {
            a(65);
        }
        if (interfaceC14592iA02 == null) {
            a(66);
        }
        AbstractC4099Dr3 returnType = interfaceC14592iA0.getReturnType();
        AbstractC4099Dr3 returnType2 = interfaceC14592iA02.getReturnType();
        if (!K(interfaceC14592iA0, interfaceC14592iA02)) {
            return false;
        }
        XV4 xv4N = d.n(interfaceC14592iA0.getTypeParameters(), interfaceC14592iA02.getTypeParameters());
        if (interfaceC14592iA0 instanceof AB2) {
            return J(interfaceC14592iA0, returnType, interfaceC14592iA02, returnType2, xv4N);
        }
        if (!(interfaceC14592iA0 instanceof InterfaceC20989sw5)) {
            throw new IllegalArgumentException("Unexpected callable: " + interfaceC14592iA0.getClass());
        }
        InterfaceC20989sw5 interfaceC20989sw5 = (InterfaceC20989sw5) interfaceC14592iA0;
        InterfaceC20989sw5 interfaceC20989sw52 = (InterfaceC20989sw5) interfaceC14592iA02;
        if (D(interfaceC20989sw5.J(), interfaceC20989sw52.J())) {
            return (interfaceC20989sw5.P() && interfaceC20989sw52.P()) ? ((C15041iu4) xv4N.e()).e((IU0) xv4N.f(), returnType.N0(), returnType2.N0()) : (interfaceC20989sw5.P() || !interfaceC20989sw52.P()) && J(interfaceC14592iA0, returnType, interfaceC14592iA02, returnType2, xv4N);
        }
        return false;
    }

    private static boolean F(InterfaceC14592iA0 interfaceC14592iA0, Collection collection) {
        if (interfaceC14592iA0 == null) {
            a(69);
        }
        if (collection == null) {
            a(70);
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!E(interfaceC14592iA0, (InterfaceC14592iA0) it.next())) {
                return false;
            }
        }
        return true;
    }

    private static boolean J(InterfaceC14592iA0 interfaceC14592iA0, AbstractC4099Dr3 abstractC4099Dr3, InterfaceC14592iA0 interfaceC14592iA02, AbstractC4099Dr3 abstractC4099Dr32, XV4 xv4) {
        if (interfaceC14592iA0 == null) {
            a(71);
        }
        if (abstractC4099Dr3 == null) {
            a(72);
        }
        if (interfaceC14592iA02 == null) {
            a(73);
        }
        if (abstractC4099Dr32 == null) {
            a(74);
        }
        if (xv4 == null) {
            a(75);
        }
        return ((C15041iu4) xv4.e()).f((IU0) xv4.f(), abstractC4099Dr3.N0(), abstractC4099Dr32.N0());
    }

    private static boolean K(InterfaceC16977mB1 interfaceC16977mB1, InterfaceC16977mB1 interfaceC16977mB12) {
        if (interfaceC16977mB1 == null) {
            a(67);
        }
        if (interfaceC16977mB12 == null) {
            a(68);
        }
        Integer numD = QI1.d(interfaceC16977mB1.getVisibility(), interfaceC16977mB12.getVisibility());
        return numD == null || numD.intValue() >= 0;
    }

    public static boolean L(InterfaceC21058t24 interfaceC21058t24, InterfaceC21058t24 interfaceC21058t242) {
        if (interfaceC21058t24 == null) {
            a(55);
        }
        if (interfaceC21058t242 == null) {
            a(56);
        }
        return !QI1.g(interfaceC21058t242.getVisibility()) && QI1.h(interfaceC21058t242, interfaceC21058t24);
    }

    public static boolean M(InterfaceC14592iA0 interfaceC14592iA0, InterfaceC14592iA0 interfaceC14592iA02, boolean z, boolean z2) {
        if (interfaceC14592iA0 == null) {
            a(11);
        }
        if (interfaceC14592iA02 == null) {
            a(12);
        }
        if (!interfaceC14592iA0.equals(interfaceC14592iA02) && C23067wI1.a.e(interfaceC14592iA0.a(), interfaceC14592iA02.a(), z, z2)) {
            return true;
        }
        InterfaceC14592iA0 interfaceC14592iA0A = interfaceC14592iA02.a();
        Iterator it = OI1.d(interfaceC14592iA0).iterator();
        while (it.hasNext()) {
            if (C23067wI1.a.e(interfaceC14592iA0A, (InterfaceC14592iA0) it.next(), z, z2)) {
                return true;
            }
        }
        return false;
    }

    public static void N(InterfaceC15194jA0 interfaceC15194jA0, UA2 ua2) {
        RI1 ri1;
        if (interfaceC15194jA0 == null) {
            a(105);
        }
        for (InterfaceC15194jA0 interfaceC15194jA02 : interfaceC15194jA0.d()) {
            if (interfaceC15194jA02.getVisibility() == QI1.g) {
                N(interfaceC15194jA02, ua2);
            }
        }
        if (interfaceC15194jA0.getVisibility() != QI1.g) {
            return;
        }
        RI1 ri1J = j(interfaceC15194jA0);
        if (ri1J == null) {
            if (ua2 != null) {
                ua2.invoke(interfaceC15194jA0);
            }
            ri1 = QI1.e;
        } else {
            ri1 = ri1J;
        }
        if (interfaceC15194jA0 instanceof C21676tw5) {
            ((C21676tw5) interfaceC15194jA0).Z0(ri1);
            Iterator it = ((InterfaceC20989sw5) interfaceC15194jA0).v().iterator();
            while (it.hasNext()) {
                N((InterfaceC19199pw5) it.next(), ri1J == null ? null : ua2);
            }
            return;
        }
        if (interfaceC15194jA0 instanceof BB2) {
            ((BB2) interfaceC15194jA0).i1(ri1);
            return;
        }
        AbstractC19790qw5 abstractC19790qw5 = (AbstractC19790qw5) interfaceC15194jA0;
        abstractC19790qw5.M0(ri1);
        if (ri1 != abstractC19790qw5.V().getVisibility()) {
            abstractC19790qw5.K0(false);
        }
    }

    public static Object O(Collection collection, UA2 ua2) {
        Object next;
        if (collection == null) {
            a(76);
        }
        if (ua2 == null) {
            a(77);
        }
        if (collection.size() == 1) {
            Object objP0 = AbstractC15401jX0.p0(collection);
            if (objP0 == null) {
                a(78);
            }
            return objP0;
        }
        ArrayList arrayList = new ArrayList(2);
        List listG0 = AbstractC15401jX0.G0(collection, ua2);
        Object objP02 = AbstractC15401jX0.p0(collection);
        InterfaceC14592iA0 interfaceC14592iA0 = (InterfaceC14592iA0) ua2.invoke(objP02);
        for (Object obj : collection) {
            InterfaceC14592iA0 interfaceC14592iA02 = (InterfaceC14592iA0) ua2.invoke(obj);
            if (F(interfaceC14592iA02, listG0)) {
                arrayList.add(obj);
            }
            if (E(interfaceC14592iA02, interfaceC14592iA0) && !E(interfaceC14592iA0, interfaceC14592iA02)) {
                objP02 = obj;
            }
        }
        if (arrayList.isEmpty()) {
            if (objP02 == null) {
                a(79);
            }
            return objP02;
        }
        if (arrayList.size() == 1) {
            Object objP03 = AbstractC15401jX0.p0(arrayList);
            if (objP03 == null) {
                a(80);
            }
            return objP03;
        }
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (!AbstractC7411Rp2.b(((InterfaceC14592iA0) ua2.invoke(next)).getReturnType())) {
                break;
            }
        }
        if (next != null) {
            return next;
        }
        Object objP04 = AbstractC15401jX0.p0(arrayList);
        if (objP04 == null) {
            a(82);
        }
        return objP04;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002d A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004c A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0184  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static /* synthetic */ void a(int r22) {
        /*
            Method dump skipped, instructions count: 1282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C11663dO4.a(int):void");
    }

    private static boolean d(Collection collection) {
        if (collection == null) {
            a(61);
        }
        if (collection.size() < 2) {
            return true;
        }
        return AbstractC15401jX0.e0(collection, new c(((InterfaceC15194jA0) collection.iterator().next()).b()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0054, code lost:
    
        r1.remove();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean e(ir.nasim.InterfaceC22882vy7 r5, ir.nasim.InterfaceC22882vy7 r6, ir.nasim.XV4 r7) {
        /*
            r4 = this;
            if (r5 != 0) goto L7
            r0 = 47
            a(r0)
        L7:
            if (r6 != 0) goto Le
            r0 = 48
            a(r0)
        Le:
            if (r7 != 0) goto L15
            r0 = 49
            a(r0)
        L15:
            java.util.List r5 = r5.getUpperBounds()
            java.util.ArrayList r0 = new java.util.ArrayList
            java.util.List r6 = r6.getUpperBounds()
            r0.<init>(r6)
            int r6 = r5.size()
            int r1 = r0.size()
            r2 = 0
            if (r6 == r1) goto L2e
            return r2
        L2e:
            java.util.Iterator r5 = r5.iterator()
        L32:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L59
            java.lang.Object r6 = r5.next()
            ir.nasim.Dr3 r6 = (ir.nasim.AbstractC4099Dr3) r6
            java.util.ListIterator r1 = r0.listIterator()
        L42:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L58
            java.lang.Object r3 = r1.next()
            ir.nasim.Dr3 r3 = (ir.nasim.AbstractC4099Dr3) r3
            boolean r3 = r4.f(r6, r3, r7)
            if (r3 == 0) goto L42
            r1.remove()
            goto L32
        L58:
            return r2
        L59:
            r5 = 1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C11663dO4.e(ir.nasim.vy7, ir.nasim.vy7, ir.nasim.XV4):boolean");
    }

    private boolean f(AbstractC4099Dr3 abstractC4099Dr3, AbstractC4099Dr3 abstractC4099Dr32, XV4 xv4) {
        if (abstractC4099Dr3 == null) {
            a(44);
        }
        if (abstractC4099Dr32 == null) {
            a(45);
        }
        if (xv4 == null) {
            a(46);
        }
        if (AbstractC4816Gr3.a(abstractC4099Dr3) && AbstractC4816Gr3.a(abstractC4099Dr32)) {
            return true;
        }
        return ((C15041iu4) xv4.e()).e((IU0) xv4.f(), abstractC4099Dr3.N0(), abstractC4099Dr32.N0());
    }

    private static i g(InterfaceC14592iA0 interfaceC14592iA0, InterfaceC14592iA0 interfaceC14592iA02) {
        if ((interfaceC14592iA0.Q() == null) != (interfaceC14592iA02.Q() == null)) {
            return i.d("Receiver presence mismatch");
        }
        if (interfaceC14592iA0.h().size() != interfaceC14592iA02.h().size()) {
            return i.d("Value parameter number mismatch");
        }
        return null;
    }

    private static void h(InterfaceC15194jA0 interfaceC15194jA0, Set set) {
        if (interfaceC15194jA0 == null) {
            a(15);
        }
        if (set == null) {
            a(16);
        }
        if (interfaceC15194jA0.f().a()) {
            set.add(interfaceC15194jA0);
            return;
        }
        if (interfaceC15194jA0.d().isEmpty()) {
            throw new IllegalStateException("No overridden descriptors found for (fake override) " + interfaceC15194jA0);
        }
        Iterator it = interfaceC15194jA0.d().iterator();
        while (it.hasNext()) {
            h((InterfaceC15194jA0) it.next(), set);
        }
    }

    private static List i(InterfaceC14592iA0 interfaceC14592iA0) {
        ZI5 zi5Q = interfaceC14592iA0.Q();
        ArrayList arrayList = new ArrayList();
        if (zi5Q != null) {
            arrayList.add(zi5Q.getType());
        }
        Iterator it = interfaceC14592iA0.h().iterator();
        while (it.hasNext()) {
            arrayList.add(((InterfaceC24919zQ7) it.next()).getType());
        }
        return arrayList;
    }

    private static RI1 j(InterfaceC15194jA0 interfaceC15194jA0) {
        if (interfaceC15194jA0 == null) {
            a(Type.L64);
        }
        Collection<InterfaceC15194jA0> collectionD = interfaceC15194jA0.d();
        RI1 ri1X = x(collectionD);
        if (ri1X == null) {
            return null;
        }
        if (interfaceC15194jA0.f() != InterfaceC15194jA0.a.FAKE_OVERRIDE) {
            return ri1X.f();
        }
        for (InterfaceC15194jA0 interfaceC15194jA02 : collectionD) {
            if (interfaceC15194jA02.r() != EnumC11067cg4.ABSTRACT && !interfaceC15194jA02.getVisibility().equals(ri1X)) {
                return null;
            }
        }
        return ri1X;
    }

    public static C11663dO4 k(AbstractC5284Ir3 abstractC5284Ir3, InterfaceC4333Er3.a aVar) {
        if (abstractC5284Ir3 == null) {
            a(2);
        }
        if (aVar == null) {
            a(3);
        }
        return new C11663dO4(aVar, abstractC5284Ir3);
    }

    private static void l(Collection collection, InterfaceC21331tU0 interfaceC21331tU0, AbstractC10899cO4 abstractC10899cO4) {
        if (collection == null) {
            a(83);
        }
        if (interfaceC21331tU0 == null) {
            a(84);
        }
        if (abstractC10899cO4 == null) {
            a(85);
        }
        Collection collectionW = w(interfaceC21331tU0, collection);
        boolean zIsEmpty = collectionW.isEmpty();
        if (!zIsEmpty) {
            collection = collectionW;
        }
        InterfaceC15194jA0 interfaceC15194jA0U = ((InterfaceC15194jA0) O(collection, new d())).u(interfaceC21331tU0, q(collection, interfaceC21331tU0), zIsEmpty ? QI1.h : QI1.g, InterfaceC15194jA0.a.FAKE_OVERRIDE, false);
        abstractC10899cO4.d(interfaceC15194jA0U, collection);
        abstractC10899cO4.a(interfaceC15194jA0U);
    }

    private static void m(InterfaceC21331tU0 interfaceC21331tU0, Collection collection, AbstractC10899cO4 abstractC10899cO4) {
        if (interfaceC21331tU0 == null) {
            a(62);
        }
        if (collection == null) {
            a(63);
        }
        if (abstractC10899cO4 == null) {
            a(64);
        }
        if (d(collection)) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                l(Collections.singleton((InterfaceC15194jA0) it.next()), interfaceC21331tU0, abstractC10899cO4);
            }
        } else {
            LinkedList linkedList = new LinkedList(collection);
            while (!linkedList.isEmpty()) {
                l(s(MY7.a(linkedList), linkedList, abstractC10899cO4), interfaceC21331tU0, abstractC10899cO4);
            }
        }
    }

    private XV4 n(List list, List list2) {
        if (list == null) {
            a(40);
        }
        if (list2 == null) {
            a(41);
        }
        return new XV4(new C15041iu4(this.a), o(list, list2));
    }

    private j o(List list, List list2) {
        if (list == null) {
            a(42);
        }
        if (list2 == null) {
            a(43);
        }
        if (list.isEmpty()) {
            return new j(null);
        }
        HashMap map = new HashMap();
        for (int i2 = 0; i2 < list.size(); i2++) {
            map.put(((InterfaceC22882vy7) list.get(i2)).j(), ((InterfaceC22882vy7) list2.get(i2)).j());
        }
        return new j(map);
    }

    public static C11663dO4 p(AbstractC5284Ir3 abstractC5284Ir3) {
        if (abstractC5284Ir3 == null) {
            a(1);
        }
        return new C11663dO4(e, abstractC5284Ir3);
    }

    private static EnumC11067cg4 q(Collection collection, InterfaceC21331tU0 interfaceC21331tU0) {
        if (collection == null) {
            a(86);
        }
        if (interfaceC21331tU0 == null) {
            a(87);
        }
        Iterator it = collection.iterator();
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (it.hasNext()) {
            InterfaceC15194jA0 interfaceC15194jA0 = (InterfaceC15194jA0) it.next();
            int i2 = h.c[interfaceC15194jA0.r().ordinal()];
            if (i2 == 1) {
                EnumC11067cg4 enumC11067cg4 = EnumC11067cg4.FINAL;
                if (enumC11067cg4 == null) {
                    a(88);
                }
                return enumC11067cg4;
            }
            if (i2 == 2) {
                throw new IllegalStateException("Member cannot have SEALED modality: " + interfaceC15194jA0);
            }
            if (i2 == 3) {
                z2 = true;
            } else if (i2 == 4) {
                z3 = true;
            }
        }
        if (interfaceC21331tU0.l0() && interfaceC21331tU0.r() != EnumC11067cg4.ABSTRACT && interfaceC21331tU0.r() != EnumC11067cg4.SEALED) {
            z = true;
        }
        if (z2 && !z3) {
            EnumC11067cg4 enumC11067cg42 = EnumC11067cg4.OPEN;
            if (enumC11067cg42 == null) {
                a(89);
            }
            return enumC11067cg42;
        }
        if (!z2 && z3) {
            EnumC11067cg4 enumC11067cg4R = z ? interfaceC21331tU0.r() : EnumC11067cg4.ABSTRACT;
            if (enumC11067cg4R == null) {
                a(90);
            }
            return enumC11067cg4R;
        }
        HashSet hashSet = new HashSet();
        Iterator it2 = collection.iterator();
        while (it2.hasNext()) {
            hashSet.addAll(C((InterfaceC15194jA0) it2.next()));
        }
        return B(u(hashSet), z, interfaceC21331tU0.r());
    }

    private Collection r(InterfaceC15194jA0 interfaceC15194jA0, Collection collection, InterfaceC21331tU0 interfaceC21331tU0, AbstractC10899cO4 abstractC10899cO4) {
        if (interfaceC15194jA0 == null) {
            a(57);
        }
        if (collection == null) {
            a(58);
        }
        if (interfaceC21331tU0 == null) {
            a(59);
        }
        if (abstractC10899cO4 == null) {
            a(60);
        }
        ArrayList arrayList = new ArrayList(collection.size());
        DE6 de6F = DE6.f();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            InterfaceC15194jA0 interfaceC15194jA02 = (InterfaceC15194jA0) it.next();
            i.a aVarC = G(interfaceC15194jA02, interfaceC15194jA0, interfaceC21331tU0).c();
            boolean zL = L(interfaceC15194jA0, interfaceC15194jA02);
            int i2 = h.b[aVarC.ordinal()];
            if (i2 == 1) {
                if (zL) {
                    de6F.add(interfaceC15194jA02);
                }
                arrayList.add(interfaceC15194jA02);
            } else if (i2 == 2) {
                if (zL) {
                    abstractC10899cO4.c(interfaceC15194jA02, interfaceC15194jA0);
                }
                arrayList.add(interfaceC15194jA02);
            }
        }
        abstractC10899cO4.d(interfaceC15194jA0, de6F);
        return arrayList;
    }

    private static Collection s(InterfaceC15194jA0 interfaceC15194jA0, Queue queue, AbstractC10899cO4 abstractC10899cO4) {
        if (interfaceC15194jA0 == null) {
            a(102);
        }
        if (queue == null) {
            a(103);
        }
        if (abstractC10899cO4 == null) {
            a(104);
        }
        return t(interfaceC15194jA0, queue, new f(), new g(abstractC10899cO4, interfaceC15194jA0));
    }

    public static Collection t(Object obj, Collection collection, UA2 ua2, UA2 ua22) {
        if (obj == null) {
            a(97);
        }
        if (collection == null) {
            a(98);
        }
        if (ua2 == null) {
            a(99);
        }
        if (ua22 == null) {
            a(100);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(obj);
        InterfaceC14592iA0 interfaceC14592iA0 = (InterfaceC14592iA0) ua2.invoke(obj);
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            InterfaceC14592iA0 interfaceC14592iA02 = (InterfaceC14592iA0) ua2.invoke(next);
            if (obj == next) {
                it.remove();
            } else {
                i.a aVarA = A(interfaceC14592iA0, interfaceC14592iA02);
                if (aVarA == i.a.OVERRIDABLE) {
                    arrayList.add(next);
                    it.remove();
                } else if (aVarA == i.a.CONFLICT) {
                    ua22.invoke(next);
                    it.remove();
                }
            }
        }
        return arrayList;
    }

    public static Set u(Set set) {
        if (set == null) {
            a(6);
        }
        return v(set, !set.isEmpty() && PI1.q(PI1.l((InterfaceC12795fB1) set.iterator().next())), null, new b());
    }

    public static Set v(Set set, boolean z, SA2 sa2, InterfaceC14603iB2 interfaceC14603iB2) {
        if (set == null) {
            a(7);
        }
        if (interfaceC14603iB2 == null) {
            a(8);
        }
        if (set.size() <= 1) {
            return set;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : set) {
            if (sa2 != null) {
                sa2.invoke();
            }
            Iterator it = linkedHashSet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    linkedHashSet.add(obj);
                    break;
                }
                XV4 xv4 = (XV4) interfaceC14603iB2.invoke(obj, it.next());
                InterfaceC14592iA0 interfaceC14592iA0 = (InterfaceC14592iA0) xv4.a();
                InterfaceC14592iA0 interfaceC14592iA02 = (InterfaceC14592iA0) xv4.b();
                if (!M(interfaceC14592iA0, interfaceC14592iA02, z, true)) {
                    if (M(interfaceC14592iA02, interfaceC14592iA0, z, true)) {
                        break;
                    }
                } else {
                    it.remove();
                }
            }
        }
        return linkedHashSet;
    }

    private static Collection w(InterfaceC21331tU0 interfaceC21331tU0, Collection collection) {
        if (interfaceC21331tU0 == null) {
            a(94);
        }
        if (collection == null) {
            a(95);
        }
        List listM0 = AbstractC15401jX0.m0(collection, new e(interfaceC21331tU0));
        if (listM0 == null) {
            a(96);
        }
        return listM0;
    }

    public static RI1 x(Collection collection) {
        RI1 ri1;
        if (collection == null) {
            a(107);
        }
        if (collection.isEmpty()) {
            return QI1.l;
        }
        Iterator it = collection.iterator();
        loop0: while (true) {
            ri1 = null;
            while (it.hasNext()) {
                RI1 visibility = ((InterfaceC15194jA0) it.next()).getVisibility();
                if (ri1 != null) {
                    Integer numD = QI1.d(visibility, ri1);
                    if (numD == null) {
                        break;
                    }
                    if (numD.intValue() > 0) {
                    }
                }
                ri1 = visibility;
            }
        }
        if (ri1 == null) {
            return null;
        }
        Iterator it2 = collection.iterator();
        while (it2.hasNext()) {
            Integer numD2 = QI1.d(ri1, ((InterfaceC15194jA0) it2.next()).getVisibility());
            if (numD2 == null || numD2.intValue() < 0) {
                return null;
            }
        }
        return ri1;
    }

    public static i z(InterfaceC14592iA0 interfaceC14592iA0, InterfaceC14592iA0 interfaceC14592iA02) {
        boolean z;
        if (interfaceC14592iA0 == null) {
            a(38);
        }
        if (interfaceC14592iA02 == null) {
            a(39);
        }
        boolean z2 = interfaceC14592iA0 instanceof AB2;
        if ((z2 && !(interfaceC14592iA02 instanceof AB2)) || (((z = interfaceC14592iA0 instanceof InterfaceC20989sw5)) && !(interfaceC14592iA02 instanceof InterfaceC20989sw5))) {
            return i.d("Member kind mismatch");
        }
        if (!z2 && !z) {
            throw new IllegalArgumentException("This type of CallableDescriptor cannot be checked for overridability: " + interfaceC14592iA0);
        }
        if (!interfaceC14592iA0.getName().equals(interfaceC14592iA02.getName())) {
            return i.d("Name mismatch");
        }
        i iVarG = g(interfaceC14592iA0, interfaceC14592iA02);
        if (iVarG != null) {
            return iVarG;
        }
        return null;
    }

    public i G(InterfaceC14592iA0 interfaceC14592iA0, InterfaceC14592iA0 interfaceC14592iA02, InterfaceC21331tU0 interfaceC21331tU0) {
        if (interfaceC14592iA0 == null) {
            a(17);
        }
        if (interfaceC14592iA02 == null) {
            a(18);
        }
        i iVarH = H(interfaceC14592iA0, interfaceC14592iA02, interfaceC21331tU0, false);
        if (iVarH == null) {
            a(19);
        }
        return iVarH;
    }

    public i H(InterfaceC14592iA0 interfaceC14592iA0, InterfaceC14592iA0 interfaceC14592iA02, InterfaceC21331tU0 interfaceC21331tU0, boolean z) {
        if (interfaceC14592iA0 == null) {
            a(20);
        }
        if (interfaceC14592iA02 == null) {
            a(21);
        }
        i iVarI = I(interfaceC14592iA0, interfaceC14592iA02, z);
        boolean z2 = iVarI.c() == i.a.OVERRIDABLE;
        for (InterfaceC8487We2 interfaceC8487We2 : c) {
            if (interfaceC8487We2.b() != InterfaceC8487We2.a.CONFLICTS_ONLY && (!z2 || interfaceC8487We2.b() != InterfaceC8487We2.a.SUCCESS_ONLY)) {
                int i2 = h.a[interfaceC8487We2.a(interfaceC14592iA0, interfaceC14592iA02, interfaceC21331tU0).ordinal()];
                if (i2 == 1) {
                    z2 = true;
                } else {
                    if (i2 == 2) {
                        i iVarB = i.b("External condition failed");
                        if (iVarB == null) {
                            a(22);
                        }
                        return iVarB;
                    }
                    if (i2 == 3) {
                        i iVarD = i.d("External condition");
                        if (iVarD == null) {
                            a(23);
                        }
                        return iVarD;
                    }
                }
            }
        }
        if (!z2) {
            return iVarI;
        }
        for (InterfaceC8487We2 interfaceC8487We22 : c) {
            if (interfaceC8487We22.b() == InterfaceC8487We2.a.CONFLICTS_ONLY) {
                int i3 = h.a[interfaceC8487We22.a(interfaceC14592iA0, interfaceC14592iA02, interfaceC21331tU0).ordinal()];
                if (i3 == 1) {
                    throw new IllegalStateException("Contract violation in " + interfaceC8487We22.getClass().getName() + " condition. It's not supposed to end with success");
                }
                if (i3 == 2) {
                    i iVarB2 = i.b("External condition failed");
                    if (iVarB2 == null) {
                        a(25);
                    }
                    return iVarB2;
                }
                if (i3 == 3) {
                    i iVarD2 = i.d("External condition");
                    if (iVarD2 == null) {
                        a(26);
                    }
                    return iVarD2;
                }
            }
        }
        i iVarE = i.e();
        if (iVarE == null) {
            a(27);
        }
        return iVarE;
    }

    public i I(InterfaceC14592iA0 interfaceC14592iA0, InterfaceC14592iA0 interfaceC14592iA02, boolean z) {
        if (interfaceC14592iA0 == null) {
            a(28);
        }
        if (interfaceC14592iA02 == null) {
            a(29);
        }
        i iVarZ = z(interfaceC14592iA0, interfaceC14592iA02);
        if (iVarZ != null) {
            return iVarZ;
        }
        List listI = i(interfaceC14592iA0);
        List listI2 = i(interfaceC14592iA02);
        List typeParameters = interfaceC14592iA0.getTypeParameters();
        List typeParameters2 = interfaceC14592iA02.getTypeParameters();
        int i2 = 0;
        if (typeParameters.size() != typeParameters2.size()) {
            while (i2 < listI.size()) {
                if (!InterfaceC4333Er3.a.c((AbstractC4099Dr3) listI.get(i2), (AbstractC4099Dr3) listI2.get(i2))) {
                    i iVarD = i.d("Type parameter number mismatch");
                    if (iVarD == null) {
                        a(31);
                    }
                    return iVarD;
                }
                i2++;
            }
            i iVarB = i.b("Type parameter number mismatch");
            if (iVarB == null) {
                a(32);
            }
            return iVarB;
        }
        XV4 xv4N = n(typeParameters, typeParameters2);
        for (int i3 = 0; i3 < typeParameters.size(); i3++) {
            if (!e((InterfaceC22882vy7) typeParameters.get(i3), (InterfaceC22882vy7) typeParameters2.get(i3), xv4N)) {
                i iVarD2 = i.d("Type parameter bounds mismatch");
                if (iVarD2 == null) {
                    a(33);
                }
                return iVarD2;
            }
        }
        while (i2 < listI.size()) {
            if (!f((AbstractC4099Dr3) listI.get(i2), (AbstractC4099Dr3) listI2.get(i2), xv4N)) {
                i iVarD3 = i.d("Value parameter type mismatch");
                if (iVarD3 == null) {
                    a(34);
                }
                return iVarD3;
            }
            i2++;
        }
        if ((interfaceC14592iA0 instanceof AB2) && (interfaceC14592iA02 instanceof AB2) && ((AB2) interfaceC14592iA0).isSuspend() != ((AB2) interfaceC14592iA02).isSuspend()) {
            i iVarB2 = i.b("Incompatible suspendability");
            if (iVarB2 == null) {
                a(35);
            }
            return iVarB2;
        }
        if (z) {
            AbstractC4099Dr3 returnType = interfaceC14592iA0.getReturnType();
            AbstractC4099Dr3 returnType2 = interfaceC14592iA02.getReturnType();
            if (returnType != null && returnType2 != null && ((!AbstractC4816Gr3.a(returnType2) || !AbstractC4816Gr3.a(returnType)) && !((C15041iu4) xv4N.e()).f((IU0) xv4N.f(), returnType2.N0(), returnType.N0()))) {
                i iVarB3 = i.b("Return type mismatch");
                if (iVarB3 == null) {
                    a(36);
                }
                return iVarB3;
            }
        }
        i iVarE = i.e();
        if (iVarE == null) {
            a(37);
        }
        return iVarE;
    }

    public void y(C6432No4 c6432No4, Collection collection, Collection collection2, InterfaceC21331tU0 interfaceC21331tU0, AbstractC10899cO4 abstractC10899cO4) {
        if (c6432No4 == null) {
            a(50);
        }
        if (collection == null) {
            a(51);
        }
        if (collection2 == null) {
            a(52);
        }
        if (interfaceC21331tU0 == null) {
            a(53);
        }
        if (abstractC10899cO4 == null) {
            a(54);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
        Iterator it = collection2.iterator();
        while (it.hasNext()) {
            linkedHashSet.removeAll(r((InterfaceC15194jA0) it.next(), collection, interfaceC21331tU0, abstractC10899cO4));
        }
        m(interfaceC21331tU0, linkedHashSet, abstractC10899cO4);
    }

    /* renamed from: ir.nasim.dO4$d */
    static class d implements UA2 {
        d() {
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public InterfaceC15194jA0 invoke(InterfaceC15194jA0 interfaceC15194jA0) {
            return interfaceC15194jA0;
        }
    }

    /* renamed from: ir.nasim.dO4$f */
    static class f implements UA2 {
        f() {
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public InterfaceC14592iA0 invoke(InterfaceC15194jA0 interfaceC15194jA0) {
            return interfaceC15194jA0;
        }
    }
}
