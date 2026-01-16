package ir.nasim;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.CancellationSignal;
import java.io.File;

/* renamed from: ir.nasim.a27, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C9486a27 {
    public static final C9486a27 a = new C9486a27();

    private C9486a27() {
    }

    public static final void a(CancellationSignal cancellationSignal) {
        AbstractC13042fc3.i(cancellationSignal, "cancellationSignal");
        cancellationSignal.cancel();
    }

    public static final CancellationSignal b() {
        return new CancellationSignal();
    }

    public static final boolean c(File file) {
        AbstractC13042fc3.i(file, "file");
        return SQLiteDatabase.deleteDatabase(file);
    }

    public static final boolean d(SQLiteDatabase sQLiteDatabase) {
        AbstractC13042fc3.i(sQLiteDatabase, "sQLiteDatabase");
        return sQLiteDatabase.isWriteAheadLoggingEnabled();
    }

    public static final Cursor e(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String str2, CancellationSignal cancellationSignal, SQLiteDatabase.CursorFactory cursorFactory) {
        AbstractC13042fc3.i(sQLiteDatabase, "sQLiteDatabase");
        AbstractC13042fc3.i(str, "sql");
        AbstractC13042fc3.i(strArr, "selectionArgs");
        AbstractC13042fc3.i(cancellationSignal, "cancellationSignal");
        AbstractC13042fc3.i(cursorFactory, "cursorFactory");
        Cursor cursorRawQueryWithFactory = sQLiteDatabase.rawQueryWithFactory(cursorFactory, str, strArr, str2, cancellationSignal);
        AbstractC13042fc3.h(cursorRawQueryWithFactory, "sQLiteDatabase.rawQueryW…ationSignal\n            )");
        return cursorRawQueryWithFactory;
    }

    public static final void f(SQLiteOpenHelper sQLiteOpenHelper, boolean z) {
        AbstractC13042fc3.i(sQLiteOpenHelper, "sQLiteOpenHelper");
        sQLiteOpenHelper.setWriteAheadLoggingEnabled(z);
    }
}
