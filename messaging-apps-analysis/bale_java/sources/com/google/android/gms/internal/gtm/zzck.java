package com.google.android.gms.internal.gtm;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.analytics.CampaignTrackingReceiver;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.C13715gh8;
import ir.nasim.Fb8;
import ir.nasim.Gu8;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
final class zzck extends zzbs {
    private boolean zza;
    private final zzce zzb;
    private final zzfe zzc;
    private final zzfc zzd;
    private final zzcc zze;
    private long zzf;
    private final zzcw zzg;
    private final zzcw zzh;
    private final zzfo zzi;
    private long zzj;
    private boolean zzk;

    protected zzck(zzbv zzbvVar, zzbw zzbwVar) {
        super(zzbvVar);
        AbstractC3795Cj5.j(zzbwVar);
        this.zzf = Long.MIN_VALUE;
        this.zzd = new zzfc(zzbvVar);
        this.zzb = new zzce(zzbvVar);
        this.zzc = new zzfe(zzbvVar);
        this.zze = new zzcc(zzbvVar);
        this.zzi = new zzfo(zzC());
        this.zzg = new zzcg(this, zzbvVar);
        this.zzh = new zzch(this, zzbvVar);
    }

    private final void zzag() {
        zzcy zzcyVarZzy = zzy();
        if (zzcyVarZzy.zze()) {
            zzcyVarZzy.zza();
        }
    }

    private final void zzah() {
        if (this.zzg.zzh()) {
            zzO("All hits dispatched or no network/service. Going to power save mode");
        }
        this.zzg.zzf();
    }

    private final void zzai() {
        long jZzc;
        zzcy zzcyVarZzy = zzy();
        if (zzcyVarZzy.zzc() && !zzcyVarZzy.zze()) {
            Gu8.e();
            zzW();
            try {
                jZzc = this.zzb.zzc();
            } catch (SQLiteException e) {
                zzK("Failed to get min/max hit times from local store", e);
                jZzc = 0;
            }
            if (jZzc != 0) {
                long jAbs = Math.abs(zzC().currentTimeMillis() - jZzc);
                zzw();
                if (jAbs <= zzeu.zzn.zzb().longValue()) {
                    zzw();
                    zzP("Dispatch alarm scheduled (ms)", Long.valueOf(zzct.zzd()));
                    zzcyVarZzy.zzb();
                }
            }
        }
    }

    private final void zzaj(zzbx zzbxVar, zzaw zzawVar) {
        AbstractC3795Cj5.j(zzbxVar);
        AbstractC3795Cj5.j(zzawVar);
        C13715gh8 c13715gh8 = new C13715gh8(zzt());
        c13715gh8.d(zzbxVar.zzc());
        c13715gh8.e(zzbxVar.zzf());
        AbstractC18350oW3.a(c13715gh8.b().a(zzbe.class));
        throw null;
    }

    private final boolean zzak(String str) {
        return Fb8.a(zzo()).a(str) == 0;
    }

    static /* bridge */ /* synthetic */ void zzc(zzck zzckVar) {
        try {
            zzckVar.zzb.zza();
            zzckVar.zzae();
        } catch (SQLiteException e) {
            zzckVar.zzS("Failed to delete stale hits", e);
        }
        zzcw zzcwVar = zzckVar.zzh;
        zzckVar.zzw();
        zzcwVar.zzg(86400000L);
    }

    public final long zza() {
        long j = this.zzf;
        if (j != Long.MIN_VALUE) {
            return j;
        }
        zzw();
        long jLongValue = zzeu.zzi.zzb().longValue();
        zzft zzftVarZzB = zzB();
        zzftVarZzB.zzW();
        if (!zzftVarZzB.zzc) {
            return jLongValue;
        }
        zzB().zzW();
        return r0.zzd * 1000;
    }

    final void zzaa() {
        zzW();
        AbstractC3795Cj5.n(!this.zza, "Analytics backend already started");
        this.zza = true;
        zzq().f(new zzci(this));
    }

    protected final void zzab() {
        zzW();
        zzw();
        Gu8.e();
        Context contextZza = zzt().zza();
        if (!zzfi.zza(contextZza)) {
            zzR("AnalyticsReceiver is not registered or is disabled. Register the receiver for reliable dispatching on non-Google Play devices. See http://goo.gl/8Rd3yj for instructions.");
        } else if (!zzfn.zzh(contextZza)) {
            zzJ("AnalyticsService is not registered or is disabled. Analytics service at risk of not starting. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!CampaignTrackingReceiver.zzb(contextZza)) {
            zzR("CampaignTrackingReceiver is not registered, not exported or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
        }
        zzA().zza();
        if (!zzak("android.permission.ACCESS_NETWORK_STATE")) {
            zzJ("Missing required android.permission.ACCESS_NETWORK_STATE. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            zzad();
        }
        if (!zzak("android.permission.INTERNET")) {
            zzJ("Missing required android.permission.INTERNET. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            zzad();
        }
        if (zzfn.zzh(zzo())) {
            zzO("AnalyticsService registered in the app manifest and enabled");
        } else {
            zzw();
            zzR("AnalyticsService not registered in the app manifest. Hits might not be delivered reliably. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!this.zzk) {
            zzw();
            if (!this.zzb.zzac()) {
                zzi();
            }
        }
        zzae();
    }

    public final void zzad() {
        zzW();
        Gu8.e();
        this.zzk = true;
        this.zze.zzc();
        zzae();
    }

    public final void zzae() {
        long jMin;
        Gu8.e();
        zzW();
        if (!this.zzk) {
            zzw();
            if (zza() > 0) {
                if (this.zzb.zzac()) {
                    this.zzd.zzc();
                    zzah();
                    zzag();
                    return;
                }
                if (!zzeu.zzJ.zzb().booleanValue()) {
                    this.zzd.zza();
                    if (!this.zzd.zzd()) {
                        zzah();
                        zzag();
                        zzai();
                        return;
                    }
                }
                zzai();
                long jZza = zza();
                long jZzb = zzA().zzb();
                if (jZzb != 0) {
                    jMin = jZza - Math.abs(zzC().currentTimeMillis() - jZzb);
                    if (jMin <= 0) {
                        zzw();
                        jMin = Math.min(zzct.zze(), jZza);
                    }
                } else {
                    zzw();
                    jMin = Math.min(zzct.zze(), jZza);
                }
                zzP("Dispatch scheduled (ms)", Long.valueOf(jMin));
                if (!this.zzg.zzh()) {
                    this.zzg.zzg(jMin);
                    return;
                } else {
                    this.zzg.zze(Math.max(1L, jMin + this.zzg.zzb()));
                    return;
                }
            }
        }
        this.zzd.zzc();
        zzah();
        zzag();
    }

    protected final boolean zzaf() {
        boolean z;
        Gu8.e();
        zzW();
        zzO("Dispatching a batch of local hits");
        if (this.zze.zzg()) {
            z = false;
        } else {
            zzw();
            z = true;
        }
        boolean zZze = true ^ this.zzc.zze();
        if (z && zZze) {
            zzO("No network or service available. Will retry later");
            return false;
        }
        zzw();
        int iZzh = zzct.zzh();
        zzw();
        long jMax = Math.max(iZzh, zzct.zzg());
        ArrayList arrayList = new ArrayList();
        long jMax2 = 0;
        while (true) {
            try {
                try {
                    this.zzb.zzm();
                    arrayList.clear();
                    try {
                        List<zzex> listZzj = this.zzb.zzj(jMax);
                        if (listZzj.isEmpty()) {
                            zzO("Store is empty, nothing to dispatch");
                            zzah();
                            zzag();
                            try {
                                this.zzb.zzab();
                                this.zzb.zzaa();
                                return false;
                            } catch (SQLiteException e) {
                                zzK("Failed to commit local dispatch transaction", e);
                                zzah();
                                zzag();
                                return false;
                            }
                        }
                        zzP("Hits loaded from store. count", Integer.valueOf(listZzj.size()));
                        Iterator<zzex> it = listZzj.iterator();
                        while (it.hasNext()) {
                            if (it.next().zzb() == jMax2) {
                                zzL("Database contains successfully uploaded hit", Long.valueOf(jMax2), Integer.valueOf(listZzj.size()));
                                zzah();
                                zzag();
                                try {
                                    this.zzb.zzab();
                                    this.zzb.zzaa();
                                    return false;
                                } catch (SQLiteException e2) {
                                    zzK("Failed to commit local dispatch transaction", e2);
                                    zzah();
                                    zzag();
                                    return false;
                                }
                            }
                        }
                        if (this.zze.zzg()) {
                            zzw();
                            zzO("Service connected, sending hits to the service");
                            while (!listZzj.isEmpty()) {
                                zzex zzexVar = listZzj.get(0);
                                if (!this.zze.zzh(zzexVar)) {
                                    break;
                                }
                                jMax2 = Math.max(jMax2, zzexVar.zzb());
                                listZzj.remove(zzexVar);
                                zzG("Hit sent do device AnalyticsService for delivery", zzexVar);
                                try {
                                    this.zzb.zzn(zzexVar.zzb());
                                    arrayList.add(Long.valueOf(zzexVar.zzb()));
                                } catch (SQLiteException e3) {
                                    zzK("Failed to remove hit that was send for delivery", e3);
                                    zzah();
                                    zzag();
                                    try {
                                        this.zzb.zzab();
                                        this.zzb.zzaa();
                                        return false;
                                    } catch (SQLiteException e4) {
                                        zzK("Failed to commit local dispatch transaction", e4);
                                        zzah();
                                        zzag();
                                        return false;
                                    }
                                }
                            }
                        }
                        if (this.zzc.zze()) {
                            List<Long> listZzc = this.zzc.zzc(listZzj);
                            Iterator<Long> it2 = listZzc.iterator();
                            while (it2.hasNext()) {
                                jMax2 = Math.max(jMax2, it2.next().longValue());
                            }
                            try {
                                this.zzb.zzZ(listZzc);
                                arrayList.addAll(listZzc);
                            } catch (SQLiteException e5) {
                                zzK("Failed to remove successfully uploaded hits", e5);
                                zzah();
                                zzag();
                                try {
                                    this.zzb.zzab();
                                    this.zzb.zzaa();
                                    return false;
                                } catch (SQLiteException e6) {
                                    zzK("Failed to commit local dispatch transaction", e6);
                                    zzah();
                                    zzag();
                                    return false;
                                }
                            }
                        }
                        if (arrayList.isEmpty()) {
                            try {
                                this.zzb.zzab();
                                this.zzb.zzaa();
                                return false;
                            } catch (SQLiteException e7) {
                                zzK("Failed to commit local dispatch transaction", e7);
                                zzah();
                                zzag();
                                return false;
                            }
                        }
                        try {
                            this.zzb.zzab();
                            this.zzb.zzaa();
                        } catch (SQLiteException e8) {
                            zzK("Failed to commit local dispatch transaction", e8);
                            zzah();
                            zzag();
                            return false;
                        }
                    } catch (SQLiteException e9) {
                        zzS("Failed to read hits from persisted store", e9);
                        zzah();
                        zzag();
                        try {
                            this.zzb.zzab();
                            this.zzb.zzaa();
                            return false;
                        } catch (SQLiteException e10) {
                            zzK("Failed to commit local dispatch transaction", e10);
                            zzah();
                            zzag();
                            return false;
                        }
                    }
                } catch (Throwable th) {
                    this.zzb.zzab();
                    this.zzb.zzaa();
                    throw th;
                }
                this.zzb.zzab();
                this.zzb.zzaa();
                throw th;
            } catch (SQLiteException e11) {
                zzK("Failed to commit local dispatch transaction", e11);
                zzah();
                zzag();
                return false;
            }
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzbs
    protected final void zzd() {
        this.zzb.zzX();
        this.zzc.zzX();
        this.zze.zzX();
    }

    public final void zzf(zzcz zzczVar) {
        zzg(zzczVar, this.zzj);
    }

    public final void zzg(zzcz zzczVar, long j) {
        Gu8.e();
        zzW();
        long jZzb = zzA().zzb();
        zzG("Dispatching local hits. Elapsed time since last dispatch (ms)", Long.valueOf(jZzb != 0 ? Math.abs(zzC().currentTimeMillis() - jZzb) : -1L));
        zzw();
        zzi();
        try {
            zzaf();
            zzA().zzi();
            zzae();
            if (zzczVar != null) {
                zzczVar.zza(null);
            }
            if (this.zzj != j) {
                this.zzd.zzb();
            }
        } catch (Exception e) {
            zzK("Local dispatch failed", e);
            zzA().zzi();
            zzae();
            if (zzczVar != null) {
                zzczVar.zza(e);
            }
        }
    }

    protected final void zzi() {
        if (this.zzk) {
            return;
        }
        zzw();
        if (zzct.zzl() && !this.zze.zzg()) {
            zzw();
            if (this.zzi.zzc(zzeu.zzO.zzb().longValue())) {
                this.zzi.zzb();
                zzO("Connecting to service");
                if (this.zze.zzf()) {
                    zzO("Connected to service");
                    this.zzi.zza();
                    zzm();
                }
            }
        }
    }

    final void zzl() {
        Gu8.e();
        this.zzj = zzC().currentTimeMillis();
    }

    protected final void zzm() {
        Gu8.e();
        zzw();
        Gu8.e();
        zzW();
        zzE();
        zzw();
        if (!zzct.zzl()) {
            zzR("Service client disabled. Can't dispatch local hits to device AnalyticsService");
        }
        if (!this.zze.zzg()) {
            zzO("Service not connected");
            return;
        }
        if (this.zzb.zzac()) {
            return;
        }
        zzO("Dispatching local hits to device AnalyticsService");
        while (true) {
            try {
                zzce zzceVar = this.zzb;
                zzw();
                List<zzex> listZzj = zzceVar.zzj(zzct.zzh());
                if (listZzj.isEmpty()) {
                    zzae();
                    return;
                }
                while (!listZzj.isEmpty()) {
                    zzex zzexVar = listZzj.get(0);
                    if (!this.zze.zzh(zzexVar)) {
                        zzae();
                        return;
                    }
                    listZzj.remove(zzexVar);
                    try {
                        this.zzb.zzn(zzexVar.zzb());
                    } catch (SQLiteException e) {
                        zzK("Failed to remove hit that was send for delivery", e);
                        zzah();
                        zzag();
                        return;
                    }
                }
            } catch (SQLiteException e2) {
                zzK("Failed to read hits from store", e2);
                zzah();
                zzag();
                return;
            }
        }
    }

    public final void zzn(String str) {
        AbstractC3795Cj5.f(str);
        Gu8.e();
        zzE();
        zzaw zzawVarZzb = zzfs.zzb(zzz(), str);
        if (zzawVarZzb == null) {
            zzS("Parsing failed. Ignoring invalid campaign data", str);
            return;
        }
        String strZzg = zzA().zzg();
        if (str.equals(strZzg)) {
            zzR("Ignoring duplicate install campaign");
            return;
        }
        if (!TextUtils.isEmpty(strZzg)) {
            zzL("Ignoring multiple install campaigns. original, new", strZzg, str);
            return;
        }
        zzA().zzh(str);
        zzfo zzfoVarZzf = zzA().zzf();
        zzw();
        if (zzfoVarZzf.zzc(zzct.zzc())) {
            zzS("Campaign received too late, ignoring", zzawVarZzb);
            return;
        }
        zzG("Received installation campaign", zzawVarZzb);
        zzce zzceVar = this.zzb;
        zzceVar.zzW();
        Gu8.e();
        SQLiteDatabase sQLiteDatabaseZzf = zzceVar.zzf();
        Cursor cursorQuery = null;
        try {
            try {
                zzceVar.zzw();
                int iIntValue = zzeu.zzh.zzb().intValue();
                cursorQuery = sQLiteDatabaseZzf.query("properties", new String[]{"cid", "tid", "adid", "hits_count", "params"}, "app_uid=?", new String[]{"0"}, null, null, null, String.valueOf(iIntValue));
                ArrayList arrayList = new ArrayList();
                if (cursorQuery.moveToFirst()) {
                    do {
                        String string = cursorQuery.getString(0);
                        String string2 = cursorQuery.getString(1);
                        boolean z = cursorQuery.getInt(2) != 0;
                        long j = cursorQuery.getInt(3);
                        Map<String, String> mapZzl = zzceVar.zzl(cursorQuery.getString(4));
                        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
                            zzceVar.zzT("Read property with empty client id or tracker id", string, string2);
                        } else {
                            arrayList.add(new zzbx(0L, string, string2, z, j, mapZzl));
                        }
                    } while (cursorQuery.moveToNext());
                }
                if (arrayList.size() >= iIntValue) {
                    zzceVar.zzR("Sending hits to too many properties. Campaign report might be incorrect");
                }
                cursorQuery.close();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    zzaj((zzbx) it.next(), zzawVarZzb);
                }
            } catch (SQLiteException e) {
                zzceVar.zzK("Error loading hits from the database", e);
                throw e;
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }
}
