package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class SentenceOuterClass$ResponseGetMyAwardsSummary extends GeneratedMessageLite implements U64 {
    private static final SentenceOuterClass$ResponseGetMyAwardsSummary DEFAULT_INSTANCE;
    public static final int NUMBER_OF_COINS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int RECEIVED_PACKET_AMOUNT_FIELD_NUMBER = 2;
    public static final int REMAINING_PACKET_AMOUNT_FIELD_NUMBER = 3;
    private int numberOfCoins_;
    private int receivedPacketAmount_;
    private int remainingPacketAmount_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SentenceOuterClass$ResponseGetMyAwardsSummary.DEFAULT_INSTANCE);
        }
    }

    static {
        SentenceOuterClass$ResponseGetMyAwardsSummary sentenceOuterClass$ResponseGetMyAwardsSummary = new SentenceOuterClass$ResponseGetMyAwardsSummary();
        DEFAULT_INSTANCE = sentenceOuterClass$ResponseGetMyAwardsSummary;
        GeneratedMessageLite.registerDefaultInstance(SentenceOuterClass$ResponseGetMyAwardsSummary.class, sentenceOuterClass$ResponseGetMyAwardsSummary);
    }

    private SentenceOuterClass$ResponseGetMyAwardsSummary() {
    }

    private void clearNumberOfCoins() {
        this.numberOfCoins_ = 0;
    }

    private void clearReceivedPacketAmount() {
        this.receivedPacketAmount_ = 0;
    }

    private void clearRemainingPacketAmount() {
        this.remainingPacketAmount_ = 0;
    }

    public static SentenceOuterClass$ResponseGetMyAwardsSummary getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SentenceOuterClass$ResponseGetMyAwardsSummary parseDelimitedFrom(InputStream inputStream) {
        return (SentenceOuterClass$ResponseGetMyAwardsSummary) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SentenceOuterClass$ResponseGetMyAwardsSummary parseFrom(ByteBuffer byteBuffer) {
        return (SentenceOuterClass$ResponseGetMyAwardsSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setNumberOfCoins(int i) {
        this.numberOfCoins_ = i;
    }

    private void setReceivedPacketAmount(int i) {
        this.receivedPacketAmount_ = i;
    }

    private void setRemainingPacketAmount(int i) {
        this.remainingPacketAmount_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (R1.a[gVar.ordinal()]) {
            case 1:
                return new SentenceOuterClass$ResponseGetMyAwardsSummary();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0002\u0004\u0003\u0004", new Object[]{"numberOfCoins_", "receivedPacketAmount_", "remainingPacketAmount_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SentenceOuterClass$ResponseGetMyAwardsSummary.class) {
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

    public int getNumberOfCoins() {
        return this.numberOfCoins_;
    }

    public int getReceivedPacketAmount() {
        return this.receivedPacketAmount_;
    }

    public int getRemainingPacketAmount() {
        return this.remainingPacketAmount_;
    }

    public static a newBuilder(SentenceOuterClass$ResponseGetMyAwardsSummary sentenceOuterClass$ResponseGetMyAwardsSummary) {
        return (a) DEFAULT_INSTANCE.createBuilder(sentenceOuterClass$ResponseGetMyAwardsSummary);
    }

    public static SentenceOuterClass$ResponseGetMyAwardsSummary parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SentenceOuterClass$ResponseGetMyAwardsSummary) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SentenceOuterClass$ResponseGetMyAwardsSummary parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SentenceOuterClass$ResponseGetMyAwardsSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SentenceOuterClass$ResponseGetMyAwardsSummary parseFrom(AbstractC2383g abstractC2383g) {
        return (SentenceOuterClass$ResponseGetMyAwardsSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SentenceOuterClass$ResponseGetMyAwardsSummary parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SentenceOuterClass$ResponseGetMyAwardsSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SentenceOuterClass$ResponseGetMyAwardsSummary parseFrom(byte[] bArr) {
        return (SentenceOuterClass$ResponseGetMyAwardsSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SentenceOuterClass$ResponseGetMyAwardsSummary parseFrom(byte[] bArr, C2394s c2394s) {
        return (SentenceOuterClass$ResponseGetMyAwardsSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SentenceOuterClass$ResponseGetMyAwardsSummary parseFrom(InputStream inputStream) {
        return (SentenceOuterClass$ResponseGetMyAwardsSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SentenceOuterClass$ResponseGetMyAwardsSummary parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SentenceOuterClass$ResponseGetMyAwardsSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SentenceOuterClass$ResponseGetMyAwardsSummary parseFrom(AbstractC2384h abstractC2384h) {
        return (SentenceOuterClass$ResponseGetMyAwardsSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SentenceOuterClass$ResponseGetMyAwardsSummary parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SentenceOuterClass$ResponseGetMyAwardsSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
