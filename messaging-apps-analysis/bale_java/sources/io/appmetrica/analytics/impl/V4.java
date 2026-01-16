package io.appmetrica.analytics.impl;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import io.appmetrica.analytics.coreapi.internal.db.DatabaseScript;

/* loaded from: classes3.dex */
public final class V4 extends DatabaseScript {
    public final U4 a = new U4();
    public final T4 b = new T4();

    @Override // io.appmetrica.analytics.coreapi.internal.db.DatabaseScript
    public final void runScript(SQLiteDatabase sQLiteDatabase) throws SQLException {
        this.a.runScript(sQLiteDatabase);
        this.b.runScript(sQLiteDatabase);
    }
}
