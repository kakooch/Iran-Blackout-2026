package ir.nasim.tgwidgets.editor.ui.ActionBar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import ir.nasim.AbstractC14392hq2;
import ir.nasim.AbstractC21558tk6;
import ir.nasim.AbstractC22000uV3;
import ir.nasim.AbstractC8662Wx6;
import ir.nasim.C9151Ys;
import ir.nasim.FH3;
import ir.nasim.InterpolatorC12631ew1;
import ir.nasim.QY0;
import ir.nasim.TD5;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.Utilities;
import ir.nasim.tgwidgets.editor.messenger.v;
import ir.nasim.tgwidgets.editor.ui.ActionBar.m;
import ir.nasim.tgwidgets.editor.ui.Components.AnimatedTextView;
import ir.nasim.tgwidgets.editor.ui.Components.F;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes7.dex */
public class ActionBarMenuSlider extends FrameLayout {
    private ValueAnimator A;
    private boolean A0;
    private boolean B;
    private Runnable D;
    private ColorFilter G;
    private float H;
    private float J;
    private float a;
    private Utilities.a b;
    private AnimatedTextView.a c;
    private C9151Ys d;
    private Bitmap e;
    private BitmapShader f;
    private Matrix g;
    private int[] h;
    private float i;
    private boolean j;
    private boolean k;
    protected m.h l;
    private Paint m;
    private Paint n;
    private Paint o;
    private Paint p;
    private Paint q;
    private Paint r;
    private Paint s;
    private boolean t;
    private boolean u;
    private LinearGradient v;
    private int w;
    private int x;
    private Matrix y;
    private int z;
    private long z0;

    public static class SpeedSlider extends ActionBarMenuSlider {
        private final AbstractC21558tk6 B0;

        class a extends AbstractC14392hq2 {
            a(boolean z) {
                super(z);
            }

            @Override // ir.nasim.AbstractC21558tk6
            public CharSequence f(View view) {
                return F.a(SpeedSlider.this.getSpeed()) + "x  " + FH3.E("AccDescrSpeedSlider", TD5.tgwidget_AccDescrSpeedSlider);
            }

            @Override // ir.nasim.AbstractC14392hq2
            protected float k() {
                return 0.2f;
            }

            @Override // ir.nasim.AbstractC14392hq2
            protected float l() {
                return 2.5f;
            }

            @Override // ir.nasim.AbstractC14392hq2
            protected float m() {
                return 0.2f;
            }

            @Override // ir.nasim.AbstractC14392hq2
            public float n() {
                return SpeedSlider.this.getSpeed();
            }

            @Override // ir.nasim.AbstractC14392hq2
            public void o(float f) {
                SpeedSlider.this.setSpeed(f, true);
            }
        }

        public SpeedSlider(Context context, m.h hVar) {
            super(context, hVar);
            setFocusable(true);
            setFocusableInTouchMode(true);
            setImportantForAccessibility(1);
            a aVar = new a(false);
            this.B0 = aVar;
            setAccessibilityDelegate(aVar);
        }

        public float getSpeed() {
            return o(getValue());
        }

        @Override // ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarMenuSlider
        protected int h(float f) {
            return QY0.c(m.j0(m.dh, this.l), m.j0(m.eh, this.l), AbstractC22000uV3.a((((f * 2.3f) + 0.2f) - 1.0f) / 1.0f, 0.0f, 1.0f));
        }

        @Override // ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarMenuSlider
        protected String i(float f) {
            return F.a((f * 2.3f) + 0.2f) + "x";
        }

        public float o(float f) {
            return (f * 2.3f) + 0.2f;
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            this.B0.h(this, accessibilityNodeInfo);
        }

        @Override // android.view.View
        public boolean performAccessibilityAction(int i, Bundle bundle) {
            return super.performAccessibilityAction(i, bundle) || this.B0.i(this, i, bundle);
        }

        public void setSpeed(float f, boolean z) {
            setValue((f - 0.2f) / 2.3f, z);
        }
    }

    class a extends AnimatedTextView.a {
        a(boolean z, boolean z2, boolean z3) {
            super(z, z2, z3);
        }

        @Override // android.graphics.drawable.Drawable
        public void invalidateSelf() {
            ActionBarMenuSlider.this.invalidate();
        }
    }

    class b extends AnimatorListenerAdapter {
        final /* synthetic */ float a;

        b(float f) {
            this.a = f;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ActionBarMenuSlider.this.A = null;
            ActionBarMenuSlider.this.a = this.a;
            ActionBarMenuSlider.this.invalidate();
        }
    }

    public ActionBarMenuSlider(Context context) {
        this(context, null);
    }

    private void f(Canvas canvas, boolean z) {
        ColorFilter porterDuffColorFilter;
        AnimatedTextView.a aVar = this.c;
        if (z) {
            porterDuffColorFilter = this.G;
            if (porterDuffColorFilter == null) {
                porterDuffColorFilter = new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_IN);
                this.G = porterDuffColorFilter;
            }
        } else {
            porterDuffColorFilter = null;
        }
        aVar.setColorFilter(porterDuffColorFilter);
        this.c.setBounds(getPaddingLeft() + AbstractC21455b.F(20.0f), getMeasuredHeight() / 2, (getMeasuredWidth() - getPaddingRight()) - AbstractC21455b.F(20.0f), getMeasuredHeight() / 2);
        this.c.draw(canvas);
    }

    private Pair g(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        float f = this.h[0] / AbstractC21455b.h.x;
        int width = (int) (f * bitmap.getWidth());
        int measuredWidth = (int) (((r1 + getMeasuredWidth()) / AbstractC21455b.h.x) * bitmap.getWidth());
        int currentActionBarHeight = (int) ((((this.h[1] - AbstractC21455b.d) - ActionBar.getCurrentActionBarHeight()) / AbstractC21455b.h.y) * bitmap.getHeight());
        if (width < 0 || width >= bitmap.getWidth() || measuredWidth < 0 || measuredWidth >= bitmap.getWidth() || currentActionBarHeight < 0 || currentActionBarHeight >= bitmap.getHeight()) {
            return null;
        }
        return new Pair(Integer.valueOf(bitmap.getPixel(width, currentActionBarHeight)), Integer.valueOf(bitmap.getPixel(measuredWidth, currentActionBarHeight)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(Bitmap bitmap) {
        this.B = false;
        this.e = bitmap;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.f = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = this.g;
        if (matrix == null) {
            this.g = new Matrix();
        } else {
            matrix.reset();
        }
        this.g.postScale(8.0f, 8.0f);
        Matrix matrix2 = this.g;
        int[] iArr = this.h;
        matrix2.postTranslate(-iArr[0], -iArr[1]);
        this.f.setLocalMatrix(this.g);
        this.o.setShader(this.f);
        ColorMatrix colorMatrix = new ColorMatrix();
        AbstractC21455b.r(colorMatrix, -0.2f);
        this.o.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k() throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        this.B = true;
        AbstractC21455b.a1(new Utilities.b() { // from class: ir.nasim.r5
            @Override // ir.nasim.tgwidgets.editor.messenger.Utilities.b
            public final void a(Object obj) {
                this.a.j((Bitmap) obj);
            }
        }, 8.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(ValueAnimator valueAnimator) {
        this.a = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    private void m() throws InterruptedException {
        int iJ0;
        int iIntValue;
        if (this.u) {
            Drawable drawableG0 = m.g0();
            if (drawableG0 instanceof ColorDrawable) {
                iJ0 = ((ColorDrawable) drawableG0).getColor();
            } else {
                Pair pairG = g(drawableG0 instanceof BitmapDrawable ? ((BitmapDrawable) drawableG0).getBitmap() : null);
                if (pairG != null) {
                    int iIntValue2 = ((Integer) pairG.first).intValue();
                    iIntValue = ((Integer) pairG.second).intValue();
                    iJ0 = iIntValue2;
                    if (this.v == null && this.w == iJ0 && this.x == iIntValue) {
                        return;
                    }
                    this.w = iJ0;
                    this.x = iIntValue;
                    LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, 1.0f, 0.0f, new int[]{iJ0, iIntValue}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
                    this.v = linearGradient;
                    this.r.setShader(linearGradient);
                }
                iJ0 = m.Q0(m.j0(m.N4, this.l), 0.25f);
            }
        } else {
            iJ0 = m.j0(m.N4, this.l);
            if (!m.D0()) {
                iJ0 = m.D(iJ0, m.Q0(-16777216, 0.18f));
            }
        }
        iIntValue = iJ0;
        if (this.v == null) {
        }
        this.w = iJ0;
        this.x = iIntValue;
        LinearGradient linearGradient2 = new LinearGradient(0.0f, 0.0f, 1.0f, 0.0f, new int[]{iJ0, iIntValue}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
        this.v = linearGradient2;
        this.r.setShader(linearGradient2);
    }

    private void n(float f, boolean z) {
        setValue(f, false);
        Utilities.a aVar = this.b;
        if (aVar != null) {
            aVar.a(Float.valueOf(this.a), Boolean.valueOf(z));
        }
    }

    public float getValue() {
        return this.a;
    }

    protected int h(float f) {
        return -1;
    }

    protected String i(float f) {
        return null;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = AbstractC21455b.x;
        rectF.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        if (this.j) {
            canvas.drawRoundRect(rectF, AbstractC21455b.F(this.i), AbstractC21455b.F(this.i), this.m);
        }
        if (this.k) {
            float fC = this.d.c(this.e != null ? 1.0f : 0.0f);
            if (fC < 1.0f) {
                if (this.y == null || this.z != ((int) rectF.width())) {
                    Matrix matrix = this.y;
                    if (matrix == null) {
                        this.y = new Matrix();
                    } else {
                        matrix.reset();
                    }
                    Matrix matrix2 = this.y;
                    int iWidth = (int) rectF.width();
                    this.z = iWidth;
                    matrix2.postScale(iWidth, 1.0f);
                    this.v.setLocalMatrix(this.y);
                }
                this.r.setAlpha((int) ((1.0f - fC) * 255.0f));
                canvas.drawRoundRect(rectF, AbstractC21455b.F(this.i), AbstractC21455b.F(this.i), this.r);
            }
            if (this.e != null && this.a < 1.0f && fC > 0.0f) {
                this.o.setAlpha((int) (fC * 255.0f));
                canvas.drawRoundRect(rectF, AbstractC21455b.F(this.i), AbstractC21455b.F(this.i), this.o);
            }
            canvas.drawRoundRect(rectF, AbstractC21455b.F(this.i), AbstractC21455b.F(this.i), this.p);
            canvas.drawRoundRect(rectF, AbstractC21455b.F(this.i), AbstractC21455b.F(this.i), this.q);
            this.s.setColor(-1);
        } else {
            canvas.drawRoundRect(rectF, AbstractC21455b.F(this.i), AbstractC21455b.F(this.i), this.n);
        }
        if (!this.t) {
            f(canvas, false);
        }
        if (this.a < 1.0f) {
            canvas.save();
            canvas.clipRect(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + (((getWidth() - getPaddingLeft()) - getPaddingRight()) * this.a), getHeight() - getPaddingBottom());
        }
        canvas.drawRoundRect(rectF, AbstractC21455b.F(this.i), AbstractC21455b.F(this.i), this.s);
        if (!this.t) {
            f(canvas, true);
        }
        if (this.a < 1.0f) {
            canvas.restore();
        }
        if (this.t) {
            f(canvas, false);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) throws InterruptedException {
        super.onLayout(z, i, i2, i3, i4);
        getLocationOnScreen(this.h);
        Matrix matrix = this.g;
        if (matrix != null) {
            matrix.reset();
            this.g.postScale(8.0f, 8.0f);
            Matrix matrix2 = this.g;
            int[] iArr = this.h;
            matrix2.postTranslate(-iArr[0], -iArr[1]);
            BitmapShader bitmapShader = this.f;
            if (bitmapShader != null) {
                bitmapShader.setLocalMatrix(this.g);
                invalidate();
            }
        }
        m();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.j) {
            i = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i) + getPaddingRight() + getPaddingLeft(), 1073741824);
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(AbstractC21455b.F(44.0f) + getPaddingTop() + getPaddingBottom(), 1073741824));
        boolean z = AbstractC8662Wx6.h() >= 2 && v.e(256);
        if (this.k && this.e == null && !this.B && z) {
            this.D.run();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX() - getPaddingLeft();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.A0 = true;
            this.H = x;
            this.J = this.a;
            this.z0 = System.currentTimeMillis();
        } else if (action == 2 || action == 1) {
            if (action == 1) {
                this.A0 = false;
                if (System.currentTimeMillis() - this.z0 < ViewConfiguration.getTapTimeout()) {
                    float paddingLeft = (x - getPaddingLeft()) / ((getWidth() - getPaddingLeft()) - getPaddingRight());
                    Utilities.a aVar = this.b;
                    if (aVar != null) {
                        aVar.a(Float.valueOf(paddingLeft), Boolean.TRUE);
                    }
                    return true;
                }
            }
            n(this.J + ((x - this.H) / Math.max(1, (getWidth() - getPaddingLeft()) - getPaddingRight())), !this.A0);
        }
        return true;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.n.setColor(i);
        boolean z = AbstractC21455b.z(this.n.getColor()) <= 0.721f;
        this.t = z;
        this.c.R(z ? -1 : -16777216);
    }

    public void setDrawShadow(boolean z) {
        this.j = z;
        int iF = z ? AbstractC21455b.F(8.0f) : 0;
        setPadding(iF, iF, iF, iF);
        invalidate();
    }

    public void setOnValueChange(Utilities.a aVar) {
        this.b = aVar;
    }

    public void setTextColor(int i) {
        this.c.R(i);
    }

    public void setValue(float f, boolean z) {
        ValueAnimator valueAnimator = this.A;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.A = null;
        }
        float fA = AbstractC22000uV3.a(f, 0.0f, 1.0f);
        if (z) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.a, fA);
            this.A = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.q5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    this.a.l(valueAnimator2);
                }
            });
            this.A.addListener(new b(fA));
            this.A.setInterpolator(InterpolatorC12631ew1.h);
            this.A.setDuration(220L);
            this.A.start();
        } else {
            this.a = fA;
            invalidate();
        }
        String strI = i(fA);
        if (strI != null && !TextUtils.equals(this.c.w(), strI)) {
            this.c.r();
            this.c.P(strI, true);
        }
        this.s.setColor(h(fA));
    }

    public ActionBarMenuSlider(Context context, m.h hVar) {
        super(context);
        this.a = 0.5f;
        InterpolatorC12631ew1 interpolatorC12631ew1 = InterpolatorC12631ew1.h;
        this.d = new C9151Ys(1.0f, this, 0L, 320L, interpolatorC12631ew1);
        this.h = new int[2];
        this.i = 0.0f;
        this.m = new Paint(1);
        this.n = new Paint(1);
        this.o = new Paint(1);
        this.p = new Paint(1);
        this.q = new Paint(1);
        this.r = new Paint(1);
        this.s = new Paint(1);
        this.u = true;
        this.B = false;
        this.D = new Runnable() { // from class: ir.nasim.p5
            @Override // java.lang.Runnable
            public final void run() throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
                this.a.k();
            }
        };
        this.l = hVar;
        setWillNotDraw(false);
        a aVar = new a(false, true, true);
        this.c = aVar;
        aVar.setCallback(this);
        this.c.T(AbstractC21455b.q0("fonts/rmedium.ttf"));
        this.c.G(0.3f, 0L, 165L, interpolatorC12631ew1);
        this.c.S(AbstractC21455b.H(14.0f));
        this.c.v().setStyle(Paint.Style.FILL_AND_STROKE);
        this.c.v().setStrokeWidth(AbstractC21455b.H(0.3f));
        this.c.I(FH3.D ? 5 : 3);
        this.m.setColor(0);
        this.m.setShadowLayer(AbstractC21455b.H(1.33f), 0.0f, AbstractC21455b.H(0.33f), 1056964608);
        ColorMatrix colorMatrix = new ColorMatrix();
        AbstractC21455b.r(colorMatrix, -0.4f);
        AbstractC21455b.q(colorMatrix, 0.1f);
        this.r.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        this.n.setColor(m.j0(m.n7, hVar));
        boolean z = AbstractC21455b.z(this.n.getColor()) <= 0.721f;
        this.t = z;
        this.c.R(z ? -1 : -16777216);
        this.q.setColor(m.Q0(-16777216, 0.025f));
        this.p.setColor(m.Q0(-1, 0.35f));
    }
}
