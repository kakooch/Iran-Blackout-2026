package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int64Value;
import ai.bale.proto.CollectionsStruct$StringValue;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.DoubleValue;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.VQ;
import ir.nasim.YQ;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class AuthStruct$AuthSession extends GeneratedMessageLite implements YQ {
    public static final int APP_ID_FIELD_NUMBER = 3;
    public static final int APP_TITLE_FIELD_NUMBER = 4;
    public static final int AUTH_HOLDER_FIELD_NUMBER = 2;
    public static final int AUTH_LOCATION_FIELD_NUMBER = 7;
    public static final int AUTH_TIME_FIELD_NUMBER = 6;
    private static final AuthStruct$AuthSession DEFAULT_INSTANCE;
    public static final int DEVICE_TITLE_FIELD_NUMBER = 5;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int LAST_ACTIVITY_AT_FIELD_NUMBER = 10;
    public static final int LAST_IP_ADDRESS_FIELD_NUMBER = 11;
    public static final int LATITUDE_FIELD_NUMBER = 8;
    public static final int LONGITUDE_FIELD_NUMBER = 9;
    private static volatile KW4 PARSER;
    private int appId_;
    private int authHolder_;
    private int authTime_;
    private int bitField0_;
    private int id_;
    private CollectionsStruct$Int64Value lastActivityAt_;
    private CollectionsStruct$StringValue lastIpAddress_;
    private DoubleValue latitude_;
    private DoubleValue longitude_;
    private String appTitle_ = "";
    private String deviceTitle_ = "";
    private String authLocation_ = "";

    public static final class a extends GeneratedMessageLite.b implements YQ {
        private a() {
            super(AuthStruct$AuthSession.DEFAULT_INSTANCE);
        }
    }

    static {
        AuthStruct$AuthSession authStruct$AuthSession = new AuthStruct$AuthSession();
        DEFAULT_INSTANCE = authStruct$AuthSession;
        GeneratedMessageLite.registerDefaultInstance(AuthStruct$AuthSession.class, authStruct$AuthSession);
    }

    private AuthStruct$AuthSession() {
    }

    private void clearAppId() {
        this.appId_ = 0;
    }

    private void clearAppTitle() {
        this.appTitle_ = getDefaultInstance().getAppTitle();
    }

    private void clearAuthHolder() {
        this.authHolder_ = 0;
    }

    private void clearAuthLocation() {
        this.authLocation_ = getDefaultInstance().getAuthLocation();
    }

    private void clearAuthTime() {
        this.authTime_ = 0;
    }

    private void clearDeviceTitle() {
        this.deviceTitle_ = getDefaultInstance().getDeviceTitle();
    }

    private void clearId() {
        this.id_ = 0;
    }

    private void clearLastActivityAt() {
        this.lastActivityAt_ = null;
        this.bitField0_ &= -5;
    }

    private void clearLastIpAddress() {
        this.lastIpAddress_ = null;
        this.bitField0_ &= -9;
    }

    private void clearLatitude() {
        this.latitude_ = null;
        this.bitField0_ &= -2;
    }

    private void clearLongitude() {
        this.longitude_ = null;
        this.bitField0_ &= -3;
    }

    public static AuthStruct$AuthSession getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeLastActivityAt(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.lastActivityAt_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.lastActivityAt_ = collectionsStruct$Int64Value;
        } else {
            this.lastActivityAt_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.lastActivityAt_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeLastIpAddress(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        CollectionsStruct$StringValue collectionsStruct$StringValue2 = this.lastIpAddress_;
        if (collectionsStruct$StringValue2 == null || collectionsStruct$StringValue2 == CollectionsStruct$StringValue.getDefaultInstance()) {
            this.lastIpAddress_ = collectionsStruct$StringValue;
        } else {
            this.lastIpAddress_ = (CollectionsStruct$StringValue) ((CollectionsStruct$StringValue.a) CollectionsStruct$StringValue.newBuilder(this.lastIpAddress_).v(collectionsStruct$StringValue)).j();
        }
        this.bitField0_ |= 8;
    }

    private void mergeLatitude(DoubleValue doubleValue) {
        doubleValue.getClass();
        DoubleValue doubleValue2 = this.latitude_;
        if (doubleValue2 == null || doubleValue2 == DoubleValue.getDefaultInstance()) {
            this.latitude_ = doubleValue;
        } else {
            this.latitude_ = (DoubleValue) ((DoubleValue.b) DoubleValue.newBuilder(this.latitude_).v(doubleValue)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeLongitude(DoubleValue doubleValue) {
        doubleValue.getClass();
        DoubleValue doubleValue2 = this.longitude_;
        if (doubleValue2 == null || doubleValue2 == DoubleValue.getDefaultInstance()) {
            this.longitude_ = doubleValue;
        } else {
            this.longitude_ = (DoubleValue) ((DoubleValue.b) DoubleValue.newBuilder(this.longitude_).v(doubleValue)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AuthStruct$AuthSession parseDelimitedFrom(InputStream inputStream) {
        return (AuthStruct$AuthSession) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthStruct$AuthSession parseFrom(ByteBuffer byteBuffer) {
        return (AuthStruct$AuthSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAppId(int i) {
        this.appId_ = i;
    }

    private void setAppTitle(String str) {
        str.getClass();
        this.appTitle_ = str;
    }

    private void setAppTitleBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.appTitle_ = abstractC2383g.f0();
    }

    private void setAuthHolder(VQ vq) {
        this.authHolder_ = vq.getNumber();
    }

    private void setAuthHolderValue(int i) {
        this.authHolder_ = i;
    }

    private void setAuthLocation(String str) {
        str.getClass();
        this.authLocation_ = str;
    }

    private void setAuthLocationBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.authLocation_ = abstractC2383g.f0();
    }

    private void setAuthTime(int i) {
        this.authTime_ = i;
    }

    private void setDeviceTitle(String str) {
        str.getClass();
        this.deviceTitle_ = str;
    }

    private void setDeviceTitleBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.deviceTitle_ = abstractC2383g.f0();
    }

    private void setId(int i) {
        this.id_ = i;
    }

    private void setLastActivityAt(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.lastActivityAt_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 4;
    }

    private void setLastIpAddress(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        this.lastIpAddress_ = collectionsStruct$StringValue;
        this.bitField0_ |= 8;
    }

    private void setLatitude(DoubleValue doubleValue) {
        doubleValue.getClass();
        this.latitude_ = doubleValue;
        this.bitField0_ |= 1;
    }

    private void setLongitude(DoubleValue doubleValue) {
        doubleValue.getClass();
        this.longitude_ = doubleValue;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1870l.a[gVar.ordinal()]) {
            case 1:
                return new AuthStruct$AuthSession();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0000\u0000\u0001\u0004\u0002\f\u0003\u0004\u0004Ȉ\u0005Ȉ\u0006\u0004\u0007Ȉ\bဉ\u0000\tဉ\u0001\nဉ\u0002\u000bဉ\u0003", new Object[]{"bitField0_", "id_", "authHolder_", "appId_", "appTitle_", "deviceTitle_", "authTime_", "authLocation_", "latitude_", "longitude_", "lastActivityAt_", "lastIpAddress_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AuthStruct$AuthSession.class) {
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

    public int getAppId() {
        return this.appId_;
    }

    public String getAppTitle() {
        return this.appTitle_;
    }

    public AbstractC2383g getAppTitleBytes() {
        return AbstractC2383g.N(this.appTitle_);
    }

    public VQ getAuthHolder() {
        VQ vqJ = VQ.j(this.authHolder_);
        return vqJ == null ? VQ.UNRECOGNIZED : vqJ;
    }

    public int getAuthHolderValue() {
        return this.authHolder_;
    }

    public String getAuthLocation() {
        return this.authLocation_;
    }

    public AbstractC2383g getAuthLocationBytes() {
        return AbstractC2383g.N(this.authLocation_);
    }

    public int getAuthTime() {
        return this.authTime_;
    }

    public String getDeviceTitle() {
        return this.deviceTitle_;
    }

    public AbstractC2383g getDeviceTitleBytes() {
        return AbstractC2383g.N(this.deviceTitle_);
    }

    public int getId() {
        return this.id_;
    }

    public CollectionsStruct$Int64Value getLastActivityAt() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.lastActivityAt_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public CollectionsStruct$StringValue getLastIpAddress() {
        CollectionsStruct$StringValue collectionsStruct$StringValue = this.lastIpAddress_;
        return collectionsStruct$StringValue == null ? CollectionsStruct$StringValue.getDefaultInstance() : collectionsStruct$StringValue;
    }

    public DoubleValue getLatitude() {
        DoubleValue doubleValue = this.latitude_;
        return doubleValue == null ? DoubleValue.getDefaultInstance() : doubleValue;
    }

    public DoubleValue getLongitude() {
        DoubleValue doubleValue = this.longitude_;
        return doubleValue == null ? DoubleValue.getDefaultInstance() : doubleValue;
    }

    public boolean hasLastActivityAt() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasLastIpAddress() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasLatitude() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasLongitude() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(AuthStruct$AuthSession authStruct$AuthSession) {
        return (a) DEFAULT_INSTANCE.createBuilder(authStruct$AuthSession);
    }

    public static AuthStruct$AuthSession parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AuthStruct$AuthSession) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AuthStruct$AuthSession parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AuthStruct$AuthSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AuthStruct$AuthSession parseFrom(AbstractC2383g abstractC2383g) {
        return (AuthStruct$AuthSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AuthStruct$AuthSession parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AuthStruct$AuthSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AuthStruct$AuthSession parseFrom(byte[] bArr) {
        return (AuthStruct$AuthSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AuthStruct$AuthSession parseFrom(byte[] bArr, C2394s c2394s) {
        return (AuthStruct$AuthSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AuthStruct$AuthSession parseFrom(InputStream inputStream) {
        return (AuthStruct$AuthSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthStruct$AuthSession parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AuthStruct$AuthSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AuthStruct$AuthSession parseFrom(AbstractC2384h abstractC2384h) {
        return (AuthStruct$AuthSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AuthStruct$AuthSession parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AuthStruct$AuthSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
