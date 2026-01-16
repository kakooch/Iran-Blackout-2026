package ir.nasim;

/* loaded from: classes5.dex */
public final class KF extends AbstractC9264Ze4 {
    public KF() {
        super(16, 17);
    }

    @Override // ir.nasim.AbstractC9264Ze4
    public void a(InterfaceC12694f27 interfaceC12694f27) {
        AbstractC13042fc3.i(interfaceC12694f27, "db");
        interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS `live_streams` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `peer_unique_id` INTEGER NOT NULL, `message_rid` INTEGER NOT NULL, `message_date` INTEGER NOT NULL, `live_key` INTEGER NOT NULL, `link` TEXT NOT NULL, `user_count` INTEGER NOT NULL)");
    }
}
