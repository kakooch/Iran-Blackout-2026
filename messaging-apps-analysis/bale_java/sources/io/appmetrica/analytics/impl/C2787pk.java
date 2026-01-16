package io.appmetrica.analytics.impl;

import android.database.sqlite.SQLiteDatabase;

/* renamed from: io.appmetrica.analytics.impl.pk, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2787pk implements InterfaceC2916v6 {
    public final V6 a;

    public C2787pk(V6 v6) {
        this.a = v6;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2916v6
    public final void a(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2916v6
    public final SQLiteDatabase a() {
        try {
            return this.a.getWritableDatabase();
        } catch (Throwable unused) {
            return null;
        }
    }
}
