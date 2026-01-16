package ir.nasim;

import android.graphics.Bitmap;
import android.graphics.PointF;

/* renamed from: ir.nasim.z85, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C24749z85 {
    private float a;
    private float b;
    private C22697vg5 c;
    private C22697vg5 d;
    private float e;
    private C22697vg5 f;
    private C22697vg5 g;

    public C24749z85(C18435of2 c18435of2, Bitmap bitmap, SD6 sd6, boolean z) {
        C22697vg5 c22697vg5E = null;
        C22697vg5 c22697vg5E2 = null;
        C22697vg5 c22697vg5E3 = null;
        C22697vg5 c22697vg5E4 = null;
        for (C9155Ys3 c9155Ys3 : c18435of2.b()) {
            PointF pointFA = c9155Ys3.a();
            int iB = c9155Ys3.b();
            if (iB == 4) {
                c22697vg5E = e(pointFA, bitmap, sd6, z);
            } else if (iB == 5) {
                c22697vg5E3 = e(pointFA, bitmap, sd6, z);
            } else if (iB == 10) {
                c22697vg5E2 = e(pointFA, bitmap, sd6, z);
            } else if (iB == 11) {
                c22697vg5E4 = e(pointFA, bitmap, sd6, z);
            }
        }
        if (c22697vg5E != null && c22697vg5E2 != null) {
            if (c22697vg5E.a < c22697vg5E2.a) {
                C22697vg5 c22697vg5 = c22697vg5E2;
                c22697vg5E2 = c22697vg5E;
                c22697vg5E = c22697vg5;
            }
            this.d = new C22697vg5((c22697vg5E.a * 0.5f) + (c22697vg5E2.a * 0.5f), (c22697vg5E.b * 0.5f) + (c22697vg5E2.b * 0.5f));
            this.e = (float) Math.hypot(c22697vg5E2.a - c22697vg5E.a, c22697vg5E2.b - c22697vg5E.b);
            this.b = (float) Math.toDegrees(Math.atan2(c22697vg5E2.b - c22697vg5E.b, c22697vg5E2.a - c22697vg5E.a) + 3.141592653589793d);
            float f = this.e;
            this.a = 2.35f * f;
            float f2 = f * 0.8f;
            double radians = (float) Math.toRadians(r12 - 90.0f);
            this.c = new C22697vg5(this.d.a + (((float) Math.cos(radians)) * f2), this.d.b + (f2 * ((float) Math.sin(radians))));
        }
        if (c22697vg5E3 == null || c22697vg5E4 == null) {
            return;
        }
        if (c22697vg5E3.a < c22697vg5E4.a) {
            C22697vg5 c22697vg52 = c22697vg5E4;
            c22697vg5E4 = c22697vg5E3;
            c22697vg5E3 = c22697vg52;
        }
        this.f = new C22697vg5((c22697vg5E3.a * 0.5f) + (c22697vg5E4.a * 0.5f), (c22697vg5E3.b * 0.5f) + (c22697vg5E4.b * 0.5f));
        float f3 = this.e * 0.7f;
        double radians2 = (float) Math.toRadians(this.b + 90.0f);
        this.g = new C22697vg5(this.f.a + (((float) Math.cos(radians2)) * f3), this.f.b + (f3 * ((float) Math.sin(radians2))));
    }

    private C22697vg5 e(PointF pointF, Bitmap bitmap, SD6 sd6, boolean z) {
        return new C22697vg5((sd6.a * pointF.x) / (z ? bitmap.getHeight() : bitmap.getWidth()), (sd6.b * pointF.y) / (z ? bitmap.getWidth() : bitmap.getHeight()));
    }

    public float a() {
        return this.b;
    }

    public C22697vg5 b(int i) {
        if (i == 0) {
            return this.c;
        }
        if (i == 1) {
            return this.d;
        }
        if (i == 2) {
            return this.f;
        }
        if (i != 3) {
            return null;
        }
        return this.g;
    }

    public float c(int i) {
        return i == 1 ? this.e : this.a;
    }

    public boolean d() {
        return this.d != null;
    }
}
