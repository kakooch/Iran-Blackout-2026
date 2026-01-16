package ir.nasim;

import ir.nasim.PJ6;
import java.util.List;

/* renamed from: ir.nasim.kM5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C15898kM5 {
    public static final b k = new b(null);
    static final /* synthetic */ InterfaceC5239Im3[] l;
    private final C21830uC4 a;
    private final InterfaceC9173Yu3 b;
    private final a c;
    private final a d;
    private final a e;
    private final a f;
    private final a g;
    private final a h;
    private final a i;
    private final a j;

    /* renamed from: ir.nasim.kM5$a */
    private static final class a {
        private final int a;

        public a(int i) {
            this.a = i;
        }

        public final InterfaceC21331tU0 a(C15898kM5 c15898kM5, InterfaceC5239Im3 interfaceC5239Im3) {
            AbstractC13042fc3.i(c15898kM5, "types");
            AbstractC13042fc3.i(interfaceC5239Im3, "property");
            return c15898kM5.b(AbstractC20153rZ6.t(interfaceC5239Im3.getName()), this.a);
        }
    }

    /* renamed from: ir.nasim.kM5$b */
    public static final class b {
        private b() {
        }

        public final AbstractC4099Dr3 a(InterfaceC8507Wg4 interfaceC8507Wg4) {
            AbstractC13042fc3.i(interfaceC8507Wg4, "module");
            InterfaceC21331tU0 interfaceC21331tU0A = AbstractC23370wo2.a(interfaceC8507Wg4, PJ6.a.n0);
            if (interfaceC21331tU0A == null) {
                return null;
            }
            C4567Fr3 c4567Fr3 = C4567Fr3.a;
            InterfaceC4356Eu interfaceC4356EuB = InterfaceC4356Eu.W.b();
            List parameters = interfaceC21331tU0A.j().getParameters();
            AbstractC13042fc3.h(parameters, "kPropertyClass.typeConstructor.parameters");
            Object objV0 = AbstractC15401jX0.V0(parameters);
            AbstractC13042fc3.h(objV0, "kPropertyClass.typeConstructor.parameters.single()");
            return C4567Fr3.g(interfaceC4356EuB, interfaceC21331tU0A, AbstractC9766aX0.e(new RJ6((InterfaceC22882vy7) objV0)));
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.kM5$c */
    static final class c extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC8507Wg4 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(InterfaceC8507Wg4 interfaceC8507Wg4) {
            super(0);
            this.e = interfaceC8507Wg4;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final W24 invoke() {
            return this.e.z0(PJ6.j).o();
        }
    }

    static {
        InterfaceC5239Im3[] interfaceC5239Im3Arr = new InterfaceC5239Im3[9];
        interfaceC5239Im3Arr[1] = AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(C15898kM5.class), "kClass", "getKClass()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        interfaceC5239Im3Arr[2] = AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(C15898kM5.class), "kProperty", "getKProperty()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        interfaceC5239Im3Arr[3] = AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(C15898kM5.class), "kProperty0", "getKProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        interfaceC5239Im3Arr[4] = AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(C15898kM5.class), "kProperty1", "getKProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        interfaceC5239Im3Arr[5] = AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(C15898kM5.class), "kProperty2", "getKProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        interfaceC5239Im3Arr[6] = AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(C15898kM5.class), "kMutableProperty0", "getKMutableProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        interfaceC5239Im3Arr[7] = AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(C15898kM5.class), "kMutableProperty1", "getKMutableProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        interfaceC5239Im3Arr[8] = AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(C15898kM5.class), "kMutableProperty2", "getKMutableProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        l = interfaceC5239Im3Arr;
    }

    public C15898kM5(InterfaceC8507Wg4 interfaceC8507Wg4, C21830uC4 c21830uC4) {
        AbstractC13042fc3.i(interfaceC8507Wg4, "module");
        AbstractC13042fc3.i(c21830uC4, "notFoundClasses");
        this.a = c21830uC4;
        this.b = AbstractC13269fw3.b(EnumC4870Gx3.b, new c(interfaceC8507Wg4));
        this.c = new a(1);
        this.d = new a(1);
        this.e = new a(1);
        this.f = new a(2);
        this.g = new a(3);
        this.h = new a(1);
        this.i = new a(2);
        this.j = new a(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC21331tU0 b(String str, int i) {
        C6432No4 c6432No4P = C6432No4.p(str);
        AbstractC13042fc3.h(c6432No4P, "identifier(className)");
        MU0 mu0E = d().e(c6432No4P, FA4.FROM_REFLECTION);
        InterfaceC21331tU0 interfaceC21331tU0 = mu0E instanceof InterfaceC21331tU0 ? (InterfaceC21331tU0) mu0E : null;
        return interfaceC21331tU0 == null ? this.a.d(new C24948zU0(PJ6.j, c6432No4P), AbstractC9766aX0.e(Integer.valueOf(i))) : interfaceC21331tU0;
    }

    private final W24 d() {
        return (W24) this.b.getValue();
    }

    public final InterfaceC21331tU0 c() {
        return this.c.a(this, l[1]);
    }
}
