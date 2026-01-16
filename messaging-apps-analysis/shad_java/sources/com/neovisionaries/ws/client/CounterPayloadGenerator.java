package com.neovisionaries.ws.client;

/* loaded from: classes3.dex */
class CounterPayloadGenerator implements PayloadGenerator {
    private long mCount;

    CounterPayloadGenerator() {
    }

    @Override // com.neovisionaries.ws.client.PayloadGenerator
    public byte[] generate() {
        return Misc.getBytesUTF8(String.valueOf(increment()));
    }

    private long increment() {
        long jMax = Math.max(this.mCount + 1, 1L);
        this.mCount = jMax;
        return jMax;
    }
}
