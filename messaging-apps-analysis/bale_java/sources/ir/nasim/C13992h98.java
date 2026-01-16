package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.C8243Vd1;
import java.util.HashMap;

/* renamed from: ir.nasim.h98, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C13992h98 {
    public static float u = Float.NaN;
    public C16651le1 a;
    public int b;
    public int c;
    public int d;
    public int e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public float k;
    public float l;
    public float m;
    public float n;
    public float o;
    public float p;
    public float q;
    public int r;
    public final HashMap s;
    public String t;

    public C13992h98(C16651le1 c16651le1) {
        this.a = null;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = Float.NaN;
        this.g = Float.NaN;
        this.h = Float.NaN;
        this.i = Float.NaN;
        this.j = Float.NaN;
        this.k = Float.NaN;
        this.l = Float.NaN;
        this.m = Float.NaN;
        this.n = Float.NaN;
        this.o = Float.NaN;
        this.p = Float.NaN;
        this.q = Float.NaN;
        this.r = 0;
        this.s = new HashMap();
        this.t = null;
        this.a = c16651le1;
    }

    private static void a(StringBuilder sb, String str, float f) {
        if (Float.isNaN(f)) {
            return;
        }
        sb.append(str);
        sb.append(": ");
        sb.append(f);
        sb.append(",\n");
    }

    private static void b(StringBuilder sb, String str, int i) {
        sb.append(str);
        sb.append(": ");
        sb.append(i);
        sb.append(",\n");
    }

    private void e(StringBuilder sb, C8243Vd1.b bVar) {
        C8243Vd1 c8243Vd1Q = this.a.q(bVar);
        if (c8243Vd1Q == null || c8243Vd1Q.f == null) {
            return;
        }
        sb.append("Anchor");
        sb.append(bVar.name());
        sb.append(": ['");
        String str = c8243Vd1Q.f.h().o;
        if (str == null) {
            str = "#PARENT";
        }
        sb.append(str);
        sb.append("', '");
        sb.append(c8243Vd1Q.f.k().name());
        sb.append("', '");
        sb.append(c8243Vd1Q.g);
        sb.append("'],\n");
    }

    public boolean c() {
        return Float.isNaN(this.h) && Float.isNaN(this.i) && Float.isNaN(this.j) && Float.isNaN(this.k) && Float.isNaN(this.l) && Float.isNaN(this.m) && Float.isNaN(this.n) && Float.isNaN(this.o) && Float.isNaN(this.p);
    }

    public StringBuilder d(StringBuilder sb, boolean z) {
        sb.append("{\n");
        b(sb, "left", this.b);
        b(sb, "top", this.c);
        b(sb, "right", this.d);
        b(sb, "bottom", this.e);
        a(sb, "pivotX", this.f);
        a(sb, "pivotY", this.g);
        a(sb, "rotationX", this.h);
        a(sb, "rotationY", this.i);
        a(sb, "rotationZ", this.j);
        a(sb, "translationX", this.k);
        a(sb, "translationY", this.l);
        a(sb, "translationZ", this.m);
        a(sb, "scaleX", this.n);
        a(sb, "scaleY", this.o);
        a(sb, "alpha", this.p);
        b(sb, "visibility", this.r);
        a(sb, "interpolatedPos", this.q);
        if (this.a != null) {
            for (C8243Vd1.b bVar : C8243Vd1.b.values()) {
                e(sb, bVar);
            }
        }
        if (z) {
            a(sb, "phone_orientation", u);
        }
        if (z) {
            a(sb, "phone_orientation", u);
        }
        if (this.s.size() != 0) {
            sb.append("custom : {\n");
            for (String str : this.s.keySet()) {
                C5102Hx1 c5102Hx1 = (C5102Hx1) this.s.get(str);
                sb.append(str);
                sb.append(": ");
                switch (c5102Hx1.h()) {
                    case 900:
                        sb.append(c5102Hx1.e());
                        sb.append(",\n");
                        break;
                    case 901:
                    case 905:
                        sb.append(c5102Hx1.d());
                        sb.append(",\n");
                        break;
                    case 902:
                        sb.append(Separators.QUOTE);
                        sb.append(C5102Hx1.a(c5102Hx1.e()));
                        sb.append("',\n");
                        break;
                    case 903:
                        sb.append(Separators.QUOTE);
                        sb.append(c5102Hx1.g());
                        sb.append("',\n");
                        break;
                    case 904:
                        sb.append(Separators.QUOTE);
                        sb.append(c5102Hx1.c());
                        sb.append("',\n");
                        break;
                }
            }
            sb.append("}\n");
        }
        sb.append("}\n");
        return sb;
    }

    public void f(String str, int i, float f) {
        if (this.s.containsKey(str)) {
            ((C5102Hx1) this.s.get(str)).i(f);
        } else {
            this.s.put(str, new C5102Hx1(str, i, f));
        }
    }

    public void g(String str, int i, int i2) {
        if (this.s.containsKey(str)) {
            ((C5102Hx1) this.s.get(str)).j(i2);
        } else {
            this.s.put(str, new C5102Hx1(str, i, i2));
        }
    }

    public C13992h98 h() {
        C16651le1 c16651le1 = this.a;
        if (c16651le1 != null) {
            this.b = c16651le1.G();
            this.c = this.a.R();
            this.d = this.a.P();
            this.e = this.a.t();
            i(this.a.n);
        }
        return this;
    }

    public void i(C13992h98 c13992h98) {
        this.f = c13992h98.f;
        this.g = c13992h98.g;
        this.h = c13992h98.h;
        this.i = c13992h98.i;
        this.j = c13992h98.j;
        this.k = c13992h98.k;
        this.l = c13992h98.l;
        this.m = c13992h98.m;
        this.n = c13992h98.n;
        this.o = c13992h98.o;
        this.p = c13992h98.p;
        this.r = c13992h98.r;
        this.s.clear();
        for (C5102Hx1 c5102Hx1 : c13992h98.s.values()) {
            this.s.put(c5102Hx1.f(), c5102Hx1.b());
        }
    }

    public C13992h98(C13992h98 c13992h98) {
        this.a = null;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = Float.NaN;
        this.g = Float.NaN;
        this.h = Float.NaN;
        this.i = Float.NaN;
        this.j = Float.NaN;
        this.k = Float.NaN;
        this.l = Float.NaN;
        this.m = Float.NaN;
        this.n = Float.NaN;
        this.o = Float.NaN;
        this.p = Float.NaN;
        this.q = Float.NaN;
        this.r = 0;
        this.s = new HashMap();
        this.t = null;
        this.a = c13992h98.a;
        this.b = c13992h98.b;
        this.c = c13992h98.c;
        this.d = c13992h98.d;
        this.e = c13992h98.e;
        i(c13992h98);
    }
}
