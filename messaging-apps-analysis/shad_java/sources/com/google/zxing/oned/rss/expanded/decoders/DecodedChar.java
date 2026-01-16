package com.google.zxing.oned.rss.expanded.decoders;

/* loaded from: classes3.dex */
final class DecodedChar extends DecodedObject {
    private final char value;

    DecodedChar(int i, char c) {
        super(i);
        this.value = c;
    }

    char getValue() {
        return this.value;
    }

    boolean isFNC1() {
        return this.value == '$';
    }
}
