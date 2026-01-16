package ir.nasim;

/* loaded from: classes5.dex */
public abstract class LI5 {
    private boolean a;
    private Long b;
    String c;
    private String d;
    private String e;
    String f;

    private Long a(Long l) {
        if (l.longValue() == -404) {
            return null;
        }
        return l;
    }

    String b(String str) {
        if (str.equals("-404")) {
            return null;
        }
        return str;
    }

    public Long c() {
        return this.b;
    }

    public String d() {
        return this.f;
    }

    public String e() {
        return this.c;
    }

    public boolean f() {
        return this.a;
    }

    public String g() {
        return this.e;
    }

    public String h() {
        return this.d;
    }

    public void i(Long l) {
        this.b = a(l);
    }

    public void j(String str) {
        this.f = b(str);
    }

    public void k(String str) {
        this.c = b(str);
    }

    public void l(Boolean bool) {
        if (bool == null) {
            this.a = false;
        } else {
            this.a = bool.booleanValue();
        }
    }

    public void m(String str) {
        this.e = b(str);
    }

    public void n(String str) {
        this.d = b(str);
    }
}
