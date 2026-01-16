package ir.nasim;

import android.os.IBinder;
import android.os.Parcel;
import ir.nasim.XZ2;

/* loaded from: classes3.dex */
public final class Gv8 extends Gg8 implements InterfaceC14306hh8 {
    Gv8(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    @Override // ir.nasim.InterfaceC14306hh8
    public final XZ2 d() {
        Parcel parcelB2 = B2(1, C2());
        XZ2 xz2C2 = XZ2.a.C2(parcelB2.readStrongBinder());
        parcelB2.recycle();
        return xz2C2;
    }

    @Override // ir.nasim.InterfaceC14306hh8
    public final int e() {
        Parcel parcelB2 = B2(2, C2());
        int i = parcelB2.readInt();
        parcelB2.recycle();
        return i;
    }
}
