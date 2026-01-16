package ir.nasim;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes3.dex */
public final class Vo8 extends Dg8 implements IInterface {
    Vo8(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.phone.internal.ISmsRetrieverApiService");
    }

    public final void D2(Dq8 dq8) {
        Parcel parcelB2 = B2();
        AbstractC9911al8.b(parcelB2, dq8);
        C2(1, parcelB2);
    }

    public final void E2(String str, Dq8 dq8) {
        Parcel parcelB2 = B2();
        parcelB2.writeString(str);
        AbstractC9911al8.b(parcelB2, dq8);
        C2(2, parcelB2);
    }
}
