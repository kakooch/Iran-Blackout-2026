package ir.nasim.tgwidgets.editor.ui.ActionBar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Insets;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Property;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC13840gu3;
import ir.nasim.AbstractC16417lE5;
import ir.nasim.AbstractC23598xB5;
import ir.nasim.AbstractC6403Nl2;
import ir.nasim.C22477vI7;
import ir.nasim.C4347Et;
import ir.nasim.C5978Lq4;
import ir.nasim.FH3;
import ir.nasim.InterpolatorC12631ew1;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.E;
import ir.nasim.tgwidgets.editor.ui.ActionBar.BottomSheet;
import ir.nasim.tgwidgets.editor.ui.ActionBar.m;
import ir.nasim.tgwidgets.editor.ui.Components.AbstractC21469h;
import ir.nasim.tgwidgets.editor.ui.Components.Bulletin;
import java.util.ArrayList;
import org.xbill.DNS.SimpleResolver;

/* loaded from: classes7.dex */
public class BottomSheet extends Dialog {
    private int A;
    private boolean A0;
    protected boolean B;
    private boolean B0;
    boolean C0;
    protected boolean D;
    private int D0;
    protected boolean E0;
    private int F0;
    protected ColorDrawable G;
    private boolean G0;
    protected boolean H;
    protected Interpolator H0;
    private TextView I0;
    protected boolean J;
    private boolean J0;
    protected boolean K0;
    protected int L0;
    protected boolean M0;
    protected Drawable N0;
    protected int O0;
    protected int P0;
    private boolean Q0;
    private boolean R0;
    private ArrayList S0;
    private Runnable T0;
    protected AnimatorSet U0;
    protected int V0;
    protected ValueAnimator W0;
    protected float X0;
    protected int Y;
    protected View Y0;
    protected int Z;
    private boolean Z0;
    protected int a;
    private float a1;
    protected ViewGroup b;
    protected int b1;
    protected ContainerView c;
    protected int c1;
    protected boolean d;
    private DialogInterface.OnDismissListener d1;
    protected int e;
    protected m.h e1;
    private WindowInsets f;
    protected boolean f1;
    public boolean g;
    public boolean g1;
    public boolean h;
    private C4347Et h1;
    public boolean i;
    protected int i1;
    public boolean j;
    private ValueAnimator j1;
    protected boolean k;
    public boolean k1;
    protected boolean l;
    private boolean l1;
    protected Runnable m;
    private float m1;
    private int n;
    public boolean n1;
    private boolean o;
    protected int o1;
    private boolean p;
    private boolean p1;
    protected boolean q;
    private int q1;
    private DialogInterface.OnClickListener r;
    private CharSequence[] s;
    private int[] t;
    private View u;
    private CharSequence v;
    private boolean w;
    private boolean x;
    private int y;
    private int z;
    private boolean z0;

    public static class BottomSheetCell extends FrameLayout {
        private final m.h a;
        private TextView b;
        private ImageView c;
        int d;
        public boolean e;

        public BottomSheetCell(Context context, int i, m.h hVar) {
            super(context);
            this.e = false;
            this.a = hVar;
            this.d = i;
            setBackgroundDrawable(m.w0(false, hVar));
            ImageView imageView = new ImageView(context);
            this.c = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            this.c.setColorFilter(new PorterDuffColorFilter(c(m.v4), PorterDuff.Mode.MULTIPLY));
            addView(this.c, AbstractC13840gu3.d(56, 48, (FH3.D ? 5 : 3) | 16));
            TextView textView = new TextView(context);
            this.b = textView;
            textView.setLines(1);
            this.b.setSingleLine(true);
            this.b.setGravity(1);
            this.b.setEllipsize(TextUtils.TruncateAt.END);
            if (i == 0) {
                this.b.setTextColor(c(m.V3));
                this.b.setTextSize(1, 16.0f);
                addView(this.b, AbstractC13840gu3.d(-2, -2, (FH3.D ? 5 : 3) | 16));
                return;
            }
            if (i == 1) {
                this.b.setGravity(17);
                this.b.setTextColor(c(m.V3));
                this.b.setTextSize(1, 14.0f);
                this.b.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
                addView(this.b, AbstractC13840gu3.b(-1, -1.0f));
                return;
            }
            if (i == 2) {
                this.b.setGravity(17);
                this.b.setTextColor(c(m.Gf));
                this.b.setTextSize(1, 14.0f);
                this.b.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
                this.b.setBackground(m.e.e(c(m.Df), 6.0f));
                addView(this.b, AbstractC13840gu3.c(-1, -1.0f, 0, 16.0f, 16.0f, 16.0f, 16.0f));
            }
        }

        protected int c(int i) {
            return m.j0(i, this.a);
        }

        public ImageView getImageView() {
            return this.c;
        }

        public TextView getTextView() {
            return this.b;
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            if (this.e) {
                accessibilityNodeInfo.setSelected(true);
            }
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            int i3 = this.d;
            int i4 = i3 == 2 ? 80 : 48;
            if (i3 == 0) {
                i = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824);
            }
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(AbstractC21455b.F(i4), 1073741824));
        }

        public void setGravity(int i) {
            this.b.setGravity(i);
        }

        public void setIconColor(int i) {
            this.c.setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.MULTIPLY));
        }

        public void setTextAndIcon(CharSequence charSequence, int i) {
            setTextAndIcon(charSequence, i, null, false);
        }

        public void setTextColor(int i) {
            this.b.setTextColor(i);
        }

        public void setTextAndIcon(CharSequence charSequence, Drawable drawable) {
            setTextAndIcon(charSequence, 0, drawable, false);
        }

        public void setTextAndIcon(CharSequence charSequence, int i, Drawable drawable, boolean z) {
            this.b.setText(charSequence);
            if (i == 0 && drawable == null) {
                this.c.setVisibility(4);
                this.b.setPadding(AbstractC21455b.F(z ? 21.0f : 16.0f), 0, AbstractC21455b.F(z ? 21.0f : 16.0f), 0);
                return;
            }
            if (drawable != null) {
                this.c.setImageDrawable(drawable);
            } else {
                this.c.setImageResource(i);
            }
            this.c.setVisibility(0);
            if (z) {
                this.b.setPadding(AbstractC21455b.F(FH3.D ? 21.0f : 72.0f), 0, AbstractC21455b.F(FH3.D ? 72.0f : 21.0f), 0);
                this.c.setPadding(FH3.D ? 0 : AbstractC21455b.F(5.0f), 0, FH3.D ? AbstractC21455b.F(5.0f) : 5, 0);
            } else {
                this.b.setPadding(AbstractC21455b.F(FH3.D ? 16.0f : 72.0f), 0, AbstractC21455b.F(FH3.D ? 72.0f : 16.0f), 0);
                this.c.setPadding(0, 0, 0, 0);
            }
        }
    }

    public class ContainerView extends FrameLayout {
        private VelocityTracker a;
        private int b;
        private int c;
        private int d;
        private boolean e;
        private boolean f;
        private AnimatorSet g;
        private C5978Lq4 h;
        private Rect i;
        private Paint j;
        private boolean k;
        private float l;

        class a extends AnimatorListenerAdapter {
            a() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (ContainerView.this.g != null && ContainerView.this.g.equals(animator)) {
                    ContainerView.this.g = null;
                }
                E.j().s(E.e1, 512);
            }
        }

        class b extends AnimatorListenerAdapter {
            b() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                BottomSheet.this.b.setTranslationY(0.0f);
                ContainerView.this.invalidate();
            }
        }

        public ContainerView(Context context) {
            super(context);
            this.a = null;
            this.d = -1;
            this.e = false;
            this.f = false;
            this.g = null;
            this.i = new Rect();
            this.j = new Paint();
            this.l = 0.0f;
            this.h = new C5978Lq4(this);
            setWillNotDraw(false);
        }

        private void e() {
            AnimatorSet animatorSet = this.g;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.g = null;
            }
        }

        private void f(float f, float f2) {
            if ((BottomSheet.this.b.getTranslationY() >= AbstractC21455b.h0(0.8f, false) || (f2 >= 3500.0f && Math.abs(f2) >= Math.abs(f))) && (f2 >= 0.0f || Math.abs(f2) < 3500.0f)) {
                boolean z = BottomSheet.this.A0;
                BottomSheet.this.A0 = false;
                BottomSheet.this.G0 = true;
                BottomSheet.this.dismiss();
                BottomSheet.this.A0 = z;
                return;
            }
            this.g = new AnimatorSet();
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.Sj0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.a.h(valueAnimator);
                }
            });
            this.g.playTogether(ObjectAnimator.ofFloat(BottomSheet.this.b, "translationY", 0.0f), valueAnimatorOfFloat);
            this.g.setDuration((int) ((Math.max(0.0f, r2) / AbstractC21455b.h0(0.8f, false)) * 250.0f));
            this.g.setInterpolator(InterpolatorC12631ew1.f);
            this.g.addListener(new a());
            E.j().s(E.d1, 512);
            this.g.start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void h(ValueAnimator valueAnimator) {
            ContainerView containerView = BottomSheet.this.c;
            if (containerView != null) {
                containerView.invalidate();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void i(ValueAnimator valueAnimator) {
            BottomSheet.this.b.setTranslationY(((Float) valueAnimator.getAnimatedValue()).floatValue());
            invalidate();
        }

        /* JADX WARN: Removed duplicated region for block: B:32:0x00c4  */
        @Override // android.view.ViewGroup, android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected void dispatchDraw(android.graphics.Canvas r12) {
            /*
                Method dump skipped, instructions count: 467
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.ActionBar.BottomSheet.ContainerView.dispatchDraw(android.graphics.Canvas):void");
        }

        @Override // android.view.ViewGroup
        protected boolean drawChild(Canvas canvas, View view, long j) {
            return super.drawChild(canvas, view, j);
        }

        public void g(Canvas canvas, float f) {
            float fMax;
            int i = Build.VERSION.SDK_INT;
            if (i >= 26) {
                BottomSheet bottomSheet = BottomSheet.this;
                int i2 = bottomSheet.b1;
                if (i2 >= 0) {
                    this.j.setColor(bottomSheet.Z(i2));
                } else {
                    this.j.setColor(bottomSheet.c1);
                }
            } else {
                this.j.setColor(-16777216);
            }
            if (!BottomSheet.this.p1 || BottomSheet.this.b.getVisibility() == 0) {
                BottomSheet bottomSheet2 = BottomSheet.this;
                float f2 = 0.0f;
                if ((!bottomSheet2.g || bottomSheet2.y == 0) && BottomSheet.this.a1 == 0.0f) {
                    return;
                }
                BottomSheet bottomSheet3 = BottomSheet.this;
                int iU = bottomSheet3.g ? bottomSheet3.U() : 0;
                BottomSheet bottomSheet4 = BottomSheet.this;
                if (bottomSheet4.i || (i >= 29 && bottomSheet4.T() > 0)) {
                    BottomSheet bottomSheet5 = BottomSheet.this;
                    fMax = bottomSheet5.h ? Math.max(0.0f, Math.min(iU - bottomSheet5.a1, BottomSheet.this.b.getTranslationY())) : Math.max(0.0f, BottomSheet.this.U() - (bottomSheet5.b.getMeasuredHeight() - BottomSheet.this.b.getTranslationY()));
                } else {
                    fMax = 0.0f;
                }
                int alpha = this.j.getAlpha();
                if (BottomSheet.this.p1) {
                    f *= BottomSheet.this.b.getAlpha();
                }
                int x = BottomSheet.this.p1 ? (int) BottomSheet.this.b.getX() : BottomSheet.this.b.getLeft();
                if (f < 1.0f) {
                    this.j.setAlpha((int) (alpha * f));
                }
                canvas.drawRect(BottomSheet.this.P0 + x, ((getMeasuredHeight() - iU) + fMax) - BottomSheet.this.a1, BottomSheet.this.b.getRight() - BottomSheet.this.P0, getMeasuredHeight() + fMax, this.j);
                this.j.setAlpha(alpha);
                if (BottomSheet.this.q1 != 0) {
                    this.j.setColor(BottomSheet.this.q1);
                    int alpha2 = this.j.getAlpha();
                    if (f < 1.0f) {
                        this.j.setAlpha((int) (alpha2 * f));
                    } else {
                        f2 = fMax;
                    }
                    canvas.drawRect(x + BottomSheet.this.P0, ((getMeasuredHeight() - iU) + f2) - BottomSheet.this.a1, BottomSheet.this.b.getRight() - BottomSheet.this.P0, getMeasuredHeight() + f2, this.j);
                    this.j.setAlpha(alpha2);
                }
            }
        }

        @Override // android.view.ViewGroup
        public int getNestedScrollAxes() {
            return this.h.a();
        }

        @Override // android.view.View
        public boolean hasOverlappingRendering() {
            return false;
        }

        public boolean j(MotionEvent motionEvent, boolean z) {
            if (BottomSheet.this.o) {
                return false;
            }
            if (BottomSheet.this.h0(motionEvent)) {
                return true;
            }
            if (BottomSheet.this.O() && motionEvent != null && ((motionEvent.getAction() == 0 || motionEvent.getAction() == 2) && !this.f && !this.e && motionEvent.getPointerCount() == 1)) {
                this.b = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                this.c = y;
                if (y < BottomSheet.this.b.getTop() || this.b < BottomSheet.this.b.getLeft() || this.b > BottomSheet.this.b.getRight()) {
                    BottomSheet.this.o0();
                    return true;
                }
                BottomSheet.this.r0(this.l);
                this.d = motionEvent.getPointerId(0);
                this.e = true;
                e();
                VelocityTracker velocityTracker = this.a;
                if (velocityTracker != null) {
                    velocityTracker.clear();
                }
            } else if (motionEvent != null && motionEvent.getAction() == 2 && motionEvent.getPointerId(0) == this.d) {
                if (this.a == null) {
                    this.a = VelocityTracker.obtain();
                }
                float fAbs = Math.abs((int) (motionEvent.getX() - this.b));
                float y2 = ((int) motionEvent.getY()) - this.c;
                boolean zQ0 = BottomSheet.this.q0(this.l + y2);
                this.a.addMovement(motionEvent);
                if (!BottomSheet.this.Z0 && this.e && !this.f && y2 > 0.0f && y2 / 3.0f > Math.abs(fAbs) && Math.abs(y2) >= BottomSheet.this.F0) {
                    this.c = (int) motionEvent.getY();
                    this.e = false;
                    this.f = true;
                    requestDisallowInterceptTouchEvent(true);
                } else if (this.f) {
                    float f = this.l + y2;
                    this.l = f;
                    if (!zQ0) {
                        this.l = Math.max(f, 0.0f);
                    }
                    BottomSheet.this.b.setTranslationY(Math.max(this.l, 0.0f));
                    this.c = (int) motionEvent.getY();
                    BottomSheet.this.c.invalidate();
                }
            } else if (motionEvent == null || (motionEvent.getPointerId(0) == this.d && (motionEvent.getAction() == 3 || motionEvent.getAction() == 1 || motionEvent.getAction() == 6))) {
                if (this.a == null) {
                    this.a = VelocityTracker.obtain();
                }
                this.a.computeCurrentVelocity(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT);
                BottomSheet.this.s0(this.l);
                if (this.f || this.l > 0.0f) {
                    f(this.a.getXVelocity(), this.a.getYVelocity());
                } else {
                    this.e = false;
                }
                this.f = false;
                VelocityTracker velocityTracker2 = this.a;
                if (velocityTracker2 != null) {
                    velocityTracker2.recycle();
                    this.a = null;
                }
                this.d = -1;
            }
            return (!z && this.e) || this.f || !BottomSheet.this.N();
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0089  */
        @Override // android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected void onDraw(android.graphics.Canvas r11) {
            /*
                Method dump skipped, instructions count: 253
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.ActionBar.BottomSheet.ContainerView.onDraw(android.graphics.Canvas):void");
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return BottomSheet.this.N() ? j(motionEvent, true) : super.onInterceptTouchEvent(motionEvent);
        }

        /* JADX WARN: Removed duplicated region for block: B:62:0x0197  */
        /* JADX WARN: Removed duplicated region for block: B:67:0x01a6  */
        /* JADX WARN: Removed duplicated region for block: B:70:0x01b8  */
        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected void onLayout(boolean r16, int r17, int r18, int r19, int r20) {
            /*
                Method dump skipped, instructions count: 519
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.ActionBar.BottomSheet.ContainerView.onLayout(boolean, int, int, int, int):void");
        }

        /* JADX WARN: Removed duplicated region for block: B:39:0x0103  */
        @Override // android.widget.FrameLayout, android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected void onMeasure(int r12, int r13) {
            /*
                Method dump skipped, instructions count: 481
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.ActionBar.BottomSheet.ContainerView.onMeasure(int, int):void");
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public boolean onNestedFling(View view, float f, float f2, boolean z) {
            return false;
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public boolean onNestedPreFling(View view, float f, float f2) {
            return false;
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
            if (BottomSheet.this.o || !BottomSheet.this.M0) {
                return;
            }
            e();
            float translationY = BottomSheet.this.b.getTranslationY();
            if (translationY <= 0.0f || i2 <= 0) {
                return;
            }
            float f = translationY - i2;
            iArr[1] = i2;
            BottomSheet.this.b.setTranslationY(f >= 0.0f ? f : 0.0f);
            BottomSheet.this.c.invalidate();
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
            if (BottomSheet.this.o || !BottomSheet.this.M0) {
                return;
            }
            e();
            if (i4 != 0) {
                float translationY = BottomSheet.this.b.getTranslationY() - i4;
                if (translationY < 0.0f) {
                    translationY = 0.0f;
                }
                BottomSheet.this.b.setTranslationY(translationY);
                BottomSheet.this.c.invalidate();
            }
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public void onNestedScrollAccepted(View view, View view2, int i) {
            this.h.b(view, view2, i);
            if (BottomSheet.this.o || !BottomSheet.this.M0) {
                return;
            }
            e();
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public boolean onStartNestedScroll(View view, View view2, int i) {
            BottomSheet bottomSheet = BottomSheet.this;
            View view3 = bottomSheet.Y0;
            if ((view3 == null || view == view3) && !bottomSheet.o) {
                BottomSheet bottomSheet2 = BottomSheet.this;
                if (bottomSheet2.M0 && i == 2 && !bottomSheet2.N()) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public void onStopNestedScroll(View view) {
            this.h.d(view);
            if (BottomSheet.this.o) {
                return;
            }
            BottomSheet bottomSheet = BottomSheet.this;
            if (bottomSheet.M0) {
                bottomSheet.b.getTranslationY();
                f(0.0f, 0.0f);
            }
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return j(motionEvent, false);
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public void requestDisallowInterceptTouchEvent(boolean z) {
            if (this.e && !this.f) {
                onTouchEvent(null);
            }
            super.requestDisallowInterceptTouchEvent(z);
        }
    }

    class a extends ColorDrawable {
        a(int i) {
            super(i);
        }

        @Override // android.graphics.drawable.ColorDrawable, android.graphics.drawable.Drawable
        public void setAlpha(int i) {
            super.setAlpha(i);
            BottomSheet.this.c.invalidate();
        }
    }

    class b extends ContainerView {
        b(Context context) {
            super(context);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.ActionBar.BottomSheet.ContainerView, android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            super.dispatchDraw(canvas);
            BottomSheet.this.f0(canvas);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.ActionBar.BottomSheet.ContainerView, android.view.ViewGroup
        public boolean drawChild(Canvas canvas, View view, long j) {
            try {
                if (BottomSheet.this.p) {
                    if (super.drawChild(canvas, view, j)) {
                        return true;
                    }
                }
                return false;
            } catch (Exception e) {
                AbstractC6403Nl2.d(e);
                return true;
            }
        }

        @Override // android.view.View
        protected void onConfigurationChanged(Configuration configuration) {
            BottomSheet.this.f = null;
            BottomSheet.this.c.requestApplyInsets();
        }
    }

    class c extends FrameLayout {
        c(Context context) {
            super(context);
        }

        @Override // android.view.View
        public boolean hasOverlappingRendering() {
            return false;
        }

        @Override // android.view.View
        public void setTranslationY(float f) {
            super.setTranslationY(f);
            BottomSheet.this.i0(f);
        }
    }

    class d extends AppCompatTextView {
        d(Context context) {
            super(context);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (BottomSheet.this.x) {
                int measuredHeight = getMeasuredHeight();
                if (BottomSheet.this.u != null) {
                    ((ViewGroup.MarginLayoutParams) BottomSheet.this.u.getLayoutParams()).topMargin = measuredHeight;
                    return;
                }
                if (BottomSheet.this.b != null) {
                    for (int i3 = 1; i3 < BottomSheet.this.b.getChildCount(); i3++) {
                        View childAt = BottomSheet.this.b.getChildAt(i3);
                        if (childAt instanceof BottomSheetCell) {
                            ((ViewGroup.MarginLayoutParams) childAt.getLayoutParams()).topMargin = measuredHeight;
                            measuredHeight += AbstractC21455b.F(48.0f);
                        }
                    }
                }
            }
        }
    }

    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BottomSheet bottomSheet = BottomSheet.this;
            if (bottomSheet.m != this || bottomSheet.o) {
                return;
            }
            BottomSheet bottomSheet2 = BottomSheet.this;
            bottomSheet2.m = null;
            bottomSheet2.D0();
        }
    }

    class f extends AnimatorListenerAdapter {
        f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            AnimatorSet animatorSet = BottomSheet.this.U0;
            if (animatorSet == null || !animatorSet.equals(animator)) {
                return;
            }
            BottomSheet bottomSheet = BottomSheet.this;
            bottomSheet.U0 = null;
            bottomSheet.V0 = 0;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AnimatorSet animatorSet = BottomSheet.this.U0;
            if (animatorSet != null && animatorSet.equals(animator)) {
                BottomSheet bottomSheet = BottomSheet.this;
                bottomSheet.U0 = null;
                bottomSheet.V0 = 0;
                bottomSheet.p0();
                BottomSheet.this.getClass();
                BottomSheet bottomSheet2 = BottomSheet.this;
                if (bottomSheet2.q) {
                    bottomSheet2.c.setLayerType(0, null);
                }
                BottomSheet bottomSheet3 = BottomSheet.this;
                if (bottomSheet3.D) {
                    WindowManager.LayoutParams attributes = bottomSheet3.getWindow().getAttributes();
                    attributes.flags &= -1025;
                    BottomSheet.this.getWindow().setAttributes(attributes);
                }
            }
            if (BottomSheet.this.g1) {
                E.j().s(E.e1, 512);
            }
            BottomSheet.this.h1.b();
        }
    }

    class g extends AnimatorListenerAdapter {
        final /* synthetic */ int a;

        g(int i) {
            this.a = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            if (BottomSheet.this.d1 != null) {
                BottomSheet.this.d1.onDismiss(BottomSheet.this);
            }
            try {
                BottomSheet.this.Q();
            } catch (Exception e) {
                AbstractC6403Nl2.d(e);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            AnimatorSet animatorSet = BottomSheet.this.U0;
            if (animatorSet == null || !animatorSet.equals(animator)) {
                return;
            }
            BottomSheet bottomSheet = BottomSheet.this;
            bottomSheet.U0 = null;
            bottomSheet.V0 = 0;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AnimatorSet animatorSet = BottomSheet.this.U0;
            if (animatorSet != null && animatorSet.equals(animator)) {
                BottomSheet bottomSheet = BottomSheet.this;
                bottomSheet.U0 = null;
                bottomSheet.V0 = 0;
                if (bottomSheet.r != null) {
                    BottomSheet.this.r.onClick(BottomSheet.this, this.a);
                }
                AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.ActionBar.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.b();
                    }
                });
            }
            E.j().s(E.e1, 512);
        }
    }

    class h extends AnimatorListenerAdapter {
        h() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            try {
                BottomSheet.this.Q();
            } catch (Exception e) {
                AbstractC6403Nl2.d(e);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            AnimatorSet animatorSet = BottomSheet.this.U0;
            if (animatorSet == null || !animatorSet.equals(animator)) {
                return;
            }
            BottomSheet bottomSheet = BottomSheet.this;
            bottomSheet.U0 = null;
            bottomSheet.V0 = 0;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AnimatorSet animatorSet = BottomSheet.this.U0;
            if (animatorSet != null && animatorSet.equals(animator)) {
                BottomSheet bottomSheet = BottomSheet.this;
                bottomSheet.U0 = null;
                bottomSheet.V0 = 0;
                AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.ActionBar.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.b();
                    }
                });
            }
            E.j().s(E.e1, 512);
        }
    }

    public static class i {
        private BottomSheet a;

        public i(Context context, boolean z, m.h hVar, int i) {
            BottomSheet bottomSheet = new BottomSheet(context, z, hVar);
            this.a = bottomSheet;
            bottomSheet.t0(i);
            this.a.S(i);
        }

        public BottomSheet a() {
            return this.a;
        }

        public i b(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
            this.a.s = charSequenceArr;
            this.a.r = onClickListener;
            return this;
        }

        public i c(DialogInterface.OnDismissListener onDismissListener) {
            this.a.x0(onDismissListener);
            return this;
        }

        public i d(CharSequence charSequence) {
            return e(charSequence, false);
        }

        public i e(CharSequence charSequence, boolean z) {
            this.a.v = charSequence;
            this.a.w = z;
            return this;
        }
    }

    public BottomSheet(Context context, boolean z, m.h hVar) {
        super(context, AbstractC16417lE5.TransparentDialog);
        this.a = C22477vI7.f;
        this.p = true;
        this.q = true;
        this.G = new a(-16777216);
        this.H = true;
        int i2 = m.T3;
        this.Y = i2;
        this.z0 = true;
        this.A0 = true;
        this.D0 = AbstractC21455b.d;
        this.H0 = InterpolatorC12631ew1.h;
        this.K0 = true;
        this.L0 = 51;
        this.M0 = true;
        this.Q0 = true;
        this.R0 = true;
        this.S0 = new ArrayList();
        this.T0 = new Runnable() { // from class: ir.nasim.Oj0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.dismiss();
            }
        };
        this.X0 = 0.0f;
        this.b1 = m.J5;
        this.g1 = true;
        this.h1 = new C4347Et();
        this.n1 = true;
        this.o1 = 51;
        this.e1 = hVar;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 30) {
            getWindow().addFlags(-2147483392);
        } else {
            getWindow().addFlags(-2147417856);
        }
        this.F0 = ViewConfiguration.get(context).getScaledTouchSlop();
        Rect rect = new Rect();
        Drawable drawableMutate = context.getResources().getDrawable(AbstractC23598xB5.sheet_shadow_round).mutate();
        this.N0 = drawableMutate;
        drawableMutate.setColorFilter(new PorterDuffColorFilter(Z(i2), PorterDuff.Mode.MULTIPLY));
        this.N0.getPadding(rect);
        this.P0 = rect.left;
        this.O0 = rect.top;
        b bVar = new b(getContext());
        this.c = bVar;
        bVar.setBackgroundDrawable(this.G);
        this.J0 = z;
        this.c.setFitsSystemWindows(true);
        this.c.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: ir.nasim.Pj0
            @Override // android.view.View.OnApplyWindowInsetsListener
            public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                return this.a.b0(view, windowInsets);
            }
        });
        if (i3 >= 30) {
            this.c.setSystemUiVisibility(1792);
        } else {
            this.c.setSystemUiVisibility(SimpleResolver.DEFAULT_EDNS_PAYLOADSIZE);
        }
        this.G.setAlpha(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0() {
        if (this.o) {
            return;
        }
        this.b.setVisibility(0);
        if (m0()) {
            return;
        }
        if (this.q) {
            this.c.setLayerType(2, null);
        }
        if (this.p1) {
            this.b.setTranslationX(AbstractC21455b.F(48.0f));
            this.b.setAlpha(0.0f);
            this.b.setTranslationY(0.0f);
        } else {
            this.b.setTranslationY(W() + this.e + AbstractC21455b.F(10.0f) + (this.i ? U() : 0));
        }
        this.V0 = 1;
        ValueAnimator valueAnimator = this.W0;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.X0, 1.0f);
        this.W0 = valueAnimatorOfFloat;
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.Qj0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                this.a.e0(valueAnimator2);
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        this.U0 = animatorSet;
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.b, (Property<ViewGroup, Float>) View.TRANSLATION_X, 0.0f), ObjectAnimator.ofFloat(this.b, (Property<ViewGroup, Float>) View.ALPHA, 1.0f), ObjectAnimator.ofFloat(this.b, (Property<ViewGroup, Float>) View.TRANSLATION_Y, 0.0f), ObjectAnimator.ofInt(this.G, (Property<ColorDrawable, Integer>) AbstractC21469h.b, this.K0 ? this.L0 : 0), this.W0);
        if (this.p1) {
            this.U0.setDuration(250L);
            this.U0.setInterpolator(InterpolatorC12631ew1.f);
        } else {
            this.U0.setDuration(400L);
            this.U0.setInterpolator(this.H0);
        }
        this.U0.setStartDelay(this.k ? 0L : 20L);
        this.U0.setInterpolator(this.H0);
        this.h1.a();
        this.U0.addListener(new f());
        if (this.g1) {
            E.j().s(E.d1, 512);
        }
        this.U0.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int T() {
        WindowInsets windowInsets;
        if (!this.E0 || (windowInsets = this.f) == null) {
            return 0;
        }
        Insets systemGestureInsets = windowInsets.getSystemGestureInsets();
        if (this.d || !this.g || systemGestureInsets == null) {
            return 0;
        }
        if (systemGestureInsets.left == 0 && systemGestureInsets.right == 0) {
            return 0;
        }
        return systemGestureInsets.bottom;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(ValueAnimator valueAnimator) {
        this.X0 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        ContainerView containerView = this.c;
        if (containerView != null) {
            containerView.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ WindowInsets b0(View view, WindowInsets windowInsets) {
        int systemWindowInsetTop = windowInsets.getSystemWindowInsetTop();
        if ((systemWindowInsetTop != 0 || AbstractC21455b.s) && this.D0 != systemWindowInsetTop) {
            this.D0 = systemWindowInsetTop;
        }
        this.f = windowInsets;
        view.requestLayout();
        return Build.VERSION.SDK_INT >= 30 ? WindowInsets.CONSUMED : windowInsets.consumeSystemWindowInsets();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean c0(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(View view) {
        R(((Integer) view.getTag()).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(ValueAnimator valueAnimator) {
        this.X0 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        ContainerView containerView = this.c;
        if (containerView != null) {
            containerView.invalidate();
        }
    }

    private void z0(boolean z) {
        if (this.C0 == z) {
            return;
        }
        this.C0 = z;
        if (this.i1 > 0) {
            if (z) {
                E.j().s(E.d1, Integer.valueOf(this.i1));
            } else {
                E.j().s(E.e1, Integer.valueOf(this.i1));
            }
        }
    }

    public void A0(CharSequence charSequence, boolean z) {
        this.v = charSequence;
        this.w = z;
    }

    public void B0(int i2) {
        TextView textView = this.I0;
        if (textView == null) {
            return;
        }
        textView.setTextColor(i2);
    }

    protected boolean C0() {
        return false;
    }

    protected boolean N() {
        return this.z0;
    }

    protected boolean O() {
        return true;
    }

    protected void P() {
        AnimatorSet animatorSet = this.U0;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.U0 = null;
        }
        this.V0 = 0;
    }

    public void Q() {
        try {
            super.dismiss();
        } catch (Exception e2) {
            AbstractC6403Nl2.e(e2, false);
        }
    }

    public void R(int i2) {
        if (this.o) {
            return;
        }
        this.o = true;
        P();
        this.V0 = 2;
        AnimatorSet animatorSet = new AnimatorSet();
        this.U0 = animatorSet;
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.b, (Property<ViewGroup, Float>) View.TRANSLATION_Y, W() + this.e + AbstractC21455b.F(10.0f) + (this.i ? U() : 0)), ObjectAnimator.ofInt(this.G, (Property<ColorDrawable, Integer>) AbstractC21469h.b, 0));
        this.U0.setDuration(180L);
        this.U0.setInterpolator(InterpolatorC12631ew1.g);
        this.U0.addListener(new g(i2));
        E.j().s(E.d1, 512);
        this.U0.start();
    }

    public void S(int i2) {
        this.g = true;
        this.h = true;
        this.i = true;
        this.b1 = -1;
        this.c1 = i2;
        y0(i2);
    }

    public int U() {
        return (int) (this.y * (1.0f - this.m1));
    }

    protected int V(boolean z, int i2, int i3) {
        return z ? i2 : (int) Math.max(i2 * 0.8f, Math.min(AbstractC21455b.F(480.0f), i2));
    }

    public int W() {
        ViewGroup viewGroup = this.b;
        if (viewGroup == null) {
            return 0;
        }
        return viewGroup.getMeasuredHeight();
    }

    public int X() {
        if (this.f != null) {
            return (int) (r0.getSystemWindowInsetLeft() * (1.0f - this.m1));
        }
        return 0;
    }

    public int Y() {
        if (this.f != null) {
            return (int) (r0.getSystemWindowInsetRight() * (1.0f - this.m1));
        }
        return 0;
    }

    protected int Z(int i2) {
        return m.j0(i2, this.e1);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        long j;
        if (this.o) {
            return;
        }
        this.o = true;
        DialogInterface.OnDismissListener onDismissListener = this.d1;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(this);
        }
        P();
        n0();
        if (this.A0 && j0()) {
            j = 0;
        } else {
            this.V0 = 2;
            ValueAnimator valueAnimator = this.W0;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.X0, 0.0f);
            this.W0 = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.Lj0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    this.a.a0(valueAnimator2);
                }
            });
            this.U0 = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            ViewGroup viewGroup = this.b;
            if (viewGroup != null) {
                if (this.p1) {
                    arrayList.add(ObjectAnimator.ofFloat(viewGroup, (Property<ViewGroup, Float>) View.TRANSLATION_X, AbstractC21455b.F(48.0f)));
                    arrayList.add(ObjectAnimator.ofFloat(this.b, (Property<ViewGroup, Float>) View.ALPHA, 0.0f));
                } else {
                    arrayList.add(ObjectAnimator.ofFloat(viewGroup, (Property<ViewGroup, Float>) View.TRANSLATION_Y, W() + this.e + AbstractC21455b.F(10.0f) + (this.i ? U() : 0)));
                }
            }
            arrayList.add(ObjectAnimator.ofInt(this.G, (Property<ColorDrawable, Integer>) AbstractC21469h.b, 0));
            arrayList.add(this.W0);
            this.U0.playTogether(arrayList);
            if (this.p1) {
                this.U0.setDuration(200L);
                this.U0.setInterpolator(InterpolatorC12631ew1.f);
                j = 0;
            } else {
                j = 250;
                this.U0.setDuration(250L);
                this.U0.setInterpolator(InterpolatorC12631ew1.g);
            }
            this.U0.addListener(new h());
            E.j().s(E.d1, 512);
            this.U0.start();
        }
        Bulletin bulletinC = Bulletin.c();
        if (bulletinC != null && bulletinC.i() && bulletinC.f) {
            if (j > 0) {
                bulletinC.e((long) (j * 0.6f));
            } else {
                bulletinC.d();
            }
        }
        z0(false);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.o) {
            return false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    protected void f0(Canvas canvas) {
    }

    public void g0(Canvas canvas) {
    }

    protected boolean h0(MotionEvent motionEvent) {
        return false;
    }

    protected void i0(float f2) {
    }

    protected boolean j0() {
        return false;
    }

    protected boolean k0(View view, int i2, int i3, int i4, int i5) {
        return false;
    }

    protected boolean l0(View view, int i2, int i3) {
        return false;
    }

    protected boolean m0() {
        return false;
    }

    public void n0() {
    }

    protected void o0() {
        dismiss();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        int i2;
        super.onCreate(bundle);
        Window window = getWindow();
        setContentView(this.c, new ViewGroup.LayoutParams(-1, -1));
        if (this.H && m.k0(m.Z6, null, true) == -1) {
            this.c.setSystemUiVisibility(this.c.getSystemUiVisibility() | 8192);
        }
        if (this.J && Build.VERSION.SDK_INT >= 26) {
            AbstractC21455b.p1(getWindow(), false);
        }
        if (this.b == null) {
            c cVar = new c(getContext());
            this.b = cVar;
            cVar.setBackgroundDrawable(this.N0);
            this.b.setPadding(this.P0, ((this.Q0 ? AbstractC21455b.F(8.0f) : 0) + this.O0) - 1, this.P0, this.R0 ? AbstractC21455b.F(8.0f) : 0);
        }
        this.b.setVisibility(4);
        this.c.addView(this.b, 0, AbstractC13840gu3.d(-1, -2, 80));
        if (this.v != null) {
            d dVar = new d(getContext());
            this.I0 = dVar;
            dVar.setText(this.v);
            if (this.w) {
                this.I0.setTextColor(Z(m.V3));
                this.I0.setTextSize(1, 20.0f);
                this.I0.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
                this.I0.setPadding(AbstractC21455b.F(21.0f), AbstractC21455b.F(this.x ? 14.0f : 6.0f), AbstractC21455b.F(21.0f), AbstractC21455b.F(8.0f));
            } else {
                this.I0.setTextColor(Z(m.c4));
                this.I0.setTextSize(1, 16.0f);
                this.I0.setPadding(AbstractC21455b.F(16.0f), AbstractC21455b.F(this.x ? 8.0f : 0.0f), AbstractC21455b.F(16.0f), AbstractC21455b.F(8.0f));
            }
            if (this.x) {
                this.I0.setSingleLine(false);
                this.I0.setMaxLines(5);
                this.I0.setEllipsize(TextUtils.TruncateAt.END);
            } else {
                this.I0.setLines(1);
                this.I0.setSingleLine(true);
                this.I0.setEllipsize(TextUtils.TruncateAt.MIDDLE);
            }
            this.I0.setGravity(16);
            i2 = 48;
            this.b.addView(this.I0, AbstractC13840gu3.b(-1, this.x ? -2.0f : 48));
            this.I0.setOnTouchListener(new View.OnTouchListener() { // from class: ir.nasim.Mj0
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return BottomSheet.c0(view, motionEvent);
                }
            });
        } else {
            i2 = 0;
        }
        View view = this.u;
        if (view != null) {
            if (view.getParent() != null) {
                ((ViewGroup) this.u.getParent()).removeView(this.u);
            }
            if (this.n1) {
                this.b.addView(this.u, AbstractC13840gu3.c(-1, -2.0f, this.o1, 0.0f, i2, 0.0f, 0.0f));
            } else {
                this.b.setClipToPadding(false);
                this.b.setClipChildren(false);
                this.c.setClipToPadding(false);
                this.c.setClipChildren(false);
                float f2 = i2;
                this.b.addView(this.u, AbstractC13840gu3.c(-1, -2.0f, this.o1, 0.0f, f2, 0.0f, 0.0f));
                ((ViewGroup.MarginLayoutParams) this.u.getLayoutParams()).topMargin = (-this.O0) + AbstractC21455b.F(f2);
            }
        } else if (this.s != null) {
            int i3 = 0;
            while (true) {
                CharSequence[] charSequenceArr = this.s;
                if (i3 >= charSequenceArr.length) {
                    break;
                }
                if (charSequenceArr[i3] != null) {
                    BottomSheetCell bottomSheetCell = new BottomSheetCell(getContext(), 0, this.e1);
                    CharSequence charSequence = this.s[i3];
                    int[] iArr = this.t;
                    bottomSheetCell.setTextAndIcon(charSequence, iArr != null ? iArr[i3] : 0, null, this.w);
                    this.b.addView(bottomSheetCell, AbstractC13840gu3.c(-1, 48.0f, 51, 0.0f, i2, 0.0f, 0.0f));
                    i2 += 48;
                    bottomSheetCell.setTag(Integer.valueOf(i3));
                    bottomSheetCell.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Nj0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            this.a.d0(view2);
                        }
                    });
                    this.S0.add(bottomSheetCell);
                }
                i3++;
            }
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.gravity = 51;
        attributes.dimAmount = 0.0f;
        int i4 = attributes.flags & (-3);
        attributes.flags = i4;
        if (this.J0) {
            attributes.softInputMode = 16;
        } else {
            attributes.flags = i4 | 131072;
        }
        if (this.D) {
            attributes.flags |= -2147416832;
            this.c.setSystemUiVisibility(1284);
        }
        attributes.height = -1;
        if (Build.VERSION.SDK_INT >= 28) {
            attributes.layoutInDisplayCutoutMode = 1;
        }
        window.setAttributes(attributes);
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
    }

    public void p0() {
    }

    protected boolean q0(float f2) {
        return false;
    }

    protected void r0(float f2) {
    }

    protected void s0(float f2) {
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        A0(charSequence, false);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        z0(true);
        if (this.J0) {
            getWindow().setSoftInputMode(16);
        }
        this.o = false;
        P();
        this.b.measure(View.MeasureSpec.makeMeasureSpec(AbstractC21455b.h.x + (this.P0 * 2), RecyclerView.UNDEFINED_DURATION), View.MeasureSpec.makeMeasureSpec(AbstractC21455b.h.y, RecyclerView.UNDEFINED_DURATION));
        if (this.B0) {
            this.G.setAlpha(this.K0 ? this.L0 : 0);
            this.b.setTranslationY(0.0f);
            return;
        }
        this.G.setAlpha(0);
        this.n = 2;
        this.b.setTranslationY((AbstractC21455b.d * (1.0f - this.m1)) + r1.getMeasuredHeight() + (this.i ? U() : 0));
        long j = this.l1 ? 0L : 150L;
        if (this.k) {
            j = 500;
        }
        e eVar = new e();
        this.m = eVar;
        AbstractC21455b.n1(eVar, j);
    }

    public void t0(int i2) {
        this.N0.setColorFilter(i2, PorterDuff.Mode.MULTIPLY);
    }

    public void u0(boolean z) {
        this.E0 = z;
        this.g = z;
    }

    public void v0(View view) {
        this.u = view;
    }

    public void w0(int i2, int i3, int i4) {
        if (i2 < 0 || i2 >= this.S0.size()) {
            return;
        }
        BottomSheetCell bottomSheetCell = (BottomSheetCell) this.S0.get(i2);
        bottomSheetCell.b.setTextColor(i3);
        bottomSheetCell.c.setColorFilter(new PorterDuffColorFilter(i4, PorterDuff.Mode.MULTIPLY));
    }

    public void x0(DialogInterface.OnDismissListener onDismissListener) {
        this.d1 = onDismissListener;
    }

    public void y0(int i2) {
        this.q1 = i2;
        ContainerView containerView = this.c;
        if (containerView != null) {
            containerView.invalidate();
        }
        AbstractC21455b.s1(getWindow(), this.q1);
        AbstractC21455b.p1(getWindow(), ((double) AbstractC21455b.z(this.q1)) > 0.721d);
    }
}
