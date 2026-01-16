package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.I;
import com.google.protobuf.J;
import com.google.protobuf.r0;
import ir.nasim.BF3;
import ir.nasim.CF3;
import ir.nasim.EnumC24816zF3;
import ir.nasim.FF3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes8.dex */
public final class LivekitSip$SIPOutboundTrunkInfo extends GeneratedMessageLite implements CF3 {
    public static final int ADDRESS_FIELD_NUMBER = 4;
    public static final int ATTRIBUTES_TO_HEADERS_FIELD_NUMBER = 11;
    public static final int AUTH_PASSWORD_FIELD_NUMBER = 8;
    public static final int AUTH_USERNAME_FIELD_NUMBER = 7;
    private static final LivekitSip$SIPOutboundTrunkInfo DEFAULT_INSTANCE;
    public static final int DESTINATION_COUNTRY_FIELD_NUMBER = 14;
    public static final int HEADERS_FIELD_NUMBER = 9;
    public static final int HEADERS_TO_ATTRIBUTES_FIELD_NUMBER = 10;
    public static final int INCLUDE_HEADERS_FIELD_NUMBER = 12;
    public static final int MEDIA_ENCRYPTION_FIELD_NUMBER = 13;
    public static final int METADATA_FIELD_NUMBER = 3;
    public static final int NAME_FIELD_NUMBER = 2;
    public static final int NUMBERS_FIELD_NUMBER = 6;
    private static volatile KW4 PARSER = null;
    public static final int SIP_TRUNK_ID_FIELD_NUMBER = 1;
    public static final int TRANSPORT_FIELD_NUMBER = 5;
    private int includeHeaders_;
    private int mediaEncryption_;
    private int transport_;
    private J headers_ = J.e();
    private J headersToAttributes_ = J.e();
    private J attributesToHeaders_ = J.e();
    private String sipTrunkId_ = "";
    private String name_ = "";
    private String metadata_ = "";
    private String address_ = "";
    private String destinationCountry_ = "";
    private B.j numbers_ = GeneratedMessageLite.emptyProtobufList();
    private String authUsername_ = "";
    private String authPassword_ = "";

    private static final class a {
        static final I a;

        static {
            r0.b bVar = r0.b.k;
            a = I.d(bVar, "", bVar, "");
        }
    }

    public static final class b extends GeneratedMessageLite.b implements CF3 {
        /* synthetic */ b(t tVar) {
            this();
        }

        private b() {
            super(LivekitSip$SIPOutboundTrunkInfo.DEFAULT_INSTANCE);
        }
    }

    private static final class c {
        static final I a;

        static {
            r0.b bVar = r0.b.k;
            a = I.d(bVar, "", bVar, "");
        }
    }

    private static final class d {
        static final I a;

        static {
            r0.b bVar = r0.b.k;
            a = I.d(bVar, "", bVar, "");
        }
    }

    static {
        LivekitSip$SIPOutboundTrunkInfo livekitSip$SIPOutboundTrunkInfo = new LivekitSip$SIPOutboundTrunkInfo();
        DEFAULT_INSTANCE = livekitSip$SIPOutboundTrunkInfo;
        GeneratedMessageLite.registerDefaultInstance(LivekitSip$SIPOutboundTrunkInfo.class, livekitSip$SIPOutboundTrunkInfo);
    }

    private LivekitSip$SIPOutboundTrunkInfo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllNumbers(Iterable<String> iterable) {
        ensureNumbersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.numbers_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addNumbers(String str) {
        str.getClass();
        ensureNumbersIsMutable();
        this.numbers_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addNumbersBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        ensureNumbersIsMutable();
        this.numbers_.add(abstractC2383g.f0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAddress() {
        this.address_ = getDefaultInstance().getAddress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAuthPassword() {
        this.authPassword_ = getDefaultInstance().getAuthPassword();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAuthUsername() {
        this.authUsername_ = getDefaultInstance().getAuthUsername();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDestinationCountry() {
        this.destinationCountry_ = getDefaultInstance().getDestinationCountry();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIncludeHeaders() {
        this.includeHeaders_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMediaEncryption() {
        this.mediaEncryption_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMetadata() {
        this.metadata_ = getDefaultInstance().getMetadata();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNumbers() {
        this.numbers_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSipTrunkId() {
        this.sipTrunkId_ = getDefaultInstance().getSipTrunkId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTransport() {
        this.transport_ = 0;
    }

    private void ensureNumbersIsMutable() {
        B.j jVar = this.numbers_;
        if (jVar.u()) {
            return;
        }
        this.numbers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitSip$SIPOutboundTrunkInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> getMutableAttributesToHeadersMap() {
        return internalGetMutableAttributesToHeaders();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> getMutableHeadersMap() {
        return internalGetMutableHeaders();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> getMutableHeadersToAttributesMap() {
        return internalGetMutableHeadersToAttributes();
    }

    private J internalGetAttributesToHeaders() {
        return this.attributesToHeaders_;
    }

    private J internalGetHeaders() {
        return this.headers_;
    }

    private J internalGetHeadersToAttributes() {
        return this.headersToAttributes_;
    }

    private J internalGetMutableAttributesToHeaders() {
        if (!this.attributesToHeaders_.n()) {
            this.attributesToHeaders_ = this.attributesToHeaders_.s();
        }
        return this.attributesToHeaders_;
    }

    private J internalGetMutableHeaders() {
        if (!this.headers_.n()) {
            this.headers_ = this.headers_.s();
        }
        return this.headers_;
    }

    private J internalGetMutableHeadersToAttributes() {
        if (!this.headersToAttributes_.n()) {
            this.headersToAttributes_ = this.headersToAttributes_.s();
        }
        return this.headersToAttributes_;
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitSip$SIPOutboundTrunkInfo parseDelimitedFrom(InputStream inputStream) {
        return (LivekitSip$SIPOutboundTrunkInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitSip$SIPOutboundTrunkInfo parseFrom(ByteBuffer byteBuffer) {
        return (LivekitSip$SIPOutboundTrunkInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAddress(String str) {
        str.getClass();
        this.address_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAddressBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.address_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAuthPassword(String str) {
        str.getClass();
        this.authPassword_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAuthPasswordBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.authPassword_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAuthUsername(String str) {
        str.getClass();
        this.authUsername_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAuthUsernameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.authUsername_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDestinationCountry(String str) {
        str.getClass();
        this.destinationCountry_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDestinationCountryBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.destinationCountry_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIncludeHeaders(EnumC24816zF3 enumC24816zF3) {
        this.includeHeaders_ = enumC24816zF3.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIncludeHeadersValue(int i) {
        this.includeHeaders_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMediaEncryption(BF3 bf3) {
        this.mediaEncryption_ = bf3.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMediaEncryptionValue(int i) {
        this.mediaEncryption_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMetadata(String str) {
        str.getClass();
        this.metadata_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMetadataBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.metadata_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setName(String str) {
        str.getClass();
        this.name_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.name_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNumbers(int i, String str) {
        str.getClass();
        ensureNumbersIsMutable();
        this.numbers_.set(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSipTrunkId(String str) {
        str.getClass();
        this.sipTrunkId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSipTrunkIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.sipTrunkId_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTransport(FF3 ff3) {
        this.transport_ = ff3.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTransportValue(int i) {
        this.transport_ = i;
    }

    public boolean containsAttributesToHeaders(String str) {
        str.getClass();
        return internalGetAttributesToHeaders().containsKey(str);
    }

    public boolean containsHeaders(String str) {
        str.getClass();
        return internalGetHeaders().containsKey(str);
    }

    public boolean containsHeadersToAttributes(String str) {
        str.getClass();
        return internalGetHeadersToAttributes().containsKey(str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        t tVar = null;
        switch (t.a[gVar.ordinal()]) {
            case 1:
                return new LivekitSip$SIPOutboundTrunkInfo();
            case 2:
                return new b(tVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u000e\u0000\u0000\u0001\u000e\u000e\u0003\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005\f\u0006Ț\u0007Ȉ\bȈ\t2\n2\u000b2\f\f\r\f\u000eȈ", new Object[]{"sipTrunkId_", "name_", "metadata_", "address_", "transport_", "numbers_", "authUsername_", "authPassword_", "headers_", c.a, "headersToAttributes_", d.a, "attributesToHeaders_", a.a, "includeHeaders_", "mediaEncryption_", "destinationCountry_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitSip$SIPOutboundTrunkInfo.class) {
                        try {
                            cVar = PARSER;
                            if (cVar == null) {
                                cVar = new GeneratedMessageLite.c(DEFAULT_INSTANCE);
                                PARSER = cVar;
                            }
                        } finally {
                        }
                    }
                }
                return cVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public String getAddress() {
        return this.address_;
    }

    public AbstractC2383g getAddressBytes() {
        return AbstractC2383g.N(this.address_);
    }

    @Deprecated
    public Map<String, String> getAttributesToHeaders() {
        return getAttributesToHeadersMap();
    }

    public int getAttributesToHeadersCount() {
        return internalGetAttributesToHeaders().size();
    }

    public Map<String, String> getAttributesToHeadersMap() {
        return Collections.unmodifiableMap(internalGetAttributesToHeaders());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String getAttributesToHeadersOrDefault(String str, String str2) {
        str.getClass();
        J jInternalGetAttributesToHeaders = internalGetAttributesToHeaders();
        return jInternalGetAttributesToHeaders.containsKey(str) ? (String) jInternalGetAttributesToHeaders.get(str) : str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String getAttributesToHeadersOrThrow(String str) {
        str.getClass();
        J jInternalGetAttributesToHeaders = internalGetAttributesToHeaders();
        if (jInternalGetAttributesToHeaders.containsKey(str)) {
            return (String) jInternalGetAttributesToHeaders.get(str);
        }
        throw new IllegalArgumentException();
    }

    public String getAuthPassword() {
        return this.authPassword_;
    }

    public AbstractC2383g getAuthPasswordBytes() {
        return AbstractC2383g.N(this.authPassword_);
    }

    public String getAuthUsername() {
        return this.authUsername_;
    }

    public AbstractC2383g getAuthUsernameBytes() {
        return AbstractC2383g.N(this.authUsername_);
    }

    public String getDestinationCountry() {
        return this.destinationCountry_;
    }

    public AbstractC2383g getDestinationCountryBytes() {
        return AbstractC2383g.N(this.destinationCountry_);
    }

    @Deprecated
    public Map<String, String> getHeaders() {
        return getHeadersMap();
    }

    public int getHeadersCount() {
        return internalGetHeaders().size();
    }

    public Map<String, String> getHeadersMap() {
        return Collections.unmodifiableMap(internalGetHeaders());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String getHeadersOrDefault(String str, String str2) {
        str.getClass();
        J jInternalGetHeaders = internalGetHeaders();
        return jInternalGetHeaders.containsKey(str) ? (String) jInternalGetHeaders.get(str) : str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String getHeadersOrThrow(String str) {
        str.getClass();
        J jInternalGetHeaders = internalGetHeaders();
        if (jInternalGetHeaders.containsKey(str)) {
            return (String) jInternalGetHeaders.get(str);
        }
        throw new IllegalArgumentException();
    }

    @Deprecated
    public Map<String, String> getHeadersToAttributes() {
        return getHeadersToAttributesMap();
    }

    public int getHeadersToAttributesCount() {
        return internalGetHeadersToAttributes().size();
    }

    public Map<String, String> getHeadersToAttributesMap() {
        return Collections.unmodifiableMap(internalGetHeadersToAttributes());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String getHeadersToAttributesOrDefault(String str, String str2) {
        str.getClass();
        J jInternalGetHeadersToAttributes = internalGetHeadersToAttributes();
        return jInternalGetHeadersToAttributes.containsKey(str) ? (String) jInternalGetHeadersToAttributes.get(str) : str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String getHeadersToAttributesOrThrow(String str) {
        str.getClass();
        J jInternalGetHeadersToAttributes = internalGetHeadersToAttributes();
        if (jInternalGetHeadersToAttributes.containsKey(str)) {
            return (String) jInternalGetHeadersToAttributes.get(str);
        }
        throw new IllegalArgumentException();
    }

    public EnumC24816zF3 getIncludeHeaders() {
        EnumC24816zF3 enumC24816zF3J = EnumC24816zF3.j(this.includeHeaders_);
        return enumC24816zF3J == null ? EnumC24816zF3.UNRECOGNIZED : enumC24816zF3J;
    }

    public int getIncludeHeadersValue() {
        return this.includeHeaders_;
    }

    public BF3 getMediaEncryption() {
        BF3 bf3J = BF3.j(this.mediaEncryption_);
        return bf3J == null ? BF3.UNRECOGNIZED : bf3J;
    }

    public int getMediaEncryptionValue() {
        return this.mediaEncryption_;
    }

    public String getMetadata() {
        return this.metadata_;
    }

    public AbstractC2383g getMetadataBytes() {
        return AbstractC2383g.N(this.metadata_);
    }

    public String getName() {
        return this.name_;
    }

    public AbstractC2383g getNameBytes() {
        return AbstractC2383g.N(this.name_);
    }

    public String getNumbers(int i) {
        return (String) this.numbers_.get(i);
    }

    public AbstractC2383g getNumbersBytes(int i) {
        return AbstractC2383g.N((String) this.numbers_.get(i));
    }

    public int getNumbersCount() {
        return this.numbers_.size();
    }

    public List<String> getNumbersList() {
        return this.numbers_;
    }

    public String getSipTrunkId() {
        return this.sipTrunkId_;
    }

    public AbstractC2383g getSipTrunkIdBytes() {
        return AbstractC2383g.N(this.sipTrunkId_);
    }

    public FF3 getTransport() {
        FF3 ff3J = FF3.j(this.transport_);
        return ff3J == null ? FF3.UNRECOGNIZED : ff3J;
    }

    public int getTransportValue() {
        return this.transport_;
    }

    public static b newBuilder(LivekitSip$SIPOutboundTrunkInfo livekitSip$SIPOutboundTrunkInfo) {
        return (b) DEFAULT_INSTANCE.createBuilder(livekitSip$SIPOutboundTrunkInfo);
    }

    public static LivekitSip$SIPOutboundTrunkInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitSip$SIPOutboundTrunkInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitSip$SIPOutboundTrunkInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitSip$SIPOutboundTrunkInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitSip$SIPOutboundTrunkInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitSip$SIPOutboundTrunkInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitSip$SIPOutboundTrunkInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitSip$SIPOutboundTrunkInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitSip$SIPOutboundTrunkInfo parseFrom(byte[] bArr) {
        return (LivekitSip$SIPOutboundTrunkInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitSip$SIPOutboundTrunkInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitSip$SIPOutboundTrunkInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitSip$SIPOutboundTrunkInfo parseFrom(InputStream inputStream) {
        return (LivekitSip$SIPOutboundTrunkInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitSip$SIPOutboundTrunkInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitSip$SIPOutboundTrunkInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitSip$SIPOutboundTrunkInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitSip$SIPOutboundTrunkInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitSip$SIPOutboundTrunkInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitSip$SIPOutboundTrunkInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
