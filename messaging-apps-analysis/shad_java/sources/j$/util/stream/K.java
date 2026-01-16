package j$.util.stream;

import j$.util.function.Function;
import j$.wrappers.C0284k0;

/* loaded from: classes2.dex */
class K extends S {
    public final /* synthetic */ int l = 4;
    final /* synthetic */ Object m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public K(T t, AbstractC0128c abstractC0128c, EnumC0151f4 enumC0151f4, int i, j$.util.function.f fVar) {
        super(abstractC0128c, enumC0151f4, i);
        this.m = fVar;
    }

    @Override // j$.util.stream.AbstractC0128c
    InterfaceC0192m3 I0(int i, InterfaceC0192m3 interfaceC0192m3) {
        switch (this.l) {
            case 0:
                return new J(this, interfaceC0192m3);
            case 1:
                return new J(this, interfaceC0192m3, (j$.lang.a) null);
            case 2:
                return new J(this, interfaceC0192m3, (j$.lang.b) null);
            case 3:
                return new J(this, interfaceC0192m3, (j$.lang.c) null);
            case 4:
                return new F0(this, interfaceC0192m3);
            case 5:
                return new Z0(this, interfaceC0192m3);
            case 6:
                return new Y2(this, interfaceC0192m3);
            default:
                return new r(this, interfaceC0192m3);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public K(T t, AbstractC0128c abstractC0128c, EnumC0151f4 enumC0151f4, int i, j$.util.function.g gVar) {
        super(abstractC0128c, enumC0151f4, i);
        this.m = gVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public K(T t, AbstractC0128c abstractC0128c, EnumC0151f4 enumC0151f4, int i, j$.wrappers.D d) {
        super(abstractC0128c, enumC0151f4, i);
        this.m = d;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public K(T t, AbstractC0128c abstractC0128c, EnumC0151f4 enumC0151f4, int i, j$.wrappers.J j) {
        super(abstractC0128c, enumC0151f4, i);
        this.m = j;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public K(L0 l0, AbstractC0128c abstractC0128c, EnumC0151f4 enumC0151f4, int i, j$.wrappers.W w) {
        super(abstractC0128c, enumC0151f4, i);
        this.m = w;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public K(AbstractC0136d1 abstractC0136d1, AbstractC0128c abstractC0128c, EnumC0151f4 enumC0151f4, int i, C0284k0 c0284k0) {
        super(abstractC0128c, enumC0151f4, i);
        this.m = c0284k0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public K(AbstractC0144e3 abstractC0144e3, AbstractC0128c abstractC0128c, EnumC0151f4 enumC0151f4, int i, Function function) {
        super(abstractC0128c, enumC0151f4, i);
        this.m = function;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public K(AbstractC0144e3 abstractC0144e3, AbstractC0128c abstractC0128c, EnumC0151f4 enumC0151f4, int i, j$.util.function.A a) {
        super(abstractC0128c, enumC0151f4, i);
        this.m = a;
    }
}
