package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.Tp4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC7886Tp4 {
    private final androidx.navigation.p a;
    private final int b;
    private final String c;
    private CharSequence d;
    private Map e;
    private List f;
    private Map g;

    public AbstractC7886Tp4(androidx.navigation.p pVar, int i, String str) {
        AbstractC13042fc3.i(pVar, "navigator");
        this.a = pVar;
        this.b = i;
        this.c = str;
        this.e = new LinkedHashMap();
        this.f = new ArrayList();
        this.g = new LinkedHashMap();
    }

    public androidx.navigation.i a() {
        androidx.navigation.i iVarA = this.a.a();
        iVarA.Q(this.d);
        for (Map.Entry entry : this.e.entrySet()) {
            iVarA.h((String) entry.getKey(), (androidx.navigation.b) entry.getValue());
        }
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            iVarA.i((androidx.navigation.g) it.next());
        }
        for (Map.Entry entry2 : this.g.entrySet()) {
            int iIntValue = ((Number) entry2.getKey()).intValue();
            AbstractC18350oW3.a(entry2.getValue());
            iVarA.O(iIntValue, null);
        }
        String str = this.c;
        if (str != null) {
            iVarA.S(str);
        }
        int i = this.b;
        if (i != -1) {
            iVarA.P(i);
        }
        return iVarA;
    }

    public final String b() {
        return this.c;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AbstractC7886Tp4(androidx.navigation.p pVar, String str) {
        this(pVar, -1, str);
        AbstractC13042fc3.i(pVar, "navigator");
    }
}
