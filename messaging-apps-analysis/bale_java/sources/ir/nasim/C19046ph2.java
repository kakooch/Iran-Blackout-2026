package ir.nasim;

/* renamed from: ir.nasim.ph2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C19046ph2 extends AbstractC9264Ze4 {
    public C19046ph2() {
        super(7, 8);
    }

    @Override // ir.nasim.AbstractC9264Ze4
    public void a(InterfaceC12694f27 interfaceC12694f27) {
        AbstractC13042fc3.i(interfaceC12694f27, "db");
        interfaceC12694f27.O("ALTER TABLE `feed` ADD COLUMN `file_id` INTEGER NOT NULL DEFAULT 0");
    }
}
