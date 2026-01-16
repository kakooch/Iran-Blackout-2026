package ir.eitaa.SQLite;

import ir.eitaa.messenger.BuildVars;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.tgnet.NativeByteBuffer;

/* loaded from: classes.dex */
public class SQLiteCursor {
    public static final int FIELD_TYPE_BYTEARRAY = 4;
    public static final int FIELD_TYPE_FLOAT = 2;
    public static final int FIELD_TYPE_INT = 1;
    public static final int FIELD_TYPE_NULL = 5;
    public static final int FIELD_TYPE_STRING = 3;
    private boolean inRow = false;
    private SQLitePreparedStatement preparedStatement;

    native byte[] columnByteArrayValue(long statementHandle, int columnIndex);

    native long columnByteBufferValue(long statementHandle, int columnIndex);

    native int columnCount(long statementHandle);

    native double columnDoubleValue(long statementHandle, int columnIndex);

    native int columnIntValue(long statementHandle, int columnIndex);

    native int columnIsNull(long statementHandle, int columnIndex);

    native long columnLongValue(long statementHandle, int columnIndex);

    native String columnStringValue(long statementHandle, int columnIndex);

    native int columnType(long statementHandle, int columnIndex);

    public SQLiteCursor(SQLitePreparedStatement stmt) {
        this.preparedStatement = stmt;
    }

    public boolean isNull(int columnIndex) throws SQLiteException {
        checkRow();
        return columnIsNull(this.preparedStatement.getStatementHandle(), columnIndex) == 1;
    }

    public SQLitePreparedStatement getPreparedStatement() {
        return this.preparedStatement;
    }

    public int intValue(int columnIndex) throws SQLiteException {
        checkRow();
        return columnIntValue(this.preparedStatement.getStatementHandle(), columnIndex);
    }

    public double doubleValue(int columnIndex) throws SQLiteException {
        checkRow();
        return columnDoubleValue(this.preparedStatement.getStatementHandle(), columnIndex);
    }

    public long longValue(int columnIndex) throws SQLiteException {
        checkRow();
        return columnLongValue(this.preparedStatement.getStatementHandle(), columnIndex);
    }

    public String stringValue(int columnIndex) throws SQLiteException {
        checkRow();
        return columnStringValue(this.preparedStatement.getStatementHandle(), columnIndex);
    }

    public byte[] byteArrayValue(int columnIndex) throws SQLiteException {
        checkRow();
        return columnByteArrayValue(this.preparedStatement.getStatementHandle(), columnIndex);
    }

    public NativeByteBuffer byteBufferValue(int columnIndex) throws SQLiteException {
        checkRow();
        long jColumnByteBufferValue = columnByteBufferValue(this.preparedStatement.getStatementHandle(), columnIndex);
        if (jColumnByteBufferValue != 0) {
            return NativeByteBuffer.wrap(jColumnByteBufferValue);
        }
        return null;
    }

    public int getTypeOf(int columnIndex) throws SQLiteException {
        checkRow();
        return columnType(this.preparedStatement.getStatementHandle(), columnIndex);
    }

    public boolean next() throws SQLiteException {
        SQLitePreparedStatement sQLitePreparedStatement = this.preparedStatement;
        int iStep = sQLitePreparedStatement.step(sQLitePreparedStatement.getStatementHandle());
        if (iStep == -1) {
            int i = 6;
            while (true) {
                int i2 = i - 1;
                if (i == 0) {
                    break;
                }
                try {
                    if (BuildVars.LOGS_ENABLED) {
                        FileLog.d("sqlite busy, waiting...");
                    }
                    Thread.sleep(500L);
                    iStep = this.preparedStatement.step();
                } catch (Exception e) {
                    FileLog.e(e);
                }
                if (iStep == 0) {
                    break;
                }
                i = i2;
            }
            if (iStep == -1) {
                throw new SQLiteException("sqlite busy");
            }
        }
        boolean z = iStep == 0;
        this.inRow = z;
        return z;
    }

    public long getStatementHandle() {
        return this.preparedStatement.getStatementHandle();
    }

    public int getColumnCount() {
        return columnCount(this.preparedStatement.getStatementHandle());
    }

    public void dispose() {
        this.preparedStatement.dispose();
    }

    void checkRow() throws SQLiteException {
        if (!this.inRow) {
            throw new SQLiteException("You must call next before");
        }
    }
}
