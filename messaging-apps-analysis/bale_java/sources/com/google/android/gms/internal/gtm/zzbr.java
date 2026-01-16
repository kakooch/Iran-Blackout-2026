package com.google.android.gms.internal.gtm;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.Gu8;
import ir.nasim.OV0;

/* loaded from: classes3.dex */
public abstract class zzbr {
    private final zzbv zza;

    protected zzbr(zzbv zzbvVar) {
        AbstractC3795Cj5.j(zzbvVar);
        this.zza = zzbvVar;
    }

    protected static String zzD(String str, Object obj, Object obj2, Object obj3) {
        String str2 = "";
        if (str == null) {
            str = "";
        }
        String strZza = zza(obj);
        String strZza2 = zza(obj2);
        String strZza3 = zza(obj3);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(strZza)) {
            sb.append(str2);
            sb.append(strZza);
            str2 = ", ";
        }
        if (TextUtils.isEmpty(strZza2)) {
            str3 = str2;
        } else {
            sb.append(str2);
            sb.append(strZza2);
        }
        if (!TextUtils.isEmpty(strZza3)) {
            sb.append(str3);
            sb.append(strZza3);
        }
        return sb.toString();
    }

    public static final boolean zzV() {
        return Log.isLoggable(zzeu.zzc.zzb(), 2);
    }

    private static String zza(Object obj) {
        return obj == null ? "" : obj instanceof String ? (String) obj : obj instanceof Boolean ? obj == Boolean.TRUE ? "true" : "false" : obj instanceof Throwable ? ((Throwable) obj).toString() : obj.toString();
    }

    private final void zzb(int i, String str, Object obj, Object obj2, Object obj3) {
        zzbv zzbvVar = this.zza;
        zzfb zzfbVarZzn = zzbvVar != null ? zzbvVar.zzn() : null;
        if (zzfbVarZzn == null) {
            String strZzb = zzeu.zzc.zzb();
            if (Log.isLoggable(strZzb, i)) {
                Log.println(i, strZzb, zzD(str, obj, obj2, obj3));
                return;
            }
            return;
        }
        String strZzb2 = zzeu.zzc.zzb();
        if (Log.isLoggable(strZzb2, i)) {
            Log.println(i, strZzb2, zzD(str, obj, obj2, obj3));
        }
        if (i >= 5) {
            zzfbVarZzn.zze(i, str, obj, obj2, obj3);
        }
    }

    protected final zzfh zzA() {
        return this.zza.zzo();
    }

    protected final zzft zzB() {
        return this.zza.zzq();
    }

    protected final OV0 zzC() {
        return this.zza.zzr();
    }

    protected final void zzE() {
        this.zza.zzj();
    }

    public final void zzF(String str) {
        zzb(3, str, null, null, null);
    }

    public final void zzG(String str, Object obj) {
        zzb(3, str, obj, null, null);
    }

    public final void zzH(String str, Object obj, Object obj2) {
        zzb(3, str, obj, obj2, null);
    }

    public final void zzI(String str, Object obj, Object obj2, Object obj3) {
        zzb(3, "POST compressed size, ratio %, url", obj, obj2, obj3);
    }

    public final void zzJ(String str) {
        zzb(6, str, null, null, null);
    }

    public final void zzK(String str, Object obj) {
        zzb(6, str, obj, null, null);
    }

    public final void zzL(String str, Object obj, Object obj2) {
        zzb(6, str, obj, obj2, null);
    }

    public final void zzM(String str) {
        zzb(4, str, null, null, null);
    }

    public final void zzO(String str) {
        zzb(2, str, null, null, null);
    }

    public final void zzP(String str, Object obj) {
        zzb(2, str, obj, null, null);
    }

    public final void zzQ(String str, Object obj, Object obj2) {
        zzb(2, str, obj, obj2, null);
    }

    public final void zzR(String str) {
        zzb(5, str, null, null, null);
    }

    public final void zzS(String str, Object obj) {
        zzb(5, str, obj, null, null);
    }

    public final void zzT(String str, Object obj, Object obj2) {
        zzb(5, str, obj, obj2, null);
    }

    public final void zzU(String str, Object obj, Object obj2, Object obj3) {
        zzb(5, "Deleted fewer hits then expected", obj, obj2, obj3);
    }

    protected final Context zzo() {
        return this.zza.zza();
    }

    protected final Gu8 zzq() {
        return this.zza.zzd();
    }

    protected final zzbq zzs() {
        return this.zza.zzf();
    }

    public final zzbv zzt() {
        return this.zza;
    }

    protected final zzct zzw() {
        return this.zza.zzj();
    }

    protected final zzcy zzy() {
        return this.zza.zzl();
    }

    protected final zzfb zzz() {
        return this.zza.zzm();
    }
}
