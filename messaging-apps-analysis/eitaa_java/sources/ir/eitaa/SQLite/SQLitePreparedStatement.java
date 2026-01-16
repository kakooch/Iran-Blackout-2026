package ir.eitaa.SQLite;

import android.os.SystemClock;
import ir.eitaa.messenger.BuildVars;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.tgnet.NativeByteBuffer;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class SQLitePreparedStatement {
    private boolean isFinalized = false;
    private String query;
    private long sqliteStatementHandle;
    private long startTime;

    native void bindByteBuffer(long statementHandle, int index, ByteBuffer value, int length) throws SQLiteException;

    native void bindDouble(long statementHandle, int index, double value) throws SQLiteException;

    native void bindInt(long statementHandle, int index, int value) throws SQLiteException;

    native void bindLong(long statementHandle, int index, long value) throws SQLiteException;

    native void bindNull(long statementHandle, int index) throws SQLiteException;

    native void bindString(long statementHandle, int index, String value) throws SQLiteException;

    native void finalize(long statementHandle) throws SQLiteException;

    native long prepare(long sqliteHandle, String sql) throws SQLiteException;

    native void reset(long statementHandle) throws SQLiteException;

    native int step(long statementHandle) throws SQLiteException;

    public long getStatementHandle() {
        return this.sqliteStatementHandle;
    }

    public SQLitePreparedStatement(SQLiteDatabase db, String sql) throws SQLiteException {
        this.sqliteStatementHandle = prepare(db.getSQLiteHandle(), sql);
        if (BuildVars.LOGS_ENABLED) {
            this.query = sql;
            this.startTime = SystemClock.elapsedRealtime();
        }
    }

    public SQLiteCursor query(Object[] args) throws SQLiteException {
        if (args == null) {
            throw new IllegalArgumentException();
        }
        checkFinalized();
        reset(this.sqliteStatementHandle);
        int i = 1;
        for (Object obj : args) {
            if (obj == null) {
                bindNull(this.sqliteStatementHandle, i);
            } else if (obj instanceof Integer) {
                bindInt(this.sqliteStatementHandle, i, ((Integer) obj).intValue());
            } else if (obj instanceof Double) {
                bindDouble(this.sqliteStatementHandle, i, ((Double) obj).doubleValue());
            } else if (obj instanceof String) {
                bindString(this.sqliteStatementHandle, i, (String) obj);
            } else if (obj instanceof Long) {
                bindLong(this.sqliteStatementHandle, i, ((Long) obj).longValue());
            } else {
                throw new IllegalArgumentException();
            }
            i++;
        }
        return new SQLiteCursor(this);
    }

    public int step() throws SQLiteException {
        return step(this.sqliteStatementHandle);
    }

    public SQLitePreparedStatement stepThis() throws SQLiteException {
        step(this.sqliteStatementHandle);
        return this;
    }

    public void requery() throws SQLiteException {
        checkFinalized();
        reset(this.sqliteStatementHandle);
    }

    public void dispose() {
        finalizeQuery();
    }

    void checkFinalized() throws SQLiteException {
        if (this.isFinalized) {
            throw new SQLiteException("Prepared query finalized");
        }
    }

    public void finalizeQuery() throws IOException {
        if (this.isFinalized) {
            return;
        }
        if (BuildVars.LOGS_ENABLED) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.startTime;
            if (jElapsedRealtime > 500) {
                FileLog.d("sqlite query " + this.query + " took " + jElapsedRealtime + "ms");
            }
        }
        try {
            this.isFinalized = true;
            finalize(this.sqliteStatementHandle);
        } catch (SQLiteException e) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.e(e.getMessage(), e);
            }
        }
    }

    public void bindInteger(int index, int value) throws SQLiteException {
        bindInt(this.sqliteStatementHandle, index, value);
    }

    public void bindDouble(int index, double value) throws SQLiteException {
        bindDouble(this.sqliteStatementHandle, index, value);
    }

    public void bindByteBuffer(int index, ByteBuffer value) throws SQLiteException {
        bindByteBuffer(this.sqliteStatementHandle, index, value, value.limit());
    }

    public void bindByteBuffer(int index, NativeByteBuffer value) throws SQLiteException {
        bindByteBuffer(this.sqliteStatementHandle, index, value.buffer, value.limit());
    }

    public void bindString(int index, String value) throws SQLiteException {
        bindString(this.sqliteStatementHandle, index, value);
    }

    public void bindLong(int index, long value) throws SQLiteException {
        bindLong(this.sqliteStatementHandle, index, value);
    }

    public void bindNull(int index) throws SQLiteException {
        bindNull(this.sqliteStatementHandle, index);
    }
}
