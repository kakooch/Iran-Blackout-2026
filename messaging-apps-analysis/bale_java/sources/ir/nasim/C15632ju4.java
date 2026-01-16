package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: ir.nasim.ju4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C15632ju4 extends AbstractC12750f83 {
    private static final Pattern e = Pattern.compile(" *$");

    @Override // ir.nasim.AbstractC12750f83
    protected TA4 e() {
        this.d++;
        TA4 ta4D = this.b.d();
        if (ta4D instanceof C5693Kk7) {
            C5693Kk7 c5693Kk7 = (C5693Kk7) ta4D;
            if (c5693Kk7.m().endsWith(Separators.SP)) {
                String strM = c5693Kk7.m();
                Matcher matcher = e.matcher(strM);
                int iEnd = matcher.find() ? matcher.end() - matcher.start() : 0;
                if (iEnd > 0) {
                    c5693Kk7.n(strM.substring(0, strM.length() - iEnd));
                }
                return iEnd >= 2 ? new C17149mU2() : new C19991rH6();
            }
        }
        return new C19991rH6();
    }

    @Override // ir.nasim.AbstractC12750f83
    public char m() {
        return '\n';
    }
}
