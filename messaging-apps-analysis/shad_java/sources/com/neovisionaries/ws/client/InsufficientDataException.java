package com.neovisionaries.ws.client;

/* loaded from: classes3.dex */
class InsufficientDataException extends WebSocketException {
    private final int mReadByteCount;

    public InsufficientDataException(int i, int i2) {
        super(WebSocketError.INSUFFICENT_DATA, "The end of the stream has been reached unexpectedly.");
        this.mReadByteCount = i2;
    }

    public int getReadByteCount() {
        return this.mReadByteCount;
    }
}
