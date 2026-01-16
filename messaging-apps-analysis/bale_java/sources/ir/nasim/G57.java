package ir.nasim;

/* loaded from: classes7.dex */
public abstract class G57 extends AbstractC12724f57 {
    public long b;
    public long c;

    public static G57 d(T1 t1, int i, boolean z) {
        G57 p97;
        switch (i) {
            case -1182234929:
                p97 = new P97();
                break;
            case -233744186:
                p97 = new O97();
                break;
            case -138301121:
                p97 = new R97();
                break;
            case 497305826:
                p97 = new Q97();
                break;
            default:
                p97 = null;
                break;
        }
        if (p97 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in InputUser", Integer.valueOf(i)));
        }
        if (p97 != null) {
            p97.b(t1, z);
        }
        return p97;
    }
}
