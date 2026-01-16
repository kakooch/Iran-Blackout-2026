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
public final class AdvertisementStruct$BaleAd extends GeneratedMessageLite implements U64 {
    private static final AdvertisementStruct$BaleAd DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PEER_UNIQUE_ID_FIELD_NUMBER = 1;
    private long peerUniqueId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementStruct$BaleAd.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementStruct$BaleAd advertisementStruct$BaleAd = new AdvertisementStruct$BaleAd();
        DEFAULT_INSTANCE = advertisementStruct$BaleAd;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementStruct$BaleAd.class, advertisementStruct$BaleAd);
    }

    private AdvertisementStruct$BaleAd() {
    }

    private void clearPeerUniqueId() {
        this.peerUniqueId_ = 0L;
    }

    public static AdvertisementStruct$BaleAd getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementStruct$BaleAd parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementStruct$BaleAd) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$BaleAd parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementStruct$BaleAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPeerUniqueId(long j) {
        this.peerUniqueId_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1843c.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementStruct$BaleAd();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0002", new Object[]{"peerUniqueId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementStruct$BaleAd.class) {
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

    public long getPeerUniqueId() {
        return this.peerUniqueId_;
    }

    public static a newBuilder(AdvertisementStruct$BaleAd advertisementStruct$BaleAd) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementStruct$BaleAd);
    }

    public static AdvertisementStruct$BaleAd parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$BaleAd) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$BaleAd parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementStruct$BaleAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementStruct$BaleAd parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementStruct$BaleAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementStruct$BaleAd parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementStruct$BaleAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementStruct$BaleAd parseFrom(byte[] bArr) {
        return (AdvertisementStruct$BaleAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementStruct$BaleAd parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementStruct$BaleAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementStruct$BaleAd parseFrom(InputStream inputStream) {
        return (AdvertisementStruct$BaleAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$BaleAd parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$BaleAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$BaleAd parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementStruct$BaleAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementStruct$BaleAd parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementStruct$BaleAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
