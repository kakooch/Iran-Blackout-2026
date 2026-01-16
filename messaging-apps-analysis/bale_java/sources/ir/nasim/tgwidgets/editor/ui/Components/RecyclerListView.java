package ir.nasim.tgwidgets.editor.ui.Components;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.gov.nist.core.Separators;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.StateSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManagerTgwidget;
import androidx.recyclerview.widget.RecyclerView;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC23598xB5;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC6403Nl2;
import ir.nasim.AbstractC8662Wx6;
import ir.nasim.FH3;
import ir.nasim.InterfaceC25043ze1;
import ir.nasim.N72;
import ir.nasim.QY0;
import ir.nasim.SK5;
import ir.nasim.YE2;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.ui.ActionBar.m;
import ir.nasim.tgwidgets.editor.ui.Components.m;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes7.dex */
public class RecyclerListView extends RecyclerView {
    private static int[] Q2;
    private static boolean R2;
    private static final Method S2;
    boolean A2;
    private boolean B1;
    boolean B2;
    private i C1;
    boolean C2;
    private j D1;
    float D2;
    private boolean E1;
    float E2;
    private RecyclerView.t F1;
    int[] F2;
    private View G1;
    protected InterfaceC25043ze1 G2;
    private FrameLayout H1;
    protected final m.h H2;
    private Runnable I1;
    private boolean I2;
    private FastScroll J1;
    private View.AccessibilityDelegate J2;
    public boolean K1;
    private boolean K2;
    private boolean L1;
    private RecyclerView.j L2;
    private boolean M1;
    private boolean M2;
    private boolean N1;
    private YE2 N2;
    private Drawable O1;
    int O2;
    private ArrayList P1;
    Runnable P2;
    private ArrayList Q1;
    private View R1;
    private int S1;
    private int U1;
    private int V1;
    private boolean W1;
    private int X1;
    private boolean Y1;
    private boolean Z1;
    private int a2;
    protected Drawable b2;
    protected int c2;
    protected View d2;
    protected Rect e2;
    private boolean f2;
    private boolean g2;
    private boolean h2;
    public boolean i2;
    public boolean j2;
    private ir.nasim.tgwidgets.editor.ui.Components.m k2;
    private View l2;
    private int m2;
    private boolean n2;
    private boolean o2;
    private boolean p2;
    private Runnable q2;
    private boolean r2;
    private Runnable s2;
    private boolean t2;
    public boolean u2;
    private boolean v2;
    private int w2;
    private int x2;
    private int y2;
    private int z2;

    public class FastScroll extends View {
        private int A;
        public boolean A0;
        private int B;
        float B0;
        Drawable C0;
        private int D;
        Drawable D0;
        boolean E0;
        public int F0;
        private int G;
        Runnable G0;
        private boolean H;
        float H0;
        boolean I0;
        private float J;
        long J0;
        float K0;
        float L0;
        public boolean a;
        private RectF b;
        private Paint c;
        private Paint d;
        private float e;
        private float f;
        private float g;
        private boolean h;
        private StaticLayout i;
        private StaticLayout j;
        private StaticLayout k;
        private StaticLayout l;
        private StaticLayout m;
        private float n;
        private boolean o;
        private float p;
        private float q;
        private TextPaint r;
        private String s;
        private Path t;
        private Path u;
        private float[] v;
        private float w;
        private float x;
        private float y;
        private long z;
        private int[] z0;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (FastScroll.this.h) {
                    AbstractC21455b.t(FastScroll.this.G0);
                    AbstractC21455b.n1(FastScroll.this.G0, 4000L);
                } else {
                    FastScroll.this.H = false;
                    FastScroll.this.invalidate();
                }
            }
        }

        public FastScroll(Context context, int i) {
            super(context);
            this.a = true;
            this.b = new RectF();
            this.c = new Paint(1);
            this.d = new Paint(1);
            this.n = 1.0f;
            this.r = new TextPaint(1);
            this.t = new Path();
            this.u = new Path();
            this.v = new float[8];
            this.z0 = new int[2];
            this.G0 = new a();
            this.L0 = 1.0f;
            this.B = i;
            if (i == 0) {
                this.r.setTextSize(AbstractC21455b.F(45.0f));
                this.E0 = FH3.D;
            } else {
                this.E0 = false;
                this.r.setTextSize(AbstractC21455b.F(13.0f));
                this.r.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
                Paint paint = this.d;
                int i2 = ir.nasim.tgwidgets.editor.ui.ActionBar.m.N4;
                paint.setColor(ir.nasim.tgwidgets.editor.ui.ActionBar.m.j0(i2, RecyclerListView.this.H2));
                Drawable drawableMutate = AbstractC4043Dl1.f(context, AbstractC23598xB5.calendar_date).mutate();
                this.D0 = drawableMutate;
                drawableMutate.setColorFilter(new PorterDuffColorFilter(QY0.c(ir.nasim.tgwidgets.editor.ui.ActionBar.m.j0(i2, RecyclerListView.this.H2), -1, 0.1f), PorterDuff.Mode.MULTIPLY));
            }
            for (int i3 = 0; i3 < 8; i3++) {
                this.v[i3] = AbstractC21455b.F(44.0f);
            }
            this.A = AbstractC21455b.F(this.E0 ? 10.0f : (i == 0 ? WKSRecord.Service.CISCO_SYS : SetRpcStruct$ComposedRpc.RESPONSE_STICKERS_REPONSE_FIELD_NUMBER) - 15);
            f();
            setFocusableInTouchMode(true);
            this.B0 = ViewConfiguration.get(context).getScaledTouchSlop();
            this.C0 = AbstractC4043Dl1.f(context, AbstractC23598xB5.fast_scroll_shadow);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(boolean z) {
            RecyclerView.p layoutManager = RecyclerListView.this.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManagerTgwidget) {
                LinearLayoutManagerTgwidget linearLayoutManagerTgwidget = (LinearLayoutManagerTgwidget) layoutManager;
                if (linearLayoutManagerTgwidget.u2() == 1) {
                    RecyclerView.h adapter = RecyclerListView.this.getAdapter();
                    if (adapter instanceof f) {
                        f fVar = (f) adapter;
                        fVar.D(RecyclerListView.this, this.e, this.z0);
                        if (z) {
                            int[] iArr = this.z0;
                            linearLayoutManagerTgwidget.H2(iArr[0], (-iArr[1]) + RecyclerListView.this.V1);
                        }
                        String strC = fVar.C(this.z0[0]);
                        if (strC == null) {
                            StaticLayout staticLayout = this.i;
                            if (staticLayout != null) {
                                this.j = staticLayout;
                            }
                            this.i = null;
                            return;
                        }
                        if (strC.equals(this.s)) {
                            return;
                        }
                        this.s = strC;
                        if (this.B == 0) {
                            this.i = new StaticLayout(strC, this.r, AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                        } else {
                            this.k = this.i;
                            int iMeasureText = ((int) this.r.measureText(strC)) + 1;
                            TextPaint textPaint = this.r;
                            Layout.Alignment alignment = Layout.Alignment.ALIGN_NORMAL;
                            this.i = new StaticLayout(strC, textPaint, iMeasureText, alignment, 1.0f, 0.0f, false);
                            if (this.k != null) {
                                String[] strArrSplit = strC.split(Separators.SP);
                                String[] strArrSplit2 = this.k.getText().toString().split(Separators.SP);
                                if (strArrSplit != null && strArrSplit2 != null && strArrSplit.length == 2 && strArrSplit2.length == 2 && strArrSplit[1].equals(strArrSplit2[1])) {
                                    String string = this.k.getText().toString();
                                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
                                    spannableStringBuilder.setSpan(new N72(), strArrSplit2[0].length(), string.length(), 0);
                                    this.k = new StaticLayout(spannableStringBuilder, this.r, ((int) this.r.measureText(string)) + 1, alignment, 1.0f, 0.0f, false);
                                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(strC);
                                    spannableStringBuilder2.setSpan(new N72(), strArrSplit[0].length(), strC.length(), 0);
                                    this.l = new StaticLayout(spannableStringBuilder2, this.r, iMeasureText, alignment, 1.0f, 0.0f, false);
                                    SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(strC);
                                    spannableStringBuilder3.setSpan(new N72(), 0, strArrSplit[0].length(), 0);
                                    this.m = new StaticLayout(spannableStringBuilder3, this.r, iMeasureText, alignment, 1.0f, 0.0f, false);
                                } else {
                                    this.l = this.i;
                                    this.m = null;
                                }
                                this.q = this.k.getWidth();
                                this.n = 0.0f;
                                this.o = getProgress() > this.p;
                            }
                            this.p = getProgress();
                        }
                        this.j = null;
                        if (this.i.getLineCount() > 0) {
                            this.i.getLineWidth(0);
                            this.i.getLineLeft(0);
                            if (this.E0) {
                                this.w = (AbstractC21455b.F(10.0f) + ((AbstractC21455b.F(88.0f) - this.i.getLineWidth(0)) / 2.0f)) - this.i.getLineLeft(0);
                            } else {
                                this.w = ((AbstractC21455b.F(88.0f) - this.i.getLineWidth(0)) / 2.0f) - this.i.getLineLeft(0);
                            }
                            this.x = (AbstractC21455b.F(88.0f) - this.i.getHeight()) / 2;
                        }
                    }
                }
            }
        }

        private void f() {
            this.D = this.B == 0 ? ir.nasim.tgwidgets.editor.ui.ActionBar.m.j0(ir.nasim.tgwidgets.editor.ui.ActionBar.m.V5, RecyclerListView.this.H2) : QY0.k(-16777216, 102);
            this.G = ir.nasim.tgwidgets.editor.ui.ActionBar.m.j0(ir.nasim.tgwidgets.editor.ui.ActionBar.m.U5, RecyclerListView.this.H2);
            this.c.setColor(this.D);
            if (this.B == 0) {
                this.r.setColor(ir.nasim.tgwidgets.editor.ui.ActionBar.m.j0(ir.nasim.tgwidgets.editor.ui.ActionBar.m.W5, RecyclerListView.this.H2));
            } else {
                this.r.setColor(ir.nasim.tgwidgets.editor.ui.ActionBar.m.j0(ir.nasim.tgwidgets.editor.ui.ActionBar.m.p5, RecyclerListView.this.H2));
            }
            invalidate();
        }

        public void e() {
            if (this.B != 1) {
                return;
            }
            if (!this.H) {
                this.H = true;
                invalidate();
            }
            AbstractC21455b.t(this.G0);
            AbstractC21455b.n1(this.G0, 2000L);
        }

        @Override // android.view.View
        public float getAlpha() {
            return this.L0;
        }

        public float getProgress() {
            return this.e;
        }

        public int getScrollBarY() {
            return ((int) Math.ceil((getMeasuredHeight() - AbstractC21455b.F(54.0f)) * this.e)) + AbstractC21455b.F(17.0f);
        }

        @Override // android.view.View
        public boolean isPressed() {
            return this.h;
        }

        @Override // android.view.View
        public void layout(int i, int i2, int i3, int i4) {
            if (RecyclerListView.this.h2) {
                super.layout(i, i2, i3, i4);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x01f2  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0202  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x025b  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x025f  */
        @Override // android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected void onDraw(android.graphics.Canvas r19) {
            /*
                Method dump skipped, instructions count: 1324
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.Components.RecyclerListView.FastScroll.onDraw(android.graphics.Canvas):void");
        }

        @Override // android.view.View
        protected void onMeasure(int i, int i2) {
            setMeasuredDimension(AbstractC21455b.F(this.B == 0 ? 132.0f : 240.0f), View.MeasureSpec.getSize(i2));
            this.u.reset();
            this.u.setLastPoint(0.0f, 0.0f);
            this.u.lineTo(AbstractC21455b.F(4.0f), -AbstractC21455b.F(4.0f));
            this.u.lineTo(-AbstractC21455b.F(4.0f), -AbstractC21455b.F(4.0f));
            this.u.close();
        }

        /* JADX WARN: Code restructure failed: missing block: B:79:0x0159, code lost:
        
            if (r0 <= (ir.nasim.tgwidgets.editor.messenger.AbstractC21455b.F(30.0f) + r8)) goto L81;
         */
        @Override // android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onTouchEvent(android.view.MotionEvent r8) {
            /*
                Method dump skipped, instructions count: 392
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.Components.RecyclerListView.FastScroll.onTouchEvent(android.view.MotionEvent):boolean");
        }

        @Override // android.view.View
        public void setAlpha(float f) {
            if (this.L0 != f) {
                this.L0 = f;
                super.setAlpha(f * this.K0);
            }
        }

        public void setIsVisible(boolean z) {
            if (this.A0 != z) {
                this.A0 = z;
                float f = z ? 1.0f : 0.0f;
                this.K0 = f;
                super.setAlpha(this.L0 * f);
            }
        }

        public void setProgress(float f) {
            this.e = f;
            invalidate();
        }

        public void setVisibilityAlpha(float f) {
            if (this.K0 != f) {
                this.K0 = f;
                super.setAlpha(this.L0 * f);
            }
        }
    }

    class a extends View.AccessibilityDelegate {
        a() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            if (view.isEnabled()) {
                accessibilityNodeInfo.addAction(16);
            }
        }
    }

    class b extends RecyclerView.j {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public void a() {
            RecyclerListView.this.H1(true);
            if (RecyclerListView.this.K2) {
                RecyclerListView.this.S1 = -1;
                if (RecyclerListView.this.s2 == null) {
                    RecyclerListView.this.e2.setEmpty();
                }
            }
            RecyclerListView.this.invalidate();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public void d(int i, int i2) {
            RecyclerListView.this.H1(true);
            if (RecyclerListView.this.R1 == null || RecyclerListView.this.R1.getAlpha() != 0.0f) {
                return;
            }
            RecyclerListView.this.S1 = -1;
            RecyclerListView.this.O1();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public void f(int i, int i2) {
            RecyclerListView.this.H1(true);
        }
    }

    class c extends RecyclerView.t {
        c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void a(RecyclerView recyclerView, int i) {
            RecyclerListView.this.J1(i);
            if (i != 0 && RecyclerListView.this.l2 != null) {
                if (RecyclerListView.this.I1 != null) {
                    AbstractC21455b.t(RecyclerListView.this.I1);
                    RecyclerListView.this.I1 = null;
                }
                MotionEvent motionEventObtain = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0);
                try {
                    RecyclerListView.this.k2.a(motionEventObtain);
                } catch (Exception e) {
                    AbstractC6403Nl2.d(e);
                }
                RecyclerListView.this.l2.onTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
                View view = RecyclerListView.this.l2;
                RecyclerListView recyclerListView = RecyclerListView.this;
                recyclerListView.Q1(recyclerListView.l2, 0.0f, 0.0f, false);
                RecyclerListView.this.l2 = null;
                RecyclerListView.this.T1(view, null);
                RecyclerListView.this.n2 = false;
            }
            if (RecyclerListView.this.F1 != null) {
                RecyclerListView.this.F1.a(recyclerView, i);
            }
            RecyclerListView recyclerListView2 = RecyclerListView.this;
            boolean z = i == 1 || i == 2;
            recyclerListView2.i2 = z;
            if (z) {
                recyclerListView2.j2 = true;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(RecyclerView recyclerView, int i, int i2) {
            if (RecyclerListView.this.F1 != null) {
                RecyclerListView.this.F1.b(recyclerView, i, i2);
            }
            RecyclerListView recyclerListView = RecyclerListView.this;
            if (recyclerListView.c2 != -1) {
                recyclerListView.e2.offset(-i, -i2);
                RecyclerListView recyclerListView2 = RecyclerListView.this;
                recyclerListView2.b2.setBounds(recyclerListView2.e2);
                RecyclerListView.this.invalidate();
            } else {
                recyclerListView.e2.setEmpty();
            }
            RecyclerListView.this.I1(false);
            if (i2 == 0 || RecyclerListView.this.J1 == null) {
                return;
            }
            RecyclerListView.this.J1.e();
        }
    }

    class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (RecyclerListView.this.G1 != null) {
                RecyclerListView.this.G1.setVisibility(8);
            }
        }
    }

    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerListView.this.getClass();
            int[] iArr = RecyclerListView.this.F2;
            throw null;
        }
    }

    public static abstract class f extends n {
        public boolean B(RecyclerListView recyclerListView) {
            return true;
        }

        public abstract String C(int i);

        public abstract void D(RecyclerListView recyclerListView, float f, int[] iArr);

        public abstract float E(RecyclerListView recyclerListView);

        public void F() {
        }

        public void G(RecyclerListView recyclerListView) {
        }

        public void H() {
        }
    }

    public static class g extends RecyclerView.C {
        public g(View view) {
            super(view);
        }
    }

    public interface h {
    }

    public interface i {
        void a(View view, int i);
    }

    public interface j {
        void a(View view, int i, float f, float f2);

        default void b(View view, int i, float f, float f2) {
        }

        default boolean c(View view, int i) {
            return false;
        }
    }

    public interface k {
    }

    public interface l {
    }

    /* JADX INFO: Access modifiers changed from: private */
    class m implements RecyclerView.s {

        class a extends m.c {
            private View a;
            final /* synthetic */ RecyclerListView b;

            /* renamed from: ir.nasim.tgwidgets.editor.ui.Components.RecyclerListView$m$a$a, reason: collision with other inner class name */
            class RunnableC1591a implements Runnable {
                final /* synthetic */ View a;
                final /* synthetic */ int b;
                final /* synthetic */ float c;
                final /* synthetic */ float d;

                RunnableC1591a(View view, int i, float f, float f2) {
                    this.a = view;
                    this.b = i;
                    this.c = f;
                    this.d = f2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (this == RecyclerListView.this.q2) {
                        RecyclerListView.this.q2 = null;
                    }
                    View view = this.a;
                    if (view != null) {
                        RecyclerListView.this.Q1(view, 0.0f, 0.0f, false);
                        if (RecyclerListView.this.p2) {
                            return;
                        }
                        try {
                            this.a.playSoundEffect(0);
                        } catch (Exception unused) {
                        }
                        this.a.sendAccessibilityEvent(1);
                        if (this.b != -1) {
                            if (RecyclerListView.this.C1 != null) {
                                RecyclerListView.this.C1.a(this.a, this.b);
                            } else if (RecyclerListView.this.D1 != null) {
                                j jVar = RecyclerListView.this.D1;
                                View view2 = this.a;
                                jVar.a(view2, this.b, this.c - view2.getX(), this.d - this.a.getY());
                            }
                        }
                    }
                }
            }

            a(RecyclerListView recyclerListView) {
                this.b = recyclerListView;
            }

            private void b(View view, MotionEvent motionEvent) {
                if (view != null) {
                    if (RecyclerListView.this.C1 == null && RecyclerListView.this.D1 == null) {
                        return;
                    }
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    RecyclerListView.this.Q1(view, x, y, true);
                    int i = RecyclerListView.this.m2;
                    if (RecyclerListView.this.p2 && i != -1) {
                        try {
                            view.playSoundEffect(0);
                        } catch (Exception unused) {
                        }
                        view.sendAccessibilityEvent(1);
                        if (RecyclerListView.this.C1 != null) {
                            RecyclerListView.this.C1.a(view, i);
                        } else if (RecyclerListView.this.D1 != null) {
                            RecyclerListView.this.D1.a(view, i, x - view.getX(), y - view.getY());
                        }
                    }
                    RecyclerListView recyclerListView = RecyclerListView.this;
                    RunnableC1591a runnableC1591a = new RunnableC1591a(view, i, x, y);
                    recyclerListView.q2 = runnableC1591a;
                    AbstractC21455b.n1(runnableC1591a, ViewConfiguration.getPressedStateDuration());
                    if (RecyclerListView.this.I1 != null) {
                        AbstractC21455b.t(RecyclerListView.this.I1);
                        RecyclerListView.this.I1 = null;
                        RecyclerListView.this.l2 = null;
                        RecyclerListView.this.n2 = false;
                        RecyclerListView.this.T1(view, motionEvent);
                    }
                }
            }

            @Override // ir.nasim.tgwidgets.editor.ui.Components.m.c
            public boolean a(MotionEvent motionEvent) {
                RecyclerListView.i1(RecyclerListView.this);
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (this.a == null || RecyclerListView.this.D1 == null || !RecyclerListView.this.D1.c(this.a, RecyclerListView.this.m2)) {
                    return false;
                }
                RecyclerListView.this.D1.b(this.a, RecyclerListView.this.m2, motionEvent.getX(), motionEvent.getY());
                this.a = null;
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (RecyclerListView.this.l2 == null || RecyclerListView.this.m2 == -1) {
                    return;
                }
                RecyclerListView.h1(RecyclerListView.this);
                RecyclerListView.i1(RecyclerListView.this);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (this.a == null || RecyclerListView.this.D1 == null || !RecyclerListView.this.D1.c(this.a, RecyclerListView.this.m2)) {
                    return false;
                }
                b(this.a, motionEvent);
                this.a = null;
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                if (RecyclerListView.this.l2 != null) {
                    if (RecyclerListView.this.D1 == null || !RecyclerListView.this.D1.c(RecyclerListView.this.l2, RecyclerListView.this.m2)) {
                        b(RecyclerListView.this.l2, motionEvent);
                    } else {
                        this.a = RecyclerListView.this.l2;
                    }
                }
                return false;
            }
        }

        public m(Context context) {
            RecyclerListView.this.k2 = new ir.nasim.tgwidgets.editor.ui.Components.m(context, new a(RecyclerListView.this));
            RecyclerListView.this.k2.b(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(float f, float f2) {
            if (RecyclerListView.this.I1 == null || RecyclerListView.this.l2 == null) {
                return;
            }
            RecyclerListView recyclerListView = RecyclerListView.this;
            recyclerListView.Q1(recyclerListView.l2, f, f2, true);
            RecyclerListView.this.I1 = null;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void a(RecyclerView recyclerView, MotionEvent motionEvent) {
        }

        /* JADX WARN: Removed duplicated region for block: B:94:0x0269  */
        @Override // androidx.recyclerview.widget.RecyclerView.s
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean c(androidx.recyclerview.widget.RecyclerView r19, android.view.MotionEvent r20) {
            /*
                Method dump skipped, instructions count: 633
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.Components.RecyclerListView.m.c(androidx.recyclerview.widget.RecyclerView, android.view.MotionEvent):boolean");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void e(boolean z) {
            RecyclerListView.this.cancelClickRunnables(true);
        }
    }

    public static abstract class n extends RecyclerView.h {
        public abstract boolean A(RecyclerView.C c);

        public int z(View view) {
            return 0;
        }
    }

    static {
        Method declaredMethod;
        try {
            declaredMethod = View.class.getDeclaredMethod("initializeScrollbars", TypedArray.class);
        } catch (Exception unused) {
            declaredMethod = null;
        }
        S2 = declaredMethod;
    }

    public RecyclerListView(Context context) {
        this(context, null);
    }

    private void G1() {
        this.C2 = false;
        AbstractC21455b.t(this.P2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H1(boolean z) {
        if (this.L1) {
            return;
        }
        if (getAdapter() == null || this.G1 == null) {
            if (!this.t2 || getVisibility() == 0) {
                return;
            }
            setVisibility(0);
            this.t2 = false;
            return;
        }
        boolean zL1 = L1();
        int i2 = zL1 ? 0 : 8;
        if (!this.v2 || !AbstractC8662Wx6.c()) {
            z = false;
        }
        if (!z) {
            this.O2 = i2;
            this.G1.setVisibility(i2);
            this.G1.setAlpha(1.0f);
        } else if (this.O2 != i2) {
            this.O2 = i2;
            if (i2 == 0) {
                this.G1.animate().setListener(null).cancel();
                if (this.G1.getVisibility() == 8) {
                    this.G1.setVisibility(0);
                    this.G1.setAlpha(0.0f);
                    if (this.w2 == 1) {
                        this.G1.setScaleX(0.7f);
                        this.G1.setScaleY(0.7f);
                    }
                }
                this.G1.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(150L).start();
            } else if (this.G1.getVisibility() != 8) {
                ViewPropertyAnimator viewPropertyAnimatorAlpha = this.G1.animate().alpha(0.0f);
                if (this.w2 == 1) {
                    viewPropertyAnimatorAlpha.scaleY(0.7f).scaleX(0.7f);
                }
                viewPropertyAnimatorAlpha.setDuration(150L).setListener(new d()).start();
            }
        }
        if (this.Y1) {
            int i3 = zL1 ? 4 : 0;
            if (getVisibility() != i3) {
                setVisibility(i3);
            }
            this.t2 = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J1(int i2) {
        if (i2 == 0) {
            if (this.M2) {
                this.M2 = false;
                ir.nasim.tgwidgets.editor.messenger.E.j().s(ir.nasim.tgwidgets.editor.messenger.E.e1, 512);
                return;
            }
            return;
        }
        if (this.M2 || !this.W1) {
            return;
        }
        this.M2 = true;
        ir.nasim.tgwidgets.editor.messenger.E.j().s(ir.nasim.tgwidgets.editor.messenger.E.d1, 512);
    }

    private boolean K1(float f2, float f3) {
        int measuredHeight = getMeasuredHeight();
        int[] iArr = this.F2;
        Math.min(measuredHeight - iArr[1], Math.max(f3, iArr[0]));
        Math.min(getMeasuredWidth(), Math.max(f2, 0.0f));
        if (getChildCount() <= 0) {
            return true;
        }
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R1(int i2, View view) {
        S1(i2, view, false, -1.0f, -1.0f);
    }

    private void S1(int i2, View view, boolean z, float f2, float f3) {
        Runnable runnable = this.s2;
        if (runnable != null) {
            AbstractC21455b.t(runnable);
            this.s2 = null;
        }
        if (this.b2 == null) {
            return;
        }
        boolean z2 = i2 != this.c2;
        int iZ = getAdapter() instanceof n ? ((n) getAdapter()).z(view) : 0;
        if (i2 != -1) {
            this.c2 = i2;
        }
        this.d2 = view;
        if (this.a2 == 8) {
            ir.nasim.tgwidgets.editor.ui.ActionBar.m.f1(this.b2, this.x2, 0);
        } else if (this.y2 > 0 && getAdapter() != null) {
            ir.nasim.tgwidgets.editor.ui.ActionBar.m.f1(this.b2, i2 == 0 ? this.y2 : 0, i2 == getAdapter().getItemCount() + (-2) ? this.y2 : 0);
        }
        this.e2.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom() - iZ);
        boolean zIsEnabled = view.isEnabled();
        if (this.f2 != zIsEnabled) {
            this.f2 = zIsEnabled;
        }
        if (z2) {
            this.b2.setVisible(false, false);
            this.b2.setState(StateSet.NOTHING);
        }
        setListSelectorColor(M1(i2));
        this.b2.setBounds(this.e2);
        if (z2 && getVisibility() == 0) {
            this.b2.setVisible(true, false);
        }
        if (z) {
            this.b2.setHotspot(f2, f3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T1(View view, MotionEvent motionEvent) {
        if (view == null || this.e2.isEmpty()) {
            return;
        }
        if (view.isEnabled()) {
            R1(this.m2, view);
            Drawable drawable = this.b2;
            if (drawable != null) {
                Drawable current = drawable.getCurrent();
                if (current instanceof TransitionDrawable) {
                    ((TransitionDrawable) current).resetTransition();
                }
                if (motionEvent != null) {
                    this.b2.setHotspot(motionEvent.getX(), motionEvent.getY());
                }
            }
        } else {
            this.e2.setEmpty();
        }
        V1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V1() {
        Drawable drawable = this.b2;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        if (this.l2 != null) {
            if (this.b2.setState(getDrawableStateForSelector())) {
                invalidateDrawable(this.b2);
            }
        } else if (this.s2 == null) {
            this.b2.setState(StateSet.NOTHING);
        }
    }

    private int[] getDrawableStateForSelector() {
        int[] iArrOnCreateDrawableState = onCreateDrawableState(1);
        iArrOnCreateDrawableState[iArrOnCreateDrawableState.length - 1] = 16842919;
        return iArrOnCreateDrawableState;
    }

    static /* bridge */ /* synthetic */ k h1(RecyclerListView recyclerListView) {
        recyclerListView.getClass();
        return null;
    }

    static /* bridge */ /* synthetic */ l i1(RecyclerListView recyclerListView) {
        recyclerListView.getClass();
        return null;
    }

    protected boolean D1(float f2, float f3) {
        return true;
    }

    protected boolean E1(View view) {
        return true;
    }

    protected boolean F1(View view, float f2, float f3) {
        return true;
    }

    public void I1(boolean z) {
        FastScroll fastScroll;
        if ((this.i2 || z) && this.J1 != null) {
            RecyclerView.p layoutManager = getLayoutManager();
            if (layoutManager instanceof LinearLayoutManagerTgwidget) {
                LinearLayoutManagerTgwidget linearLayoutManagerTgwidget = (LinearLayoutManagerTgwidget) layoutManager;
                if (linearLayoutManagerTgwidget.u2() == 1) {
                    int iD2 = linearLayoutManagerTgwidget.d2();
                    Math.abs(linearLayoutManagerTgwidget.g2() - iD2);
                    if (iD2 == -1) {
                        return;
                    }
                    if ((!this.i2 && !z) || (fastScroll = this.J1) == null || fastScroll.isPressed()) {
                        return;
                    }
                    RecyclerView.h adapter = getAdapter();
                    if (adapter instanceof f) {
                        f fVar = (f) adapter;
                        float fE = fVar.E(this);
                        this.J1.setIsVisible(fVar.B(this));
                        this.J1.setProgress(Math.min(1.0f, fE));
                        this.J1.d(false);
                    }
                }
            }
        }
    }

    public boolean L1() {
        return (getAdapter() == null || P1() || getAdapter().getItemCount() != 0) ? false : true;
    }

    public Integer M1(int i2) {
        YE2 ye2 = this.N2;
        if (ye2 != null) {
            return (Integer) ye2.a(Integer.valueOf(i2));
        }
        return null;
    }

    protected int N1(int i2) {
        return ir.nasim.tgwidgets.editor.ui.ActionBar.m.j0(i2, this.H2);
    }

    public void O1() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            getChildAt(i2).invalidate();
        }
    }

    public boolean P1() {
        return this.u2;
    }

    protected void Q1(View view, float f2, float f3, boolean z) {
        if (this.M1 || view == null) {
            return;
        }
        view.setPressed(z);
    }

    protected boolean U1() {
        return isAttachedToWindow();
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i2) {
        return this.r2 && super.canScrollVertically(i2);
    }

    public void cancelClickRunnables(boolean z) {
        Runnable runnable = this.I1;
        if (runnable != null) {
            AbstractC21455b.t(runnable);
            this.I1 = null;
        }
        View view = this.l2;
        if (view != null) {
            if (z) {
                Q1(view, 0.0f, 0.0f, false);
            }
            this.l2 = null;
            T1(view, null);
        }
        this.e2.setEmpty();
        Runnable runnable2 = this.q2;
        if (runnable2 != null) {
            AbstractC21455b.t(runnable2);
            this.q2 = null;
        }
        this.n2 = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        View view;
        InterfaceC25043ze1 interfaceC25043ze1;
        View view2;
        InterfaceC25043ze1 interfaceC25043ze12;
        if (this.B1 && this.Z1 && !this.e2.isEmpty()) {
            this.b2.setBounds(this.e2);
            canvas.save();
            if (this.g2 && (interfaceC25043ze12 = this.G2) != null) {
                interfaceC25043ze12.accept(canvas);
            }
            if (this.g2 && (view2 = this.d2) != null) {
                canvas.translate(view2.getX() - this.e2.left, this.d2.getY() - this.e2.top);
            }
            this.b2.draw(canvas);
            canvas.restore();
        }
        super.dispatchDraw(canvas);
        if (this.B1 && !this.Z1 && !this.e2.isEmpty()) {
            this.b2.setBounds(this.e2);
            canvas.save();
            if (this.g2 && (interfaceC25043ze1 = this.G2) != null) {
                interfaceC25043ze1.accept(canvas);
            }
            if (this.g2 && (view = this.d2) != null) {
                canvas.translate(view.getX() - this.e2.left, this.d2.getY() - this.e2.top);
            }
            this.b2.draw(canvas);
            canvas.restore();
        }
        FrameLayout frameLayout = this.H1;
        if (frameLayout != null) {
            frameLayout.draw(canvas);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        if (!this.E1) {
            return super.dispatchNestedPreScroll(i2, i3, iArr, iArr2, i4);
        }
        iArr[0] = i2;
        iArr[1] = i3;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        FastScroll fastScroll = getFastScroll();
        if (fastScroll == null || !fastScroll.A0 || !fastScroll.I0 || motionEvent.getActionMasked() == 1 || motionEvent.getActionMasked() == 3) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        V1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public View findChildViewUnder(float f2, float f3) {
        int childCount = getChildCount();
        int i2 = 0;
        while (i2 < 2) {
            for (int i3 = childCount - 1; i3 >= 0; i3--) {
                View childAt = getChildAt(i3);
                float translationX = i2 == 0 ? childAt.getTranslationX() : 0.0f;
                float translationY = i2 == 0 ? childAt.getTranslationY() : 0.0f;
                if (f2 >= childAt.getLeft() + translationX && f2 <= childAt.getRight() + translationX && f3 >= childAt.getTop() + translationY && f3 <= childAt.getBottom() + translationY) {
                    return childAt;
                }
            }
            i2++;
        }
        return null;
    }

    public View getEmptyView() {
        return this.G1;
    }

    public FastScroll getFastScroll() {
        return this.J1;
    }

    public ArrayList<View> getHeaders() {
        return this.P1;
    }

    public ArrayList<View> getHeadersCache() {
        return this.Q1;
    }

    public i getOnItemClickListener() {
        return this.C1;
    }

    public RecyclerView.t getOnScrollListener() {
        return this.F1;
    }

    public View getPinnedHeader() {
        return this.R1;
    }

    public View getPressedChildView() {
        return this.l2;
    }

    public int[] getResourceDeclareStyleableIntArray(String str, String str2) {
        try {
            Field field = Class.forName(str + ".R$styleable").getField(str2);
            if (field != null) {
                return (int[]) field.get(null);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public Drawable getSelectorDrawable() {
        return this.b2;
    }

    public Rect getSelectorRect() {
        return this.e2;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.b2;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        FastScroll fastScroll = this.J1;
        if (fastScroll == null || fastScroll.getParent() == getParent()) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) this.J1.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.J1);
        }
        ((ViewGroup) getParent()).addView(this.J1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onChildAttachedToWindow(View view) {
        if (getAdapter() instanceof n) {
            RecyclerView.C cFindContainingViewHolder = findContainingViewHolder(view);
            if (cFindContainingViewHolder != null) {
                view.setEnabled(((n) getAdapter()).A(cFindContainingViewHolder));
                if (this.I2) {
                    view.setAccessibilityDelegate(this.J2);
                }
            }
        } else {
            view.setEnabled(false);
            view.setAccessibilityDelegate(null);
        }
        super.onChildAttachedToWindow(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.c2 = -1;
        this.d2 = null;
        this.e2.setEmpty();
        if (this.M2) {
            this.M2 = false;
            ir.nasim.tgwidgets.editor.messenger.E.j().s(ir.nasim.tgwidgets.editor.messenger.E.e1, 512);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        if (this.o2) {
            requestDisallowInterceptTouchEvent(true);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        FastScroll fastScroll = this.J1;
        if (fastScroll != null) {
            this.h2 = true;
            int paddingTop = i3 + (fastScroll.a ? getPaddingTop() : fastScroll.F0);
            FastScroll fastScroll2 = this.J1;
            if (fastScroll2.E0) {
                fastScroll2.layout(0, paddingTop, fastScroll2.getMeasuredWidth(), this.J1.getMeasuredHeight() + paddingTop);
            } else {
                int measuredWidth = getMeasuredWidth() - this.J1.getMeasuredWidth();
                FastScroll fastScroll3 = this.J1;
                fastScroll3.layout(measuredWidth, paddingTop, fastScroll3.getMeasuredWidth() + measuredWidth, this.J1.getMeasuredHeight() + paddingTop);
            }
            this.h2 = false;
        }
        I1(false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        FastScroll fastScroll = this.J1;
        if (fastScroll != null && fastScroll.getLayoutParams() != null) {
            FastScroll fastScroll2 = this.J1;
            int measuredHeight = (getMeasuredHeight() - (fastScroll2.a ? getPaddingTop() : fastScroll2.F0)) - getPaddingBottom();
            this.J1.getLayoutParams().height = measuredHeight;
            this.J1.measure(View.MeasureSpec.makeMeasureSpec(AbstractC21455b.F(132.0f), 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
        }
        this.z2 = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        FrameLayout frameLayout = this.H1;
        if (frameLayout != null) {
            frameLayout.requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        FastScroll fastScroll = this.J1;
        if (fastScroll != null && fastScroll.h) {
            return false;
        }
        if (!this.A2 || motionEvent.getAction() == 0 || motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            this.D2 = Float.MAX_VALUE;
            this.E2 = Float.MAX_VALUE;
            this.A2 = false;
            this.B2 = false;
            getParent().requestDisallowInterceptTouchEvent(false);
            G1();
            return super.onTouchEvent(motionEvent);
        }
        if (this.D2 == Float.MAX_VALUE && this.E2 == Float.MAX_VALUE) {
            this.D2 = motionEvent.getX();
            this.E2 = motionEvent.getY();
        }
        if (!this.B2 && Math.abs(motionEvent.getY() - this.E2) > this.z2) {
            this.B2 = true;
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        if (!this.B2) {
            return true;
        }
        K1(motionEvent.getX(), motionEvent.getY());
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.u2) {
            return;
        }
        super.requestLayout();
    }

    public void setAccessibilityEnabled(boolean z) {
        this.I2 = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.h hVar) {
        RecyclerView.h adapter = getAdapter();
        if (adapter != null) {
            adapter.unregisterAdapterDataObserver(this.L2);
        }
        ArrayList arrayList = this.P1;
        if (arrayList != null) {
            arrayList.clear();
            this.Q1.clear();
        }
        this.S1 = -1;
        this.c2 = -1;
        this.d2 = null;
        this.e2.setEmpty();
        this.R1 = null;
        super.setAdapter(hVar);
        if (hVar != null) {
            hVar.registerAdapterDataObserver(this.L2);
        }
        H1(false);
    }

    public void setAllowItemsInteractionDuringAnimation(boolean z) {
        this.N1 = z;
    }

    public void setAllowStopHeaveOperations(boolean z) {
        this.W1 = z;
    }

    public void setAnimateEmptyView(boolean z, int i2) {
        this.v2 = z;
        this.w2 = i2;
    }

    public void setDisableHighlightState(boolean z) {
        this.M1 = z;
    }

    public void setDisallowInterceptTouchEvents(boolean z) {
        this.o2 = z;
    }

    public void setDrawSelection(boolean z) {
        this.B1 = z;
    }

    public void setDrawSelectorBehind(boolean z) {
        this.Z1 = z;
    }

    public void setEmptyView(View view) {
        View view2 = this.G1;
        if (view2 == view) {
            return;
        }
        if (view2 != null) {
            view2.animate().setListener(null).cancel();
        }
        this.G1 = view;
        if (this.v2 && view != null) {
            view.setVisibility(8);
        }
        if (!this.L1) {
            this.O2 = -1;
            H1(U1());
            return;
        }
        View view3 = this.G1;
        if (view3 != null) {
            this.O2 = 8;
            view3.setVisibility(8);
        }
    }

    public void setFastScrollEnabled(int i2) {
        this.J1 = new FastScroll(getContext(), i2);
        if (getParent() != null) {
            ((ViewGroup) getParent()).addView(this.J1);
        }
    }

    public void setFastScrollVisible(boolean z) {
        FastScroll fastScroll = this.J1;
        if (fastScroll == null) {
            return;
        }
        fastScroll.setVisibility(z ? 0 : 8);
        this.J1.A0 = z;
    }

    public void setHideIfEmpty(boolean z) {
        this.Y1 = z;
    }

    public void setInstantClick(boolean z) {
        this.p2 = z;
    }

    public void setItemSelectorColorProvider(YE2 ye2) {
        this.N2 = ye2;
    }

    public void setListSelectorColor(Integer num) {
        ir.nasim.tgwidgets.editor.ui.ActionBar.m.g1(this.b2, num == null ? N1(ir.nasim.tgwidgets.editor.ui.ActionBar.m.S4) : num.intValue(), true);
    }

    public void setOnInterceptTouchListener(h hVar) {
    }

    public void setOnItemClickListener(i iVar) {
        this.C1 = iVar;
    }

    public void setOnItemLongClickListener(k kVar) {
        setOnItemLongClickListener(kVar, ViewConfiguration.getLongPressTimeout());
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setOnScrollListener(RecyclerView.t tVar) {
        this.F1 = tVar;
    }

    public void setPinnedHeaderShadowDrawable(Drawable drawable) {
        this.O1 = drawable;
    }

    public void setPinnedSectionOffsetY(int i2) {
        this.V1 = i2;
        invalidate();
    }

    public void setResetSelectorOnChanged(boolean z) {
        this.K2 = z;
    }

    public void setScrollEnabled(boolean z) {
        this.r2 = z;
    }

    public void setSectionsType(int i2) {
        this.X1 = i2;
        if (i2 == 1 || i2 == 3) {
            this.P1 = new ArrayList();
            this.Q1 = new ArrayList();
        }
    }

    public void setSelectorDrawableColor(int i2) {
        Drawable drawable = this.b2;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        int i3 = this.a2;
        if (i3 == 8) {
            this.b2 = ir.nasim.tgwidgets.editor.ui.ActionBar.m.U(i2, this.x2, 0);
        } else {
            int i4 = this.y2;
            if (i4 > 0) {
                this.b2 = ir.nasim.tgwidgets.editor.ui.ActionBar.m.U(i2, i4, i4);
            } else {
                int i5 = this.x2;
                if (i5 > 0 && i3 != 1) {
                    this.b2 = ir.nasim.tgwidgets.editor.ui.ActionBar.m.c0(i5, 0, i2, -16777216);
                } else if (i3 == 2) {
                    this.b2 = ir.nasim.tgwidgets.editor.ui.ActionBar.m.u0(i2, false);
                } else {
                    this.b2 = ir.nasim.tgwidgets.editor.ui.ActionBar.m.a0(i2, i3, i5);
                }
            }
        }
        this.b2.setCallback(this);
    }

    public void setSelectorRadius(int i2) {
        this.x2 = i2;
    }

    public void setSelectorTransformer(InterfaceC25043ze1 interfaceC25043ze1) {
        this.G2 = interfaceC25043ze1;
    }

    public void setSelectorType(int i2) {
        this.a2 = i2;
    }

    public void setTopBottomSelectorRadius(int i2) {
        this.y2 = i2;
    }

    public void setTranslateSelector(boolean z) {
        this.g2 = z;
    }

    @Override // android.view.View
    public void setTranslationY(float f2) {
        super.setTranslationY(f2);
        FastScroll fastScroll = this.J1;
        if (fastScroll != null) {
            fastScroll.setTranslationY(f2);
        }
    }

    @Override // android.view.View
    public void setVerticalScrollBarEnabled(boolean z) {
        if (Q2 != null) {
            super.setVerticalScrollBarEnabled(z);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        if (i2 != 0) {
            this.t2 = false;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void stopScroll() {
        try {
            super.stopScroll();
        } catch (NullPointerException unused) {
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return this.b2 == drawable || super.verifyDrawable(drawable);
    }

    public RecyclerListView(Context context, m.h hVar) {
        super(context);
        this.B1 = true;
        this.N1 = true;
        this.S1 = -1;
        this.U1 = -1;
        this.Y1 = true;
        this.a2 = 2;
        this.e2 = new Rect();
        this.r2 = true;
        this.D2 = Float.MAX_VALUE;
        this.E2 = Float.MAX_VALUE;
        this.I2 = true;
        this.J2 = new a();
        this.K2 = true;
        this.L2 = new b();
        this.P2 = new e();
        this.H2 = hVar;
        Drawable drawableU0 = ir.nasim.tgwidgets.editor.ui.ActionBar.m.u0(N1(ir.nasim.tgwidgets.editor.ui.ActionBar.m.S4), false);
        this.b2 = drawableU0;
        drawableU0.setCallback(this);
        try {
            if (!R2) {
                int[] resourceDeclareStyleableIntArray = getResourceDeclareStyleableIntArray("com.android.internal", "View");
                Q2 = resourceDeclareStyleableIntArray;
                if (resourceDeclareStyleableIntArray == null) {
                    Q2 = new int[0];
                }
                R2 = true;
            }
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(Q2);
            Method method = S2;
            if (method != null) {
                method.invoke(this, typedArrayObtainStyledAttributes);
            }
        } catch (Throwable th) {
            AbstractC6403Nl2.d(th);
        }
        super.setOnScrollListener(new c());
        addOnItemTouchListener(new m(context));
    }

    public void setOnItemClickListener(j jVar) {
        this.D1 = jVar;
    }

    public void setOnItemLongClickListener(k kVar, long j2) {
        this.k2.b(kVar != null);
        this.k2.c(j2);
    }

    public void setOnItemLongClickListener(l lVar) {
        setOnItemLongClickListener(lVar, ViewConfiguration.getLongPressTimeout());
    }

    public void setOnItemLongClickListener(l lVar, long j2) {
        this.k2.b(lVar != null);
        this.k2.c(j2);
    }

    public void setItemsEnterAnimator(SK5 sk5) {
    }
}
