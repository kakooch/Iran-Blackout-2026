package j$.util.stream;

/* renamed from: j$.util.stream.q, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C0212q extends AbstractC0168i3 {
    boolean b;
    Object c;

    C0212q(C0223s c0223s, InterfaceC0192m3 interfaceC0192m3) {
        super(interfaceC0192m3);
    }

    @Override // j$.util.function.Consumer
    public void accept(Object obj) {
        if (obj == null) {
            if (this.b) {
                return;
            }
            this.b = true;
            InterfaceC0192m3 interfaceC0192m3 = this.a;
            this.c = null;
            interfaceC0192m3.accept((InterfaceC0192m3) null);
            return;
        }
        Object obj2 = this.c;
        if (obj2 == null || !obj.equals(obj2)) {
            InterfaceC0192m3 interfaceC0192m32 = this.a;
            this.c = obj;
            interfaceC0192m32.accept((InterfaceC0192m3) obj);
        }
    }

    @Override // j$.util.stream.AbstractC0168i3, j$.util.stream.InterfaceC0192m3
    public void n() {
        this.b = false;
        this.c = null;
        this.a.n();
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public void o(long j) {
        this.b = false;
        this.c = null;
        this.a.o(-1L);
    }
}
