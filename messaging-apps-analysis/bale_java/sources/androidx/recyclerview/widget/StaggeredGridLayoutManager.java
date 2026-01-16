package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* loaded from: classes2.dex */
public class StaggeredGridLayoutManager extends RecyclerView.p implements RecyclerView.y.b {
    private BitSet B;
    private boolean G;
    private boolean H;
    private SavedState I;
    private int J;
    private int[] O;
    c[] t;
    t u;
    t v;
    private int w;
    private int x;
    private final n y;
    private int s = -1;
    boolean z = false;
    boolean A = false;
    int C = -1;
    int D = RecyclerView.UNDEFINED_DURATION;
    LazySpanLookup E = new LazySpanLookup();
    private int F = 2;
    private final Rect K = new Rect();
    private final b L = new b();
    private boolean M = false;
    private boolean N = true;
    private final Runnable P = new a();

    public static class LayoutParams extends RecyclerView.LayoutParams {
        c e;
        boolean f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public boolean e() {
            return this.f;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        int a;
        int b;
        int c;
        int[] d;
        int e;
        int[] f;
        List g;
        boolean h;
        boolean i;
        boolean j;

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

        void a() {
            this.d = null;
            this.c = 0;
            this.a = -1;
            this.b = -1;
        }

        void b() {
            this.d = null;
            this.c = 0;
            this.e = 0;
            this.f = null;
            this.g = null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c);
            if (this.c > 0) {
                parcel.writeIntArray(this.d);
            }
            parcel.writeInt(this.e);
            if (this.e > 0) {
                parcel.writeIntArray(this.f);
            }
            parcel.writeInt(this.h ? 1 : 0);
            parcel.writeInt(this.i ? 1 : 0);
            parcel.writeInt(this.j ? 1 : 0);
            parcel.writeList(this.g);
        }

        SavedState(Parcel parcel) {
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            int i = parcel.readInt();
            this.c = i;
            if (i > 0) {
                int[] iArr = new int[i];
                this.d = iArr;
                parcel.readIntArray(iArr);
            }
            int i2 = parcel.readInt();
            this.e = i2;
            if (i2 > 0) {
                int[] iArr2 = new int[i2];
                this.f = iArr2;
                parcel.readIntArray(iArr2);
            }
            this.h = parcel.readInt() == 1;
            this.i = parcel.readInt() == 1;
            this.j = parcel.readInt() == 1;
            this.g = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.c = savedState.c;
            this.a = savedState.a;
            this.b = savedState.b;
            this.d = savedState.d;
            this.e = savedState.e;
            this.f = savedState.f;
            this.h = savedState.h;
            this.i = savedState.i;
            this.j = savedState.j;
            this.g = savedState.g;
        }
    }

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.W1();
        }
    }

    class b {
        int a;
        int b;
        boolean c;
        boolean d;
        boolean e;
        int[] f;

        b() {
            c();
        }

        void a() {
            this.b = this.c ? StaggeredGridLayoutManager.this.u.i() : StaggeredGridLayoutManager.this.u.m();
        }

        void b(int i) {
            if (this.c) {
                this.b = StaggeredGridLayoutManager.this.u.i() - i;
            } else {
                this.b = StaggeredGridLayoutManager.this.u.m() + i;
            }
        }

        void c() {
            this.a = -1;
            this.b = RecyclerView.UNDEFINED_DURATION;
            this.c = false;
            this.d = false;
            this.e = false;
            int[] iArr = this.f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        void d(c[] cVarArr) {
            int length = cVarArr.length;
            int[] iArr = this.f;
            if (iArr == null || iArr.length < length) {
                this.f = new int[StaggeredGridLayoutManager.this.t.length];
            }
            for (int i = 0; i < length; i++) {
                this.f[i] = cVarArr[i].p(RecyclerView.UNDEFINED_DURATION);
            }
        }
    }

    class c {
        ArrayList a = new ArrayList();
        int b = RecyclerView.UNDEFINED_DURATION;
        int c = RecyclerView.UNDEFINED_DURATION;
        int d = 0;
        final int e;

        c(int i) {
            this.e = i;
        }

        void a(View view) {
            LayoutParams layoutParamsN = n(view);
            layoutParamsN.e = this;
            this.a.add(view);
            this.c = RecyclerView.UNDEFINED_DURATION;
            if (this.a.size() == 1) {
                this.b = RecyclerView.UNDEFINED_DURATION;
            }
            if (layoutParamsN.c() || layoutParamsN.b()) {
                this.d += StaggeredGridLayoutManager.this.u.e(view);
            }
        }

        void b(boolean z, int i) {
            int iL = z ? l(RecyclerView.UNDEFINED_DURATION) : p(RecyclerView.UNDEFINED_DURATION);
            e();
            if (iL == Integer.MIN_VALUE) {
                return;
            }
            if (!z || iL >= StaggeredGridLayoutManager.this.u.i()) {
                if (z || iL <= StaggeredGridLayoutManager.this.u.m()) {
                    if (i != Integer.MIN_VALUE) {
                        iL += i;
                    }
                    this.c = iL;
                    this.b = iL;
                }
            }
        }

        void c() {
            LazySpanLookup.FullSpanItem fullSpanItemF;
            ArrayList arrayList = this.a;
            View view = (View) arrayList.get(arrayList.size() - 1);
            LayoutParams layoutParamsN = n(view);
            this.c = StaggeredGridLayoutManager.this.u.d(view);
            if (layoutParamsN.f && (fullSpanItemF = StaggeredGridLayoutManager.this.E.f(layoutParamsN.a())) != null && fullSpanItemF.b == 1) {
                this.c += fullSpanItemF.a(this.e);
            }
        }

        void d() {
            LazySpanLookup.FullSpanItem fullSpanItemF;
            View view = (View) this.a.get(0);
            LayoutParams layoutParamsN = n(view);
            this.b = StaggeredGridLayoutManager.this.u.g(view);
            if (layoutParamsN.f && (fullSpanItemF = StaggeredGridLayoutManager.this.E.f(layoutParamsN.a())) != null && fullSpanItemF.b == -1) {
                this.b -= fullSpanItemF.a(this.e);
            }
        }

        void e() {
            this.a.clear();
            q();
            this.d = 0;
        }

        public int f() {
            return StaggeredGridLayoutManager.this.z ? i(this.a.size() - 1, -1, true) : i(0, this.a.size(), true);
        }

        public int g() {
            return StaggeredGridLayoutManager.this.z ? i(0, this.a.size(), true) : i(this.a.size() - 1, -1, true);
        }

        int h(int i, int i2, boolean z, boolean z2, boolean z3) {
            int iM = StaggeredGridLayoutManager.this.u.m();
            int i3 = StaggeredGridLayoutManager.this.u.i();
            int i4 = i2 > i ? 1 : -1;
            while (i != i2) {
                View view = (View) this.a.get(i);
                int iG = StaggeredGridLayoutManager.this.u.g(view);
                int iD = StaggeredGridLayoutManager.this.u.d(view);
                boolean z4 = false;
                boolean z5 = !z3 ? iG >= i3 : iG > i3;
                if (!z3 ? iD > iM : iD >= iM) {
                    z4 = true;
                }
                if (z5 && z4) {
                    if (z && z2) {
                        if (iG >= iM && iD <= i3) {
                            return StaggeredGridLayoutManager.this.i0(view);
                        }
                    } else {
                        if (z2) {
                            return StaggeredGridLayoutManager.this.i0(view);
                        }
                        if (iG < iM || iD > i3) {
                            return StaggeredGridLayoutManager.this.i0(view);
                        }
                    }
                }
                i += i4;
            }
            return -1;
        }

        int i(int i, int i2, boolean z) {
            return h(i, i2, false, false, z);
        }

        public int j() {
            return this.d;
        }

        int k() {
            int i = this.c;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            c();
            return this.c;
        }

        int l(int i) {
            int i2 = this.c;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.a.size() == 0) {
                return i;
            }
            c();
            return this.c;
        }

        public View m(int i, int i2) {
            View view = null;
            if (i2 != -1) {
                int size = this.a.size() - 1;
                while (size >= 0) {
                    View view2 = (View) this.a.get(size);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.z && staggeredGridLayoutManager.i0(view2) >= i) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.z && staggeredGridLayoutManager2.i0(view2) <= i) || !view2.hasFocusable()) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.a.size();
                int i3 = 0;
                while (i3 < size2) {
                    View view3 = (View) this.a.get(i3);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.z && staggeredGridLayoutManager3.i0(view3) <= i) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.z && staggeredGridLayoutManager4.i0(view3) >= i) || !view3.hasFocusable()) {
                        break;
                    }
                    i3++;
                    view = view3;
                }
            }
            return view;
        }

        LayoutParams n(View view) {
            return (LayoutParams) view.getLayoutParams();
        }

        int o() {
            int i = this.b;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            d();
            return this.b;
        }

        int p(int i) {
            int i2 = this.b;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.a.size() == 0) {
                return i;
            }
            d();
            return this.b;
        }

        void q() {
            this.b = RecyclerView.UNDEFINED_DURATION;
            this.c = RecyclerView.UNDEFINED_DURATION;
        }

        void r(int i) {
            int i2 = this.b;
            if (i2 != Integer.MIN_VALUE) {
                this.b = i2 + i;
            }
            int i3 = this.c;
            if (i3 != Integer.MIN_VALUE) {
                this.c = i3 + i;
            }
        }

        void s() {
            int size = this.a.size();
            View view = (View) this.a.remove(size - 1);
            LayoutParams layoutParamsN = n(view);
            layoutParamsN.e = null;
            if (layoutParamsN.c() || layoutParamsN.b()) {
                this.d -= StaggeredGridLayoutManager.this.u.e(view);
            }
            if (size == 1) {
                this.b = RecyclerView.UNDEFINED_DURATION;
            }
            this.c = RecyclerView.UNDEFINED_DURATION;
        }

        void t() {
            View view = (View) this.a.remove(0);
            LayoutParams layoutParamsN = n(view);
            layoutParamsN.e = null;
            if (this.a.size() == 0) {
                this.c = RecyclerView.UNDEFINED_DURATION;
            }
            if (layoutParamsN.c() || layoutParamsN.b()) {
                this.d -= StaggeredGridLayoutManager.this.u.e(view);
            }
            this.b = RecyclerView.UNDEFINED_DURATION;
        }

        void u(View view) {
            LayoutParams layoutParamsN = n(view);
            layoutParamsN.e = this;
            this.a.add(0, view);
            this.b = RecyclerView.UNDEFINED_DURATION;
            if (this.a.size() == 1) {
                this.c = RecyclerView.UNDEFINED_DURATION;
            }
            if (layoutParamsN.c() || layoutParamsN.b()) {
                this.d += StaggeredGridLayoutManager.this.u.e(view);
            }
        }

        void v(int i) {
            this.b = i;
            this.c = i;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        RecyclerView.p.d dVarJ0 = RecyclerView.p.j0(context, attributeSet, i, i2);
        L2(dVarJ0.a);
        N2(dVarJ0.b);
        M2(dVarJ0.c);
        this.y = new n();
        e2();
    }

    /* JADX WARN: Removed duplicated region for block: B:86:0x0155  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void A2(androidx.recyclerview.widget.RecyclerView.v r9, androidx.recyclerview.widget.RecyclerView.z r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 374
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.A2(androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$z, boolean):void");
    }

    private boolean B2(int i) {
        if (this.w == 0) {
            return (i == -1) != this.A;
        }
        return ((i == -1) == this.A) == x2();
    }

    private void D2(View view) {
        for (int i = this.s - 1; i >= 0; i--) {
            this.t[i].u(view);
        }
    }

    private void E2(RecyclerView.v vVar, n nVar) {
        if (!nVar.a || nVar.i) {
            return;
        }
        if (nVar.b == 0) {
            if (nVar.e == -1) {
                F2(vVar, nVar.g);
                return;
            } else {
                G2(vVar, nVar.f);
                return;
            }
        }
        if (nVar.e != -1) {
            int iR2 = r2(nVar.g) - nVar.g;
            G2(vVar, iR2 < 0 ? nVar.f : Math.min(iR2, nVar.b) + nVar.f);
        } else {
            int i = nVar.f;
            int iQ2 = i - q2(i);
            F2(vVar, iQ2 < 0 ? nVar.g : nVar.g - Math.min(iQ2, nVar.b));
        }
    }

    private void F2(RecyclerView.v vVar, int i) {
        for (int iK = K() - 1; iK >= 0; iK--) {
            View viewJ = J(iK);
            if (this.u.g(viewJ) < i || this.u.q(viewJ) < i) {
                return;
            }
            LayoutParams layoutParams = (LayoutParams) viewJ.getLayoutParams();
            if (layoutParams.f) {
                for (int i2 = 0; i2 < this.s; i2++) {
                    if (this.t[i2].a.size() == 1) {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.s; i3++) {
                    this.t[i3].s();
                }
            } else if (layoutParams.e.a.size() == 1) {
                return;
            } else {
                layoutParams.e.s();
            }
            p1(viewJ, vVar);
        }
    }

    private void G2(RecyclerView.v vVar, int i) {
        while (K() > 0) {
            View viewJ = J(0);
            if (this.u.d(viewJ) > i || this.u.p(viewJ) > i) {
                return;
            }
            LayoutParams layoutParams = (LayoutParams) viewJ.getLayoutParams();
            if (layoutParams.f) {
                for (int i2 = 0; i2 < this.s; i2++) {
                    if (this.t[i2].a.size() == 1) {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.s; i3++) {
                    this.t[i3].t();
                }
            } else if (layoutParams.e.a.size() == 1) {
                return;
            } else {
                layoutParams.e.t();
            }
            p1(viewJ, vVar);
        }
    }

    private void H2() {
        if (this.v.k() == 1073741824) {
            return;
        }
        int iK = K();
        float fMax = 0.0f;
        for (int i = 0; i < iK; i++) {
            View viewJ = J(i);
            float fE = this.v.e(viewJ);
            if (fE >= fMax) {
                if (((LayoutParams) viewJ.getLayoutParams()).e()) {
                    fE = (fE * 1.0f) / this.s;
                }
                fMax = Math.max(fMax, fE);
            }
        }
        int i2 = this.x;
        int iRound = Math.round(fMax * this.s);
        if (this.v.k() == Integer.MIN_VALUE) {
            iRound = Math.min(iRound, this.v.n());
        }
        T2(iRound);
        if (this.x == i2) {
            return;
        }
        for (int i3 = 0; i3 < iK; i3++) {
            View viewJ2 = J(i3);
            LayoutParams layoutParams = (LayoutParams) viewJ2.getLayoutParams();
            if (!layoutParams.f) {
                if (x2() && this.w == 1) {
                    int i4 = this.s;
                    int i5 = layoutParams.e.e;
                    viewJ2.offsetLeftAndRight(((-((i4 - 1) - i5)) * this.x) - ((-((i4 - 1) - i5)) * i2));
                } else {
                    int i6 = layoutParams.e.e;
                    int i7 = this.x * i6;
                    int i8 = i6 * i2;
                    if (this.w == 1) {
                        viewJ2.offsetLeftAndRight(i7 - i8);
                    } else {
                        viewJ2.offsetTopAndBottom(i7 - i8);
                    }
                }
            }
        }
    }

    private void I2() {
        if (this.w == 1 || !x2()) {
            this.A = this.z;
        } else {
            this.A = !this.z;
        }
    }

    private void K2(int i) {
        n nVar = this.y;
        nVar.e = i;
        nVar.d = this.A != (i == -1) ? -1 : 1;
    }

    private void O2(int i, int i2) {
        for (int i3 = 0; i3 < this.s; i3++) {
            if (!this.t[i3].a.isEmpty()) {
                U2(this.t[i3], i, i2);
            }
        }
    }

    private boolean P2(RecyclerView.z zVar, b bVar) {
        bVar.a = this.G ? k2(zVar.b()) : g2(zVar.b());
        bVar.b = RecyclerView.UNDEFINED_DURATION;
        return true;
    }

    private void Q1(View view) {
        for (int i = this.s - 1; i >= 0; i--) {
            this.t[i].a(view);
        }
    }

    private void R1(b bVar) {
        SavedState savedState = this.I;
        int i = savedState.c;
        if (i > 0) {
            if (i == this.s) {
                for (int i2 = 0; i2 < this.s; i2++) {
                    this.t[i2].e();
                    SavedState savedState2 = this.I;
                    int i3 = savedState2.d[i2];
                    if (i3 != Integer.MIN_VALUE) {
                        i3 += savedState2.i ? this.u.i() : this.u.m();
                    }
                    this.t[i2].v(i3);
                }
            } else {
                savedState.b();
                SavedState savedState3 = this.I;
                savedState3.a = savedState3.b;
            }
        }
        SavedState savedState4 = this.I;
        this.H = savedState4.j;
        M2(savedState4.h);
        I2();
        SavedState savedState5 = this.I;
        int i4 = savedState5.a;
        if (i4 != -1) {
            this.C = i4;
            bVar.c = savedState5.i;
        } else {
            bVar.c = this.A;
        }
        if (savedState5.e > 1) {
            LazySpanLookup lazySpanLookup = this.E;
            lazySpanLookup.a = savedState5.f;
            lazySpanLookup.b = savedState5.g;
        }
    }

    private void S2(int i, RecyclerView.z zVar) {
        int iN;
        int iN2;
        int iC;
        n nVar = this.y;
        boolean z = false;
        nVar.b = 0;
        nVar.c = i;
        if (!z0() || (iC = zVar.c()) == -1) {
            iN = 0;
            iN2 = 0;
        } else {
            if (this.A == (iC < i)) {
                iN = this.u.n();
                iN2 = 0;
            } else {
                iN2 = this.u.n();
                iN = 0;
            }
        }
        if (N()) {
            this.y.f = this.u.m() - iN2;
            this.y.g = this.u.i() + iN;
        } else {
            this.y.g = this.u.h() + iN;
            this.y.f = -iN2;
        }
        n nVar2 = this.y;
        nVar2.h = false;
        nVar2.a = true;
        if (this.u.k() == 0 && this.u.h() == 0) {
            z = true;
        }
        nVar2.i = z;
    }

    private void U1(View view, LayoutParams layoutParams, n nVar) {
        if (nVar.e == 1) {
            if (layoutParams.f) {
                Q1(view);
                return;
            } else {
                layoutParams.e.a(view);
                return;
            }
        }
        if (layoutParams.f) {
            D2(view);
        } else {
            layoutParams.e.u(view);
        }
    }

    private void U2(c cVar, int i, int i2) {
        int iJ = cVar.j();
        if (i == -1) {
            if (cVar.o() + iJ <= i2) {
                this.B.set(cVar.e, false);
            }
        } else if (cVar.k() - iJ >= i2) {
            this.B.set(cVar.e, false);
        }
    }

    private int V1(int i) {
        if (K() == 0) {
            return this.A ? 1 : -1;
        }
        return (i < n2()) != this.A ? -1 : 1;
    }

    private int V2(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = View.MeasureSpec.getMode(i);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i2) - i3), mode) : i;
    }

    private boolean X1(c cVar) {
        if (this.A) {
            if (cVar.k() < this.u.i()) {
                ArrayList arrayList = cVar.a;
                return !cVar.n((View) arrayList.get(arrayList.size() - 1)).f;
            }
        } else if (cVar.o() > this.u.m()) {
            return !cVar.n((View) cVar.a.get(0)).f;
        }
        return false;
    }

    private int Y1(RecyclerView.z zVar) {
        if (K() == 0) {
            return 0;
        }
        return w.a(zVar, this.u, i2(!this.N), h2(!this.N), this, this.N);
    }

    private int Z1(RecyclerView.z zVar) {
        if (K() == 0) {
            return 0;
        }
        return w.b(zVar, this.u, i2(!this.N), h2(!this.N), this, this.N, this.A);
    }

    private int a2(RecyclerView.z zVar) {
        if (K() == 0) {
            return 0;
        }
        return w.c(zVar, this.u, i2(!this.N), h2(!this.N), this, this.N);
    }

    private int b2(int i) {
        if (i == 1) {
            return (this.w != 1 && x2()) ? 1 : -1;
        }
        if (i == 2) {
            return (this.w != 1 && x2()) ? -1 : 1;
        }
        if (i == 17) {
            if (this.w == 0) {
                return -1;
            }
            return RecyclerView.UNDEFINED_DURATION;
        }
        if (i == 33) {
            if (this.w == 1) {
                return -1;
            }
            return RecyclerView.UNDEFINED_DURATION;
        }
        if (i == 66) {
            if (this.w == 0) {
                return 1;
            }
            return RecyclerView.UNDEFINED_DURATION;
        }
        if (i == 130 && this.w == 1) {
            return 1;
        }
        return RecyclerView.UNDEFINED_DURATION;
    }

    private LazySpanLookup.FullSpanItem c2(int i) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.c = new int[this.s];
        for (int i2 = 0; i2 < this.s; i2++) {
            fullSpanItem.c[i2] = i - this.t[i2].l(i);
        }
        return fullSpanItem;
    }

    private LazySpanLookup.FullSpanItem d2(int i) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.c = new int[this.s];
        for (int i2 = 0; i2 < this.s; i2++) {
            fullSpanItem.c[i2] = this.t[i2].p(i) - i;
        }
        return fullSpanItem;
    }

    private void e2() {
        this.u = t.b(this, this.w);
        this.v = t.b(this, 1 - this.w);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v7 */
    private int f2(RecyclerView.v vVar, n nVar, RecyclerView.z zVar) {
        c cVarT2;
        int iE;
        int i;
        int iE2;
        int iE3;
        boolean z;
        ?? r9 = 0;
        this.B.set(0, this.s, true);
        int i2 = this.y.i ? nVar.e == 1 ? Integer.MAX_VALUE : RecyclerView.UNDEFINED_DURATION : nVar.e == 1 ? nVar.g + nVar.b : nVar.f - nVar.b;
        O2(nVar.e, i2);
        int i3 = this.A ? this.u.i() : this.u.m();
        boolean z2 = false;
        while (nVar.a(zVar) && (this.y.i || !this.B.isEmpty())) {
            View viewB = nVar.b(vVar);
            LayoutParams layoutParams = (LayoutParams) viewB.getLayoutParams();
            int iA = layoutParams.a();
            int iG = this.E.g(iA);
            boolean z3 = iG == -1 ? true : r9;
            if (z3) {
                cVarT2 = layoutParams.f ? this.t[r9] : t2(nVar);
                this.E.n(iA, cVarT2);
            } else {
                cVarT2 = this.t[iG];
            }
            c cVar = cVarT2;
            layoutParams.e = cVar;
            if (nVar.e == 1) {
                e(viewB);
            } else {
                f(viewB, r9);
            }
            z2(viewB, layoutParams, r9);
            if (nVar.e == 1) {
                int iP2 = layoutParams.f ? p2(i3) : cVar.l(i3);
                int iE4 = this.u.e(viewB) + iP2;
                if (z3 && layoutParams.f) {
                    LazySpanLookup.FullSpanItem fullSpanItemC2 = c2(iP2);
                    fullSpanItemC2.b = -1;
                    fullSpanItemC2.a = iA;
                    this.E.a(fullSpanItemC2);
                }
                i = iE4;
                iE = iP2;
            } else {
                int iS2 = layoutParams.f ? s2(i3) : cVar.p(i3);
                iE = iS2 - this.u.e(viewB);
                if (z3 && layoutParams.f) {
                    LazySpanLookup.FullSpanItem fullSpanItemD2 = d2(iS2);
                    fullSpanItemD2.b = 1;
                    fullSpanItemD2.a = iA;
                    this.E.a(fullSpanItemD2);
                }
                i = iS2;
            }
            if (layoutParams.f && nVar.d == -1) {
                if (z3) {
                    this.M = true;
                } else {
                    if (!(nVar.e == 1 ? S1() : T1())) {
                        LazySpanLookup.FullSpanItem fullSpanItemF = this.E.f(iA);
                        if (fullSpanItemF != null) {
                            fullSpanItemF.d = true;
                        }
                        this.M = true;
                    }
                }
            }
            U1(viewB, layoutParams, nVar);
            if (x2() && this.w == 1) {
                int i4 = layoutParams.f ? this.v.i() : this.v.i() - (((this.s - 1) - cVar.e) * this.x);
                iE3 = i4;
                iE2 = i4 - this.v.e(viewB);
            } else {
                int iM = layoutParams.f ? this.v.m() : (cVar.e * this.x) + this.v.m();
                iE2 = iM;
                iE3 = this.v.e(viewB) + iM;
            }
            if (this.w == 1) {
                C0(viewB, iE2, iE, iE3, i);
            } else {
                C0(viewB, iE, iE2, i, iE3);
            }
            if (layoutParams.f) {
                O2(this.y.e, i2);
            } else {
                U2(cVar, this.y.e, i2);
            }
            E2(vVar, this.y);
            if (!this.y.h || !viewB.hasFocusable()) {
                z = false;
            } else if (layoutParams.f) {
                this.B.clear();
                z = false;
            } else {
                z = false;
                this.B.set(cVar.e, false);
            }
            r9 = z;
            z2 = true;
        }
        int i5 = r9;
        if (!z2) {
            E2(vVar, this.y);
        }
        int iM2 = this.y.e == -1 ? this.u.m() - s2(this.u.m()) : p2(this.u.i()) - this.u.i();
        return iM2 > 0 ? Math.min(nVar.b, iM2) : i5;
    }

    private int g2(int i) {
        int iK = K();
        for (int i2 = 0; i2 < iK; i2++) {
            int iI0 = i0(J(i2));
            if (iI0 >= 0 && iI0 < i) {
                return iI0;
            }
        }
        return 0;
    }

    private int k2(int i) {
        for (int iK = K() - 1; iK >= 0; iK--) {
            int iI0 = i0(J(iK));
            if (iI0 >= 0 && iI0 < i) {
                return iI0;
            }
        }
        return 0;
    }

    private void l2(RecyclerView.v vVar, RecyclerView.z zVar, boolean z) {
        int i;
        int iP2 = p2(RecyclerView.UNDEFINED_DURATION);
        if (iP2 != Integer.MIN_VALUE && (i = this.u.i() - iP2) > 0) {
            int i2 = i - (-J2(-i, vVar, zVar));
            if (!z || i2 <= 0) {
                return;
            }
            this.u.r(i2);
        }
    }

    private void m2(RecyclerView.v vVar, RecyclerView.z zVar, boolean z) {
        int iM;
        int iS2 = s2(Integer.MAX_VALUE);
        if (iS2 != Integer.MAX_VALUE && (iM = iS2 - this.u.m()) > 0) {
            int iJ2 = iM - J2(iM, vVar, zVar);
            if (!z || iJ2 <= 0) {
                return;
            }
            this.u.r(-iJ2);
        }
    }

    private int p2(int i) {
        int iL = this.t[0].l(i);
        for (int i2 = 1; i2 < this.s; i2++) {
            int iL2 = this.t[i2].l(i);
            if (iL2 > iL) {
                iL = iL2;
            }
        }
        return iL;
    }

    private int q2(int i) {
        int iP = this.t[0].p(i);
        for (int i2 = 1; i2 < this.s; i2++) {
            int iP2 = this.t[i2].p(i);
            if (iP2 > iP) {
                iP = iP2;
            }
        }
        return iP;
    }

    private int r2(int i) {
        int iL = this.t[0].l(i);
        for (int i2 = 1; i2 < this.s; i2++) {
            int iL2 = this.t[i2].l(i);
            if (iL2 < iL) {
                iL = iL2;
            }
        }
        return iL;
    }

    private int s2(int i) {
        int iP = this.t[0].p(i);
        for (int i2 = 1; i2 < this.s; i2++) {
            int iP2 = this.t[i2].p(i);
            if (iP2 < iP) {
                iP = iP2;
            }
        }
        return iP;
    }

    private c t2(n nVar) {
        int i;
        int i2;
        int i3;
        if (B2(nVar.e)) {
            i2 = this.s - 1;
            i = -1;
            i3 = -1;
        } else {
            i = this.s;
            i2 = 0;
            i3 = 1;
        }
        c cVar = null;
        if (nVar.e == 1) {
            int iM = this.u.m();
            int i4 = Integer.MAX_VALUE;
            while (i2 != i) {
                c cVar2 = this.t[i2];
                int iL = cVar2.l(iM);
                if (iL < i4) {
                    cVar = cVar2;
                    i4 = iL;
                }
                i2 += i3;
            }
            return cVar;
        }
        int i5 = this.u.i();
        int i6 = RecyclerView.UNDEFINED_DURATION;
        while (i2 != i) {
            c cVar3 = this.t[i2];
            int iP = cVar3.p(i5);
            if (iP > i6) {
                cVar = cVar3;
                i6 = iP;
            }
            i2 += i3;
        }
        return cVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0044 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void u2(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.A
            if (r0 == 0) goto L9
            int r0 = r6.o2()
            goto Ld
        L9:
            int r0 = r6.n2()
        Ld:
            r1 = 8
            if (r9 != r1) goto L1b
            if (r7 >= r8) goto L17
            int r2 = r8 + 1
        L15:
            r3 = r7
            goto L1e
        L17:
            int r2 = r7 + 1
            r3 = r8
            goto L1e
        L1b:
            int r2 = r7 + r8
            goto L15
        L1e:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r4 = r6.E
            r4.h(r3)
            r4 = 1
            if (r9 == r4) goto L3d
            r5 = 2
            if (r9 == r5) goto L37
            if (r9 == r1) goto L2c
            goto L42
        L2c:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.E
            r9.k(r7, r4)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r7 = r6.E
            r7.j(r8, r4)
            goto L42
        L37:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.E
            r9.k(r7, r8)
            goto L42
        L3d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.E
            r9.j(r7, r8)
        L42:
            if (r2 > r0) goto L45
            return
        L45:
            boolean r7 = r6.A
            if (r7 == 0) goto L4e
            int r7 = r6.n2()
            goto L52
        L4e:
            int r7 = r6.o2()
        L52:
            if (r3 > r7) goto L57
            r6.w1()
        L57:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.u2(int, int, int):void");
    }

    private void y2(View view, int i, int i2, boolean z) {
        k(view, this.K);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
        Rect rect = this.K;
        int iV2 = V2(i, i3 + rect.left, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + rect.right);
        int i4 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        Rect rect2 = this.K;
        int iV22 = V2(i2, i4 + rect2.top, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + rect2.bottom);
        if (z ? K1(view, iV2, iV22, layoutParams) : I1(view, iV2, iV22, layoutParams)) {
            view.measure(iV2, iV22);
        }
    }

    private void z2(View view, LayoutParams layoutParams, boolean z) {
        if (layoutParams.f) {
            if (this.w == 1) {
                y2(view, this.J, RecyclerView.p.L(X(), Y(), h0() + e0(), ((ViewGroup.MarginLayoutParams) layoutParams).height, true), z);
                return;
            } else {
                y2(view, RecyclerView.p.L(p0(), q0(), f0() + g0(), ((ViewGroup.MarginLayoutParams) layoutParams).width, true), this.J, z);
                return;
            }
        }
        if (this.w == 1) {
            y2(view, RecyclerView.p.L(this.x, q0(), 0, ((ViewGroup.MarginLayoutParams) layoutParams).width, false), RecyclerView.p.L(X(), Y(), h0() + e0(), ((ViewGroup.MarginLayoutParams) layoutParams).height, true), z);
        } else {
            y2(view, RecyclerView.p.L(p0(), q0(), f0() + g0(), ((ViewGroup.MarginLayoutParams) layoutParams).width, true), RecyclerView.p.L(this.x, Y(), 0, ((ViewGroup.MarginLayoutParams) layoutParams).height, false), z);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void A1(int i) {
        SavedState savedState = this.I;
        if (savedState != null && savedState.a != i) {
            savedState.a();
        }
        this.C = i;
        this.D = RecyclerView.UNDEFINED_DURATION;
        w1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public int B1(int i, RecyclerView.v vVar, RecyclerView.z zVar) {
        return J2(i, vVar, zVar);
    }

    void C2(int i, RecyclerView.z zVar) {
        int iN2;
        int i2;
        if (i > 0) {
            iN2 = o2();
            i2 = 1;
        } else {
            iN2 = n2();
            i2 = -1;
        }
        this.y.a = true;
        S2(iN2, zVar);
        K2(i2);
        n nVar = this.y;
        nVar.c = iN2 + nVar.d;
        nVar.b = Math.abs(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public RecyclerView.LayoutParams E() {
        return this.w == 0 ? new LayoutParams(-2, -1) : new LayoutParams(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public RecyclerView.LayoutParams F(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void F0(int i) {
        super.F0(i);
        for (int i2 = 0; i2 < this.s; i2++) {
            this.t[i2].r(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void F1(Rect rect, int i, int i2) {
        int iO;
        int iO2;
        int iF0 = f0() + g0();
        int iH0 = h0() + e0();
        if (this.w == 1) {
            iO2 = RecyclerView.p.o(i2, rect.height() + iH0, c0());
            iO = RecyclerView.p.o(i, (this.x * this.s) + iF0, d0());
        } else {
            iO = RecyclerView.p.o(i, rect.width() + iF0, d0());
            iO2 = RecyclerView.p.o(i2, (this.x * this.s) + iH0, c0());
        }
        E1(iO, iO2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public RecyclerView.LayoutParams G(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void G0(int i) {
        super.G0(i);
        for (int i2 = 0; i2 < this.s; i2++) {
            this.t[i2].r(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void H0(RecyclerView.h hVar, RecyclerView.h hVar2) {
        this.E.b();
        for (int i = 0; i < this.s; i++) {
            this.t[i].e();
        }
    }

    int J2(int i, RecyclerView.v vVar, RecyclerView.z zVar) {
        if (K() == 0 || i == 0) {
            return 0;
        }
        C2(i, zVar);
        int iF2 = f2(vVar, this.y, zVar);
        if (this.y.b >= iF2) {
            i = i < 0 ? -iF2 : iF2;
        }
        this.u.r(-i);
        this.G = this.A;
        n nVar = this.y;
        nVar.b = 0;
        E2(vVar, nVar);
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void L0(RecyclerView recyclerView, RecyclerView.v vVar) {
        super.L0(recyclerView, vVar);
        r1(this.P);
        for (int i = 0; i < this.s; i++) {
            this.t[i].e();
        }
        recyclerView.requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void L1(RecyclerView recyclerView, RecyclerView.z zVar, int i) {
        o oVar = new o(recyclerView.getContext());
        oVar.p(i);
        M1(oVar);
    }

    public void L2(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        h(null);
        if (i == this.w) {
            return;
        }
        this.w = i;
        t tVar = this.u;
        this.u = this.v;
        this.v = tVar;
        w1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public View M0(View view, int i, RecyclerView.v vVar, RecyclerView.z zVar) {
        View viewC;
        View viewM;
        if (K() == 0 || (viewC = C(view)) == null) {
            return null;
        }
        I2();
        int iB2 = b2(i);
        if (iB2 == Integer.MIN_VALUE) {
            return null;
        }
        LayoutParams layoutParams = (LayoutParams) viewC.getLayoutParams();
        boolean z = layoutParams.f;
        c cVar = layoutParams.e;
        int iO2 = iB2 == 1 ? o2() : n2();
        S2(iO2, zVar);
        K2(iB2);
        n nVar = this.y;
        nVar.c = nVar.d + iO2;
        nVar.b = (int) (this.u.n() * 0.33333334f);
        n nVar2 = this.y;
        nVar2.h = true;
        nVar2.a = false;
        f2(vVar, nVar2, zVar);
        this.G = this.A;
        if (!z && (viewM = cVar.m(iO2, iB2)) != null && viewM != viewC) {
            return viewM;
        }
        if (B2(iB2)) {
            for (int i2 = this.s - 1; i2 >= 0; i2--) {
                View viewM2 = this.t[i2].m(iO2, iB2);
                if (viewM2 != null && viewM2 != viewC) {
                    return viewM2;
                }
            }
        } else {
            for (int i3 = 0; i3 < this.s; i3++) {
                View viewM3 = this.t[i3].m(iO2, iB2);
                if (viewM3 != null && viewM3 != viewC) {
                    return viewM3;
                }
            }
        }
        boolean z2 = (this.z ^ true) == (iB2 == -1);
        if (!z) {
            View viewD = D(z2 ? cVar.f() : cVar.g());
            if (viewD != null && viewD != viewC) {
                return viewD;
            }
        }
        if (B2(iB2)) {
            for (int i4 = this.s - 1; i4 >= 0; i4--) {
                if (i4 != cVar.e) {
                    View viewD2 = D(z2 ? this.t[i4].f() : this.t[i4].g());
                    if (viewD2 != null && viewD2 != viewC) {
                        return viewD2;
                    }
                }
            }
        } else {
            for (int i5 = 0; i5 < this.s; i5++) {
                View viewD3 = D(z2 ? this.t[i5].f() : this.t[i5].g());
                if (viewD3 != null && viewD3 != viewC) {
                    return viewD3;
                }
            }
        }
        return null;
    }

    public void M2(boolean z) {
        h(null);
        SavedState savedState = this.I;
        if (savedState != null && savedState.h != z) {
            savedState.h = z;
        }
        this.z = z;
        w1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void N0(AccessibilityEvent accessibilityEvent) {
        super.N0(accessibilityEvent);
        if (K() > 0) {
            View viewI2 = i2(false);
            View viewH2 = h2(false);
            if (viewI2 == null || viewH2 == null) {
                return;
            }
            int iI0 = i0(viewI2);
            int iI02 = i0(viewH2);
            if (iI0 < iI02) {
                accessibilityEvent.setFromIndex(iI0);
                accessibilityEvent.setToIndex(iI02);
            } else {
                accessibilityEvent.setFromIndex(iI02);
                accessibilityEvent.setToIndex(iI0);
            }
        }
    }

    public void N2(int i) {
        h(null);
        if (i != this.s) {
            w2();
            this.s = i;
            this.B = new BitSet(this.s);
            this.t = new c[this.s];
            for (int i2 = 0; i2 < this.s; i2++) {
                this.t[i2] = new c(i2);
            }
            w1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public boolean P1() {
        return this.I == null;
    }

    boolean Q2(RecyclerView.z zVar, b bVar) {
        int i;
        if (!zVar.e() && (i = this.C) != -1) {
            if (i >= 0 && i < zVar.b()) {
                SavedState savedState = this.I;
                if (savedState == null || savedState.a == -1 || savedState.c < 1) {
                    View viewD = D(this.C);
                    if (viewD != null) {
                        bVar.a = this.A ? o2() : n2();
                        if (this.D != Integer.MIN_VALUE) {
                            if (bVar.c) {
                                bVar.b = (this.u.i() - this.D) - this.u.d(viewD);
                            } else {
                                bVar.b = (this.u.m() + this.D) - this.u.g(viewD);
                            }
                            return true;
                        }
                        if (this.u.e(viewD) > this.u.n()) {
                            bVar.b = bVar.c ? this.u.i() : this.u.m();
                            return true;
                        }
                        int iG = this.u.g(viewD) - this.u.m();
                        if (iG < 0) {
                            bVar.b = -iG;
                            return true;
                        }
                        int i2 = this.u.i() - this.u.d(viewD);
                        if (i2 < 0) {
                            bVar.b = i2;
                            return true;
                        }
                        bVar.b = RecyclerView.UNDEFINED_DURATION;
                    } else {
                        int i3 = this.C;
                        bVar.a = i3;
                        int i4 = this.D;
                        if (i4 == Integer.MIN_VALUE) {
                            bVar.c = V1(i3) == 1;
                            bVar.a();
                        } else {
                            bVar.b(i4);
                        }
                        bVar.d = true;
                    }
                } else {
                    bVar.b = RecyclerView.UNDEFINED_DURATION;
                    bVar.a = this.C;
                }
                return true;
            }
            this.C = -1;
            this.D = RecyclerView.UNDEFINED_DURATION;
        }
        return false;
    }

    void R2(RecyclerView.z zVar, b bVar) {
        if (Q2(zVar, bVar) || P2(zVar, bVar)) {
            return;
        }
        bVar.a();
        bVar.a = 0;
    }

    boolean S1() {
        int iL = this.t[0].l(RecyclerView.UNDEFINED_DURATION);
        for (int i = 1; i < this.s; i++) {
            if (this.t[i].l(RecyclerView.UNDEFINED_DURATION) != iL) {
                return false;
            }
        }
        return true;
    }

    boolean T1() {
        int iP = this.t[0].p(RecyclerView.UNDEFINED_DURATION);
        for (int i = 1; i < this.s; i++) {
            if (this.t[i].p(RecyclerView.UNDEFINED_DURATION) != iP) {
                return false;
            }
        }
        return true;
    }

    void T2(int i) {
        this.x = i / this.s;
        this.J = View.MeasureSpec.makeMeasureSpec(i, this.v.k());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void U0(RecyclerView recyclerView, int i, int i2) {
        u2(i, i2, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void V0(RecyclerView recyclerView) {
        this.E.b();
        w1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void W0(RecyclerView recyclerView, int i, int i2, int i3) {
        u2(i, i2, 8);
    }

    boolean W1() {
        int iN2;
        int iO2;
        if (K() == 0 || this.F == 0 || !t0()) {
            return false;
        }
        if (this.A) {
            iN2 = o2();
            iO2 = n2();
        } else {
            iN2 = n2();
            iO2 = o2();
        }
        if (iN2 == 0 && v2() != null) {
            this.E.b();
            x1();
            w1();
            return true;
        }
        if (!this.M) {
            return false;
        }
        int i = this.A ? -1 : 1;
        int i2 = iO2 + 1;
        LazySpanLookup.FullSpanItem fullSpanItemE = this.E.e(iN2, i2, i, true);
        if (fullSpanItemE == null) {
            this.M = false;
            this.E.d(i2);
            return false;
        }
        LazySpanLookup.FullSpanItem fullSpanItemE2 = this.E.e(iN2, fullSpanItemE.a, i * (-1), true);
        if (fullSpanItemE2 == null) {
            this.E.d(fullSpanItemE.a);
        } else {
            this.E.d(fullSpanItemE2.a + 1);
        }
        x1();
        w1();
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void X0(RecyclerView recyclerView, int i, int i2) {
        u2(i, i2, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void Z0(RecyclerView recyclerView, int i, int i2, Object obj) {
        u2(i, i2, 4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.y.b
    public PointF a(int i) {
        int iV1 = V1(i);
        PointF pointF = new PointF();
        if (iV1 == 0) {
            return null;
        }
        if (this.w == 0) {
            pointF.x = iV1;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = iV1;
        }
        return pointF;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void a1(RecyclerView.v vVar, RecyclerView.z zVar) {
        A2(vVar, zVar, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void b1(RecyclerView.z zVar) {
        super.b1(zVar);
        this.C = -1;
        this.D = RecyclerView.UNDEFINED_DURATION;
        this.I = null;
        this.L.c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void f1(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.I = savedState;
            if (this.C != -1) {
                savedState.a();
                this.I.b();
            }
            w1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public Parcelable g1() {
        int iP;
        int iM;
        int[] iArr;
        if (this.I != null) {
            return new SavedState(this.I);
        }
        SavedState savedState = new SavedState();
        savedState.h = this.z;
        savedState.i = this.G;
        savedState.j = this.H;
        LazySpanLookup lazySpanLookup = this.E;
        if (lazySpanLookup == null || (iArr = lazySpanLookup.a) == null) {
            savedState.e = 0;
        } else {
            savedState.f = iArr;
            savedState.e = iArr.length;
            savedState.g = lazySpanLookup.b;
        }
        if (K() > 0) {
            savedState.a = this.G ? o2() : n2();
            savedState.b = j2();
            int i = this.s;
            savedState.c = i;
            savedState.d = new int[i];
            for (int i2 = 0; i2 < this.s; i2++) {
                if (this.G) {
                    iP = this.t[i2].l(RecyclerView.UNDEFINED_DURATION);
                    if (iP != Integer.MIN_VALUE) {
                        iM = this.u.i();
                        iP -= iM;
                    }
                } else {
                    iP = this.t[i2].p(RecyclerView.UNDEFINED_DURATION);
                    if (iP != Integer.MIN_VALUE) {
                        iM = this.u.m();
                        iP -= iM;
                    }
                }
                savedState.d[i2] = iP;
            }
        } else {
            savedState.a = -1;
            savedState.b = -1;
            savedState.c = 0;
        }
        return savedState;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void h(String str) {
        if (this.I == null) {
            super.h(str);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void h1(int i) {
        if (i == 0) {
            W1();
        }
    }

    View h2(boolean z) {
        int iM = this.u.m();
        int i = this.u.i();
        View view = null;
        for (int iK = K() - 1; iK >= 0; iK--) {
            View viewJ = J(iK);
            int iG = this.u.g(viewJ);
            int iD = this.u.d(viewJ);
            if (iD > iM && iG < i) {
                if (iD <= i || !z) {
                    return viewJ;
                }
                if (view == null) {
                    view = viewJ;
                }
            }
        }
        return view;
    }

    View i2(boolean z) {
        int iM = this.u.m();
        int i = this.u.i();
        int iK = K();
        View view = null;
        for (int i2 = 0; i2 < iK; i2++) {
            View viewJ = J(i2);
            int iG = this.u.g(viewJ);
            if (this.u.d(viewJ) > iM && iG < i) {
                if (iG >= iM || !z) {
                    return viewJ;
                }
                if (view == null) {
                    view = viewJ;
                }
            }
        }
        return view;
    }

    int j2() {
        View viewH2 = this.A ? h2(true) : i2(true);
        if (viewH2 == null) {
            return -1;
        }
        return i0(viewH2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public boolean l() {
        return this.w == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public boolean m() {
        return this.w == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public boolean n(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    int n2() {
        if (K() == 0) {
            return 0;
        }
        return i0(J(0));
    }

    int o2() {
        int iK = K();
        if (iK == 0) {
            return 0;
        }
        return i0(J(iK - 1));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void p(int i, int i2, RecyclerView.z zVar, RecyclerView.p.c cVar) {
        int iL;
        int iP;
        if (this.w != 0) {
            i = i2;
        }
        if (K() == 0 || i == 0) {
            return;
        }
        C2(i, zVar);
        int[] iArr = this.O;
        if (iArr == null || iArr.length < this.s) {
            this.O = new int[this.s];
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.s; i4++) {
            n nVar = this.y;
            if (nVar.d == -1) {
                iL = nVar.f;
                iP = this.t[i4].p(iL);
            } else {
                iL = this.t[i4].l(nVar.g);
                iP = this.y.g;
            }
            int i5 = iL - iP;
            if (i5 >= 0) {
                this.O[i3] = i5;
                i3++;
            }
        }
        Arrays.sort(this.O, 0, i3);
        for (int i6 = 0; i6 < i3 && this.y.a(zVar); i6++) {
            cVar.a(this.y.c, this.O[i6]);
            n nVar2 = this.y;
            nVar2.c += nVar2.d;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public int r(RecyclerView.z zVar) {
        return Y1(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public int s(RecyclerView.z zVar) {
        return Z1(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public int t(RecyclerView.z zVar) {
        return a2(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public int u(RecyclerView.z zVar) {
        return Y1(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public boolean u0() {
        return this.F != 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public int v(RecyclerView.z zVar) {
        return Z1(zVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    android.view.View v2() {
        /*
            r12 = this;
            int r0 = r12.K()
            int r1 = r0 + (-1)
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r12.s
            r2.<init>(r3)
            int r3 = r12.s
            r4 = 0
            r5 = 1
            r2.set(r4, r3, r5)
            int r3 = r12.w
            r6 = -1
            if (r3 != r5) goto L21
            boolean r3 = r12.x2()
            if (r3 == 0) goto L21
            r3 = r5
            goto L22
        L21:
            r3 = r6
        L22:
            boolean r7 = r12.A
            if (r7 == 0) goto L28
            r0 = r6
            goto L29
        L28:
            r1 = r4
        L29:
            if (r1 >= r0) goto L2c
            r6 = r5
        L2c:
            if (r1 == r0) goto La4
            android.view.View r7 = r12.J(r1)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r8 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) r8
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = r8.e
            int r9 = r9.e
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L52
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = r8.e
            boolean r9 = r12.X1(r9)
            if (r9 == 0) goto L4b
            return r7
        L4b:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = r8.e
            int r9 = r9.e
            r2.clear(r9)
        L52:
            boolean r9 = r8.f
            if (r9 == 0) goto L57
            goto La2
        L57:
            int r9 = r1 + r6
            if (r9 == r0) goto La2
            android.view.View r9 = r12.J(r9)
            boolean r10 = r12.A
            if (r10 == 0) goto L75
            androidx.recyclerview.widget.t r10 = r12.u
            int r10 = r10.d(r7)
            androidx.recyclerview.widget.t r11 = r12.u
            int r11 = r11.d(r9)
            if (r10 >= r11) goto L72
            return r7
        L72:
            if (r10 != r11) goto La2
            goto L86
        L75:
            androidx.recyclerview.widget.t r10 = r12.u
            int r10 = r10.g(r7)
            androidx.recyclerview.widget.t r11 = r12.u
            int r11 = r11.g(r9)
            if (r10 <= r11) goto L84
            return r7
        L84:
            if (r10 != r11) goto La2
        L86:
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r9 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) r9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r8 = r8.e
            int r8 = r8.e
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = r9.e
            int r9 = r9.e
            int r8 = r8 - r9
            if (r8 >= 0) goto L99
            r8 = r5
            goto L9a
        L99:
            r8 = r4
        L9a:
            if (r3 >= 0) goto L9e
            r9 = r5
            goto L9f
        L9e:
            r9 = r4
        L9f:
            if (r8 == r9) goto La2
            return r7
        La2:
            int r1 = r1 + r6
            goto L2c
        La4:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.v2():android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public int w(RecyclerView.z zVar) {
        return a2(zVar);
    }

    public void w2() {
        this.E.b();
        w1();
    }

    boolean x2() {
        return a0() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public int z1(int i, RecyclerView.v vVar, RecyclerView.z zVar) {
        return J2(i, vVar, zVar);
    }

    static class LazySpanLookup {
        int[] a;
        List b;

        LazySpanLookup() {
        }

        private int i(int i) {
            if (this.b == null) {
                return -1;
            }
            FullSpanItem fullSpanItemF = f(i);
            if (fullSpanItemF != null) {
                this.b.remove(fullSpanItemF);
            }
            int size = this.b.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                }
                if (((FullSpanItem) this.b.get(i2)).a >= i) {
                    break;
                }
                i2++;
            }
            if (i2 == -1) {
                return -1;
            }
            FullSpanItem fullSpanItem = (FullSpanItem) this.b.get(i2);
            this.b.remove(i2);
            return fullSpanItem.a;
        }

        private void l(int i, int i2) {
            List list = this.b;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.b.get(size);
                int i3 = fullSpanItem.a;
                if (i3 >= i) {
                    fullSpanItem.a = i3 + i2;
                }
            }
        }

        private void m(int i, int i2) {
            List list = this.b;
            if (list == null) {
                return;
            }
            int i3 = i + i2;
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.b.get(size);
                int i4 = fullSpanItem.a;
                if (i4 >= i) {
                    if (i4 < i3) {
                        this.b.remove(size);
                    } else {
                        fullSpanItem.a = i4 - i2;
                    }
                }
            }
        }

        public void a(FullSpanItem fullSpanItem) {
            if (this.b == null) {
                this.b = new ArrayList();
            }
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                FullSpanItem fullSpanItem2 = (FullSpanItem) this.b.get(i);
                if (fullSpanItem2.a == fullSpanItem.a) {
                    this.b.remove(i);
                }
                if (fullSpanItem2.a >= fullSpanItem.a) {
                    this.b.add(i, fullSpanItem);
                    return;
                }
            }
            this.b.add(fullSpanItem);
        }

        void b() {
            int[] iArr = this.a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.b = null;
        }

        void c(int i) {
            int[] iArr = this.a;
            if (iArr == null) {
                int[] iArr2 = new int[Math.max(i, 10) + 1];
                this.a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i >= iArr.length) {
                int[] iArr3 = new int[o(i)];
                this.a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        int d(int i) {
            List list = this.b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (((FullSpanItem) this.b.get(size)).a >= i) {
                        this.b.remove(size);
                    }
                }
            }
            return h(i);
        }

        public FullSpanItem e(int i, int i2, int i3, boolean z) {
            List list = this.b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.b.get(i4);
                int i5 = fullSpanItem.a;
                if (i5 >= i2) {
                    return null;
                }
                if (i5 >= i && (i3 == 0 || fullSpanItem.b == i3 || (z && fullSpanItem.d))) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public FullSpanItem f(int i) {
            List list = this.b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.b.get(size);
                if (fullSpanItem.a == i) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        int g(int i) {
            int[] iArr = this.a;
            if (iArr == null || i >= iArr.length) {
                return -1;
            }
            return iArr[i];
        }

        int h(int i) {
            int[] iArr = this.a;
            if (iArr == null || i >= iArr.length) {
                return -1;
            }
            int i2 = i(i);
            if (i2 == -1) {
                int[] iArr2 = this.a;
                Arrays.fill(iArr2, i, iArr2.length, -1);
                return this.a.length;
            }
            int iMin = Math.min(i2 + 1, this.a.length);
            Arrays.fill(this.a, i, iMin, -1);
            return iMin;
        }

        void j(int i, int i2) {
            int[] iArr = this.a;
            if (iArr == null || i >= iArr.length) {
                return;
            }
            int i3 = i + i2;
            c(i3);
            int[] iArr2 = this.a;
            System.arraycopy(iArr2, i, iArr2, i3, (iArr2.length - i) - i2);
            Arrays.fill(this.a, i, i3, -1);
            l(i, i2);
        }

        void k(int i, int i2) {
            int[] iArr = this.a;
            if (iArr == null || i >= iArr.length) {
                return;
            }
            int i3 = i + i2;
            c(i3);
            int[] iArr2 = this.a;
            System.arraycopy(iArr2, i3, iArr2, i, (iArr2.length - i) - i2);
            int[] iArr3 = this.a;
            Arrays.fill(iArr3, iArr3.length - i2, iArr3.length, -1);
            m(i, i2);
        }

        void n(int i, c cVar) {
            c(i);
            this.a[i] = cVar.e;
        }

        int o(int i) {
            int length = this.a.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }

        static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = new a();
            int a;
            int b;
            int[] c;
            boolean d;

            class a implements Parcelable.Creator {
                a() {
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public FullSpanItem createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public FullSpanItem[] newArray(int i) {
                    return new FullSpanItem[i];
                }
            }

            FullSpanItem(Parcel parcel) {
                this.a = parcel.readInt();
                this.b = parcel.readInt();
                this.d = parcel.readInt() == 1;
                int i = parcel.readInt();
                if (i > 0) {
                    int[] iArr = new int[i];
                    this.c = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            int a(int i) {
                int[] iArr = this.c;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i];
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.a + ", mGapDir=" + this.b + ", mHasUnwantedGapAfter=" + this.d + ", mGapPerSpan=" + Arrays.toString(this.c) + '}';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.a);
                parcel.writeInt(this.b);
                parcel.writeInt(this.d ? 1 : 0);
                int[] iArr = this.c;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(iArr.length);
                    parcel.writeIntArray(this.c);
                }
            }

            FullSpanItem() {
            }
        }
    }
}
