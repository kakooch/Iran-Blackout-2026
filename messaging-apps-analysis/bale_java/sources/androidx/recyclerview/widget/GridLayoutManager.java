package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.X2;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class GridLayoutManager extends LinearLayoutManager {
    boolean I;
    int J;
    int[] K;
    View[] L;
    final SparseIntArray M;
    final SparseIntArray N;
    b O;
    final Rect P;
    private boolean Q;

    public static final class a extends b {
        @Override // androidx.recyclerview.widget.GridLayoutManager.b
        public int e(int i, int i2) {
            return i % i2;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.b
        public int f(int i) {
            return 1;
        }
    }

    public static abstract class b {
        final SparseIntArray a = new SparseIntArray();
        final SparseIntArray b = new SparseIntArray();
        private boolean c = false;
        private boolean d = false;

        static int a(SparseIntArray sparseIntArray, int i) {
            int size = sparseIntArray.size() - 1;
            int i2 = 0;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                if (sparseIntArray.keyAt(i3) < i) {
                    i2 = i3 + 1;
                } else {
                    size = i3 - 1;
                }
            }
            int i4 = i2 - 1;
            if (i4 < 0 || i4 >= sparseIntArray.size()) {
                return -1;
            }
            return sparseIntArray.keyAt(i4);
        }

        int b(int i, int i2) {
            if (!this.d) {
                return d(i, i2);
            }
            int i3 = this.b.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int iD = d(i, i2);
            this.b.put(i, iD);
            return iD;
        }

        int c(int i, int i2) {
            if (!this.c) {
                return e(i, i2);
            }
            int i3 = this.a.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int iE = e(i, i2);
            this.a.put(i, iE);
            return iE;
        }

        public int d(int i, int i2) {
            int i3;
            int i4;
            int iC;
            int iA;
            if (!this.d || (iA = a(this.b, i)) == -1) {
                i3 = 0;
                i4 = 0;
                iC = 0;
            } else {
                i3 = this.b.get(iA);
                i4 = iA + 1;
                iC = c(iA, i2) + f(iA);
                if (iC == i2) {
                    i3++;
                    iC = 0;
                }
            }
            int iF = f(i);
            while (i4 < i) {
                int iF2 = f(i4);
                iC += iF2;
                if (iC == i2) {
                    i3++;
                    iC = 0;
                } else if (iC > i2) {
                    i3++;
                    iC = iF2;
                }
                i4++;
            }
            return iC + iF > i2 ? i3 + 1 : i3;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x002b -> B:17:0x0030). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x002d -> B:17:0x0030). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x002f -> B:17:0x0030). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int e(int r6, int r7) {
            /*
                r5 = this;
                int r0 = r5.f(r6)
                r1 = 0
                if (r0 != r7) goto L8
                return r1
            L8:
                boolean r2 = r5.c
                if (r2 == 0) goto L20
                android.util.SparseIntArray r2 = r5.a
                int r2 = a(r2, r6)
                if (r2 < 0) goto L20
                android.util.SparseIntArray r3 = r5.a
                int r3 = r3.get(r2)
                int r4 = r5.f(r2)
                int r3 = r3 + r4
                goto L30
            L20:
                r2 = r1
                r3 = r2
            L22:
                if (r2 >= r6) goto L33
                int r4 = r5.f(r2)
                int r3 = r3 + r4
                if (r3 != r7) goto L2d
                r3 = r1
                goto L30
            L2d:
                if (r3 <= r7) goto L30
                r3 = r4
            L30:
                int r2 = r2 + 1
                goto L22
            L33:
                int r0 = r0 + r3
                if (r0 > r7) goto L37
                return r3
            L37:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.b.e(int, int):int");
        }

        public abstract int f(int i);

        public void g() {
            this.b.clear();
        }

        public void h() {
            this.a.clear();
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.I = false;
        this.J = -1;
        this.M = new SparseIntArray();
        this.N = new SparseIntArray();
        this.O = new a();
        this.P = new Rect();
        j3(RecyclerView.p.j0(context, attributeSet, i, i2).b);
    }

    private void S2(RecyclerView.v vVar, RecyclerView.z zVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        int i5 = 0;
        if (z) {
            i4 = 1;
            i3 = i;
            i2 = 0;
        } else {
            i2 = i - 1;
            i3 = -1;
            i4 = -1;
        }
        while (i2 != i3) {
            View view = this.L[i2];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int iF3 = f3(vVar, zVar, i0(view));
            layoutParams.f = iF3;
            layoutParams.e = i5;
            i5 += iF3;
            i2 += i4;
        }
    }

    private void T2() {
        int iK = K();
        for (int i = 0; i < iK; i++) {
            LayoutParams layoutParams = (LayoutParams) J(i).getLayoutParams();
            int iA = layoutParams.a();
            this.M.put(iA, layoutParams.f());
            this.N.put(iA, layoutParams.e());
        }
    }

    private void U2(int i) {
        this.K = V2(this.K, this.J, i);
    }

    static int[] V2(int[] iArr, int i, int i2) {
        int i3;
        if (iArr == null || iArr.length != i + 1 || iArr[iArr.length - 1] != i2) {
            iArr = new int[i + 1];
        }
        int i4 = 0;
        iArr[0] = 0;
        int i5 = i2 / i;
        int i6 = i2 % i;
        int i7 = 0;
        for (int i8 = 1; i8 <= i; i8++) {
            i4 += i6;
            if (i4 <= 0 || i - i4 >= i6) {
                i3 = i5;
            } else {
                i3 = i5 + 1;
                i4 -= i;
            }
            i7 += i3;
            iArr[i8] = i7;
        }
        return iArr;
    }

    private void W2() {
        this.M.clear();
        this.N.clear();
    }

    private int X2(RecyclerView.z zVar) {
        if (K() != 0 && zVar.b() != 0) {
            X1();
            boolean zT2 = t2();
            View viewC2 = c2(!zT2, true);
            View viewB2 = b2(!zT2, true);
            if (viewC2 != null && viewB2 != null) {
                int iB = this.O.b(i0(viewC2), this.J);
                int iB2 = this.O.b(i0(viewB2), this.J);
                int iMax = this.x ? Math.max(0, ((this.O.b(zVar.b() - 1, this.J) + 1) - Math.max(iB, iB2)) - 1) : Math.max(0, Math.min(iB, iB2));
                if (zT2) {
                    return Math.round((iMax * (Math.abs(this.u.d(viewB2) - this.u.g(viewC2)) / ((this.O.b(i0(viewB2), this.J) - this.O.b(i0(viewC2), this.J)) + 1))) + (this.u.m() - this.u.g(viewC2)));
                }
                return iMax;
            }
        }
        return 0;
    }

    private int Y2(RecyclerView.z zVar) {
        if (K() != 0 && zVar.b() != 0) {
            X1();
            View viewC2 = c2(!t2(), true);
            View viewB2 = b2(!t2(), true);
            if (viewC2 != null && viewB2 != null) {
                if (!t2()) {
                    return this.O.b(zVar.b() - 1, this.J) + 1;
                }
                int iD = this.u.d(viewB2) - this.u.g(viewC2);
                int iB = this.O.b(i0(viewC2), this.J);
                return (int) ((iD / ((this.O.b(i0(viewB2), this.J) - iB) + 1)) * (this.O.b(zVar.b() - 1, this.J) + 1));
            }
        }
        return 0;
    }

    private void Z2(RecyclerView.v vVar, RecyclerView.z zVar, LinearLayoutManager.a aVar, int i) {
        boolean z = i == 1;
        int iE3 = e3(vVar, zVar, aVar.b);
        if (z) {
            while (iE3 > 0) {
                int i2 = aVar.b;
                if (i2 <= 0) {
                    return;
                }
                int i3 = i2 - 1;
                aVar.b = i3;
                iE3 = e3(vVar, zVar, i3);
            }
            return;
        }
        int iB = zVar.b() - 1;
        int i4 = aVar.b;
        while (i4 < iB) {
            int i5 = i4 + 1;
            int iE32 = e3(vVar, zVar, i5);
            if (iE32 <= iE3) {
                break;
            }
            i4 = i5;
            iE3 = iE32;
        }
        aVar.b = i4;
    }

    private void a3() {
        View[] viewArr = this.L;
        if (viewArr == null || viewArr.length != this.J) {
            this.L = new View[this.J];
        }
    }

    private int d3(RecyclerView.v vVar, RecyclerView.z zVar, int i) {
        if (!zVar.e()) {
            return this.O.b(i, this.J);
        }
        int iF = vVar.f(i);
        if (iF != -1) {
            return this.O.b(iF, this.J);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
        return 0;
    }

    private int e3(RecyclerView.v vVar, RecyclerView.z zVar, int i) {
        if (!zVar.e()) {
            return this.O.c(i, this.J);
        }
        int i2 = this.N.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int iF = vVar.f(i);
        if (iF != -1) {
            return this.O.c(iF, this.J);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 0;
    }

    private int f3(RecyclerView.v vVar, RecyclerView.z zVar, int i) {
        if (!zVar.e()) {
            return this.O.f(i);
        }
        int i2 = this.M.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int iF = vVar.f(i);
        if (iF != -1) {
            return this.O.f(iF);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 1;
    }

    private void g3(float f, int i) {
        U2(Math.max(Math.round(f * this.J), i));
    }

    private void h3(View view, int i, boolean z) {
        int iL;
        int iL2;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect = layoutParams.b;
        int i2 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        int i3 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        int iB3 = b3(layoutParams.e, layoutParams.f);
        if (this.s == 1) {
            iL2 = RecyclerView.p.L(iB3, i, i3, ((ViewGroup.MarginLayoutParams) layoutParams).width, false);
            iL = RecyclerView.p.L(this.u.n(), Y(), i2, ((ViewGroup.MarginLayoutParams) layoutParams).height, true);
        } else {
            int iL3 = RecyclerView.p.L(iB3, i, i2, ((ViewGroup.MarginLayoutParams) layoutParams).height, false);
            int iL4 = RecyclerView.p.L(this.u.n(), q0(), i3, ((ViewGroup.MarginLayoutParams) layoutParams).width, true);
            iL = iL3;
            iL2 = iL4;
        }
        i3(view, iL2, iL, z);
    }

    private void i3(View view, int i, int i2, boolean z) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (z ? K1(view, i, i2, layoutParams) : I1(view, i, i2, layoutParams)) {
            view.measure(i, i2);
        }
    }

    private void l3() {
        int iX;
        int iH0;
        if (r2() == 1) {
            iX = p0() - g0();
            iH0 = f0();
        } else {
            iX = X() - e0();
            iH0 = h0();
        }
        U2(iX - iH0);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.p
    public int B1(int i, RecyclerView.v vVar, RecyclerView.z zVar) {
        l3();
        a3();
        return super.B1(i, vVar, zVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.p
    public RecyclerView.LayoutParams E() {
        return this.s == 0 ? new LayoutParams(-2, -1) : new LayoutParams(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public RecyclerView.LayoutParams F(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void F1(Rect rect, int i, int i2) {
        int iO;
        int iO2;
        if (this.K == null) {
            super.F1(rect, i, i2);
        }
        int iF0 = f0() + g0();
        int iH0 = h0() + e0();
        if (this.s == 1) {
            iO2 = RecyclerView.p.o(i2, rect.height() + iH0, c0());
            int[] iArr = this.K;
            iO = RecyclerView.p.o(i, iArr[iArr.length - 1] + iF0, d0());
        } else {
            iO = RecyclerView.p.o(i, rect.width() + iF0, d0());
            int[] iArr2 = this.K;
            iO2 = RecyclerView.p.o(i2, iArr2[iArr2.length - 1] + iH0, c0());
        }
        E1(iO, iO2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public RecyclerView.LayoutParams G(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void J2(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.J2(false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x00d1, code lost:
    
        if (r13 == (r2 > r15)) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x010f  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View M0(android.view.View r24, int r25, androidx.recyclerview.widget.RecyclerView.v r26, androidx.recyclerview.widget.RecyclerView.z r27) {
        /*
            Method dump skipped, instructions count: 317
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.M0(android.view.View, int, androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$z):android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public int O(RecyclerView.v vVar, RecyclerView.z zVar) {
        if (this.s == 1) {
            return this.J;
        }
        if (zVar.b() < 1) {
            return 0;
        }
        return d3(vVar, zVar, zVar.b() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.p
    public boolean P1() {
        return this.D == null && !this.I;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void R1(RecyclerView.z zVar, LinearLayoutManager.c cVar, RecyclerView.p.c cVar2) {
        int iF = this.J;
        for (int i = 0; i < this.J && cVar.c(zVar) && iF > 0; i++) {
            int i2 = cVar.d;
            cVar2.a(i2, Math.max(0, cVar.g));
            iF -= this.O.f(i2);
            cVar.d += cVar.e;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void S0(RecyclerView.v vVar, RecyclerView.z zVar, View view, X2 x2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.R0(view, x2);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        int iD3 = d3(vVar, zVar, layoutParams2.a());
        if (this.s == 0) {
            x2.s0(X2.f.a(layoutParams2.e(), layoutParams2.f(), iD3, 1, false, false));
        } else {
            x2.s0(X2.f.a(iD3, 1, layoutParams2.e(), layoutParams2.f(), false, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void U0(RecyclerView recyclerView, int i, int i2) {
        this.O.h();
        this.O.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void V0(RecyclerView recyclerView) {
        this.O.h();
        this.O.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void W0(RecyclerView recyclerView, int i, int i2, int i3) {
        this.O.h();
        this.O.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void X0(RecyclerView recyclerView, int i, int i2) {
        this.O.h();
        this.O.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void Z0(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.O.h();
        this.O.g();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.p
    public void a1(RecyclerView.v vVar, RecyclerView.z zVar) {
        if (zVar.e()) {
            T2();
        }
        super.a1(vVar, zVar);
        W2();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.p
    public void b1(RecyclerView.z zVar) {
        super.b1(zVar);
        this.I = false;
    }

    int b3(int i, int i2) {
        if (this.s != 1 || !s2()) {
            int[] iArr = this.K;
            return iArr[i2 + i] - iArr[i];
        }
        int[] iArr2 = this.K;
        int i3 = this.J;
        return iArr2[i3 - i] - iArr2[(i3 - i) - i2];
    }

    public int c3() {
        return this.J;
    }

    public void j3(int i) {
        if (i == this.J) {
            return;
        }
        this.I = true;
        if (i >= 1) {
            this.J = i;
            this.O.h();
            w1();
        } else {
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
        }
    }

    public void k3(b bVar) {
        this.O = bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public int l0(RecyclerView.v vVar, RecyclerView.z zVar) {
        if (this.s == 0) {
            return this.J;
        }
        if (zVar.b() < 1) {
            return 0;
        }
        return d3(vVar, zVar, zVar.b() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    View l2(RecyclerView.v vVar, RecyclerView.z zVar, boolean z, boolean z2) {
        int i;
        int iK;
        int iK2 = K();
        int i2 = 1;
        if (z2) {
            iK = K() - 1;
            i = -1;
            i2 = -1;
        } else {
            i = iK2;
            iK = 0;
        }
        int iB = zVar.b();
        X1();
        int iM = this.u.m();
        int i3 = this.u.i();
        View view = null;
        View view2 = null;
        while (iK != i) {
            View viewJ = J(iK);
            int iI0 = i0(viewJ);
            if (iI0 >= 0 && iI0 < iB && e3(vVar, zVar, iI0) == 0) {
                if (((RecyclerView.LayoutParams) viewJ.getLayoutParams()).c()) {
                    if (view2 == null) {
                        view2 = viewJ;
                    }
                } else {
                    if (this.u.g(viewJ) < i3 && this.u.d(viewJ) >= iM) {
                        return viewJ;
                    }
                    if (view == null) {
                        view = viewJ;
                    }
                }
            }
            iK += i2;
        }
        return view != null ? view : view2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public boolean n(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.p
    public int s(RecyclerView.z zVar) {
        return this.Q ? X2(zVar) : super.s(zVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.p
    public int t(RecyclerView.z zVar) {
        return this.Q ? Y2(zVar) : super.t(zVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void u2(RecyclerView.v vVar, RecyclerView.z zVar, LinearLayoutManager.c cVar, LinearLayoutManager.b bVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int iF;
        int iF2;
        int iF3;
        int i8;
        int iL;
        int iL2;
        View viewD;
        int iL3 = this.u.l();
        boolean z = iL3 != 1073741824;
        int i9 = K() > 0 ? this.K[this.J] : 0;
        if (z) {
            l3();
        }
        boolean z2 = cVar.e == 1;
        int iE3 = this.J;
        if (!z2) {
            iE3 = e3(vVar, zVar, cVar.d) + f3(vVar, zVar, cVar.d);
        }
        int i10 = 0;
        while (i10 < this.J && cVar.c(zVar) && iE3 > 0) {
            int i11 = cVar.d;
            int iF32 = f3(vVar, zVar, i11);
            if (iF32 > this.J) {
                throw new IllegalArgumentException("Item at position " + i11 + " requires " + iF32 + " spans but GridLayoutManager has only " + this.J + " spans.");
            }
            iE3 -= iF32;
            if (iE3 < 0 || (viewD = cVar.d(vVar)) == null) {
                break;
            }
            this.L[i10] = viewD;
            i10++;
        }
        if (i10 == 0) {
            bVar.b = true;
            return;
        }
        S2(vVar, zVar, i10, z2);
        float f = 0.0f;
        int i12 = 0;
        for (int i13 = 0; i13 < i10; i13++) {
            View view = this.L[i13];
            if (cVar.l == null) {
                if (z2) {
                    e(view);
                } else {
                    f(view, 0);
                }
            } else if (z2) {
                c(view);
            } else {
                d(view, 0);
            }
            k(view, this.P);
            h3(view, iL3, false);
            int iE = this.u.e(view);
            if (iE > i12) {
                i12 = iE;
            }
            float f2 = (this.u.f(view) * 1.0f) / ((LayoutParams) view.getLayoutParams()).f;
            if (f2 > f) {
                f = f2;
            }
        }
        if (z) {
            g3(f, i9);
            i12 = 0;
            for (int i14 = 0; i14 < i10; i14++) {
                View view2 = this.L[i14];
                h3(view2, 1073741824, true);
                int iE2 = this.u.e(view2);
                if (iE2 > i12) {
                    i12 = iE2;
                }
            }
        }
        for (int i15 = 0; i15 < i10; i15++) {
            View view3 = this.L[i15];
            if (this.u.e(view3) != i12) {
                LayoutParams layoutParams = (LayoutParams) view3.getLayoutParams();
                Rect rect = layoutParams.b;
                int i16 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                int i17 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                int iB3 = b3(layoutParams.e, layoutParams.f);
                if (this.s == 1) {
                    iL2 = RecyclerView.p.L(iB3, 1073741824, i17, ((ViewGroup.MarginLayoutParams) layoutParams).width, false);
                    iL = View.MeasureSpec.makeMeasureSpec(i12 - i16, 1073741824);
                } else {
                    int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i12 - i17, 1073741824);
                    iL = RecyclerView.p.L(iB3, 1073741824, i16, ((ViewGroup.MarginLayoutParams) layoutParams).height, false);
                    iL2 = iMakeMeasureSpec;
                }
                i3(view3, iL2, iL, true);
            }
        }
        bVar.a = i12;
        if (this.s == 1) {
            if (cVar.f == -1) {
                i6 = cVar.b;
                i8 = i6 - i12;
            } else {
                i8 = cVar.b;
                i6 = i8 + i12;
            }
            i4 = i8;
            i5 = 0;
            i3 = 0;
        } else {
            if (cVar.f == -1) {
                i2 = cVar.b;
                i = i2 - i12;
            } else {
                i = cVar.b;
                i2 = i + i12;
            }
            i3 = i;
            i4 = 0;
            i5 = i2;
            i6 = 0;
        }
        int i18 = 0;
        while (i18 < i10) {
            View view4 = this.L[i18];
            LayoutParams layoutParams2 = (LayoutParams) view4.getLayoutParams();
            if (this.s == 1) {
                if (s2()) {
                    int iF0 = f0() + this.K[this.J - layoutParams2.e];
                    iF3 = i6;
                    iF = iF0;
                    iF2 = iF0 - this.u.f(view4);
                } else {
                    int iF02 = f0() + this.K[layoutParams2.e];
                    iF3 = i6;
                    iF2 = iF02;
                    iF = this.u.f(view4) + iF02;
                }
                i7 = i4;
            } else {
                int iH0 = h0() + this.K[layoutParams2.e];
                i7 = iH0;
                iF = i5;
                iF2 = i3;
                iF3 = this.u.f(view4) + iH0;
            }
            C0(view4, iF2, i7, iF, iF3);
            if (layoutParams2.c() || layoutParams2.b()) {
                bVar.c = true;
            }
            bVar.d |= view4.hasFocusable();
            i18++;
            i6 = iF3;
            i5 = iF;
            i3 = iF2;
            i4 = i7;
        }
        Arrays.fill(this.L, (Object) null);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.p
    public int v(RecyclerView.z zVar) {
        return this.Q ? X2(zVar) : super.v(zVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.p
    public int w(RecyclerView.z zVar) {
        return this.Q ? Y2(zVar) : super.w(zVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void w2(RecyclerView.v vVar, RecyclerView.z zVar, LinearLayoutManager.a aVar, int i) {
        super.w2(vVar, zVar, aVar, i);
        l3();
        if (zVar.b() > 0 && !zVar.e()) {
            Z2(vVar, zVar, aVar, i);
        }
        a3();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.p
    public int z1(int i, RecyclerView.v vVar, RecyclerView.z zVar) {
        l3();
        a3();
        return super.z1(i, vVar, zVar);
    }

    public static class LayoutParams extends RecyclerView.LayoutParams {
        int e;
        int f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.e = -1;
            this.f = 0;
        }

        public int e() {
            return this.e;
        }

        public int f() {
            return this.f;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.e = -1;
            this.f = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.e = -1;
            this.f = 0;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.e = -1;
            this.f = 0;
        }
    }

    public GridLayoutManager(Context context, int i) {
        super(context);
        this.I = false;
        this.J = -1;
        this.M = new SparseIntArray();
        this.N = new SparseIntArray();
        this.O = new a();
        this.P = new Rect();
        j3(i);
    }

    public GridLayoutManager(Context context, int i, int i2, boolean z) {
        super(context, i2, z);
        this.I = false;
        this.J = -1;
        this.M = new SparseIntArray();
        this.N = new SparseIntArray();
        this.O = new a();
        this.P = new Rect();
        j3(i);
    }
}
