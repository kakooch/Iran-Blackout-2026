package ir.nasim;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.StrictMode;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.op8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C18541op8 implements InterfaceC21610tp8 {
    private static final Map h = new KJ();
    public static final String[] i = {"key", "value"};
    private final ContentResolver a;
    private final Uri b;
    private final Runnable c;
    private final ContentObserver d;
    private final Object e;
    private volatile Map f;
    private final List g;

    private C18541op8(ContentResolver contentResolver, Uri uri, Runnable runnable) {
        C17950np8 c17950np8 = new C17950np8(this, null);
        this.d = c17950np8;
        this.e = new Object();
        this.g = new ArrayList();
        contentResolver.getClass();
        uri.getClass();
        this.a = contentResolver;
        this.b = uri;
        this.c = runnable;
        contentResolver.registerContentObserver(uri, false, c17950np8);
    }

    public static C18541op8 b(ContentResolver contentResolver, Uri uri, Runnable runnable) {
        C18541op8 c18541op8;
        synchronized (C18541op8.class) {
            Map map = h;
            c18541op8 = (C18541op8) map.get(uri);
            if (c18541op8 == null) {
                try {
                    C18541op8 c18541op82 = new C18541op8(contentResolver, uri, runnable);
                    try {
                        map.put(uri, c18541op82);
                    } catch (SecurityException unused) {
                    }
                    c18541op8 = c18541op82;
                } catch (SecurityException unused2) {
                }
            }
        }
        return c18541op8;
    }

    static synchronized void e() {
        try {
            for (C18541op8 c18541op8 : h.values()) {
                c18541op8.a.unregisterContentObserver(c18541op8.d);
            }
            h.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // ir.nasim.InterfaceC21610tp8
    public final /* bridge */ /* synthetic */ Object a(String str) {
        return (String) c().get(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Map c() {
        Map map;
        Map map2;
        Map map3 = this.f;
        Map map4 = map3;
        if (map3 == null) {
            synchronized (this.e) {
                Map map5 = this.f;
                map = map5;
                if (map5 == null) {
                    StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        try {
                            map2 = (Map) AbstractC20332rp8.a(new InterfaceC20923sp8() { // from class: ir.nasim.lp8
                                @Override // ir.nasim.InterfaceC20923sp8
                                public final Object zza() {
                                    return this.a.d();
                                }
                            });
                        } catch (SQLiteException | IllegalStateException | SecurityException unused) {
                            Log.e("ConfigurationContentLdr", "PhenotypeFlag unable to load ContentProvider, using default values");
                            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                            map2 = null;
                        }
                        this.f = map2;
                        threadPolicyAllowThreadDiskReads = map2;
                        map = threadPolicyAllowThreadDiskReads;
                    } finally {
                        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                    }
                }
            }
            map4 = map;
        }
        return map4 != null ? map4 : Collections.emptyMap();
    }

    final /* synthetic */ Map d() {
        Cursor cursorQuery = this.a.query(this.b, i, null, null, null);
        if (cursorQuery == null) {
            return Collections.emptyMap();
        }
        try {
            int count = cursorQuery.getCount();
            if (count == 0) {
                return Collections.emptyMap();
            }
            Map kj = count <= 256 ? new KJ(count) : new HashMap(count, 1.0f);
            while (cursorQuery.moveToNext()) {
                kj.put(cursorQuery.getString(0), cursorQuery.getString(1));
            }
            return kj;
        } finally {
            cursorQuery.close();
        }
    }

    public final void f() {
        synchronized (this.e) {
            this.f = null;
            this.c.run();
        }
        synchronized (this) {
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
}
