package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.tgwidgets.editor.SQLite.SQLiteCursor;
import ir.nasim.tgwidgets.editor.SQLite.SQLiteDatabase;
import ir.nasim.tgwidgets.editor.SQLite.SQLiteException;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.NativeLoader;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/* renamed from: ir.nasim.Ul2, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C8082Ul2 {
    private HU1 a;
    private final int b;
    private SQLiteDatabase c;
    private File d;
    private File e;
    private final a f = new a();
    boolean g;

    /* renamed from: ir.nasim.Ul2$a */
    public static class a {
    }

    public C8082Ul2(int i) {
        this.b = i;
    }

    private void b() {
        File fileB = AbstractC14047hG.b();
        if (this.b != 0) {
            File file = new File(fileB, "account" + this.b + Separators.SLASH);
            file.mkdirs();
            fileB = file;
        }
        File file2 = new File(fileB, "file_to_path_backup.db");
        try {
            AbstractC21455b.B(this.d, file2);
            AbstractC6403Nl2.a("file db backup created " + file2.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void e() {
        if (this.a == null) {
            synchronized (this) {
                try {
                    if (this.a == null) {
                        HU1 hu1 = new HU1("files_database_queue_" + this.b);
                        this.a = hu1;
                        hu1.setPriority(10);
                    }
                } finally {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(long j, int i, int i2, String[] strArr, CountDownLatch countDownLatch) throws Exception {
        d();
        SQLiteDatabase sQLiteDatabase = this.c;
        if (sQLiteDatabase != null) {
            SQLiteCursor sQLiteCursorG = null;
            try {
                sQLiteCursorG = sQLiteDatabase.g("SELECT path FROM paths WHERE document_id = " + j + " AND dc_id = " + i + " AND type = " + i2, new Object[0]);
                if (sQLiteCursorG.h()) {
                    strArr[0] = sQLiteCursorG.i(0);
                    if (AbstractC8814Xl0.a) {
                        AbstractC6403Nl2.a("get file path id=" + j + " dc=" + i + " type=" + i2 + " path=" + strArr[0]);
                    }
                }
            } catch (Throwable th) {
                try {
                    AbstractC6403Nl2.d(th);
                    if (sQLiteCursorG != null) {
                    }
                } catch (Throwable th2) {
                    if (sQLiteCursorG != null) {
                        sQLiteCursorG.d();
                    }
                    throw th2;
                }
            }
            sQLiteCursorG.d();
        }
        countDownLatch.countDown();
    }

    private void h(int i) {
        if (i == 1) {
            this.c.d("CREATE INDEX IF NOT EXISTS path_in_paths ON paths(path);").k().e();
            this.c.d("PRAGMA user_version = 2").k().e();
            i = 2;
        }
        if (i == 2) {
            this.c.d("CREATE TABLE paths_by_dialog_id(path TEXT PRIMARY KEY, dialog_id INTEGER);").k().e();
            this.c.d("PRAGMA user_version = 3").k().e();
            i = 3;
        }
        if (i == 3) {
            this.c.d("ALTER TABLE paths_by_dialog_id ADD COLUMN message_id INTEGER default 0").k().e();
            this.c.d("ALTER TABLE paths_by_dialog_id ADD COLUMN message_type INTEGER default 0").k().e();
            this.c.d("PRAGMA user_version = 4").k().e();
        }
    }

    private void i(Runnable runnable) {
        e();
        this.a.i(runnable);
    }

    private boolean j() {
        File fileB = AbstractC14047hG.b();
        if (this.b != 0) {
            File file = new File(fileB, "account" + this.b + Separators.SLASH);
            file.mkdirs();
            fileB = file;
        }
        File file2 = new File(fileB, "file_to_path_backup.db");
        if (!file2.exists()) {
            return false;
        }
        try {
            return AbstractC21455b.B(file2, this.d);
        } catch (IOException e) {
            AbstractC6403Nl2.d(e);
            return false;
        }
    }

    public void c(int i, boolean z) throws Exception {
        File fileB = AbstractC14047hG.b();
        if (this.b != 0) {
            File file = new File(fileB, "account" + this.b + Separators.SLASH);
            file.mkdirs();
            fileB = file;
        }
        this.d = new File(fileB, "file_to_path.db");
        this.e = new File(fileB, "file_to_path.db-shm");
        boolean z2 = !this.d.exists();
        try {
            SQLiteDatabase sQLiteDatabase = new SQLiteDatabase(this.d.getPath());
            this.c = sQLiteDatabase;
            sQLiteDatabase.d("PRAGMA secure_delete = ON").k().e();
            this.c.d("PRAGMA temp_store = MEMORY").k().e();
            if (z2) {
                this.c.d("CREATE TABLE paths(document_id INTEGER, dc_id INTEGER, type INTEGER, path TEXT, PRIMARY KEY(document_id, dc_id, type));").k().e();
                this.c.d("CREATE INDEX IF NOT EXISTS path_in_paths ON paths(path);").k().e();
                this.c.d("CREATE TABLE paths_by_dialog_id(path TEXT PRIMARY KEY, dialog_id INTEGER, message_id INTEGER, message_type INTEGER);").k().e();
                this.c.d("PRAGMA user_version = 4").k().e();
            } else {
                int iIntValue = this.c.e("PRAGMA user_version", new Object[0]).intValue();
                if (AbstractC8814Xl0.b) {
                    AbstractC6403Nl2.a("current files db version = " + iIntValue);
                }
                if (iIntValue == 0) {
                    throw new Exception("malformed");
                }
                h(iIntValue);
            }
            if (!z) {
                b();
            }
            AbstractC6403Nl2.a("files db created from_backup= " + z);
        } catch (Exception e) {
            if (i < 4) {
                if (!z && j()) {
                    c(i + 1, true);
                    return;
                } else {
                    this.d.delete();
                    this.e.delete();
                    c(i + 1, false);
                }
            }
            if (AbstractC8814Xl0.a) {
                AbstractC6403Nl2.d(e);
            }
        }
    }

    public void d() throws Exception {
        if (this.g) {
            return;
        }
        if (!NativeLoader.d()) {
            int i = 0;
            while (!NativeLoader.d()) {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
                if (i > 5) {
                    break;
                }
            }
        }
        c(0, false);
        this.g = true;
    }

    public String f(final long j, final int i, final int i2, boolean z) throws Throwable {
        SQLiteException sQLiteException;
        String str;
        SQLiteCursor sQLiteCursorG;
        HU1 hu1;
        if (z) {
            if (AbstractC8814Xl0.c && (hu1 = this.a) != null && hu1.d() != null && Thread.currentThread() == this.a.d().getLooper().getThread()) {
                throw new RuntimeException("Error, lead to infinity loop");
            }
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            final String[] strArr = new String[1];
            i(new Runnable() { // from class: ir.nasim.Tl2
                @Override // java.lang.Runnable
                public final void run() throws Exception {
                    this.a.g(j, i, i2, strArr, countDownLatch);
                }
            });
            try {
                countDownLatch.await();
            } catch (Exception unused) {
            }
            return strArr[0];
        }
        SQLiteDatabase sQLiteDatabase = this.c;
        SQLiteCursor sQLiteCursor = null;
        strI = null;
        String strI = null;
        sQLiteCursor = null;
        if (sQLiteDatabase == null) {
            return null;
        }
        try {
            try {
                sQLiteCursorG = sQLiteDatabase.g("SELECT path FROM paths WHERE document_id = " + j + " AND dc_id = " + i + " AND type = " + i2, new Object[0]);
            } catch (SQLiteException e) {
                sQLiteException = e;
                str = null;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (sQLiteCursorG.h()) {
                strI = sQLiteCursorG.i(0);
                if (AbstractC8814Xl0.a) {
                    AbstractC6403Nl2.a("get file path id=" + j + " dc=" + i + " type=" + i2 + " path=" + strI);
                }
            }
            sQLiteCursorG.d();
            return strI;
        } catch (SQLiteException e2) {
            sQLiteException = e2;
            str = strI;
            sQLiteCursor = sQLiteCursorG;
            AbstractC6403Nl2.d(sQLiteException);
            if (sQLiteCursor != null) {
                sQLiteCursor.d();
            }
            return str;
        } catch (Throwable th2) {
            th = th2;
            sQLiteCursor = sQLiteCursorG;
            if (sQLiteCursor != null) {
                sQLiteCursor.d();
            }
            throw th;
        }
    }
}
