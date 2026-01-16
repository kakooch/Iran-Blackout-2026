package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.g;
import androidx.appcompat.widget.k;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.d;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.stateful.ExtendableSavedState;
import ir.nasim.AbstractC10402bY7;
import ir.nasim.AbstractC12181eA5;
import ir.nasim.AbstractC12799fB5;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC17750nV3;
import ir.nasim.AbstractC20604sI1;
import ir.nasim.AbstractC21175tE5;
import ir.nasim.AbstractC21710u02;
import ir.nasim.AbstractC4980Hj5;
import ir.nasim.AbstractC5729Ko7;
import ir.nasim.AbstractC9751aV3;
import ir.nasim.C11411cx6;
import ir.nasim.C15470je2;
import ir.nasim.C15532jk4;
import ir.nasim.GE5;
import ir.nasim.InterfaceC14881ie2;
import ir.nasim.InterfaceC16236kv7;
import ir.nasim.InterfaceC4873Gx6;
import ir.nasim.InterfaceC6766Ow6;
import java.util.List;

/* loaded from: classes3.dex */
public class FloatingActionButton extends VisibilityAwareImageButton implements InterfaceC14881ie2, InterfaceC4873Gx6, CoordinatorLayout.b {
    private static final int r = AbstractC21175tE5.Widget_Design_FloatingActionButton;
    private ColorStateList b;
    private PorterDuff.Mode c;
    private ColorStateList d;
    private PorterDuff.Mode e;
    private ColorStateList f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    boolean l;
    final Rect m;
    private final Rect n;
    private final k o;
    private final C15470je2 p;
    private com.google.android.material.floatingactionbutton.d q;

    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        /* renamed from: E */
        public /* bridge */ /* synthetic */ boolean b(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            return super.b(coordinatorLayout, floatingActionButton, rect);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        /* renamed from: H */
        public /* bridge */ /* synthetic */ boolean h(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            return super.h(coordinatorLayout, floatingActionButton, view);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        /* renamed from: I */
        public /* bridge */ /* synthetic */ boolean l(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i) {
            return super.l(coordinatorLayout, floatingActionButton, i);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void g(CoordinatorLayout.e eVar) {
            super.g(eVar);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    class a implements d.k {
        final /* synthetic */ b a;

        a(b bVar) {
            this.a = bVar;
        }

        @Override // com.google.android.material.floatingactionbutton.d.k
        public void b() {
            this.a.b(FloatingActionButton.this);
        }

        @Override // com.google.android.material.floatingactionbutton.d.k
        public void c() {
            this.a.a(FloatingActionButton.this);
        }
    }

    public static abstract class b {
        public void a(FloatingActionButton floatingActionButton) {
        }

        public void b(FloatingActionButton floatingActionButton) {
        }
    }

    private class c implements InterfaceC6766Ow6 {
        c() {
        }

        @Override // ir.nasim.InterfaceC6766Ow6
        public void a(int i, int i2, int i3, int i4) {
            FloatingActionButton.this.m.set(i, i2, i3, i4);
            FloatingActionButton floatingActionButton = FloatingActionButton.this;
            floatingActionButton.setPadding(i + floatingActionButton.j, i2 + FloatingActionButton.this.j, i3 + FloatingActionButton.this.j, i4 + FloatingActionButton.this.j);
        }

        @Override // ir.nasim.InterfaceC6766Ow6
        public boolean b() {
            return FloatingActionButton.this.l;
        }

        @Override // ir.nasim.InterfaceC6766Ow6
        public void c(Drawable drawable) {
            if (drawable != null) {
                FloatingActionButton.super.setBackgroundDrawable(drawable);
            }
        }
    }

    class d implements d.j {
        private final InterfaceC16236kv7 a;

        d(InterfaceC16236kv7 interfaceC16236kv7) {
            this.a = interfaceC16236kv7;
        }

        @Override // com.google.android.material.floatingactionbutton.d.j
        public void a() {
            this.a.b(FloatingActionButton.this);
        }

        @Override // com.google.android.material.floatingactionbutton.d.j
        public void b() {
            this.a.a(FloatingActionButton.this);
        }

        public boolean equals(Object obj) {
            return (obj instanceof d) && ((d) obj).a.equals(this.a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    public FloatingActionButton(Context context) {
        this(context, null);
    }

    private com.google.android.material.floatingactionbutton.d getImpl() {
        if (this.q == null) {
            this.q = h();
        }
        return this.q;
    }

    private com.google.android.material.floatingactionbutton.d h() {
        return new e(this, new c());
    }

    private int k(int i) {
        int i2 = this.i;
        if (i2 != 0) {
            return i2;
        }
        Resources resources = getResources();
        return i != -1 ? i != 1 ? resources.getDimensionPixelSize(AbstractC12799fB5.design_fab_size_normal) : resources.getDimensionPixelSize(AbstractC12799fB5.design_fab_size_mini) : Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470 ? k(1) : k(0);
    }

    private void p(Rect rect) {
        int i = rect.left;
        Rect rect2 = this.m;
        rect.left = i + rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
    }

    private void q() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        ColorStateList colorStateList = this.d;
        if (colorStateList == null) {
            AbstractC21710u02.a(drawable);
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode mode = this.e;
        if (mode == null) {
            mode = PorterDuff.Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter(g.e(colorForState, mode));
    }

    private static int r(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE) {
            return Math.min(i, size);
        }
        if (mode == 0) {
            return i;
        }
        if (mode == 1073741824) {
            return size;
        }
        throw new IllegalArgumentException();
    }

    private d.k u(b bVar) {
        if (bVar == null) {
            return null;
        }
        return new a(bVar);
    }

    @Override // ir.nasim.InterfaceC14881ie2
    public boolean a() {
        return this.p.c();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().D(getDrawableState());
    }

    public void e(Animator.AnimatorListener animatorListener) {
        getImpl().e(animatorListener);
    }

    public void f(Animator.AnimatorListener animatorListener) {
        getImpl().f(animatorListener);
    }

    public void g(InterfaceC16236kv7 interfaceC16236kv7) {
        getImpl().g(new d(interfaceC16236kv7));
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return this.b;
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.c;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.Behavior<FloatingActionButton> getBehavior() {
        return new Behavior();
    }

    public float getCompatElevation() {
        return getImpl().m();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().p();
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().s();
    }

    public Drawable getContentBackground() {
        return getImpl().l();
    }

    public int getCustomSize() {
        return this.i;
    }

    public int getExpandedComponentIdHint() {
        return this.p.b();
    }

    public C15532jk4 getHideMotionSpec() {
        return getImpl().o();
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.f;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.f;
    }

    public C11411cx6 getShapeAppearanceModel() {
        return (C11411cx6) AbstractC4980Hj5.g(getImpl().t());
    }

    public C15532jk4 getShowMotionSpec() {
        return getImpl().u();
    }

    public int getSize() {
        return this.h;
    }

    int getSizeDimension() {
        return k(this.h);
    }

    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    public ColorStateList getSupportImageTintList() {
        return this.d;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        return this.e;
    }

    public boolean getUseCompatPadding() {
        return this.l;
    }

    public boolean i(Rect rect) {
        if (!AbstractC12990fW7.T(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        p(rect);
        return true;
    }

    public void j(Rect rect) {
        rect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        p(rect);
    }

    @Override // android.widget.ImageView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().z();
    }

    public void l(b bVar) {
        m(bVar, true);
    }

    void m(b bVar, boolean z) {
        getImpl().v(u(bVar), z);
    }

    public boolean n() {
        return getImpl().x();
    }

    public boolean o() {
        return getImpl().y();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().A();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().C();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        int sizeDimension = getSizeDimension();
        this.j = (sizeDimension - this.k) / 2;
        getImpl().e0();
        int iMin = Math.min(r(sizeDimension, i), r(sizeDimension, i2));
        Rect rect = this.m;
        setMeasuredDimension(rect.left + iMin + rect.right, iMin + rect.top + rect.bottom);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ExtendableSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ExtendableSavedState extendableSavedState = (ExtendableSavedState) parcelable;
        super.onRestoreInstanceState(extendableSavedState.a());
        this.p.d((Bundle) AbstractC4980Hj5.g(extendableSavedState.c.get("expandableWidgetHelper")));
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        if (parcelableOnSaveInstanceState == null) {
            parcelableOnSaveInstanceState = new Bundle();
        }
        ExtendableSavedState extendableSavedState = new ExtendableSavedState(parcelableOnSaveInstanceState);
        extendableSavedState.c.put("expandableWidgetHelper", this.p.e());
        return extendableSavedState;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && i(this.n) && !this.n.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void s(b bVar) {
        t(bVar, true);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.b != colorStateList) {
            this.b = colorStateList;
            getImpl().K(colorStateList);
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.c != mode) {
            this.c = mode;
            getImpl().L(mode);
        }
    }

    public void setCompatElevation(float f) {
        getImpl().M(f);
    }

    public void setCompatElevationResource(int i) {
        setCompatElevation(getResources().getDimension(i));
    }

    public void setCompatHoveredFocusedTranslationZ(float f) {
        getImpl().P(f);
    }

    public void setCompatHoveredFocusedTranslationZResource(int i) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i));
    }

    public void setCompatPressedTranslationZ(float f) {
        getImpl().T(f);
    }

    public void setCompatPressedTranslationZResource(int i) {
        setCompatPressedTranslationZ(getResources().getDimension(i));
    }

    public void setCustomSize(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Custom size must be non-negative");
        }
        if (i != this.i) {
            this.i = i;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        getImpl().f0(f);
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        if (z != getImpl().n()) {
            getImpl().N(z);
            requestLayout();
        }
    }

    public void setExpandedComponentIdHint(int i) {
        this.p.f(i);
    }

    public void setHideMotionSpec(C15532jk4 c15532jk4) {
        getImpl().O(c15532jk4);
    }

    public void setHideMotionSpecResource(int i) {
        setHideMotionSpec(C15532jk4.d(getContext(), i));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            getImpl().d0();
            if (this.d != null) {
                q();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.o.i(i);
        q();
    }

    public void setMaxImageSize(int i) {
        this.k = i;
        getImpl().R(i);
    }

    public void setRippleColor(int i) {
        setRippleColor(ColorStateList.valueOf(i));
    }

    @Override // android.view.View
    public void setScaleX(float f) {
        super.setScaleX(f);
        getImpl().H();
    }

    @Override // android.view.View
    public void setScaleY(float f) {
        super.setScaleY(f);
        getImpl().H();
    }

    public void setShadowPaddingEnabled(boolean z) {
        getImpl().V(z);
    }

    @Override // ir.nasim.InterfaceC4873Gx6
    public void setShapeAppearanceModel(C11411cx6 c11411cx6) {
        getImpl().W(c11411cx6);
    }

    public void setShowMotionSpec(C15532jk4 c15532jk4) {
        getImpl().X(c15532jk4);
    }

    public void setShowMotionSpecResource(int i) {
        setShowMotionSpec(C15532jk4.d(getContext(), i));
    }

    public void setSize(int i) {
        this.i = 0;
        if (i != this.h) {
            this.h = i;
            requestLayout();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.d != colorStateList) {
            this.d = colorStateList;
            q();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.e != mode) {
            this.e = mode;
            q();
        }
    }

    @Override // android.view.View
    public void setTranslationX(float f) {
        super.setTranslationX(f);
        getImpl().I();
    }

    @Override // android.view.View
    public void setTranslationY(float f) {
        super.setTranslationY(f);
        getImpl().I();
    }

    @Override // android.view.View
    public void setTranslationZ(float f) {
        super.setTranslationZ(f);
        getImpl().I();
    }

    public void setUseCompatPadding(boolean z) {
        if (this.l != z) {
            this.l = z;
            getImpl().B();
        }
    }

    @Override // com.google.android.material.internal.VisibilityAwareImageButton, android.widget.ImageView, android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    void t(b bVar, boolean z) {
        getImpl().b0(u(bVar), z);
    }

    protected static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.Behavior<T> {
        private Rect a;
        private b b;
        private boolean c;

        public BaseBehavior() {
            this.c = true;
        }

        private static boolean F(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.e) {
                return ((CoordinatorLayout.e) layoutParams).f() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private void G(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            Rect rect = floatingActionButton.m;
            if (rect == null || rect.centerX() <= 0 || rect.centerY() <= 0) {
                return;
            }
            CoordinatorLayout.e eVar = (CoordinatorLayout.e) floatingActionButton.getLayoutParams();
            int i = 0;
            int i2 = floatingActionButton.getRight() >= coordinatorLayout.getWidth() - ((ViewGroup.MarginLayoutParams) eVar).rightMargin ? rect.right : floatingActionButton.getLeft() <= ((ViewGroup.MarginLayoutParams) eVar).leftMargin ? -rect.left : 0;
            if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin) {
                i = rect.bottom;
            } else if (floatingActionButton.getTop() <= ((ViewGroup.MarginLayoutParams) eVar).topMargin) {
                i = -rect.top;
            }
            if (i != 0) {
                AbstractC12990fW7.a0(floatingActionButton, i);
            }
            if (i2 != 0) {
                AbstractC12990fW7.Z(floatingActionButton, i2);
            }
        }

        private boolean J(View view, FloatingActionButton floatingActionButton) {
            return this.c && ((CoordinatorLayout.e) floatingActionButton.getLayoutParams()).e() == view.getId() && floatingActionButton.getUserSetVisibility() == 0;
        }

        private boolean K(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!J(appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.a == null) {
                this.a = new Rect();
            }
            Rect rect = this.a;
            AbstractC20604sI1.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.m(this.b, false);
                return true;
            }
            floatingActionButton.t(this.b, false);
            return true;
        }

        private boolean L(View view, FloatingActionButton floatingActionButton) {
            if (!J(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.e) floatingActionButton.getLayoutParams())).topMargin) {
                floatingActionButton.m(this.b, false);
                return true;
            }
            floatingActionButton.t(this.b, false);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: E, reason: merged with bridge method [inline-methods] */
        public boolean b(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            Rect rect2 = floatingActionButton.m;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: H, reason: merged with bridge method [inline-methods] */
        public boolean h(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                K(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
                return false;
            }
            if (!F(view)) {
                return false;
            }
            L(view, floatingActionButton);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: I, reason: merged with bridge method [inline-methods] */
        public boolean l(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i) {
            List listU = coordinatorLayout.u(floatingActionButton);
            int size = listU.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = (View) listU.get(i2);
                if (!(view instanceof AppBarLayout)) {
                    if (F(view) && L(view, floatingActionButton)) {
                        break;
                    }
                } else {
                    if (K(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.M(floatingActionButton, i);
            G(coordinatorLayout, floatingActionButton);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void g(CoordinatorLayout.e eVar) {
            if (eVar.h == 0) {
                eVar.h = 80;
            }
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, GE5.FloatingActionButton_Behavior_Layout);
            this.c = typedArrayObtainStyledAttributes.getBoolean(GE5.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC12181eA5.floatingActionButtonStyle);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.f != colorStateList) {
            this.f = colorStateList;
            getImpl().U(this.f);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public FloatingActionButton(Context context, AttributeSet attributeSet, int i) throws Resources.NotFoundException {
        int i2 = r;
        super(AbstractC17750nV3.c(context, attributeSet, i, i2), attributeSet, i);
        this.m = new Rect();
        this.n = new Rect();
        Context context2 = getContext();
        TypedArray typedArrayH = AbstractC5729Ko7.h(context2, attributeSet, GE5.FloatingActionButton, i, i2, new int[0]);
        this.b = AbstractC9751aV3.a(context2, typedArrayH, GE5.FloatingActionButton_backgroundTint);
        this.c = AbstractC10402bY7.k(typedArrayH.getInt(GE5.FloatingActionButton_backgroundTintMode, -1), null);
        this.f = AbstractC9751aV3.a(context2, typedArrayH, GE5.FloatingActionButton_rippleColor);
        this.h = typedArrayH.getInt(GE5.FloatingActionButton_fabSize, -1);
        this.i = typedArrayH.getDimensionPixelSize(GE5.FloatingActionButton_fabCustomSize, 0);
        this.g = typedArrayH.getDimensionPixelSize(GE5.FloatingActionButton_borderWidth, 0);
        float dimension = typedArrayH.getDimension(GE5.FloatingActionButton_elevation, 0.0f);
        float dimension2 = typedArrayH.getDimension(GE5.FloatingActionButton_hoveredFocusedTranslationZ, 0.0f);
        float dimension3 = typedArrayH.getDimension(GE5.FloatingActionButton_pressedTranslationZ, 0.0f);
        this.l = typedArrayH.getBoolean(GE5.FloatingActionButton_useCompatPadding, false);
        int dimensionPixelSize = getResources().getDimensionPixelSize(AbstractC12799fB5.mtrl_fab_min_touch_target);
        setMaxImageSize(typedArrayH.getDimensionPixelSize(GE5.FloatingActionButton_maxImageSize, 0));
        C15532jk4 c15532jk4C = C15532jk4.c(context2, typedArrayH, GE5.FloatingActionButton_showMotionSpec);
        C15532jk4 c15532jk4C2 = C15532jk4.c(context2, typedArrayH, GE5.FloatingActionButton_hideMotionSpec);
        C11411cx6 c11411cx6M = C11411cx6.g(context2, attributeSet, i, i2, C11411cx6.m).m();
        boolean z = typedArrayH.getBoolean(GE5.FloatingActionButton_ensureMinTouchTargetSize, false);
        setEnabled(typedArrayH.getBoolean(GE5.FloatingActionButton_android_enabled, true));
        typedArrayH.recycle();
        k kVar = new k(this);
        this.o = kVar;
        kVar.g(attributeSet, i);
        this.p = new C15470je2(this);
        getImpl().W(c11411cx6M);
        getImpl().w(this.b, this.c, this.f, this.g);
        getImpl().S(dimensionPixelSize);
        getImpl().M(dimension);
        getImpl().P(dimension2);
        getImpl().T(dimension3);
        getImpl().X(c15532jk4C);
        getImpl().O(c15532jk4C2);
        getImpl().N(z);
        setScaleType(ImageView.ScaleType.MATRIX);
    }
}
