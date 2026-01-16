package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* loaded from: classes5.dex */
public final class HX6 {
    public static final a g = new a(null);
    private final int a;
    private final String b;
    private final EnumC9168Yt7 c;
    private final String d;
    private final long e;
    private final List f;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public HX6(int i, String str, EnumC9168Yt7 enumC9168Yt7, String str2, long j, List list) {
        AbstractC13042fc3.i(str, "storyId");
        AbstractC13042fc3.i(enumC9168Yt7, "traitCase");
        AbstractC13042fc3.i(str2, "widgetData");
        this.a = i;
        this.b = str;
        this.c = enumC9168Yt7;
        this.d = str2;
        this.e = j;
        this.f = list;
    }

    public final List a() {
        return this.f;
    }

    public final long b() {
        return this.e;
    }

    public final int c() {
        return this.a;
    }

    public final String d() {
        return this.b;
    }

    public final EnumC9168Yt7 e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HX6)) {
            return false;
        }
        HX6 hx6 = (HX6) obj;
        return this.a == hx6.a && AbstractC13042fc3.d(this.b, hx6.b) && this.c == hx6.c && AbstractC13042fc3.d(this.d, hx6.d) && this.e == hx6.e && AbstractC13042fc3.d(this.f, hx6.f);
    }

    public final String f() {
        return this.d;
    }

    public int hashCode() {
        int iHashCode = ((((((((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + Long.hashCode(this.e)) * 31;
        List list = this.f;
        return iHashCode + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        return "StoryWidgetEntity(id=" + this.a + ", storyId=" + this.b + ", traitCase=" + this.c + ", widgetData=" + this.d + ", expirationDate=" + this.e + ", coordinates=" + this.f + Separators.RPAREN;
    }

    public /* synthetic */ HX6(int i, String str, EnumC9168Yt7 enumC9168Yt7, String str2, long j, List list, int i2, ED1 ed1) {
        this((i2 & 1) != 0 ? 0 : i, str, enumC9168Yt7, str2, j, list);
    }
}
