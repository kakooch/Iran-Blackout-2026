package com.google.zxing;

/* loaded from: classes3.dex */
public final class ChecksumException extends ReaderException {
    private static final ChecksumException c;

    static {
        ChecksumException checksumException = new ChecksumException();
        c = checksumException;
        checksumException.setStackTrace(ReaderException.b);
    }

    private ChecksumException() {
    }

    public static ChecksumException a() {
        return ReaderException.a ? new ChecksumException() : c;
    }
}
