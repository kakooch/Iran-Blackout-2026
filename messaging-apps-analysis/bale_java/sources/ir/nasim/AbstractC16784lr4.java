package ir.nasim;

import android.content.Context;
import android.net.ConnectivityManager;
import ir.nasim.InterfaceC16193kr4;

/* renamed from: ir.nasim.lr4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC16784lr4 {
    public static final InterfaceC16193kr4 a(Context context, InterfaceC16193kr4.a aVar, II3 ii3) {
        ConnectivityManager connectivityManager = (ConnectivityManager) AbstractC4043Dl1.l(context, ConnectivityManager.class);
        if (connectivityManager == null || !AbstractC12665f.e(context, "android.permission.ACCESS_NETWORK_STATE")) {
            if (ii3 != null && ii3.a() <= 5) {
                ii3.b("NetworkObserver", 5, "Unable to register network observer.", null);
            }
            return new C24736z72();
        }
        try {
            return new HI5(connectivityManager, aVar);
        } catch (Exception e) {
            if (ii3 != null) {
                AbstractC16274l.a(ii3, "NetworkObserver", new RuntimeException("Failed to register network observer.", e));
            }
            return new C24736z72();
        }
    }
}
