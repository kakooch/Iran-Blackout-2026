package j$.util.stream;

import j$.util.function.InterfaceC0109b;

/* loaded from: classes2.dex */
class D2 extends U2 {
    public final /* synthetic */ int b = 1;
    final /* synthetic */ Object c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public D2(EnumC0151f4 enumC0151f4, InterfaceC0109b interfaceC0109b) {
        super(enumC0151f4);
        this.c = interfaceC0109b;
    }

    @Override // j$.util.stream.U2
    public S2 b() {
        switch (this.b) {
            case 0:
                return new E2((j$.util.function.d) this.c);
            case 1:
                return new H2((InterfaceC0109b) this.c);
            case 2:
                return new N2((j$.util.function.j) this.c);
            default:
                return new R2((j$.util.function.o) this.c);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public D2(EnumC0151f4 enumC0151f4, j$.util.function.d dVar) {
        super(enumC0151f4);
        this.c = dVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public D2(EnumC0151f4 enumC0151f4, j$.util.function.j jVar) {
        super(enumC0151f4);
        this.c = jVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public D2(EnumC0151f4 enumC0151f4, j$.util.function.o oVar) {
        super(enumC0151f4);
        this.c = oVar;
    }
}
