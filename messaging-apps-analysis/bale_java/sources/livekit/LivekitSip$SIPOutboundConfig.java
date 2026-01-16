package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.I;
import com.google.protobuf.J;
import com.google.protobuf.r0;
import ir.nasim.FF3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes8.dex */
public final class LivekitSip$SIPOutboundConfig extends GeneratedMessageLite implements U64 {
    public static final int ATTRIBUTES_TO_HEADERS_FIELD_NUMBER = 6;
    public static final int AUTH_PASSWORD_FIELD_NUMBER = 4;
    public static final int AUTH_USERNAME_FIELD_NUMBER = 3;
    private static final LivekitSip$SIPOutboundConfig DEFAULT_INSTANCE;
    public static final int DESTINATION_COUNTRY_FIELD_NUMBER = 7;
    public static final int HEADERS_TO_ATTRIBUTES_FIELD_NUMBER = 5;
    public static final int HOSTNAME_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int TRANSPORT_FIELD_NUMBER = 2;
    private int transport_;
    private J headersToAttributes_ = J.e();
    private J attributesToHeaders_ = J.e();
    private String hostname_ = "";
    private String destinationCountry_ = "";
    private String authUsername_ = "";
    private String authPassword_ = "";

    private static final class a {
        static final I a;

        static {
            r0.b bVar = r0.b.k;
            a = I.d(bVar, "", bVar, "");
        }
    }

    public static final class b extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ b(t tVar) {
            this();
        }

        private b() {
            super(LivekitSip$SIPOutboundConfig.DEFAULT_INSTANCE);
        }
    }

    private static final class c {
        static final I a;

        static {
            r0.b bVar = r0.b.k;
            a = I.d(bVar, "", bVar, "");
        }
    }

    static {
        LivekitSip$SIPOutboundConfig livekitSip$SIPOutboundConfig = new LivekitSip$SIPOutboundConfig();
        DEFAULT_INSTANCE = livekitSip$SIPOutboundConfig;
        GeneratedMessageLite.registerDefaultInstance(LivekitSip$SIPOutboundConfig.class, livekitSip$SIPOutboundConfig);
    }

    private LivekitSip$SIPOutboundConfig() {
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
    public void clearHostname() {
        this.hostname_ = getDefaultInstance().getHostname();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTransport() {
        this.transport_ = 0;
    }

    public static LivekitSip$SIPOutboundConfig getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> getMutableAttributesToHeadersMap() {
        return internalGetMutableAttributesToHeaders();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> getMutableHeadersToAttributesMap() {
        return internalGetMutableHeadersToAttributes();
    }

    private J internalGetAttributesToHeaders() {
        return this.attributesToHeaders_;
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

    private J internalGetMutableHeadersToAttributes() {
        if (!this.headersToAttributes_.n()) {
            this.headersToAttributes_ = this.headersToAttributes_.s();
        }
        return this.headersToAttributes_;
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitSip$SIPOutboundConfig parseDelimitedFrom(InputStream inputStream) {
        return (LivekitSip$SIPOutboundConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitSip$SIPOutboundConfig parseFrom(ByteBuffer byteBuffer) {
        return (LivekitSip$SIPOutboundConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
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
    public void setHostname(String str) {
        str.getClass();
        this.hostname_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHostnameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.hostname_ = abstractC2383g.f0();
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

    public boolean containsHeadersToAttributes(String str) {
        str.getClass();
        return internalGetHeadersToAttributes().containsKey(str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        t tVar = null;
        switch (t.a[gVar.ordinal()]) {
            case 1:
                return new LivekitSip$SIPOutboundConfig();
            case 2:
                return new b(tVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0002\u0000\u0000\u0001Ȉ\u0002\f\u0003Ȉ\u0004Ȉ\u00052\u00062\u0007Ȉ", new Object[]{"hostname_", "transport_", "authUsername_", "authPassword_", "headersToAttributes_", c.a, "attributesToHeaders_", a.a, "destinationCountry_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitSip$SIPOutboundConfig.class) {
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

    public String getHostname() {
        return this.hostname_;
    }

    public AbstractC2383g getHostnameBytes() {
        return AbstractC2383g.N(this.hostname_);
    }

    public FF3 getTransport() {
        FF3 ff3J = FF3.j(this.transport_);
        return ff3J == null ? FF3.UNRECOGNIZED : ff3J;
    }

    public int getTransportValue() {
        return this.transport_;
    }

    public static b newBuilder(LivekitSip$SIPOutboundConfig livekitSip$SIPOutboundConfig) {
        return (b) DEFAULT_INSTANCE.createBuilder(livekitSip$SIPOutboundConfig);
    }

    public static LivekitSip$SIPOutboundConfig parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitSip$SIPOutboundConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitSip$SIPOutboundConfig parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitSip$SIPOutboundConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitSip$SIPOutboundConfig parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitSip$SIPOutboundConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitSip$SIPOutboundConfig parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitSip$SIPOutboundConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitSip$SIPOutboundConfig parseFrom(byte[] bArr) {
        return (LivekitSip$SIPOutboundConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitSip$SIPOutboundConfig parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitSip$SIPOutboundConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitSip$SIPOutboundConfig parseFrom(InputStream inputStream) {
        return (LivekitSip$SIPOutboundConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitSip$SIPOutboundConfig parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitSip$SIPOutboundConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitSip$SIPOutboundConfig parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitSip$SIPOutboundConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitSip$SIPOutboundConfig parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitSip$SIPOutboundConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
