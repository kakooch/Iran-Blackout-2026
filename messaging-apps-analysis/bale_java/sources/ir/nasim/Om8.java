package ir.nasim;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.StreetViewPanoramaOptions;

/* loaded from: classes3.dex */
public final class Om8 extends Jg8 implements Cn8 {
    Om8(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.ICreator");
    }

    @Override // ir.nasim.Cn8
    public final RZ2 Q1(XZ2 xz2, GoogleMapOptions googleMapOptions) {
        RZ2 kr8;
        Parcel parcelC2 = C2();
        Hk8.e(parcelC2, xz2);
        Hk8.d(parcelC2, googleMapOptions);
        Parcel parcelB2 = B2(3, parcelC2);
        IBinder strongBinder = parcelB2.readStrongBinder();
        if (strongBinder == null) {
            kr8 = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
            kr8 = iInterfaceQueryLocalInterface instanceof RZ2 ? (RZ2) iInterfaceQueryLocalInterface : new Kr8(strongBinder);
        }
        parcelB2.recycle();
        return kr8;
    }

    @Override // ir.nasim.Cn8
    public final QZ2 U(XZ2 xz2) {
        QZ2 c14408hr8;
        Parcel parcelC2 = C2();
        Hk8.e(parcelC2, xz2);
        Parcel parcelB2 = B2(2, parcelC2);
        IBinder strongBinder = parcelB2.readStrongBinder();
        if (strongBinder == null) {
            c14408hr8 = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            c14408hr8 = iInterfaceQueryLocalInterface instanceof QZ2 ? (QZ2) iInterfaceQueryLocalInterface : new C14408hr8(strongBinder);
        }
        parcelB2.recycle();
        return c14408hr8;
    }

    @Override // ir.nasim.Cn8
    public final int d() {
        Parcel parcelB2 = B2(9, C2());
        int i = parcelB2.readInt();
        parcelB2.recycle();
        return i;
    }

    @Override // ir.nasim.Cn8
    public final void f2(XZ2 xz2, int i) {
        Parcel parcelC2 = C2();
        Hk8.e(parcelC2, xz2);
        parcelC2.writeInt(i);
        D2(10, parcelC2);
    }

    @Override // ir.nasim.Cn8
    public final InterfaceC24995zZ2 g() {
        InterfaceC24995zZ2 c16117kj8;
        Parcel parcelB2 = B2(4, C2());
        IBinder strongBinder = parcelB2.readStrongBinder();
        if (strongBinder == null) {
            c16117kj8 = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            c16117kj8 = iInterfaceQueryLocalInterface instanceof InterfaceC24995zZ2 ? (InterfaceC24995zZ2) iInterfaceQueryLocalInterface : new C16117kj8(strongBinder);
        }
        parcelB2.recycle();
        return c16117kj8;
    }

    @Override // ir.nasim.Cn8
    public final Xp8 m() {
        Parcel parcelB2 = B2(5, C2());
        Xp8 xp8C2 = Zo8.C2(parcelB2.readStrongBinder());
        parcelB2.recycle();
        return xp8C2;
    }

    @Override // ir.nasim.Cn8
    public final void n0(XZ2 xz2, int i) {
        Parcel parcelC2 = C2();
        Hk8.e(parcelC2, xz2);
        parcelC2.writeInt(i);
        D2(6, parcelC2);
    }

    @Override // ir.nasim.Cn8
    public final InterfaceC12670f03 x1(XZ2 xz2, StreetViewPanoramaOptions streetViewPanoramaOptions) {
        InterfaceC12670f03 c25110zk8;
        Parcel parcelC2 = C2();
        Hk8.e(parcelC2, xz2);
        Hk8.d(parcelC2, streetViewPanoramaOptions);
        Parcel parcelB2 = B2(7, parcelC2);
        IBinder strongBinder = parcelB2.readStrongBinder();
        if (strongBinder == null) {
            c25110zk8 = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
            c25110zk8 = iInterfaceQueryLocalInterface instanceof InterfaceC12670f03 ? (InterfaceC12670f03) iInterfaceQueryLocalInterface : new C25110zk8(strongBinder);
        }
        parcelB2.recycle();
        return c25110zk8;
    }
}
