package ir.nasim;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: ir.nasim.nh8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C17870nh8 {
    private static final ConcurrentHashMap h = new ConcurrentHashMap();
    private static final String[] i = {"key", "value"};
    private final ContentResolver a;
    private final Uri b;
    private volatile Map e;
    private final Object d = new Object();
    private final Object f = new Object();
    private final List g = new ArrayList();
    private final ContentObserver c = new C21530th8(this, null);

    private C17870nh8(ContentResolver contentResolver, Uri uri) {
        this.a = contentResolver;
        this.b = uri;
    }

    public static C17870nh8 a(ContentResolver contentResolver, Uri uri) {
        ConcurrentHashMap concurrentHashMap = h;
        C17870nh8 c17870nh8 = (C17870nh8) concurrentHashMap.get(uri);
        if (c17870nh8 != null) {
            return c17870nh8;
        }
        C17870nh8 c17870nh82 = new C17870nh8(contentResolver, uri);
        C17870nh8 c17870nh83 = (C17870nh8) concurrentHashMap.putIfAbsent(uri, c17870nh82);
        if (c17870nh83 != null) {
            return c17870nh83;
        }
        c17870nh82.a.registerContentObserver(c17870nh82.b, false, c17870nh82.c);
        return c17870nh82;
    }

    private final Map e() {
        try {
            HashMap map = new HashMap();
            Cursor cursorQuery = this.a.query(this.b, i, null, null, null);
            if (cursorQuery != null) {
                while (cursorQuery.moveToNext()) {
                    try {
                        map.put(cursorQuery.getString(0), cursorQuery.getString(1));
                    } catch (Throwable th) {
                        cursorQuery.close();
                        throw th;
                    }
                }
                cursorQuery.close();
            }
            return map;
        } catch (SQLiteException | SecurityException unused) {
            Log.e("ConfigurationContentLoader", "PhenotypeFlag unable to load ContentProvider, using default values");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f() {
        synchronized (this.f) {
            try {
                Iterator it = this.g.iterator();
                if (it.hasNext()) {
                    AbstractC18350oW3.a(it.next());
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Map c() {
        Map mapE = Bh8.h("gms:phenotype:phenotype_flag:debug_disable_caching", false) ? e() : this.e;
        if (mapE == null) {
            synchronized (this.d) {
                try {
                    mapE = this.e;
                    if (mapE == null) {
                        mapE = e();
                        this.e = mapE;
                    }
                } finally {
                }
            }
        }
        return mapE != null ? mapE : Collections.emptyMap();
    }

    public final void d() {
        synchronized (this.d) {
            this.e = null;
        }
    }
}
