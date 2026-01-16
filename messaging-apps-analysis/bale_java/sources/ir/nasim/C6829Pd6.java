package ir.nasim;

/* renamed from: ir.nasim.Pd6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C6829Pd6 {
    private final C7631Sn6 a;
    private final int b;
    private final C25005za3 c;
    private final InterfaceC11379cu3 d;

    public C6829Pd6(C7631Sn6 c7631Sn6, int i, C25005za3 c25005za3, InterfaceC11379cu3 interfaceC11379cu3) {
        this.a = c7631Sn6;
        this.b = i;
        this.c = c25005za3;
        this.d = interfaceC11379cu3;
    }

    public final InterfaceC11379cu3 a() {
        return this.d;
    }

    public final int b() {
        return this.b;
    }

    public final C7631Sn6 c() {
        return this.a;
    }

    public final C25005za3 d() {
        return this.c;
    }

    public String toString() {
        return "ScrollCaptureCandidate(node=" + this.a + ", depth=" + this.b + ", viewportBoundsInWindow=" + this.c + ", coordinates=" + this.d + ')';
    }
}
