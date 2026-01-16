package ir.nasim;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes3.dex */
public final class Bk8 extends Jg8 implements InterfaceC15688k03 {
    Bk8(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IUiSettingsDelegate");
    }

    @Override // ir.nasim.InterfaceC15688k03
    public final void H(boolean z) {
        Parcel parcelC2 = C2();
        Hk8.c(parcelC2, z);
        D2(3, parcelC2);
    }
}
