package ir.nasim;

import java.util.ArrayList;

/* renamed from: ir.nasim.f67, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC12734f67 extends AbstractC12724f57 {
    public int b;
    public boolean c;
    public int e;
    public String g;
    public ArrayList d = new ArrayList();
    public ArrayList f = new ArrayList();
    public ArrayList h = new ArrayList();

    public static AbstractC12734f67 d(T1 t1, int i, boolean z) {
        AbstractC12734f67 c16076kf7;
        switch (i) {
            case -1159937629:
                c16076kf7 = new C16076kf7();
                break;
            case -932174686:
                c16076kf7 = new C15485jf7();
                break;
            case -591909213:
                c16076kf7 = new C16667lf7();
                break;
            case 1465219162:
                c16076kf7 = new C14895if7();
                break;
            case 2061444128:
                c16076kf7 = new C14285hf7();
                break;
            default:
                c16076kf7 = null;
                break;
        }
        if (c16076kf7 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in PollResults", Integer.valueOf(i)));
        }
        if (c16076kf7 != null) {
            c16076kf7.b(t1, z);
        }
        return c16076kf7;
    }
}
