package ir.eitaa.SQLite;

import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.BuildVars;
import ir.eitaa.messenger.FileLog;
import java.io.IOException;

/* loaded from: classes.dex */
public class SQLiteDatabase {
    private boolean inTransaction;
    private boolean isOpen = true;
    private final long sqliteHandle;

    native void beginTransaction(long sqliteHandle);

    native void closedb(long sqliteHandle) throws SQLiteException;

    native void commitTransaction(long sqliteHandle);

    native long opendb(String fileName, String tempDir) throws SQLiteException;

    public long getSQLiteHandle() {
        return this.sqliteHandle;
    }

    public SQLiteDatabase(String fileName) throws SQLiteException {
        this.sqliteHandle = opendb(fileName, ApplicationLoader.getFilesDirFixed().getPath());
    }

    public boolean tableExists(String tableName) throws SQLiteException {
        checkOpened();
        return executeInt("SELECT rowid FROM sqlite_master WHERE type='table' AND name=?;", tableName) != null;
    }

    public SQLitePreparedStatement executeFast(String sql) throws SQLiteException {
        return new SQLitePreparedStatement(this, sql);
    }

    public Integer executeInt(String sql, Object... args) throws SQLiteException {
        checkOpened();
        SQLiteCursor sQLiteCursorQueryFinalized = queryFinalized(sql, args);
        try {
            if (sQLiteCursorQueryFinalized.next()) {
                return Integer.valueOf(sQLiteCursorQueryFinalized.intValue(0));
            }
            return null;
        } finally {
            sQLiteCursorQueryFinalized.dispose();
        }
    }

    public void explainQuery(String sql, Object... args) throws SQLiteException {
        checkOpened();
        SQLiteCursor sQLiteCursorQuery = new SQLitePreparedStatement(this, "EXPLAIN QUERY PLAN " + sql).query(args);
        while (sQLiteCursorQuery.next()) {
            int columnCount = sQLiteCursorQuery.getColumnCount();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < columnCount; i++) {
                sb.append(sQLiteCursorQuery.stringValue(i));
                sb.append(", ");
            }
            FileLog.d("EXPLAIN QUERY PLAN " + sb.toString());
        }
        sQLiteCursorQuery.dispose();
    }

    public SQLiteCursor queryFinalized(String sql, Object... args) throws SQLiteException {
        checkOpened();
        return new SQLitePreparedStatement(this, sql).query(args);
    }

    public void close() throws IOException {
        if (this.isOpen) {
            try {
                commitTransaction();
                closedb(this.sqliteHandle);
            } catch (SQLiteException e) {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.e(e.getMessage(), e);
                }
            }
            this.isOpen = false;
        }
    }

    void checkOpened() throws SQLiteException {
        if (!this.isOpen) {
            throw new SQLiteException("Database closed");
        }
    }

    public void finalize() throws Throwable {
        super.finalize();
        close();
    }

    public void beginTransaction() throws SQLiteException {
        if (this.inTransaction) {
            throw new SQLiteException("database already in transaction");
        }
        this.inTransaction = true;
        beginTransaction(this.sqliteHandle);
    }

    public void commitTransaction() {
        if (this.inTransaction) {
            this.inTransaction = false;
            commitTransaction(this.sqliteHandle);
        }
    }
}
