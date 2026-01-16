package ir.nasim;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;

/* renamed from: ir.nasim.tu8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractBinderC21660tu8 extends AbstractBinderC11896dj8 implements Bu8 {
    public AbstractBinderC21660tu8() {
        super("com.google.android.gms.location.ILocationCallback");
    }

    public static Bu8 C2(IBinder iBinder) {
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationCallback");
        return iInterfaceQueryLocalInterface instanceof Bu8 ? (Bu8) iInterfaceQueryLocalInterface : new Pt8(iBinder);
    }

    @Override // ir.nasim.AbstractBinderC11896dj8
    protected final boolean B2(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            LocationResult locationResult = (LocationResult) Gk8.a(parcel, LocationResult.CREATOR);
            Gk8.b(parcel);
            T1(locationResult);
        } else if (i == 2) {
            LocationAvailability locationAvailability = (LocationAvailability) Gk8.a(parcel, LocationAvailability.CREATOR);
            Gk8.b(parcel);
            I0(locationAvailability);
        } else {
            if (i != 3) {
                return false;
            }
            n();
        }
        return true;
    }
}
