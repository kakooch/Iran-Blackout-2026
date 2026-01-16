package ir.nasim;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C16541lS3;
import ir.nasim.C20096rT3;
import ir.nasim.HQ3;
import ir.nasim.core.modules.market.model.MarketMenu;
import ir.nasim.core.modules.market.model.MarketSection;
import ir.nasim.core.modules.market.model.MarketSlider;
import java.util.ArrayList;

/* renamed from: ir.nasim.fS3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C12950fS3 extends RecyclerView.h {
    public static final a p = new a(null);
    public static final int q = 8;
    private final boolean d;
    private final UA2 e;
    private final UA2 f;
    private boolean g;
    private InterfaceC14159hS3 h;
    private InterfaceC14770iS3 i;
    private InterfaceC13568gS3 j;
    private C20096rT3.a k;
    private HQ3.a l;
    private c m;
    private b n;
    private ArrayList o;

    /* renamed from: ir.nasim.fS3$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.fS3$b */
    public interface b {
        void x2(Object obj);
    }

    /* renamed from: ir.nasim.fS3$c */
    public interface c {
        void g3(C17132mS3 c17132mS3);
    }

    /* renamed from: ir.nasim.fS3$d */
    public static final class d implements b {
        d() {
        }

        @Override // ir.nasim.C12950fS3.b
        public void x2(Object obj) {
            AbstractC13042fc3.i(obj, "item");
        }
    }

    public C12950fS3(boolean z, UA2 ua2, UA2 ua22) {
        AbstractC13042fc3.i(ua2, "bindItem");
        AbstractC13042fc3.i(ua22, "unbindItem");
        this.d = z;
        this.e = ua2;
        this.f = ua22;
        this.o = new ArrayList();
    }

    public final void A(InterfaceC13568gS3 interfaceC13568gS3) {
        this.j = interfaceC13568gS3;
    }

    public final void B(InterfaceC14159hS3 interfaceC14159hS3) {
        this.h = interfaceC14159hS3;
    }

    public final void C(b bVar) {
        this.n = bVar;
    }

    public final void D(HQ3.a aVar) {
        this.l = aVar;
    }

    public final void E(InterfaceC14770iS3 interfaceC14770iS3) {
        this.i = interfaceC14770iS3;
    }

    public final void F(c cVar) {
        this.m = cVar;
    }

    public final void G(C20096rT3.a aVar) {
        this.k = aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return this.o.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemViewType(int i) {
        Object obj = this.o.get(i);
        if (obj instanceof MarketSlider) {
            return 2;
        }
        if (obj instanceof MarketMenu) {
            return 3;
        }
        return obj instanceof C17132mS3 ? 4 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void onBindViewHolder(RecyclerView.C c2, int i) {
        boolean z;
        AbstractC13042fc3.i(c2, "holder");
        if (c2 instanceof KQ3) {
            Object obj = this.o.get(i);
            AbstractC13042fc3.g(obj, "null cannot be cast to non-null type ir.nasim.core.modules.market.model.MarketMenu");
            ((KQ3) c2).C0((MarketMenu) obj);
            return;
        }
        if (c2 instanceof C20705sT3) {
            Object obj2 = this.o.get(i);
            AbstractC13042fc3.g(obj2, "null cannot be cast to non-null type ir.nasim.core.modules.market.model.MarketSlider");
            ((C20705sT3) c2).H0((MarketSlider) obj2);
            return;
        }
        if (c2 instanceof C15959kT3) {
            Object obj3 = this.o.get(i);
            AbstractC13042fc3.g(obj3, "null cannot be cast to non-null type ir.nasim.core.modules.market.model.MarketSearch");
            ((C15959kT3) c2).D0((C17132mS3) obj3);
        } else if (c2 instanceof C16541lS3) {
            C16541lS3 c16541lS3 = (C16541lS3) c2;
            Object obj4 = this.o.get(i);
            AbstractC13042fc3.g(obj4, "null cannot be cast to non-null type ir.nasim.core.modules.market.model.MarketSection");
            MarketSection marketSection = (MarketSection) obj4;
            if (this.g) {
                z = false;
            } else {
                this.g = true;
                z = this.d;
            }
            c16541lS3.F0(marketSection, z);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public RecyclerView.C onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        if (i == 2) {
            return C20705sT3.A.a(viewGroup, this.k);
        }
        if (i == 3) {
            return KQ3.x.a(viewGroup, this.l);
        }
        if (i == 4) {
            return C15959kT3.w.a(viewGroup, this.m);
        }
        C16541lS3.a aVar = C16541lS3.D;
        InterfaceC14159hS3 interfaceC14159hS3 = this.h;
        InterfaceC14770iS3 interfaceC14770iS3 = this.i;
        InterfaceC13568gS3 interfaceC13568gS3 = this.j;
        b dVar = this.n;
        if (dVar == null) {
            dVar = new d();
        }
        return aVar.a(viewGroup, interfaceC14159hS3, interfaceC14770iS3, interfaceC13568gS3, dVar, this.e, this.f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        AbstractC13042fc3.i(recyclerView, "recyclerView");
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            RecyclerView.C childViewHolder = recyclerView.getChildViewHolder(recyclerView.getChildAt(i));
            if (childViewHolder instanceof C20705sT3) {
                ((C20705sT3) childViewHolder).O0();
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void onViewRecycled(RecyclerView.C c2) {
        AbstractC13042fc3.i(c2, "holder");
        if (c2 instanceof C20705sT3) {
            ((C20705sT3) c2).O0();
        }
    }

    public final ArrayList z() {
        return this.o;
    }
}
