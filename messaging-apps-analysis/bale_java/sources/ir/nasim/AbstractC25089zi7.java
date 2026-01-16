package ir.nasim;

import java.util.ArrayList;

/* renamed from: ir.nasim.zi7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC25089zi7 extends AbstractC12724f57 {
    public int b;
    public long c;
    public String d;
    public String e;
    public int f;
    public String g;
    public String h;
    public String i;
    public String j;
    public AbstractC10736c67 k;
    public String l;
    public String m;
    public int n;
    public int o;
    public int p;
    public String q;
    public AbstractC18106o57 r;
    public V57 s;
    public int t;
    public ArrayList u = new ArrayList();

    public static AbstractC25089zi7 d(T1 t1, int i, boolean z) {
        AbstractC25089zi7 c14315hi7;
        switch (i) {
            case -2054908813:
                c14315hi7 = new C14315hi7();
                break;
            case -1558273867:
                c14315hi7 = new C17879ni7();
                break;
            case -981018084:
                c14315hi7 = new C14925ii7();
                break;
            case -897446185:
                c14315hi7 = new C17288mi7();
                break;
            case -736472729:
                c14315hi7 = new C15515ji7();
                break;
            case -392411726:
                c14315hi7 = new C11263ci7();
                break;
            case -350980120:
                c14315hi7 = new C13133fi7();
                break;
            case -94051982:
                c14315hi7 = new C16697li7();
                break;
            case 1594340540:
                c14315hi7 = new C16106ki7();
                break;
            case 1930545681:
                c14315hi7 = new C13724gi7();
                break;
            default:
                c14315hi7 = null;
                break;
        }
        if (c14315hi7 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in WebPage", Integer.valueOf(i)));
        }
        if (c14315hi7 != null) {
            c14315hi7.b(t1, z);
        }
        return c14315hi7;
    }
}
