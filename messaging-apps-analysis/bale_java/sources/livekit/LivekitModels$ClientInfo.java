package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitModels$ClientInfo extends GeneratedMessageLite implements U64 {
    public static final int ADDRESS_FIELD_NUMBER = 9;
    public static final int BROWSER_FIELD_NUMBER = 7;
    public static final int BROWSER_VERSION_FIELD_NUMBER = 8;
    private static final LivekitModels$ClientInfo DEFAULT_INSTANCE;
    public static final int DEVICE_MODEL_FIELD_NUMBER = 6;
    public static final int NETWORK_FIELD_NUMBER = 10;
    public static final int OS_FIELD_NUMBER = 4;
    public static final int OS_VERSION_FIELD_NUMBER = 5;
    public static final int OTHER_SDKS_FIELD_NUMBER = 11;
    private static volatile KW4 PARSER = null;
    public static final int PROTOCOL_FIELD_NUMBER = 3;
    public static final int SDK_FIELD_NUMBER = 1;
    public static final int VERSION_FIELD_NUMBER = 2;
    private int protocol_;
    private int sdk_;
    private String version_ = "";
    private String os_ = "";
    private String osVersion_ = "";
    private String deviceModel_ = "";
    private String browser_ = "";
    private String browserVersion_ = "";
    private String address_ = "";
    private String network_ = "";
    private String otherSdks_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(o oVar) {
            this();
        }

        public a A(String str) {
            q();
            ((LivekitModels$ClientInfo) this.b).setDeviceModel(str);
            return this;
        }

        public a B(String str) {
            q();
            ((LivekitModels$ClientInfo) this.b).setOs(str);
            return this;
        }

        public a C(String str) {
            q();
            ((LivekitModels$ClientInfo) this.b).setOsVersion(str);
            return this;
        }

        public a D(b bVar) {
            q();
            ((LivekitModels$ClientInfo) this.b).setSdk(bVar);
            return this;
        }

        public a E(String str) {
            q();
            ((LivekitModels$ClientInfo) this.b).setVersion(str);
            return this;
        }

        private a() {
            super(LivekitModels$ClientInfo.DEFAULT_INSTANCE);
        }
    }

    public enum b implements B.c {
        UNKNOWN(0),
        JS(1),
        SWIFT(2),
        ANDROID(3),
        FLUTTER(4),
        GO(5),
        UNITY(6),
        REACT_NATIVE(7),
        RUST(8),
        PYTHON(9),
        CPP(10),
        UNITY_WEB(11),
        NODE(12),
        UNREAL(13),
        ESP32(14),
        UNRECOGNIZED(-1);

        private static final B.d r = new a();
        private final int a;

        class a implements B.d {
            a() {
            }

            @Override // com.google.protobuf.B.d
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public b a(int i) {
                return b.j(i);
            }
        }

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            switch (i) {
                case 0:
                    return UNKNOWN;
                case 1:
                    return JS;
                case 2:
                    return SWIFT;
                case 3:
                    return ANDROID;
                case 4:
                    return FLUTTER;
                case 5:
                    return GO;
                case 6:
                    return UNITY;
                case 7:
                    return REACT_NATIVE;
                case 8:
                    return RUST;
                case 9:
                    return PYTHON;
                case 10:
                    return CPP;
                case 11:
                    return UNITY_WEB;
                case 12:
                    return NODE;
                case 13:
                    return UNREAL;
                case 14:
                    return ESP32;
                default:
                    return null;
            }
        }

        @Override // com.google.protobuf.B.c
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.a;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    static {
        LivekitModels$ClientInfo livekitModels$ClientInfo = new LivekitModels$ClientInfo();
        DEFAULT_INSTANCE = livekitModels$ClientInfo;
        GeneratedMessageLite.registerDefaultInstance(LivekitModels$ClientInfo.class, livekitModels$ClientInfo);
    }

    private LivekitModels$ClientInfo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAddress() {
        this.address_ = getDefaultInstance().getAddress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBrowser() {
        this.browser_ = getDefaultInstance().getBrowser();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBrowserVersion() {
        this.browserVersion_ = getDefaultInstance().getBrowserVersion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDeviceModel() {
        this.deviceModel_ = getDefaultInstance().getDeviceModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNetwork() {
        this.network_ = getDefaultInstance().getNetwork();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOs() {
        this.os_ = getDefaultInstance().getOs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOsVersion() {
        this.osVersion_ = getDefaultInstance().getOsVersion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOtherSdks() {
        this.otherSdks_ = getDefaultInstance().getOtherSdks();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearProtocol() {
        this.protocol_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSdk() {
        this.sdk_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = getDefaultInstance().getVersion();
    }

    public static LivekitModels$ClientInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitModels$ClientInfo parseDelimitedFrom(InputStream inputStream) {
        return (LivekitModels$ClientInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$ClientInfo parseFrom(ByteBuffer byteBuffer) {
        return (LivekitModels$ClientInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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
    public void setBrowser(String str) {
        str.getClass();
        this.browser_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBrowserBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.browser_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBrowserVersion(String str) {
        str.getClass();
        this.browserVersion_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBrowserVersionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.browserVersion_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDeviceModel(String str) {
        str.getClass();
        this.deviceModel_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDeviceModelBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.deviceModel_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNetwork(String str) {
        str.getClass();
        this.network_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNetworkBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.network_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOs(String str) {
        str.getClass();
        this.os_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOsBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.os_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOsVersion(String str) {
        str.getClass();
        this.osVersion_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOsVersionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.osVersion_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOtherSdks(String str) {
        str.getClass();
        this.otherSdks_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOtherSdksBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.otherSdks_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProtocol(int i) {
        this.protocol_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSdk(b bVar) {
        this.sdk_ = bVar.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSdkValue(int i) {
        this.sdk_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(String str) {
        str.getClass();
        this.version_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.version_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        o oVar = null;
        switch (o.a[gVar.ordinal()]) {
            case 1:
                return new LivekitModels$ClientInfo();
            case 2:
                return new a(oVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u000b\u0000\u0000\u0001\u000b\u000b\u0000\u0000\u0000\u0001\f\u0002Ȉ\u0003\u0004\u0004Ȉ\u0005Ȉ\u0006Ȉ\u0007Ȉ\bȈ\tȈ\nȈ\u000bȈ", new Object[]{"sdk_", "version_", "protocol_", "os_", "osVersion_", "deviceModel_", "browser_", "browserVersion_", "address_", "network_", "otherSdks_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitModels$ClientInfo.class) {
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

    public String getBrowser() {
        return this.browser_;
    }

    public AbstractC2383g getBrowserBytes() {
        return AbstractC2383g.N(this.browser_);
    }

    public String getBrowserVersion() {
        return this.browserVersion_;
    }

    public AbstractC2383g getBrowserVersionBytes() {
        return AbstractC2383g.N(this.browserVersion_);
    }

    public String getDeviceModel() {
        return this.deviceModel_;
    }

    public AbstractC2383g getDeviceModelBytes() {
        return AbstractC2383g.N(this.deviceModel_);
    }

    public String getNetwork() {
        return this.network_;
    }

    public AbstractC2383g getNetworkBytes() {
        return AbstractC2383g.N(this.network_);
    }

    public String getOs() {
        return this.os_;
    }

    public AbstractC2383g getOsBytes() {
        return AbstractC2383g.N(this.os_);
    }

    public String getOsVersion() {
        return this.osVersion_;
    }

    public AbstractC2383g getOsVersionBytes() {
        return AbstractC2383g.N(this.osVersion_);
    }

    public String getOtherSdks() {
        return this.otherSdks_;
    }

    public AbstractC2383g getOtherSdksBytes() {
        return AbstractC2383g.N(this.otherSdks_);
    }

    public int getProtocol() {
        return this.protocol_;
    }

    public b getSdk() {
        b bVarJ = b.j(this.sdk_);
        return bVarJ == null ? b.UNRECOGNIZED : bVarJ;
    }

    public int getSdkValue() {
        return this.sdk_;
    }

    public String getVersion() {
        return this.version_;
    }

    public AbstractC2383g getVersionBytes() {
        return AbstractC2383g.N(this.version_);
    }

    public static a newBuilder(LivekitModels$ClientInfo livekitModels$ClientInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitModels$ClientInfo);
    }

    public static LivekitModels$ClientInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$ClientInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$ClientInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitModels$ClientInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitModels$ClientInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitModels$ClientInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitModels$ClientInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitModels$ClientInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitModels$ClientInfo parseFrom(byte[] bArr) {
        return (LivekitModels$ClientInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitModels$ClientInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitModels$ClientInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitModels$ClientInfo parseFrom(InputStream inputStream) {
        return (LivekitModels$ClientInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$ClientInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$ClientInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$ClientInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitModels$ClientInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitModels$ClientInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitModels$ClientInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
