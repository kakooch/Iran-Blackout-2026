package ir.nasim;

/* loaded from: classes5.dex */
public final class MF extends AbstractC9264Ze4 {
    public MF() {
        super(19, 20);
    }

    @Override // ir.nasim.AbstractC9264Ze4
    public void a(InterfaceC12694f27 interfaceC12694f27) {
        AbstractC13042fc3.i(interfaceC12694f27, "db");
        interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS `peer_click` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `peerId` INTEGER NOT NULL, `clickCounts` INTEGER NOT NULL)");
    }
}
