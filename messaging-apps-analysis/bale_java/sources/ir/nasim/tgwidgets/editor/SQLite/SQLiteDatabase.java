package ir.nasim.tgwidgets.editor.SQLite;

import ir.nasim.AbstractC14047hG;
import ir.nasim.AbstractC6403Nl2;
import ir.nasim.AbstractC8814Xl0;

/* loaded from: classes7.dex */
public class SQLiteDatabase {
    private final long a;
    private boolean b = true;
    private boolean c;

    public SQLiteDatabase(String str) {
        this.a = opendb(str, AbstractC14047hG.b().getPath());
    }

    void a() throws SQLiteException {
        if (!this.b) {
            throw new SQLiteException("Database closed");
        }
    }

    public void b() {
        if (this.b) {
            try {
                c();
                closedb(this.a);
            } catch (SQLiteException e) {
                if (AbstractC8814Xl0.b) {
                    AbstractC6403Nl2.c(e.getMessage(), e);
                }
            }
            this.b = false;
        }
    }

    native void beginTransaction(long j);

    public void c() {
        if (this.c) {
            this.c = false;
            commitTransaction(this.a);
        }
    }

    native void closedb(long j);

    native void commitTransaction(long j);

    public SQLitePreparedStatement d(String str) {
        return new SQLitePreparedStatement(this, str);
    }

    public Integer e(String str, Object... objArr) throws SQLiteException {
        a();
        SQLiteCursor sQLiteCursorG = g(str, objArr);
        try {
            if (sQLiteCursorG.h()) {
                return Integer.valueOf(sQLiteCursorG.e(0));
            }
            sQLiteCursorG.d();
            return null;
        } finally {
            sQLiteCursorG.d();
        }
    }

    public long f() {
        return this.a;
    }

    public void finalize() throws Throwable {
        super.finalize();
        b();
    }

    public SQLiteCursor g(String str, Object... objArr) {
        a();
        return new SQLitePreparedStatement(this, str).h(objArr);
    }

    native long opendb(String str, String str2);
}
