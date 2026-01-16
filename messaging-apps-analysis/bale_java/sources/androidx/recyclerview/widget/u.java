package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes2.dex */
public class u extends y {
    private t d;
    private t e;

    class a extends o {
        a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.o, androidx.recyclerview.widget.RecyclerView.y
        protected void o(View view, RecyclerView.z zVar, RecyclerView.y.a aVar) {
            u uVar = u.this;
            int[] iArrC = uVar.c(uVar.a.getLayoutManager(), view);
            int i = iArrC[0];
            int i2 = iArrC[1];
            int iW = w(Math.max(Math.abs(i), Math.abs(i2)));
            if (iW > 0) {
                aVar.d(i, i2, iW, this.j);
            }
        }

        @Override // androidx.recyclerview.widget.o
        protected float v(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }

        @Override // androidx.recyclerview.widget.o
        protected int x(int i) {
            return Math.min(100, super.x(i));
        }
    }

    private int k(View view, t tVar) {
        return (tVar.g(view) + (tVar.e(view) / 2)) - (tVar.m() + (tVar.n() / 2));
    }

    private View l(RecyclerView.p pVar, t tVar) {
        int iK = pVar.K();
        View view = null;
        if (iK == 0) {
            return null;
        }
        int iM = tVar.m() + (tVar.n() / 2);
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < iK; i2++) {
            View viewJ = pVar.J(i2);
            int iAbs = Math.abs((tVar.g(viewJ) + (tVar.e(viewJ) / 2)) - iM);
            if (iAbs < i) {
                view = viewJ;
                i = iAbs;
            }
        }
        return view;
    }

    private t m(RecyclerView.p pVar) {
        t tVar = this.e;
        if (tVar == null || tVar.a != pVar) {
            this.e = t.a(pVar);
        }
        return this.e;
    }

    private t n(RecyclerView.p pVar) {
        if (pVar.m()) {
            return o(pVar);
        }
        if (pVar.l()) {
            return m(pVar);
        }
        return null;
    }

    private t o(RecyclerView.p pVar) {
        t tVar = this.d;
        if (tVar == null || tVar.a != pVar) {
            this.d = t.c(pVar);
        }
        return this.d;
    }

    private boolean p(RecyclerView.p pVar, int i, int i2) {
        return pVar.l() ? i > 0 : i2 > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean q(RecyclerView.p pVar) {
        PointF pointFA;
        int iZ = pVar.Z();
        if (!(pVar instanceof RecyclerView.y.b) || (pointFA = ((RecyclerView.y.b) pVar).a(iZ - 1)) == null) {
            return false;
        }
        return pointFA.x < 0.0f || pointFA.y < 0.0f;
    }

    @Override // androidx.recyclerview.widget.y
    public int[] c(RecyclerView.p pVar, View view) {
        int[] iArr = new int[2];
        if (pVar.l()) {
            iArr[0] = k(view, m(pVar));
        } else {
            iArr[0] = 0;
        }
        if (pVar.m()) {
            iArr[1] = k(view, o(pVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.y
    protected RecyclerView.y d(RecyclerView.p pVar) {
        if (pVar instanceof RecyclerView.y.b) {
            return new a(this.a.getContext());
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.y
    public View f(RecyclerView.p pVar) {
        if (pVar.m()) {
            return l(pVar, o(pVar));
        }
        if (pVar.l()) {
            return l(pVar, m(pVar));
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.y
    public int g(RecyclerView.p pVar, int i, int i2) {
        t tVarN;
        int iZ = pVar.Z();
        if (iZ == 0 || (tVarN = n(pVar)) == null) {
            return -1;
        }
        int iK = pVar.K();
        View view = null;
        int i3 = Integer.MAX_VALUE;
        int i4 = Integer.MIN_VALUE;
        View view2 = null;
        for (int i5 = 0; i5 < iK; i5++) {
            View viewJ = pVar.J(i5);
            if (viewJ != null) {
                int iK2 = k(viewJ, tVarN);
                if (iK2 <= 0 && iK2 > i4) {
                    view2 = viewJ;
                    i4 = iK2;
                }
                if (iK2 >= 0 && iK2 < i3) {
                    view = viewJ;
                    i3 = iK2;
                }
            }
        }
        boolean zP = p(pVar, i, i2);
        if (zP && view != null) {
            return pVar.i0(view);
        }
        if (!zP && view2 != null) {
            return pVar.i0(view2);
        }
        if (zP) {
            view = view2;
        }
        if (view == null) {
            return -1;
        }
        int iI0 = pVar.i0(view) + (q(pVar) == zP ? -1 : 1);
        if (iI0 < 0 || iI0 >= iZ) {
            return -1;
        }
        return iI0;
    }
}
