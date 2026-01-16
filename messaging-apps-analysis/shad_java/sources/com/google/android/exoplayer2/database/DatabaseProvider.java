package com.google.android.exoplayer2.database;

import android.database.sqlite.SQLiteDatabase;

/* loaded from: classes.dex */
public interface DatabaseProvider {
    SQLiteDatabase getReadableDatabase();

    SQLiteDatabase getWritableDatabase();
}
