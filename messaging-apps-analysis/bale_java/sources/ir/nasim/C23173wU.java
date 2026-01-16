package ir.nasim;

import java.util.regex.Pattern;

/* renamed from: ir.nasim.wU, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C23173wU extends AbstractC12750f83 {
    private static final Pattern e = Pattern.compile("^<([a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*)>");
    private static final Pattern f = Pattern.compile("^<[a-zA-Z][a-zA-Z0-9.+-]{1,31}:[^<>\u0000- ]*>");

    @Override // ir.nasim.AbstractC12750f83
    protected TA4 e() {
        String strD = d(e);
        if (strD != null) {
            String strSubstring = strD.substring(1, strD.length() - 1);
            C9452Zz3 c9452Zz3 = new C9452Zz3("mailto:" + strSubstring, null);
            c9452Zz3.b(new C5693Kk7(strSubstring));
            return c9452Zz3;
        }
        String strD2 = d(f);
        if (strD2 == null) {
            return null;
        }
        String strSubstring2 = strD2.substring(1, strD2.length() - 1);
        C9452Zz3 c9452Zz32 = new C9452Zz3(strSubstring2, null);
        c9452Zz32.b(new C5693Kk7(strSubstring2));
        return c9452Zz32;
    }

    @Override // ir.nasim.AbstractC12750f83
    public char m() {
        return '<';
    }
}
