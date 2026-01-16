package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import com.facebook.stetho.websocket.CloseCodes;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzkw;
import com.google.android.gms.internal.measurement.zzmg;
import java.io.ByteArrayInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzkk extends zzgf {
    public static final /* synthetic */ int zza = 0;
    private static final String[] zzb = {"firebase_", "google_", "ga_"};
    private static final String[] zzc = {"_err"};
    private SecureRandom zzd;
    private final AtomicLong zze;
    private int zzf;
    private Integer zzg;

    zzkk(zzfl zzflVar) {
        super(zzflVar);
        this.zzg = null;
        this.zze = new AtomicLong(0L);
    }

    static MessageDigest zzN() throws NoSuchAlgorithmException {
        MessageDigest messageDigest;
        for (int i = 0; i < 2; i++) {
            try {
                messageDigest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException unused) {
            }
            if (messageDigest != null) {
                return messageDigest;
            }
        }
        return null;
    }

    static long zzO(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        int length = bArr.length;
        int i = 0;
        Preconditions.checkState(length > 0);
        long j = 0;
        for (int i2 = length - 1; i2 >= 0 && i2 >= bArr.length - 8; i2--) {
            j += (bArr[i2] & 255) << i;
            i += 8;
        }
        return j;
    }

    static boolean zzP(Context context, boolean z) {
        Preconditions.checkNotNull(context);
        return Build.VERSION.SDK_INT >= 24 ? zzaq(context, "com.google.android.gms.measurement.AppMeasurementJobService") : zzaq(context, "com.google.android.gms.measurement.AppMeasurementService");
    }

    static boolean zzR(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    static boolean zzS(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null) {
            return false;
        }
        return str.equals(str2);
    }

    public static boolean zzY(String str) {
        return !zzc[0].equals(str);
    }

    public static ArrayList<Bundle> zzak(List<zzaa> list) {
        if (list == null) {
            return new ArrayList<>(0);
        }
        ArrayList<Bundle> arrayList = new ArrayList<>(list.size());
        for (zzaa zzaaVar : list) {
            Bundle bundle = new Bundle();
            bundle.putString("app_id", zzaaVar.zza);
            bundle.putString("origin", zzaaVar.zzb);
            bundle.putLong("creation_timestamp", zzaaVar.zzd);
            bundle.putString("name", zzaaVar.zzc.zzb);
            zzgh.zza(bundle, zzaaVar.zzc.zza());
            bundle.putBoolean("active", zzaaVar.zze);
            String str = zzaaVar.zzf;
            if (str != null) {
                bundle.putString("trigger_event_name", str);
            }
            zzas zzasVar = zzaaVar.zzg;
            if (zzasVar != null) {
                bundle.putString("timed_out_event_name", zzasVar.zza);
                zzaq zzaqVar = zzaaVar.zzg.zzb;
                if (zzaqVar != null) {
                    bundle.putBundle("timed_out_event_params", zzaqVar.zzf());
                }
            }
            bundle.putLong("trigger_timeout", zzaaVar.zzh);
            zzas zzasVar2 = zzaaVar.zzi;
            if (zzasVar2 != null) {
                bundle.putString("triggered_event_name", zzasVar2.zza);
                zzaq zzaqVar2 = zzaaVar.zzi.zzb;
                if (zzaqVar2 != null) {
                    bundle.putBundle("triggered_event_params", zzaqVar2.zzf());
                }
            }
            bundle.putLong("triggered_timestamp", zzaaVar.zzc.zzc);
            bundle.putLong("time_to_live", zzaaVar.zzj);
            zzas zzasVar3 = zzaaVar.zzk;
            if (zzasVar3 != null) {
                bundle.putString("expired_event_name", zzasVar3.zza);
                zzaq zzaqVar3 = zzaaVar.zzk.zzb;
                if (zzaqVar3 != null) {
                    bundle.putBundle("expired_event_params", zzaqVar3.zzf());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    static final boolean zzam(Bundle bundle, int i) {
        if (bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", i);
        return true;
    }

    static final boolean zzan(String str) {
        Preconditions.checkNotNull(str);
        return str.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$");
    }

    private final Object zzao(int i, Object obj, boolean z, boolean z2) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf(((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf(((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(true != ((Boolean) obj).booleanValue() ? 0L : 1L);
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
            return zzC(String.valueOf(obj), i, z);
        }
        if (!z2 || (!(obj instanceof Bundle[]) && !(obj instanceof Parcelable[]))) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Parcelable parcelable : (Parcelable[]) obj) {
            if (parcelable instanceof Bundle) {
                Bundle bundleZzU = zzU((Bundle) parcelable);
                if (!bundleZzU.isEmpty()) {
                    arrayList.add(bundleZzU);
                }
            }
        }
        return arrayList.toArray(new Bundle[arrayList.size()]);
    }

    private final int zzap(String str) {
        if ("_ldl".equals(str)) {
            this.zzx.zzc();
            return 2048;
        }
        if ("_id".equals(str)) {
            this.zzx.zzc();
            return 256;
        }
        if (this.zzx.zzc().zzn(null, zzdw.zzaf) && "_lgclid".equals(str)) {
            this.zzx.zzc();
            return 100;
        }
        this.zzx.zzc();
        return 36;
    }

    private static boolean zzaq(Context context, String str) {
        ServiceInfo serviceInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0)) != null) {
                if (serviceInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    private static boolean zzar(String str, String[] strArr) {
        Preconditions.checkNotNull(strArr);
        for (String str2 : strArr) {
            if (zzS(str, str2)) {
                return true;
            }
        }
        return false;
    }

    static boolean zzh(String str) {
        Preconditions.checkNotEmpty(str);
        return str.charAt(0) != '_' || str.equals("_ep");
    }

    final boolean zzA(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            if (zzan(str)) {
                return true;
            }
            if (this.zzx.zzq()) {
                this.zzx.zzat().zzd().zzb("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", zzei.zzl(str));
            }
            return false;
        }
        zzmg.zzb();
        if (this.zzx.zzc().zzn(null, zzdw.zzah) && !TextUtils.isEmpty(str3)) {
            return true;
        }
        if (TextUtils.isEmpty(str2)) {
            if (this.zzx.zzq()) {
                this.zzx.zzat().zzd().zza("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            }
            return false;
        }
        if (zzan(str2)) {
            return true;
        }
        this.zzx.zzat().zzd().zzb("Invalid admob_app_id. Analytics disabled.", zzei.zzl(str2));
        return false;
    }

    final boolean zzB(String str, String str2, String str3, String str4) {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        boolean zIsEmpty2 = TextUtils.isEmpty(str2);
        if (!zIsEmpty && !zIsEmpty2) {
            Preconditions.checkNotNull(str);
            return !str.equals(str2);
        }
        if (zIsEmpty && zIsEmpty2) {
            return (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) ? !TextUtils.isEmpty(str4) : !str3.equals(str4);
        }
        if (zIsEmpty) {
            return TextUtils.isEmpty(str3) || !str3.equals(str4);
        }
        if (TextUtils.isEmpty(str4)) {
            return false;
        }
        return TextUtils.isEmpty(str3) || !str3.equals(str4);
    }

    public final String zzC(String str, int i, boolean z) {
        if (str == null) {
            return null;
        }
        if (str.codePointCount(0, str.length()) <= i) {
            return str;
        }
        if (z) {
            return String.valueOf(str.substring(0, str.offsetByCodePoints(0, i))).concat("...");
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final int zzD(java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.Object r18, android.os.Bundle r19, java.util.List<java.lang.String> r20, boolean r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 372
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkk.zzD(java.lang.String, java.lang.String, java.lang.String, java.lang.Object, android.os.Bundle, java.util.List, boolean, boolean):int");
    }

    final Object zzE(String str, Object obj) {
        int i = 256;
        if ("_ev".equals(str)) {
            this.zzx.zzc();
            return zzao(256, obj, true, true);
        }
        if (zzR(str)) {
            this.zzx.zzc();
        } else {
            this.zzx.zzc();
            i = 100;
        }
        return zzao(i, obj, false, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00d4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x011e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final android.os.Bundle zzF(java.lang.String r21, java.lang.String r22, android.os.Bundle r23, java.util.List<java.lang.String> r24, boolean r25) {
        /*
            Method dump skipped, instructions count: 291
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkk.zzF(java.lang.String, java.lang.String, android.os.Bundle, java.util.List, boolean):android.os.Bundle");
    }

    final void zzG(zzej zzejVar, int i) {
        int i2 = 0;
        for (String str : new TreeSet(zzejVar.zzd.keySet())) {
            if (zzh(str) && (i2 = i2 + 1) > i) {
                StringBuilder sb = new StringBuilder(48);
                sb.append("Event can't contain more than ");
                sb.append(i);
                sb.append(" params");
                this.zzx.zzat().zzd().zzc(sb.toString(), this.zzx.zzm().zzc(zzejVar.zza), this.zzx.zzm().zzf(zzejVar.zzd));
                zzam(zzejVar.zzd, 5);
                zzejVar.zzd.remove(str);
            }
        }
    }

    final void zzH(Bundle bundle, Bundle bundle2) {
        if (bundle2 == null) {
            return;
        }
        for (String str : bundle2.keySet()) {
            if (!bundle.containsKey(str)) {
                this.zzx.zzl().zzL(bundle, str, bundle2.get(str));
            }
        }
    }

    final void zzI(Bundle bundle, int i, String str, String str2, Object obj) {
        if (zzam(bundle, i)) {
            this.zzx.zzc();
            bundle.putString("_ev", zzC(str, 40, true));
            if (obj != null) {
                Preconditions.checkNotNull(bundle);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    bundle.putLong("_el", String.valueOf(obj).length());
                }
            }
        }
    }

    final int zzJ(String str, Object obj) {
        return "_ldl".equals(str) ? zzt("user property referrer", str, zzap(str), obj) : zzt("user property", str, zzap(str), obj) ? 0 : 7;
    }

    final Object zzK(String str, Object obj) {
        return "_ldl".equals(str) ? zzao(zzap(str), obj, true, false) : zzao(zzap(str), obj, false, false);
    }

    final void zzL(Bundle bundle, String str, Object obj) {
        if (bundle == null) {
            return;
        }
        if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof String) {
            bundle.putString(str, String.valueOf(obj));
            return;
        }
        if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof Bundle[]) {
            bundle.putParcelableArray(str, (Bundle[]) obj);
        } else if (str != null) {
            this.zzx.zzat().zzh().zzc("Not putting event parameter. Invalid value type. name, type", this.zzx.zzm().zzd(str), obj != null ? obj.getClass().getSimpleName() : null);
        }
    }

    final void zzM(zzkj zzkjVar, String str, int i, String str2, String str3, int i2) {
        Bundle bundle = new Bundle();
        zzam(bundle, i);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            bundle.putString(str2, str3);
        }
        if (i == 6 || i == 7 || i == 2) {
            bundle.putLong("_el", i2);
        }
        zzkw.zzb();
        if (this.zzx.zzc().zzn(null, zzdw.zzaA)) {
            zzkjVar.zza(str, bundle);
        } else {
            this.zzx.zzas();
            this.zzx.zzk().zzs("auto", "_err", bundle);
        }
    }

    final boolean zzQ(String str) {
        zzg();
        if (Wrappers.packageManager(this.zzx.zzaw()).checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        this.zzx.zzat().zzj().zzb("Permission not granted", str);
        return false;
    }

    final boolean zzT(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String strZzu = this.zzx.zzc().zzu();
        this.zzx.zzas();
        return strZzu.equals(str);
    }

    final Bundle zzU(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object objZzE = zzE(str, bundle.get(str));
                if (objZzE == null) {
                    this.zzx.zzat().zzh().zzb("Param value can't be null", this.zzx.zzm().zzd(str));
                } else {
                    zzL(bundle2, str, objZzE);
                }
            }
        }
        return bundle2;
    }

    final zzas zzV(String str, String str2, Bundle bundle, String str3, long j, boolean z, boolean z2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (zzn(str2) != 0) {
            this.zzx.zzat().zzb().zzb("Invalid conditional property event name", this.zzx.zzm().zze(str2));
            throw new IllegalArgumentException();
        }
        Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
        bundle2.putString("_o", str3);
        Bundle bundleZzF = zzF(str, str2, bundle2, CollectionUtils.listOf("_o"), false);
        if (z) {
            bundleZzF = zzU(bundleZzF);
        }
        Preconditions.checkNotNull(bundleZzF);
        return new zzas(str2, new zzaq(bundleZzF), str3, j);
    }

    final boolean zzW(Context context, String str) {
        Signature[] signatureArr;
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str, 64);
            if (packageInfo == null || (signatureArr = packageInfo.signatures) == null || signatureArr.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (PackageManager.NameNotFoundException e) {
            this.zzx.zzat().zzb().zzb("Package name not found", e);
            return true;
        } catch (CertificateException e2) {
            this.zzx.zzat().zzb().zzb("Error obtaining certificate", e2);
            return true;
        }
    }

    final byte[] zzX(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(parcelObtain, 0);
            return parcelObtain.marshall();
        } finally {
            parcelObtain.recycle();
        }
    }

    @EnsuresNonNull({"this.apkVersion"})
    public final int zzZ() {
        if (this.zzg == null) {
            this.zzg = Integer.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zzx.zzaw()) / CloseCodes.NORMAL_CLOSURE);
        }
        return this.zzg.intValue();
    }

    @Override // com.google.android.gms.measurement.internal.zzgf
    protected final boolean zza() {
        return true;
    }

    public final int zzaa(int i) {
        return GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(this.zzx.zzaw(), 12451000);
    }

    public final long zzab(long j, long j2) {
        return (j + (j2 * 60000)) / 86400000;
    }

    final void zzac(Bundle bundle, long j) {
        long j2 = bundle.getLong("_et");
        if (j2 != 0) {
            this.zzx.zzat().zze().zzb("Params already contained engagement", Long.valueOf(j2));
        }
        bundle.putLong("_et", j + j2);
    }

    public final void zzad(com.google.android.gms.internal.measurement.zzs zzsVar, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("r", str);
        try {
            zzsVar.zzb(bundle);
        } catch (RemoteException e) {
            this.zzx.zzat().zze().zzb("Error returning string value to wrapper", e);
        }
    }

    public final void zzae(com.google.android.gms.internal.measurement.zzs zzsVar, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("r", j);
        try {
            zzsVar.zzb(bundle);
        } catch (RemoteException e) {
            this.zzx.zzat().zze().zzb("Error returning long value to wrapper", e);
        }
    }

    public final void zzaf(com.google.android.gms.internal.measurement.zzs zzsVar, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("r", i);
        try {
            zzsVar.zzb(bundle);
        } catch (RemoteException e) {
            this.zzx.zzat().zze().zzb("Error returning int value to wrapper", e);
        }
    }

    public final void zzag(com.google.android.gms.internal.measurement.zzs zzsVar, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("r", bArr);
        try {
            zzsVar.zzb(bundle);
        } catch (RemoteException e) {
            this.zzx.zzat().zze().zzb("Error returning byte array to wrapper", e);
        }
    }

    public final void zzah(com.google.android.gms.internal.measurement.zzs zzsVar, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("r", z);
        try {
            zzsVar.zzb(bundle);
        } catch (RemoteException e) {
            this.zzx.zzat().zze().zzb("Error returning boolean value to wrapper", e);
        }
    }

    public final void zzai(com.google.android.gms.internal.measurement.zzs zzsVar, Bundle bundle) {
        try {
            zzsVar.zzb(bundle);
        } catch (RemoteException e) {
            this.zzx.zzat().zze().zzb("Error returning bundle value to wrapper", e);
        }
    }

    public final void zzaj(com.google.android.gms.internal.measurement.zzs zzsVar, ArrayList<Bundle> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("r", arrayList);
        try {
            zzsVar.zzb(bundle);
        } catch (RemoteException e) {
            this.zzx.zzat().zze().zzb("Error returning bundle list to wrapper", e);
        }
    }

    public final URL zzal(long j, String str, String str2, long j2) {
        try {
            Preconditions.checkNotEmpty(str2);
            Preconditions.checkNotEmpty(str);
            String strConcat = String.format("https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=%s&rdid=%s&bundleid=%s&retry=%s", String.format("v%s.%s", 39000L, Integer.valueOf(zzZ())), str2, str, Long.valueOf(j2));
            if (str.equals(this.zzx.zzc().zzv())) {
                strConcat = strConcat.concat("&ddl_test=1");
            }
            return new URL(strConcat);
        } catch (IllegalArgumentException | MalformedURLException e) {
            this.zzx.zzat().zzb().zzb("Failed to create BOW URL for Deferred Deep Link. exception", e.getMessage());
            return null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzgf
    protected final void zzay() {
        zzg();
        SecureRandom secureRandom = new SecureRandom();
        long jNextLong = secureRandom.nextLong();
        if (jNextLong == 0) {
            jNextLong = secureRandom.nextLong();
            if (jNextLong == 0) {
                this.zzx.zzat().zze().zza("Utils falling back to Random for random id");
            }
        }
        this.zze.set(jNextLong);
    }

    public final long zzd() {
        long andIncrement;
        long j;
        if (this.zze.get() != 0) {
            synchronized (this.zze) {
                this.zze.compareAndSet(-1L, 1L);
                andIncrement = this.zze.getAndIncrement();
            }
            return andIncrement;
        }
        synchronized (this.zze) {
            long jNextLong = new Random(System.nanoTime() ^ this.zzx.zzax().currentTimeMillis()).nextLong();
            int i = this.zzf + 1;
            this.zzf = i;
            j = jNextLong + i;
        }
        return j;
    }

    @EnsuresNonNull({"this.secureRandom"})
    final SecureRandom zzf() {
        zzg();
        if (this.zzd == null) {
            this.zzd = new SecureRandom();
        }
        return this.zzd;
    }

    final Bundle zzi(Uri uri) {
        String queryParameter;
        String queryParameter2;
        String queryParameter3;
        String queryParameter4;
        if (uri != null) {
            try {
                if (uri.isHierarchical()) {
                    queryParameter = uri.getQueryParameter("utm_campaign");
                    queryParameter2 = uri.getQueryParameter("utm_source");
                    queryParameter3 = uri.getQueryParameter("utm_medium");
                    queryParameter4 = uri.getQueryParameter("gclid");
                } else {
                    queryParameter = null;
                    queryParameter2 = null;
                    queryParameter3 = null;
                    queryParameter4 = null;
                }
                if (TextUtils.isEmpty(queryParameter) && TextUtils.isEmpty(queryParameter2) && TextUtils.isEmpty(queryParameter3) && TextUtils.isEmpty(queryParameter4)) {
                    return null;
                }
                Bundle bundle = new Bundle();
                if (!TextUtils.isEmpty(queryParameter)) {
                    bundle.putString("campaign", queryParameter);
                }
                if (!TextUtils.isEmpty(queryParameter2)) {
                    bundle.putString("source", queryParameter2);
                }
                if (!TextUtils.isEmpty(queryParameter3)) {
                    bundle.putString("medium", queryParameter3);
                }
                if (!TextUtils.isEmpty(queryParameter4)) {
                    bundle.putString("gclid", queryParameter4);
                }
                String queryParameter5 = uri.getQueryParameter("utm_term");
                if (!TextUtils.isEmpty(queryParameter5)) {
                    bundle.putString("term", queryParameter5);
                }
                String queryParameter6 = uri.getQueryParameter("utm_content");
                if (!TextUtils.isEmpty(queryParameter6)) {
                    bundle.putString("content", queryParameter6);
                }
                String queryParameter7 = uri.getQueryParameter("aclid");
                if (!TextUtils.isEmpty(queryParameter7)) {
                    bundle.putString("aclid", queryParameter7);
                }
                String queryParameter8 = uri.getQueryParameter("cp1");
                if (!TextUtils.isEmpty(queryParameter8)) {
                    bundle.putString("cp1", queryParameter8);
                }
                String queryParameter9 = uri.getQueryParameter("anid");
                if (!TextUtils.isEmpty(queryParameter9)) {
                    bundle.putString("anid", queryParameter9);
                }
                return bundle;
            } catch (UnsupportedOperationException e) {
                this.zzx.zzat().zze().zzb("Install referrer url isn't a hierarchical URI", e);
            }
        }
        return null;
    }

    final boolean zzj(String str, String str2) {
        if (str2 == null) {
            this.zzx.zzat().zzd().zzb("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.length() == 0) {
            this.zzx.zzat().zzd().zzb("Name is required and can't be empty. Type", str);
            return false;
        }
        int iCodePointAt = str2.codePointAt(0);
        if (!Character.isLetter(iCodePointAt)) {
            this.zzx.zzat().zzd().zzc("Name must start with a letter. Type, name", str, str2);
            return false;
        }
        int length = str2.length();
        int iCharCount = Character.charCount(iCodePointAt);
        while (iCharCount < length) {
            int iCodePointAt2 = str2.codePointAt(iCharCount);
            if (iCodePointAt2 != 95 && !Character.isLetterOrDigit(iCodePointAt2)) {
                this.zzx.zzat().zzd().zzc("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt2);
        }
        return true;
    }

    final boolean zzk(String str, String str2) {
        if (str2 == null) {
            this.zzx.zzat().zzd().zzb("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.length() == 0) {
            this.zzx.zzat().zzd().zzb("Name is required and can't be empty. Type", str);
            return false;
        }
        int iCodePointAt = str2.codePointAt(0);
        if (!Character.isLetter(iCodePointAt)) {
            if (iCodePointAt != 95) {
                this.zzx.zzat().zzd().zzc("Name must start with a letter or _ (underscore). Type, name", str, str2);
                return false;
            }
            iCodePointAt = 95;
        }
        int length = str2.length();
        int iCharCount = Character.charCount(iCodePointAt);
        while (iCharCount < length) {
            int iCodePointAt2 = str2.codePointAt(iCharCount);
            if (iCodePointAt2 != 95 && !Character.isLetterOrDigit(iCodePointAt2)) {
                this.zzx.zzat().zzd().zzc("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt2);
        }
        return true;
    }

    final boolean zzl(String str, String[] strArr, String[] strArr2, String str2) {
        if (str2 == null) {
            this.zzx.zzat().zzd().zzb("Name is required and can't be null. Type", str);
            return false;
        }
        Preconditions.checkNotNull(str2);
        String[] strArr3 = zzb;
        for (int i = 0; i < 3; i++) {
            if (str2.startsWith(strArr3[i])) {
                this.zzx.zzat().zzd().zzc("Name starts with reserved prefix. Type, name", str, str2);
                return false;
            }
        }
        if (strArr == null || !zzar(str2, strArr)) {
            return true;
        }
        if (strArr2 != null && zzar(str2, strArr2)) {
            return true;
        }
        this.zzx.zzat().zzd().zzc("Name is reserved. Type, name", str, str2);
        return false;
    }

    final boolean zzm(String str, int i, String str2) {
        if (str2 == null) {
            this.zzx.zzat().zzd().zzb("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.codePointCount(0, str2.length()) <= i) {
            return true;
        }
        this.zzx.zzat().zzd().zzd("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
        return false;
    }

    final int zzn(String str) {
        if (!zzk("event", str)) {
            return 2;
        }
        if (!zzl("event", zzgi.zza, zzgi.zzb, str)) {
            return 13;
        }
        this.zzx.zzc();
        return !zzm("event", 40, str) ? 2 : 0;
    }

    final int zzo(String str) {
        if (!zzk("user property", str)) {
            return 6;
        }
        if (!zzl("user property", zzgk.zza, null, str)) {
            return 15;
        }
        this.zzx.zzc();
        return !zzm("user property", 24, str) ? 6 : 0;
    }

    final int zzq(String str) {
        if (!zzj("event param", str)) {
            return 3;
        }
        if (!zzl("event param", null, null, str)) {
            return 14;
        }
        this.zzx.zzc();
        return !zzm("event param", 40, str) ? 3 : 0;
    }

    final int zzr(String str) {
        if (!zzk("event param", str)) {
            return 3;
        }
        if (!zzl("event param", null, null, str)) {
            return 14;
        }
        this.zzx.zzc();
        return !zzm("event param", 40, str) ? 3 : 0;
    }

    final boolean zzs(Object obj) {
        return (obj instanceof Parcelable[]) || (obj instanceof ArrayList) || (obj instanceof Bundle);
    }

    final boolean zzt(String str, String str2, int i, Object obj) {
        if (obj != null && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                return false;
            }
            String strValueOf = String.valueOf(obj);
            if (strValueOf.codePointCount(0, strValueOf.length()) > i) {
                this.zzx.zzat().zzh().zzd("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(strValueOf.length()));
                return false;
            }
        }
        return true;
    }

    final void zzz(String str, String str2, String str3, Bundle bundle, List<String> list, boolean z) {
        int i;
        String str4;
        int iZzD;
        if (bundle == null) {
            return;
        }
        this.zzx.zzc();
        int i2 = 0;
        for (String str5 : new TreeSet(bundle.keySet())) {
            if (list == null || !list.contains(str5)) {
                int iZzq = z ? zzq(str5) : 0;
                if (iZzq == 0) {
                    iZzq = zzr(str5);
                }
                i = iZzq;
            } else {
                i = 0;
            }
            if (i != 0) {
                zzI(bundle, i, str5, str5, i == 3 ? str5 : null);
                bundle.remove(str5);
            } else {
                if (zzs(bundle.get(str5))) {
                    this.zzx.zzat().zzh().zzd("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", str2, str3, str5);
                    str4 = str5;
                    iZzD = 22;
                } else {
                    str4 = str5;
                    iZzD = zzD(str, str2, str5, bundle.get(str5), bundle, list, z, false);
                }
                if (iZzD != 0 && !"_ev".equals(str4)) {
                    zzI(bundle, iZzD, str4, str4, bundle.get(str4));
                    bundle.remove(str4);
                } else if (zzh(str4) && !zzar(str4, zzgj.zzd) && (i2 = i2 + 1) > 0) {
                    this.zzx.zzat().zzd().zzc("Item cannot contain custom parameters", this.zzx.zzm().zzc(str2), this.zzx.zzm().zzf(bundle));
                    zzam(bundle, 23);
                    bundle.remove(str4);
                }
            }
        }
    }
}
