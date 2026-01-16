package ir.nasim;

import ir.nasim.AbstractC10274bN4;

/* loaded from: classes.dex */
final class PY2 implements InterfaceC10031ax6 {
    public static final PY2 a = new PY2();

    private PY2() {
    }

    @Override // ir.nasim.InterfaceC10031ax6
    public AbstractC10274bN4 a(long j, EnumC12613eu3 enumC12613eu3, WH1 wh1) {
        float fB0 = wh1.B0(HV0.b());
        return new AbstractC10274bN4.b(new CK5(0.0f, -fB0, Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j & 4294967295L)) + fB0));
    }
}
