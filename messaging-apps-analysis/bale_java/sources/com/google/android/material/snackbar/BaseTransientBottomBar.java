package com.google.android.material.snackbar;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.snackbar.a;
import ir.nasim.AbstractC10402bY7;
import ir.nasim.AbstractC12181eA5;
import ir.nasim.AbstractC12799fB5;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC17750nV3;
import ir.nasim.AbstractC21710u02;
import ir.nasim.AbstractC5729Ko7;
import ir.nasim.AbstractC6732Ot;
import ir.nasim.AbstractC9751aV3;
import ir.nasim.C22317v2;
import ir.nasim.GE5;
import ir.nasim.InterfaceC22153ul1;
import ir.nasim.InterfaceC22474vI4;
import ir.nasim.O98;
import ir.nasim.WU3;
import ir.nasim.X2;
import ir.nasim.YC5;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class BaseTransientBottomBar {
    private final ViewGroup a;
    private final Context b;
    protected final SnackbarBaseLayout c;
    private final InterfaceC22153ul1 d;
    private int e;
    private boolean f;
    private q g;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private boolean o;
    private List p;
    private Behavior q;
    private final AccessibilityManager r;
    private static final boolean u = false;
    private static final int[] v = {AbstractC12181eA5.snackbarStyle};
    private static final String w = BaseTransientBottomBar.class.getSimpleName();
    static final Handler t = new Handler(Looper.getMainLooper(), new h());
    private boolean h = false;
    private final Runnable i = new i();
    a.b s = new l();

    public static class Behavior extends SwipeDismissBehavior<View> {
        private final s k = new s(this);

        /* JADX INFO: Access modifiers changed from: private */
        public void P(BaseTransientBottomBar baseTransientBottomBar) {
            this.k.c(baseTransientBottomBar);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean E(View view) {
            return this.k.a(view);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            this.k.b(coordinatorLayout, view, motionEvent);
            return super.k(coordinatorLayout, view, motionEvent);
        }
    }

    protected static class SnackbarBaseLayout extends FrameLayout {
        private static final View.OnTouchListener k = new a();
        private BaseTransientBottomBar a;
        private int b;
        private final float c;
        private final float d;
        private final int e;
        private final int f;
        private ColorStateList g;
        private PorterDuff.Mode h;
        private Rect i;
        private boolean j;

        class a implements View.OnTouchListener {
            a() {
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        }

        protected SnackbarBaseLayout(Context context) {
            this(context, null);
        }

        private Drawable d() throws Resources.NotFoundException {
            float dimension = getResources().getDimension(AbstractC12799fB5.mtrl_snackbar_background_corner_radius);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(dimension);
            gradientDrawable.setColor(WU3.i(this, AbstractC12181eA5.colorSurface, AbstractC12181eA5.colorOnSurface, getBackgroundOverlayColorAlpha()));
            if (this.g == null) {
                return AbstractC21710u02.l(gradientDrawable);
            }
            Drawable drawableL = AbstractC21710u02.l(gradientDrawable);
            AbstractC21710u02.i(drawableL, this.g);
            return drawableL;
        }

        private void e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.i = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBaseTransientBottomBar(BaseTransientBottomBar baseTransientBottomBar) {
            this.a = baseTransientBottomBar;
        }

        void c(ViewGroup viewGroup) {
            this.j = true;
            viewGroup.addView(this);
            this.j = false;
        }

        float getActionTextColorAlpha() {
            return this.d;
        }

        int getAnimationMode() {
            return this.b;
        }

        float getBackgroundOverlayColorAlpha() {
            return this.c;
        }

        int getMaxInlineActionWidth() {
            return this.f;
        }

        int getMaxWidth() {
            return this.e;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            BaseTransientBottomBar baseTransientBottomBar = this.a;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.K();
            }
            AbstractC12990fW7.m0(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            BaseTransientBottomBar baseTransientBottomBar = this.a;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.L();
            }
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            BaseTransientBottomBar baseTransientBottomBar = this.a;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.M();
            }
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (this.e > 0) {
                int measuredWidth = getMeasuredWidth();
                int i3 = this.e;
                if (measuredWidth > i3) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), i2);
                }
            }
        }

        void setAnimationMode(int i) {
            this.b = i;
        }

        @Override // android.view.View
        public void setBackground(Drawable drawable) {
            setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundDrawable(Drawable drawable) {
            if (drawable != null && this.g != null) {
                drawable = AbstractC21710u02.l(drawable.mutate());
                AbstractC21710u02.i(drawable, this.g);
                AbstractC21710u02.j(drawable, this.h);
            }
            super.setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundTintList(ColorStateList colorStateList) {
            this.g = colorStateList;
            if (getBackground() != null) {
                Drawable drawableL = AbstractC21710u02.l(getBackground().mutate());
                AbstractC21710u02.i(drawableL, colorStateList);
                AbstractC21710u02.j(drawableL, this.h);
                if (drawableL != getBackground()) {
                    super.setBackgroundDrawable(drawableL);
                }
            }
        }

        @Override // android.view.View
        public void setBackgroundTintMode(PorterDuff.Mode mode) {
            this.h = mode;
            if (getBackground() != null) {
                Drawable drawableL = AbstractC21710u02.l(getBackground().mutate());
                AbstractC21710u02.j(drawableL, mode);
                if (drawableL != getBackground()) {
                    super.setBackgroundDrawable(drawableL);
                }
            }
        }

        @Override // android.view.View
        public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
            super.setLayoutParams(layoutParams);
            if (this.j || !(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                return;
            }
            e((ViewGroup.MarginLayoutParams) layoutParams);
            BaseTransientBottomBar baseTransientBottomBar = this.a;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.d0();
            }
        }

        @Override // android.view.View
        public void setOnClickListener(View.OnClickListener onClickListener) {
            setOnTouchListener(onClickListener != null ? null : k);
            super.setOnClickListener(onClickListener);
        }

        protected SnackbarBaseLayout(Context context, AttributeSet attributeSet) {
            super(AbstractC17750nV3.c(context, attributeSet, 0, 0), attributeSet);
            Context context2 = getContext();
            TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, GE5.SnackbarLayout);
            if (typedArrayObtainStyledAttributes.hasValue(GE5.SnackbarLayout_elevation)) {
                AbstractC12990fW7.x0(this, typedArrayObtainStyledAttributes.getDimensionPixelSize(GE5.SnackbarLayout_elevation, 0));
            }
            this.b = typedArrayObtainStyledAttributes.getInt(GE5.SnackbarLayout_animationMode, 0);
            this.c = typedArrayObtainStyledAttributes.getFloat(GE5.SnackbarLayout_backgroundOverlayColorAlpha, 1.0f);
            setBackgroundTintList(AbstractC9751aV3.a(context2, typedArrayObtainStyledAttributes, GE5.SnackbarLayout_backgroundTint));
            setBackgroundTintMode(AbstractC10402bY7.k(typedArrayObtainStyledAttributes.getInt(GE5.SnackbarLayout_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN));
            this.d = typedArrayObtainStyledAttributes.getFloat(GE5.SnackbarLayout_actionTextColorAlpha, 1.0f);
            this.e = typedArrayObtainStyledAttributes.getDimensionPixelSize(GE5.SnackbarLayout_android_maxWidth, -1);
            this.f = typedArrayObtainStyledAttributes.getDimensionPixelSize(GE5.SnackbarLayout_maxActionInlineWidth, -1);
            typedArrayObtainStyledAttributes.recycle();
            setOnTouchListener(k);
            setFocusable(true);
            if (getBackground() == null) {
                AbstractC12990fW7.t0(this, d());
            }
        }
    }

    class a extends AnimatorListenerAdapter {
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.N(this.a);
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            BaseTransientBottomBar.this.c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            BaseTransientBottomBar.this.c.setScaleX(fFloatValue);
            BaseTransientBottomBar.this.c.setScaleY(fFloatValue);
        }
    }

    class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.O();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.d.a(70, SetRpcStruct$ComposedRpc.JOIN_GROUP_FIELD_NUMBER);
        }
    }

    class e implements ValueAnimator.AnimatorUpdateListener {
        private int a;
        final /* synthetic */ int b;

        e(int i) {
            this.b = i;
            this.a = i;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.u) {
                AbstractC12990fW7.a0(BaseTransientBottomBar.this.c, iIntValue - this.a);
            } else {
                BaseTransientBottomBar.this.c.setTranslationY(iIntValue);
            }
            this.a = iIntValue;
        }
    }

    class f extends AnimatorListenerAdapter {
        final /* synthetic */ int a;

        f(int i) {
            this.a = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.N(this.a);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.d.b(0, SetRpcStruct$ComposedRpc.JOIN_GROUP_FIELD_NUMBER);
        }
    }

    class g implements ValueAnimator.AnimatorUpdateListener {
        private int a = 0;

        g() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.u) {
                AbstractC12990fW7.a0(BaseTransientBottomBar.this.c, iIntValue - this.a);
            } else {
                BaseTransientBottomBar.this.c.setTranslationY(iIntValue);
            }
            this.a = iIntValue;
        }
    }

    class h implements Handler.Callback {
        h() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                ((BaseTransientBottomBar) message.obj).X();
                return true;
            }
            if (i != 1) {
                return false;
            }
            ((BaseTransientBottomBar) message.obj).G(message.arg1);
            return true;
        }
    }

    class i implements Runnable {
        i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int iA;
            BaseTransientBottomBar baseTransientBottomBar = BaseTransientBottomBar.this;
            if (baseTransientBottomBar.c == null || baseTransientBottomBar.b == null || (iA = (BaseTransientBottomBar.this.A() - BaseTransientBottomBar.this.E()) + ((int) BaseTransientBottomBar.this.c.getTranslationY())) >= BaseTransientBottomBar.this.m) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = BaseTransientBottomBar.this.c.getLayoutParams();
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                Log.w(BaseTransientBottomBar.w, "Unable to apply gesture inset because layout params are not MarginLayoutParams");
                return;
            }
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin += BaseTransientBottomBar.this.m - iA;
            BaseTransientBottomBar.this.c.requestLayout();
        }
    }

    class j implements InterfaceC22474vI4 {
        j() {
        }

        @Override // ir.nasim.InterfaceC22474vI4
        public O98 b(View view, O98 o98) {
            BaseTransientBottomBar.this.j = o98.j();
            BaseTransientBottomBar.this.k = o98.k();
            BaseTransientBottomBar.this.l = o98.l();
            BaseTransientBottomBar.this.d0();
            return o98;
        }
    }

    class k extends C22317v2 {
        k() {
        }

        @Override // ir.nasim.C22317v2
        public void g(View view, X2 x2) {
            super.g(view, x2);
            x2.a(1048576);
            x2.v0(true);
        }

        @Override // ir.nasim.C22317v2
        public boolean j(View view, int i, Bundle bundle) {
            if (i != 1048576) {
                return super.j(view, i, bundle);
            }
            BaseTransientBottomBar.this.t();
            return true;
        }
    }

    class l implements a.b {
        l() {
        }

        @Override // com.google.android.material.snackbar.a.b
        public void a() {
            Handler handler = BaseTransientBottomBar.t;
            handler.sendMessage(handler.obtainMessage(0, BaseTransientBottomBar.this));
        }

        @Override // com.google.android.material.snackbar.a.b
        public void b(int i) {
            Handler handler = BaseTransientBottomBar.t;
            handler.sendMessage(handler.obtainMessage(1, i, 0, BaseTransientBottomBar.this));
        }
    }

    class m implements Runnable {
        m() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseTransientBottomBar.this.N(3);
        }
    }

    class n implements SwipeDismissBehavior.c {
        n() {
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.c
        public void a(View view) {
            if (view.getParent() != null) {
                view.setVisibility(8);
            }
            BaseTransientBottomBar.this.u(0);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.c
        public void b(int i) {
            if (i == 0) {
                com.google.android.material.snackbar.a.c().l(BaseTransientBottomBar.this.s);
            } else if (i == 1 || i == 2) {
                com.google.android.material.snackbar.a.c().k(BaseTransientBottomBar.this.s);
            }
        }
    }

    class o implements Runnable {
        o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SnackbarBaseLayout snackbarBaseLayout = BaseTransientBottomBar.this.c;
            if (snackbarBaseLayout == null) {
                return;
            }
            if (snackbarBaseLayout.getParent() != null) {
                BaseTransientBottomBar.this.c.setVisibility(0);
            }
            if (BaseTransientBottomBar.this.c.getAnimationMode() == 1) {
                BaseTransientBottomBar.this.Z();
            } else {
                BaseTransientBottomBar.this.b0();
            }
        }
    }

    class p extends AnimatorListenerAdapter {
        p() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.O();
        }
    }

    static class q implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener {
        private final WeakReference a;
        private final WeakReference b;

        private q(BaseTransientBottomBar baseTransientBottomBar, View view) {
            this.a = new WeakReference(baseTransientBottomBar);
            this.b = new WeakReference(view);
        }

        static q a(BaseTransientBottomBar baseTransientBottomBar, View view) {
            q qVar = new q(baseTransientBottomBar, view);
            if (AbstractC12990fW7.S(view)) {
                AbstractC10402bY7.a(view, qVar);
            }
            view.addOnAttachStateChangeListener(qVar);
            return qVar;
        }

        private boolean d() {
            if (this.a.get() != null) {
                return false;
            }
            c();
            return true;
        }

        View b() {
            return (View) this.b.get();
        }

        void c() {
            if (this.b.get() != null) {
                ((View) this.b.get()).removeOnAttachStateChangeListener(this);
                AbstractC10402bY7.l((View) this.b.get(), this);
            }
            this.b.clear();
            this.a.clear();
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (d() || !((BaseTransientBottomBar) this.a.get()).h) {
                return;
            }
            ((BaseTransientBottomBar) this.a.get()).P();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            if (d()) {
                return;
            }
            AbstractC10402bY7.a(view, this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (d()) {
                return;
            }
            AbstractC10402bY7.l(view, this);
        }
    }

    public static abstract class r {
        public abstract void a(Object obj, int i);

        public void b(Object obj) {
        }
    }

    public static class s {
        private a.b a;

        public s(SwipeDismissBehavior swipeDismissBehavior) {
            swipeDismissBehavior.L(0.1f);
            swipeDismissBehavior.J(0.6f);
            swipeDismissBehavior.M(0);
        }

        public boolean a(View view) {
            return view instanceof SnackbarBaseLayout;
        }

        public void b(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                if (coordinatorLayout.F(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                    com.google.android.material.snackbar.a.c().k(this.a);
                }
            } else if (actionMasked == 1 || actionMasked == 3) {
                com.google.android.material.snackbar.a.c().l(this.a);
            }
        }

        public void c(BaseTransientBottomBar baseTransientBottomBar) {
            this.a = baseTransientBottomBar.s;
        }
    }

    protected BaseTransientBottomBar(Context context, ViewGroup viewGroup, View view, InterfaceC22153ul1 interfaceC22153ul1) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
        }
        if (view == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        }
        if (interfaceC22153ul1 == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
        }
        this.a = viewGroup;
        this.d = interfaceC22153ul1;
        this.b = context;
        AbstractC5729Ko7.a(context);
        SnackbarBaseLayout snackbarBaseLayout = (SnackbarBaseLayout) LayoutInflater.from(context).inflate(B(), viewGroup, false);
        this.c = snackbarBaseLayout;
        snackbarBaseLayout.setBaseTransientBottomBar(this);
        if (view instanceof SnackbarContentLayout) {
            SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) view;
            snackbarContentLayout.c(snackbarBaseLayout.getActionTextColorAlpha());
            snackbarContentLayout.setMaxInlineActionWidth(snackbarBaseLayout.getMaxInlineActionWidth());
        }
        snackbarBaseLayout.addView(view);
        AbstractC12990fW7.r0(snackbarBaseLayout, 1);
        AbstractC12990fW7.A0(snackbarBaseLayout, 1);
        AbstractC12990fW7.y0(snackbarBaseLayout, true);
        AbstractC12990fW7.E0(snackbarBaseLayout, new j());
        AbstractC12990fW7.p0(snackbarBaseLayout, new k());
        this.r = (AccessibilityManager) context.getSystemService("accessibility");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int A() {
        WindowManager windowManager = (WindowManager) this.b.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    private int C() {
        int height = this.c.getHeight();
        ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? height + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int E() {
        int[] iArr = new int[2];
        this.c.getLocationOnScreen(iArr);
        return iArr[1] + this.c.getHeight();
    }

    private boolean J() {
        ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
        return (layoutParams instanceof CoordinatorLayout.e) && (((CoordinatorLayout.e) layoutParams).f() instanceof SwipeDismissBehavior);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        this.n = s();
        d0();
    }

    private void T(CoordinatorLayout.e eVar) {
        SwipeDismissBehavior swipeDismissBehaviorY = this.q;
        if (swipeDismissBehaviorY == null) {
            swipeDismissBehaviorY = y();
        }
        if (swipeDismissBehaviorY instanceof Behavior) {
            ((Behavior) swipeDismissBehaviorY).P(this);
        }
        swipeDismissBehaviorY.K(new n());
        eVar.o(swipeDismissBehaviorY);
        if (w() == null) {
            eVar.g = 80;
        }
    }

    private boolean V() {
        return this.m > 0 && !this.f && J();
    }

    private void Y() {
        if (U()) {
            q();
            return;
        }
        if (this.c.getParent() != null) {
            this.c.setVisibility(0);
        }
        O();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        ValueAnimator valueAnimatorV = v(0.0f, 1.0f);
        ValueAnimator valueAnimatorZ = z(0.8f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(valueAnimatorV, valueAnimatorZ);
        animatorSet.setDuration(150L);
        animatorSet.addListener(new p());
        animatorSet.start();
    }

    private void a0(int i2) {
        ValueAnimator valueAnimatorV = v(1.0f, 0.0f);
        valueAnimatorV.setDuration(75L);
        valueAnimatorV.addListener(new a(i2));
        valueAnimatorV.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0() {
        int iC = C();
        if (u) {
            AbstractC12990fW7.a0(this.c, iC);
        } else {
            this.c.setTranslationY(iC);
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(iC, 0);
        valueAnimator.setInterpolator(AbstractC6732Ot.b);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new d());
        valueAnimator.addUpdateListener(new e(iC));
        valueAnimator.start();
    }

    private void c0(int i2) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(0, C());
        valueAnimator.setInterpolator(AbstractC6732Ot.b);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new f(i2));
        valueAnimator.addUpdateListener(new g());
        valueAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0() {
        ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams) || this.c.i == null) {
            Log.w(w, "Unable to update margins because layout params are not MarginLayoutParams");
            return;
        }
        if (this.c.getParent() == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.bottomMargin = this.c.i.bottom + (w() != null ? this.n : this.j);
        marginLayoutParams.leftMargin = this.c.i.left + this.k;
        marginLayoutParams.rightMargin = this.c.i.right + this.l;
        marginLayoutParams.topMargin = this.c.i.top;
        this.c.requestLayout();
        if (Build.VERSION.SDK_INT < 29 || !V()) {
            return;
        }
        this.c.removeCallbacks(this.i);
        this.c.post(this.i);
    }

    private void r(int i2) {
        if (this.c.getAnimationMode() == 1) {
            a0(i2);
        } else {
            c0(i2);
        }
    }

    private int s() {
        if (w() == null) {
            return 0;
        }
        int[] iArr = new int[2];
        w().getLocationOnScreen(iArr);
        int i2 = iArr[1];
        int[] iArr2 = new int[2];
        this.a.getLocationOnScreen(iArr2);
        return (iArr2[1] + this.a.getHeight()) - i2;
    }

    private ValueAnimator v(float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(AbstractC6732Ot.a);
        valueAnimatorOfFloat.addUpdateListener(new b());
        return valueAnimatorOfFloat;
    }

    private ValueAnimator z(float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(AbstractC6732Ot.d);
        valueAnimatorOfFloat.addUpdateListener(new c());
        return valueAnimatorOfFloat;
    }

    protected int B() {
        return F() ? YC5.mtrl_layout_snackbar : YC5.design_layout_snackbar;
    }

    public View D() {
        return this.c;
    }

    protected boolean F() {
        TypedArray typedArrayObtainStyledAttributes = this.b.obtainStyledAttributes(v);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId != -1;
    }

    final void G(int i2) {
        if (U() && this.c.getVisibility() == 0) {
            r(i2);
        } else {
            N(i2);
        }
    }

    public boolean H() {
        return com.google.android.material.snackbar.a.c().e(this.s);
    }

    public boolean I() {
        return com.google.android.material.snackbar.a.c().f(this.s);
    }

    void K() {
        WindowInsets rootWindowInsets;
        if (Build.VERSION.SDK_INT < 29 || (rootWindowInsets = this.c.getRootWindowInsets()) == null) {
            return;
        }
        this.m = rootWindowInsets.getMandatorySystemGestureInsets().bottom;
        d0();
    }

    void L() {
        if (I()) {
            t.post(new m());
        }
    }

    void M() {
        if (this.o) {
            Y();
            this.o = false;
        }
    }

    void N(int i2) {
        com.google.android.material.snackbar.a.c().i(this.s);
        List list = this.p;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((r) this.p.get(size)).a(this, i2);
            }
        }
        ViewParent parent = this.c.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.c);
        }
    }

    void O() {
        com.google.android.material.snackbar.a.c().j(this.s);
        List list = this.p;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((r) this.p.get(size)).b(this);
            }
        }
    }

    public BaseTransientBottomBar Q(View view) {
        q qVar = this.g;
        if (qVar != null) {
            qVar.c();
        }
        this.g = view == null ? null : q.a(this, view);
        return this;
    }

    public BaseTransientBottomBar R(int i2) {
        this.c.setAnimationMode(i2);
        return this;
    }

    public BaseTransientBottomBar S(int i2) {
        this.e = i2;
        return this;
    }

    boolean U() {
        AccessibilityManager accessibilityManager = this.r;
        if (accessibilityManager == null) {
            return true;
        }
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(1);
        return enabledAccessibilityServiceList != null && enabledAccessibilityServiceList.isEmpty();
    }

    public void W() {
        com.google.android.material.snackbar.a.c().n(x(), this.s);
    }

    final void X() {
        if (this.c.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.e) {
                T((CoordinatorLayout.e) layoutParams);
            }
            this.c.c(this.a);
            P();
            this.c.setVisibility(4);
        }
        if (AbstractC12990fW7.T(this.c)) {
            Y();
        } else {
            this.o = true;
        }
    }

    public BaseTransientBottomBar p(r rVar) {
        if (rVar == null) {
            return this;
        }
        if (this.p == null) {
            this.p = new ArrayList();
        }
        this.p.add(rVar);
        return this;
    }

    void q() {
        this.c.post(new o());
    }

    public void t() {
        u(3);
    }

    protected void u(int i2) {
        com.google.android.material.snackbar.a.c().b(this.s, i2);
    }

    public View w() {
        q qVar = this.g;
        if (qVar == null) {
            return null;
        }
        return qVar.b();
    }

    public int x() {
        return this.e;
    }

    protected SwipeDismissBehavior y() {
        return new Behavior();
    }
}
