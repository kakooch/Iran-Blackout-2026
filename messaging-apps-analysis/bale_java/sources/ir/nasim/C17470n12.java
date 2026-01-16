package ir.nasim;

import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import ir.nasim.YG4;

/* renamed from: ir.nasim.n12, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C17470n12 {
    private float a;
    private float b;
    private float c;
    private int d;
    private float[] e = null;

    public C17470n12(float f, float f2, float f3, int i) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = i;
    }

    public void a(Paint paint) {
        if (Color.alpha(this.d) > 0) {
            paint.setShadowLayer(Math.max(this.a, Float.MIN_VALUE), this.b, this.c, this.d);
        } else {
            paint.clearShadowLayer();
        }
    }

    public void b(YG4.a aVar) {
        if (Color.alpha(this.d) > 0) {
            aVar.d = this;
        } else {
            aVar.d = null;
        }
    }

    public void c(int i, Paint paint) {
        int iL = AbstractC16500lN7.l(Color.alpha(this.d), AbstractC7323Rf4.c(i, 0, 255));
        if (iL <= 0) {
            paint.clearShadowLayer();
        } else {
            paint.setShadowLayer(Math.max(this.a, Float.MIN_VALUE), this.b, this.c, Color.argb(iL, Color.red(this.d), Color.green(this.d), Color.blue(this.d)));
        }
    }

    public void d(int i, YG4.a aVar) {
        C17470n12 c17470n12 = new C17470n12(this);
        aVar.d = c17470n12;
        c17470n12.i(i);
    }

    public int e() {
        return this.d;
    }

    public float f() {
        return this.b;
    }

    public float g() {
        return this.c;
    }

    public float h() {
        return this.a;
    }

    public void i(int i) {
        this.d = Color.argb(Math.round((Color.alpha(this.d) * AbstractC7323Rf4.c(i, 0, 255)) / 255.0f), Color.red(this.d), Color.green(this.d), Color.blue(this.d));
    }

    public boolean j(C17470n12 c17470n12) {
        return this.a == c17470n12.a && this.b == c17470n12.b && this.c == c17470n12.c && this.d == c17470n12.d;
    }

    public void k(Matrix matrix) {
        if (this.e == null) {
            this.e = new float[2];
        }
        float[] fArr = this.e;
        fArr[0] = this.b;
        fArr[1] = this.c;
        matrix.mapVectors(fArr);
        float[] fArr2 = this.e;
        this.b = fArr2[0];
        this.c = fArr2[1];
        this.a = matrix.mapRadius(this.a);
    }

    public C17470n12(C17470n12 c17470n12) {
        this.a = 0.0f;
        this.b = 0.0f;
        this.c = 0.0f;
        this.d = 0;
        this.a = c17470n12.a;
        this.b = c17470n12.b;
        this.c = c17470n12.c;
        this.d = c17470n12.d;
    }
}
