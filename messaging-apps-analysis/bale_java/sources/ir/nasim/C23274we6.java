package ir.nasim;

import android.content.Context;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/* renamed from: ir.nasim.we6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C23274we6 {
    private static float A;
    private static float B;
    private static float w = (float) (Math.log(0.75d) / Math.log(0.9d));
    private static float x = 0.4f;
    private static float y = 1.0f - 0.4f;
    private static final float[] z = new float[101];
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private long l;
    private int m;
    private float n;
    private float o;
    private float p;
    private boolean q;
    private Interpolator r;
    private boolean s;
    private float t;
    private float u;
    private final float v;

    static {
        float f;
        float f2;
        float f3 = 0.0f;
        for (int i = 0; i <= 100; i++) {
            float f4 = i / 100.0f;
            float f5 = 1.0f;
            while (true) {
                float f6 = ((f5 - f3) / 2.0f) + f3;
                float f7 = 1.0f - f6;
                f = 3.0f * f6 * f7;
                f2 = f6 * f6 * f6;
                float f8 = (((f7 * x) + (y * f6)) * f) + f2;
                if (Math.abs(f8 - f4) < 1.0E-5d) {
                    break;
                } else if (f8 > f4) {
                    f5 = f6;
                } else {
                    f3 = f6;
                }
            }
            z[i] = f + f2;
        }
        z[100] = 1.0f;
        A = 8.0f;
        B = 1.0f;
        B = 1.0f / l(1.0f);
    }

    public C23274we6(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    private float a(float f) {
        return this.v * 386.0878f * f;
    }

    static float l(float f) {
        float f2 = f * A;
        return (f2 < 1.0f ? f2 - (1.0f - ((float) Math.exp(-f2))) : 0.36787945f + ((1.0f - ((float) Math.exp(1.0f - f2))) * 0.63212055f)) * B;
    }

    public boolean b() {
        if (this.q) {
            return false;
        }
        int iCurrentAnimationTimeMillis = (int) (AnimationUtils.currentAnimationTimeMillis() - this.l);
        int i = this.m;
        if (iCurrentAnimationTimeMillis < i) {
            int i2 = this.a;
            if (i2 == 0) {
                float f = iCurrentAnimationTimeMillis * this.n;
                Interpolator interpolator = this.r;
                float fL = interpolator == null ? l(f) : interpolator.getInterpolation(f);
                this.j = this.b + Math.round(this.o * fL);
                this.k = this.c + Math.round(fL * this.p);
            } else if (i2 == 1) {
                float f2 = iCurrentAnimationTimeMillis / i;
                int i3 = (int) (f2 * 100.0f);
                float f3 = i3 / 100.0f;
                int i4 = i3 + 1;
                float[] fArr = z;
                float f4 = fArr[i3];
                float f5 = f4 + (((f2 - f3) / ((i4 / 100.0f) - f3)) * (fArr[i4] - f4));
                int iRound = this.b + Math.round((this.d - r0) * f5);
                this.j = iRound;
                int iMin = Math.min(iRound, this.g);
                this.j = iMin;
                this.j = Math.max(iMin, this.f);
                int iRound2 = this.c + Math.round(f5 * (this.e - r0));
                this.k = iRound2;
                int iMin2 = Math.min(iRound2, this.i);
                this.k = iMin2;
                int iMax = Math.max(iMin2, this.h);
                this.k = iMax;
                if (this.j == this.d && iMax == this.e) {
                    this.q = true;
                }
            }
        } else {
            this.j = this.d;
            this.k = this.e;
            this.q = true;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c(int r17, int r18, int r19, int r20, int r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instructions count: 245
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C23274we6.c(int, int, int, int, int, int, int, int):void");
    }

    public final void d(boolean z2) {
        this.q = z2;
    }

    public float e() {
        return this.t - ((this.u * k()) / 2000.0f);
    }

    public final int f() {
        return this.k;
    }

    public final int g() {
        return this.e;
    }

    public final int h() {
        return this.c;
    }

    public final boolean i() {
        return this.q;
    }

    public void j(int i, int i2, int i3, int i4, int i5) {
        this.a = 0;
        this.q = false;
        this.m = i5;
        this.l = AnimationUtils.currentAnimationTimeMillis();
        this.b = i;
        this.c = i2;
        this.d = i + i3;
        this.e = i2 + i4;
        this.o = i3;
        this.p = i4;
        this.n = 1.0f / this.m;
    }

    public int k() {
        return (int) (AnimationUtils.currentAnimationTimeMillis() - this.l);
    }

    public C23274we6(Context context, Interpolator interpolator, boolean z2) {
        this.q = true;
        this.r = interpolator;
        this.v = context.getResources().getDisplayMetrics().density * 160.0f;
        this.u = a(ViewConfiguration.getScrollFriction());
        this.s = z2;
    }
}
