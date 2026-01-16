package ir.nasim;

/* loaded from: classes7.dex */
public abstract class W57 extends AbstractC12724f57 {
    public int b;
    public AbstractC11500d67 c;
    public AbstractC12724f57 d;

    public static W57 d(T1 t1, int i, boolean z) {
        W57 c3743Cd7;
        switch (i) {
            case -2143067670:
                c3743Cd7 = new C3743Cd7();
                break;
            case -1879401953:
                c3743Cd7 = new C14886ie7();
                break;
            case -1702174239:
                c3743Cd7 = new C9024Yd7();
                break;
            case -1538310410:
                c3743Cd7 = new C8749Xd7();
                break;
            case -1468953147:
                c3743Cd7 = new C6336Nd7();
                break;
            case -1162877472:
                c3743Cd7 = new C4211Ed7();
                break;
            case -1085412734:
                c3743Cd7 = new C15475je7();
                break;
            case -1076861716:
                c3743Cd7 = new C7779Td7();
                break;
            case -1066346178:
                c3743Cd7 = new C11050ce7();
                break;
            case -840826671:
                c3743Cd7 = new C7308Rd7();
                break;
            case -837994576:
                c3743Cd7 = new C3509Bd7();
                break;
            case -650782469:
                c3743Cd7 = new C7074Qd7();
                break;
            case -640214938:
                c3743Cd7 = new C17839ne7();
                break;
            case -618614392:
                c3743Cd7 = new C6097Md7();
                break;
            case -454524911:
                c3743Cd7 = new C8249Vd7();
                break;
            case -372860542:
                c3743Cd7 = new C10460be7();
                break;
            case -283684427:
                c3743Cd7 = new C4928Hd7();
                break;
            case -248793375:
                c3743Cd7 = new C14275he7();
                break;
            case -229005301:
                c3743Cd7 = new C6591Od7();
                break;
            case 52401552:
                c3743Cd7 = new C13066fe7();
                break;
            case 145955919:
                c3743Cd7 = new C5396Jd7();
                break;
            case 319588707:
                c3743Cd7 = new C13684ge7();
                break;
            case 324435594:
                c3743Cd7 = new C16657le7();
                break;
            case 370236054:
                c3743Cd7 = new C12457ee7();
                break;
            case 391759200:
                c3743Cd7 = new C9840ae7();
                break;
            case 504660880:
                c3743Cd7 = new C8015Ud7();
                break;
            case 641563686:
                c3743Cd7 = new C4694Gd7();
                break;
            case 690781161:
                c3743Cd7 = new C6830Pd7();
                break;
            case 834148991:
                c3743Cd7 = new C3977Dd7();
                break;
            case 972174080:
                c3743Cd7 = new C5630Kd7();
                break;
            case 978896884:
                c3743Cd7 = new C8483Wd7();
                break;
            case 1029399794:
                c3743Cd7 = new C4445Fd7();
                break;
            case 1182402406:
                c3743Cd7 = new C9258Zd7();
                break;
            case 1216809369:
                c3743Cd7 = new C7542Sd7();
                break;
            case 1329878739:
                c3743Cd7 = new C11845de7();
                break;
            case 1705048653:
                c3743Cd7 = new C5162Id7();
                break;
            case 1890305021:
                c3743Cd7 = new C16066ke7();
                break;
            case 1987480557:
                c3743Cd7 = new C5864Ld7();
                break;
            case 2089805750:
                c3743Cd7 = new C17248me7();
                break;
            default:
                c3743Cd7 = null;
                break;
        }
        if (c3743Cd7 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in PageBlock", Integer.valueOf(i)));
        }
        if (c3743Cd7 != null) {
            c3743Cd7.b(t1, z);
        }
        return c3743Cd7;
    }
}
