package ir.nasim.features.media.components;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.widget.FrameLayout;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.C19406qI3;
import ir.nasim.C5495Jo7;

/* loaded from: classes6.dex */
public class PhotoCropView extends FrameLayout {
    private boolean a;
    private Paint b;
    private Paint c;
    private Paint d;
    private Paint e;
    private float f;
    private float g;
    private int h;
    private int i;
    private float j;
    private float k;
    private int l;
    private int m;
    private int n;
    private int o;
    private float p;
    private float q;
    private float r;
    private float s;
    private float t;
    private PhotoCropViewDelegate u;
    private Bitmap v;
    private RectF w;
    private RectF x;
    private Runnable y;

    public interface PhotoCropViewDelegate {
        Bitmap getBitmap();

        void needMoveImageTo(float f, float f2, float f3, boolean z);
    }

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (PhotoCropView.this.y == this) {
                PhotoCropView.this.y = null;
                PhotoCropView.this.moveToFill(true);
            }
        }
    }

    public PhotoCropView(Context context) {
        super(context);
        this.a = true;
        this.f = 600.0f;
        this.g = 600.0f;
        this.h = 0;
        this.j = 0.0f;
        this.k = 0.0f;
        this.l = 1;
        this.m = 1;
        this.p = -1.0f;
        this.q = -1.0f;
        this.r = 1.0f;
        this.s = 0.0f;
        this.t = 0.0f;
        Paint paint = new Paint();
        this.b = paint;
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        paint.setColor(c5495Jo7.y0(c5495Jo7.f0(), 70));
        this.b.setStrokeWidth(AbstractC7426Rr.z(2.0f));
        this.b.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint();
        this.c = paint2;
        paint2.setColor(c5495Jo7.f0());
        Paint paint3 = new Paint();
        this.d = paint3;
        paint3.setColor(c5495Jo7.y0(c5495Jo7.j2(), 50));
        Paint paint4 = new Paint();
        this.e = paint4;
        paint4.setColor(c5495Jo7.y0(c5495Jo7.j2(), 10));
        setWillNotDraw(false);
    }

    private Bitmap c(int i, int i2, int i3, int i4) {
        Bitmap bitmap = this.u.getBitmap();
        if (bitmap != null) {
            this.v = bitmap;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(6);
        Matrix matrix = new Matrix();
        matrix.setTranslate((-this.v.getWidth()) / 2, (-this.v.getHeight()) / 2);
        matrix.postRotate(this.i);
        int i5 = this.i;
        if (i5 % 360 == 90 || i5 % 360 == 270) {
            matrix.postTranslate((this.v.getHeight() / 2) - i, (this.v.getWidth() / 2) - i2);
        } else {
            matrix.postTranslate((this.v.getWidth() / 2) - i, (this.v.getHeight() / 2) - i2);
        }
        canvas.drawBitmap(this.v, matrix, paint);
        try {
            canvas.setBitmap(null);
        } catch (Exception unused) {
        }
        return bitmapCreateBitmap;
    }

    public void cancelAnimationRunnable() {
        Runnable runnable = this.y;
        if (runnable != null) {
            AbstractC7426Rr.w(runnable);
            this.y = null;
            this.w = null;
            this.x = null;
        }
    }

    public Bitmap getBitmap() {
        int height;
        int width;
        Bitmap bitmap = this.u.getBitmap();
        if (bitmap != null) {
            this.v = bitmap;
        }
        float f = this.l;
        float f2 = this.r;
        float f3 = f * f2;
        float f4 = this.m * f2;
        float fH = AbstractC7426Rr.H();
        float width2 = ((getWidth() - f3) / 2.0f) + this.s;
        float height2 = (((getHeight() - f4) + fH) / 2.0f) + this.t;
        float f5 = (this.p - width2) / f3;
        float f6 = (this.q - height2) / f4;
        float f7 = this.f / f3;
        float f8 = this.g / f4;
        int i = this.i;
        if (i % 360 == 90 || i % 360 == 270) {
            height = this.v.getHeight();
            width = this.v.getWidth();
        } else {
            height = this.v.getWidth();
            width = this.v.getHeight();
        }
        float f9 = height;
        int i2 = (int) (f5 * f9);
        float f10 = width;
        int i3 = (int) (f6 * f10);
        int i4 = (int) (f7 * f9);
        int i5 = (int) (f8 * f10);
        if (i2 < 0) {
            i2 = 0;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        if (i2 + i4 > height) {
            i4 = height - i2;
        }
        if (i3 + i5 > width) {
            i5 = width - i3;
        }
        try {
            return c(i2, i3, i4, i5);
        } catch (Throwable th) {
            C19406qI3.d("tmessags", th);
            System.gc();
            try {
                return c(i2, i3, i4, i5);
            } catch (Throwable th2) {
                C19406qI3.d("baleMessages", th2);
                return null;
            }
        }
    }

    public float getLimitHeight() {
        return ((((getHeight() - AbstractC7426Rr.z(14.0f)) - AbstractC7426Rr.H()) - this.q) - ((int) Math.max(0.0d, Math.ceil((((getHeight() - AbstractC7426Rr.z(28.0f)) - (this.m * this.r)) - r0) / 2.0f)))) - this.g;
    }

    public float getLimitWidth() {
        return (((getWidth() - AbstractC7426Rr.z(14.0f)) - this.p) - ((int) Math.max(0.0d, Math.ceil(((getWidth() - AbstractC7426Rr.z(28.0f)) - (this.l * this.r)) / 2.0f)))) - this.f;
    }

    public float getLimitX() {
        return this.p - Math.max(0.0f, (float) Math.ceil((getWidth() - (this.l * this.r)) / 2.0f));
    }

    public float getLimitY() {
        return this.q - Math.max(0.0f, (float) Math.ceil(((getHeight() - (this.m * this.r)) + AbstractC7426Rr.H()) / 2.0f));
    }

    public float getRectSizeX() {
        return this.f;
    }

    public float getRectSizeY() {
        return this.g;
    }

    public float getRectX() {
        return this.p - AbstractC7426Rr.z(14.0f);
    }

    public float getRectY() {
        return (this.q - AbstractC7426Rr.z(14.0f)) - AbstractC7426Rr.H();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void moveToFill(boolean r14) {
        /*
            r13 = this;
            int r0 = r13.l
            float r0 = (float) r0
            float r1 = r13.f
            float r0 = r0 / r1
            int r2 = r13.m
            float r2 = (float) r2
            float r3 = r13.g
            float r2 = r2 / r3
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L11
            r0 = r2
        L11:
            r2 = 1065353216(0x3f800000, float:1.0)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L24
            float r4 = r13.r
            float r5 = r0 * r4
            r6 = 1077936128(0x40400000, float:3.0)
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 <= 0) goto L24
            float r0 = r6 / r4
            goto L32
        L24:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L32
            float r4 = r13.r
            float r5 = r0 * r4
            int r5 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r5 >= 0) goto L32
            float r0 = r2 / r4
        L32:
            float r1 = r1 * r0
            float r3 = r3 * r0
            int r4 = ir.nasim.AbstractC7426Rr.H()
            float r4 = (float) r4
            int r5 = r13.getWidth()
            float r5 = (float) r5
            float r5 = r5 - r1
            r6 = 1073741824(0x40000000, float:2.0)
            float r5 = r5 / r6
            int r7 = r13.getHeight()
            float r7 = (float) r7
            float r7 = r7 - r3
            float r7 = r7 + r4
            float r7 = r7 / r6
            android.graphics.RectF r8 = new android.graphics.RectF
            float r9 = r13.p
            float r10 = r13.q
            float r11 = r13.f
            float r12 = r13.g
            r8.<init>(r9, r10, r11, r12)
            r13.w = r8
            android.graphics.RectF r8 = new android.graphics.RectF
            r8.<init>(r5, r7, r1, r3)
            r13.x = r8
            int r1 = r13.getWidth()
            int r1 = r1 / 2
            float r1 = (float) r1
            float r2 = r0 - r2
            float r1 = r1 * r2
            float r5 = r5 + r1
            float r1 = r13.s
            float r3 = r13.p
            float r1 = r1 - r3
            float r1 = r1 * r0
            float r5 = r5 + r1
            int r1 = r13.getHeight()
            float r1 = (float) r1
            float r1 = r1 + r4
            float r1 = r1 / r6
            float r1 = r1 * r2
            float r7 = r7 + r1
            float r1 = r13.t
            float r2 = r13.q
            float r1 = r1 - r2
            float r1 = r1 * r0
            float r7 = r7 + r1
            ir.nasim.features.media.components.PhotoCropView$PhotoCropViewDelegate r1 = r13.u
            float r2 = r13.r
            float r2 = r2 * r0
            r1.needMoveImageTo(r5, r7, r2, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.media.components.PhotoCropView.moveToFill(boolean):void");
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.q, this.d);
        float f = this.q;
        canvas.drawRect(0.0f, f, this.p, f + this.g, this.d);
        canvas.drawRect(this.p + this.f, this.q, getWidth(), this.q + this.g, this.d);
        canvas.drawRect(0.0f, this.q + this.g, getWidth(), getHeight(), this.d);
        int iZ = AbstractC7426Rr.z(1.0f);
        float f2 = this.p;
        float f3 = iZ * 2;
        canvas.drawRect(f2 - f3, this.q - f3, (f2 - f3) + AbstractC7426Rr.z(20.0f), this.q, this.c);
        float f4 = this.p;
        float f5 = this.q;
        canvas.drawRect(f4 - f3, f5 - f3, f4, (f5 - f3) + AbstractC7426Rr.z(20.0f), this.c);
        float fZ = ((this.p + this.f) + f3) - AbstractC7426Rr.z(20.0f);
        float f6 = this.q;
        canvas.drawRect(fZ, f6 - f3, this.p + this.f + f3, f6, this.c);
        float f7 = this.p;
        float f8 = this.f;
        float f9 = this.q;
        canvas.drawRect(f7 + f8, f9 - f3, f7 + f8 + f3, (f9 - f3) + AbstractC7426Rr.z(20.0f), this.c);
        canvas.drawRect(this.p - f3, ((this.q + this.g) + f3) - AbstractC7426Rr.z(20.0f), this.p, this.q + this.g + f3, this.c);
        float f10 = this.p;
        canvas.drawRect(f10 - f3, this.g + this.q, (f10 - f3) + AbstractC7426Rr.z(20.0f), this.q + this.g + f3, this.c);
        float fZ2 = ((this.p + this.f) + f3) - AbstractC7426Rr.z(20.0f);
        float f11 = this.q;
        float f12 = this.g;
        canvas.drawRect(fZ2, f11 + f12, this.p + this.f + f3, f11 + f12 + f3, this.c);
        canvas.drawRect(this.p + this.f, ((this.q + this.g) + f3) - AbstractC7426Rr.z(20.0f), this.p + this.f + f3, this.q + this.g + f3, this.c);
        for (int i = 1; i < 3; i++) {
            float f13 = this.p;
            float f14 = this.f;
            float f15 = i;
            float f16 = iZ;
            float f17 = this.q;
            canvas.drawRect((((f14 / 3.0f) * f15) + f13) - f16, f17, f13 + f3 + ((f14 / 3.0f) * f15), f17 + this.g, this.e);
            float f18 = this.p;
            float f19 = this.q;
            float f20 = this.g;
            canvas.drawRect(f18, (((f20 / 3.0f) * f15) + f19) - f16, f18 + this.f, f19 + ((f20 / 3.0f) * f15) + f3, this.e);
        }
        for (int i2 = 1; i2 < 3; i2++) {
            float f21 = this.p;
            float f22 = this.f;
            float f23 = i2;
            float f24 = this.q;
            float f25 = iZ;
            canvas.drawRect(f21 + ((f22 / 3.0f) * f23), f24, f21 + f25 + ((f22 / 3.0f) * f23), f24 + this.g, this.c);
            float f26 = this.p;
            float f27 = this.q;
            float f28 = this.g;
            canvas.drawRect(f26, f27 + ((f28 / 3.0f) * f23), f26 + this.f, f27 + ((f28 / 3.0f) * f23) + f25, this.c);
        }
        float f29 = this.p;
        float f30 = this.q;
        canvas.drawRect(f29, f30, f29 + this.f, f30 + this.g, this.b);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float height;
        int width;
        super.onLayout(z, i, i2, i3, i4);
        Bitmap bitmap = this.u.getBitmap();
        if (bitmap != null) {
            this.v = bitmap;
        }
        if (this.v == null) {
            return;
        }
        int width2 = getWidth() - AbstractC7426Rr.z(28.0f);
        int height2 = (getHeight() - AbstractC7426Rr.z(28.0f)) - AbstractC7426Rr.H();
        int i5 = this.i;
        if (i5 % 360 == 90 || i5 % 360 == 270) {
            height = this.v.getHeight();
            width = this.v.getWidth();
        } else {
            height = this.v.getWidth();
            width = this.v.getHeight();
        }
        float fCeil = width2;
        float fCeil2 = height2;
        if (fCeil / height > fCeil2 / width) {
            fCeil = (int) Math.ceil(height * r2);
        } else {
            fCeil2 = (int) Math.ceil(r10 * r0);
        }
        float f = this.p - this.n;
        int i6 = this.l;
        float f2 = f / i6;
        float f3 = this.q - this.o;
        int i7 = this.m;
        float f4 = f3 / i7;
        float f5 = this.f / i6;
        float f6 = this.g / i7;
        this.l = (int) fCeil;
        this.m = (int) fCeil2;
        this.n = (int) Math.ceil(((width2 - r11) / 2) + AbstractC7426Rr.z(14.0f));
        int iCeil = (int) Math.ceil(((height2 - this.m) / 2) + AbstractC7426Rr.z(14.0f) + AbstractC7426Rr.H());
        this.o = iCeil;
        if (this.p != -1.0f || this.q != -1.0f) {
            int i8 = this.l;
            this.p = (f2 * i8) + this.n;
            int i9 = this.m;
            this.q = (f4 * i9) + iCeil;
            this.f = f5 * i8;
            this.g = f6 * i9;
            return;
        }
        if (this.a) {
            this.q = iCeil;
            this.p = this.n;
            this.f = this.l;
            this.g = this.m;
            return;
        }
        if (this.l > this.m) {
            this.q = iCeil;
            this.p = ((width2 - r10) / 2) + AbstractC7426Rr.z(14.0f);
            int i10 = this.m;
            this.f = i10;
            this.g = i10;
            return;
        }
        this.p = this.n;
        this.q = ((height2 - r8) / 2) + AbstractC7426Rr.z(14.0f) + AbstractC7426Rr.H();
        int i11 = this.l;
        this.f = i11;
        this.g = i11;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x04ad  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x04af  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0137  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouch(android.view.MotionEvent r19) {
        /*
            Method dump skipped, instructions count: 1201
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.media.components.PhotoCropView.onTouch(android.view.MotionEvent):boolean");
    }

    public void setAnimationProgress(float f) {
        RectF rectF = this.w;
        if (rectF != null) {
            if (f == 1.0f) {
                RectF rectF2 = this.x;
                this.p = rectF2.left;
                this.q = rectF2.top;
                this.f = rectF2.right;
                this.g = rectF2.bottom;
                this.w = null;
                this.x = null;
            } else {
                float f2 = rectF.left;
                RectF rectF3 = this.x;
                this.p = f2 + ((rectF3.left - f2) * f);
                float f3 = rectF.top;
                this.q = f3 + ((rectF3.top - f3) * f);
                float f4 = rectF.right;
                this.f = f4 + ((rectF3.right - f4) * f);
                float f5 = rectF.bottom;
                this.g = f5 + ((rectF3.bottom - f5) * f);
            }
            invalidate();
        }
    }

    public void setBitmap(Bitmap bitmap, int i, boolean z) {
        this.v = bitmap;
        this.f = 600.0f;
        this.g = 600.0f;
        this.h = 0;
        this.j = 0.0f;
        this.k = 0.0f;
        this.l = 1;
        this.m = 1;
        this.p = -1.0f;
        this.q = -1.0f;
        this.a = z;
        this.i = i;
        requestLayout();
    }

    public void setBitmapParams(float f, float f2, float f3) {
        this.r = f;
        this.s = f2;
        this.t = f3;
    }

    public void setDelegate(PhotoCropViewDelegate photoCropViewDelegate) {
        this.u = photoCropViewDelegate;
    }

    public void setOrientation(int i) {
        this.i = i;
        this.p = -1.0f;
        this.q = -1.0f;
        this.f = 600.0f;
        this.g = 600.0f;
        this.u.needMoveImageTo(0.0f, 0.0f, 1.0f, false);
        requestLayout();
    }

    public void startAnimationRunnable() {
        if (this.y != null) {
            return;
        }
        a aVar = new a();
        this.y = aVar;
        AbstractC7426Rr.Q(aVar, 1500L);
    }
}
