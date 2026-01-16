package io.appmetrica.analytics.impl;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import java.util.concurrent.Callable;

/* renamed from: io.appmetrica.analytics.impl.sa, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class CallableC2848sa implements Callable {
    public final /* synthetic */ C2872ta a;

    public CallableC2848sa(C2872ta c2872ta) {
        this.a = c2872ta;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        Uri uri = Uri.parse("content://com.huawei.appmarket.commondata/item/5");
        ContentResolver contentResolver = this.a.a.getContentResolver();
        C2872ta c2872ta = this.a;
        c2872ta.b = contentResolver.query(uri, null, null, new String[]{c2872ta.a.getPackageName()}, null);
        Cursor cursor = this.a.b;
        if (cursor != null && cursor.moveToFirst()) {
            String string = this.a.b.getString(0);
            if (!TextUtils.isEmpty(string)) {
                return new Cf(string, this.a.b.getLong(1), this.a.b.getLong(2), Bf.d);
            }
        }
        return null;
    }
}
