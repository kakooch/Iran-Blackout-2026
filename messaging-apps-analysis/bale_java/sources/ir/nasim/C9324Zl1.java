package ir.nasim;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* renamed from: ir.nasim.Zl1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C9324Zl1 {
    private final C6163Ml1 a;

    public C9324Zl1(RecyclerView recyclerView, SA2 sa2) {
        AbstractC13042fc3.i(recyclerView, "recyclerView");
        AbstractC13042fc3.i(sa2, "onItemClick");
        Context context = recyclerView.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        C6163Ml1 c6163Ml1 = new C6163Ml1(context, sa2);
        this.a = c6163Ml1;
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(c6163Ml1);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setItemAnimator(null);
        recyclerView.setClipToOutline(true);
    }

    public final void a(List list) {
        AbstractC13042fc3.i(list, "items");
        this.a.C(list);
    }
}
