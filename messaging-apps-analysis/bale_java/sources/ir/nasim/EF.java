package ir.nasim;

/* loaded from: classes5.dex */
public final class EF extends AbstractC9264Ze4 {
    public EF() {
        super(10, 11);
    }

    @Override // ir.nasim.AbstractC9264Ze4
    public void a(InterfaceC12694f27 interfaceC12694f27) {
        AbstractC13042fc3.i(interfaceC12694f27, "db");
        interfaceC12694f27.O("ALTER TABLE `service_items` ADD COLUMN `custom_icon` TEXT DEFAULT NULL");
    }
}
