package ir.nasim;

/* loaded from: classes5.dex */
public final class JF extends AbstractC9264Ze4 {
    public JF() {
        super(15, 16);
    }

    @Override // ir.nasim.AbstractC9264Ze4
    public void a(InterfaceC12694f27 interfaceC12694f27) {
        AbstractC13042fc3.i(interfaceC12694f27, "db");
        interfaceC12694f27.O("CREATE TABLE IF NOT EXISTS `download_state` (`file_id` INTEGER NOT NULL, `access_hash` INTEGER NOT NULL, `file_name` TEXT NOT NULL, `file_size` INTEGER NOT NULL, `file_path` TEXT NOT NULL, `file_state` TEXT NOT NULL, PRIMARY KEY(`file_id`, `access_hash`))");
    }
}
