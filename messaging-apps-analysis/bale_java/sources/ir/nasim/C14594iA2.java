package ir.nasim;

import android.database.sqlite.SQLiteStatement;

/* renamed from: ir.nasim.iA2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C14594iA2 extends C13996hA2 implements InterfaceC15121j27 {
    private final SQLiteStatement b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C14594iA2(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        AbstractC13042fc3.i(sQLiteStatement, "delegate");
        this.b = sQLiteStatement;
    }

    @Override // ir.nasim.InterfaceC15121j27
    public long M0() {
        return this.b.executeInsert();
    }

    @Override // ir.nasim.InterfaceC15121j27
    public int V() {
        return this.b.executeUpdateDelete();
    }
}
