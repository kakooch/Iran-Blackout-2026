package ir.nasim;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC20283rl;
import ir.nasim.M44;
import java.util.List;

/* renamed from: ir.nasim.vl, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C22741vl extends RecyclerView.C implements O44, InterfaceC9437Zx6 {
    public static final a w = new a(null);
    public static final int x = 8;
    private final AbstractC20283rl u;
    private final boolean v;

    /* renamed from: ir.nasim.vl$a */
    public static final class a {
        private a() {
        }

        public final C22741vl a(ViewGroup viewGroup, InterfaceC11285cl interfaceC11285cl, AbstractC20283rl.a aVar, boolean z) {
            AbstractC13042fc3.i(viewGroup, "parent");
            AbstractC13042fc3.i(interfaceC11285cl, "albumClickListener");
            AbstractC13042fc3.i(aVar, "albumItemFactory");
            return new C22741vl(aVar.a(viewGroup, interfaceC11285cl), z, null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ C22741vl(AbstractC20283rl abstractC20283rl, boolean z, ED1 ed1) {
        this(abstractC20283rl, z);
    }

    public final void C0(C14339hl c14339hl, XV4 xv4, int i, EnumC8893Xt7 enumC8893Xt7, String str) {
        AbstractC13042fc3.i(c14339hl, "albumData");
        AbstractC13042fc3.i(xv4, "measuredSize");
        AbstractC13042fc3.i(str, "contentDescription");
        long jI = c14339hl.d().h().i();
        long jH = c14339hl.d().h().h();
        StringBuilder sb = new StringBuilder();
        sb.append(jI);
        sb.append(jH);
        this.u.c(c14339hl, new C17177mX3(i, xv4, this.v, sb.toString(), enumC8893Xt7), str);
        this.u.r();
    }

    public final void D0(InterfaceC23337wl interfaceC23337wl) {
        AbstractC13042fc3.i(interfaceC23337wl, "payload");
        this.u.f(interfaceC23337wl);
    }

    public final void a() {
        this.u.a();
    }

    @Override // ir.nasim.InterfaceC9437Zx6
    public C8948Xx6 b() {
        return this.u.b();
    }

    @Override // ir.nasim.InterfaceC9437Zx6
    public void e() {
        this.u.e();
    }

    @Override // ir.nasim.InterfaceC9437Zx6
    public List g() {
        return this.u.g();
    }

    @Override // ir.nasim.O44
    public void j(M44.a aVar) {
        AbstractC13042fc3.i(aVar, "builder");
        this.u.j(aVar);
    }

    @Override // ir.nasim.InterfaceC9437Zx6
    public void n() {
        this.u.n();
    }

    @Override // ir.nasim.InterfaceC9437Zx6
    public void u() {
        this.u.u();
    }

    private C22741vl(AbstractC20283rl abstractC20283rl, boolean z) {
        super(abstractC20283rl.p());
        this.u = abstractC20283rl;
        this.v = z;
    }
}
