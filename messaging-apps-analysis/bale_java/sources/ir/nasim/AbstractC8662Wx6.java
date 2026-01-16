package ir.nasim;

import android.app.ActivityManager;
import android.content.SharedPreferences;
import android.gov.nist.core.Separators;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.Utilities;
import ir.nasim.tgwidgets.editor.tgnet.ConnectionsManager;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;

/* renamed from: ir.nasim.Wx6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC8662Wx6 {
    public static boolean A;
    public static C24751z87 A0;
    public static boolean B;
    public static int B0;
    public static boolean C;
    public static long C0;
    public static int D;
    public static boolean D0;
    public static boolean E;
    private static int E0;
    public static boolean F;
    private static int F0;
    public static boolean G;
    public static boolean G0;
    public static boolean H;
    public static boolean H0;
    public static boolean I;
    private static int I0;
    private static int J;
    public static int J0;
    public static String K;
    public static int K0;
    private static String L;
    public static int L0;
    public static int M;
    public static int M0;
    private static boolean N;
    public static boolean N0;
    private static final Object O;
    public static boolean O0;
    private static final Object P;
    private static final int[] P0;
    public static int Q;
    public static ArrayList Q0;
    public static boolean R;
    private static Boolean R0;
    public static boolean S;
    static Boolean S0;
    public static boolean T;
    private static String T0;
    public static boolean U;
    public static int U0;
    public static boolean V;
    public static boolean W;
    public static boolean X;
    public static boolean Y;
    public static boolean Z;
    private static HashSet a;
    public static boolean a0;
    public static String b;
    public static boolean b0;
    public static boolean c;
    public static boolean c0;
    public static byte[] d;
    public static boolean d0;
    public static String e;
    public static boolean e0;
    public static int f;
    public static boolean f0;
    public static String g;
    public static boolean g0;
    public static long h;
    public static boolean h0;
    public static long i;
    public static boolean i0;
    public static int j;
    public static boolean j0;
    public static byte[] k;
    public static boolean k0;
    public static boolean l;
    public static boolean l0;
    public static int m;
    public static boolean m0;
    public static boolean n;
    public static boolean n0;
    public static boolean o;
    public static int o0;
    public static int p;
    public static boolean p0;
    public static boolean q;
    public static boolean q0;
    public static String r;
    public static int r0;
    public static int s;
    public static boolean s0;
    public static boolean t;
    public static int t0;
    public static int u;
    public static int u0;
    public static int v;
    public static boolean v0;
    public static int w;
    public static int w0;
    public static int x;
    public static int x0;
    public static int y;
    public static int y0;
    public static int z;
    public static int z0;

    /* renamed from: ir.nasim.Wx6$a */
    public static class a {
        private static SharedPreferences a;
    }

    static {
        HashSet hashSet = new HashSet();
        a = hashSet;
        hashSet.add("c2.exynos.hevc.encoder");
        a.add("OMX.Exynos.HEVC.Encoder".toLowerCase());
        b = "";
        g = "";
        k = new byte[0];
        m = 3600;
        q = true;
        G = true;
        J = -210000;
        L = "";
        O = new Object();
        P = new Object();
        Q = 2;
        R = false;
        S = true;
        T = true;
        U = false;
        V = true;
        W = true;
        X = true;
        Y = true;
        Z = false;
        a0 = true;
        b0 = false;
        c0 = false;
        d0 = true;
        e0 = false;
        f0 = false;
        n0 = true;
        r0 = 16;
        t0 = 17;
        u0 = 16;
        K0 = 3;
        L0 = 3;
        M0 = 3;
        P0 = new int[]{-1775228513, 802464304, 802464333, 802464302, 2067362118, 2067362060, 2067362084, 2067362241, 2067362117, 2067361998, -1853602818};
        m();
        Q0 = new ArrayList();
        U0 = AbstractC13787gp0.a;
    }

    public static boolean b() {
        if (S0 == null) {
            int codecCount = MediaCodecList.getCodecCount();
            int i2 = 0;
            for (int i3 = 0; i3 < codecCount; i3++) {
                MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i3);
                if (!codecInfoAt.isEncoder()) {
                    int i4 = 0;
                    while (true) {
                        if (i4 >= codecInfoAt.getSupportedTypes().length) {
                            break;
                        }
                        if (codecInfoAt.getSupportedTypes()[i4].contains("video/hevc")) {
                            int maxSupportedInstances = codecInfoAt.getCapabilitiesForType("video/hevc").getMaxSupportedInstances();
                            if (maxSupportedInstances > i2) {
                                i2 = maxSupportedInstances;
                            }
                        } else {
                            i4++;
                        }
                    }
                }
            }
            S0 = Boolean.valueOf(i2 >= 8);
        }
        return S0.booleanValue();
    }

    public static boolean c() {
        if (R0 == null) {
            R0 = Boolean.valueOf(ir.nasim.tgwidgets.editor.messenger.C.m().getBoolean("view_animations", true));
        }
        return R0.booleanValue();
    }

    public static void d() {
        Utilities.e.i(new Runnable() { // from class: ir.nasim.Vx6
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC8662Wx6.l();
            }
        });
    }

    public static boolean e() {
        return h() <= 1;
    }

    public static boolean f(boolean z2) {
        return S && (!z2 || R);
    }

    public static String g() {
        if (T0 == null) {
            int codecCount = MediaCodecList.getCodecCount();
            for (int i2 = 0; i2 < codecCount; i2++) {
                MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i2);
                if (codecInfoAt.isEncoder()) {
                    for (int i3 = 0; i3 < codecInfoAt.getSupportedTypes().length; i3++) {
                        if (codecInfoAt.getSupportedTypes()[i3].contains("video/hevc") && codecInfoAt.isHardwareAccelerated() && k(codecInfoAt)) {
                            String name = codecInfoAt.getName();
                            T0 = name;
                            return name;
                        }
                    }
                }
            }
            T0 = "";
        }
        if (TextUtils.isEmpty(T0)) {
            return null;
        }
        return T0;
    }

    public static int h() {
        int i2 = F0;
        if (i2 != -1) {
            return i2;
        }
        if (E0 == -1) {
            E0 = n();
        }
        return E0;
    }

    public static int i() {
        int i2;
        synchronized (P) {
            i2 = J;
            J = i2 - 1;
        }
        return i2;
    }

    public static boolean j() {
        return ir.nasim.tgwidgets.editor.messenger.v.e(1024);
    }

    private static boolean k(MediaCodecInfo mediaCodecInfo) {
        if (AbstractC8814Xl0.c) {
            return true;
        }
        return a.contains(mediaCodecInfo.getName().toLowerCase());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void l() {
        try {
            File file = new File(Environment.getExternalStorageDirectory(), "EditorFiles");
            File file2 = new File(file, "EditorFiles Images");
            file2.mkdir();
            File file3 = new File(file, "EditorFiles Video");
            file3.mkdir();
            if (AbstractC8814Xl0.e) {
                if (file2.isDirectory()) {
                    AbstractC21455b.E(new File(file2, ".nomedia"));
                }
                if (file3.isDirectory()) {
                    AbstractC21455b.E(new File(file3, ".nomedia"));
                    return;
                }
                return;
            }
            if (file2.isDirectory()) {
                new File(file2, ".nomedia").delete();
            }
            if (file3.isDirectory()) {
                new File(file3, ".nomedia").delete();
            }
        } catch (Throwable th) {
            AbstractC6403Nl2.d(th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0174 A[Catch: all -> 0x00e1, Exception -> 0x014f, TryCatch #0 {Exception -> 0x014f, blocks: (B:24:0x0122, B:26:0x012a, B:28:0x013a, B:31:0x0151, B:42:0x0174, B:44:0x0178, B:45:0x017a, B:47:0x017e, B:49:0x0184, B:51:0x018a, B:53:0x018e, B:40:0x016e), top: B:83:0x0122, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0178 A[Catch: all -> 0x00e1, Exception -> 0x014f, TryCatch #0 {Exception -> 0x014f, blocks: (B:24:0x0122, B:26:0x012a, B:28:0x013a, B:31:0x0151, B:42:0x0174, B:44:0x0178, B:45:0x017a, B:47:0x017e, B:49:0x0184, B:51:0x018a, B:53:0x018e, B:40:0x016e), top: B:83:0x0122, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x018e A[Catch: all -> 0x00e1, Exception -> 0x014f, TRY_LEAVE, TryCatch #0 {Exception -> 0x014f, blocks: (B:24:0x0122, B:26:0x012a, B:28:0x013a, B:31:0x0151, B:42:0x0174, B:44:0x0178, B:45:0x017a, B:47:0x017e, B:49:0x0184, B:51:0x018a, B:53:0x018e, B:40:0x016e), top: B:83:0x0122, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x03b2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x03d1 A[Catch: all -> 0x00e1, Exception -> 0x03d5, TRY_LEAVE, TryCatch #4 {Exception -> 0x03d5, blocks: (B:71:0x03cd, B:73:0x03d1), top: B:90:0x03cd, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void m() {
        /*
            Method dump skipped, instructions count: 991
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC8662Wx6.m():void");
    }

    public static int n() {
        long j2;
        int i2 = Build.VERSION.SDK_INT;
        int i3 = ConnectionsManager.c;
        int memoryClass = ((ActivityManager) AbstractC14047hG.a.getSystemService("activity")).getMemoryClass();
        int i4 = 0;
        if (i2 >= 31 && Build.SOC_MODEL != null) {
            int iHashCode = Build.SOC_MODEL.toUpperCase().hashCode();
            int i5 = 0;
            while (true) {
                int[] iArr = P0;
                if (i5 >= iArr.length) {
                    break;
                }
                if (iArr[i5] == iHashCode) {
                    return 0;
                }
                i5++;
            }
        }
        int i6 = 0;
        int iIntValue = 0;
        for (int i7 = 0; i7 < i3; i7++) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(String.format(Locale.ENGLISH, "/sys/devices/system/cpu/cpu%d/cpufreq/cpuinfo_max_freq", Integer.valueOf(i7)), "r");
                String line = randomAccessFile.readLine();
                if (line != null) {
                    iIntValue += Utilities.h(line).intValue() / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT;
                    i6++;
                }
                randomAccessFile.close();
            } catch (Throwable unused) {
            }
        }
        int iCeil = i6 == 0 ? -1 : (int) Math.ceil(iIntValue / i6);
        try {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) AbstractC14047hG.a.getSystemService("activity")).getMemoryInfo(memoryInfo);
            j2 = memoryInfo.totalMem;
        } catch (Exception unused2) {
            j2 = -1;
        }
        if (i3 > 2 && memoryClass > 100 && ((i3 > 4 || iCeil == -1 || iCeil > 1250) && ((i3 > 4 || iCeil > 1300 || memoryClass > 128 || i2 > 24) && (j2 == -1 || j2 >= 2147483648L)))) {
            i4 = (i3 < 8 || memoryClass <= 160 || (iCeil != -1 && iCeil <= 2055)) ? 1 : 2;
        }
        if (AbstractC8814Xl0.b) {
            AbstractC6403Nl2.a("device performance info selected_class = " + i4 + " (cpu_count = " + i3 + ", freq = " + iCeil + ", memoryClass = " + memoryClass + ", android version " + i2 + ", manufacture " + Build.MANUFACTURER + ", screenRefreshRate=" + AbstractC21455b.i + Separators.RPAREN);
        }
        return i4;
    }

    public static void o() {
        synchronized (O) {
            try {
                try {
                    SharedPreferences.Editor editorEdit = AbstractC14047hG.a.getSharedPreferences(EnumC18608ow5.q.getValue(), 0).edit();
                    editorEdit.putBoolean("saveIncomingPhotos", n);
                    editorEdit.putString("passcodeHash1", g);
                    byte[] bArr = k;
                    editorEdit.putString("passcodeSalt", bArr.length > 0 ? Base64.encodeToString(bArr, 0) : "");
                    editorEdit.putBoolean("appLocked", l);
                    editorEdit.putInt("passcodeType", f);
                    editorEdit.putLong("passcodeRetryInMs", h);
                    editorEdit.putLong("lastUptimeMillis", i);
                    editorEdit.putInt("badPasscodeTries", j);
                    editorEdit.putInt("autoLockIn", m);
                    editorEdit.putInt("lastPauseTime", p);
                    editorEdit.putString("lastUpdateVersion2", r);
                    editorEdit.putBoolean("useFingerprint", q);
                    editorEdit.putBoolean("allowScreenCapture", o);
                    editorEdit.putString("pushString2", b);
                    editorEdit.putBoolean("pushStatSent", c);
                    byte[] bArr2 = d;
                    editorEdit.putString("pushAuthKey", bArr2 != null ? Base64.encodeToString(bArr2, 0) : "");
                    editorEdit.putInt("lastLocalId", J);
                    editorEdit.putString("passportConfigJson", L);
                    editorEdit.putInt("passportConfigHash", M);
                    editorEdit.putBoolean("sortContactsByName", i0);
                    editorEdit.putBoolean("sortFilesByName", j0);
                    editorEdit.putInt("textSelectionHintShows", x);
                    editorEdit.putInt("scheduledOrNoSoundHintShows", y);
                    editorEdit.putBoolean("forwardingOptionsHintShown", A);
                    editorEdit.putInt("lockRecordAudioVideoHint", z);
                    editorEdit.putString("storageCacheDir", !TextUtils.isEmpty(K) ? K : "");
                    editorEdit.putBoolean("proxyRotationEnabled", v0);
                    editorEdit.putInt("proxyRotationTimeout", w0);
                    C24751z87 c24751z87 = A0;
                    if (c24751z87 != null) {
                        try {
                            C23394wq6 c23394wq6 = new C23394wq6(c24751z87.a());
                            A0.c(c23394wq6);
                            editorEdit.putString("appUpdate", Base64.encodeToString(c23394wq6.q(), 0));
                            editorEdit.putInt("appUpdateBuild", B0);
                            c23394wq6.p();
                        } catch (Exception unused) {
                        }
                    } else {
                        editorEdit.remove("appUpdate");
                    }
                    editorEdit.putLong("appUpdateCheckTime", C0);
                    editorEdit.apply();
                    SharedPreferences.Editor editorEdit2 = AbstractC14047hG.a.getSharedPreferences("mainconfig", 0).edit();
                    editorEdit2.putBoolean("hasEmailLogin", D0);
                    editorEdit2.putBoolean("floatingDebugActive", O0);
                    editorEdit2.putBoolean("record_via_sco", U);
                    editorEdit2.apply();
                } catch (Exception e2) {
                    AbstractC6403Nl2.d(e2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
