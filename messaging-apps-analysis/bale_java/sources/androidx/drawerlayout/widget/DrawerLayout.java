package androidx.drawerlayout.widget;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import androidx.customview.view.AbsSavedState;
import ir.nasim.AbstractC10783cB5;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.AbstractC19336qA5;
import ir.nasim.AbstractC21710u02;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.C22013uW7;
import ir.nasim.C22317v2;
import ir.nasim.InterfaceC10698c3;
import ir.nasim.L93;
import ir.nasim.O98;
import ir.nasim.VE5;
import ir.nasim.X2;
import ir.nasim.YK2;
import java.util.ArrayList;
import java.util.List;
import org.xbill.DNS.SimpleResolver;

/* loaded from: classes2.dex */
public class DrawerLayout extends ViewGroup {
    private static final int[] D0 = {R.attr.colorPrimaryDark};
    static final int[] E0 = {R.attr.layout_gravity};
    static final boolean F0;
    private static final boolean G0;
    private static boolean H0;
    private Object A;
    private Rect A0;
    private boolean B;
    private Matrix B0;
    private final InterfaceC10698c3 C0;
    private Drawable D;
    private Drawable G;
    private Drawable H;
    private Drawable J;
    private final d a;
    private float b;
    private int c;
    private int d;
    private float e;
    private Paint f;
    private final C22013uW7 g;
    private final C22013uW7 h;
    private final f i;
    private final f j;
    private int k;
    private boolean l;
    private boolean m;
    private int n;
    private int o;
    private int p;
    private int q;
    private boolean r;
    private List s;
    private float t;
    private float u;
    private Drawable v;
    private Drawable w;
    private Drawable x;
    private CharSequence y;
    private CharSequence z;
    private final ArrayList z0;

    class a implements InterfaceC10698c3 {
        a() {
        }

        @Override // ir.nasim.InterfaceC10698c3
        public boolean a(View view, InterfaceC10698c3.a aVar) {
            if (!DrawerLayout.this.A(view) || DrawerLayout.this.p(view) == 2) {
                return false;
            }
            DrawerLayout.this.d(view);
            return true;
        }
    }

    class b implements View.OnApplyWindowInsetsListener {
        b() {
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            ((DrawerLayout) view).setChildInsets(windowInsets, windowInsets.getSystemWindowInsetTop() > 0);
            return windowInsets.consumeSystemWindowInsets();
        }
    }

    class c extends C22317v2 {
        private final Rect d = new Rect();

        c() {
        }

        private void n(X2 x2, ViewGroup viewGroup) {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (DrawerLayout.y(childAt)) {
                    x2.c(childAt);
                }
            }
        }

        private void o(X2 x2, X2 x22) {
            Rect rect = this.d;
            x22.n(rect);
            x2.l0(rect);
            x2.e1(x22.Z());
            x2.J0(x22.z());
            x2.p0(x22.q());
            x2.t0(x22.t());
            x2.x0(x22.O());
            x2.A0(x22.Q());
            x2.h0(x22.J());
            x2.S0(x22.W());
            x2.a(x22.k());
        }

        @Override // ir.nasim.C22317v2
        public boolean a(View view, AccessibilityEvent accessibilityEvent) {
            if (accessibilityEvent.getEventType() != 32) {
                return super.a(view, accessibilityEvent);
            }
            List<CharSequence> text = accessibilityEvent.getText();
            View viewN = DrawerLayout.this.n();
            if (viewN == null) {
                return true;
            }
            CharSequence charSequenceQ = DrawerLayout.this.q(DrawerLayout.this.r(viewN));
            if (charSequenceQ == null) {
                return true;
            }
            text.add(charSequenceQ);
            return true;
        }

        @Override // ir.nasim.C22317v2
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            super.f(view, accessibilityEvent);
            accessibilityEvent.setClassName("androidx.drawerlayout.widget.DrawerLayout");
        }

        @Override // ir.nasim.C22317v2
        public void g(View view, X2 x2) {
            if (DrawerLayout.F0) {
                super.g(view, x2);
            } else {
                X2 x2C0 = X2.c0(x2);
                super.g(view, x2C0);
                x2.U0(view);
                Object objG = AbstractC12990fW7.G(view);
                if (objG instanceof View) {
                    x2.L0((View) objG);
                }
                o(x2, x2C0);
                x2C0.e0();
                n(x2, (ViewGroup) view);
            }
            x2.p0("androidx.drawerlayout.widget.DrawerLayout");
            x2.z0(false);
            x2.A0(false);
            x2.f0(X2.a.e);
            x2.f0(X2.a.f);
        }

        @Override // ir.nasim.C22317v2
        public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (DrawerLayout.F0 || DrawerLayout.y(view)) {
                return super.i(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    static final class d extends C22317v2 {
        d() {
        }

        @Override // ir.nasim.C22317v2
        public void g(View view, X2 x2) {
            super.g(view, x2);
            if (DrawerLayout.y(view)) {
                return;
            }
            x2.L0(null);
        }
    }

    public interface e {
    }

    private class f extends C22013uW7.c {
        private final int a;
        private C22013uW7 b;
        private final Runnable c = new a();

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                f.this.o();
            }
        }

        f(int i) {
            this.a = i;
        }

        private void n() {
            View viewL = DrawerLayout.this.l(this.a == 3 ? 5 : 3);
            if (viewL != null) {
                DrawerLayout.this.d(viewL);
            }
        }

        @Override // ir.nasim.C22013uW7.c
        public int a(View view, int i, int i2) {
            if (DrawerLayout.this.c(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i, 0));
            }
            int width = DrawerLayout.this.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i, width));
        }

        @Override // ir.nasim.C22013uW7.c
        public int b(View view, int i, int i2) {
            return view.getTop();
        }

        @Override // ir.nasim.C22013uW7.c
        public int d(View view) {
            if (DrawerLayout.this.B(view)) {
                return view.getWidth();
            }
            return 0;
        }

        @Override // ir.nasim.C22013uW7.c
        public void f(int i, int i2) {
            View viewL = (i & 1) == 1 ? DrawerLayout.this.l(3) : DrawerLayout.this.l(5);
            if (viewL == null || DrawerLayout.this.p(viewL) != 0) {
                return;
            }
            this.b.c(viewL, i2);
        }

        @Override // ir.nasim.C22013uW7.c
        public boolean g(int i) {
            return false;
        }

        @Override // ir.nasim.C22013uW7.c
        public void h(int i, int i2) {
            DrawerLayout.this.postDelayed(this.c, 160L);
        }

        @Override // ir.nasim.C22013uW7.c
        public void i(View view, int i) {
            ((LayoutParams) view.getLayoutParams()).c = false;
            n();
        }

        @Override // ir.nasim.C22013uW7.c
        public void j(int i) {
            DrawerLayout.this.O(i, this.b.w());
        }

        @Override // ir.nasim.C22013uW7.c
        public void k(View view, int i, int i2, int i3, int i4) {
            float width = (DrawerLayout.this.c(view, 3) ? i + r3 : DrawerLayout.this.getWidth() - i) / view.getWidth();
            DrawerLayout.this.L(view, width);
            view.setVisibility(width == 0.0f ? 4 : 0);
            DrawerLayout.this.invalidate();
        }

        @Override // ir.nasim.C22013uW7.c
        public void l(View view, float f, float f2) {
            int i;
            float fS = DrawerLayout.this.s(view);
            int width = view.getWidth();
            if (DrawerLayout.this.c(view, 3)) {
                i = (f > 0.0f || (f == 0.0f && fS > 0.5f)) ? 0 : -width;
            } else {
                int width2 = DrawerLayout.this.getWidth();
                if (f < 0.0f || (f == 0.0f && fS > 0.5f)) {
                    width2 -= width;
                }
                i = width2;
            }
            this.b.P(i, view.getTop());
            DrawerLayout.this.invalidate();
        }

        @Override // ir.nasim.C22013uW7.c
        public boolean m(View view, int i) {
            return DrawerLayout.this.B(view) && DrawerLayout.this.c(view, this.a) && DrawerLayout.this.p(view) == 0;
        }

        void o() {
            View viewL;
            int width;
            int iY = this.b.y();
            boolean z = this.a == 3;
            if (z) {
                viewL = DrawerLayout.this.l(3);
                width = (viewL != null ? -viewL.getWidth() : 0) + iY;
            } else {
                viewL = DrawerLayout.this.l(5);
                width = DrawerLayout.this.getWidth() - iY;
            }
            if (viewL != null) {
                if (((!z || viewL.getLeft() >= width) && (z || viewL.getLeft() <= width)) || DrawerLayout.this.p(viewL) != 0) {
                    return;
                }
                LayoutParams layoutParams = (LayoutParams) viewL.getLayoutParams();
                this.b.R(viewL, width, viewL.getTop());
                layoutParams.c = true;
                DrawerLayout.this.invalidate();
                n();
                DrawerLayout.this.b();
            }
        }

        public void p() {
            DrawerLayout.this.removeCallbacks(this.c);
        }

        public void q(C22013uW7 c22013uW7) {
            this.b = c22013uW7;
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        F0 = true;
        G0 = true;
        H0 = i >= 29;
    }

    public DrawerLayout(Context context) {
        this(context, null);
    }

    private boolean D(float f2, float f3, View view) {
        if (this.A0 == null) {
            this.A0 = new Rect();
        }
        view.getHitRect(this.A0);
        return this.A0.contains((int) f2, (int) f3);
    }

    private void E(Drawable drawable, int i) {
        if (drawable == null || !AbstractC21710u02.c(drawable)) {
            return;
        }
        AbstractC21710u02.g(drawable, i);
    }

    private Drawable I() {
        int iA = AbstractC12990fW7.A(this);
        if (iA == 0) {
            Drawable drawable = this.D;
            if (drawable != null) {
                E(drawable, iA);
                return this.D;
            }
        } else {
            Drawable drawable2 = this.G;
            if (drawable2 != null) {
                E(drawable2, iA);
                return this.G;
            }
        }
        return this.H;
    }

    private Drawable J() {
        int iA = AbstractC12990fW7.A(this);
        if (iA == 0) {
            Drawable drawable = this.G;
            if (drawable != null) {
                E(drawable, iA);
                return this.G;
            }
        } else {
            Drawable drawable2 = this.D;
            if (drawable2 != null) {
                E(drawable2, iA);
                return this.D;
            }
        }
        return this.J;
    }

    private void K() {
        if (G0) {
            return;
        }
        this.w = I();
        this.x = J();
    }

    private void M(View view) {
        X2.a aVar = X2.a.y;
        AbstractC12990fW7.j0(view, aVar.b());
        if (!A(view) || p(view) == 2) {
            return;
        }
        AbstractC12990fW7.l0(view, aVar, null, this.C0);
    }

    private void N(View view, boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((z || B(childAt)) && !(z && childAt == view)) {
                AbstractC12990fW7.A0(childAt, 4);
            } else {
                AbstractC12990fW7.A0(childAt, 1);
            }
        }
    }

    private boolean k(MotionEvent motionEvent, View view) {
        if (!view.getMatrix().isIdentity()) {
            MotionEvent motionEventT = t(motionEvent, view);
            boolean zDispatchGenericMotionEvent = view.dispatchGenericMotionEvent(motionEventT);
            motionEventT.recycle();
            return zDispatchGenericMotionEvent;
        }
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        motionEvent.offsetLocation(scrollX, scrollY);
        boolean zDispatchGenericMotionEvent2 = view.dispatchGenericMotionEvent(motionEvent);
        motionEvent.offsetLocation(-scrollX, -scrollY);
        return zDispatchGenericMotionEvent2;
    }

    private MotionEvent t(MotionEvent motionEvent, View view) {
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.offsetLocation(scrollX, scrollY);
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            if (this.B0 == null) {
                this.B0 = new Matrix();
            }
            matrix.invert(this.B0);
            motionEventObtain.transform(this.B0);
        }
        return motionEventObtain;
    }

    static String u(int i) {
        return (i & 3) == 3 ? "LEFT" : (i & 5) == 5 ? "RIGHT" : Integer.toHexString(i);
    }

    private static boolean v(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    private boolean w() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((LayoutParams) getChildAt(i).getLayoutParams()).c) {
                return true;
            }
        }
        return false;
    }

    private boolean x() {
        return n() != null;
    }

    static boolean y(View view) {
        return (AbstractC12990fW7.y(view) == 4 || AbstractC12990fW7.y(view) == 2) ? false : true;
    }

    public boolean A(View view) {
        if (B(view)) {
            return (((LayoutParams) view.getLayoutParams()).d & 1) == 1;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    boolean B(View view) {
        int iB = YK2.b(((LayoutParams) view.getLayoutParams()).a, AbstractC12990fW7.A(view));
        return ((iB & 3) == 0 && (iB & 5) == 0) ? false : true;
    }

    public boolean C(View view) {
        if (B(view)) {
            return ((LayoutParams) view.getLayoutParams()).b > 0.0f;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    void F(View view, float f2) {
        float fS = s(view);
        float width = view.getWidth();
        int i = ((int) (width * f2)) - ((int) (fS * width));
        if (!c(view, 3)) {
            i = -i;
        }
        view.offsetLeftAndRight(i);
        L(view, f2);
    }

    public void G(View view) {
        H(view, true);
    }

    public void H(View view, boolean z) {
        if (!B(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (this.m) {
            layoutParams.b = 1.0f;
            layoutParams.d = 1;
            N(view, true);
            M(view);
        } else if (z) {
            layoutParams.d |= 2;
            if (c(view, 3)) {
                this.g.R(view, 0, view.getTop());
            } else {
                this.h.R(view, getWidth() - view.getWidth(), view.getTop());
            }
        } else {
            F(view, 1.0f);
            O(0, view);
            view.setVisibility(0);
        }
        invalidate();
    }

    void L(View view, float f2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f2 == layoutParams.b) {
            return;
        }
        layoutParams.b = f2;
        j(view, f2);
    }

    void O(int i, View view) {
        int i2;
        int size;
        int iB = this.g.B();
        int iB2 = this.h.B();
        if (iB == 1 || iB2 == 1) {
            i2 = 1;
        } else {
            i2 = 2;
            if (iB != 2 && iB2 != 2) {
                i2 = 0;
            }
        }
        if (view != null && i == 0) {
            float f2 = ((LayoutParams) view.getLayoutParams()).b;
            if (f2 == 0.0f) {
                h(view);
            } else if (f2 == 1.0f) {
                i(view);
            }
        }
        if (i2 != this.k) {
            this.k = i2;
            List list = this.s;
            if (list == null || (size = list.size() - 1) < 0) {
                return;
            }
            AbstractC18350oW3.a(this.s.get(size));
            throw null;
        }
    }

    public void a(e eVar) {
        if (eVar == null) {
            return;
        }
        if (this.s == null) {
            this.s = new ArrayList();
        }
        this.s.add(eVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList arrayList, int i, int i2) {
        if (getDescendantFocusability() == 393216) {
            return;
        }
        int childCount = getChildCount();
        boolean z = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (!B(childAt)) {
                this.z0.add(childAt);
            } else if (A(childAt)) {
                childAt.addFocusables(arrayList, i, i2);
                z = true;
            }
        }
        if (!z) {
            int size = this.z0.size();
            for (int i4 = 0; i4 < size; i4++) {
                View view = (View) this.z0.get(i4);
                if (view.getVisibility() == 0) {
                    view.addFocusables(arrayList, i, i2);
                }
            }
        }
        this.z0.clear();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (m() != null || B(view)) {
            AbstractC12990fW7.A0(view, 4);
        } else {
            AbstractC12990fW7.A0(view, 1);
        }
        if (F0) {
            return;
        }
        AbstractC12990fW7.p0(view, this.a);
    }

    void b() {
        if (this.r) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).dispatchTouchEvent(motionEventObtain);
        }
        motionEventObtain.recycle();
        this.r = true;
    }

    boolean c(View view, int i) {
        return (r(view) & i) == i;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        int childCount = getChildCount();
        float fMax = 0.0f;
        for (int i = 0; i < childCount; i++) {
            fMax = Math.max(fMax, ((LayoutParams) getChildAt(i).getLayoutParams()).b);
        }
        this.e = fMax;
        boolean zN = this.g.n(true);
        boolean zN2 = this.h.n(true);
        if (zN || zN2) {
            AbstractC12990fW7.g0(this);
        }
    }

    public void d(View view) {
        e(view, true);
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) == 0 || motionEvent.getAction() == 10 || this.e <= 0.0f) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        int childCount = getChildCount();
        if (childCount == 0) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        for (int i = childCount - 1; i >= 0; i--) {
            View childAt = getChildAt(i);
            if (D(x, y, childAt) && !z(childAt) && k(motionEvent, childAt)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        int height = getHeight();
        boolean z = z(view);
        int width = getWidth();
        int iSave = canvas.save();
        int i = 0;
        if (z) {
            int childCount = getChildCount();
            int i2 = 0;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != view && childAt.getVisibility() == 0 && v(childAt) && B(childAt) && childAt.getHeight() >= height) {
                    if (c(childAt, 3)) {
                        int right = childAt.getRight();
                        if (right > i2) {
                            i2 = right;
                        }
                    } else {
                        int left = childAt.getLeft();
                        if (left < width) {
                            width = left;
                        }
                    }
                }
            }
            canvas.clipRect(i2, 0, width, getHeight());
            i = i2;
        }
        boolean zDrawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(iSave);
        float f2 = this.e;
        if (f2 > 0.0f && z) {
            this.f.setColor((this.d & 16777215) | (((int) ((((-16777216) & r2) >>> 24) * f2)) << 24));
            canvas.drawRect(i, 0.0f, width, getHeight(), this.f);
        } else if (this.w != null && c(view, 3)) {
            int intrinsicWidth = this.w.getIntrinsicWidth();
            int right2 = view.getRight();
            float fMax = Math.max(0.0f, Math.min(right2 / this.g.y(), 1.0f));
            this.w.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
            this.w.setAlpha((int) (fMax * 255.0f));
            this.w.draw(canvas);
        } else if (this.x != null && c(view, 5)) {
            int intrinsicWidth2 = this.x.getIntrinsicWidth();
            int left2 = view.getLeft();
            float fMax2 = Math.max(0.0f, Math.min((getWidth() - left2) / this.h.y(), 1.0f));
            this.x.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
            this.x.setAlpha((int) (fMax2 * 255.0f));
            this.x.draw(canvas);
        }
        return zDrawChild;
    }

    public void e(View view, boolean z) {
        if (!B(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (this.m) {
            layoutParams.b = 0.0f;
            layoutParams.d = 0;
        } else if (z) {
            layoutParams.d |= 4;
            if (c(view, 3)) {
                this.g.R(view, -view.getWidth(), view.getTop());
            } else {
                this.h.R(view, getWidth(), view.getTop());
            }
        } else {
            F(view, 0.0f);
            O(0, view);
            view.setVisibility(4);
        }
        invalidate();
    }

    public void f() {
        g(false);
    }

    void g(boolean z) {
        int childCount = getChildCount();
        boolean zR = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (B(childAt) && (!z || layoutParams.c)) {
                zR |= c(childAt, 3) ? this.g.R(childAt, -childAt.getWidth(), childAt.getTop()) : this.h.R(childAt, getWidth(), childAt.getTop());
                layoutParams.c = false;
            }
        }
        this.i.p();
        this.j.p();
        if (zR) {
            invalidate();
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public float getDrawerElevation() {
        if (G0) {
            return this.b;
        }
        return 0.0f;
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.v;
    }

    void h(View view) {
        View rootView;
        int size;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if ((layoutParams.d & 1) == 1) {
            layoutParams.d = 0;
            List list = this.s;
            if (list != null && (size = list.size() - 1) >= 0) {
                AbstractC18350oW3.a(this.s.get(size));
                throw null;
            }
            N(view, false);
            M(view);
            if (!hasWindowFocus() || (rootView = getRootView()) == null) {
                return;
            }
            rootView.sendAccessibilityEvent(32);
        }
    }

    void i(View view) {
        int size;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if ((layoutParams.d & 1) == 0) {
            layoutParams.d = 1;
            List list = this.s;
            if (list != null && (size = list.size() - 1) >= 0) {
                AbstractC18350oW3.a(this.s.get(size));
                throw null;
            }
            N(view, true);
            M(view);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
        }
    }

    void j(View view, float f2) {
        int size;
        if (this.s == null || r1.size() - 1 < 0) {
            return;
        }
        AbstractC18350oW3.a(this.s.get(size));
        throw null;
    }

    View l(int i) {
        int iB = YK2.b(i, AbstractC12990fW7.A(this)) & 7;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((r(childAt) & 7) == iB) {
                return childAt;
            }
        }
        return null;
    }

    View m() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((((LayoutParams) childAt.getLayoutParams()).d & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    View n() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (B(childAt) && C(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    public int o(int i) {
        int iA = AbstractC12990fW7.A(this);
        if (i == 3) {
            int i2 = this.n;
            if (i2 != 3) {
                return i2;
            }
            int i3 = iA == 0 ? this.p : this.q;
            if (i3 != 3) {
                return i3;
            }
            return 0;
        }
        if (i == 5) {
            int i4 = this.o;
            if (i4 != 3) {
                return i4;
            }
            int i5 = iA == 0 ? this.q : this.p;
            if (i5 != 3) {
                return i5;
            }
            return 0;
        }
        if (i == 8388611) {
            int i6 = this.p;
            if (i6 != 3) {
                return i6;
            }
            int i7 = iA == 0 ? this.n : this.o;
            if (i7 != 3) {
                return i7;
            }
            return 0;
        }
        if (i != 8388613) {
            return 0;
        }
        int i8 = this.q;
        if (i8 != 3) {
            return i8;
        }
        int i9 = iA == 0 ? this.o : this.n;
        if (i9 != 3) {
            return i9;
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.m = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.m = true;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.B || this.v == null) {
            return;
        }
        Object obj = this.A;
        int systemWindowInsetTop = obj != null ? ((WindowInsets) obj).getSystemWindowInsetTop() : 0;
        if (systemWindowInsetTop > 0) {
            this.v.setBounds(0, 0, getWidth(), systemWindowInsetTop);
            this.v.draw(canvas);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            int r0 = r7.getActionMasked()
            ir.nasim.uW7 r1 = r6.g
            boolean r1 = r1.Q(r7)
            ir.nasim.uW7 r2 = r6.h
            boolean r2 = r2.Q(r7)
            r1 = r1 | r2
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L38
            if (r0 == r2) goto L31
            r7 = 2
            r4 = 3
            if (r0 == r7) goto L1e
            if (r0 == r4) goto L31
            goto L36
        L1e:
            ir.nasim.uW7 r7 = r6.g
            boolean r7 = r7.e(r4)
            if (r7 == 0) goto L36
            androidx.drawerlayout.widget.DrawerLayout$f r7 = r6.i
            r7.p()
            androidx.drawerlayout.widget.DrawerLayout$f r7 = r6.j
            r7.p()
            goto L36
        L31:
            r6.g(r2)
            r6.r = r3
        L36:
            r7 = r3
            goto L60
        L38:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.t = r0
            r6.u = r7
            float r4 = r6.e
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L5d
            ir.nasim.uW7 r4 = r6.g
            int r0 = (int) r0
            int r7 = (int) r7
            android.view.View r7 = r4.u(r0, r7)
            if (r7 == 0) goto L5d
            boolean r7 = r6.z(r7)
            if (r7 == 0) goto L5d
            r7 = r2
            goto L5e
        L5d:
            r7 = r3
        L5e:
            r6.r = r3
        L60:
            if (r1 != 0) goto L70
            if (r7 != 0) goto L70
            boolean r7 = r6.w()
            if (r7 != 0) goto L70
            boolean r7 = r6.r
            if (r7 == 0) goto L6f
            goto L70
        L6f:
            r2 = r3
        L70:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !x()) {
            return super.onKeyDown(i, keyEvent);
        }
        keyEvent.startTracking();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        View viewN = n();
        if (viewN != null && p(viewN) == 0) {
            f();
        }
        return viewN != null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        WindowInsets rootWindowInsets;
        float f2;
        int i5;
        boolean z2 = true;
        this.l = true;
        int i6 = i3 - i;
        int childCount = getChildCount();
        int i7 = 0;
        while (i7 < childCount) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (z(childAt)) {
                    int i8 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    childAt.layout(i8, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, childAt.getMeasuredWidth() + i8, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (c(childAt, 3)) {
                        float f3 = measuredWidth;
                        i5 = (-measuredWidth) + ((int) (layoutParams.b * f3));
                        f2 = (measuredWidth + i5) / f3;
                    } else {
                        float f4 = measuredWidth;
                        f2 = (i6 - r11) / f4;
                        i5 = i6 - ((int) (layoutParams.b * f4));
                    }
                    boolean z3 = f2 != layoutParams.b ? z2 : false;
                    int i9 = layoutParams.a & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER;
                    if (i9 == 16) {
                        int i10 = i4 - i2;
                        int i11 = (i10 - measuredHeight) / 2;
                        int i12 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                        if (i11 < i12) {
                            i11 = i12;
                        } else {
                            int i13 = i11 + measuredHeight;
                            int i14 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                            if (i13 > i10 - i14) {
                                i11 = (i10 - i14) - measuredHeight;
                            }
                        }
                        childAt.layout(i5, i11, measuredWidth + i5, measuredHeight + i11);
                    } else if (i9 != 80) {
                        int i15 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                        childAt.layout(i5, i15, measuredWidth + i5, measuredHeight + i15);
                    } else {
                        int i16 = i4 - i2;
                        childAt.layout(i5, (i16 - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i5, i16 - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
                    }
                    if (z3) {
                        L(childAt, f2);
                    }
                    int i17 = layoutParams.b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i17) {
                        childAt.setVisibility(i17);
                    }
                }
            }
            i7++;
            z2 = true;
        }
        if (H0 && (rootWindowInsets = getRootWindowInsets()) != null) {
            L93 l93I = O98.z(rootWindowInsets).i();
            C22013uW7 c22013uW7 = this.g;
            c22013uW7.M(Math.max(c22013uW7.x(), l93I.a));
            C22013uW7 c22013uW72 = this.h;
            c22013uW72.M(Math.max(c22013uW72.x(), l93I.c));
        }
        this.l = false;
        this.m = false;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824 || mode2 != 1073741824) {
            if (!isInEditMode()) {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
            if (mode == 0) {
                size = 300;
            }
            if (mode2 == 0) {
                size2 = 300;
            }
        }
        setMeasuredDimension(size, size2);
        boolean z = this.A != null && AbstractC12990fW7.x(this);
        int iA = AbstractC12990fW7.A(this);
        int childCount = getChildCount();
        boolean z2 = false;
        boolean z3 = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (z) {
                    int iB = YK2.b(layoutParams.a, iA);
                    if (AbstractC12990fW7.x(childAt)) {
                        WindowInsets windowInsetsReplaceSystemWindowInsets = (WindowInsets) this.A;
                        if (iB == 3) {
                            windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetLeft(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), 0, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
                        } else if (iB == 5) {
                            windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(0, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetRight(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
                        }
                        childAt.dispatchApplyWindowInsets(windowInsetsReplaceSystemWindowInsets);
                    } else {
                        WindowInsets windowInsetsReplaceSystemWindowInsets2 = (WindowInsets) this.A;
                        if (iB == 3) {
                            windowInsetsReplaceSystemWindowInsets2 = windowInsetsReplaceSystemWindowInsets2.replaceSystemWindowInsets(windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetLeft(), windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetTop(), 0, windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetBottom());
                        } else if (iB == 5) {
                            windowInsetsReplaceSystemWindowInsets2 = windowInsetsReplaceSystemWindowInsets2.replaceSystemWindowInsets(0, windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetTop(), windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetRight(), windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetBottom());
                        }
                        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetLeft();
                        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetTop();
                        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetRight();
                        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetBottom();
                    }
                }
                if (z(childAt)) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec((size - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec((size2 - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, 1073741824));
                } else {
                    if (!B(childAt)) {
                        throw new IllegalStateException("Child " + childAt + " at index " + i3 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                    }
                    if (G0) {
                        float fV = AbstractC12990fW7.v(childAt);
                        float f2 = this.b;
                        if (fV != f2) {
                            AbstractC12990fW7.x0(childAt, f2);
                        }
                    }
                    int iR = r(childAt) & 7;
                    boolean z4 = iR == 3;
                    if ((z4 && z2) || (!z4 && z3)) {
                        throw new IllegalStateException("Child drawer has absolute gravity " + u(iR) + " but this DrawerLayout already has a drawer view along that edge");
                    }
                    if (z4) {
                        z2 = true;
                    } else {
                        z3 = true;
                    }
                    childAt.measure(ViewGroup.getChildMeasureSpec(i, this.c + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, ((ViewGroup.MarginLayoutParams) layoutParams).width), ViewGroup.getChildMeasureSpec(i2, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, ((ViewGroup.MarginLayoutParams) layoutParams).height));
                }
            }
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        View viewL;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        int i = savedState.c;
        if (i != 0 && (viewL = l(i)) != null) {
            G(viewL);
        }
        int i2 = savedState.d;
        if (i2 != 3) {
            setDrawerLockMode(i2, 3);
        }
        int i3 = savedState.e;
        if (i3 != 3) {
            setDrawerLockMode(i3, 5);
        }
        int i4 = savedState.f;
        if (i4 != 3) {
            setDrawerLockMode(i4, 8388611);
        }
        int i5 = savedState.g;
        if (i5 != 3) {
            setDrawerLockMode(i5, 8388613);
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        K();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i).getLayoutParams();
            int i2 = layoutParams.d;
            boolean z = i2 == 1;
            boolean z2 = i2 == 2;
            if (z || z2) {
                savedState.c = layoutParams.a;
                break;
            }
        }
        savedState.d = this.n;
        savedState.e = this.o;
        savedState.f = this.p;
        savedState.g = this.q;
        return savedState;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005a  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            ir.nasim.uW7 r0 = r6.g
            r0.G(r7)
            ir.nasim.uW7 r0 = r6.h
            r0.G(r7)
            int r0 = r7.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L5f
            if (r0 == r2) goto L20
            r7 = 3
            if (r0 == r7) goto L1a
            goto L6d
        L1a:
            r6.g(r2)
            r6.r = r1
            goto L6d
        L20:
            float r0 = r7.getX()
            float r7 = r7.getY()
            ir.nasim.uW7 r3 = r6.g
            int r4 = (int) r0
            int r5 = (int) r7
            android.view.View r3 = r3.u(r4, r5)
            if (r3 == 0) goto L5a
            boolean r3 = r6.z(r3)
            if (r3 == 0) goto L5a
            float r3 = r6.t
            float r0 = r0 - r3
            float r3 = r6.u
            float r7 = r7 - r3
            ir.nasim.uW7 r3 = r6.g
            int r3 = r3.A()
            float r0 = r0 * r0
            float r7 = r7 * r7
            float r0 = r0 + r7
            int r3 = r3 * r3
            float r7 = (float) r3
            int r7 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r7 >= 0) goto L5a
            android.view.View r7 = r6.m()
            if (r7 == 0) goto L5a
            int r7 = r6.p(r7)
            r0 = 2
            if (r7 != r0) goto L5b
        L5a:
            r1 = r2
        L5b:
            r6.g(r1)
            goto L6d
        L5f:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.t = r0
            r6.u = r7
            r6.r = r1
        L6d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public int p(View view) {
        if (B(view)) {
            return o(((LayoutParams) view.getLayoutParams()).a);
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public CharSequence q(int i) {
        int iB = YK2.b(i, AbstractC12990fW7.A(this));
        if (iB == 3) {
            return this.y;
        }
        if (iB == 5) {
            return this.z;
        }
        return null;
    }

    int r(View view) {
        return YK2.b(((LayoutParams) view.getLayoutParams()).a, AbstractC12990fW7.A(this));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z) {
            g(true);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.l) {
            return;
        }
        super.requestLayout();
    }

    float s(View view) {
        return ((LayoutParams) view.getLayoutParams()).b;
    }

    public void setChildInsets(Object obj, boolean z) {
        this.A = obj;
        this.B = z;
        setWillNotDraw(!z && getBackground() == null);
        requestLayout();
    }

    public void setDrawerElevation(float f2) {
        this.b = f2;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (B(childAt)) {
                AbstractC12990fW7.x0(childAt, this.b);
            }
        }
    }

    @Deprecated
    public void setDrawerListener(e eVar) {
        if (eVar != null) {
            a(eVar);
        }
    }

    public void setDrawerLockMode(int i) {
        setDrawerLockMode(i, 3);
        setDrawerLockMode(i, 5);
    }

    public void setDrawerShadow(Drawable drawable, int i) {
        if (G0) {
            return;
        }
        if ((i & 8388611) == 8388611) {
            this.D = drawable;
        } else if ((i & 8388613) == 8388613) {
            this.G = drawable;
        } else if ((i & 3) == 3) {
            this.H = drawable;
        } else if ((i & 5) != 5) {
            return;
        } else {
            this.J = drawable;
        }
        K();
        invalidate();
    }

    public void setDrawerTitle(int i, CharSequence charSequence) {
        int iB = YK2.b(i, AbstractC12990fW7.A(this));
        if (iB == 3) {
            this.y = charSequence;
        } else if (iB == 5) {
            this.z = charSequence;
        }
    }

    public void setScrimColor(int i) {
        this.d = i;
        invalidate();
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.v = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i) {
        this.v = new ColorDrawable(i);
        invalidate();
    }

    boolean z(View view) {
        return ((LayoutParams) view.getLayoutParams()).a == 0;
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC19336qA5.drawerLayoutStyle);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new d();
        this.d = -1728053248;
        this.f = new Paint();
        this.m = true;
        this.n = 3;
        this.o = 3;
        this.p = 3;
        this.q = 3;
        this.D = null;
        this.G = null;
        this.H = null;
        this.J = null;
        this.C0 = new a();
        setDescendantFocusability(262144);
        float f2 = getResources().getDisplayMetrics().density;
        this.c = (int) ((64.0f * f2) + 0.5f);
        float f3 = f2 * 400.0f;
        f fVar = new f(3);
        this.i = fVar;
        f fVar2 = new f(5);
        this.j = fVar2;
        C22013uW7 c22013uW7O = C22013uW7.o(this, 1.0f, fVar);
        this.g = c22013uW7O;
        c22013uW7O.N(1);
        c22013uW7O.O(f3);
        fVar.q(c22013uW7O);
        C22013uW7 c22013uW7O2 = C22013uW7.o(this, 1.0f, fVar2);
        this.h = c22013uW7O2;
        c22013uW7O2.N(2);
        c22013uW7O2.O(f3);
        fVar2.q(c22013uW7O2);
        setFocusableInTouchMode(true);
        AbstractC12990fW7.A0(this, 1);
        AbstractC12990fW7.p0(this, new c());
        setMotionEventSplittingEnabled(false);
        if (AbstractC12990fW7.x(this)) {
            setOnApplyWindowInsetsListener(new b());
            setSystemUiVisibility(SimpleResolver.DEFAULT_EDNS_PAYLOADSIZE);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(D0);
            try {
                this.v = typedArrayObtainStyledAttributes.getDrawable(0);
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, VE5.DrawerLayout, i, 0);
        try {
            if (typedArrayObtainStyledAttributes2.hasValue(VE5.DrawerLayout_elevation)) {
                this.b = typedArrayObtainStyledAttributes2.getDimension(VE5.DrawerLayout_elevation, 0.0f);
            } else {
                this.b = getResources().getDimension(AbstractC10783cB5.def_drawer_elevation);
            }
            typedArrayObtainStyledAttributes2.recycle();
            this.z0 = new ArrayList();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes2.recycle();
            throw th;
        }
    }

    public void setDrawerLockMode(int i, int i2) {
        View viewL;
        int iB = YK2.b(i2, AbstractC12990fW7.A(this));
        if (i2 == 3) {
            this.n = i;
        } else if (i2 == 5) {
            this.o = i;
        } else if (i2 == 8388611) {
            this.p = i;
        } else if (i2 == 8388613) {
            this.q = i;
        }
        if (i != 0) {
            (iB == 3 ? this.g : this.h).b();
        }
        if (i != 1) {
            if (i == 2 && (viewL = l(iB)) != null) {
                G(viewL);
                return;
            }
            return;
        }
        View viewL2 = l(iB);
        if (viewL2 != null) {
            d(viewL2);
        }
    }

    public void setStatusBarBackground(int i) {
        this.v = i != 0 ? AbstractC4043Dl1.f(getContext(), i) : null;
        invalidate();
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int a;
        float b;
        boolean c;
        int d;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = 0;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.E0);
            this.a = typedArrayObtainStyledAttributes.getInt(0, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.a = 0;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.a = 0;
            this.a = layoutParams.a;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.a = 0;
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        int c;
        int d;
        int e;
        int f;
        int g;

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
            this.c = 0;
            this.c = parcel.readInt();
            this.d = parcel.readInt();
            this.e = parcel.readInt();
            this.f = parcel.readInt();
            this.g = parcel.readInt();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.c);
            parcel.writeInt(this.d);
            parcel.writeInt(this.e);
            parcel.writeInt(this.f);
            parcel.writeInt(this.g);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
            this.c = 0;
        }
    }

    public void setDrawerShadow(int i, int i2) {
        setDrawerShadow(AbstractC4043Dl1.f(getContext(), i), i2);
    }

    public void setDrawerLockMode(int i, View view) {
        if (B(view)) {
            setDrawerLockMode(i, ((LayoutParams) view.getLayoutParams()).a);
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer with appropriate layout_gravity");
    }
}
