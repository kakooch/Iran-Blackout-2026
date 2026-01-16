package ir.nasim;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.measurement.internal.C2227d1;

/* loaded from: classes3.dex */
public final class Fn8 {
    private final En8 a;

    public Fn8(En8 en8) {
        AbstractC3795Cj5.j(en8);
        this.a = en8;
    }

    public final void a(Context context, Intent intent) {
        com.google.android.gms.measurement.internal.H1 h1H = com.google.android.gms.measurement.internal.H1.H(context, null, null);
        C2227d1 c2227d1B = h1H.b();
        if (intent == null) {
            c2227d1B.w().a("Receiver called with null intent");
            return;
        }
        h1H.d();
        String action = intent.getAction();
        c2227d1B.v().b("Local receiver got", action);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(action)) {
            if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
                c2227d1B.w().a("Install Referrer Broadcasts are deprecated");
            }
        } else {
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            c2227d1B.v().a("Starting wakeful intent.");
            this.a.a(context, className);
        }
    }
}
