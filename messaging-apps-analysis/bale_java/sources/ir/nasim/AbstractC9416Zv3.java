package ir.nasim;

import ir.nasim.AbstractC24247yI1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* renamed from: ir.nasim.Zv3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC9416Zv3 extends X24 {
    static final /* synthetic */ InterfaceC5239Im3[] m = {AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(AbstractC9416Zv3.class), "functionNamesLazy", "getFunctionNamesLazy()Ljava/util/Set;")), AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(AbstractC9416Zv3.class), "propertyNamesLazy", "getPropertyNamesLazy()Ljava/util/Set;")), AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(AbstractC9416Zv3.class), "classNamesLazy", "getClassNamesLazy()Ljava/util/Set;"))};
    private final C9182Yv3 b;
    private final AbstractC9416Zv3 c;
    private final InterfaceC23016wC4 d;
    private final InterfaceC23016wC4 e;
    private final I34 f;
    private final J34 g;
    private final I34 h;
    private final InterfaceC23016wC4 i;
    private final InterfaceC23016wC4 j;
    private final InterfaceC23016wC4 k;
    private final I34 l;

    /* renamed from: ir.nasim.Zv3$a */
    protected static final class a {
        private final AbstractC4099Dr3 a;
        private final AbstractC4099Dr3 b;
        private final List c;
        private final List d;
        private final boolean e;
        private final List f;

        public a(AbstractC4099Dr3 abstractC4099Dr3, AbstractC4099Dr3 abstractC4099Dr32, List list, List list2, boolean z, List list3) {
            AbstractC13042fc3.i(abstractC4099Dr3, "returnType");
            AbstractC13042fc3.i(list, "valueParameters");
            AbstractC13042fc3.i(list2, "typeParameters");
            AbstractC13042fc3.i(list3, "errors");
            this.a = abstractC4099Dr3;
            this.b = abstractC4099Dr32;
            this.c = list;
            this.d = list2;
            this.e = z;
            this.f = list3;
        }

        public final List a() {
            return this.f;
        }

        public final boolean b() {
            return this.e;
        }

        public final AbstractC4099Dr3 c() {
            return this.b;
        }

        public final AbstractC4099Dr3 d() {
            return this.a;
        }

        public final List e() {
            return this.d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return AbstractC13042fc3.d(this.a, aVar.a) && AbstractC13042fc3.d(this.b, aVar.b) && AbstractC13042fc3.d(this.c, aVar.c) && AbstractC13042fc3.d(this.d, aVar.d) && this.e == aVar.e && AbstractC13042fc3.d(this.f, aVar.f);
        }

        public final List f() {
            return this.c;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int iHashCode = this.a.hashCode() * 31;
            AbstractC4099Dr3 abstractC4099Dr3 = this.b;
            int iHashCode2 = (((((iHashCode + (abstractC4099Dr3 == null ? 0 : abstractC4099Dr3.hashCode())) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
            boolean z = this.e;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            return ((iHashCode2 + i) * 31) + this.f.hashCode();
        }

        public String toString() {
            return "MethodSignatureData(returnType=" + this.a + ", receiverType=" + this.b + ", valueParameters=" + this.c + ", typeParameters=" + this.d + ", hasStableParameterNames=" + this.e + ", errors=" + this.f + ')';
        }
    }

    /* renamed from: ir.nasim.Zv3$b */
    protected static final class b {
        private final List a;
        private final boolean b;

        public b(List list, boolean z) {
            AbstractC13042fc3.i(list, "descriptors");
            this.a = list;
            this.b = z;
        }

        public final List a() {
            return this.a;
        }

        public final boolean b() {
            return this.b;
        }
    }

    /* renamed from: ir.nasim.Zv3$c */
    static final class c extends AbstractC8614Ws3 implements SA2 {
        c() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Collection invoke() {
            return AbstractC9416Zv3.this.m(C24841zI1.o, W24.a.a());
        }
    }

    /* renamed from: ir.nasim.Zv3$d */
    static final class d extends AbstractC8614Ws3 implements SA2 {
        d() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Set invoke() {
            return AbstractC9416Zv3.this.l(C24841zI1.t, null);
        }
    }

    /* renamed from: ir.nasim.Zv3$e */
    static final class e extends AbstractC8614Ws3 implements UA2 {
        e() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC20989sw5 invoke(C6432No4 c6432No4) {
            AbstractC13042fc3.i(c6432No4, "name");
            if (AbstractC9416Zv3.this.B() != null) {
                return (InterfaceC20989sw5) AbstractC9416Zv3.this.B().g.invoke(c6432No4);
            }
            InterfaceC14921ii3 interfaceC14921ii3D = ((InterfaceC17568nB1) AbstractC9416Zv3.this.y().invoke()).d(c6432No4);
            if (interfaceC14921ii3D == null || interfaceC14921ii3D.K()) {
                return null;
            }
            return AbstractC9416Zv3.this.J(interfaceC14921ii3D);
        }
    }

    /* renamed from: ir.nasim.Zv3$f */
    static final class f extends AbstractC8614Ws3 implements UA2 {
        f() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Collection invoke(C6432No4 c6432No4) {
            AbstractC13042fc3.i(c6432No4, "name");
            if (AbstractC9416Zv3.this.B() != null) {
                return (Collection) AbstractC9416Zv3.this.B().f.invoke(c6432No4);
            }
            ArrayList arrayList = new ArrayList();
            for (InterfaceC20257ri3 interfaceC20257ri3 : ((InterfaceC17568nB1) AbstractC9416Zv3.this.y().invoke()).f(c6432No4)) {
                C20848si3 c20848si3I = AbstractC9416Zv3.this.I(interfaceC20257ri3);
                if (AbstractC9416Zv3.this.G(c20848si3I)) {
                    AbstractC9416Zv3.this.w().a().g().b(interfaceC20257ri3, c20848si3I);
                    arrayList.add(c20848si3I);
                }
            }
            AbstractC9416Zv3.this.o(arrayList, c6432No4);
            return arrayList;
        }
    }

    /* renamed from: ir.nasim.Zv3$g */
    static final class g extends AbstractC8614Ws3 implements SA2 {
        g() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC17568nB1 invoke() {
            return AbstractC9416Zv3.this.p();
        }
    }

    /* renamed from: ir.nasim.Zv3$h */
    static final class h extends AbstractC8614Ws3 implements SA2 {
        h() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Set invoke() {
            return AbstractC9416Zv3.this.n(C24841zI1.v, null);
        }
    }

    /* renamed from: ir.nasim.Zv3$i */
    static final class i extends AbstractC8614Ws3 implements UA2 {
        i() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Collection invoke(C6432No4 c6432No4) {
            AbstractC13042fc3.i(c6432No4, "name");
            LinkedHashSet linkedHashSet = new LinkedHashSet((Collection) AbstractC9416Zv3.this.f.invoke(c6432No4));
            AbstractC9416Zv3.this.L(linkedHashSet);
            AbstractC9416Zv3.this.r(linkedHashSet, c6432No4);
            return AbstractC15401jX0.m1(AbstractC9416Zv3.this.w().a().q().e(AbstractC9416Zv3.this.w(), linkedHashSet));
        }
    }

    /* renamed from: ir.nasim.Zv3$j */
    static final class j extends AbstractC8614Ws3 implements UA2 {
        j() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List invoke(C6432No4 c6432No4) {
            AbstractC13042fc3.i(c6432No4, "name");
            ArrayList arrayList = new ArrayList();
            YW0.a(arrayList, AbstractC9416Zv3.this.g.invoke(c6432No4));
            AbstractC9416Zv3.this.s(c6432No4, arrayList);
            return OI1.t(AbstractC9416Zv3.this.C()) ? AbstractC15401jX0.m1(arrayList) : AbstractC15401jX0.m1(AbstractC9416Zv3.this.w().a().q().e(AbstractC9416Zv3.this.w(), arrayList));
        }
    }

    /* renamed from: ir.nasim.Zv3$k */
    static final class k extends AbstractC8614Ws3 implements SA2 {
        k() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Set invoke() {
            return AbstractC9416Zv3.this.t(C24841zI1.w, null);
        }
    }

    /* renamed from: ir.nasim.Zv3$l */
    static final class l extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC14921ii3 f;
        final /* synthetic */ C21676tw5 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(InterfaceC14921ii3 interfaceC14921ii3, C21676tw5 c21676tw5) {
            super(0);
            this.f = interfaceC14921ii3;
            this.g = c21676tw5;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC7068Qd1 invoke() {
            return AbstractC9416Zv3.this.w().a().f().a(this.f, this.g);
        }
    }

    /* renamed from: ir.nasim.Zv3$m */
    static final class m extends AbstractC8614Ws3 implements UA2 {
        public static final m e = new m();

        m() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC14592iA0 invoke(JC6 jc6) {
            AbstractC13042fc3.i(jc6, "<this>");
            return jc6;
        }
    }

    public /* synthetic */ AbstractC9416Zv3(C9182Yv3 c9182Yv3, AbstractC9416Zv3 abstractC9416Zv3, int i2, ED1 ed1) {
        this(c9182Yv3, (i2 & 2) != 0 ? null : abstractC9416Zv3);
    }

    private final Set A() {
        return (Set) MN6.a(this.i, this, m[0]);
    }

    private final Set D() {
        return (Set) MN6.a(this.j, this, m[1]);
    }

    private final AbstractC4099Dr3 E(InterfaceC14921ii3 interfaceC14921ii3) {
        AbstractC4099Dr3 abstractC4099Dr3N = this.b.g().n(interfaceC14921ii3.getType(), AbstractC8790Xi3.f(EnumC7263Qy7.COMMON, false, null, 3, null));
        if ((!AbstractC19738qr3.y0(abstractC4099Dr3N) && !AbstractC19738qr3.C0(abstractC4099Dr3N)) || !F(interfaceC14921ii3) || !interfaceC14921ii3.P()) {
            return abstractC4099Dr3N;
        }
        AbstractC4099Dr3 abstractC4099Dr3N2 = AbstractC7497Ry7.n(abstractC4099Dr3N);
        AbstractC13042fc3.h(abstractC4099Dr3N2, "makeNotNullable(propertyType)");
        return abstractC4099Dr3N2;
    }

    private final boolean F(InterfaceC14921ii3 interfaceC14921ii3) {
        return interfaceC14921ii3.isFinal() && interfaceC14921ii3.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC20989sw5 J(InterfaceC14921ii3 interfaceC14921ii3) {
        C21676tw5 c21676tw5U = u(interfaceC14921ii3);
        c21676tw5U.T0(null, null, null, null);
        c21676tw5U.Y0(E(interfaceC14921ii3), AbstractC10360bX0.m(), z(), null);
        if (OI1.K(c21676tw5U, c21676tw5U.getType())) {
            c21676tw5U.J0(this.b.e().g(new l(interfaceC14921ii3, c21676tw5U)));
        }
        this.b.a().g().e(interfaceC14921ii3, c21676tw5U);
        return c21676tw5U;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L(Set set) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : set) {
            String strC = AbstractC6597Oe4.c((JC6) obj, false, false, 2, null);
            Object arrayList = linkedHashMap.get(strC);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(strC, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        for (List list : linkedHashMap.values()) {
            if (list.size() != 1) {
                List list2 = list;
                Collection collectionA = AbstractC12306eO4.a(list2, m.e);
                set.removeAll(list2);
                set.addAll(collectionA);
            }
        }
    }

    private final C21676tw5 u(InterfaceC14921ii3 interfaceC14921ii3) {
        C24491yi3 c24491yi3A1 = C24491yi3.a1(C(), AbstractC7700Sv3.a(this.b, interfaceC14921ii3), EnumC11067cg4.FINAL, AbstractC22522vN7.b(interfaceC14921ii3.getVisibility()), !interfaceC14921ii3.isFinal(), interfaceC14921ii3.getName(), this.b.a().s().a(interfaceC14921ii3), F(interfaceC14921ii3));
        AbstractC13042fc3.h(c24491yi3A1, "create(\n            ownerDescriptor, annotations, Modality.FINAL, field.visibility.toDescriptorVisibility(), isVar, field.name,\n            c.components.sourceElementFactory.source(field), /* isConst = */ field.isFinalStatic\n        )");
        return c24491yi3A1;
    }

    private final Set x() {
        return (Set) MN6.a(this.k, this, m[2]);
    }

    protected final AbstractC9416Zv3 B() {
        return this.c;
    }

    protected abstract InterfaceC12795fB1 C();

    protected boolean G(C20848si3 c20848si3) {
        AbstractC13042fc3.i(c20848si3, "<this>");
        return true;
    }

    protected abstract a H(InterfaceC20257ri3 interfaceC20257ri3, List list, AbstractC4099Dr3 abstractC4099Dr3, List list2);

    protected final C20848si3 I(InterfaceC20257ri3 interfaceC20257ri3) {
        AbstractC13042fc3.i(interfaceC20257ri3, "method");
        InterfaceC4356Eu interfaceC4356EuA = AbstractC7700Sv3.a(this.b, interfaceC20257ri3);
        InterfaceC12795fB1 interfaceC12795fB1C = C();
        C6432No4 name = interfaceC20257ri3.getName();
        InterfaceC4486Fi3 interfaceC4486Fi3A = this.b.a().s().a(interfaceC20257ri3);
        ((InterfaceC17568nB1) this.e.invoke()).b(interfaceC20257ri3.getName());
        C20848si3 c20848si3O1 = C20848si3.o1(interfaceC12795fB1C, interfaceC4356EuA, name, interfaceC4486Fi3A, false);
        AbstractC13042fc3.h(c20848si3O1, "createJavaMethod(\n            ownerDescriptor, annotations, method.name, c.components.sourceElementFactory.source(method),\n            declaredMemberIndex().findRecordComponentByName(method.name) != null && method.valueParameters.isEmpty()\n        )");
        C9182Yv3 c9182Yv3F = AbstractC4760Gl1.f(this.b, c20848si3O1, interfaceC20257ri3, 0, 4, null);
        List typeParameters = interfaceC20257ri3.getTypeParameters();
        List arrayList = new ArrayList(AbstractC10976cX0.x(typeParameters, 10));
        Iterator it = typeParameters.iterator();
        while (it.hasNext()) {
            InterfaceC22882vy7 interfaceC22882vy7A = c9182Yv3F.f().a((InterfaceC7583Si3) it.next());
            AbstractC13042fc3.f(interfaceC22882vy7A);
            arrayList.add(interfaceC22882vy7A);
        }
        b bVarK = K(c9182Yv3F, c20848si3O1, interfaceC20257ri3.h());
        a aVarH = H(interfaceC20257ri3, arrayList, q(interfaceC20257ri3, c9182Yv3F), bVarK.a());
        AbstractC4099Dr3 abstractC4099Dr3C = aVarH.c();
        c20848si3O1.n1(abstractC4099Dr3C == null ? null : AbstractC23657xI1.f(c20848si3O1, abstractC4099Dr3C, InterfaceC4356Eu.W.b()), z(), aVarH.e(), aVarH.f(), aVarH.d(), EnumC11067cg4.a.a(false, interfaceC20257ri3.isAbstract(), !interfaceC20257ri3.isFinal()), AbstractC22522vN7.b(interfaceC20257ri3.getVisibility()), aVarH.c() != null ? AbstractC19460qO3.g(AbstractC4616Fw7.a(C20848si3.J, AbstractC15401jX0.q0(bVarK.a()))) : AbstractC20051rO3.k());
        c20848si3O1.r1(aVarH.b(), bVarK.b());
        if (!aVarH.a().isEmpty()) {
            c9182Yv3F.a().r().a(c20848si3O1, aVarH.a());
        }
        return c20848si3O1;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final ir.nasim.AbstractC9416Zv3.b K(ir.nasim.C9182Yv3 r23, ir.nasim.AB2 r24, java.util.List r25) {
        /*
            Method dump skipped, instructions count: 374
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC9416Zv3.K(ir.nasim.Yv3, ir.nasim.AB2, java.util.List):ir.nasim.Zv3$b");
    }

    @Override // ir.nasim.X24, ir.nasim.W24
    public Set a() {
        return A();
    }

    @Override // ir.nasim.X24, ir.nasim.W24
    public Collection b(C6432No4 c6432No4, IJ3 ij3) {
        AbstractC13042fc3.i(c6432No4, "name");
        AbstractC13042fc3.i(ij3, "location");
        return !c().contains(c6432No4) ? AbstractC10360bX0.m() : (Collection) this.l.invoke(c6432No4);
    }

    @Override // ir.nasim.X24, ir.nasim.W24
    public Set c() {
        return D();
    }

    @Override // ir.nasim.X24, ir.nasim.W24
    public Collection d(C6432No4 c6432No4, IJ3 ij3) {
        AbstractC13042fc3.i(c6432No4, "name");
        AbstractC13042fc3.i(ij3, "location");
        return !a().contains(c6432No4) ? AbstractC10360bX0.m() : (Collection) this.h.invoke(c6432No4);
    }

    @Override // ir.nasim.X24, ir.nasim.InterfaceC22011uW5
    public Collection f(C24841zI1 c24841zI1, UA2 ua2) {
        AbstractC13042fc3.i(c24841zI1, "kindFilter");
        AbstractC13042fc3.i(ua2, "nameFilter");
        return (Collection) this.d.invoke();
    }

    @Override // ir.nasim.X24, ir.nasim.W24
    public Set g() {
        return x();
    }

    protected abstract Set l(C24841zI1 c24841zI1, UA2 ua2);

    protected final List m(C24841zI1 c24841zI1, UA2 ua2) {
        AbstractC13042fc3.i(c24841zI1, "kindFilter");
        AbstractC13042fc3.i(ua2, "nameFilter");
        FA4 fa4 = FA4.WHEN_GET_ALL_DESCRIPTORS;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (c24841zI1.a(C24841zI1.c.d())) {
            for (C6432No4 c6432No4 : l(c24841zI1, ua2)) {
                if (((Boolean) ua2.invoke(c6432No4)).booleanValue()) {
                    YW0.a(linkedHashSet, e(c6432No4, fa4));
                }
            }
        }
        if (c24841zI1.a(C24841zI1.c.e()) && !c24841zI1.n().contains(AbstractC24247yI1.a.a)) {
            for (C6432No4 c6432No42 : n(c24841zI1, ua2)) {
                if (((Boolean) ua2.invoke(c6432No42)).booleanValue()) {
                    linkedHashSet.addAll(d(c6432No42, fa4));
                }
            }
        }
        if (c24841zI1.a(C24841zI1.c.k()) && !c24841zI1.n().contains(AbstractC24247yI1.a.a)) {
            for (C6432No4 c6432No43 : t(c24841zI1, ua2)) {
                if (((Boolean) ua2.invoke(c6432No43)).booleanValue()) {
                    linkedHashSet.addAll(b(c6432No43, fa4));
                }
            }
        }
        return AbstractC15401jX0.m1(linkedHashSet);
    }

    protected abstract Set n(C24841zI1 c24841zI1, UA2 ua2);

    protected void o(Collection collection, C6432No4 c6432No4) {
        AbstractC13042fc3.i(collection, "result");
        AbstractC13042fc3.i(c6432No4, "name");
    }

    protected abstract InterfaceC17568nB1 p();

    protected final AbstractC4099Dr3 q(InterfaceC20257ri3 interfaceC20257ri3, C9182Yv3 c9182Yv3) {
        AbstractC13042fc3.i(interfaceC20257ri3, "method");
        AbstractC13042fc3.i(c9182Yv3, "c");
        return c9182Yv3.g().n(interfaceC20257ri3.getReturnType(), AbstractC8790Xi3.f(EnumC7263Qy7.COMMON, interfaceC20257ri3.Q().n(), null, 2, null));
    }

    protected abstract void r(Collection collection, C6432No4 c6432No4);

    protected abstract void s(C6432No4 c6432No4, Collection collection);

    protected abstract Set t(C24841zI1 c24841zI1, UA2 ua2);

    public String toString() {
        return AbstractC13042fc3.q("Lazy scope for ", C());
    }

    protected final InterfaceC23016wC4 v() {
        return this.d;
    }

    protected final C9182Yv3 w() {
        return this.b;
    }

    protected final InterfaceC23016wC4 y() {
        return this.e;
    }

    protected abstract ZI5 z();

    public AbstractC9416Zv3(C9182Yv3 c9182Yv3, AbstractC9416Zv3 abstractC9416Zv3) {
        AbstractC13042fc3.i(c9182Yv3, "c");
        this.b = c9182Yv3;
        this.c = abstractC9416Zv3;
        this.d = c9182Yv3.e().d(new c(), AbstractC10360bX0.m());
        this.e = c9182Yv3.e().c(new g());
        this.f = c9182Yv3.e().e(new f());
        this.g = c9182Yv3.e().b(new e());
        this.h = c9182Yv3.e().e(new i());
        this.i = c9182Yv3.e().c(new h());
        this.j = c9182Yv3.e().c(new k());
        this.k = c9182Yv3.e().c(new d());
        this.l = c9182Yv3.e().e(new j());
    }
}
