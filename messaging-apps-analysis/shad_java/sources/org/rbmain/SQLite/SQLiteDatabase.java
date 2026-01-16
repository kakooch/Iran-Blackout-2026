package org.rbmain.SQLite;

import com.google.firebase.crashlytics.FirebaseCrashlytics;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.BuildVars;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.NativeLoader;

/* loaded from: classes4.dex */
public class SQLiteDatabase {
    private boolean inTransaction;
    private boolean isOpen;
    private final long sqliteHandle;

    native void beginTransaction(long j);

    native void closedb(long j) throws SQLiteException;

    native void commitTransaction(long j);

    native long opendb(String str, String str2) throws SQLiteException;

    public long getSQLiteHandle() {
        return this.sqliteHandle;
    }

    public SQLiteDatabase(String str) throws SQLiteException {
        String path = ApplicationLoader.getFilesDirFixed().getPath();
        FirebaseCrashlytics.getInstance().setCustomKey("SQLiteDatabase", "nativeLoaded " + NativeLoader.nativeLoaded + "\t" + path);
        this.sqliteHandle = opendb(str, path);
        this.isOpen = true;
    }

    public boolean tableExists(String str) throws SQLiteException {
        checkOpened();
        return executeInt("SELECT rowid FROM sqlite_master WHERE type='table' AND name=?;", str) != null;
    }

    public SQLitePreparedStatement executeFast(String str) throws SQLiteException {
        return new SQLitePreparedStatement(this, str);
    }

    public Integer executeInt(String str, Object... objArr) throws SQLiteException {
        checkOpened();
        SQLiteCursor sQLiteCursorQueryFinalized = queryFinalized(str, objArr);
        try {
            if (sQLiteCursorQueryFinalized.next()) {
                return Integer.valueOf(sQLiteCursorQueryFinalized.intValue(0));
            }
            return null;
        } finally {
            sQLiteCursorQueryFinalized.dispose();
        }
    }

    public void explainQuery(String str, Object... objArr) throws SQLiteException {
        checkOpened();
        SQLiteCursor sQLiteCursorQuery = new SQLitePreparedStatement(this, "EXPLAIN QUERY PLAN " + str).query(objArr);
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

    public SQLiteCursor queryFinalized(String str, Object... objArr) throws SQLiteException {
        checkOpened();
        return new SQLitePreparedStatement(this, str).query(objArr);
    }

    public void close() {
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
