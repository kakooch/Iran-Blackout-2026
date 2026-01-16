package ir.nasim;

import java.util.regex.Pattern;

/* renamed from: ir.nasim.jZ2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C15421jZ2 extends AbstractC12750f83 {
    private static final Pattern e = Pattern.compile("^(?:<[A-Za-z][A-Za-z0-9-]*(?:\\s+[a-zA-Z_:][a-zA-Z0-9:._-]*(?:\\s*=\\s*(?:[^\"'=<>`\\x00-\\x20]+|'[^']*'|\"[^\"]*\"))?)*\\s*/?>|</[A-Za-z][A-Za-z0-9-]*\\s*[>]|<!---->|<!--(?:-?[^>-])(?:-?[^-])*-->|[<][?].*?[?][>]|<![A-Z]+\\s+[^>]*>|<!\\[CDATA\\[[\\s\\S]*?\\]\\]>)", 2);

    @Override // ir.nasim.AbstractC12750f83
    protected TA4 e() {
        String strD = d(e);
        if (strD == null) {
            return null;
        }
        C14832iZ2 c14832iZ2 = new C14832iZ2();
        c14832iZ2.m(strD);
        return c14832iZ2;
    }

    @Override // ir.nasim.AbstractC12750f83
    public char m() {
        return '<';
    }
}
