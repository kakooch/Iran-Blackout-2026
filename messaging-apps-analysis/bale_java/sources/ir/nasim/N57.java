package ir.nasim;

/* loaded from: classes7.dex */
public abstract class N57 extends AbstractC12724f57 {
    public int b;
    public int c;
    public String d;
    public String e;

    public static N57 d(T1 t1, int i, boolean z) {
        N57 c5144Ib7;
        switch (i) {
            case -2106619040:
                c5144Ib7 = new C5144Ib7();
                break;
            case -1687559349:
                c5144Ib7 = new C6079Mb7();
                break;
            case -1672577397:
                c5144Ib7 = new C7290Rb7();
                break;
            case -1148011883:
                c5144Ib7 = new C7524Sb7();
                break;
            case -1117713463:
                c5144Ib7 = new C3491Bb7();
                break;
            case -1090087980:
                c5144Ib7 = new C6812Pb7();
                break;
            case -925956616:
                c5144Ib7 = new C4427Fb7();
                break;
            case -595914432:
                c5144Ib7 = new C5612Kb7();
                break;
            case -100378723:
                c5144Ib7 = new C5378Jb7();
                break;
            case 34469328:
                c5144Ib7 = new C3252Ab7();
                break;
            case 546203849:
                c5144Ib7 = new C19328q97();
                break;
            case 681706865:
                c5144Ib7 = new C4193Eb7();
                break;
            case 852137487:
                c5144Ib7 = new C6573Ob7();
                break;
            case 892193368:
                c5144Ib7 = new C5846Lb7();
                break;
            case 1280209983:
                c5144Ib7 = new C3959Db7();
                break;
            case 1592721940:
                c5144Ib7 = new C24425yb7();
                break;
            case 1692693954:
                c5144Ib7 = new C4676Gb7();
                break;
            case 1827637959:
                c5144Ib7 = new C3725Cb7();
                break;
            case 1859134776:
                c5144Ib7 = new C7761Tb7();
                break;
            case 1868782349:
                c5144Ib7 = new C4910Hb7();
                break;
            case 1938967520:
                c5144Ib7 = new C6318Nb7();
                break;
            case 1981704948:
                c5144Ib7 = new C25019zb7();
                break;
            case 1990644519:
                c5144Ib7 = new C7056Qb7();
                break;
            default:
                c5144Ib7 = null;
                break;
        }
        if (c5144Ib7 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in MessageEntity", Integer.valueOf(i)));
        }
        if (c5144Ib7 != null) {
            c5144Ib7.b(t1, z);
        }
        return c5144Ib7;
    }
}
