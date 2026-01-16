package ir.nasim;

/* renamed from: ir.nasim.kh2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C16091kh2 extends AbstractC9264Ze4 {
    public C16091kh2() {
        super(2, 3);
    }

    @Override // ir.nasim.AbstractC9264Ze4
    public void a(InterfaceC12694f27 interfaceC12694f27) {
        AbstractC13042fc3.i(interfaceC12694f27, "db");
        interfaceC12694f27.O("ALTER TABLE `feed` ADD COLUMN `category` TEXT NOT NULL DEFAULT ''");
    }
}
