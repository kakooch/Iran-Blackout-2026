package ir.nasim;

import android.os.SystemClock;
import java.io.File;

/* renamed from: ir.nasim.fl2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C13158fl2 {
    public static final C13158fl2 a = new C13158fl2();
    private static final File b = new File("/proc/self/fd");
    private static int c = 30;
    private static long d = SystemClock.uptimeMillis();
    private static boolean e = true;

    private C13158fl2() {
    }

    private final boolean a() {
        int i = c;
        c = i + 1;
        return i >= 30 || SystemClock.uptimeMillis() > d + ((long) 30000);
    }

    public final synchronized boolean b(II3 ii3) {
        try {
            if (a()) {
                c = 0;
                d = SystemClock.uptimeMillis();
                String[] list = b.list();
                if (list == null) {
                    list = new String[0];
                }
                int length = list.length;
                boolean z = length < 800;
                e = z;
                if (!z && ii3 != null && ii3.a() <= 5) {
                    ii3.b("FileDescriptorCounter", 5, "Unable to allocate more hardware bitmaps. Number of used file descriptors: " + length, null);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return e;
    }
}
