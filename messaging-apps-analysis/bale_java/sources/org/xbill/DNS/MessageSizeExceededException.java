package org.xbill.DNS;

import lombok.Generated;

/* loaded from: classes8.dex */
public final class MessageSizeExceededException extends Exception {
    private final int maxSize;

    MessageSizeExceededException(int i) {
        super("Message size would exceed the allowed maximum of " + i + " bytes");
        this.maxSize = i;
    }

    @Generated
    public int getMaxSize() {
        return this.maxSize;
    }
}
