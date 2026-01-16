package ir.nasim;

import android.view.ViewGroup;
import ir.nasim.AbstractC15520jj2;
import ir.nasim.InterfaceC14910ih2;
import java.util.List;

/* renamed from: ir.nasim.zh2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C25074zh2 extends OT4 {
    public static final a l = new a(null);
    public static final int m = 8;
    private final O98 h;
    private final InterfaceC13138fj2 i;
    private final C14970in2 j;
    private final VI2 k;

    /* renamed from: ir.nasim.zh2$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C25074zh2(O98 o98, InterfaceC13138fj2 interfaceC13138fj2, C14970in2 c14970in2, VI2 vi2) {
        super(C20244rh2.a, null, null, 6, null);
        AbstractC13042fc3.i(interfaceC13138fj2, "feedListener");
        AbstractC13042fc3.i(c14970in2, "filesModule");
        AbstractC13042fc3.i(vi2, "glideRequests");
        this.h = o98;
        this.i = interfaceC13138fj2;
        this.j = c14970in2;
        this.k = vi2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(JA2 ja2, int i) {
        AbstractC13042fc3.i(ja2, "holder");
        C4743Gj2 c4743Gj2 = (C4743Gj2) D(i);
        if (c4743Gj2 == null) {
            return;
        }
        C5886Lg2 c5886Lg2E = c4743Gj2.e();
        if (c5886Lg2E.i() instanceof AbstractC15520jj2.g) {
            ((C17283mi2) ja2).K3(c5886Lg2E, (AbstractC15520jj2.g) c5886Lg2E.i());
            return;
        }
        ja2.p2(c4743Gj2);
        if ((c5886Lg2E.i() instanceof AbstractC15520jj2.e) && AbstractC13042fc3.d(((AbstractC15520jj2.e) c5886Lg2E.i()).b(), "photo")) {
            ((C15510ji2) ja2).T3(c5886Lg2E, (AbstractC15520jj2.e) c5886Lg2E.i());
            return;
        }
        if (c5886Lg2E.i() instanceof AbstractC15520jj2.h) {
            ((C22714vi2) ja2).S3(c5886Lg2E, (AbstractC15520jj2.h) c5886Lg2E.i());
        } else if (c5886Lg2E.i() instanceof AbstractC15520jj2.f) {
            ((C19056pi2) ja2).M3(c5886Lg2E, (AbstractC15520jj2.f) c5886Lg2E.i());
        } else if (c5886Lg2E.i() instanceof AbstractC15520jj2.c) {
            ((C9289Zh2) ja2).T3(c5886Lg2E, (AbstractC15520jj2.c) c5886Lg2E.i());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(JA2 ja2, int i, List list) {
        AbstractC13042fc3.i(ja2, "holder");
        AbstractC13042fc3.i(list, "payloads");
        List listC = AbstractC19810qy7.c(list);
        if (listC.size() == 1 && (listC.get(0) instanceof List)) {
            Object obj = list.get(0);
            AbstractC13042fc3.g(obj, "null cannot be cast to non-null type kotlin.collections.MutableList<*>");
            listC = AbstractC19810qy7.c(obj);
        }
        if (listC.isEmpty()) {
            super.onBindViewHolder(ja2, i, list);
            return;
        }
        for (Object obj2 : listC) {
            if (obj2 instanceof InterfaceC14910ih2.a) {
                ja2.N2(((InterfaceC14910ih2.a) obj2).a());
            } else if (obj2 instanceof InterfaceC14910ih2.c) {
                ja2.X2(((InterfaceC14910ih2.c) obj2).a());
            } else if (obj2 instanceof InterfaceC14910ih2.b) {
                ja2.O2(((InterfaceC14910ih2.b) obj2).a());
            } else {
                C19406qI3.g("FeedFullScreenAdapter", "payload: " + obj2 + " ignored in position: " + i, new Object[0]);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public JA2 onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        return i == EnumC12502ej2.d.j() ? C15510ji2.T0.a(viewGroup, this.i, this.j, this.k, this.h) : i == EnumC12502ej2.e.j() ? C22714vi2.U0.a(viewGroup, this.i, this.k, this.h) : i == EnumC12502ej2.c.j() ? C19056pi2.O0.a(viewGroup, this.i, this.h) : i == EnumC12502ej2.g.j() ? C9289Zh2.T0.a(viewGroup, this.i, this.j, this.k, this.h) : C17283mi2.Q0.a(viewGroup, this.i, this.h);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(JA2 ja2) {
        AbstractC13042fc3.i(ja2, "holder");
        super.onViewRecycled(ja2);
        ja2.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemViewType(int i) {
        C4743Gj2 c4743Gj2 = (C4743Gj2) D(i);
        return c4743Gj2 == null ? EnumC12502ej2.b.j() : c4743Gj2.e().i().a();
    }
}
