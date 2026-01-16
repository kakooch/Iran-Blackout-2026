package ir.nasim;

import ir.nasim.AbstractC10274bN4;

/* renamed from: ir.nasim.mS7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C17136mS7 implements InterfaceC10031ax6 {
    public static final C17136mS7 a = new C17136mS7();

    private C17136mS7() {
    }

    @Override // ir.nasim.InterfaceC10031ax6
    public AbstractC10274bN4 a(long j, EnumC12613eu3 enumC12613eu3, WH1 wh1) {
        float fB0 = wh1.B0(HV0.b());
        return new AbstractC10274bN4.b(new CK5(-fB0, 0.0f, Float.intBitsToFloat((int) (j >> 32)) + fB0, Float.intBitsToFloat((int) (j & 4294967295L))));
    }
}
