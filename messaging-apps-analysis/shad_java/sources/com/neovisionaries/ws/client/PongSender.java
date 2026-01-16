package com.neovisionaries.ws.client;

/* loaded from: classes3.dex */
class PongSender extends PeriodicalFrameSender {
    public PongSender(WebSocket webSocket, PayloadGenerator payloadGenerator) {
        super(webSocket, "PongSender", payloadGenerator);
    }

    @Override // com.neovisionaries.ws.client.PeriodicalFrameSender
    protected WebSocketFrame createFrame(byte[] bArr) {
        return WebSocketFrame.createPongFrame(bArr);
    }
}
