package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
public abstract class zzfg<T> {
    public static final /* synthetic */ int zzc = 0;
    private static final Object zzd = new Object();
    private static volatile zzff zze;
    private static final AtomicInteger zzj;
    final zzfe zza;
    final String zzb;
    private final T zzi;
    private volatile int zzk = -1;
    private volatile T zzl;
    private final boolean zzm;

    static {
        new AtomicReference();
        new zzfi(zzez.zza);
        zzj = new AtomicInteger();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* synthetic */ zzfg(zzfe zzfeVar, String str, Object obj, boolean z, zzfa zzfaVar) {
        if (zzfeVar.zzb == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        }
        this.zza = zzfeVar;
        this.zzb = str;
        this.zzi = obj;
        this.zzm = true;
    }

    @Deprecated
    public static void zzb(final Context context) {
        synchronized (zzd) {
            zzff zzffVar = zze;
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            if (zzffVar == null || zzffVar.zza() != context) {
                zzen.zzd();
                zzfh.zzb();
                zzeu.zzc();
                zze = new zzek(context, zzfs.zza(new zzfo(context) { // from class: com.google.android.gms.internal.measurement.zzey
                    private final Context zza;

                    {
                        this.zza = context;
                    }

                    @Override // com.google.android.gms.internal.measurement.zzfo
                    public final Object zza() throws IOException {
                        zzfm zzfmVarZzc;
                        Context contextCreateDeviceProtectedStorageContext = this.zza;
                        int i = zzfg.zzc;
                        String str = Build.TYPE;
                        String str2 = Build.TAGS;
                        if ((!str.equals("eng") && !str.equals("userdebug")) || (!str2.contains("dev-keys") && !str2.contains("test-keys"))) {
                            return zzfm.zzc();
                        }
                        if (zzej.zza() && !contextCreateDeviceProtectedStorageContext.isDeviceProtectedStorage()) {
                            contextCreateDeviceProtectedStorageContext = contextCreateDeviceProtectedStorageContext.createDeviceProtectedStorageContext();
                        }
                        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                        try {
                            StrictMode.allowThreadDiskWrites();
                            try {
                                File file = new File(contextCreateDeviceProtectedStorageContext.getDir("phenotype_hermetic", 0), "overrides.txt");
                                zzfmVarZzc = file.exists() ? zzfm.zzd(file) : zzfm.zzc();
                            } catch (RuntimeException e) {
                                Log.e("HermeticFileOverrides", "no data dir", e);
                                zzfmVarZzc = zzfm.zzc();
                            }
                            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                            if (!zzfmVarZzc.zza()) {
                                return zzfm.zzc();
                            }
                            File file2 = (File) zzfmVarZzc.zzb();
                            try {
                                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file2)));
                                try {
                                    HashMap map = new HashMap();
                                    HashMap map2 = new HashMap();
                                    while (true) {
                                        String line = bufferedReader.readLine();
                                        if (line == null) {
                                            String strValueOf = String.valueOf(file2);
                                            StringBuilder sb = new StringBuilder(strValueOf.length() + 7);
                                            sb.append("Parsed ");
                                            sb.append(strValueOf);
                                            Log.i("HermeticFileOverrides", sb.toString());
                                            zzev zzevVar = new zzev(map);
                                            bufferedReader.close();
                                            return zzfm.zzd(zzevVar);
                                        }
                                        String[] strArrSplit = line.split(" ", 3);
                                        if (strArrSplit.length != 3) {
                                            Log.e("HermeticFileOverrides", line.length() != 0 ? "Invalid: ".concat(line) : new String("Invalid: "));
                                        } else {
                                            String str3 = new String(strArrSplit[0]);
                                            String strDecode = Uri.decode(new String(strArrSplit[1]));
                                            String strDecode2 = (String) map2.get(strArrSplit[2]);
                                            if (strDecode2 == null) {
                                                String str4 = new String(strArrSplit[2]);
                                                strDecode2 = Uri.decode(str4);
                                                if (strDecode2.length() < 1024 || strDecode2 == str4) {
                                                    map2.put(str4, strDecode2);
                                                }
                                            }
                                            if (!map.containsKey(str3)) {
                                                map.put(str3, new HashMap());
                                            }
                                            ((Map) map.get(str3)).put(strDecode, strDecode2);
                                        }
                                    }
                                } finally {
                                }
                            } catch (IOException e2) {
                                throw new RuntimeException(e2);
                            }
                        } catch (Throwable th) {
                            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                            throw th;
                        }
                    }
                }));
                zzj.incrementAndGet();
            }
        }
    }

    static void zzc() {
        zzj.incrementAndGet();
    }

    abstract T zza(Object obj);

    public final String zzd() {
        String str = this.zza.zzd;
        return this.zzb;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00bc A[Catch: all -> 0x0116, TryCatch #0 {, blocks: (B:12:0x001c, B:14:0x0020, B:16:0x0026, B:18:0x003b, B:20:0x0047, B:22:0x0050, B:24:0x0062, B:26:0x006d, B:25:0x0067, B:47:0x00de, B:49:0x00ee, B:51:0x0102, B:52:0x0105, B:53:0x0109, B:41:0x00bc, B:43:0x00d4, B:46:0x00dc, B:28:0x0072, B:30:0x0078, B:32:0x0086, B:36:0x00ab, B:38:0x00b5, B:34:0x009d, B:54:0x010e, B:55:0x0113, B:56:0x0114), top: B:63:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ee A[Catch: all -> 0x0116, TryCatch #0 {, blocks: (B:12:0x001c, B:14:0x0020, B:16:0x0026, B:18:0x003b, B:20:0x0047, B:22:0x0050, B:24:0x0062, B:26:0x006d, B:25:0x0067, B:47:0x00de, B:49:0x00ee, B:51:0x0102, B:52:0x0105, B:53:0x0109, B:41:0x00bc, B:43:0x00d4, B:46:0x00dc, B:28:0x0072, B:30:0x0078, B:32:0x0086, B:36:0x00ab, B:38:0x00b5, B:34:0x009d, B:54:0x010e, B:55:0x0113, B:56:0x0114), top: B:63:0x001c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final T zze() {
        /*
            Method dump skipped, instructions count: 284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzfg.zze():java.lang.Object");
    }
}
