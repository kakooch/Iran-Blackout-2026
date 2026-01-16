package ir.nasim;

import android.graphics.PointF;
import ir.nasim.AW1;
import ir.nasim.AbstractC11911dl3;

/* loaded from: classes2.dex */
public class BW1 implements BQ7 {
    public static final BW1 a = new BW1();
    private static final AbstractC11911dl3.a b = AbstractC11911dl3.a.a("t", "f", "s", "j", "tr", "lh", "ls", "fc", "sc", "sw", "of", "ps", "sz");

    private BW1() {
    }

    @Override // ir.nasim.BQ7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public AW1 a(AbstractC11911dl3 abstractC11911dl3, float f) {
        AW1.a aVar = AW1.a.CENTER;
        abstractC11911dl3.B();
        AW1.a aVar2 = aVar;
        String strT0 = null;
        String strT02 = null;
        PointF pointF = null;
        PointF pointF2 = null;
        float fF1 = 0.0f;
        float fF12 = 0.0f;
        float fF13 = 0.0f;
        float fF14 = 0.0f;
        int iR0 = 0;
        int iD = 0;
        int iD2 = 0;
        boolean zE = true;
        while (abstractC11911dl3.d()) {
            switch (abstractC11911dl3.l(b)) {
                case 0:
                    strT0 = abstractC11911dl3.T0();
                    break;
                case 1:
                    strT02 = abstractC11911dl3.T0();
                    break;
                case 2:
                    fF1 = (float) abstractC11911dl3.f1();
                    break;
                case 3:
                    int iR02 = abstractC11911dl3.r0();
                    aVar2 = AW1.a.CENTER;
                    if (iR02 <= aVar2.ordinal() && iR02 >= 0) {
                        aVar2 = AW1.a.values()[iR02];
                        break;
                    } else {
                        break;
                    }
                    break;
                case 4:
                    iR0 = abstractC11911dl3.r0();
                    break;
                case 5:
                    fF12 = (float) abstractC11911dl3.f1();
                    break;
                case 6:
                    fF13 = (float) abstractC11911dl3.f1();
                    break;
                case 7:
                    iD = AbstractC20878sl3.d(abstractC11911dl3);
                    break;
                case 8:
                    iD2 = AbstractC20878sl3.d(abstractC11911dl3);
                    break;
                case 9:
                    fF14 = (float) abstractC11911dl3.f1();
                    break;
                case 10:
                    zE = abstractC11911dl3.e();
                    break;
                case 11:
                    abstractC11911dl3.b();
                    PointF pointF3 = new PointF(((float) abstractC11911dl3.f1()) * f, ((float) abstractC11911dl3.f1()) * f);
                    abstractC11911dl3.c();
                    pointF = pointF3;
                    break;
                case 12:
                    abstractC11911dl3.b();
                    PointF pointF4 = new PointF(((float) abstractC11911dl3.f1()) * f, ((float) abstractC11911dl3.f1()) * f);
                    abstractC11911dl3.c();
                    pointF2 = pointF4;
                    break;
                default:
                    abstractC11911dl3.m();
                    abstractC11911dl3.R();
                    break;
            }
        }
        abstractC11911dl3.F();
        return new AW1(strT0, strT02, fF1, aVar2, iR0, fF12, fF13, iD, iD2, fF14, zE, pointF, pointF2);
    }
}
