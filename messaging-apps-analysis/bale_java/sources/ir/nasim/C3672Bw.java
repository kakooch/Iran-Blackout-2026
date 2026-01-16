package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.InterfaceC16050kd1;
import ir.nasim.PP;
import ir.nasim.core.network.RpcException;
import ir.nasim.core.network.RpcFloodWaitException;
import ir.nasim.core.network.RpcInternalException;
import ir.nasim.core.network.RpcTimeoutException;
import ir.nasim.core.network.RpcUnknownException;
import ir.nasim.core.network.api.RpcDisabledException;
import java.io.IOException;
import java.util.HashMap;

/* renamed from: ir.nasim.Bw, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C3672Bw extends K6 {
    private static final RL t = AbstractC20507s76.f(1);
    private final LZ2 f;
    private final RP g;
    private final InterfaceC9947ap4 h;
    private final int i;
    private final int j;
    private final int k;
    private EnumC19739qr4 l;
    private final HashMap m = new HashMap();
    private final HashMap n = new HashMap();
    private final HashMap o = new HashMap();
    private long p;
    private HL3 q;
    private C9528a7 r;
    private final C20530sA s;

    /* renamed from: ir.nasim.Bw$a */
    public static class a {
        private final boolean a;

        public a(boolean z) {
            this.a = z;
        }

        boolean a() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.Bw$b */
    private static class b {
        private long a;

        public b(long j) {
            this.a = j;
        }

        public long a() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.Bw$c */
    public static class c {
        private long a;

        public c(long j) {
            this.a = j;
        }

        public long a() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.Bw$d */
    private class d {
        private int a;

        public d(int i) {
            this.a = i;
        }

        public int a() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.Bw$e */
    public static class e {
    }

    /* renamed from: ir.nasim.Bw$f */
    private class f {
        private long a;

        public f(long j) {
            this.a = j;
        }

        public long a() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.Bw$g */
    private class g {
        private InterfaceC16050kd1.a a;

        public g(InterfaceC16050kd1.a aVar) {
            this.a = aVar;
        }

        public InterfaceC16050kd1.a a() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.Bw$h */
    public static class h {
        private long a;
        private byte[] b;

        public h(long j, byte[] bArr) {
            this.a = j;
            this.b = bArr;
        }

        public long a() {
            return this.a;
        }

        public byte[] b() {
            return this.b;
        }
    }

    /* renamed from: ir.nasim.Bw$i */
    public static class i {
        private EnumC19739qr4 a;

        public i(EnumC19739qr4 enumC19739qr4) {
            this.a = enumC19739qr4;
        }

        public EnumC19739qr4 a() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.Bw$j */
    private class j {
        private long a;

        public j(long j) {
            this.a = j;
        }

        public long a() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.Bw$k */
    public static class k {
        private TP5 a;
        private O66 b;
        private long c;
        private long d;

        public k(long j, TP5 tp5, O66 o66, long j2) {
            this.c = j;
            this.a = tp5;
            this.b = o66;
            this.d = j2;
        }

        public O66 a() {
            return this.b;
        }

        public TP5 b() {
            return this.a;
        }

        public long c() {
            return this.c;
        }

        public long d() {
            return this.d;
        }
    }

    /* renamed from: ir.nasim.Bw$l */
    private class l implements IL3 {
        private long a;

        public l(long j) {
            this.a = j;
        }

        @Override // ir.nasim.IL3
        public void a() {
            C3672Bw.this.r().d(C3672Bw.this.new j(this.a));
        }

        @Override // ir.nasim.IL3
        public void b(int i) {
            C3672Bw.this.r().d(C3672Bw.this.new d(i));
        }

        @Override // ir.nasim.IL3
        public void c(byte[] bArr) {
            C3672Bw.this.r().d(C3672Bw.this.new n(this.a, bArr));
        }

        @Override // ir.nasim.IL3
        public void d(InterfaceC16050kd1.a aVar) {
            C3672Bw.this.r().d(C3672Bw.this.new g(aVar));
        }

        @Override // ir.nasim.IL3
        public void e(long j) {
            if (this.a != j) {
                return;
            }
            C3672Bw.this.r().d(new b(j));
        }

        @Override // ir.nasim.IL3
        public void f(long j, byte[] bArr) {
            C3672Bw.this.r().d(C3672Bw.this.new m(this.a, j, bArr));
        }
    }

    /* renamed from: ir.nasim.Bw$m */
    private class m {
        private long a;
        private long b;
        private byte[] c;

        public m(long j, long j2, byte[] bArr) {
            this.a = j;
            this.b = j2;
            this.c = bArr;
        }

        public long a() {
            return this.a;
        }

        public byte[] b() {
            return this.c;
        }

        public long c() {
            return this.b;
        }
    }

    /* renamed from: ir.nasim.Bw$n */
    private class n {
        private long a;
        private byte[] b;

        public n(long j, byte[] bArr) {
            this.a = j;
            this.b = bArr;
        }

        public long a() {
            return this.a;
        }

        public byte[] b() {
            return this.b;
        }
    }

    /* renamed from: ir.nasim.Bw$o */
    public static class o {
        private long a;

        public o(long j) {
            this.a = j;
        }

        public long a() {
            return this.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ir.nasim.Bw$p */
    class p {
        private final long a;
        private final C10129b76 b;
        private final long c;
        private final O66 d;
        private long e;

        private p(long j, long j2, C10129b76 c10129b76, O66 o66) {
            this.a = j;
            this.b = c10129b76;
            this.c = j2;
            this.d = o66;
        }
    }

    /* renamed from: ir.nasim.Bw$q */
    public static class q {
    }

    /* renamed from: ir.nasim.Bw$r */
    public static class r {
    }

    /* renamed from: ir.nasim.Bw$s */
    private class s implements Runnable {
        private final long a;

        public s(long j) {
            this.a = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3672Bw.this.I(this.a, true);
        }
    }

    public C3672Bw(LZ2 lz2, RP rp, InterfaceC9947ap4 interfaceC9947ap4, int i2, int i3, int i4) {
        this.f = lz2;
        this.g = rp;
        this.h = interfaceC9947ap4;
        this.i = i2;
        this.j = i3;
        this.k = i4;
        C20530sA c20530sA = new C20530sA();
        this.s = c20530sA;
        c20530sA.a(new PW4(new C9535a76()));
    }

    private void G(long j2, p pVar) {
        J(j2);
        this.m.remove(Long.valueOf(j2));
        if (pVar.e != 0) {
            this.n.remove(Long.valueOf(pVar.e));
        }
    }

    private void H(long j2) {
        I(j2, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(long j2, boolean z) {
        O66 o66;
        C19406qI3.j("ApiBroker", "request#" + j2 + " cancels", new Object[0]);
        J(j2);
        p pVar = (p) this.m.get(Long.valueOf(j2));
        if (pVar != null) {
            if (z && (o66 = pVar.d) != null) {
                o66.b(new RpcTimeoutException());
            }
            this.m.remove(Long.valueOf(j2));
            if (pVar.e == 0 || this.q == null) {
                return;
            }
            this.n.remove(Long.valueOf(pVar.e));
            this.q.a(pVar.e);
        }
    }

    private void J(long j2) {
        C10054b01 c10054b01 = (C10054b01) this.o.get(Long.valueOf(j2));
        if (c10054b01 != null) {
            c10054b01.a();
            this.o.remove(Long.valueOf(j2));
        }
    }

    private void K(int i2) {
        this.h.a(i2, this.l);
    }

    private void L(long j2, byte[] bArr) {
        this.g.b(j2);
        this.g.c(bArr);
        this.p = j2;
        this.q = new HL3(j2, bArr, AbstractC19981rG5.a(), this.f, new l(j2), f() + "/proto#" + t.c(), this.i, this.j, this.k);
        for (p pVar : this.m.values()) {
            pVar.e = this.q.o(pVar.b);
            this.n.put(Long.valueOf(pVar.e), Long.valueOf(pVar.c));
        }
    }

    private void M() {
        HL3 hl3 = this.q;
        if (hl3 != null) {
            hl3.b();
        }
    }

    private void N(long j2) {
        p pVar = (p) this.m.get(Long.valueOf(j2));
        if (pVar != null) {
            if (pVar.e != 0) {
                this.n.remove(Long.valueOf(pVar.e));
                this.q.a(pVar.e);
            }
            long jO = this.q.o(pVar.b);
            pVar.e = jO;
            this.n.put(Long.valueOf(jO), Long.valueOf(j2));
        }
    }

    public static C9528a7 O(final LZ2 lz2, final RP rp, final InterfaceC9947ap4 interfaceC9947ap4, int i2, final int i3, final int i4, final int i5) {
        return C12736f7.n().c(C4614Fw5.d(new V6() { // from class: ir.nasim.vw
            @Override // ir.nasim.V6
            public final K6 create() {
                return C3672Bw.T(lz2, rp, interfaceC9947ap4, i3, i4, i5);
            }
        }), "api/broker#" + i2);
    }

    private String P(TP5 tp5) {
        if (tp5 instanceof AU5) {
            return "Request" + ((AU5) tp5).getMethod().split(Separators.SLASH)[2];
        }
        return "rpc_header_" + tp5.q() + "";
    }

    private String Q(TP5 tp5) {
        if (!(tp5 instanceof AU5)) {
            return tp5.toString();
        }
        return "Request" + ((AU5) tp5).getMethod().split(Separators.SLASH)[2];
    }

    private boolean S(String str) {
        return C7183Qq.q(EnumC18608ow5.h).h(str, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ K6 T(LZ2 lz2, RP rp, InterfaceC9947ap4 interfaceC9947ap4, int i2, int i3, int i4) {
        return new C3672Bw(lz2, rp, interfaceC9947ap4, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void U(p pVar, S66 s66) {
        pVar.d.b(new RpcException(s66.b, s66.a, s66.c, s66.d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void V(p pVar) {
        pVar.d.b(new RpcInternalException());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void W(p pVar) {
        pVar.d.b(new RpcFloodWaitException());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void X(p pVar) {
        pVar.d.b(new RpcUnknownException());
    }

    private void Y(boolean z) {
        HL3 hl3 = this.q;
        if (hl3 != null) {
            hl3.l(z);
        }
    }

    private void Z(long j2) {
        if (j2 != this.p) {
            return;
        }
        C19406qI3.j("ApiBroker", "StartKeyCreation Auth id invalidated", new Object[0]);
        this.g.b(0L);
        this.g.c(null);
        this.p = 0L;
        this.q = null;
        this.h.c(j2);
        this.r.e(new PP.k(this.f), r());
    }

    private void a0(long j2, byte[] bArr) {
        this.g.b(j2);
        this.g.c(bArr);
        r().d(new h(j2, bArr));
    }

    private void b0(EnumC19739qr4 enumC19739qr4) {
        if (enumC19739qr4 != this.l) {
            this.l = enumC19739qr4;
            HL3 hl3 = this.q;
            if (hl3 != null) {
                hl3.m(enumC19739qr4);
            }
        }
    }

    private void c0(long j2) {
        if (j2 != this.p) {
            return;
        }
        C19406qI3.j("ApiBroker", "New Session Created", new Object[0]);
        this.h.d();
    }

    private void d0(long j2) {
        if (j2 != this.p) {
            return;
        }
        C19406qI3.j("ApiBroker", "StartKeyCreation Auth id invalidated", new Object[0]);
        this.g.b(0L);
        this.g.c(null);
        this.p = 0L;
        this.q = null;
        this.r.e(new PP.k(this.f), r());
    }

    private void e0(long j2, TP5 tp5, O66 o66, long j3) {
        byte[] byteArray;
        boolean z;
        long j4;
        String strP = P(tp5);
        if (S(strP)) {
            o66.b(new RpcDisabledException(strP));
            return;
        }
        try {
            byteArray = tp5.toByteArray();
            j4 = j3;
            z = false;
        } catch (Exception e2) {
            C19406qI3.a("performRequest", "error message: " + e2.getMessage(), new Object[0]);
            byteArray = new byte[0];
            z = true;
            j4 = 100L;
        }
        p pVar = new p(AbstractC20507s76.p(), j2, new C10129b76(tp5.q(), byteArray), o66);
        this.m.put(Long.valueOf(pVar.c), pVar);
        HL3 hl3 = this.q;
        if (hl3 != null && !z) {
            long jO = hl3.o(pVar.b);
            StringBuilder sb = new StringBuilder();
            sb.append("-> request#");
            sb.append(jO);
            sb.append(", rid#");
            sb.append(j2);
            sb.append(": ");
            sb.append(Q(tp5));
            sb.append(tp5 instanceof AU5 ? " Proto" : "");
            C19406qI3.a("ApiBroker", sb.toString(), new Object[0]);
            pVar.e = jO;
            this.n.put(Long.valueOf(jO), Long.valueOf(j2));
        }
        if (j4 > 0) {
            C10054b01 c10054b01 = new C10054b01(new s(pVar.c));
            this.o.put(Long.valueOf(pVar.c), c10054b01);
            c10054b01.d(j4);
        }
    }

    private void f0(long j2, long j3, byte[] bArr) {
        boolean z;
        if (j2 != this.p) {
            return;
        }
        try {
            AbstractC24641yx5 abstractC24641yx5C = AbstractC24051xx5.c(bArr);
            if (this.n.containsKey(Long.valueOf(j3))) {
                Long l2 = (Long) this.n.get(Long.valueOf(j3));
                long jLongValue = l2.longValue();
                if (!this.m.containsKey(l2)) {
                    C19406qI3.j("ApiBroker", "return from processResponse with rid: #" + jLongValue + " because it isn't in requests list.", new Object[0]);
                    return;
                }
                final p pVar = (p) this.m.get(l2);
                if (pVar == null) {
                    C19406qI3.j("ApiBroker", "return from processResponse with rid: #" + jLongValue + " because request holder is null!", new Object[0]);
                    return;
                }
                if (abstractC24641yx5C instanceof Z66) {
                    G(jLongValue, pVar);
                    Z66 z66 = (Z66) abstractC24641yx5C;
                    try {
                        AbstractC10365bX5 abstractC10365bX5 = (AbstractC10365bX5) this.s.b(z66.a, z66.b);
                        C19406qI3.a("ApiBroker", "<- response#" + j3 + ", rid#" + jLongValue + ": " + abstractC10365bX5 + " in " + (AbstractC20507s76.p() - pVar.a) + " ms", new Object[0]);
                        abstractC10365bX5.r(pVar.c);
                        pVar.d.a(abstractC10365bX5);
                        return;
                    } catch (IOException e2) {
                        C19406qI3.d("ApiBroker", e2);
                        return;
                    }
                }
                if (abstractC24641yx5C instanceof S66) {
                    G(jLongValue, pVar);
                    final S66 s66 = (S66) abstractC24641yx5C;
                    C19406qI3.j("ApiBroker", "<- request error#" + pVar.c + ": " + s66.b + Separators.SP + s66.a + Separators.SP + s66.c + " in " + (AbstractC20507s76.p() - pVar.a) + " ms", new Object[0]);
                    q(new Runnable() { // from class: ir.nasim.ww
                        @Override // java.lang.Runnable
                        public final void run() {
                            C3672Bw.U(pVar, s66);
                        }
                    }, 200L);
                    return;
                }
                if (abstractC24641yx5C instanceof W66) {
                    W66 w66 = (W66) abstractC24641yx5C;
                    C19406qI3.a("ApiBroker", "<- internal_error publicId: #" + pVar.c + ", rid: #" + jLongValue + Separators.SP + w66.g() + " sec in " + (AbstractC20507s76.p() - pVar.a) + " ms", new Object[0]);
                    boolean zH = w66.h();
                    boolean z2 = this.o.get(Long.valueOf(pVar.c)) == null;
                    z = this.o.get(Long.valueOf(pVar.c)) != null && ((C10054b01) this.o.get(Long.valueOf(pVar.c))).c() > AbstractC20507s76.p() + (((long) w66.g()) * 1000);
                    if (zH && (z2 || z)) {
                        C19406qI3.a("ApiBroker", "RpcInternalError: ForceResend request with rid: #" + jLongValue, new Object[0]);
                        q(new f(jLongValue), ((long) w66.g()) * 1000);
                        return;
                    }
                    C19406qI3.a("ApiBroker", "RpcInternalError: Cancel request and report exception with rid: #" + jLongValue, new Object[0]);
                    G(jLongValue, pVar);
                    q(new Runnable() { // from class: ir.nasim.xw
                        @Override // java.lang.Runnable
                        public final void run() {
                            C3672Bw.V(pVar);
                        }
                    }, 400L);
                    return;
                }
                if (!(abstractC24641yx5C instanceof U66)) {
                    G(jLongValue, pVar);
                    q(new Runnable() { // from class: ir.nasim.zw
                        @Override // java.lang.Runnable
                        public final void run() {
                            C3672Bw.X(pVar);
                        }
                    }, 400L);
                    C19406qI3.a("ApiBroker", "<- unknown_package publicId: #" + pVar.c + ", rid: #" + jLongValue + " in " + (AbstractC20507s76.p() - pVar.a) + " ms", new Object[0]);
                    return;
                }
                U66 u66 = (U66) abstractC24641yx5C;
                C19406qI3.a("ApiBroker", "<- flood_wait publicId: #" + pVar.c + ", rid: #" + jLongValue + Separators.SP + u66.g() + " sec in " + (AbstractC20507s76.p() - pVar.a) + " ms", new Object[0]);
                boolean z3 = this.o.get(Long.valueOf(pVar.c)) == null;
                z = this.o.get(Long.valueOf(pVar.c)) != null && ((C10054b01) this.o.get(Long.valueOf(pVar.c))).c() > AbstractC20507s76.p() + (((long) u66.g()) * 1000);
                if (z3 || z) {
                    C19406qI3.a("ApiBroker", "RpcFloodWait: ForceResend request with rid: #" + jLongValue, new Object[0]);
                    q(new f(jLongValue), ((long) u66.g()) * 1000);
                    return;
                }
                C19406qI3.a("ApiBroker", "RpcFloodWait: Cancel request and report exception with rid: #" + jLongValue, new Object[0]);
                G(jLongValue, pVar);
                q(new Runnable() { // from class: ir.nasim.yw
                    @Override // java.lang.Runnable
                    public final void run() {
                        C3672Bw.W(pVar);
                    }
                }, 400L);
            }
        } catch (IOException e3) {
            C19406qI3.c("ApiBroker", "Broken response mid#" + j3, e3);
        }
    }

    private void g0(long j2, byte[] bArr) {
        if (j2 != this.p) {
            return;
        }
        try {
            this.h.e(AbstractC24051xx5.e(bArr));
        } catch (IOException e2) {
            C19406qI3.c("ApiBroker", "Broken mt update", e2);
        }
    }

    private void h0() {
        HL3 hl3 = this.q;
        if (hl3 != null) {
            hl3.n();
        }
    }

    void R(InterfaceC16050kd1.a aVar) {
        this.h.b(aVar);
    }

    @Override // ir.nasim.K6
    public void m(Object obj) {
        if (obj instanceof h) {
            h hVar = (h) obj;
            L(hVar.a(), hVar.b());
            return;
        }
        if (obj instanceof k) {
            k kVar = (k) obj;
            e0(kVar.c(), kVar.b(), kVar.a(), kVar.d());
            return;
        }
        if (obj instanceof c) {
            H(((c) obj).a());
            return;
        }
        if (obj instanceof m) {
            m mVar = (m) obj;
            f0(mVar.a(), mVar.c(), mVar.b());
            return;
        }
        if (obj instanceof f) {
            N(((f) obj).a());
            return;
        }
        if (obj instanceof n) {
            n nVar = (n) obj;
            g0(nVar.a(), nVar.b());
            return;
        }
        if (obj instanceof j) {
            c0(((j) obj).a());
            return;
        }
        if (obj instanceof b) {
            Z(((b) obj).a());
            return;
        }
        if (obj instanceof o) {
            d0(((o) obj).a());
            return;
        }
        if (obj instanceof a) {
            Y(((a) obj).a());
            return;
        }
        if (obj instanceof i) {
            b0(((i) obj).a());
            return;
        }
        if (obj instanceof e) {
            M();
            return;
        }
        if (obj instanceof q) {
            h0();
            return;
        }
        if (obj instanceof d) {
            K(((d) obj).a());
            return;
        }
        if (obj instanceof g) {
            R(((g) obj).a());
            return;
        }
        if (obj instanceof PP.f) {
            PP.f fVar = (PP.f) obj;
            a0(fVar.b(), fVar.a());
        } else if (obj instanceof r) {
            n();
        } else {
            super.m(obj);
        }
    }

    @Override // ir.nasim.K6
    public void n() {
        HL3 hl3 = this.q;
        if (hl3 != null) {
            hl3.p();
            this.q = null;
        }
    }

    @Override // ir.nasim.K6
    public void o() {
        this.p = this.g.d();
        this.r = C12736f7.n().d(f() + "/key", new V6() { // from class: ir.nasim.Aw
            @Override // ir.nasim.V6
            public final K6 create() {
                return new PP();
            }
        });
        if (this.p != 0) {
            r().d(new h(this.p, this.g.a()));
        } else {
            C19406qI3.a("ApiBroker", "StartKeyCreation authKey is zero", new Object[0]);
            this.r.e(new PP.k(this.f), r());
        }
    }
}
