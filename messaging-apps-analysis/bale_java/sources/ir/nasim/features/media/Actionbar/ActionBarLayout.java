package ir.nasim.features.media.Actionbar;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.AbstractC9160Yt;
import ir.nasim.C12885fL1;
import ir.nasim.C22078ud6;
import ir.nasim.C23381wp3;
import ir.nasim.C5495Jo7;
import ir.nasim.KB5;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes6.dex */
public class ActionBarLayout extends FrameLayout {
    private static Drawable A;
    private static Drawable B;
    private static Paint D;
    private Runnable a;
    private Runnable b;
    private LinearLayoutContainer c;
    private LinearLayoutContainer d;
    private ActionBar e;
    private AnimatorSet f;
    private DecelerateInterpolator g;
    public float h;
    private boolean i;
    protected boolean j;
    private int k;
    private int l;
    protected boolean m;
    private VelocityTracker n;
    private boolean o;
    private boolean p;
    private long q;
    private int r;
    private Runnable s;
    private Runnable t;
    private Runnable u;
    private float v;
    private long w;
    private j x;
    protected Activity y;
    public ArrayList z;

    public class LinearLayoutContainer extends LinearLayout {
        private Rect a;
        private boolean b;

        public LinearLayoutContainer(Context context) {
            super(context);
            this.a = new Rect();
            setOrientation(1);
        }

        @Override // android.view.ViewGroup
        protected boolean drawChild(Canvas canvas, View view, long j) {
            int measuredHeight;
            if (view instanceof ActionBar) {
                return super.drawChild(canvas, view, j);
            }
            int childCount = getChildCount();
            int i = 0;
            while (true) {
                if (i >= childCount) {
                    break;
                }
                View childAt = getChildAt(i);
                if (childAt == view || !(childAt instanceof ActionBar) || childAt.getVisibility() != 0) {
                    i++;
                } else if (((ActionBar) childAt).getCastShadows()) {
                    measuredHeight = childAt.getMeasuredHeight();
                }
            }
            measuredHeight = 0;
            boolean zDrawChild = super.drawChild(canvas, view, j);
            if (measuredHeight != 0 && ActionBarLayout.A != null) {
                ActionBarLayout.A.setBounds(0, measuredHeight, getMeasuredWidth(), ActionBarLayout.A.getIntrinsicHeight() + measuredHeight);
                ActionBarLayout.A.draw(canvas);
            }
            return zDrawChild;
        }

        @Override // android.view.View
        public boolean hasOverlappingRendering() {
            return false;
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            View rootView = getRootView();
            getWindowVisibleDisplayFrame(this.a);
            int height = (rootView.getHeight() - (this.a.top != 0 ? AbstractC7426Rr.H() : 0)) - AbstractC7426Rr.J(rootView);
            Rect rect = this.a;
            this.b = height - (rect.bottom - rect.top) > 0;
            if (ActionBarLayout.this.a == null || ActionBarLayout.this.c.b || ActionBarLayout.this.d.b) {
                return;
            }
            AbstractC7426Rr.w(ActionBarLayout.this.a);
            ActionBarLayout.this.a.run();
            ActionBarLayout.this.a = null;
        }
    }

    class a extends AbstractC9160Yt {
        final /* synthetic */ boolean a;

        a(boolean z) {
            this.a = z;
        }

        @Override // ir.nasim.AbstractC9160Yt, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ActionBarLayout.this.J(this.a);
        }
    }

    class b implements Runnable {
        final /* synthetic */ boolean a;
        final /* synthetic */ boolean b;

        b(boolean z, boolean z2) {
            this.a = z;
            this.b = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ActionBarLayout.this.u != this) {
                return;
            }
            ActionBarLayout.this.u = null;
            if (this.a) {
                ActionBarLayout.this.q = System.currentTimeMillis();
            }
            long jNanoTime = System.nanoTime() / 1000000;
            long j = jNanoTime - ActionBarLayout.this.w;
            if (j > 18) {
                j = 18;
            }
            ActionBarLayout.this.w = jNanoTime;
            ActionBarLayout.this.v += j / 150.0f;
            if (ActionBarLayout.this.v > 1.0f) {
                ActionBarLayout.this.v = 1.0f;
            }
            float interpolation = ActionBarLayout.this.g.getInterpolation(ActionBarLayout.this.v);
            if (this.b) {
                ActionBarLayout.this.c.setAlpha(interpolation);
                ActionBarLayout.this.c.setTranslationX(C22078ud6.a(48.0f) * (1.0f - interpolation));
            } else {
                ActionBarLayout.this.d.setAlpha(1.0f - interpolation);
                ActionBarLayout.this.d.setTranslationX(C22078ud6.a(48.0f) * interpolation);
            }
            if (ActionBarLayout.this.v < 1.0f) {
                ActionBarLayout.this.Q(this.b, false);
            } else {
                ActionBarLayout.this.D(false);
            }
        }
    }

    class c implements Runnable {
        final /* synthetic */ boolean a;
        final /* synthetic */ ir.nasim.features.media.Actionbar.b b;
        final /* synthetic */ ir.nasim.features.media.Actionbar.b c;

        c(boolean z, ir.nasim.features.media.Actionbar.b bVar, ir.nasim.features.media.Actionbar.b bVar2) {
            this.a = z;
            this.b = bVar;
            this.c = bVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarLayout.this.c.setLayerType(0, null);
            ActionBarLayout.this.d.setLayerType(0, null);
            ActionBarLayout.this.N(this.a, this.b);
            this.c.p(true);
            ActionBarLayout.this.c.setTranslationX(0.0f);
        }
    }

    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ActionBarLayout.this.a != this) {
                return;
            }
            ActionBarLayout.this.Q(true, true);
        }
    }

    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ActionBarLayout.this.b != this) {
                return;
            }
            ActionBarLayout.this.b = null;
            ActionBarLayout.this.Q(true, true);
        }
    }

    class f implements Runnable {
        final /* synthetic */ ir.nasim.features.media.Actionbar.b a;
        final /* synthetic */ ir.nasim.features.media.Actionbar.b b;

        f(ir.nasim.features.media.Actionbar.b bVar, ir.nasim.features.media.Actionbar.b bVar2) {
            this.a = bVar;
            this.b = bVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarLayout.this.c.setLayerType(0, null);
            ActionBarLayout.this.d.setLayerType(0, null);
            ActionBarLayout.this.B(this.a);
            ActionBarLayout.this.d.setTranslationX(0.0f);
            this.a.p(false);
            this.b.p(true);
        }
    }

    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ActionBarLayout.this.a != this) {
                return;
            }
            ActionBarLayout.this.Q(false, true);
        }
    }

    class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarLayout.this.s.run();
            ActionBarLayout.this.s = null;
        }
    }

    class i implements Runnable {
        i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarLayout.this.t.run();
            ActionBarLayout.this.t = null;
        }
    }

    public interface j {
        boolean H();

        boolean j(ActionBarLayout actionBarLayout);

        boolean r();
    }

    public ActionBarLayout(Context context) {
        super(context);
        this.g = new DecelerateInterpolator(1.5f);
        this.v = 0.0f;
        this.x = null;
        this.y = null;
        this.z = null;
        this.y = (Activity) context;
        if (B == null) {
            B = getResources().getDrawable(KB5.layer_shadow);
            A = getResources().getDrawable(KB5.header_shadow);
            D = new Paint();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(ir.nasim.features.media.Actionbar.b bVar) {
        bVar.n();
        bVar.m();
        bVar.s(null);
        this.z.remove(bVar);
        this.d.setVisibility(8);
        bringChildToFront(this.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(boolean z) {
        F(false);
        G(false);
        Runnable runnable = this.a;
        if (runnable != null) {
            AbstractC7426Rr.w(runnable);
            this.a = null;
        }
        AnimatorSet animatorSet = this.f;
        if (animatorSet != null) {
            if (z) {
                animatorSet.cancel();
            }
            this.f = null;
        }
        Runnable runnable2 = this.u;
        if (runnable2 != null) {
            AbstractC7426Rr.w(runnable2);
            this.u = null;
        }
        setAlpha(1.0f);
        this.c.setAlpha(1.0f);
        this.c.setScaleX(1.0f);
        this.c.setScaleY(1.0f);
        this.d.setAlpha(1.0f);
        this.d.setScaleX(1.0f);
        this.d.setScaleY(1.0f);
    }

    private void F(boolean z) {
        Runnable runnable;
        if (!this.p || (runnable = this.s) == null) {
            return;
        }
        this.p = false;
        this.q = 0L;
        if (z) {
            new Handler().post(new h());
        } else {
            runnable.run();
            this.s = null;
        }
    }

    private void G(boolean z) {
        Runnable runnable;
        if (!this.p || (runnable = this.t) == null) {
            return;
        }
        this.p = false;
        this.q = 0L;
        if (z) {
            new Handler().post(new i());
        } else {
            runnable.run();
            this.t = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(boolean z) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        if (z) {
            ir.nasim.features.media.Actionbar.b bVar = (ir.nasim.features.media.Actionbar.b) this.z.get(r3.size() - 2);
            bVar.n();
            View view = bVar.c;
            if (view != null && (viewGroup2 = (ViewGroup) view.getParent()) != null) {
                viewGroup2.removeView(bVar.c);
            }
            ActionBar actionBar = bVar.e;
            if (actionBar != null && actionBar.getAddToContainer() && (viewGroup = (ViewGroup) bVar.e.getParent()) != null) {
                viewGroup.removeView(bVar.e);
            }
        } else {
            ir.nasim.features.media.Actionbar.b bVar2 = (ir.nasim.features.media.Actionbar.b) this.z.get(r3.size() - 1);
            bVar2.n();
            bVar2.m();
            bVar2.s(null);
            this.z.remove(r3.size() - 1);
            LinearLayoutContainer linearLayoutContainer = this.c;
            LinearLayoutContainer linearLayoutContainer2 = this.d;
            this.c = linearLayoutContainer2;
            this.d = linearLayoutContainer;
            bringChildToFront(linearLayoutContainer2);
            ir.nasim.features.media.Actionbar.b bVar3 = (ir.nasim.features.media.Actionbar.b) this.z.get(r3.size() - 1);
            this.e = bVar3.e;
            bVar3.o();
        }
        this.d.setVisibility(8);
        this.j = false;
        this.m = false;
        this.c.setTranslationX(0.0f);
        this.d.setTranslationX(0.0f);
        setInnerTranslationX(0.0f);
    }

    private void K(MotionEvent motionEvent) {
        this.i = false;
        this.j = true;
        this.k = (int) motionEvent.getX();
        this.d.setVisibility(0);
        this.o = false;
        ir.nasim.features.media.Actionbar.b bVar = (ir.nasim.features.media.Actionbar.b) this.z.get(r4.size() - 2);
        View viewB = bVar.c;
        if (viewB == null) {
            viewB = bVar.b(this.y);
        } else {
            ViewGroup viewGroup = (ViewGroup) viewB.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(viewB);
            }
        }
        ViewGroup viewGroup2 = (ViewGroup) viewB.getParent();
        if (viewGroup2 != null) {
            viewGroup2.removeView(viewB);
        }
        ActionBar actionBar = bVar.e;
        if (actionBar != null && actionBar.getAddToContainer()) {
            ViewGroup viewGroup3 = (ViewGroup) bVar.e.getParent();
            if (viewGroup3 != null) {
                viewGroup3.removeView(bVar.e);
            }
            this.d.addView(bVar.e);
            bVar.e.setTitleOverlayText(null);
        }
        this.d.addView(viewB);
        ViewGroup.LayoutParams layoutParams = viewB.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        viewB.setLayoutParams(layoutParams);
        if (!bVar.h && viewB.getBackground() == null) {
            viewB.setBackgroundColor(C5495Jo7.a.f0());
        }
        bVar.o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(boolean z, ir.nasim.features.media.Actionbar.b bVar) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        if (bVar == null) {
            return;
        }
        bVar.n();
        if (z) {
            bVar.m();
            bVar.s(null);
            this.z.remove(bVar);
        } else {
            View view = bVar.c;
            if (view != null && (viewGroup2 = (ViewGroup) view.getParent()) != null) {
                viewGroup2.removeView(bVar.c);
            }
            ActionBar actionBar = bVar.e;
            if (actionBar != null && actionBar.getAddToContainer() && (viewGroup = (ViewGroup) bVar.e.getParent()) != null) {
                viewGroup.removeView(bVar.e);
            }
        }
        this.d.setVisibility(8);
    }

    private void P(ir.nasim.features.media.Actionbar.b bVar) {
        bVar.n();
        bVar.m();
        bVar.s(null);
        this.z.remove(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(boolean z, boolean z2) {
        if (z2) {
            this.v = 0.0f;
            this.w = System.nanoTime() / 1000000;
            this.c.setLayerType(2, null);
            this.d.setLayerType(2, null);
        }
        b bVar = new b(z2, z);
        this.u = bVar;
        AbstractC7426Rr.P(bVar);
    }

    public void A(boolean z) {
        ir.nasim.features.media.Actionbar.b bVar;
        j jVar = this.x;
        if ((jVar != null && !jVar.j(this)) || y() || this.z.isEmpty()) {
            return;
        }
        if (this.y.getCurrentFocus() != null) {
            C23381wp3.f(this.y.getCurrentFocus());
        }
        setInnerTranslationX(0.0f);
        boolean z2 = z && this.y.getSharedPreferences("mainconfig", 0).getBoolean("view_animations", true);
        ArrayList arrayList = this.z;
        ir.nasim.features.media.Actionbar.b bVar2 = (ir.nasim.features.media.Actionbar.b) arrayList.get(arrayList.size() - 1);
        if (this.z.size() > 1) {
            bVar = (ir.nasim.features.media.Actionbar.b) this.z.get(r3.size() - 2);
        } else {
            bVar = null;
        }
        if (bVar == null) {
            P(bVar2);
            setVisibility(8);
            return;
        }
        LinearLayoutContainer linearLayoutContainer = this.c;
        LinearLayoutContainer linearLayoutContainer2 = this.d;
        this.c = linearLayoutContainer2;
        this.d = linearLayoutContainer;
        linearLayoutContainer2.setVisibility(0);
        bVar.s(this);
        View viewB = bVar.c;
        if (viewB == null) {
            viewB = bVar.b(this.y);
        } else {
            ViewGroup viewGroup = (ViewGroup) viewB.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(viewB);
            }
        }
        ActionBar actionBar = bVar.e;
        if (actionBar != null && actionBar.getAddToContainer()) {
            ViewGroup viewGroup2 = (ViewGroup) bVar.e.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(bVar.e);
            }
            this.c.addView(bVar.e);
            bVar.e.setTitleOverlayText(null);
        }
        this.c.addView(viewB);
        ViewGroup.LayoutParams layoutParams = viewB.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        viewB.setLayoutParams(layoutParams);
        bVar.o();
        this.e = bVar.e;
        if (!bVar.h && viewB.getBackground() == null) {
            viewB.setBackgroundColor(C5495Jo7.a.f0());
        }
        if (!z2) {
            B(bVar2);
        }
        if (!z2) {
            bVar2.p(false);
            bVar.p(true);
            return;
        }
        this.q = System.currentTimeMillis();
        this.p = true;
        this.s = new f(bVar2, bVar);
        AnimatorSet animatorSetK = bVar2.k();
        if (animatorSetK != null) {
            this.f = animatorSetK;
            return;
        }
        if (!this.c.b && !this.d.b) {
            Q(false, true);
            return;
        }
        g gVar = new g();
        this.a = gVar;
        AbstractC7426Rr.Q(gVar, 200L);
    }

    public void C(ArrayList arrayList) {
        this.z = arrayList;
        LinearLayoutContainer linearLayoutContainer = new LinearLayoutContainer(this.y);
        this.d = linearLayoutContainer;
        addView(linearLayoutContainer);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.d.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.gravity = 51;
        this.d.setLayoutParams(layoutParams);
        LinearLayoutContainer linearLayoutContainer2 = new LinearLayoutContainer(this.y);
        this.c = linearLayoutContainer2;
        addView(linearLayoutContainer2);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.c.getLayoutParams();
        layoutParams2.width = -1;
        layoutParams2.height = -1;
        layoutParams2.gravity = 51;
        this.c.setLayoutParams(layoutParams2);
        Iterator it = this.z.iterator();
        while (it.hasNext()) {
            ((ir.nasim.features.media.Actionbar.b) it.next()).s(this);
        }
    }

    public void E() {
        if (this.j || y() || this.z.isEmpty()) {
            return;
        }
        ActionBar actionBar = this.e;
        if (actionBar != null && actionBar.h) {
            actionBar.b();
            return;
        }
        ArrayList arrayList = this.z;
        if (!((ir.nasim.features.media.Actionbar.b) arrayList.get(arrayList.size() - 1)).h() || this.z.isEmpty()) {
            return;
        }
        A(true);
    }

    public void H() {
        if (this.z.isEmpty()) {
            return;
        }
        ((ir.nasim.features.media.Actionbar.b) this.z.get(r0.size() - 1)).n();
    }

    public void I() {
        if (this.p) {
            AnimatorSet animatorSet = this.f;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.f = null;
            }
            if (this.s != null) {
                F(false);
            } else if (this.t != null) {
                G(false);
            }
        }
        if (this.z.isEmpty()) {
            return;
        }
        ((ir.nasim.features.media.Actionbar.b) this.z.get(r0.size() - 1)).o();
    }

    public boolean L(ir.nasim.features.media.Actionbar.b bVar) {
        return M(bVar, false, false, true);
    }

    public boolean M(ir.nasim.features.media.Actionbar.b bVar, boolean z, boolean z2, boolean z3) {
        j jVar;
        ir.nasim.features.media.Actionbar.b bVar2;
        if (y() || !(((jVar = this.x) == null || !z3 || jVar.r()) && bVar.l())) {
            return false;
        }
        if (this.y.getCurrentFocus() != null) {
            C23381wp3.f(this.y.getCurrentFocus());
        }
        boolean z4 = !z2 && this.y.getSharedPreferences("mainconfig", 0).getBoolean("view_animations", true);
        if (this.z.isEmpty()) {
            bVar2 = null;
        } else {
            ArrayList arrayList = this.z;
            bVar2 = (ir.nasim.features.media.Actionbar.b) arrayList.get(arrayList.size() - 1);
        }
        bVar.s(this);
        View viewB = bVar.c;
        if (viewB == null) {
            viewB = bVar.b(this.y);
        } else {
            ViewGroup viewGroup = (ViewGroup) viewB.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(viewB);
            }
        }
        ActionBar actionBar = bVar.e;
        if (actionBar != null && actionBar.getAddToContainer()) {
            ViewGroup viewGroup2 = (ViewGroup) bVar.e.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(bVar.e);
            }
            this.d.addView(bVar.e);
            bVar.e.setTitleOverlayText(null);
        }
        this.d.addView(viewB);
        ViewGroup.LayoutParams layoutParams = viewB.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        viewB.setLayoutParams(layoutParams);
        this.z.add(bVar);
        bVar.o();
        this.e = bVar.e;
        if (!bVar.h && viewB.getBackground() == null) {
            viewB.setBackgroundColor(C5495Jo7.a.f0());
        }
        LinearLayoutContainer linearLayoutContainer = this.c;
        LinearLayoutContainer linearLayoutContainer2 = this.d;
        this.c = linearLayoutContainer2;
        this.d = linearLayoutContainer;
        linearLayoutContainer2.setVisibility(0);
        setInnerTranslationX(0.0f);
        bringChildToFront(this.c);
        if (!z4) {
            N(z, bVar2);
        }
        if (z4) {
            this.q = System.currentTimeMillis();
            this.p = true;
            this.t = new c(z, bVar2, bVar);
            AnimatorSet animatorSetK = bVar.k();
            if (animatorSetK == null) {
                this.c.setAlpha(0.0f);
                this.c.setTranslationX(48.0f);
                if (this.c.b || this.d.b) {
                    d dVar = new d();
                    this.a = dVar;
                    AbstractC7426Rr.Q(dVar, 200L);
                } else if (bVar.g()) {
                    e eVar = new e();
                    this.b = eVar;
                    AbstractC7426Rr.Q(eVar, 200L);
                } else {
                    Q(true, true);
                }
            } else {
                this.c.setAlpha(1.0f);
                this.c.setTranslationX(0.0f);
                this.f = animatorSetK;
            }
        } else {
            bVar.p(true);
        }
        return true;
    }

    public void O(ir.nasim.features.media.Actionbar.b bVar) {
        P(bVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        if (keyEvent == null || keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 1) {
            return super.dispatchKeyEventPreIme(keyEvent);
        }
        j jVar = this.x;
        return (jVar != null && jVar.H()) || super.dispatchKeyEventPreIme(keyEvent);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j2) {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int paddingRight = ((int) this.h) + getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int paddingLeft2 = getPaddingLeft() + width;
        if (view == this.d) {
            paddingLeft2 = paddingRight;
        } else if (view == this.c) {
            paddingLeft = paddingRight;
        }
        int iSave = canvas.save();
        if (!this.p) {
            canvas.clipRect(paddingLeft, 0, paddingLeft2, getHeight());
        }
        boolean zDrawChild = super.drawChild(canvas, view, j2);
        canvas.restoreToCount(iSave);
        if (paddingRight != 0) {
            if (view == this.c) {
                float fMax = Math.max(0.0f, Math.min((width - paddingRight) / C22078ud6.a(20.0f), 1.0f));
                Drawable drawable = B;
                drawable.setBounds(paddingRight - drawable.getIntrinsicWidth(), view.getTop(), paddingRight, view.getBottom());
                B.setAlpha((int) (fMax * 255.0f));
                B.draw(canvas);
            } else if (view == this.d) {
                float fMin = Math.min(0.8f, (width - paddingRight) / width);
                D.setColor(((int) ((fMin >= 0.0f ? fMin : 0.0f) * 153.0f)) << 24);
                canvas.drawRect(paddingLeft, 0.0f, paddingLeft2, getHeight(), D);
            }
        }
        return zDrawChild;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.z.isEmpty()) {
            return;
        }
        ((ir.nasim.features.media.Actionbar.b) this.z.get(r0.size() - 1)).j(configuration);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.m || y() || onTouchEvent(motionEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        ActionBar actionBar;
        if (i2 == 82 && !y() && !this.j && (actionBar = this.e) != null) {
            actionBar.f();
        }
        return super.onKeyUp(i2, keyEvent);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (y() || this.m) {
            return false;
        }
        if (this.z.size() > 1) {
            if (motionEvent != null && motionEvent.getAction() == 0 && !this.j && !this.i) {
                ArrayList arrayList = this.z;
                if (!((ir.nasim.features.media.Actionbar.b) arrayList.get(arrayList.size() - 1)).g) {
                    return false;
                }
                this.r = motionEvent.getPointerId(0);
                this.i = true;
                this.k = (int) motionEvent.getX();
                this.l = (int) motionEvent.getY();
                VelocityTracker velocityTracker = this.n;
                if (velocityTracker != null) {
                    velocityTracker.clear();
                }
            } else if (motionEvent != null && motionEvent.getAction() == 2 && motionEvent.getPointerId(0) == this.r) {
                if (this.n == null) {
                    this.n = VelocityTracker.obtain();
                }
                int iMax = Math.max(0, (int) (motionEvent.getX() - this.k));
                int iAbs = Math.abs(((int) motionEvent.getY()) - this.l);
                this.n.addMovement(motionEvent);
                if (this.i && !this.j && iMax >= C12885fL1.b(0.4f, true) && Math.abs(iMax) / 3 > iAbs) {
                    K(motionEvent);
                } else if (this.j) {
                    if (!this.o) {
                        if (this.y.getCurrentFocus() != null) {
                            C23381wp3.f(this.y.getCurrentFocus());
                        }
                        ArrayList arrayList2 = this.z;
                        ((ir.nasim.features.media.Actionbar.b) arrayList2.get(arrayList2.size() - 1)).i();
                        this.o = true;
                    }
                    float f2 = iMax;
                    this.c.setTranslationX(f2);
                    setInnerTranslationX(f2);
                }
            } else if (motionEvent != null && motionEvent.getPointerId(0) == this.r && (motionEvent.getAction() == 3 || motionEvent.getAction() == 1 || motionEvent.getAction() == 6)) {
                if (this.n == null) {
                    this.n = VelocityTracker.obtain();
                }
                this.n.computeCurrentVelocity(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT);
                if (!this.j) {
                    ArrayList arrayList3 = this.z;
                    if (((ir.nasim.features.media.Actionbar.b) arrayList3.get(arrayList3.size() - 1)).g) {
                        float xVelocity = this.n.getXVelocity();
                        float yVelocity = this.n.getYVelocity();
                        if (xVelocity >= 3500.0f && xVelocity > Math.abs(yVelocity)) {
                            K(motionEvent);
                            if (!this.o) {
                                if (((Activity) getContext()).getCurrentFocus() != null) {
                                    C23381wp3.f(((Activity) getContext()).getCurrentFocus());
                                }
                                this.o = true;
                            }
                        }
                    }
                }
                if (this.j) {
                    float x = this.c.getX();
                    AnimatorSet animatorSet = new AnimatorSet();
                    float xVelocity2 = this.n.getXVelocity();
                    boolean z = x < ((float) this.c.getMeasuredWidth()) / 3.0f && (xVelocity2 < 3500.0f || xVelocity2 < this.n.getYVelocity());
                    if (z) {
                        animatorSet.playTogether(ObjectAnimator.ofFloat(this.c, "translationX", 0.0f), ObjectAnimator.ofFloat(this, "innerTranslationX", 0.0f));
                    } else {
                        x = this.c.getMeasuredWidth() - x;
                        animatorSet.playTogether(ObjectAnimator.ofFloat(this.c, "translationX", r8.getMeasuredWidth()), ObjectAnimator.ofFloat(this, "innerTranslationX", this.c.getMeasuredWidth()));
                    }
                    animatorSet.setDuration(Math.max((int) ((200.0f / this.c.getMeasuredWidth()) * x), 50));
                    animatorSet.addListener(new a(z));
                    animatorSet.start();
                    this.m = true;
                } else {
                    this.i = false;
                    this.j = false;
                }
                VelocityTracker velocityTracker2 = this.n;
                if (velocityTracker2 != null) {
                    velocityTracker2.recycle();
                    this.n = null;
                }
            } else if (motionEvent == null) {
                this.i = false;
                this.j = false;
                VelocityTracker velocityTracker3 = this.n;
                if (velocityTracker3 != null) {
                    velocityTracker3.recycle();
                    this.n = null;
                }
            }
        }
        return this.j;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        onTouchEvent(null);
        super.requestDisallowInterceptTouchEvent(z);
    }

    public void setDelegate(j jVar) {
        this.x = jVar;
    }

    public void setInnerTranslationX(float f2) {
        this.h = f2;
        invalidate();
    }

    public boolean y() {
        if (this.p && this.q < System.currentTimeMillis() - 1500) {
            D(true);
        }
        return this.p;
    }

    public void z() {
        this.y = null;
    }
}
