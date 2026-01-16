package ir.nasim;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.versionedparcelable.ParcelImpl;

/* renamed from: ir.nasim.xW4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC23786xW4 {
    public static InterfaceC12954fS7 a(Parcelable parcelable) {
        if (parcelable instanceof ParcelImpl) {
            return ((ParcelImpl) parcelable).a();
        }
        throw new IllegalArgumentException("Invalid parcel");
    }

    public static InterfaceC12954fS7 b(Bundle bundle, String str) {
        try {
            Bundle bundle2 = (Bundle) bundle.getParcelable(str);
            if (bundle2 == null) {
                return null;
            }
            bundle2.setClassLoader(AbstractC23786xW4.class.getClassLoader());
            return a(bundle2.getParcelable("a"));
        } catch (RuntimeException unused) {
            return null;
        }
    }

    public static void c(Bundle bundle, String str, InterfaceC12954fS7 interfaceC12954fS7) {
        if (interfaceC12954fS7 == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("a", d(interfaceC12954fS7));
        bundle.putParcelable(str, bundle2);
    }

    public static Parcelable d(InterfaceC12954fS7 interfaceC12954fS7) {
        return new ParcelImpl(interfaceC12954fS7);
    }
}
