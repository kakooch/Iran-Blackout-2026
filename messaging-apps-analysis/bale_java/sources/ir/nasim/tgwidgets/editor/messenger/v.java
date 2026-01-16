package ir.nasim.tgwidgets.editor.messenger;

import android.content.SharedPreferences;
import android.os.BatteryManager;
import ir.nasim.AbstractC14047hG;
import ir.nasim.AbstractC8662Wx6;
import ir.nasim.tgwidgets.editor.messenger.G;
import ir.nasim.tgwidgets.editor.messenger.Utilities;
import ir.nasim.tgwidgets.editor.ui.Components.C21463b;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes7.dex */
public abstract class v {
    public static int a = 2076;
    public static int b = 7775;
    public static int c = 65535;
    public static int d = 0;
    private static int e = 10;
    private static int f = 10;
    private static int g = 10;
    private static int h = 0;
    private static boolean i = false;
    private static int j = 0;
    private static boolean k = false;
    private static int l = -1;
    private static long m;
    private static HashSet n;

    public static int b() {
        BatteryManager batteryManager;
        if ((l < 0 || System.currentTimeMillis() - m > 12000) && (batteryManager = (BatteryManager) AbstractC14047hG.a.getSystemService("batterymanager")) != null) {
            l = batteryManager.getIntProperty(4);
            m = System.currentTimeMillis();
        }
        return l;
    }

    public static int c() {
        return d(false);
    }

    public static int d(boolean z) {
        if (!k) {
            g();
        }
        if (!z) {
            int iB = b();
            int i2 = h;
            if (iB <= i2 && i2 > 0) {
                if (!i) {
                    i = true;
                    i(true);
                }
                return d;
            }
            if (i) {
                i = false;
                i(false);
            }
        }
        return j;
    }

    public static boolean e(int i2) {
        if (i2 == 64 && AbstractC21455b.F0()) {
            return true;
        }
        return (j(i2) & c()) > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(boolean z) {
        Iterator it = n.iterator();
        while (it.hasNext()) {
            Utilities.b bVar = (Utilities.b) it.next();
            if (bVar != null) {
                bVar.a(Boolean.valueOf(z));
            }
        }
    }

    public static void g() {
        int i2 = c;
        int i3 = g;
        if (AbstractC8662Wx6.h() == 0) {
            i2 = a;
            i3 = e;
        } else if (AbstractC8662Wx6.h() == 1) {
            i2 = b;
            i3 = f;
        }
        SharedPreferences sharedPreferencesM = C.m();
        if (!sharedPreferencesM.contains("lite_mode2")) {
            if (sharedPreferencesM.contains("lite_mode")) {
                i2 = sharedPreferencesM.getInt("lite_mode", i2);
                if (i2 == 4095) {
                    i2 = c;
                }
            } else {
                if (sharedPreferencesM.contains("light_mode")) {
                    i2 = (sharedPreferencesM.getInt("light_mode", AbstractC8662Wx6.h() == 0 ? 1 : 0) & 1) > 0 ? a : c;
                }
                if (sharedPreferencesM.contains("loopStickers")) {
                    i2 = sharedPreferencesM.getBoolean("loopStickers", true) ? i2 | 2 : i2 & (-3);
                }
                if (sharedPreferencesM.contains("autoplay_video")) {
                    i2 = (sharedPreferencesM.getBoolean("autoplay_video", true) || sharedPreferencesM.getBoolean("autoplay_video_liteforce", false)) ? i2 | 1024 : i2 & (-1025);
                }
                if (sharedPreferencesM.contains("autoplay_gif")) {
                    i2 = sharedPreferencesM.getBoolean("autoplay_gif", true) ? i2 | 2048 : i2 & (-2049);
                }
                if (sharedPreferencesM.contains("chatBlur")) {
                    i2 = sharedPreferencesM.getBoolean("chatBlur", true) ? i2 | 256 : i2 & (-257);
                }
            }
        }
        int i4 = j;
        int i5 = sharedPreferencesM.getInt("lite_mode2", i2);
        j = i5;
        if (k) {
            h(i4, i5);
        }
        h = sharedPreferencesM.getInt("lite_mode_battery_level", i3);
        k = true;
    }

    private static void h(int i2, int i3) {
        int i4 = (~i2) & i3;
        if ((i4 & 28700) > 0) {
            C21463b.x();
        }
        int i5 = i4 & 32;
        if (i5 > 0) {
            G.j.l();
        }
        if (i5 > 0) {
            ir.nasim.tgwidgets.editor.ui.ActionBar.m.W0(true);
        }
    }

    private static void i(final boolean z) {
        if (z) {
            h(d(true), d);
        } else {
            h(d, d(true));
        }
        if (n != null) {
            AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.qC3
                @Override // java.lang.Runnable
                public final void run() {
                    ir.nasim.tgwidgets.editor.messenger.v.f(z);
                }
            });
        }
    }

    private static int j(int i2) {
        if ((i2 & 16388) > 0) {
            i2 = (i2 & (-16389)) | 4;
        }
        if ((i2 & 8200) > 0) {
            i2 = (i2 & (-8201)) | 8;
        }
        return (i2 & 4112) > 0 ? (i2 & (-4113)) | 16 : i2;
    }
}
