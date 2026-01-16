package okio;

import android.gov.nist.javax.sip.parser.TokenNames;
import ir.nasim.AbstractC10868cL0;
import ir.nasim.AbstractC13042fc3;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\n\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001a\u0010\u001cJ\u0017\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b \u0010!J)\u0010 \u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010#*\u00020\"2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000$H\u0016¢\u0006\u0004\b \u0010%J\u000f\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010'\u001a\u00020&2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b'\u0010)J\u0017\u0010\f\u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020&H\u0016¢\u0006\u0004\b\f\u0010*J\u0017\u0010+\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020&H\u0016¢\u0006\u0004\b+\u0010,J'\u0010\f\u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020&2\u0006\u0010-\u001a\u00020\u001f2\u0006\u0010\u000b\u001a\u00020\u001fH\u0016¢\u0006\u0004\b\f\u0010.J\u0017\u0010\f\u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020/H\u0016¢\u0006\u0004\b\f\u00100J\u001f\u0010+\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b+\u00101J\u0017\u00103\u001a\u00020\n2\u0006\u0010\t\u001a\u000202H\u0016¢\u0006\u0004\b3\u00104J\u000f\u00106\u001a\u000205H\u0016¢\u0006\u0004\b6\u00107J\u0017\u00106\u001a\u0002052\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b6\u00108J\u0017\u0010;\u001a\u0002052\u0006\u0010:\u001a\u000209H\u0016¢\u0006\u0004\b;\u0010<J\u001f\u0010;\u001a\u0002052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010:\u001a\u000209H\u0016¢\u0006\u0004\b;\u0010=J\u0011\u0010>\u001a\u0004\u0018\u000105H\u0016¢\u0006\u0004\b>\u00107J\u000f\u0010?\u001a\u000205H\u0016¢\u0006\u0004\b?\u00107J\u0017\u0010?\u001a\u0002052\u0006\u0010@\u001a\u00020\nH\u0016¢\u0006\u0004\b?\u00108J\u000f\u0010A\u001a\u00020\u001fH\u0016¢\u0006\u0004\bA\u0010BJ\u000f\u0010D\u001a\u00020CH\u0016¢\u0006\u0004\bD\u0010EJ\u000f\u0010F\u001a\u00020CH\u0016¢\u0006\u0004\bF\u0010EJ\u000f\u0010G\u001a\u00020\u001fH\u0016¢\u0006\u0004\bG\u0010BJ\u000f\u0010H\u001a\u00020\u001fH\u0016¢\u0006\u0004\bH\u0010BJ\u000f\u0010I\u001a\u00020\nH\u0016¢\u0006\u0004\bI\u0010JJ\u000f\u0010K\u001a\u00020\nH\u0016¢\u0006\u0004\bK\u0010JJ\u000f\u0010L\u001a\u00020\nH\u0016¢\u0006\u0004\bL\u0010JJ\u000f\u0010M\u001a\u00020\nH\u0016¢\u0006\u0004\bM\u0010JJ\u0017\u0010N\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\bN\u0010\u0013J\u0017\u0010P\u001a\u00020\n2\u0006\u0010O\u001a\u00020\u0016H\u0016¢\u0006\u0004\bP\u0010QJ\u001f\u0010P\u001a\u00020\n2\u0006\u0010O\u001a\u00020\u00162\u0006\u0010R\u001a\u00020\nH\u0016¢\u0006\u0004\bP\u0010SJ'\u0010P\u001a\u00020\n2\u0006\u0010O\u001a\u00020\u00162\u0006\u0010R\u001a\u00020\n2\u0006\u0010T\u001a\u00020\nH\u0016¢\u0006\u0004\bP\u0010UJ\u0017\u0010P\u001a\u00020\n2\u0006\u0010V\u001a\u00020\u0019H\u0016¢\u0006\u0004\bP\u0010WJ\u001f\u0010P\u001a\u00020\n2\u0006\u0010V\u001a\u00020\u00192\u0006\u0010R\u001a\u00020\nH\u0016¢\u0006\u0004\bP\u0010XJ\u0017\u0010Z\u001a\u00020\n2\u0006\u0010Y\u001a\u00020\u0019H\u0016¢\u0006\u0004\bZ\u0010WJ\u001f\u0010Z\u001a\u00020\n2\u0006\u0010Y\u001a\u00020\u00192\u0006\u0010R\u001a\u00020\nH\u0016¢\u0006\u0004\bZ\u0010XJ\u001f\u0010[\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\n2\u0006\u0010V\u001a\u00020\u0019H\u0016¢\u0006\u0004\b[\u0010\\J/\u0010[\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\n2\u0006\u0010V\u001a\u00020\u00192\u0006\u0010]\u001a\u00020\u001f2\u0006\u0010\u000b\u001a\u00020\u001fH\u0016¢\u0006\u0004\b[\u0010^J\u000f\u0010_\u001a\u00020\u0001H\u0016¢\u0006\u0004\b_\u0010`J\u000f\u0010b\u001a\u00020aH\u0016¢\u0006\u0004\bb\u0010cJ\u000f\u0010d\u001a\u00020\u000eH\u0016¢\u0006\u0004\bd\u0010\u0010J\u000f\u0010e\u001a\u00020\u0011H\u0016¢\u0006\u0004\be\u0010fJ\u000f\u0010h\u001a\u00020gH\u0016¢\u0006\u0004\bh\u0010iJ\u000f\u0010j\u001a\u000205H\u0016¢\u0006\u0004\bj\u00107R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010kR\u0014\u0010l\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bl\u0010mR\u0016\u0010n\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bn\u0010oR\u001b\u0010\u0007\u001a\u00020\u00068Ö\u0002X\u0096\u0004¢\u0006\f\u0012\u0004\bq\u0010f\u001a\u0004\bp\u0010\b¨\u0006r"}, d2 = {"Lokio/RealBufferedSource;", "Lokio/BufferedSource;", "Lokio/Source;", "source", "<init>", "(Lokio/Source;)V", "Lokio/Buffer;", "buffer", "()Lokio/Buffer;", "sink", "", "byteCount", "read", "(Lokio/Buffer;J)J", "", "exhausted", "()Z", "Lir/nasim/rB7;", "require", "(J)V", "request", "(J)Z", "", "readByte", "()B", "Lokio/ByteString;", "readByteString", "()Lokio/ByteString;", "(J)Lokio/ByteString;", "Lokio/Options;", "options", "", "select", "(Lokio/Options;)I", "", TokenNames.T, "Lokio/TypedOptions;", "(Lokio/TypedOptions;)Ljava/lang/Object;", "", "readByteArray", "()[B", "(J)[B", "([B)I", "readFully", "([B)V", "offset", "([BII)I", "Ljava/nio/ByteBuffer;", "(Ljava/nio/ByteBuffer;)I", "(Lokio/Buffer;J)V", "Lokio/Sink;", "readAll", "(Lokio/Sink;)J", "", "readUtf8", "()Ljava/lang/String;", "(J)Ljava/lang/String;", "Ljava/nio/charset/Charset;", "charset", "readString", "(Ljava/nio/charset/Charset;)Ljava/lang/String;", "(JLjava/nio/charset/Charset;)Ljava/lang/String;", "readUtf8Line", "readUtf8LineStrict", "limit", "readUtf8CodePoint", "()I", "", "readShort", "()S", "readShortLe", "readInt", "readIntLe", "readLong", "()J", "readLongLe", "readDecimalLong", "readHexadecimalUnsignedLong", "skip", "b", "indexOf", "(B)J", "fromIndex", "(BJ)J", "toIndex", "(BJJ)J", "bytes", "(Lokio/ByteString;)J", "(Lokio/ByteString;J)J", "targetBytes", "indexOfElement", "rangeEquals", "(JLokio/ByteString;)Z", "bytesOffset", "(JLokio/ByteString;II)Z", "peek", "()Lokio/BufferedSource;", "Ljava/io/InputStream;", "inputStream", "()Ljava/io/InputStream;", "isOpen", "close", "()V", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "toString", "Lokio/Source;", "bufferField", "Lokio/Buffer;", "closed", "Z", "getBuffer", "getBuffer$annotations", "okio"}, k = 1, mv = {1, 9, 0})
/* renamed from: okio.RealBufferedSource, reason: from toString */
/* loaded from: classes8.dex */
public final class buffer implements BufferedSource {
    public final Buffer bufferField;
    public boolean closed;
    public final Source source;

    public buffer(Source source) {
        AbstractC13042fc3.i(source, "source");
        this.source = source;
        this.bufferField = new Buffer();
    }

    public static /* synthetic */ void getBuffer$annotations() {
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    /* renamed from: buffer, reason: from getter */
    public Buffer getBufferField() {
        return this.bufferField;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws EOFException {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.source.close();
        this.bufferField.clear();
    }

    @Override // okio.BufferedSource
    public boolean exhausted() {
        if (!this.closed) {
            return this.bufferField.exhausted() && this.source.read(this.bufferField, 8192L) == -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    public Buffer getBuffer() {
        return this.bufferField;
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b) {
        return indexOf(b, 0L, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString targetBytes) {
        AbstractC13042fc3.i(targetBytes, "targetBytes");
        return indexOfElement(targetBytes, 0L);
    }

    @Override // okio.BufferedSource
    public InputStream inputStream() {
        return new InputStream() { // from class: okio.RealBufferedSource.inputStream.1
            @Override // java.io.InputStream
            public int available() throws IOException {
                buffer bufferVar = buffer.this;
                if (bufferVar.closed) {
                    throw new IOException("closed");
                }
                return (int) Math.min(bufferVar.bufferField.size(), Integer.MAX_VALUE);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws EOFException {
                buffer.this.close();
            }

            @Override // java.io.InputStream
            public int read() throws IOException {
                buffer bufferVar = buffer.this;
                if (bufferVar.closed) {
                    throw new IOException("closed");
                }
                if (bufferVar.bufferField.size() == 0) {
                    buffer bufferVar2 = buffer.this;
                    if (bufferVar2.source.read(bufferVar2.bufferField, 8192L) == -1) {
                        return -1;
                    }
                }
                return buffer.this.bufferField.readByte() & 255;
            }

            public String toString() {
                return buffer.this + ".inputStream()";
            }

            @Override // java.io.InputStream
            public int read(byte[] data, int offset, int byteCount) throws IOException {
                AbstractC13042fc3.i(data, "data");
                if (!buffer.this.closed) {
                    SegmentedByteString.checkOffsetAndCount(data.length, offset, byteCount);
                    if (buffer.this.bufferField.size() == 0) {
                        buffer bufferVar = buffer.this;
                        if (bufferVar.source.read(bufferVar.bufferField, 8192L) == -1) {
                            return -1;
                        }
                    }
                    return buffer.this.bufferField.read(data, offset, byteCount);
                }
                throw new IOException("closed");
            }
        };
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.closed;
    }

    @Override // okio.BufferedSource
    public BufferedSource peek() {
        return Okio.buffer(new PeekSource(this));
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long offset, ByteString bytes) {
        AbstractC13042fc3.i(bytes, "bytes");
        return rangeEquals(offset, bytes, 0, bytes.size());
    }

    @Override // okio.BufferedSource
    public int read(byte[] sink) {
        AbstractC13042fc3.i(sink, "sink");
        return read(sink, 0, sink.length);
    }

    @Override // okio.BufferedSource
    public long readAll(Sink sink) {
        AbstractC13042fc3.i(sink, "sink");
        long j = 0;
        while (this.source.read(this.bufferField, 8192L) != -1) {
            long jCompleteSegmentByteCount = this.bufferField.completeSegmentByteCount();
            if (jCompleteSegmentByteCount > 0) {
                j += jCompleteSegmentByteCount;
                sink.write(this.bufferField, jCompleteSegmentByteCount);
            }
        }
        if (this.bufferField.size() <= 0) {
            return j;
        }
        long size = j + this.bufferField.size();
        Buffer buffer = this.bufferField;
        sink.write(buffer, buffer.size());
        return size;
    }

    @Override // okio.BufferedSource
    public byte readByte() throws EOFException {
        require(1L);
        return this.bufferField.readByte();
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readByteArray();
    }

    @Override // okio.BufferedSource
    public ByteString readByteString() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readByteString();
    }

    @Override // okio.BufferedSource
    public long readDecimalLong() throws EOFException {
        byte b;
        require(1L);
        long j = 0;
        while (true) {
            long j2 = j + 1;
            if (!request(j2)) {
                break;
            }
            b = this.bufferField.getByte(j);
            if ((b < 48 || b > 57) && !(j == 0 && b == 45)) {
                break;
            }
            j = j2;
        }
        if (j == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected a digit or '-' but was 0x");
            String string = Integer.toString(b, AbstractC10868cL0.a(16));
            AbstractC13042fc3.h(string, "toString(...)");
            sb.append(string);
            throw new NumberFormatException(sb.toString());
        }
        return this.bufferField.readDecimalLong();
    }

    @Override // okio.BufferedSource
    public void readFully(byte[] sink) throws EOFException {
        AbstractC13042fc3.i(sink, "sink");
        try {
            require(sink.length);
            this.bufferField.readFully(sink);
        } catch (EOFException e) {
            int i = 0;
            while (this.bufferField.size() > 0) {
                Buffer buffer = this.bufferField;
                int i2 = buffer.read(sink, i, (int) buffer.size());
                if (i2 == -1) {
                    throw new AssertionError();
                }
                i += i2;
            }
            throw e;
        }
    }

    @Override // okio.BufferedSource
    public long readHexadecimalUnsignedLong() throws EOFException {
        byte b;
        require(1L);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!request(i2)) {
                break;
            }
            b = this.bufferField.getByte(i);
            if ((b < 48 || b > 57) && ((b < 97 || b > 102) && (b < 65 || b > 70))) {
                break;
            }
            i = i2;
        }
        if (i == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected leading [0-9a-fA-F] character but was 0x");
            String string = Integer.toString(b, AbstractC10868cL0.a(16));
            AbstractC13042fc3.h(string, "toString(...)");
            sb.append(string);
            throw new NumberFormatException(sb.toString());
        }
        return this.bufferField.readHexadecimalUnsignedLong();
    }

    @Override // okio.BufferedSource
    public int readInt() throws EOFException {
        require(4L);
        return this.bufferField.readInt();
    }

    @Override // okio.BufferedSource
    public int readIntLe() throws EOFException {
        require(4L);
        return this.bufferField.readIntLe();
    }

    @Override // okio.BufferedSource
    public long readLong() throws EOFException {
        require(8L);
        return this.bufferField.readLong();
    }

    @Override // okio.BufferedSource
    public long readLongLe() throws EOFException {
        require(8L);
        return this.bufferField.readLongLe();
    }

    @Override // okio.BufferedSource
    public short readShort() throws EOFException {
        require(2L);
        return this.bufferField.readShort();
    }

    @Override // okio.BufferedSource
    public short readShortLe() throws EOFException {
        require(2L);
        return this.bufferField.readShortLe();
    }

    @Override // okio.BufferedSource
    public String readString(long byteCount, Charset charset) throws EOFException {
        AbstractC13042fc3.i(charset, "charset");
        require(byteCount);
        return this.bufferField.readString(byteCount, charset);
    }

    @Override // okio.BufferedSource
    public String readUtf8() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readUtf8();
    }

    @Override // okio.BufferedSource
    public int readUtf8CodePoint() throws EOFException {
        require(1L);
        byte b = this.bufferField.getByte(0L);
        if ((b & 224) == 192) {
            require(2L);
        } else if ((b & 240) == 224) {
            require(3L);
        } else if ((b & 248) == 240) {
            require(4L);
        }
        return this.bufferField.readUtf8CodePoint();
    }

    @Override // okio.BufferedSource
    public String readUtf8Line() {
        long jIndexOf = indexOf((byte) 10);
        if (jIndexOf != -1) {
            return okio.internal.Buffer.readUtf8Line(this.bufferField, jIndexOf);
        }
        if (this.bufferField.size() != 0) {
            return readUtf8(this.bufferField.size());
        }
        return null;
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict() {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public boolean request(long byteCount) {
        if (byteCount < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        }
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (this.bufferField.size() < byteCount) {
            if (this.source.read(this.bufferField, 8192L) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override // okio.BufferedSource
    public void require(long byteCount) throws EOFException {
        if (!request(byteCount)) {
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    public int select(Options options) throws EOFException {
        AbstractC13042fc3.i(options, "options");
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            int iSelectPrefix = okio.internal.Buffer.selectPrefix(this.bufferField, options, true);
            if (iSelectPrefix != -2) {
                if (iSelectPrefix != -1) {
                    this.bufferField.skip(options.getByteStrings()[iSelectPrefix].size());
                    return iSelectPrefix;
                }
            } else if (this.source.read(this.bufferField, 8192L) == -1) {
                break;
            }
        }
        return -1;
    }

    @Override // okio.BufferedSource
    public void skip(long byteCount) throws EOFException {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (byteCount > 0) {
            if (this.bufferField.size() == 0 && this.source.read(this.bufferField, 8192L) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(byteCount, this.bufferField.size());
            this.bufferField.skip(jMin);
            byteCount -= jMin;
        }
    }

    @Override // okio.Source
    /* renamed from: timeout */
    public Timeout getTimeout() {
        return this.source.getTimeout();
    }

    public String toString() {
        return "buffer(" + this.source + ')';
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b, long fromIndex) {
        return indexOf(b, fromIndex, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString targetBytes, long fromIndex) {
        AbstractC13042fc3.i(targetBytes, "targetBytes");
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long jIndexOfElement = this.bufferField.indexOfElement(targetBytes, fromIndex);
            if (jIndexOfElement != -1) {
                return jIndexOfElement;
            }
            long size = this.bufferField.size();
            if (this.source.read(this.bufferField, 8192L) == -1) {
                return -1L;
            }
            fromIndex = Math.max(fromIndex, size);
        }
    }

    @Override // okio.Source
    public long read(Buffer sink, long byteCount) {
        AbstractC13042fc3.i(sink, "sink");
        if (byteCount < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        }
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (this.bufferField.size() == 0 && this.source.read(this.bufferField, 8192L) == -1) {
            return -1L;
        }
        return this.bufferField.read(sink, Math.min(byteCount, this.bufferField.size()));
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict(long limit) throws EOFException {
        if (limit < 0) {
            throw new IllegalArgumentException(("limit < 0: " + limit).toString());
        }
        long j = limit == Long.MAX_VALUE ? Long.MAX_VALUE : limit + 1;
        long jIndexOf = indexOf((byte) 10, 0L, j);
        if (jIndexOf != -1) {
            return okio.internal.Buffer.readUtf8Line(this.bufferField, jIndexOf);
        }
        if (j < Long.MAX_VALUE && request(j) && this.bufferField.getByte(j - 1) == 13 && request(1 + j) && this.bufferField.getByte(j) == 10) {
            return okio.internal.Buffer.readUtf8Line(this.bufferField, j);
        }
        Buffer buffer = new Buffer();
        Buffer buffer2 = this.bufferField;
        buffer2.copyTo(buffer, 0L, Math.min(32, buffer2.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.bufferField.size(), limit) + " content=" + buffer.readByteString().hex() + (char) 8230);
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString bytes) {
        AbstractC13042fc3.i(bytes, "bytes");
        return indexOf(bytes, 0L);
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long offset, ByteString bytes, int bytesOffset, int byteCount) {
        AbstractC13042fc3.i(bytes, "bytes");
        if (!this.closed) {
            if (offset >= 0 && bytesOffset >= 0 && byteCount >= 0 && bytes.size() - bytesOffset >= byteCount) {
                for (int i = 0; i < byteCount; i++) {
                    long j = i + offset;
                    if (request(1 + j) && this.bufferField.getByte(j) == bytes.getByte(bytesOffset + i)) {
                    }
                }
                return true;
            }
            return false;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b, long fromIndex, long toIndex) {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (0 > fromIndex || fromIndex > toIndex) {
            throw new IllegalArgumentException(("fromIndex=" + fromIndex + " toIndex=" + toIndex).toString());
        }
        while (fromIndex < toIndex) {
            long jIndexOf = this.bufferField.indexOf(b, fromIndex, toIndex);
            if (jIndexOf != -1) {
                return jIndexOf;
            }
            long size = this.bufferField.size();
            if (size >= toIndex || this.source.read(this.bufferField, 8192L) == -1) {
                return -1L;
            }
            fromIndex = Math.max(fromIndex, size);
        }
        return -1L;
    }

    @Override // okio.BufferedSource
    public String readString(Charset charset) {
        AbstractC13042fc3.i(charset, "charset");
        this.bufferField.writeAll(this.source);
        return this.bufferField.readString(charset);
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray(long byteCount) throws EOFException {
        require(byteCount);
        return this.bufferField.readByteArray(byteCount);
    }

    @Override // okio.BufferedSource
    public ByteString readByteString(long byteCount) throws EOFException {
        require(byteCount);
        return this.bufferField.readByteString(byteCount);
    }

    @Override // okio.BufferedSource
    public String readUtf8(long byteCount) throws EOFException {
        require(byteCount);
        return this.bufferField.readUtf8(byteCount);
    }

    @Override // okio.BufferedSource
    public void readFully(Buffer sink, long byteCount) throws EOFException {
        AbstractC13042fc3.i(sink, "sink");
        try {
            require(byteCount);
            this.bufferField.readFully(sink, byteCount);
        } catch (EOFException e) {
            sink.writeAll(this.bufferField);
            throw e;
        }
    }

    @Override // okio.BufferedSource
    public <T> T select(TypedOptions<T> options) {
        AbstractC13042fc3.i(options, "options");
        int iSelect = select(options.getOptions());
        if (iSelect == -1) {
            return null;
        }
        return options.get(iSelect);
    }

    @Override // okio.BufferedSource
    public int read(byte[] sink, int offset, int byteCount) {
        AbstractC13042fc3.i(sink, "sink");
        long j = byteCount;
        SegmentedByteString.checkOffsetAndCount(sink.length, offset, j);
        if (this.bufferField.size() == 0 && this.source.read(this.bufferField, 8192L) == -1) {
            return -1;
        }
        return this.bufferField.read(sink, offset, (int) Math.min(j, this.bufferField.size()));
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString bytes, long fromIndex) {
        AbstractC13042fc3.i(bytes, "bytes");
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long jIndexOf = this.bufferField.indexOf(bytes, fromIndex);
            if (jIndexOf != -1) {
                return jIndexOf;
            }
            long size = this.bufferField.size();
            if (this.source.read(this.bufferField, 8192L) == -1) {
                return -1L;
            }
            fromIndex = Math.max(fromIndex, (size - bytes.size()) + 1);
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer sink) {
        AbstractC13042fc3.i(sink, "sink");
        if (this.bufferField.size() == 0 && this.source.read(this.bufferField, 8192L) == -1) {
            return -1;
        }
        return this.bufferField.read(sink);
    }
}
