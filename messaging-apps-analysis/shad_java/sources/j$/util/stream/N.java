package j$.util.stream;

import j$.util.function.Function;
import j$.wrappers.C0280i0;

/* loaded from: classes2.dex */
class N extends AbstractC0130c1 {
    public final /* synthetic */ int l = 1;
    final /* synthetic */ Object m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public N(T t, AbstractC0128c abstractC0128c, EnumC0151f4 enumC0151f4, int i, j$.util.function.h hVar) {
        super(abstractC0128c, enumC0151f4, i);
        this.m = hVar;
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
                return new Z0(this, interfaceC0192m3, (j$.lang.a) null);
            case 4:
                return new Z0(this, interfaceC0192m3, (j$.lang.b) null);
            case 5:
                return new Z0(this, interfaceC0192m3, (j$.lang.c) null);
            case 6:
                return new r(this, interfaceC0192m3);
            default:
                return new Y2(this, interfaceC0192m3);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public N(L0 l0, AbstractC0128c abstractC0128c, EnumC0151f4 enumC0151f4, int i, j$.util.function.n nVar) {
        super(abstractC0128c, enumC0151f4, i);
        this.m = nVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public N(AbstractC0136d1 abstractC0136d1, AbstractC0128c abstractC0128c, EnumC0151f4 enumC0151f4, int i, j$.util.function.q qVar) {
        super(abstractC0128c, enumC0151f4, i);
        this.m = qVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public N(AbstractC0136d1 abstractC0136d1, AbstractC0128c abstractC0128c, EnumC0151f4 enumC0151f4, int i, j$.util.function.r rVar) {
        super(abstractC0128c, enumC0151f4, i);
        this.m = rVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public N(AbstractC0136d1 abstractC0136d1, AbstractC0128c abstractC0128c, EnumC0151f4 enumC0151f4, int i, j$.util.function.t tVar) {
        super(abstractC0128c, enumC0151f4, i);
        this.m = tVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public N(AbstractC0136d1 abstractC0136d1, AbstractC0128c abstractC0128c, EnumC0151f4 enumC0151f4, int i, C0280i0 c0280i0) {
        super(abstractC0128c, enumC0151f4, i);
        this.m = c0280i0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public N(AbstractC0144e3 abstractC0144e3, AbstractC0128c abstractC0128c, EnumC0151f4 enumC0151f4, int i, Function function) {
        super(abstractC0128c, enumC0151f4, i);
        this.m = function;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public N(AbstractC0144e3 abstractC0144e3, AbstractC0128c abstractC0128c, EnumC0151f4 enumC0151f4, int i, j$.util.function.B b) {
        super(abstractC0128c, enumC0151f4, i);
        this.m = b;
    }
}
