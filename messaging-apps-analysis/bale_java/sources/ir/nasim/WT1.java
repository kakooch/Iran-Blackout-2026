package ir.nasim;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C12950fS3;
import ir.nasim.core.modules.market.model.MarketSection;
import ir.nasim.jaryan.discover.model.BannerSection;
import ir.nasim.jaryan.discover.model.DiscoverSection;
import ir.nasim.jaryan.discover.model.PeerSection;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public final class WT1 extends RecyclerView.h {
    private final InterfaceC13568gS3 d;
    private final InterfaceC14159hS3 e;
    private final InterfaceC14770iS3 f;
    private final C12950fS3.b g;
    private final InterfaceC24154y80 h;
    private final InterfaceC15426jZ7 i;
    private final UA2 j;
    private final UA2 k;
    private final int l;
    private final int m;
    private final int n;
    private final int o;
    private final List p;

    public WT1(InterfaceC13568gS3 interfaceC13568gS3, InterfaceC14159hS3 interfaceC14159hS3, InterfaceC14770iS3 interfaceC14770iS3, C12950fS3.b bVar, InterfaceC24154y80 interfaceC24154y80, InterfaceC15426jZ7 interfaceC15426jZ7, UA2 ua2, UA2 ua22) {
        AbstractC13042fc3.i(interfaceC13568gS3, "hintClickListener");
        AbstractC13042fc3.i(interfaceC14159hS3, "onItemClickListener");
        AbstractC13042fc3.i(interfaceC14770iS3, "moreItemClickListener");
        AbstractC13042fc3.i(bVar, "onLongItemClick");
        AbstractC13042fc3.i(interfaceC24154y80, "bannerClickListener");
        AbstractC13042fc3.i(interfaceC15426jZ7, "vitrineClickListener");
        AbstractC13042fc3.i(ua2, "bindItem");
        AbstractC13042fc3.i(ua22, "unbindItem");
        this.d = interfaceC13568gS3;
        this.e = interfaceC14159hS3;
        this.f = interfaceC14770iS3;
        this.g = bVar;
        this.h = interfaceC24154y80;
        this.i = interfaceC15426jZ7;
        this.j = ua2;
        this.k = ua22;
        this.l = 1;
        this.m = 2;
        this.n = 3;
        this.o = -1;
        this.p = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return this.p.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemViewType(int i) {
        DiscoverSection discoverSection = (DiscoverSection) this.p.get(i);
        DiscoverSection.Companion companion = DiscoverSection.INSTANCE;
        return companion.c(discoverSection) ? this.l : companion.b(discoverSection) ? this.m : companion.a(discoverSection) ? this.n : this.o;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void onBindViewHolder(RecyclerView.C c, int i) {
        AbstractC13042fc3.i(c, "holder");
        if (c instanceof C13635gZ7) {
            PeerSection peerSection = ((DiscoverSection) this.p.get(i)).getPeerSection();
            AbstractC13042fc3.f(peerSection);
            ((C13635gZ7) c).C0(peerSection);
        } else if (c instanceof T80) {
            BannerSection bannerSection = ((DiscoverSection) this.p.get(i)).getBannerSection();
            AbstractC13042fc3.f(bannerSection);
            ((T80) c).C0(bannerSection);
        } else if (c instanceof C11698dS3) {
            MarketSection marketSection = ((DiscoverSection) this.p.get(i)).getMarketSection();
            AbstractC13042fc3.f(marketSection);
            ((C11698dS3) c).E0(marketSection);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public RecyclerView.C onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        return i == this.l ? C13635gZ7.A.a(viewGroup, this.i, this.j, this.k) : i == this.m ? C11698dS3.D.a(viewGroup, this.d, this.e, this.f, this.g, this.j, this.k) : i == this.n ? T80.z.a(viewGroup, this.h, this.j, this.k) : C13635gZ7.A.a(viewGroup, this.i, this.j, this.k);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void onViewRecycled(RecyclerView.C c) {
        AbstractC13042fc3.i(c, "holder");
        if (c instanceof C13635gZ7) {
            ((C13635gZ7) c).a();
        } else if (c instanceof T80) {
            ((T80) c).a();
        } else if (c instanceof C11698dS3) {
            ((C11698dS3) c).a();
        }
    }

    public final void z(List list) {
        AbstractC13042fc3.i(list, "vitrineSections");
        this.p.clear();
        this.p.addAll(list);
        notifyDataSetChanged();
    }
}
