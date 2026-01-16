package ir.nasim.chat.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.t;
import ir.nasim.AbstractC22913w2;
import ir.nasim.C8697Wz3;
import ir.nasim.Z2;
import java.util.List;

/* loaded from: classes4.dex */
public class ChatLinearLayoutManager extends RecyclerView.p {
    private boolean C;
    private boolean F;
    int s;
    private c t;
    t u;
    private boolean v;
    private boolean w = false;
    boolean x = false;
    private boolean y = false;
    private boolean z = true;
    int A = -1;
    int B = RecyclerView.UNDEFINED_DURATION;
    SavedState D = null;
    final a E = new a();

    static class SavedState implements Parcelable {
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

    class a {
        int a;
        int b;
        boolean c;

        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean e(View view, RecyclerView.z zVar) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return !layoutParams.c() && layoutParams.a() >= 0 && layoutParams.a() < zVar.b();
        }

        void b() {
            this.b = this.c ? ChatLinearLayoutManager.this.u.i() : ChatLinearLayoutManager.this.u.m();
        }

        public void c(View view) {
            if (this.c) {
                this.b = ChatLinearLayoutManager.this.u.d(view) + ChatLinearLayoutManager.this.u.o();
            } else {
                this.b = ChatLinearLayoutManager.this.u.g(view);
            }
            this.a = ChatLinearLayoutManager.this.i0(view);
        }

        public void d(View view) {
            int iO = ChatLinearLayoutManager.this.u.o();
            if (iO >= 0) {
                c(view);
                return;
            }
            this.a = ChatLinearLayoutManager.this.i0(view);
            if (this.c) {
                int i = (ChatLinearLayoutManager.this.u.i() - iO) - ChatLinearLayoutManager.this.u.d(view);
                this.b = ChatLinearLayoutManager.this.u.i() - i;
                if (i > 0) {
                    int iE = this.b - ChatLinearLayoutManager.this.u.e(view);
                    int iM = ChatLinearLayoutManager.this.u.m();
                    int iMin = iE - (iM + Math.min(ChatLinearLayoutManager.this.u.g(view) - iM, 0));
                    if (iMin < 0) {
                        this.b += Math.min(i, -iMin);
                        return;
                    }
                    return;
                }
                return;
            }
            int iG = ChatLinearLayoutManager.this.u.g(view);
            int iM2 = iG - ChatLinearLayoutManager.this.u.m();
            this.b = iG;
            if (iM2 > 0) {
                int i2 = (ChatLinearLayoutManager.this.u.i() - Math.min(0, (ChatLinearLayoutManager.this.u.i() - iO) - ChatLinearLayoutManager.this.u.d(view))) - (iG + ChatLinearLayoutManager.this.u.e(view));
                if (i2 < 0) {
                    this.b -= Math.min(iM2, -i2);
                }
            }
        }

        void f() {
            this.a = -1;
            this.b = RecyclerView.UNDEFINED_DURATION;
            this.c = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.a + ", mCoordinate=" + this.b + ", mLayoutFromEnd=" + this.c + '}';
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
        int j;
        boolean a = true;
        int h = 0;
        boolean i = false;
        List k = null;

        c() {
        }

        private View e() {
            int size = this.k.size();
            for (int i = 0; i < size; i++) {
                RecyclerView.C c = (RecyclerView.C) this.k.get(i);
                if (this.d == c.N()) {
                    b(c);
                    return c.a;
                }
            }
            return null;
        }

        public void a() {
            b(null);
        }

        public void b(RecyclerView.C c) {
            RecyclerView.C cF = f(c);
            this.d = cF == null ? -1 : cF.N();
        }

        boolean c(RecyclerView.z zVar) {
            int i = this.d;
            return i >= 0 && i < zVar.b();
        }

        View d(RecyclerView.v vVar) {
            if (this.k != null) {
                return e();
            }
            View viewO = vVar.o(this.d);
            this.d += this.e;
            return viewO;
        }

        public RecyclerView.C f(RecyclerView.C c) {
            int iN;
            int size = this.k.size();
            RecyclerView.C c2 = null;
            int i = Integer.MAX_VALUE;
            for (int i2 = 0; i2 < size; i2++) {
                RecyclerView.C c3 = (RecyclerView.C) this.k.get(i2);
                if (c3 != c && (iN = (c3.N() - this.d) * this.e) >= 0 && iN < i) {
                    c2 = c3;
                    if (iN == 0) {
                        break;
                    }
                    i = iN;
                }
            }
            return c2;
        }
    }

    public ChatLinearLayoutManager(int i, boolean z) {
        y2(i);
        z2(z);
    }

    private boolean B2(RecyclerView.z zVar, a aVar) {
        if (K() == 0) {
            return false;
        }
        View viewW = W();
        if (viewW != null && aVar.e(viewW, zVar)) {
            aVar.d(viewW);
            return true;
        }
        View viewG2 = aVar.c ? g2(zVar) : h2(zVar);
        if (viewG2 == null) {
            return false;
        }
        aVar.c(viewG2);
        if (!zVar.e() && P1() && (this.u.g(viewG2) >= this.u.i() || this.u.d(viewG2) < this.u.m())) {
            aVar.b = aVar.c ? this.u.i() : this.u.m();
        }
        return true;
    }

    private boolean C2(RecyclerView.z zVar, a aVar) {
        int i;
        if (!zVar.e() && (i = this.A) != -1) {
            if (i >= 0 && i < zVar.b()) {
                aVar.a = this.A;
                SavedState savedState = this.D;
                if (savedState != null && savedState.a()) {
                    boolean z = this.D.c;
                    aVar.c = z;
                    if (z) {
                        aVar.b = this.u.i() - this.D.b;
                    } else {
                        aVar.b = this.u.m() + this.D.b;
                    }
                    return true;
                }
                if (this.B != Integer.MIN_VALUE) {
                    boolean z2 = this.F;
                    aVar.c = z2 ? false : this.x;
                    if (z2) {
                        aVar.c = false;
                        aVar.b = this.u.m() + this.B;
                        this.F = false;
                    } else if (this.x) {
                        aVar.b = this.u.i() - this.B;
                    } else {
                        aVar.b = this.u.m() + this.B;
                    }
                    return true;
                }
                View viewD = D(this.A);
                if (viewD == null) {
                    if (K() > 0) {
                        aVar.c = (this.A < i0(J(0))) == this.x;
                    }
                    aVar.b();
                } else {
                    if (this.u.e(viewD) > this.u.n()) {
                        aVar.b();
                        return true;
                    }
                    if (this.u.g(viewD) - this.u.m() < 0) {
                        aVar.b = this.u.m();
                        aVar.c = false;
                        return true;
                    }
                    if (this.u.i() - this.u.d(viewD) < 0) {
                        aVar.b = this.u.i();
                        aVar.c = true;
                        return true;
                    }
                    aVar.b = aVar.c ? this.u.d(viewD) + this.u.o() : this.u.g(viewD);
                }
                return true;
            }
            this.A = -1;
            this.B = RecyclerView.UNDEFINED_DURATION;
        }
        return false;
    }

    private void D2(RecyclerView.z zVar, a aVar) {
        if (C2(zVar, aVar) || B2(zVar, aVar)) {
            return;
        }
        aVar.b();
        aVar.a = this.y ? zVar.b() - 1 : 0;
    }

    private void E2(int i, int i2, boolean z, RecyclerView.z zVar) {
        int iM;
        this.t.h = m2(zVar);
        c cVar = this.t;
        cVar.f = i;
        if (i == 1) {
            cVar.h += this.u.j();
            View viewK2 = k2();
            c cVar2 = this.t;
            cVar2.e = this.x ? -1 : 1;
            int iI0 = i0(viewK2);
            c cVar3 = this.t;
            cVar2.d = iI0 + cVar3.e;
            cVar3.b = this.u.d(viewK2);
            iM = this.u.d(viewK2) - this.u.i();
        } else {
            View viewL2 = l2();
            this.t.h += this.u.m();
            c cVar4 = this.t;
            cVar4.e = this.x ? 1 : -1;
            int iI02 = i0(viewL2);
            c cVar5 = this.t;
            cVar4.d = iI02 + cVar5.e;
            cVar5.b = this.u.g(viewL2);
            iM = (-this.u.g(viewL2)) + this.u.m();
        }
        c cVar6 = this.t;
        cVar6.c = i2;
        if (z) {
            cVar6.c = i2 - iM;
        }
        cVar6.g = iM;
    }

    private void F2(int i, int i2) {
        this.t.c = this.u.i() - i2;
        c cVar = this.t;
        cVar.e = this.x ? -1 : 1;
        cVar.d = i;
        cVar.f = 1;
        cVar.b = i2;
        cVar.g = RecyclerView.UNDEFINED_DURATION;
    }

    private void G2(a aVar) {
        F2(aVar.a, aVar.b);
    }

    private void H2(int i, int i2) {
        this.t.c = i2 - this.u.m();
        c cVar = this.t;
        cVar.d = i;
        cVar.e = this.x ? 1 : -1;
        cVar.f = -1;
        cVar.b = i2;
        cVar.g = RecyclerView.UNDEFINED_DURATION;
    }

    private void I2(a aVar) {
        H2(aVar.a, aVar.b);
    }

    private int Q1(RecyclerView.z zVar) {
        if (K() == 0) {
            return 0;
        }
        V1();
        return ir.nasim.chat.util.a.a(zVar, this.u, a2(!this.z, true), Z1(!this.z, true), this, this.z);
    }

    private int R1(RecyclerView.z zVar) {
        if (K() == 0) {
            return 0;
        }
        V1();
        return ir.nasim.chat.util.a.b(zVar, this.u, a2(!this.z, true), Z1(!this.z, true), this, this.z, this.x);
    }

    private int S1(RecyclerView.z zVar) {
        if (K() == 0) {
            return 0;
        }
        V1();
        return ir.nasim.chat.util.a.c(zVar, this.u, a2(!this.z, true), Z1(!this.z, true), this, this.z);
    }

    private int T1(int i) {
        if (i == 1) {
            return -1;
        }
        if (i == 2) {
            return 1;
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

    private View Y1(int i) {
        return f2(0, K(), i);
    }

    private View Z1(boolean z, boolean z2) {
        return this.x ? e2(0, K(), z, z2) : e2(K() - 1, -1, z, z2);
    }

    private View a2(boolean z, boolean z2) {
        return this.x ? e2(K() - 1, -1, z, z2) : e2(0, K(), z, z2);
    }

    private View c2(int i) {
        return f2(K() - 1, -1, i);
    }

    private View g2(RecyclerView.z zVar) {
        return this.x ? Y1(zVar.b()) : c2(zVar.b());
    }

    private View h2(RecyclerView.z zVar) {
        return this.x ? c2(zVar.b()) : Y1(zVar.b());
    }

    private int i2(int i, RecyclerView.v vVar, RecyclerView.z zVar, boolean z) {
        int i2;
        int i3 = this.u.i() - i;
        if (i3 <= 0) {
            return 0;
        }
        int i4 = -w2(-i3, vVar, zVar);
        int i5 = i + i4;
        if (!z || (i2 = this.u.i() - i5) <= 0) {
            return i4;
        }
        this.u.r(i2);
        return i2 + i4;
    }

    private int j2(int i, RecyclerView.v vVar, RecyclerView.z zVar, boolean z) {
        int iM;
        int iM2 = i - this.u.m();
        if (iM2 <= 0) {
            return 0;
        }
        int i2 = -w2(iM2, vVar, zVar);
        int i3 = i + i2;
        if (!z || (iM = i3 - this.u.m()) <= 0) {
            return i2;
        }
        this.u.r(-iM);
        return i2 - iM;
    }

    private View k2() {
        return J(this.x ? 0 : K() - 1);
    }

    private View l2() {
        return J(this.x ? K() - 1 : 0);
    }

    private void p2(RecyclerView.v vVar, RecyclerView.z zVar, int i, int i2) {
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
            if ((c2.N() < iI0) != this.x) {
                iE += this.u.e(c2.a);
            } else {
                iE2 += this.u.e(c2.a);
            }
        }
        this.t.k = listK;
        if (iE > 0) {
            H2(i0(l2()), i);
            c cVar = this.t;
            cVar.h = iE;
            cVar.c = 0;
            cVar.a();
            W1(vVar, this.t, zVar, false);
        }
        if (iE2 > 0) {
            F2(i0(k2()), i2);
            c cVar2 = this.t;
            cVar2.h = iE2;
            cVar2.c = 0;
            cVar2.a();
            W1(vVar, this.t, zVar, false);
        }
        this.t.k = null;
    }

    private void r2(RecyclerView.v vVar, c cVar) {
        if (cVar.a) {
            if (cVar.f == -1) {
                t2(vVar, cVar.g);
            } else {
                u2(vVar, cVar.g);
            }
        }
    }

    private void s2(RecyclerView.v vVar, int i, int i2) {
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

    private void t2(RecyclerView.v vVar, int i) {
        int iK = K();
        if (i < 0) {
            return;
        }
        int iH = this.u.h() - i;
        if (this.x) {
            for (int i2 = 0; i2 < iK; i2++) {
                if (this.u.g(J(i2)) < iH) {
                    s2(vVar, 0, i2);
                    return;
                }
            }
            return;
        }
        int i3 = iK - 1;
        for (int i4 = i3; i4 >= 0; i4--) {
            if (this.u.g(J(i4)) < iH) {
                s2(vVar, i3, i4);
                return;
            }
        }
    }

    private void u2(RecyclerView.v vVar, int i) {
        if (i < 0) {
            return;
        }
        int iK = K();
        if (!this.x) {
            for (int i2 = 0; i2 < iK; i2++) {
                if (this.u.d(J(i2)) > i) {
                    s2(vVar, 0, i2);
                    return;
                }
            }
            return;
        }
        int i3 = iK - 1;
        for (int i4 = i3; i4 >= 0; i4--) {
            if (this.u.d(J(i4)) > i) {
                s2(vVar, i3, i4);
                return;
            }
        }
    }

    private void v2() {
        if (this.s == 1 || !n2()) {
            this.x = this.w;
        } else {
            this.x = !this.w;
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

    public void A2(boolean z) {
        if (this.y == z) {
            return;
        }
        this.y = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public int B1(int i, RecyclerView.v vVar, RecyclerView.z zVar) {
        if (this.s == 0) {
            return 0;
        }
        return w2(i, vVar, zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public View D(int i) {
        int iI0;
        int iK = K();
        if (iK != 0 && (iI0 = i - i0(J(0))) >= 0 && iI0 < iK) {
            return J(iI0);
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public RecyclerView.LayoutParams E() {
        return new RecyclerView.LayoutParams(-2, -2);
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
        C8697Wz3 c8697Wz3 = new C8697Wz3(recyclerView.getContext());
        c8697Wz3.p(i);
        M1(c8697Wz3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public View M0(View view, int i, RecyclerView.v vVar, RecyclerView.z zVar) {
        int iT1;
        v2();
        if (K() == 0 || (iT1 = T1(i)) == Integer.MIN_VALUE) {
            return null;
        }
        V1();
        View viewH2 = iT1 == -1 ? h2(zVar) : g2(zVar);
        if (viewH2 == null) {
            return null;
        }
        V1();
        E2(iT1, (int) (this.u.n() * 0.33f), false, zVar);
        c cVar = this.t;
        cVar.g = RecyclerView.UNDEFINED_DURATION;
        cVar.a = false;
        W1(vVar, cVar, zVar, true);
        View viewL2 = iT1 == -1 ? l2() : k2();
        if (viewL2 == viewH2 || !viewL2.isFocusable()) {
            return null;
        }
        return viewL2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void N0(AccessibilityEvent accessibilityEvent) {
        super.N0(accessibilityEvent);
        if (K() > 0) {
            Z2 z2A = AbstractC22913w2.a(accessibilityEvent);
            z2A.a(b2());
            z2A.e(d2());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public boolean P1() {
        return false;
    }

    c U1() {
        return new c();
    }

    void V1() {
        if (this.t == null) {
            this.t = U1();
        }
        if (this.u == null) {
            this.u = t.b(this, this.s);
        }
    }

    int W1(RecyclerView.v vVar, c cVar, RecyclerView.z zVar, boolean z) {
        int i = cVar.c;
        int i2 = cVar.g;
        if (i2 != Integer.MIN_VALUE) {
            if (i < 0) {
                cVar.g = i2 + i;
            }
            r2(vVar, cVar);
        }
        int i3 = cVar.c + cVar.h;
        b bVar = new b();
        while (i3 > 0 && cVar.c(zVar)) {
            bVar.a();
            o2(vVar, zVar, cVar, bVar);
            if (!bVar.b) {
                cVar.b += bVar.a * cVar.f;
                if (!bVar.c || this.t.k != null || !zVar.e()) {
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
                    r2(vVar, cVar);
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

    public int X1() {
        View viewE2 = e2(0, K(), true, false);
        if (viewE2 == null) {
            return -1;
        }
        return i0(viewE2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void a1(RecyclerView.v vVar, RecyclerView.z zVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int iI2;
        int i6;
        View viewD;
        int iG;
        int i7;
        SavedState savedState = this.D;
        if (savedState != null && savedState.a()) {
            this.A = this.D.a;
        }
        V1();
        this.t.a = false;
        v2();
        this.E.f();
        a aVar = this.E;
        aVar.c = this.x ^ this.y;
        D2(zVar, aVar);
        int iM2 = m2(zVar);
        if (this.t.j >= 0) {
            i = iM2;
            iM2 = 0;
        } else {
            i = 0;
        }
        int iM = iM2 + this.u.m();
        int iJ = i + this.u.j();
        if (zVar.e() && (i6 = this.A) != -1 && this.B != Integer.MIN_VALUE && (viewD = D(i6)) != null) {
            if (this.x) {
                i7 = this.u.i() - this.u.d(viewD);
                iG = this.B;
            } else {
                iG = this.u.g(viewD) - this.u.m();
                i7 = this.B;
            }
            int i8 = i7 - iG;
            if (i8 > 0) {
                iM += i8;
            } else {
                iJ -= i8;
            }
        }
        q2(zVar, this.E);
        x(vVar);
        this.t.i = zVar.e();
        a aVar2 = this.E;
        if (aVar2.c) {
            I2(aVar2);
            c cVar = this.t;
            cVar.h = iM;
            W1(vVar, cVar, zVar, false);
            c cVar2 = this.t;
            i2 = cVar2.b;
            int i9 = cVar2.d;
            int i10 = cVar2.c;
            if (i10 > 0) {
                iJ += i10;
            }
            G2(this.E);
            c cVar3 = this.t;
            cVar3.h = iJ;
            cVar3.d += cVar3.e;
            W1(vVar, cVar3, zVar, false);
            c cVar4 = this.t;
            i3 = cVar4.b;
            int i11 = cVar4.c;
            if (i11 > 0) {
                H2(i9, i2);
                c cVar5 = this.t;
                cVar5.h = i11;
                W1(vVar, cVar5, zVar, false);
                i2 = this.t.b;
            }
        } else {
            G2(aVar2);
            c cVar6 = this.t;
            cVar6.h = iJ;
            W1(vVar, cVar6, zVar, false);
            c cVar7 = this.t;
            int i12 = cVar7.b;
            int i13 = cVar7.d;
            int i14 = cVar7.c;
            if (i14 > 0) {
                iM += i14;
            }
            I2(this.E);
            c cVar8 = this.t;
            cVar8.h = iM;
            cVar8.d += cVar8.e;
            W1(vVar, cVar8, zVar, false);
            c cVar9 = this.t;
            int i15 = cVar9.b;
            int i16 = cVar9.c;
            if (i16 > 0) {
                F2(i13, i12);
                c cVar10 = this.t;
                cVar10.h = i16;
                W1(vVar, cVar10, zVar, false);
                i2 = i15;
                i3 = this.t.b;
            } else {
                i2 = i15;
                i3 = i12;
            }
        }
        if (K() > 0) {
            if (this.x ^ this.y) {
                int iI22 = i2(i3, vVar, zVar, true);
                i4 = i2 + iI22;
                i5 = i3 + iI22;
                iI2 = j2(i4, vVar, zVar, false);
            } else {
                int iJ2 = j2(i2, vVar, zVar, true);
                i4 = i2 + iJ2;
                i5 = i3 + iJ2;
                iI2 = i2(i5, vVar, zVar, false);
            }
            i2 = i4 + iI2;
            i3 = i5 + iI2;
        }
        p2(vVar, zVar, i2, i3);
        if (!zVar.e()) {
            this.A = -1;
            this.B = RecyclerView.UNDEFINED_DURATION;
            this.u.s();
        }
        this.v = this.y;
        this.D = null;
    }

    public int b2() {
        View viewE2 = e2(0, K(), false, true);
        if (viewE2 == null) {
            return -1;
        }
        return i0(viewE2);
    }

    public int d2() {
        View viewE2 = e2(K() - 1, -1, false, true);
        if (viewE2 == null) {
            return -1;
        }
        return i0(viewE2);
    }

    View e2(int i, int i2, boolean z, boolean z2) {
        V1();
        int iM = this.u.m();
        int i3 = this.u.i();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View viewJ = J(i);
            if (viewJ != null) {
                int iG = this.u.g(viewJ);
                int iD = this.u.d(viewJ);
                if (iG < i3 && iD > iM) {
                    if (!z) {
                        return viewJ;
                    }
                    if (iG >= iM && iD <= i3) {
                        return viewJ;
                    }
                    if (z2 && view == null) {
                        view = viewJ;
                    }
                }
            }
            i += i4;
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void f1(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.D = (SavedState) parcelable;
            w1();
        }
    }

    View f2(int i, int i2, int i3) {
        V1();
        int iM = this.u.m();
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
    public Parcelable g1() {
        if (this.D != null) {
            return new SavedState(this.D);
        }
        SavedState savedState = new SavedState();
        if (K() > 0) {
            V1();
            boolean z = this.v ^ this.x;
            savedState.c = z;
            if (z) {
                View viewK2 = k2();
                savedState.b = this.u.i() - this.u.d(viewK2);
                savedState.a = i0(viewK2);
            } else {
                View viewL2 = l2();
                savedState.a = i0(viewL2);
                savedState.b = this.u.g(viewL2) - this.u.m();
            }
        } else {
            savedState.b();
        }
        return savedState;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void h(String str) {
        if (this.D == null) {
            super.h(str);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public boolean l() {
        return this.s == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public boolean m() {
        return this.s == 1;
    }

    protected int m2(RecyclerView.z zVar) {
        if (zVar.d()) {
            return this.u.n();
        }
        return 0;
    }

    protected boolean n2() {
        return a0() == 1;
    }

    void o2(RecyclerView.v vVar, RecyclerView.z zVar, c cVar, b bVar) {
        int iF0;
        int i;
        int i2;
        int iF;
        View viewD = cVar.d(vVar);
        if (viewD == null) {
            bVar.b = true;
            return;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) viewD.getLayoutParams();
        if (cVar.k == null) {
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
            if (n2()) {
                iF = p0() - g0();
                iF0 = iF - this.u.f(viewD);
            } else {
                iF0 = f0();
                iF = this.u.f(viewD) + iF0;
            }
            if (cVar.f == -1) {
                i = cVar.b;
                i2 = i - bVar.a;
            } else {
                i2 = cVar.b;
                i = bVar.a + i2;
            }
        } else {
            int iH0 = h0();
            int iF2 = this.u.f(viewD) + iH0;
            if (cVar.f == -1) {
                int i3 = cVar.b;
                int i4 = i3 - bVar.a;
                iF = i3;
                i = iF2;
                iF0 = i4;
                i2 = iH0;
            } else {
                int i5 = cVar.b;
                int i6 = bVar.a + i5;
                iF0 = i5;
                i = iF2;
                i2 = iH0;
                iF = i6;
            }
        }
        B0(viewD, iF0 + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + i2, iF - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, i - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        if (layoutParams.c() || layoutParams.b()) {
            bVar.c = true;
        }
        bVar.d = viewD.isFocusable();
    }

    void q2(RecyclerView.z zVar, a aVar) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public int r(RecyclerView.z zVar) {
        return Q1(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public int s(RecyclerView.z zVar) {
        return R1(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public int t(RecyclerView.z zVar) {
        return S1(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public int u(RecyclerView.z zVar) {
        return Q1(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public int v(RecyclerView.z zVar) {
        return R1(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public int w(RecyclerView.z zVar) {
        return S1(zVar);
    }

    int w2(int i, RecyclerView.v vVar, RecyclerView.z zVar) {
        if (K() == 0 || i == 0) {
            return 0;
        }
        this.t.a = true;
        V1();
        int i2 = i > 0 ? 1 : -1;
        int iAbs = Math.abs(i);
        E2(i2, iAbs, true, zVar);
        c cVar = this.t;
        int iW1 = cVar.g + W1(vVar, cVar, zVar, false);
        if (iW1 < 0) {
            return 0;
        }
        if (iAbs > iW1) {
            i = i2 * iW1;
        }
        this.u.r(-i);
        this.t.j = i;
        return i;
    }

    public void x2(int i, int i2) {
        this.F = true;
        this.A = i;
        this.B = i2;
        SavedState savedState = this.D;
        if (savedState != null) {
            savedState.b();
        }
        w1();
    }

    public void y2(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i);
        }
        h(null);
        if (i == this.s) {
            return;
        }
        this.s = i;
        this.u = null;
        w1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public int z1(int i, RecyclerView.v vVar, RecyclerView.z zVar) {
        if (this.s == 1) {
            return 0;
        }
        return w2(i, vVar, zVar);
    }

    public void z2(boolean z) {
        h(null);
        if (z == this.w) {
            return;
        }
        this.w = z;
        w1();
    }
}
