package okio;

import android.gov.nist.javax.sip.parser.TokenNames;
import ir.nasim.InterfaceC14067hI1;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u00012\u00020\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H'¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0013H&¢\u0006\u0004\b\u0016\u0010\u0015J\u000f\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0017H&¢\u0006\u0004\b\u001a\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\tH&¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\tH&¢\u0006\u0004\b\u001d\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\tH&¢\u0006\u0004\b\u001e\u0010\u001cJ\u000f\u0010\u001f\u001a\u00020\tH&¢\u0006\u0004\b\u001f\u0010\u001cJ\u0017\u0010 \u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b \u0010\rJ\u000f\u0010\"\u001a\u00020!H&¢\u0006\u0004\b\"\u0010#J\u0017\u0010\"\u001a\u00020!2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\"\u0010$J\u0017\u0010'\u001a\u00020\u00172\u0006\u0010&\u001a\u00020%H&¢\u0006\u0004\b'\u0010(J)\u0010'\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010**\u00020)2\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000+H&¢\u0006\u0004\b'\u0010,J\u000f\u0010.\u001a\u00020-H&¢\u0006\u0004\b.\u0010/J\u0017\u0010.\u001a\u00020-2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b.\u00100J\u0017\u00102\u001a\u00020\u00172\u0006\u00101\u001a\u00020-H&¢\u0006\u0004\b2\u00103J\u0017\u00104\u001a\u00020\u000b2\u0006\u00101\u001a\u00020-H&¢\u0006\u0004\b4\u00105J'\u00102\u001a\u00020\u00172\u0006\u00101\u001a\u00020-2\u0006\u00106\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u0017H&¢\u0006\u0004\b2\u00107J\u001f\u00104\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b4\u00108J\u0017\u0010:\u001a\u00020\t2\u0006\u00101\u001a\u000209H&¢\u0006\u0004\b:\u0010;J\u000f\u0010=\u001a\u00020<H&¢\u0006\u0004\b=\u0010>J\u0017\u0010=\u001a\u00020<2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b=\u0010?J\u0011\u0010@\u001a\u0004\u0018\u00010<H&¢\u0006\u0004\b@\u0010>J\u000f\u0010A\u001a\u00020<H&¢\u0006\u0004\bA\u0010>J\u0017\u0010A\u001a\u00020<2\u0006\u0010B\u001a\u00020\tH&¢\u0006\u0004\bA\u0010?J\u000f\u0010C\u001a\u00020\u0017H&¢\u0006\u0004\bC\u0010\u0019J\u0017\u0010F\u001a\u00020<2\u0006\u0010E\u001a\u00020DH&¢\u0006\u0004\bF\u0010GJ\u001f\u0010F\u001a\u00020<2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010E\u001a\u00020DH&¢\u0006\u0004\bF\u0010HJ\u0017\u0010J\u001a\u00020\t2\u0006\u0010I\u001a\u00020\u0010H&¢\u0006\u0004\bJ\u0010KJ\u001f\u0010J\u001a\u00020\t2\u0006\u0010I\u001a\u00020\u00102\u0006\u0010L\u001a\u00020\tH&¢\u0006\u0004\bJ\u0010MJ'\u0010J\u001a\u00020\t2\u0006\u0010I\u001a\u00020\u00102\u0006\u0010L\u001a\u00020\t2\u0006\u0010N\u001a\u00020\tH&¢\u0006\u0004\bJ\u0010OJ\u0017\u0010J\u001a\u00020\t2\u0006\u0010P\u001a\u00020!H&¢\u0006\u0004\bJ\u0010QJ\u001f\u0010J\u001a\u00020\t2\u0006\u0010P\u001a\u00020!2\u0006\u0010L\u001a\u00020\tH&¢\u0006\u0004\bJ\u0010RJ\u0017\u0010T\u001a\u00020\t2\u0006\u0010S\u001a\u00020!H&¢\u0006\u0004\bT\u0010QJ\u001f\u0010T\u001a\u00020\t2\u0006\u0010S\u001a\u00020!2\u0006\u0010L\u001a\u00020\tH&¢\u0006\u0004\bT\u0010RJ\u001f\u0010U\u001a\u00020\u00062\u0006\u00106\u001a\u00020\t2\u0006\u0010P\u001a\u00020!H&¢\u0006\u0004\bU\u0010VJ/\u0010U\u001a\u00020\u00062\u0006\u00106\u001a\u00020\t2\u0006\u0010P\u001a\u00020!2\u0006\u0010W\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u0017H&¢\u0006\u0004\bU\u0010XJ\u000f\u0010Y\u001a\u00020\u0000H&¢\u0006\u0004\bY\u0010ZJ\u000f\u0010\\\u001a\u00020[H&¢\u0006\u0004\b\\\u0010]R\u0014\u0010\u0004\u001a\u00020\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b^\u0010\u0005\u0082\u0001\u0002\u0003_ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006`À\u0006\u0001"}, d2 = {"Lokio/BufferedSource;", "Lokio/Source;", "Ljava/nio/channels/ReadableByteChannel;", "Lokio/Buffer;", "buffer", "()Lokio/Buffer;", "", "exhausted", "()Z", "", "byteCount", "Lir/nasim/rB7;", "require", "(J)V", "request", "(J)Z", "", "readByte", "()B", "", "readShort", "()S", "readShortLe", "", "readInt", "()I", "readIntLe", "readLong", "()J", "readLongLe", "readDecimalLong", "readHexadecimalUnsignedLong", "skip", "Lokio/ByteString;", "readByteString", "()Lokio/ByteString;", "(J)Lokio/ByteString;", "Lokio/Options;", "options", "select", "(Lokio/Options;)I", "", TokenNames.T, "Lokio/TypedOptions;", "(Lokio/TypedOptions;)Ljava/lang/Object;", "", "readByteArray", "()[B", "(J)[B", "sink", "read", "([B)I", "readFully", "([B)V", "offset", "([BII)I", "(Lokio/Buffer;J)V", "Lokio/Sink;", "readAll", "(Lokio/Sink;)J", "", "readUtf8", "()Ljava/lang/String;", "(J)Ljava/lang/String;", "readUtf8Line", "readUtf8LineStrict", "limit", "readUtf8CodePoint", "Ljava/nio/charset/Charset;", "charset", "readString", "(Ljava/nio/charset/Charset;)Ljava/lang/String;", "(JLjava/nio/charset/Charset;)Ljava/lang/String;", "b", "indexOf", "(B)J", "fromIndex", "(BJ)J", "toIndex", "(BJJ)J", "bytes", "(Lokio/ByteString;)J", "(Lokio/ByteString;J)J", "targetBytes", "indexOfElement", "rangeEquals", "(JLokio/ByteString;)Z", "bytesOffset", "(JLokio/ByteString;II)Z", "peek", "()Lokio/BufferedSource;", "Ljava/io/InputStream;", "inputStream", "()Ljava/io/InputStream;", "getBuffer", "Lokio/RealBufferedSource;", "okio"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes8.dex */
public interface BufferedSource extends Source, ReadableByteChannel {
    @InterfaceC14067hI1
    /* renamed from: buffer */
    Buffer getBufferField();

    boolean exhausted();

    Buffer getBuffer();

    long indexOf(byte b);

    long indexOf(byte b, long fromIndex);

    long indexOf(byte b, long fromIndex, long toIndex);

    long indexOf(ByteString bytes);

    long indexOf(ByteString bytes, long fromIndex);

    long indexOfElement(ByteString targetBytes);

    long indexOfElement(ByteString targetBytes, long fromIndex);

    InputStream inputStream();

    BufferedSource peek();

    boolean rangeEquals(long offset, ByteString bytes);

    boolean rangeEquals(long offset, ByteString bytes, int bytesOffset, int byteCount);

    int read(byte[] sink);

    int read(byte[] sink, int offset, int byteCount);

    long readAll(Sink sink);

    byte readByte();

    byte[] readByteArray();

    byte[] readByteArray(long byteCount);

    ByteString readByteString();

    ByteString readByteString(long byteCount);

    long readDecimalLong();

    void readFully(Buffer sink, long byteCount);

    void readFully(byte[] sink);

    long readHexadecimalUnsignedLong();

    int readInt();

    int readIntLe();

    long readLong();

    long readLongLe();

    short readShort();

    short readShortLe();

    String readString(long byteCount, Charset charset);

    String readString(Charset charset);

    String readUtf8();

    String readUtf8(long byteCount);

    int readUtf8CodePoint();

    String readUtf8Line();

    String readUtf8LineStrict();

    String readUtf8LineStrict(long limit);

    boolean request(long byteCount);

    void require(long byteCount);

    int select(Options options);

    <T> T select(TypedOptions<T> options);

    void skip(long byteCount);
}
