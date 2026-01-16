package com.google.android.material.appbar;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import ir.nasim.AbstractC10961cV3;
import ir.nasim.AbstractC12181eA5;
import ir.nasim.AbstractC12799fB5;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC17750nV3;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.AbstractC21175tE5;
import ir.nasim.AbstractC21710u02;
import ir.nasim.AbstractC22000uV3;
import ir.nasim.AbstractC5729Ko7;
import ir.nasim.AbstractC6732Ot;
import ir.nasim.AbstractC9594aE;
import ir.nasim.C10345bV3;
import ir.nasim.C22317v2;
import ir.nasim.DC5;
import ir.nasim.FG4;
import ir.nasim.GE5;
import ir.nasim.InterfaceC10698c3;
import ir.nasim.InterfaceC22474vI4;
import ir.nasim.InterfaceC5042Hq4;
import ir.nasim.O98;
import ir.nasim.X2;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class AppBarLayout extends LinearLayout implements CoordinatorLayout.b {
    private static final int t = AbstractC21175tE5.Widget_Design_AppBarLayout;
    private int a;
    private int b;
    private int c;
    private int d;
    private boolean e;
    private int f;
    private O98 g;
    private List h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private int m;
    private WeakReference n;
    private ValueAnimator o;
    private final List p;
    private int[] q;
    private Drawable r;
    private Behavior s;

    protected static class BaseBehavior<T extends AppBarLayout> extends HeaderBehavior<T> {
        private int k;
        private int l;
        private ValueAnimator m;
        private SavedState n;
        private WeakReference o;
        private boolean p;

        class a implements ValueAnimator.AnimatorUpdateListener {
            final /* synthetic */ CoordinatorLayout a;
            final /* synthetic */ AppBarLayout b;

            a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
                this.a = coordinatorLayout;
                this.b = appBarLayout;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                BaseBehavior.this.P(this.a, this.b, ((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }

        class b extends C22317v2 {
            b() {
            }

            @Override // ir.nasim.C22317v2
            public void g(View view, X2 x2) {
                super.g(view, x2);
                x2.R0(BaseBehavior.this.p);
                x2.p0(ScrollView.class.getName());
            }
        }

        class c implements InterfaceC10698c3 {
            final /* synthetic */ CoordinatorLayout a;
            final /* synthetic */ AppBarLayout b;
            final /* synthetic */ View c;
            final /* synthetic */ int d;

            c(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i) {
                this.a = coordinatorLayout;
                this.b = appBarLayout;
                this.c = view;
                this.d = i;
            }

            @Override // ir.nasim.InterfaceC10698c3
            public boolean a(View view, InterfaceC10698c3.a aVar) {
                BaseBehavior.this.q(this.a, this.b, this.c, 0, this.d, new int[]{0, 0}, 1);
                return true;
            }
        }

        class d implements InterfaceC10698c3 {
            final /* synthetic */ AppBarLayout a;
            final /* synthetic */ boolean b;

            d(AppBarLayout appBarLayout, boolean z) {
                this.a = appBarLayout;
                this.b = z;
            }

            @Override // ir.nasim.InterfaceC10698c3
            public boolean a(View view, InterfaceC10698c3.a aVar) {
                this.a.setExpanded(this.b);
                return true;
            }
        }

        public BaseBehavior() {
        }

        private boolean T(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view) {
            boolean z = false;
            if (M() != (-appBarLayout.getTotalScrollRange())) {
                U(coordinatorLayout, appBarLayout, X2.a.q, false);
                z = true;
            }
            if (M() != 0) {
                if (!view.canScrollVertically(-1)) {
                    U(coordinatorLayout, appBarLayout, X2.a.r, true);
                    return true;
                }
                int i = -appBarLayout.getDownNestedPreScrollRange();
                if (i != 0) {
                    AbstractC12990fW7.l0(coordinatorLayout, X2.a.r, null, new c(coordinatorLayout, appBarLayout, view, i));
                    return true;
                }
            }
            return z;
        }

        private void U(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, X2.a aVar, boolean z) {
            AbstractC12990fW7.l0(coordinatorLayout, aVar, null, new d(appBarLayout, z));
        }

        private void V(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, float f) {
            int iAbs = Math.abs(M() - i);
            float fAbs = Math.abs(f);
            W(coordinatorLayout, appBarLayout, i, fAbs > 0.0f ? Math.round((iAbs / fAbs) * 1000.0f) * 3 : (int) (((iAbs / appBarLayout.getHeight()) + 1.0f) * 150.0f));
        }

        private void W(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2) {
            int iM = M();
            if (iM == i) {
                ValueAnimator valueAnimator = this.m;
                if (valueAnimator == null || !valueAnimator.isRunning()) {
                    return;
                }
                this.m.cancel();
                return;
            }
            ValueAnimator valueAnimator2 = this.m;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.m = valueAnimator3;
                valueAnimator3.setInterpolator(AbstractC6732Ot.e);
                this.m.addUpdateListener(new a(coordinatorLayout, appBarLayout));
            } else {
                valueAnimator2.cancel();
            }
            this.m.setDuration(Math.min(i2, SetRpcStruct$ComposedRpc.GET_JWT_TOKEN_FIELD_NUMBER));
            this.m.setIntValues(iM, i);
            this.m.start();
        }

        private int X(int i, int i2, int i3) {
            return i < (i2 + i3) / 2 ? i2 : i3;
        }

        private boolean Z(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view) {
            return appBarLayout.l() && coordinatorLayout.getHeight() - view.getHeight() <= appBarLayout.getHeight();
        }

        private static boolean a0(int i, int i2) {
            return (i & i2) == i2;
        }

        private boolean b0(AppBarLayout appBarLayout) {
            int childCount = appBarLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (((LayoutParams) appBarLayout.getChildAt(i).getLayoutParams()).a != 0) {
                    return true;
                }
            }
            return false;
        }

        private View c0(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if ((childAt instanceof InterfaceC5042Hq4) || (childAt instanceof ListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        private static View d0(AppBarLayout appBarLayout, int i) {
            int iAbs = Math.abs(i);
            int childCount = appBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = appBarLayout.getChildAt(i2);
                if (iAbs >= childAt.getTop() && iAbs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        private int e0(AppBarLayout appBarLayout, int i) {
            int childCount = appBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = appBarLayout.getChildAt(i2);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (a0(layoutParams.c(), 32)) {
                    top -= ((LinearLayout.LayoutParams) layoutParams).topMargin;
                    bottom += ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                }
                int i3 = -i;
                if (top <= i3 && bottom >= i3) {
                    return i2;
                }
            }
            return -1;
        }

        private View f0(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if (((CoordinatorLayout.e) childAt.getLayoutParams()).f() instanceof ScrollingViewBehavior) {
                    return childAt;
                }
            }
            return null;
        }

        private int i0(AppBarLayout appBarLayout, int i) {
            int iAbs = Math.abs(i);
            int childCount = appBarLayout.getChildCount();
            int topInset = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= childCount) {
                    break;
                }
                View childAt = appBarLayout.getChildAt(i2);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                Interpolator interpolatorD = layoutParams.d();
                if (iAbs < childAt.getTop() || iAbs > childAt.getBottom()) {
                    i2++;
                } else if (interpolatorD != null) {
                    int iC = layoutParams.c();
                    if ((iC & 1) != 0) {
                        topInset = childAt.getHeight() + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                        if ((iC & 2) != 0) {
                            topInset -= AbstractC12990fW7.B(childAt);
                        }
                    }
                    if (AbstractC12990fW7.x(childAt)) {
                        topInset -= appBarLayout.getTopInset();
                    }
                    if (topInset > 0) {
                        float f = topInset;
                        return Integer.signum(i) * (childAt.getTop() + Math.round(f * interpolatorD.getInterpolation((iAbs - childAt.getTop()) / f)));
                    }
                }
            }
            return i;
        }

        private boolean v0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            List listW = coordinatorLayout.w(appBarLayout);
            int size = listW.size();
            for (int i = 0; i < size; i++) {
                CoordinatorLayout.Behavior behaviorF = ((CoordinatorLayout.e) ((View) listW.get(i)).getLayoutParams()).f();
                if (behaviorF instanceof ScrollingViewBehavior) {
                    return ((ScrollingViewBehavior) behaviorF).K() != 0;
                }
            }
            return false;
        }

        private void w0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            int topInset = appBarLayout.getTopInset() + appBarLayout.getPaddingTop();
            int iM = M() - topInset;
            int iE0 = e0(appBarLayout, iM);
            if (iE0 >= 0) {
                View childAt = appBarLayout.getChildAt(iE0);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int iC = layoutParams.c();
                if ((iC & 17) == 17) {
                    int topInset2 = -childAt.getTop();
                    int iB = -childAt.getBottom();
                    if (iE0 == 0 && AbstractC12990fW7.x(appBarLayout) && AbstractC12990fW7.x(childAt)) {
                        topInset2 -= appBarLayout.getTopInset();
                    }
                    if (a0(iC, 2)) {
                        iB += AbstractC12990fW7.B(childAt);
                    } else if (a0(iC, 5)) {
                        int iB2 = AbstractC12990fW7.B(childAt) + iB;
                        if (iM < iB2) {
                            topInset2 = iB2;
                        } else {
                            iB = iB2;
                        }
                    }
                    if (a0(iC, 32)) {
                        topInset2 += ((LinearLayout.LayoutParams) layoutParams).topMargin;
                        iB -= ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                    }
                    V(coordinatorLayout, appBarLayout, AbstractC22000uV3.b(X(iM, iB, topInset2) + topInset, -appBarLayout.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        private void x0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            View viewF0;
            AbstractC12990fW7.j0(coordinatorLayout, X2.a.q.b());
            AbstractC12990fW7.j0(coordinatorLayout, X2.a.r.b());
            if (appBarLayout.getTotalScrollRange() == 0 || (viewF0 = f0(coordinatorLayout)) == null || !b0(appBarLayout)) {
                return;
            }
            if (!AbstractC12990fW7.N(coordinatorLayout)) {
                AbstractC12990fW7.p0(coordinatorLayout, new b());
            }
            this.p = T(coordinatorLayout, appBarLayout, viewF0);
        }

        private void y0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, boolean z) {
            View viewD0 = d0(appBarLayout, i);
            boolean zY = false;
            if (viewD0 != null) {
                int iC = ((LayoutParams) viewD0.getLayoutParams()).c();
                if ((iC & 1) != 0) {
                    int iB = AbstractC12990fW7.B(viewD0);
                    if (i2 <= 0 || (iC & 12) == 0 ? !((iC & 2) == 0 || (-i) < (viewD0.getBottom() - iB) - appBarLayout.getTopInset()) : (-i) >= (viewD0.getBottom() - iB) - appBarLayout.getTopInset()) {
                        zY = true;
                    }
                }
            }
            if (appBarLayout.n()) {
                zY = appBarLayout.y(c0(coordinatorLayout));
            }
            boolean zV = appBarLayout.v(zY);
            if (z || (zV && v0(coordinatorLayout, appBarLayout))) {
                appBarLayout.jumpDrawablesToCurrentState();
            }
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        int M() {
            return E() + this.k;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        /* renamed from: Y, reason: merged with bridge method [inline-methods] */
        public boolean H(AppBarLayout appBarLayout) {
            WeakReference weakReference = this.o;
            if (weakReference == null) {
                return true;
            }
            View view = (View) weakReference.get();
            return (view == null || !view.isShown() || view.canScrollVertically(-1)) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        /* renamed from: g0, reason: merged with bridge method [inline-methods] */
        public int K(AppBarLayout appBarLayout) {
            return -appBarLayout.getDownNestedScrollRange();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        /* renamed from: h0, reason: merged with bridge method [inline-methods] */
        public int L(AppBarLayout appBarLayout) {
            return appBarLayout.getTotalScrollRange();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public void N(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            w0(coordinatorLayout, appBarLayout);
            if (appBarLayout.n()) {
                appBarLayout.v(appBarLayout.y(c0(coordinatorLayout)));
            }
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: k0, reason: merged with bridge method [inline-methods] */
        public boolean l(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
            boolean zL = super.l(coordinatorLayout, appBarLayout, i);
            int pendingAction = appBarLayout.getPendingAction();
            SavedState savedState = this.n;
            if (savedState == null || (pendingAction & 8) != 0) {
                if (pendingAction != 0) {
                    boolean z = (pendingAction & 4) != 0;
                    if ((pendingAction & 2) != 0) {
                        int i2 = -appBarLayout.getUpNestedPreScrollRange();
                        if (z) {
                            V(coordinatorLayout, appBarLayout, i2, 0.0f);
                        } else {
                            P(coordinatorLayout, appBarLayout, i2);
                        }
                    } else if ((pendingAction & 1) != 0) {
                        if (z) {
                            V(coordinatorLayout, appBarLayout, 0, 0.0f);
                        } else {
                            P(coordinatorLayout, appBarLayout, 0);
                        }
                    }
                }
            } else if (savedState.c) {
                P(coordinatorLayout, appBarLayout, -appBarLayout.getTotalScrollRange());
            } else if (savedState.d) {
                P(coordinatorLayout, appBarLayout, 0);
            } else {
                View childAt = appBarLayout.getChildAt(savedState.e);
                P(coordinatorLayout, appBarLayout, (-childAt.getBottom()) + (this.n.g ? AbstractC12990fW7.B(childAt) + appBarLayout.getTopInset() : Math.round(childAt.getHeight() * this.n.f)));
            }
            appBarLayout.s();
            this.n = null;
            G(AbstractC22000uV3.b(E(), -appBarLayout.getTotalScrollRange(), 0));
            y0(coordinatorLayout, appBarLayout, E(), 0, true);
            appBarLayout.o(E());
            x0(coordinatorLayout, appBarLayout);
            return zL;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: l0, reason: merged with bridge method [inline-methods] */
        public boolean m(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3, int i4) {
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.e) appBarLayout.getLayoutParams())).height != -2) {
                return super.m(coordinatorLayout, appBarLayout, i, i2, i3, i4);
            }
            coordinatorLayout.N(appBarLayout, i, i2, View.MeasureSpec.makeMeasureSpec(0, 0), i4);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: m0, reason: merged with bridge method [inline-methods] */
        public void q(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr, int i3) {
            int i4;
            int downNestedPreScrollRange;
            if (i2 != 0) {
                if (i2 < 0) {
                    i4 = -appBarLayout.getTotalScrollRange();
                    downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange() + i4;
                } else {
                    i4 = -appBarLayout.getUpNestedPreScrollRange();
                    downNestedPreScrollRange = 0;
                }
                int i5 = i4;
                int i6 = downNestedPreScrollRange;
                if (i5 != i6) {
                    iArr[1] = O(coordinatorLayout, appBarLayout, i2, i5, i6);
                }
            }
            if (appBarLayout.n()) {
                appBarLayout.v(appBarLayout.y(view));
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: n0, reason: merged with bridge method [inline-methods] */
        public void t(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
            if (i4 < 0) {
                iArr[1] = O(coordinatorLayout, appBarLayout, i4, -appBarLayout.getDownNestedScrollRange(), 0);
            }
            if (i4 == 0) {
                x0(coordinatorLayout, appBarLayout);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: o0, reason: merged with bridge method [inline-methods] */
        public void x(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            if (parcelable instanceof SavedState) {
                s0((SavedState) parcelable, true);
                super.x(coordinatorLayout, appBarLayout, this.n.a());
            } else {
                super.x(coordinatorLayout, appBarLayout, parcelable);
                this.n = null;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: p0, reason: merged with bridge method [inline-methods] */
        public Parcelable y(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            Parcelable parcelableY = super.y(coordinatorLayout, appBarLayout);
            SavedState savedStateT0 = t0(parcelableY, appBarLayout);
            return savedStateT0 == null ? parcelableY : savedStateT0;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: q0, reason: merged with bridge method [inline-methods] */
        public boolean A(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i, int i2) {
            ValueAnimator valueAnimator;
            boolean z = (i & 2) != 0 && (appBarLayout.n() || Z(coordinatorLayout, appBarLayout, view));
            if (z && (valueAnimator = this.m) != null) {
                valueAnimator.cancel();
            }
            this.o = null;
            this.l = i2;
            return z;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: r0, reason: merged with bridge method [inline-methods] */
        public void C(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i) {
            if (this.l == 0 || i == 1) {
                w0(coordinatorLayout, appBarLayout);
                if (appBarLayout.n()) {
                    appBarLayout.v(appBarLayout.y(view));
                }
            }
            this.o = new WeakReference(view);
        }

        void s0(SavedState savedState, boolean z) {
            if (this.n == null || z) {
                this.n = savedState;
            }
        }

        SavedState t0(Parcelable parcelable, AppBarLayout appBarLayout) {
            int iE = E();
            int childCount = appBarLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = appBarLayout.getChildAt(i);
                int bottom = childAt.getBottom() + iE;
                if (childAt.getTop() + iE <= 0 && bottom >= 0) {
                    if (parcelable == null) {
                        parcelable = AbsSavedState.b;
                    }
                    SavedState savedState = new SavedState(parcelable);
                    boolean z = iE == 0;
                    savedState.d = z;
                    savedState.c = !z && (-iE) >= appBarLayout.getTotalScrollRange();
                    savedState.e = i;
                    savedState.g = bottom == AbstractC12990fW7.B(childAt) + appBarLayout.getTopInset();
                    savedState.f = bottom / childAt.getHeight();
                    return savedState;
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        /* renamed from: u0, reason: merged with bridge method [inline-methods] */
        public int Q(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3) {
            int iM = M();
            int i4 = 0;
            if (i2 == 0 || iM < i2 || iM > i3) {
                this.k = 0;
            } else {
                int iB = AbstractC22000uV3.b(i, i2, i3);
                if (iM != iB) {
                    int iI0 = appBarLayout.j() ? i0(appBarLayout, iB) : iB;
                    boolean zG = G(iI0);
                    int i5 = iM - iB;
                    this.k = iB - iI0;
                    if (zG) {
                        while (i4 < appBarLayout.getChildCount()) {
                            LayoutParams layoutParams = (LayoutParams) appBarLayout.getChildAt(i4).getLayoutParams();
                            d dVarB = layoutParams.b();
                            if (dVarB != null && (layoutParams.c() & 1) != 0) {
                                dVarB.a(appBarLayout, appBarLayout.getChildAt(i4), E());
                            }
                            i4++;
                        }
                    }
                    if (!zG && appBarLayout.j()) {
                        coordinatorLayout.l(appBarLayout);
                    }
                    appBarLayout.o(E());
                    y0(coordinatorLayout, appBarLayout, iB, iB < iM ? -1 : 1, false);
                    i4 = i5;
                }
            }
            x0(coordinatorLayout, appBarLayout);
            return i4;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        protected static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = new a();
            boolean c;
            boolean d;
            int e;
            float f;
            boolean g;

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

            public SavedState(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.c = parcel.readByte() != 0;
                this.d = parcel.readByte() != 0;
                this.e = parcel.readInt();
                this.f = parcel.readFloat();
                this.g = parcel.readByte() != 0;
            }

            @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                super.writeToParcel(parcel, i);
                parcel.writeByte(this.c ? (byte) 1 : (byte) 0);
                parcel.writeByte(this.d ? (byte) 1 : (byte) 0);
                parcel.writeInt(this.e);
                parcel.writeFloat(this.f);
                parcel.writeByte(this.g ? (byte) 1 : (byte) 0);
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }
        }
    }

    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        @Override // com.google.android.material.appbar.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean D(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return super.D(coordinatorLayout, view, motionEvent);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int E() {
            return super.E();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean G(int i) {
            return super.G(i);
        }

        @Override // com.google.android.material.appbar.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return super.k(coordinatorLayout, view, motionEvent);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: k0 */
        public /* bridge */ /* synthetic */ boolean l(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
            return super.l(coordinatorLayout, appBarLayout, i);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: l0 */
        public /* bridge */ /* synthetic */ boolean m(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3, int i4) {
            return super.m(coordinatorLayout, appBarLayout, i, i2, i3, i4);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: m0 */
        public /* bridge */ /* synthetic */ void q(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr, int i3) {
            super.q(coordinatorLayout, appBarLayout, view, i, i2, iArr, i3);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: n0 */
        public /* bridge */ /* synthetic */ void t(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
            super.t(coordinatorLayout, appBarLayout, view, i, i2, i3, i4, i5, iArr);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: o0 */
        public /* bridge */ /* synthetic */ void x(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            super.x(coordinatorLayout, appBarLayout, parcelable);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: p0 */
        public /* bridge */ /* synthetic */ Parcelable y(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            return super.y(coordinatorLayout, appBarLayout);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: q0 */
        public /* bridge */ /* synthetic */ boolean A(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i, int i2) {
            return super.A(coordinatorLayout, appBarLayout, view, view2, i, i2);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: r0 */
        public /* bridge */ /* synthetic */ void C(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i) {
            super.C(coordinatorLayout, appBarLayout, view, i);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        public ScrollingViewBehavior() {
        }

        private static int R(AppBarLayout appBarLayout) {
            CoordinatorLayout.Behavior behaviorF = ((CoordinatorLayout.e) appBarLayout.getLayoutParams()).f();
            if (behaviorF instanceof BaseBehavior) {
                return ((BaseBehavior) behaviorF).M();
            }
            return 0;
        }

        private void S(View view, View view2) {
            CoordinatorLayout.Behavior behaviorF = ((CoordinatorLayout.e) view2.getLayoutParams()).f();
            if (behaviorF instanceof BaseBehavior) {
                AbstractC12990fW7.a0(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) behaviorF).k) + M()) - I(view2));
            }
        }

        private void T(View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.n()) {
                    appBarLayout.v(appBarLayout.y(view));
                }
            }
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        float J(View view) {
            int i;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int iR = R(appBarLayout);
                if ((downNestedPreScrollRange == 0 || totalScrollRange + iR > downNestedPreScrollRange) && (i = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (iR / i) + 1.0f;
                }
            }
            return 0.0f;
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        int L(View view) {
            return view instanceof AppBarLayout ? ((AppBarLayout) view).getTotalScrollRange() : super.L(view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        /* renamed from: Q, reason: merged with bridge method [inline-methods] */
        public AppBarLayout H(List list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View view = (View) list.get(i);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean e(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
            S(view, view2);
            T(view, view2);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void i(CoordinatorLayout coordinatorLayout, View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                AbstractC12990fW7.j0(coordinatorLayout, X2.a.q.b());
                AbstractC12990fW7.j0(coordinatorLayout, X2.a.r.b());
                AbstractC12990fW7.p0(coordinatorLayout, null);
            }
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean l(CoordinatorLayout coordinatorLayout, View view, int i) {
            return super.l(coordinatorLayout, view, i);
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean m(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
            return super.m(coordinatorLayout, view, i, i2, i3, i4);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean w(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            AppBarLayout appBarLayoutH = H(coordinatorLayout.u(view));
            if (appBarLayoutH != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.d;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    appBarLayoutH.setExpanded(false, !z);
                    return true;
                }
            }
            return false;
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, GE5.ScrollingViewBehavior_Layout);
            O(typedArrayObtainStyledAttributes.getDimensionPixelSize(GE5.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    class a implements InterfaceC22474vI4 {
        a() {
        }

        @Override // ir.nasim.InterfaceC22474vI4
        public O98 b(View view, O98 o98) {
            return AppBarLayout.this.p(o98);
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ C10345bV3 a;

        b(C10345bV3 c10345bV3) {
            this.a = c10345bV3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.a.a0(fFloatValue);
            if (AppBarLayout.this.r instanceof C10345bV3) {
                ((C10345bV3) AppBarLayout.this.r).a0(fFloatValue);
            }
            Iterator it = AppBarLayout.this.p.iterator();
            if (it.hasNext()) {
                AbstractC18350oW3.a(it.next());
                this.a.A();
                throw null;
            }
        }
    }

    public interface c {
        void a(AppBarLayout appBarLayout, int i);
    }

    public static abstract class d {
        public abstract void a(AppBarLayout appBarLayout, View view, float f);
    }

    public static class e extends d {
        private final Rect a = new Rect();
        private final Rect b = new Rect();

        private static void b(Rect rect, AppBarLayout appBarLayout, View view) {
            view.getDrawingRect(rect);
            appBarLayout.offsetDescendantRectToMyCoords(view, rect);
            rect.offset(0, -appBarLayout.getTopInset());
        }

        @Override // com.google.android.material.appbar.AppBarLayout.d
        public void a(AppBarLayout appBarLayout, View view, float f) {
            b(this.a, appBarLayout, view);
            float fAbs = this.a.top - Math.abs(f);
            if (fAbs > 0.0f) {
                AbstractC12990fW7.w0(view, null);
                view.setTranslationY(0.0f);
                return;
            }
            float fA = 1.0f - AbstractC22000uV3.a(Math.abs(fAbs / this.a.height()), 0.0f, 1.0f);
            float fHeight = (-fAbs) - ((this.a.height() * 0.3f) * (1.0f - (fA * fA)));
            view.setTranslationY(fHeight);
            view.getDrawingRect(this.b);
            this.b.offset(0, (int) (-fHeight));
            AbstractC12990fW7.w0(view, this.b);
        }
    }

    public interface f extends c {
    }

    public AppBarLayout(Context context) {
        this(context, null);
    }

    private void A(C10345bV3 c10345bV3, boolean z) throws Resources.NotFoundException {
        float dimension = getResources().getDimension(AbstractC12799fB5.design_appbar_elevation);
        float f2 = z ? 0.0f : dimension;
        if (!z) {
            dimension = 0.0f;
        }
        ValueAnimator valueAnimator = this.o;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f2, dimension);
        this.o = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(getResources().getInteger(DC5.app_bar_elevation_anim_duration));
        this.o.setInterpolator(AbstractC6732Ot.a);
        this.o.addUpdateListener(new b(c10345bV3));
        this.o.start();
    }

    private void B() {
        setWillNotDraw(!x());
    }

    private void e() {
        WeakReference weakReference = this.n;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.n = null;
    }

    private View f(View view) {
        int i;
        if (this.n == null && (i = this.m) != -1) {
            View viewFindViewById = view != null ? view.findViewById(i) : null;
            if (viewFindViewById == null && (getParent() instanceof ViewGroup)) {
                viewFindViewById = ((ViewGroup) getParent()).findViewById(this.m);
            }
            if (viewFindViewById != null) {
                this.n = new WeakReference(viewFindViewById);
            }
        }
        WeakReference weakReference = this.n;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    private boolean k() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((LayoutParams) getChildAt(i).getLayoutParams()).e()) {
                return true;
            }
        }
        return false;
    }

    private void m() {
        Behavior behavior = this.s;
        BaseBehavior.SavedState savedStateT0 = (behavior == null || this.b == -1 || this.f != 0) ? null : behavior.t0(AbsSavedState.b, this);
        this.b = -1;
        this.c = -1;
        this.d = -1;
        if (savedStateT0 != null) {
            this.s.s0(savedStateT0, false);
        }
    }

    private void t(boolean z, boolean z2, boolean z3) {
        this.f = (z ? 1 : 2) | (z2 ? 4 : 0) | (z3 ? 8 : 0);
        requestLayout();
    }

    private boolean u(boolean z) {
        if (this.j == z) {
            return false;
        }
        this.j = z;
        refreshDrawableState();
        return true;
    }

    private boolean x() {
        return this.r != null && getTopInset() > 0;
    }

    private boolean z() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        return (childAt.getVisibility() == 8 || AbstractC12990fW7.x(childAt)) ? false : true;
    }

    public void c(c cVar) {
        if (this.h == null) {
            this.h = new ArrayList();
        }
        if (cVar == null || this.h.contains(cVar)) {
            return;
        }
        this.h.add(cVar);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void d(f fVar) {
        c(fVar);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (x()) {
            int iSave = canvas.save();
            canvas.translate(0.0f, -this.a);
            this.r.draw(canvas);
            canvas.restoreToCount(iSave);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.r;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.Behavior<AppBarLayout> getBehavior() {
        Behavior behavior = new Behavior();
        this.s = behavior;
        return behavior;
    }

    int getDownNestedPreScrollRange() {
        int iMin;
        int iB;
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = layoutParams.a;
            if ((i3 & 5) != 5) {
                if (i2 > 0) {
                    break;
                }
            } else {
                int i4 = ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                if ((i3 & 8) != 0) {
                    iB = AbstractC12990fW7.B(childAt);
                } else if ((i3 & 2) != 0) {
                    iB = measuredHeight - AbstractC12990fW7.B(childAt);
                } else {
                    iMin = i4 + measuredHeight;
                    if (childCount == 0 && AbstractC12990fW7.x(childAt)) {
                        iMin = Math.min(iMin, measuredHeight - getTopInset());
                    }
                    i2 += iMin;
                }
                iMin = i4 + iB;
                if (childCount == 0) {
                    iMin = Math.min(iMin, measuredHeight - getTopInset());
                }
                i2 += iMin;
            }
        }
        int iMax = Math.max(0, i2);
        this.c = iMax;
        return iMax;
    }

    int getDownNestedScrollRange() {
        int i = this.d;
        if (i != -1) {
            return i;
        }
        int childCount = getChildCount();
        int i2 = 0;
        int iB = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
            int i3 = layoutParams.a;
            if ((i3 & 1) == 0) {
                break;
            }
            iB += measuredHeight;
            if ((i3 & 2) != 0) {
                iB -= AbstractC12990fW7.B(childAt);
                break;
            }
            i2++;
        }
        int iMax = Math.max(0, iB);
        this.d = iMax;
        return iMax;
    }

    public int getLiftOnScrollTargetViewId() {
        return this.m;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int iB = AbstractC12990fW7.B(this);
        if (iB == 0) {
            int childCount = getChildCount();
            iB = childCount >= 1 ? AbstractC12990fW7.B(getChildAt(childCount - 1)) : 0;
            if (iB == 0) {
                return getHeight() / 3;
            }
        }
        return (iB * 2) + topInset;
    }

    int getPendingAction() {
        return this.f;
    }

    public Drawable getStatusBarForeground() {
        return this.r;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    final int getTopInset() {
        O98 o98 = this.g;
        if (o98 != null) {
            return o98.m();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i = this.b;
        if (i != -1) {
            return i;
        }
        int childCount = getChildCount();
        int i2 = 0;
        int iB = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = layoutParams.a;
            if ((i3 & 1) == 0) {
                break;
            }
            iB += measuredHeight + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
            if (i2 == 0 && AbstractC12990fW7.x(childAt)) {
                iB -= getTopInset();
            }
            if ((i3 & 2) != 0) {
                iB -= AbstractC12990fW7.B(childAt);
                break;
            }
            i2++;
        }
        int iMax = Math.max(0, iB);
        this.b = iMax;
        return iMax;
    }

    int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LinearLayout.LayoutParams ? new LayoutParams((LinearLayout.LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    boolean j() {
        return this.e;
    }

    boolean l() {
        return getTotalScrollRange() != 0;
    }

    public boolean n() {
        return this.l;
    }

    void o(int i) {
        this.a = i;
        if (!willNotDraw()) {
            AbstractC12990fW7.g0(this);
        }
        List list = this.h;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                c cVar = (c) this.h.get(i2);
                if (cVar != null) {
                    cVar.a(this, i);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        AbstractC10961cV3.e(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i) {
        if (this.q == null) {
            this.q = new int[4];
        }
        int[] iArr = this.q;
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + iArr.length);
        boolean z = this.j;
        int i2 = AbstractC12181eA5.state_liftable;
        if (!z) {
            i2 = -i2;
        }
        iArr[0] = i2;
        iArr[1] = (z && this.k) ? AbstractC12181eA5.state_lifted : -AbstractC12181eA5.state_lifted;
        int i3 = AbstractC12181eA5.state_collapsible;
        if (!z) {
            i3 = -i3;
        }
        iArr[2] = i3;
        iArr[3] = (z && this.k) ? AbstractC12181eA5.state_collapsed : -AbstractC12181eA5.state_collapsed;
        return View.mergeDrawableStates(iArrOnCreateDrawableState, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        boolean z2 = true;
        if (AbstractC12990fW7.x(this) && z()) {
            int topInset = getTopInset();
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                AbstractC12990fW7.a0(getChildAt(childCount), topInset);
            }
        }
        m();
        this.e = false;
        int childCount2 = getChildCount();
        int i5 = 0;
        while (true) {
            if (i5 >= childCount2) {
                break;
            }
            if (((LayoutParams) getChildAt(i5).getLayoutParams()).d() != null) {
                this.e = true;
                break;
            }
            i5++;
        }
        Drawable drawable = this.r;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (this.i) {
            return;
        }
        if (!this.l && !k()) {
            z2 = false;
        }
        u(z2);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i2);
        if (mode != 1073741824 && AbstractC12990fW7.x(this) && z()) {
            int measuredHeight = getMeasuredHeight();
            if (mode == Integer.MIN_VALUE) {
                measuredHeight = AbstractC22000uV3.b(getMeasuredHeight() + getTopInset(), 0, View.MeasureSpec.getSize(i2));
            } else if (mode == 0) {
                measuredHeight += getTopInset();
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
        m();
    }

    O98 p(O98 o98) {
        O98 o982 = AbstractC12990fW7.x(this) ? o98 : null;
        if (!FG4.a(this.g, o982)) {
            this.g = o982;
            B();
            requestLayout();
        }
        return o98;
    }

    public void q(c cVar) {
        List list = this.h;
        if (list == null || cVar == null) {
            return;
        }
        list.remove(cVar);
    }

    public void r(f fVar) {
        q(fVar);
    }

    void s() {
        this.f = 0;
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        super.setElevation(f2);
        AbstractC10961cV3.d(this, f2);
    }

    public void setExpanded(boolean z) {
        setExpanded(z, AbstractC12990fW7.T(this));
    }

    public void setLiftOnScroll(boolean z) {
        this.l = z;
    }

    public void setLiftOnScrollTargetViewId(int i) {
        this.m = i;
        e();
    }

    public void setLiftableOverrideEnabled(boolean z) {
        this.i = z;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i) {
        if (i != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i);
    }

    public void setStatusBarForeground(Drawable drawable) {
        Drawable drawable2 = this.r;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.r = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.r.setState(getDrawableState());
                }
                AbstractC21710u02.g(this.r, AbstractC12990fW7.A(this));
                this.r.setVisible(getVisibility() == 0, false);
                this.r.setCallback(this);
            }
            B();
            AbstractC12990fW7.g0(this);
        }
    }

    public void setStatusBarForegroundColor(int i) {
        setStatusBarForeground(new ColorDrawable(i));
    }

    public void setStatusBarForegroundResource(int i) {
        setStatusBarForeground(AbstractC9594aE.b(getContext(), i));
    }

    @Deprecated
    public void setTargetElevation(float f2) throws Resources.NotFoundException {
        com.google.android.material.appbar.b.b(this, f2);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.r;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
    }

    boolean v(boolean z) {
        return w(z, !this.i);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.r;
    }

    boolean w(boolean z, boolean z2) throws Resources.NotFoundException {
        if (!z2 || this.k == z) {
            return false;
        }
        this.k = z;
        refreshDrawableState();
        if (!this.l || !(getBackground() instanceof C10345bV3)) {
            return true;
        }
        A((C10345bV3) getBackground(), z);
        return true;
    }

    boolean y(View view) {
        View viewF = f(view);
        if (viewF != null) {
            view = viewF;
        }
        return view != null && (view.canScrollVertically(-1) || view.getScrollY() > 0);
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC12181eA5.appBarLayoutStyle);
    }

    public void setExpanded(boolean z, boolean z2) {
        t(z, z2, true);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AppBarLayout(Context context, AttributeSet attributeSet, int i) throws Resources.NotFoundException {
        int i2 = t;
        super(AbstractC17750nV3.c(context, attributeSet, i, i2), attributeSet, i);
        this.b = -1;
        this.c = -1;
        this.d = -1;
        this.f = 0;
        this.p = new ArrayList();
        Context context2 = getContext();
        setOrientation(1);
        int i3 = Build.VERSION.SDK_INT;
        if (getOutlineProvider() == ViewOutlineProvider.BACKGROUND) {
            com.google.android.material.appbar.b.a(this);
        }
        com.google.android.material.appbar.b.c(this, attributeSet, i, i2);
        TypedArray typedArrayH = AbstractC5729Ko7.h(context2, attributeSet, GE5.AppBarLayout, i, i2, new int[0]);
        AbstractC12990fW7.t0(this, typedArrayH.getDrawable(GE5.AppBarLayout_android_background));
        if (getBackground() instanceof ColorDrawable) {
            ColorDrawable colorDrawable = (ColorDrawable) getBackground();
            C10345bV3 c10345bV3 = new C10345bV3();
            c10345bV3.b0(ColorStateList.valueOf(colorDrawable.getColor()));
            c10345bV3.Q(context2);
            AbstractC12990fW7.t0(this, c10345bV3);
        }
        if (typedArrayH.hasValue(GE5.AppBarLayout_expanded)) {
            t(typedArrayH.getBoolean(GE5.AppBarLayout_expanded, false), false, false);
        }
        if (typedArrayH.hasValue(GE5.AppBarLayout_elevation)) {
            com.google.android.material.appbar.b.b(this, typedArrayH.getDimensionPixelSize(GE5.AppBarLayout_elevation, 0));
        }
        if (i3 >= 26) {
            if (typedArrayH.hasValue(GE5.AppBarLayout_android_keyboardNavigationCluster)) {
                setKeyboardNavigationCluster(typedArrayH.getBoolean(GE5.AppBarLayout_android_keyboardNavigationCluster, false));
            }
            if (typedArrayH.hasValue(GE5.AppBarLayout_android_touchscreenBlocksFocus)) {
                setTouchscreenBlocksFocus(typedArrayH.getBoolean(GE5.AppBarLayout_android_touchscreenBlocksFocus, false));
            }
        }
        this.l = typedArrayH.getBoolean(GE5.AppBarLayout_liftOnScroll, false);
        this.m = typedArrayH.getResourceId(GE5.AppBarLayout_liftOnScrollTargetViewId, -1);
        setStatusBarForeground(typedArrayH.getDrawable(GE5.AppBarLayout_statusBarForeground));
        typedArrayH.recycle();
        AbstractC12990fW7.E0(this, new a());
    }

    public static class LayoutParams extends LinearLayout.LayoutParams {
        int a;
        private d b;
        Interpolator c;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = 1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, GE5.AppBarLayout_Layout);
            this.a = typedArrayObtainStyledAttributes.getInt(GE5.AppBarLayout_Layout_layout_scrollFlags, 0);
            f(a(typedArrayObtainStyledAttributes.getInt(GE5.AppBarLayout_Layout_layout_scrollEffect, 0)));
            if (typedArrayObtainStyledAttributes.hasValue(GE5.AppBarLayout_Layout_layout_scrollInterpolator)) {
                this.c = AnimationUtils.loadInterpolator(context, typedArrayObtainStyledAttributes.getResourceId(GE5.AppBarLayout_Layout_layout_scrollInterpolator, 0));
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        private d a(int i) {
            if (i != 1) {
                return null;
            }
            return new e();
        }

        public d b() {
            return this.b;
        }

        public int c() {
            return this.a;
        }

        public Interpolator d() {
            return this.c;
        }

        boolean e() {
            int i = this.a;
            return (i & 1) == 1 && (i & 10) != 0;
        }

        public void f(d dVar) {
            this.b = dVar;
        }

        public void g(int i) {
            this.a = i;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.a = 1;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 1;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.a = 1;
        }

        public LayoutParams(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 1;
        }
    }
}
