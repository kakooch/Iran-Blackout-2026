package ir.nasim;

/* renamed from: ir.nasim.Pi4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C6872Pi4 extends LI5 {
    String g;
    String h;
    String i;
    String j;
    Boolean k;

    @Override // ir.nasim.LI5
    public void k(String str) {
        if (str == null) {
            this.f = AbstractC19902r80.f(Long.valueOf(Long.parseLong("-404")));
        } else {
            this.c = str;
            this.f = AbstractC19902r80.f(Long.valueOf(Long.parseLong(str)));
        }
    }

    public String o() {
        return this.j;
    }

    public String p() {
        return this.h;
    }

    public String q() {
        return this.g;
    }

    public void r(String str) {
        this.j = b(str);
    }

    public void s(String str) {
        this.h = b(str);
    }

    public void t(Boolean bool) {
        this.k = bool;
    }

    public void u(String str) {
        this.g = b(str);
    }

    public void v(String str) {
        this.i = b(str);
    }
}
