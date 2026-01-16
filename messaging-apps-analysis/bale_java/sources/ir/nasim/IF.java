package ir.nasim;

/* loaded from: classes5.dex */
public final class IF extends AbstractC9264Ze4 {
    public IF() {
        super(14, 15);
    }

    @Override // ir.nasim.AbstractC9264Ze4
    public void a(InterfaceC12694f27 interfaceC12694f27) {
        AbstractC13042fc3.i(interfaceC12694f27, "db");
        interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS `story_widget` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `story_id` TEXT NOT NULL, `trait_case` TEXT NOT NULL, `widget_data` TEXT NOT NULL, `expiration_date` INTEGER NOT NULL, `coordinates` TEXT)");
    }
}
