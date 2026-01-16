package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* renamed from: ir.nasim.nG3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C17615nG3 {
    private final List a;
    private final Set b;
    private final Set c;

    public C17615nG3(List list, Set set, Set set2) {
        AbstractC13042fc3.i(list, DialogEntity.TABLE_NAME);
        AbstractC13042fc3.i(set, "loadedPeerUids");
        AbstractC13042fc3.i(set2, "errors");
        this.a = list;
        this.b = set;
        this.c = set2;
    }

    public final List a() {
        return this.a;
    }

    public final Set b() {
        return this.c;
    }

    public final Set c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C17615nG3)) {
            return false;
        }
        C17615nG3 c17615nG3 = (C17615nG3) obj;
        return AbstractC13042fc3.d(this.a, c17615nG3.a) && AbstractC13042fc3.d(this.b, c17615nG3.b) && AbstractC13042fc3.d(this.c, c17615nG3.c);
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "LoadUnreadResult(dialogs=" + this.a + ", loadedPeerUids=" + this.b + ", errors=" + this.c + Separators.RPAREN;
    }

    public /* synthetic */ C17615nG3(List list, Set set, Set set2, int i, ED1 ed1) {
        this((i & 1) != 0 ? new ArrayList() : list, (i & 2) != 0 ? new LinkedHashSet() : set, (i & 4) != 0 ? new LinkedHashSet() : set2);
    }
}
