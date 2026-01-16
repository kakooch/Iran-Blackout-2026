package ir.nasim.tgwidgets.editor.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.FrameLayout;
import ir.nasim.AbstractC13840gu3;
import ir.nasim.AbstractC18973pa;
import ir.nasim.AbstractC6403Nl2;
import ir.nasim.HU1;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.Utilities;
import ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBar;
import ir.nasim.tgwidgets.editor.ui.ActionBar.m;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class SizeNotifierFrameLayout extends FrameLayout {
    private static HU1 P0;
    c A;
    public Paint A0;
    public ArrayList B;
    public Paint B0;
    private Paint C0;
    public ArrayList D;
    private Paint D0;
    public float E0;
    private final float F0;
    Matrix G;
    private final int G0;
    Matrix H;
    ValueAnimator H0;
    public boolean I0;
    public Paint J;
    int J0;
    int K0;
    int L0;
    int M0;
    private float N0;
    final b O0;
    private Rect a;
    private Drawable b;
    private boolean c;
    private Drawable d;
    private boolean e;
    protected int f;
    private int g;
    private boolean h;
    private float i;
    private float j;
    private float k;
    private int l;
    private boolean m;
    private ir.nasim.tgwidgets.editor.ui.ActionBar.l n;
    public AbstractC18973pa o;
    private int p;
    private float q;
    private boolean r;
    private boolean s;
    protected View t;
    boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    c z;
    public Paint z0;

    private class a extends View {
        public a(Context context) {
            super(context);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            float f;
            float f2;
            float f3;
            if (SizeNotifierFrameLayout.this.b == null || SizeNotifierFrameLayout.this.s) {
                return;
            }
            Drawable newDrawable = SizeNotifierFrameLayout.this.getNewDrawable();
            boolean newDrawableMotion = SizeNotifierFrameLayout.this.getNewDrawableMotion();
            float f4 = 0.0f;
            if (newDrawable != SizeNotifierFrameLayout.this.b && newDrawable != null) {
                if (ir.nasim.tgwidgets.editor.ui.ActionBar.m.C0()) {
                    SizeNotifierFrameLayout sizeNotifierFrameLayout = SizeNotifierFrameLayout.this;
                    sizeNotifierFrameLayout.d = sizeNotifierFrameLayout.b;
                    SizeNotifierFrameLayout sizeNotifierFrameLayout2 = SizeNotifierFrameLayout.this;
                    sizeNotifierFrameLayout2.e = sizeNotifierFrameLayout2.c;
                }
                SizeNotifierFrameLayout.this.b = newDrawable;
                SizeNotifierFrameLayout.this.c = newDrawableMotion;
                SizeNotifierFrameLayout.this.N0 = 0.0f;
                SizeNotifierFrameLayout.this.v();
            }
            SizeNotifierFrameLayout sizeNotifierFrameLayout3 = SizeNotifierFrameLayout.this;
            float f5 = 1.0f;
            sizeNotifierFrameLayout3.N0 = Utilities.c(sizeNotifierFrameLayout3.N0 + (AbstractC21455b.j / 200.0f), 1.0f, 0.0f);
            int i = 0;
            while (i < 2) {
                SizeNotifierFrameLayout sizeNotifierFrameLayout4 = SizeNotifierFrameLayout.this;
                Drawable drawable = i == 0 ? sizeNotifierFrameLayout4.d : sizeNotifierFrameLayout4.b;
                if (drawable != null) {
                    if (i != 1 || SizeNotifierFrameLayout.this.d == null || SizeNotifierFrameLayout.this.n == null) {
                        drawable.setAlpha(255);
                    } else {
                        drawable.setAlpha((int) (SizeNotifierFrameLayout.this.N0 * 255.0f));
                    }
                    SizeNotifierFrameLayout sizeNotifierFrameLayout5 = SizeNotifierFrameLayout.this;
                    if (i == 0 ? sizeNotifierFrameLayout5.e : sizeNotifierFrameLayout5.c) {
                        f = SizeNotifierFrameLayout.this.k;
                        f2 = SizeNotifierFrameLayout.this.i;
                        f3 = SizeNotifierFrameLayout.this.j;
                    } else {
                        f = f5;
                        f2 = f4;
                        f3 = f2;
                    }
                    if (drawable instanceof ColorDrawable) {
                        if (SizeNotifierFrameLayout.this.g != 0) {
                            canvas.save();
                            canvas.clipRect(0, 0, getMeasuredWidth(), getMeasuredHeight() - SizeNotifierFrameLayout.this.g);
                        }
                        drawable.setBounds(0, 0, getMeasuredWidth(), getRootView().getMeasuredHeight());
                        drawable.draw(canvas);
                        SizeNotifierFrameLayout.this.w(canvas);
                        if (SizeNotifierFrameLayout.this.g != 0) {
                            canvas.restore();
                        }
                    } else if (drawable instanceof GradientDrawable) {
                        if (SizeNotifierFrameLayout.this.g != 0) {
                            canvas.save();
                            canvas.clipRect(0, 0, getMeasuredWidth(), getRootView().getMeasuredHeight() - SizeNotifierFrameLayout.this.g);
                        }
                        drawable.setBounds(0, SizeNotifierFrameLayout.this.l, getMeasuredWidth(), SizeNotifierFrameLayout.this.l + getRootView().getMeasuredHeight());
                        drawable.draw(canvas);
                        SizeNotifierFrameLayout.this.w(canvas);
                        if (SizeNotifierFrameLayout.this.g != 0) {
                            canvas.restore();
                        }
                    } else if (!(drawable instanceof BitmapDrawable)) {
                        if (SizeNotifierFrameLayout.this.g != 0) {
                            canvas.save();
                            canvas.clipRect(0, 0, getMeasuredWidth(), getRootView().getMeasuredHeight() - SizeNotifierFrameLayout.this.g);
                        }
                        float f6 = f - 1.0f;
                        float f7 = (((-getMeasuredWidth()) * f6) / 2.0f) + f2;
                        float f8 = (((-getRootView().getMeasuredHeight()) * f6) / 2.0f) + f3;
                        drawable.setBounds((int) f7, (int) (SizeNotifierFrameLayout.this.l + f8), (int) ((getMeasuredWidth() * f) + f7), (int) (SizeNotifierFrameLayout.this.l + (getRootView().getMeasuredHeight() * f) + f8));
                        drawable.draw(canvas);
                        SizeNotifierFrameLayout.this.w(canvas);
                        if (SizeNotifierFrameLayout.this.g != 0) {
                            canvas.restore();
                        }
                    } else if (((BitmapDrawable) drawable).getTileModeX() == Shader.TileMode.REPEAT) {
                        canvas.save();
                        float f9 = 2.0f / AbstractC21455b.g;
                        canvas.scale(f9, f9);
                        drawable.setBounds(0, 0, (int) Math.ceil(getMeasuredWidth() / f9), (int) Math.ceil(getRootView().getMeasuredHeight() / f9));
                        drawable.draw(canvas);
                        SizeNotifierFrameLayout.this.w(canvas);
                        canvas.restore();
                    } else {
                        int currentActionBarHeight = (SizeNotifierFrameLayout.this.B() ? ActionBar.getCurrentActionBarHeight() : 0) + (SizeNotifierFrameLayout.this.h ? AbstractC21455b.d : 0);
                        int measuredHeight = getRootView().getMeasuredHeight() - currentActionBarHeight;
                        float fMax = Math.max(getMeasuredWidth() / drawable.getIntrinsicWidth(), measuredHeight / drawable.getIntrinsicHeight());
                        int iCeil = (int) Math.ceil(drawable.getIntrinsicWidth() * fMax * f);
                        int iCeil2 = (int) Math.ceil(drawable.getIntrinsicHeight() * fMax * f);
                        int measuredWidth = ((getMeasuredWidth() - iCeil) / 2) + ((int) f2);
                        int i2 = SizeNotifierFrameLayout.this.l + ((measuredHeight - iCeil2) / 2) + currentActionBarHeight + ((int) f3);
                        canvas.save();
                        canvas.clipRect(0, currentActionBarHeight, iCeil, getMeasuredHeight() - SizeNotifierFrameLayout.this.g);
                        drawable.setBounds(measuredWidth, i2, iCeil + measuredWidth, iCeil2 + i2);
                        drawable.draw(canvas);
                        SizeNotifierFrameLayout.this.w(canvas);
                        canvas.restore();
                    }
                    if (i == 0 && SizeNotifierFrameLayout.this.d != null && SizeNotifierFrameLayout.this.N0 >= 1.0f) {
                        SizeNotifierFrameLayout.this.d = null;
                        SizeNotifierFrameLayout.this.e = false;
                        SizeNotifierFrameLayout.this.v();
                        SizeNotifierFrameLayout.this.t.invalidate();
                    }
                }
                i++;
                f5 = 1.0f;
                f4 = 0.0f;
            }
            if (SizeNotifierFrameLayout.this.N0 != 1.0f) {
                SizeNotifierFrameLayout.this.t.invalidate();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class b implements Runnable {
        int a;
        c b;

        class a extends AnimatorListenerAdapter {
            final /* synthetic */ c a;

            a(c cVar) {
                this.a = cVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                SizeNotifierFrameLayout sizeNotifierFrameLayout = SizeNotifierFrameLayout.this;
                sizeNotifierFrameLayout.E0 = 1.0f;
                sizeNotifierFrameLayout.B.add(this.a);
                SizeNotifierFrameLayout.this.z0.setShader(null);
                SizeNotifierFrameLayout.this.B0.setShader(null);
                SizeNotifierFrameLayout.this.A();
                super.onAnimationEnd(animator);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(ValueAnimator valueAnimator) {
            SizeNotifierFrameLayout.this.E0 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            SizeNotifierFrameLayout.this.A();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e() {
            SizeNotifierFrameLayout sizeNotifierFrameLayout = SizeNotifierFrameLayout.this;
            sizeNotifierFrameLayout.y = false;
            sizeNotifierFrameLayout.D();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f() {
            SizeNotifierFrameLayout sizeNotifierFrameLayout = SizeNotifierFrameLayout.this;
            if (!sizeNotifierFrameLayout.x) {
                c cVar = this.b;
                if (cVar != null) {
                    cVar.a();
                }
                SizeNotifierFrameLayout.this.y = false;
                return;
            }
            c cVar2 = sizeNotifierFrameLayout.z;
            sizeNotifierFrameLayout.A = cVar2;
            sizeNotifierFrameLayout.z0.setShader(sizeNotifierFrameLayout.J.getShader());
            SizeNotifierFrameLayout sizeNotifierFrameLayout2 = SizeNotifierFrameLayout.this;
            sizeNotifierFrameLayout2.B0.setShader(sizeNotifierFrameLayout2.A0.getShader());
            Bitmap bitmap = this.b.d;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            SizeNotifierFrameLayout.this.J.setShader(new BitmapShader(bitmap, tileMode, tileMode));
            c cVar3 = this.b;
            if (cVar3.a && cVar3.l != null) {
                SizeNotifierFrameLayout.this.A0.setShader(new BitmapShader(this.b.l, tileMode, tileMode));
            }
            ValueAnimator valueAnimator = SizeNotifierFrameLayout.this.H0;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            SizeNotifierFrameLayout sizeNotifierFrameLayout3 = SizeNotifierFrameLayout.this;
            sizeNotifierFrameLayout3.E0 = 0.0f;
            sizeNotifierFrameLayout3.H0 = ValueAnimator.ofFloat(0.0f, 1.0f);
            SizeNotifierFrameLayout.this.H0.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.tgwidgets.editor.ui.Components.D
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    this.a.d(valueAnimator2);
                }
            });
            SizeNotifierFrameLayout.this.H0.addListener(new a(cVar2));
            SizeNotifierFrameLayout.this.H0.setDuration(50L);
            SizeNotifierFrameLayout.this.H0.start();
            SizeNotifierFrameLayout.this.A();
            SizeNotifierFrameLayout.this.z = this.b;
            AbstractC21455b.n1(new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.Components.E
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.e();
                }
            }, 16L);
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap bitmap;
            long jCurrentTimeMillis = System.currentTimeMillis();
            Utilities.stackBlurBitmap(this.b.d, this.a);
            c cVar = this.b;
            if (cVar.a && (bitmap = cVar.l) != null) {
                Utilities.stackBlurBitmap(bitmap, this.a);
            }
            SizeNotifierFrameLayout.this.K0 = (int) (r2.K0 + (System.currentTimeMillis() - jCurrentTimeMillis));
            SizeNotifierFrameLayout sizeNotifierFrameLayout = SizeNotifierFrameLayout.this;
            int i = sizeNotifierFrameLayout.J0 + 1;
            sizeNotifierFrameLayout.J0 = i;
            if (i > 1000) {
                StringBuilder sb = new StringBuilder();
                sb.append("chat blur generating average time");
                SizeNotifierFrameLayout sizeNotifierFrameLayout2 = SizeNotifierFrameLayout.this;
                sb.append(sizeNotifierFrameLayout2.K0 / sizeNotifierFrameLayout2.J0);
                AbstractC6403Nl2.a(sb.toString());
                SizeNotifierFrameLayout sizeNotifierFrameLayout3 = SizeNotifierFrameLayout.this;
                sizeNotifierFrameLayout3.J0 = 0;
                sizeNotifierFrameLayout3.K0 = 0;
            }
            AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.Components.C
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.f();
                }
            });
        }

        private b() {
        }
    }

    private static class c {
        public boolean a;
        int b;
        Canvas c;
        Bitmap d;
        float e;
        float f;
        float g;
        float h;
        float i;
        float j;
        Canvas k;
        Bitmap l;

        private c() {
        }

        public void a() {
            this.d.recycle();
            Bitmap bitmap = this.l;
            if (bitmap != null) {
                bitmap.recycle();
            }
        }
    }

    public interface d {
    }

    public SizeNotifierFrameLayout(Context context) {
        this(context, null);
    }

    private void E(float f, boolean z) {
        this.C0 = z ? this.J : this.A0;
        this.D0 = z ? this.z0 : this.B0;
        if (z) {
            f += getTranslationY();
        }
        if (this.C0.getShader() != null) {
            this.G.reset();
            this.H.reset();
            if (z) {
                float f2 = -f;
                this.G.setTranslate(0.0f, (f2 - this.z.b) - 34.0f);
                Matrix matrix = this.G;
                c cVar = this.z;
                matrix.preScale(cVar.e, cVar.f);
                if (this.A != null) {
                    this.H.setTranslate(0.0f, (f2 - r7.b) - 34.0f);
                    Matrix matrix2 = this.H;
                    c cVar2 = this.A;
                    matrix2.preScale(cVar2.e, cVar2.f);
                }
            } else {
                float f3 = -f;
                c cVar3 = this.z;
                this.G.setTranslate(0.0f, (((cVar3.i + f3) - cVar3.b) - 34.0f) - (cVar3.j - (getBottomOffset() + getListTranslationY())));
                Matrix matrix3 = this.G;
                c cVar4 = this.z;
                matrix3.preScale(cVar4.g, cVar4.h);
                c cVar5 = this.A;
                if (cVar5 != null) {
                    this.H.setTranslate(0.0f, (((f3 + cVar5.i) - cVar5.b) - 34.0f) - (cVar5.j - (getBottomOffset() + getListTranslationY())));
                    Matrix matrix4 = this.H;
                    c cVar6 = this.A;
                    matrix4.preScale(cVar6.g, cVar6.h);
                }
            }
            this.C0.getShader().setLocalMatrix(this.G);
            if (this.D0.getShader() != null) {
                this.D0.getShader().setLocalMatrix(this.G);
            }
        }
    }

    private void u() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(Canvas canvas) {
        if (this.t == null || !ir.nasim.tgwidgets.editor.ui.ActionBar.m.E()) {
            return;
        }
        ir.nasim.tgwidgets.editor.messenger.v.e(32);
    }

    public void A() {
        for (int i = 0; i < this.D.size(); i++) {
            ((View) this.D.get(i)).invalidate();
        }
    }

    protected boolean B() {
        return true;
    }

    public void C() {
    }

    public void D() {
        c cVar;
        if (!this.x || this.y || !this.I0 || Color.alpha(ir.nasim.tgwidgets.editor.ui.ActionBar.m.i0(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Xd)) == 255) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int currentActionBarHeight = ActionBar.getCurrentActionBarHeight() + AbstractC21455b.d + AbstractC21455b.F(100.0f);
        if (measuredWidth == 0 || currentActionBarHeight == 0) {
            return;
        }
        this.I0 = false;
        this.y = true;
        float f = currentActionBarHeight;
        int i = ((int) (f / 12.0f)) + 34;
        float f2 = measuredWidth;
        int i2 = (int) (f2 / 12.0f);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.B.size() > 0) {
            ArrayList arrayList = this.B;
            cVar = (c) arrayList.remove(arrayList.size() - 1);
        } else {
            cVar = null;
        }
        if (cVar == null) {
            cVar = new c();
            Bitmap.Config config = Bitmap.Config.ARGB_8888;
            cVar.d = Bitmap.createBitmap(i2, i, config);
            cVar.c = new Canvas(cVar.d);
            if (this.w) {
                cVar.l = Bitmap.createBitmap(i2, i, config);
                cVar.k = new Canvas(cVar.l);
            }
        } else {
            cVar.d.eraseColor(0);
            Bitmap bitmap = cVar.l;
            if (bitmap != null) {
                bitmap.eraseColor(0);
            }
        }
        float width = cVar.d.getWidth() / f2;
        float height = (cVar.d.getHeight() - 34) / f;
        cVar.c.save();
        cVar.b = getScrollOffset() % 24;
        float f3 = height * 10.0f;
        cVar.c.clipRect(1.0f, f3, cVar.d.getWidth(), cVar.d.getHeight() - 1);
        cVar.c.scale(width, height);
        cVar.c.translate(0.0f, f3 + cVar.b);
        cVar.e = 1.0f / width;
        cVar.f = 1.0f / height;
        z(cVar.c, true);
        cVar.c.restore();
        if (this.w) {
            float width2 = cVar.l.getWidth() / f2;
            float height2 = (cVar.l.getHeight() - 34) / f;
            cVar.a = true;
            cVar.i = getBottomOffset() - f;
            cVar.j = getBottomOffset();
            cVar.k.save();
            float f4 = 10.0f * height2;
            cVar.k.clipRect(1.0f, f4, cVar.l.getWidth(), cVar.l.getHeight() - 1);
            cVar.k.scale(width2, height2);
            cVar.k.translate(0.0f, (f4 - cVar.i) + cVar.b);
            cVar.g = 1.0f / width2;
            cVar.h = 1.0f / height2;
            z(cVar.k, false);
            cVar.k.restore();
        } else {
            cVar.a = false;
        }
        this.M0 = (int) (this.M0 + (System.currentTimeMillis() - jCurrentTimeMillis));
        int i3 = this.L0 + 1;
        this.L0 = i3;
        if (i3 >= 20) {
            this.L0 = 0;
            this.M0 = 0;
        }
        if (P0 == null) {
            P0 = new HU1("BlurQueue");
        }
        b bVar = this.O0;
        bVar.b = cVar;
        P0.i(bVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.x) {
            D();
        }
        super.dispatchDraw(canvas);
    }

    public Drawable getBackgroundImage() {
        return this.b;
    }

    public int getBackgroundSizeY() {
        return getMeasuredHeight();
    }

    public int getBackgroundTranslationY() {
        return 0;
    }

    protected float getBottomOffset() {
        return getMeasuredHeight();
    }

    public int getBottomPadding() {
        return 0;
    }

    protected float getBottomTranslation() {
        return 0.0f;
    }

    public int getHeightWithKeyboard() {
        return this.f + getMeasuredHeight();
    }

    public int getKeyboardHeight() {
        return this.f;
    }

    protected float getListTranslationY() {
        return 0.0f;
    }

    protected Drawable getNewDrawable() {
        return ir.nasim.tgwidgets.editor.ui.ActionBar.m.h0();
    }

    protected boolean getNewDrawableMotion() {
        return ir.nasim.tgwidgets.editor.ui.ActionBar.m.I0();
    }

    protected m.h getResourceProvider() {
        return null;
    }

    protected int getScrollOffset() {
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.u = true;
        if (!this.v || this.x) {
            return;
        }
        this.x = true;
        this.I0 = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.u = false;
        this.J.setShader(null);
        this.z0.setShader(null);
        this.A0.setShader(null);
        this.B0.setShader(null);
        ValueAnimator valueAnimator = this.H0;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        c cVar = this.z;
        if (cVar != null) {
            cVar.a();
            this.z = null;
        }
        for (int i = 0; i < this.B.size(); i++) {
            if (this.B.get(i) != null) {
                ((c) this.B.get(i)).a();
            }
        }
        this.B.clear();
        this.x = false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        C();
    }

    public void setBackgroundImage(Drawable drawable, boolean z) {
        if (this.b == drawable) {
            return;
        }
        if (this.t == null) {
            a aVar = new a(getContext());
            this.t = aVar;
            addView(aVar, 0, AbstractC13840gu3.b(-1, -1.0f));
            u();
        }
        v();
        this.t.invalidate();
        u();
    }

    public void setBackgroundTranslation(int i) {
        if (i != this.l) {
            this.l = i;
            View view = this.t;
            if (view != null) {
                view.invalidate();
            }
        }
    }

    public void setBottomClip(int i) {
        if (i != this.g) {
            this.g = i;
            View view = this.t;
            if (view != null) {
                view.invalidate();
            }
        }
    }

    public void setDelegate(d dVar) {
    }

    public void setEmojiKeyboardHeight(int i) {
        if (this.p != i) {
            this.p = i;
            View view = this.t;
            if (view != null) {
                view.invalidate();
            }
        }
    }

    public void setEmojiOffset(boolean z, float f) {
        if (this.q == f && this.r == z) {
            return;
        }
        this.q = f;
        this.r = z;
        View view = this.t;
        if (view != null) {
            view.invalidate();
        }
    }

    public void setOccupyStatusBar(boolean z) {
        this.h = z;
    }

    public void setSkipBackgroundDrawing(boolean z) {
        if (this.s != z) {
            this.s = z;
            View view = this.t;
            if (view != null) {
                view.invalidate();
            }
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return drawable == getBackgroundImage() || super.verifyDrawable(drawable);
    }

    protected AbstractC18973pa x() {
        return null;
    }

    public void y(Canvas canvas, float f, Rect rect, Paint paint, boolean z) {
        int iAlpha = Color.alpha(ir.nasim.tgwidgets.editor.ui.ActionBar.m.i0(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Xd));
        if (this.z == null) {
            canvas.drawRect(rect, paint);
            return;
        }
        E(f, z);
        paint.setAlpha(255);
        if (this.E0 == 1.0f || this.D0.getShader() == null) {
            canvas.drawRect(rect, paint);
            canvas.drawRect(rect, this.C0);
        } else {
            canvas.drawRect(rect, paint);
            canvas.drawRect(rect, this.D0);
            canvas.saveLayerAlpha(rect.left, rect.top, rect.right, rect.bottom, (int) (this.E0 * 255.0f), 31);
            canvas.drawRect(rect, paint);
            canvas.drawRect(rect, this.C0);
            canvas.restore();
        }
        paint.setAlpha(iAlpha);
        canvas.drawRect(rect, paint);
    }

    protected void z(Canvas canvas, boolean z) {
    }

    public SizeNotifierFrameLayout(Context context, ir.nasim.tgwidgets.editor.ui.ActionBar.l lVar) {
        super(context);
        this.a = new Rect();
        this.h = true;
        this.k = 1.0f;
        this.m = true;
        this.B = new ArrayList(10);
        this.D = new ArrayList();
        this.G = new Matrix();
        this.H = new Matrix();
        this.J = new Paint();
        this.z0 = new Paint();
        this.A0 = new Paint();
        this.B0 = new Paint();
        this.F0 = 12.0f;
        this.G0 = 34;
        this.N0 = 1.0f;
        this.O0 = new b();
        setWillNotDraw(false);
        this.n = lVar;
        this.o = x();
    }
}
