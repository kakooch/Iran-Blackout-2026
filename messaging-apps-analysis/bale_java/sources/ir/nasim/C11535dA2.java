package ir.nasim;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteStatement;
import android.os.CancellationSignal;
import java.util.List;

/* renamed from: ir.nasim.dA2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C11535dA2 implements InterfaceC12694f27 {
    public static final a b = new a(null);
    private static final String[] c = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
    private static final String[] d = new String[0];
    private final SQLiteDatabase a;

    /* renamed from: ir.nasim.dA2$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.dA2$b */
    static final class b extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
        final /* synthetic */ InterfaceC14514i27 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC14514i27 interfaceC14514i27) {
            super(4);
            this.e = interfaceC14514i27;
        }

        @Override // ir.nasim.InterfaceC16978mB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final SQLiteCursor e(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            InterfaceC14514i27 interfaceC14514i27 = this.e;
            AbstractC13042fc3.f(sQLiteQuery);
            interfaceC14514i27.b(new C13996hA2(sQLiteQuery));
            return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
        }
    }

    public C11535dA2(SQLiteDatabase sQLiteDatabase) {
        AbstractC13042fc3.i(sQLiteDatabase, "delegate");
        this.a = sQLiteDatabase;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Cursor d(InterfaceC16978mB2 interfaceC16978mB2, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        AbstractC13042fc3.i(interfaceC16978mB2, "$tmp0");
        return (Cursor) interfaceC16978mB2.e(sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Cursor e(InterfaceC14514i27 interfaceC14514i27, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        AbstractC13042fc3.i(interfaceC14514i27, "$query");
        AbstractC13042fc3.f(sQLiteQuery);
        interfaceC14514i27.b(new C13996hA2(sQLiteQuery));
        return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
    }

    @Override // ir.nasim.InterfaceC12694f27
    public String A() {
        return this.a.getPath();
    }

    @Override // ir.nasim.InterfaceC12694f27
    public boolean D1() {
        return this.a.inTransaction();
    }

    @Override // ir.nasim.InterfaceC12694f27
    public void I() {
        this.a.beginTransaction();
    }

    @Override // ir.nasim.InterfaceC12694f27
    public List N() {
        return this.a.getAttachedDbs();
    }

    @Override // ir.nasim.InterfaceC12694f27
    public boolean N1() {
        return C9486a27.d(this.a);
    }

    @Override // ir.nasim.InterfaceC12694f27
    public void O(String str) throws SQLException {
        AbstractC13042fc3.i(str, "sql");
        this.a.execSQL(str);
    }

    @Override // ir.nasim.InterfaceC12694f27
    public Cursor P1(InterfaceC14514i27 interfaceC14514i27) {
        AbstractC13042fc3.i(interfaceC14514i27, "query");
        final b bVar = new b(interfaceC14514i27);
        Cursor cursorRawQueryWithFactory = this.a.rawQueryWithFactory(new SQLiteDatabase.CursorFactory() { // from class: ir.nasim.cA2
            @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
            public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                return C11535dA2.d(bVar, sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
            }
        }, interfaceC14514i27.a(), d, null);
        AbstractC13042fc3.h(cursorRawQueryWithFactory, "delegate.rawQueryWithFac…EMPTY_STRING_ARRAY, null)");
        return cursorRawQueryWithFactory;
    }

    @Override // ir.nasim.InterfaceC12694f27
    public InterfaceC15121j27 Z0(String str) throws SQLException {
        AbstractC13042fc3.i(str, "sql");
        SQLiteStatement sQLiteStatementCompileStatement = this.a.compileStatement(str);
        AbstractC13042fc3.h(sQLiteStatementCompileStatement, "delegate.compileStatement(sql)");
        return new C14594iA2(sQLiteStatementCompileStatement);
    }

    public final boolean c(SQLiteDatabase sQLiteDatabase) {
        AbstractC13042fc3.i(sQLiteDatabase, "sqLiteDatabase");
        return AbstractC13042fc3.d(this.a, sQLiteDatabase);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.a.close();
    }

    @Override // ir.nasim.InterfaceC12694f27
    public void h0() {
        this.a.setTransactionSuccessful();
    }

    @Override // ir.nasim.InterfaceC12694f27
    public void i0(String str, Object[] objArr) throws SQLException {
        AbstractC13042fc3.i(str, "sql");
        AbstractC13042fc3.i(objArr, "bindArgs");
        this.a.execSQL(str, objArr);
    }

    @Override // ir.nasim.InterfaceC12694f27
    public boolean isOpen() {
        return this.a.isOpen();
    }

    @Override // ir.nasim.InterfaceC12694f27
    public void j0() {
        this.a.beginTransactionNonExclusive();
    }

    @Override // ir.nasim.InterfaceC12694f27
    public Cursor p0(final InterfaceC14514i27 interfaceC14514i27, CancellationSignal cancellationSignal) {
        AbstractC13042fc3.i(interfaceC14514i27, "query");
        SQLiteDatabase sQLiteDatabase = this.a;
        String strA = interfaceC14514i27.a();
        String[] strArr = d;
        AbstractC13042fc3.f(cancellationSignal);
        return C9486a27.e(sQLiteDatabase, strA, strArr, null, cancellationSignal, new SQLiteDatabase.CursorFactory() { // from class: ir.nasim.bA2
            @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
            public final Cursor newCursor(SQLiteDatabase sQLiteDatabase2, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                return C11535dA2.e(interfaceC14514i27, sQLiteDatabase2, sQLiteCursorDriver, str, sQLiteQuery);
            }
        });
    }

    @Override // ir.nasim.InterfaceC12694f27
    public Cursor r1(String str) {
        AbstractC13042fc3.i(str, "query");
        return P1(new TC6(str));
    }

    @Override // ir.nasim.InterfaceC12694f27
    public void t0() {
        this.a.endTransaction();
    }
}
