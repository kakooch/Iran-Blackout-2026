package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.Zu, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C9403Zu {
    private final List a;
    private final C8894Xu b;

    public C9403Zu(List list, C8894Xu c8894Xu) {
        AbstractC13042fc3.i(list, "commonGroups");
        this.a = list;
        this.b = c8894Xu;
    }

    public final C8894Xu a() {
        return this.b;
    }

    public final List b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C9403Zu)) {
            return false;
        }
        C9403Zu c9403Zu = (C9403Zu) obj;
        return AbstractC13042fc3.d(this.a, c9403Zu.a) && AbstractC13042fc3.d(this.b, c9403Zu.b);
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        C8894Xu c8894Xu = this.b;
        return iHashCode + (c8894Xu == null ? 0 : c8894Xu.hashCode());
    }

    public String toString() {
        return "AnonymousUserUIState(commonGroups=" + this.a + ", anonymousUser=" + this.b + Separators.RPAREN;
    }
}
