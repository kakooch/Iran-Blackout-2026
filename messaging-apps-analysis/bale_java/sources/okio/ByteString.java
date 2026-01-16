package okio;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sdp.fields.SDPKeywords;
import android.gov.nist.javax.sip.clientauthutils.DigestServerAuthenticationHelper;
import android.gov.nist.javax.sip.parser.TokenNames;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC20153rZ6;
import ir.nasim.AbstractC9648aK;
import ir.nasim.C12275eL0;
import ir.nasim.ED1;
import ir.nasim.InterfaceC14067hI1;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u0015\b\u0016\u0018\u0000 v2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001vB\u0011\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0017\u0010\u0012J\r\u0010\u0018\u001a\u00020\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\u0000¢\u0006\u0004\b\u001a\u0010\u0019J\r\u0010\u001b\u001a\u00020\u0000¢\u0006\u0004\b\u001b\u0010\u0019J\r\u0010\u001c\u001a\u00020\u0000¢\u0006\u0004\b\u001c\u0010\u0019J\u0017\u0010 \u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0010H\u0010¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0000H\u0016¢\u0006\u0004\b$\u0010#J\u0017\u0010%\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0000H\u0016¢\u0006\u0004\b%\u0010#J\u001f\u0010(\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u0000H\u0010¢\u0006\u0004\b&\u0010'J\u000f\u0010)\u001a\u00020\u0010H\u0016¢\u0006\u0004\b)\u0010\u0012J\u000f\u0010*\u001a\u00020\u0010H\u0016¢\u0006\u0004\b*\u0010\u0012J\u000f\u0010+\u001a\u00020\u0000H\u0016¢\u0006\u0004\b+\u0010\u0019J\u000f\u0010,\u001a\u00020\u0000H\u0016¢\u0006\u0004\b,\u0010\u0019J#\u00100\u001a\u00020\u00002\b\b\u0002\u0010.\u001a\u00020-2\b\b\u0002\u0010/\u001a\u00020-H\u0017¢\u0006\u0004\b0\u00101J\u0017\u00106\u001a\u0002032\u0006\u00102\u001a\u00020-H\u0010¢\u0006\u0004\b4\u00105J\u0018\u00109\u001a\u0002032\u0006\u00107\u001a\u00020-H\u0087\u0002¢\u0006\u0004\b8\u00105J\u000f\u0010<\u001a\u00020-H\u0010¢\u0006\u0004\b:\u0010;J\u000f\u0010=\u001a\u00020\u0003H\u0016¢\u0006\u0004\b=\u0010>J\u000f\u0010@\u001a\u00020\u0003H\u0010¢\u0006\u0004\b?\u0010>J\u000f\u0010B\u001a\u00020AH\u0016¢\u0006\u0004\bB\u0010CJ\u0017\u0010E\u001a\u00020\t2\u0006\u0010\r\u001a\u00020DH\u0016¢\u0006\u0004\bE\u0010FJ'\u0010E\u001a\u00020\t2\u0006\u0010H\u001a\u00020G2\u0006\u0010I\u001a\u00020-2\u0006\u0010J\u001a\u00020-H\u0010¢\u0006\u0004\bK\u0010LJ/\u0010P\u001a\u00020O2\u0006\u0010I\u001a\u00020-2\u0006\u0010M\u001a\u00020\u00002\u0006\u0010N\u001a\u00020-2\u0006\u0010J\u001a\u00020-H\u0016¢\u0006\u0004\bP\u0010QJ/\u0010P\u001a\u00020O2\u0006\u0010I\u001a\u00020-2\u0006\u0010M\u001a\u00020\u00032\u0006\u0010N\u001a\u00020-2\u0006\u0010J\u001a\u00020-H\u0016¢\u0006\u0004\bP\u0010RJ3\u0010U\u001a\u00020\t2\b\b\u0002\u0010I\u001a\u00020-2\u0006\u0010S\u001a\u00020\u00032\b\b\u0002\u0010T\u001a\u00020-2\u0006\u0010J\u001a\u00020-H\u0016¢\u0006\u0004\bU\u0010VJ\u0015\u0010X\u001a\u00020O2\u0006\u0010W\u001a\u00020\u0000¢\u0006\u0004\bX\u0010YJ\u0015\u0010X\u001a\u00020O2\u0006\u0010W\u001a\u00020\u0003¢\u0006\u0004\bX\u0010ZJ\u0015\u0010\\\u001a\u00020O2\u0006\u0010[\u001a\u00020\u0000¢\u0006\u0004\b\\\u0010YJ\u0015\u0010\\\u001a\u00020O2\u0006\u0010[\u001a\u00020\u0003¢\u0006\u0004\b\\\u0010ZJ!\u0010^\u001a\u00020-2\u0006\u0010M\u001a\u00020\u00002\b\b\u0002\u0010]\u001a\u00020-H\u0007¢\u0006\u0004\b^\u0010_J!\u0010^\u001a\u00020-2\u0006\u0010M\u001a\u00020\u00032\b\b\u0002\u0010]\u001a\u00020-H\u0017¢\u0006\u0004\b^\u0010`J!\u0010a\u001a\u00020-2\u0006\u0010M\u001a\u00020\u00002\b\b\u0002\u0010]\u001a\u00020-H\u0007¢\u0006\u0004\ba\u0010_J!\u0010a\u001a\u00020-2\u0006\u0010M\u001a\u00020\u00032\b\b\u0002\u0010]\u001a\u00020-H\u0017¢\u0006\u0004\ba\u0010`J\u001a\u0010c\u001a\u00020O2\b\u0010M\u001a\u0004\u0018\u00010bH\u0096\u0002¢\u0006\u0004\bc\u0010dJ\u000f\u0010e\u001a\u00020-H\u0016¢\u0006\u0004\be\u0010;J\u0018\u0010f\u001a\u00020-2\u0006\u0010M\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\bf\u0010gJ\u000f\u0010h\u001a\u00020\u0010H\u0016¢\u0006\u0004\bh\u0010\u0012J\u0017\u00108\u001a\u0002032\u0006\u00107\u001a\u00020-H\u0007¢\u0006\u0004\bi\u00105J\u000f\u0010k\u001a\u00020-H\u0007¢\u0006\u0004\bj\u0010;R\u001a\u0010\u0004\u001a\u00020\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010l\u001a\u0004\bm\u0010>R\"\u0010e\u001a\u00020-8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\be\u0010n\u001a\u0004\bo\u0010;\"\u0004\bp\u0010qR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010r\u001a\u0004\bs\u0010\u0012\"\u0004\bt\u0010uR\u0011\u0010k\u001a\u00020-8G¢\u0006\u0006\u001a\u0004\bk\u0010;¨\u0006w"}, d2 = {"Lokio/ByteString;", "Ljava/io/Serializable;", "", "", "data", "<init>", "([B)V", "Ljava/io/ObjectInputStream;", "in", "Lir/nasim/rB7;", "readObject", "(Ljava/io/ObjectInputStream;)V", "Ljava/io/ObjectOutputStream;", "out", "writeObject", "(Ljava/io/ObjectOutputStream;)V", "", "utf8", "()Ljava/lang/String;", "Ljava/nio/charset/Charset;", "charset", "string", "(Ljava/nio/charset/Charset;)Ljava/lang/String;", SDPKeywords.BASE64, "md5", "()Lokio/ByteString;", "sha1", "sha256", "sha512", "algorithm", "digest$okio", "(Ljava/lang/String;)Lokio/ByteString;", "digest", "key", "hmacSha1", "(Lokio/ByteString;)Lokio/ByteString;", "hmacSha256", "hmacSha512", "hmac$okio", "(Ljava/lang/String;Lokio/ByteString;)Lokio/ByteString;", "hmac", "base64Url", "hex", "toAsciiLowercase", "toAsciiUppercase", "", "beginIndex", "endIndex", "substring", "(II)Lokio/ByteString;", "pos", "", "internalGet$okio", "(I)B", "internalGet", "index", "getByte", "get", "getSize$okio", "()I", "getSize", "toByteArray", "()[B", "internalArray$okio", "internalArray", "Ljava/nio/ByteBuffer;", "asByteBuffer", "()Ljava/nio/ByteBuffer;", "Ljava/io/OutputStream;", "write", "(Ljava/io/OutputStream;)V", "Lokio/Buffer;", "buffer", "offset", "byteCount", "write$okio", "(Lokio/Buffer;II)V", "other", "otherOffset", "", "rangeEquals", "(ILokio/ByteString;II)Z", "(I[BII)Z", "target", "targetOffset", "copyInto", "(I[BII)V", "prefix", "startsWith", "(Lokio/ByteString;)Z", "([B)Z", "suffix", "endsWith", "fromIndex", "indexOf", "(Lokio/ByteString;I)I", "([BI)I", "lastIndexOf", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "compareTo", "(Lokio/ByteString;)I", "toString", "-deprecated_getByte", "-deprecated_size", "size", "[B", "getData$okio", TokenNames.I, "getHashCode$okio", "setHashCode$okio", "(I)V", "Ljava/lang/String;", "getUtf8$okio", "setUtf8$okio", "(Ljava/lang/String;)V", "Companion", "okio"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes8.dex */
public class ByteString implements Serializable, Comparable<ByteString> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final ByteString EMPTY = new ByteString(new byte[0]);
    private static final long serialVersionUID = 1;
    private final byte[] data;
    private transient int hashCode;
    private transient String utf8;

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\nJ\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\fJ\u001d\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0002\b\u0010J\u0015\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\u0012J\u0015\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0002\b\u0016J\u0014\u0010\u0013\u001a\u00020\u00042\n\u0010\u0017\u001a\u00020\u0018\"\u00020\u0019H\u0007J%\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0002\b\u0016J\u001d\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0002\b!J\u000e\u0010\u0007\u001a\u0004\u0018\u00010\u0004*\u00020\tH\u0007J\f\u0010\u000b\u001a\u00020\u0004*\u00020\tH\u0007J\u001b\u0010\"\u001a\u00020\u0004*\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0002\b\rJ\f\u0010\u0011\u001a\u00020\u0004*\u00020\tH\u0007J\u0019\u0010#\u001a\u00020\u0004*\u00020 2\u0006\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0002\b\u001eJ\u0011\u0010$\u001a\u00020\u0004*\u00020\u0015H\u0007¢\u0006\u0002\b\u0013J%\u0010$\u001a\u00020\u0004*\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0002\b\u0013R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lokio/ByteString$Companion;", "", "()V", "EMPTY", "Lokio/ByteString;", "serialVersionUID", "", "decodeBase64", "string", "", "-deprecated_decodeBase64", "decodeHex", "-deprecated_decodeHex", "encodeString", "charset", "Ljava/nio/charset/Charset;", "-deprecated_encodeString", "encodeUtf8", "-deprecated_encodeUtf8", "of", "buffer", "Ljava/nio/ByteBuffer;", "-deprecated_of", "data", "", "", "array", "offset", "", "byteCount", "read", "inputstream", "Ljava/io/InputStream;", "-deprecated_read", "encode", "readByteString", "toByteString", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ ByteString encodeString$default(Companion companion, String str, Charset charset, int i, Object obj) {
            if ((i & 1) != 0) {
                charset = C12275eL0.b;
            }
            return companion.encodeString(str, charset);
        }

        public static /* synthetic */ ByteString of$default(Companion companion, byte[] bArr, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = SegmentedByteString.getDEFAULT__ByteString_size();
            }
            return companion.of(bArr, i, i2);
        }

        @InterfaceC14067hI1
        /* renamed from: -deprecated_decodeBase64, reason: not valid java name */
        public final ByteString m167deprecated_decodeBase64(String string) {
            AbstractC13042fc3.i(string, "string");
            return decodeBase64(string);
        }

        @InterfaceC14067hI1
        /* renamed from: -deprecated_decodeHex, reason: not valid java name */
        public final ByteString m168deprecated_decodeHex(String string) {
            AbstractC13042fc3.i(string, "string");
            return decodeHex(string);
        }

        @InterfaceC14067hI1
        /* renamed from: -deprecated_encodeString, reason: not valid java name */
        public final ByteString m169deprecated_encodeString(String string, Charset charset) {
            AbstractC13042fc3.i(string, "string");
            AbstractC13042fc3.i(charset, "charset");
            return encodeString(string, charset);
        }

        @InterfaceC14067hI1
        /* renamed from: -deprecated_encodeUtf8, reason: not valid java name */
        public final ByteString m170deprecated_encodeUtf8(String string) {
            AbstractC13042fc3.i(string, "string");
            return encodeUtf8(string);
        }

        @InterfaceC14067hI1
        /* renamed from: -deprecated_of, reason: not valid java name */
        public final ByteString m171deprecated_of(ByteBuffer buffer) {
            AbstractC13042fc3.i(buffer, "buffer");
            return of(buffer);
        }

        @InterfaceC14067hI1
        /* renamed from: -deprecated_read, reason: not valid java name */
        public final ByteString m173deprecated_read(InputStream inputstream, int byteCount) {
            AbstractC13042fc3.i(inputstream, "inputstream");
            return read(inputstream, byteCount);
        }

        public final ByteString decodeBase64(String str) {
            AbstractC13042fc3.i(str, "<this>");
            byte[] bArrDecodeBase64ToArray = Base64.decodeBase64ToArray(str);
            if (bArrDecodeBase64ToArray != null) {
                return new ByteString(bArrDecodeBase64ToArray);
            }
            return null;
        }

        public final ByteString decodeHex(String str) {
            AbstractC13042fc3.i(str, "<this>");
            if (str.length() % 2 != 0) {
                throw new IllegalArgumentException(("Unexpected hex string: " + str).toString());
            }
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                bArr[i] = (byte) ((okio.internal.ByteString.decodeHexDigit(str.charAt(i2)) << 4) + okio.internal.ByteString.decodeHexDigit(str.charAt(i2 + 1)));
            }
            return new ByteString(bArr);
        }

        public final ByteString encodeString(String str, Charset charset) {
            AbstractC13042fc3.i(str, "<this>");
            AbstractC13042fc3.i(charset, "charset");
            byte[] bytes = str.getBytes(charset);
            AbstractC13042fc3.h(bytes, "getBytes(...)");
            return new ByteString(bytes);
        }

        public final ByteString encodeUtf8(String str) {
            AbstractC13042fc3.i(str, "<this>");
            ByteString byteString = new ByteString(_JvmPlatformKt.asUtf8ToByteArray(str));
            byteString.setUtf8$okio(str);
            return byteString;
        }

        public final ByteString of(ByteBuffer byteBuffer) {
            AbstractC13042fc3.i(byteBuffer, "<this>");
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            return new ByteString(bArr);
        }

        public final ByteString read(InputStream inputStream, int i) throws IOException {
            AbstractC13042fc3.i(inputStream, "<this>");
            if (i < 0) {
                throw new IllegalArgumentException(("byteCount < 0: " + i).toString());
            }
            byte[] bArr = new byte[i];
            int i2 = 0;
            while (i2 < i) {
                int i3 = inputStream.read(bArr, i2, i - i2);
                if (i3 == -1) {
                    throw new EOFException();
                }
                i2 += i3;
            }
            return new ByteString(bArr);
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }

        @InterfaceC14067hI1
        /* renamed from: -deprecated_of, reason: not valid java name */
        public final ByteString m172deprecated_of(byte[] array, int offset, int byteCount) {
            AbstractC13042fc3.i(array, "array");
            return of(array, offset, byteCount);
        }

        public final ByteString of(byte... data) {
            AbstractC13042fc3.i(data, "data");
            byte[] bArrCopyOf = Arrays.copyOf(data, data.length);
            AbstractC13042fc3.h(bArrCopyOf, "copyOf(...)");
            return new ByteString(bArrCopyOf);
        }

        public final ByteString of(byte[] bArr, int i, int i2) {
            AbstractC13042fc3.i(bArr, "<this>");
            int iResolveDefaultParameter = SegmentedByteString.resolveDefaultParameter(bArr, i2);
            SegmentedByteString.checkOffsetAndCount(bArr.length, i, iResolveDefaultParameter);
            return new ByteString(AbstractC9648aK.r(bArr, i, iResolveDefaultParameter + i));
        }
    }

    public ByteString(byte[] bArr) {
        AbstractC13042fc3.i(bArr, "data");
        this.data = bArr;
    }

    public static /* synthetic */ void copyInto$default(ByteString byteString, int i, byte[] bArr, int i2, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copyInto");
        }
        if ((i4 & 1) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        byteString.copyInto(i, bArr, i2, i3);
    }

    public static final ByteString decodeBase64(String str) {
        return INSTANCE.decodeBase64(str);
    }

    public static final ByteString decodeHex(String str) {
        return INSTANCE.decodeHex(str);
    }

    public static final ByteString encodeString(String str, Charset charset) {
        return INSTANCE.encodeString(str, charset);
    }

    public static final ByteString encodeUtf8(String str) {
        return INSTANCE.encodeUtf8(str);
    }

    public static /* synthetic */ int indexOf$default(ByteString byteString, ByteString byteString2, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        }
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return byteString.indexOf(byteString2, i);
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString byteString, ByteString byteString2, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        }
        if ((i2 & 2) != 0) {
            i = SegmentedByteString.getDEFAULT__ByteString_size();
        }
        return byteString.lastIndexOf(byteString2, i);
    }

    public static final ByteString of(ByteBuffer byteBuffer) {
        return INSTANCE.of(byteBuffer);
    }

    public static final ByteString read(InputStream inputStream, int i) {
        return INSTANCE.read(inputStream, i);
    }

    private final void readObject(ObjectInputStream in) throws IllegalAccessException, NoSuchFieldException, IOException, SecurityException, IllegalArgumentException {
        ByteString byteString = INSTANCE.read(in, in.readInt());
        Field declaredField = ByteString.class.getDeclaredField("data");
        declaredField.setAccessible(true);
        declaredField.set(this, byteString.data);
    }

    public static /* synthetic */ ByteString substring$default(ByteString byteString, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: substring");
        }
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = SegmentedByteString.getDEFAULT__ByteString_size();
        }
        return byteString.substring(i, i2);
    }

    private final void writeObject(ObjectOutputStream out) throws IOException {
        out.writeInt(this.data.length);
        out.write(this.data);
    }

    @InterfaceC14067hI1
    /* renamed from: -deprecated_getByte, reason: not valid java name */
    public final byte m165deprecated_getByte(int index) {
        return getByte(index);
    }

    @InterfaceC14067hI1
    /* renamed from: -deprecated_size, reason: not valid java name */
    public final int m166deprecated_size() {
        return size();
    }

    public ByteBuffer asByteBuffer() {
        ByteBuffer byteBufferAsReadOnlyBuffer = ByteBuffer.wrap(this.data).asReadOnlyBuffer();
        AbstractC13042fc3.h(byteBufferAsReadOnlyBuffer, "asReadOnlyBuffer(...)");
        return byteBufferAsReadOnlyBuffer;
    }

    public String base64() {
        return Base64.encodeBase64$default(getData(), null, 1, null);
    }

    public String base64Url() {
        return Base64.encodeBase64(getData(), Base64.getBASE64_URL_SAFE());
    }

    public void copyInto(int offset, byte[] target, int targetOffset, int byteCount) {
        AbstractC13042fc3.i(target, "target");
        AbstractC9648aK.g(getData(), target, targetOffset, offset, byteCount + offset);
    }

    public ByteString digest$okio(String algorithm) throws NoSuchAlgorithmException {
        AbstractC13042fc3.i(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        messageDigest.update(this.data, 0, size());
        byte[] bArrDigest = messageDigest.digest();
        AbstractC13042fc3.f(bArrDigest);
        return new ByteString(bArrDigest);
    }

    public final boolean endsWith(ByteString suffix) {
        AbstractC13042fc3.i(suffix, "suffix");
        return rangeEquals(size() - suffix.size(), suffix, 0, suffix.size());
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other instanceof ByteString) {
            ByteString byteString = (ByteString) other;
            if (byteString.size() == getData().length && byteString.rangeEquals(0, getData(), 0, getData().length)) {
                return true;
            }
        }
        return false;
    }

    public final byte getByte(int index) {
        return internalGet$okio(index);
    }

    /* renamed from: getData$okio, reason: from getter */
    public final byte[] getData() {
        return this.data;
    }

    /* renamed from: getHashCode$okio, reason: from getter */
    public final int getHashCode() {
        return this.hashCode;
    }

    public int getSize$okio() {
        return getData().length;
    }

    /* renamed from: getUtf8$okio, reason: from getter */
    public final String getUtf8() {
        return this.utf8;
    }

    public int hashCode() {
        int hashCode = getHashCode();
        if (hashCode != 0) {
            return hashCode;
        }
        int iHashCode = Arrays.hashCode(getData());
        setHashCode$okio(iHashCode);
        return iHashCode;
    }

    public String hex() {
        char[] cArr = new char[getData().length * 2];
        int i = 0;
        for (byte b : getData()) {
            int i2 = i + 1;
            cArr[i] = okio.internal.ByteString.getHEX_DIGIT_CHARS()[(b >> 4) & 15];
            i += 2;
            cArr[i2] = okio.internal.ByteString.getHEX_DIGIT_CHARS()[b & 15];
        }
        return AbstractC20153rZ6.w(cArr);
    }

    public ByteString hmac$okio(String algorithm, ByteString key) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {
        AbstractC13042fc3.i(algorithm, "algorithm");
        AbstractC13042fc3.i(key, "key");
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.toByteArray(), algorithm));
            byte[] bArrDoFinal = mac.doFinal(this.data);
            AbstractC13042fc3.h(bArrDoFinal, "doFinal(...)");
            return new ByteString(bArrDoFinal);
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public ByteString hmacSha1(ByteString key) {
        AbstractC13042fc3.i(key, "key");
        return hmac$okio("HmacSHA1", key);
    }

    public ByteString hmacSha256(ByteString key) {
        AbstractC13042fc3.i(key, "key");
        return hmac$okio("HmacSHA256", key);
    }

    public ByteString hmacSha512(ByteString key) {
        AbstractC13042fc3.i(key, "key");
        return hmac$okio("HmacSHA512", key);
    }

    public final int indexOf(ByteString byteString) {
        AbstractC13042fc3.i(byteString, "other");
        return indexOf$default(this, byteString, 0, 2, (Object) null);
    }

    public byte[] internalArray$okio() {
        return getData();
    }

    public byte internalGet$okio(int pos) {
        return getData()[pos];
    }

    public final int lastIndexOf(ByteString byteString) {
        AbstractC13042fc3.i(byteString, "other");
        return lastIndexOf$default(this, byteString, 0, 2, (Object) null);
    }

    public final ByteString md5() {
        return digest$okio(DigestServerAuthenticationHelper.DEFAULT_ALGORITHM);
    }

    public boolean rangeEquals(int offset, ByteString other, int otherOffset, int byteCount) {
        AbstractC13042fc3.i(other, "other");
        return other.rangeEquals(otherOffset, getData(), offset, byteCount);
    }

    public final void setHashCode$okio(int i) {
        this.hashCode = i;
    }

    public final void setUtf8$okio(String str) {
        this.utf8 = str;
    }

    public final ByteString sha1() {
        return digest$okio("SHA-1");
    }

    public final ByteString sha256() {
        return digest$okio("SHA-256");
    }

    public final ByteString sha512() {
        return digest$okio("SHA-512");
    }

    public final int size() {
        return getSize$okio();
    }

    public final boolean startsWith(ByteString prefix) {
        AbstractC13042fc3.i(prefix, "prefix");
        return rangeEquals(0, prefix, 0, prefix.size());
    }

    public String string(Charset charset) {
        AbstractC13042fc3.i(charset, "charset");
        return new String(this.data, charset);
    }

    public final ByteString substring() {
        return substring$default(this, 0, 0, 3, null);
    }

    public ByteString toAsciiLowercase() {
        for (int i = 0; i < getData().length; i++) {
            byte b = getData()[i];
            if (b >= 65 && b <= 90) {
                byte[] data = getData();
                byte[] bArrCopyOf = Arrays.copyOf(data, data.length);
                AbstractC13042fc3.h(bArrCopyOf, "copyOf(...)");
                bArrCopyOf[i] = (byte) (b + 32);
                for (int i2 = i + 1; i2 < bArrCopyOf.length; i2++) {
                    byte b2 = bArrCopyOf[i2];
                    if (b2 >= 65 && b2 <= 90) {
                        bArrCopyOf[i2] = (byte) (b2 + 32);
                    }
                }
                return new ByteString(bArrCopyOf);
            }
        }
        return this;
    }

    public ByteString toAsciiUppercase() {
        for (int i = 0; i < getData().length; i++) {
            byte b = getData()[i];
            if (b >= 97 && b <= 122) {
                byte[] data = getData();
                byte[] bArrCopyOf = Arrays.copyOf(data, data.length);
                AbstractC13042fc3.h(bArrCopyOf, "copyOf(...)");
                bArrCopyOf[i] = (byte) (b - 32);
                for (int i2 = i + 1; i2 < bArrCopyOf.length; i2++) {
                    byte b2 = bArrCopyOf[i2];
                    if (b2 >= 97 && b2 <= 122) {
                        bArrCopyOf[i2] = (byte) (b2 - 32);
                    }
                }
                return new ByteString(bArrCopyOf);
            }
        }
        return this;
    }

    public byte[] toByteArray() {
        byte[] data = getData();
        byte[] bArrCopyOf = Arrays.copyOf(data, data.length);
        AbstractC13042fc3.h(bArrCopyOf, "copyOf(...)");
        return bArrCopyOf;
    }

    public String toString() {
        String str;
        if (getData().length == 0) {
            str = "[size=0]";
        } else {
            int iCodePointIndexToCharIndex = okio.internal.ByteString.codePointIndexToCharIndex(getData(), 64);
            if (iCodePointIndexToCharIndex != -1) {
                String strUtf8 = utf8();
                String strSubstring = strUtf8.substring(0, iCodePointIndexToCharIndex);
                AbstractC13042fc3.h(strSubstring, "substring(...)");
                String strM = AbstractC20153rZ6.M(AbstractC20153rZ6.M(AbstractC20153rZ6.M(strSubstring, "\\", "\\\\", false, 4, null), Separators.RETURN, "\\n", false, 4, null), "\r", "\\r", false, 4, null);
                if (iCodePointIndexToCharIndex >= strUtf8.length()) {
                    return "[text=" + strM + ']';
                }
                return "[size=" + getData().length + " text=" + strM + "…]";
            }
            if (getData().length > 64) {
                StringBuilder sb = new StringBuilder();
                sb.append("[size=");
                sb.append(getData().length);
                sb.append(" hex=");
                int iResolveDefaultParameter = SegmentedByteString.resolveDefaultParameter(this, 64);
                if (iResolveDefaultParameter <= getData().length) {
                    if (iResolveDefaultParameter < 0) {
                        throw new IllegalArgumentException("endIndex < beginIndex".toString());
                    }
                    sb.append((iResolveDefaultParameter == getData().length ? this : new ByteString(AbstractC9648aK.r(getData(), 0, iResolveDefaultParameter))).hex());
                    sb.append("…]");
                    return sb.toString();
                }
                throw new IllegalArgumentException(("endIndex > length(" + getData().length + ')').toString());
            }
            str = "[hex=" + hex() + ']';
        }
        return str;
    }

    public String utf8() {
        String utf8 = getUtf8();
        if (utf8 != null) {
            return utf8;
        }
        String utf8String = _JvmPlatformKt.toUtf8String(internalArray$okio());
        setUtf8$okio(utf8String);
        return utf8String;
    }

    public void write(OutputStream out) throws IOException {
        AbstractC13042fc3.i(out, "out");
        out.write(this.data);
    }

    public void write$okio(Buffer buffer, int offset, int byteCount) {
        AbstractC13042fc3.i(buffer, "buffer");
        okio.internal.ByteString.commonWrite(this, buffer, offset, byteCount);
    }

    public static /* synthetic */ int indexOf$default(ByteString byteString, byte[] bArr, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        }
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return byteString.indexOf(bArr, i);
    }

    public static final ByteString of(byte... bArr) {
        return INSTANCE.of(bArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0031, code lost:
    
        if (r0 < r1) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0034, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:?, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0028, code lost:
    
        if (r7 < r8) goto L9;
     */
    @Override // java.lang.Comparable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int compareTo(okio.ByteString r10) {
        /*
            r9 = this;
            java.lang.String r0 = "other"
            ir.nasim.AbstractC13042fc3.i(r10, r0)
            int r0 = r9.size()
            int r1 = r10.size()
            int r2 = java.lang.Math.min(r0, r1)
            r3 = 0
            r4 = r3
        L13:
            r5 = -1
            r6 = 1
            if (r4 >= r2) goto L2e
            byte r7 = r9.getByte(r4)
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r8 = r10.getByte(r4)
            r8 = r8 & 255(0xff, float:3.57E-43)
            if (r7 != r8) goto L28
            int r4 = r4 + 1
            goto L13
        L28:
            if (r7 >= r8) goto L2c
        L2a:
            r3 = r5
            goto L34
        L2c:
            r3 = r6
            goto L34
        L2e:
            if (r0 != r1) goto L31
            goto L34
        L31:
            if (r0 >= r1) goto L2c
            goto L2a
        L34:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.ByteString.compareTo(okio.ByteString):int");
    }

    public final boolean endsWith(byte[] suffix) {
        AbstractC13042fc3.i(suffix, "suffix");
        return rangeEquals(size() - suffix.length, suffix, 0, suffix.length);
    }

    public final int indexOf(byte[] bArr) {
        AbstractC13042fc3.i(bArr, "other");
        return indexOf$default(this, bArr, 0, 2, (Object) null);
    }

    public final int lastIndexOf(byte[] bArr) {
        AbstractC13042fc3.i(bArr, "other");
        return lastIndexOf$default(this, bArr, 0, 2, (Object) null);
    }

    public boolean rangeEquals(int offset, byte[] other, int otherOffset, int byteCount) {
        AbstractC13042fc3.i(other, "other");
        return offset >= 0 && offset <= getData().length - byteCount && otherOffset >= 0 && otherOffset <= other.length - byteCount && SegmentedByteString.arrayRangeEquals(getData(), offset, other, otherOffset, byteCount);
    }

    public final boolean startsWith(byte[] prefix) {
        AbstractC13042fc3.i(prefix, "prefix");
        return rangeEquals(0, prefix, 0, prefix.length);
    }

    public final ByteString substring(int i) {
        return substring$default(this, i, 0, 2, null);
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString byteString, byte[] bArr, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        }
        if ((i2 & 2) != 0) {
            i = SegmentedByteString.getDEFAULT__ByteString_size();
        }
        return byteString.lastIndexOf(bArr, i);
    }

    public static final ByteString of(byte[] bArr, int i, int i2) {
        return INSTANCE.of(bArr, i, i2);
    }

    public final int indexOf(ByteString other, int fromIndex) {
        AbstractC13042fc3.i(other, "other");
        return indexOf(other.internalArray$okio(), fromIndex);
    }

    public final int lastIndexOf(ByteString other, int fromIndex) {
        AbstractC13042fc3.i(other, "other");
        return lastIndexOf(other.internalArray$okio(), fromIndex);
    }

    public ByteString substring(int beginIndex, int endIndex) {
        int iResolveDefaultParameter = SegmentedByteString.resolveDefaultParameter(this, endIndex);
        if (beginIndex >= 0) {
            if (iResolveDefaultParameter <= getData().length) {
                if (iResolveDefaultParameter - beginIndex >= 0) {
                    return (beginIndex == 0 && iResolveDefaultParameter == getData().length) ? this : new ByteString(AbstractC9648aK.r(getData(), beginIndex, iResolveDefaultParameter));
                }
                throw new IllegalArgumentException("endIndex < beginIndex".toString());
            }
            throw new IllegalArgumentException(("endIndex > length(" + getData().length + ')').toString());
        }
        throw new IllegalArgumentException("beginIndex < 0".toString());
    }

    public int indexOf(byte[] other, int fromIndex) {
        AbstractC13042fc3.i(other, "other");
        int length = getData().length - other.length;
        int iMax = Math.max(fromIndex, 0);
        if (iMax <= length) {
            while (!SegmentedByteString.arrayRangeEquals(getData(), iMax, other, 0, other.length)) {
                if (iMax != length) {
                    iMax++;
                }
            }
            return iMax;
        }
        return -1;
    }

    public int lastIndexOf(byte[] other, int fromIndex) {
        AbstractC13042fc3.i(other, "other");
        for (int iMin = Math.min(SegmentedByteString.resolveDefaultParameter(this, fromIndex), getData().length - other.length); -1 < iMin; iMin--) {
            if (SegmentedByteString.arrayRangeEquals(getData(), iMin, other, 0, other.length)) {
                return iMin;
            }
        }
        return -1;
    }
}
