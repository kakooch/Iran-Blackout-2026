package io.sentry.android.core;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

/* renamed from: io.sentry.android.core.r0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
abstract class AbstractC3073r0 extends ContentProvider {
    private final io.sentry.android.core.internal.util.k a = new io.sentry.android.core.internal.util.k();

    AbstractC3073r0() {
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        this.a.a(this);
        return 0;
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues) {
        this.a.a(this);
        return null;
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        this.a.a(this);
        return null;
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        this.a.a(this);
        return 0;
    }
}
