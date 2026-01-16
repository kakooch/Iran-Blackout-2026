package ir.nasim;

import android.graphics.Matrix;
import android.view.MotionEvent;
import ir.nasim.features.libphotovideo.Paint.RenderView;
import java.util.Vector;

/* renamed from: ir.nasim.r83, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C19905r83 {
    private RenderView a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private C23293wg5 f;
    private double g;
    private int i;
    private Matrix j;
    private C23293wg5[] h = new C23293wg5[3];
    private float[] k = new float[2];

    /* renamed from: ir.nasim.r83$a */
    class a implements Runnable {
        final /* synthetic */ W05 a;

        /* renamed from: ir.nasim.r83$a$a, reason: collision with other inner class name */
        class RunnableC1489a implements Runnable {
            RunnableC1489a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                C19905r83.this.g = aVar.a.a;
                C19905r83.this.e = false;
            }
        }

        a(W05 w05) {
            this.a = w05;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC7426Rr.P(new RunnableC1489a());
        }
    }

    public C19905r83(RenderView renderView) {
        this.a = renderView;
    }

    private void c(W05 w05) {
        w05.f(this.a.getCurrentColor(), this.a.getCurrentWeight(), this.a.getCurrentBrush());
        if (this.e) {
            this.g = 0.0d;
        }
        w05.a = this.g;
        this.a.getPainting().M(w05, this.e, new a(w05));
    }

    private void e() {
        this.i = 0;
    }

    private C23293wg5 g(C23293wg5 c23293wg5, C23293wg5 c23293wg52, C23293wg5 c23293wg53, float f) {
        float f2 = 1.0f - f;
        double dPow = Math.pow(f2, 2.0d);
        double d = f2 * 2.0f * f;
        double d2 = f * f;
        return new C23293wg5((c23293wg5.a * dPow) + (c23293wg53.a * d) + (c23293wg52.a * d2), (c23293wg5.b * dPow) + (c23293wg53.b * d) + (c23293wg52.b * d2), 1.0d);
    }

    private void h(boolean z) {
        int i = this.i;
        if (i <= 2) {
            C23293wg5[] c23293wg5Arr = new C23293wg5[i];
            System.arraycopy(this.h, 0, c23293wg5Arr, 0, i);
            c(new W05(c23293wg5Arr));
            return;
        }
        Vector vector = new Vector();
        C23293wg5[] c23293wg5Arr2 = this.h;
        C23293wg5 c23293wg5 = c23293wg5Arr2[0];
        C23293wg5 c23293wg52 = c23293wg5Arr2[1];
        C23293wg5 c23293wg53 = c23293wg5Arr2[2];
        if (c23293wg53 == null || c23293wg52 == null || c23293wg5 == null) {
            return;
        }
        C23293wg5 c23293wg5D = c23293wg52.d(c23293wg5, 0.5d);
        C23293wg5 c23293wg5D2 = c23293wg53.d(c23293wg52, 0.5d);
        int iMin = (int) Math.min(48.0d, Math.max(Math.floor(c23293wg5D.b(c23293wg5D2) / 1), 24.0d));
        float f = 1.0f / iMin;
        float f2 = 0.0f;
        for (int i2 = 0; i2 < iMin; i2++) {
            C23293wg5 c23293wg5G = g(c23293wg5D, c23293wg5D2, c23293wg52, f2);
            if (this.c) {
                c23293wg5G.d = true;
                this.c = false;
            }
            vector.add(c23293wg5G);
            f2 += f;
        }
        if (z) {
            c23293wg5D2.d = true;
        }
        vector.add(c23293wg5D2);
        C23293wg5[] c23293wg5Arr3 = new C23293wg5[vector.size()];
        vector.toArray(c23293wg5Arr3);
        c(new W05(c23293wg5Arr3));
        C23293wg5[] c23293wg5Arr4 = this.h;
        System.arraycopy(c23293wg5Arr4, 1, c23293wg5Arr4, 0, 2);
        if (z) {
            this.i = 0;
        } else {
            this.i = 2;
        }
    }

    public void d(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        float x = motionEvent.getX();
        float height = this.a.getHeight() - motionEvent.getY();
        float[] fArr = this.k;
        fArr[0] = x;
        fArr[1] = height;
        this.j.mapPoints(fArr);
        float[] fArr2 = this.k;
        C23293wg5 c23293wg5 = new C23293wg5(fArr2[0], fArr2[1], 1.0d);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                if (!this.d) {
                    if (this.a.r()) {
                        c23293wg5.d = true;
                        c(new W05(c23293wg5));
                    }
                    e();
                } else if (this.i > 0) {
                    h(true);
                }
                this.i = 0;
                this.a.getPainting().A(this.a.getCurrentColor());
                this.b = false;
                this.a.p(this.d);
                return;
            }
            if (actionMasked != 2) {
                return;
            }
        }
        if (!this.b) {
            this.b = true;
            this.d = false;
            this.c = true;
            this.f = c23293wg5;
            this.h[0] = c23293wg5;
            this.i = 1;
            this.e = true;
            return;
        }
        if (c23293wg5.b(this.f) < AbstractC7426Rr.z(5.0f)) {
            return;
        }
        if (!this.d) {
            this.a.o();
            this.d = true;
        }
        C23293wg5[] c23293wg5Arr = this.h;
        int i = this.i;
        c23293wg5Arr[i] = c23293wg5;
        int i2 = i + 1;
        this.i = i2;
        if (i2 == 3) {
            h(false);
        }
        this.f = c23293wg5;
    }

    public void f(Matrix matrix) {
        Matrix matrix2 = new Matrix();
        this.j = matrix2;
        matrix.invert(matrix2);
    }
}
