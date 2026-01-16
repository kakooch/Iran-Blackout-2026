package ir.nasim.tgwidgets.editor.ui.ActionBar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import androidx.annotation.Keep;
import ir.nasim.AbstractC13840gu3;
import ir.nasim.AbstractC18763pC5;
import ir.nasim.AbstractC23598xB5;
import ir.nasim.AbstractC6403Nl2;
import ir.nasim.C4347Et;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarPopupWindow;
import ir.nasim.tgwidgets.editor.ui.ActionBar.m;
import ir.nasim.tgwidgets.editor.ui.Components.PopupSwipeBackLayout;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes7.dex */
public class ActionBarPopupWindow extends PopupWindow {
    private static Method i;
    private static final Field j;
    private static final boolean k = true;
    private static DecelerateInterpolator l = new DecelerateInterpolator();
    private static final ViewTreeObserver.OnScrollChangedListener m;
    private AnimatorSet a;
    private boolean b;
    private int c;
    private boolean d;
    private long e;
    private ViewTreeObserver.OnScrollChangedListener f;
    private ViewTreeObserver g;
    private C4347Et h;

    public static class ActionBarPopupWindowLayout extends FrameLayout {
        Path A;
        public boolean a;
        public boolean b;
        private d c;
        private float d;
        private float e;
        private boolean f;
        private int g;
        private int h;
        public boolean i;
        private boolean j;
        private ArrayList k;
        private HashMap l;
        private int m;
        private int n;
        private Rect o;
        private float p;
        private PopupSwipeBackLayout q;
        private ScrollView r;
        protected LinearLayout s;
        private int t;
        protected Drawable u;
        private boolean v;
        private final m.h w;
        private View x;
        public int y;
        Rect z;

        class a implements ViewTreeObserver.OnScrollChangedListener {
            a() {
            }

            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                ActionBarPopupWindowLayout.this.invalidate();
            }
        }

        class b extends LinearLayout {
            b(Context context) {
                super(context);
            }

            @Override // android.view.ViewGroup
            protected boolean drawChild(Canvas canvas, View view, long j) {
                if (view instanceof GapView) {
                    return false;
                }
                return super.drawChild(canvas, view, j);
            }

            /* JADX WARN: Removed duplicated region for block: B:22:0x0094  */
            @Override // android.widget.LinearLayout, android.view.View
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            protected void onMeasure(int r18, int r19) {
                /*
                    r17 = this;
                    r6 = r17
                    ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarPopupWindow$ActionBarPopupWindowLayout r0 = ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarPopupWindow.ActionBarPopupWindowLayout.this
                    boolean r0 = ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarPopupWindow.ActionBarPopupWindowLayout.b(r0)
                    if (r0 == 0) goto Lba
                    ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarPopupWindow$ActionBarPopupWindowLayout r0 = ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarPopupWindow.ActionBarPopupWindowLayout.this
                    r1 = -1000000(0xfffffffffff0bdc0, float:NaN)
                    ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarPopupWindow.ActionBarPopupWindowLayout.g(r0, r1)
                    ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarPopupWindow$ActionBarPopupWindowLayout r0 = ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarPopupWindow.ActionBarPopupWindowLayout.this
                    ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarPopupWindow.ActionBarPopupWindowLayout.f(r0, r1)
                    int r7 = r17.getChildCount()
                    r8 = 0
                    r0 = 0
                    r9 = r0
                    r10 = r8
                    r11 = r10
                    r12 = r11
                L21:
                    if (r10 >= r7) goto L9f
                    android.view.View r13 = r6.getChildAt(r10)
                    int r0 = r13.getVisibility()
                    r1 = 8
                    if (r0 != r1) goto L30
                    goto L9c
                L30:
                    int r0 = ir.nasim.AbstractC18763pC5.width_tag
                    java.lang.Object r14 = r13.getTag(r0)
                    int r0 = ir.nasim.AbstractC18763pC5.object_tag
                    java.lang.Object r15 = r13.getTag(r0)
                    int r0 = ir.nasim.AbstractC18763pC5.fit_width_tag
                    java.lang.Object r16 = r13.getTag(r0)
                    if (r14 == 0) goto L4b
                    android.view.ViewGroup$LayoutParams r0 = r13.getLayoutParams()
                    r1 = -2
                    r0.width = r1
                L4b:
                    r3 = 0
                    r5 = 0
                    r0 = r17
                    r1 = r13
                    r2 = r18
                    r4 = r19
                    r0.measureChildWithMargins(r1, r2, r3, r4, r5)
                    if (r16 == 0) goto L5a
                    goto L92
                L5a:
                    boolean r0 = r14 instanceof java.lang.Integer
                    if (r0 != 0) goto L69
                    if (r15 != 0) goto L69
                    int r0 = r13.getMeasuredWidth()
                    int r11 = java.lang.Math.max(r11, r0)
                    goto L9c
                L69:
                    if (r0 == 0) goto L92
                    java.lang.Integer r14 = (java.lang.Integer) r14
                    int r0 = r14.intValue()
                    int r1 = r13.getMeasuredWidth()
                    int r12 = java.lang.Math.max(r0, r1)
                    ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarPopupWindow$ActionBarPopupWindowLayout r0 = ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarPopupWindow.ActionBarPopupWindowLayout.this
                    int r1 = r13.getMeasuredHeight()
                    ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarPopupWindow.ActionBarPopupWindowLayout.g(r0, r1)
                    ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarPopupWindow$ActionBarPopupWindowLayout r0 = ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarPopupWindow.ActionBarPopupWindowLayout.this
                    int r1 = ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarPopupWindow.ActionBarPopupWindowLayout.c(r0)
                    r2 = 1086324736(0x40c00000, float:6.0)
                    int r2 = ir.nasim.tgwidgets.editor.messenger.AbstractC21455b.F(r2)
                    int r1 = r1 + r2
                    ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarPopupWindow.ActionBarPopupWindowLayout.f(r0, r1)
                L92:
                    if (r9 != 0) goto L99
                    java.util.ArrayList r9 = new java.util.ArrayList
                    r9.<init>()
                L99:
                    r9.add(r13)
                L9c:
                    int r10 = r10 + 1
                    goto L21
                L9f:
                    if (r9 == 0) goto Lba
                    int r0 = r9.size()
                La5:
                    if (r8 >= r0) goto Lba
                    java.lang.Object r1 = r9.get(r8)
                    android.view.View r1 = (android.view.View) r1
                    android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
                    int r2 = java.lang.Math.max(r11, r12)
                    r1.width = r2
                    int r8 = r8 + 1
                    goto La5
                Lba:
                    super.onMeasure(r18, r19)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarPopupWindow.ActionBarPopupWindowLayout.b.onMeasure(int, int):void");
            }
        }

        class c extends AnimatorListenerAdapter {
            final /* synthetic */ AnimatorSet a;
            final /* synthetic */ View b;

            c(AnimatorSet animatorSet, View view) {
                this.a = animatorSet;
                this.b = view;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ActionBarPopupWindowLayout.this.k.remove(this.a);
                View view = this.b;
                if (view instanceof ActionBarMenuSubItem) {
                    ((ActionBarMenuSubItem) view).b();
                }
            }
        }

        public ActionBarPopupWindowLayout(Context context) {
            this(context, null);
        }

        private void p(View view) {
            if (this.j) {
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 0.0f, view.isEnabled() ? 1.0f : 0.5f), ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_Y, AbstractC21455b.F(this.i ? 6.0f : -6.0f), 0.0f));
                animatorSet.setDuration(180L);
                animatorSet.addListener(new c(animatorSet, view));
                animatorSet.setInterpolator(ActionBarPopupWindow.l);
                animatorSet.start();
                if (this.k == null) {
                    this.k = new ArrayList();
                }
                this.k.add(animatorSet);
            }
        }

        @Override // android.view.ViewGroup
        public void addView(View view) {
            this.s.addView(view);
        }

        /* JADX WARN: Removed duplicated region for block: B:108:0x027c A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00f9  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x00fc  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x0105  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x0120  */
        /* JADX WARN: Removed duplicated region for block: B:67:0x01ab  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x01d6  */
        /* JADX WARN: Removed duplicated region for block: B:92:0x0279  */
        @Override // android.view.ViewGroup, android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected void dispatchDraw(android.graphics.Canvas r21) {
            /*
                Method dump skipped, instructions count: 698
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarPopupWindow.ActionBarPopupWindowLayout.dispatchDraw(android.graphics.Canvas):void");
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            d dVar = this.c;
            if (dVar != null) {
                dVar.onDispatchKeyEvent(keyEvent);
            }
            return super.dispatchKeyEvent(keyEvent);
        }

        public int getBackgroundColor() {
            return this.t;
        }

        public int getItemsCount() {
            return this.s.getChildCount();
        }

        public PopupSwipeBackLayout getSwipeBack() {
            return this.q;
        }

        public void j(View view, LinearLayout.LayoutParams layoutParams) {
            this.s.addView(view, layoutParams);
        }

        public int k(View view) {
            this.q.addView(view, AbstractC13840gu3.d(-2, -2, this.i ? 80 : 48));
            return this.q.getChildCount() - 1;
        }

        public View l(int i) {
            return this.s.getChildAt(i);
        }

        protected int m(int i) {
            return m.j0(i, this.w);
        }

        public void n() {
            this.s.removeAllViews();
        }

        public void o() {
            ScrollView scrollView = this.r;
            if (scrollView != null) {
                scrollView.scrollTo(0, 0);
            }
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            PopupSwipeBackLayout popupSwipeBackLayout = this.q;
            if (popupSwipeBackLayout != null) {
                popupSwipeBackLayout.v(!this.f);
            }
        }

        public void q() {
            int childCount = this.s.getChildCount();
            View view = null;
            View view2 = null;
            for (int i = 0; i < childCount; i++) {
                View childAt = this.s.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    if (view == null) {
                        view = childAt;
                    }
                    view2 = childAt;
                }
            }
            boolean z = false;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt2 = this.s.getChildAt(i2);
                if (childAt2.getVisibility() == 0) {
                    Object tag = childAt2.getTag(AbstractC18763pC5.object_tag);
                    if (childAt2 instanceof ActionBarMenuSubItem) {
                        ((ActionBarMenuSubItem) childAt2).f(childAt2 == view || z, childAt2 == view2);
                    }
                    z = tag != null;
                }
            }
        }

        public void setAnimationEnabled(boolean z) {
            this.j = z;
        }

        @Keep
        public void setBackScaleX(float f) {
            if (this.d != f) {
                this.d = f;
                invalidate();
            }
        }

        @Keep
        public void setBackScaleY(float f) {
            if (this.e != f) {
                this.e = f;
                if (this.j && this.a) {
                    int measuredHeight = getMeasuredHeight() - AbstractC21455b.F(16.0f);
                    if (this.i) {
                        for (int i = this.h; i >= 0; i--) {
                            View viewL = l(i);
                            if (viewL != null && viewL.getVisibility() == 0 && !(viewL instanceof GapView)) {
                                if (((Integer) this.l.get(viewL)) != null && measuredHeight - ((r3.intValue() * AbstractC21455b.F(48.0f)) + AbstractC21455b.F(32.0f)) > measuredHeight * f) {
                                    break;
                                }
                                this.h = i - 1;
                                p(viewL);
                            }
                        }
                    } else {
                        int itemsCount = getItemsCount();
                        int measuredHeight2 = 0;
                        for (int i2 = 0; i2 < itemsCount; i2++) {
                            View viewL2 = l(i2);
                            if (viewL2.getVisibility() == 0) {
                                measuredHeight2 += viewL2.getMeasuredHeight();
                                if (i2 < this.h) {
                                    continue;
                                } else {
                                    if (((Integer) this.l.get(viewL2)) != null && measuredHeight2 - AbstractC21455b.F(24.0f) > measuredHeight * f) {
                                        break;
                                    }
                                    this.h = i2 + 1;
                                    p(viewL2);
                                }
                            }
                        }
                    }
                }
                invalidate();
            }
        }

        @Override // android.view.View
        public void setBackgroundColor(int i) {
            Drawable drawable;
            if (this.t == i || (drawable = this.u) == null) {
                return;
            }
            this.t = i;
            drawable.setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.MULTIPLY));
        }

        @Override // android.view.View
        public void setBackgroundDrawable(Drawable drawable) {
            this.t = -1;
            this.u = drawable;
            if (drawable != null) {
                drawable.getPadding(this.o);
            }
        }

        public void setDispatchKeyEventListener(d dVar) {
            this.c = dVar;
        }

        public void setFitItems(boolean z) {
            this.v = z;
        }

        public void setShownFromBottom(boolean z) {
            this.i = z;
        }

        public void setSwipeBackForegroundColor(int i) {
            getSwipeBack().setForegroundColor(i);
        }

        public void setTopView(View view) {
            this.x = view;
        }

        public void setupRadialSelectors(int i) {
            int childCount = this.s.getChildCount();
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = this.s.getChildAt(i2);
                int i3 = 6;
                int i4 = i2 == 0 ? 6 : 0;
                if (i2 != childCount - 1) {
                    i3 = 0;
                }
                childAt.setBackground(m.U(i, i4, i3));
                i2++;
            }
        }

        public ActionBarPopupWindowLayout(Context context, m.h hVar) {
            this(context, AbstractC23598xB5.popup_fixed_alert2, hVar);
        }

        public ActionBarPopupWindowLayout(Context context, int i, m.h hVar) {
            this(context, i, hVar, 0);
        }

        public ActionBarPopupWindowLayout(Context context, int i, m.h hVar, int i2) {
            super(context);
            this.d = 1.0f;
            this.e = 1.0f;
            this.f = false;
            this.g = 255;
            this.h = 0;
            this.j = ActionBarPopupWindow.k;
            this.l = new HashMap();
            this.m = -1000000;
            this.n = -1000000;
            this.o = new Rect();
            this.p = 1.0f;
            this.t = -1;
            this.w = hVar;
            if (i != 0) {
                this.u = getResources().getDrawable(i).mutate();
                setPadding(AbstractC21455b.F(8.0f), AbstractC21455b.F(8.0f), AbstractC21455b.F(8.0f), AbstractC21455b.F(8.0f));
            }
            Drawable drawable = this.u;
            if (drawable != null) {
                drawable.getPadding(this.o);
                setBackgroundColor(m(m.n7));
            }
            setWillNotDraw(false);
            if ((i2 & 2) > 0) {
                this.i = true;
            }
            if ((i2 & 1) > 0) {
                PopupSwipeBackLayout popupSwipeBackLayout = new PopupSwipeBackLayout(context, hVar);
                this.q = popupSwipeBackLayout;
                addView(popupSwipeBackLayout, AbstractC13840gu3.b(-2, -2.0f));
            }
            try {
                ScrollView scrollView = new ScrollView(context);
                this.r = scrollView;
                scrollView.getViewTreeObserver().addOnScrollChangedListener(new a());
                this.r.setVerticalScrollBarEnabled(false);
                PopupSwipeBackLayout popupSwipeBackLayout2 = this.q;
                if (popupSwipeBackLayout2 != null) {
                    popupSwipeBackLayout2.addView(this.r, AbstractC13840gu3.d(-2, -2, this.i ? 80 : 48));
                } else {
                    addView(this.r, AbstractC13840gu3.b(-2, -2.0f));
                }
            } catch (Throwable th) {
                AbstractC6403Nl2.d(th);
            }
            b bVar = new b(context);
            this.s = bVar;
            bVar.setOrientation(1);
            ScrollView scrollView2 = this.r;
            if (scrollView2 != null) {
                scrollView2.addView(this.s, new FrameLayout.LayoutParams(-2, -2));
                return;
            }
            PopupSwipeBackLayout popupSwipeBackLayout3 = this.q;
            if (popupSwipeBackLayout3 != null) {
                popupSwipeBackLayout3.addView(this.s, AbstractC13840gu3.d(-2, -2, this.i ? 80 : 48));
            } else {
                addView(this.s, AbstractC13840gu3.b(-2, -2.0f));
            }
        }
    }

    class a extends AnimatorListenerAdapter {
        final /* synthetic */ ActionBarPopupWindowLayout a;

        a(ActionBarPopupWindowLayout actionBarPopupWindowLayout) {
            this.a = actionBarPopupWindowLayout;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.f = false;
            int itemsCount = this.a.getItemsCount();
            for (int i = 0; i < itemsCount; i++) {
                View viewL = this.a.l(i);
                if (!(viewL instanceof GapView)) {
                    viewL.setAlpha(viewL.isEnabled() ? 1.0f : 0.5f);
                }
            }
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ActionBarPopupWindowLayout actionBarPopupWindowLayout;
            ActionBarPopupWindowLayout actionBarPopupWindowLayout2 = null;
            ActionBarPopupWindow.this.a = null;
            ViewGroup viewGroup = (ViewGroup) ActionBarPopupWindow.this.getContentView();
            if (viewGroup instanceof ActionBarPopupWindowLayout) {
                actionBarPopupWindowLayout = (ActionBarPopupWindowLayout) viewGroup;
                actionBarPopupWindowLayout.f = false;
            } else {
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    if (viewGroup.getChildAt(i) instanceof ActionBarPopupWindowLayout) {
                        actionBarPopupWindowLayout2 = (ActionBarPopupWindowLayout) viewGroup.getChildAt(i);
                        actionBarPopupWindowLayout2.f = false;
                    }
                }
                actionBarPopupWindowLayout = actionBarPopupWindowLayout2;
            }
            int itemsCount = actionBarPopupWindowLayout.getItemsCount();
            for (int i2 = 0; i2 < itemsCount; i2++) {
                View viewL = actionBarPopupWindowLayout.l(i2);
                if (!(viewL instanceof GapView)) {
                    viewL.setAlpha(viewL.isEnabled() ? 1.0f : 0.5f);
                }
            }
        }
    }

    class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ActionBarPopupWindow.this.a = null;
            ActionBarPopupWindow.this.d = false;
            ActionBarPopupWindow.this.setFocusable(false);
            try {
                ActionBarPopupWindow.super.dismiss();
            } catch (Exception unused) {
            }
            ActionBarPopupWindow.this.v();
        }
    }

    public interface d {
        void onDispatchKeyEvent(KeyEvent keyEvent);
    }

    static {
        Field declaredField = null;
        try {
            declaredField = PopupWindow.class.getDeclaredField("mOnScrollChangedListener");
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException unused) {
        }
        j = declaredField;
        m = new ViewTreeObserver.OnScrollChangedListener() { // from class: ir.nasim.t5
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                ActionBarPopupWindow.p();
            }
        };
    }

    public ActionBarPopupWindow(View view, int i2, int i3) throws IllegalAccessException, IllegalArgumentException {
        super(view, i2, i3);
        this.b = k;
        this.c = 150;
        this.e = -1L;
        this.h = new C4347Et();
        m();
    }

    private void l() {
        View rootView = getContentView().getRootView();
        WindowManager windowManager = (WindowManager) getContentView().getContext().getSystemService("window");
        if (rootView.getLayoutParams() == null || !(rootView.getLayoutParams() instanceof WindowManager.LayoutParams)) {
            return;
        }
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) rootView.getLayoutParams();
        try {
            int i2 = layoutParams.flags;
            if ((i2 & 2) != 0) {
                layoutParams.flags = i2 & (-3);
                layoutParams.dimAmount = 0.0f;
                windowManager.updateViewLayout(rootView, layoutParams);
            }
        } catch (Exception unused) {
        }
    }

    private void m() throws IllegalAccessException, IllegalArgumentException {
        View contentView = getContentView();
        if (contentView instanceof ActionBarPopupWindowLayout) {
            ActionBarPopupWindowLayout actionBarPopupWindowLayout = (ActionBarPopupWindowLayout) contentView;
            if (actionBarPopupWindowLayout.getSwipeBack() != null) {
                actionBarPopupWindowLayout.getSwipeBack().setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.u5
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.a.n(view);
                    }
                });
            }
        }
        Field field = j;
        if (field != null) {
            try {
                this.f = (ViewTreeObserver.OnScrollChangedListener) field.get(this);
                field.set(this, m);
            } catch (Exception unused) {
                this.f = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(View view) {
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void o(ActionBarPopupWindowLayout actionBarPopupWindowLayout, ValueAnimator valueAnimator) {
        int itemsCount = actionBarPopupWindowLayout.getItemsCount();
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        for (int i2 = 0; i2 < itemsCount; i2++) {
            View viewL = actionBarPopupWindowLayout.l(i2);
            if (!(viewL instanceof GapView)) {
                viewL.setTranslationY((1.0f - AbstractC21455b.u(fFloatValue, actionBarPopupWindowLayout.i ? (itemsCount - 1) - i2 : i2, itemsCount, 4.0f)) * AbstractC21455b.F(-6.0f));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void p() {
    }

    private void q(View view) {
        if (this.f != null) {
            ViewTreeObserver viewTreeObserver = view.getWindowToken() != null ? view.getViewTreeObserver() : null;
            ViewTreeObserver viewTreeObserver2 = this.g;
            if (viewTreeObserver != viewTreeObserver2) {
                if (viewTreeObserver2 != null && viewTreeObserver2.isAlive()) {
                    this.g.removeOnScrollChangedListener(this.f);
                }
                this.g = viewTreeObserver;
                if (viewTreeObserver != null) {
                    viewTreeObserver.addOnScrollChangedListener(this.f);
                }
            }
        }
    }

    public static AnimatorSet t(final ActionBarPopupWindowLayout actionBarPopupWindowLayout) {
        actionBarPopupWindowLayout.f = true;
        actionBarPopupWindowLayout.setTranslationY(0.0f);
        float f = 1.0f;
        actionBarPopupWindowLayout.setAlpha(1.0f);
        actionBarPopupWindowLayout.setPivotX(actionBarPopupWindowLayout.getMeasuredWidth());
        actionBarPopupWindowLayout.setPivotY(0.0f);
        int itemsCount = actionBarPopupWindowLayout.getItemsCount();
        actionBarPopupWindowLayout.l.clear();
        int i2 = 0;
        for (int i3 = 0; i3 < itemsCount; i3++) {
            View viewL = actionBarPopupWindowLayout.l(i3);
            if (!(viewL instanceof GapView)) {
                viewL.setAlpha(0.0f);
                if (viewL.getVisibility() == 0) {
                    actionBarPopupWindowLayout.l.put(viewL, Integer.valueOf(i2));
                    i2++;
                }
            }
        }
        if (actionBarPopupWindowLayout.i) {
            actionBarPopupWindowLayout.h = itemsCount - 1;
        } else {
            actionBarPopupWindowLayout.h = 0;
        }
        if (actionBarPopupWindowLayout.getSwipeBack() != null) {
            actionBarPopupWindowLayout.getSwipeBack().u();
            f = actionBarPopupWindowLayout.e;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.v5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ActionBarPopupWindow.o(actionBarPopupWindowLayout, valueAnimator);
            }
        });
        actionBarPopupWindowLayout.a = true;
        animatorSet.playTogether(ObjectAnimator.ofFloat(actionBarPopupWindowLayout, "backScaleY", 0.0f, f), ObjectAnimator.ofInt(actionBarPopupWindowLayout, "backAlpha", 0, 255), valueAnimatorOfFloat);
        animatorSet.setDuration((i2 * 16) + 150);
        animatorSet.addListener(new a(actionBarPopupWindowLayout));
        animatorSet.start();
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        ViewTreeObserver viewTreeObserver;
        if (this.f == null || (viewTreeObserver = this.g) == null) {
            return;
        }
        if (viewTreeObserver.isAlive()) {
            this.g.removeOnScrollChangedListener(this.f);
        }
        this.g = null;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        k(true);
    }

    public void j(float f) {
        View rootView = getContentView().getRootView();
        WindowManager windowManager = (WindowManager) getContentView().getContext().getSystemService("window");
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) rootView.getLayoutParams();
        layoutParams.flags |= 2;
        layoutParams.dimAmount = f;
        windowManager.updateViewLayout(rootView, layoutParams);
    }

    public void k(boolean z) {
        setFocusable(false);
        l();
        AnimatorSet animatorSet = this.a;
        ActionBarPopupWindowLayout actionBarPopupWindowLayout = null;
        if (animatorSet != null) {
            if (z && this.d) {
                return;
            }
            animatorSet.cancel();
            this.a = null;
        }
        this.d = false;
        if (!this.b || !z) {
            try {
                super.dismiss();
            } catch (Exception unused) {
            }
            v();
            return;
        }
        this.d = true;
        ViewGroup viewGroup = (ViewGroup) getContentView();
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            if (viewGroup.getChildAt(i2) instanceof ActionBarPopupWindowLayout) {
                actionBarPopupWindowLayout = (ActionBarPopupWindowLayout) viewGroup.getChildAt(i2);
            }
        }
        if (actionBarPopupWindowLayout != null && actionBarPopupWindowLayout.k != null && !actionBarPopupWindowLayout.k.isEmpty()) {
            int size = actionBarPopupWindowLayout.k.size();
            for (int i3 = 0; i3 < size; i3++) {
                AnimatorSet animatorSet2 = (AnimatorSet) actionBarPopupWindowLayout.k.get(i3);
                animatorSet2.removeAllListeners();
                animatorSet2.cancel();
            }
            actionBarPopupWindowLayout.k.clear();
        }
        AnimatorSet animatorSet3 = new AnimatorSet();
        this.a = animatorSet3;
        if (this.e > 0) {
            animatorSet3.playTogether(ValueAnimator.ofFloat(0.0f, 1.0f));
            this.a.setDuration(this.e);
        } else {
            animatorSet3.playTogether(ObjectAnimator.ofFloat(viewGroup, (Property<ViewGroup, Float>) View.TRANSLATION_Y, AbstractC21455b.F((actionBarPopupWindowLayout == null || !actionBarPopupWindowLayout.i) ? -5.0f : 5.0f)), ObjectAnimator.ofFloat(viewGroup, (Property<ViewGroup, Float>) View.ALPHA, 0.0f));
            this.a.setDuration(this.c);
        }
        this.a.addListener(new c());
        this.a.start();
    }

    public void r(boolean z) {
        this.b = z;
    }

    public void s(boolean z) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            if (i == null) {
                Method declaredMethod = PopupWindow.class.getDeclaredMethod("setLayoutInScreenEnabled", Boolean.TYPE);
                i = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            i.invoke(this, Boolean.TRUE);
        } catch (Exception e) {
            AbstractC6403Nl2.d(e);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i2, int i3) {
        try {
            super.showAsDropDown(view, i2, i3);
            q(view);
        } catch (Exception e) {
            AbstractC6403Nl2.d(e);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(View view, int i2, int i3, int i4) {
        super.showAtLocation(view, i2, i3, i4);
        v();
    }

    public void u() {
        ActionBarPopupWindowLayout actionBarPopupWindowLayout;
        if (this.b && this.a == null) {
            ViewGroup viewGroup = (ViewGroup) getContentView();
            if (viewGroup instanceof ActionBarPopupWindowLayout) {
                actionBarPopupWindowLayout = (ActionBarPopupWindowLayout) viewGroup;
                actionBarPopupWindowLayout.f = true;
            } else {
                ActionBarPopupWindowLayout actionBarPopupWindowLayout2 = null;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    if (viewGroup.getChildAt(i2) instanceof ActionBarPopupWindowLayout) {
                        actionBarPopupWindowLayout2 = (ActionBarPopupWindowLayout) viewGroup.getChildAt(i2);
                        actionBarPopupWindowLayout2.f = true;
                    }
                }
                actionBarPopupWindowLayout = actionBarPopupWindowLayout2;
            }
            actionBarPopupWindowLayout.setTranslationY(0.0f);
            float f = 1.0f;
            actionBarPopupWindowLayout.setAlpha(1.0f);
            actionBarPopupWindowLayout.setPivotX(actionBarPopupWindowLayout.getMeasuredWidth());
            actionBarPopupWindowLayout.setPivotY(0.0f);
            int itemsCount = actionBarPopupWindowLayout.getItemsCount();
            actionBarPopupWindowLayout.l.clear();
            int i3 = 0;
            for (int i4 = 0; i4 < itemsCount; i4++) {
                View viewL = actionBarPopupWindowLayout.l(i4);
                viewL.setAlpha(0.0f);
                if (viewL.getVisibility() == 0) {
                    actionBarPopupWindowLayout.l.put(viewL, Integer.valueOf(i3));
                    i3++;
                }
            }
            if (actionBarPopupWindowLayout.i) {
                actionBarPopupWindowLayout.h = itemsCount - 1;
            } else {
                actionBarPopupWindowLayout.h = 0;
            }
            if (actionBarPopupWindowLayout.getSwipeBack() != null) {
                actionBarPopupWindowLayout.getSwipeBack().u();
                f = actionBarPopupWindowLayout.e;
            }
            AnimatorSet animatorSet = new AnimatorSet();
            this.a = animatorSet;
            animatorSet.playTogether(ObjectAnimator.ofFloat(actionBarPopupWindowLayout, "backScaleY", 0.0f, f), ObjectAnimator.ofInt(actionBarPopupWindowLayout, "backAlpha", 0, 255));
            this.a.setDuration((i3 * 16) + 150);
            this.a.addListener(new b());
            this.a.start();
        }
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i2, int i3, int i4, int i5) {
        super.update(view, i2, i3, i4, i5);
        q(view);
    }

    public static class GapView extends FrameLayout {
        Drawable a;

        public GapView(Context context, int i, int i2) {
            super(context);
            this.a = m.B0(getContext(), AbstractC23598xB5.greydivider, i2);
            setBackgroundColor(i);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Drawable drawable = this.a;
            if (drawable != null) {
                drawable.setBounds(0, 0, getWidth(), getHeight());
                this.a.draw(canvas);
            }
        }

        public void setColor(int i) {
            setBackgroundColor(i);
        }

        public GapView(Context context, m.h hVar, int i) {
            this(context, m.j0(i, hVar), m.j0(m.K5, hVar));
        }
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i2, int i3) {
        super.update(view, i2, i3);
        q(view);
    }
}
