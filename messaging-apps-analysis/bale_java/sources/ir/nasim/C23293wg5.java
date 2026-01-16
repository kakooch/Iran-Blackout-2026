package ir.nasim;

import android.graphics.PointF;

/* renamed from: ir.nasim.wg5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C23293wg5 {
    public double a;
    public double b;
    public double c;
    public boolean d;

    public C23293wg5(double d, double d2, double d3) {
        this.a = d;
        this.b = d2;
        this.c = d3;
    }

    C23293wg5 a(C23293wg5 c23293wg5) {
        return new C23293wg5(this.a + c23293wg5.a, this.b + c23293wg5.b, this.c + c23293wg5.c);
    }

    float b(C23293wg5 c23293wg5) {
        return (float) Math.sqrt(Math.pow(this.a - c23293wg5.a, 2.0d) + Math.pow(this.b - c23293wg5.b, 2.0d) + Math.pow(this.c - c23293wg5.c, 2.0d));
    }

    C23293wg5 c(double d) {
        return new C23293wg5(this.a * d, this.b * d, this.c * d);
    }

    C23293wg5 d(C23293wg5 c23293wg5, double d) {
        return new C23293wg5((this.a + c23293wg5.a) * d, (this.b + c23293wg5.b) * d, (this.c + c23293wg5.c) * d);
    }

    C23293wg5 e(C23293wg5 c23293wg5) {
        return new C23293wg5(this.a - c23293wg5.a, this.b - c23293wg5.b, this.c - c23293wg5.c);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C23293wg5)) {
            return false;
        }
        C23293wg5 c23293wg5 = (C23293wg5) obj;
        return this.a == c23293wg5.a && this.b == c23293wg5.b && this.c == c23293wg5.c;
    }

    PointF f() {
        return new PointF((float) this.a, (float) this.b);
    }
}
