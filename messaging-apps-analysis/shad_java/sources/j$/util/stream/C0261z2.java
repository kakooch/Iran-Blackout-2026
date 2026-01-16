package j$.util.stream;

import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.InterfaceC0109b;

/* renamed from: j$.util.stream.z2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C0261z2 extends U2 {
    public final /* synthetic */ int b = 3;
    final /* synthetic */ Object c;
    final /* synthetic */ Object d;
    final /* synthetic */ Object e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0261z2(EnumC0151f4 enumC0151f4, BiConsumer biConsumer, BiConsumer biConsumer2, j$.util.function.z zVar) {
        super(enumC0151f4);
        this.c = biConsumer;
        this.d = biConsumer2;
        this.e = zVar;
    }

    @Override // j$.util.stream.U2
    public S2 b() {
        switch (this.b) {
            case 0:
                return new A2((j$.util.function.z) this.e, (j$.util.function.w) this.d, (InterfaceC0109b) this.c);
            case 1:
                return new F2((j$.util.function.z) this.e, (j$.util.function.u) this.d, (InterfaceC0109b) this.c);
            case 2:
                return new G2(this.e, (BiFunction) this.d, (InterfaceC0109b) this.c);
            case 3:
                return new K2((j$.util.function.z) this.e, (BiConsumer) this.d, (BiConsumer) this.c);
            default:
                return new O2((j$.util.function.z) this.e, (j$.util.function.v) this.d, (InterfaceC0109b) this.c);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0261z2(EnumC0151f4 enumC0151f4, InterfaceC0109b interfaceC0109b, BiFunction biFunction, Object obj) {
        super(enumC0151f4);
        this.c = interfaceC0109b;
        this.d = biFunction;
        this.e = obj;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0261z2(EnumC0151f4 enumC0151f4, InterfaceC0109b interfaceC0109b, j$.util.function.u uVar, j$.util.function.z zVar) {
        super(enumC0151f4);
        this.c = interfaceC0109b;
        this.d = uVar;
        this.e = zVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0261z2(EnumC0151f4 enumC0151f4, InterfaceC0109b interfaceC0109b, j$.util.function.v vVar, j$.util.function.z zVar) {
        super(enumC0151f4);
        this.c = interfaceC0109b;
        this.d = vVar;
        this.e = zVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0261z2(EnumC0151f4 enumC0151f4, InterfaceC0109b interfaceC0109b, j$.util.function.w wVar, j$.util.function.z zVar) {
        super(enumC0151f4);
        this.c = interfaceC0109b;
        this.d = wVar;
        this.e = zVar;
    }
}
