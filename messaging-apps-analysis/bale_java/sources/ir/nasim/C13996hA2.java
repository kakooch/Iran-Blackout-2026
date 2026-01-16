package ir.nasim;

import android.database.sqlite.SQLiteProgram;

/* renamed from: ir.nasim.hA2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C13996hA2 implements InterfaceC13921h27 {
    private final SQLiteProgram a;

    public C13996hA2(SQLiteProgram sQLiteProgram) {
        AbstractC13042fc3.i(sQLiteProgram, "delegate");
        this.a = sQLiteProgram;
    }

    @Override // ir.nasim.InterfaceC13921h27
    public void U0(int i, String str) {
        AbstractC13042fc3.i(str, "value");
        this.a.bindString(i, str);
    }

    @Override // ir.nasim.InterfaceC13921h27
    public void Y(int i, double d) {
        this.a.bindDouble(i, d);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.a.close();
    }

    @Override // ir.nasim.InterfaceC13921h27
    public void k1(int i, long j) {
        this.a.bindLong(i, j);
    }

    @Override // ir.nasim.InterfaceC13921h27
    public void n1(int i, byte[] bArr) {
        AbstractC13042fc3.i(bArr, "value");
        this.a.bindBlob(i, bArr);
    }

    @Override // ir.nasim.InterfaceC13921h27
    public void y1(int i) {
        this.a.bindNull(i);
    }
}
