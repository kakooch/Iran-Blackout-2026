package ir.nasim.core.runtime.markdown.html;

import android.gov.nist.core.Separators;
import ir.nasim.EnumC16603lZ2;
import ir.nasim.G15;
import ir.nasim.RU3;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/* loaded from: classes5.dex */
public class a {
    private static final List k = Arrays.asList("a", "b", "strong", "i", "em", "u", "ins", "s", "strike", "del", "pre");
    private String b;
    private RU3 c;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private String h = "";
    private String i = "";
    private String j = "";
    private RU3 d = G15.a.b("");
    private final Stack a = new Stack();

    public a(String str) {
        this.b = str;
        this.c = G15.a.c(str);
    }

    private String a() {
        return "\nOpenCloseTagCount : " + this.f + "\nTagCount : " + this.e + "\nCodeTagOpenCloseCount : " + this.g;
    }

    static String b(String str) {
        return str.startsWith(Separators.SLASH) ? str.substring(1) : str;
    }

    private boolean c(int i) {
        return i < this.b.length() && this.c.d() && this.c.c() > 0;
    }

    static boolean d(String str) {
        return !k.contains(str.toLowerCase());
    }

    static boolean e(String str) {
        return G15.c(G15.b.a(str));
    }

    private void g(int i) {
        this.c = G15.a.c(this.b.substring(i));
    }

    private int h(int i) {
        return i + this.c.start() + this.i.indexOf(Separators.GREATER_THAN) + 1;
    }

    private void i() {
        String strE = this.c.e();
        this.i = strE;
        this.h = strE.substring(1, strE.length() - 1);
    }

    private boolean k() {
        if (this.h.equalsIgnoreCase("code") || G15.c(G15.a.c.a(this.i))) {
            this.g++;
            return true;
        }
        if (!this.h.equalsIgnoreCase("/code")) {
            return this.g != 0;
        }
        int i = this.g;
        if (i == 0) {
            throw new HtmlValidationException(EnumC16603lZ2.INVALID_CODE_TAGS_PAIR, this.i);
        }
        this.g = i - 1;
        return true;
    }

    private boolean l() {
        RU3 ru3B = G15.a.b(this.i);
        this.d = ru3B;
        if (!G15.c(ru3B)) {
            return false;
        }
        String strB = this.d.b(1);
        if (e(strB)) {
            return true;
        }
        throw new HtmlValidationException(EnumC16603lZ2.INVALID_LINK_USED, strB);
    }

    private void m() {
        if (d(b(this.h))) {
            throw new HtmlValidationException(EnumC16603lZ2.INVALID_TAG_USED, this.i);
        }
    }

    private void n() {
        if (!this.i.startsWith("</")) {
            this.a.push(this.h);
            this.f++;
        } else {
            if (this.a.isEmpty() || !((String) this.a.pop()).contains(b(this.h))) {
                throw new HtmlValidationException(EnumC16603lZ2.INVALID_TAGS_PAIR, this.i);
            }
            this.f--;
        }
    }

    private void o() {
        if (this.f != 0 || this.e % 2 != 0 || this.g != 0) {
            throw new HtmlValidationException(EnumC16603lZ2.INVALID_TAGS_PAIR, a());
        }
    }

    public boolean f() {
        try {
            j();
            return true;
        } catch (HtmlValidationException e) {
            this.j = e.getMessage();
            return false;
        }
    }

    void j() {
        int iH = 0;
        while (c(iH)) {
            i();
            iH = h(iH);
            g(iH);
            if (!k()) {
                this.e++;
                n();
                if (!l()) {
                    m();
                }
            }
        }
        o();
    }
}
