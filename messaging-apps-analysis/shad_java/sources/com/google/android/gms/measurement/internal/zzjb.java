package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.measurement.zzlc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import org.rbmain.messenger.MessagesController;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzjb extends zzf {
    private final zzja zza;
    private zzdz zzb;
    private volatile Boolean zzc;
    private final zzal zzd;
    private final zzjr zze;
    private final List<Runnable> zzf;
    private final zzal zzg;

    protected zzjb(zzfl zzflVar) {
        super(zzflVar);
        this.zzf = new ArrayList();
        this.zze = new zzjr(zzflVar.zzax());
        this.zza = new zzja(this);
        this.zzd = new zzil(this, zzflVar);
        this.zzg = new zzin(this, zzflVar);
    }

    static /* synthetic */ void zzJ(zzjb zzjbVar, ComponentName componentName) {
        zzjbVar.zzg();
        if (zzjbVar.zzb != null) {
            zzjbVar.zzb = null;
            zzjbVar.zzx.zzat().zzk().zzb("Disconnected from device MeasurementService", componentName);
            zzjbVar.zzg();
            zzjbVar.zzB();
        }
    }

    static /* synthetic */ zzdz zzK(zzjb zzjbVar, zzdz zzdzVar) {
        zzjbVar.zzb = null;
        return null;
    }

    private final boolean zzO() {
        this.zzx.zzas();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzP() {
        zzg();
        this.zze.zza();
        zzal zzalVar = this.zzd;
        this.zzx.zzc();
        zzalVar.zzb(zzdw.zzI.zzb(null).longValue());
    }

    private final void zzQ(Runnable runnable) throws IllegalStateException {
        zzg();
        if (zzh()) {
            runnable.run();
            return;
        }
        int size = this.zzf.size();
        this.zzx.zzc();
        if (size >= 1000) {
            this.zzx.zzat().zzb().zza("Discarding data. Max runnable queue size reached");
            return;
        }
        this.zzf.add(runnable);
        this.zzg.zzb(60000L);
        zzB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzR() {
        zzg();
        this.zzx.zzat().zzk().zzb("Processing queued up service tasks", Integer.valueOf(this.zzf.size()));
        Iterator<Runnable> it = this.zzf.iterator();
        while (it.hasNext()) {
            try {
                it.next().run();
            } catch (Exception e) {
                this.zzx.zzat().zzb().zzb("Task exception while flushing queue", e);
            }
        }
        this.zzf.clear();
        this.zzg.zzd();
    }

    private final zzp zzS(boolean z) {
        Pair<String, Long> pairZzb;
        this.zzx.zzas();
        zzea zzeaVarZzA = this.zzx.zzA();
        String string = null;
        if (z) {
            zzei zzeiVarZzat = this.zzx.zzat();
            if (zzeiVarZzat.zzx.zzd().zzb != null && (pairZzb = zzeiVarZzat.zzx.zzd().zzb.zzb()) != null && pairZzb != zzex.zza) {
                String strValueOf = String.valueOf(pairZzb.second);
                String str = (String) pairZzb.first;
                StringBuilder sb = new StringBuilder(strValueOf.length() + 1 + String.valueOf(str).length());
                sb.append(strValueOf);
                sb.append(":");
                sb.append(str);
                string = sb.toString();
            }
        }
        return zzeaVarZzA.zzh(string);
    }

    public final void zzA(Bundle bundle) {
        zzg();
        zzb();
        zzQ(new zzik(this, zzS(false), bundle));
    }

    final void zzB() {
        zzg();
        zzb();
        if (zzh()) {
            return;
        }
        if (zzD()) {
            this.zza.zzc();
            return;
        }
        if (this.zzx.zzc().zzy()) {
            return;
        }
        this.zzx.zzas();
        List<ResolveInfo> listQueryIntentServices = this.zzx.zzaw().getPackageManager().queryIntentServices(new Intent().setClassName(this.zzx.zzaw(), "com.google.android.gms.measurement.AppMeasurementService"), MessagesController.UPDATE_MASK_CHECK);
        if (listQueryIntentServices == null || listQueryIntentServices.size() <= 0) {
            this.zzx.zzat().zzb().zza("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            return;
        }
        Intent intent = new Intent("com.google.android.gms.measurement.START");
        Context contextZzaw = this.zzx.zzaw();
        this.zzx.zzas();
        intent.setComponent(new ComponentName(contextZzaw, "com.google.android.gms.measurement.AppMeasurementService"));
        this.zza.zza(intent);
    }

    final Boolean zzC() {
        return this.zzc;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x012b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final boolean zzD() {
        /*
            Method dump skipped, instructions count: 336
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjb.zzD():boolean");
    }

    protected final void zzE(zzdz zzdzVar) {
        zzg();
        Preconditions.checkNotNull(zzdzVar);
        this.zzb = zzdzVar;
        zzP();
        zzR();
    }

    public final void zzF() {
        zzg();
        zzb();
        this.zza.zzb();
        try {
            ConnectionTracker.getInstance().unbindService(this.zzx.zzaw(), this.zza);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.zzb = null;
    }

    public final void zzG(com.google.android.gms.internal.measurement.zzs zzsVar, zzas zzasVar, String str) throws IllegalStateException {
        zzg();
        zzb();
        if (this.zzx.zzl().zzaa(12451000) == 0) {
            zzQ(new zzim(this, zzasVar, str, zzsVar));
        } else {
            this.zzx.zzat().zze().zza("Not bundling data. Service unavailable or out of date");
            this.zzx.zzl().zzag(zzsVar, new byte[0]);
        }
    }

    final boolean zzH() {
        zzg();
        zzb();
        if (this.zzx.zzc().zzn(null, zzdw.zzay)) {
            return !zzD() || this.zzx.zzl().zzZ() >= zzdw.zzaz.zzb(null).intValue();
        }
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    protected final boolean zze() {
        return false;
    }

    public final boolean zzh() {
        zzg();
        zzb();
        return this.zzb != null;
    }

    protected final void zzi() {
        zzg();
        zzb();
        zzQ(new zzio(this, zzS(true)));
    }

    protected final void zzj(boolean z) {
        zzlc.zzb();
        if (this.zzx.zzc().zzn(null, zzdw.zzaw)) {
            zzg();
            zzb();
            if (z) {
                zzO();
                this.zzx.zzn().zzh();
            }
            if (zzH()) {
                zzQ(new zzip(this, zzS(false)));
            }
        }
    }

    final void zzk(zzdz zzdzVar, AbstractSafeParcelable abstractSafeParcelable, zzp zzpVar) {
        int size;
        zzg();
        zzb();
        zzO();
        this.zzx.zzc();
        int i = 0;
        int i2 = 100;
        while (i < 1001 && i2 == 100) {
            ArrayList arrayList = new ArrayList();
            List<AbstractSafeParcelable> listZzl = this.zzx.zzn().zzl(100);
            if (listZzl != null) {
                arrayList.addAll(listZzl);
                size = listZzl.size();
            } else {
                size = 0;
            }
            if (abstractSafeParcelable != null && size < 100) {
                arrayList.add(abstractSafeParcelable);
            }
            int size2 = arrayList.size();
            for (int i3 = 0; i3 < size2; i3++) {
                AbstractSafeParcelable abstractSafeParcelable2 = (AbstractSafeParcelable) arrayList.get(i3);
                if (abstractSafeParcelable2 instanceof zzas) {
                    try {
                        zzdzVar.zzd((zzas) abstractSafeParcelable2, zzpVar);
                    } catch (RemoteException e) {
                        this.zzx.zzat().zzb().zzb("Failed to send event to the service", e);
                    }
                } else if (abstractSafeParcelable2 instanceof zzkg) {
                    try {
                        zzdzVar.zze((zzkg) abstractSafeParcelable2, zzpVar);
                    } catch (RemoteException e2) {
                        this.zzx.zzat().zzb().zzb("Failed to send user property to the service", e2);
                    }
                } else if (abstractSafeParcelable2 instanceof zzaa) {
                    try {
                        zzdzVar.zzm((zzaa) abstractSafeParcelable2, zzpVar);
                    } catch (RemoteException e3) {
                        this.zzx.zzat().zzb().zzb("Failed to send conditional user property to the service", e3);
                    }
                } else {
                    this.zzx.zzat().zzb().zza("Discarding data. Unrecognized parcel type.");
                }
            }
            i++;
            i2 = size;
        }
    }

    protected final void zzl(zzas zzasVar, String str) {
        Preconditions.checkNotNull(zzasVar);
        zzg();
        zzb();
        zzO();
        zzQ(new zziq(this, true, zzS(true), this.zzx.zzn().zzi(zzasVar), zzasVar, str));
    }

    protected final void zzm(zzaa zzaaVar) throws IllegalStateException {
        Preconditions.checkNotNull(zzaaVar);
        zzg();
        zzb();
        this.zzx.zzas();
        zzQ(new zzir(this, true, zzS(true), this.zzx.zzn().zzk(zzaaVar), new zzaa(zzaaVar), zzaaVar));
    }

    protected final void zzn(AtomicReference<List<zzaa>> atomicReference, String str, String str2, String str3) throws IllegalStateException {
        zzg();
        zzb();
        zzQ(new zzis(this, atomicReference, null, str2, str3, zzS(false)));
    }

    protected final void zzo(com.google.android.gms.internal.measurement.zzs zzsVar, String str, String str2) throws IllegalStateException {
        zzg();
        zzb();
        zzQ(new zzit(this, str, str2, zzS(false), zzsVar));
    }

    protected final void zzq(AtomicReference<List<zzkg>> atomicReference, String str, String str2, String str3, boolean z) throws IllegalStateException {
        zzg();
        zzb();
        zzQ(new zziu(this, atomicReference, null, str2, str3, zzS(false), z));
    }

    protected final void zzr(com.google.android.gms.internal.measurement.zzs zzsVar, String str, String str2, boolean z) throws IllegalStateException {
        zzg();
        zzb();
        zzQ(new zzic(this, str, str2, zzS(false), z, zzsVar));
    }

    protected final void zzs(zzkg zzkgVar) {
        zzg();
        zzb();
        zzO();
        zzQ(new zzid(this, zzS(true), this.zzx.zzn().zzj(zzkgVar), zzkgVar));
    }

    protected final void zzu() {
        zzg();
        zzb();
        zzp zzpVarZzS = zzS(false);
        zzO();
        this.zzx.zzn().zzh();
        zzQ(new zzif(this, zzpVarZzS));
    }

    public final void zzv(AtomicReference<String> atomicReference) {
        zzg();
        zzb();
        zzQ(new zzig(this, atomicReference, zzS(false)));
    }

    public final void zzx(com.google.android.gms.internal.measurement.zzs zzsVar) throws IllegalStateException {
        zzg();
        zzb();
        zzQ(new zzih(this, zzS(false), zzsVar));
    }

    protected final void zzy() throws IllegalStateException {
        zzg();
        zzb();
        zzp zzpVarZzS = zzS(true);
        this.zzx.zzn().zzm();
        zzQ(new zzii(this, zzpVarZzS));
    }

    protected final void zzz(zzhu zzhuVar) {
        zzg();
        zzb();
        zzQ(new zzij(this, zzhuVar));
    }
}
