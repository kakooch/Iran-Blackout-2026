package ir.nasim;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: ir.nasim.iX7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C14819iX7 {
    private final Map a = new LinkedHashMap();

    public final void a() {
        Iterator it = this.a.values().iterator();
        while (it.hasNext()) {
            ((VW7) it.next()).J0();
        }
        this.a.clear();
    }

    public final VW7 b(String str) {
        AbstractC13042fc3.i(str, "key");
        return (VW7) this.a.get(str);
    }

    public final Set c() {
        return new HashSet(this.a.keySet());
    }

    public final void d(String str, VW7 vw7) {
        AbstractC13042fc3.i(str, "key");
        AbstractC13042fc3.i(vw7, "viewModel");
        VW7 vw72 = (VW7) this.a.put(str, vw7);
        if (vw72 != null) {
            vw72.J0();
        }
    }
}
