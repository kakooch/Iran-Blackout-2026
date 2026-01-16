package okio;

import android.gov.nist.javax.sip.clientauthutils.DigestServerAuthenticationHelper;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C19938rB7;
import ir.nasim.ED1;
import ir.nasim.InterfaceC14067hI1;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001eB\u0019\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\nB\u0019\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0006\u0010\rB!\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\u0010J\u001f\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u001a\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u001dR\u0011\u0010\u001a\u001a\u00020\u000e8G¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0019¨\u0006\u001f"}, d2 = {"Lokio/HashingSink;", "Lokio/ForwardingSink;", "Lokio/Sink;", "sink", "Ljava/security/MessageDigest;", "digest", "<init>", "(Lokio/Sink;Ljava/security/MessageDigest;)V", "", "algorithm", "(Lokio/Sink;Ljava/lang/String;)V", "Ljavax/crypto/Mac;", "mac", "(Lokio/Sink;Ljavax/crypto/Mac;)V", "Lokio/ByteString;", "key", "(Lokio/Sink;Lokio/ByteString;Ljava/lang/String;)V", "Lokio/Buffer;", "source", "", "byteCount", "Lir/nasim/rB7;", "write", "(Lokio/Buffer;J)V", "-deprecated_hash", "()Lokio/ByteString;", "hash", "messageDigest", "Ljava/security/MessageDigest;", "Ljavax/crypto/Mac;", "Companion", "okio"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes8.dex */
public final class HashingSink extends ForwardingSink implements Sink {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Mac mac;
    private final MessageDigest messageDigest;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u000f"}, d2 = {"Lokio/HashingSink$Companion;", "", "()V", "hmacSha1", "Lokio/HashingSink;", "sink", "Lokio/Sink;", "key", "Lokio/ByteString;", "hmacSha256", "hmacSha512", "md5", "sha1", "sha256", "sha512", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final HashingSink hmacSha1(Sink sink, ByteString key) {
            AbstractC13042fc3.i(sink, "sink");
            AbstractC13042fc3.i(key, "key");
            return new HashingSink(sink, key, "HmacSHA1");
        }

        public final HashingSink hmacSha256(Sink sink, ByteString key) {
            AbstractC13042fc3.i(sink, "sink");
            AbstractC13042fc3.i(key, "key");
            return new HashingSink(sink, key, "HmacSHA256");
        }

        public final HashingSink hmacSha512(Sink sink, ByteString key) {
            AbstractC13042fc3.i(sink, "sink");
            AbstractC13042fc3.i(key, "key");
            return new HashingSink(sink, key, "HmacSHA512");
        }

        public final HashingSink md5(Sink sink) {
            AbstractC13042fc3.i(sink, "sink");
            return new HashingSink(sink, DigestServerAuthenticationHelper.DEFAULT_ALGORITHM);
        }

        public final HashingSink sha1(Sink sink) {
            AbstractC13042fc3.i(sink, "sink");
            return new HashingSink(sink, "SHA-1");
        }

        public final HashingSink sha256(Sink sink) {
            AbstractC13042fc3.i(sink, "sink");
            return new HashingSink(sink, "SHA-256");
        }

        public final HashingSink sha512(Sink sink) {
            AbstractC13042fc3.i(sink, "sink");
            return new HashingSink(sink, "SHA-512");
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashingSink(Sink sink, MessageDigest messageDigest) {
        super(sink);
        AbstractC13042fc3.i(sink, "sink");
        AbstractC13042fc3.i(messageDigest, "digest");
        this.messageDigest = messageDigest;
        this.mac = null;
    }

    public static final HashingSink hmacSha1(Sink sink, ByteString byteString) {
        return INSTANCE.hmacSha1(sink, byteString);
    }

    public static final HashingSink hmacSha256(Sink sink, ByteString byteString) {
        return INSTANCE.hmacSha256(sink, byteString);
    }

    public static final HashingSink hmacSha512(Sink sink, ByteString byteString) {
        return INSTANCE.hmacSha512(sink, byteString);
    }

    public static final HashingSink md5(Sink sink) {
        return INSTANCE.md5(sink);
    }

    public static final HashingSink sha1(Sink sink) {
        return INSTANCE.sha1(sink);
    }

    public static final HashingSink sha256(Sink sink) {
        return INSTANCE.sha256(sink);
    }

    public static final HashingSink sha512(Sink sink) {
        return INSTANCE.sha512(sink);
    }

    @InterfaceC14067hI1
    /* renamed from: -deprecated_hash, reason: not valid java name */
    public final ByteString m181deprecated_hash() {
        return hash();
    }

    public final ByteString hash() throws IllegalStateException {
        byte[] bArrDoFinal;
        MessageDigest messageDigest = this.messageDigest;
        if (messageDigest != null) {
            bArrDoFinal = messageDigest.digest();
        } else {
            Mac mac = this.mac;
            AbstractC13042fc3.f(mac);
            bArrDoFinal = mac.doFinal();
        }
        AbstractC13042fc3.f(bArrDoFinal);
        return new ByteString(bArrDoFinal);
    }

    @Override // okio.ForwardingSink, okio.Sink
    public void write(Buffer source, long byteCount) throws IllegalStateException {
        AbstractC13042fc3.i(source, "source");
        SegmentedByteString.checkOffsetAndCount(source.size(), 0L, byteCount);
        Segment segment = source.head;
        AbstractC13042fc3.f(segment);
        long j = 0;
        while (j < byteCount) {
            int iMin = (int) Math.min(byteCount - j, segment.limit - segment.pos);
            MessageDigest messageDigest = this.messageDigest;
            if (messageDigest != null) {
                messageDigest.update(segment.data, segment.pos, iMin);
            } else {
                Mac mac = this.mac;
                AbstractC13042fc3.f(mac);
                mac.update(segment.data, segment.pos, iMin);
            }
            j += iMin;
            segment = segment.next;
            AbstractC13042fc3.f(segment);
        }
        super.write(source, byteCount);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public HashingSink(Sink sink, String str) throws NoSuchAlgorithmException {
        AbstractC13042fc3.i(sink, "sink");
        AbstractC13042fc3.i(str, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        AbstractC13042fc3.h(messageDigest, "getInstance(...)");
        this(sink, messageDigest);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashingSink(Sink sink, Mac mac) {
        super(sink);
        AbstractC13042fc3.i(sink, "sink");
        AbstractC13042fc3.i(mac, "mac");
        this.mac = mac;
        this.messageDigest = null;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public HashingSink(Sink sink, ByteString byteString, String str) throws NoSuchAlgorithmException, InvalidKeyException {
        AbstractC13042fc3.i(sink, "sink");
        AbstractC13042fc3.i(byteString, "key");
        AbstractC13042fc3.i(str, "algorithm");
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(byteString.toByteArray(), str));
            C19938rB7 c19938rB7 = C19938rB7.a;
            AbstractC13042fc3.f(mac);
            this(sink, mac);
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
