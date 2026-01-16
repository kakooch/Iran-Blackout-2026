package androidx.transition;

import android.gov.nist.core.Separators;
import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class t {
    public View b;
    public final Map a = new HashMap();
    final ArrayList c = new ArrayList();

    public t(View view) {
        this.b = view;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return this.b == tVar.b && this.a.equals(tVar.a);
    }

    public int hashCode() {
        return (this.b.hashCode() * 31) + this.a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.b + Separators.RETURN) + "    values:";
        for (String str2 : this.a.keySet()) {
            str = str + "    " + str2 + ": " + this.a.get(str2) + Separators.RETURN;
        }
        return str;
    }
}
