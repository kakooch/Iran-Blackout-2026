package ir.nasim;

import ir.nasim.AB2;
import ir.nasim.AbstractC7955Tx1;
import ir.nasim.C11663dO4;
import ir.nasim.C3577Bl3;
import ir.nasim.DE6;
import ir.nasim.InterfaceC15194jA0;
import ir.nasim.W24;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* renamed from: ir.nasim.Cl3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C3811Cl3 implements InterfaceC15427ja, InterfaceC8256Ve5 {
    static final /* synthetic */ InterfaceC5239Im3[] h = {AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(C3811Cl3.class), "settings", "getSettings()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltIns$Settings;")), AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(C3811Cl3.class), "cloneableType", "getCloneableType()Lorg/jetbrains/kotlin/types/SimpleType;")), AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(C3811Cl3.class), "notConsideredDeprecation", "getNotConsideredDeprecation()Lorg/jetbrains/kotlin/descriptors/annotations/Annotations;"))};
    private final InterfaceC8507Wg4 a;
    private final C5437Ji3 b;
    private final InterfaceC23016wC4 c;
    private final AbstractC4099Dr3 d;
    private final InterfaceC23016wC4 e;
    private final InterfaceC20324rp0 f;
    private final InterfaceC23016wC4 g;

    /* renamed from: ir.nasim.Cl3$a */
    private enum a {
        HIDDEN,
        VISIBLE,
        NOT_CONSIDERED,
        DROP;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static a[] valuesCustom() {
            a[] aVarArrValuesCustom = values();
            a[] aVarArr = new a[aVarArrValuesCustom.length];
            System.arraycopy(aVarArrValuesCustom, 0, aVarArr, 0, aVarArrValuesCustom.length);
            return aVarArr;
        }
    }

    /* renamed from: ir.nasim.Cl3$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[a.valuesCustom().length];
            iArr[a.HIDDEN.ordinal()] = 1;
            iArr[a.NOT_CONSIDERED.ordinal()] = 2;
            iArr[a.DROP.ordinal()] = 3;
            iArr[a.VISIBLE.ordinal()] = 4;
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.Cl3$c */
    static final class c extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ ON6 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(ON6 on6) {
            super(0);
            this.f = on6;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final XC6 invoke() {
            return AbstractC23370wo2.c(C3811Cl3.this.s().a(), C3338Al3.d.a(), new C21830uC4(this.f, C3811Cl3.this.s().a())).p();
        }
    }

    /* renamed from: ir.nasim.Cl3$d */
    public static final class d extends AbstractC24934zS4 {
        d(InterfaceC8507Wg4 interfaceC8507Wg4, C9424Zw2 c9424Zw2) {
            super(interfaceC8507Wg4, c9424Zw2);
        }

        @Override // ir.nasim.InterfaceC24340yS4
        /* renamed from: I0, reason: merged with bridge method [inline-methods] */
        public W24.b o() {
            return W24.b.b;
        }
    }

    /* renamed from: ir.nasim.Cl3$e */
    static final class e extends AbstractC8614Ws3 implements SA2 {
        e() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC4099Dr3 invoke() {
            XC6 xc6I = C3811Cl3.this.a.n().i();
            AbstractC13042fc3.h(xc6I, "moduleDescriptor.builtIns.anyType");
            return xc6I;
        }
    }

    /* renamed from: ir.nasim.Cl3$f */
    static final class f extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ C7939Tv3 e;
        final /* synthetic */ InterfaceC21331tU0 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(C7939Tv3 c7939Tv3, InterfaceC21331tU0 interfaceC21331tU0) {
            super(0);
            this.e = c7939Tv3;
            this.f = interfaceC21331tU0;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC21331tU0 invoke() {
            C7939Tv3 c7939Tv3 = this.e;
            InterfaceC3550Bi3 interfaceC3550Bi3 = InterfaceC3550Bi3.a;
            AbstractC13042fc3.h(interfaceC3550Bi3, "EMPTY");
            return c7939Tv3.M0(interfaceC3550Bi3, this.f);
        }
    }

    /* renamed from: ir.nasim.Cl3$g */
    static final class g extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C6432No4 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(C6432No4 c6432No4) {
            super(1);
            this.e = c6432No4;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Collection invoke(W24 w24) {
            AbstractC13042fc3.i(w24, "it");
            return w24.d(this.e, FA4.FROM_BUILTINS);
        }
    }

    /* renamed from: ir.nasim.Cl3$h */
    static final class h implements AbstractC7955Tx1.c {
        h() {
        }

        @Override // ir.nasim.AbstractC7955Tx1.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Iterable a(InterfaceC21331tU0 interfaceC21331tU0) {
            Collection collectionB = interfaceC21331tU0.j().b();
            AbstractC13042fc3.h(collectionB, "it.typeConstructor.supertypes");
            C3811Cl3 c3811Cl3 = C3811Cl3.this;
            ArrayList arrayList = new ArrayList();
            Iterator it = collectionB.iterator();
            while (it.hasNext()) {
                MU0 mu0T = ((AbstractC4099Dr3) it.next()).K0().t();
                MU0 mu0A = mu0T == null ? null : mu0T.a();
                InterfaceC21331tU0 interfaceC21331tU02 = mu0A instanceof InterfaceC21331tU0 ? (InterfaceC21331tU0) mu0A : null;
                C7939Tv3 c7939Tv3P = interfaceC21331tU02 != null ? c3811Cl3.p(interfaceC21331tU02) : null;
                if (c7939Tv3P != null) {
                    arrayList.add(c7939Tv3P);
                }
            }
            return arrayList;
        }
    }

    /* renamed from: ir.nasim.Cl3$i */
    public static final class i extends AbstractC7955Tx1.b {
        final /* synthetic */ String a;
        final /* synthetic */ C12889fL5 b;

        i(String str, C12889fL5 c12889fL5) {
            this.a = str;
            this.b = c12889fL5;
        }

        @Override // ir.nasim.AbstractC7955Tx1.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean c(InterfaceC21331tU0 interfaceC21331tU0) {
            AbstractC13042fc3.i(interfaceC21331tU0, "javaClassDescriptor");
            String strA = AbstractC6103Me4.a(C17582nC6.a, interfaceC21331tU0, this.a);
            C4279El3 c4279El3 = C4279El3.a;
            if (c4279El3.e().contains(strA)) {
                this.b.a = a.HIDDEN;
            } else if (c4279El3.h().contains(strA)) {
                this.b.a = a.VISIBLE;
            } else if (c4279El3.c().contains(strA)) {
                this.b.a = a.DROP;
            }
            return this.b.a == null;
        }

        @Override // ir.nasim.AbstractC7955Tx1.d
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public a a() {
            a aVar = (a) this.b.a;
            return aVar == null ? a.NOT_CONSIDERED : aVar;
        }
    }

    /* renamed from: ir.nasim.Cl3$j */
    static final class j implements AbstractC7955Tx1.c {
        public static final j a = new j();

        j() {
        }

        @Override // ir.nasim.AbstractC7955Tx1.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Iterable a(InterfaceC15194jA0 interfaceC15194jA0) {
            return interfaceC15194jA0.a().d();
        }
    }

    /* renamed from: ir.nasim.Cl3$k */
    static final class k extends AbstractC8614Ws3 implements UA2 {
        k() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(InterfaceC15194jA0 interfaceC15194jA0) {
            return Boolean.valueOf(interfaceC15194jA0.f() == InterfaceC15194jA0.a.DECLARATION && C3811Cl3.this.b.c((InterfaceC21331tU0) interfaceC15194jA0.b()));
        }
    }

    /* renamed from: ir.nasim.Cl3$l */
    static final class l extends AbstractC8614Ws3 implements SA2 {
        l() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC4356Eu invoke() {
            return InterfaceC4356Eu.W.a(AbstractC9766aX0.e(AbstractC3888Cu.b(C3811Cl3.this.a.n(), "This member is not fully supported by Kotlin compiler, so it may be absent or have different signature in next major version", null, null, 6, null)));
        }
    }

    public C3811Cl3(InterfaceC8507Wg4 interfaceC8507Wg4, ON6 on6, SA2 sa2) {
        AbstractC13042fc3.i(interfaceC8507Wg4, "moduleDescriptor");
        AbstractC13042fc3.i(on6, "storageManager");
        AbstractC13042fc3.i(sa2, "settingsComputation");
        this.a = interfaceC8507Wg4;
        this.b = C5437Ji3.a;
        this.c = on6.c(sa2);
        this.d = k(on6);
        this.e = on6.c(new c(on6));
        this.f = on6.a();
        this.g = on6.c(new l());
    }

    private final JC6 j(C10851cJ1 c10851cJ1, JC6 jc6) {
        AB2.a aVarT = jc6.t();
        aVarT.n(c10851cJ1);
        aVarT.g(QI1.e);
        aVarT.f(c10851cJ1.p());
        aVarT.e(c10851cJ1.H0());
        JC6 jc62 = (JC6) aVarT.a();
        AbstractC13042fc3.f(jc62);
        return jc62;
    }

    private final AbstractC4099Dr3 k(ON6 on6) {
        C23174wU0 c23174wU0 = new C23174wU0(new d(this.a, new C9424Zw2("java.io")), C6432No4.p("Serializable"), EnumC11067cg4.ABSTRACT, AU0.INTERFACE, AbstractC9766aX0.e(new C5572Jx3(on6, new e())), JH6.a, false, on6);
        c23174wU0.J0(W24.b.b, AbstractC4597Fu6.d(), null);
        XC6 xc6P = c23174wU0.p();
        AbstractC13042fc3.h(xc6P, "mockSerializableClass.defaultType");
        return xc6P;
    }

    private final Collection l(InterfaceC21331tU0 interfaceC21331tU0, UA2 ua2) {
        C7939Tv3 c7939Tv3P = p(interfaceC21331tU0);
        if (c7939Tv3P == null) {
            return AbstractC10360bX0.m();
        }
        Collection collectionI = this.b.i(PI1.i(c7939Tv3P), C5877Lf2.g.a());
        InterfaceC21331tU0 interfaceC21331tU02 = (InterfaceC21331tU0) AbstractC15401jX0.E0(collectionI);
        if (interfaceC21331tU02 == null) {
            return AbstractC10360bX0.m();
        }
        DE6.b bVar = DE6.c;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(collectionI, 10));
        Iterator it = collectionI.iterator();
        while (it.hasNext()) {
            arrayList.add(PI1.i((InterfaceC21331tU0) it.next()));
        }
        DE6 de6B = bVar.b(arrayList);
        boolean zC = this.b.c(interfaceC21331tU0);
        W24 w24W = ((InterfaceC21331tU0) this.f.a(PI1.i(c7939Tv3P), new f(c7939Tv3P, interfaceC21331tU02))).W();
        AbstractC13042fc3.h(w24W, "fakeJavaClassDescriptor.unsubstitutedMemberScope");
        Iterable iterable = (Iterable) ua2.invoke(w24W);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : iterable) {
            JC6 jc6 = (JC6) obj;
            if (jc6.f() == InterfaceC15194jA0.a.DECLARATION && jc6.getVisibility().d() && !AbstractC19738qr3.k0(jc6)) {
                Collection collectionD = jc6.d();
                AbstractC13042fc3.h(collectionD, "analogueMember.overriddenDescriptors");
                Collection collection = collectionD;
                if (!collection.isEmpty()) {
                    Iterator it2 = collection.iterator();
                    while (it2.hasNext()) {
                        InterfaceC12795fB1 interfaceC12795fB1B = ((AB2) it2.next()).b();
                        AbstractC13042fc3.h(interfaceC12795fB1B, "it.containingDeclaration");
                        if (de6B.contains(PI1.i(interfaceC12795fB1B))) {
                            break;
                        }
                    }
                }
                if (!t(jc6, zC)) {
                    arrayList2.add(obj);
                }
            }
        }
        return arrayList2;
    }

    private final XC6 m() {
        return (XC6) MN6.a(this.e, this, h[1]);
    }

    private static final boolean n(InterfaceC21426te1 interfaceC21426te1, C5585Jy7 c5585Jy7, InterfaceC21426te1 interfaceC21426te12) {
        return C11663dO4.A(interfaceC21426te1, interfaceC21426te12.c(c5585Jy7)) == C11663dO4.i.a.OVERRIDABLE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C7939Tv3 p(InterfaceC21331tU0 interfaceC21331tU0) {
        if (AbstractC19738qr3.Z(interfaceC21331tU0) || !AbstractC19738qr3.I0(interfaceC21331tU0)) {
            return null;
        }
        C10027ax2 c10027ax2J = PI1.j(interfaceC21331tU0);
        if (!c10027ax2J.f()) {
            return null;
        }
        C24948zU0 c24948zU0O = C5203Ii3.a.o(c10027ax2J);
        C9424Zw2 c9424Zw2B = c24948zU0O == null ? null : c24948zU0O.b();
        if (c9424Zw2B == null) {
            return null;
        }
        InterfaceC21331tU0 interfaceC21331tU0A = NI1.a(s().a(), c9424Zw2B, FA4.FROM_BUILTINS);
        if (interfaceC21331tU0A instanceof C7939Tv3) {
            return (C7939Tv3) interfaceC21331tU0A;
        }
        return null;
    }

    private final a q(AB2 ab2) {
        Object objB = AbstractC7955Tx1.b(AbstractC9766aX0.e((InterfaceC21331tU0) ab2.b()), new h(), new i(AbstractC6597Oe4.c(ab2, false, false, 3, null), new C12889fL5()));
        AbstractC13042fc3.h(objB, "private fun FunctionDescriptor.getJdkMethodStatus(): JDKMemberStatus {\n        val owner = containingDeclaration as ClassDescriptor\n        val jvmDescriptor = computeJvmDescriptor()\n        var result: JDKMemberStatus? = null\n        return DFS.dfs<ClassDescriptor, JDKMemberStatus>(\n            listOf(owner),\n            {\n                // Search through mapped supertypes to determine that Set.toArray should be invisible, while we have only\n                // Collection.toArray there explicitly\n                // Note, that we can't find j.u.Collection.toArray within overriddenDescriptors of j.u.Set.toArray\n                it.typeConstructor.supertypes.mapNotNull {\n                    (it.constructor.declarationDescriptor?.original as? ClassDescriptor)?.getJavaAnalogue()\n                }\n            },\n            object : DFS.AbstractNodeHandler<ClassDescriptor, JDKMemberStatus>() {\n                override fun beforeChildren(javaClassDescriptor: ClassDescriptor): Boolean {\n                    val signature = SignatureBuildingComponents.signature(javaClassDescriptor, jvmDescriptor)\n                    when (signature) {\n                        in HIDDEN_METHOD_SIGNATURES -> result = JDKMemberStatus.HIDDEN\n                        in VISIBLE_METHOD_SIGNATURES -> result = JDKMemberStatus.VISIBLE\n                        in DROP_LIST_METHOD_SIGNATURES -> result = JDKMemberStatus.DROP\n                    }\n\n                    return result == null\n                }\n\n                override fun result() = result ?: JDKMemberStatus.NOT_CONSIDERED\n            })\n    }");
        return (a) objB;
    }

    private final InterfaceC4356Eu r() {
        return (InterfaceC4356Eu) MN6.a(this.g, this, h[2]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C3577Bl3.b s() {
        return (C3577Bl3.b) MN6.a(this.c, this, h[0]);
    }

    private final boolean t(JC6 jc6, boolean z) {
        if (z ^ C4279El3.a.f().contains(AbstractC6103Me4.a(C17582nC6.a, (InterfaceC21331tU0) jc6.b(), AbstractC6597Oe4.c(jc6, false, false, 3, null)))) {
            return true;
        }
        Boolean boolE = AbstractC7955Tx1.e(AbstractC9766aX0.e(jc6), j.a, new k());
        AbstractC13042fc3.h(boolE, "private fun SimpleFunctionDescriptor.isMutabilityViolation(isMutable: Boolean): Boolean {\n        val owner = containingDeclaration as ClassDescriptor\n        val jvmDescriptor = computeJvmDescriptor()\n\n        if ((SignatureBuildingComponents.signature(owner, jvmDescriptor) in MUTABLE_METHOD_SIGNATURES) xor isMutable) return true\n\n        return DFS.ifAny<CallableMemberDescriptor>(\n            listOf(this),\n            { it.original.overriddenDescriptors }\n        ) { overridden ->\n            overridden.kind == CallableMemberDescriptor.Kind.DECLARATION &&\n                    j2kClassMapper.isMutable(overridden.containingDeclaration as ClassDescriptor)\n        }\n    }");
        return boolE.booleanValue();
    }

    private final boolean u(InterfaceC21426te1 interfaceC21426te1, InterfaceC21331tU0 interfaceC21331tU0) {
        if (interfaceC21426te1.h().size() == 1) {
            List listH = interfaceC21426te1.h();
            AbstractC13042fc3.h(listH, "valueParameters");
            MU0 mu0T = ((InterfaceC24919zQ7) AbstractC15401jX0.V0(listH)).getType().K0().t();
            if (AbstractC13042fc3.d(mu0T == null ? null : PI1.j(mu0T), PI1.j(interfaceC21331tU0))) {
                return true;
            }
        }
        return false;
    }

    @Override // ir.nasim.InterfaceC15427ja
    public Collection a(InterfaceC21331tU0 interfaceC21331tU0) {
        InterfaceC21331tU0 interfaceC21331tU0H;
        AbstractC13042fc3.i(interfaceC21331tU0, "classDescriptor");
        if (interfaceC21331tU0.f() != AU0.CLASS || !s().b()) {
            return AbstractC10360bX0.m();
        }
        C7939Tv3 c7939Tv3P = p(interfaceC21331tU0);
        if (c7939Tv3P != null && (interfaceC21331tU0H = C5437Ji3.h(this.b, PI1.i(c7939Tv3P), C5877Lf2.g.a(), null, 4, null)) != null) {
            C5585Jy7 c5585Jy7C = AbstractC15914kO3.a(interfaceC21331tU0H, c7939Tv3P).c();
            List listN0 = c7939Tv3P.k();
            ArrayList<InterfaceC18329oU0> arrayList = new ArrayList();
            for (Object obj : listN0) {
                InterfaceC18329oU0 interfaceC18329oU0 = (InterfaceC18329oU0) obj;
                if (interfaceC18329oU0.getVisibility().d()) {
                    Collection collectionK = interfaceC21331tU0H.k();
                    AbstractC13042fc3.h(collectionK, "defaultKotlinVersion.constructors");
                    Collection<InterfaceC18329oU0> collection = collectionK;
                    if (!collection.isEmpty()) {
                        for (InterfaceC18329oU0 interfaceC18329oU02 : collection) {
                            AbstractC13042fc3.h(interfaceC18329oU02, "it");
                            if (n(interfaceC18329oU02, c5585Jy7C, interfaceC18329oU0)) {
                                break;
                            }
                        }
                    }
                    if (!u(interfaceC18329oU0, interfaceC21331tU0) && !AbstractC19738qr3.k0(interfaceC18329oU0) && !C4279El3.a.d().contains(AbstractC6103Me4.a(C17582nC6.a, c7939Tv3P, AbstractC6597Oe4.c(interfaceC18329oU0, false, false, 3, null)))) {
                        arrayList.add(obj);
                    }
                }
            }
            ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(arrayList, 10));
            for (InterfaceC18329oU0 interfaceC18329oU03 : arrayList) {
                AB2.a aVarT = interfaceC18329oU03.t();
                aVarT.n(interfaceC21331tU0);
                aVarT.f(interfaceC21331tU0.p());
                aVarT.m();
                aVarT.h(c5585Jy7C.j());
                if (!C4279El3.a.g().contains(AbstractC6103Me4.a(C17582nC6.a, c7939Tv3P, AbstractC6597Oe4.c(interfaceC18329oU03, false, false, 3, null)))) {
                    aVarT.r(r());
                }
                AB2 ab2A = aVarT.a();
                if (ab2A == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor");
                }
                arrayList2.add((InterfaceC18329oU0) ab2A);
            }
            return arrayList2;
        }
        return AbstractC10360bX0.m();
    }

    @Override // ir.nasim.InterfaceC15427ja
    public Collection b(InterfaceC21331tU0 interfaceC21331tU0) {
        AbstractC13042fc3.i(interfaceC21331tU0, "classDescriptor");
        C10027ax2 c10027ax2J = PI1.j(interfaceC21331tU0);
        C4279El3 c4279El3 = C4279El3.a;
        if (!c4279El3.i(c10027ax2J)) {
            return c4279El3.j(c10027ax2J) ? AbstractC9766aX0.e(this.d) : AbstractC10360bX0.m();
        }
        XC6 xc6M = m();
        AbstractC13042fc3.h(xc6M, "cloneableType");
        return AbstractC10360bX0.p(xc6M, this.d);
    }

    @Override // ir.nasim.InterfaceC8256Ve5
    public boolean c(InterfaceC21331tU0 interfaceC21331tU0, JC6 jc6) {
        AbstractC13042fc3.i(interfaceC21331tU0, "classDescriptor");
        AbstractC13042fc3.i(jc6, "functionDescriptor");
        C7939Tv3 c7939Tv3P = p(interfaceC21331tU0);
        if (c7939Tv3P == null || !jc6.getAnnotations().M1(AbstractC8490We5.a())) {
            return true;
        }
        if (!s().b()) {
            return false;
        }
        String strC = AbstractC6597Oe4.c(jc6, false, false, 3, null);
        C8173Uv3 c8173Uv3P0 = c7939Tv3P.W();
        C6432No4 name = jc6.getName();
        AbstractC13042fc3.h(name, "functionDescriptor.name");
        Collection collectionD = c8173Uv3P0.d(name, FA4.FROM_BUILTINS);
        if (!(collectionD instanceof Collection) || !collectionD.isEmpty()) {
            Iterator it = collectionD.iterator();
            while (it.hasNext()) {
                if (AbstractC13042fc3.d(AbstractC6597Oe4.c((JC6) it.next(), false, false, 3, null), strC)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // ir.nasim.InterfaceC15427ja
    public Collection e(C6432No4 c6432No4, InterfaceC21331tU0 interfaceC21331tU0) {
        AbstractC13042fc3.i(c6432No4, "name");
        AbstractC13042fc3.i(interfaceC21331tU0, "classDescriptor");
        if (AbstractC13042fc3.d(c6432No4, RV0.e.a()) && (interfaceC21331tU0 instanceof C10851cJ1) && AbstractC19738qr3.c0(interfaceC21331tU0)) {
            C10851cJ1 c10851cJ1 = (C10851cJ1) interfaceC21331tU0;
            List listV0 = c10851cJ1.W0().v0();
            AbstractC13042fc3.h(listV0, "classDescriptor.classProto.functionList");
            List list = listV0;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (AbstractC13042fc3.d(AbstractC7170Qo4.b(c10851cJ1.V0().g(), ((C7950Tw5) it.next()).Z()), RV0.e.a())) {
                        return AbstractC10360bX0.m();
                    }
                }
            }
            return AbstractC9766aX0.e(j(c10851cJ1, (JC6) AbstractC15401jX0.U0(m().o().d(c6432No4, FA4.FROM_BUILTINS))));
        }
        if (!s().b()) {
            return AbstractC10360bX0.m();
        }
        Collection<JC6> collectionL = l(interfaceC21331tU0, new g(c6432No4));
        ArrayList arrayList = new ArrayList();
        for (JC6 jc6 : collectionL) {
            AB2 ab2C = jc6.c(AbstractC15914kO3.a((InterfaceC21331tU0) jc6.b(), interfaceC21331tU0).c());
            if (ab2C == null) {
                throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.SimpleFunctionDescriptor");
            }
            AB2.a aVarT = ((JC6) ab2C).t();
            aVarT.n(interfaceC21331tU0);
            aVarT.e(interfaceC21331tU0.H0());
            aVarT.m();
            int i2 = b.a[q(jc6).ordinal()];
            JC6 jc62 = null;
            if (i2 != 1) {
                if (i2 == 2) {
                    aVarT.r(r());
                } else if (i2 != 3) {
                }
                jc62 = (JC6) aVarT.a();
                AbstractC13042fc3.f(jc62);
            } else if (!AbstractC11862dg4.a(interfaceC21331tU0)) {
                aVarT.i();
                jc62 = (JC6) aVarT.a();
                AbstractC13042fc3.f(jc62);
            }
            if (jc62 != null) {
                arrayList.add(jc62);
            }
        }
        return arrayList;
    }

    @Override // ir.nasim.InterfaceC15427ja
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public Set d(InterfaceC21331tU0 interfaceC21331tU0) {
        C8173Uv3 c8173Uv3P0;
        AbstractC13042fc3.i(interfaceC21331tU0, "classDescriptor");
        if (!s().b()) {
            return AbstractC4597Fu6.d();
        }
        C7939Tv3 c7939Tv3P = p(interfaceC21331tU0);
        Set setA = null;
        if (c7939Tv3P != null && (c8173Uv3P0 = c7939Tv3P.W()) != null) {
            setA = c8173Uv3P0.a();
        }
        return setA == null ? AbstractC4597Fu6.d() : setA;
    }
}
