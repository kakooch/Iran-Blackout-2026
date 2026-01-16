package ir.nasim.dialoglist.ui.noneCompose;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C19406qI3;

/* loaded from: classes5.dex */
public final class a extends RecyclerView.t {
    final /* synthetic */ DialogLayoutManager a;

    a(DialogLayoutManager dialogLayoutManager) {
        this.a = dialogLayoutManager;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.t
    public void a(RecyclerView recyclerView, int i) {
        AbstractC13042fc3.i(recyclerView, "recyclerView");
        boolean z = i != 0;
        if (this.a.isScrolling != z) {
            this.a.isScrolling = z;
            C19406qI3.a("DialogLayoutManager", "Internal listener updated scrolling state to: " + this.a.isScrolling, new Object[0]);
        }
    }
}
