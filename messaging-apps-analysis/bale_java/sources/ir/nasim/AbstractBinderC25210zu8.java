package ir.nasim;

import android.os.Parcel;
import com.google.android.gms.location.LocationSettingsResult;

/* renamed from: ir.nasim.zu8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractBinderC25210zu8 extends AbstractBinderC11896dj8 implements Ju8 {
    public AbstractBinderC25210zu8() {
        super("com.google.android.gms.location.internal.ISettingsCallbacks");
    }

    @Override // ir.nasim.AbstractBinderC11896dj8
    protected final boolean B2(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        LocationSettingsResult locationSettingsResult = (LocationSettingsResult) Gk8.a(parcel, LocationSettingsResult.CREATOR);
        Gk8.b(parcel);
        W(locationSettingsResult);
        return true;
    }
}
