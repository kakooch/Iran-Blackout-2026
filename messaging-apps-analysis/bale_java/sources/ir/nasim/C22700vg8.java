package ir.nasim;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

/* renamed from: ir.nasim.vg8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C22700vg8 extends Yf8 implements IInterface {
    C22700vg8(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.signin.internal.ISignInService");
    }

    public final void D2(InterfaceC22110ug8 interfaceC22110ug8, GoogleSignInOptions googleSignInOptions) {
        Parcel parcelB2 = B2();
        AbstractC12478eg8.c(parcelB2, interfaceC22110ug8);
        AbstractC12478eg8.b(parcelB2, googleSignInOptions);
        C2(103, parcelB2);
    }

    public final void E2(InterfaceC22110ug8 interfaceC22110ug8, GoogleSignInOptions googleSignInOptions) {
        Parcel parcelB2 = B2();
        AbstractC12478eg8.c(parcelB2, interfaceC22110ug8);
        AbstractC12478eg8.b(parcelB2, googleSignInOptions);
        C2(102, parcelB2);
    }
}
