package ir.nasim;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.jaryan.discover.model.BannerSection;

/* loaded from: classes6.dex */
public final class T80 extends RecyclerView.C {
    private final U80 u;
    private final InterfaceC24154y80 v;
    private final UA2 w;
    private final UA2 x;
    private G80 y;
    public static final a z = new a(null);
    public static final int A = 8;

    public static final class a {
        private a() {
        }

        public final T80 a(ViewGroup viewGroup, InterfaceC24154y80 interfaceC24154y80, UA2 ua2, UA2 ua22) {
            AbstractC13042fc3.i(viewGroup, "parent");
            AbstractC13042fc3.i(interfaceC24154y80, "bannerClickListener");
            AbstractC13042fc3.i(ua2, "bindItem");
            AbstractC13042fc3.i(ua22, "unbindItem");
            U80 u80C = U80.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            AbstractC13042fc3.h(u80C, "inflate(...)");
            return new T80(u80C, interfaceC24154y80, ua2, ua22);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public T80(U80 u80, InterfaceC24154y80 interfaceC24154y80, UA2 ua2, UA2 ua22) {
        super(u80.getRoot());
        AbstractC13042fc3.i(u80, "binding");
        AbstractC13042fc3.i(interfaceC24154y80, "bannerClickListener");
        AbstractC13042fc3.i(ua2, "bindItem");
        AbstractC13042fc3.i(ua22, "unbindItem");
        this.u = u80;
        this.v = interfaceC24154y80;
        this.w = ua2;
        this.x = ua22;
        G80 g80 = new G80(interfaceC24154y80, ua2, ua22);
        this.y = g80;
        u80.b.setAdapter(g80);
        u80.b.setNestedScrollingEnabled(false);
    }

    public final void C0(BannerSection bannerSection) {
        AbstractC13042fc3.i(bannerSection, "bannerSection");
        if (this.y == null) {
            this.y = new G80(this.v, this.w, this.x);
        }
        this.u.b.setAdapter(this.y);
        G80 g80 = this.y;
        if (g80 != null) {
            g80.C(bannerSection.getItems(), bannerSection.getId());
        }
    }

    public final void a() {
        this.y = null;
        this.u.b.setAdapter(null);
    }
}
