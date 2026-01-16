package ir.nasim;

import android.view.ViewGroup;
import ir.nasim.InterfaceC14910ih2;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Mg2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C6119Mg2 extends OT4 {
    private static final a k = new a(null);
    public static final int l = 8;
    private final C14970in2 h;
    private final InterfaceC13138fj2 i;
    private final InterfaceC14123hO3 j;

    /* renamed from: ir.nasim.Mg2$a */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C6119Mg2(C14970in2 c14970in2, InterfaceC13138fj2 interfaceC13138fj2, InterfaceC14123hO3 interfaceC14123hO3) {
        super(C20244rh2.a, null, null, 6, null);
        AbstractC13042fc3.i(c14970in2, "filesModule");
        AbstractC13042fc3.i(interfaceC13138fj2, "feedListener");
        AbstractC13042fc3.i(interfaceC14123hO3, "mediaMessageToAbsContentMapper");
        this.h = c14970in2;
        this.i = interfaceC13138fj2;
        this.j = interfaceC14123hO3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(AbstractC10505bj2 abstractC10505bj2, int i) {
        AbstractC13042fc3.i(abstractC10505bj2, "holder");
        C4743Gj2 c4743Gj2 = (C4743Gj2) D(i);
        if (c4743Gj2 != null) {
            abstractC10505bj2.n2(c4743Gj2);
            abstractC10505bj2.E2(c4743Gj2.e().i());
            return;
        }
        C19406qI3.b("FeedAdapter", "getItem returned null for position: " + i);
        abstractC10505bj2.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(AbstractC10505bj2 abstractC10505bj2, int i, List list) {
        AbstractC13042fc3.i(abstractC10505bj2, "holder");
        AbstractC13042fc3.i(list, "payloads");
        ArrayList<InterfaceC14910ih2> arrayList = new ArrayList();
        for (Object obj : list) {
            List listM = obj instanceof List ? (List) obj : null;
            if (listM == null) {
                listM = AbstractC10360bX0.m();
            }
            AbstractC13610gX0.D(arrayList, listM);
        }
        if (arrayList.isEmpty()) {
            super.onBindViewHolder(abstractC10505bj2, i, list);
            return;
        }
        for (InterfaceC14910ih2 interfaceC14910ih2 : arrayList) {
            if (interfaceC14910ih2 instanceof InterfaceC14910ih2.a) {
                abstractC10505bj2.G2(((InterfaceC14910ih2.a) interfaceC14910ih2).a());
            } else if (interfaceC14910ih2 instanceof InterfaceC14910ih2.d) {
                InterfaceC14910ih2.d dVar = (InterfaceC14910ih2.d) interfaceC14910ih2;
                abstractC10505bj2.P2(dVar.a(), dVar.b());
            } else if (interfaceC14910ih2 instanceof InterfaceC14910ih2.c) {
                abstractC10505bj2.S2(((InterfaceC14910ih2.c) interfaceC14910ih2).a());
            } else {
                if (!(interfaceC14910ih2 instanceof InterfaceC14910ih2.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                abstractC10505bj2.H2(((InterfaceC14910ih2.b) interfaceC14910ih2).a());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public AbstractC10505bj2 onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        return i == EnumC12502ej2.c.j() ? C7380Rl7.J0.a(viewGroup, this.i) : i == EnumC12502ej2.d.j() ? H85.O0.a(viewGroup, this.h, viewGroup.getWidth(), this.j, this.i) : i == EnumC12502ej2.g.j() ? C17623nH2.R0.a(viewGroup, this.h, viewGroup.getWidth(), this.j, this.i) : i == EnumC12502ej2.e.j() ? C15372jT7.T0.a(viewGroup, viewGroup.getWidth(), this.j, this.i) : i == EnumC12502ej2.f.j() ? C17901nl.L0.a(viewGroup, this.h, this.j, this.i) : C7380Rl7.J0.a(viewGroup, this.i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(AbstractC10505bj2 abstractC10505bj2) {
        AbstractC13042fc3.i(abstractC10505bj2, "holder");
        super.onViewRecycled(abstractC10505bj2);
        abstractC10505bj2.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemViewType(int i) {
        C4743Gj2 c4743Gj2 = (C4743Gj2) D(i);
        if (c4743Gj2 != null) {
            return c4743Gj2.e().i().a();
        }
        C19406qI3.b("FeedAdapter", "null item at position: " + i);
        return EnumC12502ej2.b.j();
    }
}
