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

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$ResponseCreateChannelIncomeFactor extends GeneratedMessageLite implements U64 {
    private static final AdvertisementOuterClass$ResponseCreateChannelIncomeFactor DEFAULT_INSTANCE;
    public static final int FACTOR_HTML_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private String factorHtml_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$ResponseCreateChannelIncomeFactor.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$ResponseCreateChannelIncomeFactor advertisementOuterClass$ResponseCreateChannelIncomeFactor = new AdvertisementOuterClass$ResponseCreateChannelIncomeFactor();
        DEFAULT_INSTANCE = advertisementOuterClass$ResponseCreateChannelIncomeFactor;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$ResponseCreateChannelIncomeFactor.class, advertisementOuterClass$ResponseCreateChannelIncomeFactor);
    }

    private AdvertisementOuterClass$ResponseCreateChannelIncomeFactor() {
    }

    private void clearFactorHtml() {
        this.factorHtml_ = getDefaultInstance().getFactorHtml();
    }

    public static AdvertisementOuterClass$ResponseCreateChannelIncomeFactor getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$ResponseCreateChannelIncomeFactor parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseCreateChannelIncomeFactor) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseCreateChannelIncomeFactor parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$ResponseCreateChannelIncomeFactor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setFactorHtml(String str) {
        str.getClass();
        this.factorHtml_ = str;
    }

    private void setFactorHtmlBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.factorHtml_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$ResponseCreateChannelIncomeFactor();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"factorHtml_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$ResponseCreateChannelIncomeFactor.class) {
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

    public String getFactorHtml() {
        return this.factorHtml_;
    }

    public AbstractC2383g getFactorHtmlBytes() {
        return AbstractC2383g.N(this.factorHtml_);
    }

    public static a newBuilder(AdvertisementOuterClass$ResponseCreateChannelIncomeFactor advertisementOuterClass$ResponseCreateChannelIncomeFactor) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$ResponseCreateChannelIncomeFactor);
    }

    public static AdvertisementOuterClass$ResponseCreateChannelIncomeFactor parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseCreateChannelIncomeFactor) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseCreateChannelIncomeFactor parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseCreateChannelIncomeFactor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$ResponseCreateChannelIncomeFactor parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$ResponseCreateChannelIncomeFactor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$ResponseCreateChannelIncomeFactor parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseCreateChannelIncomeFactor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$ResponseCreateChannelIncomeFactor parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$ResponseCreateChannelIncomeFactor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$ResponseCreateChannelIncomeFactor parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseCreateChannelIncomeFactor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$ResponseCreateChannelIncomeFactor parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseCreateChannelIncomeFactor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseCreateChannelIncomeFactor parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseCreateChannelIncomeFactor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseCreateChannelIncomeFactor parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$ResponseCreateChannelIncomeFactor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$ResponseCreateChannelIncomeFactor parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseCreateChannelIncomeFactor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
