package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.StrictMode;
import android.util.Log;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzen implements zzer {
    private final ContentResolver zzc;
    private final Uri zzd;
    private final ContentObserver zze;
    private final Object zzf;
    private volatile Map<String, String> zzg;
    private final List<zzeo> zzh;
    private static final Map<Uri, zzen> zzb = new ArrayMap();
    public static final String[] zza = {"key", "value"};

    private zzen(ContentResolver contentResolver, Uri uri) {
        zzem zzemVar = new zzem(this, null);
        this.zze = zzemVar;
        this.zzf = new Object();
        this.zzh = new ArrayList();
        contentResolver.getClass();
        uri.getClass();
        this.zzc = contentResolver;
        this.zzd = uri;
        contentResolver.registerContentObserver(uri, false, zzemVar);
    }

    public static zzen zza(ContentResolver contentResolver, Uri uri) {
        zzen zzenVar;
        synchronized (zzen.class) {
            Map<Uri, zzen> map = zzb;
            zzenVar = map.get(uri);
            if (zzenVar == null) {
                try {
                    zzen zzenVar2 = new zzen(contentResolver, uri);
                    try {
                        map.put(uri, zzenVar2);
                    } catch (SecurityException unused) {
                    }
                    zzenVar = zzenVar2;
                } catch (SecurityException unused2) {
                }
            }
        }
        return zzenVar;
    }

    static synchronized void zzd() {
        for (zzen zzenVar : zzb.values()) {
            zzenVar.zzc.unregisterContentObserver(zzenVar.zze);
        }
        zzb.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Map<String, String> zzb() {
        Map<String, String> map;
        Map<String, String> map2;
        Map<String, String> map3 = this.zzg;
        Map<String, String> map4 = map3;
        if (map3 == null) {
            synchronized (this.zzf) {
                Map<String, String> map5 = this.zzg;
                map = map5;
                if (map5 == null) {
                    StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        try {
                            map2 = (Map) zzep.zza(new zzeq(this) { // from class: com.google.android.gms.internal.measurement.zzel
                                private final zzen zza;

                                {
                                    this.zza = this;
                                }

                                @Override // com.google.android.gms.internal.measurement.zzeq
                                public final Object zza() {
                                    return this.zza.zzf();
                                }
                            });
                        } finally {
                            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                        }
                    } catch (SQLiteException | IllegalStateException | SecurityException unused) {
                        Log.e("ConfigurationContentLoader", "PhenotypeFlag unable to load ContentProvider, using default values");
                        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                        map2 = null;
                    }
                    this.zzg = map2;
                    threadPolicyAllowThreadDiskReads = map2;
                    map = threadPolicyAllowThreadDiskReads;
                }
            }
            map4 = map;
        }
        return map4 != null ? map4 : Collections.emptyMap();
    }

    public final void zzc() {
        synchronized (this.zzf) {
            this.zzg = null;
            zzfg.zzc();
        }
        synchronized (this) {
            Iterator<zzeo> it = this.zzh.iterator();
            while (it.hasNext()) {
                it.next().zza();
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzer
    public final /* bridge */ /* synthetic */ Object zze(String str) {
        return zzb().get(str);
    }

    final /* synthetic */ Map zzf() {
        Cursor cursorQuery = this.zzc.query(this.zzd, zza, null, null, null);
        if (cursorQuery == null) {
            return Collections.emptyMap();
        }
        try {
            int count = cursorQuery.getCount();
            if (count == 0) {
                return Collections.emptyMap();
            }
            Map arrayMap = count <= 256 ? new ArrayMap(count) : new HashMap(count, 1.0f);
            while (cursorQuery.moveToNext()) {
                arrayMap.put(cursorQuery.getString(0), cursorQuery.getString(1));
            }
            return arrayMap;
        } finally {
            cursorQuery.close();
        }
    }
}
