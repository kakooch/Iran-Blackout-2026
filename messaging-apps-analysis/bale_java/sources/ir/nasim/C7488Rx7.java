package ir.nasim;

import ir.nasim.InterfaceC15194jA0;
import java.util.List;

/* renamed from: ir.nasim.Rx7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C7488Rx7 extends BB2 implements InterfaceC7254Qx7 {
    public static final a Z = new a(null);
    static final /* synthetic */ InterfaceC5239Im3[] z0 = {AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(C7488Rx7.class), "withDispatchReceiver", "getWithDispatchReceiver()Lorg/jetbrains/kotlin/descriptors/impl/TypeAliasConstructorDescriptor;"))};
    private final ON6 G;
    private final InterfaceC7722Sx7 H;
    private final InterfaceC20580sF4 J;
    private InterfaceC18329oU0 Y;

    /* renamed from: ir.nasim.Rx7$a */
    public static final class a {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final C5585Jy7 c(InterfaceC7722Sx7 interfaceC7722Sx7) {
            if (interfaceC7722Sx7.s() == null) {
                return null;
            }
            return C5585Jy7.f(interfaceC7722Sx7.G());
        }

        public final InterfaceC7254Qx7 b(ON6 on6, InterfaceC7722Sx7 interfaceC7722Sx7, InterfaceC18329oU0 interfaceC18329oU0) {
            InterfaceC18329oU0 interfaceC18329oU0C;
            AbstractC13042fc3.i(on6, "storageManager");
            AbstractC13042fc3.i(interfaceC7722Sx7, "typeAliasDescriptor");
            AbstractC13042fc3.i(interfaceC18329oU0, "constructor");
            C5585Jy7 c5585Jy7C = c(interfaceC7722Sx7);
            if (c5585Jy7C == null || (interfaceC18329oU0C = interfaceC18329oU0.c(c5585Jy7C)) == null) {
                return null;
            }
            InterfaceC4356Eu annotations = interfaceC18329oU0.getAnnotations();
            InterfaceC15194jA0.a aVarF = interfaceC18329oU0.f();
            AbstractC13042fc3.h(aVarF, "constructor.kind");
            JH6 jh6I = interfaceC7722Sx7.i();
            AbstractC13042fc3.h(jh6I, "typeAliasDescriptor.source");
            C7488Rx7 c7488Rx7 = new C7488Rx7(on6, interfaceC7722Sx7, interfaceC18329oU0C, null, annotations, aVarF, jh6I, null);
            List listN0 = BB2.N0(c7488Rx7, interfaceC18329oU0.h(), c5585Jy7C);
            if (listN0 == null) {
                return null;
            }
            XC6 xc6C = AbstractC7411Rp2.c(interfaceC18329oU0C.getReturnType().N0());
            XC6 xc6P = interfaceC7722Sx7.p();
            AbstractC13042fc3.h(xc6P, "typeAliasDescriptor.defaultType");
            XC6 xc6J = AbstractC24252yI6.j(xc6C, xc6P);
            ZI5 zi5N = interfaceC18329oU0.N();
            c7488Rx7.Q0(zi5N != null ? AbstractC23657xI1.f(c7488Rx7, c5585Jy7C.n(zi5N.getType(), KQ7.INVARIANT), InterfaceC4356Eu.W.b()) : null, null, interfaceC7722Sx7.q(), listN0, xc6J, EnumC11067cg4.FINAL, interfaceC7722Sx7.getVisibility());
            return c7488Rx7;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Rx7$b */
    static final class b extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC18329oU0 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC18329oU0 interfaceC18329oU0) {
            super(0);
            this.f = interfaceC18329oU0;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C7488Rx7 invoke() {
            ON6 on6O = C7488Rx7.this.O();
            InterfaceC7722Sx7 interfaceC7722Sx7N1 = C7488Rx7.this.n1();
            InterfaceC18329oU0 interfaceC18329oU0 = this.f;
            C7488Rx7 c7488Rx7 = C7488Rx7.this;
            InterfaceC4356Eu annotations = interfaceC18329oU0.getAnnotations();
            InterfaceC15194jA0.a aVarF = this.f.f();
            AbstractC13042fc3.h(aVarF, "underlyingConstructorDescriptor.kind");
            JH6 jh6I = C7488Rx7.this.n1().i();
            AbstractC13042fc3.h(jh6I, "typeAliasDescriptor.source");
            C7488Rx7 c7488Rx72 = new C7488Rx7(on6O, interfaceC7722Sx7N1, interfaceC18329oU0, c7488Rx7, annotations, aVarF, jh6I, null);
            C7488Rx7 c7488Rx73 = C7488Rx7.this;
            InterfaceC18329oU0 interfaceC18329oU02 = this.f;
            C5585Jy7 c5585Jy7C = C7488Rx7.Z.c(c7488Rx73.n1());
            if (c5585Jy7C == null) {
                return null;
            }
            ZI5 zi5N = interfaceC18329oU02.N();
            c7488Rx72.Q0(null, zi5N == null ? null : zi5N.c(c5585Jy7C), c7488Rx73.n1().q(), c7488Rx73.h(), c7488Rx73.getReturnType(), EnumC11067cg4.FINAL, c7488Rx73.n1().getVisibility());
            return c7488Rx72;
        }
    }

    public /* synthetic */ C7488Rx7(ON6 on6, InterfaceC7722Sx7 interfaceC7722Sx7, InterfaceC18329oU0 interfaceC18329oU0, InterfaceC7254Qx7 interfaceC7254Qx7, InterfaceC4356Eu interfaceC4356Eu, InterfaceC15194jA0.a aVar, JH6 jh6, ED1 ed1) {
        this(on6, interfaceC7722Sx7, interfaceC18329oU0, interfaceC7254Qx7, interfaceC4356Eu, aVar, jh6);
    }

    public final ON6 O() {
        return this.G;
    }

    @Override // ir.nasim.InterfaceC7254Qx7
    public InterfaceC18329oU0 T() {
        return this.Y;
    }

    @Override // ir.nasim.InterfaceC21426te1
    public boolean d0() {
        return T().d0();
    }

    @Override // ir.nasim.InterfaceC21426te1
    public InterfaceC21331tU0 e0() {
        InterfaceC21331tU0 interfaceC21331tU0E0 = T().e0();
        AbstractC13042fc3.h(interfaceC21331tU0E0, "underlyingConstructorDescriptor.constructedClass");
        return interfaceC21331tU0E0;
    }

    @Override // ir.nasim.BB2, ir.nasim.InterfaceC14592iA0
    public AbstractC4099Dr3 getReturnType() {
        AbstractC4099Dr3 returnType = super.getReturnType();
        AbstractC13042fc3.f(returnType);
        return returnType;
    }

    @Override // ir.nasim.InterfaceC15194jA0
    /* renamed from: j1, reason: merged with bridge method [inline-methods] */
    public InterfaceC7254Qx7 u(InterfaceC12795fB1 interfaceC12795fB1, EnumC11067cg4 enumC11067cg4, RI1 ri1, InterfaceC15194jA0.a aVar, boolean z) {
        AbstractC13042fc3.i(interfaceC12795fB1, "newOwner");
        AbstractC13042fc3.i(enumC11067cg4, "modality");
        AbstractC13042fc3.i(ri1, "visibility");
        AbstractC13042fc3.i(aVar, "kind");
        AB2 ab2A = t().n(interfaceC12795fB1).s(enumC11067cg4).g(ri1).q(aVar).o(z).a();
        if (ab2A != null) {
            return (InterfaceC7254Qx7) ab2A;
        }
        throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.BB2
    /* renamed from: k1, reason: merged with bridge method [inline-methods] */
    public C7488Rx7 K0(InterfaceC12795fB1 interfaceC12795fB1, AB2 ab2, InterfaceC15194jA0.a aVar, C6432No4 c6432No4, InterfaceC4356Eu interfaceC4356Eu, JH6 jh6) {
        AbstractC13042fc3.i(interfaceC12795fB1, "newOwner");
        AbstractC13042fc3.i(aVar, "kind");
        AbstractC13042fc3.i(interfaceC4356Eu, "annotations");
        AbstractC13042fc3.i(jh6, "source");
        InterfaceC15194jA0.a aVar2 = InterfaceC15194jA0.a.DECLARATION;
        if (aVar != aVar2) {
            InterfaceC15194jA0.a aVar3 = InterfaceC15194jA0.a.SYNTHESIZED;
        }
        return new C7488Rx7(this.G, n1(), T(), this, interfaceC4356Eu, aVar2, jh6);
    }

    @Override // ir.nasim.AbstractC14602iB1, ir.nasim.InterfaceC12795fB1
    /* renamed from: l1, reason: merged with bridge method [inline-methods] */
    public InterfaceC7722Sx7 b() {
        return n1();
    }

    @Override // ir.nasim.AbstractC14602iB1
    /* renamed from: m1, reason: merged with bridge method [inline-methods] */
    public InterfaceC7254Qx7 a() {
        return (InterfaceC7254Qx7) super.a();
    }

    public InterfaceC7722Sx7 n1() {
        return this.H;
    }

    @Override // ir.nasim.BB2, ir.nasim.AB2, ir.nasim.InterfaceC19829r07
    /* renamed from: o1, reason: merged with bridge method [inline-methods] */
    public InterfaceC7254Qx7 c(C5585Jy7 c5585Jy7) {
        AbstractC13042fc3.i(c5585Jy7, "substitutor");
        AB2 ab2C = super.c(c5585Jy7);
        if (ab2C == null) {
            throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptorImpl");
        }
        C7488Rx7 c7488Rx7 = (C7488Rx7) ab2C;
        C5585Jy7 c5585Jy7F = C5585Jy7.f(c7488Rx7.getReturnType());
        AbstractC13042fc3.h(c5585Jy7F, "create(substitutedTypeAliasConstructor.returnType)");
        InterfaceC18329oU0 interfaceC18329oU0C = T().a().c(c5585Jy7F);
        if (interfaceC18329oU0C == null) {
            return null;
        }
        c7488Rx7.Y = interfaceC18329oU0C;
        return c7488Rx7;
    }

    private C7488Rx7(ON6 on6, InterfaceC7722Sx7 interfaceC7722Sx7, InterfaceC18329oU0 interfaceC18329oU0, InterfaceC7254Qx7 interfaceC7254Qx7, InterfaceC4356Eu interfaceC4356Eu, InterfaceC15194jA0.a aVar, JH6 jh6) {
        super(interfaceC7722Sx7, interfaceC7254Qx7, interfaceC4356Eu, C6432No4.s("<init>"), aVar, jh6);
        this.G = on6;
        this.H = interfaceC7722Sx7;
        U0(n1().Y());
        this.J = on6.g(new b(interfaceC18329oU0));
        this.Y = interfaceC18329oU0;
    }
}
