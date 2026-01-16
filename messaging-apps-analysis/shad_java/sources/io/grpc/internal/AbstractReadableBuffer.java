package io.grpc.internal;

/* loaded from: classes3.dex */
public abstract class AbstractReadableBuffer implements ReadableBuffer {
    @Override // io.grpc.internal.ReadableBuffer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // io.grpc.internal.ReadableBuffer
    public void mark() {
    }

    @Override // io.grpc.internal.ReadableBuffer
    public boolean markSupported() {
        return false;
    }

    public final int readInt() {
        checkReadable(4);
        return (readUnsignedByte() << 24) | (readUnsignedByte() << 16) | (readUnsignedByte() << 8) | readUnsignedByte();
    }

    @Override // io.grpc.internal.ReadableBuffer
    public void reset() {
        throw new UnsupportedOperationException();
    }

    protected final void checkReadable(int i) {
        if (readableBytes() < i) {
            throw new IndexOutOfBoundsException();
        }
    }
}
