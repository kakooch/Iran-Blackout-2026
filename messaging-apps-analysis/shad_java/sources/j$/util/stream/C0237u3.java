package j$.util.stream;

/* renamed from: j$.util.stream.u3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C0237u3 extends AbstractC0162h3 {
    long b;
    long c;
    final /* synthetic */ C0242v3 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0237u3(C0242v3 c0242v3, InterfaceC0192m3 interfaceC0192m3) {
        super(interfaceC0192m3);
        this.d = c0242v3;
        this.b = c0242v3.l;
        long j = c0242v3.m;
        this.c = j < 0 ? Long.MAX_VALUE : j;
    }

    @Override // j$.util.stream.InterfaceC0186l3, j$.util.function.q
    public void accept(long j) {
        long j2 = this.b;
        if (j2 != 0) {
            this.b = j2 - 1;
            return;
        }
        long j3 = this.c;
        if (j3 > 0) {
            this.c = j3 - 1;
            this.a.accept(j);
        }
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public void o(long j) {
        this.a.o(B3.c(j, this.d.l, this.c));
    }

    @Override // j$.util.stream.AbstractC0162h3, j$.util.stream.InterfaceC0192m3
    public boolean p() {
        return this.c == 0 || this.a.p();
    }
}
