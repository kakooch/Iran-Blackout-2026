package ir.nasim;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.Yo3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC9119Yo3 {
    protected final SQLiteDatabase a;
    protected final String b;
    protected final String c;
    private boolean d = false;
    protected InterfaceC17311ml0 e;
    protected InterfaceC15345jQ7 f;

    public AbstractC9119Yo3(SQLiteDatabase sQLiteDatabase, String str, String str2, InterfaceC17311ml0 interfaceC17311ml0, InterfaceC15345jQ7 interfaceC15345jQ7) {
        this.a = sQLiteDatabase;
        this.b = str;
        this.c = str2;
        this.e = interfaceC17311ml0;
        this.f = interfaceC15345jQ7;
    }

    public void a(List list) throws SQLException {
        b();
    }

    protected void b() throws SQLException {
        if (this.d) {
            return;
        }
        if (!AbstractC22384v86.a(this.a, this.b)) {
            this.a.execSQL(this.c);
        }
        this.d = true;
    }

    public void c() throws SQLException {
        b();
        this.a.beginTransactionNonExclusive();
        try {
            this.a.execSQL("DELETE FROM \"" + this.b + Separators.DOUBLE_QUOTE);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    public void d() throws SQLException {
        b();
        this.a.beginTransactionNonExclusive();
        try {
            this.a.execSQL("DROP TABLE IF EXISTS \"" + this.b + Separators.DOUBLE_QUOTE);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    public List e() throws SQLException {
        b();
        return null;
    }

    public AbstractC17902nl0 f(long j) throws SQLException {
        b();
        return null;
    }

    public List g(long[] jArr) throws SQLException {
        b();
        return null;
    }

    public void h(long j) throws SQLException {
        b();
    }
}
