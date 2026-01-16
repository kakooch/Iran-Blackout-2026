package ir.nasim;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* renamed from: ir.nasim.hk8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C14338hk8 extends AbstractC10521bk8 implements InterfaceC17309mk8 {
    C14338hk8(IBinder iBinder) {
        super(iBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
    }

    @Override // ir.nasim.InterfaceC17309mk8
    public final Bundle K1(Bundle bundle) {
        Parcel parcelB2 = B2();
        AbstractC13154fk8.e(parcelB2, bundle);
        Parcel parcelC2 = C2(1, parcelB2);
        Bundle bundle2 = (Bundle) AbstractC13154fk8.a(parcelC2, Bundle.CREATOR);
        parcelC2.recycle();
        return bundle2;
    }
}
