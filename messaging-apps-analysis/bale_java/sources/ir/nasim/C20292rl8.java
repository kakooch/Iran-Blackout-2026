package ir.nasim;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* renamed from: ir.nasim.rl8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C20292rl8 extends AbstractC10521bk8 implements InterfaceC20883sl8 {
    C20292rl8(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    @Override // ir.nasim.InterfaceC20883sl8
    public final void b(String str, String str2, Bundle bundle, long j) {
        Parcel parcelB2 = B2();
        parcelB2.writeString(str);
        parcelB2.writeString(str2);
        AbstractC13154fk8.e(parcelB2, bundle);
        parcelB2.writeLong(j);
        D2(1, parcelB2);
    }

    @Override // ir.nasim.InterfaceC20883sl8
    public final int d() {
        Parcel parcelC2 = C2(2, B2());
        int i = parcelC2.readInt();
        parcelC2.recycle();
        return i;
    }
}
