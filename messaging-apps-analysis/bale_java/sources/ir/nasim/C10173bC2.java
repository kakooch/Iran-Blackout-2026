package ir.nasim;

import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.bC2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C10173bC2 extends androidx.recyclerview.widget.q {
    private final boolean f;
    private final VI2 g;
    private final InterfaceC14603iB2 h;
    private final UA2 i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C10173bC2(boolean z, VI2 vi2, InterfaceC14603iB2 interfaceC14603iB2, UA2 ua2) {
        super(ZC2.a);
        AbstractC13042fc3.i(vi2, "glideRequests");
        AbstractC13042fc3.i(interfaceC14603iB2, "onItemClicked");
        AbstractC13042fc3.i(ua2, "photoViewerOpener");
        this.f = z;
        this.g = vi2;
        this.h = interfaceC14603iB2;
        this.i = ua2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(C24797zD2 c24797zD2, int i) {
        AbstractC13042fc3.i(c24797zD2, "holder");
        c24797zD2.F0((C21837uD2) A(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(C24797zD2 c24797zD2, int i, List list) {
        AbstractC13042fc3.i(c24797zD2, "holder");
        AbstractC13042fc3.i(list, "payloads");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            List listM = obj instanceof List ? (List) obj : null;
            if (listM == null) {
                listM = AbstractC10360bX0.m();
            }
            AbstractC13610gX0.D(arrayList, listM);
        }
        if (arrayList.isEmpty()) {
            onBindViewHolder(c24797zD2, i);
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            c24797zD2.P0((O15) it.next());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public C24797zD2 onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        return C24797zD2.z.a(viewGroup, this.f, this.g, this.h, this.i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(C24797zD2 c24797zD2) {
        AbstractC13042fc3.i(c24797zD2, "holder");
        c24797zD2.a();
    }
}
