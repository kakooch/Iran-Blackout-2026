package ir.nasim;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.jaryan.discover.model.PeerSection;

/* renamed from: ir.nasim.gZ7, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C13635gZ7 extends RecyclerView.C implements IZ7 {
    public static final a A = new a(null);
    public static final int B = 8;
    private final C14226hZ7 u;
    private final InterfaceC15426jZ7 v;
    private final UA2 w;
    private final UA2 x;
    private PeerSection y;
    private C13017fZ7 z;

    /* renamed from: ir.nasim.gZ7$a */
    public static final class a {
        private a() {
        }

        public final C13635gZ7 a(ViewGroup viewGroup, InterfaceC15426jZ7 interfaceC15426jZ7, UA2 ua2, UA2 ua22) {
            AbstractC13042fc3.i(viewGroup, "parent");
            AbstractC13042fc3.i(interfaceC15426jZ7, "vitrineClickListener");
            AbstractC13042fc3.i(ua2, "bindItem");
            AbstractC13042fc3.i(ua22, "unbindItem");
            C14226hZ7 c14226hZ7C = C14226hZ7.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            AbstractC13042fc3.h(c14226hZ7C, "inflate(...)");
            c14226hZ7C.d.setTypeface(C6011Lu2.i());
            return new C13635gZ7(c14226hZ7C, interfaceC15426jZ7, ua2, ua22);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C13635gZ7(C14226hZ7 c14226hZ7, InterfaceC15426jZ7 interfaceC15426jZ7, UA2 ua2, UA2 ua22) {
        super(c14226hZ7.getRoot());
        AbstractC13042fc3.i(c14226hZ7, "binding");
        AbstractC13042fc3.i(interfaceC15426jZ7, "vitrineClickListener");
        AbstractC13042fc3.i(ua2, "bindItem");
        AbstractC13042fc3.i(ua22, "unbindItem");
        this.u = c14226hZ7;
        this.v = interfaceC15426jZ7;
        this.w = ua2;
        this.x = ua22;
        c14226hZ7.c.setNestedScrollingEnabled(false);
    }

    public final void C0(PeerSection peerSection) {
        AbstractC13042fc3.i(peerSection, "peerCategorySection");
        this.y = peerSection;
        this.u.d.setText(peerSection.getTitle());
        this.z = new C13017fZ7(this.v, peerSection, this, this.w, this.x);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.a.getContext(), 0, false);
        linearLayoutManager.J2(false);
        this.u.c.setLayoutManager(linearLayoutManager);
        this.u.c.setAdapter(this.z);
        this.u.c.setNestedScrollingEnabled(false);
    }

    public final void a() {
        this.z = null;
        this.u.c.setAdapter(null);
    }

    @Override // ir.nasim.IZ7
    public void m(int i) {
        String name;
        try {
            RecyclerView.p layoutManager = this.u.c.getLayoutManager();
            AbstractC13042fc3.g(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            if (this.y != null) {
                if (linearLayoutManager.e2() == r2.getItemsCount() - 1) {
                    return;
                }
            }
            this.u.c.smoothScrollBy(-i, 0);
        } catch (Exception e) {
            if (e.getClass().isAnonymousClass()) {
                name = e.getClass().getName();
                int length = name.length();
                AbstractC13042fc3.f(name);
                if (length > 23) {
                    name = name.substring(name.length() - 23, name.length());
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            } else {
                name = e.getClass().getSimpleName();
                int length2 = name.length();
                AbstractC13042fc3.f(name);
                if (length2 > 23) {
                    name = name.substring(0, 23);
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            }
            C19406qI3.d(name, e);
        }
    }
}
