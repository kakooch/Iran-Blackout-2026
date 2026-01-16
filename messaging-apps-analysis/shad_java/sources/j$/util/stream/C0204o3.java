package j$.util.stream;

/* renamed from: j$.util.stream.o3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C0204o3 extends AbstractC0168i3 {
    long b;
    long c;
    final /* synthetic */ C0210p3 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0204o3(C0210p3 c0210p3, InterfaceC0192m3 interfaceC0192m3) {
        super(interfaceC0192m3);
        this.d = c0210p3;
        this.b = c0210p3.l;
        long j = c0210p3.m;
        this.c = j < 0 ? Long.MAX_VALUE : j;
    }

    @Override // j$.util.function.Consumer
    public void accept(Object obj) {
        long j = this.b;
        if (j != 0) {
            this.b = j - 1;
            return;
        }
        long j2 = this.c;
        if (j2 > 0) {
            this.c = j2 - 1;
            this.a.accept((InterfaceC0192m3) obj);
        }
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public void o(long j) {
        this.a.o(B3.c(j, this.d.l, this.c));
    }

    @Override // j$.util.stream.AbstractC0168i3, j$.util.stream.InterfaceC0192m3
    public boolean p() {
        return this.c == 0 || this.a.p();
    }
}
