package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import java.util.Arrays;

/* renamed from: ir.nasim.z68, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C24732z68 {
    public static final a p = new a(null);
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final String j;
    private final String k;
    private final String l;
    private final String m;
    private final String n;
    private final String o;

    /* renamed from: ir.nasim.z68$a */
    public static final class a {
        private a() {
        }

        public final C24732z68 a(Context context) {
            AbstractC13042fc3.i(context, "context");
            return new C24732z68(b(context, AbstractC23589xA5.background), b(context, AbstractC23589xA5.n500), b(context, AbstractC23589xA5.n200), b(context, AbstractC23589xA5.link_color), b(context, AbstractC23589xA5.primary), b(context, AbstractC23589xA5.design_default_color_on_primary), b(context, AbstractC23589xA5.n20), b(context, AbstractC23589xA5.background), b(context, AbstractC23589xA5.n30), b(context, AbstractC23589xA5.primary), b(context, AbstractC23589xA5.background), b(context, AbstractC23589xA5.n300), b(context, AbstractC23589xA5.n30), b(context, AbstractC23589xA5.n300), b(context, AbstractC23589xA5.error));
        }

        public final String b(Context context, int i) {
            AbstractC13042fc3.i(context, "context");
            int iC = AbstractC4043Dl1.c(context, i);
            DY6 dy6 = DY6.a;
            String str = String.format("#%06X", Arrays.copyOf(new Object[]{Integer.valueOf(iC & 16777215)}, 1));
            AbstractC13042fc3.h(str, "format(...)");
            return str;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C24732z68(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15) {
        AbstractC13042fc3.i(str, "bgColor");
        AbstractC13042fc3.i(str2, "textColor");
        AbstractC13042fc3.i(str3, "hindColor");
        AbstractC13042fc3.i(str4, "linkColor");
        AbstractC13042fc3.i(str5, "buttonColor");
        AbstractC13042fc3.i(str6, "buttonTextColor");
        AbstractC13042fc3.i(str7, "secondaryBgColor");
        AbstractC13042fc3.i(str8, "headerBgColor");
        AbstractC13042fc3.i(str9, "bottomBarBgColor");
        AbstractC13042fc3.i(str10, "accentTextColor");
        AbstractC13042fc3.i(str11, "sectionBgColor");
        AbstractC13042fc3.i(str12, "sectionHeaderTextColor");
        AbstractC13042fc3.i(str13, "sectionSeparatorColor");
        AbstractC13042fc3.i(str14, "subtitleTextColor");
        AbstractC13042fc3.i(str15, "destructiveTextColor");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
        this.h = str8;
        this.i = str9;
        this.j = str10;
        this.k = str11;
        this.l = str12;
        this.m = str13;
        this.n = str14;
        this.o = str15;
    }

    public final String a() {
        return this.j;
    }

    public final String b() {
        return this.a;
    }

    public final String c() {
        return this.i;
    }

    public final String d() {
        return this.e;
    }

    public final String e() {
        return this.f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C24732z68)) {
            return false;
        }
        C24732z68 c24732z68 = (C24732z68) obj;
        return AbstractC13042fc3.d(this.a, c24732z68.a) && AbstractC13042fc3.d(this.b, c24732z68.b) && AbstractC13042fc3.d(this.c, c24732z68.c) && AbstractC13042fc3.d(this.d, c24732z68.d) && AbstractC13042fc3.d(this.e, c24732z68.e) && AbstractC13042fc3.d(this.f, c24732z68.f) && AbstractC13042fc3.d(this.g, c24732z68.g) && AbstractC13042fc3.d(this.h, c24732z68.h) && AbstractC13042fc3.d(this.i, c24732z68.i) && AbstractC13042fc3.d(this.j, c24732z68.j) && AbstractC13042fc3.d(this.k, c24732z68.k) && AbstractC13042fc3.d(this.l, c24732z68.l) && AbstractC13042fc3.d(this.m, c24732z68.m) && AbstractC13042fc3.d(this.n, c24732z68.n) && AbstractC13042fc3.d(this.o, c24732z68.o);
    }

    public final String f() {
        return this.o;
    }

    public final String g() {
        return this.h;
    }

    public final String h() {
        return this.c;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31) + this.l.hashCode()) * 31) + this.m.hashCode()) * 31) + this.n.hashCode()) * 31) + this.o.hashCode();
    }

    public final String i() {
        return this.d;
    }

    public final String j() {
        return this.g;
    }

    public final String k() {
        return this.k;
    }

    public final String l() {
        return this.l;
    }

    public final String m() {
        return this.n;
    }

    public final String n() {
        return this.b;
    }

    public String toString() {
        return "WebAppThemeParams(bgColor=" + this.a + ", textColor=" + this.b + ", hindColor=" + this.c + ", linkColor=" + this.d + ", buttonColor=" + this.e + ", buttonTextColor=" + this.f + ", secondaryBgColor=" + this.g + ", headerBgColor=" + this.h + ", bottomBarBgColor=" + this.i + ", accentTextColor=" + this.j + ", sectionBgColor=" + this.k + ", sectionHeaderTextColor=" + this.l + ", sectionSeparatorColor=" + this.m + ", subtitleTextColor=" + this.n + ", destructiveTextColor=" + this.o + Separators.RPAREN;
    }
}
