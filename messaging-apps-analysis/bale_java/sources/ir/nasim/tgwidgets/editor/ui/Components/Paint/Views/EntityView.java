package ir.nasim.tgwidgets.editor.ui.Components.Paint.Views;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import ir.nasim.AbstractC23776xV3;
import ir.nasim.C22697vg5;
import ir.nasim.C5713Kn0;
import ir.nasim.DK5;
import ir.nasim.InterpolatorC12631ew1;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.Utilities;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* loaded from: classes7.dex */
public class EntityView extends FrameLayout {
    private static final List C0 = Arrays.asList(-90, 0, 90, Integer.valueOf(SetRpcStruct$ComposedRpc.JOIN_GROUP_FIELD_NUMBER));
    private ValueAnimator A;
    private float A0;
    private ValueAnimator B;
    private ValueAnimator B0;
    private boolean D;
    private boolean G;
    private float H;
    private ValueAnimator J;
    private C5713Kn0 a;
    private float b;
    private float c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private g k;
    private C22697vg5 l;
    protected SelectionView m;
    private GestureDetector n;
    private UUID o;
    private boolean p;
    private int q;
    private float r;
    private ValueAnimator s;
    private float t;
    private float u;
    private ValueAnimator v;
    private boolean w;
    private boolean x;
    private float y;
    private float z;
    private boolean z0;

    public class SelectionView extends FrameLayout {
        protected Paint a;
        protected Paint b;
        protected Paint c;
        private int d;

        public SelectionView(Context context) {
            super(context);
            this.a = new Paint(1);
            this.b = new Paint(1);
            this.c = new Paint(1);
            setWillNotDraw(false);
            this.a.setColor(-1);
            Paint paint = this.a;
            Paint.Style style = Paint.Style.STROKE;
            paint.setStyle(style);
            this.a.setStrokeWidth(AbstractC21455b.F(2.0f));
            this.a.setStrokeCap(Paint.Cap.ROUND);
            this.a.setPathEffect(new DashPathEffect(new float[]{AbstractC21455b.F(10.0f), AbstractC21455b.F(10.0f)}, 0.5f));
            this.a.setShadowLayer(AbstractC21455b.H(0.75f), 0.0f, 0.0f, 1342177280);
            this.b.setColor(-15033089);
            this.c.setColor(-1);
            this.c.setStyle(style);
            this.c.setStrokeWidth(AbstractC21455b.H(2.66f));
            this.c.setShadowLayer(AbstractC21455b.H(0.75f), 0.0f, 0.0f, 1342177280);
        }

        protected int a(float f, float f2) {
            return 0;
        }

        protected void b() {
            DK5 selectionBounds = EntityView.this.getSelectionBounds();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
            layoutParams.leftMargin = (int) selectionBounds.a;
            layoutParams.topMargin = (int) selectionBounds.b;
            layoutParams.width = (int) selectionBounds.c;
            layoutParams.height = (int) selectionBounds.d;
            setLayoutParams(layoutParams);
            setRotation(EntityView.this.getRotation());
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x002a, code lost:
        
            if (r0 != 6) goto L34;
         */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00ff  */
        @Override // android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onTouchEvent(android.view.MotionEvent r12) {
            /*
                Method dump skipped, instructions count: 327
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.EntityView.SelectionView.onTouchEvent(android.view.MotionEvent):boolean");
        }
    }

    class a extends GestureDetector.SimpleOnGestureListener {
        a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (EntityView.this.d || EntityView.this.f || EntityView.this.e) {
                return;
            }
            EntityView.this.j = true;
            if (EntityView.this.k != null) {
                EntityView.this.performHapticFeedback(0);
                EntityView.this.k.D(EntityView.this);
            }
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (animator == EntityView.this.A) {
                EntityView.this.A = null;
                EntityView.this.D = false;
            }
        }
    }

    class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (animator == EntityView.this.B) {
                EntityView.this.B = null;
                EntityView.this.G = false;
            }
        }
    }

    class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (animator == EntityView.this.s) {
                EntityView.this.s = null;
                EntityView.this.r = 0.0f;
            }
        }
    }

    class e extends AnimatorListenerAdapter {
        e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (animator == EntityView.this.v) {
                EntityView.this.v = null;
            }
        }
    }

    class f extends AnimatorListenerAdapter {
        f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (EntityView.this.z0) {
                return;
            }
            AbstractC21455b.i1(EntityView.this.m);
            EntityView.this.m = null;
        }
    }

    public interface g {
        boolean D(EntityView entityView);

        boolean d(EntityView entityView);

        float getCropRotation();

        default void h(boolean z) {
        }

        boolean i(EntityView entityView);

        float[] k(MotionEvent motionEvent, float f, float f2);

        default void l(boolean z) {
        }

        default void s(boolean z) {
        }

        default void u() {
        }

        int[] v(EntityView entityView);

        default void z(boolean z) {
        }
    }

    public EntityView(Context context, C22697vg5 c22697vg5) {
        super(context);
        this.a = new C5713Kn0(this);
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = false;
        this.p = true;
        this.q = 0;
        this.z0 = false;
        this.A0 = 1.0f;
        this.o = UUID.randomUUID();
        this.l = c22697vg5;
        this.n = new GestureDetector(context, new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M(float f2, ValueAnimator valueAnimator) {
        float fX0 = AbstractC21455b.X0(f2, this.q, valueAnimator.getAnimatedFraction());
        this.r = fX0;
        W(fX0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N(ValueAnimator valueAnimator) {
        W(AbstractC21455b.X0(this.t, this.u, this.v.getAnimatedFraction()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O(ValueAnimator valueAnimator) {
        b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P(ValueAnimator valueAnimator) {
        b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.H = fFloatValue;
        SelectionView selectionView = this.m;
        if (selectionView != null) {
            selectionView.setScaleX(AbstractC21455b.T0(0.9f, 1.0f, fFloatValue) * Utilities.c(this.A0 * 1.25f, 1.0f, 0.0f));
            this.m.setScaleY(AbstractC21455b.T0(0.9f, 1.0f, this.H) * Utilities.c(this.A0 * 1.25f, 1.0f, 0.0f));
            this.m.setAlpha(this.H * Math.max(0.0f, this.A0 - 0.8f) * 5.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.A0 = fFloatValue;
        setAlpha(fFloatValue);
        SelectionView selectionView = this.m;
        if (selectionView != null) {
            selectionView.setScaleX(AbstractC21455b.T0(0.9f, 1.0f, this.H) * Utilities.c(this.A0 * 1.25f, 1.0f, 0.0f));
            this.m.setScaleY(AbstractC21455b.T0(0.9f, 1.0f, this.H) * Utilities.c(this.A0 * 1.25f, 1.0f, 0.0f));
            this.m.setAlpha(this.H * Math.max(0.0f, this.A0 - 0.8f) * 5.0f);
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean S(float f2, float f3) {
        g gVar;
        g gVar2;
        if (getParent() == null) {
            return false;
        }
        float scaleX = ((View) getParent()).getScaleX();
        float f4 = (f2 - this.b) / scaleX;
        float f5 = (f3 - this.c) / scaleX;
        if (((float) Math.hypot(f4, f5)) <= (this.d ? 6.0f : 16.0f)) {
            return false;
        }
        U(f4, f5);
        this.b = f2;
        this.c = f3;
        this.d = true;
        if ((getParent() instanceof EntitiesContainerView) && (this.w || this.x)) {
            ((EntitiesContainerView) getParent()).invalidate();
        }
        if (!this.g && (gVar2 = this.k) != null) {
            this.g = true;
            gVar2.u();
        }
        if (!isSelected() && !this.h && (gVar = this.k) != null) {
            gVar.i(this);
            this.h = true;
        }
        g gVar3 = this.k;
        if (gVar3 != null) {
            gVar3.s(this.l.b - ((((float) getHeight()) / 2.0f) * scaleX) < ((float) AbstractC21455b.F(66.0f)));
            this.k.z(this.l.b + ((((float) getHeight()) / 2.0f) * scaleX) > ((float) (((View) getParent()).getHeight() - AbstractC21455b.F(114.0f))));
        }
        e0(AbstractC23776xV3.a(f2, f3, ((float) ((View) getParent()).getWidth()) / 2.0f, (float) (((View) getParent()).getHeight() - AbstractC21455b.F(76.0f))) < ((float) AbstractC21455b.F(32.0f)));
        this.a.i(false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        g gVar;
        g gVar2;
        if (this.g) {
            this.k.h(this.i);
            this.g = false;
        }
        if (!this.j && !this.d && !this.f && !this.h && (gVar2 = this.k) != null) {
            gVar2.i(this);
        }
        if (this.d && (gVar = this.k) != null) {
            gVar.s(false);
            this.k.z(false);
        }
        this.j = false;
        this.d = false;
        this.f = false;
        this.e = true;
        this.h = false;
        if (getParent() instanceof EntitiesContainerView) {
            ((EntitiesContainerView) getParent()).invalidate();
        }
    }

    private void W(float f2) {
        setRotation(f2);
        d0();
    }

    private void X(float... fArr) {
        ValueAnimator duration = ValueAnimator.ofFloat(fArr).setDuration(150L);
        this.A = duration;
        duration.setInterpolator(InterpolatorC12631ew1.f);
        this.A.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.x92
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.a.O(valueAnimator);
            }
        });
        this.A.addListener(new b());
        this.A.start();
    }

    private void Y(float... fArr) {
        ValueAnimator duration = ValueAnimator.ofFloat(fArr).setDuration(150L);
        this.B = duration;
        duration.setInterpolator(InterpolatorC12631ew1.f);
        this.B.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.v92
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.a.P(valueAnimator);
            }
        });
        this.B.addListener(new c());
        this.B.start();
    }

    private void c0(ViewGroup viewGroup, boolean z) {
        if (this.z0 != z) {
            this.z0 = z;
            ValueAnimator valueAnimator = this.J;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.J = null;
            }
            if (this.m == null) {
                if (!z && viewGroup == null) {
                    return;
                }
                SelectionView selectionViewG = G();
                this.m = selectionViewG;
                viewGroup.addView(selectionViewG);
                this.H = 0.0f;
            }
            this.m.b();
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.H, z ? 1.0f : 0.0f);
            this.J = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.y92
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    this.a.Q(valueAnimator2);
                }
            });
            this.J.addListener(new f());
            this.J.setDuration(280L);
            this.J.setInterpolator(InterpolatorC12631ew1.h);
            this.J.start();
        }
    }

    private void e0(boolean z) {
        if (this.i != z) {
            ValueAnimator valueAnimator = this.B0;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.B0 = null;
            }
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.A0, z ? 0.5f : 1.0f);
            this.B0 = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.w92
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    this.a.R(valueAnimator2);
                }
            });
            this.B0.setInterpolator(InterpolatorC12631ew1.h);
            this.B0.setDuration(280L);
            this.B0.start();
            this.i = z;
            g gVar = this.k;
            if (gVar != null) {
                gVar.l(z);
            }
        }
    }

    protected SelectionView G() {
        return null;
    }

    public void H() {
        c0(null, false);
    }

    public boolean I() {
        return this.d;
    }

    public final boolean J() {
        return this.w;
    }

    public final boolean K() {
        return this.x;
    }

    public final boolean L() {
        return !this.e;
    }

    public void U(float f2, float f3) {
        C22697vg5 c22697vg5 = this.l;
        float f4 = c22697vg5.a + f2;
        c22697vg5.a = f4;
        float f5 = c22697vg5.b + f3;
        c22697vg5.b = f5;
        if (this.D) {
            this.y = f4;
        }
        if (this.G) {
            this.z = f5;
        }
        if (((View) getParent()) != null) {
            if (this.w) {
                if (Math.abs(this.l.a - (r10.getMeasuredWidth() / 2.0f)) > AbstractC21455b.F(16.0f) || this.l.b >= r10.getMeasuredHeight() - AbstractC21455b.F(176.0f)) {
                    this.w = false;
                    if (getParent() instanceof EntitiesContainerView) {
                        ((EntitiesContainerView) getParent()).invalidate();
                    }
                    ValueAnimator valueAnimator = this.A;
                    if (valueAnimator != null) {
                        valueAnimator.cancel();
                    }
                    this.D = true;
                    X(1.0f, 0.0f);
                }
            } else if (Math.abs(this.l.a - (r10.getMeasuredWidth() / 2.0f)) <= AbstractC21455b.F(6.0f) && this.l.b < r10.getMeasuredHeight() - AbstractC21455b.F(176.0f)) {
                this.w = true;
                try {
                    performHapticFeedback(3, 2);
                } catch (Exception unused) {
                }
                if (getParent() instanceof EntitiesContainerView) {
                    ((EntitiesContainerView) getParent()).invalidate();
                }
                ValueAnimator valueAnimator2 = this.A;
                if (valueAnimator2 != null) {
                    valueAnimator2.cancel();
                }
                this.y = this.l.a;
                this.D = false;
                X(0.0f, 1.0f);
            }
            if (this.x) {
                if (Math.abs(this.l.b - (r10.getMeasuredHeight() / 2.0f)) > AbstractC21455b.F(16.0f)) {
                    this.x = false;
                    if (getParent() instanceof EntitiesContainerView) {
                        ((EntitiesContainerView) getParent()).invalidate();
                    }
                    ValueAnimator valueAnimator3 = this.B;
                    if (valueAnimator3 != null) {
                        valueAnimator3.cancel();
                    }
                    this.G = true;
                    Y(1.0f, 0.0f);
                }
            } else if (Math.abs(this.l.b - (r10.getMeasuredHeight() / 2.0f)) <= AbstractC21455b.F(6.0f)) {
                this.x = true;
                try {
                    performHapticFeedback(3, 2);
                } catch (Exception unused2) {
                }
                if (getParent() instanceof EntitiesContainerView) {
                    ((EntitiesContainerView) getParent()).invalidate();
                }
                ValueAnimator valueAnimator4 = this.B;
                if (valueAnimator4 != null) {
                    valueAnimator4.cancel();
                }
                this.z = this.l.b;
                this.G = false;
                Y(0.0f, 1.0f);
            }
        }
        b0();
    }

    public void V(final float f2) {
        if (!this.p) {
            Iterator it = C0.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                int iIntValue = ((Integer) it.next()).intValue();
                if (Math.abs(iIntValue - f2) < 5.0f) {
                    this.q = iIntValue;
                    this.p = true;
                    try {
                        performHapticFeedback(3, 2);
                    } catch (Exception unused) {
                    }
                    ValueAnimator valueAnimator = this.s;
                    if (valueAnimator != null) {
                        valueAnimator.cancel();
                    }
                    ValueAnimator valueAnimator2 = this.v;
                    if (valueAnimator2 != null) {
                        valueAnimator2.cancel();
                    }
                    ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(150L);
                    this.s = duration;
                    duration.setInterpolator(InterpolatorC12631ew1.f);
                    this.s.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.z92
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                            this.a.M(f2, valueAnimator3);
                        }
                    });
                    this.s.addListener(new d());
                    this.s.start();
                }
            }
        } else if (Math.abs(this.q - f2) >= 15.0f) {
            ValueAnimator valueAnimator3 = this.s;
            if (valueAnimator3 != null) {
                valueAnimator3.cancel();
            }
            ValueAnimator valueAnimator4 = this.v;
            if (valueAnimator4 != null) {
                valueAnimator4.cancel();
            }
            this.t = this.q;
            this.u = f2;
            ValueAnimator duration2 = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(150L);
            this.v = duration2;
            duration2.setInterpolator(InterpolatorC12631ew1.f);
            this.v.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.A92
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator5) {
                    this.a.N(valueAnimator5);
                }
            });
            this.v.addListener(new e());
            this.v.start();
            this.p = false;
        } else {
            f2 = this.s != null ? this.r : this.q;
        }
        ValueAnimator valueAnimator5 = this.v;
        if (valueAnimator5 != null) {
            this.u = f2;
            f2 = AbstractC21455b.X0(this.t, f2, valueAnimator5.getAnimatedFraction());
        }
        W(f2);
    }

    public void Z(float f2) {
        setScale(Math.max(getScale() * f2, 0.1f));
        d0();
    }

    public void a0(ViewGroup viewGroup) {
        c0(viewGroup, true);
    }

    protected void b0() {
        setX(getPositionX() - (getMeasuredWidth() / 2.0f));
        setY(getPositionY() - (getMeasuredHeight() / 2.0f));
        d0();
    }

    public void d0() {
        SelectionView selectionView = this.m;
        if (selectionView != null) {
            selectionView.b();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        float fE = this.a.e(0.05f);
        canvas.save();
        canvas.scale(fE, fE, getWidth() / 2.0f, getHeight() / 2.0f);
        if (getParent() instanceof View) {
            View view = (View) getParent();
            float f2 = this.A0;
            canvas.scale(f2, f2, (view.getWidth() / 2.0f) - getX(), (view.getHeight() - AbstractC21455b.F(76.0f)) - getY());
        }
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public C22697vg5 getPosition() {
        return this.l;
    }

    protected float getPositionX() {
        float f2 = this.l.a;
        if (getParent() == null) {
            return f2;
        }
        View view = (View) getParent();
        return this.A != null ? AbstractC21455b.T0(this.y, view.getMeasuredWidth() / 2.0f, ((Float) this.A.getAnimatedValue()).floatValue()) : this.w ? view.getMeasuredWidth() / 2.0f : f2;
    }

    protected float getPositionY() {
        float f2 = this.l.b;
        if (getParent() == null) {
            return f2;
        }
        View view = (View) getParent();
        return this.B != null ? AbstractC21455b.T0(this.z, view.getMeasuredHeight() / 2.0f, ((Float) this.B.getAnimatedValue()).floatValue()) : this.x ? view.getMeasuredHeight() / 2.0f : f2;
    }

    public float getScale() {
        return getScaleX();
    }

    protected DK5 getSelectionBounds() {
        return new DK5(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public UUID getUUID() {
        return this.o;
    }

    @Override // android.view.View
    public boolean isSelected() {
        return this.z0;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.k.d(this);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zS;
        if (motionEvent.getPointerCount() > 1 || !this.k.d(this)) {
            return false;
        }
        float[] fArrK = this.k.k(motionEvent, motionEvent.getRawX(), motionEvent.getRawY());
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.b = fArrK[0];
            this.c = fArrK[1];
            this.e = false;
            if ((getParent() instanceof EntitiesContainerView) && (this.w || this.x)) {
                ((EntitiesContainerView) getParent()).invalidate();
            }
            this.a.i(true);
            zS = true;
        } else {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    zS = S(fArrK[0], fArrK[1]);
                } else if (actionMasked != 3) {
                    if (actionMasked != 5) {
                        if (actionMasked != 6) {
                            zS = false;
                        }
                    }
                    this.b = fArrK[0];
                    this.c = fArrK[1];
                    this.e = false;
                    if (getParent() instanceof EntitiesContainerView) {
                        ((EntitiesContainerView) getParent()).invalidate();
                    }
                    this.a.i(true);
                    zS = true;
                }
            }
            T();
            this.a.i(false);
            zS = true;
        }
        this.n.onTouchEvent(motionEvent);
        return super.onTouchEvent(motionEvent) || zS;
    }

    public void setDelegate(g gVar) {
        this.k = gVar;
    }

    public void setHasStickyX(boolean z) {
        this.w = z;
    }

    public void setHasStickyY(boolean z) {
        this.x = z;
    }

    public void setPosition(C22697vg5 c22697vg5) {
        this.l = c22697vg5;
        b0();
    }

    public void setScale(float f2) {
        setScaleX(f2);
        setScaleY(f2);
    }

    public void setSelectionVisibility(boolean z) {
        SelectionView selectionView = this.m;
        if (selectionView == null) {
            return;
        }
        selectionView.setVisibility(z ? 0 : 8);
    }
}
