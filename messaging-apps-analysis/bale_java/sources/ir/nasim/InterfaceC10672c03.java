package ir.nasim;

import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;

/* renamed from: ir.nasim.c03, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public interface InterfaceC10672c03 extends IInterface {

    /* renamed from: ir.nasim.c03$a */
    public static abstract class a extends Se8 implements InterfaceC10672c03 {
        public a() {
            super("com.google.android.gms.common.api.internal.IStatusCallback");
        }

        @Override // ir.nasim.Se8
        protected final boolean B2(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i != 1) {
                return false;
            }
            Status status = (Status) AbstractC11061cf8.a(parcel, Status.CREATOR);
            AbstractC11061cf8.b(parcel);
            B1(status);
            return true;
        }
    }

    void B1(Status status);
}
