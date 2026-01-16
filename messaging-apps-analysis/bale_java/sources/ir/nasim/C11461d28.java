package ir.nasim;

import ai.bale.proto.PeersStruct$Peer;

/* renamed from: ir.nasim.d28, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C11461d28 extends AbstractC21707u0 {
    private String b;
    private C38 c;
    private InterfaceC8344Vo3 d;
    private VL3 e;
    private C19482qQ7 f;
    private C9057Yh4 g;

    public C11461d28(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        this.b = getClass().getName();
        this.g = c9057Yh4;
        VL3 vl3K = KN6.k("wallets_storage", W38.c(), D18.e, true);
        this.e = vl3K;
        this.d = vl3K.o();
        this.f = new C19482qQ7("default_wallet_id", "");
    }

    public C6517Nv5 A(String str, Long l) {
        return this.c.l(str, l.longValue());
    }

    public C19482qQ7 B() {
        return this.f;
    }

    public C6517Nv5 C(String str, Long l, String str2) {
        return this.c.m(str, l.longValue(), str2);
    }

    public C38 D() {
        return this.c;
    }

    public VL3 E() {
        return this.e;
    }

    public InterfaceC8344Vo3 F() {
        return this.d;
    }

    public C6517Nv5 G(String str, int i) {
        return this.c.n(str, i);
    }

    public C6517Nv5 H() {
        return this.c.o();
    }

    public C6517Nv5 I(String str, C11458d25 c11458d25, long j, long j2, Long l, String str2) {
        return this.c.q(str, (PeersStruct$Peer) PeersStruct$Peer.newBuilder().A(c11458d25.getPeerId()).B(c11458d25.s().q()).a(), j, j2, l.longValue(), str2);
    }

    public C6517Nv5 J(String str, String str2, Long l, EnumC17422mw1 enumC17422mw1, String str3) {
        return this.c.r(str, str2, l.longValue(), enumC17422mw1.q(), str3);
    }

    public C6517Nv5 K() {
        return this.c.s();
    }

    public void L() {
        this.c = new C38(this.g);
    }

    public C6517Nv5 M(String str) {
        return this.c.t(str);
    }
}
