package ir.nasim.tgwidgets.editor.ui.ActionBar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.transition.TransitionValues;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC13840gu3;
import ir.nasim.FH3;
import ir.nasim.InterpolatorC12631ew1;
import ir.nasim.M52;
import ir.nasim.QY0;
import ir.nasim.TD5;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.E;
import ir.nasim.tgwidgets.editor.ui.ActionBar.m;
import ir.nasim.tgwidgets.editor.ui.Components.BackupImageView;
import ir.nasim.tgwidgets.editor.ui.Components.SizeNotifierFrameLayout;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class ActionBar extends FrameLayout {
    private View.OnClickListener A;
    protected int A0;
    private Object[] B;
    protected int B0;
    protected int C0;
    private boolean D;
    protected int D0;
    public e E0;
    private int F0;
    private Runnable G;
    private boolean G0;
    private boolean H;
    private boolean H0;
    private boolean I0;
    protected boolean J;
    private boolean J0;
    private CharSequence K0;
    private boolean L0;
    private boolean M0;
    private boolean N0;
    private boolean O0;
    private FrameLayout P0;
    private boolean Q0;
    private View.OnTouchListener R0;
    private final m.h S0;
    private PorterDuff.Mode T0;
    SizeNotifierFrameLayout U0;
    boolean V0;
    public Paint W0;
    Rect X0;
    M52 Y0;
    Runnable Z0;
    private ImageView a;
    AnimatorSet a1;
    private BackupImageView b;
    boolean b1;
    private SimpleTextView[] c;
    private SimpleTextView d;
    private SimpleTextView e;
    private View f;
    private int g;
    private int h;
    private boolean i;
    public ActionBarMenu j;
    private ActionBarMenu k;
    private boolean l;
    protected boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private int s;
    private boolean t;
    private Paint.FontMetricsInt u;
    private Rect v;
    private int w;
    private boolean x;
    private CharSequence y;
    private Drawable z;
    public float z0;

    class a extends SimpleTextView {
        a(Context context) {
            super(context);
        }

        @Override // android.view.View
        public void setAlpha(float f) {
            super.setAlpha(f);
        }
    }

    class b extends AnimatorListenerAdapter {
        final /* synthetic */ ArrayList a;
        final /* synthetic */ boolean b;
        final /* synthetic */ boolean c;

        b(ArrayList arrayList, boolean z, boolean z2) {
            this.a = arrayList;
            this.b = z;
            this.c = z2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            for (int i = 0; i < this.a.size(); i++) {
                View view = (View) this.a.get(i);
                if (this.b) {
                    view.setVisibility(4);
                    view.setAlpha(0.0f);
                } else {
                    view.setAlpha(1.0f);
                }
            }
            if (this.b && !this.c) {
                if (ActionBar.this.c[0] != null) {
                    ActionBar.this.c[0].setVisibility(8);
                }
                if (ActionBar.this.c[1] != null) {
                    ActionBar.this.c[1].setVisibility(8);
                }
            }
            if (ActionBar.this.b == null || this.b) {
                return;
            }
            ActionBar.this.b.setVisibility(8);
        }
    }

    class c extends AnimatorListenerAdapter {
        final /* synthetic */ boolean a;
        final /* synthetic */ boolean b;

        c(boolean z, boolean z2) {
            this.a = z;
            this.b = z2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (ActionBar.this.c[1] != null && ActionBar.this.c[1].getParent() != null) {
                ((ViewGroup) ActionBar.this.c[1].getParent()).removeView(ActionBar.this.c[1]);
            }
            ActionBar.this.c[1] = null;
            ActionBar.this.H0 = false;
            if (this.a && this.b) {
                ActionBar.this.d.setVisibility(8);
            }
            ActionBar.this.requestLayout();
        }
    }

    class d extends ChangeBounds {

        class a extends AnimatorListenerAdapter {
            final /* synthetic */ TransitionValues a;

            a(TransitionValues transitionValues) {
                this.a = transitionValues;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                this.a.view.setLayerType(0, null);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                this.a.view.setLayerType(2, null);
            }
        }

        d() {
        }

        @Override // android.transition.ChangeBounds, android.transition.Transition
        public void captureEndValues(TransitionValues transitionValues) {
            super.captureEndValues(transitionValues);
            View view = transitionValues.view;
            if (view instanceof SimpleTextView) {
                transitionValues.values.put("text_size", Float.valueOf(((SimpleTextView) view).getTextPaint().getTextSize()));
            }
        }

        @Override // android.transition.ChangeBounds, android.transition.Transition
        public void captureStartValues(TransitionValues transitionValues) {
            super.captureStartValues(transitionValues);
            View view = transitionValues.view;
            if (view instanceof SimpleTextView) {
                transitionValues.values.put("text_size", Float.valueOf(((SimpleTextView) view).getTextPaint().getTextSize()));
            }
        }

        @Override // android.transition.ChangeBounds, android.transition.Transition
        public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
            if (transitionValues == null || !(transitionValues.view instanceof SimpleTextView)) {
                return super.createAnimator(viewGroup, transitionValues, transitionValues2);
            }
            AnimatorSet animatorSet = new AnimatorSet();
            if (transitionValues2 != null) {
                Animator animatorCreateAnimator = super.createAnimator(viewGroup, transitionValues, transitionValues2);
                float fFloatValue = ((Float) transitionValues.values.get("text_size")).floatValue() / ((Float) transitionValues2.values.get("text_size")).floatValue();
                transitionValues.view.setScaleX(fFloatValue);
                transitionValues.view.setScaleY(fFloatValue);
                if (animatorCreateAnimator != null) {
                    animatorSet.playTogether(animatorCreateAnimator);
                }
            }
            animatorSet.playTogether(ObjectAnimator.ofFloat(transitionValues.view, (Property<View, Float>) View.SCALE_X, 1.0f));
            animatorSet.playTogether(ObjectAnimator.ofFloat(transitionValues.view, (Property<View, Float>) View.SCALE_Y, 1.0f));
            animatorSet.addListener(new a(transitionValues));
            return animatorSet;
        }
    }

    public static class e {
        public boolean a() {
            return true;
        }

        public abstract void b(int i);
    }

    public ActionBar(Context context) {
        this(context, null);
    }

    public static int getCurrentActionBarHeight() {
        if (AbstractC21455b.F0()) {
            return AbstractC21455b.F(64.0f);
        }
        Point point = AbstractC21455b.h;
        return point.x > point.y ? AbstractC21455b.F(48.0f) : AbstractC21455b.F(56.0f);
    }

    private void k() {
        if (this.a != null) {
            return;
        }
        ImageView imageView = new ImageView(getContext());
        this.a = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        this.a.setBackgroundDrawable(m.Y(this.A0));
        if (this.C0 != 0) {
            this.a.setColorFilter(new PorterDuffColorFilter(this.C0, this.T0));
        }
        this.a.setPadding(AbstractC21455b.F(1.0f), 0, 0, 0);
        addView(this.a, AbstractC13840gu3.d(54, 54, 51));
        this.a.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.I4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.r(view);
            }
        });
        this.a.setContentDescription(FH3.E("AccDescrGoBack", TD5.tgwidget_AccDescrGoBack));
    }

    private void m() {
        if (this.d != null) {
            return;
        }
        SimpleTextView simpleTextView = new SimpleTextView(getContext());
        this.d = simpleTextView;
        simpleTextView.setGravity(3);
        this.d.setVisibility(8);
        this.d.setTextColor(o(m.i7));
        addView(this.d, 0, AbstractC13840gu3.d(-2, -2, 51));
    }

    private void n(int i) {
        SimpleTextView[] simpleTextViewArr = this.c;
        if (simpleTextViewArr[i] != null) {
            return;
        }
        simpleTextViewArr[i] = new a(getContext());
        this.c[i].setGravity(19);
        int i2 = this.F0;
        if (i2 != 0) {
            this.c[i].setTextColor(i2);
        } else {
            this.c[i].setTextColor(o(m.h7));
        }
        this.c[i].setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
        this.c[i].setDrawablePadding(AbstractC21455b.F(4.0f));
        this.c[i].setPadding(0, AbstractC21455b.F(8.0f), 0, AbstractC21455b.F(8.0f));
        this.c[i].setRightDrawableTopPadding(-AbstractC21455b.F(1.0f));
        if (this.Q0) {
            this.P0.addView(this.c[i], 0, AbstractC13840gu3.d(-2, -2, 51));
        } else {
            addView(this.c[i], 0, AbstractC13840gu3.d(-2, -2, 51));
        }
    }

    private int o(int i) {
        return m.j0(i, this.S0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(View view) {
        if (!this.n && this.J) {
            i();
            return;
        }
        e eVar = this.E0;
        if (eVar != null) {
            eVar.b(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(View view) {
        Runnable runnable;
        if (q() || (runnable = this.G) == null) {
            return;
        }
        runnable.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(ValueAnimator valueAnimator) {
        this.z0 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        Runnable runnable = this.Z0;
        if (runnable != null) {
            runnable.run();
        }
    }

    private void y() {
        boolean z = this.M0 && this.N0;
        if (this.O0 != z) {
            this.O0 = z;
            if (z) {
                this.Y0.e();
            } else {
                this.Y0.f();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.V0 && this.h != 0) {
            this.X0.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
            this.W0.setColor(this.h);
            this.U0.y(canvas, getY(), this.X0, this.W0, true);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        Drawable drawableL0;
        if (this.L0 && view == this.a) {
            return true;
        }
        boolean zX = x(view);
        if (zX) {
            canvas.save();
            canvas.clipRect(0.0f, (-getTranslationY()) + (this.m ? AbstractC21455b.d : 0), getMeasuredWidth(), getMeasuredHeight());
        }
        boolean zDrawChild = super.drawChild(canvas, view, j);
        if (this.t && !this.D && !FH3.D) {
            SimpleTextView[] simpleTextViewArr = this.c;
            if ((view == simpleTextViewArr[0] || view == simpleTextViewArr[1]) && (drawableL0 = m.l0()) != null) {
                SimpleTextView simpleTextView = (SimpleTextView) view;
                if (simpleTextView.getVisibility() == 0 && (simpleTextView.getText() instanceof String)) {
                    TextPaint textPaint = simpleTextView.getTextPaint();
                    textPaint.getFontMetricsInt(this.u);
                    textPaint.getTextBounds((String) simpleTextView.getText(), 0, 1, this.v);
                    int textStartX = simpleTextView.getTextStartX() + m.m0() + ((this.v.width() - (drawableL0.getIntrinsicWidth() + m.m0())) / 2);
                    int textStartY = simpleTextView.getTextStartY() + m.n0() + ((int) Math.ceil((simpleTextView.getTextHeight() - this.v.height()) / 2.0f));
                    drawableL0.setBounds(textStartX, textStartY - drawableL0.getIntrinsicHeight(), drawableL0.getIntrinsicWidth() + textStartX, textStartY);
                    drawableL0.setAlpha((int) (simpleTextView.getAlpha() * 255.0f));
                    drawableL0.draw(canvas);
                    if (this.b1) {
                        view.invalidate();
                        invalidate();
                    }
                }
            }
        }
        if (zX) {
            canvas.restore();
        }
        return zDrawChild;
    }

    public e getActionBarMenuOnItemClick() {
        return this.E0;
    }

    public ImageView getBackButton() {
        return this.a;
    }

    public boolean getCastShadows() {
        return this.H;
    }

    public String getTitle() {
        SimpleTextView simpleTextView = this.c[0];
        if (simpleTextView == null) {
            return null;
        }
        return simpleTextView.getText().toString();
    }

    public void h() {
        if (FH3.D) {
            return;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.setOrdering(0);
        transitionSet.addTransition(new Fade());
        transitionSet.addTransition(new d());
        this.J0 = false;
        transitionSet.setDuration(220L);
        transitionSet.setInterpolator((TimeInterpolator) InterpolatorC12631ew1.f);
        TransitionManager.beginDelayedTransition(this, transitionSet);
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    public void i() {
        j(true);
    }

    public void j(boolean z) {
        ActionBarMenu actionBarMenu;
        if (!this.J || (actionBarMenu = this.j) == null) {
            return;
        }
        actionBarMenu.h(z);
    }

    public ActionBarMenu l() {
        ActionBarMenu actionBarMenu = this.j;
        if (actionBarMenu != null) {
            return actionBarMenu;
        }
        ActionBarMenu actionBarMenu2 = new ActionBarMenu(getContext(), this);
        this.j = actionBarMenu2;
        addView(actionBarMenu2, 0, AbstractC13840gu3.d(-2, -1, 5));
        return this.j;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.M0 = true;
        y();
        if (this.n) {
            if (QY0.d(this.g) < 0.699999988079071d) {
                AbstractC21455b.q1(((Activity) getContext()).getWindow(), false);
            } else {
                AbstractC21455b.q1(((Activity) getContext()).getWindow(), true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.M0 = false;
        y();
        if (this.n) {
            int i = this.h;
            if (i == 0) {
                E.j().s(E.T2, new Object[0]);
            } else if (QY0.d(i) < 0.699999988079071d) {
                AbstractC21455b.q1(((Activity) getContext()).getWindow(), false);
            } else {
                AbstractC21455b.q1(((Activity) getContext()).getWindow(), true);
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        Drawable drawableL0;
        if (this.t && !this.D && !FH3.D && motionEvent.getAction() == 0 && (drawableL0 = m.l0()) != null) {
            drawableL0.getBounds().contains((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        View.OnTouchListener onTouchListener = this.R0;
        return (onTouchListener != null && onTouchListener.onTouch(this, motionEvent)) || super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x025d  */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onLayout(boolean r15, int r16, int r17, int r18, int r19) {
        /*
            Method dump skipped, instructions count: 625
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBar.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int iF;
        SimpleTextView simpleTextView;
        SimpleTextView simpleTextView2;
        int iMakeMeasureSpec;
        int size = View.MeasureSpec.getSize(i);
        View.MeasureSpec.getSize(i2);
        int currentActionBarHeight = getCurrentActionBarHeight();
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(currentActionBarHeight, 1073741824);
        this.l = true;
        View view = this.f;
        if (view != null) {
            ((FrameLayout.LayoutParams) view.getLayoutParams()).height = AbstractC21455b.d;
        }
        ActionBarMenu actionBarMenu = this.k;
        if (actionBarMenu != null) {
            actionBarMenu.setPadding(0, this.m ? AbstractC21455b.d : 0, 0, 0);
        }
        this.l = false;
        setMeasuredDimension(size, currentActionBarHeight + (this.m ? AbstractC21455b.d : 0) + this.s);
        ImageView imageView = this.a;
        if (imageView == null || imageView.getVisibility() == 8) {
            iF = AbstractC21455b.F(AbstractC21455b.F0() ? 26.0f : 18.0f);
        } else {
            this.a.measure(View.MeasureSpec.makeMeasureSpec(AbstractC21455b.F(54.0f), 1073741824), iMakeMeasureSpec2);
            iF = AbstractC21455b.F(AbstractC21455b.F0() ? 80.0f : 72.0f);
        }
        ActionBarMenu actionBarMenu2 = this.j;
        if (actionBarMenu2 != null && actionBarMenu2.getVisibility() != 8) {
            if (this.j.m() && !this.J) {
                this.j.measure(View.MeasureSpec.makeMeasureSpec(size, RecyclerView.UNDEFINED_DURATION), iMakeMeasureSpec2);
                int itemsMeasuredWidth = this.j.getItemsMeasuredWidth();
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec((size - AbstractC21455b.F(AbstractC21455b.F0() ? 74.0f : 66.0f)) + this.j.getItemsMeasuredWidth(), 1073741824);
                if (!this.i) {
                    this.j.o(-itemsMeasuredWidth);
                }
            } else if (this.J) {
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size - AbstractC21455b.F(AbstractC21455b.F0() ? 74.0f : 66.0f), 1073741824);
                if (!this.i) {
                    this.j.o(0.0f);
                }
            } else {
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, RecyclerView.UNDEFINED_DURATION);
                if (!this.i) {
                    this.j.o(0.0f);
                }
            }
            this.j.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        }
        for (int i3 = 0; i3 < 2; i3++) {
            SimpleTextView simpleTextView3 = this.c[0];
            if ((simpleTextView3 != null && simpleTextView3.getVisibility() != 8) || ((simpleTextView = this.d) != null && simpleTextView.getVisibility() != 8)) {
                ActionBarMenu actionBarMenu3 = this.j;
                int measuredWidth = (((size - (actionBarMenu3 != null ? actionBarMenu3.getMeasuredWidth() : 0)) - AbstractC21455b.F(16.0f)) - iF) - this.w;
                boolean z = this.I0;
                if (((z && i3 == 0) || (!z && i3 == 1)) && this.G0 && this.H0) {
                    this.c[i3].setTextSize((AbstractC21455b.F0() || getResources().getConfiguration().orientation != 2) ? 20 : 18);
                } else {
                    SimpleTextView simpleTextView4 = this.c[0];
                    if (simpleTextView4 == null || simpleTextView4.getVisibility() == 8 || (simpleTextView2 = this.d) == null || simpleTextView2.getVisibility() == 8) {
                        SimpleTextView simpleTextView5 = this.c[i3];
                        if (simpleTextView5 != null && simpleTextView5.getVisibility() != 8) {
                            this.c[i3].setTextSize((AbstractC21455b.F0() || getResources().getConfiguration().orientation != 2) ? 20 : 18);
                        }
                        SimpleTextView simpleTextView6 = this.d;
                        if (simpleTextView6 != null && simpleTextView6.getVisibility() != 8) {
                            this.d.setTextSize((AbstractC21455b.F0() || getResources().getConfiguration().orientation != 2) ? 16 : 14);
                        }
                        SimpleTextView simpleTextView7 = this.e;
                        if (simpleTextView7 != null) {
                            simpleTextView7.setTextSize((AbstractC21455b.F0() || getResources().getConfiguration().orientation != 2) ? 16 : 14);
                        }
                    } else {
                        SimpleTextView simpleTextView8 = this.c[i3];
                        if (simpleTextView8 != null) {
                            simpleTextView8.setTextSize(AbstractC21455b.F0() ? 20 : 18);
                        }
                        this.d.setTextSize(AbstractC21455b.F0() ? 16 : 14);
                        SimpleTextView simpleTextView9 = this.e;
                        if (simpleTextView9 != null) {
                            simpleTextView9.setTextSize(AbstractC21455b.F0() ? 16 : 14);
                        }
                    }
                }
                SimpleTextView simpleTextView10 = this.c[i3];
                if (simpleTextView10 != null && simpleTextView10.getVisibility() != 8) {
                    this.c[i3].measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, RecyclerView.UNDEFINED_DURATION), View.MeasureSpec.makeMeasureSpec(AbstractC21455b.F(24.0f) + this.c[i3].getPaddingTop() + this.c[i3].getPaddingBottom(), RecyclerView.UNDEFINED_DURATION));
                    if (this.J0) {
                        CharSequence text = this.c[i3].getText();
                        SimpleTextView simpleTextView11 = this.c[i3];
                        simpleTextView11.setPivotX(simpleTextView11.getTextPaint().measureText(text, 0, text.length()) / 2.0f);
                        this.c[i3].setPivotY(AbstractC21455b.F(24.0f) >> 1);
                    } else {
                        this.c[i3].setPivotX(0.0f);
                        this.c[i3].setPivotY(0.0f);
                    }
                }
                SimpleTextView simpleTextView12 = this.d;
                if (simpleTextView12 != null && simpleTextView12.getVisibility() != 8) {
                    this.d.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, RecyclerView.UNDEFINED_DURATION), View.MeasureSpec.makeMeasureSpec(AbstractC21455b.F(20.0f), RecyclerView.UNDEFINED_DURATION));
                }
                SimpleTextView simpleTextView13 = this.e;
                if (simpleTextView13 != null && simpleTextView13.getVisibility() != 8) {
                    this.e.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, RecyclerView.UNDEFINED_DURATION), View.MeasureSpec.makeMeasureSpec(AbstractC21455b.F(20.0f), RecyclerView.UNDEFINED_DURATION));
                }
            }
        }
        BackupImageView backupImageView = this.b;
        if (backupImageView != null) {
            backupImageView.measure(View.MeasureSpec.makeMeasureSpec(AbstractC21455b.F(42.0f), 1073741824), View.MeasureSpec.makeMeasureSpec(AbstractC21455b.F(42.0f), 1073741824));
        }
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                SimpleTextView[] simpleTextViewArr = this.c;
                if (childAt != simpleTextViewArr[0] && childAt != simpleTextViewArr[1] && childAt != this.d && childAt != this.j && childAt != this.a && childAt != this.e && childAt != this.b) {
                    measureChildWithMargins(childAt, i, 0, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824), 0);
                }
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.r) {
            return false;
        }
        return super.onTouchEvent(motionEvent) || this.q;
    }

    public boolean p() {
        return this.k != null && this.n;
    }

    public boolean q() {
        return this.J;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.l) {
            return;
        }
        super.requestLayout();
    }

    public void setActionBarMenuOnItemClick(e eVar) {
        this.E0 = eVar;
    }

    public void setActionModeColor(int i) {
        ActionBarMenu actionBarMenu = this.k;
        if (actionBarMenu != null) {
            actionBarMenu.setBackgroundColor(i);
        }
    }

    public void setActionModeTopColor(int i) {
        View view = this.f;
        if (view != null) {
            view.setBackgroundColor(i);
        }
    }

    public void setAllowOverlayTitle(boolean z) {
        this.x = z;
    }

    public void setBackButtonImage(int i) {
        if (this.a == null) {
            k();
        }
        this.a.setVisibility(i == 0 ? 8 : 0);
        this.a.setImageResource(i);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.h = i;
        super.setBackgroundColor(i);
        ImageView imageView = this.a;
        if (imageView != null) {
            imageView.getDrawable();
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        ImageView imageView = this.a;
        if (imageView != null) {
            imageView.setEnabled(z);
        }
        ActionBarMenu actionBarMenu = this.j;
        if (actionBarMenu != null) {
            actionBarMenu.setEnabled(z);
        }
        ActionBarMenu actionBarMenu2 = this.k;
        if (actionBarMenu2 != null) {
            actionBarMenu2.setEnabled(z);
        }
    }

    public void setItemsBackgroundColor(int i, boolean z) {
        ImageView imageView;
        if (z) {
            this.B0 = i;
            if (this.n && (imageView = this.a) != null) {
                imageView.setBackgroundDrawable(m.Y(i));
            }
            ActionBarMenu actionBarMenu = this.k;
            if (actionBarMenu != null) {
                actionBarMenu.p();
                return;
            }
            return;
        }
        this.A0 = i;
        ImageView imageView2 = this.a;
        if (imageView2 != null) {
            imageView2.setBackgroundDrawable(m.Y(i));
        }
        ActionBarMenu actionBarMenu2 = this.j;
        if (actionBarMenu2 != null) {
            actionBarMenu2.p();
        }
    }

    public void setItemsColor(int i, boolean z) {
        if (z) {
            this.D0 = i;
            ActionBarMenu actionBarMenu = this.k;
            if (actionBarMenu != null) {
                actionBarMenu.q();
            }
            ImageView imageView = this.a;
            if (imageView != null) {
                imageView.getDrawable();
                return;
            }
            return;
        }
        this.C0 = i;
        ImageView imageView2 = this.a;
        if (imageView2 != null && i != 0) {
            imageView2.setColorFilter(new PorterDuffColorFilter(this.C0, this.T0));
            this.a.getDrawable();
        }
        ActionBarMenu actionBarMenu2 = this.j;
        if (actionBarMenu2 != null) {
            actionBarMenu2.q();
        }
    }

    public void setOccupyStatusBar(boolean z) {
        this.m = z;
        ActionBarMenu actionBarMenu = this.k;
        if (actionBarMenu != null) {
            actionBarMenu.setPadding(0, z ? AbstractC21455b.d : 0, 0, 0);
        }
    }

    public void setOverlayTitleAnimation(boolean z) {
        this.G0 = z;
    }

    public void setPopupBackgroundColor(int i, boolean z) {
        ActionBarMenu actionBarMenu;
        ActionBarMenu actionBarMenu2;
        if (z && (actionBarMenu2 = this.k) != null) {
            actionBarMenu2.l(i);
        } else {
            if (z || (actionBarMenu = this.j) == null) {
                return;
            }
            actionBarMenu.l(i);
        }
    }

    public void setPopupItemsColor(int i, boolean z, boolean z2) {
        ActionBarMenu actionBarMenu;
        ActionBarMenu actionBarMenu2;
        if (z2 && (actionBarMenu2 = this.k) != null) {
            actionBarMenu2.n(i, z);
        } else {
            if (z2 || (actionBarMenu = this.j) == null) {
                return;
            }
            actionBarMenu.n(i, z);
        }
    }

    public void setSearchTextColor(int i, boolean z) {
        ActionBarMenu actionBarMenu = this.j;
        if (actionBarMenu != null) {
            actionBarMenu.setSearchTextColor(i, z);
        }
    }

    public void setSubtitleColor(int i) {
        if (this.d == null) {
            m();
        }
        this.d.setTextColor(i);
    }

    public void setTitle(CharSequence charSequence) {
        setTitle(charSequence, null);
    }

    public void setTitleAnimated(CharSequence charSequence, boolean z, long j, Interpolator interpolator) {
        if (this.c[0] == null || charSequence == null) {
            setTitle(charSequence);
            return;
        }
        boolean z2 = this.G0 && !TextUtils.isEmpty(this.K0);
        if (z2) {
            if (this.d.getVisibility() != 0) {
                this.d.setVisibility(0);
                this.d.setAlpha(0.0f);
            }
            this.d.animate().alpha(z ? 0.0f : 1.0f).setDuration(220L).start();
        }
        SimpleTextView simpleTextView = this.c[1];
        if (simpleTextView != null) {
            if (simpleTextView.getParent() != null) {
                ((ViewGroup) this.c[1].getParent()).removeView(this.c[1]);
            }
            this.c[1] = null;
        }
        SimpleTextView[] simpleTextViewArr = this.c;
        simpleTextViewArr[1] = simpleTextViewArr[0];
        simpleTextViewArr[0] = null;
        setTitle(charSequence);
        this.I0 = z;
        this.c[0].setAlpha(0.0f);
        if (!z2) {
            SimpleTextView simpleTextView2 = this.c[0];
            int iF = AbstractC21455b.F(20.0f);
            if (!z) {
                iF = -iF;
            }
            simpleTextView2.setTranslationY(iF);
        }
        ViewPropertyAnimator duration = this.c[0].animate().alpha(1.0f).translationY(0.0f).setDuration(j);
        if (interpolator != null) {
            duration.setInterpolator(interpolator);
        }
        duration.start();
        this.H0 = true;
        ViewPropertyAnimator viewPropertyAnimatorAlpha = this.c[1].animate().alpha(0.0f);
        if (!z2) {
            int iF2 = AbstractC21455b.F(20.0f);
            if (z) {
                iF2 = -iF2;
            }
            viewPropertyAnimatorAlpha.translationY(iF2);
        }
        if (interpolator != null) {
            viewPropertyAnimatorAlpha.setInterpolator(interpolator);
        }
        viewPropertyAnimatorAlpha.setDuration(j).setListener(new c(z2, z)).start();
        requestLayout();
    }

    public void setTitleColor(int i) {
        if (this.c[0] == null) {
            n(0);
        }
        this.F0 = i;
        this.c[0].setTextColor(i);
        SimpleTextView simpleTextView = this.c[1];
        if (simpleTextView != null) {
            simpleTextView.setTextColor(i);
        }
    }

    public void setTitleOverlayText(String str, int i, Runnable runnable) {
        if (this.x) {
            throw null;
        }
    }

    public void setTitleRightMargin(int i) {
        this.w = i;
    }

    public void setTitleScrollNonFitText(boolean z) {
        this.c[0].setScrollNonFitText(z);
    }

    @Override // android.view.View
    public void setTranslationY(float f) {
        super.setTranslationY(f);
        if (this.p) {
            invalidate();
        }
    }

    public void u() {
        ActionBarMenu actionBarMenu;
        if (p() || (actionBarMenu = this.j) == null) {
            return;
        }
        actionBarMenu.k();
    }

    protected boolean v() {
        return false;
    }

    public void w(boolean z) {
        this.J = z;
        AnimatorSet animatorSet = this.a1;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.a1 = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        boolean zV = v();
        if (!zV) {
            SimpleTextView simpleTextView = this.c[0];
            if (simpleTextView != null) {
                arrayList.add(simpleTextView);
            }
            if (this.d != null && !TextUtils.isEmpty(this.K0)) {
                arrayList.add(this.d);
                this.d.setVisibility(z ? 4 : 0);
            }
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.z0, z ? 1.0f : 0.0f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.K4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.a.t(valueAnimator);
            }
        });
        this.a1.playTogether(valueAnimatorOfFloat);
        for (int i = 0; i < arrayList.size(); i++) {
            View view = (View) arrayList.get(i);
            float f = 0.95f;
            if (!z) {
                view.setVisibility(0);
                view.setAlpha(0.0f);
                view.setScaleX(0.95f);
                view.setScaleY(0.95f);
            }
            this.a1.playTogether(ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, z ? 0.0f : 1.0f));
            this.a1.playTogether(ObjectAnimator.ofFloat(view, (Property<View, Float>) View.SCALE_Y, z ? 0.95f : 1.0f));
            AnimatorSet animatorSet2 = this.a1;
            Property property = View.SCALE_X;
            if (!z) {
                f = 1.0f;
            }
            animatorSet2.playTogether(ObjectAnimator.ofFloat(view, (Property<View, Float>) property, f));
        }
        BackupImageView backupImageView = this.b;
        if (backupImageView != null) {
            backupImageView.setVisibility(0);
            this.a1.playTogether(ObjectAnimator.ofFloat(this.b, (Property<BackupImageView, Float>) View.ALPHA, z ? 1.0f : 0.0f));
        }
        this.J0 = true;
        requestLayout();
        this.a1.addListener(new b(arrayList, z, zV));
        this.a1.setDuration(150L).start();
        ImageView imageView = this.a;
        if (imageView != null) {
            imageView.getDrawable();
        }
    }

    protected boolean x(View view) {
        if (!this.p) {
            return false;
        }
        SimpleTextView[] simpleTextViewArr = this.c;
        return view == simpleTextViewArr[0] || view == simpleTextViewArr[1] || view == this.d || view == this.j || view == this.a || view == this.e || view == this.P0;
    }

    public ActionBar(Context context, m.h hVar) {
        super(context);
        this.c = new SimpleTextView[2];
        this.m = true;
        this.o = true;
        this.q = true;
        this.B = new Object[3];
        this.H = true;
        this.F0 = 0;
        this.T0 = PorterDuff.Mode.MULTIPLY;
        this.W0 = new Paint();
        this.X0 = new Rect();
        this.Y0 = new M52(this);
        this.S0 = hVar;
        setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.J4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.s(view);
            }
        });
    }

    public void setTitle(CharSequence charSequence, Drawable drawable) {
        if (charSequence != null && this.c[0] == null) {
            n(0);
        }
        SimpleTextView simpleTextView = this.c[0];
        if (simpleTextView != null) {
            simpleTextView.setVisibility((charSequence == null || this.J) ? 4 : 0);
            SimpleTextView simpleTextView2 = this.c[0];
            this.y = charSequence;
            simpleTextView2.i(charSequence);
            SimpleTextView simpleTextView3 = this.c[0];
            this.z = drawable;
            simpleTextView3.setRightDrawable(drawable);
            this.c[0].setRightDrawableOnClick(this.A);
        }
        this.I0 = false;
    }
}
