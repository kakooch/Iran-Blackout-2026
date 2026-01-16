package j$.util.stream;

/* renamed from: j$.util.stream.f1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C0148f1 extends AbstractC0172j1 {
    final /* synthetic */ EnumC0178k1 c;
    final /* synthetic */ j$.util.function.y d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0148f1(EnumC0178k1 enumC0178k1, j$.util.function.y yVar) {
        super(enumC0178k1);
        this.c = enumC0178k1;
        this.d = yVar;
    }

    @Override // j$.util.function.Consumer
    public void accept(Object obj) {
        if (this.a || this.d.test(obj) != this.c.a) {
            return;
        }
        this.a = true;
        this.b = this.c.b;
    }
}
