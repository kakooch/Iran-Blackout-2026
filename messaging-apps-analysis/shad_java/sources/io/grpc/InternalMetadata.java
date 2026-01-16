package io.grpc;

import com.google.common.io.BaseEncoding;
import io.grpc.Metadata;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* loaded from: classes3.dex */
public final class InternalMetadata {
    public static final Charset US_ASCII = StandardCharsets.US_ASCII;
    public static final BaseEncoding BASE64_ENCODING_OMIT_PADDING = Metadata.BASE64_ENCODING_OMIT_PADDING;

    public interface TrustedAsciiMarshaller<T> extends Metadata.TrustedAsciiMarshaller<T> {
    }

    public static <T> Metadata.Key<T> keyOf(String str, TrustedAsciiMarshaller<T> trustedAsciiMarshaller) {
        boolean z = false;
        if (str != null && !str.isEmpty() && str.charAt(0) == ':') {
            z = true;
        }
        return Metadata.Key.of(str, z, trustedAsciiMarshaller);
    }

    public static Metadata newMetadata(byte[]... bArr) {
        return new Metadata(bArr);
    }

    public static byte[][] serialize(Metadata metadata) {
        return metadata.serialize();
    }

    public static int headerCount(Metadata metadata) {
        return metadata.headerCount();
    }
}
