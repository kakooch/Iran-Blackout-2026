package ir.nasim;

/* loaded from: classes5.dex */
public final class PF extends AbstractC9264Ze4 {
    public PF() {
        super(9, 10);
    }

    @Override // ir.nasim.AbstractC9264Ze4
    public void a(InterfaceC12694f27 interfaceC12694f27) {
        AbstractC13042fc3.i(interfaceC12694f27, "db");
        interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS `user_presences` (`peer_unique_id` INTEGER NOT NULL, `last_seen` INTEGER NOT NULL, `state` INTEGER NOT NULL, `unknown` INTEGER NOT NULL, PRIMARY KEY(`peer_unique_id`))");
        interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS `contacts` (`id` INTEGER NOT NULL, `name` TEXT NOT NULL COLLATE LOCALIZED, `isBot` INTEGER NOT NULL, `sortKey` INTEGER NOT NULL, `avatarJson` TEXT, PRIMARY KEY(`id`))");
    }
}
