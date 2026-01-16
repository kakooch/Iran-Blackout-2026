package ir.nasim;

/* loaded from: classes5.dex */
public final class FF extends AbstractC9264Ze4 {
    private final JS c;

    public FF() {
        super(11, 12);
        this.c = new C19395qH1();
    }

    @Override // ir.nasim.AbstractC9264Ze4
    public void a(InterfaceC12694f27 interfaceC12694f27) {
        AbstractC13042fc3.i(interfaceC12694f27, "db");
        interfaceC12694f27.O("ALTER TABLE `contacts` ADD COLUMN `avatarByte` BLOB DEFAULT NULL");
        interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS `_new_contacts` (`id` INTEGER NOT NULL, `name` TEXT NOT NULL COLLATE LOCALIZED, `isBot` INTEGER NOT NULL, `sortKey` INTEGER NOT NULL, `avatarByte` BLOB, PRIMARY KEY(`id`))");
        interfaceC12694f27.O("INSERT INTO `_new_contacts` (`id`,`name`,`isBot`,`sortKey`) SELECT `id`,`name`,`isBot`,`sortKey` FROM `contacts`");
        interfaceC12694f27.O("DROP TABLE `contacts`");
        interfaceC12694f27.O("ALTER TABLE `_new_contacts` RENAME TO `contacts`");
        this.c.a(interfaceC12694f27);
    }
}
