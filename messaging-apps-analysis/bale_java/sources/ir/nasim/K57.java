package ir.nasim;

import java.util.ArrayList;

/* loaded from: classes7.dex */
public abstract class K57 extends AbstractC12724f57 {
    public String b;
    public String c;
    public int d;
    public boolean e;
    public String f;
    public byte[] g;
    public int h;
    public boolean i;
    public G57 j;
    public String k;
    public boolean l;
    public boolean m;
    public long n;
    public G57 o;
    public ArrayList p = new ArrayList();

    public static K57 d(T1 t1, int i, boolean z) {
        K57 c14846ia7;
        switch (i) {
            case -1816527947:
                c14846ia7 = new C14846ia7();
                break;
            case -1598009252:
                c14846ia7 = new C14235ha7();
                break;
            case -1560655744:
                c14846ia7 = new X97();
                break;
            case -1344716869:
                c14846ia7 = new Y97();
                break;
            case -1318425559:
                c14846ia7 = new C12417ea7();
                break;
            case -1144565411:
                c14846ia7 = new C13026fa7();
                break;
            case -802258988:
                c14846ia7 = new C9556a97();
                break;
            case -376962181:
                c14846ia7 = new C10150b97();
                break;
            case -59151553:
                c14846ia7 = new C11010ca7();
                break;
            case 90744648:
                c14846ia7 = new C15435ja7();
                break;
            case 218842764:
                c14846ia7 = new C11774da7();
                break;
            case 280464681:
                c14846ia7 = new C16617la7();
                break;
            case 326529584:
                c14846ia7 = new C17799na7();
                break;
            case 629866245:
                c14846ia7 = new C16026ka7();
                break;
            case 814112961:
                c14846ia7 = new C17208ma7();
                break;
            case 901503851:
                c14846ia7 = new Z97();
                break;
            case 1358175439:
                c14846ia7 = new C10420ba7();
                break;
            case 1748655686:
                c14846ia7 = new C9800aa7();
                break;
            default:
                c14846ia7 = null;
                break;
        }
        if (c14846ia7 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in KeyboardButton", Integer.valueOf(i)));
        }
        if (c14846ia7 != null) {
            c14846ia7.b(t1, z);
        }
        return c14846ia7;
    }
}
