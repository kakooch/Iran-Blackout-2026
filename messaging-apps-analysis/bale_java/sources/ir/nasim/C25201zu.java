package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: ir.nasim.zu, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C25201zu {
    private final C7115Qi3 a;
    private final J34 b;

    /* renamed from: ir.nasim.zu$a */
    public static final class a {
        private final InterfaceC21651tu a;
        private final int b;

        public a(InterfaceC21651tu interfaceC21651tu, int i) {
            AbstractC13042fc3.i(interfaceC21651tu, "typeQualifier");
            this.a = interfaceC21651tu;
            this.b = i;
        }

        private final boolean c(EnumC23427wu enumC23427wu) {
            return ((1 << enumC23427wu.ordinal()) & this.b) != 0;
        }

        private final boolean d(EnumC23427wu enumC23427wu) {
            if (c(enumC23427wu)) {
                return true;
            }
            return c(EnumC23427wu.TYPE_USE) && enumC23427wu != EnumC23427wu.TYPE_PARAMETER_BOUNDS;
        }

        public final InterfaceC21651tu a() {
            return this.a;
        }

        public final List b() {
            EnumC23427wu[] enumC23427wuArrValuesCustom = EnumC23427wu.valuesCustom();
            ArrayList arrayList = new ArrayList();
            for (EnumC23427wu enumC23427wu : enumC23427wuArrValuesCustom) {
                if (d(enumC23427wu)) {
                    arrayList.add(enumC23427wu);
                }
            }
            return arrayList;
        }
    }

    /* renamed from: ir.nasim.zu$b */
    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final b e = new b();

        b() {
            super(2);
        }

        public final boolean a(N92 n92, EnumC23427wu enumC23427wu) {
            AbstractC13042fc3.i(n92, "<this>");
            AbstractC13042fc3.i(enumC23427wu, "it");
            return AbstractC13042fc3.d(n92.c().j(), enumC23427wu.a());
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return Boolean.valueOf(a((N92) obj, (EnumC23427wu) obj2));
        }
    }

    /* renamed from: ir.nasim.zu$c */
    static final class c extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        c() {
            super(2);
        }

        public final boolean a(N92 n92, EnumC23427wu enumC23427wu) {
            AbstractC13042fc3.i(n92, "<this>");
            AbstractC13042fc3.i(enumC23427wu, "it");
            return C25201zu.this.p(enumC23427wu.a()).contains(n92.c().j());
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return Boolean.valueOf(a((N92) obj, (EnumC23427wu) obj2));
        }
    }

    /* renamed from: ir.nasim.zu$d */
    /* synthetic */ class d extends DB2 implements UA2 {
        d(C25201zu c25201zu) {
            super(1, c25201zu);
        }

        @Override // ir.nasim.AbstractC15785kA0, ir.nasim.InterfaceC9916am3
        public final String getName() {
            return "computeTypeQualifierNickname";
        }

        @Override // ir.nasim.AbstractC15785kA0
        public final InterfaceC15551jm3 getOwner() {
            return AbstractC10882cM5.b(C25201zu.class);
        }

        @Override // ir.nasim.AbstractC15785kA0
        public final String getSignature() {
            return "computeTypeQualifierNickname(Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;)Lorg/jetbrains/kotlin/descriptors/annotations/AnnotationDescriptor;";
        }

        @Override // ir.nasim.UA2
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final InterfaceC21651tu invoke(InterfaceC21331tU0 interfaceC21331tU0) {
            AbstractC13042fc3.i(interfaceC21331tU0, "p0");
            return ((C25201zu) this.receiver).c(interfaceC21331tU0);
        }
    }

    public C25201zu(ON6 on6, C7115Qi3 c7115Qi3) {
        AbstractC13042fc3.i(on6, "storageManager");
        AbstractC13042fc3.i(c7115Qi3, "javaTypeEnhancementState");
        this.a = c7115Qi3;
        this.b = on6.b(new d(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC21651tu c(InterfaceC21331tU0 interfaceC21331tU0) {
        if (!interfaceC21331tU0.getAnnotations().M1(AbstractC24017xu.g())) {
            return null;
        }
        Iterator it = interfaceC21331tU0.getAnnotations().iterator();
        while (it.hasNext()) {
            InterfaceC21651tu interfaceC21651tuM = m((InterfaceC21651tu) it.next());
            if (interfaceC21651tuM != null) {
                return interfaceC21651tuM;
            }
        }
        return null;
    }

    private final List d(AbstractC7068Qd1 abstractC7068Qd1, InterfaceC14603iB2 interfaceC14603iB2) {
        EnumC23427wu enumC23427wu;
        if (abstractC7068Qd1 instanceof WJ) {
            Iterable iterable = (Iterable) ((WJ) abstractC7068Qd1).b();
            ArrayList arrayList = new ArrayList();
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                AbstractC13610gX0.D(arrayList, d((AbstractC7068Qd1) it.next(), interfaceC14603iB2));
            }
            return arrayList;
        }
        if (!(abstractC7068Qd1 instanceof N92)) {
            return AbstractC10360bX0.m();
        }
        EnumC23427wu[] enumC23427wuArrValuesCustom = EnumC23427wu.valuesCustom();
        int length = enumC23427wuArrValuesCustom.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                enumC23427wu = null;
                break;
            }
            enumC23427wu = enumC23427wuArrValuesCustom[i];
            if (((Boolean) interfaceC14603iB2.invoke(abstractC7068Qd1, enumC23427wu)).booleanValue()) {
                break;
            }
            i++;
        }
        return AbstractC10360bX0.q(enumC23427wu);
    }

    private final List e(AbstractC7068Qd1 abstractC7068Qd1) {
        return d(abstractC7068Qd1, b.e);
    }

    private final List f(AbstractC7068Qd1 abstractC7068Qd1) {
        return d(abstractC7068Qd1, new c());
    }

    private final EnumC23724xP5 g(InterfaceC21331tU0 interfaceC21331tU0) {
        InterfaceC21651tu interfaceC21651tuZ = interfaceC21331tU0.getAnnotations().z(AbstractC24017xu.d());
        AbstractC7068Qd1 abstractC7068Qd1B = interfaceC21651tuZ == null ? null : PI1.b(interfaceC21651tuZ);
        N92 n92 = abstractC7068Qd1B instanceof N92 ? (N92) abstractC7068Qd1B : null;
        if (n92 == null) {
            return null;
        }
        EnumC23724xP5 enumC23724xP5F = this.a.f();
        if (enumC23724xP5F != null) {
            return enumC23724xP5F;
        }
        String strH = n92.c().h();
        int iHashCode = strH.hashCode();
        if (iHashCode == -2137067054) {
            if (strH.equals("IGNORE")) {
                return EnumC23724xP5.IGNORE;
            }
            return null;
        }
        if (iHashCode == -1838656823) {
            if (strH.equals("STRICT")) {
                return EnumC23724xP5.STRICT;
            }
            return null;
        }
        if (iHashCode == 2656902 && strH.equals("WARN")) {
            return EnumC23724xP5.WARN;
        }
        return null;
    }

    private final EnumC23724xP5 i(InterfaceC21651tu interfaceC21651tu) {
        return AbstractC24017xu.c().containsKey(interfaceC21651tu.e()) ? this.a.e() : j(interfaceC21651tu);
    }

    private final InterfaceC21651tu o(InterfaceC21331tU0 interfaceC21331tU0) {
        if (interfaceC21331tU0.f() != AU0.ANNOTATION_CLASS) {
            return null;
        }
        return (InterfaceC21651tu) this.b.invoke(interfaceC21331tU0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List p(String str) {
        Set setB = C5428Jh3.a.b(str);
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(setB, 10));
        Iterator it = setB.iterator();
        while (it.hasNext()) {
            arrayList.add(((EnumC3865Cr3) it.next()).name());
        }
        return arrayList;
    }

    public final a h(InterfaceC21651tu interfaceC21651tu) {
        AbstractC13042fc3.i(interfaceC21651tu, "annotationDescriptor");
        InterfaceC21331tU0 interfaceC21331tU0F = PI1.f(interfaceC21651tu);
        if (interfaceC21331tU0F == null) {
            return null;
        }
        InterfaceC4356Eu annotations = interfaceC21331tU0F.getAnnotations();
        C9424Zw2 c9424Zw2 = AbstractC24521yl3.d;
        AbstractC13042fc3.h(c9424Zw2, "TARGET_ANNOTATION");
        InterfaceC21651tu interfaceC21651tuZ = annotations.z(c9424Zw2);
        if (interfaceC21651tuZ == null) {
            return null;
        }
        Map mapJ = interfaceC21651tuZ.j();
        ArrayList arrayList = new ArrayList();
        Iterator it = mapJ.entrySet().iterator();
        while (it.hasNext()) {
            AbstractC13610gX0.D(arrayList, f((AbstractC7068Qd1) ((Map.Entry) it.next()).getValue()));
        }
        Iterator it2 = arrayList.iterator();
        int iOrdinal = 0;
        while (it2.hasNext()) {
            iOrdinal |= 1 << ((EnumC23427wu) it2.next()).ordinal();
        }
        return new a(interfaceC21651tu, iOrdinal);
    }

    public final EnumC23724xP5 j(InterfaceC21651tu interfaceC21651tu) {
        AbstractC13042fc3.i(interfaceC21651tu, "annotationDescriptor");
        EnumC23724xP5 enumC23724xP5K = k(interfaceC21651tu);
        return enumC23724xP5K == null ? this.a.d() : enumC23724xP5K;
    }

    public final EnumC23724xP5 k(InterfaceC21651tu interfaceC21651tu) {
        AbstractC13042fc3.i(interfaceC21651tu, "annotationDescriptor");
        Map mapG = this.a.g();
        C9424Zw2 c9424Zw2E = interfaceC21651tu.e();
        EnumC23724xP5 enumC23724xP5 = (EnumC23724xP5) mapG.get(c9424Zw2E == null ? null : c9424Zw2E.b());
        if (enumC23724xP5 != null) {
            return enumC23724xP5;
        }
        InterfaceC21331tU0 interfaceC21331tU0F = PI1.f(interfaceC21651tu);
        if (interfaceC21331tU0F == null) {
            return null;
        }
        return g(interfaceC21331tU0F);
    }

    public final C9876ai3 l(InterfaceC21651tu interfaceC21651tu) {
        C9876ai3 c9876ai3;
        AbstractC13042fc3.i(interfaceC21651tu, "annotationDescriptor");
        if (this.a.a() || (c9876ai3 = (C9876ai3) AbstractC24017xu.a().get(interfaceC21651tu.e())) == null) {
            return null;
        }
        EnumC23724xP5 enumC23724xP5I = i(interfaceC21651tu);
        if (enumC23724xP5I == EnumC23724xP5.IGNORE) {
            enumC23724xP5I = null;
        }
        if (enumC23724xP5I == null) {
            return null;
        }
        return C9876ai3.b(c9876ai3, C14645iF4.b(c9876ai3.e(), null, enumC23724xP5I.p(), 1, null), null, false, 6, null);
    }

    public final InterfaceC21651tu m(InterfaceC21651tu interfaceC21651tu) {
        InterfaceC21331tU0 interfaceC21331tU0F;
        AbstractC13042fc3.i(interfaceC21651tu, "annotationDescriptor");
        if (this.a.b() || (interfaceC21331tU0F = PI1.f(interfaceC21651tu)) == null) {
            return null;
        }
        return AbstractC3415Au.b(interfaceC21331tU0F) ? interfaceC21651tu : o(interfaceC21331tU0F);
    }

    public final a n(InterfaceC21651tu interfaceC21651tu) {
        Object next;
        AbstractC13042fc3.i(interfaceC21651tu, "annotationDescriptor");
        if (this.a.b()) {
            return null;
        }
        InterfaceC21331tU0 interfaceC21331tU0F = PI1.f(interfaceC21651tu);
        if (interfaceC21331tU0F == null || !interfaceC21331tU0F.getAnnotations().M1(AbstractC24017xu.e())) {
            interfaceC21331tU0F = null;
        }
        if (interfaceC21331tU0F == null) {
            return null;
        }
        InterfaceC21331tU0 interfaceC21331tU0F2 = PI1.f(interfaceC21651tu);
        AbstractC13042fc3.f(interfaceC21331tU0F2);
        InterfaceC21651tu interfaceC21651tuZ = interfaceC21331tU0F2.getAnnotations().z(AbstractC24017xu.e());
        AbstractC13042fc3.f(interfaceC21651tuZ);
        Map mapJ = interfaceC21651tuZ.j();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : mapJ.entrySet()) {
            AbstractC13610gX0.D(arrayList, AbstractC13042fc3.d((C6432No4) entry.getKey(), AbstractC24521yl3.c) ? e((AbstractC7068Qd1) entry.getValue()) : AbstractC10360bX0.m());
        }
        Iterator it = arrayList.iterator();
        int iOrdinal = 0;
        while (it.hasNext()) {
            iOrdinal |= 1 << ((EnumC23427wu) it.next()).ordinal();
        }
        Iterator it2 = interfaceC21331tU0F.getAnnotations().iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            if (m((InterfaceC21651tu) next) != null) {
                break;
            }
        }
        InterfaceC21651tu interfaceC21651tu2 = (InterfaceC21651tu) next;
        if (interfaceC21651tu2 == null) {
            return null;
        }
        return new a(interfaceC21651tu2, iOrdinal);
    }
}
