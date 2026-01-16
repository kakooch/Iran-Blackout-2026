package ir.nasim;

import java.util.ArrayList;

/* renamed from: ir.nasim.j67, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC15161j67 extends AbstractC12724f57 {
    public int b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public String g;
    public ArrayList h = new ArrayList();

    public static AbstractC15161j67 d(T1 t1, int i, boolean z) {
        AbstractC15161j67 c4712Gf7;
        switch (i) {
            case -2049074735:
                c4712Gf7 = new C4712Gf7();
                break;
            case -2035021048:
                c4712Gf7 = new C3995Df7();
                break;
            case -1606526075:
                c4712Gf7 = new C4463Ff7();
                break;
            case -200242528:
                c4712Gf7 = new C4229Ef7();
                break;
            case 889353612:
                c4712Gf7 = new C4946Hf7();
                break;
            case 1218642516:
                c4712Gf7 = new C3761Cf7();
                break;
            default:
                c4712Gf7 = null;
                break;
        }
        if (c4712Gf7 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in ReplyMarkup", Integer.valueOf(i)));
        }
        if (c4712Gf7 != null) {
            c4712Gf7.b(t1, z);
        }
        return c4712Gf7;
    }
}
