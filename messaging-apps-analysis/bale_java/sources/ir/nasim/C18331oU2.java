package ir.nasim;

import android.gov.nist.javax.sip.stack.SIPTransactionStack;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: ir.nasim.oU2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C18331oU2 {
    public static final boolean e;
    public static final boolean f;
    private static final File g;
    private static volatile C18331oU2 h;
    private int b;
    private boolean c = true;
    private final AtomicBoolean d = new AtomicBoolean(false);
    private final int a = 20000;

    static {
        int i = Build.VERSION.SDK_INT;
        e = i < 29;
        f = i >= 28;
        g = new File("/proc/self/fd");
    }

    C18331oU2() {
    }

    private boolean a() {
        return e && !this.d.get();
    }

    public static C18331oU2 b() {
        if (h == null) {
            synchronized (C18331oU2.class) {
                try {
                    if (h == null) {
                        h = new C18331oU2();
                    }
                } finally {
                }
            }
        }
        return h;
    }

    private int c() {
        return e() ? SIPTransactionStack.BASE_TIMER_INTERVAL : this.a;
    }

    private synchronized boolean d() {
        try {
            boolean z = true;
            int i = this.b + 1;
            this.b = i;
            if (i >= 50) {
                this.b = 0;
                int length = g.list().length;
                long jC = c();
                if (length >= jC) {
                    z = false;
                }
                this.c = z;
                if (!z && Log.isLoggable("Downsampler", 5)) {
                    Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + jC);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.c;
    }

    private static boolean e() {
        if (Build.VERSION.SDK_INT != 28) {
            return false;
        }
        Iterator it = Arrays.asList("GM1900", "GM1901", "GM1903", "GM1911", "GM1915", "ONEPLUS A3000", "ONEPLUS A3010", "ONEPLUS A5010", "ONEPLUS A5000", "ONEPLUS A3003", "ONEPLUS A6000", "ONEPLUS A6003", "ONEPLUS A6010", "ONEPLUS A6013").iterator();
        while (it.hasNext()) {
            if (Build.MODEL.startsWith((String) it.next())) {
                return true;
            }
        }
        return false;
    }

    public boolean f(int i, int i2, boolean z, boolean z2) {
        if (!z) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by caller");
            }
            return false;
        }
        if (!f) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by sdk");
            }
            return false;
        }
        if (a()) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by app state");
            }
            return false;
        }
        if (z2) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed because exif orientation is required");
            }
            return false;
        }
        if (i < 0 || i2 < 0) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed because of invalid dimensions");
            }
            return false;
        }
        if (d()) {
            return true;
        }
        if (Log.isLoggable("HardwareConfig", 2)) {
            Log.v("HardwareConfig", "Hardware config disallowed because there are insufficient FDs");
        }
        return false;
    }

    boolean g(int i, int i2, BitmapFactory.Options options, boolean z, boolean z2) {
        boolean zF = f(i, i2, z, z2);
        if (zF) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return zF;
    }

    public void h() {
        YM7.b();
        this.d.set(true);
    }
}
