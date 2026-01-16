package ir.nasim;

import android.net.Uri;
import java.util.Iterator;
import java.util.Set;

/* renamed from: ir.nasim.Se2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC7546Se2 {
    public static final String a(Uri uri, String str) {
        Object next;
        AbstractC13042fc3.i(uri, "<this>");
        AbstractC13042fc3.i(str, "key");
        Set<String> queryParameterNames = uri.getQueryParameterNames();
        AbstractC13042fc3.h(queryParameterNames, "getQueryParameterNames(...)");
        Iterator<T> it = queryParameterNames.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (AbstractC20153rZ6.D((String) next, str, true)) {
                break;
            }
        }
        String str2 = (String) next;
        if (str2 != null) {
            return uri.getQueryParameter(str2);
        }
        return null;
    }
}
