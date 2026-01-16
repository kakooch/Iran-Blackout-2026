package ir.nasim;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* loaded from: classes2.dex */
public final class HD1 implements InterfaceC13995hA1 {
    private final SQLiteOpenHelper a;

    public HD1(SQLiteOpenHelper sQLiteOpenHelper) {
        this.a = sQLiteOpenHelper;
    }

    @Override // ir.nasim.InterfaceC13995hA1
    public SQLiteDatabase E() {
        return this.a.getWritableDatabase();
    }

    @Override // ir.nasim.InterfaceC13995hA1
    public SQLiteDatabase F() {
        return this.a.getReadableDatabase();
    }
}
