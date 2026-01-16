package ir.nasim;

/* loaded from: classes5.dex */
public final class NF extends AbstractC9264Ze4 {
    public NF() {
        super(20, 21);
    }

    @Override // ir.nasim.AbstractC9264Ze4
    public void a(InterfaceC12694f27 interfaceC12694f27) {
        AbstractC13042fc3.i(interfaceC12694f27, "db");
        interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS `premium_badges` (`badgeId` INTEGER NOT NULL, `url` TEXT NOT NULL, `mediaFormat` INTEGER NOT NULL, `downloadedContent` BLOB, PRIMARY KEY(`badgeId`, `url`))");
    }
}
