package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class Saba$ResponseGetWebViewTrackingNumber extends GeneratedMessageLite implements U64 {
    private static final Saba$ResponseGetWebViewTrackingNumber DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TRACKING_NUMBER_FIELD_NUMBER = 1;
    public static final int URL_FIELD_NUMBER = 2;
    private String trackingNumber_ = "";
    private String url_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Saba$ResponseGetWebViewTrackingNumber.DEFAULT_INSTANCE);
        }
    }

    static {
        Saba$ResponseGetWebViewTrackingNumber saba$ResponseGetWebViewTrackingNumber = new Saba$ResponseGetWebViewTrackingNumber();
        DEFAULT_INSTANCE = saba$ResponseGetWebViewTrackingNumber;
        GeneratedMessageLite.registerDefaultInstance(Saba$ResponseGetWebViewTrackingNumber.class, saba$ResponseGetWebViewTrackingNumber);
    }

    private Saba$ResponseGetWebViewTrackingNumber() {
    }

    private void clearTrackingNumber() {
        this.trackingNumber_ = getDefaultInstance().getTrackingNumber();
    }

    private void clearUrl() {
        this.url_ = getDefaultInstance().getUrl();
    }

    public static Saba$ResponseGetWebViewTrackingNumber getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Saba$ResponseGetWebViewTrackingNumber parseDelimitedFrom(InputStream inputStream) {
        return (Saba$ResponseGetWebViewTrackingNumber) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Saba$ResponseGetWebViewTrackingNumber parseFrom(ByteBuffer byteBuffer) {
        return (Saba$ResponseGetWebViewTrackingNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setTrackingNumber(String str) {
        str.getClass();
        this.trackingNumber_ = str;
    }

    private void setTrackingNumberBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.trackingNumber_ = abstractC2383g.f0();
    }

    private void setUrl(String str) {
        str.getClass();
        this.url_ = str;
    }

    private void setUrlBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.url_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (B1.a[gVar.ordinal()]) {
            case 1:
                return new Saba$ResponseGetWebViewTrackingNumber();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"trackingNumber_", "url_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Saba$ResponseGetWebViewTrackingNumber.class) {
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

    public String getTrackingNumber() {
        return this.trackingNumber_;
    }

    public AbstractC2383g getTrackingNumberBytes() {
        return AbstractC2383g.N(this.trackingNumber_);
    }

    public String getUrl() {
        return this.url_;
    }

    public AbstractC2383g getUrlBytes() {
        return AbstractC2383g.N(this.url_);
    }

    public static a newBuilder(Saba$ResponseGetWebViewTrackingNumber saba$ResponseGetWebViewTrackingNumber) {
        return (a) DEFAULT_INSTANCE.createBuilder(saba$ResponseGetWebViewTrackingNumber);
    }

    public static Saba$ResponseGetWebViewTrackingNumber parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Saba$ResponseGetWebViewTrackingNumber) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Saba$ResponseGetWebViewTrackingNumber parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Saba$ResponseGetWebViewTrackingNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Saba$ResponseGetWebViewTrackingNumber parseFrom(AbstractC2383g abstractC2383g) {
        return (Saba$ResponseGetWebViewTrackingNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Saba$ResponseGetWebViewTrackingNumber parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Saba$ResponseGetWebViewTrackingNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Saba$ResponseGetWebViewTrackingNumber parseFrom(byte[] bArr) {
        return (Saba$ResponseGetWebViewTrackingNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Saba$ResponseGetWebViewTrackingNumber parseFrom(byte[] bArr, C2394s c2394s) {
        return (Saba$ResponseGetWebViewTrackingNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Saba$ResponseGetWebViewTrackingNumber parseFrom(InputStream inputStream) {
        return (Saba$ResponseGetWebViewTrackingNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Saba$ResponseGetWebViewTrackingNumber parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Saba$ResponseGetWebViewTrackingNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Saba$ResponseGetWebViewTrackingNumber parseFrom(AbstractC2384h abstractC2384h) {
        return (Saba$ResponseGetWebViewTrackingNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Saba$ResponseGetWebViewTrackingNumber parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Saba$ResponseGetWebViewTrackingNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
