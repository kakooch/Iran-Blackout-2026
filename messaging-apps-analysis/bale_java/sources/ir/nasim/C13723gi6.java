package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.AbstractC17858ng6;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.gi6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C13723gi6 {
    private final AbstractC17858ng6 a;
    private final List b;
    private final List c;
    private final Map d;
    private final List e;

    public C13723gi6(AbstractC17858ng6 abstractC17858ng6, List list, List list2, Map map, List list3) {
        AbstractC13042fc3.i(abstractC17858ng6, "searchBarState");
        AbstractC13042fc3.i(list, "recentSearchModel");
        AbstractC13042fc3.i(list2, "recommendedGroup");
        this.a = abstractC17858ng6;
        this.b = list;
        this.c = list2;
        this.d = map;
        this.e = list3;
    }

    public static /* synthetic */ C13723gi6 b(C13723gi6 c13723gi6, AbstractC17858ng6 abstractC17858ng6, List list, List list2, Map map, List list3, int i, Object obj) {
        if ((i & 1) != 0) {
            abstractC17858ng6 = c13723gi6.a;
        }
        if ((i & 2) != 0) {
            list = c13723gi6.b;
        }
        List list4 = list;
        if ((i & 4) != 0) {
            list2 = c13723gi6.c;
        }
        List list5 = list2;
        if ((i & 8) != 0) {
            map = c13723gi6.d;
        }
        Map map2 = map;
        if ((i & 16) != 0) {
            list3 = c13723gi6.e;
        }
        return c13723gi6.a(abstractC17858ng6, list4, list5, map2, list3);
    }

    public final C13723gi6 a(AbstractC17858ng6 abstractC17858ng6, List list, List list2, Map map, List list3) {
        AbstractC13042fc3.i(abstractC17858ng6, "searchBarState");
        AbstractC13042fc3.i(list, "recentSearchModel");
        AbstractC13042fc3.i(list2, "recommendedGroup");
        return new C13723gi6(abstractC17858ng6, list, list2, map, list3);
    }

    public final List c() {
        return this.b;
    }

    public final List d() {
        return this.c;
    }

    public final Map e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C13723gi6)) {
            return false;
        }
        C13723gi6 c13723gi6 = (C13723gi6) obj;
        return AbstractC13042fc3.d(this.a, c13723gi6.a) && AbstractC13042fc3.d(this.b, c13723gi6.b) && AbstractC13042fc3.d(this.c, c13723gi6.c) && AbstractC13042fc3.d(this.d, c13723gi6.d) && AbstractC13042fc3.d(this.e, c13723gi6.e);
    }

    public final AbstractC17858ng6 f() {
        return this.a;
    }

    public final List g() {
        return this.e;
    }

    public int hashCode() {
        int iHashCode = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        Map map = this.d;
        int iHashCode2 = (iHashCode + (map == null ? 0 : map.hashCode())) * 31;
        List list = this.e;
        return iHashCode2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "SearchUiState(searchBarState=" + this.a + ", recentSearchModel=" + this.b + ", recommendedGroup=" + this.c + ", remoteSearchPeerResult=" + this.d + ", searchMxpPeerResult=" + this.e + Separators.RPAREN;
    }

    public /* synthetic */ C13723gi6(AbstractC17858ng6 abstractC17858ng6, List list, List list2, Map map, List list3, int i, ED1 ed1) {
        this((i & 1) != 0 ? AbstractC17858ng6.b.b : abstractC17858ng6, (i & 2) != 0 ? AbstractC10360bX0.m() : list, (i & 4) != 0 ? AbstractC10360bX0.m() : list2, (i & 8) != 0 ? null : map, (i & 16) != 0 ? null : list3);
    }
}
