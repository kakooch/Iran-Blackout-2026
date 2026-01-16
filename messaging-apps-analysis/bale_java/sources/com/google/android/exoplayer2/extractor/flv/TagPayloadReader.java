package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.ParserException;
import ir.nasim.EW4;
import ir.nasim.InterfaceC4589Ft7;

/* loaded from: classes2.dex */
abstract class TagPayloadReader {
    protected final InterfaceC4589Ft7 a;

    public static final class UnsupportedFormatException extends ParserException {
        public UnsupportedFormatException(String str) {
            super(str, null, false, 1);
        }
    }

    protected TagPayloadReader(InterfaceC4589Ft7 interfaceC4589Ft7) {
        this.a = interfaceC4589Ft7;
    }

    public final boolean a(EW4 ew4, long j) {
        return b(ew4) && c(ew4, j);
    }

    protected abstract boolean b(EW4 ew4);

    protected abstract boolean c(EW4 ew4, long j);
}
