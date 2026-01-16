package com.neovisionaries.ws.client;

import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class OpeningHandshakeException extends WebSocketException {
    private final Map<String, List<String>> mHeaders;

    OpeningHandshakeException(WebSocketError webSocketError, String str, StatusLine statusLine, Map<String, List<String>> map) {
        this(webSocketError, str, statusLine, map, null);
    }

    OpeningHandshakeException(WebSocketError webSocketError, String str, StatusLine statusLine, Map<String, List<String>> map, byte[] bArr) {
        super(webSocketError, str);
        this.mHeaders = map;
    }
}
