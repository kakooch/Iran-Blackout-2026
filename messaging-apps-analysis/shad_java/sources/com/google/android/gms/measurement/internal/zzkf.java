package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import io.github.inflationx.calligraphy3.BuildConfig;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import org.rbmain.messenger.NotificationBadge;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzkf extends zzjv {
    zzkf(zzkd zzkdVar) {
        super(zzkdVar);
    }

    static final Object zzA(com.google.android.gms.internal.measurement.zzdb zzdbVar, String str) {
        com.google.android.gms.internal.measurement.zzdf zzdfVarZzz = zzz(zzdbVar, str);
        if (zzdfVarZzz == null) {
            return null;
        }
        if (zzdfVarZzz.zzc()) {
            return zzdfVarZzz.zzd();
        }
        if (zzdfVarZzz.zze()) {
            return Long.valueOf(zzdfVarZzz.zzf());
        }
        if (zzdfVarZzz.zzi()) {
            return Double.valueOf(zzdfVarZzz.zzj());
        }
        if (zzdfVarZzz.zzm() <= 0) {
            return null;
        }
        List<com.google.android.gms.internal.measurement.zzdf> listZzk = zzdfVarZzz.zzk();
        ArrayList arrayList = new ArrayList();
        for (com.google.android.gms.internal.measurement.zzdf zzdfVar : listZzk) {
            if (zzdfVar != null) {
                Bundle bundle = new Bundle();
                for (com.google.android.gms.internal.measurement.zzdf zzdfVar2 : zzdfVar.zzk()) {
                    if (zzdfVar2.zzc()) {
                        bundle.putString(zzdfVar2.zzb(), zzdfVar2.zzd());
                    } else if (zzdfVar2.zze()) {
                        bundle.putLong(zzdfVar2.zzb(), zzdfVar2.zzf());
                    } else if (zzdfVar2.zzi()) {
                        bundle.putDouble(zzdfVar2.zzb(), zzdfVar2.zzj());
                    }
                }
                if (!bundle.isEmpty()) {
                    arrayList.add(bundle);
                }
            }
        }
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    private final void zzB(StringBuilder sb, int i, List<com.google.android.gms.internal.measurement.zzdf> list) {
        if (list == null) {
            return;
        }
        int i2 = i + 1;
        for (com.google.android.gms.internal.measurement.zzdf zzdfVar : list) {
            if (zzdfVar != null) {
                zzD(sb, i2);
                sb.append("param {\n");
                zzG(sb, i2, "name", zzdfVar.zza() ? this.zzx.zzm().zzd(zzdfVar.zzb()) : null);
                zzG(sb, i2, "string_value", zzdfVar.zzc() ? zzdfVar.zzd() : null);
                zzG(sb, i2, "int_value", zzdfVar.zze() ? Long.valueOf(zzdfVar.zzf()) : null);
                zzG(sb, i2, "double_value", zzdfVar.zzi() ? Double.valueOf(zzdfVar.zzj()) : null);
                if (zzdfVar.zzm() > 0) {
                    zzB(sb, i2, zzdfVar.zzk());
                }
                zzD(sb, i2);
                sb.append("}\n");
            }
        }
    }

    private final void zzC(StringBuilder sb, int i, com.google.android.gms.internal.measurement.zzby zzbyVar) {
        if (zzbyVar == null) {
            return;
        }
        zzD(sb, i);
        sb.append("filter {\n");
        if (zzbyVar.zze()) {
            zzG(sb, i, "complement", Boolean.valueOf(zzbyVar.zzf()));
        }
        if (zzbyVar.zzg()) {
            zzG(sb, i, "param_name", this.zzx.zzm().zzd(zzbyVar.zzh()));
        }
        if (zzbyVar.zza()) {
            int i2 = i + 1;
            com.google.android.gms.internal.measurement.zzck zzckVarZzb = zzbyVar.zzb();
            if (zzckVarZzb != null) {
                zzD(sb, i2);
                sb.append("string_filter {\n");
                if (zzckVarZzb.zza()) {
                    zzG(sb, i2, "match_type", zzckVarZzb.zzb().name());
                }
                if (zzckVarZzb.zzc()) {
                    zzG(sb, i2, "expression", zzckVarZzb.zzd());
                }
                if (zzckVarZzb.zze()) {
                    zzG(sb, i2, "case_sensitive", Boolean.valueOf(zzckVarZzb.zzf()));
                }
                if (zzckVarZzb.zzh() > 0) {
                    zzD(sb, i2 + 1);
                    sb.append("expression_list {\n");
                    for (String str : zzckVarZzb.zzg()) {
                        zzD(sb, i2 + 2);
                        sb.append(str);
                        sb.append("\n");
                    }
                    sb.append("}\n");
                }
                zzD(sb, i2);
                sb.append("}\n");
            }
        }
        if (zzbyVar.zzc()) {
            zzH(sb, i + 1, "number_filter", zzbyVar.zzd());
        }
        zzD(sb, i);
        sb.append("}\n");
    }

    private static final void zzD(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("  ");
        }
    }

    private static final String zzE(boolean z, boolean z2, boolean z3) {
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append("Dynamic ");
        }
        if (z2) {
            sb.append("Sequence ");
        }
        if (z3) {
            sb.append("Session-Scoped ");
        }
        return sb.toString();
    }

    private static final void zzF(StringBuilder sb, int i, String str, com.google.android.gms.internal.measurement.zzdq zzdqVar, String str2) {
        if (zzdqVar == null) {
            return;
        }
        zzD(sb, 3);
        sb.append(str);
        sb.append(" {\n");
        if (zzdqVar.zzd() != 0) {
            zzD(sb, 4);
            sb.append("results: ");
            int i2 = 0;
            for (Long l : zzdqVar.zzc()) {
                int i3 = i2 + 1;
                if (i2 != 0) {
                    sb.append(", ");
                }
                sb.append(l);
                i2 = i3;
            }
            sb.append('\n');
        }
        if (zzdqVar.zzb() != 0) {
            zzD(sb, 4);
            sb.append("status: ");
            int i4 = 0;
            for (Long l2 : zzdqVar.zza()) {
                int i5 = i4 + 1;
                if (i4 != 0) {
                    sb.append(", ");
                }
                sb.append(l2);
                i4 = i5;
            }
            sb.append('\n');
        }
        if (zzdqVar.zzf() != 0) {
            zzD(sb, 4);
            sb.append("dynamic_filter_timestamps: {");
            int i6 = 0;
            for (com.google.android.gms.internal.measurement.zzcz zzczVar : zzdqVar.zze()) {
                int i7 = i6 + 1;
                if (i6 != 0) {
                    sb.append(", ");
                }
                sb.append(zzczVar.zza() ? Integer.valueOf(zzczVar.zzb()) : null);
                sb.append(":");
                sb.append(zzczVar.zzc() ? Long.valueOf(zzczVar.zzd()) : null);
                i6 = i7;
            }
            sb.append("}\n");
        }
        if (zzdqVar.zzi() != 0) {
            zzD(sb, 4);
            sb.append("sequence_filter_timestamps: {");
            int i8 = 0;
            for (com.google.android.gms.internal.measurement.zzds zzdsVar : zzdqVar.zzh()) {
                int i9 = i8 + 1;
                if (i8 != 0) {
                    sb.append(", ");
                }
                sb.append(zzdsVar.zza() ? Integer.valueOf(zzdsVar.zzb()) : null);
                sb.append(": [");
                Iterator<Long> it = zzdsVar.zzc().iterator();
                int i10 = 0;
                while (it.hasNext()) {
                    long jLongValue = it.next().longValue();
                    int i11 = i10 + 1;
                    if (i10 != 0) {
                        sb.append(", ");
                    }
                    sb.append(jLongValue);
                    i10 = i11;
                }
                sb.append("]");
                i8 = i9;
            }
            sb.append("}\n");
        }
        zzD(sb, 3);
        sb.append("}\n");
    }

    private static final void zzG(StringBuilder sb, int i, String str, Object obj) {
        if (obj == null) {
            return;
        }
        zzD(sb, i + 1);
        sb.append(str);
        sb.append(": ");
        sb.append(obj);
        sb.append('\n');
    }

    private static final void zzH(StringBuilder sb, int i, String str, com.google.android.gms.internal.measurement.zzcd zzcdVar) {
        if (zzcdVar == null) {
            return;
        }
        zzD(sb, i);
        sb.append(str);
        sb.append(" {\n");
        if (zzcdVar.zza()) {
            zzG(sb, i, "comparison_type", zzcdVar.zzb().name());
        }
        if (zzcdVar.zzc()) {
            zzG(sb, i, "match_as_float", Boolean.valueOf(zzcdVar.zzd()));
        }
        if (zzcdVar.zze()) {
            zzG(sb, i, "comparison_value", zzcdVar.zzf());
        }
        if (zzcdVar.zzg()) {
            zzG(sb, i, "min_comparison_value", zzcdVar.zzh());
        }
        if (zzcdVar.zzi()) {
            zzG(sb, i, "max_comparison_value", zzcdVar.zzj());
        }
        zzD(sb, i);
        sb.append("}\n");
    }

    static boolean zzl(String str) {
        return str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    static boolean zzm(List<Long> list, int i) {
        if (i < list.size() * 64) {
            return ((1 << (i % 64)) & list.get(i / 64).longValue()) != 0;
        }
        return false;
    }

    static List<Long> zzn(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            long j = 0;
            for (int i2 = 0; i2 < 64; i2++) {
                int i3 = (i * 64) + i2;
                if (i3 >= bitSet.length()) {
                    break;
                }
                if (bitSet.get(i3)) {
                    j |= 1 << i2;
                }
            }
            arrayList.add(Long.valueOf(j));
        }
        return arrayList;
    }

    static <Builder extends com.google.android.gms.internal.measurement.zziw> Builder zzt(Builder builder, byte[] bArr) throws com.google.android.gms.internal.measurement.zzic {
        com.google.android.gms.internal.measurement.zzhe zzheVarZzb = com.google.android.gms.internal.measurement.zzhe.zzb();
        return zzheVarZzb != null ? (Builder) builder.zzav(bArr, zzheVarZzb) : (Builder) builder.zzaw(bArr);
    }

    static int zzu(com.google.android.gms.internal.measurement.zzdi zzdiVar, String str) {
        for (int i = 0; i < zzdiVar.zzk(); i++) {
            if (str.equals(zzdiVar.zzl(i).zzc())) {
                return i;
            }
        }
        return -1;
    }

    static List<com.google.android.gms.internal.measurement.zzdf> zzv(Bundle[] bundleArr) {
        ArrayList arrayList = new ArrayList();
        for (Bundle bundle : bundleArr) {
            if (bundle != null) {
                com.google.android.gms.internal.measurement.zzde zzdeVarZzn = com.google.android.gms.internal.measurement.zzdf.zzn();
                for (String str : bundle.keySet()) {
                    com.google.android.gms.internal.measurement.zzde zzdeVarZzn2 = com.google.android.gms.internal.measurement.zzdf.zzn();
                    zzdeVarZzn2.zza(str);
                    Object obj = bundle.get(str);
                    if (obj instanceof Long) {
                        zzdeVarZzn2.zzd(((Long) obj).longValue());
                    } else if (obj instanceof String) {
                        zzdeVarZzn2.zzb((String) obj);
                    } else if (obj instanceof Double) {
                        zzdeVarZzn2.zzf(((Double) obj).doubleValue());
                    }
                    zzdeVarZzn.zzi(zzdeVarZzn2);
                }
                if (zzdeVarZzn.zzh() > 0) {
                    arrayList.add(zzdeVarZzn.zzaA());
                }
            }
        }
        return arrayList;
    }

    static final void zzx(com.google.android.gms.internal.measurement.zzda zzdaVar, String str, Object obj) {
        List<com.google.android.gms.internal.measurement.zzdf> listZza = zzdaVar.zza();
        int i = 0;
        while (true) {
            if (i >= listZza.size()) {
                i = -1;
                break;
            } else if (str.equals(listZza.get(i).zzb())) {
                break;
            } else {
                i++;
            }
        }
        com.google.android.gms.internal.measurement.zzde zzdeVarZzn = com.google.android.gms.internal.measurement.zzdf.zzn();
        zzdeVarZzn.zza(str);
        if (obj instanceof Long) {
            zzdeVarZzn.zzd(((Long) obj).longValue());
        } else if (obj instanceof String) {
            zzdeVarZzn.zzb((String) obj);
        } else if (obj instanceof Double) {
            zzdeVarZzn.zzf(((Double) obj).doubleValue());
        } else if (obj instanceof Bundle[]) {
            zzdeVarZzn.zzj(zzv((Bundle[]) obj));
        }
        if (i >= 0) {
            zzdaVar.zze(i, zzdeVarZzn);
        } else {
            zzdaVar.zzg(zzdeVarZzn);
        }
    }

    static final boolean zzy(zzas zzasVar, zzp zzpVar) {
        Preconditions.checkNotNull(zzasVar);
        Preconditions.checkNotNull(zzpVar);
        return (TextUtils.isEmpty(zzpVar.zzb) && TextUtils.isEmpty(zzpVar.zzq)) ? false : true;
    }

    static final com.google.android.gms.internal.measurement.zzdf zzz(com.google.android.gms.internal.measurement.zzdb zzdbVar, String str) {
        for (com.google.android.gms.internal.measurement.zzdf zzdfVar : zzdbVar.zza()) {
            if (zzdfVar.zzb().equals(str)) {
                return zzdfVar;
            }
        }
        return null;
    }

    @Override // com.google.android.gms.measurement.internal.zzjv
    protected final boolean zzaz() {
        return false;
    }

    final void zzc(com.google.android.gms.internal.measurement.zzdt zzdtVar, Object obj) {
        Preconditions.checkNotNull(obj);
        zzdtVar.zzd();
        zzdtVar.zzf();
        zzdtVar.zzh();
        if (obj instanceof String) {
            zzdtVar.zzc((String) obj);
            return;
        }
        if (obj instanceof Long) {
            zzdtVar.zze(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            zzdtVar.zzg(((Double) obj).doubleValue());
        } else {
            this.zzx.zzat().zzb().zzb("Ignoring invalid (type) user attribute value", obj);
        }
    }

    final void zzd(com.google.android.gms.internal.measurement.zzde zzdeVar, Object obj) {
        Preconditions.checkNotNull(obj);
        zzdeVar.zzc();
        zzdeVar.zze();
        zzdeVar.zzg();
        zzdeVar.zzk();
        if (obj instanceof String) {
            zzdeVar.zzb((String) obj);
            return;
        }
        if (obj instanceof Long) {
            zzdeVar.zzd(((Long) obj).longValue());
            return;
        }
        if (obj instanceof Double) {
            zzdeVar.zzf(((Double) obj).doubleValue());
        } else if (obj instanceof Bundle[]) {
            zzdeVar.zzj(zzv((Bundle[]) obj));
        } else {
            this.zzx.zzat().zzb().zzb("Ignoring invalid (type) event param value", obj);
        }
    }

    final com.google.android.gms.internal.measurement.zzdb zzf(zzan zzanVar) {
        com.google.android.gms.internal.measurement.zzda zzdaVarZzk = com.google.android.gms.internal.measurement.zzdb.zzk();
        zzdaVarZzk.zzq(zzanVar.zze);
        zzap zzapVar = new zzap(zzanVar.zzf);
        while (zzapVar.hasNext()) {
            String next = zzapVar.next();
            com.google.android.gms.internal.measurement.zzde zzdeVarZzn = com.google.android.gms.internal.measurement.zzdf.zzn();
            zzdeVarZzn.zza(next);
            Object objZza = zzanVar.zzf.zza(next);
            Preconditions.checkNotNull(objZza);
            zzd(zzdeVarZzn, objZza);
            zzdaVarZzk.zzg(zzdeVarZzn);
        }
        return zzdaVarZzk.zzaA();
    }

    final String zzh(com.google.android.gms.internal.measurement.zzdh zzdhVar) {
        if (zzdhVar == null) {
            return BuildConfig.FLAVOR;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nbatch {\n");
        for (com.google.android.gms.internal.measurement.zzdj zzdjVar : zzdhVar.zza()) {
            if (zzdjVar != null) {
                zzD(sb, 1);
                sb.append("bundle {\n");
                if (zzdjVar.zza()) {
                    zzG(sb, 1, "protocol_version", Integer.valueOf(zzdjVar.zzb()));
                }
                zzG(sb, 1, "platform", zzdjVar.zzt());
                if (zzdjVar.zzC()) {
                    zzG(sb, 1, "gmp_version", Long.valueOf(zzdjVar.zzD()));
                }
                if (zzdjVar.zzE()) {
                    zzG(sb, 1, "uploading_gmp_version", Long.valueOf(zzdjVar.zzF()));
                }
                if (zzdjVar.zzae()) {
                    zzG(sb, 1, "dynamite_version", Long.valueOf(zzdjVar.zzaf()));
                }
                if (zzdjVar.zzW()) {
                    zzG(sb, 1, "config_version", Long.valueOf(zzdjVar.zzX()));
                }
                zzG(sb, 1, "gmp_app_id", zzdjVar.zzP());
                zzG(sb, 1, "admob_app_id", zzdjVar.zzad());
                zzG(sb, 1, "app_id", zzdjVar.zzA());
                zzG(sb, 1, "app_version", zzdjVar.zzB());
                if (zzdjVar.zzU()) {
                    zzG(sb, 1, "app_version_major", Integer.valueOf(zzdjVar.zzV()));
                }
                zzG(sb, 1, "firebase_instance_id", zzdjVar.zzT());
                if (zzdjVar.zzK()) {
                    zzG(sb, 1, "dev_cert_hash", Long.valueOf(zzdjVar.zzL()));
                }
                zzG(sb, 1, "app_store", zzdjVar.zzz());
                if (zzdjVar.zzi()) {
                    zzG(sb, 1, "upload_timestamp_millis", Long.valueOf(zzdjVar.zzj()));
                }
                if (zzdjVar.zzk()) {
                    zzG(sb, 1, "start_timestamp_millis", Long.valueOf(zzdjVar.zzm()));
                }
                if (zzdjVar.zzn()) {
                    zzG(sb, 1, "end_timestamp_millis", Long.valueOf(zzdjVar.zzo()));
                }
                if (zzdjVar.zzp()) {
                    zzG(sb, 1, "previous_bundle_start_timestamp_millis", Long.valueOf(zzdjVar.zzq()));
                }
                if (zzdjVar.zzr()) {
                    zzG(sb, 1, "previous_bundle_end_timestamp_millis", Long.valueOf(zzdjVar.zzs()));
                }
                zzG(sb, 1, "app_instance_id", zzdjVar.zzJ());
                zzG(sb, 1, "resettable_device_id", zzdjVar.zzG());
                zzG(sb, 1, "ds_id", zzdjVar.zzaa());
                if (zzdjVar.zzH()) {
                    zzG(sb, 1, "limited_ad_tracking", Boolean.valueOf(zzdjVar.zzI()));
                }
                zzG(sb, 1, "os_version", zzdjVar.zzu());
                zzG(sb, 1, "device_model", zzdjVar.zzv());
                zzG(sb, 1, "user_default_language", zzdjVar.zzw());
                if (zzdjVar.zzx()) {
                    zzG(sb, 1, "time_zone_offset_minutes", Integer.valueOf(zzdjVar.zzy()));
                }
                if (zzdjVar.zzM()) {
                    zzG(sb, 1, "bundle_sequential_index", Integer.valueOf(zzdjVar.zzN()));
                }
                if (zzdjVar.zzQ()) {
                    zzG(sb, 1, "service_upload", Boolean.valueOf(zzdjVar.zzR()));
                }
                zzG(sb, 1, "health_monitor", zzdjVar.zzO());
                if (!this.zzx.zzc().zzn(null, zzdw.zzav) && zzdjVar.zzY() && zzdjVar.zzZ() != 0) {
                    zzG(sb, 1, "android_id", Long.valueOf(zzdjVar.zzZ()));
                }
                if (zzdjVar.zzab()) {
                    zzG(sb, 1, "retry_counter", Integer.valueOf(zzdjVar.zzac()));
                }
                if (zzdjVar.zzah()) {
                    zzG(sb, 1, "consent_signals", zzdjVar.zzai());
                }
                List<com.google.android.gms.internal.measurement.zzdu> listZzf = zzdjVar.zzf();
                if (listZzf != null) {
                    for (com.google.android.gms.internal.measurement.zzdu zzduVar : listZzf) {
                        if (zzduVar != null) {
                            zzD(sb, 2);
                            sb.append("user_property {\n");
                            zzG(sb, 2, "set_timestamp_millis", zzduVar.zza() ? Long.valueOf(zzduVar.zzb()) : null);
                            zzG(sb, 2, "name", this.zzx.zzm().zze(zzduVar.zzc()));
                            zzG(sb, 2, "string_value", zzduVar.zze());
                            zzG(sb, 2, "int_value", zzduVar.zzf() ? Long.valueOf(zzduVar.zzg()) : null);
                            zzG(sb, 2, "double_value", zzduVar.zzh() ? Double.valueOf(zzduVar.zzi()) : null);
                            zzD(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<com.google.android.gms.internal.measurement.zzcx> listZzS = zzdjVar.zzS();
                String strZzA = zzdjVar.zzA();
                if (listZzS != null) {
                    for (com.google.android.gms.internal.measurement.zzcx zzcxVar : listZzS) {
                        if (zzcxVar != null) {
                            zzD(sb, 2);
                            sb.append("audience_membership {\n");
                            if (zzcxVar.zza()) {
                                zzG(sb, 2, "audience_id", Integer.valueOf(zzcxVar.zzb()));
                            }
                            if (zzcxVar.zzf()) {
                                zzG(sb, 2, "new_audience", Boolean.valueOf(zzcxVar.zzg()));
                            }
                            zzF(sb, 2, "current_data", zzcxVar.zzc(), strZzA);
                            if (zzcxVar.zzd()) {
                                zzF(sb, 2, "previous_data", zzcxVar.zze(), strZzA);
                            }
                            zzD(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<com.google.android.gms.internal.measurement.zzdb> listZzc = zzdjVar.zzc();
                if (listZzc != null) {
                    for (com.google.android.gms.internal.measurement.zzdb zzdbVar : listZzc) {
                        if (zzdbVar != null) {
                            zzD(sb, 2);
                            sb.append("event {\n");
                            zzG(sb, 2, "name", this.zzx.zzm().zzc(zzdbVar.zzd()));
                            if (zzdbVar.zze()) {
                                zzG(sb, 2, "timestamp_millis", Long.valueOf(zzdbVar.zzf()));
                            }
                            if (zzdbVar.zzg()) {
                                zzG(sb, 2, "previous_timestamp_millis", Long.valueOf(zzdbVar.zzh()));
                            }
                            if (zzdbVar.zzi()) {
                                zzG(sb, 2, NotificationBadge.NewHtcHomeBadger.COUNT, Integer.valueOf(zzdbVar.zzj()));
                            }
                            if (zzdbVar.zzb() != 0) {
                                zzB(sb, 2, zzdbVar.zza());
                            }
                            zzD(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                zzD(sb, 1);
                sb.append("}\n");
            }
        }
        sb.append("}\n");
        return sb.toString();
    }

    final String zzi(com.google.android.gms.internal.measurement.zzbw zzbwVar) {
        if (zzbwVar == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nevent_filter {\n");
        if (zzbwVar.zza()) {
            zzG(sb, 0, "filter_id", Integer.valueOf(zzbwVar.zzb()));
        }
        zzG(sb, 0, "event_name", this.zzx.zzm().zzc(zzbwVar.zzc()));
        String strZzE = zzE(zzbwVar.zzi(), zzbwVar.zzj(), zzbwVar.zzm());
        if (!strZzE.isEmpty()) {
            zzG(sb, 0, "filter_type", strZzE);
        }
        if (zzbwVar.zzg()) {
            zzH(sb, 1, "event_count_filter", zzbwVar.zzh());
        }
        if (zzbwVar.zze() > 0) {
            sb.append("  filters {\n");
            Iterator<com.google.android.gms.internal.measurement.zzby> it = zzbwVar.zzd().iterator();
            while (it.hasNext()) {
                zzC(sb, 2, it.next());
            }
        }
        zzD(sb, 1);
        sb.append("}\n}\n");
        return sb.toString();
    }

    final String zzj(com.google.android.gms.internal.measurement.zzcf zzcfVar) {
        if (zzcfVar == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nproperty_filter {\n");
        if (zzcfVar.zza()) {
            zzG(sb, 0, "filter_id", Integer.valueOf(zzcfVar.zzb()));
        }
        zzG(sb, 0, "property_name", this.zzx.zzm().zze(zzcfVar.zzc()));
        String strZzE = zzE(zzcfVar.zze(), zzcfVar.zzf(), zzcfVar.zzh());
        if (!strZzE.isEmpty()) {
            zzG(sb, 0, "filter_type", strZzE);
        }
        zzC(sb, 1, zzcfVar.zzd());
        sb.append("}\n");
        return sb.toString();
    }

    final <T extends Parcelable> T zzk(byte[] bArr, Parcelable.Creator<T> creator) {
        if (bArr == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.unmarshall(bArr, 0, bArr.length);
            parcelObtain.setDataPosition(0);
            return creator.createFromParcel(parcelObtain);
        } catch (SafeParcelReader.ParseException unused) {
            this.zzx.zzat().zzb().zza("Failed to load parcelable from buffer");
            return null;
        } finally {
            parcelObtain.recycle();
        }
    }

    final List<Long> zzo(List<Long> list, List<Integer> list2) {
        int i;
        ArrayList arrayList = new ArrayList(list);
        for (Integer num : list2) {
            if (num.intValue() < 0) {
                this.zzx.zzat().zze().zzb("Ignoring negative bit index to be cleared", num);
            } else {
                int iIntValue = num.intValue() / 64;
                if (iIntValue >= arrayList.size()) {
                    this.zzx.zzat().zze().zzc("Ignoring bit index greater than bitSet size", num, Integer.valueOf(arrayList.size()));
                } else {
                    arrayList.set(iIntValue, Long.valueOf(((Long) arrayList.get(iIntValue)).longValue() & ((1 << (num.intValue() % 64)) ^ (-1))));
                }
            }
        }
        int size = arrayList.size();
        int size2 = arrayList.size() - 1;
        while (true) {
            int i2 = size2;
            i = size;
            size = i2;
            if (size < 0 || ((Long) arrayList.get(size)).longValue() != 0) {
                break;
            }
            size2 = size - 1;
        }
        return arrayList.subList(0, i);
    }

    final boolean zzq(long j, long j2) {
        return j == 0 || j2 <= 0 || Math.abs(this.zzx.zzax().currentTimeMillis() - j) > j2;
    }

    final long zzr(byte[] bArr) throws NoSuchAlgorithmException {
        Preconditions.checkNotNull(bArr);
        this.zzx.zzl().zzg();
        MessageDigest messageDigestZzN = zzkk.zzN();
        if (messageDigestZzN != null) {
            return zzkk.zzO(messageDigestZzN.digest(bArr));
        }
        this.zzx.zzat().zzb().zza("Failed to get MD5");
        return 0L;
    }

    final byte[] zzs(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            this.zzx.zzat().zzb().zzb("Failed to gzip content", e);
            throw e;
        }
    }
}
