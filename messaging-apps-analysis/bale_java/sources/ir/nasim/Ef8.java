package ir.nasim;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;

/* loaded from: classes3.dex */
final class Ef8 extends BasePendingResult {
    private final InterfaceC10069b16 a;

    public Ef8(com.google.android.gms.common.api.c cVar, InterfaceC10069b16 interfaceC10069b16) {
        super(cVar);
        this.a = interfaceC10069b16;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    protected final InterfaceC10069b16 a(Status status) {
        return this.a;
    }
}
