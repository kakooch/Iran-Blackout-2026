package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$StringValue;
import ai.bale.proto.SapStruct$CardInfo;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class SapOuterClass$RequestGetCardInfo extends GeneratedMessageLite implements U64 {
    public static final int CARD_ID_FIELD_NUMBER = 3;
    public static final int CARD_INFO_FIELD_NUMBER = 2;
    private static final SapOuterClass$RequestGetCardInfo DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TRANSACTION_ID_FIELD_NUMBER = 1;
    private int bitField0_;
    private CollectionsStruct$StringValue cardId_;
    private SapStruct$CardInfo cardInfo_;
    private String transactionId_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(CollectionsStruct$StringValue.a aVar) {
            q();
            ((SapOuterClass$RequestGetCardInfo) this.b).setCardId((CollectionsStruct$StringValue) aVar.a());
            return this;
        }

        public a B(String str) {
            q();
            ((SapOuterClass$RequestGetCardInfo) this.b).setTransactionId(str);
            return this;
        }

        private a() {
            super(SapOuterClass$RequestGetCardInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        SapOuterClass$RequestGetCardInfo sapOuterClass$RequestGetCardInfo = new SapOuterClass$RequestGetCardInfo();
        DEFAULT_INSTANCE = sapOuterClass$RequestGetCardInfo;
        GeneratedMessageLite.registerDefaultInstance(SapOuterClass$RequestGetCardInfo.class, sapOuterClass$RequestGetCardInfo);
    }

    private SapOuterClass$RequestGetCardInfo() {
    }

    private void clearCardId() {
        this.cardId_ = null;
        this.bitField0_ &= -3;
    }

    private void clearCardInfo() {
        this.cardInfo_ = null;
        this.bitField0_ &= -2;
    }

    private void clearTransactionId() {
        this.transactionId_ = getDefaultInstance().getTransactionId();
    }

    public static SapOuterClass$RequestGetCardInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeCardId(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        CollectionsStruct$StringValue collectionsStruct$StringValue2 = this.cardId_;
        if (collectionsStruct$StringValue2 == null || collectionsStruct$StringValue2 == CollectionsStruct$StringValue.getDefaultInstance()) {
            this.cardId_ = collectionsStruct$StringValue;
        } else {
            this.cardId_ = (CollectionsStruct$StringValue) ((CollectionsStruct$StringValue.a) CollectionsStruct$StringValue.newBuilder(this.cardId_).v(collectionsStruct$StringValue)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeCardInfo(SapStruct$CardInfo sapStruct$CardInfo) {
        sapStruct$CardInfo.getClass();
        SapStruct$CardInfo sapStruct$CardInfo2 = this.cardInfo_;
        if (sapStruct$CardInfo2 == null || sapStruct$CardInfo2 == SapStruct$CardInfo.getDefaultInstance()) {
            this.cardInfo_ = sapStruct$CardInfo;
        } else {
            this.cardInfo_ = (SapStruct$CardInfo) ((SapStruct$CardInfo.a) SapStruct$CardInfo.newBuilder(this.cardInfo_).v(sapStruct$CardInfo)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SapOuterClass$RequestGetCardInfo parseDelimitedFrom(InputStream inputStream) {
        return (SapOuterClass$RequestGetCardInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SapOuterClass$RequestGetCardInfo parseFrom(ByteBuffer byteBuffer) {
        return (SapOuterClass$RequestGetCardInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCardId(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        this.cardId_ = collectionsStruct$StringValue;
        this.bitField0_ |= 2;
    }

    private void setCardInfo(SapStruct$CardInfo sapStruct$CardInfo) {
        sapStruct$CardInfo.getClass();
        this.cardInfo_ = sapStruct$CardInfo;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTransactionId(String str) {
        str.getClass();
        this.transactionId_ = str;
    }

    private void setTransactionIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.transactionId_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (H1.a[gVar.ordinal()]) {
            case 1:
                return new SapOuterClass$RequestGetCardInfo();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000\u0003ဉ\u0001", new Object[]{"bitField0_", "transactionId_", "cardInfo_", "cardId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SapOuterClass$RequestGetCardInfo.class) {
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

    public CollectionsStruct$StringValue getCardId() {
        CollectionsStruct$StringValue collectionsStruct$StringValue = this.cardId_;
        return collectionsStruct$StringValue == null ? CollectionsStruct$StringValue.getDefaultInstance() : collectionsStruct$StringValue;
    }

    public SapStruct$CardInfo getCardInfo() {
        SapStruct$CardInfo sapStruct$CardInfo = this.cardInfo_;
        return sapStruct$CardInfo == null ? SapStruct$CardInfo.getDefaultInstance() : sapStruct$CardInfo;
    }

    public String getTransactionId() {
        return this.transactionId_;
    }

    public AbstractC2383g getTransactionIdBytes() {
        return AbstractC2383g.N(this.transactionId_);
    }

    public boolean hasCardId() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasCardInfo() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(SapOuterClass$RequestGetCardInfo sapOuterClass$RequestGetCardInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(sapOuterClass$RequestGetCardInfo);
    }

    public static SapOuterClass$RequestGetCardInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SapOuterClass$RequestGetCardInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SapOuterClass$RequestGetCardInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SapOuterClass$RequestGetCardInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SapOuterClass$RequestGetCardInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (SapOuterClass$RequestGetCardInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SapOuterClass$RequestGetCardInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SapOuterClass$RequestGetCardInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SapOuterClass$RequestGetCardInfo parseFrom(byte[] bArr) {
        return (SapOuterClass$RequestGetCardInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SapOuterClass$RequestGetCardInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (SapOuterClass$RequestGetCardInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SapOuterClass$RequestGetCardInfo parseFrom(InputStream inputStream) {
        return (SapOuterClass$RequestGetCardInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SapOuterClass$RequestGetCardInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SapOuterClass$RequestGetCardInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SapOuterClass$RequestGetCardInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (SapOuterClass$RequestGetCardInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SapOuterClass$RequestGetCardInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SapOuterClass$RequestGetCardInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
