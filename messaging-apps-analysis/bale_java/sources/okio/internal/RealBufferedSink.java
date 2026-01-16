package okio.internal;

import ir.nasim.AbstractC13042fc3;
import java.io.EOFException;
import kotlin.Metadata;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import okio.buffer;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a$\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001c\u0010\u0006\u001a\u00020\n*\u00020\u00002\u0006\u0010\t\u001a\u00020\bH\u0080\b¢\u0006\u0004\b\u0006\u0010\u000b\u001a,\u0010\u0006\u001a\u00020\n*\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\fH\u0080\b¢\u0006\u0004\b\u0006\u0010\u000e\u001a\u001c\u0010\u0011\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fH\u0080\b¢\u0006\u0004\b\u0011\u0010\u0012\u001a,\u0010\u0011\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\fH\u0080\b¢\u0006\u0004\b\u0011\u0010\u0015\u001a\u001c\u0010\u0017\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0016\u001a\u00020\fH\u0080\b¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u001c\u0010\u0006\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0019H\u0080\b¢\u0006\u0004\b\u0006\u0010\u001a\u001a,\u0010\u0006\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00192\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\fH\u0080\b¢\u0006\u0004\b\u0006\u0010\u001b\u001a\u001c\u0010\u001d\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u001cH\u0080\b¢\u0006\u0004\b\u001d\u0010\u001e\u001a$\u0010\u0006\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u001c2\u0006\u0010\u0004\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b\u0006\u0010\u001f\u001a\u001c\u0010!\u001a\u00020\n*\u00020\u00002\u0006\u0010 \u001a\u00020\fH\u0080\b¢\u0006\u0004\b!\u0010\u0018\u001a\u001c\u0010#\u001a\u00020\n*\u00020\u00002\u0006\u0010\"\u001a\u00020\fH\u0080\b¢\u0006\u0004\b#\u0010\u0018\u001a\u001c\u0010$\u001a\u00020\n*\u00020\u00002\u0006\u0010\"\u001a\u00020\fH\u0080\b¢\u0006\u0004\b$\u0010\u0018\u001a\u001c\u0010&\u001a\u00020\n*\u00020\u00002\u0006\u0010%\u001a\u00020\fH\u0080\b¢\u0006\u0004\b&\u0010\u0018\u001a\u001c\u0010'\u001a\u00020\n*\u00020\u00002\u0006\u0010%\u001a\u00020\fH\u0080\b¢\u0006\u0004\b'\u0010\u0018\u001a\u001c\u0010)\u001a\u00020\n*\u00020\u00002\u0006\u0010(\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b)\u0010*\u001a\u001c\u0010+\u001a\u00020\n*\u00020\u00002\u0006\u0010(\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b+\u0010*\u001a\u001c\u0010,\u001a\u00020\n*\u00020\u00002\u0006\u0010(\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b,\u0010*\u001a\u001c\u0010-\u001a\u00020\n*\u00020\u00002\u0006\u0010(\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b-\u0010*\u001a\u0014\u0010.\u001a\u00020\n*\u00020\u0000H\u0080\b¢\u0006\u0004\b.\u0010/\u001a\u0014\u00100\u001a\u00020\n*\u00020\u0000H\u0080\b¢\u0006\u0004\b0\u0010/\u001a\u0014\u00101\u001a\u00020\u0005*\u00020\u0000H\u0080\b¢\u0006\u0004\b1\u00102\u001a\u0014\u00103\u001a\u00020\u0005*\u00020\u0000H\u0080\b¢\u0006\u0004\b3\u00102\u001a\u0014\u00105\u001a\u000204*\u00020\u0000H\u0080\b¢\u0006\u0004\b5\u00106\u001a\u0014\u00107\u001a\u00020\u000f*\u00020\u0000H\u0080\b¢\u0006\u0004\b7\u00108¨\u00069"}, d2 = {"Lokio/RealBufferedSink;", "Lokio/Buffer;", "source", "", "byteCount", "Lir/nasim/rB7;", "commonWrite", "(Lokio/RealBufferedSink;Lokio/Buffer;J)V", "Lokio/ByteString;", "byteString", "Lokio/BufferedSink;", "(Lokio/RealBufferedSink;Lokio/ByteString;)Lokio/BufferedSink;", "", "offset", "(Lokio/RealBufferedSink;Lokio/ByteString;II)Lokio/BufferedSink;", "", "string", "commonWriteUtf8", "(Lokio/RealBufferedSink;Ljava/lang/String;)Lokio/BufferedSink;", "beginIndex", "endIndex", "(Lokio/RealBufferedSink;Ljava/lang/String;II)Lokio/BufferedSink;", "codePoint", "commonWriteUtf8CodePoint", "(Lokio/RealBufferedSink;I)Lokio/BufferedSink;", "", "(Lokio/RealBufferedSink;[B)Lokio/BufferedSink;", "(Lokio/RealBufferedSink;[BII)Lokio/BufferedSink;", "Lokio/Source;", "commonWriteAll", "(Lokio/RealBufferedSink;Lokio/Source;)J", "(Lokio/RealBufferedSink;Lokio/Source;J)Lokio/BufferedSink;", "b", "commonWriteByte", "s", "commonWriteShort", "commonWriteShortLe", "i", "commonWriteInt", "commonWriteIntLe", "v", "commonWriteLong", "(Lokio/RealBufferedSink;J)Lokio/BufferedSink;", "commonWriteLongLe", "commonWriteDecimalLong", "commonWriteHexadecimalUnsignedLong", "commonEmitCompleteSegments", "(Lokio/RealBufferedSink;)Lokio/BufferedSink;", "commonEmit", "commonFlush", "(Lokio/RealBufferedSink;)V", "commonClose", "Lokio/Timeout;", "commonTimeout", "(Lokio/RealBufferedSink;)Lokio/Timeout;", "commonToString", "(Lokio/RealBufferedSink;)Ljava/lang/String;", "okio"}, k = 2, mv = {1, 9, 0})
/* renamed from: okio.internal.-RealBufferedSink, reason: invalid class name */
/* loaded from: classes8.dex */
public final class RealBufferedSink {
    public static final void commonClose(buffer bufferVar) throws Throwable {
        AbstractC13042fc3.i(bufferVar, "<this>");
        if (bufferVar.closed) {
            return;
        }
        try {
            if (bufferVar.bufferField.size() > 0) {
                Sink sink = bufferVar.sink;
                Buffer buffer = bufferVar.bufferField;
                sink.write(buffer, buffer.size());
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            bufferVar.sink.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        bufferVar.closed = true;
        if (th != null) {
            throw th;
        }
    }

    public static final BufferedSink commonEmit(buffer bufferVar) {
        AbstractC13042fc3.i(bufferVar, "<this>");
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        long size = bufferVar.bufferField.size();
        if (size > 0) {
            bufferVar.sink.write(bufferVar.bufferField, size);
        }
        return bufferVar;
    }

    public static final BufferedSink commonEmitCompleteSegments(buffer bufferVar) {
        AbstractC13042fc3.i(bufferVar, "<this>");
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        long jCompleteSegmentByteCount = bufferVar.bufferField.completeSegmentByteCount();
        if (jCompleteSegmentByteCount > 0) {
            bufferVar.sink.write(bufferVar.bufferField, jCompleteSegmentByteCount);
        }
        return bufferVar;
    }

    public static final void commonFlush(buffer bufferVar) {
        AbstractC13042fc3.i(bufferVar, "<this>");
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (bufferVar.bufferField.size() > 0) {
            Sink sink = bufferVar.sink;
            Buffer buffer = bufferVar.bufferField;
            sink.write(buffer, buffer.size());
        }
        bufferVar.sink.flush();
    }

    public static final Timeout commonTimeout(buffer bufferVar) {
        AbstractC13042fc3.i(bufferVar, "<this>");
        return bufferVar.sink.getTimeout();
    }

    public static final String commonToString(buffer bufferVar) {
        AbstractC13042fc3.i(bufferVar, "<this>");
        return "buffer(" + bufferVar.sink + ')';
    }

    public static final void commonWrite(buffer bufferVar, Buffer buffer, long j) {
        AbstractC13042fc3.i(bufferVar, "<this>");
        AbstractC13042fc3.i(buffer, "source");
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        bufferVar.bufferField.write(buffer, j);
        bufferVar.emitCompleteSegments();
    }

    public static final long commonWriteAll(buffer bufferVar, Source source) {
        AbstractC13042fc3.i(bufferVar, "<this>");
        AbstractC13042fc3.i(source, "source");
        long j = 0;
        while (true) {
            long j2 = source.read(bufferVar.bufferField, 8192L);
            if (j2 == -1) {
                return j;
            }
            j += j2;
            bufferVar.emitCompleteSegments();
        }
    }

    public static final BufferedSink commonWriteByte(buffer bufferVar, int i) {
        AbstractC13042fc3.i(bufferVar, "<this>");
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        bufferVar.bufferField.writeByte(i);
        return bufferVar.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteDecimalLong(buffer bufferVar, long j) {
        AbstractC13042fc3.i(bufferVar, "<this>");
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        bufferVar.bufferField.writeDecimalLong(j);
        return bufferVar.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteHexadecimalUnsignedLong(buffer bufferVar, long j) {
        AbstractC13042fc3.i(bufferVar, "<this>");
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        bufferVar.bufferField.writeHexadecimalUnsignedLong(j);
        return bufferVar.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteInt(buffer bufferVar, int i) {
        AbstractC13042fc3.i(bufferVar, "<this>");
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        bufferVar.bufferField.writeInt(i);
        return bufferVar.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteIntLe(buffer bufferVar, int i) {
        AbstractC13042fc3.i(bufferVar, "<this>");
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        bufferVar.bufferField.writeIntLe(i);
        return bufferVar.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteLong(buffer bufferVar, long j) {
        AbstractC13042fc3.i(bufferVar, "<this>");
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        bufferVar.bufferField.writeLong(j);
        return bufferVar.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteLongLe(buffer bufferVar, long j) {
        AbstractC13042fc3.i(bufferVar, "<this>");
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        bufferVar.bufferField.writeLongLe(j);
        return bufferVar.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteShort(buffer bufferVar, int i) {
        AbstractC13042fc3.i(bufferVar, "<this>");
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        bufferVar.bufferField.writeShort(i);
        return bufferVar.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteShortLe(buffer bufferVar, int i) {
        AbstractC13042fc3.i(bufferVar, "<this>");
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        bufferVar.bufferField.writeShortLe(i);
        return bufferVar.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteUtf8(buffer bufferVar, String str) {
        AbstractC13042fc3.i(bufferVar, "<this>");
        AbstractC13042fc3.i(str, "string");
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        bufferVar.bufferField.writeUtf8(str);
        return bufferVar.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteUtf8CodePoint(buffer bufferVar, int i) {
        AbstractC13042fc3.i(bufferVar, "<this>");
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        bufferVar.bufferField.writeUtf8CodePoint(i);
        return bufferVar.emitCompleteSegments();
    }

    public static final BufferedSink commonWrite(buffer bufferVar, ByteString byteString) {
        AbstractC13042fc3.i(bufferVar, "<this>");
        AbstractC13042fc3.i(byteString, "byteString");
        if (!bufferVar.closed) {
            bufferVar.bufferField.write(byteString);
            return bufferVar.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteUtf8(buffer bufferVar, String str, int i, int i2) {
        AbstractC13042fc3.i(bufferVar, "<this>");
        AbstractC13042fc3.i(str, "string");
        if (!bufferVar.closed) {
            bufferVar.bufferField.writeUtf8(str, i, i2);
            return bufferVar.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWrite(buffer bufferVar, ByteString byteString, int i, int i2) {
        AbstractC13042fc3.i(bufferVar, "<this>");
        AbstractC13042fc3.i(byteString, "byteString");
        if (!bufferVar.closed) {
            bufferVar.bufferField.write(byteString, i, i2);
            return bufferVar.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWrite(buffer bufferVar, byte[] bArr) {
        AbstractC13042fc3.i(bufferVar, "<this>");
        AbstractC13042fc3.i(bArr, "source");
        if (!bufferVar.closed) {
            bufferVar.bufferField.write(bArr);
            return bufferVar.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWrite(buffer bufferVar, byte[] bArr, int i, int i2) {
        AbstractC13042fc3.i(bufferVar, "<this>");
        AbstractC13042fc3.i(bArr, "source");
        if (!bufferVar.closed) {
            bufferVar.bufferField.write(bArr, i, i2);
            return bufferVar.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWrite(buffer bufferVar, Source source, long j) throws EOFException {
        AbstractC13042fc3.i(bufferVar, "<this>");
        AbstractC13042fc3.i(source, "source");
        while (j > 0) {
            long j2 = source.read(bufferVar.bufferField, j);
            if (j2 != -1) {
                j -= j2;
                bufferVar.emitCompleteSegments();
            } else {
                throw new EOFException();
            }
        }
        return bufferVar;
    }
}
