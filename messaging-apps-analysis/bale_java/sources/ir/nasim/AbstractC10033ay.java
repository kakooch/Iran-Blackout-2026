package ir.nasim;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.Status;

/* renamed from: ir.nasim.ay, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC10033ay {
    public static ApiException a(Status status) {
        return status.s0() ? new ResolvableApiException(status) : new ApiException(status);
    }
}
