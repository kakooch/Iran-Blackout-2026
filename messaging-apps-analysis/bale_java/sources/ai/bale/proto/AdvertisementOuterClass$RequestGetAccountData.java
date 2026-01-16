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
public final class AdvertisementOuterClass$RequestGetAccountData extends GeneratedMessageLite implements U64 {
    private static final AdvertisementOuterClass$RequestGetAccountData DEFAULT_INSTANCE;
    public static final int OWNER_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int ownerId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$RequestGetAccountData.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$RequestGetAccountData advertisementOuterClass$RequestGetAccountData = new AdvertisementOuterClass$RequestGetAccountData();
        DEFAULT_INSTANCE = advertisementOuterClass$RequestGetAccountData;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$RequestGetAccountData.class, advertisementOuterClass$RequestGetAccountData);
    }

    private AdvertisementOuterClass$RequestGetAccountData() {
    }

    private void clearOwnerId() {
        this.ownerId_ = 0;
    }

    public static AdvertisementOuterClass$RequestGetAccountData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$RequestGetAccountData parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestGetAccountData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestGetAccountData parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$RequestGetAccountData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setOwnerId(int i) {
        this.ownerId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$RequestGetAccountData();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"ownerId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$RequestGetAccountData.class) {
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

    public int getOwnerId() {
        return this.ownerId_;
    }

    public static a newBuilder(AdvertisementOuterClass$RequestGetAccountData advertisementOuterClass$RequestGetAccountData) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$RequestGetAccountData);
    }

    public static AdvertisementOuterClass$RequestGetAccountData parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetAccountData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetAccountData parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetAccountData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetAccountData parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$RequestGetAccountData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$RequestGetAccountData parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetAccountData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetAccountData parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$RequestGetAccountData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$RequestGetAccountData parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetAccountData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetAccountData parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestGetAccountData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestGetAccountData parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetAccountData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetAccountData parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$RequestGetAccountData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$RequestGetAccountData parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetAccountData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
