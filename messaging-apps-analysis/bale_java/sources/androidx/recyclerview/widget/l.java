package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import androidx.core.view.GestureDetectorCompat;
import androidx.recyclerview.widget.RecyclerView;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC11547dB5;
import ir.nasim.AbstractC12990fW7;
import java.util.ArrayList;
import java.util.List;
import org.xbill.DNS.dnssec.ValidatingResolver;

/* loaded from: classes2.dex */
public class l extends RecyclerView.o implements RecyclerView.q {
    private f A;
    private Rect C;
    private long D;
    float d;
    float e;
    private float f;
    private float g;
    float h;
    float i;
    private float j;
    private float k;
    e m;
    int o;
    private int q;
    RecyclerView r;
    VelocityTracker t;
    private List u;
    private List v;
    private RecyclerView.k w;
    GestureDetectorCompat z;
    final List a = new ArrayList();
    private final float[] b = new float[2];
    RecyclerView.C c = null;
    int l = -1;
    private int n = 0;
    List p = new ArrayList();
    final Runnable s = new a();
    View x = null;
    int y = -1;
    private final RecyclerView.s B = new b();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l lVar = l.this;
            if (lVar.c == null || !lVar.E()) {
                return;
            }
            l lVar2 = l.this;
            RecyclerView.C c = lVar2.c;
            if (c != null) {
                lVar2.z(c);
            }
            l lVar3 = l.this;
            lVar3.r.removeCallbacks(lVar3.s);
            AbstractC12990fW7.h0(l.this.r, this);
        }
    }

    class b implements RecyclerView.s {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void a(RecyclerView recyclerView, MotionEvent motionEvent) {
            l.this.z.a(motionEvent);
            VelocityTracker velocityTracker = l.this.t;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            if (l.this.l == -1) {
                return;
            }
            int actionMasked = motionEvent.getActionMasked();
            int iFindPointerIndex = motionEvent.findPointerIndex(l.this.l);
            if (iFindPointerIndex >= 0) {
                l.this.o(actionMasked, motionEvent, iFindPointerIndex);
            }
            l lVar = l.this;
            RecyclerView.C c = lVar.c;
            if (c == null) {
                return;
            }
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (iFindPointerIndex >= 0) {
                        lVar.K(motionEvent, lVar.o, iFindPointerIndex);
                        l.this.z(c);
                        l lVar2 = l.this;
                        lVar2.r.removeCallbacks(lVar2.s);
                        l.this.s.run();
                        l.this.r.invalidate();
                        return;
                    }
                    return;
                }
                if (actionMasked != 3) {
                    if (actionMasked != 6) {
                        return;
                    }
                    int actionIndex = motionEvent.getActionIndex();
                    int pointerId = motionEvent.getPointerId(actionIndex);
                    l lVar3 = l.this;
                    if (pointerId == lVar3.l) {
                        lVar3.l = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
                        l lVar4 = l.this;
                        lVar4.K(motionEvent, lVar4.o, actionIndex);
                        return;
                    }
                    return;
                }
                VelocityTracker velocityTracker2 = lVar.t;
                if (velocityTracker2 != null) {
                    velocityTracker2.clear();
                }
            }
            l.this.F(null, 0);
            l.this.l = -1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public boolean c(RecyclerView recyclerView, MotionEvent motionEvent) {
            int iFindPointerIndex;
            g gVarS;
            l.this.z.a(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                l.this.l = motionEvent.getPointerId(0);
                l.this.d = motionEvent.getX();
                l.this.e = motionEvent.getY();
                l.this.A();
                l lVar = l.this;
                if (lVar.c == null && (gVarS = lVar.s(motionEvent)) != null) {
                    l lVar2 = l.this;
                    lVar2.d -= gVarS.j;
                    lVar2.e -= gVarS.k;
                    lVar2.r(gVarS.e, true);
                    if (l.this.a.remove(gVarS.e.a)) {
                        l lVar3 = l.this;
                        lVar3.m.c(lVar3.r, gVarS.e);
                    }
                    l.this.F(gVarS.e, gVarS.f);
                    l lVar4 = l.this;
                    lVar4.K(motionEvent, lVar4.o, 0);
                }
            } else if (actionMasked == 3 || actionMasked == 1) {
                l lVar5 = l.this;
                lVar5.l = -1;
                lVar5.F(null, 0);
            } else {
                int i = l.this.l;
                if (i != -1 && (iFindPointerIndex = motionEvent.findPointerIndex(i)) >= 0) {
                    l.this.o(actionMasked, motionEvent, iFindPointerIndex);
                }
            }
            VelocityTracker velocityTracker = l.this.t;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            return l.this.c != null;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void e(boolean z) {
            if (z) {
                l.this.F(null, 0);
            }
        }
    }

    class c extends g {
        final /* synthetic */ int o;
        final /* synthetic */ RecyclerView.C p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(RecyclerView.C c, int i, int i2, float f, float f2, float f3, float f4, int i3, RecyclerView.C c2) {
            super(c, i, i2, f, f2, f3, f4);
            this.o = i3;
            this.p = c2;
        }

        @Override // androidx.recyclerview.widget.l.g, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (this.l) {
                return;
            }
            if (this.o <= 0) {
                l lVar = l.this;
                lVar.m.c(lVar.r, this.p);
            } else {
                l.this.a.add(this.p.a);
                this.i = true;
                int i = this.o;
                if (i > 0) {
                    l.this.B(this, i);
                }
            }
            l lVar2 = l.this;
            View view = lVar2.x;
            View view2 = this.p.a;
            if (view == view2) {
                lVar2.D(view2);
            }
        }
    }

    class d implements Runnable {
        final /* synthetic */ g a;
        final /* synthetic */ int b;

        d(g gVar, int i) {
            this.a = gVar;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = l.this.r;
            if (recyclerView == null || !recyclerView.isAttachedToWindow()) {
                return;
            }
            g gVar = this.a;
            if (gVar.l || gVar.e.I() == -1) {
                return;
            }
            RecyclerView.m itemAnimator = l.this.r.getItemAnimator();
            if ((itemAnimator == null || !itemAnimator.q(null)) && !l.this.x()) {
                l.this.m.B(this.a.e, this.b);
            } else {
                l.this.r.post(this);
            }
        }
    }

    public static abstract class e {
        private static final Interpolator b = new a();
        private static final Interpolator c = new b();
        private int a = -1;

        class a implements Interpolator {
            a() {
            }

            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                return f * f * f * f * f;
            }
        }

        class b implements Interpolator {
            b() {
            }

            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                float f2 = f - 1.0f;
                return (f2 * f2 * f2 * f2 * f2) + 1.0f;
            }
        }

        public static int e(int i, int i2) {
            int i3;
            int i4 = i & 789516;
            if (i4 == 0) {
                return i;
            }
            int i5 = i & (~i4);
            if (i2 == 0) {
                i3 = i4 << 2;
            } else {
                int i6 = i4 << 1;
                i5 |= (-789517) & i6;
                i3 = (i6 & 789516) << 2;
            }
            return i5 | i3;
        }

        private int i(RecyclerView recyclerView) {
            if (this.a == -1) {
                this.a = recyclerView.getResources().getDimensionPixelSize(AbstractC11547dB5.item_touch_helper_max_drag_scroll_per_frame);
            }
            return this.a;
        }

        public static int s(int i, int i2) {
            return i2 << (i * 8);
        }

        public static int t(int i, int i2) {
            return s(2, i) | s(1, i2) | s(0, i2 | i);
        }

        public void A(RecyclerView.C c2, int i) {
            if (c2 != null) {
                m.a.b(c2.a);
            }
        }

        public abstract void B(RecyclerView.C c2, int i);

        public boolean a(RecyclerView recyclerView, RecyclerView.C c2, RecyclerView.C c3) {
            return true;
        }

        public RecyclerView.C b(RecyclerView.C c2, List list, int i, int i2) {
            int bottom;
            int iAbs;
            int top;
            int iAbs2;
            int left;
            int iAbs3;
            int right;
            int iAbs4;
            int width = i + c2.a.getWidth();
            int height = i2 + c2.a.getHeight();
            int left2 = i - c2.a.getLeft();
            int top2 = i2 - c2.a.getTop();
            int size = list.size();
            RecyclerView.C c3 = null;
            int i3 = -1;
            for (int i4 = 0; i4 < size; i4++) {
                RecyclerView.C c4 = (RecyclerView.C) list.get(i4);
                if (left2 > 0 && (right = c4.a.getRight() - width) < 0 && c4.a.getRight() > c2.a.getRight() && (iAbs4 = Math.abs(right)) > i3) {
                    c3 = c4;
                    i3 = iAbs4;
                }
                if (left2 < 0 && (left = c4.a.getLeft() - i) > 0 && c4.a.getLeft() < c2.a.getLeft() && (iAbs3 = Math.abs(left)) > i3) {
                    c3 = c4;
                    i3 = iAbs3;
                }
                if (top2 < 0 && (top = c4.a.getTop() - i2) > 0 && c4.a.getTop() < c2.a.getTop() && (iAbs2 = Math.abs(top)) > i3) {
                    c3 = c4;
                    i3 = iAbs2;
                }
                if (top2 > 0 && (bottom = c4.a.getBottom() - height) < 0 && c4.a.getBottom() > c2.a.getBottom() && (iAbs = Math.abs(bottom)) > i3) {
                    c3 = c4;
                    i3 = iAbs;
                }
            }
            return c3;
        }

        public void c(RecyclerView recyclerView, RecyclerView.C c2) {
            m.a.a(c2.a);
        }

        public int d(int i, int i2) {
            int i3;
            int i4 = i & 3158064;
            if (i4 == 0) {
                return i;
            }
            int i5 = i & (~i4);
            if (i2 == 0) {
                i3 = i4 >> 2;
            } else {
                int i6 = i4 >> 1;
                i5 |= (-3158065) & i6;
                i3 = (i6 & 3158064) >> 2;
            }
            return i5 | i3;
        }

        final int f(RecyclerView recyclerView, RecyclerView.C c2) {
            return d(k(recyclerView, c2), AbstractC12990fW7.A(recyclerView));
        }

        public long g(RecyclerView recyclerView, int i, float f, float f2) {
            RecyclerView.m itemAnimator = recyclerView.getItemAnimator();
            return itemAnimator == null ? i == 8 ? 200L : 250L : i == 8 ? itemAnimator.n() : itemAnimator.o();
        }

        public int h() {
            return 0;
        }

        public float j(RecyclerView.C c2) {
            return 0.5f;
        }

        public abstract int k(RecyclerView recyclerView, RecyclerView.C c2);

        public float l(float f) {
            return f;
        }

        public float m(RecyclerView.C c2) {
            return 0.5f;
        }

        public float n(float f) {
            return f;
        }

        boolean o(RecyclerView recyclerView, RecyclerView.C c2) {
            return (f(recyclerView, c2) & 16711680) != 0;
        }

        public int p(RecyclerView recyclerView, int i, int i2, int i3, long j) {
            int iSignum = (int) (((int) (((int) Math.signum(i2)) * i(recyclerView) * c.getInterpolation(Math.min(1.0f, (Math.abs(i2) * 1.0f) / i)))) * b.getInterpolation(j <= 2000 ? j / 2000.0f : 1.0f));
            return iSignum == 0 ? i2 > 0 ? 1 : -1 : iSignum;
        }

        public boolean q() {
            return true;
        }

        public boolean r() {
            return true;
        }

        public void u(Canvas canvas, RecyclerView recyclerView, RecyclerView.C c2, float f, float f2, int i, boolean z) {
            m.a.c(canvas, recyclerView, c2.a, f, f2, i, z);
        }

        public void v(Canvas canvas, RecyclerView recyclerView, RecyclerView.C c2, float f, float f2, int i, boolean z) {
            m.a.d(canvas, recyclerView, c2.a, f, f2, i, z);
        }

        void w(Canvas canvas, RecyclerView recyclerView, RecyclerView.C c2, List list, int i, float f, float f2) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                g gVar = (g) list.get(i2);
                gVar.e();
                int iSave = canvas.save();
                u(canvas, recyclerView, gVar.e, gVar.j, gVar.k, gVar.f, false);
                canvas.restoreToCount(iSave);
            }
            if (c2 != null) {
                int iSave2 = canvas.save();
                u(canvas, recyclerView, c2, f, f2, i, true);
                canvas.restoreToCount(iSave2);
            }
        }

        void x(Canvas canvas, RecyclerView recyclerView, RecyclerView.C c2, List list, int i, float f, float f2) {
            int size = list.size();
            boolean z = false;
            for (int i2 = 0; i2 < size; i2++) {
                g gVar = (g) list.get(i2);
                int iSave = canvas.save();
                v(canvas, recyclerView, gVar.e, gVar.j, gVar.k, gVar.f, false);
                canvas.restoreToCount(iSave);
            }
            if (c2 != null) {
                int iSave2 = canvas.save();
                v(canvas, recyclerView, c2, f, f2, i, true);
                canvas.restoreToCount(iSave2);
            }
            for (int i3 = size - 1; i3 >= 0; i3--) {
                g gVar2 = (g) list.get(i3);
                boolean z2 = gVar2.m;
                if (z2 && !gVar2.i) {
                    list.remove(i3);
                } else if (!z2) {
                    z = true;
                }
            }
            if (z) {
                recyclerView.invalidate();
            }
        }

        public abstract boolean y(RecyclerView recyclerView, RecyclerView.C c2, RecyclerView.C c3);

        /* JADX WARN: Multi-variable type inference failed */
        public void z(RecyclerView recyclerView, RecyclerView.C c2, int i, RecyclerView.C c3, int i2, int i3, int i4) {
            RecyclerView.p layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof h) {
                ((h) layoutManager).b(c2.a, c3.a, i3, i4);
                return;
            }
            if (layoutManager.l()) {
                if (layoutManager.R(c3.a) <= recyclerView.getPaddingLeft()) {
                    recyclerView.scrollToPosition(i2);
                }
                if (layoutManager.U(c3.a) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                    recyclerView.scrollToPosition(i2);
                }
            }
            if (layoutManager.m()) {
                if (layoutManager.V(c3.a) <= recyclerView.getPaddingTop()) {
                    recyclerView.scrollToPosition(i2);
                }
                if (layoutManager.P(c3.a) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                    recyclerView.scrollToPosition(i2);
                }
            }
        }
    }

    private class f extends GestureDetector.SimpleOnGestureListener {
        private boolean a = true;

        f() {
        }

        void a() {
            this.a = false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            View viewT;
            RecyclerView.C childViewHolder;
            if (!this.a || (viewT = l.this.t(motionEvent)) == null || (childViewHolder = l.this.r.getChildViewHolder(viewT)) == null) {
                return;
            }
            l lVar = l.this;
            if (lVar.m.o(lVar.r, childViewHolder)) {
                int pointerId = motionEvent.getPointerId(0);
                int i = l.this.l;
                if (pointerId == i) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(i);
                    float x = motionEvent.getX(iFindPointerIndex);
                    float y = motionEvent.getY(iFindPointerIndex);
                    l lVar2 = l.this;
                    lVar2.d = x;
                    lVar2.e = y;
                    lVar2.i = 0.0f;
                    lVar2.h = 0.0f;
                    if (lVar2.m.r()) {
                        l.this.F(childViewHolder, 2);
                    }
                }
            }
        }
    }

    static class g implements Animator.AnimatorListener {
        final float a;
        final float b;
        final float c;
        final float d;
        final RecyclerView.C e;
        final int f;
        final ValueAnimator g;
        final int h;
        boolean i;
        float j;
        float k;
        boolean l = false;
        boolean m = false;
        private float n;

        class a implements ValueAnimator.AnimatorUpdateListener {
            a() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                g.this.c(valueAnimator.getAnimatedFraction());
            }
        }

        g(RecyclerView.C c, int i, int i2, float f, float f2, float f3, float f4) {
            this.f = i2;
            this.h = i;
            this.e = c;
            this.a = f;
            this.b = f2;
            this.c = f3;
            this.d = f4;
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.g = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new a());
            valueAnimatorOfFloat.setTarget(c.a);
            valueAnimatorOfFloat.addListener(this);
            c(0.0f);
        }

        public void a() {
            this.g.cancel();
        }

        public void b(long j) {
            this.g.setDuration(j);
        }

        public void c(float f) {
            this.n = f;
        }

        public void d() {
            this.e.u0(false);
            this.g.start();
        }

        public void e() {
            float f = this.a;
            float f2 = this.c;
            if (f == f2) {
                this.j = this.e.a.getTranslationX();
            } else {
                this.j = f + (this.n * (f2 - f));
            }
            float f3 = this.b;
            float f4 = this.d;
            if (f3 == f4) {
                this.k = this.e.a.getTranslationY();
            } else {
                this.k = f3 + (this.n * (f4 - f3));
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            c(1.0f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.m) {
                this.e.u0(true);
            }
            this.m = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public interface h {
        void b(View view, View view2, int i, int i2);
    }

    public l(e eVar) {
        this.m = eVar;
    }

    private void C() {
        VelocityTracker velocityTracker = this.t;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.t = null;
        }
    }

    private void G() {
        this.q = ViewConfiguration.get(this.r.getContext()).getScaledTouchSlop();
        this.r.addItemDecoration(this);
        this.r.addOnItemTouchListener(this.B);
        this.r.addOnChildAttachStateChangeListener(this);
        H();
    }

    private void H() {
        this.A = new f();
        this.z = new GestureDetectorCompat(this.r.getContext(), this.A);
    }

    private void I() {
        f fVar = this.A;
        if (fVar != null) {
            fVar.a();
            this.A = null;
        }
        if (this.z != null) {
            this.z = null;
        }
    }

    private int J(RecyclerView.C c2) {
        if (this.n == 2) {
            return 0;
        }
        int iK = this.m.k(this.r, c2);
        int iD = (this.m.d(iK, AbstractC12990fW7.A(this.r)) & ValidatingResolver.VALIDATION_REASON_QCLASS) >> 8;
        if (iD == 0) {
            return 0;
        }
        int i = (iK & ValidatingResolver.VALIDATION_REASON_QCLASS) >> 8;
        if (Math.abs(this.h) > Math.abs(this.i)) {
            int iN = n(c2, iD);
            if (iN > 0) {
                return (i & iN) == 0 ? e.e(iN, AbstractC12990fW7.A(this.r)) : iN;
            }
            int iP = p(c2, iD);
            if (iP > 0) {
                return iP;
            }
        } else {
            int iP2 = p(c2, iD);
            if (iP2 > 0) {
                return iP2;
            }
            int iN2 = n(c2, iD);
            if (iN2 > 0) {
                return (i & iN2) == 0 ? e.e(iN2, AbstractC12990fW7.A(this.r)) : iN2;
            }
        }
        return 0;
    }

    private void l() {
    }

    private int n(RecyclerView.C c2, int i) {
        if ((i & 12) == 0) {
            return 0;
        }
        int i2 = this.h > 0.0f ? 8 : 4;
        VelocityTracker velocityTracker = this.t;
        if (velocityTracker != null && this.l > -1) {
            velocityTracker.computeCurrentVelocity(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT, this.m.n(this.g));
            float xVelocity = this.t.getXVelocity(this.l);
            float yVelocity = this.t.getYVelocity(this.l);
            int i3 = xVelocity > 0.0f ? 8 : 4;
            float fAbs = Math.abs(xVelocity);
            if ((i3 & i) != 0 && i2 == i3 && fAbs >= this.m.l(this.f) && fAbs > Math.abs(yVelocity)) {
                return i3;
            }
        }
        float width = this.r.getWidth() * this.m.m(c2);
        if ((i & i2) == 0 || Math.abs(this.h) <= width) {
            return 0;
        }
        return i2;
    }

    private int p(RecyclerView.C c2, int i) {
        if ((i & 3) == 0) {
            return 0;
        }
        int i2 = this.i > 0.0f ? 2 : 1;
        VelocityTracker velocityTracker = this.t;
        if (velocityTracker != null && this.l > -1) {
            velocityTracker.computeCurrentVelocity(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT, this.m.n(this.g));
            float xVelocity = this.t.getXVelocity(this.l);
            float yVelocity = this.t.getYVelocity(this.l);
            int i3 = yVelocity > 0.0f ? 2 : 1;
            float fAbs = Math.abs(yVelocity);
            if ((i3 & i) != 0 && i3 == i2 && fAbs >= this.m.l(this.f) && fAbs > Math.abs(xVelocity)) {
                return i3;
            }
        }
        float height = this.r.getHeight() * this.m.m(c2);
        if ((i & i2) == 0 || Math.abs(this.i) <= height) {
            return 0;
        }
        return i2;
    }

    private void q() {
        this.r.removeItemDecoration(this);
        this.r.removeOnItemTouchListener(this.B);
        this.r.removeOnChildAttachStateChangeListener(this);
        for (int size = this.p.size() - 1; size >= 0; size--) {
            g gVar = (g) this.p.get(0);
            gVar.a();
            this.m.c(this.r, gVar.e);
        }
        this.p.clear();
        this.x = null;
        this.y = -1;
        C();
        I();
    }

    private List u(RecyclerView.C c2) {
        RecyclerView.C c3 = c2;
        List list = this.u;
        if (list == null) {
            this.u = new ArrayList();
            this.v = new ArrayList();
        } else {
            list.clear();
            this.v.clear();
        }
        int iH = this.m.h();
        int iRound = Math.round(this.j + this.h) - iH;
        int iRound2 = Math.round(this.k + this.i) - iH;
        int i = iH * 2;
        int width = c3.a.getWidth() + iRound + i;
        int height = c3.a.getHeight() + iRound2 + i;
        int i2 = (iRound + width) / 2;
        int i3 = (iRound2 + height) / 2;
        RecyclerView.p layoutManager = this.r.getLayoutManager();
        int iK = layoutManager.K();
        int i4 = 0;
        while (i4 < iK) {
            View viewJ = layoutManager.J(i4);
            if (viewJ != c3.a && viewJ.getBottom() >= iRound2 && viewJ.getTop() <= height && viewJ.getRight() >= iRound && viewJ.getLeft() <= width) {
                RecyclerView.C childViewHolder = this.r.getChildViewHolder(viewJ);
                if (this.m.a(this.r, this.c, childViewHolder)) {
                    int iAbs = Math.abs(i2 - ((viewJ.getLeft() + viewJ.getRight()) / 2));
                    int iAbs2 = Math.abs(i3 - ((viewJ.getTop() + viewJ.getBottom()) / 2));
                    int i5 = (iAbs * iAbs) + (iAbs2 * iAbs2);
                    int size = this.u.size();
                    int i6 = 0;
                    for (int i7 = 0; i7 < size && i5 > ((Integer) this.v.get(i7)).intValue(); i7++) {
                        i6++;
                    }
                    this.u.add(i6, childViewHolder);
                    this.v.add(i6, Integer.valueOf(i5));
                }
            }
            i4++;
            c3 = c2;
        }
        return this.u;
    }

    private RecyclerView.C v(MotionEvent motionEvent) {
        View viewT;
        RecyclerView.p layoutManager = this.r.getLayoutManager();
        int i = this.l;
        if (i == -1) {
            return null;
        }
        int iFindPointerIndex = motionEvent.findPointerIndex(i);
        float x = motionEvent.getX(iFindPointerIndex) - this.d;
        float y = motionEvent.getY(iFindPointerIndex) - this.e;
        float fAbs = Math.abs(x);
        float fAbs2 = Math.abs(y);
        int i2 = this.q;
        if (fAbs < i2 && fAbs2 < i2) {
            return null;
        }
        if (fAbs > fAbs2 && layoutManager.l()) {
            return null;
        }
        if ((fAbs2 <= fAbs || !layoutManager.m()) && (viewT = t(motionEvent)) != null) {
            return this.r.getChildViewHolder(viewT);
        }
        return null;
    }

    private void w(float[] fArr) {
        if ((this.o & 12) != 0) {
            fArr[0] = (this.j + this.h) - this.c.a.getLeft();
        } else {
            fArr[0] = this.c.a.getTranslationX();
        }
        if ((this.o & 3) != 0) {
            fArr[1] = (this.k + this.i) - this.c.a.getTop();
        } else {
            fArr[1] = this.c.a.getTranslationY();
        }
    }

    private static boolean y(View view, float f2, float f3, float f4, float f5) {
        return f2 >= f4 && f2 <= f4 + ((float) view.getWidth()) && f3 >= f5 && f3 <= f5 + ((float) view.getHeight());
    }

    void A() {
        VelocityTracker velocityTracker = this.t;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.t = VelocityTracker.obtain();
    }

    void B(g gVar, int i) {
        this.r.post(new d(gVar, i));
    }

    void D(View view) {
        if (view == this.x) {
            this.x = null;
            if (this.w != null) {
                this.r.setChildDrawingOrderCallback(null);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    boolean E() {
        /*
            Method dump skipped, instructions count: 277
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.l.E():boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0121  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void F(androidx.recyclerview.widget.RecyclerView.C r24, int r25) {
        /*
            Method dump skipped, instructions count: 334
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.l.F(androidx.recyclerview.widget.RecyclerView$C, int):void");
    }

    void K(MotionEvent motionEvent, int i, int i2) {
        float x = motionEvent.getX(i2);
        float y = motionEvent.getY(i2);
        float f2 = x - this.d;
        this.h = f2;
        this.i = y - this.e;
        if ((i & 4) == 0) {
            this.h = Math.max(0.0f, f2);
        }
        if ((i & 8) == 0) {
            this.h = Math.min(0.0f, this.h);
        }
        if ((i & 1) == 0) {
            this.i = Math.max(0.0f, this.i);
        }
        if ((i & 2) == 0) {
            this.i = Math.min(0.0f, this.i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void b(View view) {
        D(view);
        RecyclerView.C childViewHolder = this.r.getChildViewHolder(view);
        if (childViewHolder == null) {
            return;
        }
        RecyclerView.C c2 = this.c;
        if (c2 != null && childViewHolder == c2) {
            F(null, 0);
            return;
        }
        r(childViewHolder, false);
        if (this.a.remove(childViewHolder.a)) {
            this.m.c(this.r, childViewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void d(View view) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void g(Rect rect, View view, RecyclerView recyclerView, RecyclerView.z zVar) {
        rect.setEmpty();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void i(Canvas canvas, RecyclerView recyclerView, RecyclerView.z zVar) {
        float f2;
        float f3;
        this.y = -1;
        if (this.c != null) {
            w(this.b);
            float[] fArr = this.b;
            float f4 = fArr[0];
            f3 = fArr[1];
            f2 = f4;
        } else {
            f2 = 0.0f;
            f3 = 0.0f;
        }
        this.m.w(canvas, recyclerView, this.c, this.p, this.n, f2, f3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void k(Canvas canvas, RecyclerView recyclerView, RecyclerView.z zVar) {
        float f2;
        float f3;
        if (this.c != null) {
            w(this.b);
            float[] fArr = this.b;
            float f4 = fArr[0];
            f3 = fArr[1];
            f2 = f4;
        } else {
            f2 = 0.0f;
            f3 = 0.0f;
        }
        this.m.x(canvas, recyclerView, this.c, this.p, this.n, f2, f3);
    }

    public void m(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.r;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            q();
        }
        this.r = recyclerView;
        if (recyclerView != null) {
            Resources resources = recyclerView.getResources();
            this.f = resources.getDimension(AbstractC11547dB5.item_touch_helper_swipe_escape_velocity);
            this.g = resources.getDimension(AbstractC11547dB5.item_touch_helper_swipe_escape_max_velocity);
            G();
        }
    }

    void o(int i, MotionEvent motionEvent, int i2) {
        RecyclerView.C cV;
        int iF;
        if (this.c != null || i != 2 || this.n == 2 || !this.m.q() || this.r.getScrollState() == 1 || (cV = v(motionEvent)) == null || (iF = (this.m.f(this.r, cV) & ValidatingResolver.VALIDATION_REASON_QCLASS) >> 8) == 0) {
            return;
        }
        float x = motionEvent.getX(i2);
        float y = motionEvent.getY(i2);
        float f2 = x - this.d;
        float f3 = y - this.e;
        float fAbs = Math.abs(f2);
        float fAbs2 = Math.abs(f3);
        int i3 = this.q;
        if (fAbs >= i3 || fAbs2 >= i3) {
            if (fAbs > fAbs2) {
                if (f2 < 0.0f && (iF & 4) == 0) {
                    return;
                }
                if (f2 > 0.0f && (iF & 8) == 0) {
                    return;
                }
            } else {
                if (f3 < 0.0f && (iF & 1) == 0) {
                    return;
                }
                if (f3 > 0.0f && (iF & 2) == 0) {
                    return;
                }
            }
            this.i = 0.0f;
            this.h = 0.0f;
            this.l = motionEvent.getPointerId(0);
            F(cV, 1);
        }
    }

    void r(RecyclerView.C c2, boolean z) {
        for (int size = this.p.size() - 1; size >= 0; size--) {
            g gVar = (g) this.p.get(size);
            if (gVar.e == c2) {
                gVar.l |= z;
                if (!gVar.m) {
                    gVar.a();
                }
                this.p.remove(size);
                return;
            }
        }
    }

    g s(MotionEvent motionEvent) {
        if (this.p.isEmpty()) {
            return null;
        }
        View viewT = t(motionEvent);
        for (int size = this.p.size() - 1; size >= 0; size--) {
            g gVar = (g) this.p.get(size);
            if (gVar.e.a == viewT) {
                return gVar;
            }
        }
        return null;
    }

    View t(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        RecyclerView.C c2 = this.c;
        if (c2 != null) {
            View view = c2.a;
            if (y(view, x, y, this.j + this.h, this.k + this.i)) {
                return view;
            }
        }
        for (int size = this.p.size() - 1; size >= 0; size--) {
            g gVar = (g) this.p.get(size);
            View view2 = gVar.e.a;
            if (y(view2, x, y, gVar.j, gVar.k)) {
                return view2;
            }
        }
        return this.r.findChildViewUnder(x, y);
    }

    boolean x() {
        int size = this.p.size();
        for (int i = 0; i < size; i++) {
            if (!((g) this.p.get(i)).m) {
                return true;
            }
        }
        return false;
    }

    void z(RecyclerView.C c2) {
        if (!this.r.isLayoutRequested() && this.n == 2) {
            float fJ = this.m.j(c2);
            int i = (int) (this.j + this.h);
            int i2 = (int) (this.k + this.i);
            if (Math.abs(i2 - c2.a.getTop()) >= c2.a.getHeight() * fJ || Math.abs(i - c2.a.getLeft()) >= c2.a.getWidth() * fJ) {
                List listU = u(c2);
                if (listU.size() == 0) {
                    return;
                }
                RecyclerView.C cB = this.m.b(c2, listU, i, i2);
                if (cB == null) {
                    this.u.clear();
                    this.v.clear();
                    return;
                }
                int I = cB.I();
                int I2 = c2.I();
                if (this.m.y(this.r, c2, cB)) {
                    this.m.z(this.r, c2, I2, cB, I, i, i2);
                }
            }
        }
    }
}
