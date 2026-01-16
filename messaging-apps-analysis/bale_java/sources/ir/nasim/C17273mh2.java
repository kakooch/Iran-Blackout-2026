package ir.nasim;

/* renamed from: ir.nasim.mh2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C17273mh2 extends AbstractC9264Ze4 {
    public C17273mh2() {
        super(4, 5);
    }

    @Override // ir.nasim.AbstractC9264Ze4
    public void a(InterfaceC12694f27 interfaceC12694f27) {
        AbstractC13042fc3.i(interfaceC12694f27, "db");
        interfaceC12694f27.O("ALTER TABLE `feed` ADD COLUMN `grouped_id` INTEGER DEFAULT NULL");
    }
}
