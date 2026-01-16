package androidx.coordinatorlayout.widget;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.gov.nist.core.Separators;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.customview.view.AbsSavedState;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC17563nA5;
import ir.nasim.AbstractC19963rE5;
import ir.nasim.AbstractC21710u02;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.BW7;
import ir.nasim.C23313wi5;
import ir.nasim.C5978Lq4;
import ir.nasim.FG4;
import ir.nasim.InterfaceC20850si5;
import ir.nasim.InterfaceC22474vI4;
import ir.nasim.InterfaceC5510Jq4;
import ir.nasim.InterfaceC5744Kq4;
import ir.nasim.O98;
import ir.nasim.OT1;
import ir.nasim.TE5;
import ir.nasim.YK2;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xbill.DNS.SimpleResolver;

/* loaded from: classes2.dex */
public class CoordinatorLayout extends ViewGroup implements InterfaceC5510Jq4, InterfaceC5744Kq4 {
    static final String u;
    static final Class[] v;
    static final ThreadLocal w;
    static final Comparator x;
    private static final InterfaceC20850si5 y;
    private final List a;
    private final OT1 b;
    private final List c;
    private final List d;
    private Paint e;
    private final int[] f;
    private final int[] g;
    private boolean h;
    private boolean i;
    private int[] j;
    private View k;
    private View l;
    private f m;
    private boolean n;
    private O98 o;
    private boolean p;
    private Drawable q;
    ViewGroup.OnHierarchyChangeListener r;
    private InterfaceC22474vI4 s;
    private final C5978Lq4 t;

    public static abstract class Behavior<V extends View> {
        public Behavior() {
        }

        public boolean A(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i2) {
            if (i2 == 0) {
                return z(coordinatorLayout, view, view2, view3, i);
            }
            return false;
        }

        public void B(CoordinatorLayout coordinatorLayout, View view, View view2) {
        }

        public void C(CoordinatorLayout coordinatorLayout, View view, View view2, int i) {
            if (i == 0) {
                B(coordinatorLayout, view, view2);
            }
        }

        public boolean D(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, View view) {
            return d(coordinatorLayout, view) > 0.0f;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, View view, Rect rect) {
            return false;
        }

        public int c(CoordinatorLayout coordinatorLayout, View view) {
            return -16777216;
        }

        public float d(CoordinatorLayout coordinatorLayout, View view) {
            return 0.0f;
        }

        public boolean e(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return false;
        }

        public void g(e eVar) {
        }

        public boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return false;
        }

        public void i(CoordinatorLayout coordinatorLayout, View view, View view2) {
        }

        public void j() {
        }

        public boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return false;
        }

        public boolean l(CoordinatorLayout coordinatorLayout, View view, int i) {
            return false;
        }

        public boolean m(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
            return false;
        }

        public boolean n(CoordinatorLayout coordinatorLayout, View view, View view2, float f, float f2, boolean z) {
            return false;
        }

        public boolean o(CoordinatorLayout coordinatorLayout, View view, View view2, float f, float f2) {
            return false;
        }

        public void p(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int[] iArr) {
        }

        public void q(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int[] iArr, int i3) {
            if (i3 == 0) {
                p(coordinatorLayout, view, view2, i, i2, iArr);
            }
        }

        public void r(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int i3, int i4) {
        }

        public void s(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int i3, int i4, int i5) {
            if (i5 == 0) {
                r(coordinatorLayout, view, view2, i, i2, i3, i4);
            }
        }

        public void t(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int i3, int i4, int i5, int[] iArr) {
            iArr[0] = iArr[0] + i3;
            iArr[1] = iArr[1] + i4;
            s(coordinatorLayout, view, view2, i, i2, i3, i4, i5);
        }

        public void u(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i) {
        }

        public void v(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i2) {
            if (i2 == 0) {
                u(coordinatorLayout, view, view2, view3, i);
            }
        }

        public boolean w(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            return false;
        }

        public void x(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
        }

        public Parcelable y(CoordinatorLayout coordinatorLayout, View view) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        public boolean z(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i) {
            return false;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
        }

        public O98 f(CoordinatorLayout coordinatorLayout, View view, O98 o98) {
            return o98;
        }
    }

    class a implements InterfaceC22474vI4 {
        a() {
        }

        @Override // ir.nasim.InterfaceC22474vI4
        public O98 b(View view, O98 o98) {
            return CoordinatorLayout.this.a0(o98);
        }
    }

    public interface b {
        Behavior getBehavior();
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface c {
        Class value();
    }

    private class d implements ViewGroup.OnHierarchyChangeListener {
        d() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.r;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.L(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.r;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    class f implements ViewTreeObserver.OnPreDrawListener {
        f() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            CoordinatorLayout.this.L(0);
            return true;
        }
    }

    static class g implements Comparator {
        g() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            float fM = AbstractC12990fW7.M(view);
            float fM2 = AbstractC12990fW7.M(view2);
            if (fM > fM2) {
                return -1;
            }
            return fM < fM2 ? 1 : 0;
        }
    }

    static {
        Package r0 = CoordinatorLayout.class.getPackage();
        u = r0 != null ? r0.getName() : null;
        x = new g();
        v = new Class[]{Context.class, AttributeSet.class};
        w = new ThreadLocal();
        y = new C23313wi5(12);
    }

    public CoordinatorLayout(Context context) {
        this(context, null);
    }

    private int A(int i) {
        int[] iArr = this.j;
        if (iArr == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i);
            return 0;
        }
        if (i >= 0 && i < iArr.length) {
            return iArr[i];
        }
        Log.e("CoordinatorLayout", "Keyline index " + i + " out of range for " + this);
        return 0;
    }

    private void D(List list) {
        list.clear();
        boolean zIsChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i = childCount - 1; i >= 0; i--) {
            list.add(getChildAt(zIsChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i) : i));
        }
        Comparator comparator = x;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
    }

    private boolean E(View view) {
        return this.b.j(view);
    }

    private void G(View view, int i) {
        e eVar = (e) view.getLayoutParams();
        Rect rectE = e();
        rectE.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) eVar).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin);
        if (this.o != null && AbstractC12990fW7.x(this) && !AbstractC12990fW7.x(view)) {
            rectE.left += this.o.k();
            rectE.top += this.o.m();
            rectE.right -= this.o.l();
            rectE.bottom -= this.o.j();
        }
        Rect rectE2 = e();
        YK2.a(W(eVar.c), view.getMeasuredWidth(), view.getMeasuredHeight(), rectE, rectE2, i);
        view.layout(rectE2.left, rectE2.top, rectE2.right, rectE2.bottom);
        S(rectE);
        S(rectE2);
    }

    private void H(View view, View view2, int i) {
        Rect rectE = e();
        Rect rectE2 = e();
        try {
            x(view2, rectE);
            y(view, i, rectE, rectE2);
            view.layout(rectE2.left, rectE2.top, rectE2.right, rectE2.bottom);
        } finally {
            S(rectE);
            S(rectE2);
        }
    }

    private void I(View view, int i, int i2) {
        e eVar = (e) view.getLayoutParams();
        int iB = YK2.b(X(eVar.c), i2);
        int i3 = iB & 7;
        int i4 = iB & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i2 == 1) {
            i = width - i;
        }
        int iA = A(i) - measuredWidth;
        if (i3 == 1) {
            iA += measuredWidth / 2;
        } else if (i3 == 5) {
            iA += measuredWidth;
        }
        int i5 = i4 != 16 ? i4 != 80 ? 0 : measuredHeight : measuredHeight / 2;
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin, Math.min(iA, ((width - getPaddingRight()) - measuredWidth) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) eVar).topMargin, Math.min(i5, ((height - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin));
        view.layout(iMax, iMax2, measuredWidth + iMax, measuredHeight + iMax2);
    }

    private void J(View view, Rect rect, int i) {
        boolean z;
        boolean z2;
        int width;
        int i2;
        int i3;
        int i4;
        int height;
        int i5;
        int i6;
        int i7;
        if (AbstractC12990fW7.T(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            e eVar = (e) view.getLayoutParams();
            Behavior behaviorF = eVar.f();
            Rect rectE = e();
            Rect rectE2 = e();
            rectE2.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (behaviorF == null || !behaviorF.b(this, view, rectE)) {
                rectE.set(rectE2);
            } else if (!rectE2.contains(rectE)) {
                throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + rectE.toShortString() + " | Bounds:" + rectE2.toShortString());
            }
            S(rectE2);
            if (rectE.isEmpty()) {
                S(rectE);
                return;
            }
            int iB = YK2.b(eVar.h, i);
            boolean z3 = true;
            if ((iB & 48) != 48 || (i6 = (rectE.top - ((ViewGroup.MarginLayoutParams) eVar).topMargin) - eVar.j) >= (i7 = rect.top)) {
                z = false;
            } else {
                Z(view, i7 - i6);
                z = true;
            }
            if ((iB & 80) == 80 && (height = ((getHeight() - rectE.bottom) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin) + eVar.j) < (i5 = rect.bottom)) {
                Z(view, height - i5);
                z = true;
            }
            if (!z) {
                Z(view, 0);
            }
            if ((iB & 3) != 3 || (i3 = (rectE.left - ((ViewGroup.MarginLayoutParams) eVar).leftMargin) - eVar.i) >= (i4 = rect.left)) {
                z2 = false;
            } else {
                Y(view, i4 - i3);
                z2 = true;
            }
            if ((iB & 5) != 5 || (width = ((getWidth() - rectE.right) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin) + eVar.i) >= (i2 = rect.right)) {
                z3 = z2;
            } else {
                Y(view, width - i2);
            }
            if (!z3) {
                Y(view, 0);
            }
            S(rectE);
        }
    }

    static Behavior O(Context context, AttributeSet attributeSet, String str) throws NoSuchMethodException, SecurityException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(Separators.DOT)) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0) {
            String str2 = u;
            if (!TextUtils.isEmpty(str2)) {
                str = str2 + '.' + str;
            }
        }
        try {
            ThreadLocal threadLocal = w;
            Map map = (Map) threadLocal.get();
            if (map == null) {
                map = new HashMap();
                threadLocal.set(map);
            }
            Constructor<?> constructor = (Constructor) map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, false, context.getClassLoader()).getConstructor(v);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return (Behavior) constructor.newInstance(context, attributeSet);
        } catch (Exception e2) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e2);
        }
    }

    private boolean P(MotionEvent motionEvent, int i) {
        int actionMasked = motionEvent.getActionMasked();
        List list = this.c;
        D(list);
        int size = list.size();
        MotionEvent motionEventObtain = null;
        boolean zK = false;
        boolean z = false;
        for (int i2 = 0; i2 < size; i2++) {
            View view = (View) list.get(i2);
            e eVar = (e) view.getLayoutParams();
            Behavior behaviorF = eVar.f();
            if (!(zK || z) || actionMasked == 0) {
                if (!zK && behaviorF != null) {
                    if (i == 0) {
                        zK = behaviorF.k(this, view, motionEvent);
                    } else if (i == 1) {
                        zK = behaviorF.D(this, view, motionEvent);
                    }
                    if (zK) {
                        this.k = view;
                    }
                }
                boolean zC = eVar.c();
                boolean zI = eVar.i(this, view);
                z = zI && !zC;
                if (zI && !z) {
                    break;
                }
            } else if (behaviorF != null) {
                if (motionEventObtain == null) {
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                if (i == 0) {
                    behaviorF.k(this, view, motionEventObtain);
                } else if (i == 1) {
                    behaviorF.D(this, view, motionEventObtain);
                }
            }
        }
        list.clear();
        return zK;
    }

    private void Q() {
        this.a.clear();
        this.b.c();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            e eVarC = C(childAt);
            eVarC.d(this, childAt);
            this.b.b(childAt);
            for (int i2 = 0; i2 < childCount; i2++) {
                if (i2 != i) {
                    View childAt2 = getChildAt(i2);
                    if (eVarC.b(this, childAt, childAt2)) {
                        if (!this.b.d(childAt2)) {
                            this.b.b(childAt2);
                        }
                        this.b.a(childAt2, childAt);
                    }
                }
            }
        }
        this.a.addAll(this.b.i());
        Collections.reverse(this.a);
    }

    private static void S(Rect rect) {
        rect.setEmpty();
        y.a(rect);
    }

    private void U(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            Behavior behaviorF = ((e) childAt.getLayoutParams()).f();
            if (behaviorF != null) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z) {
                    behaviorF.k(this, childAt, motionEventObtain);
                } else {
                    behaviorF.D(this, childAt, motionEventObtain);
                }
                motionEventObtain.recycle();
            }
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            ((e) getChildAt(i2).getLayoutParams()).m();
        }
        this.k = null;
        this.h = false;
    }

    private static int V(int i) {
        if (i == 0) {
            return 17;
        }
        return i;
    }

    private static int W(int i) {
        if ((i & 7) == 0) {
            i |= 8388611;
        }
        return (i & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 0 ? i | 48 : i;
    }

    private static int X(int i) {
        if (i == 0) {
            return 8388661;
        }
        return i;
    }

    private void Y(View view, int i) {
        e eVar = (e) view.getLayoutParams();
        int i2 = eVar.i;
        if (i2 != i) {
            AbstractC12990fW7.Z(view, i - i2);
            eVar.i = i;
        }
    }

    private void Z(View view, int i) {
        e eVar = (e) view.getLayoutParams();
        int i2 = eVar.j;
        if (i2 != i) {
            AbstractC12990fW7.a0(view, i - i2);
            eVar.j = i;
        }
    }

    private void b0() {
        if (!AbstractC12990fW7.x(this)) {
            AbstractC12990fW7.E0(this, null);
            return;
        }
        if (this.s == null) {
            this.s = new a();
        }
        AbstractC12990fW7.E0(this, this.s);
        setSystemUiVisibility(SimpleResolver.DEFAULT_EDNS_PAYLOADSIZE);
    }

    private static Rect e() {
        Rect rect = (Rect) y.b();
        return rect == null ? new Rect() : rect;
    }

    private static int g(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    private void i(e eVar, Rect rect, int i, int i2) {
        int width = getWidth();
        int height = getHeight();
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) eVar).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i2) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin));
        rect.set(iMax, iMax2, i + iMax, i2 + iMax2);
    }

    private O98 j(O98 o98) {
        Behavior behaviorF;
        if (o98.r()) {
            return o98;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (AbstractC12990fW7.x(childAt) && (behaviorF = ((e) childAt.getLayoutParams()).f()) != null) {
                o98 = behaviorF.f(this, childAt, o98);
                if (o98.r()) {
                    break;
                }
            }
        }
        return o98;
    }

    private void z(View view, int i, Rect rect, Rect rect2, e eVar, int i2, int i3) {
        int iB = YK2.b(V(eVar.c), i);
        int iB2 = YK2.b(W(eVar.d), i);
        int i4 = iB & 7;
        int i5 = iB & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER;
        int i6 = iB2 & 7;
        int i7 = iB2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER;
        int iWidth = i6 != 1 ? i6 != 5 ? rect.left : rect.right : rect.left + (rect.width() / 2);
        int iHeight = i7 != 16 ? i7 != 80 ? rect.top : rect.bottom : rect.top + (rect.height() / 2);
        if (i4 == 1) {
            iWidth -= i2 / 2;
        } else if (i4 != 5) {
            iWidth -= i2;
        }
        if (i5 == 16) {
            iHeight -= i3 / 2;
        } else if (i5 != 80) {
            iHeight -= i3;
        }
        rect2.set(iWidth, iHeight, i2 + iWidth, i3 + iHeight);
    }

    void B(View view, Rect rect) {
        rect.set(((e) view.getLayoutParams()).h());
    }

    /* JADX WARN: Multi-variable type inference failed */
    e C(View view) {
        e eVar = (e) view.getLayoutParams();
        if (!eVar.b) {
            if (view instanceof b) {
                Behavior behavior = ((b) view).getBehavior();
                if (behavior == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                eVar.o(behavior);
                eVar.b = true;
            } else {
                c cVar = null;
                for (Class<?> superclass = view.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
                    cVar = (c) superclass.getAnnotation(c.class);
                    if (cVar != null) {
                        break;
                    }
                }
                if (cVar != null) {
                    try {
                        eVar.o((Behavior) cVar.value().getDeclaredConstructor(null).newInstance(null));
                    } catch (Exception e2) {
                        Log.e("CoordinatorLayout", "Default behavior class " + cVar.value().getName() + " could not be instantiated. Did you forget a default constructor?", e2);
                    }
                }
                eVar.b = true;
            }
        }
        return eVar;
    }

    public boolean F(View view, int i, int i2) {
        Rect rectE = e();
        x(view, rectE);
        try {
            return rectE.contains(i, i2);
        } finally {
            S(rectE);
        }
    }

    void K(View view, int i) {
        Behavior behaviorF;
        e eVar = (e) view.getLayoutParams();
        if (eVar.k != null) {
            Rect rectE = e();
            Rect rectE2 = e();
            Rect rectE3 = e();
            x(eVar.k, rectE);
            s(view, false, rectE2);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            z(view, i, rectE, rectE3, eVar, measuredWidth, measuredHeight);
            boolean z = (rectE3.left == rectE2.left && rectE3.top == rectE2.top) ? false : true;
            i(eVar, rectE3, measuredWidth, measuredHeight);
            int i2 = rectE3.left - rectE2.left;
            int i3 = rectE3.top - rectE2.top;
            if (i2 != 0) {
                AbstractC12990fW7.Z(view, i2);
            }
            if (i3 != 0) {
                AbstractC12990fW7.a0(view, i3);
            }
            if (z && (behaviorF = eVar.f()) != null) {
                behaviorF.h(this, view, eVar.k);
            }
            S(rectE);
            S(rectE2);
            S(rectE3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final void L(int r18) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.L(int):void");
    }

    public void M(View view, int i) {
        e eVar = (e) view.getLayoutParams();
        if (eVar.a()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
        View view2 = eVar.k;
        if (view2 != null) {
            H(view, view2, i);
            return;
        }
        int i2 = eVar.e;
        if (i2 >= 0) {
            I(view, i2, i);
        } else {
            G(view, i);
        }
    }

    public void N(View view, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view, i, i2, i3, i4);
    }

    void R(View view, Rect rect) {
        ((e) view.getLayoutParams()).q(rect);
    }

    void T() {
        if (this.i && this.m != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.m);
        }
        this.n = false;
    }

    final O98 a0(O98 o98) {
        if (FG4.a(this.o, o98)) {
            return o98;
        }
        this.o = o98;
        boolean z = false;
        boolean z2 = o98 != null && o98.m() > 0;
        this.p = z2;
        if (!z2 && getBackground() == null) {
            z = true;
        }
        setWillNotDraw(z);
        O98 o98J = j(o98);
        requestLayout();
        return o98J;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof e) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        e eVar = (e) view.getLayoutParams();
        Behavior behavior = eVar.a;
        if (behavior != null) {
            float fD = behavior.d(this, view);
            if (fD > 0.0f) {
                if (this.e == null) {
                    this.e = new Paint();
                }
                this.e.setColor(eVar.a.c(this, view));
                this.e.setAlpha(g(Math.round(fD * 255.0f), 0, 255));
                int iSave = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.e);
                canvas.restoreToCount(iSave);
            }
        }
        return super.drawChild(canvas, view, j);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.q;
        if ((drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState)) {
            invalidate();
        }
    }

    void f() {
        if (this.i) {
            if (this.m == null) {
                this.m = new f();
            }
            getViewTreeObserver().addOnPreDrawListener(this.m);
        }
        this.n = true;
    }

    final List<View> getDependencySortedChildren() {
        Q();
        return Collections.unmodifiableList(this.a);
    }

    public final O98 getLastWindowInsets() {
        return this.o;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.t.a();
    }

    public Drawable getStatusBarBackground() {
        return this.q;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    @Override // ir.nasim.InterfaceC5510Jq4
    public void h(View view, View view2, int i, int i2) {
        Behavior behaviorF;
        this.t.c(view, view2, i, i2);
        this.l = view2;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            e eVar = (e) childAt.getLayoutParams();
            if (eVar.j(i2) && (behaviorF = eVar.f()) != null) {
                behaviorF.v(this, childAt, view, view2, i, i2);
            }
        }
    }

    @Override // ir.nasim.InterfaceC5510Jq4
    public void k(View view, int i) {
        this.t.e(view, i);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            e eVar = (e) childAt.getLayoutParams();
            if (eVar.j(i)) {
                Behavior behaviorF = eVar.f();
                if (behaviorF != null) {
                    behaviorF.C(this, childAt, view, i);
                }
                eVar.l(i);
                eVar.k();
            }
        }
        this.l = null;
    }

    public void l(View view) {
        List listG = this.b.g(view);
        if (listG == null || listG.isEmpty()) {
            return;
        }
        for (int i = 0; i < listG.size(); i++) {
            View view2 = (View) listG.get(i);
            Behavior behaviorF = ((e) view2.getLayoutParams()).f();
            if (behaviorF != null) {
                behaviorF.h(this, view2, view);
            }
        }
    }

    void m() {
        int childCount = getChildCount();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            }
            if (E(getChildAt(i))) {
                z = true;
                break;
            }
            i++;
        }
        if (z != this.n) {
            if (z) {
                f();
            } else {
                T();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public e generateDefaultLayoutParams() {
        return new e(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        U(false);
        if (this.n) {
            if (this.m == null) {
                this.m = new f();
            }
            getViewTreeObserver().addOnPreDrawListener(this.m);
        }
        if (this.o == null && AbstractC12990fW7.x(this)) {
            AbstractC12990fW7.m0(this);
        }
        this.i = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        U(false);
        if (this.n && this.m != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.m);
        }
        View view = this.l;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.i = false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.p || this.q == null) {
            return;
        }
        O98 o98 = this.o;
        int iM = o98 != null ? o98.m() : 0;
        if (iM > 0) {
            this.q.setBounds(0, 0, getWidth(), iM);
            this.q.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            U(true);
        }
        boolean zP = P(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            U(true);
        }
        return zP;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Behavior behaviorF;
        int iA = AbstractC12990fW7.A(this);
        int size = this.a.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = (View) this.a.get(i5);
            if (view.getVisibility() != 8 && ((behaviorF = ((e) view.getLayoutParams()).f()) == null || !behaviorF.l(this, view, iA))) {
                M(view, iA);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x011f  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r31, int r32) {
        /*
            Method dump skipped, instructions count: 393
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        Behavior behaviorF;
        int childCount = getChildCount();
        boolean zN = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.j(0) && (behaviorF = eVar.f()) != null) {
                    zN |= behaviorF.n(this, childAt, view, f2, f3, z);
                }
            }
        }
        if (zN) {
            L(1);
        }
        return zN;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f2, float f3) {
        Behavior behaviorF;
        int childCount = getChildCount();
        boolean zO = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.j(0) && (behaviorF = eVar.f()) != null) {
                    zO |= behaviorF.o(this, childAt, view, f2, f3);
                }
            }
        }
        return zO;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        p(view, i, i2, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        t(view, i, i2, i3, i4, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        h(view, view2, i, 0);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        SparseArray sparseArray = savedState.c;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            Behavior behaviorF = C(childAt).f();
            if (id != -1 && behaviorF != null && (parcelable2 = (Parcelable) sparseArray.get(id)) != null) {
                behaviorF.x(this, childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable parcelableY;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            Behavior behaviorF = ((e) childAt.getLayoutParams()).f();
            if (id != -1 && behaviorF != null && (parcelableY = behaviorF.y(this, childAt)) != null) {
                sparseArray.append(id, parcelableY);
            }
        }
        savedState.c = sparseArray;
        return savedState;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return v(view, view2, i, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        k(view, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015 A[PHI: r3
      0x0015: PHI (r3v4 boolean) = (r3v2 boolean), (r3v5 boolean) binds: [B:10:0x0024, B:5:0x0012] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r18.getActionMasked()
            android.view.View r3 = r0.k
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L17
            boolean r3 = r0.P(r1, r4)
            if (r3 == 0) goto L15
            goto L18
        L15:
            r6 = r5
            goto L2c
        L17:
            r3 = r5
        L18:
            android.view.View r6 = r0.k
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$e r6 = (androidx.coordinatorlayout.widget.CoordinatorLayout.e) r6
            androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r6 = r6.f()
            if (r6 == 0) goto L15
            android.view.View r7 = r0.k
            boolean r6 = r6.D(r0, r7, r1)
        L2c:
            android.view.View r7 = r0.k
            r8 = 0
            if (r7 != 0) goto L37
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L4a
        L37:
            if (r3 == 0) goto L4a
            long r11 = android.os.SystemClock.uptimeMillis()
            r15 = 0
            r16 = 0
            r13 = 3
            r14 = 0
            r9 = r11
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L4a:
            if (r8 == 0) goto L4f
            r8.recycle()
        L4f:
            if (r2 == r4) goto L54
            r1 = 3
            if (r2 != r1) goto L57
        L54:
            r0.U(r5)
        L57:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // ir.nasim.InterfaceC5510Jq4
    public void p(View view, int i, int i2, int[] iArr, int i3) {
        Behavior behaviorF;
        int childCount = getChildCount();
        boolean z = false;
        int iMax = 0;
        int iMax2 = 0;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.j(i3) && (behaviorF = eVar.f()) != null) {
                    int[] iArr2 = this.f;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    behaviorF.q(this, childAt, view, i, i2, iArr2, i3);
                    int[] iArr3 = this.f;
                    iMax = i > 0 ? Math.max(iMax, iArr3[0]) : Math.min(iMax, iArr3[0]);
                    int[] iArr4 = this.f;
                    iMax2 = i2 > 0 ? Math.max(iMax2, iArr4[1]) : Math.min(iMax2, iArr4[1]);
                    z = true;
                }
            }
        }
        iArr[0] = iMax;
        iArr[1] = iMax2;
        if (z) {
            L(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e ? new e((e) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new e((ViewGroup.MarginLayoutParams) layoutParams) : new e(layoutParams);
    }

    @Override // ir.nasim.InterfaceC5744Kq4
    public void r(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        Behavior behaviorF;
        boolean z;
        int iMin;
        int childCount = getChildCount();
        boolean z2 = false;
        int iMax = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.j(i5) && (behaviorF = eVar.f()) != null) {
                    int[] iArr2 = this.f;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    behaviorF.t(this, childAt, view, i, i2, i3, i4, i5, iArr2);
                    int[] iArr3 = this.f;
                    iMax = i3 > 0 ? Math.max(iMax, iArr3[0]) : Math.min(iMax, iArr3[0]);
                    if (i4 > 0) {
                        z = true;
                        iMin = Math.max(i6, this.f[1]);
                    } else {
                        z = true;
                        iMin = Math.min(i6, this.f[1]);
                    }
                    i6 = iMin;
                    z2 = z;
                }
            }
        }
        iArr[0] = iArr[0] + iMax;
        iArr[1] = iArr[1] + i6;
        if (z2) {
            L(1);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        Behavior behaviorF = ((e) view.getLayoutParams()).f();
        if (behaviorF == null || !behaviorF.w(this, view, rect, z)) {
            return super.requestChildRectangleOnScreen(view, rect, z);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (!z || this.h) {
            return;
        }
        U(false);
        this.h = true;
    }

    void s(View view, boolean z, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z) {
            x(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
        b0();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.r = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.q;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.q = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.q.setState(getDrawableState());
                }
                AbstractC21710u02.g(this.q, AbstractC12990fW7.A(this));
                this.q.setVisible(getVisibility() == 0, false);
                this.q.setCallback(this);
            }
            AbstractC12990fW7.g0(this);
        }
    }

    public void setStatusBarBackgroundColor(int i) {
        setStatusBarBackground(new ColorDrawable(i));
    }

    public void setStatusBarBackgroundResource(int i) {
        setStatusBarBackground(i != 0 ? AbstractC4043Dl1.f(getContext(), i) : null);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.q;
        if (drawable == null || drawable.isVisible() == z) {
            return;
        }
        this.q.setVisible(z, false);
    }

    @Override // ir.nasim.InterfaceC5510Jq4
    public void t(View view, int i, int i2, int i3, int i4, int i5) {
        r(view, i, i2, i3, i4, 0, this.g);
    }

    public List u(View view) {
        List listH = this.b.h(view);
        this.d.clear();
        if (listH != null) {
            this.d.addAll(listH);
        }
        return this.d;
    }

    @Override // ir.nasim.InterfaceC5510Jq4
    public boolean v(View view, View view2, int i, int i2) {
        int childCount = getChildCount();
        boolean z = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                Behavior behaviorF = eVar.f();
                if (behaviorF != null) {
                    boolean zA = behaviorF.A(this, childAt, view, view2, i, i2);
                    z |= zA;
                    eVar.r(i2, zA);
                } else {
                    eVar.r(i2, false);
                }
            }
        }
        return z;
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.q;
    }

    public List w(View view) {
        List listG = this.b.g(view);
        this.d.clear();
        if (listG != null) {
            this.d.addAll(listG);
        }
        return this.d;
    }

    void x(View view, Rect rect) {
        BW7.a(this, view, rect);
    }

    void y(View view, int i, Rect rect, Rect rect2) {
        e eVar = (e) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        z(view, i, rect, rect2, eVar, measuredWidth, measuredHeight);
        i(eVar, rect2, measuredWidth, measuredHeight);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC17563nA5.coordinatorLayoutStyle);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes;
        super(context, attributeSet, i);
        this.a = new ArrayList();
        this.b = new OT1();
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.f = new int[2];
        this.g = new int[2];
        this.t = new C5978Lq4(this);
        if (i == 0) {
            typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, TE5.CoordinatorLayout, 0, AbstractC19963rE5.Widget_Support_CoordinatorLayout);
        } else {
            typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, TE5.CoordinatorLayout, i, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            if (i == 0) {
                saveAttributeDataForStyleable(context, TE5.CoordinatorLayout, attributeSet, typedArrayObtainStyledAttributes, 0, AbstractC19963rE5.Widget_Support_CoordinatorLayout);
            } else {
                saveAttributeDataForStyleable(context, TE5.CoordinatorLayout, attributeSet, typedArrayObtainStyledAttributes, i, 0);
            }
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(TE5.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.j = resources.getIntArray(resourceId);
            float f2 = resources.getDisplayMetrics().density;
            int length = this.j.length;
            for (int i2 = 0; i2 < length; i2++) {
                this.j[i2] = (int) (r12[i2] * f2);
            }
        }
        this.q = typedArrayObtainStyledAttributes.getDrawable(TE5.CoordinatorLayout_statusBarBackground);
        typedArrayObtainStyledAttributes.recycle();
        b0();
        super.setOnHierarchyChangeListener(new d());
        if (AbstractC12990fW7.y(this) == 0) {
            AbstractC12990fW7.A0(this, 1);
        }
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        SparseArray c;

        static class a implements Parcelable.ClassLoaderCreator {
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
            int i = parcel.readInt();
            int[] iArr = new int[i];
            parcel.readIntArray(iArr);
            Parcelable[] parcelableArray = parcel.readParcelableArray(classLoader);
            this.c = new SparseArray(i);
            for (int i2 = 0; i2 < i; i2++) {
                this.c.append(iArr[i2], parcelableArray[i2]);
            }
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            SparseArray sparseArray = this.c;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i2 = 0; i2 < size; i2++) {
                iArr[i2] = this.c.keyAt(i2);
                parcelableArr[i2] = (Parcelable) this.c.valueAt(i2);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public static class e extends ViewGroup.MarginLayoutParams {
        Behavior a;
        boolean b;
        public int c;
        public int d;
        public int e;
        int f;
        public int g;
        public int h;
        int i;
        int j;
        View k;
        View l;
        private boolean m;
        private boolean n;
        private boolean o;
        private boolean p;
        final Rect q;
        Object r;

        public e(int i, int i2) {
            super(i, i2);
            this.b = false;
            this.c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.q = new Rect();
        }

        private void n(View view, CoordinatorLayout coordinatorLayout) {
            View viewFindViewById = coordinatorLayout.findViewById(this.f);
            this.k = viewFindViewById;
            if (viewFindViewById == null) {
                if (coordinatorLayout.isInEditMode()) {
                    this.l = null;
                    this.k = null;
                    return;
                }
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f) + " to anchor view " + view);
            }
            if (viewFindViewById == coordinatorLayout) {
                if (!coordinatorLayout.isInEditMode()) {
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
                this.l = null;
                this.k = null;
                return;
            }
            for (ViewParent parent = viewFindViewById.getParent(); parent != coordinatorLayout && parent != null; parent = parent.getParent()) {
                if (parent == view) {
                    if (!coordinatorLayout.isInEditMode()) {
                        throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                    }
                    this.l = null;
                    this.k = null;
                    return;
                }
                if (parent instanceof View) {
                    viewFindViewById = parent;
                }
            }
            this.l = viewFindViewById;
        }

        private boolean s(View view, int i) {
            int iB = YK2.b(((e) view.getLayoutParams()).g, i);
            return iB != 0 && (YK2.b(this.h, i) & iB) == iB;
        }

        private boolean t(View view, CoordinatorLayout coordinatorLayout) {
            if (this.k.getId() != this.f) {
                return false;
            }
            View view2 = this.k;
            for (ViewParent parent = view2.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent == null || parent == view) {
                    this.l = null;
                    this.k = null;
                    return false;
                }
                if (parent instanceof View) {
                    view2 = parent;
                }
            }
            this.l = view2;
            return true;
        }

        boolean a() {
            return this.k == null && this.f != -1;
        }

        boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            Behavior behavior;
            return view2 == this.l || s(view2, AbstractC12990fW7.A(coordinatorLayout)) || ((behavior = this.a) != null && behavior.e(coordinatorLayout, view, view2));
        }

        boolean c() {
            if (this.a == null) {
                this.m = false;
            }
            return this.m;
        }

        View d(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f == -1) {
                this.l = null;
                this.k = null;
                return null;
            }
            if (this.k == null || !t(view, coordinatorLayout)) {
                n(view, coordinatorLayout);
            }
            return this.k;
        }

        public int e() {
            return this.f;
        }

        public Behavior f() {
            return this.a;
        }

        boolean g() {
            return this.p;
        }

        Rect h() {
            return this.q;
        }

        boolean i(CoordinatorLayout coordinatorLayout, View view) {
            boolean z = this.m;
            if (z) {
                return true;
            }
            Behavior behavior = this.a;
            boolean zA = (behavior != null ? behavior.a(coordinatorLayout, view) : false) | z;
            this.m = zA;
            return zA;
        }

        boolean j(int i) {
            if (i == 0) {
                return this.n;
            }
            if (i != 1) {
                return false;
            }
            return this.o;
        }

        void k() {
            this.p = false;
        }

        void l(int i) {
            r(i, false);
        }

        void m() {
            this.m = false;
        }

        public void o(Behavior behavior) {
            Behavior behavior2 = this.a;
            if (behavior2 != behavior) {
                if (behavior2 != null) {
                    behavior2.j();
                }
                this.a = behavior;
                this.r = null;
                this.b = true;
                if (behavior != null) {
                    behavior.g(this);
                }
            }
        }

        void p(boolean z) {
            this.p = z;
        }

        void q(Rect rect) {
            this.q.set(rect);
        }

        void r(int i, boolean z) {
            if (i == 0) {
                this.n = z;
            } else {
                if (i != 1) {
                    return;
                }
                this.o = z;
            }
        }

        e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.b = false;
            this.c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.q = new Rect();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, TE5.CoordinatorLayout_Layout);
            this.c = typedArrayObtainStyledAttributes.getInteger(TE5.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.f = typedArrayObtainStyledAttributes.getResourceId(TE5.CoordinatorLayout_Layout_layout_anchor, -1);
            this.d = typedArrayObtainStyledAttributes.getInteger(TE5.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.e = typedArrayObtainStyledAttributes.getInteger(TE5.CoordinatorLayout_Layout_layout_keyline, -1);
            this.g = typedArrayObtainStyledAttributes.getInt(TE5.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.h = typedArrayObtainStyledAttributes.getInt(TE5.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(TE5.CoordinatorLayout_Layout_layout_behavior);
            this.b = zHasValue;
            if (zHasValue) {
                this.a = CoordinatorLayout.O(context, attributeSet, typedArrayObtainStyledAttributes.getString(TE5.CoordinatorLayout_Layout_layout_behavior));
            }
            typedArrayObtainStyledAttributes.recycle();
            Behavior behavior = this.a;
            if (behavior != null) {
                behavior.g(this);
            }
        }

        public e(e eVar) {
            super((ViewGroup.MarginLayoutParams) eVar);
            this.b = false;
            this.c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.q = new Rect();
        }

        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.b = false;
            this.c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.q = new Rect();
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.b = false;
            this.c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.q = new Rect();
        }
    }
}
