package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.util.VisibleForTesting;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.AbstractC3795Cj5;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@VisibleForTesting
/* loaded from: classes3.dex */
public class TagManager {
    private static TagManager zza;
    private final zzfp zzb;
    private final Context zzc;
    private final DataLayer zzd;
    private final zzey zze;
    private final ConcurrentMap<String, Object> zzf;
    private final zzap zzg;

    @VisibleForTesting
    TagManager(Context context, zzfp zzfpVar, DataLayer dataLayer, zzey zzeyVar) {
        Context applicationContext = context.getApplicationContext();
        this.zzc = applicationContext;
        this.zze = zzeyVar;
        this.zzb = zzfpVar;
        this.zzf = new ConcurrentHashMap();
        this.zzd = dataLayer;
        dataLayer.zzg(new zzfm(this));
        dataLayer.zzg(new zzg(applicationContext));
        this.zzg = new zzap();
        AbstractC3795Cj5.j(applicationContext);
        applicationContext.registerComponentCallbacks(new zzfo(this));
        AbstractC3795Cj5.j(applicationContext);
        zzd.zzb(applicationContext);
    }

    @RecentlyNonNull
    public static TagManager getInstance(@RecentlyNonNull Context context) {
        TagManager tagManager;
        synchronized (TagManager.class) {
            try {
                if (zza == null) {
                    if (context == null) {
                        zzdh.zza("TagManager.getInstance requires non-null context.");
                        throw null;
                    }
                    zza = new TagManager(context, new zzfn(), new DataLayer(new zzbe(context)), zzff.zzg());
                }
                tagManager = zza;
            } catch (Throwable th) {
                throw th;
            }
        }
        return tagManager;
    }

    static /* bridge */ /* synthetic */ void zzb(TagManager tagManager, String str) {
        AbstractC3795Cj5.j(tagManager.zzf);
        Iterator<Object> it = tagManager.zzf.values().iterator();
        if (it.hasNext()) {
            AbstractC18350oW3.a(it.next());
            throw null;
        }
    }

    public void dispatch() {
        this.zze.zza();
    }

    final synchronized boolean zzd(Uri uri) {
        try {
            zzea zzeaVarZza = zzea.zza();
            if (!zzeaVarZza.zzd(uri)) {
                return false;
            }
            String strZzc = zzeaVarZza.zzc();
            int iZze = zzeaVarZza.zze();
            int i = iZze - 1;
            if (iZze == 0) {
                throw null;
            }
            if (i == 0) {
                AbstractC18350oW3.a(this.zzf.get(strZzc));
            } else if (i == 1 || i == 2) {
                Iterator<String> it = this.zzf.keySet().iterator();
                if (it.hasNext()) {
                    String next = it.next();
                    AbstractC18350oW3.a(this.zzf.get(next));
                    if (!next.equals(strZzc)) {
                        throw null;
                    }
                    zzeaVarZza.zzb();
                    throw null;
                }
            }
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }
}
