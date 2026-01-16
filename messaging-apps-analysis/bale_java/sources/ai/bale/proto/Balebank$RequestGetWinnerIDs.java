package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class Balebank$RequestGetWinnerIDs extends GeneratedMessageLite implements U64 {
    private static final Balebank$RequestGetWinnerIDs DEFAULT_INSTANCE;
    public static final int GIFT_PACKET_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private long giftPacketId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Balebank$RequestGetWinnerIDs.DEFAULT_INSTANCE);
        }
    }

    static {
        Balebank$RequestGetWinnerIDs balebank$RequestGetWinnerIDs = new Balebank$RequestGetWinnerIDs();
        DEFAULT_INSTANCE = balebank$RequestGetWinnerIDs;
        GeneratedMessageLite.registerDefaultInstance(Balebank$RequestGetWinnerIDs.class, balebank$RequestGetWinnerIDs);
    }

    private Balebank$RequestGetWinnerIDs() {
    }

    private void clearGiftPacketId() {
        this.giftPacketId_ = 0L;
    }

    public static Balebank$RequestGetWinnerIDs getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Balebank$RequestGetWinnerIDs parseDelimitedFrom(InputStream inputStream) {
        return (Balebank$RequestGetWinnerIDs) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Balebank$RequestGetWinnerIDs parseFrom(ByteBuffer byteBuffer) {
        return (Balebank$RequestGetWinnerIDs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setGiftPacketId(long j) {
        this.giftPacketId_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1873m.a[gVar.ordinal()]) {
            case 1:
                return new Balebank$RequestGetWinnerIDs();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0002", new Object[]{"giftPacketId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Balebank$RequestGetWinnerIDs.class) {
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

    public long getGiftPacketId() {
        return this.giftPacketId_;
    }

    public static a newBuilder(Balebank$RequestGetWinnerIDs balebank$RequestGetWinnerIDs) {
        return (a) DEFAULT_INSTANCE.createBuilder(balebank$RequestGetWinnerIDs);
    }

    public static Balebank$RequestGetWinnerIDs parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Balebank$RequestGetWinnerIDs) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Balebank$RequestGetWinnerIDs parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Balebank$RequestGetWinnerIDs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Balebank$RequestGetWinnerIDs parseFrom(AbstractC2383g abstractC2383g) {
        return (Balebank$RequestGetWinnerIDs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Balebank$RequestGetWinnerIDs parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Balebank$RequestGetWinnerIDs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Balebank$RequestGetWinnerIDs parseFrom(byte[] bArr) {
        return (Balebank$RequestGetWinnerIDs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Balebank$RequestGetWinnerIDs parseFrom(byte[] bArr, C2394s c2394s) {
        return (Balebank$RequestGetWinnerIDs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Balebank$RequestGetWinnerIDs parseFrom(InputStream inputStream) {
        return (Balebank$RequestGetWinnerIDs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Balebank$RequestGetWinnerIDs parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Balebank$RequestGetWinnerIDs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Balebank$RequestGetWinnerIDs parseFrom(AbstractC2384h abstractC2384h) {
        return (Balebank$RequestGetWinnerIDs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Balebank$RequestGetWinnerIDs parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Balebank$RequestGetWinnerIDs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
