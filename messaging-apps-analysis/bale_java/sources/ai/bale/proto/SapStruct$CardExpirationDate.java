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
public final class SapStruct$CardExpirationDate extends GeneratedMessageLite implements U64 {
    public static final int CARD_EXPIRATION_MONTH_FIELD_NUMBER = 1;
    public static final int CARD_EXPIRATION_YEAR_FIELD_NUMBER = 2;
    private static final SapStruct$CardExpirationDate DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private int cardExpirationMonth_;
    private int cardExpirationYear_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(int i) {
            q();
            ((SapStruct$CardExpirationDate) this.b).setCardExpirationMonth(i);
            return this;
        }

        public a B(int i) {
            q();
            ((SapStruct$CardExpirationDate) this.b).setCardExpirationYear(i);
            return this;
        }

        private a() {
            super(SapStruct$CardExpirationDate.DEFAULT_INSTANCE);
        }
    }

    static {
        SapStruct$CardExpirationDate sapStruct$CardExpirationDate = new SapStruct$CardExpirationDate();
        DEFAULT_INSTANCE = sapStruct$CardExpirationDate;
        GeneratedMessageLite.registerDefaultInstance(SapStruct$CardExpirationDate.class, sapStruct$CardExpirationDate);
    }

    private SapStruct$CardExpirationDate() {
    }

    private void clearCardExpirationMonth() {
        this.cardExpirationMonth_ = 0;
    }

    private void clearCardExpirationYear() {
        this.cardExpirationYear_ = 0;
    }

    public static SapStruct$CardExpirationDate getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SapStruct$CardExpirationDate parseDelimitedFrom(InputStream inputStream) {
        return (SapStruct$CardExpirationDate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SapStruct$CardExpirationDate parseFrom(ByteBuffer byteBuffer) {
        return (SapStruct$CardExpirationDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCardExpirationMonth(int i) {
        this.cardExpirationMonth_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCardExpirationYear(int i) {
        this.cardExpirationYear_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (I1.a[gVar.ordinal()]) {
            case 1:
                return new SapStruct$CardExpirationDate();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002\u0004", new Object[]{"cardExpirationMonth_", "cardExpirationYear_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SapStruct$CardExpirationDate.class) {
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

    public int getCardExpirationMonth() {
        return this.cardExpirationMonth_;
    }

    public int getCardExpirationYear() {
        return this.cardExpirationYear_;
    }

    public static a newBuilder(SapStruct$CardExpirationDate sapStruct$CardExpirationDate) {
        return (a) DEFAULT_INSTANCE.createBuilder(sapStruct$CardExpirationDate);
    }

    public static SapStruct$CardExpirationDate parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SapStruct$CardExpirationDate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SapStruct$CardExpirationDate parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SapStruct$CardExpirationDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SapStruct$CardExpirationDate parseFrom(AbstractC2383g abstractC2383g) {
        return (SapStruct$CardExpirationDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SapStruct$CardExpirationDate parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SapStruct$CardExpirationDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SapStruct$CardExpirationDate parseFrom(byte[] bArr) {
        return (SapStruct$CardExpirationDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SapStruct$CardExpirationDate parseFrom(byte[] bArr, C2394s c2394s) {
        return (SapStruct$CardExpirationDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SapStruct$CardExpirationDate parseFrom(InputStream inputStream) {
        return (SapStruct$CardExpirationDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SapStruct$CardExpirationDate parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SapStruct$CardExpirationDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SapStruct$CardExpirationDate parseFrom(AbstractC2384h abstractC2384h) {
        return (SapStruct$CardExpirationDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SapStruct$CardExpirationDate parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SapStruct$CardExpirationDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
