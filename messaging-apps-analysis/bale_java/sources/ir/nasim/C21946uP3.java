package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* renamed from: ir.nasim.uP3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C21946uP3 {
    public static final a p = new a(null);
    private final Integer a;
    private final Integer b;
    private final Integer c;
    private final String d;
    private final String e;
    private final Integer f;
    private final String g;
    private final Long h;
    private final String i;
    private final Integer j;
    private final Long k;
    private final String l;
    private final Integer m;
    private final Integer n;
    private final Integer o;

    /* renamed from: ir.nasim.uP3$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C21946uP3(Integer num, Integer num2, Integer num3, String str, String str2, Integer num4, String str3, Long l, String str4, Integer num5, Long l2, String str5, Integer num6, Integer num7, Integer num8) {
        this.a = num;
        this.b = num2;
        this.c = num3;
        this.d = str;
        this.e = str2;
        this.f = num4;
        this.g = str3;
        this.h = l;
        this.i = str4;
        this.j = num5;
        this.k = l2;
        this.l = str5;
        this.m = num6;
        this.n = num7;
        this.o = num8;
    }

    public final HashMap a() {
        HashMap map = new HashMap();
        Integer num = this.a;
        if (num != null) {
            map.put("action_type", Integer.valueOf(num.intValue()));
        }
        Integer num2 = this.b;
        if (num2 != null) {
            map.put("category_type", Integer.valueOf(num2.intValue()));
        }
        Integer num3 = this.c;
        if (num3 != null) {
            map.put("service_type", Integer.valueOf(num3.intValue()));
        }
        String str = this.d;
        if (str != null) {
            map.put("category_title", str);
        }
        String str2 = this.e;
        if (str2 != null) {
            map.put("service_title", str2);
        }
        Integer num4 = this.f;
        if (num4 != null) {
            map.put("item_id", Integer.valueOf(num4.intValue()));
        }
        String str3 = this.g;
        if (str3 != null) {
            map.put("url", str3);
        }
        Long l = this.h;
        if (l != null) {
            map.put("peer_id", Long.valueOf(l.longValue()));
        }
        if (this.i != null) {
            String lowerCase = "CHANNEL".toLowerCase(Locale.ROOT);
            AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
            map.put("peer_type", lowerCase);
        }
        Integer num5 = this.j;
        if (num5 != null) {
            map.put("is_active", Integer.valueOf(num5.intValue()));
        }
        Long l2 = this.k;
        if (l2 != null) {
            map.put("duration_seconds", Long.valueOf(l2.longValue()));
        }
        String str4 = this.l;
        if (str4 != null) {
            map.put("msg_info", str4);
        }
        Integer num6 = this.m;
        if (num6 != null) {
            map.put("vertical_position", Integer.valueOf(num6.intValue()));
        }
        Integer num7 = this.n;
        if (num7 != null) {
            map.put("horizontal_position", Integer.valueOf(num7.intValue()));
        }
        Integer num8 = this.o;
        if (num8 != null) {
            map.put("section", Integer.valueOf(num8.intValue()));
        }
        map.put("service_id", "15");
        return map;
    }

    public final HashMap b() {
        HashMap map = new HashMap();
        for (Map.Entry entry : a().entrySet()) {
            map.put(entry.getKey(), entry.getValue().toString());
        }
        return map;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C21946uP3)) {
            return false;
        }
        C21946uP3 c21946uP3 = (C21946uP3) obj;
        return AbstractC13042fc3.d(this.a, c21946uP3.a) && AbstractC13042fc3.d(this.b, c21946uP3.b) && AbstractC13042fc3.d(this.c, c21946uP3.c) && AbstractC13042fc3.d(this.d, c21946uP3.d) && AbstractC13042fc3.d(this.e, c21946uP3.e) && AbstractC13042fc3.d(this.f, c21946uP3.f) && AbstractC13042fc3.d(this.g, c21946uP3.g) && AbstractC13042fc3.d(this.h, c21946uP3.h) && AbstractC13042fc3.d(this.i, c21946uP3.i) && AbstractC13042fc3.d(this.j, c21946uP3.j) && AbstractC13042fc3.d(this.k, c21946uP3.k) && AbstractC13042fc3.d(this.l, c21946uP3.l) && AbstractC13042fc3.d(this.m, c21946uP3.m) && AbstractC13042fc3.d(this.n, c21946uP3.n) && AbstractC13042fc3.d(this.o, c21946uP3.o);
    }

    public int hashCode() {
        Integer num = this.a;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.b;
        int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.c;
        int iHashCode3 = (iHashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str = this.d;
        int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.e;
        int iHashCode5 = (iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num4 = this.f;
        int iHashCode6 = (iHashCode5 + (num4 == null ? 0 : num4.hashCode())) * 31;
        String str3 = this.g;
        int iHashCode7 = (iHashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Long l = this.h;
        int iHashCode8 = (iHashCode7 + (l == null ? 0 : l.hashCode())) * 31;
        String str4 = this.i;
        int iHashCode9 = (iHashCode8 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num5 = this.j;
        int iHashCode10 = (iHashCode9 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Long l2 = this.k;
        int iHashCode11 = (iHashCode10 + (l2 == null ? 0 : l2.hashCode())) * 31;
        String str5 = this.l;
        int iHashCode12 = (iHashCode11 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num6 = this.m;
        int iHashCode13 = (iHashCode12 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Integer num7 = this.n;
        int iHashCode14 = (iHashCode13 + (num7 == null ? 0 : num7.hashCode())) * 31;
        Integer num8 = this.o;
        return iHashCode14 + (num8 != null ? num8.hashCode() : 0);
    }

    public String toString() {
        return "MarketEvent(actionType=" + this.a + ", categoryType=" + this.b + ", serviceType=" + this.c + ", categoryTitle=" + this.d + ", serviceTitle=" + this.e + ", id=" + this.f + ", url=" + this.g + ", peerId=" + this.h + ", peerType=" + this.i + ", isActive=" + this.j + ", durationSeconds=" + this.k + ", messageInfo=" + this.l + ", verticalPosition=" + this.m + ", horizontalPosition=" + this.n + ", section=" + this.o + Separators.RPAREN;
    }

    public /* synthetic */ C21946uP3(Integer num, Integer num2, Integer num3, String str, String str2, Integer num4, String str3, Long l, String str4, Integer num5, Long l2, String str5, Integer num6, Integer num7, Integer num8, int i, ED1 ed1) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : num4, (i & 64) != 0 ? null : str3, (i & 128) != 0 ? null : l, (i & 256) != 0 ? null : str4, (i & 512) != 0 ? null : num5, (i & 1024) != 0 ? null : l2, (i & 2048) != 0 ? null : str5, (i & 4096) != 0 ? null : num6, (i & 8192) != 0 ? null : num7, (i & 16384) == 0 ? num8 : null);
    }
}
