package ir.nasim;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;

/* loaded from: classes3.dex */
public abstract class Tp8 extends Yi8 implements Dq8 {
    public Tp8() {
        super("com.google.android.gms.auth.api.phone.internal.ISmsRetrieverResultCallback");
    }

    @Override // ir.nasim.Yi8
    protected final boolean B2(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        a((Status) AbstractC9911al8.a(parcel, Status.CREATOR));
        return true;
    }
}
