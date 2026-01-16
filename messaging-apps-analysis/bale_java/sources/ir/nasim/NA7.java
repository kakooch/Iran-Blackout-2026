package ir.nasim;

import android.os.RemoteException;
import com.google.android.gms.maps.model.RuntimeRemoteException;

/* loaded from: classes3.dex */
public final class NA7 {
    private final InterfaceC15688k03 a;

    NA7(InterfaceC15688k03 interfaceC15688k03) {
        this.a = interfaceC15688k03;
    }

    public void a(boolean z) {
        try {
            this.a.H(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
