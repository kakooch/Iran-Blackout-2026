package ir.nasim;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes3.dex */
public final class Wl8 extends Ag8 implements InterfaceC22180un8 {
    Wl8(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
    }

    @Override // ir.nasim.InterfaceC22180un8
    public final boolean R(boolean z) {
        Parcel parcelB2 = B2();
        Yk8.a(parcelB2, true);
        Parcel parcelC2 = C2(2, parcelB2);
        boolean zB = Yk8.b(parcelC2);
        parcelC2.recycle();
        return zB;
    }

    @Override // ir.nasim.InterfaceC22180un8
    public final boolean d() {
        Parcel parcelC2 = C2(6, B2());
        boolean zB = Yk8.b(parcelC2);
        parcelC2.recycle();
        return zB;
    }

    @Override // ir.nasim.InterfaceC22180un8
    public final String e() {
        Parcel parcelC2 = C2(1, B2());
        String string = parcelC2.readString();
        parcelC2.recycle();
        return string;
    }
}
