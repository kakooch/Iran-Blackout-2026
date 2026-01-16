package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import ir.nasim.VE3;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitAnalytics$AnalyticsClientMeta extends GeneratedMessageLite implements U64 {
    public static final int CLIENT_ADDR_FIELD_NUMBER = 3;
    public static final int CLIENT_CONNECT_TIME_FIELD_NUMBER = 4;
    public static final int CONNECTION_TYPE_FIELD_NUMBER = 5;
    public static final int COUNTRY_FIELD_NUMBER = 8;
    private static final LivekitAnalytics$AnalyticsClientMeta DEFAULT_INSTANCE;
    public static final int GEO_HASH_FIELD_NUMBER = 7;
    public static final int ISP_ASN_FIELD_NUMBER = 9;
    public static final int NODE_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int RECONNECT_REASON_FIELD_NUMBER = 6;
    public static final int REGION_FIELD_NUMBER = 1;
    private int bitField0_;
    private int clientConnectTime_;
    private int ispAsn_;
    private int reconnectReason_;
    private String region_ = "";
    private String node_ = "";
    private String clientAddr_ = "";
    private String connectionType_ = "";
    private String geoHash_ = "";
    private String country_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(c cVar) {
            this();
        }

        private a() {
            super(LivekitAnalytics$AnalyticsClientMeta.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitAnalytics$AnalyticsClientMeta livekitAnalytics$AnalyticsClientMeta = new LivekitAnalytics$AnalyticsClientMeta();
        DEFAULT_INSTANCE = livekitAnalytics$AnalyticsClientMeta;
        GeneratedMessageLite.registerDefaultInstance(LivekitAnalytics$AnalyticsClientMeta.class, livekitAnalytics$AnalyticsClientMeta);
    }

    private LivekitAnalytics$AnalyticsClientMeta() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearClientAddr() {
        this.clientAddr_ = getDefaultInstance().getClientAddr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearClientConnectTime() {
        this.clientConnectTime_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearConnectionType() {
        this.connectionType_ = getDefaultInstance().getConnectionType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCountry() {
        this.bitField0_ &= -3;
        this.country_ = getDefaultInstance().getCountry();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearGeoHash() {
        this.bitField0_ &= -2;
        this.geoHash_ = getDefaultInstance().getGeoHash();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIspAsn() {
        this.bitField0_ &= -5;
        this.ispAsn_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNode() {
        this.node_ = getDefaultInstance().getNode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearReconnectReason() {
        this.reconnectReason_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRegion() {
        this.region_ = getDefaultInstance().getRegion();
    }

    public static LivekitAnalytics$AnalyticsClientMeta getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitAnalytics$AnalyticsClientMeta parseDelimitedFrom(InputStream inputStream) {
        return (LivekitAnalytics$AnalyticsClientMeta) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAnalytics$AnalyticsClientMeta parseFrom(ByteBuffer byteBuffer) {
        return (LivekitAnalytics$AnalyticsClientMeta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setClientAddr(String str) {
        str.getClass();
        this.clientAddr_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setClientAddrBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.clientAddr_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setClientConnectTime(int i) {
        this.clientConnectTime_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConnectionType(String str) {
        str.getClass();
        this.connectionType_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConnectionTypeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.connectionType_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCountry(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.country_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCountryBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.country_ = abstractC2383g.f0();
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGeoHash(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.geoHash_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGeoHashBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.geoHash_ = abstractC2383g.f0();
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIspAsn(int i) {
        this.bitField0_ |= 4;
        this.ispAsn_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNode(String str) {
        str.getClass();
        this.node_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNodeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.node_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReconnectReason(VE3 ve3) {
        this.reconnectReason_ = ve3.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReconnectReasonValue(int i) {
        this.reconnectReason_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRegion(String str) {
        str.getClass();
        this.region_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRegionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.region_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        c cVar = null;
        switch (c.a[gVar.ordinal()]) {
            case 1:
                return new LivekitAnalytics$AnalyticsClientMeta();
            case 2:
                return new a(cVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004\u000b\u0005Ȉ\u0006\f\u0007ለ\u0000\bለ\u0001\tဋ\u0002", new Object[]{"bitField0_", "region_", "node_", "clientAddr_", "clientConnectTime_", "connectionType_", "reconnectReason_", "geoHash_", "country_", "ispAsn_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar2 = PARSER;
                if (cVar2 == null) {
                    synchronized (LivekitAnalytics$AnalyticsClientMeta.class) {
                        try {
                            cVar2 = PARSER;
                            if (cVar2 == null) {
                                cVar2 = new GeneratedMessageLite.c(DEFAULT_INSTANCE);
                                PARSER = cVar2;
                            }
                        } finally {
                        }
                    }
                }
                return cVar2;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public String getClientAddr() {
        return this.clientAddr_;
    }

    public AbstractC2383g getClientAddrBytes() {
        return AbstractC2383g.N(this.clientAddr_);
    }

    public int getClientConnectTime() {
        return this.clientConnectTime_;
    }

    public String getConnectionType() {
        return this.connectionType_;
    }

    public AbstractC2383g getConnectionTypeBytes() {
        return AbstractC2383g.N(this.connectionType_);
    }

    public String getCountry() {
        return this.country_;
    }

    public AbstractC2383g getCountryBytes() {
        return AbstractC2383g.N(this.country_);
    }

    public String getGeoHash() {
        return this.geoHash_;
    }

    public AbstractC2383g getGeoHashBytes() {
        return AbstractC2383g.N(this.geoHash_);
    }

    public int getIspAsn() {
        return this.ispAsn_;
    }

    public String getNode() {
        return this.node_;
    }

    public AbstractC2383g getNodeBytes() {
        return AbstractC2383g.N(this.node_);
    }

    public VE3 getReconnectReason() {
        VE3 ve3J = VE3.j(this.reconnectReason_);
        return ve3J == null ? VE3.UNRECOGNIZED : ve3J;
    }

    public int getReconnectReasonValue() {
        return this.reconnectReason_;
    }

    public String getRegion() {
        return this.region_;
    }

    public AbstractC2383g getRegionBytes() {
        return AbstractC2383g.N(this.region_);
    }

    public boolean hasCountry() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasGeoHash() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasIspAsn() {
        return (this.bitField0_ & 4) != 0;
    }

    public static a newBuilder(LivekitAnalytics$AnalyticsClientMeta livekitAnalytics$AnalyticsClientMeta) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitAnalytics$AnalyticsClientMeta);
    }

    public static LivekitAnalytics$AnalyticsClientMeta parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsClientMeta) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAnalytics$AnalyticsClientMeta parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsClientMeta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitAnalytics$AnalyticsClientMeta parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitAnalytics$AnalyticsClientMeta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitAnalytics$AnalyticsClientMeta parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsClientMeta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitAnalytics$AnalyticsClientMeta parseFrom(byte[] bArr) {
        return (LivekitAnalytics$AnalyticsClientMeta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitAnalytics$AnalyticsClientMeta parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsClientMeta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitAnalytics$AnalyticsClientMeta parseFrom(InputStream inputStream) {
        return (LivekitAnalytics$AnalyticsClientMeta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAnalytics$AnalyticsClientMeta parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsClientMeta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAnalytics$AnalyticsClientMeta parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitAnalytics$AnalyticsClientMeta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitAnalytics$AnalyticsClientMeta parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsClientMeta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
