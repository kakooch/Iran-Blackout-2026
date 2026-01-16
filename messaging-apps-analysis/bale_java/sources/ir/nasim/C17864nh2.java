package ir.nasim;

/* renamed from: ir.nasim.nh2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C17864nh2 extends AbstractC9264Ze4 {
    public C17864nh2() {
        super(5, 6);
    }

    @Override // ir.nasim.AbstractC9264Ze4
    public void a(InterfaceC12694f27 interfaceC12694f27) {
        AbstractC13042fc3.i(interfaceC12694f27, "db");
        interfaceC12694f27.O("ALTER TABLE `feed` ADD COLUMN `comment_count` INTEGER DEFAULT NULL");
    }
}
