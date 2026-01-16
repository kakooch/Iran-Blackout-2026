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
public final class AdvertisementStruct$TapsellAd extends GeneratedMessageLite implements U64 {
    private static final AdvertisementStruct$TapsellAd DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TAG_FIELD_NUMBER = 1;
    private String tag_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementStruct$TapsellAd.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementStruct$TapsellAd advertisementStruct$TapsellAd = new AdvertisementStruct$TapsellAd();
        DEFAULT_INSTANCE = advertisementStruct$TapsellAd;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementStruct$TapsellAd.class, advertisementStruct$TapsellAd);
    }

    private AdvertisementStruct$TapsellAd() {
    }

    private void clearTag() {
        this.tag_ = getDefaultInstance().getTag();
    }

    public static AdvertisementStruct$TapsellAd getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementStruct$TapsellAd parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementStruct$TapsellAd) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$TapsellAd parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementStruct$TapsellAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setTag(String str) {
        str.getClass();
        this.tag_ = str;
    }

    private void setTagBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.tag_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1843c.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementStruct$TapsellAd();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"tag_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementStruct$TapsellAd.class) {
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

    public String getTag() {
        return this.tag_;
    }

    public AbstractC2383g getTagBytes() {
        return AbstractC2383g.N(this.tag_);
    }

    public static a newBuilder(AdvertisementStruct$TapsellAd advertisementStruct$TapsellAd) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementStruct$TapsellAd);
    }

    public static AdvertisementStruct$TapsellAd parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$TapsellAd) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$TapsellAd parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementStruct$TapsellAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementStruct$TapsellAd parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementStruct$TapsellAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementStruct$TapsellAd parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementStruct$TapsellAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementStruct$TapsellAd parseFrom(byte[] bArr) {
        return (AdvertisementStruct$TapsellAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementStruct$TapsellAd parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementStruct$TapsellAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementStruct$TapsellAd parseFrom(InputStream inputStream) {
        return (AdvertisementStruct$TapsellAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$TapsellAd parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$TapsellAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$TapsellAd parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementStruct$TapsellAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementStruct$TapsellAd parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementStruct$TapsellAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
