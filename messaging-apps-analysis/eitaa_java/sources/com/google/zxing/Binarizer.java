package com.google.zxing;

import com.google.zxing.common.BitMatrix;

/* loaded from: classes.dex */
public abstract class Binarizer {
    private final LuminanceSource source;

    public abstract BitMatrix getBlackMatrix() throws NotFoundException;

    protected Binarizer(LuminanceSource source) {
        this.source = source;
    }

    public final LuminanceSource getLuminanceSource() {
        return this.source;
    }
}
