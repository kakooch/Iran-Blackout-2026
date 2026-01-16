package ir.nasim;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.internal.TelemetryData;

/* loaded from: classes3.dex */
public final class Hf8 extends Le8 implements IInterface {
    Hf8(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.service.IClientTelemetryService");
    }

    public final void F2(TelemetryData telemetryData) {
        Parcel parcelB2 = B2();
        AbstractC11061cf8.c(parcelB2, telemetryData);
        E2(1, parcelB2);
    }
}
