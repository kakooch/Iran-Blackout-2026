package j$.util.stream;

import j$.util.function.Consumer;

/* loaded from: classes2.dex */
class L extends AbstractC0138d3 {
    public final /* synthetic */ int l = 1;
    final /* synthetic */ Object m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public L(T t, AbstractC0128c abstractC0128c, EnumC0151f4 enumC0151f4, int i, j$.util.function.g gVar) {
        super(abstractC0128c, enumC0151f4, i);
        this.m = gVar;
    }

    @Override // j$.util.stream.AbstractC0128c
    InterfaceC0192m3 I0(int i, InterfaceC0192m3 interfaceC0192m3) {
        switch (this.l) {
            case 0:
                return new J(this, interfaceC0192m3);
            case 1:
                return new F0(this, interfaceC0192m3);
            case 2:
                return new Z0(this, interfaceC0192m3);
            case 3:
                return new Y2(this, interfaceC0192m3);
            default:
                return new Y2(this, interfaceC0192m3, (j$.lang.a) null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public L(L0 l0, AbstractC0128c abstractC0128c, EnumC0151f4 enumC0151f4, int i, j$.util.function.m mVar) {
        super(abstractC0128c, enumC0151f4, i);
        this.m = mVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public L(AbstractC0136d1 abstractC0136d1, AbstractC0128c abstractC0128c, EnumC0151f4 enumC0151f4, int i, j$.util.function.r rVar) {
        super(abstractC0128c, enumC0151f4, i);
        this.m = rVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public L(AbstractC0144e3 abstractC0144e3, AbstractC0128c abstractC0128c, EnumC0151f4 enumC0151f4, int i, Consumer consumer) {
        super(abstractC0128c, enumC0151f4, i);
        this.m = consumer;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public L(AbstractC0144e3 abstractC0144e3, AbstractC0128c abstractC0128c, EnumC0151f4 enumC0151f4, int i, j$.util.function.y yVar) {
        super(abstractC0128c, enumC0151f4, i);
        this.m = yVar;
    }
}
