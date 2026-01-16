package ir.nasim;

import java.util.regex.Pattern;

/* renamed from: ir.nasim.s92, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C20523s92 extends AbstractC12750f83 {
    private static final Pattern e = Pattern.compile("^&(?:#x[a-f0-9]{1,6}|#[0-9]{1,7}|[a-z][a-z0-9]{1,31});", 2);

    @Override // ir.nasim.AbstractC12750f83
    protected TA4 e() {
        String strD = d(e);
        if (strD != null) {
            return o(AbstractC13630gZ2.a(strD));
        }
        return null;
    }

    @Override // ir.nasim.AbstractC12750f83
    public char m() {
        return '&';
    }
}
