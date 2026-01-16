package ir.nasim;

import android.app.Notification;
import android.app.Service;
import android.os.Build;

/* renamed from: ir.nasim.Zq6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC9374Zq6 {

    /* renamed from: ir.nasim.Zq6$a */
    static class a {
        static void a(Service service, int i) {
            service.stopForeground(i);
        }
    }

    /* renamed from: ir.nasim.Zq6$b */
    static class b {
        static void a(Service service, int i, Notification notification, int i2) {
            if (i2 == 0 || i2 == -1) {
                service.startForeground(i, notification, i2);
            } else {
                service.startForeground(i, notification, i2 & 255);
            }
        }
    }

    /* renamed from: ir.nasim.Zq6$c */
    static class c {
        static void a(Service service, int i, Notification notification, int i2) {
            if (i2 == 0 || i2 == -1) {
                service.startForeground(i, notification, i2);
            } else {
                service.startForeground(i, notification, i2 & 1073745919);
            }
        }
    }

    public static void a(Service service, int i, Notification notification, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 34) {
            c.a(service, i, notification, i2);
        } else if (i3 >= 29) {
            b.a(service, i, notification, i2);
        } else {
            service.startForeground(i, notification);
        }
    }

    public static void b(Service service, int i) {
        a.a(service, i);
    }
}
