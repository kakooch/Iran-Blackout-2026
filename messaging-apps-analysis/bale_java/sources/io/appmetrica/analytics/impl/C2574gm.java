package io.appmetrica.analytics.impl;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: io.appmetrica.analytics.impl.gm, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2574gm {
    public final HashMap a;

    public C2574gm(String str, HashMap<String, List<String>> map) {
        this.a = map;
    }

    public final HashMap<String, List<String>> a() {
        return this.a;
    }

    public final boolean a(SQLiteDatabase sQLiteDatabase) {
        try {
            boolean zEquals = true;
            for (Map.Entry entry : this.a.entrySet()) {
                try {
                    Cursor cursorQuery = sQLiteDatabase.query((String) entry.getKey(), null, null, null, null, null, null);
                    if (cursorQuery == null) {
                        hn.a(cursorQuery);
                        return false;
                    }
                    List list = (List) entry.getValue();
                    List listAsList = Arrays.asList(cursorQuery.getColumnNames());
                    Collections.sort(listAsList);
                    zEquals &= list.equals(listAsList);
                    hn.a(cursorQuery);
                } catch (Throwable th) {
                    hn.a((Cursor) null);
                    throw th;
                }
            }
            return zEquals;
        } catch (Throwable unused) {
            return false;
        }
    }
}
