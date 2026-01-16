package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.C15680jz5;
import ir.nasim.InterfaceC16050kd1;
import ir.nasim.core.runtime.mtproto.ConnectionEndpoint;
import java.io.IOException;

/* renamed from: ir.nasim.qN3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C19451qN3 extends K6 {
    private static final RL B = AbstractC20507s76.f(1);
    public long A;
    private final HL3 f;
    private final LZ2 g;
    private final long h;
    private final byte[] i;
    private final C3848Cp4 j;
    private final C11326cp0 k;
    private final C11326cp0 l;
    private final long m;
    private int n;
    private InterfaceC16050kd1 o;
    private final C22674ve2 u;
    private FE0 v;
    private C9528a7 w;
    private C9528a7 x;
    private long y;
    private EnumC19739qr4 p = EnumC19739qr4.UNKNOWN;
    private boolean q = false;
    private int r = 0;
    private int s = 0;
    private boolean t = false;
    private final long z = 900000;

    /* renamed from: ir.nasim.qN3$a */
    class a implements InterfaceC17232md1 {
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        @Override // ir.nasim.InterfaceC17232md1
        public void a(byte[] bArr, int i, int i2) {
            C19451qN3.this.r().d(new h(bArr, i, i2));
        }

        @Override // ir.nasim.InterfaceC17232md1
        public void b(InterfaceC16050kd1.a aVar) {
            C19406qI3.a("ConnectionLog", "Connection#" + this.a + ": onConnectionDie after: " + (System.currentTimeMillis() - C19451qN3.this.A), new Object[0]);
            C19451qN3.this.r().d(new f(this.a, aVar));
        }
    }

    /* renamed from: ir.nasim.qN3$b */
    class b implements InterfaceC6449Np1 {
        final /* synthetic */ int a;
        final /* synthetic */ ConnectionEndpoint b;

        b(int i, ConnectionEndpoint connectionEndpoint) {
            this.a = i;
            this.b = connectionEndpoint;
        }

        @Override // ir.nasim.InterfaceC6449Np1
        public void a(InterfaceC16050kd1 interfaceC16050kd1) {
            C19451qN3.this.A = System.currentTimeMillis();
            C19406qI3.j("ConnectionLog", "Connection#" + this.a + ": connection Created endpoint " + this.b + " at: " + C19451qN3.this.A, new Object[0]);
            C19451qN3.this.r().d(new e(this.a, interfaceC16050kd1, this.b));
        }

        @Override // ir.nasim.InterfaceC6449Np1
        public void b(InterfaceC16050kd1.a aVar) {
            C19406qI3.j("ConnectionLog", "Connection#" + this.a + ": onConnectionCreateError " + this.b, new Object[0]);
            C19451qN3.this.r().d(new d(this.a, aVar, this.b));
        }
    }

    /* renamed from: ir.nasim.qN3$c */
    public static class c {
        private final boolean a;

        public c(boolean z) {
            this.a = z;
        }

        boolean a() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.qN3$d */
    private static class d {
        private final int a;
        private final InterfaceC16050kd1.a b;
        private final ConnectionEndpoint c;

        public d(int i, InterfaceC16050kd1.a aVar, ConnectionEndpoint connectionEndpoint) {
            this.a = i;
            this.b = aVar;
            this.c = connectionEndpoint;
        }

        public InterfaceC16050kd1.a a() {
            return this.b;
        }

        public int b() {
            return this.a;
        }

        public ConnectionEndpoint c() {
            return this.c;
        }
    }

    /* renamed from: ir.nasim.qN3$e */
    private static class e {
        private final int a;
        private final InterfaceC16050kd1 b;
        private final ConnectionEndpoint c;

        public e(int i, InterfaceC16050kd1 interfaceC16050kd1, ConnectionEndpoint connectionEndpoint) {
            this.a = i;
            this.b = interfaceC16050kd1;
            this.c = connectionEndpoint;
        }
    }

    /* renamed from: ir.nasim.qN3$f */
    private static class f {
        private final int a;
        private final InterfaceC16050kd1.a b;

        public f(int i, InterfaceC16050kd1.a aVar) {
            this.a = i;
            this.b = aVar;
        }

        public InterfaceC16050kd1.a b() {
            return this.b;
        }
    }

    /* renamed from: ir.nasim.qN3$g */
    public static class g {
    }

    /* renamed from: ir.nasim.qN3$h */
    public static class h {
        private final byte[] a;
        private final int b;
        private final int c;

        public h(byte[] bArr, int i, int i2) {
            this.a = bArr;
            this.b = i;
            this.c = i2;
        }
    }

    /* renamed from: ir.nasim.qN3$i */
    public static class i {
        private final EnumC19739qr4 a;

        public i(EnumC19739qr4 enumC19739qr4) {
            this.a = enumC19739qr4;
        }
    }

    /* renamed from: ir.nasim.qN3$j */
    public static class j {
        private final byte[] a;
        private final int b;
        private final int c;

        public j(byte[] bArr, int i, int i2) {
            this.a = bArr;
            this.b = i;
            this.c = i2;
        }
    }

    /* renamed from: ir.nasim.qN3$k */
    private static class k {
        private k() {
        }
    }

    /* renamed from: ir.nasim.qN3$l */
    public static class l {
    }

    public C19451qN3(HL3 hl3) {
        this.f = hl3;
        this.g = hl3.g();
        this.h = hl3.d();
        byte[] bArrE = hl3.e();
        this.i = bArrE;
        if (bArrE != null) {
            C3848Cp4 c3848Cp4 = new C3848Cp4(bArrE);
            this.j = c3848Cp4;
            this.k = new C11326cp0(AbstractC7464Rv1.g(c3848Cp4.c()), AbstractC7464Rv1.h(), c3848Cp4.d(), true);
            this.l = new C11326cp0(AbstractC7464Rv1.g(c3848Cp4.a()), AbstractC7464Rv1.h(), c3848Cp4.b(), true);
        } else {
            this.j = null;
            this.k = null;
            this.l = null;
        }
        this.m = hl3.k();
        this.u = new C22674ve2(hl3.j(), hl3.h(), hl3.i());
        this.y = System.currentTimeMillis();
    }

    private void B() {
        C19406qI3.a("ConnectionLog", "cancelRequestCheckConnection", new Object[0]);
        FE0 fe0 = this.v;
        if (fe0 != null) {
            fe0.cancel();
            this.v = null;
        }
    }

    private void C() {
        StringBuilder sb = new StringBuilder();
        sb.append("checkConnection current connection isNull=");
        sb.append(this.o == null);
        sb.append(", isClosed=");
        InterfaceC16050kd1 interfaceC16050kd1 = this.o;
        sb.append(interfaceC16050kd1 == null || interfaceC16050kd1.isClosed());
        C19406qI3.a("ConnectionLog", sb.toString(), new Object[0]);
        if (this.t) {
            C19406qI3.a("ConnectionLog", "checkConnection: return because isCheckingConnections is true", new Object[0]);
            return;
        }
        InterfaceC16050kd1 interfaceC16050kd12 = this.o;
        if (interfaceC16050kd12 != null && !interfaceC16050kd12.isClosed()) {
            C19406qI3.a("ConnectionLog", "No need to create new connection, because connection is neither null nor closed", new Object[0]);
            return;
        }
        if (this.p == EnumC19739qr4.NO_CONNECTION && !this.q) {
            C19406qI3.a("ConnectionLog", "Do not create new connection because network state is " + this.p + " and app is not visible", new Object[0]);
            return;
        }
        I();
        int iB = B.b();
        P(iB);
        ConnectionEndpoint connectionEndpointA = this.g.a(this.i == null);
        C19406qI3.a("ConnectionLog", "Trying to connect to endpoint: " + connectionEndpointA + ", with connection id:" + iB, new Object[0]);
        AbstractC6211Mq4.a(iB, 7, 7, 0, connectionEndpointA, new a(iB), new b(iB, connectionEndpointA));
    }

    private boolean D() {
        if (this.o == null) {
            C19406qI3.j("ConnectionLog", "return from closeCurrentConnection because currentConnection is null", new Object[0]);
            return false;
        }
        try {
            C19406qI3.a("ConnectionLog", " Going close connection from ManagerActor:closeCurrentConnection", new Object[0]);
            this.o.close();
        } catch (Exception e2) {
            C19406qI3.c("ConnectionLog", "exception in closing currentConnection", e2);
        }
        C19406qI3.a("NetworkLimit", "resetCurrentConnection from closeCurrentConnection", new Object[0]);
        V();
        return true;
    }

    private void E() {
        StringBuilder sb = new StringBuilder();
        sb.append("connectionStateChanged currentConnection isNull ");
        sb.append(this.o == null);
        C19406qI3.a("ConnectionLog", sb.toString(), new Object[0]);
        this.f.f().b(this.o == null ? 0 : 1);
    }

    private void F() {
        StringBuilder sb = new StringBuilder();
        sb.append("forceNetworkCheck currentConnection isNull ");
        sb.append(this.o == null);
        C19406qI3.j("ConnectionLog", sb.toString(), new Object[0]);
        InterfaceC16050kd1 interfaceC16050kd1 = this.o;
        if (interfaceC16050kd1 != null) {
            interfaceC16050kd1.a();
        } else {
            C19406qI3.a("ConnectionLog", "forceNetworkCheck: do not call check connection, because currentConnection is null", new Object[0]);
        }
    }

    private void G(InterfaceC16050kd1.a aVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("handshakeError currentConnection isNull ");
        sb.append(this.o == null);
        C19406qI3.a("ConnectionLog", sb.toString(), new Object[0]);
        this.f.f().d(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ K6 H(HL3 hl3) {
        return new C19451qN3(hl3);
    }

    private void I() {
        C19406qI3.a("ConnectionLog", "Create new connection because current connection is " + (this.o == null ? "null" : "closed"), new Object[0]);
    }

    public static C9528a7 J(final HL3 hl3) {
        return C12736f7.n().g(hl3.c() + "/manager", C4614Fw5.d(new V6() { // from class: ir.nasim.pN3
            @Override // ir.nasim.V6
            public final K6 create() {
                return C19451qN3.H(hl3);
            }
        }).a("D_network"), true);
    }

    private void K(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("App Visible changed, isVisible: ");
        sb.append(z);
        sb.append(" currentConnection isNull: ");
        sb.append(this.o == null);
        C19406qI3.j("Manager", sb.toString(), new Object[0]);
        this.q = z;
        this.y = System.currentTimeMillis();
        if (this.q) {
            T();
        }
    }

    private void L(int i2, InterfaceC16050kd1.a aVar, ConnectionEndpoint connectionEndpoint) {
        C19406qI3.j("ConnectionLog", "Connection create failure", new Object[0]);
        this.g.d(connectionEndpoint);
        this.u.b();
        O(i2, false);
        E();
        if (aVar != InterfaceC16050kd1.a.UNKNOWN) {
            G(aVar);
        } else {
            U(this.u.a());
        }
    }

    private void M(int i2, InterfaceC16050kd1 interfaceC16050kd1, ConnectionEndpoint connectionEndpoint) {
        this.g.f(connectionEndpoint);
        if (this.n == i2) {
            C19406qI3.a("ConnectionLog", "Connection#" + i2 + " return from onConnectionCreated because connection id is same as current connection", new Object[0]);
            return;
        }
        C19406qI3.a("ConnectionLog", "Connection #" + i2 + " created", new Object[0]);
        C19406qI3.a("ConnectionLog", "Going to close previous connection#" + this.n + " because new connection#" + i2 + " is created", new Object[0]);
        D();
        C19406qI3.a("NetworkLimit", "Connection Created !", new Object[0]);
        this.n = i2;
        this.o = interfaceC16050kd1;
        this.r = 0;
        this.s = 0;
        E();
        this.u.c();
        O(i2, true);
        T();
        this.x.d(new C15680jz5.b());
    }

    private void N(int i2, InterfaceC16050kd1.a aVar) {
        C19406qI3.j("ConnectionLog", "Connection #" + i2 + " dies", new Object[0]);
        if (this.n != i2) {
            C19406qI3.a("ConnectionLog", "return from onConnectionDie because currentConnectionId(" + this.n + ") is not equal to died connection id(" + i2 + Separators.RPAREN, new Object[0]);
            return;
        }
        if (!D()) {
            C19406qI3.a("NetworkLimit", "resetCurrentConnection from onConnectionDie", new Object[0]);
            V();
        }
        O(i2, false);
        E();
        if (aVar != InterfaceC16050kd1.a.UNKNOWN) {
            G(aVar);
        }
        if (this.q || System.currentTimeMillis() - this.y <= 900000) {
            T();
        } else {
            C19406qI3.a("ConnectionLog", "Not trying to recreate connection: App is not active", new Object[0]);
        }
    }

    private void O(int i2, boolean z) {
        this.t = false;
        C19406qI3.a("ConnectionLog", "onCreatingConnectionFinished(" + (z ? "successful" : "failed") + ") for connection#" + i2 + ", Set isCreatingConnection to false", new Object[0]);
    }

    private void P(int i2) {
        this.t = true;
        C19406qI3.a("ConnectionLog", "onCreatingConnectionStarted for connection#" + i2 + ", Set isCreatingConnection to true", new Object[0]);
    }

    private void Q(byte[] bArr, int i2, int i3) throws IOException {
        C9207Yy1 c9207Yy1 = new C9207Yy1(bArr, i2, i3);
        try {
            long jE = c9207Yy1.e();
            long jE2 = c9207Yy1.e();
            if (jE != this.h || jE2 != this.m) {
                throw new IOException("Incorrect header");
            }
            if (this.i == null) {
                this.w.d(new C20408rx5(c9207Yy1.e(), c9207Yy1.g()));
                return;
            }
            C14574i82 c14574i82 = new C14574i82(c9207Yy1);
            int iE = (int) c14574i82.e();
            int i4 = this.s;
            if (iE == i4) {
                this.s = i4 + 1;
                C13385g82 c13385g82 = new C13385g82(new C9207Yy1(c14574i82.d()));
                C9207Yy1 c9207Yy12 = new C9207Yy1(this.k.a(AbstractC8107Uo0.f(iE), c13385g82.e(), c13385g82.d()));
                this.w.d(new C20408rx5(c9207Yy12.e(), c9207Yy12.g()));
                return;
            }
            if (i4 == 0 && iE == -1) {
                throw new IOException("server changed");
            }
            throw new IOException("Expected " + this.s + ", got: " + iE);
        } catch (IOException e2) {
            C19406qI3.j("ConnectionLog", "Closing connection: incorrect package", new Object[0]);
            C19406qI3.d("ConnectionLog", e2);
            D();
            if (e2.getMessage().equals("server changed")) {
                return;
            }
            q(new k(), 100L);
        }
    }

    private void R(EnumC19739qr4 enumC19739qr4) {
        C19406qI3.j("ConnectionLog", "Network configuration changed: " + enumC19739qr4, new Object[0]);
        this.p = enumC19739qr4;
        this.u.d();
        q(new k(), 100L);
    }

    private void S(byte[] bArr, int i2, int i3) {
        InterfaceC16050kd1 interfaceC16050kd1 = this.o;
        if (interfaceC16050kd1 == null || (interfaceC16050kd1 != null && interfaceC16050kd1.isClosed())) {
            C19406qI3.a("NetworkLimit", "resetCurrentConnection from onOutMessage", new Object[0]);
            V();
            C19406qI3.a("ConnectionLog", "PerformConnectionCheck in 100ms from onOutMessage", new Object[0]);
            q(new k(), 100L);
        }
        try {
            if (this.o != null) {
                if (this.i == null) {
                    C12658ez1 c12658ez1 = new C12658ez1();
                    c12658ez1.i(this.h);
                    c12658ez1.i(this.m);
                    c12658ez1.g(bArr, i2, i3);
                    byte[] bArrC = c12658ez1.c();
                    this.o.b(bArrC, 0, bArrC.length);
                    return;
                }
                int i4 = this.r;
                this.r = i4 + 1;
                byte[] bArr2 = new byte[16];
                AbstractC7464Rv1.j(bArr2);
                long j2 = i4;
                byte[] bArrB = new C14574i82(j2, new C13385g82(bArr2, this.l.b(AbstractC8107Uo0.f(j2), bArr2, AbstractC8107Uo0.h(bArr, i2, i3))).b()).b();
                C12658ez1 c12658ez12 = new C12658ez1();
                c12658ez12.i(this.h);
                c12658ez12.i(this.m);
                c12658ez12.g(bArrB, 0, bArrB.length);
                byte[] bArrC2 = c12658ez12.c();
                this.o.b(bArrC2, 0, bArrC2.length);
            }
        } catch (Exception e2) {
            C19406qI3.j("Manager", "Closing connection: exception during push", new Object[0]);
            C19406qI3.d("Manager", e2);
            C19406qI3.d("NON_FATAL_EXCEPTION", e2);
            D();
            C19406qI3.a("ConnectionLog", "PerformConnectionCheck in 100ms because of exception in onOutMessage", new Object[0]);
            q(new k(), 100L);
        }
    }

    private void T() {
        U(100L);
    }

    private void U(long j2) {
        StringBuilder sb = new StringBuilder();
        sb.append("requestCheckConnection isCheckingConnections ");
        sb.append(this.t);
        sb.append(" currentConnection isNull ");
        sb.append(this.o == null);
        C19406qI3.a("ConnectionLog", sb.toString(), new Object[0]);
        if (this.t) {
            return;
        }
        if (this.o == null) {
            if (j2 == 0) {
                C19406qI3.j("ConnectionLog", "Requesting connection creating", new Object[0]);
            } else {
                C19406qI3.j("ConnectionLog", "Requesting connection creating in " + j2 + " ms", new Object[0]);
            }
        }
        B();
        this.v = q(new k(), j2);
    }

    private void V() {
        this.o = null;
        this.n = 0;
    }

    private void W() {
        C19406qI3.j("ConnectionLog", "Restarting the connection ...", new Object[0]);
        D();
        try {
            C();
        } catch (Exception e2) {
            C19406qI3.c("ConnectionLog", "checkConnection() failed because of:", e2);
        }
    }

    @Override // ir.nasim.K6
    public void m(Object obj) throws IOException {
        if (obj instanceof e) {
            e eVar = (e) obj;
            M(eVar.a, eVar.b, eVar.c);
            return;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            L(dVar.b(), dVar.a(), dVar.c());
            return;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            N(fVar.a, fVar.b());
            return;
        }
        if (obj instanceof k) {
            C();
            return;
        }
        if (obj instanceof c) {
            K(((c) obj).a());
            return;
        }
        if (obj instanceof i) {
            R(((i) obj).a);
            return;
        }
        if (obj instanceof g) {
            F();
            return;
        }
        if (obj instanceof l) {
            W();
            return;
        }
        if (obj instanceof j) {
            j jVar = (j) obj;
            S(jVar.a, jVar.b, jVar.c);
        } else if (!(obj instanceof h)) {
            super.m(obj);
        } else {
            h hVar = (h) obj;
            Q(hVar.a, hVar.b, hVar.c);
        }
    }

    @Override // ir.nasim.K6
    public void n() {
        this.w = null;
        this.x = null;
        D();
        this.n = -1;
        E();
    }

    @Override // ir.nasim.K6
    public void o() {
        this.w = XI5.D(this.f);
        this.x = C15680jz5.G(this.f);
        E();
        try {
            C19406qI3.a("ConnectionLog", "Going to check connection from Manager prestart", new Object[0]);
            C();
        } catch (Exception e2) {
            C19406qI3.c("Manager", "manager crash:", e2);
        }
    }
}
