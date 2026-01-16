package j$.util.stream;

import j$.util.function.BiConsumer;
import j$.util.function.InterfaceC0109b;

/* loaded from: classes2.dex */
class I2 extends U2 {
    final /* synthetic */ InterfaceC0109b b;
    final /* synthetic */ BiConsumer c;
    final /* synthetic */ j$.util.function.z d;
    final /* synthetic */ j$.wrappers.I0 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    I2(EnumC0151f4 enumC0151f4, InterfaceC0109b interfaceC0109b, BiConsumer biConsumer, j$.util.function.z zVar, j$.wrappers.I0 i0) {
        super(enumC0151f4);
        this.b = interfaceC0109b;
        this.c = biConsumer;
        this.d = zVar;
        this.e = i0;
    }

    @Override // j$.util.stream.U2, j$.util.stream.O4
    public int a() {
        if (this.e.b().contains(EnumC0158h.UNORDERED)) {
            return EnumC0145e4.r;
        }
        return 0;
    }

    @Override // j$.util.stream.U2
    public S2 b() {
        return new J2(this.d, this.c, this.b);
    }
}
