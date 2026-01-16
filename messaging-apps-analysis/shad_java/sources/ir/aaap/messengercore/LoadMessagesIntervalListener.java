package ir.aaap.messengercore;

import ir.aaap.messengercore.model.LoadMessagesIntervalResult;

/* loaded from: classes3.dex */
public interface LoadMessagesIntervalListener {
    void onLoadingMessagesFailedInterval(LoadMessagesIntervalResult loadMessagesIntervalResult);

    void onMessagesDidLoadInterval(LoadMessagesIntervalResult loadMessagesIntervalResult);
}
