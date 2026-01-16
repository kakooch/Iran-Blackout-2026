package ir.nasim;

import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;

/* loaded from: classes3.dex */
public abstract class OD0 {
    private static InterfaceC24995zZ2 a;

    public static ND0 a(LatLng latLng, float f) {
        AbstractC3795Cj5.k(latLng, "latLng must not be null");
        try {
            return new ND0(c().T0(latLng, f));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static void b(InterfaceC24995zZ2 interfaceC24995zZ2) {
        a = (InterfaceC24995zZ2) AbstractC3795Cj5.j(interfaceC24995zZ2);
    }

    private static InterfaceC24995zZ2 c() {
        return (InterfaceC24995zZ2) AbstractC3795Cj5.k(a, "CameraUpdateFactory is not initialized");
    }
}
