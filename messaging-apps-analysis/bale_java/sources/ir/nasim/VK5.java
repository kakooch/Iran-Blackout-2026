package ir.nasim;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes5.dex */
public class VK5 {
    final RecyclerView a;
    final RecyclerView.p b;

    VK5(RecyclerView recyclerView) {
        this.a = recyclerView;
        this.b = recyclerView.getLayoutManager();
    }

    public static VK5 a(RecyclerView recyclerView) {
        if (recyclerView != null) {
            return new VK5(recyclerView);
        }
        throw new NullPointerException("Recycler View is null");
    }

    public int b() {
        View viewC = c(this.b.K() - 1);
        if (viewC == null) {
            return -1;
        }
        return this.a.getChildAdapterPosition(viewC);
    }

    View c(int i) {
        androidx.recyclerview.widget.t tVarC = this.b.m() ? androidx.recyclerview.widget.t.c(this.b) : androidx.recyclerview.widget.t.a(this.b);
        int iM = tVarC.m();
        int i2 = tVarC.i();
        int i3 = -1 > i ? 1 : -1;
        while (i != -1) {
            View viewJ = this.b.J(i);
            int iG = tVarC.g(viewJ);
            int iD = tVarC.d(viewJ);
            if (iG < i2 && iD > iM) {
                return viewJ;
            }
            i += i3;
        }
        return null;
    }
}
