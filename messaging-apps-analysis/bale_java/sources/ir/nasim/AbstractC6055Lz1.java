package ir.nasim;

/* renamed from: ir.nasim.Lz1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC6055Lz1 {
    private static final AbstractC9264Ze4 a = new a();
    private static final AbstractC9264Ze4 b = new b();

    /* renamed from: ir.nasim.Lz1$a */
    public static final class a extends AbstractC9264Ze4 {
        a() {
            super(1, 2);
        }

        @Override // ir.nasim.AbstractC9264Ze4
        public void a(InterfaceC12694f27 interfaceC12694f27) {
            AbstractC13042fc3.i(interfaceC12694f27, "database");
            interfaceC12694f27.O("ALTER TABLE feed ADD COLUMN tag TEXT");
        }
    }

    /* renamed from: ir.nasim.Lz1$b */
    public static final class b extends AbstractC9264Ze4 {
        b() {
            super(2, 1);
        }

        @Override // ir.nasim.AbstractC9264Ze4
        public void a(InterfaceC12694f27 interfaceC12694f27) {
            AbstractC13042fc3.i(interfaceC12694f27, "database");
            interfaceC12694f27.O("ALTER TABLE feed DROP COLUMN tag");
        }
    }

    public static final AbstractC9264Ze4 a() {
        return a;
    }

    public static final AbstractC9264Ze4 b() {
        return b;
    }
}
