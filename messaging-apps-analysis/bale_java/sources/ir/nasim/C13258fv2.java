package ir.nasim;

import android.app.Notification;

/* renamed from: ir.nasim.fv2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C13258fv2 {
    private final int a;
    private final int b;
    private final Notification c;

    public C13258fv2(int i, Notification notification, int i2) {
        this.a = i;
        this.c = notification;
        this.b = i2;
    }

    public int a() {
        return this.b;
    }

    public Notification b() {
        return this.c;
    }

    public int c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C13258fv2.class != obj.getClass()) {
            return false;
        }
        C13258fv2 c13258fv2 = (C13258fv2) obj;
        if (this.a == c13258fv2.a && this.b == c13258fv2.b) {
            return this.c.equals(c13258fv2.c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.a * 31) + this.b) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "ForegroundInfo{mNotificationId=" + this.a + ", mForegroundServiceType=" + this.b + ", mNotification=" + this.c + '}';
    }
}
