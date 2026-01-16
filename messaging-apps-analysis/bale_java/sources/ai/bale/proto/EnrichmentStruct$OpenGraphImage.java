package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC12759f92;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class EnrichmentStruct$OpenGraphImage extends GeneratedMessageLite implements InterfaceC12759f92 {
    private static final EnrichmentStruct$OpenGraphImage DEFAULT_INSTANCE;
    public static final int HEIGHT_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int SECURE_URL_FIELD_NUMBER = 2;
    public static final int TYPE_FIELD_NUMBER = 3;
    public static final int URL_FIELD_NUMBER = 1;
    public static final int WIDTH_FIELD_NUMBER = 5;
    private int height_;
    private int width_;
    private String url_ = "";
    private String secureUrl_ = "";
    private String type_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC12759f92 {
        private a() {
            super(EnrichmentStruct$OpenGraphImage.DEFAULT_INSTANCE);
        }
    }

    static {
        EnrichmentStruct$OpenGraphImage enrichmentStruct$OpenGraphImage = new EnrichmentStruct$OpenGraphImage();
        DEFAULT_INSTANCE = enrichmentStruct$OpenGraphImage;
        GeneratedMessageLite.registerDefaultInstance(EnrichmentStruct$OpenGraphImage.class, enrichmentStruct$OpenGraphImage);
    }

    private EnrichmentStruct$OpenGraphImage() {
    }

    private void clearHeight() {
        this.height_ = 0;
    }

    private void clearSecureUrl() {
        this.secureUrl_ = getDefaultInstance().getSecureUrl();
    }

    private void clearType() {
        this.type_ = getDefaultInstance().getType();
    }

    private void clearUrl() {
        this.url_ = getDefaultInstance().getUrl();
    }

    private void clearWidth() {
        this.width_ = 0;
    }

    public static EnrichmentStruct$OpenGraphImage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static EnrichmentStruct$OpenGraphImage parseDelimitedFrom(InputStream inputStream) {
        return (EnrichmentStruct$OpenGraphImage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EnrichmentStruct$OpenGraphImage parseFrom(ByteBuffer byteBuffer) {
        return (EnrichmentStruct$OpenGraphImage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setHeight(int i) {
        this.height_ = i;
    }

    private void setSecureUrl(String str) {
        str.getClass();
        this.secureUrl_ = str;
    }

    private void setSecureUrlBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.secureUrl_ = abstractC2383g.f0();
    }

    private void setType(String str) {
        str.getClass();
        this.type_ = str;
    }

    private void setTypeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.type_ = abstractC2383g.f0();
    }

    private void setUrl(String str) {
        str.getClass();
        this.url_ = str;
    }

    private void setUrlBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.url_ = abstractC2383g.f0();
    }

    private void setWidth(int i) {
        this.width_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (P.a[gVar.ordinal()]) {
            case 1:
                return new EnrichmentStruct$OpenGraphImage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004\u0004\u0005\u0004", new Object[]{"url_", "secureUrl_", "type_", "height_", "width_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (EnrichmentStruct$OpenGraphImage.class) {
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

    public int getHeight() {
        return this.height_;
    }

    public String getSecureUrl() {
        return this.secureUrl_;
    }

    public AbstractC2383g getSecureUrlBytes() {
        return AbstractC2383g.N(this.secureUrl_);
    }

    public String getType() {
        return this.type_;
    }

    public AbstractC2383g getTypeBytes() {
        return AbstractC2383g.N(this.type_);
    }

    public String getUrl() {
        return this.url_;
    }

    public AbstractC2383g getUrlBytes() {
        return AbstractC2383g.N(this.url_);
    }

    public int getWidth() {
        return this.width_;
    }

    public static a newBuilder(EnrichmentStruct$OpenGraphImage enrichmentStruct$OpenGraphImage) {
        return (a) DEFAULT_INSTANCE.createBuilder(enrichmentStruct$OpenGraphImage);
    }

    public static EnrichmentStruct$OpenGraphImage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (EnrichmentStruct$OpenGraphImage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static EnrichmentStruct$OpenGraphImage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (EnrichmentStruct$OpenGraphImage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static EnrichmentStruct$OpenGraphImage parseFrom(AbstractC2383g abstractC2383g) {
        return (EnrichmentStruct$OpenGraphImage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static EnrichmentStruct$OpenGraphImage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (EnrichmentStruct$OpenGraphImage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static EnrichmentStruct$OpenGraphImage parseFrom(byte[] bArr) {
        return (EnrichmentStruct$OpenGraphImage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static EnrichmentStruct$OpenGraphImage parseFrom(byte[] bArr, C2394s c2394s) {
        return (EnrichmentStruct$OpenGraphImage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static EnrichmentStruct$OpenGraphImage parseFrom(InputStream inputStream) {
        return (EnrichmentStruct$OpenGraphImage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EnrichmentStruct$OpenGraphImage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (EnrichmentStruct$OpenGraphImage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static EnrichmentStruct$OpenGraphImage parseFrom(AbstractC2384h abstractC2384h) {
        return (EnrichmentStruct$OpenGraphImage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static EnrichmentStruct$OpenGraphImage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (EnrichmentStruct$OpenGraphImage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
