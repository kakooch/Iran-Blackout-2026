package ir.aaap.messengercore;

import ir.aaap.messengercore.model.LoadMessagesResult;

/* loaded from: classes3.dex */
public interface LoadMessagesListener {
    void onLoadingMessagesFailed(LoadMessagesResult loadMessagesResult);

    void onMessagesDidLoad(LoadMessagesResult loadMessagesResult);
}
