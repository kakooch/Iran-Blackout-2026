package ir.nasim.tgwidgets.editor.SQLite;

import android.os.SystemClock;
import ir.nasim.AbstractC6403Nl2;
import ir.nasim.AbstractC8814Xl0;
import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public class SQLitePreparedStatement {
    private boolean a = false;
    private long b;
    private long c;
    private String d;

    public SQLitePreparedStatement(SQLiteDatabase sQLiteDatabase, String str) {
        this.b = prepare(sQLiteDatabase.f(), str);
        if (AbstractC8814Xl0.b) {
            this.d = str;
            this.c = SystemClock.elapsedRealtime();
        }
    }

    public void a(int i, int i2) {
        bindInt(this.b, i, i2);
    }

    public void b(int i, long j) {
        bindLong(this.b, i, j);
    }

    native void bindByteBuffer(long j, int i, ByteBuffer byteBuffer, int i2);

    native void bindDouble(long j, int i, double d);

    native void bindInt(long j, int i, int i2);

    native void bindLong(long j, int i, long j2);

    native void bindNull(long j, int i);

    native void bindString(long j, int i, String str);

    public void c(int i, String str) {
        bindString(this.b, i, str);
    }

    void d() throws SQLiteException {
        if (this.a) {
            throw new SQLiteException("Prepared query finalized");
        }
    }

    public void e() {
        f();
    }

    public void f() {
        if (this.a) {
            return;
        }
        if (AbstractC8814Xl0.b) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.c;
            if (jElapsedRealtime > 500) {
                AbstractC6403Nl2.a("sqlite query " + this.d + " took " + jElapsedRealtime + "ms");
            }
        }
        try {
            this.a = true;
            finalize(this.b);
        } catch (SQLiteException e) {
            if (AbstractC8814Xl0.b) {
                AbstractC6403Nl2.c(e.getMessage(), e);
            }
        }
    }

    native void finalize(long j);

    public long g() {
        return this.b;
    }

    public SQLiteCursor h(Object[] objArr) throws SQLiteException {
        if (objArr == null) {
            throw new IllegalArgumentException();
        }
        d();
        reset(this.b);
        int i = 1;
        for (Object obj : objArr) {
            if (obj == null) {
                bindNull(this.b, i);
            } else if (obj instanceof Integer) {
                bindInt(this.b, i, ((Integer) obj).intValue());
            } else if (obj instanceof Double) {
                bindDouble(this.b, i, ((Double) obj).doubleValue());
            } else if (obj instanceof String) {
                bindString(this.b, i, (String) obj);
            } else {
                if (!(obj instanceof Long)) {
                    throw new IllegalArgumentException();
                }
                bindLong(this.b, i, ((Long) obj).longValue());
            }
            i++;
        }
        return new SQLiteCursor(this);
    }

    public void i() {
        d();
        reset(this.b);
    }

    public int j() {
        return step(this.b);
    }

    public SQLitePreparedStatement k() {
        step(this.b);
        return this;
    }

    native long prepare(long j, String str);

    native void reset(long j);

    native int step(long j);
}
