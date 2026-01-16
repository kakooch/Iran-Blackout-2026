package okio.internal;

import ir.nasim.AbstractC10868cL0;
import ir.nasim.AbstractC13042fc3;
import java.io.EOFException;
import kotlin.Metadata;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Options;
import okio.PeekSource;
import okio.SegmentedByteString;
import okio.Sink;
import okio.Timeout;
import okio.buffer;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\n\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a$\u0010\u0005\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0014\u0010\b\u001a\u00020\u0007*\u00020\u0000H\u0080\b¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\u000b\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b\u000b\u0010\f\u001a\u001c\u0010\r\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b\r\u0010\u000e\u001a\u0014\u0010\u0010\u001a\u00020\u000f*\u00020\u0000H\u0080\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0014\u0010\u0013\u001a\u00020\u0012*\u00020\u0000H\u0080\b¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001c\u0010\u0013\u001a\u00020\u0012*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b\u0013\u0010\u0015\u001a\u001c\u0010\u0019\u001a\u00020\u0018*\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0016H\u0080\b¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0014\u0010\u001c\u001a\u00020\u001b*\u00020\u0000H\u0080\b¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001c\u0010\u001c\u001a\u00020\u001b*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b\u001c\u0010\u001e\u001a\u001c\u0010\u001f\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u001bH\u0080\b¢\u0006\u0004\b\u001f\u0010 \u001a,\u0010\u0005\u001a\u00020\u0018*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u00182\u0006\u0010\u0004\u001a\u00020\u0018H\u0080\b¢\u0006\u0004\b\u0005\u0010\"\u001a$\u0010\u001f\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b\u001f\u0010#\u001a\u001c\u0010%\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020$H\u0080\b¢\u0006\u0004\b%\u0010&\u001a\u0014\u0010(\u001a\u00020'*\u00020\u0000H\u0080\b¢\u0006\u0004\b(\u0010)\u001a\u001c\u0010(\u001a\u00020'*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b(\u0010*\u001a\u0016\u0010+\u001a\u0004\u0018\u00010'*\u00020\u0000H\u0080\b¢\u0006\u0004\b+\u0010)\u001a\u001c\u0010-\u001a\u00020'*\u00020\u00002\u0006\u0010,\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b-\u0010*\u001a\u0014\u0010.\u001a\u00020\u0018*\u00020\u0000H\u0080\b¢\u0006\u0004\b.\u0010/\u001a\u0014\u00101\u001a\u000200*\u00020\u0000H\u0080\b¢\u0006\u0004\b1\u00102\u001a\u0014\u00103\u001a\u000200*\u00020\u0000H\u0080\b¢\u0006\u0004\b3\u00102\u001a\u0014\u00104\u001a\u00020\u0018*\u00020\u0000H\u0080\b¢\u0006\u0004\b4\u0010/\u001a\u0014\u00105\u001a\u00020\u0018*\u00020\u0000H\u0080\b¢\u0006\u0004\b5\u0010/\u001a\u0014\u00106\u001a\u00020\u0003*\u00020\u0000H\u0080\b¢\u0006\u0004\b6\u00107\u001a\u0014\u00108\u001a\u00020\u0003*\u00020\u0000H\u0080\b¢\u0006\u0004\b8\u00107\u001a\u0014\u00109\u001a\u00020\u0003*\u00020\u0000H\u0080\b¢\u0006\u0004\b9\u00107\u001a\u0014\u0010:\u001a\u00020\u0003*\u00020\u0000H\u0080\b¢\u0006\u0004\b:\u00107\u001a\u001c\u0010;\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b;\u0010\f\u001a,\u0010?\u001a\u00020\u0003*\u00020\u00002\u0006\u0010<\u001a\u00020\u000f2\u0006\u0010=\u001a\u00020\u00032\u0006\u0010>\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b?\u0010@\u001a$\u0010?\u001a\u00020\u0003*\u00020\u00002\u0006\u0010A\u001a\u00020\u00122\u0006\u0010=\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b?\u0010B\u001a$\u0010D\u001a\u00020\u0003*\u00020\u00002\u0006\u0010C\u001a\u00020\u00122\u0006\u0010=\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\bD\u0010B\u001a4\u0010F\u001a\u00020\u0007*\u00020\u00002\u0006\u0010!\u001a\u00020\u00032\u0006\u0010A\u001a\u00020\u00122\u0006\u0010E\u001a\u00020\u00182\u0006\u0010\u0004\u001a\u00020\u0018H\u0080\b¢\u0006\u0004\bF\u0010G\u001a\u0014\u0010I\u001a\u00020H*\u00020\u0000H\u0080\b¢\u0006\u0004\bI\u0010J\u001a\u0014\u0010K\u001a\u00020\n*\u00020\u0000H\u0080\b¢\u0006\u0004\bK\u0010L\u001a\u0014\u0010N\u001a\u00020M*\u00020\u0000H\u0080\b¢\u0006\u0004\bN\u0010O\u001a\u0014\u0010P\u001a\u00020'*\u00020\u0000H\u0080\b¢\u0006\u0004\bP\u0010)¨\u0006Q"}, d2 = {"Lokio/RealBufferedSource;", "Lokio/Buffer;", "sink", "", "byteCount", "commonRead", "(Lokio/RealBufferedSource;Lokio/Buffer;J)J", "", "commonExhausted", "(Lokio/RealBufferedSource;)Z", "Lir/nasim/rB7;", "commonRequire", "(Lokio/RealBufferedSource;J)V", "commonRequest", "(Lokio/RealBufferedSource;J)Z", "", "commonReadByte", "(Lokio/RealBufferedSource;)B", "Lokio/ByteString;", "commonReadByteString", "(Lokio/RealBufferedSource;)Lokio/ByteString;", "(Lokio/RealBufferedSource;J)Lokio/ByteString;", "Lokio/Options;", "options", "", "commonSelect", "(Lokio/RealBufferedSource;Lokio/Options;)I", "", "commonReadByteArray", "(Lokio/RealBufferedSource;)[B", "(Lokio/RealBufferedSource;J)[B", "commonReadFully", "(Lokio/RealBufferedSource;[B)V", "offset", "(Lokio/RealBufferedSource;[BII)I", "(Lokio/RealBufferedSource;Lokio/Buffer;J)V", "Lokio/Sink;", "commonReadAll", "(Lokio/RealBufferedSource;Lokio/Sink;)J", "", "commonReadUtf8", "(Lokio/RealBufferedSource;)Ljava/lang/String;", "(Lokio/RealBufferedSource;J)Ljava/lang/String;", "commonReadUtf8Line", "limit", "commonReadUtf8LineStrict", "commonReadUtf8CodePoint", "(Lokio/RealBufferedSource;)I", "", "commonReadShort", "(Lokio/RealBufferedSource;)S", "commonReadShortLe", "commonReadInt", "commonReadIntLe", "commonReadLong", "(Lokio/RealBufferedSource;)J", "commonReadLongLe", "commonReadDecimalLong", "commonReadHexadecimalUnsignedLong", "commonSkip", "b", "fromIndex", "toIndex", "commonIndexOf", "(Lokio/RealBufferedSource;BJJ)J", "bytes", "(Lokio/RealBufferedSource;Lokio/ByteString;J)J", "targetBytes", "commonIndexOfElement", "bytesOffset", "commonRangeEquals", "(Lokio/RealBufferedSource;JLokio/ByteString;II)Z", "Lokio/BufferedSource;", "commonPeek", "(Lokio/RealBufferedSource;)Lokio/BufferedSource;", "commonClose", "(Lokio/RealBufferedSource;)V", "Lokio/Timeout;", "commonTimeout", "(Lokio/RealBufferedSource;)Lokio/Timeout;", "commonToString", "okio"}, k = 2, mv = {1, 9, 0})
/* renamed from: okio.internal.-RealBufferedSource, reason: invalid class name */
/* loaded from: classes8.dex */
public final class RealBufferedSource {
    public static final void commonClose(buffer bufferVar) throws EOFException {
        AbstractC13042fc3.i(bufferVar, "<this>");
        if (bufferVar.closed) {
            return;
        }
        bufferVar.closed = true;
        bufferVar.source.close();
        bufferVar.bufferField.clear();
    }

    public static final boolean commonExhausted(buffer bufferVar) {
        AbstractC13042fc3.i(bufferVar, "<this>");
        if (!bufferVar.closed) {
            return bufferVar.bufferField.exhausted() && bufferVar.source.read(bufferVar.bufferField, 8192L) == -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final long commonIndexOf(buffer bufferVar, byte b, long j, long j2) {
        AbstractC13042fc3.i(bufferVar, "<this>");
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (0 > j || j > j2) {
            throw new IllegalArgumentException(("fromIndex=" + j + " toIndex=" + j2).toString());
        }
        while (j < j2) {
            long jIndexOf = bufferVar.bufferField.indexOf(b, j, j2);
            if (jIndexOf != -1) {
                return jIndexOf;
            }
            long size = bufferVar.bufferField.size();
            if (size >= j2 || bufferVar.source.read(bufferVar.bufferField, 8192L) == -1) {
                break;
            }
            j = Math.max(j, size);
        }
        return -1L;
    }

    public static final long commonIndexOfElement(buffer bufferVar, ByteString byteString, long j) {
        AbstractC13042fc3.i(bufferVar, "<this>");
        AbstractC13042fc3.i(byteString, "targetBytes");
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long jIndexOfElement = bufferVar.bufferField.indexOfElement(byteString, j);
            if (jIndexOfElement != -1) {
                return jIndexOfElement;
            }
            long size = bufferVar.bufferField.size();
            if (bufferVar.source.read(bufferVar.bufferField, 8192L) == -1) {
                return -1L;
            }
            j = Math.max(j, size);
        }
    }

    public static final BufferedSource commonPeek(buffer bufferVar) {
        AbstractC13042fc3.i(bufferVar, "<this>");
        return Okio.buffer(new PeekSource(bufferVar));
    }

    public static final boolean commonRangeEquals(buffer bufferVar, long j, ByteString byteString, int i, int i2) {
        AbstractC13042fc3.i(bufferVar, "<this>");
        AbstractC13042fc3.i(byteString, "bytes");
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (j < 0 || i < 0 || i2 < 0 || byteString.size() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            long j2 = i3 + j;
            if (!bufferVar.request(1 + j2) || bufferVar.bufferField.getByte(j2) != byteString.getByte(i + i3)) {
                return false;
            }
        }
        return true;
    }

    public static final long commonRead(buffer bufferVar, Buffer buffer, long j) {
        AbstractC13042fc3.i(bufferVar, "<this>");
        AbstractC13042fc3.i(buffer, "sink");
        if (j < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
        }
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (bufferVar.bufferField.size() == 0 && bufferVar.source.read(bufferVar.bufferField, 8192L) == -1) {
            return -1L;
        }
        return bufferVar.bufferField.read(buffer, Math.min(j, bufferVar.bufferField.size()));
    }

    public static final long commonReadAll(buffer bufferVar, Sink sink) {
        AbstractC13042fc3.i(bufferVar, "<this>");
        AbstractC13042fc3.i(sink, "sink");
        long j = 0;
        while (bufferVar.source.read(bufferVar.bufferField, 8192L) != -1) {
            long jCompleteSegmentByteCount = bufferVar.bufferField.completeSegmentByteCount();
            if (jCompleteSegmentByteCount > 0) {
                j += jCompleteSegmentByteCount;
                sink.write(bufferVar.bufferField, jCompleteSegmentByteCount);
            }
        }
        if (bufferVar.bufferField.size() <= 0) {
            return j;
        }
        long size = j + bufferVar.bufferField.size();
        Buffer buffer = bufferVar.bufferField;
        sink.write(buffer, buffer.size());
        return size;
    }

    public static final byte commonReadByte(buffer bufferVar) throws EOFException {
        AbstractC13042fc3.i(bufferVar, "<this>");
        bufferVar.require(1L);
        return bufferVar.bufferField.readByte();
    }

    public static final byte[] commonReadByteArray(buffer bufferVar, long j) throws EOFException {
        AbstractC13042fc3.i(bufferVar, "<this>");
        bufferVar.require(j);
        return bufferVar.bufferField.readByteArray(j);
    }

    public static final ByteString commonReadByteString(buffer bufferVar, long j) throws EOFException {
        AbstractC13042fc3.i(bufferVar, "<this>");
        bufferVar.require(j);
        return bufferVar.bufferField.readByteString(j);
    }

    public static final long commonReadDecimalLong(buffer bufferVar) throws EOFException {
        byte b;
        AbstractC13042fc3.i(bufferVar, "<this>");
        bufferVar.require(1L);
        long j = 0;
        while (true) {
            long j2 = j + 1;
            if (!bufferVar.request(j2)) {
                break;
            }
            b = bufferVar.bufferField.getByte(j);
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
        return bufferVar.bufferField.readDecimalLong();
    }

    public static final void commonReadFully(buffer bufferVar, byte[] bArr) throws EOFException {
        AbstractC13042fc3.i(bufferVar, "<this>");
        AbstractC13042fc3.i(bArr, "sink");
        try {
            bufferVar.require(bArr.length);
            bufferVar.bufferField.readFully(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (bufferVar.bufferField.size() > 0) {
                Buffer buffer = bufferVar.bufferField;
                int i2 = buffer.read(bArr, i, (int) buffer.size());
                if (i2 == -1) {
                    throw new AssertionError();
                }
                i += i2;
            }
            throw e;
        }
    }

    public static final long commonReadHexadecimalUnsignedLong(buffer bufferVar) throws EOFException {
        byte b;
        AbstractC13042fc3.i(bufferVar, "<this>");
        bufferVar.require(1L);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!bufferVar.request(i2)) {
                break;
            }
            b = bufferVar.bufferField.getByte(i);
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
        return bufferVar.bufferField.readHexadecimalUnsignedLong();
    }

    public static final int commonReadInt(buffer bufferVar) throws EOFException {
        AbstractC13042fc3.i(bufferVar, "<this>");
        bufferVar.require(4L);
        return bufferVar.bufferField.readInt();
    }

    public static final int commonReadIntLe(buffer bufferVar) throws EOFException {
        AbstractC13042fc3.i(bufferVar, "<this>");
        bufferVar.require(4L);
        return bufferVar.bufferField.readIntLe();
    }

    public static final long commonReadLong(buffer bufferVar) throws EOFException {
        AbstractC13042fc3.i(bufferVar, "<this>");
        bufferVar.require(8L);
        return bufferVar.bufferField.readLong();
    }

    public static final long commonReadLongLe(buffer bufferVar) throws EOFException {
        AbstractC13042fc3.i(bufferVar, "<this>");
        bufferVar.require(8L);
        return bufferVar.bufferField.readLongLe();
    }

    public static final short commonReadShort(buffer bufferVar) throws EOFException {
        AbstractC13042fc3.i(bufferVar, "<this>");
        bufferVar.require(2L);
        return bufferVar.bufferField.readShort();
    }

    public static final short commonReadShortLe(buffer bufferVar) throws EOFException {
        AbstractC13042fc3.i(bufferVar, "<this>");
        bufferVar.require(2L);
        return bufferVar.bufferField.readShortLe();
    }

    public static final String commonReadUtf8(buffer bufferVar, long j) throws EOFException {
        AbstractC13042fc3.i(bufferVar, "<this>");
        bufferVar.require(j);
        return bufferVar.bufferField.readUtf8(j);
    }

    public static final int commonReadUtf8CodePoint(buffer bufferVar) throws EOFException {
        AbstractC13042fc3.i(bufferVar, "<this>");
        bufferVar.require(1L);
        byte b = bufferVar.bufferField.getByte(0L);
        if ((b & 224) == 192) {
            bufferVar.require(2L);
        } else if ((b & 240) == 224) {
            bufferVar.require(3L);
        } else if ((b & 248) == 240) {
            bufferVar.require(4L);
        }
        return bufferVar.bufferField.readUtf8CodePoint();
    }

    public static final String commonReadUtf8Line(buffer bufferVar) {
        AbstractC13042fc3.i(bufferVar, "<this>");
        long jIndexOf = bufferVar.indexOf((byte) 10);
        if (jIndexOf != -1) {
            return Buffer.readUtf8Line(bufferVar.bufferField, jIndexOf);
        }
        if (bufferVar.bufferField.size() != 0) {
            return bufferVar.readUtf8(bufferVar.bufferField.size());
        }
        return null;
    }

    public static final String commonReadUtf8LineStrict(buffer bufferVar, long j) throws EOFException {
        AbstractC13042fc3.i(bufferVar, "<this>");
        if (j < 0) {
            throw new IllegalArgumentException(("limit < 0: " + j).toString());
        }
        long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
        long jIndexOf = bufferVar.indexOf((byte) 10, 0L, j2);
        if (jIndexOf != -1) {
            return Buffer.readUtf8Line(bufferVar.bufferField, jIndexOf);
        }
        if (j2 < Long.MAX_VALUE && bufferVar.request(j2) && bufferVar.bufferField.getByte(j2 - 1) == 13 && bufferVar.request(1 + j2) && bufferVar.bufferField.getByte(j2) == 10) {
            return Buffer.readUtf8Line(bufferVar.bufferField, j2);
        }
        Buffer buffer = new Buffer();
        Buffer buffer2 = bufferVar.bufferField;
        buffer2.copyTo(buffer, 0L, Math.min(32, buffer2.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(bufferVar.bufferField.size(), j) + " content=" + buffer.readByteString().hex() + (char) 8230);
    }

    public static final boolean commonRequest(buffer bufferVar, long j) {
        AbstractC13042fc3.i(bufferVar, "<this>");
        if (j < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
        }
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (bufferVar.bufferField.size() < j) {
            if (bufferVar.source.read(bufferVar.bufferField, 8192L) == -1) {
                return false;
            }
        }
        return true;
    }

    public static final void commonRequire(buffer bufferVar, long j) throws EOFException {
        AbstractC13042fc3.i(bufferVar, "<this>");
        if (!bufferVar.request(j)) {
            throw new EOFException();
        }
    }

    public static final int commonSelect(buffer bufferVar, Options options) throws EOFException {
        AbstractC13042fc3.i(bufferVar, "<this>");
        AbstractC13042fc3.i(options, "options");
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        do {
            int iSelectPrefix = Buffer.selectPrefix(bufferVar.bufferField, options, true);
            if (iSelectPrefix != -2) {
                if (iSelectPrefix == -1) {
                    return -1;
                }
                bufferVar.bufferField.skip(options.getByteStrings()[iSelectPrefix].size());
                return iSelectPrefix;
            }
        } while (bufferVar.source.read(bufferVar.bufferField, 8192L) != -1);
        return -1;
    }

    public static final void commonSkip(buffer bufferVar, long j) throws EOFException {
        AbstractC13042fc3.i(bufferVar, "<this>");
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (j > 0) {
            if (bufferVar.bufferField.size() == 0 && bufferVar.source.read(bufferVar.bufferField, 8192L) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j, bufferVar.bufferField.size());
            bufferVar.bufferField.skip(jMin);
            j -= jMin;
        }
    }

    public static final Timeout commonTimeout(buffer bufferVar) {
        AbstractC13042fc3.i(bufferVar, "<this>");
        return bufferVar.source.getTimeout();
    }

    public static final String commonToString(buffer bufferVar) {
        AbstractC13042fc3.i(bufferVar, "<this>");
        return "buffer(" + bufferVar.source + ')';
    }

    public static final byte[] commonReadByteArray(buffer bufferVar) {
        AbstractC13042fc3.i(bufferVar, "<this>");
        bufferVar.bufferField.writeAll(bufferVar.source);
        return bufferVar.bufferField.readByteArray();
    }

    public static final ByteString commonReadByteString(buffer bufferVar) {
        AbstractC13042fc3.i(bufferVar, "<this>");
        bufferVar.bufferField.writeAll(bufferVar.source);
        return bufferVar.bufferField.readByteString();
    }

    public static final String commonReadUtf8(buffer bufferVar) {
        AbstractC13042fc3.i(bufferVar, "<this>");
        bufferVar.bufferField.writeAll(bufferVar.source);
        return bufferVar.bufferField.readUtf8();
    }

    public static final void commonReadFully(buffer bufferVar, Buffer buffer, long j) throws EOFException {
        AbstractC13042fc3.i(bufferVar, "<this>");
        AbstractC13042fc3.i(buffer, "sink");
        try {
            bufferVar.require(j);
            bufferVar.bufferField.readFully(buffer, j);
        } catch (EOFException e) {
            buffer.writeAll(bufferVar.bufferField);
            throw e;
        }
    }

    public static final long commonIndexOf(buffer bufferVar, ByteString byteString, long j) {
        AbstractC13042fc3.i(bufferVar, "<this>");
        AbstractC13042fc3.i(byteString, "bytes");
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long jIndexOf = bufferVar.bufferField.indexOf(byteString, j);
            if (jIndexOf != -1) {
                return jIndexOf;
            }
            long size = bufferVar.bufferField.size();
            if (bufferVar.source.read(bufferVar.bufferField, 8192L) == -1) {
                return -1L;
            }
            j = Math.max(j, (size - byteString.size()) + 1);
        }
    }

    public static final int commonRead(buffer bufferVar, byte[] bArr, int i, int i2) {
        AbstractC13042fc3.i(bufferVar, "<this>");
        AbstractC13042fc3.i(bArr, "sink");
        long j = i2;
        SegmentedByteString.checkOffsetAndCount(bArr.length, i, j);
        if (bufferVar.bufferField.size() == 0 && bufferVar.source.read(bufferVar.bufferField, 8192L) == -1) {
            return -1;
        }
        return bufferVar.bufferField.read(bArr, i, (int) Math.min(j, bufferVar.bufferField.size()));
    }
}
