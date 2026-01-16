package ir.nasim;

import android.gov.nist.core.Separators;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.Hx1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C5102Hx1 {
    String a;
    private int b;
    private int c;
    private float d;
    private String e;
    boolean f;

    public C5102Hx1(C5102Hx1 c5102Hx1) {
        this.c = RecyclerView.UNDEFINED_DURATION;
        this.d = Float.NaN;
        this.e = null;
        this.a = c5102Hx1.a;
        this.b = c5102Hx1.b;
        this.c = c5102Hx1.c;
        this.d = c5102Hx1.d;
        this.e = c5102Hx1.e;
        this.f = c5102Hx1.f;
    }

    public static String a(int i) {
        return Separators.POUND + ("00000000" + Integer.toHexString(i)).substring(r2.length() - 8);
    }

    public C5102Hx1 b() {
        return new C5102Hx1(this);
    }

    public boolean c() {
        return this.f;
    }

    public float d() {
        return this.d;
    }

    public int e() {
        return this.c;
    }

    public String f() {
        return this.a;
    }

    public String g() {
        return this.e;
    }

    public int h() {
        return this.b;
    }

    public void i(float f) {
        this.d = f;
    }

    public void j(int i) {
        this.c = i;
    }

    public String toString() {
        String str = this.a + ':';
        switch (this.b) {
            case 900:
                return str + this.c;
            case 901:
                return str + this.d;
            case 902:
                return str + a(this.c);
            case 903:
                return str + this.e;
            case 904:
                return str + Boolean.valueOf(this.f);
            case 905:
                return str + this.d;
            default:
                return str + "????";
        }
    }

    public C5102Hx1(String str, int i, int i2) {
        this.c = RecyclerView.UNDEFINED_DURATION;
        this.d = Float.NaN;
        this.e = null;
        this.a = str;
        this.b = i;
        if (i == 901) {
            this.d = i2;
        } else {
            this.c = i2;
        }
    }

    public C5102Hx1(String str, int i, float f) {
        this.c = RecyclerView.UNDEFINED_DURATION;
        this.e = null;
        this.a = str;
        this.b = i;
        this.d = f;
    }
}
