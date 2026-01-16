package j$.util.stream;

import j$.util.Comparator$CC;
import java.util.Arrays;
import java.util.Comparator;

/* loaded from: classes2.dex */
final class M3 extends AbstractC0132c3 {
    private final boolean l;
    private final Comparator m;

    M3(AbstractC0128c abstractC0128c) {
        super(abstractC0128c, EnumC0151f4.REFERENCE, EnumC0145e4.q | EnumC0145e4.o);
        this.l = true;
        this.m = Comparator$CC.a();
    }

    M3(AbstractC0128c abstractC0128c, Comparator comparator) {
        super(abstractC0128c, EnumC0151f4.REFERENCE, EnumC0145e4.q | EnumC0145e4.p);
        this.l = false;
        comparator.getClass();
        this.m = comparator;
    }

    @Override // j$.util.stream.AbstractC0128c
    public A1 F0(AbstractC0256y2 abstractC0256y2, j$.util.t tVar, j$.util.function.m mVar) {
        if (EnumC0145e4.SORTED.d(abstractC0256y2.t0()) && this.l) {
            return abstractC0256y2.q0(tVar, false, mVar);
        }
        Object[] objArrR = abstractC0256y2.q0(tVar, true, mVar).r(mVar);
        Arrays.sort(objArrR, this.m);
        return new D1(objArrR);
    }

    @Override // j$.util.stream.AbstractC0128c
    public InterfaceC0192m3 I0(int i, InterfaceC0192m3 interfaceC0192m3) {
        interfaceC0192m3.getClass();
        return (EnumC0145e4.SORTED.d(i) && this.l) ? interfaceC0192m3 : EnumC0145e4.SIZED.d(i) ? new R3(interfaceC0192m3, this.m) : new N3(interfaceC0192m3, this.m);
    }
}
