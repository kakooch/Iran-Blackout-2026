package org.rbmain.messenger;

import org.rbmain.messenger.ChatObject;

/* loaded from: classes4.dex */
public final /* synthetic */ class ChatObject$Call$$ExternalSyntheticLambda4 implements Runnable {
    public final /* synthetic */ ChatObject.Call f$0;

    public /* synthetic */ ChatObject$Call$$ExternalSyntheticLambda4(ChatObject.Call call) {
        this.f$0 = call;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.checkQueue();
    }
}
