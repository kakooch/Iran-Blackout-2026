package ir.nasim.tgwidgets.editor.ui.Components;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.SystemClock;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.transition.TransitionManager;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManagerTgwidget;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC13840gu3;
import ir.nasim.AbstractC3671Bv7;
import ir.nasim.C19545qX7;
import ir.nasim.C22477vI7;
import ir.nasim.C25039zd7;
import ir.nasim.InterpolatorC12631ew1;
import ir.nasim.QY0;
import ir.nasim.R62;
import ir.nasim.X2;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.C;
import ir.nasim.tgwidgets.editor.messenger.Utilities;
import ir.nasim.tgwidgets.editor.tgnet.ConnectionsManager;
import ir.nasim.tgwidgets.editor.ui.ActionBar.m;
import ir.nasim.tgwidgets.editor.ui.Components.RecyclerListView;
import ir.nasim.tgwidgets.editor.ui.Components.ViewPagerFixed;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class ViewPagerFixed extends FrameLayout {
    private static final Interpolator A = new Interpolator() { // from class: ir.nasim.oX7
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            return ViewPagerFixed.v(f);
        }
    };
    private m.h a;
    int b;
    int c;
    protected View[] d;
    private int[] e;
    protected SparseArray f;
    private int g;
    private int h;
    private int i;
    private VelocityTracker j;
    private AnimatorSet k;
    private boolean l;
    private boolean m;
    private float n;
    private boolean o;
    private int p;
    private boolean q;
    private boolean r;
    private final float s;
    private e t;
    TabsView u;
    ValueAnimator.AnimatorUpdateListener v;
    private Rect w;
    private boolean x;
    private ValueAnimator y;
    private float z;

    public static class TabsView extends FrameLayout {
        private int A;
        private int A0;
        private int B;
        private int B0;
        private int C0;
        private int D;
        private boolean D0;
        private boolean E0;
        private float F0;
        private GradientDrawable G;
        private InterpolatorC12631ew1 G0;
        private int H;
        private SparseIntArray H0;
        private SparseIntArray I0;
        private int J;
        private SparseIntArray J0;
        private SparseIntArray K0;
        private long L0;
        private float M0;
        private int N0;
        private int O0;
        private Runnable P0;
        private m.h Q0;
        ValueAnimator R0;
        float S0;
        float T0;
        private float a;
        private TextPaint b;
        private TextPaint c;
        private Paint d;
        private Paint e;
        private ArrayList f;
        private Bitmap g;
        private Paint h;
        private float i;
        private boolean j;
        private boolean k;
        private float l;
        private float m;
        public int n;
        private boolean o;
        private boolean p;
        private RecyclerListView q;
        private LinearLayoutManagerTgwidget r;
        private g s;
        private i t;
        private int u;
        private int v;
        private int w;
        private int x;
        private boolean y;
        private float z;
        private int z0;

        public class TabView extends View {
            private h a;
            private int b;
            private int c;
            private int d;
            private RectF e;
            private String f;
            private StaticLayout g;
            private int h;

            public TabView(Context context) {
                super(context);
                this.e = new RectF();
            }

            @Override // android.view.View
            public int getId() {
                return this.a.a;
            }

            @Override // android.view.View
            protected void onDraw(Canvas canvas) {
                int i;
                int i2;
                int i3;
                int i4;
                int i5;
                String str;
                int iCeil;
                int iF;
                int iF2;
                if (this.a.a != Integer.MAX_VALUE && TabsView.this.l != 0.0f) {
                    canvas.save();
                    float f = TabsView.this.l * (this.d % 2 == 0 ? 1.0f : -1.0f);
                    canvas.translate(AbstractC21455b.F(0.66f) * f, 0.0f);
                    canvas.rotate(f, getMeasuredWidth() / 2, getMeasuredHeight() / 2);
                }
                if (TabsView.this.B != -1) {
                    i = TabsView.this.B;
                    i2 = TabsView.this.v;
                } else {
                    i = TabsView.this.v;
                    i2 = TabsView.this.O0;
                }
                if (this.a.a == i) {
                    i3 = TabsView.this.J;
                    i4 = TabsView.this.z0;
                    Runnable runnable = ir.nasim.tgwidgets.editor.ui.ActionBar.m.b;
                } else {
                    i3 = TabsView.this.z0;
                    i4 = TabsView.this.J;
                    Runnable runnable2 = ir.nasim.tgwidgets.editor.ui.ActionBar.m.b;
                }
                if ((TabsView.this.y || TabsView.this.B != -1) && ((i5 = this.a.a) == i || i5 == i2)) {
                    TabsView.this.b.setColor(QY0.c(ir.nasim.tgwidgets.editor.ui.ActionBar.m.j0(i4, TabsView.this.Q0), ir.nasim.tgwidgets.editor.ui.ActionBar.m.j0(i3, TabsView.this.Q0), TabsView.this.z));
                } else {
                    TabsView.this.b.setColor(ir.nasim.tgwidgets.editor.ui.ActionBar.m.j0(i3, TabsView.this.Q0));
                }
                int i6 = this.a.d;
                if (i6 > 0) {
                    str = String.format("%d", Integer.valueOf(i6));
                    iCeil = (int) Math.ceil(TabsView.this.c.measureText(str));
                    iF = Math.max(AbstractC21455b.F(10.0f), iCeil) + AbstractC21455b.F(10.0f);
                } else {
                    str = null;
                    iCeil = 0;
                    iF = 0;
                }
                if (this.a.a != Integer.MAX_VALUE && (TabsView.this.j || TabsView.this.m != 0.0f)) {
                    iF = (int) (iF + ((AbstractC21455b.F(20.0f) - iF) * TabsView.this.m));
                }
                int i7 = this.a.c;
                if (iF != 0) {
                    iF2 = AbstractC21455b.F((str != null ? 1.0f : TabsView.this.m) * 6.0f) + iF;
                } else {
                    iF2 = 0;
                }
                this.c = i7 + iF2;
                int measuredWidth = (getMeasuredWidth() - this.c) / 2;
                if (!TextUtils.equals(this.a.b, this.f)) {
                    String str2 = this.a.b;
                    this.f = str2;
                    StaticLayout staticLayout = new StaticLayout(R62.S(str2, TabsView.this.b.getFontMetricsInt(), AbstractC21455b.F(15.0f), false), TabsView.this.b, AbstractC21455b.F(400.0f), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                    this.g = staticLayout;
                    this.b = staticLayout.getHeight();
                    this.h = (int) (-this.g.getLineLeft(0));
                }
                if (this.g != null) {
                    canvas.save();
                    canvas.translate(this.h + measuredWidth, ((getMeasuredHeight() - this.b) / 2) + 1);
                    this.g.draw(canvas);
                    canvas.restore();
                }
                if (str != null || (this.a.a != Integer.MAX_VALUE && (TabsView.this.j || TabsView.this.m != 0.0f))) {
                    TabsView.this.c.setColor(ir.nasim.tgwidgets.editor.ui.ActionBar.m.j0(TabsView.this.B0, TabsView.this.Q0));
                    TabsView.this.e.setColor(TabsView.this.b.getColor());
                    int iF3 = measuredWidth + this.a.c + AbstractC21455b.F(6.0f);
                    int measuredHeight = (getMeasuredHeight() - AbstractC21455b.F(20.0f)) / 2;
                    if (this.a.a == Integer.MAX_VALUE || ((!TabsView.this.j && TabsView.this.m == 0.0f) || str != null)) {
                        TabsView.this.e.setAlpha(255);
                    } else {
                        TabsView.this.e.setAlpha((int) (TabsView.this.m * 255.0f));
                    }
                    this.e.set(iF3, measuredHeight, iF3 + iF, AbstractC21455b.F(20.0f) + measuredHeight);
                    RectF rectF = this.e;
                    float f2 = AbstractC21455b.g;
                    canvas.drawRoundRect(rectF, f2 * 11.5f, f2 * 11.5f, TabsView.this.e);
                    if (str != null) {
                        if (this.a.a != Integer.MAX_VALUE) {
                            TabsView.this.c.setAlpha((int) ((1.0f - TabsView.this.m) * 255.0f));
                        }
                        RectF rectF2 = this.e;
                        canvas.drawText(str, rectF2.left + ((rectF2.width() - iCeil) / 2.0f), measuredHeight + AbstractC21455b.F(14.5f), TabsView.this.c);
                    }
                    if (this.a.a != Integer.MAX_VALUE && (TabsView.this.j || TabsView.this.m != 0.0f)) {
                        TabsView.this.d.setColor(TabsView.this.c.getColor());
                        TabsView.this.d.setAlpha((int) (TabsView.this.m * 255.0f));
                        float F = AbstractC21455b.F(3.0f);
                        canvas.drawLine(this.e.centerX() - F, this.e.centerY() - F, this.e.centerX() + F, this.e.centerY() + F, TabsView.this.d);
                        canvas.drawLine(this.e.centerX() - F, this.e.centerY() + F, this.e.centerX() + F, this.e.centerY() - F, TabsView.this.d);
                    }
                }
                if (this.a.a == Integer.MAX_VALUE || TabsView.this.l == 0.0f) {
                    return;
                }
                canvas.restore();
            }

            @Override // android.view.View
            public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
                super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
                accessibilityNodeInfo.setSelected((this.a == null || TabsView.this.v == -1 || this.a.a != TabsView.this.v) ? false : true);
            }

            @Override // android.view.View
            protected void onMeasure(int i, int i2) {
                setMeasuredDimension(this.a.a(false, TabsView.this.b) + AbstractC21455b.F(TabsView.this.n * 2) + TabsView.this.x, View.MeasureSpec.getSize(i2));
            }

            public void setTab(h hVar, int i) {
                this.a = hVar;
                this.d = i;
                setContentDescription(hVar.b);
                setAlpha(hVar.e);
                requestLayout();
            }
        }

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (TabsView.this.y) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime() - TabsView.this.L0;
                    if (jElapsedRealtime > 17) {
                        jElapsedRealtime = 17;
                    }
                    TabsView.this.M0 += jElapsedRealtime / 200.0f;
                    TabsView tabsView = TabsView.this;
                    tabsView.setAnimationIdicatorProgress(tabsView.G0.getInterpolation(TabsView.this.M0));
                    if (TabsView.this.M0 > 1.0f) {
                        TabsView.this.M0 = 1.0f;
                    }
                    if (TabsView.this.M0 < 1.0f) {
                        AbstractC21455b.m1(TabsView.this.P0);
                        return;
                    }
                    TabsView.this.y = false;
                    TabsView.this.setEnabled(true);
                    if (TabsView.this.t != null) {
                        TabsView.this.t.a(1.0f);
                    }
                }
            }
        }

        class b extends RecyclerListView {
            b(Context context) {
                super(context);
            }

            @Override // ir.nasim.tgwidgets.editor.ui.Components.RecyclerListView
            protected boolean F1(View view, float f, float f2) {
                if (TabsView.this.j) {
                    TabView tabView = (TabView) view;
                    float F = AbstractC21455b.F(6.0f);
                    if (tabView.e.left - F < f && tabView.e.right + F > f) {
                        return false;
                    }
                }
                return super.F1(view, f, f2);
            }

            @Override // android.view.ViewGroup
            public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
                super.addView(view, i, layoutParams);
                if (TabsView.this.E0) {
                    view.setScaleX(0.3f);
                    view.setScaleY(0.3f);
                    view.setAlpha(0.0f);
                } else {
                    view.setScaleX(1.0f);
                    view.setScaleY(1.0f);
                    view.setAlpha(1.0f);
                }
            }

            @Override // android.view.View
            public void setAlpha(float f) {
                super.setAlpha(f);
                TabsView.this.invalidate();
            }
        }

        class c extends LinearLayoutManagerTgwidget {

            class a extends androidx.recyclerview.widget.o {
                a(Context context) {
                    super(context);
                }

                @Override // androidx.recyclerview.widget.o, androidx.recyclerview.widget.RecyclerView.y
                protected void o(View view, RecyclerView.z zVar, RecyclerView.y.a aVar) {
                    int iT = t(view, z());
                    if (iT > 0 || (iT == 0 && view.getLeft() - AbstractC21455b.F(21.0f) < 0)) {
                        iT += AbstractC21455b.F(60.0f);
                    } else if (iT < 0 || (iT == 0 && view.getRight() + AbstractC21455b.F(21.0f) > TabsView.this.getMeasuredWidth())) {
                        iT -= AbstractC21455b.F(60.0f);
                    }
                    int iU = u(view, B());
                    int iMax = Math.max(SetRpcStruct$ComposedRpc.JOIN_GROUP_FIELD_NUMBER, w((int) Math.sqrt((iT * iT) + (iU * iU))));
                    if (iMax > 0) {
                        aVar.d(-iT, -iU, iMax, this.j);
                    }
                }
            }

            c(Context context, int i, boolean z) {
                super(context, i, z);
            }

            @Override // androidx.recyclerview.widget.LinearLayoutManagerTgwidget, androidx.recyclerview.widget.RecyclerView.p
            public void L1(RecyclerView recyclerView, RecyclerView.z zVar, int i) {
                a aVar = new a(recyclerView.getContext());
                aVar.p(i);
                M1(aVar);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.p
            public void P0(RecyclerView.v vVar, RecyclerView.z zVar, X2 x2) {
                super.P0(vVar, zVar, x2);
                if (TabsView.this.E0) {
                    x2.e1(false);
                }
            }
        }

        class d extends RecyclerView.t {
            d() {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.t
            public void b(RecyclerView recyclerView, int i, int i2) {
                TabsView.this.invalidate();
            }
        }

        class e implements ValueAnimator.AnimatorUpdateListener {
            e() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                TabsView.this.setAnimationIdicatorProgress(fFloatValue);
                if (TabsView.this.t != null) {
                    TabsView.this.t.a(fFloatValue);
                }
            }
        }

        class f extends AnimatorListenerAdapter {
            f() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                TabsView.this.y = false;
                TabsView.this.setEnabled(true);
                if (TabsView.this.t != null) {
                    TabsView.this.t.a(1.0f);
                }
                TabsView.this.invalidate();
            }
        }

        private class g extends RecyclerListView.n {
            private Context d;

            public g(Context context) {
                this.d = context;
            }

            @Override // ir.nasim.tgwidgets.editor.ui.Components.RecyclerListView.n
            public boolean A(RecyclerView.C c) {
                return true;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.h
            public int getItemCount() {
                return TabsView.this.f.size();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.h
            public long getItemId(int i) {
                return ((h) TabsView.this.f.get(i)).a;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.h
            public int getItemViewType(int i) {
                return 0;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.h
            public void onBindViewHolder(RecyclerView.C c, int i) {
                ((TabView) c.a).setTab((h) TabsView.this.f.get(i), i);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.h
            public RecyclerView.C onCreateViewHolder(ViewGroup viewGroup, int i) {
                return new RecyclerListView.g(TabsView.this.new TabView(this.d));
            }
        }

        private static class h {
            public int a;
            public String b;
            public int c;
            public int d;
            public float e = 1.0f;

            public h(int i, String str) {
                this.a = i;
                this.b = str;
            }

            public int a(boolean z, TextPaint textPaint) {
                int iCeil = (int) Math.ceil(textPaint.measureText(this.b));
                this.c = iCeil;
                return Math.max(AbstractC21455b.F(40.0f), iCeil);
            }
        }

        public interface i {
            void a(float f);

            void b(int i, boolean z);

            void c();

            void d();

            boolean e();
        }

        public TabsView(Context context) {
            this(context, false, 8, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void F(View view, int i2, float f2, float f3) {
            i iVar;
            if (this.t.e()) {
                TabView tabView = (TabView) view;
                if (i2 != this.u || (iVar = this.t) == null) {
                    I(tabView.a.a, i2);
                } else {
                    iVar.d();
                }
            }
        }

        private void H(int i2) {
            if (this.f.isEmpty() || this.D == i2 || i2 < 0 || i2 >= this.f.size()) {
                return;
            }
            this.D = i2;
            this.q.smoothScrollToPosition(i2);
        }

        private void K() {
            this.K0.clear();
            this.J0.clear();
            int iF = AbstractC21455b.F(7.0f);
            int size = this.f.size();
            for (int i2 = 0; i2 < size; i2++) {
                int iA = ((h) this.f.get(i2)).a(false, this.b);
                this.J0.put(i2, iA);
                this.K0.put(i2, (this.x / 2) + iF);
                iF += iA + AbstractC21455b.F(this.n * 2) + this.x;
            }
        }

        public void C(int i2, String str) {
            int size = this.f.size();
            if (size == 0 && this.v == -1) {
                this.v = i2;
            }
            this.H0.put(size, i2);
            this.I0.put(i2, size);
            int i3 = this.v;
            if (i3 != -1 && i3 == i2) {
                this.u = size;
            }
            h hVar = new h(i2, str);
            this.w += hVar.a(true, this.b) + AbstractC21455b.F(this.n * 2);
            this.f.add(hVar);
        }

        public void D() {
            this.s.notifyDataSetChanged();
        }

        public boolean E() {
            return this.y;
        }

        public void G() {
            this.f.clear();
            this.H0.clear();
            this.I0.clear();
            this.J0.clear();
            this.K0.clear();
            this.w = 0;
        }

        public void I(int i2, int i3) {
            int i4 = this.u;
            boolean z = i4 < i3;
            this.D = -1;
            this.N0 = i4;
            this.O0 = this.v;
            this.u = i3;
            this.v = i2;
            ValueAnimator valueAnimator = this.R0;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            if (this.y) {
                this.y = false;
            }
            this.M0 = 0.0f;
            this.z = 0.0f;
            this.y = true;
            setEnabled(false);
            i iVar = this.t;
            if (iVar != null) {
                iVar.b(i3, z);
            }
            H(i3);
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.R0 = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new e());
            this.R0.setDuration(250L);
            this.R0.setInterpolator(InterpolatorC12631ew1.f);
            this.R0.addListener(new f());
            this.R0.start();
        }

        public void J(int i2, int i3, float f2) {
            if (f2 < 0.0f) {
                f2 = 0.0f;
            } else if (f2 > 1.0f) {
                f2 = 1.0f;
            }
            this.u = i2;
            this.v = this.H0.get(i2);
            if (f2 > 0.0f) {
                this.A = i3;
                this.B = this.H0.get(i3);
            } else {
                this.A = -1;
                this.B = -1;
            }
            this.z = f2;
            this.q.O1();
            invalidate();
            H(i2);
            if (f2 >= 1.0f) {
                this.A = -1;
                this.B = -1;
                this.u = i3;
                this.v = this.H0.get(i3);
            }
            i iVar = this.t;
            if (iVar != null) {
                iVar.c();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0029  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0086  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x00fb  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0142  */
        @Override // android.view.ViewGroup
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected boolean drawChild(android.graphics.Canvas r10, android.view.View r11, long r12) {
            /*
                Method dump skipped, instructions count: 339
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.Components.ViewPagerFixed.TabsView.drawChild(android.graphics.Canvas, android.view.View, long):boolean");
        }

        public float getAnimatingIndicatorProgress() {
            return this.z;
        }

        public int getCurrentPosition() {
            return this.u;
        }

        public int getCurrentTabId() {
            return this.v;
        }

        public int getFirstTabId() {
            return this.H0.get(0, 0);
        }

        public int getPreviousPosition() {
            return this.N0;
        }

        public Drawable getSelectorDrawable() {
            return this.G;
        }

        public RecyclerListView getTabsContainer() {
            return this.q;
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
            super.onLayout(z, i2, i3, i4, i5);
            int i6 = i4 - i2;
            if (this.C0 != i6) {
                this.C0 = i6;
                this.D = -1;
                if (this.y) {
                    AbstractC21455b.t(this.P0);
                    this.y = false;
                    setEnabled(true);
                    i iVar = this.t;
                    if (iVar != null) {
                        iVar.a(1.0f);
                    }
                }
            }
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i2, int i3) {
            if (!this.f.isEmpty()) {
                int size = (View.MeasureSpec.getSize(i2) - AbstractC21455b.F(7.0f)) - AbstractC21455b.F(7.0f);
                int i4 = this.x;
                if (this.f.size() == 1) {
                    this.x = 0;
                } else {
                    int i5 = this.w;
                    this.x = i5 < size ? (size - i5) / this.f.size() : 0;
                }
                if (i4 != this.x) {
                    this.p = true;
                    this.s.notifyDataSetChanged();
                    this.p = false;
                }
                K();
                this.D0 = false;
            }
            super.onMeasure(i2, i3);
        }

        @Override // android.view.View, android.view.ViewParent
        public void requestLayout() {
            if (this.p) {
                return;
            }
            super.requestLayout();
        }

        public void setAnimationIdicatorProgress(float f2) {
            this.z = f2;
            this.q.O1();
            invalidate();
            i iVar = this.t;
            if (iVar != null) {
                iVar.a(f2);
            }
        }

        public void setDelegate(i iVar) {
            this.t = iVar;
        }

        public void setIsEditing(boolean z) {
            this.j = z;
            this.k = true;
            this.q.O1();
            invalidate();
            if (this.j || !this.o) {
                return;
            }
            ir.nasim.tgwidgets.editor.messenger.D.F(C22477vI7.f).e0();
            C25039zd7 c25039zd7 = new C25039zd7();
            ArrayList arrayList = ir.nasim.tgwidgets.editor.messenger.C.n(C22477vI7.f).e;
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                c25039zd7.b.add(Integer.valueOf(((C.a) arrayList.get(i2)).a));
            }
            ConnectionsManager.k(C22477vI7.f).m(c25039zd7, new C19545qX7());
            this.o = false;
        }

        public TabsView(Context context, boolean z, int i2, m.h hVar) {
            super(context);
            this.a = 1.0f;
            this.b = new TextPaint(1);
            this.c = new TextPaint(1);
            this.d = new TextPaint(1);
            this.e = new Paint(1);
            this.f = new ArrayList();
            this.h = new Paint();
            this.n = 16;
            this.v = -1;
            this.A = -1;
            this.B = -1;
            this.D = -1;
            this.H = ir.nasim.tgwidgets.editor.ui.ActionBar.m.vf;
            this.J = ir.nasim.tgwidgets.editor.ui.ActionBar.m.uf;
            this.z0 = ir.nasim.tgwidgets.editor.ui.ActionBar.m.tf;
            this.A0 = ir.nasim.tgwidgets.editor.ui.ActionBar.m.wf;
            this.B0 = ir.nasim.tgwidgets.editor.ui.ActionBar.m.Z6;
            this.G0 = InterpolatorC12631ew1.h;
            this.H0 = new SparseIntArray(5);
            this.I0 = new SparseIntArray(5);
            this.J0 = new SparseIntArray(5);
            this.K0 = new SparseIntArray(5);
            this.P0 = new a();
            this.Q0 = hVar;
            this.c.setTextSize(AbstractC21455b.F(13.0f));
            this.c.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
            this.b.setTextSize(AbstractC21455b.F(15.0f));
            this.b.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
            this.d.setStyle(Paint.Style.STROKE);
            this.d.setStrokeCap(Paint.Cap.ROUND);
            this.d.setStrokeWidth(AbstractC21455b.F(1.5f));
            this.G = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, null);
            float fH = AbstractC21455b.H(3.0f);
            this.G.setCornerRadii(new float[]{fH, fH, fH, fH, 0.0f, 0.0f, 0.0f, 0.0f});
            this.G.setColor(ir.nasim.tgwidgets.editor.ui.ActionBar.m.j0(this.H, hVar));
            setHorizontalScrollBarEnabled(false);
            b bVar = new b(context);
            this.q = bVar;
            if (z) {
                bVar.setItemAnimator(null);
            }
            this.q.setSelectorType(i2);
            if (i2 == 3) {
                this.q.setSelectorRadius(0);
            } else {
                this.q.setSelectorRadius(6);
            }
            this.q.setSelectorDrawableColor(ir.nasim.tgwidgets.editor.ui.ActionBar.m.j0(this.A0, hVar));
            RecyclerListView recyclerListView = this.q;
            c cVar = new c(context, 0, false);
            this.r = cVar;
            recyclerListView.setLayoutManager(cVar);
            this.q.setPadding(AbstractC21455b.F(7.0f), 0, AbstractC21455b.F(7.0f), 0);
            this.q.setClipToPadding(false);
            this.q.setDrawSelectorBehind(true);
            g gVar = new g(context);
            this.s = gVar;
            gVar.setHasStableIds(z);
            this.q.setAdapter(this.s);
            this.q.setOnItemClickListener(new RecyclerListView.j() { // from class: ir.nasim.rX7
                @Override // ir.nasim.tgwidgets.editor.ui.Components.RecyclerListView.j
                public final void a(View view, int i3, float f2, float f3) {
                    this.a.F(view, i3, f2, f3);
                }
            });
            this.q.setOnScrollListener(new d());
            addView(this.q, AbstractC13840gu3.b(-1, -1.0f));
        }
    }

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (ViewPagerFixed.this.l) {
                float fAbs = Math.abs(ViewPagerFixed.this.d[0].getTranslationX()) / ViewPagerFixed.this.d[0].getMeasuredWidth();
                ViewPagerFixed viewPagerFixed = ViewPagerFixed.this;
                TabsView tabsView = viewPagerFixed.u;
                if (tabsView != null) {
                    tabsView.J(viewPagerFixed.c, viewPagerFixed.b, 1.0f - fAbs);
                }
            }
            ViewPagerFixed.this.A();
        }
    }

    class b extends TabsView {
        b(Context context, boolean z, int i, m.h hVar) {
            super(context, z, i, hVar);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.ViewPagerFixed.TabsView
        public void J(int i, int i2, float f) {
            super.J(i, i2, f);
            ViewPagerFixed viewPagerFixed = ViewPagerFixed.this;
            if (f > 0.5f) {
                i = i2;
            }
            viewPagerFixed.B(i);
        }
    }

    class c implements TabsView.i {
        c() {
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.ViewPagerFixed.TabsView.i
        public void a(float f) {
            if (f == 1.0f) {
                ViewPagerFixed viewPagerFixed = ViewPagerFixed.this;
                if (viewPagerFixed.d[1] != null) {
                    viewPagerFixed.D();
                    ViewPagerFixed viewPagerFixed2 = ViewPagerFixed.this;
                    viewPagerFixed2.f.put(viewPagerFixed2.e[1], ViewPagerFixed.this.d[1]);
                    ViewPagerFixed viewPagerFixed3 = ViewPagerFixed.this;
                    viewPagerFixed3.removeView(viewPagerFixed3.d[1]);
                    ViewPagerFixed.this.d[0].setTranslationX(0.0f);
                    ViewPagerFixed.this.d[1] = null;
                    return;
                }
                return;
            }
            ViewPagerFixed viewPagerFixed4 = ViewPagerFixed.this;
            if (viewPagerFixed4.d[1] == null) {
                return;
            }
            if (viewPagerFixed4.m) {
                ViewPagerFixed.this.d[1].setTranslationX(r1[0].getMeasuredWidth() * (1.0f - f));
                ViewPagerFixed.this.d[0].setTranslationX((-r0.getMeasuredWidth()) * f);
                return;
            }
            ViewPagerFixed.this.d[1].setTranslationX((-r1[0].getMeasuredWidth()) * (1.0f - f));
            ViewPagerFixed.this.d[0].setTranslationX(r0.getMeasuredWidth() * f);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.ViewPagerFixed.TabsView.i
        public void b(int i, boolean z) {
            ViewPagerFixed.this.m = z;
            ViewPagerFixed viewPagerFixed = ViewPagerFixed.this;
            viewPagerFixed.c = i;
            viewPagerFixed.F(1);
            ViewPagerFixed.this.B(i);
            View view = ViewPagerFixed.this.d[0];
            int measuredWidth = view != null ? view.getMeasuredWidth() : 0;
            if (z) {
                ViewPagerFixed.this.d[1].setTranslationX(measuredWidth);
            } else {
                ViewPagerFixed.this.d[1].setTranslationX(-measuredWidth);
            }
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.ViewPagerFixed.TabsView.i
        public void c() {
            ViewPagerFixed.this.t();
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.ViewPagerFixed.TabsView.i
        public void d() {
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.ViewPagerFixed.TabsView.i
        public boolean e() {
            return (ViewPagerFixed.this.l || ViewPagerFixed.this.q) ? false : true;
        }
    }

    class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ViewPagerFixed.this.k = null;
            ViewPagerFixed viewPagerFixed = ViewPagerFixed.this;
            if (viewPagerFixed.c < 0) {
                viewPagerFixed.w();
            }
            ViewPagerFixed viewPagerFixed2 = ViewPagerFixed.this;
            if (viewPagerFixed2.d[1] != null) {
                if (!viewPagerFixed2.o) {
                    ViewPagerFixed.this.D();
                }
                ViewPagerFixed viewPagerFixed3 = ViewPagerFixed.this;
                viewPagerFixed3.f.put(viewPagerFixed3.e[1], ViewPagerFixed.this.d[1]);
                ViewPagerFixed viewPagerFixed4 = ViewPagerFixed.this;
                viewPagerFixed4.removeView(viewPagerFixed4.d[1]);
                ViewPagerFixed.this.d[1].setVisibility(8);
                ViewPagerFixed.this.d[1] = null;
            }
            ViewPagerFixed.this.l = false;
            ViewPagerFixed.this.r = false;
            TabsView tabsView = ViewPagerFixed.this.u;
            if (tabsView != null) {
                tabsView.setEnabled(true);
            }
            ViewPagerFixed.this.A();
            ViewPagerFixed.this.z();
        }
    }

    public static abstract class e {
        public abstract void a(View view, int i, int i2);

        public abstract View b(int i);

        public abstract int c();

        public int d(int i) {
            return i;
        }

        public abstract String e(int i);

        public abstract int f(int i);
    }

    public ViewPagerFixed(Context context) {
        this(context, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean C(android.view.MotionEvent r5, boolean r6) {
        /*
            r4 = this;
            r0 = 0
            if (r6 != 0) goto L10
            int r1 = r4.b
            if (r1 != 0) goto L10
            r1 = 0
            r4.z = r1
            boolean r1 = r4.x(r1)
            if (r1 == 0) goto L22
        L10:
            r1 = 1
            if (r6 == 0) goto L1e
            int r2 = r4.b
            ir.nasim.tgwidgets.editor.ui.Components.ViewPagerFixed$e r3 = r4.t
            int r3 = r3.c()
            int r3 = r3 - r1
            if (r2 == r3) goto L22
        L1e:
            android.animation.ValueAnimator r2 = r4.y
            if (r2 == 0) goto L23
        L22:
            return r0
        L23:
            boolean r2 = r4.n(r5)
            if (r2 != 0) goto L2a
            return r0
        L2a:
            android.view.ViewParent r2 = r4.getParent()
            r2.requestDisallowInterceptTouchEvent(r1)
            r4.r = r0
            r4.q = r1
            float r5 = r5.getX()
            float r2 = r4.n
            float r5 = r5 + r2
            int r5 = (int) r5
            r4.h = r5
            ir.nasim.tgwidgets.editor.ui.Components.ViewPagerFixed$TabsView r5 = r4.u
            if (r5 == 0) goto L46
            r5.setEnabled(r0)
        L46:
            r4.m = r6
            int r5 = r4.b
            if (r6 == 0) goto L4e
            r2 = r1
            goto L4f
        L4e:
            r2 = -1
        L4f:
            int r5 = r5 + r2
            r4.c = r5
            r4.F(r1)
            android.view.View[] r5 = r4.d
            r2 = r5[r1]
            if (r2 == 0) goto L73
            if (r6 == 0) goto L68
            r5 = r5[r0]
            int r5 = r5.getMeasuredWidth()
            float r5 = (float) r5
            r2.setTranslationX(r5)
            goto L73
        L68:
            r5 = r5[r0]
            int r5 = r5.getMeasuredWidth()
            int r5 = -r5
            float r5 = (float) r5
            r2.setTranslationX(r5)
        L73:
            r4.A()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.Components.ViewPagerFixed.C(android.view.MotionEvent, boolean):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        View[] viewArr = this.d;
        View view = viewArr[0];
        View view2 = viewArr[1];
        viewArr[0] = view2;
        viewArr[1] = view;
        int i = this.b;
        int i2 = this.c;
        this.b = i2;
        this.c = i;
        int[] iArr = this.e;
        int i3 = iArr[0];
        iArr[0] = iArr[1];
        iArr[1] = i3;
        y(view2, view, i2, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(int i) {
        int i2 = i == 0 ? this.b : this.c;
        if (i2 < 0 || i2 >= this.t.c()) {
            return;
        }
        if (this.d[i] == null) {
            this.e[i] = this.t.f(i2);
            View viewB = (View) this.f.get(this.e[i]);
            if (viewB == null) {
                viewB = this.t.b(this.e[i]);
            } else {
                this.f.remove(this.e[i]);
            }
            if (viewB.getParent() != null) {
                ((ViewGroup) viewB.getParent()).removeView(viewB);
            }
            addView(viewB);
            this.d[i] = viewB;
            this.t.a(viewB, i2, this.e[i]);
            this.d[i].setVisibility(0);
            return;
        }
        if (this.e[i] == this.t.f(i2)) {
            this.t.a(this.d[i], i2, this.e[i]);
            this.d[i].setVisibility(0);
            return;
        }
        this.f.put(this.e[i], this.d[i]);
        this.d[i].setVisibility(8);
        removeView(this.d[i]);
        this.e[i] = this.t.f(i2);
        View viewB2 = (View) this.f.get(this.e[i]);
        if (viewB2 == null) {
            viewB2 = this.t.b(this.e[i]);
        } else {
            this.f.remove(this.e[i]);
        }
        addView(viewB2);
        this.d[i] = viewB2;
        viewB2.setVisibility(0);
        e eVar = this.t;
        eVar.a(this.d[i], i2, eVar.f(i2));
    }

    public static float q(float f) {
        return (float) Math.sin((f - 0.5f) * 0.47123894f);
    }

    private View s(ViewGroup viewGroup, float f, float f2) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt.getVisibility() == 0) {
                childAt.getHitRect(this.w);
                if (!this.w.contains((int) f, (int) f2)) {
                    continue;
                } else {
                    if (childAt.canScrollHorizontally(-1)) {
                        return childAt;
                    }
                    if (childAt instanceof ViewGroup) {
                        Rect rect = this.w;
                        View viewS = s((ViewGroup) childAt, f - rect.left, f2 - rect.top);
                        if (viewS != null) {
                            return viewS;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.z = fFloatValue;
        x(fFloatValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ float v(float f) {
        float f2 = f - 1.0f;
        return (f2 * f2 * f2 * f2 * f2) + 1.0f;
    }

    protected void A() {
    }

    protected void B(int i) {
    }

    protected int E() {
        return 16;
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        if (i == 0) {
            return false;
        }
        if (!this.l && !this.q) {
            boolean z = i > 0;
            if ((!z && this.b == 0) || (z && this.b == this.t.c() - 1)) {
                return false;
            }
        }
        return true;
    }

    public int getCurrentPosition() {
        return this.b;
    }

    public View getCurrentView() {
        return this.d[0];
    }

    public float getPositionAnimated() {
        float fC;
        View view = this.d[0];
        if (view == null || view.getVisibility() != 0) {
            fC = 0.0f;
        } else {
            fC = (this.b * Utilities.c(1.0f - Math.abs(this.d[0].getTranslationX() / AbstractC21455b.h.x), 1.0f, 0.0f)) + 0.0f;
        }
        View view2 = this.d[1];
        if (view2 == null || view2.getVisibility() != 0) {
            return fC;
        }
        return fC + (this.c * Utilities.c(1.0f - Math.abs(this.d[1].getTranslationX() / AbstractC21455b.h.x), 1.0f, 0.0f));
    }

    public View[] getViewPages() {
        return this.d;
    }

    protected boolean n(MotionEvent motionEvent) {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean o() {
        /*
            r7 = this;
            boolean r0 = r7.l
            r1 = 0
            if (r0 == 0) goto L77
            boolean r0 = r7.o
            r2 = -1
            r3 = 0
            r4 = 1065353216(0x3f800000, float:1.0)
            r5 = 1
            if (r0 == 0) goto L3c
            android.view.View[] r0 = r7.d
            r0 = r0[r1]
            float r0 = r0.getTranslationX()
            float r0 = java.lang.Math.abs(r0)
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 >= 0) goto L74
            android.view.View[] r0 = r7.d
            r0 = r0[r1]
            r0.setTranslationX(r3)
            android.view.View[] r0 = r7.d
            r3 = r0[r5]
            if (r3 == 0) goto L68
            r0 = r0[r1]
            int r0 = r0.getMeasuredWidth()
            boolean r4 = r7.m
            if (r4 == 0) goto L36
            r2 = r5
        L36:
            int r0 = r0 * r2
            float r0 = (float) r0
            r3.setTranslationX(r0)
            goto L68
        L3c:
            android.view.View[] r0 = r7.d
            r0 = r0[r5]
            float r0 = r0.getTranslationX()
            float r0 = java.lang.Math.abs(r0)
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 >= 0) goto L74
            android.view.View[] r0 = r7.d
            r0 = r0[r1]
            int r4 = r0.getMeasuredWidth()
            boolean r6 = r7.m
            if (r6 == 0) goto L59
            goto L5a
        L59:
            r2 = r5
        L5a:
            int r4 = r4 * r2
            float r2 = (float) r4
            r0.setTranslationX(r2)
            android.view.View[] r0 = r7.d
            r0 = r0[r5]
            if (r0 == 0) goto L68
            r0.setTranslationX(r3)
        L68:
            android.animation.AnimatorSet r0 = r7.k
            if (r0 == 0) goto L72
            r0.cancel()
            r0 = 0
            r7.k = r0
        L72:
            r7.l = r1
        L74:
            boolean r0 = r7.l
            return r0
        L77:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.Components.ViewPagerFixed.o():boolean");
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        TabsView tabsView = this.u;
        if (tabsView != null && tabsView.E()) {
            return false;
        }
        if (o()) {
            return true;
        }
        onTouchEvent(motionEvent);
        return this.q;
    }

    /* JADX WARN: Code restructure failed: missing block: B:148:0x0293, code lost:
    
        r6 = true;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r12) {
        /*
            Method dump skipped, instructions count: 1238
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.Components.ViewPagerFixed.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public TabsView p(boolean z, int i) {
        b bVar = new b(getContext(), z, i, this.a);
        this.u = bVar;
        bVar.n = E();
        this.u.setDelegate(new c());
        r(false);
        return this.u;
    }

    protected void r(boolean z) {
        TabsView tabsView;
        if (this.t == null || (tabsView = this.u) == null) {
            return;
        }
        tabsView.G();
        for (int i = 0; i < this.t.c(); i++) {
            this.u.C(this.t.d(i), this.t.e(i));
        }
        if (z) {
            TransitionManager.beginDelayedTransition(this.u.q, AbstractC3671Bv7.a());
        }
        this.u.D();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (this.x && this.r && !this.q) {
            onTouchEvent(null);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public void setAdapter(e eVar) {
        this.t = eVar;
        this.e[0] = eVar.f(this.b);
        this.d[0] = eVar.b(this.e[0]);
        eVar.a(this.d[0], this.b, this.e[0]);
        addView(this.d[0]);
        this.d[0].setVisibility(0);
        r(false);
    }

    public void setAllowDisallowInterceptTouch(boolean z) {
        this.x = z;
    }

    public void setPosition(int i) {
        AnimatorSet animatorSet = this.k;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        View view = this.d[1];
        if (view != null) {
            this.f.put(this.e[1], view);
            removeView(this.d[1]);
            this.d[1] = null;
        }
        int i2 = this.b;
        if (i2 != i) {
            this.b = i;
            View view2 = this.d[0];
            F(0);
            y(this.d[0], view2, this.b, i2);
            this.d[0].setTranslationX(0.0f);
            TabsView tabsView = this.u;
            if (tabsView != null) {
                tabsView.J(i, 0, 1.0f);
            }
        }
    }

    protected void t() {
    }

    protected void w() {
    }

    protected boolean x(float f) {
        return false;
    }

    protected void y(View view, View view2, int i, int i2) {
    }

    protected void z() {
    }

    public ViewPagerFixed(Context context, m.h hVar) {
        super(context);
        this.f = new SparseArray();
        this.v = new a();
        this.w = new Rect();
        this.x = true;
        this.a = hVar;
        this.s = AbstractC21455b.h0(0.3f, true);
        this.p = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
        this.e = new int[2];
        this.d = new View[2];
        setClipChildren(true);
    }
}
