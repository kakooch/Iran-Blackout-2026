package ir.nasim;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import ir.nasim.XZ2;

/* renamed from: ir.nasim.zk8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C25110zk8 extends Jg8 implements InterfaceC12670f03 {
    C25110zk8(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
    }

    @Override // ir.nasim.InterfaceC12670f03
    public final void X0(InterfaceC18491ok8 interfaceC18491ok8) {
        Parcel parcelC2 = C2();
        Hk8.e(parcelC2, interfaceC18491ok8);
        D2(9, parcelC2);
    }

    @Override // ir.nasim.InterfaceC12670f03
    public final void f() {
        D2(10, C2());
    }

    @Override // ir.nasim.InterfaceC12670f03
    public final XZ2 getView() {
        Parcel parcelB2 = B2(8, C2());
        XZ2 xz2C2 = XZ2.a.C2(parcelB2.readStrongBinder());
        parcelB2.recycle();
        return xz2C2;
    }

    @Override // ir.nasim.InterfaceC12670f03
    public final void i() {
        D2(11, C2());
    }

    @Override // ir.nasim.InterfaceC12670f03
    public final void k(Bundle bundle) {
        Parcel parcelC2 = C2();
        Hk8.d(parcelC2, bundle);
        D2(2, parcelC2);
    }

    @Override // ir.nasim.InterfaceC12670f03
    public final void l(Bundle bundle) {
        Parcel parcelC2 = C2();
        Hk8.d(parcelC2, bundle);
        Parcel parcelB2 = B2(7, parcelC2);
        if (parcelB2.readInt() != 0) {
            bundle.readFromParcel(parcelB2);
        }
        parcelB2.recycle();
    }

    @Override // ir.nasim.InterfaceC12670f03
    public final void onDestroy() {
        D2(5, C2());
    }

    @Override // ir.nasim.InterfaceC12670f03
    public final void onLowMemory() {
        D2(6, C2());
    }

    @Override // ir.nasim.InterfaceC12670f03
    public final void onPause() {
        D2(4, C2());
    }

    @Override // ir.nasim.InterfaceC12670f03
    public final void onResume() {
        D2(3, C2());
    }
}
