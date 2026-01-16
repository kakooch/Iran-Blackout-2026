package ir.nasim;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.zzk;

/* renamed from: ir.nasim.wh8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractBinderC23306wh8 extends AbstractBinderC10511bj8 implements NZ2 {
    public AbstractBinderC23306wh8() {
        super("com.google.android.gms.common.internal.IGmsCallbacks");
    }

    @Override // ir.nasim.AbstractBinderC10511bj8
    protected final boolean B2(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            int i3 = parcel.readInt();
            IBinder strongBinder = parcel.readStrongBinder();
            Bundle bundle = (Bundle) Ek8.a(parcel, Bundle.CREATOR);
            Ek8.b(parcel);
            r0(i3, strongBinder, bundle);
        } else if (i == 2) {
            int i4 = parcel.readInt();
            Bundle bundle2 = (Bundle) Ek8.a(parcel, Bundle.CREATOR);
            Ek8.b(parcel);
            D1(i4, bundle2);
        } else {
            if (i != 3) {
                return false;
            }
            int i5 = parcel.readInt();
            IBinder strongBinder2 = parcel.readStrongBinder();
            zzk zzkVar = (zzk) Ek8.a(parcel, zzk.CREATOR);
            Ek8.b(parcel);
            s2(i5, strongBinder2, zzkVar);
        }
        parcel2.writeNoException();
        return true;
    }
}
