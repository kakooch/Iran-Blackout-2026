package ir.nasim;

import ir.nasim.PJ6;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* renamed from: ir.nasim.Al3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C3338Al3 implements InterfaceC22578vU0 {
    public static final b d = new b(null);
    static final /* synthetic */ InterfaceC5239Im3[] e = {AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(C3338Al3.class), "cloneable", "getCloneable()Lorg/jetbrains/kotlin/descriptors/impl/ClassDescriptorImpl;"))};
    private static final C9424Zw2 f = PJ6.m;
    private static final C6432No4 g;
    private static final C24948zU0 h;
    private final InterfaceC8507Wg4 a;
    private final UA2 b;
    private final InterfaceC23016wC4 c;

    /* renamed from: ir.nasim.Al3$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC14958im0 invoke(InterfaceC8507Wg4 interfaceC8507Wg4) {
            AbstractC13042fc3.i(interfaceC8507Wg4, "module");
            List listJ0 = interfaceC8507Wg4.z0(C3338Al3.f).j0();
            ArrayList arrayList = new ArrayList();
            for (Object obj : listJ0) {
                if (obj instanceof InterfaceC14958im0) {
                    arrayList.add(obj);
                }
            }
            return (InterfaceC14958im0) AbstractC15401jX0.q0(arrayList);
        }
    }

    /* renamed from: ir.nasim.Al3$b */
    public static final class b {
        private b() {
        }

        public final C24948zU0 a() {
            return C3338Al3.h;
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Al3$c */
    static final class c extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ ON6 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(ON6 on6) {
            super(0);
            this.f = on6;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C23174wU0 invoke() {
            C23174wU0 c23174wU0 = new C23174wU0((InterfaceC12795fB1) C3338Al3.this.b.invoke(C3338Al3.this.a), C3338Al3.g, EnumC11067cg4.ABSTRACT, AU0.INTERFACE, AbstractC9766aX0.e(C3338Al3.this.a.n().i()), JH6.a, false, this.f);
            c23174wU0.J0(new RV0(this.f, c23174wU0), AbstractC4597Fu6.d(), null);
            return c23174wU0;
        }
    }

    static {
        C10027ax2 c10027ax2 = PJ6.a.d;
        C6432No4 c6432No4I = c10027ax2.i();
        AbstractC13042fc3.h(c6432No4I, "cloneable.shortName()");
        g = c6432No4I;
        C24948zU0 c24948zU0M = C24948zU0.m(c10027ax2.l());
        AbstractC13042fc3.h(c24948zU0M, "topLevel(StandardNames.FqNames.cloneable.toSafe())");
        h = c24948zU0M;
    }

    public C3338Al3(ON6 on6, InterfaceC8507Wg4 interfaceC8507Wg4, UA2 ua2) {
        AbstractC13042fc3.i(on6, "storageManager");
        AbstractC13042fc3.i(interfaceC8507Wg4, "moduleDescriptor");
        AbstractC13042fc3.i(ua2, "computeContainingDeclaration");
        this.a = interfaceC8507Wg4;
        this.b = ua2;
        this.c = on6.c(new c(on6));
    }

    private final C23174wU0 i() {
        return (C23174wU0) MN6.a(this.c, this, e[0]);
    }

    @Override // ir.nasim.InterfaceC22578vU0
    public InterfaceC21331tU0 a(C24948zU0 c24948zU0) {
        AbstractC13042fc3.i(c24948zU0, "classId");
        if (AbstractC13042fc3.d(c24948zU0, d.a())) {
            return i();
        }
        return null;
    }

    @Override // ir.nasim.InterfaceC22578vU0
    public boolean b(C9424Zw2 c9424Zw2, C6432No4 c6432No4) {
        AbstractC13042fc3.i(c9424Zw2, "packageFqName");
        AbstractC13042fc3.i(c6432No4, "name");
        return AbstractC13042fc3.d(c6432No4, g) && AbstractC13042fc3.d(c9424Zw2, f);
    }

    @Override // ir.nasim.InterfaceC22578vU0
    public Collection c(C9424Zw2 c9424Zw2) {
        AbstractC13042fc3.i(c9424Zw2, "packageFqName");
        return AbstractC13042fc3.d(c9424Zw2, f) ? AbstractC4363Eu6.c(i()) : AbstractC4597Fu6.d();
    }

    public /* synthetic */ C3338Al3(ON6 on6, InterfaceC8507Wg4 interfaceC8507Wg4, UA2 ua2, int i, ED1 ed1) {
        this(on6, interfaceC8507Wg4, (i & 4) != 0 ? a.e : ua2);
    }
}
