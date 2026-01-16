package ir.nasim;

import java.util.ArrayList;

/* renamed from: ir.nasim.l67, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC16343l67 extends AbstractC12724f57 {
    public String b;
    public long c;
    public String d;
    public ArrayList e = new ArrayList();

    public static AbstractC16343l67 d(T1 t1, int i, boolean z) {
        AbstractC16343l67 c5657Kg7;
        switch (i) {
            case -1678197867:
                c5657Kg7 = new C5657Kg7();
                break;
            case -1054465340:
                c5657Kg7 = new C6363Ng7();
                break;
            case -939827711:
                c5657Kg7 = new C6124Mg7();
                break;
            case -653089380:
                c5657Kg7 = new C4721Gg7();
                break;
            case -599948721:
                c5657Kg7 = new C4004Dg7();
                break;
            case -564523562:
                c5657Kg7 = new C3770Cg7();
                break;
            case -311786236:
                c5657Kg7 = new C5891Lg7();
                break;
            case 55281185:
                c5657Kg7 = new C4955Hg7();
                break;
            case 136105807:
                c5657Kg7 = new C4472Fg7();
                break;
            case 483104362:
                c5657Kg7 = new C5189Ig7();
                break;
            case 894777186:
                c5657Kg7 = new C25069zg7();
                break;
            case 1009288385:
                c5657Kg7 = new C6618Og7();
                break;
            case 1730456516:
                c5657Kg7 = new C3297Ag7();
                break;
            case 1816074681:
                c5657Kg7 = new C4238Eg7();
                break;
            case 1950782688:
                c5657Kg7 = new C5423Jg7();
                break;
            case 2120376535:
                c5657Kg7 = new C3536Bg7();
                break;
            default:
                c5657Kg7 = null;
                break;
        }
        if (c5657Kg7 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in RichText", Integer.valueOf(i)));
        }
        if (c5657Kg7 != null) {
            c5657Kg7.b(t1, z);
        }
        return c5657Kg7;
    }
}
