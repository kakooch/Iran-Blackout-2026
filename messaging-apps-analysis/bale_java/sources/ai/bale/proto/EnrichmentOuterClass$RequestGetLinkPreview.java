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

/* loaded from: classes9.dex */
public final class EnrichmentOuterClass$RequestGetLinkPreview extends GeneratedMessageLite implements U64 {
    private static final EnrichmentOuterClass$RequestGetLinkPreview DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int URL_FIELD_NUMBER = 1;
    private String url_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(EnrichmentOuterClass$RequestGetLinkPreview.DEFAULT_INSTANCE);
        }
    }

    static {
        EnrichmentOuterClass$RequestGetLinkPreview enrichmentOuterClass$RequestGetLinkPreview = new EnrichmentOuterClass$RequestGetLinkPreview();
        DEFAULT_INSTANCE = enrichmentOuterClass$RequestGetLinkPreview;
        GeneratedMessageLite.registerDefaultInstance(EnrichmentOuterClass$RequestGetLinkPreview.class, enrichmentOuterClass$RequestGetLinkPreview);
    }

    private EnrichmentOuterClass$RequestGetLinkPreview() {
    }

    private void clearUrl() {
        this.url_ = getDefaultInstance().getUrl();
    }

    public static EnrichmentOuterClass$RequestGetLinkPreview getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static EnrichmentOuterClass$RequestGetLinkPreview parseDelimitedFrom(InputStream inputStream) {
        return (EnrichmentOuterClass$RequestGetLinkPreview) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EnrichmentOuterClass$RequestGetLinkPreview parseFrom(ByteBuffer byteBuffer) {
        return (EnrichmentOuterClass$RequestGetLinkPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
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
        switch (O.a[gVar.ordinal()]) {
            case 1:
                return new EnrichmentOuterClass$RequestGetLinkPreview();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"url_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (EnrichmentOuterClass$RequestGetLinkPreview.class) {
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

    public String getUrl() {
        return this.url_;
    }

    public AbstractC2383g getUrlBytes() {
        return AbstractC2383g.N(this.url_);
    }

    public static a newBuilder(EnrichmentOuterClass$RequestGetLinkPreview enrichmentOuterClass$RequestGetLinkPreview) {
        return (a) DEFAULT_INSTANCE.createBuilder(enrichmentOuterClass$RequestGetLinkPreview);
    }

    public static EnrichmentOuterClass$RequestGetLinkPreview parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (EnrichmentOuterClass$RequestGetLinkPreview) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static EnrichmentOuterClass$RequestGetLinkPreview parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (EnrichmentOuterClass$RequestGetLinkPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static EnrichmentOuterClass$RequestGetLinkPreview parseFrom(AbstractC2383g abstractC2383g) {
        return (EnrichmentOuterClass$RequestGetLinkPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static EnrichmentOuterClass$RequestGetLinkPreview parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (EnrichmentOuterClass$RequestGetLinkPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static EnrichmentOuterClass$RequestGetLinkPreview parseFrom(byte[] bArr) {
        return (EnrichmentOuterClass$RequestGetLinkPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static EnrichmentOuterClass$RequestGetLinkPreview parseFrom(byte[] bArr, C2394s c2394s) {
        return (EnrichmentOuterClass$RequestGetLinkPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static EnrichmentOuterClass$RequestGetLinkPreview parseFrom(InputStream inputStream) {
        return (EnrichmentOuterClass$RequestGetLinkPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EnrichmentOuterClass$RequestGetLinkPreview parseFrom(InputStream inputStream, C2394s c2394s) {
        return (EnrichmentOuterClass$RequestGetLinkPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static EnrichmentOuterClass$RequestGetLinkPreview parseFrom(AbstractC2384h abstractC2384h) {
        return (EnrichmentOuterClass$RequestGetLinkPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static EnrichmentOuterClass$RequestGetLinkPreview parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (EnrichmentOuterClass$RequestGetLinkPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
