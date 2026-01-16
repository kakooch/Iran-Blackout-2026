package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import ir.nasim.AbstractC10402bY7;
import ir.nasim.AbstractC10961cV3;
import ir.nasim.AbstractC12181eA5;
import ir.nasim.AbstractC12799fB5;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC17750nV3;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.AbstractC21175tE5;
import ir.nasim.AbstractC21710u02;
import ir.nasim.AbstractC5729Ko7;
import ir.nasim.AbstractC9564aA5;
import ir.nasim.AbstractC9751aV3;
import ir.nasim.C10345bV3;
import ir.nasim.C11411cx6;
import ir.nasim.GE5;
import ir.nasim.InterfaceC16236kv7;
import ir.nasim.O98;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout.b {
    private static final int j1 = AbstractC21175tE5.Widget_MaterialComponents_BottomAppBar;
    private Integer N0;
    private final int O0;
    private final C10345bV3 P0;
    private Animator Q0;
    private Animator R0;
    private int S0;
    private int T0;
    private boolean U0;
    private final boolean V0;
    private final boolean W0;
    private final boolean X0;
    private int Y0;
    private ArrayList Z0;
    private int a1;
    private boolean b1;
    private boolean c1;
    private Behavior d1;
    private int e1;
    private int f1;
    private int g1;
    AnimatorListenerAdapter h1;
    InterfaceC16236kv7 i1;

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        int c;
        boolean d;

        class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.c);
            parcel.writeInt(this.d ? 1 : 0);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.c = parcel.readInt();
            this.d = parcel.readInt() != 0;
        }
    }

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (BottomAppBar.this.b1) {
                return;
            }
            BottomAppBar bottomAppBar = BottomAppBar.this;
            bottomAppBar.I0(bottomAppBar.S0, BottomAppBar.this.c1);
        }
    }

    class b implements InterfaceC16236kv7 {
        b() {
        }

        @Override // ir.nasim.InterfaceC16236kv7
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(FloatingActionButton floatingActionButton) {
            BottomAppBar.this.P0.c0(floatingActionButton.getVisibility() == 0 ? floatingActionButton.getScaleY() : 0.0f);
        }

        @Override // ir.nasim.InterfaceC16236kv7
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(FloatingActionButton floatingActionButton) {
            float translationX = floatingActionButton.getTranslationX();
            if (BottomAppBar.this.getTopEdgeTreatment().k() != translationX) {
                BottomAppBar.this.getTopEdgeTreatment().q(translationX);
                BottomAppBar.this.P0.invalidateSelf();
            }
            float fMax = Math.max(0.0f, -floatingActionButton.getTranslationY());
            if (BottomAppBar.this.getTopEdgeTreatment().d() != fMax) {
                BottomAppBar.this.getTopEdgeTreatment().l(fMax);
                BottomAppBar.this.P0.invalidateSelf();
            }
            BottomAppBar.this.P0.c0(floatingActionButton.getVisibility() == 0 ? floatingActionButton.getScaleY() : 0.0f);
        }
    }

    class c implements AbstractC10402bY7.e {
        c() {
        }

        @Override // ir.nasim.AbstractC10402bY7.e
        public O98 a(View view, O98 o98, AbstractC10402bY7.f fVar) {
            boolean z;
            if (BottomAppBar.this.V0) {
                BottomAppBar.this.e1 = o98.j();
            }
            boolean z2 = false;
            if (BottomAppBar.this.W0) {
                z = BottomAppBar.this.g1 != o98.k();
                BottomAppBar.this.g1 = o98.k();
            } else {
                z = false;
            }
            if (BottomAppBar.this.X0) {
                boolean z3 = BottomAppBar.this.f1 != o98.l();
                BottomAppBar.this.f1 = o98.l();
                z2 = z3;
            }
            if (z || z2) {
                BottomAppBar.this.x0();
                BottomAppBar.this.N0();
                BottomAppBar.this.M0();
            }
            return o98;
        }
    }

    class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.B0();
            BottomAppBar.this.Q0 = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.C0();
        }
    }

    class e extends FloatingActionButton.b {
        final /* synthetic */ int a;

        class a extends FloatingActionButton.b {
            a() {
            }

            @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.b
            public void b(FloatingActionButton floatingActionButton) {
                BottomAppBar.this.B0();
            }
        }

        e(int i) {
            this.a = i;
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.b
        public void a(FloatingActionButton floatingActionButton) {
            floatingActionButton.setTranslationX(BottomAppBar.this.G0(this.a));
            floatingActionButton.s(new a());
        }
    }

    class f extends AnimatorListenerAdapter {
        f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.B0();
            BottomAppBar.this.b1 = false;
            BottomAppBar.this.R0 = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.C0();
        }
    }

    class g extends AnimatorListenerAdapter {
        public boolean a;
        final /* synthetic */ ActionMenuView b;
        final /* synthetic */ int c;
        final /* synthetic */ boolean d;

        g(ActionMenuView actionMenuView, int i, boolean z) {
            this.b = actionMenuView;
            this.c = i;
            this.d = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.a) {
                return;
            }
            boolean z = BottomAppBar.this.a1 != 0;
            BottomAppBar bottomAppBar = BottomAppBar.this;
            bottomAppBar.L0(bottomAppBar.a1);
            BottomAppBar.this.Q0(this.b, this.c, this.d, z);
        }
    }

    class h implements Runnable {
        final /* synthetic */ ActionMenuView a;
        final /* synthetic */ int b;
        final /* synthetic */ boolean c;

        h(ActionMenuView actionMenuView, int i, boolean z) {
            this.a = actionMenuView;
            this.b = i;
            this.c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.setTranslationX(BottomAppBar.this.F0(r0, this.b, this.c));
        }
    }

    class i extends AnimatorListenerAdapter {
        i() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.h1.onAnimationStart(animator);
            FloatingActionButton floatingActionButtonD0 = BottomAppBar.this.D0();
            if (floatingActionButtonD0 != null) {
                floatingActionButtonD0.setTranslationX(BottomAppBar.this.getFabTranslationX());
            }
        }
    }

    public BottomAppBar(Context context) {
        this(context, null);
    }

    private void A0(int i2, boolean z, List list) {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null) {
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
        if (Math.abs(actionMenuView.getTranslationX() - F0(actionMenuView, i2, z)) <= 1.0f) {
            if (actionMenuView.getAlpha() < 1.0f) {
                list.add(objectAnimatorOfFloat);
            }
        } else {
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(actionMenuView, "alpha", 0.0f);
            objectAnimatorOfFloat2.addListener(new g(actionMenuView, i2, z));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(150L);
            animatorSet.playSequentially(objectAnimatorOfFloat2, objectAnimatorOfFloat);
            list.add(animatorSet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0() {
        ArrayList arrayList;
        int i2 = this.Y0 - 1;
        this.Y0 = i2;
        if (i2 != 0 || (arrayList = this.Z0) == null) {
            return;
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            AbstractC18350oW3.a(it.next());
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0() {
        ArrayList arrayList;
        int i2 = this.Y0;
        this.Y0 = i2 + 1;
        if (i2 != 0 || (arrayList = this.Z0) == null) {
            return;
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            AbstractC18350oW3.a(it.next());
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FloatingActionButton D0() {
        View viewE0 = E0();
        if (viewE0 instanceof FloatingActionButton) {
            return (FloatingActionButton) viewE0;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View E0() {
        if (!(getParent() instanceof CoordinatorLayout)) {
            return null;
        }
        for (View view : ((CoordinatorLayout) getParent()).w(this)) {
            if ((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton)) {
                return view;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float G0(int i2) {
        boolean zJ = AbstractC10402bY7.j(this);
        if (i2 == 1) {
            return ((getMeasuredWidth() / 2) - (this.O0 + (zJ ? this.g1 : this.f1))) * (zJ ? -1 : 1);
        }
        return 0.0f;
    }

    private boolean H0() {
        FloatingActionButton floatingActionButtonD0 = D0();
        return floatingActionButtonD0 != null && floatingActionButtonD0.o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0(int i2, boolean z) {
        if (!AbstractC12990fW7.T(this)) {
            this.b1 = false;
            L0(this.a1);
            return;
        }
        Animator animator = this.R0;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        if (!H0()) {
            i2 = 0;
            z = false;
        }
        A0(i2, z, arrayList);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.R0 = animatorSet;
        animatorSet.addListener(new f());
        this.R0.start();
    }

    private void J0(int i2) {
        if (this.S0 == i2 || !AbstractC12990fW7.T(this)) {
            return;
        }
        Animator animator = this.Q0;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        if (this.T0 == 1) {
            z0(i2, arrayList);
        } else {
            y0(i2, arrayList);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.Q0 = animatorSet;
        animatorSet.addListener(new d());
        this.Q0.start();
    }

    private Drawable K0(Drawable drawable) {
        if (drawable == null || this.N0 == null) {
            return drawable;
        }
        Drawable drawableL = AbstractC21710u02.l(drawable.mutate());
        AbstractC21710u02.h(drawableL, this.N0.intValue());
        return drawableL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M0() {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null || this.R0 != null) {
            return;
        }
        actionMenuView.setAlpha(1.0f);
        if (H0()) {
            P0(actionMenuView, this.S0, this.c1);
        } else {
            P0(actionMenuView, 0, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N0() {
        getTopEdgeTreatment().q(getFabTranslationX());
        View viewE0 = E0();
        this.P0.c0((this.c1 && H0()) ? 1.0f : 0.0f);
        if (viewE0 != null) {
            viewE0.setTranslationY(getFabTranslationY());
            viewE0.setTranslationX(getFabTranslationX());
        }
    }

    private void P0(ActionMenuView actionMenuView, int i2, boolean z) {
        Q0(actionMenuView, i2, z, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q0(ActionMenuView actionMenuView, int i2, boolean z, boolean z2) {
        h hVar = new h(actionMenuView, i2, z);
        if (z2) {
            actionMenuView.post(hVar);
        } else {
            hVar.run();
        }
    }

    private ActionMenuView getActionMenuView() {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getBottomInset() {
        return this.e1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getFabTranslationX() {
        return G0(this.S0);
    }

    private float getFabTranslationY() {
        return -getTopEdgeTreatment().d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getLeftInset() {
        return this.g1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRightInset() {
        return this.f1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.google.android.material.bottomappbar.a getTopEdgeTreatment() {
        return (com.google.android.material.bottomappbar.a) this.P0.E().p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0(FloatingActionButton floatingActionButton) {
        floatingActionButton.e(this.h1);
        floatingActionButton.f(new i());
        floatingActionButton.g(this.i1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0() {
        Animator animator = this.R0;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.Q0;
        if (animator2 != null) {
            animator2.cancel();
        }
    }

    private void z0(int i2, List list) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(D0(), "translationX", G0(i2));
        objectAnimatorOfFloat.setDuration(300L);
        list.add(objectAnimatorOfFloat);
    }

    protected int F0(ActionMenuView actionMenuView, int i2, boolean z) {
        if (i2 != 1 || !z) {
            return 0;
        }
        boolean zJ = AbstractC10402bY7.j(this);
        int measuredWidth = zJ ? getMeasuredWidth() : 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if ((childAt.getLayoutParams() instanceof Toolbar.LayoutParams) && (((Toolbar.LayoutParams) childAt.getLayoutParams()).a & 8388615) == 8388611) {
                measuredWidth = zJ ? Math.min(measuredWidth, childAt.getLeft()) : Math.max(measuredWidth, childAt.getRight());
            }
        }
        return measuredWidth - ((zJ ? actionMenuView.getRight() : actionMenuView.getLeft()) + (zJ ? this.f1 : -this.g1));
    }

    public void L0(int i2) {
        if (i2 != 0) {
            this.a1 = 0;
            getMenu().clear();
            y(i2);
        }
    }

    boolean O0(int i2) {
        float f2 = i2;
        if (f2 == getTopEdgeTreatment().i()) {
            return false;
        }
        getTopEdgeTreatment().p(f2);
        this.P0.invalidateSelf();
        return true;
    }

    public ColorStateList getBackgroundTint() {
        return this.P0.I();
    }

    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().d();
    }

    public int getFabAlignmentMode() {
        return this.S0;
    }

    public int getFabAnimationMode() {
        return this.T0;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().f();
    }

    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().h();
    }

    public boolean getHideOnScroll() {
        return this.U0;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        AbstractC10961cV3.f(this, this.P0);
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).setClipChildren(false);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            x0();
            N0();
        }
        M0();
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        this.S0 = savedState.c;
        this.c1 = savedState.d;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.c = this.S0;
        savedState.d = this.c1;
        return savedState;
    }

    public void setBackgroundTint(ColorStateList colorStateList) {
        AbstractC21710u02.i(this.P0, colorStateList);
    }

    public void setCradleVerticalOffset(float f2) {
        if (f2 != getCradleVerticalOffset()) {
            getTopEdgeTreatment().l(f2);
            this.P0.invalidateSelf();
            N0();
        }
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        this.P0.a0(f2);
        getBehavior().I(this, this.P0.D() - this.P0.C());
    }

    public void setFabAlignmentMode(int i2) {
        setFabAlignmentModeAndReplaceMenu(i2, 0);
    }

    public void setFabAlignmentModeAndReplaceMenu(int i2, int i3) {
        this.a1 = i3;
        this.b1 = true;
        I0(i2, this.c1);
        J0(i2);
        this.S0 = i2;
    }

    public void setFabAnimationMode(int i2) {
        this.T0 = i2;
    }

    void setFabCornerSize(float f2) {
        if (f2 != getTopEdgeTreatment().e()) {
            getTopEdgeTreatment().m(f2);
            this.P0.invalidateSelf();
        }
    }

    public void setFabCradleMargin(float f2) {
        if (f2 != getFabCradleMargin()) {
            getTopEdgeTreatment().n(f2);
            this.P0.invalidateSelf();
        }
    }

    public void setFabCradleRoundedCornerRadius(float f2) {
        if (f2 != getFabCradleRoundedCornerRadius()) {
            getTopEdgeTreatment().o(f2);
            this.P0.invalidateSelf();
        }
    }

    public void setHideOnScroll(boolean z) {
        this.U0 = z;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        super.setNavigationIcon(K0(drawable));
    }

    public void setNavigationIconTint(int i2) {
        this.N0 = Integer.valueOf(i2);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }

    protected void y0(int i2, List list) {
        FloatingActionButton floatingActionButtonD0 = D0();
        if (floatingActionButtonD0 == null || floatingActionButtonD0.n()) {
            return;
        }
        C0();
        floatingActionButtonD0.l(new e(i2));
    }

    public BottomAppBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC12181eA5.bottomAppBarStyle);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public Behavior getBehavior() {
        if (this.d1 == null) {
            this.d1 = new Behavior();
        }
        return this.d1;
    }

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {
        private final Rect e;
        private WeakReference f;
        private int g;
        private final View.OnLayoutChangeListener h;

        class a implements View.OnLayoutChangeListener {
            a() {
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                BottomAppBar bottomAppBar = (BottomAppBar) Behavior.this.f.get();
                if (bottomAppBar == null || !(view instanceof FloatingActionButton)) {
                    view.removeOnLayoutChangeListener(this);
                    return;
                }
                FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                floatingActionButton.j(Behavior.this.e);
                int iHeight = Behavior.this.e.height();
                bottomAppBar.O0(iHeight);
                bottomAppBar.setFabCornerSize(floatingActionButton.getShapeAppearanceModel().r().a(new RectF(Behavior.this.e)));
                CoordinatorLayout.e eVar = (CoordinatorLayout.e) view.getLayoutParams();
                if (Behavior.this.g == 0) {
                    ((ViewGroup.MarginLayoutParams) eVar).bottomMargin = bottomAppBar.getBottomInset() + (bottomAppBar.getResources().getDimensionPixelOffset(AbstractC12799fB5.mtrl_bottomappbar_fab_bottom_margin) - ((floatingActionButton.getMeasuredHeight() - iHeight) / 2));
                    ((ViewGroup.MarginLayoutParams) eVar).leftMargin = bottomAppBar.getLeftInset();
                    ((ViewGroup.MarginLayoutParams) eVar).rightMargin = bottomAppBar.getRightInset();
                    if (AbstractC10402bY7.j(floatingActionButton)) {
                        ((ViewGroup.MarginLayoutParams) eVar).leftMargin += bottomAppBar.O0;
                    } else {
                        ((ViewGroup.MarginLayoutParams) eVar).rightMargin += bottomAppBar.O0;
                    }
                }
            }
        }

        public Behavior() {
            this.h = new a();
            this.e = new Rect();
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: Q, reason: merged with bridge method [inline-methods] */
        public boolean l(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, int i) {
            this.f = new WeakReference(bottomAppBar);
            View viewE0 = bottomAppBar.E0();
            if (viewE0 != null && !AbstractC12990fW7.T(viewE0)) {
                CoordinatorLayout.e eVar = (CoordinatorLayout.e) viewE0.getLayoutParams();
                eVar.d = 49;
                this.g = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
                if (viewE0 instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) viewE0;
                    if (floatingActionButton.getShowMotionSpec() == null) {
                        floatingActionButton.setShowMotionSpecResource(AbstractC9564aA5.mtrl_fab_show_motion_spec);
                    }
                    if (floatingActionButton.getHideMotionSpec() == null) {
                        floatingActionButton.setHideMotionSpecResource(AbstractC9564aA5.mtrl_fab_hide_motion_spec);
                    }
                    floatingActionButton.addOnLayoutChangeListener(this.h);
                    bottomAppBar.w0(floatingActionButton);
                }
                bottomAppBar.N0();
            }
            coordinatorLayout.M(bottomAppBar, i);
            return super.l(coordinatorLayout, bottomAppBar, i);
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: R, reason: merged with bridge method [inline-methods] */
        public boolean A(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, View view, View view2, int i, int i2) {
            return bottomAppBar.getHideOnScroll() && super.A(coordinatorLayout, bottomAppBar, view, view2, i, i2);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.h = new a();
            this.e = new Rect();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public BottomAppBar(Context context, AttributeSet attributeSet, int i2) {
        int i3 = j1;
        super(AbstractC17750nV3.c(context, attributeSet, i2, i3), attributeSet, i2);
        C10345bV3 c10345bV3 = new C10345bV3();
        this.P0 = c10345bV3;
        this.Y0 = 0;
        this.a1 = 0;
        this.b1 = false;
        this.c1 = true;
        this.h1 = new a();
        this.i1 = new b();
        Context context2 = getContext();
        TypedArray typedArrayH = AbstractC5729Ko7.h(context2, attributeSet, GE5.BottomAppBar, i2, i3, new int[0]);
        ColorStateList colorStateListA = AbstractC9751aV3.a(context2, typedArrayH, GE5.BottomAppBar_backgroundTint);
        if (typedArrayH.hasValue(GE5.BottomAppBar_navigationIconTint)) {
            setNavigationIconTint(typedArrayH.getColor(GE5.BottomAppBar_navigationIconTint, -1));
        }
        int dimensionPixelSize = typedArrayH.getDimensionPixelSize(GE5.BottomAppBar_elevation, 0);
        float dimensionPixelOffset = typedArrayH.getDimensionPixelOffset(GE5.BottomAppBar_fabCradleMargin, 0);
        float dimensionPixelOffset2 = typedArrayH.getDimensionPixelOffset(GE5.BottomAppBar_fabCradleRoundedCornerRadius, 0);
        float dimensionPixelOffset3 = typedArrayH.getDimensionPixelOffset(GE5.BottomAppBar_fabCradleVerticalOffset, 0);
        this.S0 = typedArrayH.getInt(GE5.BottomAppBar_fabAlignmentMode, 0);
        this.T0 = typedArrayH.getInt(GE5.BottomAppBar_fabAnimationMode, 0);
        this.U0 = typedArrayH.getBoolean(GE5.BottomAppBar_hideOnScroll, false);
        this.V0 = typedArrayH.getBoolean(GE5.BottomAppBar_paddingBottomSystemWindowInsets, false);
        this.W0 = typedArrayH.getBoolean(GE5.BottomAppBar_paddingLeftSystemWindowInsets, false);
        this.X0 = typedArrayH.getBoolean(GE5.BottomAppBar_paddingRightSystemWindowInsets, false);
        typedArrayH.recycle();
        this.O0 = getResources().getDimensionPixelOffset(AbstractC12799fB5.mtrl_bottomappbar_fabOffsetEndMode);
        c10345bV3.setShapeAppearanceModel(C11411cx6.a().D(new com.google.android.material.bottomappbar.a(dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3)).m());
        c10345bV3.i0(2);
        c10345bV3.e0(Paint.Style.FILL);
        c10345bV3.Q(context2);
        setElevation(dimensionPixelSize);
        AbstractC21710u02.i(c10345bV3, colorStateListA);
        AbstractC12990fW7.t0(this, c10345bV3);
        AbstractC10402bY7.b(this, attributeSet, i2, i3, new c());
    }
}
