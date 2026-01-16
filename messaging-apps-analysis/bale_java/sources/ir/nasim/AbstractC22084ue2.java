package ir.nasim;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC5984Lr2;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.ue2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC22084ue2 extends C22317v2 {
    private static final Rect n = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, RecyclerView.UNDEFINED_DURATION, RecyclerView.UNDEFINED_DURATION);
    private static final AbstractC5984Lr2.a o = new a();
    private static final AbstractC5984Lr2.b p = new b();
    private final AccessibilityManager h;
    private final View i;
    private c j;
    private final Rect d = new Rect();
    private final Rect e = new Rect();
    private final Rect f = new Rect();
    private final int[] g = new int[2];
    int k = RecyclerView.UNDEFINED_DURATION;
    int l = RecyclerView.UNDEFINED_DURATION;
    private int m = RecyclerView.UNDEFINED_DURATION;

    /* renamed from: ir.nasim.ue2$a */
    class a implements AbstractC5984Lr2.a {
        a() {
        }

        @Override // ir.nasim.AbstractC5984Lr2.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(X2 x2, Rect rect) {
            x2.m(rect);
        }
    }

    /* renamed from: ir.nasim.ue2$b */
    class b implements AbstractC5984Lr2.b {
        b() {
        }

        @Override // ir.nasim.AbstractC5984Lr2.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public X2 a(C19409qI6 c19409qI6, int i) {
            return (X2) c19409qI6.p(i);
        }

        @Override // ir.nasim.AbstractC5984Lr2.b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public int b(C19409qI6 c19409qI6) {
            return c19409qI6.o();
        }
    }

    /* renamed from: ir.nasim.ue2$c */
    private class c extends Y2 {
        c() {
        }

        @Override // ir.nasim.Y2
        public X2 b(int i) {
            return X2.c0(AbstractC22084ue2.this.J(i));
        }

        @Override // ir.nasim.Y2
        public X2 d(int i) {
            int i2 = i == 2 ? AbstractC22084ue2.this.k : AbstractC22084ue2.this.l;
            if (i2 == Integer.MIN_VALUE) {
                return null;
            }
            return b(i2);
        }

        @Override // ir.nasim.Y2
        public boolean f(int i, int i2, Bundle bundle) {
            return AbstractC22084ue2.this.R(i, i2, bundle);
        }
    }

    public AbstractC22084ue2(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.i = view;
        this.h = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        if (AbstractC12990fW7.y(view) == 0) {
            AbstractC12990fW7.A0(view, 1);
        }
    }

    private static Rect D(View view, int i, Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i == 17) {
            rect.set(width, 0, width, height);
        } else if (i == 33) {
            rect.set(0, height, width, height);
        } else if (i == 66) {
            rect.set(-1, 0, -1, height);
        } else {
            if (i != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            rect.set(0, -1, width, -1);
        }
        return rect;
    }

    private boolean G(Rect rect) {
        if (rect == null || rect.isEmpty() || this.i.getWindowVisibility() != 0) {
            return false;
        }
        Object parent = this.i.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        return parent != null;
    }

    private static int H(int i) {
        if (i == 19) {
            return 33;
        }
        if (i != 21) {
            return i != 22 ? 130 : 66;
        }
        return 17;
    }

    private boolean I(int i, Rect rect) {
        X2 x2;
        C19409qI6 c19409qI6Y = y();
        int i2 = this.l;
        int iK = RecyclerView.UNDEFINED_DURATION;
        X2 x22 = i2 == Integer.MIN_VALUE ? null : (X2) c19409qI6Y.f(i2);
        if (i == 1 || i == 2) {
            x2 = (X2) AbstractC5984Lr2.d(c19409qI6Y, p, o, x22, i, AbstractC12990fW7.A(this.i) == 1, false);
        } else {
            if (i != 17 && i != 33 && i != 66 && i != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            Rect rect2 = new Rect();
            int i3 = this.l;
            if (i3 != Integer.MIN_VALUE) {
                z(i3, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                D(this.i, i, rect2);
            }
            x2 = (X2) AbstractC5984Lr2.c(c19409qI6Y, p, o, x22, rect2, i);
        }
        if (x2 != null) {
            iK = c19409qI6Y.k(c19409qI6Y.i(x2));
        }
        return V(iK);
    }

    private boolean S(int i, int i2, Bundle bundle) {
        return i2 != 1 ? i2 != 2 ? i2 != 64 ? i2 != 128 ? L(i, i2, bundle) : n(i) : U(i) : o(i) : V(i);
    }

    private boolean T(int i, Bundle bundle) {
        return AbstractC12990fW7.e0(this.i, i, bundle);
    }

    private boolean U(int i) {
        int i2;
        if (!this.h.isEnabled() || !this.h.isTouchExplorationEnabled() || (i2 = this.k) == i) {
            return false;
        }
        if (i2 != Integer.MIN_VALUE) {
            n(i2);
        }
        this.k = i;
        this.i.invalidate();
        W(i, 32768);
        return true;
    }

    private void X(int i) {
        int i2 = this.m;
        if (i2 == i) {
            return;
        }
        this.m = i;
        W(i, 128);
        W(i2, 256);
    }

    private boolean n(int i) {
        if (this.k != i) {
            return false;
        }
        this.k = RecyclerView.UNDEFINED_DURATION;
        this.i.invalidate();
        W(i, 65536);
        return true;
    }

    private boolean p() {
        int i = this.l;
        return i != Integer.MIN_VALUE && L(i, 16, null);
    }

    private AccessibilityEvent q(int i, int i2) {
        return i != -1 ? r(i, i2) : s(i2);
    }

    private AccessibilityEvent r(int i, int i2) {
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i2);
        X2 x2J = J(i);
        accessibilityEventObtain.getText().add(x2J.C());
        accessibilityEventObtain.setContentDescription(x2J.t());
        accessibilityEventObtain.setScrollable(x2J.V());
        accessibilityEventObtain.setPassword(x2J.U());
        accessibilityEventObtain.setEnabled(x2J.O());
        accessibilityEventObtain.setChecked(x2J.L());
        N(i, accessibilityEventObtain);
        if (accessibilityEventObtain.getText().isEmpty() && accessibilityEventObtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        accessibilityEventObtain.setClassName(x2J.q());
        Z2.d(accessibilityEventObtain, this.i, i);
        accessibilityEventObtain.setPackageName(this.i.getContext().getPackageName());
        return accessibilityEventObtain;
    }

    private AccessibilityEvent s(int i) {
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i);
        this.i.onInitializeAccessibilityEvent(accessibilityEventObtain);
        return accessibilityEventObtain;
    }

    private X2 t(int i) {
        X2 x2A0 = X2.a0();
        x2A0.x0(true);
        x2A0.z0(true);
        x2A0.p0("android.view.View");
        Rect rect = n;
        x2A0.k0(rect);
        x2A0.l0(rect);
        x2A0.L0(this.i);
        P(i, x2A0);
        if (x2A0.C() == null && x2A0.t() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        x2A0.m(this.e);
        if (this.e.equals(rect)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int iK = x2A0.k();
        if ((iK & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        if ((iK & 128) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        x2A0.J0(this.i.getContext().getPackageName());
        x2A0.V0(this.i, i);
        if (this.k == i) {
            x2A0.h0(true);
            x2A0.a(128);
        } else {
            x2A0.h0(false);
            x2A0.a(64);
        }
        boolean z = this.l == i;
        if (z) {
            x2A0.a(2);
        } else if (x2A0.P()) {
            x2A0.a(1);
        }
        x2A0.A0(z);
        this.i.getLocationOnScreen(this.g);
        x2A0.n(this.d);
        if (this.d.equals(rect)) {
            x2A0.m(this.d);
            if (x2A0.b != -1) {
                X2 x2A02 = X2.a0();
                for (int i2 = x2A0.b; i2 != -1; i2 = x2A02.b) {
                    x2A02.M0(this.i, -1);
                    x2A02.k0(n);
                    P(i2, x2A02);
                    x2A02.m(this.e);
                    Rect rect2 = this.d;
                    Rect rect3 = this.e;
                    rect2.offset(rect3.left, rect3.top);
                }
                x2A02.e0();
            }
            this.d.offset(this.g[0] - this.i.getScrollX(), this.g[1] - this.i.getScrollY());
        }
        if (this.i.getLocalVisibleRect(this.f)) {
            this.f.offset(this.g[0] - this.i.getScrollX(), this.g[1] - this.i.getScrollY());
            if (this.d.intersect(this.f)) {
                x2A0.l0(this.d);
                if (G(this.d)) {
                    x2A0.e1(true);
                }
            }
        }
        return x2A0;
    }

    private X2 u() {
        X2 x2B0 = X2.b0(this.i);
        AbstractC12990fW7.c0(this.i, x2B0);
        ArrayList arrayList = new ArrayList();
        C(arrayList);
        if (x2B0.p() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            x2B0.d(this.i, ((Integer) arrayList.get(i)).intValue());
        }
        return x2B0;
    }

    private C19409qI6 y() {
        ArrayList arrayList = new ArrayList();
        C(arrayList);
        C19409qI6 c19409qI6 = new C19409qI6();
        for (int i = 0; i < arrayList.size(); i++) {
            c19409qI6.l(((Integer) arrayList.get(i)).intValue(), t(((Integer) arrayList.get(i)).intValue()));
        }
        return c19409qI6;
    }

    private void z(int i, Rect rect) {
        J(i).m(rect);
    }

    public final int A() {
        return this.l;
    }

    protected abstract int B(float f, float f2);

    protected abstract void C(List list);

    public final void E(int i) {
        F(i, 0);
    }

    public final void F(int i, int i2) {
        ViewParent parent;
        if (i == Integer.MIN_VALUE || !this.h.isEnabled() || (parent = this.i.getParent()) == null) {
            return;
        }
        AccessibilityEvent accessibilityEventQ = q(i, 2048);
        AbstractC22913w2.c(accessibilityEventQ, i2);
        parent.requestSendAccessibilityEvent(this.i, accessibilityEventQ);
    }

    X2 J(int i) {
        return i == -1 ? u() : t(i);
    }

    public final void K(boolean z, int i, Rect rect) {
        int i2 = this.l;
        if (i2 != Integer.MIN_VALUE) {
            o(i2);
        }
        if (z) {
            I(i, rect);
        }
    }

    protected abstract boolean L(int i, int i2, Bundle bundle);

    protected abstract void P(int i, X2 x2);

    boolean R(int i, int i2, Bundle bundle) {
        return i != -1 ? S(i, i2, bundle) : T(i2, bundle);
    }

    public final boolean V(int i) {
        int i2;
        if ((!this.i.isFocused() && !this.i.requestFocus()) || (i2 = this.l) == i) {
            return false;
        }
        if (i2 != Integer.MIN_VALUE) {
            o(i2);
        }
        if (i == Integer.MIN_VALUE) {
            return false;
        }
        this.l = i;
        Q(i, true);
        W(i, 8);
        return true;
    }

    public final boolean W(int i, int i2) {
        ViewParent parent;
        if (i == Integer.MIN_VALUE || !this.h.isEnabled() || (parent = this.i.getParent()) == null) {
            return false;
        }
        return parent.requestSendAccessibilityEvent(this.i, q(i, i2));
    }

    @Override // ir.nasim.C22317v2
    public Y2 b(View view) {
        if (this.j == null) {
            this.j = new c();
        }
        return this.j;
    }

    @Override // ir.nasim.C22317v2
    public void f(View view, AccessibilityEvent accessibilityEvent) {
        super.f(view, accessibilityEvent);
        M(accessibilityEvent);
    }

    @Override // ir.nasim.C22317v2
    public void g(View view, X2 x2) {
        super.g(view, x2);
        O(x2);
    }

    public final boolean o(int i) {
        if (this.l != i) {
            return false;
        }
        this.l = RecyclerView.UNDEFINED_DURATION;
        Q(i, false);
        W(i, 8);
        return true;
    }

    public final boolean v(MotionEvent motionEvent) {
        if (!this.h.isEnabled() || !this.h.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 7 || action == 9) {
            int iB = B(motionEvent.getX(), motionEvent.getY());
            X(iB);
            return iB != Integer.MIN_VALUE;
        }
        if (action != 10 || this.m == Integer.MIN_VALUE) {
            return false;
        }
        X(RecyclerView.UNDEFINED_DURATION);
        return true;
    }

    public final boolean w(KeyEvent keyEvent) {
        int i = 0;
        if (keyEvent.getAction() == 1) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 61) {
            if (keyEvent.hasNoModifiers()) {
                return I(2, null);
            }
            if (keyEvent.hasModifiers(1)) {
                return I(1, null);
            }
            return false;
        }
        if (keyCode != 66) {
            switch (keyCode) {
                case 19:
                case 20:
                case 21:
                case 22:
                    if (!keyEvent.hasNoModifiers()) {
                        return false;
                    }
                    int iH = H(keyCode);
                    int repeatCount = keyEvent.getRepeatCount() + 1;
                    boolean z = false;
                    while (i < repeatCount && I(iH, null)) {
                        i++;
                        z = true;
                    }
                    return z;
                case 23:
                    break;
                default:
                    return false;
            }
        }
        if (!keyEvent.hasNoModifiers() || keyEvent.getRepeatCount() != 0) {
            return false;
        }
        p();
        return true;
    }

    public final int x() {
        return this.k;
    }

    protected void M(AccessibilityEvent accessibilityEvent) {
    }

    protected void O(X2 x2) {
    }

    protected void N(int i, AccessibilityEvent accessibilityEvent) {
    }

    protected void Q(int i, boolean z) {
    }
}
