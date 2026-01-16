package ir.nasim;

import android.os.Looper;
import android.os.Message;

/* renamed from: ir.nasim.mh8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class HandlerC17279mh8 extends HandlerC23956xn8 {
    final /* synthetic */ N66 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC17279mh8(N66 n66, Looper looper) {
        super(looper);
        this.a = n66;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        N66.d(this.a, message);
    }
}
