package ir.nasim;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.maps.model.LatLng;
import ir.nasim.XZ2;

/* renamed from: ir.nasim.kj8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C16117kj8 extends Jg8 implements InterfaceC24995zZ2 {
    C16117kj8(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
    }

    @Override // ir.nasim.InterfaceC24995zZ2
    public final XZ2 T0(LatLng latLng, float f) {
        Parcel parcelC2 = C2();
        Hk8.d(parcelC2, latLng);
        parcelC2.writeFloat(f);
        Parcel parcelB2 = B2(9, parcelC2);
        XZ2 xz2C2 = XZ2.a.C2(parcelB2.readStrongBinder());
        parcelB2.recycle();
        return xz2C2;
    }
}
