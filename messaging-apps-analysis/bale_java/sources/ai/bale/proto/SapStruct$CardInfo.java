package ai.bale.proto;

import ai.bale.proto.SapStruct$CardExpirationDate;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC6563Oa6;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class SapStruct$CardInfo extends GeneratedMessageLite implements InterfaceC6563Oa6 {
    public static final int CARD_EXP_DATE_FIELD_NUMBER = 2;
    public static final int CARD_NUMBER_FIELD_NUMBER = 1;
    private static final SapStruct$CardInfo DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private SapStruct$CardExpirationDate cardExpDate_;
    private String cardNumber_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC6563Oa6 {
        public a A(SapStruct$CardExpirationDate.a aVar) {
            q();
            ((SapStruct$CardInfo) this.b).setCardExpDate((SapStruct$CardExpirationDate) aVar.a());
            return this;
        }

        public a B(SapStruct$CardExpirationDate sapStruct$CardExpirationDate) {
            q();
            ((SapStruct$CardInfo) this.b).setCardExpDate(sapStruct$CardExpirationDate);
            return this;
        }

        public a C(String str) {
            q();
            ((SapStruct$CardInfo) this.b).setCardNumber(str);
            return this;
        }

        private a() {
            super(SapStruct$CardInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        SapStruct$CardInfo sapStruct$CardInfo = new SapStruct$CardInfo();
        DEFAULT_INSTANCE = sapStruct$CardInfo;
        GeneratedMessageLite.registerDefaultInstance(SapStruct$CardInfo.class, sapStruct$CardInfo);
    }

    private SapStruct$CardInfo() {
    }

    private void clearCardExpDate() {
        this.cardExpDate_ = null;
        this.bitField0_ &= -2;
    }

    private void clearCardNumber() {
        this.cardNumber_ = getDefaultInstance().getCardNumber();
    }

    public static SapStruct$CardInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeCardExpDate(SapStruct$CardExpirationDate sapStruct$CardExpirationDate) {
        sapStruct$CardExpirationDate.getClass();
        SapStruct$CardExpirationDate sapStruct$CardExpirationDate2 = this.cardExpDate_;
        if (sapStruct$CardExpirationDate2 == null || sapStruct$CardExpirationDate2 == SapStruct$CardExpirationDate.getDefaultInstance()) {
            this.cardExpDate_ = sapStruct$CardExpirationDate;
        } else {
            this.cardExpDate_ = (SapStruct$CardExpirationDate) ((SapStruct$CardExpirationDate.a) SapStruct$CardExpirationDate.newBuilder(this.cardExpDate_).v(sapStruct$CardExpirationDate)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SapStruct$CardInfo parseDelimitedFrom(InputStream inputStream) {
        return (SapStruct$CardInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SapStruct$CardInfo parseFrom(ByteBuffer byteBuffer) {
        return (SapStruct$CardInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCardExpDate(SapStruct$CardExpirationDate sapStruct$CardExpirationDate) {
        sapStruct$CardExpirationDate.getClass();
        this.cardExpDate_ = sapStruct$CardExpirationDate;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCardNumber(String str) {
        str.getClass();
        this.cardNumber_ = str;
    }

    private void setCardNumberBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.cardNumber_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (I1.a[gVar.ordinal()]) {
            case 1:
                return new SapStruct$CardInfo();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000", new Object[]{"bitField0_", "cardNumber_", "cardExpDate_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SapStruct$CardInfo.class) {
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

    public SapStruct$CardExpirationDate getCardExpDate() {
        SapStruct$CardExpirationDate sapStruct$CardExpirationDate = this.cardExpDate_;
        return sapStruct$CardExpirationDate == null ? SapStruct$CardExpirationDate.getDefaultInstance() : sapStruct$CardExpirationDate;
    }

    public String getCardNumber() {
        return this.cardNumber_;
    }

    public AbstractC2383g getCardNumberBytes() {
        return AbstractC2383g.N(this.cardNumber_);
    }

    public boolean hasCardExpDate() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(SapStruct$CardInfo sapStruct$CardInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(sapStruct$CardInfo);
    }

    public static SapStruct$CardInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SapStruct$CardInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SapStruct$CardInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SapStruct$CardInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SapStruct$CardInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (SapStruct$CardInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SapStruct$CardInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SapStruct$CardInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SapStruct$CardInfo parseFrom(byte[] bArr) {
        return (SapStruct$CardInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SapStruct$CardInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (SapStruct$CardInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SapStruct$CardInfo parseFrom(InputStream inputStream) {
        return (SapStruct$CardInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SapStruct$CardInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SapStruct$CardInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SapStruct$CardInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (SapStruct$CardInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SapStruct$CardInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SapStruct$CardInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
