package ir.nasim;

import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC13460gG3;

/* loaded from: classes4.dex */
public class WT4 extends RecyclerView.C {
    private final C25083zi1 u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WT4(C25083zi1 c25083zi1) {
        super(c25083zi1.getRoot());
        AbstractC13042fc3.i(c25083zi1, "binding");
        this.u = c25083zi1;
    }

    public void C0(AbstractC13460gG3 abstractC13460gG3) {
        AbstractC13042fc3.i(abstractC13460gG3, "loadState");
        ProgressBar progressBar = this.u.b;
        if (abstractC13460gG3 instanceof AbstractC13460gG3.c) {
            AbstractC13042fc3.f(progressBar);
            progressBar.setVisibility(8);
        } else if (AbstractC13042fc3.d(abstractC13460gG3, AbstractC13460gG3.b.b)) {
            AbstractC13042fc3.f(progressBar);
            progressBar.setVisibility(0);
        }
    }
}
