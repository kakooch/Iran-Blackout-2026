package j$.util.stream;

import java.util.Arrays;

/* loaded from: classes2.dex */
final class J3 extends Q {
    J3(AbstractC0128c abstractC0128c) {
        super(abstractC0128c, EnumC0151f4.DOUBLE_VALUE, EnumC0145e4.q | EnumC0145e4.o);
    }

    @Override // j$.util.stream.AbstractC0128c
    public A1 F0(AbstractC0256y2 abstractC0256y2, j$.util.t tVar, j$.util.function.m mVar) {
        if (EnumC0145e4.SORTED.d(abstractC0256y2.t0())) {
            return abstractC0256y2.q0(tVar, false, mVar);
        }
        double[] dArr = (double[]) ((InterfaceC0235u1) abstractC0256y2.q0(tVar, true, mVar)).g();
        Arrays.sort(dArr);
        return new T1(dArr);
    }

    @Override // j$.util.stream.AbstractC0128c
    public InterfaceC0192m3 I0(int i, InterfaceC0192m3 interfaceC0192m3) {
        interfaceC0192m3.getClass();
        return EnumC0145e4.SORTED.d(i) ? interfaceC0192m3 : EnumC0145e4.SIZED.d(i) ? new O3(interfaceC0192m3) : new G3(interfaceC0192m3);
    }
}
