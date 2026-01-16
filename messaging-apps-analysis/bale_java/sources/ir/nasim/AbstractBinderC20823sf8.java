package ir.nasim;

import android.os.Parcel;
import com.google.android.gms.signin.internal.zak;

/* renamed from: ir.nasim.sf8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractBinderC20823sf8 extends Se8 implements InterfaceC23286wf8 {
    public AbstractBinderC20823sf8() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    @Override // ir.nasim.Se8
    protected final boolean B2(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 3:
                AbstractC11061cf8.b(parcel);
                break;
            case 4:
                AbstractC11061cf8.b(parcel);
                break;
            case 5:
            default:
                return false;
            case 6:
                AbstractC11061cf8.b(parcel);
                break;
            case 7:
                AbstractC11061cf8.b(parcel);
                break;
            case 8:
                zak zakVar = (zak) AbstractC11061cf8.a(parcel, zak.CREATOR);
                AbstractC11061cf8.b(parcel);
                T(zakVar);
                break;
            case 9:
                AbstractC11061cf8.b(parcel);
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
