package ir.nasim;

import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;

/* renamed from: ir.nasim.tg8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractBinderC21453tg8 extends AbstractBinderC10481bg8 implements InterfaceC22110ug8 {
    public AbstractBinderC21453tg8() {
        super("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
    }

    @Override // ir.nasim.AbstractBinderC10481bg8
    protected final boolean B2(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 101:
                p0((GoogleSignInAccount) AbstractC12478eg8.a(parcel, GoogleSignInAccount.CREATOR), (Status) AbstractC12478eg8.a(parcel, Status.CREATOR));
                break;
            case 102:
                e2((Status) AbstractC12478eg8.a(parcel, Status.CREATOR));
                break;
            case 103:
                P1((Status) AbstractC12478eg8.a(parcel, Status.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
