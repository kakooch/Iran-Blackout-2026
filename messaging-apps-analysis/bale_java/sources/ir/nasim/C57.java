package ir.nasim;

import java.util.ArrayList;

/* loaded from: classes7.dex */
public abstract class C57 extends AbstractC12724f57 {
    public String b;
    public String c;
    public String d;
    public String e;
    public int f;
    public int g;
    public B57 h;
    public AbstractC24721z57 i;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public int p;
    public int q;
    public boolean r;
    public boolean s;
    public boolean t;
    public AbstractC24721z57 u;
    public String v;
    public int x;
    public boolean y;
    public ArrayList j = new ArrayList();
    public ArrayList w = new ArrayList();

    public static C57 d(T1 t1, int i, boolean z) {
        C57 c13400g97;
        switch (i) {
            case -1771768449:
                c13400g97 = new C13400g97();
                break;
            case -1759532989:
                c13400g97 = new C14589i97();
                break;
            case -1279654347:
                c13400g97 = new C15782k97();
                break;
            case -1052959727:
                c13400g97 = new C18737p97();
                break;
            case -750828557:
                c13400g97 = new C13991h97();
                break;
            case -440664550:
                c13400g97 = new C16373l97();
                break;
            case -428884101:
                c13400g97 = new C11530d97();
                break;
            case -122978821:
                c13400g97 = new C10766c97();
                break;
            case -104578748:
                c13400g97 = new C15191j97();
                break;
            case -78455655:
                c13400g97 = new C12764f97();
                break;
            case 261416433:
                c13400g97 = new C16964m97();
                break;
            case 505969924:
                c13400g97 = new C18146o97();
                break;
            case 860303448:
                c13400g97 = new C12173e97();
                break;
            case 1530447553:
                c13400g97 = new C17555n97();
                break;
            default:
                c13400g97 = null;
                break;
        }
        if (c13400g97 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in InputMedia", Integer.valueOf(i)));
        }
        if (c13400g97 != null) {
            c13400g97.b(t1, z);
        }
        return c13400g97;
    }
}
