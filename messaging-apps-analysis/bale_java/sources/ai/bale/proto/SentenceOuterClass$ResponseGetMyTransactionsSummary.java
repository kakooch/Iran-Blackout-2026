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
public final class SentenceOuterClass$ResponseGetMyTransactionsSummary extends GeneratedMessageLite implements U64 {
    public static final int BUNDLES_AMOUNT_FIELD_NUMBER = 1;
    public static final int CHARGES_AMOUNT_FIELD_NUMBER = 2;
    private static final SentenceOuterClass$ResponseGetMyTransactionsSummary DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private int bundlesAmount_;
    private int chargesAmount_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SentenceOuterClass$ResponseGetMyTransactionsSummary.DEFAULT_INSTANCE);
        }
    }

    static {
        SentenceOuterClass$ResponseGetMyTransactionsSummary sentenceOuterClass$ResponseGetMyTransactionsSummary = new SentenceOuterClass$ResponseGetMyTransactionsSummary();
        DEFAULT_INSTANCE = sentenceOuterClass$ResponseGetMyTransactionsSummary;
        GeneratedMessageLite.registerDefaultInstance(SentenceOuterClass$ResponseGetMyTransactionsSummary.class, sentenceOuterClass$ResponseGetMyTransactionsSummary);
    }

    private SentenceOuterClass$ResponseGetMyTransactionsSummary() {
    }

    private void clearBundlesAmount() {
        this.bundlesAmount_ = 0;
    }

    private void clearChargesAmount() {
        this.chargesAmount_ = 0;
    }

    public static SentenceOuterClass$ResponseGetMyTransactionsSummary getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SentenceOuterClass$ResponseGetMyTransactionsSummary parseDelimitedFrom(InputStream inputStream) {
        return (SentenceOuterClass$ResponseGetMyTransactionsSummary) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SentenceOuterClass$ResponseGetMyTransactionsSummary parseFrom(ByteBuffer byteBuffer) {
        return (SentenceOuterClass$ResponseGetMyTransactionsSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBundlesAmount(int i) {
        this.bundlesAmount_ = i;
    }

    private void setChargesAmount(int i) {
        this.chargesAmount_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (R1.a[gVar.ordinal()]) {
            case 1:
                return new SentenceOuterClass$ResponseGetMyTransactionsSummary();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002\u0004", new Object[]{"bundlesAmount_", "chargesAmount_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SentenceOuterClass$ResponseGetMyTransactionsSummary.class) {
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

    public int getBundlesAmount() {
        return this.bundlesAmount_;
    }

    public int getChargesAmount() {
        return this.chargesAmount_;
    }

    public static a newBuilder(SentenceOuterClass$ResponseGetMyTransactionsSummary sentenceOuterClass$ResponseGetMyTransactionsSummary) {
        return (a) DEFAULT_INSTANCE.createBuilder(sentenceOuterClass$ResponseGetMyTransactionsSummary);
    }

    public static SentenceOuterClass$ResponseGetMyTransactionsSummary parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SentenceOuterClass$ResponseGetMyTransactionsSummary) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SentenceOuterClass$ResponseGetMyTransactionsSummary parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SentenceOuterClass$ResponseGetMyTransactionsSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SentenceOuterClass$ResponseGetMyTransactionsSummary parseFrom(AbstractC2383g abstractC2383g) {
        return (SentenceOuterClass$ResponseGetMyTransactionsSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SentenceOuterClass$ResponseGetMyTransactionsSummary parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SentenceOuterClass$ResponseGetMyTransactionsSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SentenceOuterClass$ResponseGetMyTransactionsSummary parseFrom(byte[] bArr) {
        return (SentenceOuterClass$ResponseGetMyTransactionsSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SentenceOuterClass$ResponseGetMyTransactionsSummary parseFrom(byte[] bArr, C2394s c2394s) {
        return (SentenceOuterClass$ResponseGetMyTransactionsSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SentenceOuterClass$ResponseGetMyTransactionsSummary parseFrom(InputStream inputStream) {
        return (SentenceOuterClass$ResponseGetMyTransactionsSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SentenceOuterClass$ResponseGetMyTransactionsSummary parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SentenceOuterClass$ResponseGetMyTransactionsSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SentenceOuterClass$ResponseGetMyTransactionsSummary parseFrom(AbstractC2384h abstractC2384h) {
        return (SentenceOuterClass$ResponseGetMyTransactionsSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SentenceOuterClass$ResponseGetMyTransactionsSummary parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SentenceOuterClass$ResponseGetMyTransactionsSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
