package ir.nasim;

import ir.nasim.InterfaceC22259uv7;

/* renamed from: ir.nasim.pC4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C18762pC4 implements InterfaceC22259uv7 {
    private final InterfaceC4856Gv7 a;
    private final Y23 b;

    /* renamed from: ir.nasim.pC4$a */
    public static final class a implements InterfaceC22259uv7.a {
        @Override // ir.nasim.InterfaceC22259uv7.a
        public InterfaceC22259uv7 a(InterfaceC4856Gv7 interfaceC4856Gv7, Y23 y23) {
            return new C18762pC4(interfaceC4856Gv7, y23);
        }

        public boolean equals(Object obj) {
            return obj instanceof a;
        }

        public int hashCode() {
            return a.class.hashCode();
        }
    }

    public C18762pC4(InterfaceC4856Gv7 interfaceC4856Gv7, Y23 y23) {
        this.a = interfaceC4856Gv7;
        this.b = y23;
    }

    @Override // ir.nasim.InterfaceC22259uv7
    public void a() {
        Y23 y23 = this.b;
        if (y23 instanceof I07) {
            this.a.a(((I07) y23).a());
        } else if (y23 instanceof C12412ea2) {
            this.a.c(y23.a());
        }
    }
}
