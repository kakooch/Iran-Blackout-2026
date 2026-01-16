package okio;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;

/* loaded from: classes4.dex */
public interface BufferedSink extends Sink, WritableByteChannel {
    Buffer buffer();

    BufferedSink emitCompleteSegments() throws IOException;

    @Override // okio.Sink, java.io.Flushable
    void flush() throws IOException;

    BufferedSink write(ByteString byteString) throws IOException;

    BufferedSink write(byte[] bArr) throws IOException;

    BufferedSink write(byte[] bArr, int i, int i2) throws IOException;

    BufferedSink writeByte(int i) throws IOException;

    BufferedSink writeDecimalLong(long j) throws IOException;

    BufferedSink writeHexadecimalUnsignedLong(long j) throws IOException;

    BufferedSink writeInt(int i) throws IOException;

    BufferedSink writeShort(int i) throws IOException;

    BufferedSink writeUtf8(String str) throws IOException;
}
