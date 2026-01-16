package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.l;
import java.util.List;

/* loaded from: classes2.dex */
public class LinearLayoutManagerTgwidget extends RecyclerView.p implements l.h, RecyclerView.y.b {
    private boolean A;
    private boolean B;
    int C;
    boolean D;
    int E;
    private boolean F;
    SavedState G;
    final a H;
    private final b I;
    private int J;
    private int[] K;
    private boolean L;
    private boolean M;
    int s;
    private c t;
    t u;
    public boolean v;
    private boolean w;
    private boolean x;
    private boolean y;
    boolean z;

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

    public LinearLayoutManagerTgwidget(Context context) {
        this(context, 1, false);
    }

    private void A2(RecyclerView.v vVar, c cVar) {
        if (!cVar.a || cVar.m) {
            return;
        }
        int i = cVar.g;
        int i2 = cVar.i;
        if (cVar.f == -1) {
            C2(vVar, i, i2);
        } else {
            D2(vVar, i, i2);
        }
    }

    private void C2(RecyclerView.v vVar, int i, int i2) {
        RecyclerView.C childViewHolder;
        RecyclerView.C childViewHolder2;
        int iK = K();
        if (i < 0) {
            return;
        }
        int iH = (this.u.h() - i) + i2;
        if (this.z) {
            for (int i3 = 0; i3 < iK; i3++) {
                View viewJ = J(i3);
                if (viewJ != null && (childViewHolder2 = this.b.getChildViewHolder(viewJ)) != null && !childViewHolder2.y0() && (this.u.g(viewJ) < iH || this.u.q(viewJ) < iH)) {
                    B2(vVar, 0, i3);
                    return;
                }
            }
            return;
        }
        int i4 = iK - 1;
        for (int i5 = i4; i5 >= 0; i5--) {
            View viewJ2 = J(i5);
            if (viewJ2 != null && (childViewHolder = this.b.getChildViewHolder(viewJ2)) != null && !childViewHolder.y0() && (this.u.g(viewJ2) < iH || this.u.q(viewJ2) < iH)) {
                B2(vVar, i4, i5);
                return;
            }
        }
    }

    private void F2() {
        if (this.s == 1 || !w2()) {
            this.z = this.x;
        } else {
            this.z = !this.x;
        }
    }

    private boolean L2(RecyclerView.v vVar, RecyclerView.z zVar, a aVar) {
        if (K() == 0) {
            return false;
        }
        View viewW = W();
        if (viewW != null && aVar.d(viewW, zVar)) {
            aVar.c(viewW, i0(viewW));
            return true;
        }
        if (this.w != this.A) {
            return false;
        }
        View viewM2 = aVar.d ? m2(vVar, zVar) : n2(vVar, zVar);
        if (viewM2 == null) {
            return false;
        }
        aVar.b(viewM2, i0(viewM2));
        if (!zVar.e() && P1() && (this.u.g(viewM2) >= this.u.i() || this.u.d(viewM2) < this.u.m())) {
            aVar.c = aVar.d ? this.u.i() : this.u.m();
        }
        return true;
    }

    private boolean M2(RecyclerView.z zVar, a aVar) {
        int i;
        if (!zVar.e() && (i = this.C) != -1) {
            if (i >= 0 && i < zVar.b()) {
                aVar.b = this.C;
                SavedState savedState = this.G;
                if (savedState != null && savedState.a()) {
                    boolean z = this.G.c;
                    aVar.d = z;
                    if (z) {
                        aVar.c = this.u.i() - this.G.b;
                    } else {
                        aVar.c = this.u.m() + this.G.b;
                    }
                    return true;
                }
                if (this.E != Integer.MIN_VALUE) {
                    boolean z2 = this.D;
                    aVar.d = z2;
                    if (z2) {
                        aVar.c = this.u.i() - this.E;
                    } else {
                        aVar.c = this.u.m() + this.E;
                    }
                    return true;
                }
                View viewD = D(this.C);
                if (viewD == null) {
                    if (K() > 0) {
                        aVar.d = (this.C < i0(J(0))) == this.D;
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
            this.C = -1;
            this.E = RecyclerView.UNDEFINED_DURATION;
        }
        return false;
    }

    private void N2(RecyclerView.v vVar, RecyclerView.z zVar, a aVar) {
        if (M2(zVar, aVar) || L2(vVar, zVar, aVar)) {
            return;
        }
        aVar.a();
        aVar.b = this.A ? zVar.b() - 1 : o2();
    }

    private void O2(int i, int i2, boolean z, RecyclerView.z zVar) {
        int iM;
        this.t.m = E2();
        this.t.f = i;
        int[] iArr = this.K;
        iArr[0] = 0;
        iArr[1] = 0;
        Q1(zVar, iArr);
        int iMax = Math.max(0, this.K[0]);
        int iMax2 = Math.max(0, this.K[1]);
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
            View viewR2 = r2();
            c cVar2 = this.t;
            cVar2.e = this.z ? -1 : 1;
            int iI0 = i0(viewR2);
            c cVar3 = this.t;
            cVar2.d = iI0 + cVar3.e;
            cVar3.b = this.u.d(viewR2);
            iM = this.u.d(viewR2) - this.u.i();
        } else {
            View viewS2 = s2();
            this.t.h += this.u.m();
            c cVar4 = this.t;
            cVar4.e = this.z ? 1 : -1;
            int iI02 = i0(viewS2);
            c cVar5 = this.t;
            cVar4.d = iI02 + cVar5.e;
            cVar5.b = this.u.g(viewS2);
            iM = (-this.u.g(viewS2)) + this.u.m();
        }
        c cVar6 = this.t;
        cVar6.c = i2;
        if (z) {
            cVar6.c = i2 - iM;
        }
        cVar6.g = iM;
    }

    private void P2(int i, int i2) {
        this.t.c = this.u.i() - i2;
        c cVar = this.t;
        cVar.e = this.z ? -1 : 1;
        cVar.d = i;
        cVar.f = 1;
        cVar.b = i2;
        cVar.g = RecyclerView.UNDEFINED_DURATION;
    }

    private void Q2(a aVar) {
        P2(aVar.b, aVar.c);
    }

    private void R2(int i, int i2) {
        this.t.c = i2 - this.u.m();
        c cVar = this.t;
        cVar.d = i;
        cVar.e = this.z ? 1 : -1;
        cVar.f = -1;
        cVar.b = i2;
        cVar.g = RecyclerView.UNDEFINED_DURATION;
    }

    private int S1(RecyclerView.z zVar) {
        if (K() == 0) {
            return 0;
        }
        X1();
        return w.a(zVar, this.u, c2(!this.B, true), b2(!this.B, true), this, this.B);
    }

    private void S2(a aVar) {
        R2(aVar.b, aVar.c);
    }

    private int T1(RecyclerView.z zVar) {
        if (K() == 0) {
            return 0;
        }
        X1();
        return w.b(zVar, this.u, c2(!this.B, true), b2(!this.B, true), this, this.B, this.z);
    }

    private int U1(RecyclerView.z zVar) {
        if (K() == 0) {
            return 0;
        }
        X1();
        return w.c(zVar, this.u, c2(!this.B, true), b2(!this.B, true), this, this.B);
    }

    private View Z1() {
        return h2(0, K());
    }

    private View a2(RecyclerView.v vVar, RecyclerView.z zVar) {
        return l2(vVar, zVar, 0, K(), zVar.b());
    }

    private View e2() {
        return h2(K() - 1, -1);
    }

    private View f2(RecyclerView.v vVar, RecyclerView.z zVar) {
        return l2(vVar, zVar, K() - 1, -1, zVar.b());
    }

    private View j2() {
        return this.z ? Z1() : e2();
    }

    private View k2() {
        return this.z ? e2() : Z1();
    }

    private View m2(RecyclerView.v vVar, RecyclerView.z zVar) {
        return this.z ? a2(vVar, zVar) : f2(vVar, zVar);
    }

    private View n2(RecyclerView.v vVar, RecyclerView.z zVar) {
        return this.z ? f2(vVar, zVar) : a2(vVar, zVar);
    }

    private int p2(int i, RecyclerView.v vVar, RecyclerView.z zVar, boolean z) {
        int i2;
        int i3;
        if (!this.L || !this.M || (i2 = this.u.i() - i) <= 0) {
            return 0;
        }
        int i4 = -G2(-i2, vVar, zVar);
        int i5 = i + i4;
        if (!z || (i3 = this.u.i() - i5) <= 0) {
            return i4;
        }
        this.u.r(i3);
        return i3 + i4;
    }

    private int q2(int i, RecyclerView.v vVar, RecyclerView.z zVar, boolean z) {
        int iV2;
        int iM;
        if (!this.L || (iV2 = i - v2()) <= 0) {
            return 0;
        }
        int i2 = -G2(iV2, vVar, zVar);
        int i3 = i + i2;
        if (!z || (iM = i3 - this.u.m()) <= 0) {
            return i2;
        }
        this.u.r(-iM);
        return i2 - iM;
    }

    private View r2() {
        return J(this.z ? 0 : K() - 1);
    }

    private View s2() {
        return J(this.z ? K() - 1 : 0);
    }

    private void y2(RecyclerView.v vVar, RecyclerView.z zVar, int i, int i2) {
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
                if ((c2.N() < iI0) != this.z) {
                    iE += this.u.e(c2.a);
                } else {
                    iE2 += this.u.e(c2.a);
                }
            }
        }
        this.t.l = listK;
        if (iE > 0) {
            R2(i0(s2()), i);
            c cVar = this.t;
            cVar.h = iE;
            cVar.c = 0;
            cVar.a();
            Y1(vVar, this.t, zVar, false);
        }
        if (iE2 > 0) {
            P2(i0(r2()), i2);
            c cVar2 = this.t;
            cVar2.h = iE2;
            cVar2.c = 0;
            cVar2.a();
            Y1(vVar, this.t, zVar, false);
        }
        this.t.l = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void A1(int i) {
        this.C = i;
        this.E = RecyclerView.UNDEFINED_DURATION;
        SavedState savedState = this.G;
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
        return G2(i, vVar, zVar);
    }

    protected void B2(RecyclerView.v vVar, int i, int i2) {
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

    protected void D2(RecyclerView.v vVar, int i, int i2) {
        RecyclerView.C childViewHolder;
        RecyclerView.C childViewHolder2;
        if (i < 0) {
            return;
        }
        int i3 = i - i2;
        int iK = K();
        if (!this.z) {
            for (int i4 = 0; i4 < iK; i4++) {
                View viewJ = J(i4);
                if (viewJ != null && (childViewHolder = this.b.getChildViewHolder(viewJ)) != null && !childViewHolder.y0() && (this.u.d(viewJ) > i3 || this.u.p(viewJ) > i3)) {
                    B2(vVar, 0, i4);
                    return;
                }
            }
            return;
        }
        int i5 = iK - 1;
        for (int i6 = i5; i6 >= 0; i6--) {
            View viewJ2 = J(i6);
            if (viewJ2 != null && (childViewHolder2 = this.b.getChildViewHolder(viewJ2)) != null && !childViewHolder2.y0() && (this.u.d(viewJ2) > i3 || this.u.p(viewJ2) > i3)) {
                B2(vVar, i5, i6);
                return;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public RecyclerView.LayoutParams E() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    boolean E2() {
        return this.u.k() == 0 && this.u.h() == 0;
    }

    int G2(int i, RecyclerView.v vVar, RecyclerView.z zVar) {
        if (K() == 0 || i == 0) {
            return 0;
        }
        X1();
        this.t.a = true;
        int i2 = i > 0 ? 1 : -1;
        int iAbs = Math.abs(i);
        O2(i2, iAbs, true, zVar);
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

    public void H2(int i, int i2) {
        I2(i, i2, this.z);
    }

    public void I2(int i, int i2, boolean z) {
        if (this.C == i && this.E == i2 && this.D == z) {
            return;
        }
        this.C = i;
        this.E = i2;
        this.D = z;
        SavedState savedState = this.G;
        if (savedState != null) {
            savedState.b();
        }
        w1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    boolean J1() {
        return (Y() == 1073741824 || q0() == 1073741824 || !r0()) ? false : true;
    }

    public void J2(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i);
        }
        h(null);
        if (i != this.s || this.u == null) {
            t tVarB = t.b(this, i);
            this.u = tVarB;
            this.H.a = tVarB;
            this.s = i;
            w1();
        }
    }

    public void K2(boolean z) {
        h(null);
        if (z == this.x) {
            return;
        }
        this.x = z;
        w1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void L0(RecyclerView recyclerView, RecyclerView.v vVar) {
        super.L0(recyclerView, vVar);
        if (this.F) {
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
        F2();
        if (K() == 0 || (iV1 = V1(i)) == Integer.MIN_VALUE) {
            return null;
        }
        X1();
        O2(iV1, (int) (this.u.n() * 0.33333334f), false, zVar);
        c cVar = this.t;
        cVar.g = RecyclerView.UNDEFINED_DURATION;
        cVar.a = false;
        Y1(vVar, cVar, zVar, true);
        View viewK2 = iV1 == -1 ? k2() : j2();
        View viewS2 = iV1 == -1 ? s2() : r2();
        if (!viewS2.hasFocusable()) {
            return viewK2;
        }
        if (viewK2 == null) {
            return null;
        }
        return viewS2;
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
        return this.G == null && this.w == this.A;
    }

    protected void Q1(RecyclerView.z zVar, int[] iArr) {
        int i;
        int iT2 = t2(zVar);
        if (this.t.f == -1) {
            i = 0;
        } else {
            i = iT2;
            iT2 = 0;
        }
        iArr[0] = iT2;
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
            return (this.s != 1 && w2()) ? 1 : -1;
        }
        if (i == 2) {
            return (this.s != 1 && w2()) ? -1 : 1;
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
            A2(vVar, cVar);
        }
        int i3 = cVar.c + cVar.h;
        b bVar = this.I;
        while (true) {
            if ((!cVar.m && i3 <= 0) || !cVar.c(zVar)) {
                break;
            }
            bVar.a();
            x2(vVar, zVar, cVar, bVar);
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
                    A2(vVar, cVar);
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

    @Override // androidx.recyclerview.widget.RecyclerView.y.b
    public PointF a(int i) {
        if (K() == 0) {
            return null;
        }
        int i2 = (i < i0(J(0))) != this.z ? -1 : 1;
        return this.s == 0 ? new PointF(i2, 0.0f) : new PointF(0.0f, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void a1(RecyclerView.v vVar, RecyclerView.z zVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int iP2;
        int i5;
        View viewD;
        int iG;
        int i6;
        int i7 = -1;
        if (!(this.G == null && this.C == -1) && zVar.b() == 0) {
            n1(vVar);
            return;
        }
        SavedState savedState = this.G;
        if (savedState != null && savedState.a()) {
            this.C = this.G.a;
        }
        X1();
        this.t.a = false;
        F2();
        View viewW = W();
        a aVar = this.H;
        if (!aVar.e || this.C != -1 || this.G != null) {
            aVar.e();
            a aVar2 = this.H;
            aVar2.d = this.z ^ this.A;
            N2(vVar, zVar, aVar2);
            this.H.e = true;
        } else if (viewW != null && (this.u.g(viewW) >= this.u.i() || this.u.d(viewW) <= this.u.m())) {
            this.H.c(viewW, i0(viewW));
        }
        c cVar = this.t;
        cVar.f = cVar.k >= 0 ? 1 : -1;
        int[] iArr = this.K;
        iArr[0] = 0;
        iArr[1] = 0;
        Q1(zVar, iArr);
        int iMax = Math.max(0, this.K[0]) + this.u.m();
        int iMax2 = Math.max(0, this.K[1]) + this.u.j();
        if (zVar.e() && (i5 = this.C) != -1 && this.E != Integer.MIN_VALUE && (viewD = D(i5)) != null) {
            if (this.D) {
                i6 = this.u.i() - this.u.d(viewD);
                iG = this.E;
            } else {
                iG = this.u.g(viewD) - this.u.m();
                i6 = this.E;
            }
            int i8 = i6 - iG;
            if (i8 > 0) {
                iMax += i8;
            } else {
                iMax2 -= i8;
            }
        }
        a aVar3 = this.H;
        if (!aVar3.d ? !this.z : this.z) {
            i7 = 1;
        }
        z2(vVar, zVar, aVar3, i7);
        x(vVar);
        this.t.m = E2();
        this.t.j = zVar.e();
        this.t.i = 0;
        a aVar4 = this.H;
        if (aVar4.d) {
            S2(aVar4);
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
            Q2(this.H);
            c cVar4 = this.t;
            cVar4.h = iMax2;
            cVar4.d += cVar4.e;
            Y1(vVar, cVar4, zVar, false);
            c cVar5 = this.t;
            i = cVar5.b;
            int i11 = cVar5.c;
            if (i11 > 0) {
                R2(i9, i2);
                c cVar6 = this.t;
                cVar6.h = i11;
                Y1(vVar, cVar6, zVar, false);
                i2 = this.t.b;
            }
        } else {
            Q2(aVar4);
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
            S2(this.H);
            c cVar9 = this.t;
            cVar9.h = iMax;
            cVar9.d += cVar9.e;
            Y1(vVar, cVar9, zVar, false);
            c cVar10 = this.t;
            i2 = cVar10.b;
            int i14 = cVar10.c;
            if (i14 > 0) {
                P2(i12, i);
                c cVar11 = this.t;
                cVar11.h = i14;
                Y1(vVar, cVar11, zVar, false);
                i = this.t.b;
            }
        }
        if (K() > 0) {
            if (this.z ^ this.A) {
                int iP22 = p2(i, vVar, zVar, true);
                i3 = i2 + iP22;
                i4 = i + iP22;
                iP2 = q2(i3, vVar, zVar, false);
            } else {
                int iQ2 = q2(i2, vVar, zVar, true);
                i3 = i2 + iQ2;
                i4 = i + iQ2;
                iP2 = p2(i4, vVar, zVar, false);
            }
            i2 = i3 + iP2;
            i = i4 + iP2;
        }
        y2(vVar, zVar, i2, i);
        if (zVar.e()) {
            this.H.e();
        } else {
            this.u.s();
        }
        this.w = this.A;
    }

    @Override // androidx.recyclerview.widget.l.h
    public void b(View view, View view2, int i, int i2) {
        h("Cannot drop a view during a scroll or layout calculation");
        X1();
        F2();
        int iI0 = i0(view);
        int iI02 = i0(view2);
        char c2 = iI0 < iI02 ? (char) 1 : (char) 65535;
        if (this.z) {
            if (c2 == 1) {
                H2(iI02, this.u.i() - (this.u.g(view2) + this.u.e(view)));
                return;
            } else {
                H2(iI02, this.u.i() - this.u.d(view2));
                return;
            }
        }
        if (c2 == 65535) {
            H2(iI02, this.u.g(view2));
        } else {
            H2(iI02, this.u.d(view2) - this.u.e(view));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void b1(RecyclerView.z zVar) {
        super.b1(zVar);
        this.G = null;
        this.C = -1;
        this.E = RecyclerView.UNDEFINED_DURATION;
        this.H.e();
    }

    View b2(boolean z, boolean z2) {
        return this.z ? i2(0, K(), z, z2) : i2(K() - 1, -1, z, z2);
    }

    View c2(boolean z, boolean z2) {
        return this.z ? i2(K() - 1, -1, z, z2) : i2(0, K(), z, z2);
    }

    public int d2() {
        View viewI2 = i2(0, K(), false, true);
        if (viewI2 == null) {
            return -1;
        }
        return i0(viewI2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void f1(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.G = (SavedState) parcelable;
            w1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public Parcelable g1() {
        if (this.G != null) {
            return new SavedState(this.G);
        }
        SavedState savedState = new SavedState();
        if (K() > 0) {
            X1();
            boolean z = this.w ^ this.z;
            savedState.c = z;
            if (z) {
                View viewR2 = r2();
                savedState.b = this.u.i() - this.u.d(viewR2);
                savedState.a = i0(viewR2);
            } else {
                View viewS2 = s2();
                savedState.a = i0(viewS2);
                savedState.b = this.u.g(viewS2) - this.u.m();
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
        if (this.G == null) {
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
        return !this.y && this.s == 0;
    }

    View l2(RecyclerView.v vVar, RecyclerView.z zVar, int i, int i2, int i3) {
        X1();
        int iM = this.v ? 0 : this.u.m();
        int i4 = this.u.i();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View viewJ = J(i);
            int iI0 = i0(viewJ);
            if (iI0 >= 0 && iI0 < i3) {
                if (((RecyclerView.LayoutParams) viewJ.getLayoutParams()).c()) {
                    if (view2 == null) {
                        view2 = viewJ;
                    }
                } else {
                    if (this.u.g(viewJ) < i4 && this.u.d(viewJ) >= iM) {
                        return viewJ;
                    }
                    if (view == null) {
                        view = viewJ;
                    }
                }
            }
            i += i5;
        }
        return view != null ? view : view2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public boolean m() {
        return !this.y && this.s == 1;
    }

    protected int o2() {
        return 0;
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
        O2(i > 0 ? 1 : -1, Math.abs(i), true, zVar);
        R1(zVar, this.t, cVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void q(int i, RecyclerView.p.c cVar) {
        boolean z;
        int i2;
        SavedState savedState = this.G;
        if (savedState == null || !savedState.a()) {
            F2();
            z = this.z;
            i2 = this.C;
            if (i2 == -1) {
                i2 = z ? i - 1 : 0;
            }
        } else {
            SavedState savedState2 = this.G;
            z = savedState2.c;
            i2 = savedState2.a;
        }
        int i3 = z ? -1 : 1;
        for (int i4 = 0; i4 < this.J && i2 >= 0 && i2 < i; i4++) {
            cVar.a(i2, 0);
            i2 += i3;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public int r(RecyclerView.z zVar) {
        return S1(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public int s(RecyclerView.z zVar) {
        return T1(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public int t(RecyclerView.z zVar) {
        return U1(zVar);
    }

    protected int t2(RecyclerView.z zVar) {
        if (zVar.d()) {
            return this.u.n();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public int u(RecyclerView.z zVar) {
        return S1(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public boolean u0() {
        return true;
    }

    public int u2() {
        return this.s;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public int v(RecyclerView.z zVar) {
        return T1(zVar);
    }

    public int v2() {
        return this.u.m();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public int w(RecyclerView.z zVar) {
        return U1(zVar);
    }

    protected boolean w2() {
        return a0() == 1;
    }

    void x2(RecyclerView.v vVar, RecyclerView.z zVar, c cVar, b bVar) {
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
            if (this.z == (cVar.f == -1)) {
                e(viewD);
            } else {
                f(viewD, 0);
            }
        } else {
            if (this.z == (cVar.f == -1)) {
                c(viewD);
            } else {
                d(viewD, 0);
            }
        }
        D0(viewD, 0, 0);
        bVar.a = this.u.e(viewD);
        if (this.s == 1) {
            if (w2()) {
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
    public int z1(int i, RecyclerView.v vVar, RecyclerView.z zVar) {
        if (this.s == 1) {
            return 0;
        }
        return G2(i, vVar, zVar);
    }

    void z2(RecyclerView.v vVar, RecyclerView.z zVar, a aVar, int i) {
    }

    public LinearLayoutManagerTgwidget(Context context, int i, boolean z) {
        this.s = 1;
        this.v = false;
        this.x = false;
        this.y = false;
        this.z = false;
        this.A = false;
        this.B = true;
        this.C = -1;
        this.D = true;
        this.E = RecyclerView.UNDEFINED_DURATION;
        this.G = null;
        this.H = new a();
        this.I = new b();
        this.J = 2;
        this.K = new int[2];
        this.L = true;
        this.M = true;
        J2(i);
        K2(z);
    }
}
