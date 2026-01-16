package ir.nasim;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.jaryan.discover.model.PeerItem;
import ir.nasim.jaryan.discover.model.PeerSection;

/* renamed from: ir.nasim.fZ7, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C13017fZ7 extends RecyclerView.h {
    private final InterfaceC15426jZ7 d;
    private final PeerSection e;
    private final C13635gZ7 f;
    private final UA2 g;
    private final UA2 h;

    public C13017fZ7(InterfaceC15426jZ7 interfaceC15426jZ7, PeerSection peerSection, C13635gZ7 c13635gZ7, UA2 ua2, UA2 ua22) {
        AbstractC13042fc3.i(interfaceC15426jZ7, "vitrineClickListener");
        AbstractC13042fc3.i(peerSection, "peerCategorySection");
        AbstractC13042fc3.i(c13635gZ7, "vitrinRowHolder");
        AbstractC13042fc3.i(ua2, "bindItem");
        AbstractC13042fc3.i(ua22, "unbindItem");
        this.d = interfaceC15426jZ7;
        this.e = peerSection;
        this.f = c13635gZ7;
        this.g = ua2;
        this.h = ua22;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public C11765dZ7 onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        return C11765dZ7.J.a(viewGroup, this.d, this.f, this.g, this.h);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(C11765dZ7 c11765dZ7) {
        AbstractC13042fc3.i(c11765dZ7, "holder");
        super.onViewRecycled(c11765dZ7);
        c11765dZ7.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return this.e.getItems().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(C11765dZ7 c11765dZ7, int i) {
        AbstractC13042fc3.i(c11765dZ7, "holder");
        String title = this.e.getTitle();
        PeerItem peerItem = this.e.getItems().get(i);
        AbstractC13042fc3.h(peerItem, "get(...)");
        c11765dZ7.S0(title, peerItem, this.e.getId());
    }
}
