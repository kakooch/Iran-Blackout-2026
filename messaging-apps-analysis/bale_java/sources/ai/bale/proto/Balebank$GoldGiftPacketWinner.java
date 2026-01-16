package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC15705k20;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class Balebank$GoldGiftPacketWinner extends GeneratedMessageLite implements InterfaceC15705k20 {
    public static final int AMOUNT_FIELD_NUMBER = 2;
    private static final Balebank$GoldGiftPacketWinner DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int USER_IDS_FIELD_NUMBER = 1;
    private long amount_;
    private long userIds_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC15705k20 {
        private a() {
            super(Balebank$GoldGiftPacketWinner.DEFAULT_INSTANCE);
        }
    }

    static {
        Balebank$GoldGiftPacketWinner balebank$GoldGiftPacketWinner = new Balebank$GoldGiftPacketWinner();
        DEFAULT_INSTANCE = balebank$GoldGiftPacketWinner;
        GeneratedMessageLite.registerDefaultInstance(Balebank$GoldGiftPacketWinner.class, balebank$GoldGiftPacketWinner);
    }

    private Balebank$GoldGiftPacketWinner() {
    }

    private void clearAmount() {
        this.amount_ = 0L;
    }

    private void clearUserIds() {
        this.userIds_ = 0L;
    }

    public static Balebank$GoldGiftPacketWinner getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Balebank$GoldGiftPacketWinner parseDelimitedFrom(InputStream inputStream) {
        return (Balebank$GoldGiftPacketWinner) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Balebank$GoldGiftPacketWinner parseFrom(ByteBuffer byteBuffer) {
        return (Balebank$GoldGiftPacketWinner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAmount(long j) {
        this.amount_ = j;
    }

    private void setUserIds(long j) {
        this.userIds_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1873m.a[gVar.ordinal()]) {
            case 1:
                return new Balebank$GoldGiftPacketWinner();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0002", new Object[]{"userIds_", "amount_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Balebank$GoldGiftPacketWinner.class) {
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

    public long getAmount() {
        return this.amount_;
    }

    public long getUserIds() {
        return this.userIds_;
    }

    public static a newBuilder(Balebank$GoldGiftPacketWinner balebank$GoldGiftPacketWinner) {
        return (a) DEFAULT_INSTANCE.createBuilder(balebank$GoldGiftPacketWinner);
    }

    public static Balebank$GoldGiftPacketWinner parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Balebank$GoldGiftPacketWinner) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Balebank$GoldGiftPacketWinner parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Balebank$GoldGiftPacketWinner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Balebank$GoldGiftPacketWinner parseFrom(AbstractC2383g abstractC2383g) {
        return (Balebank$GoldGiftPacketWinner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Balebank$GoldGiftPacketWinner parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Balebank$GoldGiftPacketWinner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Balebank$GoldGiftPacketWinner parseFrom(byte[] bArr) {
        return (Balebank$GoldGiftPacketWinner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Balebank$GoldGiftPacketWinner parseFrom(byte[] bArr, C2394s c2394s) {
        return (Balebank$GoldGiftPacketWinner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Balebank$GoldGiftPacketWinner parseFrom(InputStream inputStream) {
        return (Balebank$GoldGiftPacketWinner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Balebank$GoldGiftPacketWinner parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Balebank$GoldGiftPacketWinner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Balebank$GoldGiftPacketWinner parseFrom(AbstractC2384h abstractC2384h) {
        return (Balebank$GoldGiftPacketWinner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Balebank$GoldGiftPacketWinner parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Balebank$GoldGiftPacketWinner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
