package ir.nasim.tgwidgets.editor.SQLite;

import ir.nasim.AbstractC6403Nl2;
import ir.nasim.AbstractC8814Xl0;
import ir.nasim.tgwidgets.editor.tgnet.NativeByteBuffer;

/* loaded from: classes7.dex */
public class SQLiteCursor {
    private SQLitePreparedStatement a;
    private boolean b = false;

    public SQLiteCursor(SQLitePreparedStatement sQLitePreparedStatement) {
        this.a = sQLitePreparedStatement;
    }

    public byte[] a(int i) throws SQLiteException {
        c();
        return columnByteArrayValue(this.a.g(), i);
    }

    public NativeByteBuffer b(int i) {
        c();
        long jColumnByteBufferValue = columnByteBufferValue(this.a.g(), i);
        if (jColumnByteBufferValue != 0) {
            return NativeByteBuffer.u(jColumnByteBufferValue);
        }
        return null;
    }

    void c() throws SQLiteException {
        if (!this.b) {
            throw new SQLiteException("You must call next before");
        }
    }

    native byte[] columnByteArrayValue(long j, int i);

    native long columnByteBufferValue(long j, int i);

    native int columnCount(long j);

    native double columnDoubleValue(long j, int i);

    native int columnIntValue(long j, int i);

    native int columnIsNull(long j, int i);

    native long columnLongValue(long j, int i);

    native String columnStringValue(long j, int i);

    native int columnType(long j, int i);

    public void d() {
        this.a.e();
    }

    public int e(int i) {
        c();
        return columnIntValue(this.a.g(), i);
    }

    public boolean f(int i) throws SQLiteException {
        c();
        return columnIsNull(this.a.g(), i) == 1;
    }

    public long g(int i) {
        c();
        return columnLongValue(this.a.g(), i);
    }

    public boolean h() throws InterruptedException, SQLiteException {
        SQLitePreparedStatement sQLitePreparedStatement = this.a;
        int iStep = sQLitePreparedStatement.step(sQLitePreparedStatement.g());
        if (iStep == -1) {
            int i = 6;
            while (true) {
                int i2 = i - 1;
                if (i == 0) {
                    break;
                }
                try {
                    if (AbstractC8814Xl0.b) {
                        AbstractC6403Nl2.a("sqlite busy, waiting...");
                    }
                    Thread.sleep(500L);
                    iStep = this.a.j();
                } catch (Exception e) {
                    AbstractC6403Nl2.d(e);
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
        this.b = z;
        return z;
    }

    public String i(int i) throws SQLiteException {
        c();
        return columnStringValue(this.a.g(), i);
    }
}
