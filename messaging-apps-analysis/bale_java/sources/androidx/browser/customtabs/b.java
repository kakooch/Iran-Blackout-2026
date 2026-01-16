package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.os.IBinder;
import ir.nasim.AZ2;
import ir.nasim.AbstractC3683Bx1;

/* loaded from: classes.dex */
public class b {
    final AZ2 a;
    private final PendingIntent b;
    private final AbstractC3683Bx1 c;

    class a extends AbstractC3683Bx1 {
        a() {
        }
    }

    b(AZ2 az2, PendingIntent pendingIntent) {
        if (az2 == null && pendingIntent == null) {
            throw new IllegalStateException("CustomTabsSessionToken must have either a session id or a callback (or both).");
        }
        this.a = az2;
        this.b = pendingIntent;
        this.c = az2 == null ? null : new a();
    }

    private IBinder b() {
        AZ2 az2 = this.a;
        if (az2 != null) {
            return az2.asBinder();
        }
        throw new IllegalStateException("CustomTabSessionToken must have valid binder or pending session");
    }

    IBinder a() {
        AZ2 az2 = this.a;
        if (az2 == null) {
            return null;
        }
        return az2.asBinder();
    }

    PendingIntent c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        PendingIntent pendingIntentC = bVar.c();
        PendingIntent pendingIntent = this.b;
        if ((pendingIntent == null) != (pendingIntentC == null)) {
            return false;
        }
        return pendingIntent != null ? pendingIntent.equals(pendingIntentC) : b().equals(bVar.b());
    }

    public int hashCode() {
        PendingIntent pendingIntent = this.b;
        return pendingIntent != null ? pendingIntent.hashCode() : b().hashCode();
    }
}
