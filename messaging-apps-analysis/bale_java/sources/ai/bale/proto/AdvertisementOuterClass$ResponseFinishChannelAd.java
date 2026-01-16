package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$ResponseFinishChannelAd extends GeneratedMessageLite implements U64 {
    private static final AdvertisementOuterClass$ResponseFinishChannelAd DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$ResponseFinishChannelAd.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$ResponseFinishChannelAd advertisementOuterClass$ResponseFinishChannelAd = new AdvertisementOuterClass$ResponseFinishChannelAd();
        DEFAULT_INSTANCE = advertisementOuterClass$ResponseFinishChannelAd;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$ResponseFinishChannelAd.class, advertisementOuterClass$ResponseFinishChannelAd);
    }

    private AdvertisementOuterClass$ResponseFinishChannelAd() {
    }

    public static AdvertisementOuterClass$ResponseFinishChannelAd getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$ResponseFinishChannelAd parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseFinishChannelAd) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseFinishChannelAd parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$ResponseFinishChannelAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$ResponseFinishChannelAd();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$ResponseFinishChannelAd.class) {
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

    public static a newBuilder(AdvertisementOuterClass$ResponseFinishChannelAd advertisementOuterClass$ResponseFinishChannelAd) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$ResponseFinishChannelAd);
    }

    public static AdvertisementOuterClass$ResponseFinishChannelAd parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseFinishChannelAd) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseFinishChannelAd parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseFinishChannelAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$ResponseFinishChannelAd parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$ResponseFinishChannelAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$ResponseFinishChannelAd parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseFinishChannelAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$ResponseFinishChannelAd parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$ResponseFinishChannelAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$ResponseFinishChannelAd parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseFinishChannelAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$ResponseFinishChannelAd parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseFinishChannelAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseFinishChannelAd parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseFinishChannelAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseFinishChannelAd parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$ResponseFinishChannelAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$ResponseFinishChannelAd parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseFinishChannelAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
