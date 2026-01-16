package ir.nasim.tgwidgets.editor.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.AbstractC24721z57;
import ir.nasim.AbstractC6403Nl2;
import ir.nasim.DK5;
import ir.nasim.InterpolatorC12631ew1;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.E;
import ir.nasim.tgwidgets.editor.messenger.ImageReceiver;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes7.dex */
public class InstantCameraView extends FrameLayout implements E.d {
    private static final int[] J = {285904780, -1394191079};
    private int A;
    private boolean B;
    private boolean D;
    public boolean G;
    ValueAnimator H;
    private int a;
    private InstantViewCameraContainer b;
    private Paint c;
    private RectF d;
    private ImageView e;
    private ImageView f;
    private float g;
    private AbstractC24721z57 h;
    private long i;
    private int[] j;
    private File k;
    private long l;
    private boolean m;
    private long n;
    private TextureView o;
    private BackupImageView p;
    private ir.nasim.tgwidgets.editor.messenger.camera.c q;
    private float r;
    private float s;
    private boolean t;
    float u;
    float v;
    boolean w;
    boolean x;
    private int y;
    private int z;

    public class InstantViewCameraContainer extends FrameLayout {
        ImageReceiver a;
        float b;
        final /* synthetic */ InstantCameraView c;

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            super.dispatchDraw(canvas);
            float f = this.b;
            if (f != 1.0f) {
                float f2 = f + 0.064f;
                this.b = f2;
                if (f2 > 1.0f) {
                    this.b = 1.0f;
                }
                invalidate();
            }
            if (this.a != null) {
                canvas.save();
                if (this.a.E() != this.c.A) {
                    float fE = this.c.A / this.a.E();
                    canvas.scale(fE, fE);
                }
                canvas.translate(-this.a.F(), -this.a.G());
                float alpha = this.a.getAlpha();
                this.a.setAlpha(this.b);
                this.a.e(canvas);
                this.a.setAlpha(alpha);
                canvas.restore();
            }
        }

        public void setImageReceiver(ImageReceiver imageReceiver) {
            if (this.a == null) {
                this.b = 0.0f;
            }
            this.a = imageReceiver;
            invalidate();
        }
    }

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            InstantCameraView instantCameraView = InstantCameraView.this;
            if (instantCameraView.H != null) {
                instantCameraView.H = null;
            }
        }
    }

    public static class b {
        public ByteBuffer[] a = new ByteBuffer[10];
        public long[] b = new long[10];
        public int[] c = new int[10];
        public int d;
        public int e;
        public boolean f;

        public b() {
            for (int i = 0; i < 10; i++) {
                this.a[i] = ByteBuffer.allocateDirect(2048);
                this.a[i].order(ByteOrder.nativeOrder());
            }
        }
    }

    private boolean c(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() < 2) {
            return false;
        }
        if (this.y == motionEvent.getPointerId(0) && this.z == motionEvent.getPointerId(1)) {
            return true;
        }
        return this.y == motionEvent.getPointerId(1) && this.z == motionEvent.getPointerId(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(ValueAnimator valueAnimator) {
        ir.nasim.tgwidgets.editor.messenger.camera.c cVar = this.q;
        if (cVar != null) {
            cVar.F(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    private void f() {
        this.p.setTranslationY(this.s + this.r);
        this.b.setTranslationY(this.s + this.r);
    }

    public void d() {
        if (this.H != null) {
            return;
        }
        float fMin = Math.min(1.0f, Math.max(0.0f, this.v - 1.0f));
        if (fMin > 0.0f) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fMin, 0.0f);
            this.H = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.ga3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.a.e(valueAnimator);
                }
            });
            this.H.addListener(new a());
            this.H.setDuration(350L);
            this.H.setInterpolator(InterpolatorC12631ew1.f);
            this.H.start();
        }
    }

    public InstantViewCameraContainer getCameraContainer() {
        return this.b;
    }

    public DK5 getCameraRect() {
        this.b.getLocationOnScreen(this.j);
        int[] iArr = this.j;
        return new DK5(iArr[0], iArr[1], this.b.getWidth(), this.b.getHeight());
    }

    public View getMuteImageView() {
        return this.f;
    }

    public Paint getPaint() {
        return this.c;
    }

    public View getSwitchButtonView() {
        return this.e;
    }

    public TextureView getTextureView() {
        return this.o;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ir.nasim.tgwidgets.editor.messenger.E.k(this.a).e(this, ir.nasim.tgwidgets.editor.messenger.E.I1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ir.nasim.tgwidgets.editor.messenger.E.k(this.a).u(this, ir.nasim.tgwidgets.editor.messenger.E.I1);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.G) {
            throw null;
        }
        float x = this.b.getX();
        float y = this.b.getY();
        this.d.set(x - AbstractC21455b.F(8.0f), y - AbstractC21455b.F(8.0f), this.b.getMeasuredWidth() + x + AbstractC21455b.F(8.0f), this.b.getMeasuredHeight() + y + AbstractC21455b.F(8.0f));
        if (this.m) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.l;
            this.n = jCurrentTimeMillis;
            this.g = Math.min(1.0f, jCurrentTimeMillis / 60000.0f);
            invalidate();
        }
        if (this.g != 0.0f) {
            canvas.save();
            if (!this.t) {
                canvas.scale(this.b.getScaleX(), this.b.getScaleY(), this.d.centerX(), this.d.centerY());
            }
            canvas.drawArc(this.d, -90.0f, this.g * 360.0f, false, this.c);
            canvas.restore();
        }
        if (ir.nasim.tgwidgets.editor.ui.ActionBar.m.i2 != null) {
            int iF = ((int) x) - AbstractC21455b.F(3.0f);
            int iF2 = ((int) y) - AbstractC21455b.F(2.0f);
            canvas.save();
            if (this.B) {
                canvas.scale(this.b.getScaleX(), this.b.getScaleY(), x, y);
            } else {
                float scaleX = this.b.getScaleX();
                float scaleY = this.b.getScaleY();
                int i = this.A;
                canvas.scale(scaleX, scaleY, x + (i / 2.0f), y + (i / 2.0f));
            }
            ir.nasim.tgwidgets.editor.ui.ActionBar.m.i2.setAlpha((int) (this.b.getAlpha() * 255.0f));
            ir.nasim.tgwidgets.editor.ui.ActionBar.m.i2.setBounds(iF, iF2, this.A + iF + AbstractC21455b.F(6.0f), this.A + iF2 + AbstractC21455b.F(6.0f));
            ir.nasim.tgwidgets.editor.ui.ActionBar.m.i2.draw(canvas);
            canvas.restore();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.D) {
            int i3 = ((float) View.MeasureSpec.getSize(i2)) > ((float) View.MeasureSpec.getSize(i)) * 1.3f ? AbstractC21455b.l : AbstractC21455b.k;
            if (i3 != this.A) {
                this.A = i3;
                ViewGroup.LayoutParams layoutParams = this.p.getLayoutParams();
                ViewGroup.LayoutParams layoutParams2 = this.p.getLayoutParams();
                int i4 = this.A;
                layoutParams2.height = i4;
                layoutParams.width = i4;
                ViewGroup.LayoutParams layoutParams3 = this.b.getLayoutParams();
                ViewGroup.LayoutParams layoutParams4 = this.b.getLayoutParams();
                int i5 = this.A;
                layoutParams4.height = i5;
                layoutParams3.width = i5;
                ((FrameLayout.LayoutParams) this.f.getLayoutParams()).topMargin = (this.A / 2) - AbstractC21455b.F(24.0f);
                this.p.setRoundRadius(this.A / 2);
                this.b.invalidateOutline();
            }
            this.D = false;
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (getVisibility() != 0) {
            this.s = getMeasuredHeight() / 2;
            f();
        }
        throw null;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        motionEvent.getAction();
        if (motionEvent.getActionMasked() == 0 || motionEvent.getActionMasked() == 5) {
            if (this.x && !this.w && motionEvent.getPointerCount() == 2 && this.H == null && this.m) {
                this.u = (float) Math.hypot(motionEvent.getX(1) - motionEvent.getX(0), motionEvent.getY(1) - motionEvent.getY(0));
                this.v = 1.0f;
                this.y = motionEvent.getPointerId(0);
                this.z = motionEvent.getPointerId(1);
                this.w = true;
            }
            if (motionEvent.getActionMasked() == 0) {
                RectF rectF = AbstractC21455b.x;
                rectF.set(this.b.getX(), this.b.getY(), this.b.getX() + this.b.getMeasuredWidth(), this.b.getY() + this.b.getMeasuredHeight());
                this.x = rectF.contains(motionEvent.getX(), motionEvent.getY());
            }
            return true;
        }
        if (motionEvent.getActionMasked() == 2 && this.w) {
            int i = -1;
            int i2 = -1;
            for (int i3 = 0; i3 < motionEvent.getPointerCount(); i3++) {
                if (this.y == motionEvent.getPointerId(i3)) {
                    i = i3;
                }
                if (this.z == motionEvent.getPointerId(i3)) {
                    i2 = i3;
                }
            }
            if (i == -1 || i2 == -1) {
                this.w = false;
                d();
                return false;
            }
            float fHypot = ((float) Math.hypot(motionEvent.getX(i2) - motionEvent.getX(i), motionEvent.getY(i2) - motionEvent.getY(i))) / this.u;
            this.v = fHypot;
            this.q.F(Math.min(1.0f, Math.max(0.0f, fHypot - 1.0f)));
        } else if ((motionEvent.getActionMasked() == 1 || ((motionEvent.getActionMasked() == 6 && c(motionEvent)) || motionEvent.getActionMasked() == 3)) && this.w) {
            this.w = false;
            d();
        }
        return true;
    }

    public void setIsMessageTransition(boolean z) {
        this.B = z;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        this.e.setAlpha(0.0f);
        this.b.setAlpha(0.0f);
        this.p.setAlpha(0.0f);
        this.f.setAlpha(0.0f);
        this.f.setScaleX(1.0f);
        this.f.setScaleY(1.0f);
        this.b.setScaleX(0.1f);
        this.b.setScaleY(0.1f);
        this.p.setScaleX(0.1f);
        this.p.setScaleY(0.1f);
        if (this.b.getMeasuredWidth() != 0) {
            this.b.setPivotX(r0.getMeasuredWidth() / 2);
            this.b.setPivotY(r0.getMeasuredHeight() / 2);
            this.p.setPivotX(r0.getMeasuredWidth() / 2);
            this.p.setPivotY(r0.getMeasuredHeight() / 2);
        }
        try {
            if (i == 0) {
                ((Activity) getContext()).getWindow().addFlags(128);
            } else {
                ((Activity) getContext()).getWindow().clearFlags(128);
            }
        } catch (Exception e) {
            AbstractC6403Nl2.d(e);
        }
    }

    @Override // ir.nasim.tgwidgets.editor.messenger.E.d
    public void t(int i, int i2, Object... objArr) {
        if (i == ir.nasim.tgwidgets.editor.messenger.E.I1) {
            String str = (String) objArr[0];
            File file = this.k;
            if (file == null || !file.getAbsolutePath().equals(str)) {
                return;
            }
            this.h = (AbstractC24721z57) objArr[1];
            AbstractC18350oW3.a(objArr[2]);
            this.i = ((Long) objArr[5]).longValue();
        }
    }
}
