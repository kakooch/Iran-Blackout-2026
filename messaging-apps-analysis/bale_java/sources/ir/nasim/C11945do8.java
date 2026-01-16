package ir.nasim;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.MapStyleOptions;

/* renamed from: ir.nasim.do8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C11945do8 extends Jg8 implements PZ2 {
    C11945do8(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IGoogleMapDelegate");
    }

    @Override // ir.nasim.PZ2
    public final boolean G1(MapStyleOptions mapStyleOptions) {
        Parcel parcelC2 = C2();
        Hk8.d(parcelC2, mapStyleOptions);
        Parcel parcelB2 = B2(91, parcelC2);
        boolean zF = Hk8.f(parcelB2);
        parcelB2.recycle();
        return zF;
    }

    @Override // ir.nasim.PZ2
    public final void O1(boolean z) {
        Parcel parcelC2 = C2();
        Hk8.c(parcelC2, z);
        D2(18, parcelC2);
    }

    @Override // ir.nasim.PZ2
    public final CameraPosition a0() {
        Parcel parcelB2 = B2(1, C2());
        CameraPosition cameraPosition = (CameraPosition) Hk8.a(parcelB2, CameraPosition.CREATOR);
        parcelB2.recycle();
        return cameraPosition;
    }

    @Override // ir.nasim.PZ2
    public final void h2(XZ2 xz2) {
        Parcel parcelC2 = C2();
        Hk8.e(parcelC2, xz2);
        D2(5, parcelC2);
    }

    @Override // ir.nasim.PZ2
    public final InterfaceC15688k03 i2() {
        InterfaceC15688k03 bk8;
        Parcel parcelB2 = B2(25, C2());
        IBinder strongBinder = parcelB2.readStrongBinder();
        if (strongBinder == null) {
            bk8 = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            bk8 = iInterfaceQueryLocalInterface instanceof InterfaceC15688k03 ? (InterfaceC15688k03) iInterfaceQueryLocalInterface : new Bk8(strongBinder);
        }
        parcelB2.recycle();
        return bk8;
    }

    @Override // ir.nasim.PZ2
    public final void p2(boolean z) {
        Parcel parcelC2 = C2();
        Hk8.c(parcelC2, z);
        D2(22, parcelC2);
    }

    @Override // ir.nasim.PZ2
    public final void q0(XZ2 xz2) {
        Parcel parcelC2 = C2();
        Hk8.e(parcelC2, xz2);
        D2(4, parcelC2);
    }

    @Override // ir.nasim.PZ2
    public final void t0(int i) {
        Parcel parcelC2 = C2();
        parcelC2.writeInt(i);
        D2(16, parcelC2);
    }
}
