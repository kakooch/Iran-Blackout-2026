package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.Iterator;

/* renamed from: ir.nasim.zF2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C24815zF2 {
    public final C20644sM5 a(String str) {
        AbstractC13042fc3.i(str, "title");
        Iterator it = AbstractC20762sZ6.N0(str, new String[]{Separators.SP}, false, 0, 6, null).iterator();
        String str2 = "";
        while (it.hasNext()) {
            str2 = ((Object) str2) + ((String) it.next()) + "|";
        }
        return new C20644sM5(AbstractC22039uZ6.y1(str2, AbstractC23053wG5.y(0, str2.length() - 1)), EnumC23107wM5.c);
    }
}
