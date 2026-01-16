package ir.nasim;

/* loaded from: classes5.dex */
public final class HF extends AbstractC9264Ze4 {
    public HF() {
        super(13, 14);
    }

    @Override // ir.nasim.AbstractC9264Ze4
    public void a(InterfaceC12694f27 interfaceC12694f27) {
        AbstractC13042fc3.i(interfaceC12694f27, "db");
        interfaceC12694f27.O("ALTER TABLE `service_items` ADD COLUMN `min_app_version` INTEGER NOT NULL DEFAULT 0");
        interfaceC12694f27.O("ALTER TABLE `service_items` ADD COLUMN `max_app_version` INTEGER NOT NULL DEFAULT 999999");
        interfaceC12694f27.O("ALTER TABLE `service_items` ADD COLUMN `menu_items` TEXT DEFAULT NULL");
    }
}
