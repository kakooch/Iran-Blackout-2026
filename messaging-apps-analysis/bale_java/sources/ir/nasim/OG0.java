package ir.nasim;

/* loaded from: classes5.dex */
public class OG0 {
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private boolean k;
    public boolean l;

    public OG0(byte[] bArr) {
        this.a = "CardInfo";
        this.b = "title";
        this.c = "pan";
        this.d = "expirationDate";
        this.e = "cvv2";
        this.f = "otp_enabled";
        this.l = true;
        m(bArr);
    }

    private C8542Wk3 c() {
        C8542Wk3 c8542Wk3 = new C8542Wk3();
        c8542Wk3.F("title", this.g);
        c8542Wk3.F("pan", this.h);
        c8542Wk3.F("expirationDate", this.i);
        c8542Wk3.F("cvv2", this.j);
        c8542Wk3.D("otp_enabled", Boolean.valueOf(this.k));
        return c8542Wk3;
    }

    private void e(String str, String str2, String str3, String str4, boolean z) {
        p(str);
        o(XY6.q(XY6.h(str2)));
        l(XY6.q(XY6.h(str3)));
        k(XY6.q(XY6.h(str4)));
        n(z);
    }

    private boolean f(String str) {
        return str.length() == 3 || str.length() == 4;
    }

    private boolean g(String str) {
        int i;
        return str.length() == 4 && (i = Integer.parseInt(str.substring(2))) >= 1 && i <= 12;
    }

    private boolean i(String str) {
        return !AbstractC19902r80.d(str).equals(Y50.d);
    }

    private void k(String str) {
        if (f(str)) {
            this.j = str;
        } else {
            this.l = false;
        }
    }

    private void l(String str) {
        if (g(str)) {
            this.i = str;
        } else {
            this.l = false;
        }
    }

    private void m(byte[] bArr) {
        try {
            C19231q00 c19231q00 = new C19231q00(new String(bArr));
            this.l = true;
            e(c19231q00.o("title", ""), c19231q00.o("pan", ""), c19231q00.o("expirationDate", ""), c19231q00.o("cvv2", ""), c19231q00.i("otp_enabled", false));
        } catch (Exception e) {
            C19406qI3.d("CardInfo", e);
            C19406qI3.a("CardInfo", "Failed to parse json from string!", new Object[0]);
            this.l = false;
        }
    }

    private void o(String str) {
        if (i(str)) {
            this.h = str;
        } else {
            this.l = false;
        }
    }

    private void p(String str) {
        this.g = str;
    }

    public String a() {
        return this.j;
    }

    public String b() {
        return this.i;
    }

    public String d() {
        return this.h;
    }

    public boolean h() {
        return this.k;
    }

    public boolean j() {
        return this.l;
    }

    public void n(boolean z) {
        this.k = z;
    }

    public byte[] q() {
        return toString().getBytes();
    }

    public String toString() {
        return c().toString();
    }

    public OG0(String str, String str2, String str3) {
        this("", str, str2, str3);
    }

    public OG0(String str, String str2, String str3, String str4) {
        this(str, str2, str3, str4, false);
    }

    public OG0(String str, String str2, String str3, String str4, boolean z) {
        this.a = "CardInfo";
        this.b = "title";
        this.c = "pan";
        this.d = "expirationDate";
        this.e = "cvv2";
        this.f = "otp_enabled";
        this.l = true;
        e(str, str2, str3, str4, z);
    }
}
