package ir.nasim;

/* renamed from: ir.nasim.oh2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C18455oh2 extends AbstractC9264Ze4 {
    public C18455oh2() {
        super(6, 7);
    }

    @Override // ir.nasim.AbstractC9264Ze4
    public void a(InterfaceC12694f27 interfaceC12694f27) {
        AbstractC13042fc3.i(interfaceC12694f27, "db");
        interfaceC12694f27.O("ALTER TABLE `feed` ADD COLUMN `category_id` INTEGER NOT NULL DEFAULT 0");
    }
}
