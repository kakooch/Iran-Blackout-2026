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
public final class SentenceOuterClass$RequestSendMyGiftPacket extends GeneratedMessageLite implements U64 {
    public static final int AMOUNT_FIELD_NUMBER = 1;
    private static final SentenceOuterClass$RequestSendMyGiftPacket DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private int amount_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SentenceOuterClass$RequestSendMyGiftPacket.DEFAULT_INSTANCE);
        }
    }

    static {
        SentenceOuterClass$RequestSendMyGiftPacket sentenceOuterClass$RequestSendMyGiftPacket = new SentenceOuterClass$RequestSendMyGiftPacket();
        DEFAULT_INSTANCE = sentenceOuterClass$RequestSendMyGiftPacket;
        GeneratedMessageLite.registerDefaultInstance(SentenceOuterClass$RequestSendMyGiftPacket.class, sentenceOuterClass$RequestSendMyGiftPacket);
    }

    private SentenceOuterClass$RequestSendMyGiftPacket() {
    }

    private void clearAmount() {
        this.amount_ = 0;
    }

    public static SentenceOuterClass$RequestSendMyGiftPacket getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SentenceOuterClass$RequestSendMyGiftPacket parseDelimitedFrom(InputStream inputStream) {
        return (SentenceOuterClass$RequestSendMyGiftPacket) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SentenceOuterClass$RequestSendMyGiftPacket parseFrom(ByteBuffer byteBuffer) {
        return (SentenceOuterClass$RequestSendMyGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAmount(int i) {
        this.amount_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (R1.a[gVar.ordinal()]) {
            case 1:
                return new SentenceOuterClass$RequestSendMyGiftPacket();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"amount_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SentenceOuterClass$RequestSendMyGiftPacket.class) {
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

    public int getAmount() {
        return this.amount_;
    }

    public static a newBuilder(SentenceOuterClass$RequestSendMyGiftPacket sentenceOuterClass$RequestSendMyGiftPacket) {
        return (a) DEFAULT_INSTANCE.createBuilder(sentenceOuterClass$RequestSendMyGiftPacket);
    }

    public static SentenceOuterClass$RequestSendMyGiftPacket parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SentenceOuterClass$RequestSendMyGiftPacket) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SentenceOuterClass$RequestSendMyGiftPacket parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SentenceOuterClass$RequestSendMyGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SentenceOuterClass$RequestSendMyGiftPacket parseFrom(AbstractC2383g abstractC2383g) {
        return (SentenceOuterClass$RequestSendMyGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SentenceOuterClass$RequestSendMyGiftPacket parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SentenceOuterClass$RequestSendMyGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SentenceOuterClass$RequestSendMyGiftPacket parseFrom(byte[] bArr) {
        return (SentenceOuterClass$RequestSendMyGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SentenceOuterClass$RequestSendMyGiftPacket parseFrom(byte[] bArr, C2394s c2394s) {
        return (SentenceOuterClass$RequestSendMyGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SentenceOuterClass$RequestSendMyGiftPacket parseFrom(InputStream inputStream) {
        return (SentenceOuterClass$RequestSendMyGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SentenceOuterClass$RequestSendMyGiftPacket parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SentenceOuterClass$RequestSendMyGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SentenceOuterClass$RequestSendMyGiftPacket parseFrom(AbstractC2384h abstractC2384h) {
        return (SentenceOuterClass$RequestSendMyGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SentenceOuterClass$RequestSendMyGiftPacket parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SentenceOuterClass$RequestSendMyGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
