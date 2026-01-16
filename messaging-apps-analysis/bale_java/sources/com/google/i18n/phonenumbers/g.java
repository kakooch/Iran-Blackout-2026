package com.google.i18n.phonenumbers;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class g implements Serializable {
    private boolean a;
    private boolean c;
    private boolean e;
    private boolean g;
    private boolean i;
    private boolean k;
    private boolean m;
    private boolean o;
    private int b = 0;
    private long d = 0;
    private String f = "";
    private boolean h = false;
    private int j = 1;
    private String l = "";
    private String p = "";
    private a n = a.UNSPECIFIED;

    public enum a {
        FROM_NUMBER_WITH_PLUS_SIGN,
        FROM_NUMBER_WITH_IDD,
        FROM_NUMBER_WITHOUT_PLUS_SIGN,
        FROM_DEFAULT_COUNTRY,
        UNSPECIFIED
    }

    public g C(long j) {
        this.c = true;
        this.d = j;
        return this;
    }

    public g D(int i) {
        this.i = true;
        this.j = i;
        return this;
    }

    public g E(String str) {
        str.getClass();
        this.o = true;
        this.p = str;
        return this;
    }

    public g F(String str) {
        str.getClass();
        this.k = true;
        this.l = str;
        return this;
    }

    public g a() {
        this.m = false;
        this.n = a.UNSPECIFIED;
        return this;
    }

    public boolean b(g gVar) {
        if (gVar == null) {
            return false;
        }
        if (this == gVar) {
            return true;
        }
        return this.b == gVar.b && this.d == gVar.d && this.f.equals(gVar.f) && this.h == gVar.h && this.j == gVar.j && this.l.equals(gVar.l) && this.n == gVar.n && this.p.equals(gVar.p) && q() == gVar.q();
    }

    public int c() {
        return this.b;
    }

    public a d() {
        return this.n;
    }

    public String e() {
        return this.f;
    }

    public boolean equals(Object obj) {
        return (obj instanceof g) && b((g) obj);
    }

    public long f() {
        return this.d;
    }

    public int g() {
        return this.j;
    }

    public int hashCode() {
        return ((((((((((((((((2173 + c()) * 53) + Long.valueOf(f()).hashCode()) * 53) + e().hashCode()) * 53) + (s() ? 1231 : 1237)) * 53) + g()) * 53) + k().hashCode()) * 53) + d().hashCode()) * 53) + j().hashCode()) * 53) + (q() ? 1231 : 1237);
    }

    public String j() {
        return this.p;
    }

    public String k() {
        return this.l;
    }

    public boolean l() {
        return this.m;
    }

    public boolean m() {
        return this.e;
    }

    public boolean n() {
        return this.g;
    }

    public boolean p() {
        return this.i;
    }

    public boolean q() {
        return this.o;
    }

    public boolean r() {
        return this.k;
    }

    public boolean s() {
        return this.h;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Country Code: ");
        sb.append(this.b);
        sb.append(" National Number: ");
        sb.append(this.d);
        if (n() && s()) {
            sb.append(" Leading Zero(s): true");
        }
        if (p()) {
            sb.append(" Number of leading zeros: ");
            sb.append(this.j);
        }
        if (m()) {
            sb.append(" Extension: ");
            sb.append(this.f);
        }
        if (l()) {
            sb.append(" Country Code Source: ");
            sb.append(this.n);
        }
        if (q()) {
            sb.append(" Preferred Domestic Carrier Code: ");
            sb.append(this.p);
        }
        return sb.toString();
    }

    public g u(int i) {
        this.a = true;
        this.b = i;
        return this;
    }

    public g w(a aVar) {
        aVar.getClass();
        this.m = true;
        this.n = aVar;
        return this;
    }

    public g y(String str) {
        str.getClass();
        this.e = true;
        this.f = str;
        return this;
    }

    public g z(boolean z) {
        this.g = true;
        this.h = z;
        return this;
    }
}
