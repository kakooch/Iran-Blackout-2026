package com.google.zxing;

import java.util.EnumMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class Result {
    private final BarcodeFormat format;
    private final int numBits;
    private final byte[] rawBytes;
    private Map<ResultMetadataType, Object> resultMetadata;
    private ResultPoint[] resultPoints;
    private final String text;
    private final long timestamp;

    public Result(String text, byte[] rawBytes, ResultPoint[] resultPoints, BarcodeFormat format) {
        this(text, rawBytes, resultPoints, format, System.currentTimeMillis());
    }

    public Result(String text, byte[] rawBytes, ResultPoint[] resultPoints, BarcodeFormat format, long timestamp) {
        this(text, rawBytes, rawBytes == null ? 0 : rawBytes.length * 8, resultPoints, format, timestamp);
    }

    public Result(String text, byte[] rawBytes, int numBits, ResultPoint[] resultPoints, BarcodeFormat format, long timestamp) {
        this.text = text;
        this.rawBytes = rawBytes;
        this.numBits = numBits;
        this.resultPoints = resultPoints;
        this.format = format;
        this.resultMetadata = null;
        this.timestamp = timestamp;
    }

    public String getText() {
        return this.text;
    }

    public void putMetadata(ResultMetadataType type, Object value) {
        if (this.resultMetadata == null) {
            this.resultMetadata = new EnumMap(ResultMetadataType.class);
        }
        this.resultMetadata.put(type, value);
    }

    public String toString() {
        return this.text;
    }
}
