package j$.util.stream;

import j$.util.function.Function;
import j$.util.function.ToIntFunction;
import j$.wrappers.C0264a0;
import j$.wrappers.C0288m0;

/* loaded from: classes2.dex */
class M extends K0 {
    public final /* synthetic */ int l = 1;
    final /* synthetic */ Object m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public M(T t, AbstractC0128c abstractC0128c, EnumC0151f4 enumC0151f4, int i, j$.wrappers.F f) {
        super(abstractC0128c, enumC0151f4, i);
        this.m = f;
    }

    @Override // j$.util.stream.AbstractC0128c
    InterfaceC0192m3 I0(int i, InterfaceC0192m3 interfaceC0192m3) {
        switch (this.l) {
            case 0:
                return new J(this, interfaceC0192m3);
            case 1:
                return new F0(this, interfaceC0192m3);
            case 2:
                return new F0(this, interfaceC0192m3, (j$.lang.a) null);
            case 3:
                return new F0(this, interfaceC0192m3, (j$.lang.b) null);
            case 4:
                return new F0(this, interfaceC0192m3, (j$.lang.c) null);
            case 5:
                return new Z0(this, interfaceC0192m3);
            case 6:
                return new Y2(this, interfaceC0192m3);
            default:
                return new r(this, interfaceC0192m3);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public M(L0 l0, AbstractC0128c abstractC0128c, EnumC0151f4 enumC0151f4, int i, j$.util.function.l lVar) {
        super(abstractC0128c, enumC0151f4, i);
        this.m = lVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public M(L0 l0, AbstractC0128c abstractC0128c, EnumC0151f4 enumC0151f4, int i, j$.util.function.m mVar) {
        super(abstractC0128c, enumC0151f4, i);
        this.m = mVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public M(L0 l0, AbstractC0128c abstractC0128c, EnumC0151f4 enumC0151f4, int i, j$.wrappers.U u) {
        super(abstractC0128c, enumC0151f4, i);
        this.m = u;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public M(L0 l0, AbstractC0128c abstractC0128c, EnumC0151f4 enumC0151f4, int i, C0264a0 c0264a0) {
        super(abstractC0128c, enumC0151f4, i);
        this.m = c0264a0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public M(AbstractC0136d1 abstractC0136d1, AbstractC0128c abstractC0128c, EnumC0151f4 enumC0151f4, int i, C0288m0 c0288m0) {
        super(abstractC0128c, enumC0151f4, i);
        this.m = c0288m0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public M(AbstractC0144e3 abstractC0144e3, AbstractC0128c abstractC0128c, EnumC0151f4 enumC0151f4, int i, Function function) {
        super(abstractC0128c, enumC0151f4, i);
        this.m = function;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public M(AbstractC0144e3 abstractC0144e3, AbstractC0128c abstractC0128c, EnumC0151f4 enumC0151f4, int i, ToIntFunction toIntFunction) {
        super(abstractC0128c, enumC0151f4, i);
        this.m = toIntFunction;
    }
}
