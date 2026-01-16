package ir.nasim;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes2.dex */
public interface MZ2 extends IInterface {

    public static abstract class a extends AbstractBinderC11836dd8 implements MZ2 {

        /* renamed from: ir.nasim.MZ2$a$a, reason: collision with other inner class name */
        public static class C0500a extends AbstractC11041cd8 implements MZ2 {
            C0500a(IBinder iBinder) {
                super(iBinder);
            }

            @Override // ir.nasim.MZ2
            public final Bundle e0(Bundle bundle) {
                Parcel parcelB2 = B2();
                AbstractC12448ed8.b(parcelB2, bundle);
                Parcel parcelC2 = C2(parcelB2);
                Bundle bundle2 = (Bundle) AbstractC12448ed8.a(parcelC2, Bundle.CREATOR);
                parcelC2.recycle();
                return bundle2;
            }
        }

        public static MZ2 B2(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
            return iInterfaceQueryLocalInterface instanceof MZ2 ? (MZ2) iInterfaceQueryLocalInterface : new C0500a(iBinder);
        }
    }

    Bundle e0(Bundle bundle);
}
