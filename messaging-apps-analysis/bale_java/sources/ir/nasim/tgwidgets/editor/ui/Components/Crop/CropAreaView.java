package ir.nasim.tgwidgets.editor.ui.Components.Crop;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.SystemClock;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.annotation.Keep;
import ir.nasim.QY0;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;

/* loaded from: classes7.dex */
public class CropAreaView extends ViewGroup {
    private Paint A;
    private f A0;
    private Paint B;
    private float B0;
    private Animator C0;
    private AccelerateDecelerateInterpolator D;
    private d D0;
    private boolean E0;
    private boolean F0;
    private float G;
    private Bitmap G0;
    private float H;
    private Paint H0;
    private String I0;
    private boolean J;
    private StaticLayout J0;
    private Animator K0;
    private RectF L0;
    TextPaint M0;
    public float N0;
    public float O0;
    public float P0;
    public float Q0;
    public int a;
    public float b;
    public float c;
    private RectF d;
    private RectF e;
    private RectF f;
    private RectF g;
    private RectF h;
    private RectF i;
    private RectF j;
    private RectF k;
    private float l;
    private e m;
    private RectF n;
    private RectF o;
    private int p;
    private int q;
    private float r;
    private boolean s;
    private boolean t;
    private float u;
    private long v;
    private Paint w;
    private Paint x;
    private Paint y;
    private Paint z;
    private f z0;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            CropAreaView.this.C0 = null;
        }
    }

    class b extends AnimatorListenerAdapter {
        final /* synthetic */ RectF a;

        b(RectF rectF) {
            this.a = rectF;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            CropAreaView.this.setActualRect(this.a);
            CropAreaView.this.K0 = null;
        }
    }

    static /* synthetic */ class c {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[e.values().length];
            a = iArr;
            try {
                iArr[e.TOP_LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[e.TOP_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[e.BOTTOM_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[e.BOTTOM_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[e.TOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[e.LEFT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[e.RIGHT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[e.BOTTOM.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    interface d {
        void e();

        void f();

        void g();
    }

    private enum e {
        NONE,
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT,
        TOP,
        LEFT,
        BOTTOM,
        RIGHT
    }

    enum f {
        NONE,
        MINOR,
        MAJOR
    }

    public CropAreaView(Context context) {
        super(context);
        this.d = new RectF();
        this.e = new RectF();
        this.f = new RectF();
        this.g = new RectF();
        this.h = new RectF();
        this.i = new RectF();
        this.j = new RectF();
        this.k = new RectF();
        this.n = new RectF();
        this.o = new RectF();
        this.u = 1.0f;
        this.D = new AccelerateDecelerateInterpolator();
        this.F0 = true;
        this.L0 = new RectF();
        this.N0 = 0.0f;
        this.O0 = 1.0f;
        this.P0 = 0.0f;
        this.Q0 = 0.0f;
        this.J = false;
        this.t = true;
        this.s = true;
        this.G = AbstractC21455b.F(16.0f);
        this.H = AbstractC21455b.F(32.0f);
        this.A0 = f.NONE;
        Paint paint = new Paint();
        this.w = paint;
        paint.setColor(2130706432);
        Paint paint2 = new Paint();
        this.x = paint2;
        Paint.Style style = Paint.Style.FILL;
        paint2.setStyle(style);
        this.x.setColor(436207616);
        this.x.setStrokeWidth(AbstractC21455b.F(2.0f));
        Paint paint3 = new Paint();
        this.y = paint3;
        paint3.setStyle(style);
        this.y.setColor(-1);
        this.y.setStrokeWidth(AbstractC21455b.F(1.0f));
        Paint paint4 = new Paint();
        this.z = paint4;
        paint4.setStyle(style);
        this.z.setColor(-1);
        Paint paint5 = new Paint();
        this.A = paint5;
        paint5.setStyle(style);
        this.A.setColor(-1291845633);
        Paint paint6 = new Paint(1);
        this.H0 = paint6;
        paint6.setColor(0);
        this.H0.setStyle(style);
        this.H0.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Paint paint7 = new Paint(2);
        this.B = paint7;
        paint7.setColor(-1);
        setWillNotDraw(false);
    }

    private void d(RectF rectF, float f2) {
        float fHeight = rectF.height();
        rectF.right = rectF.left + (f2 * fHeight);
        rectF.bottom = rectF.top + fHeight;
    }

    private void e(RectF rectF, float f2) {
        float fWidth = rectF.width();
        rectF.right = rectF.left + fWidth;
        rectF.bottom = rectF.top + (fWidth / f2);
    }

    @Keep
    private float getGridProgress() {
        return this.B0;
    }

    private void l() {
        if (this.I0 == null) {
            this.J0 = null;
            return;
        }
        if (this.M0 == null) {
            TextPaint textPaint = new TextPaint();
            this.M0 = textPaint;
            textPaint.setColor(QY0.k(-1, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER));
            this.M0.setTextSize(AbstractC21455b.F(13.0f));
            this.M0.setTextAlign(Paint.Align.CENTER);
        }
        this.J0 = new StaticLayout(this.I0, this.M0, getMeasuredWidth() - AbstractC21455b.F(120.0f), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
    }

    @Keep
    private void setCropBottom(float f2) {
        this.n.bottom = f2;
        invalidate();
    }

    @Keep
    private void setCropLeft(float f2) {
        this.n.left = f2;
        invalidate();
    }

    @Keep
    private void setCropRight(float f2) {
        this.n.right = f2;
        invalidate();
    }

    @Keep
    private void setCropTop(float f2) {
        this.n.top = f2;
        invalidate();
    }

    @Keep
    private void setGridProgress(float f2) {
        this.B0 = f2;
        invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c(android.graphics.RectF r13, float r14) {
        /*
            r12 = this;
            boolean r0 = r12.J
            if (r0 != 0) goto L7
            int r0 = ir.nasim.tgwidgets.editor.messenger.AbstractC21455b.d
            goto L8
        L7:
            r0 = 0
        L8:
            float r0 = (float) r0
            int r1 = r12.getMeasuredHeight()
            float r1 = (float) r1
            float r2 = r12.r
            float r1 = r1 - r2
            float r1 = r1 - r0
            int r2 = r12.getMeasuredWidth()
            float r2 = (float) r2
            float r2 = r2 / r1
            int r3 = r12.getMeasuredWidth()
            float r3 = (float) r3
            float r3 = java.lang.Math.min(r3, r1)
            float r4 = r12.G
            r5 = 1073741824(0x40000000, float:2.0)
            float r4 = r4 * r5
            float r3 = r3 - r4
            int r4 = r12.getMeasuredWidth()
            float r4 = (float) r4
            float r6 = r12.G
            float r7 = r6 * r5
            float r4 = r4 - r7
            float r6 = r6 * r5
            float r6 = r1 - r6
            int r7 = r12.getMeasuredWidth()
            float r7 = (float) r7
            float r7 = r7 / r5
            float r1 = r1 / r5
            float r0 = r0 + r1
            r1 = 1065353216(0x3f800000, float:1.0)
            float r1 = r1 - r14
            float r1 = java.lang.Math.abs(r1)
            double r8 = (double) r1
            r10 = 4547007122018943789(0x3f1a36e2eb1c432d, double:1.0E-4)
            int r1 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r1 >= 0) goto L55
            float r3 = r3 / r5
            float r14 = r7 - r3
            float r1 = r0 - r3
            float r7 = r7 + r3
            float r0 = r0 + r3
            goto L79
        L55:
            float r1 = r14 - r2
            double r1 = (double) r1
            int r1 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
            if (r1 > 0) goto L6d
            float r1 = r6 * r14
            int r2 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r2 <= 0) goto L63
            goto L6d
        L63:
            float r1 = r1 / r5
            float r14 = r7 - r1
            float r6 = r6 / r5
            float r2 = r0 - r6
            float r7 = r7 + r1
            float r0 = r0 + r6
            r1 = r2
            goto L79
        L6d:
            float r1 = r4 / r5
            float r2 = r7 - r1
            float r4 = r4 / r14
            float r4 = r4 / r5
            float r14 = r0 - r4
            float r7 = r7 + r1
            float r0 = r0 + r4
            r1 = r14
            r14 = r2
        L79:
            r13.set(r14, r1, r7, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.Components.Crop.CropAreaView.c(android.graphics.RectF, float):void");
    }

    public void f(RectF rectF, Animator animator, boolean z) {
        if (!z) {
            setActualRect(rectF);
            return;
        }
        Animator animator2 = this.K0;
        if (animator2 != null) {
            animator2.cancel();
            this.K0 = null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        this.K0 = animatorSet;
        animatorSet.setDuration(300L);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "cropLeft", rectF.left);
        objectAnimatorOfFloat.setInterpolator(this.D);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, "cropTop", rectF.top);
        objectAnimatorOfFloat2.setInterpolator(this.D);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this, "cropRight", rectF.right);
        objectAnimatorOfFloat3.setInterpolator(this.D);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this, "cropBottom", rectF.bottom);
        objectAnimatorOfFloat4.setInterpolator(this.D);
        animator.setInterpolator(this.D);
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3, objectAnimatorOfFloat4, animator);
        animatorSet.addListener(new b(rectF));
        animatorSet.start();
    }

    public void g(RectF rectF) {
        rectF.set(this.n);
    }

    public float getAspectRatio() {
        RectF rectF = this.n;
        return (rectF.right - rectF.left) / (rectF.bottom - rectF.top);
    }

    @Keep
    public float getCropBottom() {
        return this.n.bottom;
    }

    public float getCropCenterX() {
        RectF rectF = this.n;
        return (rectF.left + rectF.right) / 2.0f;
    }

    public float getCropCenterY() {
        RectF rectF = this.n;
        return (rectF.top + rectF.bottom) / 2.0f;
    }

    public float getCropHeight() {
        RectF rectF = this.n;
        return rectF.bottom - rectF.top;
    }

    @Keep
    public float getCropLeft() {
        return this.n.left;
    }

    @Keep
    public float getCropRight() {
        return this.n.right;
    }

    @Keep
    public float getCropTop() {
        return this.n.top;
    }

    public float getCropWidth() {
        RectF rectF = this.n;
        return rectF.right - rectF.left;
    }

    public Interpolator getInterpolator() {
        return this.D;
    }

    public float getLockAspectRatio() {
        return this.l;
    }

    public RectF getTargetRectToFill() {
        return h(getAspectRatio());
    }

    public RectF h(float f2) {
        c(this.L0, f2);
        return this.L0;
    }

    public boolean i() {
        return this.E0;
    }

    public void j() {
        Animator animator = this.K0;
        if (animator != null) {
            animator.cancel();
            this.K0 = null;
        }
    }

    public void k(boolean z) {
        try {
            View decorView = ((Activity) getContext()).getWindow().getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z ? systemUiVisibility | 4 : systemUiVisibility & (-5));
        } catch (Exception unused) {
        }
    }

    public void m() {
        int iF = AbstractC21455b.F(16.0f);
        RectF rectF = this.d;
        RectF rectF2 = this.n;
        float f2 = rectF2.left;
        float f3 = iF;
        float f4 = rectF2.top;
        rectF.set(f2 - f3, f4 - f3, f2 + f3, f4 + f3);
        RectF rectF3 = this.e;
        RectF rectF4 = this.n;
        float f5 = rectF4.right;
        float f6 = rectF4.top;
        rectF3.set(f5 - f3, f6 - f3, f5 + f3, f6 + f3);
        RectF rectF5 = this.f;
        RectF rectF6 = this.n;
        float f7 = rectF6.left;
        float f8 = rectF6.bottom;
        rectF5.set(f7 - f3, f8 - f3, f7 + f3, f8 + f3);
        RectF rectF7 = this.g;
        RectF rectF8 = this.n;
        float f9 = rectF8.right;
        float f10 = rectF8.bottom;
        rectF7.set(f9 - f3, f10 - f3, f9 + f3, f10 + f3);
        RectF rectF9 = this.h;
        RectF rectF10 = this.n;
        float f11 = rectF10.left + f3;
        float f12 = rectF10.top;
        rectF9.set(f11, f12 - f3, rectF10.right - f3, f12 + f3);
        RectF rectF11 = this.i;
        RectF rectF12 = this.n;
        float f13 = rectF12.left;
        rectF11.set(f13 - f3, rectF12.top + f3, f13 + f3, rectF12.bottom - f3);
        RectF rectF13 = this.k;
        RectF rectF14 = this.n;
        float f14 = rectF14.right;
        rectF13.set(f14 - f3, rectF14.top + f3, f14 + f3, rectF14.bottom - f3);
        RectF rectF15 = this.j;
        RectF rectF16 = this.n;
        float f15 = rectF16.left + f3;
        float f16 = rectF16.bottom;
        rectF15.set(f15, f16 - f3, rectF16.right - f3, f16 + f3);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        if (this.F0) {
            int iF = AbstractC21455b.F(2.0f / this.O0);
            int iF2 = AbstractC21455b.F(16.0f / this.O0);
            int iF3 = AbstractC21455b.F(3.0f / this.O0);
            RectF rectF = this.n;
            float f2 = rectF.left;
            int i4 = ((int) f2) - iF;
            float f3 = rectF.top;
            int i5 = ((int) f3) - iF;
            int i6 = iF * 2;
            int i7 = ((int) (rectF.right - f2)) + i6;
            int i8 = ((int) (rectF.bottom - f3)) + i6;
            canvas.save();
            canvas.translate(this.P0, this.Q0);
            float f4 = this.O0;
            float f5 = (i7 / 2) + i4;
            float f6 = (i8 / 2) + i5;
            canvas.scale(f4, f4, f5, f6);
            canvas.rotate(this.N0, f5, f6);
            if (this.s) {
                int i9 = (-getWidth()) * 4;
                int i10 = (-getHeight()) * 4;
                int width = getWidth() * 4;
                int height = getHeight() * 4;
                this.w.setAlpha((int) (255.0f - (this.u * 127.0f)));
                float f7 = i9;
                float f8 = width;
                i = i5;
                i2 = i4;
                canvas.drawRect(f7, i10, f8, 0.0f, this.w);
                canvas.drawRect(f7, 0.0f, 0.0f, getHeight(), this.w);
                canvas.drawRect(getWidth(), 0.0f, f8, getHeight(), this.w);
                canvas.drawRect(f7, getHeight(), f8, height, this.w);
                float f9 = i + iF;
                canvas.drawRect(0.0f, 0.0f, getWidth(), f9, this.w);
                float f10 = (i + i8) - iF;
                canvas.drawRect(0.0f, f9, i2 + iF, f10, this.w);
                canvas.drawRect((i2 + i7) - iF, f9, getWidth(), f10, this.w);
                canvas.drawRect(0.0f, f10, getWidth(), getHeight(), this.w);
            } else {
                i = i5;
                i2 = i4;
            }
            if (!this.t) {
                return;
            }
            int i11 = iF3 - iF;
            int i12 = iF3 * 2;
            int i13 = i7 - i12;
            int i14 = i8 - i12;
            f fVar = this.A0;
            if (fVar == f.NONE && this.B0 > 0.0f) {
                fVar = this.z0;
            }
            f fVar2 = fVar;
            this.x.setAlpha((int) (this.B0 * 26.0f * this.u));
            this.y.setAlpha((int) (this.B0 * 178.0f * this.u));
            this.A.setAlpha((int) (this.u * 178.0f));
            this.z.setAlpha((int) (this.u * 255.0f));
            int i15 = i2 + i11;
            float f11 = i15;
            float f12 = i + i11;
            int i16 = i2 + i7;
            float f13 = i16 - i11;
            canvas.drawRect(f11, f12, f13, r1 + iF, this.A);
            float f14 = i15 + iF;
            int i17 = i + i8;
            float f15 = i17 - i11;
            canvas.drawRect(f11, f12, f14, f15, this.A);
            canvas.drawRect(f11, r11 - iF, f13, f15, this.A);
            canvas.drawRect(r2 - iF, f12, f13, f15, this.A);
            int i18 = 0;
            while (true) {
                int i19 = 3;
                if (i18 >= 3) {
                    break;
                }
                if (fVar2 == f.MINOR) {
                    int i20 = 1;
                    while (i20 < 4) {
                        if (i18 == 2 && i20 == i19) {
                            i3 = i20;
                        } else {
                            int i21 = i2 + iF3;
                            int i22 = i13 / 3;
                            float f16 = ((i22 / 3) * i20) + i21 + (i22 * i18);
                            int i23 = i + iF3;
                            float f17 = i23;
                            float f18 = i23 + i14;
                            i3 = i20;
                            canvas.drawLine(f16, f17, f16, f18, this.x);
                            canvas.drawLine(f16, f17, f16, f18, this.y);
                            int i24 = i14 / 3;
                            float f19 = i21;
                            float f20 = i23 + ((i24 / 3) * i3) + (i24 * i18);
                            float f21 = i21 + i13;
                            canvas.drawLine(f19, f20, f21, f20, this.x);
                            canvas.drawLine(f19, f20, f21, f20, this.y);
                        }
                        i20 = i3 + 1;
                        i19 = 3;
                    }
                } else if (fVar2 == f.MAJOR && i18 > 0) {
                    int i25 = i2 + iF3;
                    float f22 = ((i13 / 3) * i18) + i25;
                    int i26 = i + iF3;
                    float f23 = i26;
                    float f24 = i26 + i14;
                    canvas.drawLine(f22, f23, f22, f24, this.x);
                    canvas.drawLine(f22, f23, f22, f24, this.y);
                    float f25 = i25;
                    float f26 = i26 + ((i14 / 3) * i18);
                    float f27 = i25 + i13;
                    canvas.drawLine(f25, f26, f27, f26, this.x);
                    canvas.drawLine(f25, f26, f27, f26, this.y);
                }
                i18++;
            }
            float f28 = i2;
            float f29 = i;
            float f30 = i2 + iF2;
            float f31 = i + iF3;
            canvas.drawRect(f28, f29, f30, f31, this.z);
            float f32 = i2 + iF3;
            float f33 = i + iF2;
            canvas.drawRect(f28, f29, f32, f33, this.z);
            float f34 = i16 - iF2;
            float f35 = i16;
            canvas.drawRect(f34, f29, f35, f31, this.z);
            float f36 = i16 - iF3;
            canvas.drawRect(f36, f29, f35, f33, this.z);
            float f37 = i17 - iF3;
            float f38 = i17;
            canvas.drawRect(f28, f37, f30, f38, this.z);
            float f39 = i17 - iF2;
            canvas.drawRect(f28, f39, f32, f38, this.z);
            canvas.drawRect(f34, f37, f35, f38, this.z);
            canvas.drawRect(f36, f39, f35, f38, this.z);
            canvas.restore();
        } else {
            float measuredWidth = getMeasuredWidth() - (this.G * 2.0f);
            float measuredHeight = ((getMeasuredHeight() - this.r) - (!this.J ? AbstractC21455b.d : 0)) - (this.G * 2.0f);
            this.a = (int) Math.min(measuredWidth, measuredHeight);
            Bitmap bitmap = this.G0;
            if (bitmap == null || bitmap.getWidth() != this.a) {
                Bitmap bitmap2 = this.G0;
                boolean z = bitmap2 != null;
                if (bitmap2 != null) {
                    bitmap2.recycle();
                    this.G0 = null;
                }
                try {
                    int i27 = this.a;
                    this.G0 = Bitmap.createBitmap(i27, i27, Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(this.G0);
                    this.w.setAlpha(127);
                    int i28 = this.a;
                    canvas2.drawRect(0.0f, 0.0f, i28, i28, this.w);
                    int i29 = this.a;
                    canvas2.drawCircle(i29 / 2, i29 / 2, i29 / 2, this.H0);
                    canvas2.setBitmap(null);
                    if (!z) {
                        this.u = 0.0f;
                        this.v = SystemClock.elapsedRealtime();
                    }
                } catch (Throwable unused) {
                }
            }
            if (this.G0 != null) {
                this.B.setAlpha((int) (this.u * 255.0f));
                this.w.setAlpha(127);
                float f40 = this.G;
                int i30 = this.a;
                this.b = ((measuredWidth - i30) / 2.0f) + f40;
                float f41 = f40 + ((measuredHeight - i30) / 2.0f) + (!this.J ? AbstractC21455b.d : 0);
                this.c = f41;
                float f42 = f41 + i30;
                canvas.drawRect(0.0f, 0.0f, getWidth(), (int) this.c, this.w);
                float f43 = (int) f42;
                canvas.drawRect(0.0f, (int) this.c, (int) this.b, f43, this.w);
                canvas.drawRect((int) (r1 + i30), (int) this.c, getWidth(), f43, this.w);
                canvas.drawRect(0.0f, f43, getWidth(), getHeight(), this.w);
                canvas.drawBitmap(this.G0, (int) this.b, (int) this.c, this.B);
                if (getMeasuredHeight() > getMeasuredWidth() && this.J0 != null) {
                    canvas.save();
                    canvas.translate(getMeasuredWidth() / 2.0f, f42 + AbstractC21455b.F(16.0f));
                    this.J0.draw(canvas);
                    canvas.restore();
                }
            }
        }
        if (this.u < 1.0f) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j = jElapsedRealtime - this.v;
            if (j > 17) {
                j = 17;
            }
            this.v = jElapsedRealtime;
            float f44 = this.u + (j / 180.0f);
            this.u = f44;
            if (f44 > 1.0f) {
                this.u = 1.0f;
            }
            invalidate();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.E0) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        l();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) (motionEvent.getX() - ((ViewGroup) getParent()).getX());
        int y = (int) (motionEvent.getY() - ((ViewGroup) getParent()).getY());
        float f2 = !this.J ? AbstractC21455b.d : 0;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            if (!this.F0) {
                this.m = e.NONE;
                return false;
            }
            float f3 = x;
            float f4 = y;
            if (this.d.contains(f3, f4)) {
                this.m = e.TOP_LEFT;
            } else if (this.e.contains(f3, f4)) {
                this.m = e.TOP_RIGHT;
            } else if (this.f.contains(f3, f4)) {
                this.m = e.BOTTOM_LEFT;
            } else if (this.g.contains(f3, f4)) {
                this.m = e.BOTTOM_RIGHT;
            } else if (this.i.contains(f3, f4)) {
                this.m = e.LEFT;
            } else if (this.h.contains(f3, f4)) {
                this.m = e.TOP;
            } else if (this.k.contains(f3, f4)) {
                this.m = e.RIGHT;
            } else {
                if (!this.j.contains(f3, f4)) {
                    this.m = e.NONE;
                    return false;
                }
                this.m = e.BOTTOM;
            }
            this.p = x;
            this.q = y;
            setGridType(f.MAJOR, false);
            this.E0 = true;
            k(true);
            d dVar = this.D0;
            if (dVar != null) {
                dVar.e();
            }
            return true;
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.E0 = false;
            k(false);
            e eVar = this.m;
            e eVar2 = e.NONE;
            if (eVar == eVar2) {
                return false;
            }
            this.m = eVar2;
            d dVar2 = this.D0;
            if (dVar2 != null) {
                dVar2.f();
            }
            return true;
        }
        if (actionMasked != 2 || this.m == e.NONE) {
            return false;
        }
        this.o.set(this.n);
        float f5 = x - this.p;
        float f6 = y - this.q;
        this.p = x;
        this.q = y;
        boolean z = Math.abs(f5) > Math.abs(f6);
        switch (c.a[this.m.ordinal()]) {
            case 1:
                RectF rectF = this.o;
                rectF.left += f5;
                rectF.top += f6;
                if (this.l > 0.0f) {
                    float fWidth = rectF.width();
                    float fHeight = this.o.height();
                    if (z) {
                        e(this.o, this.l);
                    } else {
                        d(this.o, this.l);
                    }
                    RectF rectF2 = this.o;
                    rectF2.left -= rectF2.width() - fWidth;
                    RectF rectF3 = this.o;
                    rectF3.top -= rectF3.width() - fHeight;
                    break;
                }
                break;
            case 2:
                RectF rectF4 = this.o;
                rectF4.right += f5;
                rectF4.top += f6;
                if (this.l > 0.0f) {
                    float fHeight2 = rectF4.height();
                    if (z) {
                        e(this.o, this.l);
                    } else {
                        d(this.o, this.l);
                    }
                    RectF rectF5 = this.o;
                    rectF5.top -= rectF5.width() - fHeight2;
                    break;
                }
                break;
            case 3:
                RectF rectF6 = this.o;
                rectF6.left += f5;
                rectF6.bottom += f6;
                if (this.l > 0.0f) {
                    float fWidth2 = rectF6.width();
                    if (z) {
                        e(this.o, this.l);
                    } else {
                        d(this.o, this.l);
                    }
                    RectF rectF7 = this.o;
                    rectF7.left -= rectF7.width() - fWidth2;
                    break;
                }
                break;
            case 4:
                RectF rectF8 = this.o;
                rectF8.right += f5;
                rectF8.bottom += f6;
                float f7 = this.l;
                if (f7 > 0.0f) {
                    if (!z) {
                        d(rectF8, f7);
                        break;
                    } else {
                        e(rectF8, f7);
                        break;
                    }
                }
                break;
            case 5:
                RectF rectF9 = this.o;
                rectF9.top += f6;
                float f8 = this.l;
                if (f8 > 0.0f) {
                    d(rectF9, f8);
                    break;
                }
                break;
            case 6:
                RectF rectF10 = this.o;
                rectF10.left += f5;
                float f9 = this.l;
                if (f9 > 0.0f) {
                    e(rectF10, f9);
                    break;
                }
                break;
            case 7:
                RectF rectF11 = this.o;
                rectF11.right += f5;
                float f10 = this.l;
                if (f10 > 0.0f) {
                    e(rectF11, f10);
                    break;
                }
                break;
            case 8:
                RectF rectF12 = this.o;
                rectF12.bottom += f6;
                float f11 = this.l;
                if (f11 > 0.0f) {
                    d(rectF12, f11);
                    break;
                }
                break;
        }
        RectF rectF13 = this.o;
        float f12 = rectF13.left;
        float f13 = this.G;
        if (f12 < f13) {
            float f14 = this.l;
            if (f14 > 0.0f) {
                rectF13.bottom = rectF13.top + ((rectF13.right - f13) / f14);
            }
            rectF13.left = f13;
        } else if (rectF13.right > getWidth() - this.G) {
            this.o.right = getWidth() - this.G;
            if (this.l > 0.0f) {
                RectF rectF14 = this.o;
                rectF14.bottom = rectF14.top + (rectF14.width() / this.l);
            }
        }
        float f15 = this.G;
        float f16 = f2 + f15;
        float f17 = this.r + f15;
        RectF rectF15 = this.o;
        if (rectF15.top < f16) {
            float f18 = this.l;
            if (f18 > 0.0f) {
                rectF15.right = rectF15.left + ((rectF15.bottom - f16) * f18);
            }
            rectF15.top = f16;
        } else if (rectF15.bottom > getHeight() - f17) {
            this.o.bottom = getHeight() - f17;
            if (this.l > 0.0f) {
                RectF rectF16 = this.o;
                rectF16.right = rectF16.left + (rectF16.height() * this.l);
            }
        }
        float fWidth3 = this.o.width();
        float f19 = this.H;
        if (fWidth3 < f19) {
            RectF rectF17 = this.o;
            rectF17.right = rectF17.left + f19;
        }
        float fHeight3 = this.o.height();
        float f20 = this.H;
        if (fHeight3 < f20) {
            RectF rectF18 = this.o;
            rectF18.bottom = rectF18.top + f20;
        }
        float f21 = this.l;
        if (f21 > 0.0f) {
            if (f21 < 1.0f) {
                float fWidth4 = this.o.width();
                float f22 = this.H;
                if (fWidth4 <= f22) {
                    RectF rectF19 = this.o;
                    rectF19.right = rectF19.left + f22;
                    rectF19.bottom = rectF19.top + (rectF19.width() / this.l);
                }
            } else {
                float fHeight4 = this.o.height();
                float f23 = this.H;
                if (fHeight4 <= f23) {
                    RectF rectF20 = this.o;
                    rectF20.bottom = rectF20.top + f23;
                    rectF20.right = rectF20.left + (rectF20.height() * this.l);
                }
            }
        }
        setActualRect(this.o);
        d dVar3 = this.D0;
        if (dVar3 != null) {
            dVar3.g();
        }
        return true;
    }

    public void setActualRect(float f2) {
        c(this.n, f2);
        m();
        invalidate();
    }

    public void setBitmap(int i, int i2, boolean z, boolean z2) {
        this.F0 = z2;
        float f2 = z ? i2 / i : i / i2;
        if (!z2) {
            f2 = 1.0f;
            this.l = 1.0f;
        }
        setActualRect(f2);
    }

    public void setBottomPadding(float f2) {
        this.r = f2;
    }

    public void setDimVisibility(boolean z) {
        this.s = z;
    }

    public void setFrameVisibility(boolean z, boolean z2) {
        this.t = z;
        if (!z) {
            this.u = 1.0f;
            return;
        }
        this.u = z2 ? 0.0f : 1.0f;
        this.v = SystemClock.elapsedRealtime();
        invalidate();
    }

    public void setFreeform(boolean z) {
        this.F0 = z;
    }

    public void setGridType(f fVar, boolean z) {
        Animator animator = this.C0;
        if (animator != null && (!z || this.A0 != fVar)) {
            animator.cancel();
            this.C0 = null;
        }
        f fVar2 = this.A0;
        if (fVar2 == fVar) {
            return;
        }
        this.z0 = fVar2;
        this.A0 = fVar;
        f fVar3 = f.NONE;
        float f2 = fVar == fVar3 ? 0.0f : 1.0f;
        if (!z) {
            this.B0 = f2;
            invalidate();
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "gridProgress", this.B0, f2);
        this.C0 = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(200L);
        this.C0.addListener(new a());
        if (fVar == fVar3) {
            this.C0.setStartDelay(200L);
        }
        this.C0.start();
    }

    public void setIsVideo(boolean z) {
        this.H = AbstractC21455b.F(z ? 64.0f : 32.0f);
    }

    public void setListener(d dVar) {
        this.D0 = dVar;
    }

    public void setLockedAspectRatio(float f2) {
        this.l = f2;
    }

    public void setRotationScaleTranslation(float f2, float f3, float f4, float f5) {
        this.N0 = f2;
        this.O0 = f3;
        this.P0 = f4;
        this.Q0 = f5;
        invalidate();
    }

    public void setSubtitle(String str) {
        this.I0 = str;
        if (getMeasuredWidth() > 0) {
            l();
        }
    }

    public void setActualRect(RectF rectF) {
        this.n.set(rectF);
        m();
        invalidate();
    }
}
