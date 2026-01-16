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
public final class Balebank$RequestOpenGoldGiftPacket extends GeneratedMessageLite implements U64 {
    private static final Balebank$RequestOpenGoldGiftPacket DEFAULT_INSTANCE;
    public static final int GIFT_PACKET_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private long giftPacketId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(long j) {
            q();
            ((Balebank$RequestOpenGoldGiftPacket) this.b).setGiftPacketId(j);
            return this;
        }

        private a() {
            super(Balebank$RequestOpenGoldGiftPacket.DEFAULT_INSTANCE);
        }
    }

    static {
        Balebank$RequestOpenGoldGiftPacket balebank$RequestOpenGoldGiftPacket = new Balebank$RequestOpenGoldGiftPacket();
        DEFAULT_INSTANCE = balebank$RequestOpenGoldGiftPacket;
        GeneratedMessageLite.registerDefaultInstance(Balebank$RequestOpenGoldGiftPacket.class, balebank$RequestOpenGoldGiftPacket);
    }

    private Balebank$RequestOpenGoldGiftPacket() {
    }

    private void clearGiftPacketId() {
        this.giftPacketId_ = 0L;
    }

    public static Balebank$RequestOpenGoldGiftPacket getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Balebank$RequestOpenGoldGiftPacket parseDelimitedFrom(InputStream inputStream) {
        return (Balebank$RequestOpenGoldGiftPacket) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Balebank$RequestOpenGoldGiftPacket parseFrom(ByteBuffer byteBuffer) {
        return (Balebank$RequestOpenGoldGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGiftPacketId(long j) {
        this.giftPacketId_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1873m.a[gVar.ordinal()]) {
            case 1:
                return new Balebank$RequestOpenGoldGiftPacket();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0002", new Object[]{"giftPacketId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Balebank$RequestOpenGoldGiftPacket.class) {
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

    public static a newBuilder(Balebank$RequestOpenGoldGiftPacket balebank$RequestOpenGoldGiftPacket) {
        return (a) DEFAULT_INSTANCE.createBuilder(balebank$RequestOpenGoldGiftPacket);
    }

    public static Balebank$RequestOpenGoldGiftPacket parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Balebank$RequestOpenGoldGiftPacket) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Balebank$RequestOpenGoldGiftPacket parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Balebank$RequestOpenGoldGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Balebank$RequestOpenGoldGiftPacket parseFrom(AbstractC2383g abstractC2383g) {
        return (Balebank$RequestOpenGoldGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Balebank$RequestOpenGoldGiftPacket parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Balebank$RequestOpenGoldGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Balebank$RequestOpenGoldGiftPacket parseFrom(byte[] bArr) {
        return (Balebank$RequestOpenGoldGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Balebank$RequestOpenGoldGiftPacket parseFrom(byte[] bArr, C2394s c2394s) {
        return (Balebank$RequestOpenGoldGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Balebank$RequestOpenGoldGiftPacket parseFrom(InputStream inputStream) {
        return (Balebank$RequestOpenGoldGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Balebank$RequestOpenGoldGiftPacket parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Balebank$RequestOpenGoldGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Balebank$RequestOpenGoldGiftPacket parseFrom(AbstractC2384h abstractC2384h) {
        return (Balebank$RequestOpenGoldGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Balebank$RequestOpenGoldGiftPacket parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Balebank$RequestOpenGoldGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
