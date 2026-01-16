package ir.nasim;

import ir.nasim.C3672Bw;

/* renamed from: ir.nasim.Zo4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C9354Zo4 {
    public static final a g = new a(null);
    private static final RL h = AbstractC20507s76.f(1);
    private static final TL i = AbstractC20507s76.g(1);
    private final LZ2 a;
    private final RP b;
    private final X66 c;
    private final C20216re4 d;
    private InterfaceC11073ch0 e;
    private final C9528a7 f;

    /* renamed from: ir.nasim.Zo4$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C9354Zo4(LZ2 lz2, RP rp, X66 x66, C20216re4 c20216re4, InterfaceC9947ap4 interfaceC9947ap4, int i2, int i3, int i4) {
        AbstractC13042fc3.i(lz2, "endpoints");
        AbstractC13042fc3.i(rp, "keyStorage");
        AbstractC13042fc3.i(x66, "rpcMetaDataProvider");
        AbstractC13042fc3.i(c20216re4, "metaDataToApiMapValueMapper");
        this.a = lz2;
        this.b = rp;
        this.c = x66;
        this.d = c20216re4;
        this.f = C3672Bw.O(lz2, rp, interfaceC9947ap4, h.a(), i2, i3, i4);
        byte[] bArrA = rp.a();
        if (bArrA != null) {
            if (!(bArrA.length == 0)) {
                this.e = AbstractC7464Rv1.g(new C3848Cp4(bArrA).a());
            }
        }
    }

    public static /* synthetic */ long k(C9354Zo4 c9354Zo4, C22871vx5 c22871vx5, O66 o66, long j, long j2, C16018ka c16018ka, int i2, Object obj) {
        return c9354Zo4.i(c22871vx5, o66, (i2 & 4) != 0 ? 16500L : j, (i2 & 8) != 0 ? -1L : j2, (i2 & 16) != 0 ? null : c16018ka);
    }

    public final synchronized void a(long j) {
        this.f.d(new C3672Bw.c(j));
    }

    public final synchronized void b() {
        this.f.d(new C3672Bw.e());
    }

    public final LZ2 c() {
        return this.a;
    }

    public final synchronized void d(long j, byte[] bArr) {
        AbstractC13042fc3.i(bArr, "masterKey");
        this.f.d(new C3672Bw.h(j, bArr));
    }

    public final synchronized void e(boolean z) {
        this.f.d(new C3672Bw.a(z));
    }

    public final synchronized void f(EnumC19739qr4 enumC19739qr4) {
        this.f.d(new C3672Bw.i(enumC19739qr4));
    }

    public final synchronized void g() {
        this.f.d(new C3672Bw.o(this.b.d()));
    }

    public final long h(C22871vx5 c22871vx5, O66 o66, long j, long j2) {
        AbstractC13042fc3.i(c22871vx5, "protoRpc");
        AbstractC13042fc3.i(o66, "rpcCallback");
        return k(this, c22871vx5, o66, j, j2, null, 16, null);
    }

    public final synchronized long i(C22871vx5 c22871vx5, O66 o66, long j, long j2, C16018ka c16018ka) {
        try {
            AbstractC13042fc3.i(c22871vx5, "protoRpc");
            AbstractC13042fc3.i(o66, "rpcCallback");
            if (j2 == -1) {
                j2 = i.b();
            }
            this.f.d(new C3672Bw.k(j2, new AU5(c22871vx5.a(), c22871vx5.b().toByteArray(), this.d.a(this.c.a(), c16018ka)), o66, j));
        } catch (Throwable th) {
            throw th;
        }
        return j2;
    }

    public final synchronized long j(TP5 tp5, O66 o66, long j, long j2) {
        try {
            AbstractC13042fc3.i(o66, "rpcCallback");
            if (tp5 == null) {
                throw new RuntimeException("Request can't be null");
            }
            if (j2 == -1) {
                j2 = i.b();
            }
            this.f.d(new C3672Bw.k(j2, tp5, o66, j));
        } catch (Throwable th) {
            throw th;
        }
        return j2;
    }

    public final synchronized void l() {
        this.f.d(new C3672Bw.q());
    }

    public final synchronized void m() {
        this.f.d(new C3672Bw.r());
    }
}
