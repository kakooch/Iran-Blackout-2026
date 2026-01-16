package ir.nasim;

import android.os.RemoteException;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class UJ2 {
    private final PZ2 a;
    private final HashMap b = new HashMap();
    private NA7 c;

    public UJ2(PZ2 pz2) {
        this.a = (PZ2) AbstractC3795Cj5.j(pz2);
    }

    public final void a(ND0 nd0) {
        try {
            AbstractC3795Cj5.k(nd0, "CameraUpdate must not be null.");
            this.a.h2(nd0.a());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final CameraPosition b() {
        try {
            return this.a.a0();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final NA7 c() {
        try {
            if (this.c == null) {
                this.c = new NA7(this.a.i2());
            }
            return this.c;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void d(ND0 nd0) {
        try {
            AbstractC3795Cj5.k(nd0, "CameraUpdate must not be null.");
            this.a.q0(nd0.a());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean e(MapStyleOptions mapStyleOptions) {
        try {
            return this.a.G1(mapStyleOptions);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void f(int i) {
        try {
            this.a.t0(i);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void g(boolean z) {
        try {
            this.a.p2(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void h(boolean z) {
        try {
            this.a.O1(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
