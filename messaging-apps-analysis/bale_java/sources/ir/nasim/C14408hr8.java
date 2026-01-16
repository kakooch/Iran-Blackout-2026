package ir.nasim;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.maps.GoogleMapOptions;
import ir.nasim.XZ2;

/* renamed from: ir.nasim.hr8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C14408hr8 extends Jg8 implements QZ2 {
    C14408hr8(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IMapFragmentDelegate");
    }

    @Override // ir.nasim.QZ2
    public final void W1(XZ2 xz2, GoogleMapOptions googleMapOptions, Bundle bundle) {
        Parcel parcelC2 = C2();
        Hk8.e(parcelC2, xz2);
        Hk8.d(parcelC2, googleMapOptions);
        Hk8.d(parcelC2, bundle);
        D2(2, parcelC2);
    }

    @Override // ir.nasim.QZ2
    public final XZ2 a2(XZ2 xz2, XZ2 xz22, Bundle bundle) {
        Parcel parcelC2 = C2();
        Hk8.e(parcelC2, xz2);
        Hk8.e(parcelC2, xz22);
        Hk8.d(parcelC2, bundle);
        Parcel parcelB2 = B2(4, parcelC2);
        XZ2 xz2C2 = XZ2.a.C2(parcelB2.readStrongBinder());
        parcelB2.recycle();
        return xz2C2;
    }

    @Override // ir.nasim.QZ2
    public final void f() {
        D2(15, C2());
    }

    @Override // ir.nasim.QZ2
    public final void i() {
        D2(16, C2());
    }

    @Override // ir.nasim.QZ2
    public final void k(Bundle bundle) {
        Parcel parcelC2 = C2();
        Hk8.d(parcelC2, bundle);
        D2(3, parcelC2);
    }

    @Override // ir.nasim.QZ2
    public final void l(Bundle bundle) {
        Parcel parcelC2 = C2();
        Hk8.d(parcelC2, bundle);
        Parcel parcelB2 = B2(10, parcelC2);
        if (parcelB2.readInt() != 0) {
            bundle.readFromParcel(parcelB2);
        }
        parcelB2.recycle();
    }

    @Override // ir.nasim.QZ2
    public final void onDestroy() {
        D2(8, C2());
    }

    @Override // ir.nasim.QZ2
    public final void onLowMemory() {
        D2(9, C2());
    }

    @Override // ir.nasim.QZ2
    public final void onPause() {
        D2(6, C2());
    }

    @Override // ir.nasim.QZ2
    public final void onResume() {
        D2(5, C2());
    }

    @Override // ir.nasim.QZ2
    public final void u() {
        D2(7, C2());
    }

    @Override // ir.nasim.QZ2
    public final void w(Bi8 bi8) {
        Parcel parcelC2 = C2();
        Hk8.e(parcelC2, bi8);
        D2(12, parcelC2);
    }
}
