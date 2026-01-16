package ir.nasim;

import java.util.ArrayList;

/* loaded from: classes7.dex */
public abstract class M57 extends AbstractC12724f57 {
    public boolean A;
    public int B;
    public String C;
    public long D;
    public AbstractC23315wi7 E;
    public String b;
    public String c;
    public AbstractC16924m57 d;
    public String e;
    public ArrayList f = new ArrayList();
    public Z87 g;
    public long h;
    public AbstractC10736c67 i;
    public long j;
    public long k;
    public AbstractC20852si7 l;
    public long m;
    public int n;
    public int o;
    public long p;
    public AbstractC10120b67 q;
    public int r;
    public boolean s;
    public boolean t;
    public String u;
    public long v;
    public long w;
    public String x;
    public long y;
    public int z;

    public static M57 d(T1 t1, int i, boolean z) {
        M57 c10430bb7;
        switch (i) {
            case -2132731265:
                c10430bb7 = new C10430bb7();
                break;
            case -1892568281:
                c10430bb7 = new C9231Za7();
                break;
            case -1834538890:
                c10430bb7 = new C6803Pa7();
                break;
            case -1799538451:
                c10430bb7 = new C11815db7();
                break;
            case -1781355374:
                c10430bb7 = new C21392ta7();
                break;
            case -1780220945:
                c10430bb7 = new C3482Ba7();
                break;
            case -1776926890:
                c10430bb7 = new C8976Ya7();
                break;
            case -1730095465:
                c10430bb7 = new C7047Qa7();
                break;
            case -1615153660:
                c10430bb7 = new C7988Ua7();
                break;
            case -1539362612:
                c10430bb7 = new C3716Ca7();
                break;
            case -1503425638:
                c10430bb7 = new C3243Aa7();
                break;
            case -1441072131:
                c10430bb7 = new C16036kb7();
                break;
            case -1434950843:
                c10430bb7 = new C14245hb7();
                break;
            case -1410748418:
                c10430bb7 = new C20772sa7();
                break;
            case -1336546578:
                c10430bb7 = new C22639va7();
                break;
            case -1316338916:
                c10430bb7 = new C19582qb7();
                break;
            case -1297179892:
                c10430bb7 = new C3950Da7();
                break;
            case -1281329567:
                c10430bb7 = new C7752Ta7();
                break;
            case -1262252875:
                c10430bb7 = new C21402tb7();
                break;
            case -1247687078:
                c10430bb7 = new C4418Fa7();
                break;
            case -1230047312:
                c10430bb7 = new C6564Oa7();
                break;
            case -1136350937:
                c10430bb7 = new C14856ib7();
                break;
            case -1119368275:
                c10430bb7 = new C25009za7();
                break;
            case -1065845395:
                c10430bb7 = new C16627lb7();
                break;
            case -1064024032:
                c10430bb7 = new C18991pb7();
                break;
            case -988359047:
                c10430bb7 = new C20163ra7();
                break;
            case -935499028:
                c10430bb7 = new C7281Ra7();
                break;
            case -648257196:
                c10430bb7 = new C13654gb7();
                break;
            case -519864430:
                c10430bb7 = new C5369Ja7();
                break;
            case -404267113:
                c10430bb7 = new C19572qa7();
                break;
            case -365344535:
                c10430bb7 = new C22049ua7();
                break;
            case -339958837:
                c10430bb7 = new C5135Ia7();
                break;
            case -202219658:
                c10430bb7 = new C5837La7();
                break;
            case -123931160:
                c10430bb7 = new C4901Ha7();
                break;
            case -85549226:
                c10430bb7 = new C6309Na7();
                break;
            case -25742243:
                c10430bb7 = new C12427eb7();
                break;
            case 29007925:
                c10430bb7 = new C11020cb7();
                break;
            case 51520707:
                c10430bb7 = new C4667Ga7();
                break;
            case 228168278:
                c10430bb7 = new C18400ob7();
                break;
            case 365886720:
                c10430bb7 = new C23235wa7();
                break;
            case 1007897979:
                c10430bb7 = new C15445jb7();
                break;
            case 1080663248:
                c10430bb7 = new C9810ab7();
                break;
            case 1200788123:
                c10430bb7 = new C13036fb7();
                break;
            case 1205698681:
                c10430bb7 = new C22059ub7();
                break;
            case 1217033015:
                c10430bb7 = new C23825xa7();
                break;
            case 1345295095:
                c10430bb7 = new C8222Va7();
                break;
            case 1371385889:
                c10430bb7 = new C5603Ka7();
                break;
            case 1431655760:
                c10430bb7 = new C20189rb7();
                break;
            case 1431655761:
                c10430bb7 = new C20782sb7();
                break;
            case 1431655762:
                c10430bb7 = new C17809nb7();
                break;
            case 1431655767:
                c10430bb7 = new C6070Ma7();
                break;
            case 1431655925:
                c10430bb7 = new C8722Xa7();
                break;
            case 1431655927:
                c10430bb7 = new C23835xb7();
                break;
            case 1474192222:
                c10430bb7 = new C17218mb7();
                break;
            case 1581055051:
                c10430bb7 = new C24415ya7();
                break;
            case 1991897370:
                c10430bb7 = new C8456Wa7();
                break;
            case 2047704898:
                c10430bb7 = new C7515Sa7();
                break;
            case 2144015272:
                c10430bb7 = new C4184Ea7();
                break;
            default:
                c10430bb7 = null;
                break;
        }
        if (c10430bb7 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in MessageAction", Integer.valueOf(i)));
        }
        if (c10430bb7 != null) {
            c10430bb7.b(t1, z);
        }
        return c10430bb7;
    }
}
