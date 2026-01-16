package ir.nasim;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.util.Log;
import ir.nasim.C12178eA2;
import ir.nasim.InterfaceC13330g27;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/* renamed from: ir.nasim.eA2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C12178eA2 implements InterfaceC13330g27 {
    public static final a h = new a(null);
    private final Context a;
    private final String b;
    private final InterfaceC13330g27.a c;
    private final boolean d;
    private final boolean e;
    private final InterfaceC9173Yu3 f;
    private boolean g;

    /* renamed from: ir.nasim.eA2$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ir.nasim.eA2$b */
    static final class b {
        private C11535dA2 a;

        public b(C11535dA2 c11535dA2) {
            this.a = c11535dA2;
        }

        public final C11535dA2 a() {
            return this.a;
        }

        public final void b(C11535dA2 c11535dA2) {
            this.a = c11535dA2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ir.nasim.eA2$c */
    static final class c extends SQLiteOpenHelper {
        public static final C1046c h = new C1046c(null);
        private final Context a;
        private final b b;
        private final InterfaceC13330g27.a c;
        private final boolean d;
        private boolean e;
        private final C6954Pr5 f;
        private boolean g;

        /* renamed from: ir.nasim.eA2$c$a */
        private static final class a extends RuntimeException {
            private final b a;
            private final Throwable b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(b bVar, Throwable th) {
                super(th);
                AbstractC13042fc3.i(bVar, "callbackName");
                AbstractC13042fc3.i(th, ParameterNames.CAUSE);
                this.a = bVar;
                this.b = th;
            }

            public final b a() {
                return this.a;
            }

            @Override // java.lang.Throwable
            public Throwable getCause() {
                return this.b;
            }
        }

        /* renamed from: ir.nasim.eA2$c$b */
        public enum b {
            ON_CONFIGURE,
            ON_CREATE,
            ON_UPGRADE,
            ON_DOWNGRADE,
            ON_OPEN
        }

        /* renamed from: ir.nasim.eA2$c$c, reason: collision with other inner class name */
        public static final class C1046c {
            private C1046c() {
            }

            public final C11535dA2 a(b bVar, SQLiteDatabase sQLiteDatabase) {
                AbstractC13042fc3.i(bVar, "refHolder");
                AbstractC13042fc3.i(sQLiteDatabase, "sqLiteDatabase");
                C11535dA2 c11535dA2A = bVar.a();
                if (c11535dA2A != null && c11535dA2A.c(sQLiteDatabase)) {
                    return c11535dA2A;
                }
                C11535dA2 c11535dA2 = new C11535dA2(sQLiteDatabase);
                bVar.b(c11535dA2);
                return c11535dA2;
            }

            public /* synthetic */ C1046c(ED1 ed1) {
                this();
            }
        }

        /* renamed from: ir.nasim.eA2$c$d */
        public /* synthetic */ class d {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[b.values().length];
                try {
                    iArr[b.ON_CONFIGURE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[b.ON_CREATE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[b.ON_UPGRADE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[b.ON_DOWNGRADE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[b.ON_OPEN.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Context context, String str, final b bVar, final InterfaceC13330g27.a aVar, boolean z) {
            super(context, str, null, aVar.a, new DatabaseErrorHandler() { // from class: ir.nasim.fA2
                @Override // android.database.DatabaseErrorHandler
                public final void onCorruption(SQLiteDatabase sQLiteDatabase) {
                    C12178eA2.c.b(aVar, bVar, sQLiteDatabase);
                }
            });
            AbstractC13042fc3.i(context, "context");
            AbstractC13042fc3.i(bVar, "dbRef");
            AbstractC13042fc3.i(aVar, "callback");
            this.a = context;
            this.b = bVar;
            this.c = aVar;
            this.d = z;
            if (str == null) {
                str = UUID.randomUUID().toString();
                AbstractC13042fc3.h(str, "randomUUID().toString()");
            }
            this.f = new C6954Pr5(str, context.getCacheDir(), false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(InterfaceC13330g27.a aVar, b bVar, SQLiteDatabase sQLiteDatabase) {
            AbstractC13042fc3.i(aVar, "$callback");
            AbstractC13042fc3.i(bVar, "$dbRef");
            C1046c c1046c = h;
            AbstractC13042fc3.h(sQLiteDatabase, "dbObj");
            aVar.c(c1046c.a(bVar, sQLiteDatabase));
        }

        private final SQLiteDatabase e(boolean z) {
            if (z) {
                SQLiteDatabase writableDatabase = super.getWritableDatabase();
                AbstractC13042fc3.h(writableDatabase, "{\n                super.…eDatabase()\n            }");
                return writableDatabase;
            }
            SQLiteDatabase readableDatabase = super.getReadableDatabase();
            AbstractC13042fc3.h(readableDatabase, "{\n                super.…eDatabase()\n            }");
            return readableDatabase;
        }

        private final SQLiteDatabase g(boolean z) throws Throwable {
            File parentFile;
            String databaseName = getDatabaseName();
            boolean z2 = this.g;
            if (databaseName != null && !z2 && (parentFile = this.a.getDatabasePath(databaseName).getParentFile()) != null) {
                parentFile.mkdirs();
                if (!parentFile.isDirectory()) {
                    Log.w("SupportSQLite", "Invalid database parent file, not a directory: " + parentFile);
                }
            }
            try {
                return e(z);
            } catch (Throwable unused) {
                super.close();
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException unused2) {
                }
                try {
                    return e(z);
                } catch (Throwable th) {
                    super.close();
                    if (th instanceof a) {
                        a aVar = th;
                        Throwable cause = aVar.getCause();
                        int i = d.a[aVar.a().ordinal()];
                        if (i == 1 || i == 2 || i == 3 || i == 4 || !(cause instanceof SQLiteException)) {
                            throw cause;
                        }
                    } else if (!(th instanceof SQLiteException) || databaseName == null || !this.d) {
                        throw th;
                    }
                    this.a.deleteDatabase(databaseName);
                    try {
                        return e(z);
                    } catch (a e) {
                        throw e.getCause();
                    }
                }
            }
        }

        public final InterfaceC12694f27 c(boolean z) throws IOException {
            try {
                this.f.b((this.g || getDatabaseName() == null) ? false : true);
                this.e = false;
                SQLiteDatabase sQLiteDatabaseG = g(z);
                if (!this.e) {
                    C11535dA2 c11535dA2D = d(sQLiteDatabaseG);
                    this.f.d();
                    return c11535dA2D;
                }
                close();
                InterfaceC12694f27 interfaceC12694f27C = c(z);
                this.f.d();
                return interfaceC12694f27C;
            } catch (Throwable th) {
                this.f.d();
                throw th;
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
        public void close() throws IOException {
            try {
                C6954Pr5.c(this.f, false, 1, null);
                super.close();
                this.b.b(null);
                this.g = false;
            } finally {
                this.f.d();
            }
        }

        public final C11535dA2 d(SQLiteDatabase sQLiteDatabase) {
            AbstractC13042fc3.i(sQLiteDatabase, "sqLiteDatabase");
            return h.a(this.b, sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            AbstractC13042fc3.i(sQLiteDatabase, "db");
            if (!this.e && this.c.a != sQLiteDatabase.getVersion()) {
                sQLiteDatabase.setMaxSqlCacheSize(1);
            }
            try {
                this.c.b(d(sQLiteDatabase));
            } catch (Throwable th) {
                throw new a(b.ON_CONFIGURE, th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            AbstractC13042fc3.i(sQLiteDatabase, "sqLiteDatabase");
            try {
                this.c.d(d(sQLiteDatabase));
            } catch (Throwable th) {
                throw new a(b.ON_CREATE, th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            AbstractC13042fc3.i(sQLiteDatabase, "db");
            this.e = true;
            try {
                this.c.e(d(sQLiteDatabase), i, i2);
            } catch (Throwable th) {
                throw new a(b.ON_DOWNGRADE, th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            AbstractC13042fc3.i(sQLiteDatabase, "db");
            if (!this.e) {
                try {
                    this.c.f(d(sQLiteDatabase));
                } catch (Throwable th) {
                    throw new a(b.ON_OPEN, th);
                }
            }
            this.g = true;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            AbstractC13042fc3.i(sQLiteDatabase, "sqLiteDatabase");
            this.e = true;
            try {
                this.c.g(d(sQLiteDatabase), i, i2);
            } catch (Throwable th) {
                throw new a(b.ON_UPGRADE, th);
            }
        }
    }

    /* renamed from: ir.nasim.eA2$d */
    static final class d extends AbstractC8614Ws3 implements SA2 {
        d() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final c invoke() {
            c cVar;
            if (C12178eA2.this.b == null || !C12178eA2.this.d) {
                cVar = new c(C12178eA2.this.a, C12178eA2.this.b, new b(null), C12178eA2.this.c, C12178eA2.this.e);
            } else {
                cVar = new c(C12178eA2.this.a, new File(C10696c27.a(C12178eA2.this.a), C12178eA2.this.b).getAbsolutePath(), new b(null), C12178eA2.this.c, C12178eA2.this.e);
            }
            C9486a27.f(cVar, C12178eA2.this.g);
            return cVar;
        }
    }

    public C12178eA2(Context context, String str, InterfaceC13330g27.a aVar, boolean z, boolean z2) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(aVar, "callback");
        this.a = context;
        this.b = str;
        this.c = aVar;
        this.d = z;
        this.e = z2;
        this.f = AbstractC13269fw3.a(new d());
    }

    private final c j() {
        return (c) this.f.getValue();
    }

    @Override // ir.nasim.InterfaceC13330g27
    public InterfaceC12694f27 E() {
        return j().c(true);
    }

    @Override // ir.nasim.InterfaceC13330g27, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f.isInitialized()) {
            j().close();
        }
    }

    @Override // ir.nasim.InterfaceC13330g27
    public String getDatabaseName() {
        return this.b;
    }

    @Override // ir.nasim.InterfaceC13330g27
    public void setWriteAheadLoggingEnabled(boolean z) {
        if (this.f.isInitialized()) {
            C9486a27.f(j(), z);
        }
        this.g = z;
    }
}
