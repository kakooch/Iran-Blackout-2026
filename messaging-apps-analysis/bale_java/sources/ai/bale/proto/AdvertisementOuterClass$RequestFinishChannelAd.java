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
public final class AdvertisementOuterClass$RequestFinishChannelAd extends GeneratedMessageLite implements U64 {
    private static final AdvertisementOuterClass$RequestFinishChannelAd DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private String id_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$RequestFinishChannelAd.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$RequestFinishChannelAd advertisementOuterClass$RequestFinishChannelAd = new AdvertisementOuterClass$RequestFinishChannelAd();
        DEFAULT_INSTANCE = advertisementOuterClass$RequestFinishChannelAd;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$RequestFinishChannelAd.class, advertisementOuterClass$RequestFinishChannelAd);
    }

    private AdvertisementOuterClass$RequestFinishChannelAd() {
    }

    private void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    public static AdvertisementOuterClass$RequestFinishChannelAd getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$RequestFinishChannelAd parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestFinishChannelAd) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestFinishChannelAd parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$RequestFinishChannelAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setId(String str) {
        str.getClass();
        this.id_ = str;
    }

    private void setIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.id_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$RequestFinishChannelAd();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"id_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$RequestFinishChannelAd.class) {
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

    public String getId() {
        return this.id_;
    }

    public AbstractC2383g getIdBytes() {
        return AbstractC2383g.N(this.id_);
    }

    public static a newBuilder(AdvertisementOuterClass$RequestFinishChannelAd advertisementOuterClass$RequestFinishChannelAd) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$RequestFinishChannelAd);
    }

    public static AdvertisementOuterClass$RequestFinishChannelAd parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestFinishChannelAd) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestFinishChannelAd parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestFinishChannelAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$RequestFinishChannelAd parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$RequestFinishChannelAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$RequestFinishChannelAd parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestFinishChannelAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$RequestFinishChannelAd parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$RequestFinishChannelAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$RequestFinishChannelAd parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestFinishChannelAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$RequestFinishChannelAd parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestFinishChannelAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestFinishChannelAd parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestFinishChannelAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestFinishChannelAd parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$RequestFinishChannelAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$RequestFinishChannelAd parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestFinishChannelAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
