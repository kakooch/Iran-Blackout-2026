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
public final class AdvertisementOuterClass$ResponseFinishAd extends GeneratedMessageLite implements U64 {
    private static final AdvertisementOuterClass$ResponseFinishAd DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$ResponseFinishAd.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$ResponseFinishAd advertisementOuterClass$ResponseFinishAd = new AdvertisementOuterClass$ResponseFinishAd();
        DEFAULT_INSTANCE = advertisementOuterClass$ResponseFinishAd;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$ResponseFinishAd.class, advertisementOuterClass$ResponseFinishAd);
    }

    private AdvertisementOuterClass$ResponseFinishAd() {
    }

    public static AdvertisementOuterClass$ResponseFinishAd getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$ResponseFinishAd parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseFinishAd) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseFinishAd parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$ResponseFinishAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$ResponseFinishAd();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$ResponseFinishAd.class) {
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

    public static a newBuilder(AdvertisementOuterClass$ResponseFinishAd advertisementOuterClass$ResponseFinishAd) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$ResponseFinishAd);
    }

    public static AdvertisementOuterClass$ResponseFinishAd parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseFinishAd) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseFinishAd parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseFinishAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$ResponseFinishAd parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$ResponseFinishAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$ResponseFinishAd parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseFinishAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$ResponseFinishAd parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$ResponseFinishAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$ResponseFinishAd parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseFinishAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$ResponseFinishAd parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseFinishAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseFinishAd parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseFinishAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseFinishAd parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$ResponseFinishAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$ResponseFinishAd parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseFinishAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
