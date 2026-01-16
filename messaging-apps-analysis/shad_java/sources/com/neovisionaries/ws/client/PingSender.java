package com.neovisionaries.ws.client;

/* loaded from: classes3.dex */
class PingSender extends PeriodicalFrameSender {
    public PingSender(WebSocket webSocket, PayloadGenerator payloadGenerator) {
        super(webSocket, "PingSender", payloadGenerator);
    }

    @Override // com.neovisionaries.ws.client.PeriodicalFrameSender
    protected WebSocketFrame createFrame(byte[] bArr) {
        return WebSocketFrame.createPingFrame(bArr);
    }
}
