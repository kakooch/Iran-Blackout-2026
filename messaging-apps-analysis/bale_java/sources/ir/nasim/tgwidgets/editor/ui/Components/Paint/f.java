package ir.nasim.tgwidgets.editor.ui.Components.Paint;

import android.graphics.PointF;

/* loaded from: classes7.dex */
public class f {
    public double a;
    public double b;
    public double c;
    public boolean d;

    public f(double d, double d2, double d3) {
        this.a = d;
        this.b = d2;
        this.c = d3;
    }

    f a(f fVar) {
        return new f(this.a + fVar.a, this.b + fVar.b, this.c + fVar.c);
    }

    float b(f fVar) {
        return (float) Math.sqrt(Math.pow(this.a - fVar.a, 2.0d) + Math.pow(this.b - fVar.b, 2.0d) + Math.pow(this.c - fVar.c, 2.0d));
    }

    f c(double d) {
        return new f(this.a * d, this.b * d, this.c * d);
    }

    f d(f fVar, double d) {
        return new f((this.a + fVar.a) * d, (this.b + fVar.b) * d, (this.c + fVar.c) * d);
    }

    f e(f fVar) {
        return new f(this.a - fVar.a, this.b - fVar.b, this.c - fVar.c);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.a == fVar.a && this.b == fVar.b && this.c == fVar.c;
    }

    PointF f() {
        return new PointF((float) this.a, (float) this.b);
    }

    public f(double d, double d2, double d3, boolean z) {
        this.a = d;
        this.b = d2;
        this.c = d3;
        this.d = z;
    }
}
