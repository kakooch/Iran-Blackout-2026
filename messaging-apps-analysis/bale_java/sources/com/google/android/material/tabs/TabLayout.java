package com.google.android.material.tabs;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import ir.nasim.AbstractC10402bY7;
import ir.nasim.AbstractC10961cV3;
import ir.nasim.AbstractC12181eA5;
import ir.nasim.AbstractC12799fB5;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC15575jo7;
import ir.nasim.AbstractC17750nV3;
import ir.nasim.AbstractC21175tE5;
import ir.nasim.AbstractC21710u02;
import ir.nasim.AbstractC23026wD5;
import ir.nasim.AbstractC23123wO3;
import ir.nasim.AbstractC24690z26;
import ir.nasim.AbstractC5729Ko7;
import ir.nasim.AbstractC6732Ot;
import ir.nasim.AbstractC8375Vr7;
import ir.nasim.AbstractC9594aE;
import ir.nasim.AbstractC9751aV3;
import ir.nasim.C10345bV3;
import ir.nasim.C22127ui5;
import ir.nasim.C23313wi5;
import ir.nasim.C5187Ig5;
import ir.nasim.GE5;
import ir.nasim.HE5;
import ir.nasim.InterfaceC20850si5;
import ir.nasim.X2;
import ir.nasim.YC5;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

@ViewPager.e
/* loaded from: classes3.dex */
public class TabLayout extends HorizontalScrollView {
    private static final int K0 = AbstractC21175tE5.Widget_Design_TabLayout;
    private static final InterfaceC20850si5 L0 = new C23313wi5(16);
    boolean A;
    private final ArrayList A0;
    boolean B;
    private c B0;
    private ValueAnimator C0;
    int D;
    ViewPager D0;
    private androidx.viewpager.widget.a E0;
    private DataSetObserver F0;
    int G;
    private h G0;
    boolean H;
    private b H0;
    private boolean I0;
    private com.google.android.material.tabs.c J;
    private final InterfaceC20850si5 J0;
    private final ArrayList a;
    private g b;
    final f c;
    int d;
    int e;
    int f;
    int g;
    int h;
    ColorStateList i;
    ColorStateList j;
    ColorStateList k;
    Drawable l;
    private int m;
    PorterDuff.Mode n;
    float o;
    float p;
    final int q;
    int r;
    private final int s;
    private final int t;
    private final int u;
    private int v;
    int w;
    int x;
    int y;
    int z;
    private c z0;

    public final class TabView extends LinearLayout {
        private g a;
        private TextView b;
        private ImageView c;
        private View d;
        private com.google.android.material.badge.a e;
        private View f;
        private TextView g;
        private ImageView h;
        private Drawable i;
        private int j;

        class a implements View.OnLayoutChangeListener {
            final /* synthetic */ View a;

            a(View view) {
                this.a = view;
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) throws Resources.NotFoundException {
                if (this.a.getVisibility() == 0) {
                    TabView.this.s(this.a);
                }
            }
        }

        public TabView(Context context) {
            super(context);
            this.j = 2;
            u(context);
            AbstractC12990fW7.F0(this, TabLayout.this.d, TabLayout.this.e, TabLayout.this.f, TabLayout.this.g);
            setGravity(17);
            setOrientation(!TabLayout.this.A ? 1 : 0);
            setClickable(true);
            AbstractC12990fW7.G0(this, C5187Ig5.b(getContext(), 1002));
        }

        private void f(View view) {
            if (view == null) {
                return;
            }
            view.addOnLayoutChangeListener(new a(view));
        }

        private float g(Layout layout, int i, float f) {
            return layout.getLineWidth(i) * (f / layout.getPaint().getTextSize());
        }

        private com.google.android.material.badge.a getBadge() {
            return this.e;
        }

        private com.google.android.material.badge.a getOrCreateBadge() throws Resources.NotFoundException {
            if (this.e == null) {
                this.e = com.google.android.material.badge.a.c(getContext());
            }
            r();
            com.google.android.material.badge.a aVar = this.e;
            if (aVar != null) {
                return aVar;
            }
            throw new IllegalStateException("Unable to create badge");
        }

        private void h(boolean z) {
            setClipChildren(z);
            setClipToPadding(z);
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                viewGroup.setClipChildren(z);
                viewGroup.setClipToPadding(z);
            }
        }

        private FrameLayout i() {
            FrameLayout frameLayout = new FrameLayout(getContext());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            return frameLayout;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(Canvas canvas) {
            Drawable drawable = this.i;
            if (drawable != null) {
                drawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
                this.i.draw(canvas);
            }
        }

        private FrameLayout k(View view) {
            if ((view == this.c || view == this.b) && com.google.android.material.badge.b.a) {
                return (FrameLayout) view.getParent();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean l() {
            return this.e != null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void m() {
            FrameLayout frameLayoutI;
            if (com.google.android.material.badge.b.a) {
                frameLayoutI = i();
                addView(frameLayoutI, 0);
            } else {
                frameLayoutI = this;
            }
            ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(YC5.design_layout_tab_icon, (ViewGroup) frameLayoutI, false);
            this.c = imageView;
            frameLayoutI.addView(imageView, 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void n() {
            FrameLayout frameLayoutI;
            if (com.google.android.material.badge.b.a) {
                frameLayoutI = i();
                addView(frameLayoutI);
            } else {
                frameLayoutI = this;
            }
            TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(YC5.design_layout_tab_text, (ViewGroup) frameLayoutI, false);
            this.b = textView;
            frameLayoutI.addView(textView);
        }

        private void p(View view) throws Resources.NotFoundException {
            if (l() && view != null) {
                h(false);
                com.google.android.material.badge.b.a(this.e, view, k(view));
                this.d = view;
            }
        }

        private void q() {
            if (l()) {
                h(true);
                View view = this.d;
                if (view != null) {
                    com.google.android.material.badge.b.d(this.e, view);
                    this.d = null;
                }
            }
        }

        private void r() throws Resources.NotFoundException {
            g gVar;
            g gVar2;
            if (l()) {
                if (this.f != null) {
                    q();
                    return;
                }
                if (this.c != null && (gVar2 = this.a) != null && gVar2.f() != null) {
                    View view = this.d;
                    ImageView imageView = this.c;
                    if (view == imageView) {
                        s(imageView);
                        return;
                    } else {
                        q();
                        p(this.c);
                        return;
                    }
                }
                if (this.b == null || (gVar = this.a) == null || gVar.i() != 1) {
                    q();
                    return;
                }
                View view2 = this.d;
                TextView textView = this.b;
                if (view2 == textView) {
                    s(textView);
                } else {
                    q();
                    p(this.b);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s(View view) throws Resources.NotFoundException {
            if (l() && view == this.d) {
                com.google.android.material.badge.b.e(this.e, view, k(view));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v0, types: [android.graphics.drawable.RippleDrawable] */
        public void u(Context context) {
            int i = TabLayout.this.q;
            if (i != 0) {
                Drawable drawableB = AbstractC9594aE.b(context, i);
                this.i = drawableB;
                if (drawableB != null && drawableB.isStateful()) {
                    this.i.setState(getDrawableState());
                }
            } else {
                this.i = null;
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(0);
            if (TabLayout.this.k != null) {
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setCornerRadius(1.0E-5f);
                gradientDrawable2.setColor(-1);
                ColorStateList colorStateListA = AbstractC24690z26.a(TabLayout.this.k);
                boolean z = TabLayout.this.H;
                if (z) {
                    gradientDrawable = null;
                }
                gradientDrawable = new RippleDrawable(colorStateListA, gradientDrawable, z ? null : gradientDrawable2);
            }
            AbstractC12990fW7.t0(this, gradientDrawable);
            TabLayout.this.invalidate();
        }

        private void w(TextView textView, ImageView imageView) {
            g gVar = this.a;
            Drawable drawableMutate = (gVar == null || gVar.f() == null) ? null : AbstractC21710u02.l(this.a.f()).mutate();
            if (drawableMutate != null) {
                AbstractC21710u02.i(drawableMutate, TabLayout.this.j);
                PorterDuff.Mode mode = TabLayout.this.n;
                if (mode != null) {
                    AbstractC21710u02.j(drawableMutate, mode);
                }
            }
            g gVar2 = this.a;
            CharSequence charSequenceK = gVar2 != null ? gVar2.k() : null;
            if (imageView != null) {
                if (drawableMutate != null) {
                    imageView.setImageDrawable(drawableMutate);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
            }
            boolean z = !TextUtils.isEmpty(charSequenceK);
            if (textView != null) {
                if (z) {
                    textView.setText(charSequenceK);
                    if (this.a.g == 1) {
                        textView.setVisibility(0);
                    } else {
                        textView.setVisibility(8);
                    }
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText((CharSequence) null);
                }
            }
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                int iD = (z && imageView.getVisibility() == 0) ? (int) AbstractC10402bY7.d(getContext(), 8) : 0;
                if (TabLayout.this.A) {
                    if (iD != AbstractC23123wO3.a(marginLayoutParams)) {
                        AbstractC23123wO3.c(marginLayoutParams, iD);
                        marginLayoutParams.bottomMargin = 0;
                        imageView.setLayoutParams(marginLayoutParams);
                        imageView.requestLayout();
                    }
                } else if (iD != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = iD;
                    AbstractC23123wO3.c(marginLayoutParams, 0);
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            }
            g gVar3 = this.a;
            CharSequence charSequence = gVar3 != null ? gVar3.d : null;
            if (!z) {
                charSequenceK = charSequence;
            }
            AbstractC8375Vr7.a(this, charSequenceK);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.i;
            if ((drawable == null || !drawable.isStateful()) ? false : this.i.setState(drawableState)) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        int getContentHeight() {
            View[] viewArr = {this.b, this.c, this.f};
            int iMax = 0;
            int iMin = 0;
            boolean z = false;
            for (int i = 0; i < 3; i++) {
                View view = viewArr[i];
                if (view != null && view.getVisibility() == 0) {
                    iMin = z ? Math.min(iMin, view.getTop()) : view.getTop();
                    iMax = z ? Math.max(iMax, view.getBottom()) : view.getBottom();
                    z = true;
                }
            }
            return iMax - iMin;
        }

        int getContentWidth() {
            View[] viewArr = {this.b, this.c, this.f};
            int iMax = 0;
            int iMin = 0;
            boolean z = false;
            for (int i = 0; i < 3; i++) {
                View view = viewArr[i];
                if (view != null && view.getVisibility() == 0) {
                    iMin = z ? Math.min(iMin, view.getLeft()) : view.getLeft();
                    iMax = z ? Math.max(iMax, view.getRight()) : view.getRight();
                    z = true;
                }
            }
            return iMax - iMin;
        }

        public g getTab() {
            return this.a;
        }

        void o() throws Resources.NotFoundException {
            setTab(null);
            setSelected(false);
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            com.google.android.material.badge.a aVar = this.e;
            if (aVar != null && aVar.isVisible()) {
                accessibilityNodeInfo.setContentDescription(((Object) getContentDescription()) + ", " + ((Object) this.e.g()));
            }
            X2 x2G1 = X2.g1(accessibilityNodeInfo);
            x2G1.s0(X2.f.a(0, 1, this.a.h(), 1, false, isSelected()));
            if (isSelected()) {
                x2G1.q0(false);
                x2G1.f0(X2.a.i);
            }
            x2G1.P0(getResources().getString(AbstractC23026wD5.item_view_role_description));
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            Layout layout;
            int size = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            int tabMaxWidth = TabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i = View.MeasureSpec.makeMeasureSpec(TabLayout.this.r, RecyclerView.UNDEFINED_DURATION);
            }
            super.onMeasure(i, i2);
            if (this.b != null) {
                float f = TabLayout.this.o;
                int i3 = this.j;
                ImageView imageView = this.c;
                if (imageView == null || imageView.getVisibility() != 0) {
                    TextView textView = this.b;
                    if (textView != null && textView.getLineCount() > 1) {
                        f = TabLayout.this.p;
                    }
                } else {
                    i3 = 1;
                }
                float textSize = this.b.getTextSize();
                int lineCount = this.b.getLineCount();
                int iD = AbstractC15575jo7.d(this.b);
                if (f != textSize || (iD >= 0 && i3 != iD)) {
                    if (TabLayout.this.z != 1 || f <= textSize || lineCount != 1 || ((layout = this.b.getLayout()) != null && g(layout, 0, f) <= (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) {
                        this.b.setTextSize(0, f);
                        this.b.setMaxLines(i3);
                        super.onMeasure(i, i2);
                    }
                }
            }
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean zPerformClick = super.performClick();
            if (this.a == null) {
                return zPerformClick;
            }
            if (!zPerformClick) {
                playSoundEffect(0);
            }
            this.a.n();
            return true;
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            isSelected();
            super.setSelected(z);
            TextView textView = this.b;
            if (textView != null) {
                textView.setSelected(z);
            }
            ImageView imageView = this.c;
            if (imageView != null) {
                imageView.setSelected(z);
            }
            View view = this.f;
            if (view != null) {
                view.setSelected(z);
            }
        }

        void setTab(g gVar) throws Resources.NotFoundException {
            if (gVar != this.a) {
                this.a = gVar;
                t();
            }
        }

        final void t() throws Resources.NotFoundException {
            g gVar = this.a;
            View viewE = gVar != null ? gVar.e() : null;
            if (viewE != null) {
                ViewParent parent = viewE.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(viewE);
                    }
                    addView(viewE);
                }
                this.f = viewE;
                TextView textView = this.b;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.c;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.c.setImageDrawable(null);
                }
                TextView textView2 = (TextView) viewE.findViewById(R.id.text1);
                this.g = textView2;
                if (textView2 != null) {
                    this.j = AbstractC15575jo7.d(textView2);
                }
                this.h = (ImageView) viewE.findViewById(R.id.icon);
            } else {
                View view = this.f;
                if (view != null) {
                    removeView(view);
                    this.f = null;
                }
                this.g = null;
                this.h = null;
            }
            if (this.f == null) {
                if (this.c == null) {
                    m();
                }
                if (this.b == null) {
                    n();
                    this.j = AbstractC15575jo7.d(this.b);
                }
                AbstractC15575jo7.p(this.b, TabLayout.this.h);
                ColorStateList colorStateList = TabLayout.this.i;
                if (colorStateList != null) {
                    this.b.setTextColor(colorStateList);
                }
                w(this.b, this.c);
                r();
                f(this.c);
                f(this.b);
            } else {
                TextView textView3 = this.g;
                if (textView3 != null || this.h != null) {
                    w(textView3, this.h);
                }
            }
            if (gVar != null && !TextUtils.isEmpty(gVar.d)) {
                setContentDescription(gVar.d);
            }
            setSelected(gVar != null && gVar.l());
        }

        final void v() {
            setOrientation(!TabLayout.this.A ? 1 : 0);
            TextView textView = this.g;
            if (textView == null && this.h == null) {
                w(this.b, this.c);
            } else {
                w(textView, this.h);
            }
        }
    }

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    private class b implements ViewPager.h {
        private boolean a;

        b() {
        }

        void a(boolean z) {
            this.a = z;
        }

        @Override // androidx.viewpager.widget.ViewPager.h
        public void b(ViewPager viewPager, androidx.viewpager.widget.a aVar, androidx.viewpager.widget.a aVar2) throws Resources.NotFoundException {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.D0 == viewPager) {
                tabLayout.K(aVar2, this.a);
            }
        }
    }

    public interface c {
        void a(g gVar);

        void b(g gVar);

        void c(g gVar);
    }

    public interface d extends c {
    }

    private class e extends DataSetObserver {
        e() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() throws Resources.NotFoundException {
            TabLayout.this.C();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() throws Resources.NotFoundException {
            TabLayout.this.C();
        }
    }

    class f extends LinearLayout {
        ValueAnimator a;
        int b;
        float c;
        private int d;

        class a implements ValueAnimator.AnimatorUpdateListener {
            final /* synthetic */ View a;
            final /* synthetic */ View b;

            a(View view, View view2) {
                this.a = view;
                this.b = view2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.h(this.a, this.b, valueAnimator.getAnimatedFraction());
            }
        }

        class b extends AnimatorListenerAdapter {
            final /* synthetic */ int a;

            b(int i) {
                this.a = i;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.this.b = this.a;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                f.this.b = this.a;
            }
        }

        f(Context context) {
            super(context);
            this.b = -1;
            this.d = -1;
            setWillNotDraw(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e() {
            View childAt = getChildAt(this.b);
            com.google.android.material.tabs.c cVar = TabLayout.this.J;
            TabLayout tabLayout = TabLayout.this;
            cVar.c(tabLayout, childAt, tabLayout.l);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h(View view, View view2, float f) {
            if (view == null || view.getWidth() <= 0) {
                Drawable drawable = TabLayout.this.l;
                drawable.setBounds(-1, drawable.getBounds().top, -1, TabLayout.this.l.getBounds().bottom);
            } else {
                com.google.android.material.tabs.c cVar = TabLayout.this.J;
                TabLayout tabLayout = TabLayout.this;
                cVar.d(tabLayout, view, view2, f, tabLayout.l);
            }
            AbstractC12990fW7.g0(this);
        }

        private void i(boolean z, int i, int i2) {
            View childAt = getChildAt(this.b);
            View childAt2 = getChildAt(i);
            if (childAt2 == null) {
                e();
                return;
            }
            a aVar = new a(childAt, childAt2);
            if (!z) {
                this.a.removeAllUpdateListeners();
                this.a.addUpdateListener(aVar);
                return;
            }
            ValueAnimator valueAnimator = new ValueAnimator();
            this.a = valueAnimator;
            valueAnimator.setInterpolator(AbstractC6732Ot.b);
            valueAnimator.setDuration(i2);
            valueAnimator.setFloatValues(0.0f, 1.0f);
            valueAnimator.addUpdateListener(aVar);
            valueAnimator.addListener(new b(i));
            valueAnimator.start();
        }

        void c(int i, int i2) {
            ValueAnimator valueAnimator = this.a;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.a.cancel();
            }
            i(true, i, i2);
        }

        boolean d() {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            int height;
            int iHeight = TabLayout.this.l.getBounds().height();
            if (iHeight < 0) {
                iHeight = TabLayout.this.l.getIntrinsicHeight();
            }
            int i = TabLayout.this.y;
            if (i == 0) {
                height = getHeight() - iHeight;
                iHeight = getHeight();
            } else if (i != 1) {
                height = 0;
                if (i != 2) {
                    iHeight = i != 3 ? 0 : getHeight();
                }
            } else {
                height = (getHeight() - iHeight) / 2;
                iHeight = (getHeight() + iHeight) / 2;
            }
            if (TabLayout.this.l.getBounds().width() > 0) {
                Rect bounds = TabLayout.this.l.getBounds();
                TabLayout.this.l.setBounds(bounds.left, height, bounds.right, iHeight);
                TabLayout tabLayout = TabLayout.this;
                Drawable drawableL = tabLayout.l;
                if (tabLayout.m != 0) {
                    drawableL = AbstractC21710u02.l(drawableL);
                    AbstractC21710u02.h(drawableL, TabLayout.this.m);
                } else {
                    AbstractC21710u02.i(drawableL, null);
                }
                drawableL.draw(canvas);
            }
            super.draw(canvas);
        }

        void f(int i, float f) {
            ValueAnimator valueAnimator = this.a;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.a.cancel();
            }
            this.b = i;
            this.c = f;
            h(getChildAt(i), getChildAt(this.b + 1), this.c);
        }

        void g(int i) {
            Rect bounds = TabLayout.this.l.getBounds();
            TabLayout.this.l.setBounds(bounds.left, 0, bounds.right, i);
            requestLayout();
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            ValueAnimator valueAnimator = this.a;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                e();
            } else {
                i(false, this.b, -1);
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (View.MeasureSpec.getMode(i) != 1073741824) {
                return;
            }
            TabLayout tabLayout = TabLayout.this;
            boolean z = true;
            if (tabLayout.w == 1 || tabLayout.z == 2) {
                int childCount = getChildCount();
                int iMax = 0;
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = getChildAt(i3);
                    if (childAt.getVisibility() == 0) {
                        iMax = Math.max(iMax, childAt.getMeasuredWidth());
                    }
                }
                if (iMax <= 0) {
                    return;
                }
                if (iMax * childCount <= getMeasuredWidth() - (((int) AbstractC10402bY7.d(getContext(), 16)) * 2)) {
                    boolean z2 = false;
                    for (int i4 = 0; i4 < childCount; i4++) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i4).getLayoutParams();
                        if (layoutParams.width != iMax || layoutParams.weight != 0.0f) {
                            layoutParams.width = iMax;
                            layoutParams.weight = 0.0f;
                            z2 = true;
                        }
                    }
                    z = z2;
                } else {
                    TabLayout tabLayout2 = TabLayout.this;
                    tabLayout2.w = 0;
                    tabLayout2.O(false);
                }
                if (z) {
                    super.onMeasure(i, i2);
                }
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int i) {
            super.onRtlPropertiesChanged(i);
        }
    }

    public static class g {
        private Object a;
        private Drawable b;
        private CharSequence c;
        private CharSequence d;
        private View f;
        public TabLayout h;
        public TabView i;
        private int e = -1;
        private int g = 1;
        private int j = -1;

        public View e() {
            return this.f;
        }

        public Drawable f() {
            return this.b;
        }

        public int g() {
            return this.j;
        }

        public int h() {
            return this.e;
        }

        public int i() {
            return this.g;
        }

        public Object j() {
            return this.a;
        }

        public CharSequence k() {
            return this.c;
        }

        public boolean l() {
            TabLayout tabLayout = this.h;
            if (tabLayout == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            int selectedTabPosition = tabLayout.getSelectedTabPosition();
            return selectedTabPosition != -1 && selectedTabPosition == this.e;
        }

        void m() {
            this.h = null;
            this.i = null;
            this.a = null;
            this.b = null;
            this.j = -1;
            this.c = null;
            this.d = null;
            this.e = -1;
            this.f = null;
        }

        public void n() {
            TabLayout tabLayout = this.h;
            if (tabLayout == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            tabLayout.I(this);
        }

        public g o(int i) {
            TabLayout tabLayout = this.h;
            if (tabLayout != null) {
                return p(tabLayout.getResources().getText(i));
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public g p(CharSequence charSequence) throws Resources.NotFoundException {
            this.d = charSequence;
            z();
            return this;
        }

        public g q(int i) {
            return r(LayoutInflater.from(this.i.getContext()).inflate(i, (ViewGroup) this.i, false));
        }

        public g r(View view) {
            this.f = view;
            z();
            return this;
        }

        public g s(int i) {
            TabLayout tabLayout = this.h;
            if (tabLayout != null) {
                return t(AbstractC9594aE.b(tabLayout.getContext(), i));
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public g t(Drawable drawable) throws Resources.NotFoundException {
            this.b = drawable;
            TabLayout tabLayout = this.h;
            if (tabLayout.w == 1 || tabLayout.z == 2) {
                tabLayout.O(true);
            }
            z();
            if (com.google.android.material.badge.b.a && this.i.l() && this.i.e.isVisible()) {
                this.i.invalidate();
            }
            return this;
        }

        public g u(int i) {
            this.j = i;
            TabView tabView = this.i;
            if (tabView != null) {
                tabView.setId(i);
            }
            return this;
        }

        void v(int i) {
            this.e = i;
        }

        public g w(Object obj) {
            this.a = obj;
            return this;
        }

        public g x(int i) {
            TabLayout tabLayout = this.h;
            if (tabLayout != null) {
                return y(tabLayout.getResources().getText(i));
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public g y(CharSequence charSequence) {
            if (TextUtils.isEmpty(this.d) && !TextUtils.isEmpty(charSequence)) {
                this.i.setContentDescription(charSequence);
            }
            this.c = charSequence;
            z();
            return this;
        }

        void z() throws Resources.NotFoundException {
            TabView tabView = this.i;
            if (tabView != null) {
                tabView.t();
            }
        }
    }

    public static class h implements ViewPager.i {
        private final WeakReference a;
        private int b;
        private int c;

        public h(TabLayout tabLayout) {
            this.a = new WeakReference(tabLayout);
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void a(int i, float f, int i2) {
            TabLayout tabLayout = (TabLayout) this.a.get();
            if (tabLayout != null) {
                int i3 = this.c;
                tabLayout.setScrollPosition(i, f, i3 != 2 || this.b == 1, (i3 == 2 && this.b == 0) ? false : true);
            }
        }

        void b() {
            this.c = 0;
            this.b = 0;
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void c(int i) {
            this.b = this.c;
            this.c = i;
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void d(int i) {
            TabLayout tabLayout = (TabLayout) this.a.get();
            if (tabLayout == null || tabLayout.getSelectedTabPosition() == i || i >= tabLayout.getTabCount()) {
                return;
            }
            int i2 = this.c;
            tabLayout.J(tabLayout.y(i), i2 == 0 || (i2 == 2 && this.b == 0));
        }
    }

    public static class i implements d {
        private final ViewPager a;

        public i(ViewPager viewPager) {
            this.a = viewPager;
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void a(g gVar) throws Resources.NotFoundException {
            this.a.setCurrentItem(gVar.h());
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void b(g gVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void c(g gVar) {
        }
    }

    public TabLayout(Context context) {
        this(context, null);
    }

    private void H(int i2) throws Resources.NotFoundException {
        TabView tabView = (TabView) this.c.getChildAt(i2);
        this.c.removeViewAt(i2);
        if (tabView != null) {
            tabView.o();
            this.J0.a(tabView);
        }
        requestLayout();
    }

    private void L(ViewPager viewPager, boolean z, boolean z2) throws Resources.NotFoundException {
        ViewPager viewPager2 = this.D0;
        if (viewPager2 != null) {
            h hVar = this.G0;
            if (hVar != null) {
                viewPager2.J(hVar);
            }
            b bVar = this.H0;
            if (bVar != null) {
                this.D0.I(bVar);
            }
        }
        c cVar = this.B0;
        if (cVar != null) {
            F(cVar);
            this.B0 = null;
        }
        if (viewPager != null) {
            this.D0 = viewPager;
            if (this.G0 == null) {
                this.G0 = new h(this);
            }
            this.G0.b();
            viewPager.c(this.G0);
            i iVar = new i(viewPager);
            this.B0 = iVar;
            c(iVar);
            androidx.viewpager.widget.a adapter = viewPager.getAdapter();
            if (adapter != null) {
                K(adapter, z);
            }
            if (this.H0 == null) {
                this.H0 = new b();
            }
            this.H0.a(z);
            viewPager.b(this.H0);
            setScrollPosition(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.D0 = null;
            K(null, false);
        }
        this.I0 = z2;
    }

    private void M() throws Resources.NotFoundException {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((g) this.a.get(i2)).z();
        }
    }

    private void N(LinearLayout.LayoutParams layoutParams) {
        if (this.z == 1 && this.w == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
        } else {
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
        }
    }

    private int getDefaultHeight() {
        int size = this.a.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            g gVar = (g) this.a.get(i2);
            if (gVar == null || gVar.f() == null || TextUtils.isEmpty(gVar.k())) {
                i2++;
            } else if (!this.A) {
                return 72;
            }
        }
        return 48;
    }

    private int getTabMinWidth() {
        int i2 = this.s;
        if (i2 != -1) {
            return i2;
        }
        int i3 = this.z;
        if (i3 == 0 || i3 == 2) {
            return this.u;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.c.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void h(TabItem tabItem) throws Resources.NotFoundException {
        g gVarB = B();
        CharSequence charSequence = tabItem.a;
        if (charSequence != null) {
            gVarB.y(charSequence);
        }
        Drawable drawable = tabItem.b;
        if (drawable != null) {
            gVarB.t(drawable);
        }
        int i2 = tabItem.c;
        if (i2 != 0) {
            gVarB.q(i2);
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            gVarB.p(tabItem.getContentDescription());
        }
        e(gVarB);
    }

    private void i(g gVar) {
        TabView tabView = gVar.i;
        tabView.setSelected(false);
        tabView.setActivated(false);
        this.c.addView(tabView, gVar.h(), r());
    }

    private void j(View view) throws Resources.NotFoundException {
        if (!(view instanceof TabItem)) {
            throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
        }
        h((TabItem) view);
    }

    private void k(int i2) {
        if (i2 == -1) {
            return;
        }
        if (getWindowToken() == null || !AbstractC12990fW7.T(this) || this.c.d()) {
            setScrollPosition(i2, 0.0f, true);
            return;
        }
        int scrollX = getScrollX();
        int iN = n(i2, 0.0f);
        if (scrollX != iN) {
            x();
            this.C0.setIntValues(scrollX, iN);
            this.C0.start();
        }
        this.c.c(i2, this.x);
    }

    private void l(int i2) {
        if (i2 == 0) {
            Log.w("TabLayout", "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
        } else if (i2 == 1) {
            this.c.setGravity(1);
            return;
        } else if (i2 != 2) {
            return;
        }
        this.c.setGravity(8388611);
    }

    private void m() {
        int i2 = this.z;
        AbstractC12990fW7.F0(this.c, (i2 == 0 || i2 == 2) ? Math.max(0, this.v - this.d) : 0, 0, 0, 0);
        int i3 = this.z;
        if (i3 == 0) {
            l(this.w);
        } else if (i3 == 1 || i3 == 2) {
            if (this.w == 2) {
                Log.w("TabLayout", "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead");
            }
            this.c.setGravity(1);
        }
        O(true);
    }

    private int n(int i2, float f2) {
        View childAt;
        int i3 = this.z;
        if ((i3 != 0 && i3 != 2) || (childAt = this.c.getChildAt(i2)) == null) {
            return 0;
        }
        int i4 = i2 + 1;
        View childAt2 = i4 < this.c.getChildCount() ? this.c.getChildAt(i4) : null;
        int width = childAt.getWidth();
        int width2 = childAt2 != null ? childAt2.getWidth() : 0;
        int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
        int i5 = (int) ((width + width2) * 0.5f * f2);
        return AbstractC12990fW7.A(this) == 0 ? left + i5 : left - i5;
    }

    private void p(g gVar, int i2) {
        gVar.v(i2);
        this.a.add(i2, gVar);
        int size = this.a.size();
        while (true) {
            i2++;
            if (i2 >= size) {
                return;
            } else {
                ((g) this.a.get(i2)).v(i2);
            }
        }
    }

    private static ColorStateList q(int i2, int i3) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i3, i2});
    }

    private LinearLayout.LayoutParams r() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        N(layoutParams);
        return layoutParams;
    }

    private void setSelectedTabView(int i2) {
        int childCount = this.c.getChildCount();
        if (i2 < childCount) {
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = this.c.getChildAt(i3);
                boolean z = true;
                childAt.setSelected(i3 == i2);
                if (i3 != i2) {
                    z = false;
                }
                childAt.setActivated(z);
                i3++;
            }
        }
    }

    private TabView t(g gVar) throws Resources.NotFoundException {
        InterfaceC20850si5 interfaceC20850si5 = this.J0;
        TabView tabView = interfaceC20850si5 != null ? (TabView) interfaceC20850si5.b() : null;
        if (tabView == null) {
            tabView = new TabView(getContext());
        }
        tabView.setTab(gVar);
        tabView.setFocusable(true);
        tabView.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(gVar.d)) {
            tabView.setContentDescription(gVar.c);
        } else {
            tabView.setContentDescription(gVar.d);
        }
        return tabView;
    }

    private void u(g gVar) {
        for (int size = this.A0.size() - 1; size >= 0; size--) {
            ((c) this.A0.get(size)).c(gVar);
        }
    }

    private void v(g gVar) {
        for (int size = this.A0.size() - 1; size >= 0; size--) {
            ((c) this.A0.get(size)).a(gVar);
        }
    }

    private void w(g gVar) {
        for (int size = this.A0.size() - 1; size >= 0; size--) {
            ((c) this.A0.get(size)).b(gVar);
        }
    }

    private void x() {
        if (this.C0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.C0 = valueAnimator;
            valueAnimator.setInterpolator(AbstractC6732Ot.b);
            this.C0.setDuration(this.x);
            this.C0.addUpdateListener(new a());
        }
    }

    private boolean z() {
        return getTabMode() == 0 || getTabMode() == 2;
    }

    public boolean A() {
        return this.B;
    }

    public g B() {
        g gVarS = s();
        gVarS.h = this;
        gVarS.i = t(gVarS);
        if (gVarS.j != -1) {
            gVarS.i.setId(gVarS.j);
        }
        return gVarS;
    }

    void C() throws Resources.NotFoundException {
        int currentItem;
        E();
        androidx.viewpager.widget.a aVar = this.E0;
        if (aVar != null) {
            int iD = aVar.d();
            for (int i2 = 0; i2 < iD; i2++) {
                g(B().y(this.E0.f(i2)), false);
            }
            ViewPager viewPager = this.D0;
            if (viewPager == null || iD <= 0 || (currentItem = viewPager.getCurrentItem()) == getSelectedTabPosition() || currentItem >= getTabCount()) {
                return;
            }
            I(y(currentItem));
        }
    }

    protected boolean D(g gVar) {
        return L0.a(gVar);
    }

    public void E() throws Resources.NotFoundException {
        for (int childCount = this.c.getChildCount() - 1; childCount >= 0; childCount--) {
            H(childCount);
        }
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            g gVar = (g) it.next();
            it.remove();
            gVar.m();
            D(gVar);
        }
        this.b = null;
    }

    public void F(c cVar) {
        this.A0.remove(cVar);
    }

    public void G(d dVar) {
        F(dVar);
    }

    public void I(g gVar) {
        J(gVar, true);
    }

    public void J(g gVar, boolean z) {
        g gVar2 = this.b;
        if (gVar2 == gVar) {
            if (gVar2 != null) {
                u(gVar);
                k(gVar.h());
                return;
            }
            return;
        }
        int iH = gVar != null ? gVar.h() : -1;
        if (z) {
            if ((gVar2 == null || gVar2.h() == -1) && iH != -1) {
                setScrollPosition(iH, 0.0f, true);
            } else {
                k(iH);
            }
            if (iH != -1) {
                setSelectedTabView(iH);
            }
        }
        this.b = gVar;
        if (gVar2 != null) {
            w(gVar2);
        }
        if (gVar != null) {
            v(gVar);
        }
    }

    void K(androidx.viewpager.widget.a aVar, boolean z) throws Resources.NotFoundException {
        DataSetObserver dataSetObserver;
        androidx.viewpager.widget.a aVar2 = this.E0;
        if (aVar2 != null && (dataSetObserver = this.F0) != null) {
            aVar2.s(dataSetObserver);
        }
        this.E0 = aVar;
        if (z && aVar != null) {
            if (this.F0 == null) {
                this.F0 = new e();
            }
            aVar.k(this.F0);
        }
        C();
    }

    void O(boolean z) {
        for (int i2 = 0; i2 < this.c.getChildCount(); i2++) {
            View childAt = this.c.getChildAt(i2);
            childAt.setMinimumWidth(getTabMinWidth());
            N((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z) {
                childAt.requestLayout();
            }
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) throws Resources.NotFoundException {
        j(view);
    }

    public void c(c cVar) {
        if (this.A0.contains(cVar)) {
            return;
        }
        this.A0.add(cVar);
    }

    public void d(d dVar) {
        c(dVar);
    }

    public void e(g gVar) {
        g(gVar, this.a.isEmpty());
    }

    public void f(g gVar, int i2, boolean z) {
        if (gVar.h != this) {
            throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
        }
        p(gVar, i2);
        i(gVar);
        if (z) {
            gVar.n();
        }
    }

    public void g(g gVar, boolean z) {
        f(gVar, this.a.size(), z);
    }

    public int getSelectedTabPosition() {
        g gVar = this.b;
        if (gVar != null) {
            return gVar.h();
        }
        return -1;
    }

    public int getTabCount() {
        return this.a.size();
    }

    public int getTabGravity() {
        return this.w;
    }

    public ColorStateList getTabIconTint() {
        return this.j;
    }

    public int getTabIndicatorAnimationMode() {
        return this.G;
    }

    public int getTabIndicatorGravity() {
        return this.y;
    }

    int getTabMaxWidth() {
        return this.r;
    }

    public int getTabMode() {
        return this.z;
    }

    public ColorStateList getTabRippleColor() {
        return this.k;
    }

    public Drawable getTabSelectedIndicator() {
        return this.l;
    }

    public ColorStateList getTabTextColors() {
        return this.i;
    }

    public void o() {
        this.A0.clear();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() throws Resources.NotFoundException {
        super.onAttachedToWindow();
        AbstractC10961cV3.e(this);
        if (this.D0 == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                L((ViewPager) parent, true, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() throws Resources.NotFoundException {
        super.onDetachedFromWindow();
        if (this.I0) {
            setupWithViewPager(null);
            this.I0 = false;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        for (int i2 = 0; i2 < this.c.getChildCount(); i2++) {
            View childAt = this.c.getChildAt(i2);
            if (childAt instanceof TabView) {
                ((TabView) childAt).j(canvas);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        X2.g1(accessibilityNodeInfo).r0(X2.e.b(1, getTabCount(), false, 1));
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return z() && super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r7, int r8) {
        /*
            r6 = this;
            android.content.Context r0 = r6.getContext()
            int r1 = r6.getDefaultHeight()
            float r0 = ir.nasim.AbstractC10402bY7.d(r0, r1)
            int r0 = java.lang.Math.round(r0)
            int r1 = android.view.View.MeasureSpec.getMode(r8)
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 0
            r4 = 1073741824(0x40000000, float:2.0)
            r5 = 1
            if (r1 == r2) goto L2e
            if (r1 == 0) goto L1f
            goto L41
        L1f:
            int r8 = r6.getPaddingTop()
            int r0 = r0 + r8
            int r8 = r6.getPaddingBottom()
            int r0 = r0 + r8
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r4)
            goto L41
        L2e:
            int r1 = r6.getChildCount()
            if (r1 != r5) goto L41
            int r1 = android.view.View.MeasureSpec.getSize(r8)
            if (r1 < r0) goto L41
            android.view.View r1 = r6.getChildAt(r3)
            r1.setMinimumHeight(r0)
        L41:
            int r0 = android.view.View.MeasureSpec.getSize(r7)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            if (r1 == 0) goto L5f
            int r1 = r6.t
            if (r1 <= 0) goto L50
            goto L5d
        L50:
            float r0 = (float) r0
            android.content.Context r1 = r6.getContext()
            r2 = 56
            float r1 = ir.nasim.AbstractC10402bY7.d(r1, r2)
            float r0 = r0 - r1
            int r1 = (int) r0
        L5d:
            r6.r = r1
        L5f:
            super.onMeasure(r7, r8)
            int r7 = r6.getChildCount()
            if (r7 != r5) goto La9
            android.view.View r7 = r6.getChildAt(r3)
            int r0 = r6.z
            if (r0 == 0) goto L81
            if (r0 == r5) goto L76
            r1 = 2
            if (r0 == r1) goto L81
            goto La9
        L76:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 == r1) goto La9
            goto L8b
        L81:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 >= r1) goto La9
        L8b:
            int r0 = r6.getPaddingTop()
            int r1 = r6.getPaddingBottom()
            int r0 = r0 + r1
            android.view.ViewGroup$LayoutParams r1 = r7.getLayoutParams()
            int r1 = r1.height
            int r8 = android.view.ViewGroup.getChildMeasureSpec(r8, r0, r1)
            int r0 = r6.getMeasuredWidth()
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r4)
            r7.measure(r0, r8)
        La9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.onMeasure(int, int):void");
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 8 || z()) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    protected g s() {
        g gVar = (g) L0.b();
        return gVar == null ? new g() : gVar;
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        super.setElevation(f2);
        AbstractC10961cV3.d(this, f2);
    }

    public void setInlineLabel(boolean z) {
        if (this.A != z) {
            this.A = z;
            for (int i2 = 0; i2 < this.c.getChildCount(); i2++) {
                View childAt = this.c.getChildAt(i2);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).v();
                }
            }
            m();
        }
    }

    public void setInlineLabelResource(int i2) {
        setInlineLabel(getResources().getBoolean(i2));
    }

    @Deprecated
    public void setOnTabSelectedListener(d dVar) {
        setOnTabSelectedListener((c) dVar);
    }

    void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        x();
        this.C0.addListener(animatorListener);
    }

    public void setScrollPosition(int i2, float f2, boolean z) {
        setScrollPosition(i2, f2, z, true);
    }

    public void setSelectedTabIndicator(Drawable drawable) {
        if (this.l != drawable) {
            if (drawable == null) {
                drawable = new GradientDrawable();
            }
            this.l = drawable;
            int intrinsicHeight = this.D;
            if (intrinsicHeight == -1) {
                intrinsicHeight = drawable.getIntrinsicHeight();
            }
            this.c.g(intrinsicHeight);
        }
    }

    public void setSelectedTabIndicatorColor(int i2) {
        this.m = i2;
        O(false);
    }

    public void setSelectedTabIndicatorGravity(int i2) {
        if (this.y != i2) {
            this.y = i2;
            AbstractC12990fW7.g0(this.c);
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i2) {
        this.D = i2;
        this.c.g(i2);
    }

    public void setTabGravity(int i2) {
        if (this.w != i2) {
            this.w = i2;
            m();
        }
    }

    public void setTabIconTint(ColorStateList colorStateList) throws Resources.NotFoundException {
        if (this.j != colorStateList) {
            this.j = colorStateList;
            M();
        }
    }

    public void setTabIconTintResource(int i2) throws Resources.NotFoundException {
        setTabIconTint(AbstractC9594aE.a(getContext(), i2));
    }

    public void setTabIndicatorAnimationMode(int i2) {
        this.G = i2;
        if (i2 == 0) {
            this.J = new com.google.android.material.tabs.c();
            return;
        }
        if (i2 == 1) {
            this.J = new com.google.android.material.tabs.a();
        } else {
            if (i2 == 2) {
                this.J = new com.google.android.material.tabs.b();
                return;
            }
            throw new IllegalArgumentException(i2 + " is not a valid TabIndicatorAnimationMode");
        }
    }

    public void setTabIndicatorFullWidth(boolean z) {
        this.B = z;
        this.c.e();
        AbstractC12990fW7.g0(this.c);
    }

    public void setTabMode(int i2) {
        if (i2 != this.z) {
            this.z = i2;
            m();
        }
    }

    public void setTabRippleColor(ColorStateList colorStateList) {
        if (this.k != colorStateList) {
            this.k = colorStateList;
            for (int i2 = 0; i2 < this.c.getChildCount(); i2++) {
                View childAt = this.c.getChildAt(i2);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).u(getContext());
                }
            }
        }
    }

    public void setTabRippleColorResource(int i2) {
        setTabRippleColor(AbstractC9594aE.a(getContext(), i2));
    }

    public void setTabTextColors(ColorStateList colorStateList) throws Resources.NotFoundException {
        if (this.i != colorStateList) {
            this.i = colorStateList;
            M();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(androidx.viewpager.widget.a aVar) throws Resources.NotFoundException {
        K(aVar, false);
    }

    public void setUnboundedRipple(boolean z) {
        if (this.H != z) {
            this.H = z;
            for (int i2 = 0; i2 < this.c.getChildCount(); i2++) {
                View childAt = this.c.getChildAt(i2);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).u(getContext());
                }
            }
        }
    }

    public void setUnboundedRippleResource(int i2) {
        setUnboundedRipple(getResources().getBoolean(i2));
    }

    public void setupWithViewPager(ViewPager viewPager) throws Resources.NotFoundException {
        setupWithViewPager(viewPager, true);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    public g y(int i2) {
        if (i2 < 0 || i2 >= getTabCount()) {
            return null;
        }
        return (g) this.a.get(i2);
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC12181eA5.tabStyle);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i2) throws Resources.NotFoundException {
        j(view);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Deprecated
    public void setOnTabSelectedListener(c cVar) {
        c cVar2 = this.z0;
        if (cVar2 != null) {
            F(cVar2);
        }
        this.z0 = cVar;
        if (cVar != null) {
            c(cVar);
        }
    }

    public void setScrollPosition(int i2, float f2, boolean z, boolean z2) {
        int iRound = Math.round(i2 + f2);
        if (iRound < 0 || iRound >= this.c.getChildCount()) {
            return;
        }
        if (z2) {
            this.c.f(i2, f2);
        }
        ValueAnimator valueAnimator = this.C0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.C0.cancel();
        }
        scrollTo(i2 < 0 ? 0 : n(i2, f2), 0);
        if (z) {
            setSelectedTabView(iRound);
        }
    }

    public void setupWithViewPager(ViewPager viewPager, boolean z) throws Resources.NotFoundException {
        L(viewPager, z, false);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public TabLayout(Context context, AttributeSet attributeSet, int i2) throws Resources.NotFoundException {
        int i3 = K0;
        super(AbstractC17750nV3.c(context, attributeSet, i2, i3), attributeSet, i2);
        this.a = new ArrayList();
        this.l = new GradientDrawable();
        this.m = 0;
        this.r = Integer.MAX_VALUE;
        this.D = -1;
        this.A0 = new ArrayList();
        this.J0 = new C22127ui5(12);
        Context context2 = getContext();
        setHorizontalScrollBarEnabled(false);
        f fVar = new f(context2);
        this.c = fVar;
        super.addView(fVar, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray typedArrayH = AbstractC5729Ko7.h(context2, attributeSet, GE5.TabLayout, i2, i3, GE5.TabLayout_tabTextAppearance);
        if (getBackground() instanceof ColorDrawable) {
            ColorDrawable colorDrawable = (ColorDrawable) getBackground();
            C10345bV3 c10345bV3 = new C10345bV3();
            c10345bV3.b0(ColorStateList.valueOf(colorDrawable.getColor()));
            c10345bV3.Q(context2);
            c10345bV3.a0(AbstractC12990fW7.v(this));
            AbstractC12990fW7.t0(this, c10345bV3);
        }
        setSelectedTabIndicator(AbstractC9751aV3.e(context2, typedArrayH, GE5.TabLayout_tabIndicator));
        setSelectedTabIndicatorColor(typedArrayH.getColor(GE5.TabLayout_tabIndicatorColor, 0));
        fVar.g(typedArrayH.getDimensionPixelSize(GE5.TabLayout_tabIndicatorHeight, -1));
        setSelectedTabIndicatorGravity(typedArrayH.getInt(GE5.TabLayout_tabIndicatorGravity, 0));
        setTabIndicatorAnimationMode(typedArrayH.getInt(GE5.TabLayout_tabIndicatorAnimationMode, 0));
        setTabIndicatorFullWidth(typedArrayH.getBoolean(GE5.TabLayout_tabIndicatorFullWidth, true));
        int dimensionPixelSize = typedArrayH.getDimensionPixelSize(GE5.TabLayout_tabPadding, 0);
        this.g = dimensionPixelSize;
        this.f = dimensionPixelSize;
        this.e = dimensionPixelSize;
        this.d = dimensionPixelSize;
        this.d = typedArrayH.getDimensionPixelSize(GE5.TabLayout_tabPaddingStart, dimensionPixelSize);
        this.e = typedArrayH.getDimensionPixelSize(GE5.TabLayout_tabPaddingTop, this.e);
        this.f = typedArrayH.getDimensionPixelSize(GE5.TabLayout_tabPaddingEnd, this.f);
        this.g = typedArrayH.getDimensionPixelSize(GE5.TabLayout_tabPaddingBottom, this.g);
        int resourceId = typedArrayH.getResourceId(GE5.TabLayout_tabTextAppearance, AbstractC21175tE5.TextAppearance_Design_Tab);
        this.h = resourceId;
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(resourceId, HE5.TextAppearance);
        try {
            this.o = typedArrayObtainStyledAttributes.getDimensionPixelSize(HE5.TextAppearance_android_textSize, 0);
            this.i = AbstractC9751aV3.a(context2, typedArrayObtainStyledAttributes, HE5.TextAppearance_android_textColor);
            typedArrayObtainStyledAttributes.recycle();
            if (typedArrayH.hasValue(GE5.TabLayout_tabTextColor)) {
                this.i = AbstractC9751aV3.a(context2, typedArrayH, GE5.TabLayout_tabTextColor);
            }
            if (typedArrayH.hasValue(GE5.TabLayout_tabSelectedTextColor)) {
                this.i = q(this.i.getDefaultColor(), typedArrayH.getColor(GE5.TabLayout_tabSelectedTextColor, 0));
            }
            this.j = AbstractC9751aV3.a(context2, typedArrayH, GE5.TabLayout_tabIconTint);
            this.n = AbstractC10402bY7.k(typedArrayH.getInt(GE5.TabLayout_tabIconTintMode, -1), null);
            this.k = AbstractC9751aV3.a(context2, typedArrayH, GE5.TabLayout_tabRippleColor);
            this.x = typedArrayH.getInt(GE5.TabLayout_tabIndicatorAnimationDuration, 300);
            this.s = typedArrayH.getDimensionPixelSize(GE5.TabLayout_tabMinWidth, -1);
            this.t = typedArrayH.getDimensionPixelSize(GE5.TabLayout_tabMaxWidth, -1);
            this.q = typedArrayH.getResourceId(GE5.TabLayout_tabBackground, 0);
            this.v = typedArrayH.getDimensionPixelSize(GE5.TabLayout_tabContentStart, 0);
            this.z = typedArrayH.getInt(GE5.TabLayout_tabMode, 1);
            this.w = typedArrayH.getInt(GE5.TabLayout_tabGravity, 0);
            this.A = typedArrayH.getBoolean(GE5.TabLayout_tabInlineLabel, false);
            this.H = typedArrayH.getBoolean(GE5.TabLayout_tabUnboundedRipple, false);
            typedArrayH.recycle();
            Resources resources = getResources();
            this.p = resources.getDimensionPixelSize(AbstractC12799fB5.design_tab_text_size_2line);
            this.u = resources.getDimensionPixelSize(AbstractC12799fB5.design_tab_scrollable_min_width);
            m();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) throws Resources.NotFoundException {
        j(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) throws Resources.NotFoundException {
        j(view);
    }

    public void setTabTextColors(int i2, int i3) throws Resources.NotFoundException {
        setTabTextColors(q(i2, i3));
    }

    public void setSelectedTabIndicator(int i2) {
        if (i2 != 0) {
            setSelectedTabIndicator(AbstractC9594aE.b(getContext(), i2));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }
}
