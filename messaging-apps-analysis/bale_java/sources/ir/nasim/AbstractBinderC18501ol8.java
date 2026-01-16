package ir.nasim;

import android.os.Bundle;
import android.os.Parcel;

/* renamed from: ir.nasim.ol8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractBinderC18501ol8 extends AbstractBinderC11906dk8 implements InterfaceC19683ql8 {
    public AbstractBinderC18501ol8() {
        super("com.google.android.gms.measurement.api.internal.IBundleReceiver");
    }

    @Override // ir.nasim.AbstractBinderC11906dk8
    protected final boolean B2(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        Bundle bundle = (Bundle) AbstractC13154fk8.a(parcel, Bundle.CREATOR);
        AbstractC13154fk8.c(parcel);
        F1(bundle);
        parcel2.writeNoException();
        return true;
    }
}
