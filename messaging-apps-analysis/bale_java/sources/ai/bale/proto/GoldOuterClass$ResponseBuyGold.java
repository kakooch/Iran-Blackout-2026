package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class GoldOuterClass$ResponseBuyGold extends GeneratedMessageLite implements U64 {
    private static final GoldOuterClass$ResponseBuyGold DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TRANSACTION_ID_FIELD_NUMBER = 1;
    private String transactionId_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GoldOuterClass$ResponseBuyGold.DEFAULT_INSTANCE);
        }
    }

    static {
        GoldOuterClass$ResponseBuyGold goldOuterClass$ResponseBuyGold = new GoldOuterClass$ResponseBuyGold();
        DEFAULT_INSTANCE = goldOuterClass$ResponseBuyGold;
        GeneratedMessageLite.registerDefaultInstance(GoldOuterClass$ResponseBuyGold.class, goldOuterClass$ResponseBuyGold);
    }

    private GoldOuterClass$ResponseBuyGold() {
    }

    private void clearTransactionId() {
        this.transactionId_ = getDefaultInstance().getTransactionId();
    }

    public static GoldOuterClass$ResponseBuyGold getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GoldOuterClass$ResponseBuyGold parseDelimitedFrom(InputStream inputStream) {
        return (GoldOuterClass$ResponseBuyGold) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GoldOuterClass$ResponseBuyGold parseFrom(ByteBuffer byteBuffer) {
        return (GoldOuterClass$ResponseBuyGold) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setTransactionId(String str) {
        str.getClass();
        this.transactionId_ = str;
    }

    private void setTransactionIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.transactionId_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1871l0.a[gVar.ordinal()]) {
            case 1:
                return new GoldOuterClass$ResponseBuyGold();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"transactionId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GoldOuterClass$ResponseBuyGold.class) {
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

    public String getTransactionId() {
        return this.transactionId_;
    }

    public AbstractC2383g getTransactionIdBytes() {
        return AbstractC2383g.N(this.transactionId_);
    }

    public static a newBuilder(GoldOuterClass$ResponseBuyGold goldOuterClass$ResponseBuyGold) {
        return (a) DEFAULT_INSTANCE.createBuilder(goldOuterClass$ResponseBuyGold);
    }

    public static GoldOuterClass$ResponseBuyGold parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GoldOuterClass$ResponseBuyGold) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GoldOuterClass$ResponseBuyGold parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GoldOuterClass$ResponseBuyGold) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GoldOuterClass$ResponseBuyGold parseFrom(AbstractC2383g abstractC2383g) {
        return (GoldOuterClass$ResponseBuyGold) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GoldOuterClass$ResponseBuyGold parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GoldOuterClass$ResponseBuyGold) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GoldOuterClass$ResponseBuyGold parseFrom(byte[] bArr) {
        return (GoldOuterClass$ResponseBuyGold) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GoldOuterClass$ResponseBuyGold parseFrom(byte[] bArr, C2394s c2394s) {
        return (GoldOuterClass$ResponseBuyGold) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GoldOuterClass$ResponseBuyGold parseFrom(InputStream inputStream) {
        return (GoldOuterClass$ResponseBuyGold) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GoldOuterClass$ResponseBuyGold parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GoldOuterClass$ResponseBuyGold) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GoldOuterClass$ResponseBuyGold parseFrom(AbstractC2384h abstractC2384h) {
        return (GoldOuterClass$ResponseBuyGold) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GoldOuterClass$ResponseBuyGold parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GoldOuterClass$ResponseBuyGold) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
