package ir.nasim;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.gov.nist.core.Separators;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public final class B86 {
    private final SQLiteDatabase a;
    private final String b;
    private final String c;
    private final String d;
    private final InterfaceC9173Yu3 e;
    private String f;
    private boolean g;
    private final InterfaceC9173Yu3 h;

    public B86(SQLiteDatabase sQLiteDatabase) throws SQLException {
        AbstractC13042fc3.i(sQLiteDatabase, "db");
        this.a = sQLiteDatabase;
        this.b = "push";
        this.c = "_id";
        this.d = "push_type";
        this.e = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.y86
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return B86.d();
            }
        });
        this.f = "CREATE TABLE push" + Separators.LPAREN + "_id INTEGER PRIMARY KEY, push_type TEXT NOT NULL, " + j() + " INTEGER);";
        this.h = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.z86
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return B86.m(this.a);
            }
        });
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String d() {
        return "push_send_time";
    }

    private final SQLiteStatement g() throws SQLException {
        SQLiteStatement sQLiteStatementCompileStatement = this.a.compileStatement("INSERT OR REPLACE INTO \"" + this.b + "\" (\"" + this.c + "\",\"" + this.d + "\",\"" + j() + "\") VALUES (?,?,?)");
        AbstractC13042fc3.h(sQLiteStatementCompileStatement, "compileStatement(...)");
        return sQLiteStatementCompileStatement;
    }

    private final void h() throws SQLException {
        if (this.g) {
            return;
        }
        if (AbstractC22384v86.a(this.a, this.b)) {
            final String str = "SQLiteQueryPush";
            AbstractC21784u76.e(new Runnable() { // from class: ir.nasim.A86
                @Override // java.lang.Runnable
                public final void run() {
                    B86.i(this.a, str);
                }
            });
        } else {
            this.a.execSQL(this.f);
        }
        this.g = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(B86 b86, String str) {
        AbstractC13042fc3.i(b86, "this$0");
        AbstractC13042fc3.i(str, "$TAG");
        long jP = AbstractC20507s76.p();
        Cursor cursorRawQuery = b86.a.rawQuery("SELECT COUNT (" + b86.c + ") FROM " + b86.b, null);
        AbstractC13042fc3.h(cursorRawQuery, "rawQuery(...)");
        cursorRawQuery.moveToFirst();
        int i = cursorRawQuery.getInt(0);
        cursorRawQuery.close();
        C19406qI3.a(str, "Push rows count: " + i, new Object[0]);
        C19406qI3.a(str, "Push count query took: " + (AbstractC20507s76.p() - jP) + " ms", new Object[0]);
    }

    private final SQLiteStatement k() {
        return (SQLiteStatement) this.h.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SQLiteStatement m(B86 b86) {
        AbstractC13042fc3.i(b86, "this$0");
        return b86.g();
    }

    public final void e(a aVar) {
        AbstractC13042fc3.i(aVar, "push");
        this.a.beginTransactionNonExclusive();
        try {
            k().bindLong(1, aVar.a());
            k().bindString(2, aVar.c());
            k().bindLong(3, aVar.b());
            k().executeInsert();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    public final void f(List list) {
        AbstractC13042fc3.i(list, "pushes");
        this.a.beginTransactionNonExclusive();
        try {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                k().bindLong(1, aVar.a());
                k().bindString(2, aVar.c());
                k().bindLong(3, aVar.b());
                k().executeInsert();
            }
            this.a.setTransactionSuccessful();
            this.a.endTransaction();
        } catch (Throwable th) {
            this.a.endTransaction();
            throw th;
        }
    }

    public final String j() {
        return (String) this.e.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0057 A[PHI: r0 r1
      0x0057: PHI (r0v3 ir.nasim.B86$a) = (r0v8 ir.nasim.B86$a), (r0v6 ir.nasim.B86$a) binds: [B:19:0x0065, B:11:0x0055] A[DONT_GENERATE, DONT_INLINE]
      0x0057: PHI (r1v2 android.database.Cursor) = (r1v1 android.database.Cursor), (r1v4 android.database.Cursor) binds: [B:19:0x0065, B:11:0x0055] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final ir.nasim.B86.a l(long r10) throws java.lang.Throwable {
        /*
            r9 = this;
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r9.a     // Catch: java.lang.Throwable -> L5b android.database.sqlite.SQLiteException -> L5d
            java.lang.String r2 = r9.b     // Catch: java.lang.Throwable -> L5b android.database.sqlite.SQLiteException -> L5d
            java.lang.String r3 = r9.c     // Catch: java.lang.Throwable -> L5b android.database.sqlite.SQLiteException -> L5d
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5b android.database.sqlite.SQLiteException -> L5d
            r4.<init>()     // Catch: java.lang.Throwable -> L5b android.database.sqlite.SQLiteException -> L5d
            r4.append(r3)     // Catch: java.lang.Throwable -> L5b android.database.sqlite.SQLiteException -> L5d
            java.lang.String r3 = " = ? "
            r4.append(r3)     // Catch: java.lang.Throwable -> L5b android.database.sqlite.SQLiteException -> L5d
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L5b android.database.sqlite.SQLiteException -> L5d
            java.lang.String r3 = java.lang.String.valueOf(r10)     // Catch: java.lang.Throwable -> L5b android.database.sqlite.SQLiteException -> L5d
            java.lang.String[] r5 = new java.lang.String[]{r3}     // Catch: java.lang.Throwable -> L5b android.database.sqlite.SQLiteException -> L5d
            r7 = 0
            r8 = 0
            r3 = 0
            r6 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L5b android.database.sqlite.SQLiteException -> L5d
            if (r1 == 0) goto L55
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteException -> L65
            if (r2 == 0) goto L55
            java.lang.String r2 = r9.d     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteException -> L65
            int r2 = r1.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteException -> L65
            java.lang.String r6 = r1.getString(r2)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteException -> L65
            java.lang.String r2 = r9.j()     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteException -> L65
            int r2 = r1.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteException -> L65
            long r7 = r1.getLong(r2)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteException -> L65
            ir.nasim.B86$a r2 = new ir.nasim.B86$a     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteException -> L65
            ir.nasim.AbstractC13042fc3.f(r6)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteException -> L65
            r3 = r2
            r4 = r10
            r3.<init>(r4, r6, r7)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteException -> L65
            r0 = r2
            goto L55
        L52:
            r10 = move-exception
            r0 = r1
            goto L5f
        L55:
            if (r1 == 0) goto L68
        L57:
            r1.close()
            goto L68
        L5b:
            r10 = move-exception
            goto L5f
        L5d:
            r1 = r0
            goto L65
        L5f:
            if (r0 == 0) goto L64
            r0.close()
        L64:
            throw r10
        L65:
            if (r1 == 0) goto L68
            goto L57
        L68:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.B86.l(long):ir.nasim.B86$a");
    }

    public static final class a {
        private final long a;
        private final String b;
        private final long c;

        public a(long j, String str, long j2) {
            AbstractC13042fc3.i(str, "pushType");
            this.a = j;
            this.b = str;
            this.c = j2;
        }

        public final long a() {
            return this.a;
        }

        public final long b() {
            return this.c;
        }

        public final String c() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && AbstractC13042fc3.d(this.b, aVar.b) && this.c == aVar.c;
        }

        public int hashCode() {
            return (((Long.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + Long.hashCode(this.c);
        }

        public String toString() {
            return "PushDbItem(messageDate=" + this.a + ", pushType=" + this.b + ", pushSendTime=" + this.c + Separators.RPAREN;
        }

        public /* synthetic */ a(long j, String str, long j2, int i, ED1 ed1) {
            this(j, str, (i & 4) != 0 ? -1L : j2);
        }
    }
}
