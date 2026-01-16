package io.appmetrica.analytics.networktasks.internal;

import io.appmetrica.analytics.networktasks.internal.DefaultResponseParser;

/* loaded from: classes3.dex */
public class DefaultNetworkResponseHandler implements NetworkResponseHandler<DefaultResponseParser.Response> {
    private final DefaultResponseParser a;

    public DefaultNetworkResponseHandler() {
        this(new DefaultResponseParser());
    }

    DefaultNetworkResponseHandler(DefaultResponseParser defaultResponseParser) {
        this.a = defaultResponseParser;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.appmetrica.analytics.networktasks.internal.NetworkResponseHandler
    public DefaultResponseParser.Response handle(ResponseDataHolder responseDataHolder) {
        if (200 == responseDataHolder.getResponseCode()) {
            return this.a.parse(responseDataHolder.getResponseData());
        }
        return null;
    }
}
