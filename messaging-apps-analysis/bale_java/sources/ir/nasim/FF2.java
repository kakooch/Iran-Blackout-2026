package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.Iterator;

/* loaded from: classes6.dex */
public final class FF2 {
    public final C20644sM5 a(String str) {
        AbstractC13042fc3.i(str, "query");
        Iterator it = AbstractC20762sZ6.N0(str, new String[]{Separators.SP, "_"}, false, 0, 6, null).iterator();
        String str2 = Separators.LPAREN;
        while (it.hasNext()) {
            str2 = ((Object) str2) + "\\b" + ((String) it.next()) + "\\b|";
        }
        return new C20644sM5(AbstractC22039uZ6.y1(str2, AbstractC23053wG5.y(0, str2.length() - 1)) + Separators.RPAREN, EnumC23107wM5.c);
    }
}
