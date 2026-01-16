package j$.util.stream;

import j$.util.function.Function;

/* renamed from: j$.util.stream.a3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C0120a3 extends AbstractC0138d3 {
    public final /* synthetic */ int l;
    final /* synthetic */ Function m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0120a3(AbstractC0144e3 abstractC0144e3, AbstractC0128c abstractC0128c, EnumC0151f4 enumC0151f4, int i, Function function, int i2) {
        super(abstractC0128c, enumC0151f4, i);
        this.l = i2;
        if (i2 != 1) {
            this.m = function;
        } else {
            this.m = function;
            super(abstractC0128c, enumC0151f4, i);
        }
    }

    @Override // j$.util.stream.AbstractC0128c
    InterfaceC0192m3 I0(int i, InterfaceC0192m3 interfaceC0192m3) {
        switch (this.l) {
            case 0:
                return new Y2(this, interfaceC0192m3);
            default:
                return new Y2(this, interfaceC0192m3, (j$.lang.a) null);
        }
    }
}
