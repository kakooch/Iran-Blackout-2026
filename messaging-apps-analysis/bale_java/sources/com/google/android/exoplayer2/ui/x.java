package com.google.android.exoplayer2.ui;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.C14451hw1;
import ir.nasim.CF0;

/* loaded from: classes2.dex */
final class x {
    private int A;
    private int B;
    private int C;
    private int D;
    private StaticLayout E;
    private StaticLayout F;
    private int G;
    private int H;
    private int I;
    private Rect J;
    private final float a;
    private final float b;
    private final float c;
    private final float d;
    private final float e;
    private final TextPaint f;
    private final Paint g;
    private final Paint h;
    private CharSequence i;
    private Layout.Alignment j;
    private Bitmap k;
    private float l;
    private int m;
    private int n;
    private float o;
    private int p;
    private float q;
    private float r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private float x;
    private float y;
    private float z;

    public x(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{R.attr.lineSpacingExtra, R.attr.lineSpacingMultiplier}, 0, 0);
        this.e = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.d = typedArrayObtainStyledAttributes.getFloat(1, 1.0f);
        typedArrayObtainStyledAttributes.recycle();
        float fRound = Math.round((context.getResources().getDisplayMetrics().densityDpi * 2.0f) / 160.0f);
        this.a = fRound;
        this.b = fRound;
        this.c = fRound;
        TextPaint textPaint = new TextPaint();
        this.f = textPaint;
        textPaint.setAntiAlias(true);
        textPaint.setSubpixelText(true);
        Paint paint = new Paint();
        this.g = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.h = paint2;
        paint2.setAntiAlias(true);
        paint2.setFilterBitmap(true);
    }

    private static boolean a(CharSequence charSequence, CharSequence charSequence2) {
        return charSequence == charSequence2 || (charSequence != null && charSequence.equals(charSequence2));
    }

    private void c(Canvas canvas) {
        canvas.drawBitmap(this.k, (Rect) null, this.J, this.h);
    }

    private void d(Canvas canvas, boolean z) {
        if (z) {
            e(canvas);
            return;
        }
        AbstractC20011rK.e(this.J);
        AbstractC20011rK.e(this.k);
        c(canvas);
    }

    private void e(Canvas canvas) {
        StaticLayout staticLayout = this.E;
        StaticLayout staticLayout2 = this.F;
        if (staticLayout == null || staticLayout2 == null) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(this.G, this.H);
        if (Color.alpha(this.u) > 0) {
            this.g.setColor(this.u);
            canvas.drawRect(-this.I, 0.0f, staticLayout.getWidth() + this.I, staticLayout.getHeight(), this.g);
        }
        int i = this.w;
        if (i == 1) {
            this.f.setStrokeJoin(Paint.Join.ROUND);
            this.f.setStrokeWidth(this.a);
            this.f.setColor(this.v);
            this.f.setStyle(Paint.Style.FILL_AND_STROKE);
            staticLayout2.draw(canvas);
        } else if (i == 2) {
            TextPaint textPaint = this.f;
            float f = this.b;
            float f2 = this.c;
            textPaint.setShadowLayer(f, f2, f2, this.v);
        } else if (i == 3 || i == 4) {
            boolean z = i == 3;
            int i2 = z ? -1 : this.v;
            int i3 = z ? this.v : -1;
            float f3 = this.b / 2.0f;
            this.f.setColor(this.s);
            this.f.setStyle(Paint.Style.FILL);
            float f4 = -f3;
            this.f.setShadowLayer(this.b, f4, f4, i2);
            staticLayout2.draw(canvas);
            this.f.setShadowLayer(this.b, f3, f3, i3);
        }
        this.f.setColor(this.s);
        this.f.setStyle(Paint.Style.FILL);
        staticLayout.draw(canvas);
        this.f.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        canvas.restoreToCount(iSave);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void f() {
        /*
            r7 = this;
            android.graphics.Bitmap r0 = r7.k
            int r1 = r7.C
            int r2 = r7.A
            int r1 = r1 - r2
            int r3 = r7.D
            int r4 = r7.B
            int r3 = r3 - r4
            float r2 = (float) r2
            float r1 = (float) r1
            float r5 = r7.o
            float r5 = r5 * r1
            float r2 = r2 + r5
            float r4 = (float) r4
            float r3 = (float) r3
            float r5 = r7.l
            float r5 = r5 * r3
            float r4 = r4 + r5
            float r5 = r7.q
            float r1 = r1 * r5
            int r1 = java.lang.Math.round(r1)
            float r5 = r7.r
            r6 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            int r6 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r6 == 0) goto L2e
            float r3 = r3 * r5
            int r0 = java.lang.Math.round(r3)
            goto L3f
        L2e:
            float r3 = (float) r1
            int r5 = r0.getHeight()
            float r5 = (float) r5
            int r0 = r0.getWidth()
            float r0 = (float) r0
            float r5 = r5 / r0
            float r3 = r3 * r5
            int r0 = java.lang.Math.round(r3)
        L3f:
            int r3 = r7.p
            r5 = 1
            r6 = 2
            if (r3 != r6) goto L48
            float r3 = (float) r1
        L46:
            float r2 = r2 - r3
            goto L4e
        L48:
            if (r3 != r5) goto L4e
            int r3 = r1 / 2
            float r3 = (float) r3
            goto L46
        L4e:
            int r2 = java.lang.Math.round(r2)
            int r3 = r7.n
            if (r3 != r6) goto L59
            float r3 = (float) r0
        L57:
            float r4 = r4 - r3
            goto L5f
        L59:
            if (r3 != r5) goto L5f
            int r3 = r0 / 2
            float r3 = (float) r3
            goto L57
        L5f:
            int r3 = java.lang.Math.round(r4)
            android.graphics.Rect r4 = new android.graphics.Rect
            int r1 = r1 + r2
            int r0 = r0 + r3
            r4.<init>(r2, r3, r1, r0)
            r7.J = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.x.f():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void g() {
        /*
            Method dump skipped, instructions count: 489
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.x.g():void");
    }

    public void b(C14451hw1 c14451hw1, CF0 cf0, float f, float f2, float f3, Canvas canvas, int i, int i2, int i3, int i4) {
        int i5;
        boolean z = c14451hw1.d == null;
        if (!z) {
            i5 = -16777216;
        } else if (TextUtils.isEmpty(c14451hw1.a)) {
            return;
        } else {
            i5 = c14451hw1.l ? c14451hw1.m : cf0.c;
        }
        if (a(this.i, c14451hw1.a) && AbstractC9683aN7.c(this.j, c14451hw1.b) && this.k == c14451hw1.d && this.l == c14451hw1.e && this.m == c14451hw1.f && AbstractC9683aN7.c(Integer.valueOf(this.n), Integer.valueOf(c14451hw1.g)) && this.o == c14451hw1.h && AbstractC9683aN7.c(Integer.valueOf(this.p), Integer.valueOf(c14451hw1.i)) && this.q == c14451hw1.j && this.r == c14451hw1.k && this.s == cf0.a && this.t == cf0.b && this.u == i5 && this.w == cf0.d && this.v == cf0.e && AbstractC9683aN7.c(this.f.getTypeface(), cf0.f) && this.x == f && this.y == f2 && this.z == f3 && this.A == i && this.B == i2 && this.C == i3 && this.D == i4) {
            d(canvas, z);
            return;
        }
        this.i = c14451hw1.a;
        this.j = c14451hw1.b;
        this.k = c14451hw1.d;
        this.l = c14451hw1.e;
        this.m = c14451hw1.f;
        this.n = c14451hw1.g;
        this.o = c14451hw1.h;
        this.p = c14451hw1.i;
        this.q = c14451hw1.j;
        this.r = c14451hw1.k;
        this.s = cf0.a;
        this.t = cf0.b;
        this.u = i5;
        this.w = cf0.d;
        this.v = cf0.e;
        this.f.setTypeface(cf0.f);
        this.x = f;
        this.y = f2;
        this.z = f3;
        this.A = i;
        this.B = i2;
        this.C = i3;
        this.D = i4;
        if (z) {
            AbstractC20011rK.e(this.i);
            g();
        } else {
            AbstractC20011rK.e(this.k);
            f();
        }
        d(canvas, z);
    }
}
