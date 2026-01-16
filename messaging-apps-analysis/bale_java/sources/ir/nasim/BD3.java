package ir.nasim;

import android.content.Context;
import android.content.Intent;
import ir.nasim.live.LiveActivity;

/* loaded from: classes6.dex */
public final class BD3 implements InterfaceC24798zD3 {
    @Override // ir.nasim.InterfaceC24798zD3
    public Intent a(Context context, String str, AbstractC12888fL4 abstractC12888fL4) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(str, "url");
        AbstractC13042fc3.i(abstractC12888fL4, "openingSource");
        return LiveActivity.INSTANCE.b(context, str, abstractC12888fL4);
    }

    @Override // ir.nasim.InterfaceC24798zD3
    public Intent b(Context context, long j, AbstractC12888fL4 abstractC12888fL4) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(abstractC12888fL4, "openingSource");
        return LiveActivity.INSTANCE.a(context, j, abstractC12888fL4);
    }
}
