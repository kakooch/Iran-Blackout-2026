package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import ir.nasim.AbstractC12181eA5;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC17750nV3;
import ir.nasim.AbstractC20604sI1;
import ir.nasim.AbstractC21175tE5;
import ir.nasim.AbstractC5729Ko7;
import ir.nasim.AbstractC9564aA5;
import ir.nasim.C11411cx6;
import ir.nasim.C15532jk4;
import ir.nasim.GE5;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.b {
    private static final int A0 = AbstractC21175tE5.Widget_MaterialComponents_ExtendedFloatingActionButton_Icon;
    static final Property B0 = new d(Float.class, "width");
    static final Property C0 = new e(Float.class, "height");
    static final Property D0 = new f(Float.class, "paddingStart");
    static final Property E0 = new g(Float.class, "paddingEnd");
    private int A;
    private int B;
    private final CoordinatorLayout.Behavior D;
    private boolean G;
    private boolean H;
    private boolean J;
    private int t;
    private final com.google.android.material.floatingactionbutton.a u;
    private final com.google.android.material.floatingactionbutton.f v;
    private final com.google.android.material.floatingactionbutton.f w;
    private final com.google.android.material.floatingactionbutton.f x;
    private final com.google.android.material.floatingactionbutton.f y;
    private final int z;
    protected ColorStateList z0;

    class a implements l {
        a() {
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int getHeight() {
            return ExtendedFloatingActionButton.this.getMeasuredHeight();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int getWidth() {
            return (ExtendedFloatingActionButton.this.getMeasuredWidth() - (ExtendedFloatingActionButton.this.getCollapsedPadding() * 2)) + ExtendedFloatingActionButton.this.A + ExtendedFloatingActionButton.this.B;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public ViewGroup.LayoutParams o() {
            return new ViewGroup.LayoutParams(-2, -2);
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int p() {
            return ExtendedFloatingActionButton.this.B;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int q() {
            return ExtendedFloatingActionButton.this.A;
        }
    }

    class b implements l {
        b() {
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int getHeight() {
            return ExtendedFloatingActionButton.this.getCollapsedSize();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int getWidth() {
            return ExtendedFloatingActionButton.this.getCollapsedSize();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public ViewGroup.LayoutParams o() {
            return new ViewGroup.LayoutParams(getWidth(), getHeight());
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int p() {
            return ExtendedFloatingActionButton.this.getCollapsedPadding();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int q() {
            return ExtendedFloatingActionButton.this.getCollapsedPadding();
        }
    }

    class c extends AnimatorListenerAdapter {
        private boolean a;
        final /* synthetic */ com.google.android.material.floatingactionbutton.f b;

        c(com.google.android.material.floatingactionbutton.f fVar, j jVar) {
            this.b = fVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.a = true;
            this.b.g();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.b.a();
            if (this.a) {
                return;
            }
            this.b.j(null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.b.onAnimationStart(animator);
            this.a = false;
        }
    }

    class d extends Property {
        d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(view.getLayoutParams().width);
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f) {
            view.getLayoutParams().width = f.intValue();
            view.requestLayout();
        }
    }

    class e extends Property {
        e(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(view.getLayoutParams().height);
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f) {
            view.getLayoutParams().height = f.intValue();
            view.requestLayout();
        }
    }

    class f extends Property {
        f(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(AbstractC12990fW7.F(view));
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f) {
            AbstractC12990fW7.F0(view, f.intValue(), view.getPaddingTop(), AbstractC12990fW7.E(view), view.getPaddingBottom());
        }
    }

    class g extends Property {
        g(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(AbstractC12990fW7.E(view));
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f) {
            AbstractC12990fW7.F0(view, AbstractC12990fW7.F(view), view.getPaddingTop(), f.intValue(), view.getPaddingBottom());
        }
    }

    class h extends com.google.android.material.floatingactionbutton.b {
        private final l g;
        private final boolean h;

        h(com.google.android.material.floatingactionbutton.a aVar, l lVar, boolean z) {
            super(ExtendedFloatingActionButton.this, aVar);
            this.g = lVar;
            this.h = z;
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void a() {
            super.a();
            ExtendedFloatingActionButton.this.H = false;
            ExtendedFloatingActionButton.this.setHorizontallyScrolling(false);
            ViewGroup.LayoutParams layoutParams = ExtendedFloatingActionButton.this.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            layoutParams.width = this.g.o().width;
            layoutParams.height = this.g.o().height;
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public void c() {
            ExtendedFloatingActionButton.this.G = this.h;
            ViewGroup.LayoutParams layoutParams = ExtendedFloatingActionButton.this.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            layoutParams.width = this.g.o().width;
            layoutParams.height = this.g.o().height;
            AbstractC12990fW7.F0(ExtendedFloatingActionButton.this, this.g.q(), ExtendedFloatingActionButton.this.getPaddingTop(), this.g.p(), ExtendedFloatingActionButton.this.getPaddingBottom());
            ExtendedFloatingActionButton.this.requestLayout();
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public boolean e() {
            return this.h == ExtendedFloatingActionButton.this.G || ExtendedFloatingActionButton.this.getIcon() == null || TextUtils.isEmpty(ExtendedFloatingActionButton.this.getText());
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public int h() {
            return this.h ? AbstractC9564aA5.mtrl_extended_fab_change_size_expand_motion_spec : AbstractC9564aA5.mtrl_extended_fab_change_size_collapse_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public AnimatorSet i() {
            C15532jk4 c15532jk4M = m();
            if (c15532jk4M.j("width")) {
                PropertyValuesHolder[] propertyValuesHolderArrG = c15532jk4M.g("width");
                propertyValuesHolderArrG[0].setFloatValues(ExtendedFloatingActionButton.this.getWidth(), this.g.getWidth());
                c15532jk4M.l("width", propertyValuesHolderArrG);
            }
            if (c15532jk4M.j("height")) {
                PropertyValuesHolder[] propertyValuesHolderArrG2 = c15532jk4M.g("height");
                propertyValuesHolderArrG2[0].setFloatValues(ExtendedFloatingActionButton.this.getHeight(), this.g.getHeight());
                c15532jk4M.l("height", propertyValuesHolderArrG2);
            }
            if (c15532jk4M.j("paddingStart")) {
                PropertyValuesHolder[] propertyValuesHolderArrG3 = c15532jk4M.g("paddingStart");
                propertyValuesHolderArrG3[0].setFloatValues(AbstractC12990fW7.F(ExtendedFloatingActionButton.this), this.g.q());
                c15532jk4M.l("paddingStart", propertyValuesHolderArrG3);
            }
            if (c15532jk4M.j("paddingEnd")) {
                PropertyValuesHolder[] propertyValuesHolderArrG4 = c15532jk4M.g("paddingEnd");
                propertyValuesHolderArrG4[0].setFloatValues(AbstractC12990fW7.E(ExtendedFloatingActionButton.this), this.g.p());
                c15532jk4M.l("paddingEnd", propertyValuesHolderArrG4);
            }
            if (c15532jk4M.j("labelOpacity")) {
                PropertyValuesHolder[] propertyValuesHolderArrG5 = c15532jk4M.g("labelOpacity");
                boolean z = this.h;
                propertyValuesHolderArrG5[0].setFloatValues(z ? 0.0f : 1.0f, z ? 1.0f : 0.0f);
                c15532jk4M.l("labelOpacity", propertyValuesHolderArrG5);
            }
            return super.l(c15532jk4M);
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public void j(j jVar) {
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            ExtendedFloatingActionButton.this.G = this.h;
            ExtendedFloatingActionButton.this.H = true;
            ExtendedFloatingActionButton.this.setHorizontallyScrolling(true);
        }
    }

    class i extends com.google.android.material.floatingactionbutton.b {
        private boolean g;

        public i(com.google.android.material.floatingactionbutton.a aVar) {
            super(ExtendedFloatingActionButton.this, aVar);
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void a() {
            super.a();
            ExtendedFloatingActionButton.this.t = 0;
            if (this.g) {
                return;
            }
            ExtendedFloatingActionButton.this.setVisibility(8);
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public void c() {
            ExtendedFloatingActionButton.this.setVisibility(8);
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public boolean e() {
            return ExtendedFloatingActionButton.this.w();
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void g() {
            super.g();
            this.g = true;
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public int h() {
            return AbstractC9564aA5.mtrl_extended_fab_hide_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public void j(j jVar) {
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            this.g = false;
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.t = 1;
        }
    }

    public static abstract class j {
    }

    class k extends com.google.android.material.floatingactionbutton.b {
        public k(com.google.android.material.floatingactionbutton.a aVar) {
            super(ExtendedFloatingActionButton.this, aVar);
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void a() {
            super.a();
            ExtendedFloatingActionButton.this.t = 0;
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public void c() {
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.setAlpha(1.0f);
            ExtendedFloatingActionButton.this.setScaleY(1.0f);
            ExtendedFloatingActionButton.this.setScaleX(1.0f);
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public boolean e() {
            return ExtendedFloatingActionButton.this.x();
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public int h() {
            return AbstractC9564aA5.mtrl_extended_fab_show_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public void j(j jVar) {
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.t = 2;
        }
    }

    interface l {
        int getHeight();

        int getWidth();

        ViewGroup.LayoutParams o();

        int p();

        int q();
    }

    public ExtendedFloatingActionButton(Context context) {
        this(context, null);
    }

    private boolean A() {
        return (AbstractC12990fW7.T(this) || (!x() && this.J)) && !isInEditMode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean w() {
        return getVisibility() == 0 ? this.t == 1 : this.t != 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean x() {
        return getVisibility() != 0 ? this.t == 2 : this.t != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(com.google.android.material.floatingactionbutton.f fVar, j jVar) {
        if (fVar.e()) {
            return;
        }
        if (!A()) {
            fVar.c();
            fVar.j(jVar);
            return;
        }
        measure(0, 0);
        AnimatorSet animatorSetI = fVar.i();
        animatorSetI.addListener(new c(fVar, jVar));
        Iterator it = fVar.b().iterator();
        while (it.hasNext()) {
            animatorSetI.addListener((Animator.AnimatorListener) it.next());
        }
        animatorSetI.start();
    }

    private void z() {
        this.z0 = getTextColors();
    }

    protected void B(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.Behavior<ExtendedFloatingActionButton> getBehavior() {
        return this.D;
    }

    int getCollapsedPadding() {
        return (getCollapsedSize() - getIconSize()) / 2;
    }

    int getCollapsedSize() {
        int i2 = this.z;
        return i2 < 0 ? (Math.min(AbstractC12990fW7.F(this), AbstractC12990fW7.E(this)) * 2) + getIconSize() : i2;
    }

    public C15532jk4 getExtendMotionSpec() {
        return this.w.d();
    }

    public C15532jk4 getHideMotionSpec() {
        return this.y.d();
    }

    public C15532jk4 getShowMotionSpec() {
        return this.x.d();
    }

    public C15532jk4 getShrinkMotionSpec() {
        return this.v.d();
    }

    @Override // com.google.android.material.button.MaterialButton, android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.G && TextUtils.isEmpty(getText()) && getIcon() != null) {
            this.G = false;
            this.v.c();
        }
    }

    public void setAnimateShowBeforeLayout(boolean z) {
        this.J = z;
    }

    public void setExtendMotionSpec(C15532jk4 c15532jk4) {
        this.w.f(c15532jk4);
    }

    public void setExtendMotionSpecResource(int i2) {
        setExtendMotionSpec(C15532jk4.d(getContext(), i2));
    }

    public void setExtended(boolean z) {
        if (this.G == z) {
            return;
        }
        com.google.android.material.floatingactionbutton.f fVar = z ? this.w : this.v;
        if (fVar.e()) {
            return;
        }
        fVar.c();
    }

    public void setHideMotionSpec(C15532jk4 c15532jk4) {
        this.y.f(c15532jk4);
    }

    public void setHideMotionSpecResource(int i2) {
        setHideMotionSpec(C15532jk4.d(getContext(), i2));
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i2, int i3, int i4, int i5) {
        super.setPadding(i2, i3, i4, i5);
        if (!this.G || this.H) {
            return;
        }
        this.A = AbstractC12990fW7.F(this);
        this.B = AbstractC12990fW7.E(this);
    }

    @Override // android.widget.TextView, android.view.View
    public void setPaddingRelative(int i2, int i3, int i4, int i5) {
        super.setPaddingRelative(i2, i3, i4, i5);
        if (!this.G || this.H) {
            return;
        }
        this.A = i2;
        this.B = i4;
    }

    public void setShowMotionSpec(C15532jk4 c15532jk4) {
        this.x.f(c15532jk4);
    }

    public void setShowMotionSpecResource(int i2) {
        setShowMotionSpec(C15532jk4.d(getContext(), i2));
    }

    public void setShrinkMotionSpec(C15532jk4 c15532jk4) {
        this.v.f(c15532jk4);
    }

    public void setShrinkMotionSpecResource(int i2) {
        setShrinkMotionSpec(C15532jk4.d(getContext(), i2));
    }

    @Override // android.widget.TextView
    public void setTextColor(int i2) {
        super.setTextColor(i2);
        z();
    }

    public ExtendedFloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC12181eA5.extendedFloatingActionButtonStyle);
    }

    protected static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.Behavior<T> {
        private Rect a;
        private boolean b;
        private boolean c;

        public ExtendedFloatingActionButtonBehavior() {
            this.b = false;
            this.c = true;
        }

        private static boolean G(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.e) {
                return ((CoordinatorLayout.e) layoutParams).f() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private boolean J(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            return (this.b || this.c) && ((CoordinatorLayout.e) extendedFloatingActionButton.getLayoutParams()).e() == view.getId();
        }

        private boolean L(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!J(appBarLayout, extendedFloatingActionButton)) {
                return false;
            }
            if (this.a == null) {
                this.a = new Rect();
            }
            Rect rect = this.a;
            AbstractC20604sI1.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                K(extendedFloatingActionButton);
                return true;
            }
            E(extendedFloatingActionButton);
            return true;
        }

        private boolean M(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!J(view, extendedFloatingActionButton)) {
                return false;
            }
            if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.e) extendedFloatingActionButton.getLayoutParams())).topMargin) {
                K(extendedFloatingActionButton);
                return true;
            }
            E(extendedFloatingActionButton);
            return true;
        }

        protected void E(ExtendedFloatingActionButton extendedFloatingActionButton) {
            extendedFloatingActionButton.y(this.c ? extendedFloatingActionButton.w : extendedFloatingActionButton.x, null);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: F, reason: merged with bridge method [inline-methods] */
        public boolean b(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, Rect rect) {
            return super.b(coordinatorLayout, extendedFloatingActionButton, rect);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: H, reason: merged with bridge method [inline-methods] */
        public boolean h(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                L(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton);
                return false;
            }
            if (!G(view)) {
                return false;
            }
            M(view, extendedFloatingActionButton);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: I, reason: merged with bridge method [inline-methods] */
        public boolean l(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, int i) {
            List listU = coordinatorLayout.u(extendedFloatingActionButton);
            int size = listU.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = (View) listU.get(i2);
                if (!(view instanceof AppBarLayout)) {
                    if (G(view) && M(view, extendedFloatingActionButton)) {
                        break;
                    }
                } else {
                    if (L(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.M(extendedFloatingActionButton, i);
            return true;
        }

        protected void K(ExtendedFloatingActionButton extendedFloatingActionButton) {
            extendedFloatingActionButton.y(this.c ? extendedFloatingActionButton.v : extendedFloatingActionButton.y, null);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void g(CoordinatorLayout.e eVar) {
            if (eVar.h == 0) {
                eVar.h = 80;
            }
        }

        public ExtendedFloatingActionButtonBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, GE5.ExtendedFloatingActionButton_Behavior_Layout);
            this.b = typedArrayObtainStyledAttributes.getBoolean(GE5.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoHide, false);
            this.c = typedArrayObtainStyledAttributes.getBoolean(GE5.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoShrink, true);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ExtendedFloatingActionButton(Context context, AttributeSet attributeSet, int i2) {
        int i3 = A0;
        super(AbstractC17750nV3.c(context, attributeSet, i2, i3), attributeSet, i2);
        this.t = 0;
        com.google.android.material.floatingactionbutton.a aVar = new com.google.android.material.floatingactionbutton.a();
        this.u = aVar;
        k kVar = new k(aVar);
        this.x = kVar;
        i iVar = new i(aVar);
        this.y = iVar;
        this.G = true;
        this.H = false;
        this.J = false;
        Context context2 = getContext();
        this.D = new ExtendedFloatingActionButtonBehavior(context2, attributeSet);
        TypedArray typedArrayH = AbstractC5729Ko7.h(context2, attributeSet, GE5.ExtendedFloatingActionButton, i2, i3, new int[0]);
        C15532jk4 c15532jk4C = C15532jk4.c(context2, typedArrayH, GE5.ExtendedFloatingActionButton_showMotionSpec);
        C15532jk4 c15532jk4C2 = C15532jk4.c(context2, typedArrayH, GE5.ExtendedFloatingActionButton_hideMotionSpec);
        C15532jk4 c15532jk4C3 = C15532jk4.c(context2, typedArrayH, GE5.ExtendedFloatingActionButton_extendMotionSpec);
        C15532jk4 c15532jk4C4 = C15532jk4.c(context2, typedArrayH, GE5.ExtendedFloatingActionButton_shrinkMotionSpec);
        this.z = typedArrayH.getDimensionPixelSize(GE5.ExtendedFloatingActionButton_collapsedSize, -1);
        this.A = AbstractC12990fW7.F(this);
        this.B = AbstractC12990fW7.E(this);
        com.google.android.material.floatingactionbutton.a aVar2 = new com.google.android.material.floatingactionbutton.a();
        h hVar = new h(aVar2, new a(), true);
        this.w = hVar;
        h hVar2 = new h(aVar2, new b(), false);
        this.v = hVar2;
        kVar.f(c15532jk4C);
        iVar.f(c15532jk4C2);
        hVar.f(c15532jk4C3);
        hVar2.f(c15532jk4C4);
        typedArrayH.recycle();
        setShapeAppearanceModel(C11411cx6.g(context2, attributeSet, i2, i3, C11411cx6.m).m());
        z();
    }

    @Override // android.widget.TextView
    public void setTextColor(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        z();
    }
}
