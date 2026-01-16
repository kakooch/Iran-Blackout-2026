package androidx.viewpager.widget;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.C22317v2;
import ir.nasim.InterfaceC22474vI4;
import ir.nasim.O98;
import ir.nasim.X2;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes2.dex */
public class ViewPager extends ViewGroup {
    static final int[] X0 = {R.attr.layout_gravity};
    private static final Comparator Y0 = new a();
    private static final Interpolator Z0 = new b();
    private static final m a1 = new m();
    private int A;
    private int A0;
    private int B;
    private VelocityTracker B0;
    private int C0;
    private int D;
    private int D0;
    private int E0;
    private int F0;
    private float G;
    private boolean G0;
    private float H;
    private EdgeEffect H0;
    private EdgeEffect I0;
    private float J;
    private boolean J0;
    private boolean K0;
    private boolean L0;
    private int M0;
    private List N0;
    private i O0;
    private i P0;
    private List Q0;
    private j R0;
    private int S0;
    private int T0;
    private ArrayList U0;
    private final Runnable V0;
    private int W0;
    private int a;
    private final ArrayList b;
    private final f c;
    private final Rect d;
    androidx.viewpager.widget.a e;
    int f;
    private int g;
    private Parcelable h;
    private ClassLoader i;
    private Scroller j;
    private boolean k;
    private k l;
    private int m;
    private Drawable n;
    private int o;
    private int p;
    private float q;
    private float r;
    private int s;
    private int t;
    private boolean u;
    private boolean v;
    private boolean w;
    private int x;
    private boolean y;
    private boolean z;
    private float z0;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        int c;
        Parcelable d;
        ClassLoader e;

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

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.c + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.c);
            parcel.writeParcelable(this.d, i);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.c = parcel.readInt();
            this.d = parcel.readParcelable(classLoader);
            this.e = classLoader;
        }
    }

    static class a implements Comparator {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(f fVar, f fVar2) {
            return fVar.b - fVar2.b;
        }
    }

    static class b implements Interpolator {
        b() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() throws Resources.NotFoundException {
            ViewPager.this.setScrollState(0);
            ViewPager.this.E();
        }
    }

    class d implements InterfaceC22474vI4 {
        private final Rect a = new Rect();

        d() {
        }

        @Override // ir.nasim.InterfaceC22474vI4
        public O98 b(View view, O98 o98) {
            O98 o98B0 = AbstractC12990fW7.b0(view, o98);
            if (o98B0.r()) {
                return o98B0;
            }
            Rect rect = this.a;
            rect.left = o98B0.k();
            rect.top = o98B0.m();
            rect.right = o98B0.l();
            rect.bottom = o98B0.j();
            int childCount = ViewPager.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                O98 o98G = AbstractC12990fW7.g(ViewPager.this.getChildAt(i), o98B0);
                rect.left = Math.min(o98G.k(), rect.left);
                rect.top = Math.min(o98G.m(), rect.top);
                rect.right = Math.min(o98G.l(), rect.right);
                rect.bottom = Math.min(o98G.j(), rect.bottom);
            }
            return o98B0.t(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface e {
    }

    static class f {
        Object a;
        int b;
        boolean c;
        float d;
        float e;

        f() {
        }
    }

    class g extends C22317v2 {
        g() {
        }

        private boolean n() {
            androidx.viewpager.widget.a aVar = ViewPager.this.e;
            return aVar != null && aVar.d() > 1;
        }

        @Override // ir.nasim.C22317v2
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            androidx.viewpager.widget.a aVar;
            super.f(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            accessibilityEvent.setScrollable(n());
            if (accessibilityEvent.getEventType() != 4096 || (aVar = ViewPager.this.e) == null) {
                return;
            }
            accessibilityEvent.setItemCount(aVar.d());
            accessibilityEvent.setFromIndex(ViewPager.this.f);
            accessibilityEvent.setToIndex(ViewPager.this.f);
        }

        @Override // ir.nasim.C22317v2
        public void g(View view, X2 x2) {
            super.g(view, x2);
            x2.p0(ViewPager.class.getName());
            x2.R0(n());
            if (ViewPager.this.canScrollHorizontally(1)) {
                x2.a(4096);
            }
            if (ViewPager.this.canScrollHorizontally(-1)) {
                x2.a(8192);
            }
        }

        @Override // ir.nasim.C22317v2
        public boolean j(View view, int i, Bundle bundle) throws Resources.NotFoundException {
            if (super.j(view, i, bundle)) {
                return true;
            }
            if (i == 4096) {
                if (!ViewPager.this.canScrollHorizontally(1)) {
                    return false;
                }
                ViewPager viewPager = ViewPager.this;
                viewPager.setCurrentItem(viewPager.f + 1);
                return true;
            }
            if (i != 8192 || !ViewPager.this.canScrollHorizontally(-1)) {
                return false;
            }
            ViewPager viewPager2 = ViewPager.this;
            viewPager2.setCurrentItem(viewPager2.f - 1);
            return true;
        }
    }

    public interface h {
        void b(ViewPager viewPager, androidx.viewpager.widget.a aVar, androidx.viewpager.widget.a aVar2);
    }

    public interface i {
        void a(int i, float f, int i2);

        void c(int i);

        void d(int i);
    }

    public interface j {
        void a(View view, float f);
    }

    private class k extends DataSetObserver {
        k() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() throws Resources.NotFoundException {
            ViewPager.this.h();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() throws Resources.NotFoundException {
            ViewPager.this.h();
        }
    }

    public static class l implements i {
        @Override // androidx.viewpager.widget.ViewPager.i
        public void a(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void c(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void d(int i) {
        }
    }

    static class m implements Comparator {
        m() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
            boolean z = layoutParams.a;
            return z != layoutParams2.a ? z ? 1 : -1 : layoutParams.e - layoutParams2.e;
        }
    }

    public ViewPager(Context context) {
        super(context);
        this.b = new ArrayList();
        this.c = new f();
        this.d = new Rect();
        this.g = -1;
        this.h = null;
        this.i = null;
        this.q = -3.4028235E38f;
        this.r = Float.MAX_VALUE;
        this.x = 1;
        this.A0 = -1;
        this.J0 = true;
        this.K0 = false;
        this.V0 = new c();
        this.W0 = 0;
        v();
    }

    private boolean C(int i2) {
        if (this.b.size() == 0) {
            if (this.J0) {
                return false;
            }
            this.L0 = false;
            y(0, 0.0f, 0);
            if (this.L0) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        f fVarT = t();
        int clientWidth = getClientWidth();
        int i3 = this.m;
        int i4 = clientWidth + i3;
        float f2 = clientWidth;
        int i5 = fVarT.b;
        float f3 = ((i2 / f2) - fVarT.e) / (fVarT.d + (i3 / f2));
        this.L0 = false;
        y(i5, f3, (int) (i4 * f3));
        if (this.L0) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private boolean D(float f2) {
        boolean z;
        boolean z2;
        float f3 = this.G - f2;
        this.G = f2;
        float scrollX = getScrollX() + f3;
        float clientWidth = getClientWidth();
        float f4 = this.q * clientWidth;
        float f5 = this.r * clientWidth;
        boolean z3 = false;
        f fVar = (f) this.b.get(0);
        ArrayList arrayList = this.b;
        f fVar2 = (f) arrayList.get(arrayList.size() - 1);
        if (fVar.b != 0) {
            f4 = fVar.e * clientWidth;
            z = false;
        } else {
            z = true;
        }
        if (fVar2.b != this.e.d() - 1) {
            f5 = fVar2.e * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (scrollX < f4) {
            if (z) {
                this.H0.onPull(Math.abs(f4 - scrollX) / clientWidth);
                z3 = true;
            }
            scrollX = f4;
        } else if (scrollX > f5) {
            if (z2) {
                this.I0.onPull(Math.abs(scrollX - f5) / clientWidth);
                z3 = true;
            }
            scrollX = f5;
        }
        int i2 = (int) scrollX;
        this.G += scrollX - i2;
        scrollTo(i2, getScrollY());
        C(i2);
        return z3;
    }

    private void G(int i2, int i3, int i4, int i5) {
        if (i3 > 0 && !this.b.isEmpty()) {
            if (!this.j.isFinished()) {
                this.j.setFinalX(getCurrentItem() * getClientWidth());
                return;
            } else {
                scrollTo((int) ((getScrollX() / (((i3 - getPaddingLeft()) - getPaddingRight()) + i5)) * (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)), getScrollY());
                return;
            }
        }
        f fVarU = u(this.f);
        int iMin = (int) ((fVarU != null ? Math.min(fVarU.e, this.r) : 0.0f) * ((i2 - getPaddingLeft()) - getPaddingRight()));
        if (iMin != getScrollX()) {
            g(false);
            scrollTo(iMin, getScrollY());
        }
    }

    private void H() {
        int i2 = 0;
        while (i2 < getChildCount()) {
            if (!((LayoutParams) getChildAt(i2).getLayoutParams()).a) {
                removeViewAt(i2);
                i2--;
            }
            i2++;
        }
    }

    private void K(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean L() {
        this.A0 = -1;
        o();
        this.H0.onRelease();
        this.I0.onRelease();
        return this.H0.isFinished() || this.I0.isFinished();
    }

    private void M(int i2, boolean z, int i3, boolean z2) throws Resources.NotFoundException {
        f fVarU = u(i2);
        int clientWidth = fVarU != null ? (int) (getClientWidth() * Math.max(this.q, Math.min(fVarU.e, this.r))) : 0;
        if (z) {
            Q(clientWidth, 0, i3);
            if (z2) {
                k(i2);
                return;
            }
            return;
        }
        if (z2) {
            k(i2);
        }
        g(false);
        scrollTo(clientWidth, 0);
        C(clientWidth);
    }

    private void R() {
        if (this.T0 != 0) {
            ArrayList arrayList = this.U0;
            if (arrayList == null) {
                this.U0 = new ArrayList();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                this.U0.add(getChildAt(i2));
            }
            Collections.sort(this.U0, a1);
        }
    }

    private void e(f fVar, int i2, f fVar2) {
        int i3;
        int i4;
        f fVar3;
        f fVar4;
        int iD = this.e.d();
        int clientWidth = getClientWidth();
        float f2 = clientWidth > 0 ? this.m / clientWidth : 0.0f;
        if (fVar2 != null) {
            int i5 = fVar2.b;
            int i6 = fVar.b;
            if (i5 < i6) {
                float fG = fVar2.e + fVar2.d + f2;
                int i7 = i5 + 1;
                int i8 = 0;
                while (i7 <= fVar.b && i8 < this.b.size()) {
                    Object obj = this.b.get(i8);
                    while (true) {
                        fVar4 = (f) obj;
                        if (i7 <= fVar4.b || i8 >= this.b.size() - 1) {
                            break;
                        }
                        i8++;
                        obj = this.b.get(i8);
                    }
                    while (i7 < fVar4.b) {
                        fG += this.e.g(i7) + f2;
                        i7++;
                    }
                    fVar4.e = fG;
                    fG += fVar4.d + f2;
                    i7++;
                }
            } else if (i5 > i6) {
                int size = this.b.size() - 1;
                float fG2 = fVar2.e;
                while (true) {
                    i5--;
                    if (i5 < fVar.b || size < 0) {
                        break;
                    }
                    Object obj2 = this.b.get(size);
                    while (true) {
                        fVar3 = (f) obj2;
                        if (i5 >= fVar3.b || size <= 0) {
                            break;
                        }
                        size--;
                        obj2 = this.b.get(size);
                    }
                    while (i5 > fVar3.b) {
                        fG2 -= this.e.g(i5) + f2;
                        i5--;
                    }
                    fG2 -= fVar3.d + f2;
                    fVar3.e = fG2;
                }
            }
        }
        int size2 = this.b.size();
        float fG3 = fVar.e;
        int i9 = fVar.b;
        int i10 = i9 - 1;
        this.q = i9 == 0 ? fG3 : -3.4028235E38f;
        int i11 = iD - 1;
        this.r = i9 == i11 ? (fVar.d + fG3) - 1.0f : Float.MAX_VALUE;
        int i12 = i2 - 1;
        while (i12 >= 0) {
            f fVar5 = (f) this.b.get(i12);
            while (true) {
                i4 = fVar5.b;
                if (i10 <= i4) {
                    break;
                }
                fG3 -= this.e.g(i10) + f2;
                i10--;
            }
            fG3 -= fVar5.d + f2;
            fVar5.e = fG3;
            if (i4 == 0) {
                this.q = fG3;
            }
            i12--;
            i10--;
        }
        float fG4 = fVar.e + fVar.d + f2;
        int i13 = fVar.b + 1;
        int i14 = i2 + 1;
        while (i14 < size2) {
            f fVar6 = (f) this.b.get(i14);
            while (true) {
                i3 = fVar6.b;
                if (i13 >= i3) {
                    break;
                }
                fG4 += this.e.g(i13) + f2;
                i13++;
            }
            if (i3 == i11) {
                this.r = (fVar6.d + fG4) - 1.0f;
            }
            fVar6.e = fG4;
            fG4 += fVar6.d + f2;
            i14++;
            i13++;
        }
        this.K0 = false;
    }

    private void g(boolean z) {
        boolean z2 = this.W0 == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            if (!this.j.isFinished()) {
                this.j.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.j.getCurrX();
                int currY = this.j.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        C(currX);
                    }
                }
            }
        }
        this.w = false;
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            f fVar = (f) this.b.get(i2);
            if (fVar.c) {
                fVar.c = false;
                z2 = true;
            }
        }
        if (z2) {
            if (z) {
                AbstractC12990fW7.h0(this, this.V0);
            } else {
                this.V0.run();
            }
        }
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private int i(int i2, float f2, int i3, int i4) {
        if (Math.abs(i4) <= this.E0 || Math.abs(i3) <= this.C0) {
            i2 += (int) (f2 + (i2 >= this.f ? 0.4f : 0.6f));
        } else if (i3 <= 0) {
            i2++;
        }
        if (this.b.size() <= 0) {
            return i2;
        }
        return Math.max(((f) this.b.get(0)).b, Math.min(i2, ((f) this.b.get(r4.size() - 1)).b));
    }

    private void j(int i2, float f2, int i3) {
        i iVar = this.O0;
        if (iVar != null) {
            iVar.a(i2, f2, i3);
        }
        List list = this.N0;
        if (list != null) {
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                i iVar2 = (i) this.N0.get(i4);
                if (iVar2 != null) {
                    iVar2.a(i2, f2, i3);
                }
            }
        }
        i iVar3 = this.P0;
        if (iVar3 != null) {
            iVar3.a(i2, f2, i3);
        }
    }

    private void k(int i2) {
        i iVar = this.O0;
        if (iVar != null) {
            iVar.d(i2);
        }
        List list = this.N0;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                i iVar2 = (i) this.N0.get(i3);
                if (iVar2 != null) {
                    iVar2.d(i2);
                }
            }
        }
        i iVar3 = this.P0;
        if (iVar3 != null) {
            iVar3.d(i2);
        }
    }

    private void l(int i2) {
        i iVar = this.O0;
        if (iVar != null) {
            iVar.c(i2);
        }
        List list = this.N0;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                i iVar2 = (i) this.N0.get(i3);
                if (iVar2 != null) {
                    iVar2.c(i2);
                }
            }
        }
        i iVar3 = this.P0;
        if (iVar3 != null) {
            iVar3.c(i2);
        }
    }

    private void n(boolean z) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            getChildAt(i2).setLayerType(z ? this.S0 : 0, null);
        }
    }

    private void o() {
        this.y = false;
        this.z = false;
        VelocityTracker velocityTracker = this.B0;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.B0 = null;
        }
    }

    private Rect q(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.v != z) {
            this.v = z;
        }
    }

    private f t() {
        int i2;
        int clientWidth = getClientWidth();
        float f2 = 0.0f;
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f3 = clientWidth > 0 ? this.m / clientWidth : 0.0f;
        int i3 = 0;
        boolean z = true;
        f fVar = null;
        int i4 = -1;
        float f4 = 0.0f;
        while (i3 < this.b.size()) {
            f fVar2 = (f) this.b.get(i3);
            if (!z && fVar2.b != (i2 = i4 + 1)) {
                fVar2 = this.c;
                fVar2.e = f2 + f4 + f3;
                fVar2.b = i2;
                fVar2.d = this.e.g(i2);
                i3--;
            }
            f fVar3 = fVar2;
            f2 = fVar3.e;
            float f5 = fVar3.d + f2 + f3;
            if (!z && scrollX < f2) {
                return fVar;
            }
            if (scrollX < f5 || i3 == this.b.size() - 1) {
                return fVar3;
            }
            int i5 = fVar3.b;
            float f6 = fVar3.d;
            i3++;
            z = false;
            i4 = i5;
            f4 = f6;
            fVar = fVar3;
        }
        return fVar;
    }

    private static boolean w(View view) {
        return view.getClass().getAnnotation(e.class) != null;
    }

    private boolean x(float f2, float f3) {
        return (f2 < ((float) this.B) && f3 > 0.0f) || (f2 > ((float) (getWidth() - this.B)) && f3 < 0.0f);
    }

    private void z(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.A0) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.G = motionEvent.getX(i2);
            this.A0 = motionEvent.getPointerId(i2);
            VelocityTracker velocityTracker = this.B0;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    boolean A() throws Resources.NotFoundException {
        int i2 = this.f;
        if (i2 <= 0) {
            return false;
        }
        setCurrentItem(i2 - 1, true);
        return true;
    }

    boolean B() throws Resources.NotFoundException {
        androidx.viewpager.widget.a aVar = this.e;
        if (aVar == null || this.f >= aVar.d() - 1) {
            return false;
        }
        setCurrentItem(this.f + 1, true);
        return true;
    }

    void E() throws Resources.NotFoundException {
        F(this.f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0066, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00cb A[PHI: r7 r10 r15
      0x00cb: PHI (r7v6 int) = (r7v5 int), (r7v4 int), (r7v9 int) binds: [B:64:0x00ef, B:61:0x00d9, B:53:0x00c0] A[DONT_GENERATE, DONT_INLINE]
      0x00cb: PHI (r10v9 int) = (r10v1 int), (r10v8 int), (r10v12 int) binds: [B:64:0x00ef, B:61:0x00d9, B:53:0x00c0] A[DONT_GENERATE, DONT_INLINE]
      0x00cb: PHI (r15v7 float) = (r15v5 float), (r15v6 float), (r15v4 float) binds: [B:64:0x00ef, B:61:0x00d9, B:53:0x00c0] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void F(int r18) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 615
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.F(int):void");
    }

    public void I(h hVar) {
        List list = this.Q0;
        if (list != null) {
            list.remove(hVar);
        }
    }

    public void J(i iVar) {
        List list = this.N0;
        if (list != null) {
            list.remove(iVar);
        }
    }

    void N(int i2, boolean z, boolean z2) throws Resources.NotFoundException {
        O(i2, z, z2, 0);
    }

    void O(int i2, boolean z, boolean z2, int i3) throws Resources.NotFoundException {
        androidx.viewpager.widget.a aVar = this.e;
        if (aVar == null || aVar.d() <= 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (!z2 && this.f == i2 && this.b.size() != 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        } else if (i2 >= this.e.d()) {
            i2 = this.e.d() - 1;
        }
        int i4 = this.x;
        int i5 = this.f;
        if (i2 > i5 + i4 || i2 < i5 - i4) {
            for (int i6 = 0; i6 < this.b.size(); i6++) {
                ((f) this.b.get(i6)).c = true;
            }
        }
        boolean z3 = this.f != i2;
        if (!this.J0) {
            F(i2);
            M(i2, z, i3, z3);
        } else {
            this.f = i2;
            if (z3) {
                k(i2);
            }
            requestLayout();
        }
    }

    i P(i iVar) {
        i iVar2 = this.P0;
        this.P0 = iVar;
        return iVar2;
    }

    void Q(int i2, int i3, int i4) throws Resources.NotFoundException {
        int scrollX;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.j;
        if (scroller == null || scroller.isFinished()) {
            scrollX = getScrollX();
        } else {
            scrollX = this.k ? this.j.getCurrX() : this.j.getStartX();
            this.j.abortAnimation();
            setScrollingCacheEnabled(false);
        }
        int i5 = scrollX;
        int scrollY = getScrollY();
        int i6 = i2 - i5;
        int i7 = i3 - scrollY;
        if (i6 == 0 && i7 == 0) {
            g(false);
            E();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i8 = clientWidth / 2;
        float f2 = clientWidth;
        float f3 = i8;
        float fM = f3 + (m(Math.min(1.0f, (Math.abs(i6) * 1.0f) / f2)) * f3);
        int iAbs = Math.abs(i4);
        int iMin = Math.min(iAbs > 0 ? Math.round(Math.abs(fM / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i6) / ((f2 * this.e.g(this.f)) + this.m)) + 1.0f) * 100.0f), SetRpcStruct$ComposedRpc.GET_JWT_TOKEN_FIELD_NUMBER);
        this.k = false;
        this.j.startScroll(i5, scrollY, i6, i7, iMin);
        AbstractC12990fW7.g0(this);
    }

    f a(int i2, int i3) {
        f fVar = new f();
        fVar.b = i2;
        fVar.a = this.e.h(this, i2);
        fVar.d = this.e.g(i2);
        if (i3 < 0 || i3 >= this.b.size()) {
            this.b.add(fVar);
        } else {
            this.b.add(i3, fVar);
        }
        return fVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList arrayList, int i2, int i3) {
        f fVarS;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getVisibility() == 0 && (fVarS = s(childAt)) != null && fVarS.b == this.f) {
                    childAt.addFocusables(arrayList, i2, i3);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if ((i3 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList arrayList) {
        f fVarS;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (fVarS = s(childAt)) != null && fVarS.b == this.f) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        boolean zW = layoutParams2.a | w(view);
        layoutParams2.a = zW;
        if (!this.u) {
            super.addView(view, i2, layoutParams);
        } else {
            if (zW) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            layoutParams2.d = true;
            addViewInLayout(view, i2, layoutParams);
        }
    }

    public void b(h hVar) {
        if (this.Q0 == null) {
            this.Q0 = new ArrayList();
        }
        this.Q0.add(hVar);
    }

    public void c(i iVar) {
        if (this.N0 == null) {
            this.N0 = new ArrayList();
        }
        this.N0.add(iVar);
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i2) {
        if (this.e == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        return i2 < 0 ? scrollX > ((int) (((float) clientWidth) * this.q)) : i2 > 0 && scrollX < ((int) (((float) clientWidth) * this.r));
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        this.k = true;
        if (this.j.isFinished() || !this.j.computeScrollOffset()) {
            g(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.j.getCurrX();
        int currY = this.j.getCurrY();
        if (scrollX != currX || scrollY != currY) {
            scrollTo(currX, currY);
            if (!C(currX)) {
                this.j.abortAnimation();
                scrollTo(0, currY);
            }
        }
        AbstractC12990fW7.g0(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean d(int r5) {
        /*
            r4 = this;
            android.view.View r0 = r4.findFocus()
            r1 = 0
            if (r0 != r4) goto L9
        L7:
            r0 = r1
            goto L63
        L9:
            if (r0 == 0) goto L63
            android.view.ViewParent r2 = r0.getParent()
        Lf:
            boolean r3 = r2 instanceof android.view.ViewGroup
            if (r3 == 0) goto L1b
            if (r2 != r4) goto L16
            goto L63
        L16:
            android.view.ViewParent r2 = r2.getParent()
            goto Lf
        L1b:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.Class r3 = r0.getClass()
            java.lang.String r3 = r3.getSimpleName()
            r2.append(r3)
            android.view.ViewParent r0 = r0.getParent()
        L2f:
            boolean r3 = r0 instanceof android.view.ViewGroup
            if (r3 == 0) goto L48
            java.lang.String r3 = " => "
            r2.append(r3)
            java.lang.Class r3 = r0.getClass()
            java.lang.String r3 = r3.getSimpleName()
            r2.append(r3)
            android.view.ViewParent r0 = r0.getParent()
            goto L2f
        L48:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "arrowScroll tried to find focus based on non-child current focused view "
            r0.append(r3)
            java.lang.String r2 = r2.toString()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "ViewPager"
            android.util.Log.e(r2, r0)
            goto L7
        L63:
            android.view.FocusFinder r1 = android.view.FocusFinder.getInstance()
            android.view.View r1 = r1.findNextFocus(r4, r0, r5)
            r2 = 66
            r3 = 17
            if (r1 == 0) goto Lb3
            if (r1 == r0) goto Lb3
            if (r5 != r3) goto L93
            android.graphics.Rect r2 = r4.d
            android.graphics.Rect r2 = r4.q(r2, r1)
            int r2 = r2.left
            android.graphics.Rect r3 = r4.d
            android.graphics.Rect r3 = r4.q(r3, r0)
            int r3 = r3.left
            if (r0 == 0) goto L8e
            if (r2 < r3) goto L8e
            boolean r0 = r4.A()
            goto Lca
        L8e:
            boolean r0 = r1.requestFocus()
            goto Lca
        L93:
            if (r5 != r2) goto Lbf
            android.graphics.Rect r2 = r4.d
            android.graphics.Rect r2 = r4.q(r2, r1)
            int r2 = r2.left
            android.graphics.Rect r3 = r4.d
            android.graphics.Rect r3 = r4.q(r3, r0)
            int r3 = r3.left
            if (r0 == 0) goto Lae
            if (r2 > r3) goto Lae
            boolean r0 = r4.B()
            goto Lca
        Lae:
            boolean r0 = r1.requestFocus()
            goto Lca
        Lb3:
            if (r5 == r3) goto Lc6
            r0 = 1
            if (r5 != r0) goto Lb9
            goto Lc6
        Lb9:
            if (r5 == r2) goto Lc1
            r0 = 2
            if (r5 != r0) goto Lbf
            goto Lc1
        Lbf:
            r0 = 0
            goto Lca
        Lc1:
            boolean r0 = r4.B()
            goto Lca
        Lc6:
            boolean r0 = r4.A()
        Lca:
            if (r0 == 0) goto Ld3
            int r5 = android.view.SoundEffectConstants.getContantForFocusDirection(r5)
            r4.playSoundEffect(r5)
        Ld3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.d(int):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || p(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        f fVarS;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (fVarS = s(childAt)) != null && fVarS.b == this.f && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        androidx.viewpager.widget.a aVar;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean zDraw = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (aVar = this.e) != null && aVar.d() > 1)) {
            if (!this.H0.isFinished()) {
                int iSave = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), this.q * width);
                this.H0.setSize(height, width);
                zDraw = this.H0.draw(canvas);
                canvas.restoreToCount(iSave);
            }
            if (!this.I0.isFinished()) {
                int iSave2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.r + 1.0f)) * width2);
                this.I0.setSize(height2, width2);
                zDraw |= this.I0.draw(canvas);
                canvas.restoreToCount(iSave2);
            }
        } else {
            this.H0.finish();
            this.I0.finish();
        }
        if (zDraw) {
            AbstractC12990fW7.g0(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.n;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    protected boolean f(View view, boolean z, int i2, int i3, int i4) {
        int i5;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i6 = i3 + scrollX;
                if (i6 >= childAt.getLeft() && i6 < childAt.getRight() && (i5 = i4 + scrollY) >= childAt.getTop() && i5 < childAt.getBottom() && f(childAt, true, i2, i6 - childAt.getLeft(), i5 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && view.canScrollHorizontally(-i2);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public androidx.viewpager.widget.a getAdapter() {
        return this.e;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i2, int i3) {
        if (this.T0 == 2) {
            i3 = (i2 - 1) - i3;
        }
        return ((LayoutParams) ((View) this.U0.get(i3)).getLayoutParams()).f;
    }

    public int getCurrentItem() {
        return this.f;
    }

    public int getOffscreenPageLimit() {
        return this.x;
    }

    public int getPageMargin() {
        return this.m;
    }

    void h() throws Resources.NotFoundException {
        int iD = this.e.d();
        this.a = iD;
        boolean z = this.b.size() < (this.x * 2) + 1 && this.b.size() < iD;
        int iMax = this.f;
        int i2 = 0;
        boolean z2 = false;
        while (i2 < this.b.size()) {
            f fVar = (f) this.b.get(i2);
            int iE = this.e.e(fVar.a);
            if (iE != -1) {
                if (iE == -2) {
                    this.b.remove(i2);
                    i2--;
                    if (!z2) {
                        this.e.r(this);
                        z2 = true;
                    }
                    this.e.a(this, fVar.b, fVar.a);
                    int i3 = this.f;
                    if (i3 == fVar.b) {
                        iMax = Math.max(0, Math.min(i3, iD - 1));
                    }
                } else {
                    int i4 = fVar.b;
                    if (i4 != iE) {
                        if (i4 == this.f) {
                            iMax = iE;
                        }
                        fVar.b = iE;
                    }
                }
                z = true;
            }
            i2++;
        }
        if (z2) {
            this.e.c(this);
        }
        Collections.sort(this.b, Y0);
        if (z) {
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i5).getLayoutParams();
                if (!layoutParams.a) {
                    layoutParams.c = 0.0f;
                }
            }
            N(iMax, false, true);
            requestLayout();
        }
    }

    float m(float f2) {
        return (float) Math.sin((f2 - 0.5f) * 0.47123894f);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.J0 = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.V0);
        Scroller scroller = this.j;
        if (scroller != null && !scroller.isFinished()) {
            this.j.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i2;
        float f2;
        float f3;
        super.onDraw(canvas);
        if (this.m <= 0 || this.n == null || this.b.size() <= 0 || this.e == null) {
            return;
        }
        int scrollX = getScrollX();
        float width = getWidth();
        float f4 = this.m / width;
        int i3 = 0;
        f fVar = (f) this.b.get(0);
        float f5 = fVar.e;
        int size = this.b.size();
        int i4 = fVar.b;
        int i5 = ((f) this.b.get(size - 1)).b;
        while (i4 < i5) {
            while (true) {
                i2 = fVar.b;
                if (i4 <= i2 || i3 >= size) {
                    break;
                }
                i3++;
                fVar = (f) this.b.get(i3);
            }
            if (i4 == i2) {
                float f6 = fVar.e;
                float f7 = fVar.d;
                f2 = (f6 + f7) * width;
                f5 = f6 + f7 + f4;
            } else {
                float fG = this.e.g(i4);
                f2 = (f5 + fG) * width;
                f5 += fG + f4;
            }
            if (this.m + f2 > scrollX) {
                f3 = f4;
                this.n.setBounds(Math.round(f2), this.o, Math.round(this.m + f2), this.p);
                this.n.draw(canvas);
            } else {
                f3 = f4;
            }
            if (f2 > scrollX + r2) {
                return;
            }
            i4++;
            f4 = f3;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) throws Resources.NotFoundException {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            L();
            return false;
        }
        if (action != 0) {
            if (this.y) {
                return true;
            }
            if (this.z) {
                return false;
            }
        }
        if (action == 0) {
            float x = motionEvent.getX();
            this.J = x;
            this.G = x;
            float y = motionEvent.getY();
            this.z0 = y;
            this.H = y;
            this.A0 = motionEvent.getPointerId(0);
            this.z = false;
            this.k = true;
            this.j.computeScrollOffset();
            if (this.W0 != 2 || Math.abs(this.j.getFinalX() - this.j.getCurrX()) <= this.F0) {
                g(false);
                this.y = false;
            } else {
                this.j.abortAnimation();
                this.w = false;
                E();
                this.y = true;
                K(true);
                setScrollState(1);
            }
        } else if (action == 2) {
            int i2 = this.A0;
            if (i2 != -1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i2);
                float x2 = motionEvent.getX(iFindPointerIndex);
                float f2 = x2 - this.G;
                float fAbs = Math.abs(f2);
                float y2 = motionEvent.getY(iFindPointerIndex);
                float fAbs2 = Math.abs(y2 - this.z0);
                if (f2 != 0.0f && !x(this.G, f2) && f(this, false, (int) f2, (int) x2, (int) y2)) {
                    this.G = x2;
                    this.H = y2;
                    this.z = true;
                    return false;
                }
                int i3 = this.D;
                if (fAbs > i3 && fAbs * 0.5f > fAbs2) {
                    this.y = true;
                    K(true);
                    setScrollState(1);
                    float f3 = this.J;
                    float f4 = this.D;
                    this.G = f2 > 0.0f ? f3 + f4 : f3 - f4;
                    this.H = y2;
                    setScrollingCacheEnabled(true);
                } else if (fAbs2 > i3) {
                    this.z = true;
                }
                if (this.y && D(x2)) {
                    AbstractC12990fW7.g0(this);
                }
            }
        } else if (action == 6) {
            z(motionEvent);
        }
        if (this.B0 == null) {
            this.B0 = VelocityTracker.obtain();
        }
        this.B0.addMovement(motionEvent);
        return this.y;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0094  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onLayout(boolean r19, int r20, int r21, int r22, int r23) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) throws Resources.NotFoundException {
        LayoutParams layoutParams;
        LayoutParams layoutParams2;
        int i4;
        setMeasuredDimension(View.getDefaultSize(0, i2), View.getDefaultSize(0, i3));
        int measuredWidth = getMeasuredWidth();
        this.B = Math.min(measuredWidth / 10, this.A);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i5 = 0;
        while (true) {
            boolean z = true;
            int i6 = 1073741824;
            if (i5 >= childCount) {
                break;
            }
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8 && (layoutParams2 = (LayoutParams) childAt.getLayoutParams()) != null && layoutParams2.a) {
                int i7 = layoutParams2.b;
                int i8 = i7 & 7;
                int i9 = i7 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER;
                boolean z2 = i9 == 48 || i9 == 80;
                if (i8 != 3 && i8 != 5) {
                    z = false;
                }
                int i10 = RecyclerView.UNDEFINED_DURATION;
                if (z2) {
                    i4 = Integer.MIN_VALUE;
                    i10 = 1073741824;
                } else {
                    i4 = z ? 1073741824 : Integer.MIN_VALUE;
                }
                int i11 = ((ViewGroup.LayoutParams) layoutParams2).width;
                if (i11 != -2) {
                    if (i11 == -1) {
                        i11 = paddingLeft;
                    }
                    i10 = 1073741824;
                } else {
                    i11 = paddingLeft;
                }
                int i12 = ((ViewGroup.LayoutParams) layoutParams2).height;
                if (i12 == -2) {
                    i12 = measuredHeight;
                    i6 = i4;
                } else if (i12 == -1) {
                    i12 = measuredHeight;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i11, i10), View.MeasureSpec.makeMeasureSpec(i12, i6));
                if (z2) {
                    measuredHeight -= childAt.getMeasuredHeight();
                } else if (z) {
                    paddingLeft -= childAt.getMeasuredWidth();
                }
            }
            i5++;
        }
        this.s = View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.t = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.u = true;
        E();
        this.u = false;
        int childCount2 = getChildCount();
        for (int i13 = 0; i13 < childCount2; i13++) {
            View childAt2 = getChildAt(i13);
            if (childAt2.getVisibility() != 8 && ((layoutParams = (LayoutParams) childAt2.getLayoutParams()) == null || !layoutParams.a)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (paddingLeft * layoutParams.c), 1073741824), this.t);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i2, Rect rect) {
        int i3;
        int i4;
        int i5;
        f fVarS;
        int childCount = getChildCount();
        if ((i2 & 2) != 0) {
            i4 = childCount;
            i3 = 0;
            i5 = 1;
        } else {
            i3 = childCount - 1;
            i4 = -1;
            i5 = -1;
        }
        while (i3 != i4) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 0 && (fVarS = s(childAt)) != null && fVarS.b == this.f && childAt.requestFocus(i2, rect)) {
                return true;
            }
            i3 += i5;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) throws Resources.NotFoundException {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        androidx.viewpager.widget.a aVar = this.e;
        if (aVar != null) {
            aVar.l(savedState.d, savedState.e);
            N(savedState.c, false, true);
        } else {
            this.g = savedState.c;
            this.h = savedState.d;
            this.i = savedState.e;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.c = this.f;
        androidx.viewpager.widget.a aVar = this.e;
        if (aVar != null) {
            savedState.d = aVar.m();
        }
        return savedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4) {
            int i6 = this.m;
            G(i2, i4, i6, i6);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00dc  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r8) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 351
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean p(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 21) {
                return keyEvent.hasModifiers(2) ? A() : d(17);
            }
            if (keyCode == 22) {
                return keyEvent.hasModifiers(2) ? B() : d(66);
            }
            if (keyCode == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return d(2);
                }
                if (keyEvent.hasModifiers(1)) {
                    return d(1);
                }
            }
        }
        return false;
    }

    f r(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent == this) {
                return s(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.u) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    f s(View view) {
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            f fVar = (f) this.b.get(i2);
            if (this.e.i(view, fVar.a)) {
                return fVar;
            }
        }
        return null;
    }

    public void setAdapter(androidx.viewpager.widget.a aVar) throws Resources.NotFoundException {
        androidx.viewpager.widget.a aVar2 = this.e;
        if (aVar2 != null) {
            aVar2.p(null);
            this.e.r(this);
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                f fVar = (f) this.b.get(i2);
                this.e.a(this, fVar.b, fVar.a);
            }
            this.e.c(this);
            this.b.clear();
            H();
            this.f = 0;
            scrollTo(0, 0);
        }
        androidx.viewpager.widget.a aVar3 = this.e;
        this.e = aVar;
        this.a = 0;
        if (aVar != null) {
            if (this.l == null) {
                this.l = new k();
            }
            this.e.p(this.l);
            this.w = false;
            boolean z = this.J0;
            this.J0 = true;
            this.a = this.e.d();
            if (this.g >= 0) {
                this.e.l(this.h, this.i);
                N(this.g, false, true);
                this.g = -1;
                this.h = null;
                this.i = null;
            } else if (z) {
                requestLayout();
            } else {
                E();
            }
        }
        List list = this.Q0;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.Q0.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((h) this.Q0.get(i3)).b(this, aVar3, aVar);
        }
    }

    public void setCurrentItem(int i2) throws Resources.NotFoundException {
        this.w = false;
        N(i2, !this.J0, false);
    }

    public void setOffscreenPageLimit(int i2) throws Resources.NotFoundException {
        if (i2 < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i2 + " too small; defaulting to 1");
            i2 = 1;
        }
        if (i2 != this.x) {
            this.x = i2;
            E();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(i iVar) {
        this.O0 = iVar;
    }

    public void setPageMargin(int i2) {
        int i3 = this.m;
        this.m = i2;
        int width = getWidth();
        G(width, width, i2, i3);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.n = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageTransformer(boolean z, j jVar) throws Resources.NotFoundException {
        setPageTransformer(z, jVar, 2);
    }

    void setScrollState(int i2) {
        if (this.W0 == i2) {
            return;
        }
        this.W0 = i2;
        if (this.R0 != null) {
            n(i2 != 0);
        }
        l(i2);
    }

    f u(int i2) {
        for (int i3 = 0; i3 < this.b.size(); i3++) {
            f fVar = (f) this.b.get(i3);
            if (fVar.b == i2) {
                return fVar;
            }
        }
        return null;
    }

    void v() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.j = new Scroller(context, Z0);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.D = viewConfiguration.getScaledPagingTouchSlop();
        this.C0 = (int) (400.0f * f2);
        this.D0 = viewConfiguration.getScaledMaximumFlingVelocity();
        this.H0 = new EdgeEffect(context);
        this.I0 = new EdgeEffect(context);
        this.E0 = (int) (25.0f * f2);
        this.F0 = (int) (2.0f * f2);
        this.A = (int) (f2 * 16.0f);
        AbstractC12990fW7.p0(this, new g());
        if (AbstractC12990fW7.y(this) == 0) {
            AbstractC12990fW7.A0(this, 1);
        }
        AbstractC12990fW7.E0(this, new d());
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.n;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void y(int r13, float r14, int r15) {
        /*
            r12 = this;
            int r0 = r12.M0
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto L6c
            int r0 = r12.getScrollX()
            int r3 = r12.getPaddingLeft()
            int r4 = r12.getPaddingRight()
            int r5 = r12.getWidth()
            int r6 = r12.getChildCount()
            r7 = r1
        L1b:
            if (r7 >= r6) goto L6c
            android.view.View r8 = r12.getChildAt(r7)
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            androidx.viewpager.widget.ViewPager$LayoutParams r9 = (androidx.viewpager.widget.ViewPager.LayoutParams) r9
            boolean r10 = r9.a
            if (r10 != 0) goto L2c
            goto L69
        L2c:
            int r9 = r9.b
            r9 = r9 & 7
            if (r9 == r2) goto L50
            r10 = 3
            if (r9 == r10) goto L4a
            r10 = 5
            if (r9 == r10) goto L3a
            r9 = r3
            goto L5d
        L3a:
            int r9 = r5 - r4
            int r10 = r8.getMeasuredWidth()
            int r9 = r9 - r10
            int r10 = r8.getMeasuredWidth()
            int r4 = r4 + r10
        L46:
            r11 = r9
            r9 = r3
            r3 = r11
            goto L5d
        L4a:
            int r9 = r8.getWidth()
            int r9 = r9 + r3
            goto L5d
        L50:
            int r9 = r8.getMeasuredWidth()
            int r9 = r5 - r9
            int r9 = r9 / 2
            int r9 = java.lang.Math.max(r9, r3)
            goto L46
        L5d:
            int r3 = r3 + r0
            int r10 = r8.getLeft()
            int r3 = r3 - r10
            if (r3 == 0) goto L68
            r8.offsetLeftAndRight(r3)
        L68:
            r3 = r9
        L69:
            int r7 = r7 + 1
            goto L1b
        L6c:
            r12.j(r13, r14, r15)
            androidx.viewpager.widget.ViewPager$j r13 = r12.R0
            if (r13 == 0) goto La0
            int r13 = r12.getScrollX()
            int r14 = r12.getChildCount()
        L7b:
            if (r1 >= r14) goto La0
            android.view.View r15 = r12.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r0 = r15.getLayoutParams()
            androidx.viewpager.widget.ViewPager$LayoutParams r0 = (androidx.viewpager.widget.ViewPager.LayoutParams) r0
            boolean r0 = r0.a
            if (r0 == 0) goto L8c
            goto L9d
        L8c:
            int r0 = r15.getLeft()
            int r0 = r0 - r13
            float r0 = (float) r0
            int r3 = r12.getClientWidth()
            float r3 = (float) r3
            float r0 = r0 / r3
            androidx.viewpager.widget.ViewPager$j r3 = r12.R0
            r3.a(r15, r0)
        L9d:
            int r1 = r1 + 1
            goto L7b
        La0:
            r12.L0 = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.y(int, float, int):void");
    }

    public static class LayoutParams extends ViewGroup.LayoutParams {
        public boolean a;
        public int b;
        float c;
        boolean d;
        int e;
        int f;

        public LayoutParams() {
            super(-1, -1);
            this.c = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.c = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.X0);
            this.b = typedArrayObtainStyledAttributes.getInteger(0, 48);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void setPageTransformer(boolean z, j jVar, int i2) throws Resources.NotFoundException {
        boolean z2 = jVar != null;
        boolean z3 = z2 != (this.R0 != null);
        this.R0 = jVar;
        setChildrenDrawingOrderEnabled(z2);
        if (z2) {
            this.T0 = z ? 2 : 1;
            this.S0 = i2;
        } else {
            this.T0 = 0;
        }
        if (z3) {
            E();
        }
    }

    public void setCurrentItem(int i2, boolean z) throws Resources.NotFoundException {
        this.w = false;
        N(i2, z, false);
    }

    public void setPageMarginDrawable(int i2) {
        setPageMarginDrawable(AbstractC4043Dl1.f(getContext(), i2));
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new ArrayList();
        this.c = new f();
        this.d = new Rect();
        this.g = -1;
        this.h = null;
        this.i = null;
        this.q = -3.4028235E38f;
        this.r = Float.MAX_VALUE;
        this.x = 1;
        this.A0 = -1;
        this.J0 = true;
        this.K0 = false;
        this.V0 = new c();
        this.W0 = 0;
        v();
    }
}
