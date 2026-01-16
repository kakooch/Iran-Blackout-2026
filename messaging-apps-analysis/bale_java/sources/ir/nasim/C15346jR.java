package ir.nasim;

import ai.bale.proto.AuthOuterClass$RequestGetJWTToken;
import ai.bale.proto.AuthOuterClass$ResponseGetJWTToken;
import ir.nasim.core.network.RpcException;

/* renamed from: ir.nasim.jR, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C15346jR {
    private final C9057Yh4 a;
    private UQ b;
    private int c;
    private String d;
    private long e;

    /* renamed from: ir.nasim.jR$a */
    class a implements O66 {
        final /* synthetic */ C7234Qv5 a;

        a(C7234Qv5 c7234Qv5) {
            this.a = c7234Qv5;
        }

        @Override // ir.nasim.O66
        public void b(RpcException rpcException) {
            this.a.a(rpcException);
        }

        @Override // ir.nasim.O66
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(AuthOuterClass$ResponseGetJWTToken authOuterClass$ResponseGetJWTToken) {
            this.a.b(authOuterClass$ResponseGetJWTToken.getJwt().getValue());
            C15346jR.this.d = authOuterClass$ResponseGetJWTToken.getJwt().getValue();
            C15346jR.this.a.x().putString("auth_jwt", C15346jR.this.d);
        }
    }

    public C15346jR(C9057Yh4 c9057Yh4) {
        this.a = c9057Yh4;
        this.c = c9057Yh4.x().getInt("auth_uid", 0);
        this.d = c9057Yh4.x().e("auth_jwt");
        this.e = c9057Yh4.x().getLong("auth_phone", 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(PQ pq, C7234Qv5 c7234Qv5) {
        this.b = UQ.f;
        C13923h3 c13923h3 = C13923h3.a;
        this.c = c13923h3.m();
        this.d = pq.a();
        this.a.j0(true);
        this.a.W().p0().e(pq.b());
        AbstractC18427oe4 abstractC18427oe4H = this.a.H();
        if (abstractC18427oe4H != null) {
            abstractC18427oe4H.e1();
        }
        this.a.x().g("auth_yes", true);
        this.a.x().putInt("auth_uid", this.c);
        this.a.x().putString("auth_jwt", this.d);
        this.a.x().putLong("auth_access_hash", c13923h3.k().getAccessHash());
        this.a.x().putLong("auth_phone", this.e);
        c13923h3.x(true);
        c7234Qv5.b(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(C7234Qv5 c7234Qv5) {
        this.a.s().C(new C22871vx5("/bale.auth.v1.Auth/GetJWTToken", AuthOuterClass$RequestGetJWTToken.newBuilder().a(), AuthOuterClass$ResponseGetJWTToken.getDefaultInstance()), new a(c7234Qv5));
    }

    private void t() {
        if (!C13923h3.a.t()) {
            this.b = UQ.c;
        } else {
            this.b = UQ.f;
            this.a.j0(false);
        }
    }

    public C6517Nv5 f(final PQ pq) {
        return new C6517Nv5(new InterfaceC6990Pv5() { // from class: ir.nasim.hR
            @Override // ir.nasim.InterfaceC6990Pv5
            public final void a(C7234Qv5 c7234Qv5) {
                this.a.l(pq, c7234Qv5);
            }
        });
    }

    public C6517Nv5 g() {
        return this.b == UQ.f ? new C6517Nv5(new InterfaceC6990Pv5() { // from class: ir.nasim.iR
            @Override // ir.nasim.InterfaceC6990Pv5
            public final void a(C7234Qv5 c7234Qv5) {
                this.a.m(c7234Qv5);
            }
        }) : C6517Nv5.F(new RuntimeException("not logged in"));
    }

    public long h() {
        return this.a.x().getLong("auth_id", 0L);
    }

    public byte[] i() {
        return this.a.x().b("auth_master_key");
    }

    public long j() {
        return this.e;
    }

    public boolean k() {
        return this.b == UQ.f;
    }

    public long n() {
        return this.a.x().getLong("auth_access_hash", 0L);
    }

    public String o() {
        return this.d;
    }

    public int p() {
        return this.c;
    }

    public void q(long j) {
        this.e = j;
    }

    public boolean r() {
        if (!k()) {
            return false;
        }
        UQ uqA = UQ.a.a(this.a.c().e("auth_state"), UQ.c);
        return (uqA == UQ.g || uqA == UQ.b) ? false : true;
    }

    public void s() {
        t();
    }
}
