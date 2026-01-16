package ir.nasim;

import android.os.Parcel;

/* renamed from: ir.nasim.rg8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractBinderC20240rg8 extends AbstractBinderC10481bg8 implements InterfaceC20833sg8 {
    public AbstractBinderC20240rg8() {
        super("com.google.android.gms.auth.api.signin.internal.IRevocationService");
    }

    @Override // ir.nasim.AbstractBinderC10481bg8
    protected final boolean B2(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            S();
        } else {
            if (i != 2) {
                return false;
            }
            E();
        }
        return true;
    }
}
