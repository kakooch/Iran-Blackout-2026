package ir.nasim;

/* loaded from: classes5.dex */
public final class OF extends AbstractC9264Ze4 {
    public OF() {
        super(8, 9);
    }

    @Override // ir.nasim.AbstractC9264Ze4
    public void a(InterfaceC12694f27 interfaceC12694f27) {
        AbstractC13042fc3.i(interfaceC12694f27, "db");
        interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS `service_items` (`id` INTEGER NOT NULL, `title` TEXT NOT NULL, `icon` TEXT NOT NULL, `badge` TEXT, `action` INTEGER NOT NULL, `peer_id` INTEGER, `peer_type` INTEGER, `url` TEXT, `event_key` TEXT, `event_name` TEXT, `section_id` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS `service_sections` (`id` INTEGER NOT NULL, `title` TEXT NOT NULL, `badge` TEXT, `badge_type` INTEGER NOT NULL, PRIMARY KEY(`id`))");
    }
}
