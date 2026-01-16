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
public final class AdvertisementOuterClass$RequestGetAwaitingToShowChannelAds extends GeneratedMessageLite implements U64 {
    private static final AdvertisementOuterClass$RequestGetAwaitingToShowChannelAds DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$RequestGetAwaitingToShowChannelAds.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$RequestGetAwaitingToShowChannelAds advertisementOuterClass$RequestGetAwaitingToShowChannelAds = new AdvertisementOuterClass$RequestGetAwaitingToShowChannelAds();
        DEFAULT_INSTANCE = advertisementOuterClass$RequestGetAwaitingToShowChannelAds;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$RequestGetAwaitingToShowChannelAds.class, advertisementOuterClass$RequestGetAwaitingToShowChannelAds);
    }

    private AdvertisementOuterClass$RequestGetAwaitingToShowChannelAds() {
    }

    public static AdvertisementOuterClass$RequestGetAwaitingToShowChannelAds getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$RequestGetAwaitingToShowChannelAds parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestGetAwaitingToShowChannelAds) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestGetAwaitingToShowChannelAds parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$RequestGetAwaitingToShowChannelAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$RequestGetAwaitingToShowChannelAds();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$RequestGetAwaitingToShowChannelAds.class) {
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

    public static a newBuilder(AdvertisementOuterClass$RequestGetAwaitingToShowChannelAds advertisementOuterClass$RequestGetAwaitingToShowChannelAds) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$RequestGetAwaitingToShowChannelAds);
    }

    public static AdvertisementOuterClass$RequestGetAwaitingToShowChannelAds parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetAwaitingToShowChannelAds) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetAwaitingToShowChannelAds parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetAwaitingToShowChannelAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetAwaitingToShowChannelAds parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$RequestGetAwaitingToShowChannelAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$RequestGetAwaitingToShowChannelAds parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetAwaitingToShowChannelAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetAwaitingToShowChannelAds parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$RequestGetAwaitingToShowChannelAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$RequestGetAwaitingToShowChannelAds parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetAwaitingToShowChannelAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetAwaitingToShowChannelAds parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestGetAwaitingToShowChannelAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestGetAwaitingToShowChannelAds parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetAwaitingToShowChannelAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetAwaitingToShowChannelAds parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$RequestGetAwaitingToShowChannelAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$RequestGetAwaitingToShowChannelAds parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetAwaitingToShowChannelAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
