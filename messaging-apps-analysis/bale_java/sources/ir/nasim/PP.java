package ir.nasim;

import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.InterfaceC16050kd1;
import ir.nasim.core.runtime.mtproto.ConnectionEndpoint;
import java.io.IOException;
import java.util.Random;

/* loaded from: classes5.dex */
public class PP extends K6 {
    private C9528a7 f;
    private LZ2 g;
    private InterfaceC16050kd1 h;
    private long j;
    private g m;
    private FE0 n;
    private int i = 0;
    private final Random k = new Random();
    private final C22674ve2 l = new C22674ve2(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT, 30000, 25);

    class a implements g {
        a() {
        }

        @Override // ir.nasim.PP.g
        public AbstractC24641yx5 a() {
            return new DV5(PP.this.j);
        }

        @Override // ir.nasim.PP.g
        public void b(AbstractC24641yx5 abstractC24641yx5) throws IOException {
            if (!(abstractC24641yx5 instanceof B06)) {
                throw new IOException("Expected: ResponseStartAuth, got: " + abstractC24641yx5.getClass().getName());
            }
            C19406qI3.a("AuthKeyActor", "Received ResponseStartAuth", new Object[0]);
            B06 b06 = (B06) abstractC24641yx5;
            if (b06.h() != PP.this.j) {
                throw new IOException("Incorrect RandomId");
            }
            long[] jArrG = b06.g();
            if (jArrG.length == 0) {
                throw new IOException("No keys installed on server. Please, configure your server correctly.");
            }
            if (PP.this.g.c().length == 0) {
                PP.this.M(jArrG[0], b06.i());
                return;
            }
            for (long j : jArrG) {
                for (C18610ow7 c18610ow7 : PP.this.g.c()) {
                    if (c18610ow7.b() == j) {
                        if (c18610ow7.a() != null) {
                            PP.this.L(c18610ow7.b(), c18610ow7.a(), b06.i());
                            return;
                        } else {
                            PP.this.M(c18610ow7.b(), b06.i());
                            return;
                        }
                    }
                }
            }
            throw new IOException("No trusted keys found!");
        }
    }

    class b implements g {
        final /* synthetic */ long a;
        final /* synthetic */ byte[] b;

        b(long j, byte[] bArr) {
            this.a = j;
            this.b = bArr;
        }

        @Override // ir.nasim.PP.g
        public AbstractC24641yx5 a() {
            return new ZS5(this.a);
        }

        @Override // ir.nasim.PP.g
        public void b(AbstractC24641yx5 abstractC24641yx5) throws IOException {
            if (!(abstractC24641yx5 instanceof C14224hZ5)) {
                throw new IOException("Expected: ResponseGetServerKey, got: " + abstractC24641yx5.getClass().getName());
            }
            C19406qI3.a("AuthKeyActor", "Received ResponseGetServerKey", new Object[0]);
            C14224hZ5 c14224hZ5 = (C14224hZ5) abstractC24641yx5;
            long jH = c14224hZ5.h();
            long j = this.a;
            if (jH != j) {
                throw new IOException("Incorrect KeyId");
            }
            PP.this.L(j, c14224hZ5.g(), this.b);
        }
    }

    class c implements g {
        final /* synthetic */ long a;
        final /* synthetic */ byte[] b;
        final /* synthetic */ C6262Mw1 c;
        final /* synthetic */ byte[] d;
        final /* synthetic */ byte[] e;

        c(long j, byte[] bArr, C6262Mw1 c6262Mw1, byte[] bArr2, byte[] bArr3) {
            this.a = j;
            this.b = bArr;
            this.c = c6262Mw1;
            this.d = bArr2;
            this.e = bArr3;
        }

        @Override // ir.nasim.PP.g
        public AbstractC24641yx5 a() {
            return new IQ5(PP.this.j, this.a, this.b, this.c.b());
        }

        @Override // ir.nasim.PP.g
        public void b(AbstractC24641yx5 abstractC24641yx5) throws IOException {
            if (!(abstractC24641yx5 instanceof C24386yX5)) {
                throw new IOException("Expected: ResponseGetServerKey, got: " + abstractC24641yx5.getClass().getName());
            }
            C19406qI3.a("AuthKeyActor", "Received ResponseDoDH", new Object[0]);
            C24386yX5 c24386yX5 = (C24386yX5) abstractC24641yx5;
            if (c24386yX5.g() != PP.this.j) {
                throw new IOException("Incorrect RandomId");
            }
            C20697sS4 c20697sS4 = new C20697sS4(AbstractC7464Rv1.h());
            byte[] bArrG = AbstractC8107Uo0.g(this.b, this.d);
            byte[] bArrA = c20697sS4.a(AbstractC6028Lw1.a(this.c.a(), this.e), "master secret", bArrG, 256, true);
            if (!AbstractC6028Lw1.e(this.e, c20697sS4.a(bArrA, "client finished", bArrG, 256, true), c24386yX5.h())) {
                throw new IOException("Incorrect Signature");
            }
            CT1 ct1H = AbstractC7464Rv1.h();
            ct1H.c(bArrA, 0, bArrA.length);
            byte[] bArr = new byte[32];
            ct1H.a(bArr, 0);
            long jC = AbstractC8107Uo0.c(bArr);
            C19406qI3.a("AuthKeyActor", "Key successfully created", new Object[0]);
            PP.this.N(bArrA, jC);
        }
    }

    class d implements InterfaceC17232md1 {
        final /* synthetic */ int a;

        d(int i) {
            this.a = i;
        }

        @Override // ir.nasim.InterfaceC17232md1
        public void a(byte[] bArr, int i, int i2) {
            PP.this.r().d(new i(this.a, bArr, i, i2));
        }

        @Override // ir.nasim.InterfaceC17232md1
        public void b(InterfaceC16050kd1.a aVar) {
            PP.this.r().d(new h(this.a, aVar));
        }
    }

    class e implements InterfaceC6449Np1 {
        final /* synthetic */ ConnectionEndpoint a;
        final /* synthetic */ int b;

        e(ConnectionEndpoint connectionEndpoint, int i) {
            this.a = connectionEndpoint;
            this.b = i;
        }

        @Override // ir.nasim.InterfaceC6449Np1
        public void a(InterfaceC16050kd1 interfaceC16050kd1) throws IOException {
            C19406qI3.j("AuthKeyActor", "connection Created", new Object[0]);
            PP.this.g.f(this.a);
            PP.this.P(this.b, interfaceC16050kd1);
        }

        @Override // ir.nasim.InterfaceC6449Np1
        public void b(InterfaceC16050kd1.a aVar) {
            PP.this.g.d(this.a);
            PP.this.r().d(new h(this.b, aVar));
        }
    }

    public static class f {
        private final long a;
        private final byte[] b;

        public f(long j, byte[] bArr) {
            this.a = j;
            this.b = bArr;
        }

        public byte[] a() {
            return this.b;
        }

        public long b() {
            return this.a;
        }
    }

    private interface g {
        AbstractC24641yx5 a();

        void b(AbstractC24641yx5 abstractC24641yx5);
    }

    private static class h {
        private final int a;
        private final InterfaceC16050kd1.a b;

        public h(int i, InterfaceC16050kd1.a aVar) {
            this.a = i;
            this.b = aVar;
        }

        public int a() {
            return this.a;
        }
    }

    private static class i {
        private final int a;
        private final byte[] b;
        private final int c;
        private final int d;

        public i(int i, byte[] bArr, int i2, int i3) {
            this.a = i;
            this.b = bArr;
            this.c = i2;
            this.d = i3;
        }

        public int a() {
            return this.a;
        }

        public byte[] b() {
            return this.b;
        }

        public int c() {
            return this.d;
        }

        public int d() {
            return this.c;
        }
    }

    public static class j {
    }

    public static class k {
        private final LZ2 a;

        public k(LZ2 lz2) {
            this.a = lz2;
        }

        public LZ2 a() {
            return this.a;
        }
    }

    private static class l {
        private l() {
        }
    }

    private void H() {
        C19406qI3.a("AuthKeyActor", "Crashing connection", new Object[0]);
        this.i++;
        if (this.h != null) {
            C19406qI3.a("ConnectionLog", "Connection#" + this.i + " Going close connection from AuthKeyActor:crashConnection", new Object[0]);
            this.h.close();
            this.h = null;
        }
    }

    private void I() {
        C19406qI3.a("AuthKeyActor", "Crashing state...", new Object[0]);
        this.m = null;
        H();
    }

    private void J() {
        K(new a());
    }

    private void K(g gVar) {
        this.m = gVar;
        if (this.h != null) {
            try {
                byte[] bArrB = new C21685tx5(0L, 0L, new C20408rx5(0L, gVar.a().b())).b();
                this.h.b(bArrB, 0, bArrB.length);
            } catch (IOException e2) {
                C19406qI3.d("AuthKeyActor", e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(long j2, byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[32];
        AbstractC7464Rv1.j(bArr3);
        byte[] bArr4 = new byte[32];
        AbstractC7464Rv1.j(bArr4);
        K(new c(j2, bArr3, AbstractC6028Lw1.b(bArr4), bArr2, bArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(long j2, byte[] bArr) {
        K(new b(j2, bArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(byte[] bArr, long j2) {
        this.f.d(new f(j2, bArr));
        I();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O(Boolean bool, Exception exc) {
        if (bool != null && bool.booleanValue() && exc == null) {
            return;
        }
        q(new j(), this.l.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(int i2, InterfaceC16050kd1 interfaceC16050kd1) throws IOException {
        C19406qI3.a("AuthKeyActor", "onConnectionCreated", new Object[0]);
        if (i2 == this.i) {
            this.l.c();
            this.h = interfaceC16050kd1;
            R();
            return;
        }
        C19406qI3.a("ConnectionLog", "Connection#" + i2 + " Going close connection from AuthKeyActor:onConnectionCreated", new Object[0]);
        interfaceC16050kd1.close();
        C19406qI3.a("AuthKeyActor", "Too old: ignoring", new Object[0]);
    }

    private void Q(int i2) {
        C19406qI3.a("AuthKeyActor", "onConnectionDie", new Object[0]);
        if (i2 != this.i) {
            C19406qI3.a("AuthKeyActor", "Too old: ignoring", new Object[0]);
            return;
        }
        H();
        this.l.b();
        if (this.m != null) {
            long jA = this.l.a();
            C19406qI3.a("AuthKeyActor", "Trying to recreate connection in " + jA + " ms...", new Object[0]);
            FE0 fe0 = this.n;
            if (fe0 != null) {
                fe0.cancel();
                this.n = null;
            }
            this.n = q(new l(), jA);
        }
    }

    private void R() throws IOException {
        try {
            g gVar = this.m;
            if (gVar == null) {
                throw new IOException();
            }
            byte[] bArrB = new C21685tx5(0L, 0L, new C20408rx5(0L, gVar.a().b())).b();
            this.h.b(bArrB, 0, bArrB.length);
        } catch (Exception e2) {
            C19406qI3.d("AuthKeyActor", e2);
            H();
        }
    }

    private void S(int i2, byte[] bArr, int i3, int i4) throws IOException {
        if (i2 != this.i) {
            C19406qI3.a("AuthKeyActor", "Too old: ignoring", new Object[0]);
            return;
        }
        try {
            C21685tx5 c21685tx5 = new C21685tx5(new C9207Yy1(bArr, i3, i4));
            if (c21685tx5.d() != 0) {
                throw new IOException("AuthId != 0");
            }
            if (c21685tx5.f() != 0) {
                throw new IOException("Session != 0");
            }
            if (c21685tx5.e().d() != 0) {
                throw new IOException("MessageId != 0");
            }
            AbstractC24641yx5 abstractC24641yx5B = AbstractC24051xx5.b(c21685tx5.e().e());
            try {
                g gVar = this.m;
                if (gVar == null) {
                    throw new IOException();
                }
                gVar.b(abstractC24641yx5B);
            } catch (Exception unused) {
                H();
            }
        } catch (IOException unused2) {
            H();
        }
    }

    private void T() {
        AbstractC17969nr7.e().z(new InterfaceC3273Ae1() { // from class: ir.nasim.OP
            @Override // ir.nasim.InterfaceC3273Ae1
            public final void apply(Object obj, Object obj2) {
                this.a.O((Boolean) obj, (Exception) obj2);
            }
        });
    }

    private void U(LZ2 lz2) {
        if (s() == null) {
            return;
        }
        if (this.h != null) {
            C19406qI3.a("ConnectionLog", "Connection#" + this.i + " Going close connection from startKeyCreation", new Object[0]);
            this.h.close();
            this.h = null;
        }
        this.f = s();
        this.g = lz2;
        this.j = this.k.nextLong();
        this.l.d();
        J();
        FE0 fe0 = this.n;
        if (fe0 != null) {
            fe0.cancel();
            this.n = null;
        }
        this.n = q(new l(), 0L);
        r().d(new j());
    }

    private void V() {
        int i2 = this.i + 1;
        this.i = i2;
        try {
            ConnectionEndpoint connectionEndpointA = this.g.a(true);
            C19406qI3.a("AuthKeyActor", "Trying to connect to endpoint: " + connectionEndpointA, new Object[0]);
            AbstractC6211Mq4.a(i2, 7, 7, 0, connectionEndpointA, new d(i2), new e(connectionEndpointA, i2));
        } catch (Exception e2) {
            C19406qI3.c("AuthKeyActor", "Trying to connect... failed ", e2);
            r().d(new h(i2, InterfaceC16050kd1.a.NONE));
        }
    }

    @Override // ir.nasim.K6
    public void m(Object obj) throws IOException {
        if (obj instanceof k) {
            U(((k) obj).a());
            return;
        }
        if (obj instanceof h) {
            Q(((h) obj).a());
            return;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            S(iVar.a(), iVar.b(), iVar.d(), iVar.c());
        } else if (obj instanceof l) {
            V();
        } else if (obj instanceof j) {
            T();
        } else {
            super.m(obj);
        }
    }
}
