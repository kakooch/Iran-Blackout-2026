package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.HashMap;
import java.util.Map;

/* renamed from: ir.nasim.jg6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C15494jg6 {
    public static final a h = new a(null);
    private final String a;
    private final Integer b;
    private final Integer c;
    private final Long d;
    private final Integer e;
    private final Integer f;
    private final Boolean g;

    /* renamed from: ir.nasim.jg6$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C15494jg6(String str, Integer num, Integer num2, Long l, Integer num3, Integer num4, Boolean bool) {
        AbstractC13042fc3.i(str, "queryText");
        this.a = str;
        this.b = num;
        this.c = num2;
        this.d = l;
        this.e = num3;
        this.f = num4;
        this.g = bool;
    }

    public final void a() {
        C3343Am.i("market_search", c());
    }

    public final HashMap b() {
        HashMap map = new HashMap();
        map.put("query_text", this.a);
        Integer num = this.b;
        if (num != null) {
            map.put("vertical_position", Integer.valueOf(num.intValue()));
        }
        Integer num2 = this.c;
        if (num2 != null) {
            map.put("horizontal_position", Integer.valueOf(num2.intValue()));
        }
        Long l = this.d;
        if (l != null) {
            map.put(DialogEntity.COLUMN_RID, Long.valueOf(l.longValue()));
        }
        Integer num3 = this.e;
        if (num3 != null) {
            map.put("peer_id", Integer.valueOf(num3.intValue()));
        }
        Integer num4 = this.f;
        if (num4 != null) {
            map.put("peer_id", Integer.valueOf(num4.intValue()));
        }
        Boolean bool = this.g;
        if (bool != null) {
            map.put("is_ad", bool);
        }
        return map;
    }

    public final HashMap c() {
        HashMap map = new HashMap();
        for (Map.Entry entry : b().entrySet()) {
            map.put(entry.getKey(), entry.getValue().toString());
        }
        return map;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C15494jg6)) {
            return false;
        }
        C15494jg6 c15494jg6 = (C15494jg6) obj;
        return AbstractC13042fc3.d(this.a, c15494jg6.a) && AbstractC13042fc3.d(this.b, c15494jg6.b) && AbstractC13042fc3.d(this.c, c15494jg6.c) && AbstractC13042fc3.d(this.d, c15494jg6.d) && AbstractC13042fc3.d(this.e, c15494jg6.e) && AbstractC13042fc3.d(this.f, c15494jg6.f) && AbstractC13042fc3.d(this.g, c15494jg6.g);
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        Integer num = this.b;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.c;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Long l = this.d;
        int iHashCode4 = (iHashCode3 + (l == null ? 0 : l.hashCode())) * 31;
        Integer num3 = this.e;
        int iHashCode5 = (iHashCode4 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.f;
        int iHashCode6 = (iHashCode5 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Boolean bool = this.g;
        return iHashCode6 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "SearchEvent(queryText=" + this.a + ", verticalPosition=" + this.b + ", horizontalPosition=" + this.c + ", rid=" + this.d + ", peerId=" + this.e + ", actionType=" + this.f + ", is_add=" + this.g + Separators.RPAREN;
    }

    public /* synthetic */ C15494jg6(String str, Integer num, Integer num2, Long l, Integer num3, Integer num4, Boolean bool, int i, ED1 ed1) {
        this(str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : l, (i & 16) != 0 ? null : num3, (i & 32) != 0 ? null : num4, (i & 64) == 0 ? bool : null);
    }
}
