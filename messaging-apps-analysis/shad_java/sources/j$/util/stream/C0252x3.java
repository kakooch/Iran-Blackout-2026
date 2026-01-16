package j$.util.stream;

/* renamed from: j$.util.stream.x3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C0252x3 extends AbstractC0150f3 {
    long b;
    long c;
    final /* synthetic */ C0257y3 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0252x3(C0257y3 c0257y3, InterfaceC0192m3 interfaceC0192m3) {
        super(interfaceC0192m3);
        this.d = c0257y3;
        this.b = c0257y3.l;
        long j = c0257y3.m;
        this.c = j < 0 ? Long.MAX_VALUE : j;
    }

    @Override // j$.util.stream.InterfaceC0174j3, j$.util.stream.InterfaceC0192m3
    public void accept(double d) {
        long j = this.b;
        if (j != 0) {
            this.b = j - 1;
            return;
        }
        long j2 = this.c;
        if (j2 > 0) {
            this.c = j2 - 1;
            this.a.accept(d);
        }
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public void o(long j) {
        this.a.o(B3.c(j, this.d.l, this.c));
    }

    @Override // j$.util.stream.AbstractC0150f3, j$.util.stream.InterfaceC0192m3
    public boolean p() {
        return this.c == 0 || this.a.p();
    }
}
