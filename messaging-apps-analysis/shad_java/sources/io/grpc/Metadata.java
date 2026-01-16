package io.grpc;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.io.BaseEncoding;
import com.google.common.io.ByteStreams;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public final class Metadata {
    public static final AsciiMarshaller<String> ASCII_STRING_MARSHALLER;
    static final BaseEncoding BASE64_ENCODING_OMIT_PADDING;
    private static final Logger logger = Logger.getLogger(Metadata.class.getName());
    private Object[] namesAndValues;
    private int size;

    public interface AsciiMarshaller<T> {
        T parseAsciiString(String str);

        String toAsciiString(T t);
    }

    public interface BinaryStreamMarshaller<T> {
        T parseStream(InputStream inputStream);

        InputStream toStream(T t);
    }

    interface TrustedAsciiMarshaller<T> {
        T parseAsciiString(byte[] bArr);

        byte[] toAsciiString(T t);
    }

    static {
        new Object() { // from class: io.grpc.Metadata.1
        };
        ASCII_STRING_MARSHALLER = new AsciiMarshaller<String>() { // from class: io.grpc.Metadata.2
            @Override // io.grpc.Metadata.AsciiMarshaller
            public String parseAsciiString(String str) {
                return str;
            }

            @Override // io.grpc.Metadata.AsciiMarshaller
            public String toAsciiString(String str) {
                return str;
            }
        };
        BASE64_ENCODING_OMIT_PADDING = BaseEncoding.base64().omitPadding();
    }

    Metadata(byte[]... bArr) {
        this(bArr.length / 2, bArr);
    }

    Metadata(int i, byte[]... bArr) {
        this(i, (Object[]) bArr);
    }

    Metadata(int i, Object[] objArr) {
        this.size = i;
        this.namesAndValues = objArr;
    }

    private byte[] name(int i) {
        return (byte[]) this.namesAndValues[i * 2];
    }

    private void name(int i, byte[] bArr) {
        this.namesAndValues[i * 2] = bArr;
    }

    private Object value(int i) {
        return this.namesAndValues[(i * 2) + 1];
    }

    private void value(int i, byte[] bArr) {
        this.namesAndValues[(i * 2) + 1] = bArr;
    }

    private void value(int i, Object obj) {
        if (this.namesAndValues instanceof byte[][]) {
            expand(cap());
        }
        this.namesAndValues[(i * 2) + 1] = obj;
    }

    private byte[] valueAsBytes(int i) {
        Object objValue = value(i);
        if (objValue instanceof byte[]) {
            return (byte[]) objValue;
        }
        return ((LazyValue) objValue).toBytes();
    }

    private <T> T valueAsT(int i, Key<T> key) {
        Object objValue = value(i);
        if (objValue instanceof byte[]) {
            return key.parseBytes((byte[]) objValue);
        }
        return (T) ((LazyValue) objValue).toObject(key);
    }

    private int cap() {
        Object[] objArr = this.namesAndValues;
        if (objArr != null) {
            return objArr.length;
        }
        return 0;
    }

    private int len() {
        return this.size * 2;
    }

    private boolean isEmpty() {
        return this.size == 0;
    }

    public Metadata() {
    }

    int headerCount() {
        return this.size;
    }

    public <T> T get(Key<T> key) {
        for (int i = this.size - 1; i >= 0; i--) {
            if (bytesEqual(key.asciiName(), name(i))) {
                return (T) valueAsT(i, key);
            }
        }
        return null;
    }

    public <T> void put(Key<T> key, T t) {
        Preconditions.checkNotNull(key, "key");
        Preconditions.checkNotNull(t, "value");
        maybeExpand();
        name(this.size, key.asciiName());
        if (key.serializesToStreams()) {
            value(this.size, LazyValue.create(key, t));
        } else {
            value(this.size, key.toBytes(t));
        }
        this.size++;
    }

    private void maybeExpand() {
        if (len() == 0 || len() == cap()) {
            expand(Math.max(len() * 2, 8));
        }
    }

    private void expand(int i) {
        Object[] objArr = new Object[i];
        if (!isEmpty()) {
            System.arraycopy(this.namesAndValues, 0, objArr, 0, len());
        }
        this.namesAndValues = objArr;
    }

    public <T> void discardAll(Key<T> key) {
        if (isEmpty()) {
            return;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.size; i2++) {
            if (!bytesEqual(key.asciiName(), name(i2))) {
                name(i, name(i2));
                value(i, value(i2));
                i++;
            }
        }
        Arrays.fill(this.namesAndValues, i * 2, len(), (Object) null);
        this.size = i;
    }

    byte[][] serialize() {
        byte[][] bArr = new byte[len()][];
        Object[] objArr = this.namesAndValues;
        if (objArr instanceof byte[][]) {
            System.arraycopy(objArr, 0, bArr, 0, len());
        } else {
            for (int i = 0; i < this.size; i++) {
                int i2 = i * 2;
                bArr[i2] = name(i);
                bArr[i2 + 1] = valueAsBytes(i);
            }
        }
        return bArr;
    }

    public void merge(Metadata metadata) {
        if (metadata.isEmpty()) {
            return;
        }
        int iCap = cap() - len();
        if (isEmpty() || iCap < metadata.len()) {
            expand(len() + metadata.len());
        }
        System.arraycopy(metadata.namesAndValues, 0, this.namesAndValues, len(), metadata.len());
        this.size += metadata.size;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Metadata(");
        for (int i = 0; i < this.size; i++) {
            if (i != 0) {
                sb.append(',');
            }
            byte[] bArrName = name(i);
            Charset charset = Charsets.US_ASCII;
            String str = new String(bArrName, charset);
            sb.append(str);
            sb.append('=');
            if (str.endsWith("-bin")) {
                sb.append(BASE64_ENCODING_OMIT_PADDING.encode(valueAsBytes(i)));
            } else {
                sb.append(new String(valueAsBytes(i), charset));
            }
        }
        sb.append(')');
        return sb.toString();
    }

    private boolean bytesEqual(byte[] bArr, byte[] bArr2) {
        return Arrays.equals(bArr, bArr2);
    }

    public static abstract class Key<T> {
        private static final BitSet VALID_T_CHARS = generateValidTChars();
        private final Object marshaller;
        private final String name;
        private final byte[] nameBytes;
        private final String originalName;

        abstract T parseBytes(byte[] bArr);

        boolean serializesToStreams() {
            return false;
        }

        abstract byte[] toBytes(T t);

        public static <T> Key<T> of(String str, AsciiMarshaller<T> asciiMarshaller) {
            return of(str, false, (AsciiMarshaller) asciiMarshaller);
        }

        static <T> Key<T> of(String str, boolean z, AsciiMarshaller<T> asciiMarshaller) {
            return new AsciiKey(str, z, asciiMarshaller);
        }

        static <T> Key<T> of(String str, boolean z, TrustedAsciiMarshaller<T> trustedAsciiMarshaller) {
            return new TrustedAsciiKey(str, z, trustedAsciiMarshaller);
        }

        private static BitSet generateValidTChars() {
            BitSet bitSet = new BitSet(127);
            bitSet.set(45);
            bitSet.set(95);
            bitSet.set(46);
            for (char c = '0'; c <= '9'; c = (char) (c + 1)) {
                bitSet.set(c);
            }
            for (char c2 = 'a'; c2 <= 'z'; c2 = (char) (c2 + 1)) {
                bitSet.set(c2);
            }
            return bitSet;
        }

        private static String validateName(String str, boolean z) {
            Preconditions.checkNotNull(str, "name");
            Preconditions.checkArgument(!str.isEmpty(), "token must have at least 1 tchar");
            if (str.equals("connection")) {
                Metadata.logger.log(Level.WARNING, "Metadata key is 'Connection', which should not be used. That is used by HTTP/1 for connection-specific headers which are not to be forwarded. There is probably an HTTP/1 conversion bug. Simply removing the Connection header is not enough; you should remove all headers it references as well. See RFC 7230 section 6.1", (Throwable) new RuntimeException("exception to show backtrace"));
            }
            for (int i = 0; i < str.length(); i++) {
                char cCharAt = str.charAt(i);
                if (!z || cCharAt != ':' || i != 0) {
                    Preconditions.checkArgument(VALID_T_CHARS.get(cCharAt), "Invalid character '%s' in key name '%s'", cCharAt, str);
                }
            }
            return str;
        }

        private Key(String str, boolean z, Object obj) {
            String str2 = (String) Preconditions.checkNotNull(str, "name");
            this.originalName = str2;
            String strValidateName = validateName(str2.toLowerCase(Locale.ROOT), z);
            this.name = strValidateName;
            this.nameBytes = strValidateName.getBytes(Charsets.US_ASCII);
            this.marshaller = obj;
        }

        public final String name() {
            return this.name;
        }

        byte[] asciiName() {
            return this.nameBytes;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.name.equals(((Key) obj).name);
        }

        public final int hashCode() {
            return this.name.hashCode();
        }

        public String toString() {
            return "Key{name='" + this.name + "'}";
        }

        final <M> M getMarshaller(Class<M> cls) {
            if (cls.isInstance(this.marshaller)) {
                return cls.cast(this.marshaller);
            }
            return null;
        }
    }

    static final class LazyValue<T> {
        private final BinaryStreamMarshaller<T> marshaller;
        private volatile byte[] serialized;
        private final T value;

        static <T> LazyValue<T> create(Key<T> key, T t) {
            return new LazyValue<>((BinaryStreamMarshaller) Preconditions.checkNotNull(getBinaryStreamMarshaller(key)), t);
        }

        LazyValue(BinaryStreamMarshaller<T> binaryStreamMarshaller, T t) {
            this.marshaller = binaryStreamMarshaller;
            this.value = t;
        }

        InputStream toStream() {
            return this.marshaller.toStream(this.value);
        }

        byte[] toBytes() {
            if (this.serialized == null) {
                synchronized (this) {
                    if (this.serialized == null) {
                        this.serialized = Metadata.streamToBytes(toStream());
                    }
                }
            }
            return this.serialized;
        }

        <T2> T2 toObject(Key<T2> key) {
            BinaryStreamMarshaller binaryStreamMarshaller;
            if (key.serializesToStreams() && (binaryStreamMarshaller = getBinaryStreamMarshaller(key)) != null) {
                return (T2) binaryStreamMarshaller.parseStream(toStream());
            }
            return key.parseBytes(toBytes());
        }

        private static <T> BinaryStreamMarshaller<T> getBinaryStreamMarshaller(Key<T> key) {
            return (BinaryStreamMarshaller) key.getMarshaller(BinaryStreamMarshaller.class);
        }
    }

    private static class AsciiKey<T> extends Key<T> {
        private final AsciiMarshaller<T> marshaller;

        private AsciiKey(String str, boolean z, AsciiMarshaller<T> asciiMarshaller) {
            super(str, z, asciiMarshaller);
            Preconditions.checkArgument(!str.endsWith("-bin"), "ASCII header is named %s.  Only binary headers may end with %s", str, "-bin");
            this.marshaller = (AsciiMarshaller) Preconditions.checkNotNull(asciiMarshaller, "marshaller");
        }

        @Override // io.grpc.Metadata.Key
        byte[] toBytes(T t) {
            return this.marshaller.toAsciiString(t).getBytes(Charsets.US_ASCII);
        }

        @Override // io.grpc.Metadata.Key
        T parseBytes(byte[] bArr) {
            return this.marshaller.parseAsciiString(new String(bArr, Charsets.US_ASCII));
        }
    }

    private static final class TrustedAsciiKey<T> extends Key<T> {
        private final TrustedAsciiMarshaller<T> marshaller;

        private TrustedAsciiKey(String str, boolean z, TrustedAsciiMarshaller<T> trustedAsciiMarshaller) {
            super(str, z, trustedAsciiMarshaller);
            Preconditions.checkArgument(!str.endsWith("-bin"), "ASCII header is named %s.  Only binary headers may end with %s", str, "-bin");
            this.marshaller = (TrustedAsciiMarshaller) Preconditions.checkNotNull(trustedAsciiMarshaller, "marshaller");
        }

        @Override // io.grpc.Metadata.Key
        byte[] toBytes(T t) {
            return this.marshaller.toAsciiString(t);
        }

        @Override // io.grpc.Metadata.Key
        T parseBytes(byte[] bArr) {
            return this.marshaller.parseAsciiString(bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] streamToBytes(InputStream inputStream) {
        try {
            return ByteStreams.toByteArray(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("failure reading serialized stream", e);
        }
    }
}
