package io.appmetrica.analytics.impl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.io.Closeable;

/* loaded from: classes3.dex */
public final class Pb implements InterfaceC2916v6 {
    public final Context a;
    public final String b;
    public final C2550fm c;
    public final S9 d;
    public V6 e;

    public Pb(Context context, String str, C2550fm c2550fm) {
        this(context, str, new S9(str), c2550fm);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2916v6
    public final synchronized SQLiteDatabase a() {
        V6 v6;
        try {
            this.d.a();
            v6 = new V6(this.a, this.b, this.c, PublicLogger.getAnonymousInstance());
            this.e = v6;
        } catch (Throwable unused) {
            return null;
        }
        return v6.getWritableDatabase();
    }

    public Pb(Context context, String str, S9 s9, C2550fm c2550fm) {
        this.a = context;
        this.b = str;
        this.d = s9;
        this.c = c2550fm;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2916v6
    public final synchronized void a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.close();
            } catch (Throwable unused) {
            }
        }
        hn.a((Closeable) this.e);
        this.d.b();
        this.e = null;
    }
}
