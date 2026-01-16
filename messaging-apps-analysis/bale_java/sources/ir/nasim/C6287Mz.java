package ir.nasim;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.rpc.Status;
import ir.nasim.C9475a16;
import ir.nasim.InterfaceC16050kd1;
import ir.nasim.LZ2;
import ir.nasim.Z06;
import ir.nasim.core.network.RpcException;
import ir.nasim.core.runtime.mtproto.ConnectionEndpoint;
import java.util.ArrayList;

/* renamed from: ir.nasim.Mz, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6287Mz extends AbstractC21707u0 implements InterfaceC3817Cm0, InterfaceC16847ly {
    public static final int e = 8;
    private final C9057Yh4 b;
    private final RP c;
    private C9354Zo4 d;

    /* renamed from: ir.nasim.Mz$a */
    private final class a implements InterfaceC9947ap4 {
        public a() {
        }

        @Override // ir.nasim.InterfaceC9947ap4
        public void a(int i, EnumC19739qr4 enumC19739qr4) {
            C6287Mz.this.G().a().f(new C15459jd1(i == 0, enumC19739qr4));
        }

        @Override // ir.nasim.InterfaceC9947ap4
        public void b(InterfaceC16050kd1.a aVar) {
            long jA = AbstractC19981rG5.a();
            long jO = AbstractC20507s76.o();
            C11458d25 c11458d25E = C11458d25.E(10);
            AbstractC13042fc3.h(c11458d25E, "user(...)");
            String string = C5721Ko.a.d().getString(AbstractC12217eE5.connection_error_version_out_date);
            AbstractC13042fc3.h(string, "getString(...)");
            int i = 10;
            C6287Mz.this.G().G().T0().x(c11458d25E, new J44(jA, jO, jO, i, EnumC23558x74.SENT, C23345wl7.g.b(string, new ArrayList()), null, 0, null, null, 0L, null, null, false, null, null, false, null, null, 524224, null));
        }

        @Override // ir.nasim.InterfaceC9947ap4
        public void c(long j) {
            C6287Mz.this.G().k0();
        }

        @Override // ir.nasim.InterfaceC9947ap4
        public void d() {
            C6287Mz.this.G().a().f(new C3438Aw4());
        }

        @Override // ir.nasim.InterfaceC9947ap4
        public void e(Object obj) {
            if (C6287Mz.this.G().V() != null) {
                C6287Mz.this.G().V().v0(obj);
            }
        }
    }

    /* renamed from: ir.nasim.Mz$b */
    public static final class b implements O66 {
        final /* synthetic */ HE0 a;

        b(HE0 he0) {
            this.a = he0;
        }

        @Override // ir.nasim.O66
        public void b(RpcException rpcException) {
            AbstractC13042fc3.i(rpcException, "e");
            AbstractC24549yo1.c(this.a, new Z06.a(rpcException));
        }

        @Override // ir.nasim.O66
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(com.google.protobuf.P p) {
            AbstractC13042fc3.i(p, "response");
            AbstractC24549yo1.c(this.a, new Z06.b(p));
        }
    }

    /* renamed from: ir.nasim.Mz$c */
    public static final class c implements O66 {
        final /* synthetic */ C22871vx5 a;
        final /* synthetic */ O66 b;

        c(C22871vx5 c22871vx5, O66 o66) {
            this.a = c22871vx5;
            this.b = o66;
        }

        @Override // ir.nasim.O66
        public void b(RpcException rpcException) {
            AbstractC13042fc3.i(rpcException, "e");
            this.b.b(rpcException);
        }

        @Override // ir.nasim.O66
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(C15100j06 c15100j06) {
            String name;
            String name2;
            AbstractC13042fc3.i(c15100j06, "response");
            byte[] bArrU = c15100j06.u();
            AbstractC13042fc3.h(bArrU, "getResponse(...)");
            if (!(bArrU.length == 0)) {
                try {
                    Object objA = this.a.c().getParserForType().a(c15100j06.u());
                    AbstractC13042fc3.g(objA, "null cannot be cast to non-null type R of ir.nasim.core.modules.api.ApiModule.api");
                    this.b.a((com.google.protobuf.P) objA);
                    return;
                } catch (InvalidProtocolBufferException e) {
                    if (c.class.isAnonymousClass()) {
                        name = c.class.getName();
                        int length = name.length();
                        AbstractC13042fc3.f(name);
                        if (length > 23) {
                            name = name.substring(name.length() - 23, name.length());
                            AbstractC13042fc3.h(name, "substring(...)");
                        }
                    } else {
                        name = c.class.getSimpleName();
                        int length2 = name.length();
                        AbstractC13042fc3.f(name);
                        if (length2 > 23) {
                            name = name.substring(0, 23);
                            AbstractC13042fc3.h(name, "substring(...)");
                        }
                    }
                    C19406qI3.c(name, "api", e);
                    return;
                }
            }
            byte[] bArrW = c15100j06.w();
            AbstractC13042fc3.h(bArrW, "getStatus(...)");
            if (!(!(bArrW.length == 0))) {
                this.b.a(this.a.c());
                return;
            }
            try {
                Status from = Status.parseFrom(c15100j06.w());
                O66 o66 = this.b;
                String message = from.getMessage();
                AbstractC13042fc3.h(message, "getMessage(...)");
                int code = from.getCode();
                String message2 = from.getMessage();
                AbstractC13042fc3.h(message2, "getMessage(...)");
                o66.b(new RpcException(message, code, message2, false));
            } catch (InvalidProtocolBufferException e2) {
                if (c.class.isAnonymousClass()) {
                    name2 = c.class.getName();
                    int length3 = name2.length();
                    AbstractC13042fc3.f(name2);
                    if (length3 > 23) {
                        name2 = name2.substring(name2.length() - 23, name2.length());
                        AbstractC13042fc3.h(name2, "substring(...)");
                    }
                } else {
                    name2 = c.class.getSimpleName();
                    int length4 = name2.length();
                    AbstractC13042fc3.f(name2);
                    if (length4 > 23) {
                        name2 = name2.substring(0, 23);
                        AbstractC13042fc3.h(name2, "substring(...)");
                    }
                }
                C19406qI3.c(name2, "api", e2);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C6287Mz(C9057Yh4 c9057Yh4, InterfaceC3570Bk5 interfaceC3570Bk5) {
        this(c9057Yh4, interfaceC3570Bk5, null, 4, null);
        AbstractC13042fc3.i(c9057Yh4, "context");
        AbstractC13042fc3.i(interfaceC3570Bk5, "authPreferences");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer B(C9057Yh4 c9057Yh4) {
        Object objB;
        AbstractC13042fc3.i(c9057Yh4, "$context");
        try {
            C9475a16.a aVar = C9475a16.b;
            objB = C9475a16.b(Integer.valueOf(c9057Yh4.w().p()));
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            objB = C9475a16.b(AbstractC10685c16.a(th));
        }
        if (C9475a16.g(objB)) {
            objB = null;
        }
        return (Integer) objB;
    }

    public static /* synthetic */ void E(C6287Mz c6287Mz, C22871vx5 c22871vx5, O66 o66, long j, C16018ka c16018ka, int i, Object obj) {
        if ((i & 4) != 0) {
            j = 16500;
        }
        long j2 = j;
        if ((i & 8) != 0) {
            c16018ka = null;
        }
        c6287Mz.D(c22871vx5, o66, j2, c16018ka);
    }

    public final void C(C22871vx5 c22871vx5, O66 o66) {
        AbstractC13042fc3.i(c22871vx5, "request");
        AbstractC13042fc3.i(o66, "callback");
        E(this, c22871vx5, o66, 0L, null, 12, null);
    }

    public final void D(C22871vx5 c22871vx5, O66 o66, long j, C16018ka c16018ka) {
        AbstractC13042fc3.i(c22871vx5, "request");
        AbstractC13042fc3.i(o66, "callback");
        this.b.b().i(c22871vx5, new c(c22871vx5, o66), j, -1L, c16018ka);
    }

    public final RP F() {
        return this.c;
    }

    public final C9057Yh4 G() {
        return this.b;
    }

    public final C9354Zo4 H() {
        return this.d;
    }

    public final void I(long j, byte[] bArr) {
        AbstractC13042fc3.i(bArr, "masterKey");
        this.d.d(j, bArr);
    }

    public final void J() {
        L();
        this.d.g();
    }

    public void K() {
        this.d.l();
    }

    public final void L() {
        this.d.m();
    }

    @Override // ir.nasim.InterfaceC3817Cm0
    /* renamed from: g */
    public void T(AbstractC18385oa2 abstractC18385oa2) {
        if ((abstractC18385oa2 instanceof XE) && ((XE) abstractC18385oa2).a) {
            this.d.b();
        }
    }

    @Override // ir.nasim.InterfaceC16847ly
    public Object j(C22871vx5 c22871vx5, long j, C16018ka c16018ka, InterfaceC20295rm1 interfaceC20295rm1) {
        IE0 ie0 = new IE0(AbstractC14251hc3.c(interfaceC20295rm1), 1);
        ie0.w();
        D(c22871vx5, new b(ie0), j, c16018ka);
        Object objT = ie0.t();
        if (objT == AbstractC14862ic3.e()) {
            WA1.c(interfaceC20295rm1);
        }
        return objT;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ C6287Mz(final C9057Yh4 c9057Yh4, InterfaceC3570Bk5 interfaceC3570Bk5, LZ2 lz2, int i, ED1 ed1) {
        if ((i & 4) != 0) {
            C92 c92 = C92.a;
            LZ2.a aVarH0 = ((InterfaceC7480Rx) C92.a(C5721Ko.a.d(), InterfaceC7480Rx.class)).H0();
            C18610ow7[] c18610ow7ArrI = c9057Yh4.z().i();
            AbstractC13042fc3.h(c18610ow7ArrI, "getTrustedKeys(...)");
            ConnectionEndpoint[] connectionEndpointArrC = c9057Yh4.z().c();
            AbstractC13042fc3.h(connectionEndpointArrC, "getEndpoints(...)");
            lz2 = aVarH0.a(c18610ow7ArrI, connectionEndpointArrC, new SA2() { // from class: ir.nasim.Lz
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C6287Mz.B(c9057Yh4);
                }
            });
        }
        this(c9057Yh4, interfaceC3570Bk5, lz2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C6287Mz(C9057Yh4 c9057Yh4, InterfaceC3570Bk5 interfaceC3570Bk5, LZ2 lz2) {
        super(c9057Yh4);
        AbstractC13042fc3.i(c9057Yh4, "context");
        AbstractC13042fc3.i(interfaceC3570Bk5, "authPreferences");
        AbstractC13042fc3.i(lz2, "endpoints");
        this.b = c9057Yh4;
        C14335hk5 c14335hk5 = new C14335hk5(interfaceC3570Bk5);
        this.c = c14335hk5;
        this.d = new C9354Zo4(lz2, c14335hk5, Y66.a, new C20216re4(), new a(), c9057Yh4.z().f(), c9057Yh4.z().d(), c9057Yh4.z().e());
        c9057Yh4.a().h(this, "app_visible_changed");
    }
}
