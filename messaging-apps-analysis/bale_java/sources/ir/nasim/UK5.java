package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.EG6;

/* loaded from: classes5.dex */
public abstract class UK5 {
    public static final void a(RecyclerView recyclerView, androidx.recyclerview.widget.y yVar, EG6.a aVar, EG6.b bVar) {
        AbstractC13042fc3.i(recyclerView, "<this>");
        AbstractC13042fc3.i(yVar, "snapHelper");
        AbstractC13042fc3.i(aVar, "behavior");
        AbstractC13042fc3.i(bVar, "onSnapPositionChangeListener");
        yVar.b(recyclerView);
        recyclerView.addOnScrollListener(new EG6(yVar, aVar, bVar));
    }

    public static /* synthetic */ void b(RecyclerView recyclerView, androidx.recyclerview.widget.y yVar, EG6.a aVar, EG6.b bVar, int i, Object obj) {
        if ((i & 2) != 0) {
            aVar = EG6.a.a;
        }
        a(recyclerView, yVar, aVar, bVar);
    }
}
