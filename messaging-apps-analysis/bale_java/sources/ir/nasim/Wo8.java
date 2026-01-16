package ir.nasim;

import android.util.Log;
import com.google.android.gms.clearcut.zze;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.AbstractC2058b;

/* loaded from: classes3.dex */
final class Wo8 extends AbstractC2058b {
    private final zze c;

    Wo8(zze zzeVar, com.google.android.gms.common.api.c cVar) {
        super(com.google.android.gms.clearcut.a.p, cVar);
        this.c = zzeVar;
    }

    @Override // com.google.android.gms.common.api.internal.AbstractC2058b
    protected final /* synthetic */ void d(a.b bVar) {
        Eq8 eq8 = (Eq8) bVar;
        Up8 up8 = new Up8(this);
        try {
            zze zzeVar = this.c;
            zzeVar.getClass();
            C12568ep8 c12568ep8 = zzeVar.i;
            int iD = c12568ep8.d();
            byte[] bArr = new byte[iD];
            AbstractC10561bo8.c(c12568ep8, bArr, 0, iD);
            zzeVar.b = bArr;
            ((InterfaceC22230us8) eq8.D()).J1(up8, this.c);
        } catch (RuntimeException e) {
            Log.e("ClearcutLoggerApiImpl", "derived ClearcutLogger.MessageProducer ", e);
            h(new Status(10, "MessageProducer"));
        }
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    protected final /* synthetic */ InterfaceC10069b16 a(Status status) {
        return status;
    }
}
