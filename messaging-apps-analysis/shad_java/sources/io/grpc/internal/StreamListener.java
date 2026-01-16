package io.grpc.internal;

import java.io.InputStream;

/* loaded from: classes3.dex */
public interface StreamListener {

    public interface MessageProducer {
        InputStream next();
    }

    void messagesAvailable(MessageProducer messageProducer);

    void onReady();
}
