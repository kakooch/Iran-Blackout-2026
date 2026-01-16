package ir.nasim;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.gov.nist.core.Separators;
import ir.nasim.C9475a16;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.fr, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC13215fr implements PO6 {
    public static final a b = new a(null);
    private static final String c = ((InterfaceC14516i3) C92.a(C5721Ko.a.d(), InterfaceC14516i3.class)).W0();
    private static SQLiteDatabase d;
    private static SQLiteDatabase e;
    private final InterfaceC3570Bk5 a;

    /* renamed from: ir.nasim.fr$a */
    public static final class a {
        private a() {
        }

        public final String a() {
            return AbstractC13215fr.c;
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0011  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final android.database.sqlite.SQLiteDatabase b() {
            /*
                r4 = this;
                android.database.sqlite.SQLiteDatabase r0 = ir.nasim.AbstractC13215fr.j()
                r1 = 0
                if (r0 == 0) goto L11
                boolean r2 = r0.isOpen()
                if (r2 == 0) goto Le
                goto Lf
            Le:
                r0 = r1
            Lf:
                if (r0 != 0) goto L59
            L11:
                monitor-enter(r4)
                android.database.sqlite.SQLiteDatabase r0 = ir.nasim.AbstractC13215fr.j()     // Catch: java.lang.Throwable -> L23
                if (r0 == 0) goto L25
                boolean r2 = r0.isOpen()     // Catch: java.lang.Throwable -> L23
                if (r2 == 0) goto L1f
                goto L20
            L1f:
                r0 = r1
            L20:
                if (r0 != 0) goto L53
                goto L25
            L23:
                r0 = move-exception
                goto L5a
            L25:
                ir.nasim.fr$a r0 = ir.nasim.AbstractC13215fr.b     // Catch: java.lang.Throwable -> L23
                ir.nasim.NA4 r2 = new ir.nasim.NA4     // Catch: java.lang.Throwable -> L23
                ir.nasim.Ko r3 = ir.nasim.C5721Ko.a     // Catch: java.lang.Throwable -> L23
                android.content.Context r3 = r3.d()     // Catch: java.lang.Throwable -> L23
                java.lang.String r0 = r0.a()     // Catch: java.lang.Throwable -> L23
                r2.<init>(r3, r0)     // Catch: java.lang.Throwable -> L23
                android.database.sqlite.SQLiteDatabase r0 = r2.getWritableDatabase()     // Catch: java.lang.Throwable -> L23
                java.lang.String r2 = "PRAGMA temp_store = MEMORY;"
                r0.execSQL(r2)     // Catch: java.lang.Throwable -> L23
                java.lang.String r2 = "PRAGMA journal_size_limit = 10485760;"
                android.database.Cursor r1 = r0.rawQuery(r2, r1)     // Catch: java.lang.Throwable -> L23
                r1.close()     // Catch: java.lang.Throwable -> L23
                java.lang.String r1 = "PRAGMA synchronous = NORMAL"
                r0.execSQL(r1)     // Catch: java.lang.Throwable -> L23
                r0.enableWriteAheadLogging()     // Catch: java.lang.Throwable -> L23
                ir.nasim.AbstractC13215fr.l(r0)     // Catch: java.lang.Throwable -> L23
            L53:
                monitor-exit(r4)
                java.lang.String r1 = "synchronized(...)"
                ir.nasim.AbstractC13042fc3.h(r0, r1)
            L59:
                return r0
            L5a:
                monitor-exit(r4)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC13215fr.a.b():android.database.sqlite.SQLiteDatabase");
        }

        /* JADX WARN: Removed duplicated region for block: B:34:0x0016 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final synchronized android.database.sqlite.SQLiteDatabase c() {
            /*
                r3 = this;
                monitor-enter(r3)
                android.database.sqlite.SQLiteDatabase r0 = ir.nasim.AbstractC13215fr.k()     // Catch: java.lang.Throwable -> L13
                r1 = 0
                if (r0 == 0) goto L15
                boolean r2 = r0.isOpen()     // Catch: java.lang.Throwable -> L13
                if (r2 == 0) goto Lf
                goto L10
            Lf:
                r0 = r1
            L10:
                if (r0 != 0) goto L4e
                goto L15
            L13:
                r0 = move-exception
                goto L52
            L15:
                monitor-enter(r3)     // Catch: java.lang.Throwable -> L13
                android.database.sqlite.SQLiteDatabase r0 = ir.nasim.AbstractC13215fr.k()     // Catch: java.lang.Throwable -> L28
                if (r0 == 0) goto L2a
                boolean r2 = r0.isOpen()     // Catch: java.lang.Throwable -> L28
                if (r2 == 0) goto L23
                r1 = r0
            L23:
                if (r1 != 0) goto L26
                goto L2a
            L26:
                r0 = r1
                goto L48
            L28:
                r0 = move-exception
                goto L50
            L2a:
                ir.nasim.NA4 r0 = new ir.nasim.NA4     // Catch: java.lang.Throwable -> L28
                ir.nasim.Ko r1 = ir.nasim.C5721Ko.a     // Catch: java.lang.Throwable -> L28
                android.content.Context r1 = r1.d()     // Catch: java.lang.Throwable -> L28
                java.lang.String r2 = "filePath"
                r0.<init>(r1, r2)     // Catch: java.lang.Throwable -> L28
                android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch: java.lang.Throwable -> L28
                java.lang.String r1 = "PRAGMA temp_store = MEMORY;"
                r0.execSQL(r1)     // Catch: java.lang.Throwable -> L28
                java.lang.String r1 = "PRAGMA synchronous = NORMAL"
                r0.execSQL(r1)     // Catch: java.lang.Throwable -> L28
                ir.nasim.AbstractC13215fr.m(r0)     // Catch: java.lang.Throwable -> L28
            L48:
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L13
                java.lang.String r1 = "synchronized(...)"
                ir.nasim.AbstractC13042fc3.h(r0, r1)     // Catch: java.lang.Throwable -> L13
            L4e:
                monitor-exit(r3)
                return r0
            L50:
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L13
                throw r0     // Catch: java.lang.Throwable -> L13
            L52:
                monitor-exit(r3)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC13215fr.a.c():android.database.sqlite.SQLiteDatabase");
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public AbstractC13215fr(InterfaceC3570Bk5 interfaceC3570Bk5) {
        AbstractC13042fc3.i(interfaceC3570Bk5, "properties");
        this.a = interfaceC3570Bk5;
    }

    private final void n() {
        List<File> listN0;
        boolean z;
        try {
            int iP = p();
            File file = new File(C5721Ko.a.d().getApplicationInfo().dataDir, "shared_prefs");
            boolean z2 = true;
            boolean z3 = C13923h3.a.o().size() <= 1;
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                ArrayList arrayList = new ArrayList();
                for (File file2 : fileArrListFiles) {
                    AbstractC13042fc3.f(file2);
                    if (u(file2, z3, iP)) {
                        arrayList.add(file2);
                    }
                }
                listN0 = AbstractC15401jX0.n0(arrayList);
            } else {
                listN0 = null;
            }
            if (listN0 != null) {
                loop1: while (true) {
                    for (File file3 : listN0) {
                        z = z && file3.delete();
                    }
                }
                z2 = z;
            }
            C19406qI3.a("AndroidStorageProvider", "Clearing sharedPreference result was: " + z2, new Object[0]);
            C13923h3.a.v();
        } catch (Exception e2) {
            C19406qI3.d("AndroidStorageProvider", e2);
        }
    }

    private final void o() {
        Object objB;
        boolean z = true;
        try {
            C9475a16.a aVar = C9475a16.b;
            File[] fileArrListFiles = new File(C5721Ko.a.d().getApplicationInfo().dataDir, "files/datastore").listFiles();
            F92 f92J = EnumC12211eE.j();
            ArrayList arrayList = new ArrayList();
            for (Object obj : f92J) {
                if (!((EnumC12211eE) obj).p()) {
                    arrayList.add(obj);
                }
            }
            if (fileArrListFiles != null) {
                boolean z2 = true;
                for (File file : fileArrListFiles) {
                    if (!arrayList.isEmpty()) {
                        Iterator it = arrayList.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                EnumC12211eE enumC12211eE = (EnumC12211eE) it.next();
                                String name = file.getName();
                                AbstractC13042fc3.h(name, "getName(...)");
                                if (AbstractC20153rZ6.S(name, enumC12211eE.getKey(), false, 2, null)) {
                                    z2 = z2 && file.delete();
                                }
                            }
                        }
                    }
                }
                z = z2;
            }
            C19406qI3.a("AndroidStorageProvider", "Clearing data store result was: " + z, new Object[0]);
            objB = C9475a16.b(C19938rB7.a);
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            objB = C9475a16.b(AbstractC10685c16.a(th));
        }
        Throwable thE = C9475a16.e(objB);
        if (thE != null) {
            C19406qI3.d("AndroidStorageProvider", thE);
        }
    }

    private final int p() {
        return C13923h3.a.m();
    }

    public static final SQLiteDatabase q() {
        return b.b();
    }

    public static final synchronized SQLiteDatabase r() {
        return b.c();
    }

    private final boolean s(File file) {
        return AbstractC13042fc3.d("force_update.xml", file.getName());
    }

    private final boolean t(File file) {
        return AbstractC13042fc3.d("secret_shared_prefs.xml", file.getName());
    }

    private final boolean u(File file, boolean z, int i) {
        if (s(file) || t(file)) {
            return false;
        }
        if (!z) {
            String name = file.getName();
            AbstractC13042fc3.h(name, "getName(...)");
            if (!AbstractC20153rZ6.S(name, String.valueOf(i), false, 2, null)) {
                return false;
            }
        }
        return true;
    }

    @Override // ir.nasim.PO6
    public synchronized void a() {
        this.a.clear();
        n();
        o();
    }

    @Override // ir.nasim.PO6
    public InterfaceC3570Bk5 b() {
        return this.a;
    }

    @Override // ir.nasim.PO6
    public void c() throws SQLException {
        b.b().execSQL("VACUUM;");
    }

    @Override // ir.nasim.PO6
    public void d(List list) {
        AbstractC13042fc3.i(list, "tablesToClear");
        SQLiteDatabase sQLiteDatabaseB = b.b();
        sQLiteDatabaseB.beginTransactionNonExclusive();
        try {
            try {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    if (AbstractC22384v86.a(sQLiteDatabaseB, str)) {
                        sQLiteDatabaseB.execSQL("DELETE FROM \"" + str + Separators.DOUBLE_QUOTE);
                    }
                }
                sQLiteDatabaseB.setTransactionSuccessful();
            } catch (Exception e2) {
                C19406qI3.c("AndroidStorageProvider", "Exception on clear tables data: ", e2);
            }
            sQLiteDatabaseB.endTransaction();
        } catch (Throwable th) {
            sQLiteDatabaseB.endTransaction();
            throw th;
        }
    }

    @Override // ir.nasim.PO6
    public long e() {
        return new File(b.b().getPath()).length();
    }

    @Override // ir.nasim.PO6
    public void f(String str) {
        AbstractC13042fc3.i(str, "tablesPrefixForClear");
        SQLiteDatabase sQLiteDatabaseB = b.b();
        sQLiteDatabaseB.beginTransactionNonExclusive();
        try {
            try {
                Cursor cursorRawQuery = sQLiteDatabaseB.rawQuery("SELECT name FROM sqlite_master WHERE type='table' AND name LIKE ?", new String[]{str + Separators.PERCENT});
                AbstractC13042fc3.h(cursorRawQuery, "rawQuery(...)");
                ArrayList arrayList = new ArrayList();
                while (cursorRawQuery.moveToNext()) {
                    String string = cursorRawQuery.getString(0);
                    AbstractC13042fc3.h(string, "getString(...)");
                    arrayList.add(string);
                }
                cursorRawQuery.close();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    sQLiteDatabaseB.execSQL("DELETE FROM " + ((String) it.next()));
                }
                sQLiteDatabaseB.setTransactionSuccessful();
            } catch (Exception e2) {
                C19406qI3.c("AndroidStorageProvider", "Exception on clear tables data: ", e2);
            }
            sQLiteDatabaseB.endTransaction();
        } catch (Throwable th) {
            sQLiteDatabaseB.endTransaction();
            throw th;
        }
    }

    @Override // ir.nasim.PO6
    public XB3 g(String str) {
        AbstractC13042fc3.i(str, "name");
        return new C23570x86(null, "ls_" + str);
    }

    @Override // ir.nasim.PO6
    public AbstractC9119Yo3 h(C86 c86, String str, InterfaceC17311ml0 interfaceC17311ml0, InterfaceC15345jQ7 interfaceC15345jQ7) {
        AbstractC13042fc3.i(c86, "sqLiteType");
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(interfaceC17311ml0, "bserCreator");
        return new C22980w86(c86, "kv_" + str, interfaceC17311ml0, interfaceC15345jQ7);
    }
}
