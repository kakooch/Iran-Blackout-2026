package io.appmetrica.analytics.impl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import io.appmetrica.analytics.coreapi.internal.db.DatabaseScript;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.io.Closeable;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class V6 extends SQLiteOpenHelper implements Closeable {
    public final String a;
    public final PublicLogger b;
    public final C2550fm c;

    public V6(Context context, String str, C2550fm c2550fm, PublicLogger publicLogger) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, AbstractC3011z5.b);
        this.c = c2550fm;
        this.a = str;
        this.b = publicLogger;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final SQLiteDatabase getReadableDatabase() {
        try {
            return super.getReadableDatabase();
        } catch (Throwable th) {
            this.b.error(th, "Could not get readable database %s due to an exception. AppMetrica SDK may behave unexpectedly.", this.a);
            C2523ej c2523ej = Ei.a;
            c2523ej.getClass();
            c2523ej.a(new C2498dj("db_read_error", th));
            return null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final SQLiteDatabase getWritableDatabase() {
        try {
            return super.getWritableDatabase();
        } catch (Throwable th) {
            this.b.error(th, "Could not get writable database %s due to an exception. AppMetrica SDK may behave unexpectedly.", this.a);
            C2523ej c2523ej = Ei.a;
            c2523ej.getClass();
            c2523ej.a(new C2498dj("db_write_error", th));
            return null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            this.c.a.runScript(sQLiteDatabase);
        } catch (Throwable unused) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        C2550fm c2550fm = this.c;
        if (i <= i2) {
            c2550fm.getClass();
            return;
        }
        try {
            c2550fm.b.runScript(sQLiteDatabase);
        } catch (Throwable unused) {
        }
        try {
            c2550fm.a.runScript(sQLiteDatabase);
        } catch (Throwable unused2) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
        C2550fm c2550fm = this.c;
        c2550fm.getClass();
        try {
            C2574gm c2574gm = c2550fm.d;
            if (c2574gm == null || c2574gm.a(sQLiteDatabase)) {
                return;
            }
            try {
                c2550fm.b.runScript(sQLiteDatabase);
            } catch (Throwable unused) {
            }
            c2550fm.a.runScript(sQLiteDatabase);
        } catch (Throwable unused2) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        boolean z;
        C2550fm c2550fm = this.c;
        c2550fm.getClass();
        if (i2 > i) {
            for (int i3 = i + 1; i3 <= i2; i3++) {
                try {
                    Collection collection = (Collection) c2550fm.c.a.get(Integer.valueOf(i3));
                    if (collection != null) {
                        Iterator it = collection.iterator();
                        while (it.hasNext()) {
                            ((DatabaseScript) it.next()).runScript(sQLiteDatabase);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
            z = false;
        } else {
            z = true;
        }
        if (z || (!c2550fm.d.a(sQLiteDatabase))) {
            try {
                c2550fm.b.runScript(sQLiteDatabase);
            } catch (Throwable unused2) {
            }
            try {
                c2550fm.a.runScript(sQLiteDatabase);
            } catch (Throwable unused3) {
            }
        }
    }
}
