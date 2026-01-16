package ir.nasim;

import ir.nasim.AbstractC9998au2;

/* renamed from: ir.nasim.Zl7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC9330Zl7 {
    private static final String a = AbstractC20153rZ6.I("H", 10);

    public static final long a(C9348Zn7 c9348Zn7, WH1 wh1, AbstractC9998au2.b bVar, String str, int i) {
        InterfaceC10355bW4 interfaceC10355bW4A = AbstractC13605gW4.a(str, c9348Zn7, AbstractC19606qe1.b(0, 0, 0, 0, 15, null), wh1, bVar, (64 & 32) != 0 ? AbstractC10360bX0.m() : AbstractC10360bX0.m(), (64 & 64) != 0 ? AbstractC10360bX0.m() : null, (64 & 128) != 0 ? Integer.MAX_VALUE : i, (64 & 256) != 0 ? AbstractC23365wn7.a.a() : AbstractC23365wn7.a.a());
        return C4414Fa3.c((AbstractC3815Cl7.a(interfaceC10355bW4A.e()) << 32) | (AbstractC3815Cl7.a(interfaceC10355bW4A.getHeight()) & 4294967295L));
    }

    public static /* synthetic */ long b(C9348Zn7 c9348Zn7, WH1 wh1, AbstractC9998au2.b bVar, String str, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            str = a;
        }
        if ((i2 & 16) != 0) {
            i = 1;
        }
        return a(c9348Zn7, wh1, bVar, str, i);
    }

    public static final String c() {
        return a;
    }
}
