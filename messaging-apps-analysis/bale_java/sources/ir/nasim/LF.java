package ir.nasim;

/* loaded from: classes5.dex */
public final class LF extends AbstractC9264Ze4 {
    public LF() {
        super(18, 19);
    }

    @Override // ir.nasim.AbstractC9264Ze4
    public void a(InterfaceC12694f27 interfaceC12694f27) {
        AbstractC13042fc3.i(interfaceC12694f27, "db");
        interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS `pin_message` (`peer_unique_id` INTEGER NOT NULL, `ex_peer_type` INTEGER NOT NULL, `message_rid` INTEGER NOT NULL, `message_date` INTEGER NOT NULL, `message_edited_at` INTEGER NOT NULL, PRIMARY KEY(`peer_unique_id`, `ex_peer_type`, `message_rid`, `message_date`))");
        interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS `top-peer` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `peerId` INTEGER NOT NULL, `score` INTEGER NOT NULL)");
    }
}
