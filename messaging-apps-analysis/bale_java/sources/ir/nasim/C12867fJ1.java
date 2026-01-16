package ir.nasim;

import ir.nasim.C21625tr3;
import java.util.Collection;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;

/* renamed from: ir.nasim.fJ1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C12867fJ1 {
    public static final a b = new a(null);
    private static final Set c = AbstractC4363Eu6.c(C21625tr3.a.CLASS);
    private static final Set d = AbstractC4597Fu6.i(C21625tr3.a.FILE_FACADE, C21625tr3.a.MULTIFILE_CLASS_PART);
    private static final C6404Nl3 e = new C6404Nl3(1, 1, 2);
    private static final C6404Nl3 f = new C6404Nl3(1, 1, 11);
    private static final C6404Nl3 g = new C6404Nl3(1, 1, 13);
    public TI1 a;

    /* renamed from: ir.nasim.fJ1$a */
    public static final class a {
        private a() {
        }

        public final C6404Nl3 a() {
            return C12867fJ1.g;
        }

        public final Set b() {
            return C12867fJ1.c;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.fJ1$b */
    static final class b extends AbstractC8614Ws3 implements SA2 {
        public static final b e = new b();

        b() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Collection invoke() {
            return AbstractC10360bX0.m();
        }
    }

    private final EnumC11615dJ1 e(InterfaceC22805vr3 interfaceC22805vr3) {
        return f().g().d() ? EnumC11615dJ1.STABLE : interfaceC22805vr3.c().j() ? EnumC11615dJ1.FIR_UNSTABLE : interfaceC22805vr3.c().k() ? EnumC11615dJ1.IR_UNSTABLE : EnumC11615dJ1.STABLE;
    }

    private final V53 g(InterfaceC22805vr3 interfaceC22805vr3) {
        if (h() || interfaceC22805vr3.c().d().h()) {
            return null;
        }
        return new V53(interfaceC22805vr3.c().d(), C6404Nl3.i, interfaceC22805vr3.getLocation(), interfaceC22805vr3.f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean h() {
        return f().g().e();
    }

    private final boolean i(InterfaceC22805vr3 interfaceC22805vr3) {
        return !f().g().b() && interfaceC22805vr3.c().i() && AbstractC13042fc3.d(interfaceC22805vr3.c().d(), f);
    }

    private final boolean j(InterfaceC22805vr3 interfaceC22805vr3) {
        return (f().g().f() && (interfaceC22805vr3.c().i() || AbstractC13042fc3.d(interfaceC22805vr3.c().d(), e))) || i(interfaceC22805vr3);
    }

    private final String[] l(InterfaceC22805vr3 interfaceC22805vr3, Set set) {
        C21625tr3 c21625tr3C = interfaceC22805vr3.c();
        String[] strArrA = c21625tr3C.a();
        if (strArrA == null) {
            strArrA = c21625tr3C.b();
        }
        if (strArrA != null && set.contains(c21625tr3C.c())) {
            return strArrA;
        }
        return null;
    }

    public final W24 d(InterfaceC24340yS4 interfaceC24340yS4, InterfaceC22805vr3 interfaceC22805vr3) {
        String[] strArrG;
        XV4 xv4M;
        AbstractC13042fc3.i(interfaceC24340yS4, "descriptor");
        AbstractC13042fc3.i(interfaceC22805vr3, "kotlinClass");
        String[] strArrL = l(interfaceC22805vr3, d);
        if (strArrL == null || (strArrG = interfaceC22805vr3.c().g()) == null) {
            return null;
        }
        try {
            try {
                xv4M = C8083Ul3.m(strArrL, strArrG);
            } catch (InvalidProtocolBufferException e2) {
                throw new IllegalStateException(AbstractC13042fc3.q("Could not read data from ", interfaceC22805vr3.getLocation()), e2);
            }
        } catch (Throwable th) {
            if (h() || interfaceC22805vr3.c().d().h()) {
                throw th;
            }
            xv4M = null;
        }
        if (xv4M == null) {
            return null;
        }
        C6664Ol3 c6664Ol3 = (C6664Ol3) xv4M.a();
        C8652Ww5 c8652Ww5 = (C8652Ww5) xv4M.b();
        return new C15867kJ1(interfaceC24340yS4, c8652Ww5, c6664Ol3, interfaceC22805vr3.c().d(), new C6898Pl3(interfaceC22805vr3, c8652Ww5, c6664Ol3, g(interfaceC22805vr3), j(interfaceC22805vr3), e(interfaceC22805vr3)), f(), b.e);
    }

    public final TI1 f() {
        TI1 ti1 = this.a;
        if (ti1 != null) {
            return ti1;
        }
        AbstractC13042fc3.y("components");
        throw null;
    }

    public final C19511qU0 k(InterfaceC22805vr3 interfaceC22805vr3) {
        String[] strArrG;
        XV4 xv4I;
        AbstractC13042fc3.i(interfaceC22805vr3, "kotlinClass");
        String[] strArrL = l(interfaceC22805vr3, b.b());
        if (strArrL == null || (strArrG = interfaceC22805vr3.c().g()) == null) {
            return null;
        }
        try {
            try {
                xv4I = C8083Ul3.i(strArrL, strArrG);
            } catch (InvalidProtocolBufferException e2) {
                throw new IllegalStateException(AbstractC13042fc3.q("Could not read data from ", interfaceC22805vr3.getLocation()), e2);
            }
        } catch (Throwable th) {
            if (h() || interfaceC22805vr3.c().d().h()) {
                throw th;
            }
            xv4I = null;
        }
        if (xv4I == null) {
            return null;
        }
        return new C19511qU0((C6664Ol3) xv4I.a(), (C6526Nw5) xv4I.b(), interfaceC22805vr3.c().d(), new C23991xr3(interfaceC22805vr3, g(interfaceC22805vr3), j(interfaceC22805vr3), e(interfaceC22805vr3)));
    }

    public final InterfaceC21331tU0 m(InterfaceC22805vr3 interfaceC22805vr3) {
        AbstractC13042fc3.i(interfaceC22805vr3, "kotlinClass");
        C19511qU0 c19511qU0K = k(interfaceC22805vr3);
        if (c19511qU0K == null) {
            return null;
        }
        return f().f().d(interfaceC22805vr3.f(), c19511qU0K);
    }

    public final void n(TI1 ti1) {
        AbstractC13042fc3.i(ti1, "<set-?>");
        this.a = ti1;
    }

    public final void o(UI1 ui1) {
        AbstractC13042fc3.i(ui1, "components");
        n(ui1.a());
    }
}
