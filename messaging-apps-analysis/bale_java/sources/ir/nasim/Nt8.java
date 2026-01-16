package ir.nasim;

import android.location.Location;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;

/* loaded from: classes3.dex */
public abstract class Nt8 extends AbstractBinderC11896dj8 implements InterfaceC20382ru8 {
    public Nt8() {
        super("com.google.android.gms.location.internal.ILocationStatusCallback");
    }

    @Override // ir.nasim.AbstractBinderC11896dj8
    protected final boolean B2(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        Status status = (Status) Gk8.a(parcel, Status.CREATOR);
        Location location = (Location) Gk8.a(parcel, Location.CREATOR);
        Gk8.b(parcel);
        N(status, location);
        return true;
    }
}
