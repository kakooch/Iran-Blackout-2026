package ir.aaap.messengercore;

import ir.aaap.messengercore.model.GetTokenResult;

/* loaded from: classes3.dex */
public interface PushNotification {
    void getToken(LoadListener<GetTokenResult> loadListener);
}
