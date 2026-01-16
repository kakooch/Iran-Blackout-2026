package androidx.recyclerview.widget;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes2.dex */
public abstract class y extends RecyclerView.r {
    RecyclerView a;
    private Scroller b;
    private final RecyclerView.t c = new a();

    class a extends RecyclerView.t {
        boolean a = false;

        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void a(RecyclerView recyclerView, int i) {
            super.a(recyclerView, i);
            if (i == 0 && this.a) {
                this.a = false;
                y.this.j();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(RecyclerView recyclerView, int i, int i2) {
            if (i == 0 && i2 == 0) {
                return;
            }
            this.a = true;
        }
    }

    private void e() {
        this.a.removeOnScrollListener(this.c);
        this.a.setOnFlingListener(null);
    }

    private void h() {
        if (this.a.getOnFlingListener() != null) {
            throw new IllegalStateException("An instance of OnFlingListener already set.");
        }
        this.a.addOnScrollListener(this.c);
        this.a.setOnFlingListener(this);
    }

    private boolean i(RecyclerView.p pVar, int i, int i2) {
        RecyclerView.y yVarD;
        int iG;
        if (!(pVar instanceof RecyclerView.y.b) || (yVarD = d(pVar)) == null || (iG = g(pVar, i, i2)) == -1) {
            return false;
        }
        yVarD.p(iG);
        pVar.M1(yVarD);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public boolean a(int i, int i2) {
        RecyclerView.p layoutManager = this.a.getLayoutManager();
        if (layoutManager == null || this.a.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.a.getMinFlingVelocity();
        return (Math.abs(i2) > minFlingVelocity || Math.abs(i) > minFlingVelocity) && i(layoutManager, i, i2);
    }

    public void b(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.a;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            e();
        }
        this.a = recyclerView;
        if (recyclerView != null) {
            h();
            this.b = new Scroller(this.a.getContext(), new DecelerateInterpolator());
            j();
        }
    }

    public abstract int[] c(RecyclerView.p pVar, View view);

    protected abstract RecyclerView.y d(RecyclerView.p pVar);

    public abstract View f(RecyclerView.p pVar);

    public abstract int g(RecyclerView.p pVar, int i, int i2);

    void j() {
        RecyclerView.p layoutManager;
        View viewF;
        RecyclerView recyclerView = this.a;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || (viewF = f(layoutManager)) == null) {
            return;
        }
        int[] iArrC = c(layoutManager, viewF);
        int i = iArrC[0];
        if (i == 0 && iArrC[1] == 0) {
            return;
        }
        this.a.smoothScrollBy(i, iArrC[1]);
    }
}
