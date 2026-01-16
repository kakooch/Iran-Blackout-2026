package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.l;
import java.util.List;

/* loaded from: classes2.dex */
public class LinearLayoutManager extends RecyclerView.p implements l.h, RecyclerView.y.b {
    int A;
    int B;
    private boolean C;
    SavedState D;
    final a E;
    private final b F;
    private int G;
    private int[] H;
    int s;
    private c t;
    t u;
    private boolean v;
    private boolean w;
    boolean x;
    private boolean y;
    private boolean z;

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        int a;
        int b;
        boolean c;

        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState() {
        }

        boolean a() {
            return this.a >= 0;
        }

        void b() {
            this.a = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c ? 1 : 0);
        }

        SavedState(Parcel parcel) {
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            this.c = parcel.readInt() == 1;
        }

        public SavedState(SavedState savedState) {
            this.a = savedState.a;
            this.b = savedState.b;
            this.c = savedState.c;
        }
    }

    static class a {
        t a;
        int b;
        int c;
        boolean d;
        boolean e;

        a() {
            e();
        }

        void a() {
            this.c = this.d ? this.a.i() : this.a.m();
        }

        public void b(View view, int i) {
            if (this.d) {
                this.c = this.a.d(view) + this.a.o();
            } else {
                this.c = this.a.g(view);
            }
            this.b = i;
        }

        public void c(View view, int i) {
            int iO = this.a.o();
            if (iO >= 0) {
                b(view, i);
                return;
            }
            this.b = i;
            if (this.d) {
                int i2 = (this.a.i() - iO) - this.a.d(view);
                this.c = this.a.i() - i2;
                if (i2 > 0) {
                    int iE = this.c - this.a.e(view);
                    int iM = this.a.m();
                    int iMin = iE - (iM + Math.min(this.a.g(view) - iM, 0));
                    if (iMin < 0) {
                        this.c += Math.min(i2, -iMin);
                        return;
                    }
                    return;
                }
                return;
            }
            int iG = this.a.g(view);
            int iM2 = iG - this.a.m();
            this.c = iG;
            if (iM2 > 0) {
                int i3 = (this.a.i() - Math.min(0, (this.a.i() - iO) - this.a.d(view))) - (iG + this.a.e(view));
                if (i3 < 0) {
                    this.c -= Math.min(iM2, -i3);
                }
            }
        }

        boolean d(View view, RecyclerView.z zVar) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return !layoutParams.c() && layoutParams.a() >= 0 && layoutParams.a() < zVar.b();
        }

        void e() {
            this.b = -1;
            this.c = RecyclerView.UNDEFINED_DURATION;
            this.d = false;
            this.e = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.b + ", mCoordinate=" + this.c + ", mLayoutFromEnd=" + this.d + ", mValid=" + this.e + '}';
        }
    }

    protected static class b {
        public int a;
        public boolean b;
        public boolean c;
        public boolean d;

        protected b() {
        }

        void a() {
            this.a = 0;
            this.b = false;
            this.c = false;
            this.d = false;
        }
    }

    static class c {
        int b;
        int c;
        int d;
        int e;
        int f;
        int g;
        int k;
        boolean m;
        boolean a = true;
        int h = 0;
        int i = 0;
        boolean j = false;
        List l = null;

        c() {
        }

        private View e() {
            int size = this.l.size();
            for (int i = 0; i < size; i++) {
                View view = ((RecyclerView.C) this.l.get(i)).a;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                if (!layoutParams.c() && this.d == layoutParams.a()) {
                    b(view);
                    return view;
                }
            }
            return null;
        }

        public void a() {
            b(null);
        }

        public void b(View view) {
            View viewF = f(view);
            if (viewF == null) {
                this.d = -1;
            } else {
                this.d = ((RecyclerView.LayoutParams) viewF.getLayoutParams()).a();
            }
        }

        boolean c(RecyclerView.z zVar) {
            int i = this.d;
            return i >= 0 && i < zVar.b();
        }

        View d(RecyclerView.v vVar) {
            if (this.l != null) {
                return e();
            }
            View viewO = vVar.o(this.d);
            this.d += this.e;
            return viewO;
        }

        public View f(View view) {
            int iA;
            int size = this.l.size();
            View view2 = null;
            int i = Integer.MAX_VALUE;
            for (int i2 = 0; i2 < size; i2++) {
                View view3 = ((RecyclerView.C) this.l.get(i2)).a;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view3.getLayoutParams();
                if (view3 != view && !layoutParams.c() && (iA = (layoutParams.a() - this.d) * this.e) >= 0 && iA < i) {
                    view2 = view3;
                    if (iA == 0) {
                        break;
                    }
                    i = iA;
                }
            }
            return view2;
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    private void A2(RecyclerView.v vVar, int i, int i2) {
        if (i < 0) {
            return;
        }
        int i3 = i - i2;
        int iK = K();
        if (!this.x) {
            for (int i4 = 0; i4 < iK; i4++) {
                View viewJ = J(i4);
                if (this.u.d(viewJ) > i3 || this.u.p(viewJ) > i3) {
                    y2(vVar, 0, i4);
                    return;
                }
            }
            return;
        }
        int i5 = iK - 1;
        for (int i6 = i5; i6 >= 0; i6--) {
            View viewJ2 = J(i6);
            if (this.u.d(viewJ2) > i3 || this.u.p(viewJ2) > i3) {
                y2(vVar, i5, i6);
                return;
            }
        }
    }

    private void C2() {
        if (this.s == 1 || !s2()) {
            this.x = this.w;
        } else {
            this.x = !this.w;
        }
    }

    private boolean K2(RecyclerView.v vVar, RecyclerView.z zVar, a aVar) {
        View viewL2;
        boolean z = false;
        if (K() == 0) {
            return false;
        }
        View viewW = W();
        if (viewW != null && aVar.d(viewW, zVar)) {
            aVar.c(viewW, i0(viewW));
            return true;
        }
        boolean z2 = this.v;
        boolean z3 = this.y;
        if (z2 != z3 || (viewL2 = l2(vVar, zVar, aVar.d, z3)) == null) {
            return false;
        }
        aVar.b(viewL2, i0(viewL2));
        if (!zVar.e() && P1()) {
            int iG = this.u.g(viewL2);
            int iD = this.u.d(viewL2);
            int iM = this.u.m();
            int i = this.u.i();
            boolean z4 = iD <= iM && iG < iM;
            if (iG >= i && iD > i) {
                z = true;
            }
            if (z4 || z) {
                if (aVar.d) {
                    iM = i;
                }
                aVar.c = iM;
            }
        }
        return true;
    }

    private boolean L2(RecyclerView.z zVar, a aVar) {
        int i;
        if (!zVar.e() && (i = this.A) != -1) {
            if (i >= 0 && i < zVar.b()) {
                aVar.b = this.A;
                SavedState savedState = this.D;
                if (savedState != null && savedState.a()) {
                    boolean z = this.D.c;
                    aVar.d = z;
                    if (z) {
                        aVar.c = this.u.i() - this.D.b;
                    } else {
                        aVar.c = this.u.m() + this.D.b;
                    }
                    return true;
                }
                if (this.B != Integer.MIN_VALUE) {
                    boolean z2 = this.x;
                    aVar.d = z2;
                    if (z2) {
                        aVar.c = this.u.i() - this.B;
                    } else {
                        aVar.c = this.u.m() + this.B;
                    }
                    return true;
                }
                View viewD = D(this.A);
                if (viewD == null) {
                    if (K() > 0) {
                        aVar.d = (this.A < i0(J(0))) == this.x;
                    }
                    aVar.a();
                } else {
                    if (this.u.e(viewD) > this.u.n()) {
                        aVar.a();
                        return true;
                    }
                    if (this.u.g(viewD) - this.u.m() < 0) {
                        aVar.c = this.u.m();
                        aVar.d = false;
                        return true;
                    }
                    if (this.u.i() - this.u.d(viewD) < 0) {
                        aVar.c = this.u.i();
                        aVar.d = true;
                        return true;
                    }
                    aVar.c = aVar.d ? this.u.d(viewD) + this.u.o() : this.u.g(viewD);
                }
                return true;
            }
            this.A = -1;
            this.B = RecyclerView.UNDEFINED_DURATION;
        }
        return false;
    }

    private void M2(RecyclerView.v vVar, RecyclerView.z zVar, a aVar) {
        if (L2(zVar, aVar) || K2(vVar, zVar, aVar)) {
            return;
        }
        aVar.a();
        aVar.b = this.y ? zVar.b() - 1 : 0;
    }

    private void N2(int i, int i2, boolean z, RecyclerView.z zVar) {
        int iM;
        this.t.m = B2();
        this.t.f = i;
        int[] iArr = this.H;
        iArr[0] = 0;
        iArr[1] = 0;
        Q1(zVar, iArr);
        int iMax = Math.max(0, this.H[0]);
        int iMax2 = Math.max(0, this.H[1]);
        boolean z2 = i == 1;
        c cVar = this.t;
        int i3 = z2 ? iMax2 : iMax;
        cVar.h = i3;
        if (!z2) {
            iMax = iMax2;
        }
        cVar.i = iMax;
        if (z2) {
            cVar.h = i3 + this.u.j();
            View viewO2 = o2();
            c cVar2 = this.t;
            cVar2.e = this.x ? -1 : 1;
            int iI0 = i0(viewO2);
            c cVar3 = this.t;
            cVar2.d = iI0 + cVar3.e;
            cVar3.b = this.u.d(viewO2);
            iM = this.u.d(viewO2) - this.u.i();
        } else {
            View viewP2 = p2();
            this.t.h += this.u.m();
            c cVar4 = this.t;
            cVar4.e = this.x ? 1 : -1;
            int iI02 = i0(viewP2);
            c cVar5 = this.t;
            cVar4.d = iI02 + cVar5.e;
            cVar5.b = this.u.g(viewP2);
            iM = (-this.u.g(viewP2)) + this.u.m();
        }
        c cVar6 = this.t;
        cVar6.c = i2;
        if (z) {
            cVar6.c = i2 - iM;
        }
        cVar6.g = iM;
    }

    private void O2(int i, int i2) {
        this.t.c = this.u.i() - i2;
        c cVar = this.t;
        cVar.e = this.x ? -1 : 1;
        cVar.d = i;
        cVar.f = 1;
        cVar.b = i2;
        cVar.g = RecyclerView.UNDEFINED_DURATION;
    }

    private void P2(a aVar) {
        O2(aVar.b, aVar.c);
    }

    private void Q2(int i, int i2) {
        this.t.c = i2 - this.u.m();
        c cVar = this.t;
        cVar.d = i;
        cVar.e = this.x ? 1 : -1;
        cVar.f = -1;
        cVar.b = i2;
        cVar.g = RecyclerView.UNDEFINED_DURATION;
    }

    private void R2(a aVar) {
        Q2(aVar.b, aVar.c);
    }

    private int S1(RecyclerView.z zVar) {
        if (K() == 0) {
            return 0;
        }
        X1();
        return w.a(zVar, this.u, c2(!this.z, true), b2(!this.z, true), this, this.z);
    }

    private int T1(RecyclerView.z zVar) {
        if (K() == 0) {
            return 0;
        }
        X1();
        return w.b(zVar, this.u, c2(!this.z, true), b2(!this.z, true), this, this.z, this.x);
    }

    private int U1(RecyclerView.z zVar) {
        if (K() == 0) {
            return 0;
        }
        X1();
        return w.c(zVar, this.u, c2(!this.z, true), b2(!this.z, true), this, this.z);
    }

    private View a2() {
        return h2(0, K());
    }

    private View f2() {
        return h2(K() - 1, -1);
    }

    private View j2() {
        return this.x ? a2() : f2();
    }

    private View k2() {
        return this.x ? f2() : a2();
    }

    private int m2(int i, RecyclerView.v vVar, RecyclerView.z zVar, boolean z) {
        int i2;
        int i3 = this.u.i() - i;
        if (i3 <= 0) {
            return 0;
        }
        int i4 = -D2(-i3, vVar, zVar);
        int i5 = i + i4;
        if (!z || (i2 = this.u.i() - i5) <= 0) {
            return i4;
        }
        this.u.r(i2);
        return i2 + i4;
    }

    private int n2(int i, RecyclerView.v vVar, RecyclerView.z zVar, boolean z) {
        int iM;
        int iM2 = i - this.u.m();
        if (iM2 <= 0) {
            return 0;
        }
        int i2 = -D2(iM2, vVar, zVar);
        int i3 = i + i2;
        if (!z || (iM = i3 - this.u.m()) <= 0) {
            return i2;
        }
        this.u.r(-iM);
        return i2 - iM;
    }

    private View o2() {
        return J(this.x ? 0 : K() - 1);
    }

    private View p2() {
        return J(this.x ? K() - 1 : 0);
    }

    private void v2(RecyclerView.v vVar, RecyclerView.z zVar, int i, int i2) {
        if (!zVar.g() || K() == 0 || zVar.e() || !P1()) {
            return;
        }
        List listK = vVar.k();
        int size = listK.size();
        int iI0 = i0(J(0));
        int iE = 0;
        int iE2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            RecyclerView.C c2 = (RecyclerView.C) listK.get(i3);
            if (!c2.a0()) {
                if ((c2.N() < iI0) != this.x) {
                    iE += this.u.e(c2.a);
                } else {
                    iE2 += this.u.e(c2.a);
                }
            }
        }
        this.t.l = listK;
        if (iE > 0) {
            Q2(i0(p2()), i);
            c cVar = this.t;
            cVar.h = iE;
            cVar.c = 0;
            cVar.a();
            Y1(vVar, this.t, zVar, false);
        }
        if (iE2 > 0) {
            O2(i0(o2()), i2);
            c cVar2 = this.t;
            cVar2.h = iE2;
            cVar2.c = 0;
            cVar2.a();
            Y1(vVar, this.t, zVar, false);
        }
        this.t.l = null;
    }

    private void x2(RecyclerView.v vVar, c cVar) {
        if (!cVar.a || cVar.m) {
            return;
        }
        int i = cVar.g;
        int i2 = cVar.i;
        if (cVar.f == -1) {
            z2(vVar, i, i2);
        } else {
            A2(vVar, i, i2);
        }
    }

    private void y2(RecyclerView.v vVar, int i, int i2) {
        if (i == i2) {
            return;
        }
        if (i2 <= i) {
            while (i > i2) {
                q1(i, vVar);
                i--;
            }
        } else {
            for (int i3 = i2 - 1; i3 >= i; i3--) {
                q1(i3, vVar);
            }
        }
    }

    private void z2(RecyclerView.v vVar, int i, int i2) {
        int iK = K();
        if (i < 0) {
            return;
        }
        int iH = (this.u.h() - i) + i2;
        if (this.x) {
            for (int i3 = 0; i3 < iK; i3++) {
                View viewJ = J(i3);
                if (this.u.g(viewJ) < iH || this.u.q(viewJ) < iH) {
                    y2(vVar, 0, i3);
                    return;
                }
            }
            return;
        }
        int i4 = iK - 1;
        for (int i5 = i4; i5 >= 0; i5--) {
            View viewJ2 = J(i5);
            if (this.u.g(viewJ2) < iH || this.u.q(viewJ2) < iH) {
                y2(vVar, i4, i5);
                return;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void A1(int i) {
        this.A = i;
        this.B = RecyclerView.UNDEFINED_DURATION;
        SavedState savedState = this.D;
        if (savedState != null) {
            savedState.b();
        }
        w1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public int B1(int i, RecyclerView.v vVar, RecyclerView.z zVar) {
        if (this.s == 0) {
            return 0;
        }
        return D2(i, vVar, zVar);
    }

    boolean B2() {
        return this.u.k() == 0 && this.u.h() == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public View D(int i) {
        int iK = K();
        if (iK == 0) {
            return null;
        }
        int iI0 = i - i0(J(0));
        if (iI0 >= 0 && iI0 < iK) {
            View viewJ = J(iI0);
            if (i0(viewJ) == i) {
                return viewJ;
            }
        }
        return super.D(i);
    }

    int D2(int i, RecyclerView.v vVar, RecyclerView.z zVar) {
        if (K() == 0 || i == 0) {
            return 0;
        }
        X1();
        this.t.a = true;
        int i2 = i > 0 ? 1 : -1;
        int iAbs = Math.abs(i);
        N2(i2, iAbs, true, zVar);
        c cVar = this.t;
        int iY1 = cVar.g + Y1(vVar, cVar, zVar, false);
        if (iY1 < 0) {
            return 0;
        }
        if (iAbs > iY1) {
            i = i2 * iY1;
        }
        this.u.r(-i);
        this.t.k = i;
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public RecyclerView.LayoutParams E() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    public void E2(int i, int i2) {
        this.A = i;
        this.B = i2;
        SavedState savedState = this.D;
        if (savedState != null) {
            savedState.b();
        }
        w1();
    }

    public void F2(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i);
        }
        h(null);
        if (i != this.s || this.u == null) {
            t tVarB = t.b(this, i);
            this.u = tVarB;
            this.E.a = tVarB;
            this.s = i;
            w1();
        }
    }

    public void G2(boolean z) {
        this.C = z;
    }

    public void H2(boolean z) {
        h(null);
        if (z == this.w) {
            return;
        }
        this.w = z;
        w1();
    }

    public void I2(boolean z) {
        this.z = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    boolean J1() {
        return (Y() == 1073741824 || q0() == 1073741824 || !r0()) ? false : true;
    }

    public void J2(boolean z) {
        h(null);
        if (this.y == z) {
            return;
        }
        this.y = z;
        w1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void L0(RecyclerView recyclerView, RecyclerView.v vVar) {
        super.L0(recyclerView, vVar);
        if (this.C) {
            n1(vVar);
            vVar.c();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void L1(RecyclerView recyclerView, RecyclerView.z zVar, int i) {
        o oVar = new o(recyclerView.getContext());
        oVar.p(i);
        M1(oVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public View M0(View view, int i, RecyclerView.v vVar, RecyclerView.z zVar) {
        int iV1;
        C2();
        if (K() == 0 || (iV1 = V1(i)) == Integer.MIN_VALUE) {
            return null;
        }
        X1();
        N2(iV1, (int) (this.u.n() * 0.33333334f), false, zVar);
        c cVar = this.t;
        cVar.g = RecyclerView.UNDEFINED_DURATION;
        cVar.a = false;
        Y1(vVar, cVar, zVar, true);
        View viewK2 = iV1 == -1 ? k2() : j2();
        View viewP2 = iV1 == -1 ? p2() : o2();
        if (!viewP2.hasFocusable()) {
            return viewK2;
        }
        if (viewK2 == null) {
            return null;
        }
        return viewP2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void N0(AccessibilityEvent accessibilityEvent) {
        super.N0(accessibilityEvent);
        if (K() > 0) {
            accessibilityEvent.setFromIndex(d2());
            accessibilityEvent.setToIndex(g2());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public boolean P1() {
        return this.D == null && this.v == this.y;
    }

    protected void Q1(RecyclerView.z zVar, int[] iArr) {
        int i;
        int iQ2 = q2(zVar);
        if (this.t.f == -1) {
            i = 0;
        } else {
            i = iQ2;
            iQ2 = 0;
        }
        iArr[0] = iQ2;
        iArr[1] = i;
    }

    void R1(RecyclerView.z zVar, c cVar, RecyclerView.p.c cVar2) {
        int i = cVar.d;
        if (i < 0 || i >= zVar.b()) {
            return;
        }
        cVar2.a(i, Math.max(0, cVar.g));
    }

    int V1(int i) {
        if (i == 1) {
            return (this.s != 1 && s2()) ? 1 : -1;
        }
        if (i == 2) {
            return (this.s != 1 && s2()) ? -1 : 1;
        }
        if (i == 17) {
            if (this.s == 0) {
                return -1;
            }
            return RecyclerView.UNDEFINED_DURATION;
        }
        if (i == 33) {
            if (this.s == 1) {
                return -1;
            }
            return RecyclerView.UNDEFINED_DURATION;
        }
        if (i == 66) {
            if (this.s == 0) {
                return 1;
            }
            return RecyclerView.UNDEFINED_DURATION;
        }
        if (i == 130 && this.s == 1) {
            return 1;
        }
        return RecyclerView.UNDEFINED_DURATION;
    }

    c W1() {
        return new c();
    }

    void X1() {
        if (this.t == null) {
            this.t = W1();
        }
    }

    int Y1(RecyclerView.v vVar, c cVar, RecyclerView.z zVar, boolean z) {
        int i = cVar.c;
        int i2 = cVar.g;
        if (i2 != Integer.MIN_VALUE) {
            if (i < 0) {
                cVar.g = i2 + i;
            }
            x2(vVar, cVar);
        }
        int i3 = cVar.c + cVar.h;
        b bVar = this.F;
        while (true) {
            if ((!cVar.m && i3 <= 0) || !cVar.c(zVar)) {
                break;
            }
            bVar.a();
            u2(vVar, zVar, cVar, bVar);
            if (!bVar.b) {
                cVar.b += bVar.a * cVar.f;
                if (!bVar.c || cVar.l != null || !zVar.e()) {
                    int i4 = cVar.c;
                    int i5 = bVar.a;
                    cVar.c = i4 - i5;
                    i3 -= i5;
                }
                int i6 = cVar.g;
                if (i6 != Integer.MIN_VALUE) {
                    int i7 = i6 + bVar.a;
                    cVar.g = i7;
                    int i8 = cVar.c;
                    if (i8 < 0) {
                        cVar.g = i7 + i8;
                    }
                    x2(vVar, cVar);
                }
                if (z && bVar.d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - cVar.c;
    }

    public int Z1() {
        View viewI2 = i2(0, K(), true, false);
        if (viewI2 == null) {
            return -1;
        }
        return i0(viewI2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.y.b
    public PointF a(int i) {
        if (K() == 0) {
            return null;
        }
        int i2 = (i < i0(J(0))) != this.x ? -1 : 1;
        return this.s == 0 ? new PointF(i2, 0.0f) : new PointF(0.0f, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void a1(RecyclerView.v vVar, RecyclerView.z zVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int iM2;
        int i5;
        View viewD;
        int iG;
        int i6;
        int i7 = -1;
        if (!(this.D == null && this.A == -1) && zVar.b() == 0) {
            n1(vVar);
            return;
        }
        SavedState savedState = this.D;
        if (savedState != null && savedState.a()) {
            this.A = this.D.a;
        }
        X1();
        this.t.a = false;
        C2();
        View viewW = W();
        a aVar = this.E;
        if (!aVar.e || this.A != -1 || this.D != null) {
            aVar.e();
            a aVar2 = this.E;
            aVar2.d = this.x ^ this.y;
            M2(vVar, zVar, aVar2);
            this.E.e = true;
        } else if (viewW != null && (this.u.g(viewW) >= this.u.i() || this.u.d(viewW) <= this.u.m())) {
            this.E.c(viewW, i0(viewW));
        }
        c cVar = this.t;
        cVar.f = cVar.k >= 0 ? 1 : -1;
        int[] iArr = this.H;
        iArr[0] = 0;
        iArr[1] = 0;
        Q1(zVar, iArr);
        int iMax = Math.max(0, this.H[0]) + this.u.m();
        int iMax2 = Math.max(0, this.H[1]) + this.u.j();
        if (zVar.e() && (i5 = this.A) != -1 && this.B != Integer.MIN_VALUE && (viewD = D(i5)) != null) {
            if (this.x) {
                i6 = this.u.i() - this.u.d(viewD);
                iG = this.B;
            } else {
                iG = this.u.g(viewD) - this.u.m();
                i6 = this.B;
            }
            int i8 = i6 - iG;
            if (i8 > 0) {
                iMax += i8;
            } else {
                iMax2 -= i8;
            }
        }
        a aVar3 = this.E;
        if (!aVar3.d ? !this.x : this.x) {
            i7 = 1;
        }
        w2(vVar, zVar, aVar3, i7);
        x(vVar);
        this.t.m = B2();
        this.t.j = zVar.e();
        this.t.i = 0;
        a aVar4 = this.E;
        if (aVar4.d) {
            R2(aVar4);
            c cVar2 = this.t;
            cVar2.h = iMax;
            Y1(vVar, cVar2, zVar, false);
            c cVar3 = this.t;
            i2 = cVar3.b;
            int i9 = cVar3.d;
            int i10 = cVar3.c;
            if (i10 > 0) {
                iMax2 += i10;
            }
            P2(this.E);
            c cVar4 = this.t;
            cVar4.h = iMax2;
            cVar4.d += cVar4.e;
            Y1(vVar, cVar4, zVar, false);
            c cVar5 = this.t;
            i = cVar5.b;
            int i11 = cVar5.c;
            if (i11 > 0) {
                Q2(i9, i2);
                c cVar6 = this.t;
                cVar6.h = i11;
                Y1(vVar, cVar6, zVar, false);
                i2 = this.t.b;
            }
        } else {
            P2(aVar4);
            c cVar7 = this.t;
            cVar7.h = iMax2;
            Y1(vVar, cVar7, zVar, false);
            c cVar8 = this.t;
            i = cVar8.b;
            int i12 = cVar8.d;
            int i13 = cVar8.c;
            if (i13 > 0) {
                iMax += i13;
            }
            R2(this.E);
            c cVar9 = this.t;
            cVar9.h = iMax;
            cVar9.d += cVar9.e;
            Y1(vVar, cVar9, zVar, false);
            c cVar10 = this.t;
            i2 = cVar10.b;
            int i14 = cVar10.c;
            if (i14 > 0) {
                O2(i12, i);
                c cVar11 = this.t;
                cVar11.h = i14;
                Y1(vVar, cVar11, zVar, false);
                i = this.t.b;
            }
        }
        if (K() > 0) {
            if (this.x ^ this.y) {
                int iM22 = m2(i, vVar, zVar, true);
                i3 = i2 + iM22;
                i4 = i + iM22;
                iM2 = n2(i3, vVar, zVar, false);
            } else {
                int iN2 = n2(i2, vVar, zVar, true);
                i3 = i2 + iN2;
                i4 = i + iN2;
                iM2 = m2(i4, vVar, zVar, false);
            }
            i2 = i3 + iM2;
            i = i4 + iM2;
        }
        v2(vVar, zVar, i2, i);
        if (zVar.e()) {
            this.E.e();
        } else {
            this.u.s();
        }
        this.v = this.y;
    }

    @Override // androidx.recyclerview.widget.l.h
    public void b(View view, View view2, int i, int i2) {
        h("Cannot drop a view during a scroll or layout calculation");
        X1();
        C2();
        int iI0 = i0(view);
        int iI02 = i0(view2);
        char c2 = iI0 < iI02 ? (char) 1 : (char) 65535;
        if (this.x) {
            if (c2 == 1) {
                E2(iI02, this.u.i() - (this.u.g(view2) + this.u.e(view)));
                return;
            } else {
                E2(iI02, this.u.i() - this.u.d(view2));
                return;
            }
        }
        if (c2 == 65535) {
            E2(iI02, this.u.g(view2));
        } else {
            E2(iI02, this.u.d(view2) - this.u.e(view));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void b1(RecyclerView.z zVar) {
        super.b1(zVar);
        this.D = null;
        this.A = -1;
        this.B = RecyclerView.UNDEFINED_DURATION;
        this.E.e();
    }

    View b2(boolean z, boolean z2) {
        return this.x ? i2(0, K(), z, z2) : i2(K() - 1, -1, z, z2);
    }

    View c2(boolean z, boolean z2) {
        return this.x ? i2(K() - 1, -1, z, z2) : i2(0, K(), z, z2);
    }

    public int d2() {
        View viewI2 = i2(0, K(), false, true);
        if (viewI2 == null) {
            return -1;
        }
        return i0(viewI2);
    }

    public int e2() {
        View viewI2 = i2(K() - 1, -1, true, false);
        if (viewI2 == null) {
            return -1;
        }
        return i0(viewI2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void f1(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.D = savedState;
            if (this.A != -1) {
                savedState.b();
            }
            w1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public Parcelable g1() {
        if (this.D != null) {
            return new SavedState(this.D);
        }
        SavedState savedState = new SavedState();
        if (K() > 0) {
            X1();
            boolean z = this.v ^ this.x;
            savedState.c = z;
            if (z) {
                View viewO2 = o2();
                savedState.b = this.u.i() - this.u.d(viewO2);
                savedState.a = i0(viewO2);
            } else {
                View viewP2 = p2();
                savedState.a = i0(viewP2);
                savedState.b = this.u.g(viewP2) - this.u.m();
            }
        } else {
            savedState.b();
        }
        return savedState;
    }

    public int g2() {
        View viewI2 = i2(K() - 1, -1, false, true);
        if (viewI2 == null) {
            return -1;
        }
        return i0(viewI2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void h(String str) {
        if (this.D == null) {
            super.h(str);
        }
    }

    View h2(int i, int i2) {
        int i3;
        int i4;
        X1();
        if (i2 <= i && i2 >= i) {
            return J(i);
        }
        if (this.u.g(J(i)) < this.u.m()) {
            i3 = 16644;
            i4 = 16388;
        } else {
            i3 = 4161;
            i4 = 4097;
        }
        return this.s == 0 ? this.e.a(i, i2, i3, i4) : this.f.a(i, i2, i3, i4);
    }

    View i2(int i, int i2, boolean z, boolean z2) {
        X1();
        int i3 = z ? 24579 : 320;
        int i4 = z2 ? 320 : 0;
        return this.s == 0 ? this.e.a(i, i2, i3, i4) : this.f.a(i, i2, i3, i4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public boolean l() {
        return this.s == 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    android.view.View l2(androidx.recyclerview.widget.RecyclerView.v r17, androidx.recyclerview.widget.RecyclerView.z r18, boolean r19, boolean r20) {
        /*
            r16 = this;
            r0 = r16
            r16.X1()
            int r1 = r16.K()
            r2 = 0
            r3 = 1
            if (r20 == 0) goto L15
            int r1 = r16.K()
            int r1 = r1 - r3
            r4 = -1
            r5 = r4
            goto L18
        L15:
            r4 = r1
            r1 = r2
            r5 = r3
        L18:
            int r6 = r18.b()
            androidx.recyclerview.widget.t r7 = r0.u
            int r7 = r7.m()
            androidx.recyclerview.widget.t r8 = r0.u
            int r8 = r8.i()
            r9 = 0
            r10 = r9
            r11 = r10
        L2b:
            if (r1 == r4) goto L7a
            android.view.View r12 = r0.J(r1)
            int r13 = r0.i0(r12)
            androidx.recyclerview.widget.t r14 = r0.u
            int r14 = r14.g(r12)
            androidx.recyclerview.widget.t r15 = r0.u
            int r15 = r15.d(r12)
            if (r13 < 0) goto L78
            if (r13 >= r6) goto L78
            android.view.ViewGroup$LayoutParams r13 = r12.getLayoutParams()
            androidx.recyclerview.widget.RecyclerView$LayoutParams r13 = (androidx.recyclerview.widget.RecyclerView.LayoutParams) r13
            boolean r13 = r13.c()
            if (r13 == 0) goto L55
            if (r11 != 0) goto L78
            r11 = r12
            goto L78
        L55:
            if (r15 > r7) goto L5b
            if (r14 >= r7) goto L5b
            r13 = r3
            goto L5c
        L5b:
            r13 = r2
        L5c:
            if (r14 < r8) goto L62
            if (r15 <= r8) goto L62
            r14 = r3
            goto L63
        L62:
            r14 = r2
        L63:
            if (r13 != 0) goto L69
            if (r14 == 0) goto L68
            goto L69
        L68:
            return r12
        L69:
            if (r19 == 0) goto L71
            if (r14 == 0) goto L6e
            goto L73
        L6e:
            if (r9 != 0) goto L78
            goto L77
        L71:
            if (r13 == 0) goto L75
        L73:
            r10 = r12
            goto L78
        L75:
            if (r9 != 0) goto L78
        L77:
            r9 = r12
        L78:
            int r1 = r1 + r5
            goto L2b
        L7a:
            if (r9 == 0) goto L7d
            goto L82
        L7d:
            if (r10 == 0) goto L81
            r9 = r10
            goto L82
        L81:
            r9 = r11
        L82:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.LinearLayoutManager.l2(androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$z, boolean, boolean):android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public boolean m() {
        return this.s == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void p(int i, int i2, RecyclerView.z zVar, RecyclerView.p.c cVar) {
        if (this.s != 0) {
            i = i2;
        }
        if (K() == 0 || i == 0) {
            return;
        }
        X1();
        N2(i > 0 ? 1 : -1, Math.abs(i), true, zVar);
        R1(zVar, this.t, cVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void q(int i, RecyclerView.p.c cVar) {
        boolean z;
        int i2;
        SavedState savedState = this.D;
        if (savedState == null || !savedState.a()) {
            C2();
            z = this.x;
            i2 = this.A;
            if (i2 == -1) {
                i2 = z ? i - 1 : 0;
            }
        } else {
            SavedState savedState2 = this.D;
            z = savedState2.c;
            i2 = savedState2.a;
        }
        int i3 = z ? -1 : 1;
        for (int i4 = 0; i4 < this.G && i2 >= 0 && i2 < i; i4++) {
            cVar.a(i2, 0);
            i2 += i3;
        }
    }

    protected int q2(RecyclerView.z zVar) {
        if (zVar.d()) {
            return this.u.n();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public int r(RecyclerView.z zVar) {
        return S1(zVar);
    }

    public int r2() {
        return this.s;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public int s(RecyclerView.z zVar) {
        return T1(zVar);
    }

    protected boolean s2() {
        return a0() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public int t(RecyclerView.z zVar) {
        return U1(zVar);
    }

    public boolean t2() {
        return this.z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public int u(RecyclerView.z zVar) {
        return S1(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public boolean u0() {
        return true;
    }

    void u2(RecyclerView.v vVar, RecyclerView.z zVar, c cVar, b bVar) {
        int i;
        int i2;
        int i3;
        int iF0;
        int iF;
        View viewD = cVar.d(vVar);
        if (viewD == null) {
            bVar.b = true;
            return;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) viewD.getLayoutParams();
        if (cVar.l == null) {
            if (this.x == (cVar.f == -1)) {
                e(viewD);
            } else {
                f(viewD, 0);
            }
        } else {
            if (this.x == (cVar.f == -1)) {
                c(viewD);
            } else {
                d(viewD, 0);
            }
        }
        D0(viewD, 0, 0);
        bVar.a = this.u.e(viewD);
        if (this.s == 1) {
            if (s2()) {
                iF = p0() - g0();
                iF0 = iF - this.u.f(viewD);
            } else {
                iF0 = f0();
                iF = this.u.f(viewD) + iF0;
            }
            if (cVar.f == -1) {
                int i4 = cVar.b;
                i3 = i4;
                i2 = iF;
                i = i4 - bVar.a;
            } else {
                int i5 = cVar.b;
                i = i5;
                i2 = iF;
                i3 = bVar.a + i5;
            }
        } else {
            int iH0 = h0();
            int iF2 = this.u.f(viewD) + iH0;
            if (cVar.f == -1) {
                int i6 = cVar.b;
                i2 = i6;
                i = iH0;
                i3 = iF2;
                iF0 = i6 - bVar.a;
            } else {
                int i7 = cVar.b;
                i = iH0;
                i2 = bVar.a + i7;
                i3 = iF2;
                iF0 = i7;
            }
        }
        C0(viewD, iF0, i, i2, i3);
        if (layoutParams.c() || layoutParams.b()) {
            bVar.c = true;
        }
        bVar.d = viewD.hasFocusable();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public int v(RecyclerView.z zVar) {
        return T1(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public int w(RecyclerView.z zVar) {
        return U1(zVar);
    }

    void w2(RecyclerView.v vVar, RecyclerView.z zVar, a aVar, int i) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public int z1(int i, RecyclerView.v vVar, RecyclerView.z zVar) {
        if (this.s == 1) {
            return 0;
        }
        return D2(i, vVar, zVar);
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        this.s = 1;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = true;
        this.A = -1;
        this.B = RecyclerView.UNDEFINED_DURATION;
        this.D = null;
        this.E = new a();
        this.F = new b();
        this.G = 2;
        this.H = new int[2];
        F2(i);
        H2(z);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.s = 1;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = true;
        this.A = -1;
        this.B = RecyclerView.UNDEFINED_DURATION;
        this.D = null;
        this.E = new a();
        this.F = new b();
        this.G = 2;
        this.H = new int[2];
        RecyclerView.p.d dVarJ0 = RecyclerView.p.j0(context, attributeSet, i, i2);
        F2(dVarJ0.a);
        H2(dVarJ0.c);
        J2(dVarJ0.d);
    }
}
