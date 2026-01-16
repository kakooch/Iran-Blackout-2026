package ir.nasim;

import ir.nasim.AB2;
import ir.nasim.AbstractC9416Zv3;
import ir.nasim.C11663dO4;
import ir.nasim.DE6;
import ir.nasim.InterfaceC20555sC6;
import ir.nasim.InterfaceC8047Uh3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: ir.nasim.Uv3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C8173Uv3 extends AbstractC9416Zv3 {
    private final InterfaceC21331tU0 n;
    private final InterfaceC7106Qh3 o;
    private final boolean p;
    private final InterfaceC23016wC4 q;
    private final InterfaceC23016wC4 r;
    private final InterfaceC23016wC4 s;
    private final J34 t;

    /* renamed from: ir.nasim.Uv3$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        public final boolean a(InterfaceC19648qi3 interfaceC19648qi3) {
            AbstractC13042fc3.i(interfaceC19648qi3, "it");
            return !interfaceC19648qi3.i();
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return Boolean.valueOf(a((InterfaceC19648qi3) obj));
        }
    }

    /* renamed from: ir.nasim.Uv3$b */
    /* synthetic */ class b extends DB2 implements UA2 {
        b(C8173Uv3 c8173Uv3) {
            super(1, c8173Uv3);
        }

        @Override // ir.nasim.AbstractC15785kA0, ir.nasim.InterfaceC9916am3
        public final String getName() {
            return "searchMethodsByNameWithoutBuiltinMagic";
        }

        @Override // ir.nasim.AbstractC15785kA0
        public final InterfaceC15551jm3 getOwner() {
            return AbstractC10882cM5.b(C8173Uv3.class);
        }

        @Override // ir.nasim.AbstractC15785kA0
        public final String getSignature() {
            return "searchMethodsByNameWithoutBuiltinMagic(Lorg/jetbrains/kotlin/name/Name;)Ljava/util/Collection;";
        }

        @Override // ir.nasim.UA2
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final Collection invoke(C6432No4 c6432No4) {
            AbstractC13042fc3.i(c6432No4, "p0");
            return ((C8173Uv3) this.receiver).H0(c6432No4);
        }
    }

    /* renamed from: ir.nasim.Uv3$c */
    /* synthetic */ class c extends DB2 implements UA2 {
        c(C8173Uv3 c8173Uv3) {
            super(1, c8173Uv3);
        }

        @Override // ir.nasim.AbstractC15785kA0, ir.nasim.InterfaceC9916am3
        public final String getName() {
            return "searchMethodsInSupertypesWithoutBuiltinMagic";
        }

        @Override // ir.nasim.AbstractC15785kA0
        public final InterfaceC15551jm3 getOwner() {
            return AbstractC10882cM5.b(C8173Uv3.class);
        }

        @Override // ir.nasim.AbstractC15785kA0
        public final String getSignature() {
            return "searchMethodsInSupertypesWithoutBuiltinMagic(Lorg/jetbrains/kotlin/name/Name;)Ljava/util/Collection;";
        }

        @Override // ir.nasim.UA2
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final Collection invoke(C6432No4 c6432No4) {
            AbstractC13042fc3.i(c6432No4, "p0");
            return ((C8173Uv3) this.receiver).I0(c6432No4);
        }
    }

    /* renamed from: ir.nasim.Uv3$d */
    static final class d extends AbstractC8614Ws3 implements UA2 {
        d() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Collection invoke(C6432No4 c6432No4) {
            AbstractC13042fc3.i(c6432No4, "it");
            return C8173Uv3.this.H0(c6432No4);
        }
    }

    /* renamed from: ir.nasim.Uv3$e */
    static final class e extends AbstractC8614Ws3 implements UA2 {
        e() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Collection invoke(C6432No4 c6432No4) {
            AbstractC13042fc3.i(c6432No4, "it");
            return C8173Uv3.this.I0(c6432No4);
        }
    }

    /* renamed from: ir.nasim.Uv3$f */
    static final class f extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ C9182Yv3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(C9182Yv3 c9182Yv3) {
            super(0);
            this.f = c9182Yv3;
        }

        @Override // ir.nasim.SA2
        public final List invoke() {
            Collection collectionK = C8173Uv3.this.o.k();
            ArrayList arrayList = new ArrayList(collectionK.size());
            Iterator it = collectionK.iterator();
            while (it.hasNext()) {
                arrayList.add(C8173Uv3.this.G0((InterfaceC9290Zh3) it.next()));
            }
            if (C8173Uv3.this.o.p()) {
                InterfaceC18329oU0 interfaceC18329oU0E0 = C8173Uv3.this.e0();
                String strC = AbstractC6597Oe4.c(interfaceC18329oU0E0, false, false, 2, null);
                if (arrayList.isEmpty()) {
                    arrayList.add(interfaceC18329oU0E0);
                    this.f.a().g().d(C8173Uv3.this.o, interfaceC18329oU0E0);
                } else {
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        if (AbstractC13042fc3.d(AbstractC6597Oe4.c((InterfaceC18329oU0) it2.next(), false, false, 2, null), strC)) {
                            break;
                        }
                    }
                    arrayList.add(interfaceC18329oU0E0);
                    this.f.a().g().d(C8173Uv3.this.o, interfaceC18329oU0E0);
                }
            }
            C18173oC6 c18173oC6Q = this.f.a().q();
            C9182Yv3 c9182Yv3 = this.f;
            C8173Uv3 c8173Uv3 = C8173Uv3.this;
            boolean zIsEmpty = arrayList.isEmpty();
            Collection collectionQ = arrayList;
            if (zIsEmpty) {
                collectionQ = AbstractC10360bX0.q(c8173Uv3.d0());
            }
            return AbstractC15401jX0.m1(c18173oC6Q.e(c9182Yv3, collectionQ));
        }
    }

    /* renamed from: ir.nasim.Uv3$g */
    static final class g extends AbstractC8614Ws3 implements SA2 {
        g() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Map invoke() {
            Collection collectionX = C8173Uv3.this.o.x();
            ArrayList arrayList = new ArrayList();
            for (Object obj : collectionX) {
                if (((InterfaceC14921ii3) obj).K()) {
                    arrayList.add(obj);
                }
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(AbstractC23053wG5.e(AbstractC19460qO3.f(AbstractC10976cX0.x(arrayList, 10)), 16));
            for (Object obj2 : arrayList) {
                linkedHashMap.put(((InterfaceC14921ii3) obj2).getName(), obj2);
            }
            return linkedHashMap;
        }
    }

    /* renamed from: ir.nasim.Uv3$h */
    static final class h extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ JC6 e;
        final /* synthetic */ C8173Uv3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(JC6 jc6, C8173Uv3 c8173Uv3) {
            super(1);
            this.e = jc6;
            this.f = c8173Uv3;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Collection invoke(C6432No4 c6432No4) {
            AbstractC13042fc3.i(c6432No4, "accessorName");
            return AbstractC13042fc3.d(this.e.getName(), c6432No4) ? AbstractC9766aX0.e(this.e) : AbstractC15401jX0.R0(this.f.H0(c6432No4), this.f.I0(c6432No4));
        }
    }

    /* renamed from: ir.nasim.Uv3$i */
    static final class i extends AbstractC8614Ws3 implements SA2 {
        i() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Set invoke() {
            return AbstractC15401jX0.r1(C8173Uv3.this.o.B());
        }
    }

    /* renamed from: ir.nasim.Uv3$j */
    static final class j extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C9182Yv3 f;

        /* renamed from: ir.nasim.Uv3$j$a */
        static final class a extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ C8173Uv3 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C8173Uv3 c8173Uv3) {
                super(0);
                this.e = c8173Uv3;
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Set invoke() {
                return AbstractC4846Gu6.l(this.e.a(), this.e.c());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(C9182Yv3 c9182Yv3) {
            super(1);
            this.f = c9182Yv3;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC21988uU0 invoke(C6432No4 c6432No4) {
            AbstractC13042fc3.i(c6432No4, "name");
            if (!((Set) C8173Uv3.this.r.invoke()).contains(c6432No4)) {
                InterfaceC14921ii3 interfaceC14921ii3 = (InterfaceC14921ii3) ((Map) C8173Uv3.this.s.invoke()).get(c6432No4);
                if (interfaceC14921ii3 == null) {
                    return null;
                }
                return J92.K0(this.f.e(), C8173Uv3.this.C(), c6432No4, this.f.e().c(new a(C8173Uv3.this)), AbstractC7700Sv3.a(this.f, interfaceC14921ii3), this.f.a().s().a(interfaceC14921ii3));
            }
            InterfaceC8047Uh3 interfaceC8047Uh3D = this.f.a().d();
            C24948zU0 c24948zU0H = PI1.h(C8173Uv3.this.C());
            AbstractC13042fc3.f(c24948zU0H);
            C24948zU0 c24948zU0D = c24948zU0H.d(c6432No4);
            AbstractC13042fc3.h(c24948zU0D, "ownerDescriptor.classId!!.createNestedClassId(name)");
            InterfaceC7106Qh3 interfaceC7106Qh3B = interfaceC8047Uh3D.b(new InterfaceC8047Uh3.a(c24948zU0D, null, C8173Uv3.this.o, 2, null));
            if (interfaceC7106Qh3B == null) {
                return null;
            }
            C9182Yv3 c9182Yv3 = this.f;
            C7939Tv3 c7939Tv3 = new C7939Tv3(c9182Yv3, C8173Uv3.this.C(), interfaceC7106Qh3B, null, 8, null);
            c9182Yv3.a().e().a(c7939Tv3);
            return c7939Tv3;
        }
    }

    public /* synthetic */ C8173Uv3(C9182Yv3 c9182Yv3, InterfaceC21331tU0 interfaceC21331tU0, InterfaceC7106Qh3 interfaceC7106Qh3, boolean z, C8173Uv3 c8173Uv3, int i2, ED1 ed1) {
        this(c9182Yv3, interfaceC21331tU0, interfaceC7106Qh3, z, (i2 & 16) != 0 ? null : c8173Uv3);
    }

    private final boolean A0(JC6 jc6, AB2 ab2) {
        String strC = AbstractC6597Oe4.c(jc6, false, false, 2, null);
        AB2 ab2A = ab2.a();
        AbstractC13042fc3.h(ab2A, "builtinWithErasedParameters.original");
        return AbstractC13042fc3.d(strC, AbstractC6597Oe4.c(ab2A, false, false, 2, null)) && !o0(jc6, ab2);
    }

    private final boolean B0(JC6 jc6) {
        C6432No4 name = jc6.getName();
        AbstractC13042fc3.h(name, "function.name");
        List listA = AbstractC18017nw5.a(name);
        if (!(listA instanceof Collection) || !listA.isEmpty()) {
            Iterator it = listA.iterator();
            while (it.hasNext()) {
                Set<InterfaceC20989sw5> setZ0 = z0((C6432No4) it.next());
                if (!(setZ0 instanceof Collection) || !setZ0.isEmpty()) {
                    for (InterfaceC20989sw5 interfaceC20989sw5 : setZ0) {
                        if (n0(interfaceC20989sw5, new h(jc6, this))) {
                            if (!interfaceC20989sw5.P()) {
                                C23341wl3 c23341wl3 = C23341wl3.a;
                                String strH = jc6.getName().h();
                                AbstractC13042fc3.h(strH, "function.name.asString()");
                                if (!C23341wl3.c(strH)) {
                                }
                            }
                            return false;
                        }
                    }
                }
            }
        }
        return (p0(jc6) || J0(jc6) || r0(jc6)) ? false : true;
    }

    private final JC6 C0(JC6 jc6, UA2 ua2, Collection collection) {
        JC6 jc6G0;
        AB2 ab2K = C17912nm0.k(jc6);
        if (ab2K == null || (jc6G0 = g0(ab2K, ua2)) == null) {
            return null;
        }
        if (!B0(jc6G0)) {
            jc6G0 = null;
        }
        if (jc6G0 == null) {
            return null;
        }
        return f0(jc6G0, ab2K, collection);
    }

    private final JC6 D0(JC6 jc6, UA2 ua2, C6432No4 c6432No4, Collection collection) {
        JC6 jc62 = (JC6) AbstractC21886uI6.d(jc6);
        if (jc62 == null) {
            return null;
        }
        String strB = AbstractC21886uI6.b(jc62);
        AbstractC13042fc3.f(strB);
        C6432No4 c6432No4P = C6432No4.p(strB);
        AbstractC13042fc3.h(c6432No4P, "identifier(nameInJava)");
        Iterator it = ((Collection) ua2.invoke(c6432No4P)).iterator();
        while (it.hasNext()) {
            JC6 jc6L0 = l0((JC6) it.next(), c6432No4);
            if (q0(jc62, jc6L0)) {
                return f0(jc6L0, jc62, collection);
            }
        }
        return null;
    }

    private final JC6 E0(JC6 jc6, UA2 ua2) {
        if (!jc6.isSuspend()) {
            return null;
        }
        C6432No4 name = jc6.getName();
        AbstractC13042fc3.h(name, "descriptor.name");
        Iterator it = ((Iterable) ua2.invoke(name)).iterator();
        while (it.hasNext()) {
            JC6 jc6M0 = m0((JC6) it.next());
            if (jc6M0 == null || !o0(jc6M0, jc6)) {
                jc6M0 = null;
            }
            if (jc6M0 != null) {
                return jc6M0;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C7340Rh3 G0(InterfaceC9290Zh3 interfaceC9290Zh3) {
        InterfaceC21331tU0 interfaceC21331tU0C = C();
        C7340Rh3 c7340Rh3R1 = C7340Rh3.r1(interfaceC21331tU0C, AbstractC7700Sv3.a(w(), interfaceC9290Zh3), false, w().a().s().a(interfaceC9290Zh3));
        AbstractC13042fc3.h(c7340Rh3R1, "createJavaConstructor(\n            classDescriptor,\n            c.resolveAnnotations(constructor), /* isPrimary = */\n            false,\n            c.components.sourceElementFactory.source(constructor)\n        )");
        C9182Yv3 c9182Yv3E = AbstractC4760Gl1.e(w(), c7340Rh3R1, interfaceC9290Zh3, interfaceC21331tU0C.q().size());
        AbstractC9416Zv3.b bVarK = K(c9182Yv3E, c7340Rh3R1, interfaceC9290Zh3.h());
        List listQ = interfaceC21331tU0C.q();
        AbstractC13042fc3.h(listQ, "classDescriptor.declaredTypeParameters");
        List list = listQ;
        List typeParameters = interfaceC9290Zh3.getTypeParameters();
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(typeParameters, 10));
        Iterator it = typeParameters.iterator();
        while (it.hasNext()) {
            InterfaceC22882vy7 interfaceC22882vy7A = c9182Yv3E.f().a((InterfaceC7583Si3) it.next());
            AbstractC13042fc3.f(interfaceC22882vy7A);
            arrayList.add(interfaceC22882vy7A);
        }
        c7340Rh3R1.p1(bVarK.a(), AbstractC22522vN7.b(interfaceC9290Zh3.getVisibility()), AbstractC15401jX0.R0(list, arrayList));
        c7340Rh3R1.X0(false);
        c7340Rh3R1.Y0(bVarK.b());
        c7340Rh3R1.f1(interfaceC21331tU0C.p());
        c9182Yv3E.a().g().d(interfaceC9290Zh3, c7340Rh3R1);
        return c7340Rh3R1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Collection H0(C6432No4 c6432No4) {
        Collection collectionF = ((InterfaceC17568nB1) y().invoke()).f(c6432No4);
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(collectionF, 10));
        Iterator it = collectionF.iterator();
        while (it.hasNext()) {
            arrayList.add(I((InterfaceC20257ri3) it.next()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Collection I0(C6432No4 c6432No4) {
        Set setX0 = x0(c6432No4);
        ArrayList arrayList = new ArrayList();
        for (Object obj : setX0) {
            JC6 jc6 = (JC6) obj;
            if (!AbstractC21886uI6.a(jc6) && C17912nm0.k(jc6) == null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final boolean J0(JC6 jc6) {
        C17912nm0 c17912nm0 = C17912nm0.n;
        C6432No4 name = jc6.getName();
        AbstractC13042fc3.h(name, "name");
        if (!c17912nm0.l(name)) {
            return false;
        }
        C6432No4 name2 = jc6.getName();
        AbstractC13042fc3.h(name2, "name");
        Set setX0 = x0(name2);
        ArrayList arrayList = new ArrayList();
        Iterator it = setX0.iterator();
        while (it.hasNext()) {
            AB2 ab2K = C17912nm0.k((JC6) it.next());
            if (ab2K != null) {
                arrayList.add(ab2K);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            if (A0(jc6, (AB2) it2.next())) {
                return true;
            }
        }
        return false;
    }

    private final void U(List list, InterfaceC21426te1 interfaceC21426te1, int i2, InterfaceC20257ri3 interfaceC20257ri3, AbstractC4099Dr3 abstractC4099Dr3, AbstractC4099Dr3 abstractC4099Dr32) {
        InterfaceC4356Eu interfaceC4356EuB = InterfaceC4356Eu.W.b();
        C6432No4 name = interfaceC20257ri3.getName();
        AbstractC4099Dr3 abstractC4099Dr3N = AbstractC7497Ry7.n(abstractC4099Dr3);
        AbstractC13042fc3.h(abstractC4099Dr3N, "makeNotNullable(returnType)");
        list.add(new AQ7(interfaceC21426te1, null, i2, interfaceC4356EuB, name, abstractC4099Dr3N, interfaceC20257ri3.O(), false, false, abstractC4099Dr32 == null ? null : AbstractC7497Ry7.n(abstractC4099Dr32), w().a().s().a(interfaceC20257ri3)));
    }

    private final void V(Collection collection, C6432No4 c6432No4, Collection collection2, boolean z) {
        Collection collectionD = KI1.d(c6432No4, collection2, collection, C(), w().a().c(), w().a().j().a());
        AbstractC13042fc3.h(collectionD, "resolveOverridesForNonStaticMembers(\n            name, functionsFromSupertypes, result, ownerDescriptor, c.components.errorReporter,\n            c.components.kotlinTypeChecker.overridingUtil\n        )");
        if (!z) {
            collection.addAll(collectionD);
            return;
        }
        Collection<JC6> collection3 = collectionD;
        List listR0 = AbstractC15401jX0.R0(collection, collection3);
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(collection3, 10));
        for (JC6 jc6F0 : collection3) {
            JC6 jc6 = (JC6) AbstractC21886uI6.e(jc6F0);
            if (jc6 == null) {
                AbstractC13042fc3.h(jc6F0, "resolvedOverride");
            } else {
                AbstractC13042fc3.h(jc6F0, "resolvedOverride");
                jc6F0 = f0(jc6F0, jc6, listR0);
            }
            arrayList.add(jc6F0);
        }
        collection.addAll(arrayList);
    }

    private final void W(C6432No4 c6432No4, Collection collection, Collection collection2, Collection collection3, UA2 ua2) {
        Iterator it = collection2.iterator();
        while (it.hasNext()) {
            JC6 jc6 = (JC6) it.next();
            YW0.a(collection3, D0(jc6, ua2, c6432No4, collection));
            YW0.a(collection3, C0(jc6, ua2, collection));
            YW0.a(collection3, E0(jc6, ua2));
        }
    }

    private final void X(Set set, Collection collection, Set set2, UA2 ua2) {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            InterfaceC20989sw5 interfaceC20989sw5 = (InterfaceC20989sw5) it.next();
            C24491yi3 c24491yi3H0 = h0(interfaceC20989sw5, ua2);
            if (c24491yi3H0 != null) {
                collection.add(c24491yi3H0);
                if (set2 == null) {
                    return;
                }
                set2.add(interfaceC20989sw5);
                return;
            }
        }
    }

    private final void Y(C6432No4 c6432No4, Collection collection) {
        InterfaceC20257ri3 interfaceC20257ri3 = (InterfaceC20257ri3) AbstractC15401jX0.W0(((InterfaceC17568nB1) y().invoke()).f(c6432No4));
        if (interfaceC20257ri3 == null) {
            return;
        }
        collection.add(j0(this, interfaceC20257ri3, null, EnumC11067cg4.FINAL, 2, null));
    }

    private final Collection b0() {
        if (!this.p) {
            return w().a().j().d().f(C());
        }
        Collection collectionB = C().j().b();
        AbstractC13042fc3.h(collectionB, "ownerDescriptor.typeConstructor.supertypes");
        return collectionB;
    }

    private final List c0(C18920pU0 c18920pU0) {
        XV4 xv4;
        Collection collectionC = this.o.C();
        ArrayList arrayList = new ArrayList(collectionC.size());
        C6637Oi3 c6637Oi3F = AbstractC8790Xi3.f(EnumC7263Qy7.COMMON, true, null, 2, null);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : collectionC) {
            if (AbstractC13042fc3.d(((InterfaceC20257ri3) obj).getName(), AbstractC24521yl3.c)) {
                arrayList2.add(obj);
            } else {
                arrayList3.add(obj);
            }
        }
        XV4 xv42 = new XV4(arrayList2, arrayList3);
        List list = (List) xv42.a();
        List<InterfaceC20257ri3> list2 = (List) xv42.b();
        list.size();
        InterfaceC20257ri3 interfaceC20257ri3 = (InterfaceC20257ri3) AbstractC15401jX0.s0(list);
        if (interfaceC20257ri3 != null) {
            InterfaceC6138Mi3 returnType = interfaceC20257ri3.getReturnType();
            if (returnType instanceof InterfaceC5896Lh3) {
                InterfaceC5896Lh3 interfaceC5896Lh3 = (InterfaceC5896Lh3) returnType;
                xv4 = new XV4(w().g().j(interfaceC5896Lh3, c6637Oi3F, true), w().g().n(interfaceC5896Lh3.m(), c6637Oi3F));
            } else {
                xv4 = new XV4(w().g().n(returnType, c6637Oi3F), null);
            }
            U(arrayList, c18920pU0, 0, interfaceC20257ri3, (AbstractC4099Dr3) xv4.a(), (AbstractC4099Dr3) xv4.b());
        }
        int i2 = 0;
        int i3 = interfaceC20257ri3 == null ? 0 : 1;
        for (InterfaceC20257ri3 interfaceC20257ri32 : list2) {
            U(arrayList, c18920pU0, i2 + i3, interfaceC20257ri32, w().g().n(interfaceC20257ri32.getReturnType(), c6637Oi3F), null);
            i2++;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC18329oU0 d0() {
        boolean zN = this.o.n();
        if ((this.o.L() || !this.o.q()) && !zN) {
            return null;
        }
        InterfaceC21331tU0 interfaceC21331tU0C = C();
        C7340Rh3 c7340Rh3R1 = C7340Rh3.r1(interfaceC21331tU0C, InterfaceC4356Eu.W.b(), true, w().a().s().a(this.o));
        AbstractC13042fc3.h(c7340Rh3R1, "createJavaConstructor(\n            classDescriptor, Annotations.EMPTY, /* isPrimary = */ true, c.components.sourceElementFactory.source(jClass)\n        )");
        List listC0 = zN ? c0(c7340Rh3R1) : Collections.emptyList();
        c7340Rh3R1.Y0(false);
        c7340Rh3R1.o1(listC0, v0(interfaceC21331tU0C));
        c7340Rh3R1.X0(true);
        c7340Rh3R1.f1(interfaceC21331tU0C.p());
        w().a().g().d(this.o, c7340Rh3R1);
        return c7340Rh3R1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC18329oU0 e0() {
        InterfaceC21331tU0 interfaceC21331tU0C = C();
        C7340Rh3 c7340Rh3R1 = C7340Rh3.r1(interfaceC21331tU0C, InterfaceC4356Eu.W.b(), true, w().a().s().a(this.o));
        AbstractC13042fc3.h(c7340Rh3R1, "createJavaConstructor(\n            classDescriptor, Annotations.EMPTY, /* isPrimary = */ true, c.components.sourceElementFactory.source(jClass)\n        )");
        List listK0 = k0(c7340Rh3R1);
        c7340Rh3R1.Y0(false);
        c7340Rh3R1.o1(listK0, v0(interfaceC21331tU0C));
        c7340Rh3R1.X0(false);
        c7340Rh3R1.f1(interfaceC21331tU0C.p());
        return c7340Rh3R1;
    }

    private final JC6 f0(JC6 jc6, InterfaceC14592iA0 interfaceC14592iA0, Collection collection) {
        Collection<JC6> collection2 = collection;
        if ((collection2 instanceof Collection) && collection2.isEmpty()) {
            return jc6;
        }
        for (JC6 jc62 : collection2) {
            if (!AbstractC13042fc3.d(jc6, jc62) && jc62.s0() == null && o0(jc62, interfaceC14592iA0)) {
                JC6 jc63 = (JC6) jc6.t().j().a();
                AbstractC13042fc3.f(jc63);
                return jc63;
            }
        }
        return jc6;
    }

    private final JC6 g0(AB2 ab2, UA2 ua2) {
        Object next;
        C6432No4 name = ab2.getName();
        AbstractC13042fc3.h(name, "overridden.name");
        Iterator it = ((Iterable) ua2.invoke(name)).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (A0((JC6) next, ab2)) {
                break;
            }
        }
        JC6 jc6 = (JC6) next;
        if (jc6 == null) {
            return null;
        }
        AB2.a aVarT = jc6.t();
        List listH = ab2.h();
        AbstractC13042fc3.h(listH, "overridden.valueParameters");
        List<InterfaceC24919zQ7> list = listH;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        for (InterfaceC24919zQ7 interfaceC24919zQ7 : list) {
            AbstractC4099Dr3 type = interfaceC24919zQ7.getType();
            AbstractC13042fc3.h(type, "it.type");
            arrayList.add(new C24325yQ7(type, interfaceC24919zQ7.y0()));
        }
        List listH2 = jc6.h();
        AbstractC13042fc3.h(listH2, "override.valueParameters");
        aVarT.c(AbstractC14118hN7.a(arrayList, listH2, ab2));
        aVarT.t();
        aVarT.m();
        return (JC6) aVarT.a();
    }

    private final C24491yi3 h0(InterfaceC20989sw5 interfaceC20989sw5, UA2 ua2) {
        JC6 jc6U0;
        C4380Ew5 c4380Ew5J = null;
        if (!n0(interfaceC20989sw5, ua2)) {
            return null;
        }
        JC6 jc6T0 = t0(interfaceC20989sw5, ua2);
        AbstractC13042fc3.f(jc6T0);
        if (interfaceC20989sw5.P()) {
            jc6U0 = u0(interfaceC20989sw5, ua2);
            AbstractC13042fc3.f(jc6U0);
        } else {
            jc6U0 = null;
        }
        if (jc6U0 != null) {
            jc6U0.r();
            jc6T0.r();
        }
        C16102ki3 c16102ki3 = new C16102ki3(C(), jc6T0, jc6U0, interfaceC20989sw5);
        AbstractC4099Dr3 returnType = jc6T0.getReturnType();
        AbstractC13042fc3.f(returnType);
        c16102ki3.Y0(returnType, AbstractC10360bX0.m(), z(), null);
        C22862vw5 c22862vw5H = AbstractC23657xI1.h(c16102ki3, jc6T0.getAnnotations(), false, false, false, jc6T0.i());
        c22862vw5H.L0(jc6T0);
        c22862vw5H.O0(c16102ki3.getType());
        AbstractC13042fc3.h(c22862vw5H, "createGetter(\n            propertyDescriptor, getterMethod.annotations, /* isDefault = */false,\n            /* isExternal = */ false, /* isInline = */ false, getterMethod.source\n        ).apply {\n            initialSignatureDescriptor = getterMethod\n            initialize(propertyDescriptor.type)\n        }");
        if (jc6U0 != null) {
            List listH = jc6U0.h();
            AbstractC13042fc3.h(listH, "setterMethod.valueParameters");
            InterfaceC24919zQ7 interfaceC24919zQ7 = (InterfaceC24919zQ7) AbstractC15401jX0.s0(listH);
            if (interfaceC24919zQ7 == null) {
                throw new AssertionError(AbstractC13042fc3.q("No parameter found for ", jc6U0));
            }
            c4380Ew5J = AbstractC23657xI1.j(c16102ki3, jc6U0.getAnnotations(), interfaceC24919zQ7.getAnnotations(), false, false, false, jc6U0.getVisibility(), jc6U0.i());
            c4380Ew5J.L0(jc6U0);
        }
        c16102ki3.S0(c22862vw5H, c4380Ew5J);
        return c16102ki3;
    }

    private final C24491yi3 i0(InterfaceC20257ri3 interfaceC20257ri3, AbstractC4099Dr3 abstractC4099Dr3, EnumC11067cg4 enumC11067cg4) {
        C24491yi3 c24491yi3A1 = C24491yi3.a1(C(), AbstractC7700Sv3.a(w(), interfaceC20257ri3), enumC11067cg4, AbstractC22522vN7.b(interfaceC20257ri3.getVisibility()), false, interfaceC20257ri3.getName(), w().a().s().a(interfaceC20257ri3), false);
        AbstractC13042fc3.h(c24491yi3A1, "create(\n            ownerDescriptor, annotations, modality, method.visibility.toDescriptorVisibility(),\n            /* isVar = */ false, method.name, c.components.sourceElementFactory.source(method),\n            /* isStaticFinal = */ false\n        )");
        C22862vw5 c22862vw5B = AbstractC23657xI1.b(c24491yi3A1, InterfaceC4356Eu.W.b());
        AbstractC13042fc3.h(c22862vw5B, "createDefaultGetter(propertyDescriptor, Annotations.EMPTY)");
        c24491yi3A1.S0(c22862vw5B, null);
        AbstractC4099Dr3 abstractC4099Dr3Q = abstractC4099Dr3 == null ? q(interfaceC20257ri3, AbstractC4760Gl1.f(w(), c24491yi3A1, interfaceC20257ri3, 0, 4, null)) : abstractC4099Dr3;
        c24491yi3A1.Y0(abstractC4099Dr3Q, AbstractC10360bX0.m(), z(), null);
        c22862vw5B.O0(abstractC4099Dr3Q);
        return c24491yi3A1;
    }

    static /* synthetic */ C24491yi3 j0(C8173Uv3 c8173Uv3, InterfaceC20257ri3 interfaceC20257ri3, AbstractC4099Dr3 abstractC4099Dr3, EnumC11067cg4 enumC11067cg4, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            abstractC4099Dr3 = null;
        }
        return c8173Uv3.i0(interfaceC20257ri3, abstractC4099Dr3, enumC11067cg4);
    }

    private final List k0(C18920pU0 c18920pU0) {
        Collection collectionL = this.o.l();
        ArrayList arrayList = new ArrayList(collectionL.size());
        AbstractC8790Xi3.f(EnumC7263Qy7.COMMON, false, null, 2, null);
        Iterator it = collectionL.iterator();
        if (!it.hasNext()) {
            return arrayList;
        }
        AbstractC18350oW3.a(it.next());
        w().g();
        throw null;
    }

    private final JC6 l0(JC6 jc6, C6432No4 c6432No4) {
        AB2.a aVarT = jc6.t();
        aVarT.l(c6432No4);
        aVarT.t();
        aVarT.m();
        JC6 jc62 = (JC6) aVarT.a();
        AbstractC13042fc3.f(jc62);
        return jc62;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final ir.nasim.JC6 m0(ir.nasim.JC6 r6) {
        /*
            r5 = this;
            java.util.List r0 = r6.h()
            java.lang.String r1 = "valueParameters"
            ir.nasim.AbstractC13042fc3.h(r0, r1)
            java.lang.Object r0 = ir.nasim.ZW0.F0(r0)
            ir.nasim.zQ7 r0 = (ir.nasim.InterfaceC24919zQ7) r0
            r2 = 0
            if (r0 != 0) goto L14
        L12:
            r0 = r2
            goto L51
        L14:
            ir.nasim.Dr3 r3 = r0.getType()
            ir.nasim.gy7 r3 = r3.K0()
            ir.nasim.MU0 r3 = r3.t()
            if (r3 != 0) goto L24
            r3 = r2
            goto L28
        L24:
            ir.nasim.ax2 r3 = ir.nasim.PI1.j(r3)
        L28:
            if (r3 != 0) goto L2c
        L2a:
            r3 = r2
            goto L3b
        L2c:
            boolean r4 = r3.f()
            if (r4 == 0) goto L33
            goto L34
        L33:
            r3 = r2
        L34:
            if (r3 != 0) goto L37
            goto L2a
        L37:
            ir.nasim.Zw2 r3 = r3.l()
        L3b:
            ir.nasim.Yv3 r4 = r5.w()
            ir.nasim.Ci3 r4 = r4.a()
            ir.nasim.Di3 r4 = r4.p()
            boolean r4 = r4.c()
            boolean r3 = ir.nasim.AbstractC19268q37.a(r3, r4)
            if (r3 == 0) goto L12
        L51:
            if (r0 != 0) goto L54
            return r2
        L54:
            ir.nasim.AB2$a r2 = r6.t()
            java.util.List r6 = r6.h()
            ir.nasim.AbstractC13042fc3.h(r6, r1)
            r1 = 1
            java.util.List r6 = ir.nasim.ZW0.l0(r6, r1)
            ir.nasim.AB2$a r6 = r2.c(r6)
            ir.nasim.Dr3 r0 = r0.getType()
            java.util.List r0 = r0.J0()
            r2 = 0
            java.lang.Object r0 = r0.get(r2)
            ir.nasim.Cy7 r0 = (ir.nasim.InterfaceC3932Cy7) r0
            ir.nasim.Dr3 r0 = r0.getType()
            ir.nasim.AB2$a r6 = r6.f(r0)
            ir.nasim.AB2 r6 = r6.a()
            ir.nasim.JC6 r6 = (ir.nasim.JC6) r6
            r0 = r6
            ir.nasim.KC6 r0 = (ir.nasim.KC6) r0
            if (r0 != 0) goto L8b
            goto L8e
        L8b:
            r0.g1(r1)
        L8e:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C8173Uv3.m0(ir.nasim.JC6):ir.nasim.JC6");
    }

    private final boolean n0(InterfaceC20989sw5 interfaceC20989sw5, UA2 ua2) {
        if (AbstractC12493ei3.a(interfaceC20989sw5)) {
            return false;
        }
        JC6 jc6T0 = t0(interfaceC20989sw5, ua2);
        JC6 jc6U0 = u0(interfaceC20989sw5, ua2);
        if (jc6T0 == null) {
            return false;
        }
        if (interfaceC20989sw5.P()) {
            return jc6U0 != null && jc6U0.r() == jc6T0.r();
        }
        return true;
    }

    private final boolean o0(InterfaceC14592iA0 interfaceC14592iA0, InterfaceC14592iA0 interfaceC14592iA02) {
        C11663dO4.i.a aVarC = C11663dO4.d.I(interfaceC14592iA02, interfaceC14592iA0, true).c();
        AbstractC13042fc3.h(aVarC, "DEFAULT.isOverridableByWithoutExternalConditions(superDescriptor, this, true).result");
        return aVarC == C11663dO4.i.a.OVERRIDABLE && !C17875ni3.a.a(interfaceC14592iA02, interfaceC14592iA0);
    }

    private final boolean p0(JC6 jc6) {
        C17321mm0 c17321mm0 = C17321mm0.n;
        C6432No4 name = jc6.getName();
        AbstractC13042fc3.h(name, "name");
        List<C6432No4> listI = c17321mm0.i(name);
        if ((listI instanceof Collection) && listI.isEmpty()) {
            return false;
        }
        for (C6432No4 c6432No4 : listI) {
            Set setX0 = x0(c6432No4);
            ArrayList arrayList = new ArrayList();
            for (Object obj : setX0) {
                if (AbstractC21886uI6.a((JC6) obj)) {
                    arrayList.add(obj);
                }
            }
            if (!arrayList.isEmpty()) {
                JC6 jc6L0 = l0(jc6, c6432No4);
                if (arrayList.isEmpty()) {
                    continue;
                } else {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (q0((JC6) it.next(), jc6L0)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private final boolean q0(JC6 jc6, AB2 ab2) {
        if (C17321mm0.n.m(jc6)) {
            ab2 = ab2.a();
        }
        AbstractC13042fc3.h(ab2, "if (superDescriptor.isRemoveAtByIndex) subDescriptor.original else subDescriptor");
        return o0(ab2, jc6);
    }

    private final boolean r0(JC6 jc6) {
        JC6 jc6M0 = m0(jc6);
        if (jc6M0 == null) {
            return false;
        }
        C6432No4 name = jc6.getName();
        AbstractC13042fc3.h(name, "name");
        Set<JC6> setX0 = x0(name);
        if ((setX0 instanceof Collection) && setX0.isEmpty()) {
            return false;
        }
        for (JC6 jc62 : setX0) {
            if (jc62.isSuspend() && o0(jc6M0, jc62)) {
                return true;
            }
        }
        return false;
    }

    private final JC6 s0(InterfaceC20989sw5 interfaceC20989sw5, String str, UA2 ua2) {
        JC6 jc6;
        C6432No4 c6432No4P = C6432No4.p(str);
        AbstractC13042fc3.h(c6432No4P, "identifier(getterName)");
        Iterator it = ((Iterable) ua2.invoke(c6432No4P)).iterator();
        do {
            jc6 = null;
            if (!it.hasNext()) {
                break;
            }
            JC6 jc62 = (JC6) it.next();
            if (jc62.h().size() == 0) {
                InterfaceC4333Er3 interfaceC4333Er3 = InterfaceC4333Er3.a;
                AbstractC4099Dr3 returnType = jc62.getReturnType();
                if (returnType == null ? false : interfaceC4333Er3.b(returnType, interfaceC20989sw5.getType())) {
                    jc6 = jc62;
                }
            }
        } while (jc6 == null);
        return jc6;
    }

    private final JC6 t0(InterfaceC20989sw5 interfaceC20989sw5, UA2 ua2) {
        InterfaceC22266uw5 interfaceC22266uw5G = interfaceC20989sw5.g();
        InterfaceC22266uw5 interfaceC22266uw5 = interfaceC22266uw5G == null ? null : (InterfaceC22266uw5) AbstractC21886uI6.d(interfaceC22266uw5G);
        String strA = interfaceC22266uw5 != null ? HU0.a.a(interfaceC22266uw5) : null;
        if (strA != null && !AbstractC21886uI6.f(C(), interfaceC22266uw5)) {
            return s0(interfaceC20989sw5, strA, ua2);
        }
        C23341wl3 c23341wl3 = C23341wl3.a;
        String strH = interfaceC20989sw5.getName().h();
        AbstractC13042fc3.h(strH, "name.asString()");
        return s0(interfaceC20989sw5, C23341wl3.a(strH), ua2);
    }

    private final JC6 u0(InterfaceC20989sw5 interfaceC20989sw5, UA2 ua2) {
        JC6 jc6;
        AbstractC4099Dr3 returnType;
        C23341wl3 c23341wl3 = C23341wl3.a;
        String strH = interfaceC20989sw5.getName().h();
        AbstractC13042fc3.h(strH, "name.asString()");
        C6432No4 c6432No4P = C6432No4.p(C23341wl3.d(strH));
        AbstractC13042fc3.h(c6432No4P, "identifier(JvmAbi.setterName(name.asString()))");
        Iterator it = ((Iterable) ua2.invoke(c6432No4P)).iterator();
        do {
            jc6 = null;
            if (!it.hasNext()) {
                break;
            }
            JC6 jc62 = (JC6) it.next();
            if (jc62.h().size() == 1 && (returnType = jc62.getReturnType()) != null && AbstractC19738qr3.J0(returnType)) {
                InterfaceC4333Er3 interfaceC4333Er3 = InterfaceC4333Er3.a;
                List listH = jc62.h();
                AbstractC13042fc3.h(listH, "descriptor.valueParameters");
                if (interfaceC4333Er3.c(((InterfaceC24919zQ7) AbstractC15401jX0.V0(listH)).getType(), interfaceC20989sw5.getType())) {
                    jc6 = jc62;
                }
            }
        } while (jc6 == null);
        return jc6;
    }

    private final RI1 v0(InterfaceC21331tU0 interfaceC21331tU0) {
        RI1 visibility = interfaceC21331tU0.getVisibility();
        AbstractC13042fc3.h(visibility, "classDescriptor.visibility");
        if (!AbstractC13042fc3.d(visibility, AbstractC13129fi3.b)) {
            return visibility;
        }
        RI1 ri1 = AbstractC13129fi3.c;
        AbstractC13042fc3.h(ri1, "PROTECTED_AND_PACKAGE");
        return ri1;
    }

    private final Set x0(C6432No4 c6432No4) {
        Collection collectionB0 = b0();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = collectionB0.iterator();
        while (it.hasNext()) {
            AbstractC13610gX0.D(linkedHashSet, ((AbstractC4099Dr3) it.next()).o().d(c6432No4, FA4.WHEN_GET_SUPER_MEMBERS));
        }
        return linkedHashSet;
    }

    private final Set z0(C6432No4 c6432No4) {
        Collection collectionB0 = b0();
        ArrayList arrayList = new ArrayList();
        Iterator it = collectionB0.iterator();
        while (it.hasNext()) {
            Collection collectionB = ((AbstractC4099Dr3) it.next()).o().b(c6432No4, FA4.WHEN_GET_SUPER_MEMBERS);
            ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(collectionB, 10));
            Iterator it2 = collectionB.iterator();
            while (it2.hasNext()) {
                arrayList2.add((InterfaceC20989sw5) it2.next());
            }
            AbstractC13610gX0.D(arrayList, arrayList2);
        }
        return AbstractC15401jX0.r1(arrayList);
    }

    public void F0(C6432No4 c6432No4, IJ3 ij3) {
        AbstractC13042fc3.i(c6432No4, "name");
        AbstractC13042fc3.i(ij3, "location");
        AbstractC21932uN7.a(w().a().k(), ij3, C(), c6432No4);
    }

    @Override // ir.nasim.AbstractC9416Zv3
    protected boolean G(C20848si3 c20848si3) {
        AbstractC13042fc3.i(c20848si3, "<this>");
        if (this.o.n()) {
            return false;
        }
        return B0(c20848si3);
    }

    @Override // ir.nasim.AbstractC9416Zv3
    protected AbstractC9416Zv3.a H(InterfaceC20257ri3 interfaceC20257ri3, List list, AbstractC4099Dr3 abstractC4099Dr3, List list2) {
        AbstractC13042fc3.i(interfaceC20257ri3, "method");
        AbstractC13042fc3.i(list, "methodTypeParameters");
        AbstractC13042fc3.i(abstractC4099Dr3, "returnType");
        AbstractC13042fc3.i(list2, "valueParameters");
        InterfaceC20555sC6.b bVarB = w().a().r().b(interfaceC20257ri3, C(), abstractC4099Dr3, null, list2, list);
        AbstractC13042fc3.h(bVarB, "c.components.signaturePropagator.resolvePropagatedSignature(\n            method, ownerDescriptor, returnType, null, valueParameters, methodTypeParameters\n        )");
        AbstractC4099Dr3 abstractC4099Dr3D = bVarB.d();
        AbstractC13042fc3.h(abstractC4099Dr3D, "propagated.returnType");
        AbstractC4099Dr3 abstractC4099Dr3C = bVarB.c();
        List listF = bVarB.f();
        AbstractC13042fc3.h(listF, "propagated.valueParameters");
        List listE = bVarB.e();
        AbstractC13042fc3.h(listE, "propagated.typeParameters");
        boolean zG = bVarB.g();
        List listB = bVarB.b();
        AbstractC13042fc3.h(listB, "propagated.errors");
        return new AbstractC9416Zv3.a(abstractC4099Dr3D, abstractC4099Dr3C, listF, listE, zG, listB);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC9416Zv3
    /* renamed from: Z, reason: merged with bridge method [inline-methods] */
    public LinkedHashSet n(C24841zI1 c24841zI1, UA2 ua2) {
        AbstractC13042fc3.i(c24841zI1, "kindFilter");
        Collection collectionB = C().j().b();
        AbstractC13042fc3.h(collectionB, "ownerDescriptor.typeConstructor.supertypes");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = collectionB.iterator();
        while (it.hasNext()) {
            AbstractC13610gX0.D(linkedHashSet, ((AbstractC4099Dr3) it.next()).o().a());
        }
        linkedHashSet.addAll(((InterfaceC17568nB1) y().invoke()).a());
        linkedHashSet.addAll(((InterfaceC17568nB1) y().invoke()).c());
        linkedHashSet.addAll(l(c24841zI1, ua2));
        return linkedHashSet;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC9416Zv3
    /* renamed from: a0, reason: merged with bridge method [inline-methods] */
    public C20711sU0 p() {
        return new C20711sU0(this.o, a.e);
    }

    @Override // ir.nasim.AbstractC9416Zv3, ir.nasim.X24, ir.nasim.W24
    public Collection b(C6432No4 c6432No4, IJ3 ij3) {
        AbstractC13042fc3.i(c6432No4, "name");
        AbstractC13042fc3.i(ij3, "location");
        F0(c6432No4, ij3);
        return super.b(c6432No4, ij3);
    }

    @Override // ir.nasim.AbstractC9416Zv3, ir.nasim.X24, ir.nasim.W24
    public Collection d(C6432No4 c6432No4, IJ3 ij3) {
        AbstractC13042fc3.i(c6432No4, "name");
        AbstractC13042fc3.i(ij3, "location");
        F0(c6432No4, ij3);
        return super.d(c6432No4, ij3);
    }

    @Override // ir.nasim.X24, ir.nasim.InterfaceC22011uW5
    public MU0 e(C6432No4 c6432No4, IJ3 ij3) {
        J34 j34;
        AbstractC13042fc3.i(c6432No4, "name");
        AbstractC13042fc3.i(ij3, "location");
        F0(c6432No4, ij3);
        C8173Uv3 c8173Uv3 = (C8173Uv3) B();
        AbstractC21988uU0 abstractC21988uU0 = null;
        if (c8173Uv3 != null && (j34 = c8173Uv3.t) != null) {
            abstractC21988uU0 = (AbstractC21988uU0) j34.invoke(c6432No4);
        }
        return abstractC21988uU0 == null ? (MU0) this.t.invoke(c6432No4) : abstractC21988uU0;
    }

    @Override // ir.nasim.AbstractC9416Zv3
    protected Set l(C24841zI1 c24841zI1, UA2 ua2) {
        AbstractC13042fc3.i(c24841zI1, "kindFilter");
        return AbstractC4846Gu6.l((Set) this.r.invoke(), ((Map) this.s.invoke()).keySet());
    }

    @Override // ir.nasim.AbstractC9416Zv3
    protected void o(Collection collection, C6432No4 c6432No4) {
        AbstractC13042fc3.i(collection, "result");
        AbstractC13042fc3.i(c6432No4, "name");
        if (this.o.p()) {
            ((InterfaceC17568nB1) y().invoke()).b(c6432No4);
        }
    }

    @Override // ir.nasim.AbstractC9416Zv3
    protected void r(Collection collection, C6432No4 c6432No4) {
        AbstractC13042fc3.i(collection, "result");
        AbstractC13042fc3.i(c6432No4, "name");
        Set setX0 = x0(c6432No4);
        if (!C17321mm0.n.k(c6432No4) && !C17912nm0.n.l(c6432No4)) {
            Set set = setX0;
            if (!(set instanceof Collection) || !set.isEmpty()) {
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    if (((AB2) it.next()).isSuspend()) {
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : set) {
                if (B0((JC6) obj)) {
                    arrayList.add(obj);
                }
            }
            V(collection, c6432No4, arrayList, false);
            return;
        }
        DE6 de6A = DE6.c.a();
        Collection collectionD = KI1.d(c6432No4, setX0, AbstractC10360bX0.m(), C(), InterfaceC11005ca2.a, w().a().j().a());
        AbstractC13042fc3.h(collectionD, "resolveOverridesForNonStaticMembers(\n            name, functionsFromSupertypes, emptyList(), ownerDescriptor, ErrorReporter.DO_NOTHING,\n            c.components.kotlinTypeChecker.overridingUtil\n        )");
        W(c6432No4, collection, collectionD, collection, new b(this));
        W(c6432No4, collection, collectionD, de6A, new c(this));
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : setX0) {
            if (B0((JC6) obj2)) {
                arrayList2.add(obj2);
            }
        }
        V(collection, c6432No4, AbstractC15401jX0.R0(arrayList2, de6A), true);
    }

    @Override // ir.nasim.AbstractC9416Zv3
    protected void s(C6432No4 c6432No4, Collection collection) {
        AbstractC13042fc3.i(c6432No4, "name");
        AbstractC13042fc3.i(collection, "result");
        if (this.o.n()) {
            Y(c6432No4, collection);
        }
        Set setZ0 = z0(c6432No4);
        if (setZ0.isEmpty()) {
            return;
        }
        DE6.b bVar = DE6.c;
        DE6 de6A = bVar.a();
        DE6 de6A2 = bVar.a();
        X(setZ0, collection, de6A, new d());
        X(AbstractC4846Gu6.j(setZ0, de6A), de6A2, null, new e());
        Collection collectionD = KI1.d(c6432No4, AbstractC4846Gu6.l(setZ0, de6A2), collection, C(), w().a().c(), w().a().j().a());
        AbstractC13042fc3.h(collectionD, "resolveOverridesForNonStaticMembers(\n                name,\n                propertiesFromSupertypes + propertiesOverridesFromSuperTypes,\n                result,\n                ownerDescriptor,\n                c.components.errorReporter,\n                c.components.kotlinTypeChecker.overridingUtil\n            )");
        collection.addAll(collectionD);
    }

    @Override // ir.nasim.AbstractC9416Zv3
    protected Set t(C24841zI1 c24841zI1, UA2 ua2) {
        AbstractC13042fc3.i(c24841zI1, "kindFilter");
        if (this.o.n()) {
            return a();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(((InterfaceC17568nB1) y().invoke()).e());
        Collection collectionB = C().j().b();
        AbstractC13042fc3.h(collectionB, "ownerDescriptor.typeConstructor.supertypes");
        Iterator it = collectionB.iterator();
        while (it.hasNext()) {
            AbstractC13610gX0.D(linkedHashSet, ((AbstractC4099Dr3) it.next()).o().c());
        }
        return linkedHashSet;
    }

    @Override // ir.nasim.AbstractC9416Zv3
    public String toString() {
        return AbstractC13042fc3.q("Lazy Java member scope for ", this.o.e());
    }

    public final InterfaceC23016wC4 w0() {
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC9416Zv3
    /* renamed from: y0, reason: merged with bridge method [inline-methods] */
    public InterfaceC21331tU0 C() {
        return this.n;
    }

    @Override // ir.nasim.AbstractC9416Zv3
    protected ZI5 z() {
        return OI1.l(C());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8173Uv3(C9182Yv3 c9182Yv3, InterfaceC21331tU0 interfaceC21331tU0, InterfaceC7106Qh3 interfaceC7106Qh3, boolean z, C8173Uv3 c8173Uv3) {
        super(c9182Yv3, c8173Uv3);
        AbstractC13042fc3.i(c9182Yv3, "c");
        AbstractC13042fc3.i(interfaceC21331tU0, "ownerDescriptor");
        AbstractC13042fc3.i(interfaceC7106Qh3, "jClass");
        this.n = interfaceC21331tU0;
        this.o = interfaceC7106Qh3;
        this.p = z;
        this.q = c9182Yv3.e().c(new f(c9182Yv3));
        this.r = c9182Yv3.e().c(new i());
        this.s = c9182Yv3.e().c(new g());
        this.t = c9182Yv3.e().b(new j(c9182Yv3));
    }
}
