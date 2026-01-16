package ir.nasim;

import android.content.Context;
import android.util.Log;
import ir.nasim.InterfaceC4439Fd1;

/* loaded from: classes2.dex */
public class DD1 implements InterfaceC4688Gd1 {
    @Override // ir.nasim.InterfaceC4688Gd1
    public InterfaceC4439Fd1 a(Context context, InterfaceC4439Fd1.a aVar) {
        boolean z = AbstractC4043Dl1.a(context, "android.permission.ACCESS_NETWORK_STATE") == 0;
        if (Log.isLoggable("ConnectivityMonitor", 3)) {
            Log.d("ConnectivityMonitor", z ? "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor" : "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor");
        }
        return z ? new CD1(context, aVar) : new C9608aF4();
    }
}
