package ir.eitaa.messenger;

import ir.eitaa.messenger.ChatObject;

/* compiled from: lambda */
/* renamed from: ir.eitaa.messenger.-$$Lambda$ChatObject$Call$qDlsUfpBbrIWrBzcI0AefskOldo, reason: invalid class name */
/* loaded from: classes.dex */
public final /* synthetic */ class $$Lambda$ChatObject$Call$qDlsUfpBbrIWrBzcI0AefskOldo implements Runnable {
    public final /* synthetic */ ChatObject.Call f$0;

    public /* synthetic */ $$Lambda$ChatObject$Call$qDlsUfpBbrIWrBzcI0AefskOldo(ChatObject.Call call) {
        this.f$0 = call;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.checkQueue();
    }
}
