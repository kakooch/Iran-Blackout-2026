package ir.nasim;

import android.view.View;
import android.view.ViewGroup;
import ir.nasim.M44;

/* renamed from: ir.nasim.rl, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC20283rl implements O44, InterfaceC9437Zx6 {
    private final View a;
    private final InterfaceC11285cl b;
    private LW1 c;

    /* renamed from: ir.nasim.rl$a */
    public interface a {
        AbstractC20283rl a(ViewGroup viewGroup, InterfaceC11285cl interfaceC11285cl);
    }

    /* renamed from: ir.nasim.rl$b */
    public static final class b implements InterfaceC23783xW1 {
        b() {
        }

        @Override // ir.nasim.InterfaceC23783xW1
        public boolean a() {
            return AbstractC20283rl.this.m().a();
        }

        @Override // ir.nasim.InterfaceC23783xW1
        public boolean b(C14339hl c14339hl) {
            AbstractC13042fc3.i(c14339hl, "albumData");
            return AbstractC20283rl.this.m().b(c14339hl);
        }

        @Override // ir.nasim.InterfaceC23783xW1
        public void c(C14339hl c14339hl) {
            AbstractC13042fc3.i(c14339hl, "albumData");
            AbstractC20283rl.this.m().c(c14339hl);
        }

        @Override // ir.nasim.InterfaceC23783xW1
        public void d(C14339hl c14339hl) {
            AbstractC13042fc3.i(c14339hl, "albumData");
            InterfaceC11285cl interfaceC11285clM = AbstractC20283rl.this.m();
            C8948Xx6 c8948Xx6B = AbstractC20283rl.this.b();
            interfaceC11285clM.d(c14339hl, c8948Xx6B != null ? c8948Xx6B.c() : null);
        }

        @Override // ir.nasim.InterfaceC23783xW1
        public void e() {
            AbstractC20283rl.this.s();
        }
    }

    public AbstractC20283rl(View view, InterfaceC11285cl interfaceC11285cl) {
        AbstractC13042fc3.i(view, "root");
        AbstractC13042fc3.i(interfaceC11285cl, "albumClickListener");
        this.a = view;
        this.b = interfaceC11285cl;
    }

    private final InterfaceC23783xW1 k() {
        return new b();
    }

    public void a() {
        LW1 lw1 = this.c;
        if (lw1 != null) {
            lw1.s();
        }
        this.c = null;
    }

    public void c(C14339hl c14339hl, AbstractC15537jl abstractC15537jl, String str) {
        AbstractC13042fc3.i(c14339hl, "albumData");
        AbstractC13042fc3.i(abstractC15537jl, "extras");
        AbstractC13042fc3.i(str, "contentDescription");
        this.a.setContentDescription(str);
        LW1 lw1L = l(k(), abstractC15537jl.b());
        this.c = lw1L;
        lw1L.d(c14339hl, abstractC15537jl);
    }

    public abstract void f(InterfaceC23337wl interfaceC23337wl);

    @Override // ir.nasim.O44
    public final void j(M44.a aVar) {
        AbstractC13042fc3.i(aVar, "builder");
        LW1 lw1 = this.c;
        if (lw1 != null) {
            lw1.j(aVar);
        }
    }

    protected abstract LW1 l(InterfaceC23783xW1 interfaceC23783xW1, EnumC8893Xt7 enumC8893Xt7);

    protected final InterfaceC11285cl m() {
        return this.b;
    }

    public final View p() {
        return this.a;
    }

    public void q(C14339hl c14339hl) {
        AbstractC13042fc3.i(c14339hl, "albumData");
        LW1 lw1 = this.c;
        if (lw1 != null) {
            lw1.o(c14339hl);
        }
    }

    public abstract void r();

    public abstract void s();
}
