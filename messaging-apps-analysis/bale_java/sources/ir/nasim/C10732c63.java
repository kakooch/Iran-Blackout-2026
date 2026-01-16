package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.c63, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C10732c63 extends B0 {
    private final C10116b63 a = new C10116b63();
    private final List b = new ArrayList();

    /* renamed from: ir.nasim.c63$a */
    public static class a extends C0 {
        @Override // ir.nasim.InterfaceC16089kh0
        public AbstractC17271mh0 a(NW4 nw4, PU3 pu3) {
            return (nw4.a() < OW4.a || nw4.c() || (nw4.f().f() instanceof C9761aW4)) ? AbstractC17271mh0.b() : AbstractC17271mh0.c(new C10732c63()).a(nw4.b() + OW4.a);
        }
    }

    @Override // ir.nasim.InterfaceC15498jh0
    public AbstractC11868dh0 d(NW4 nw4) {
        return nw4.a() >= OW4.a ? AbstractC11868dh0.a(nw4.b() + OW4.a) : nw4.c() ? AbstractC11868dh0.b(nw4.e()) : AbstractC11868dh0.c();
    }

    @Override // ir.nasim.InterfaceC15498jh0
    public AbstractC10483bh0 f() {
        return this.a;
    }

    @Override // ir.nasim.B0, ir.nasim.InterfaceC15498jh0
    public void g(CharSequence charSequence) {
        this.b.add(charSequence);
    }

    @Override // ir.nasim.B0, ir.nasim.InterfaceC15498jh0
    public void h() {
        int size = this.b.size() - 1;
        while (size >= 0 && OW4.e((CharSequence) this.b.get(size))) {
            size--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size + 1; i++) {
            sb.append((CharSequence) this.b.get(i));
            sb.append('\n');
        }
        this.a.n(sb.toString());
    }
}
