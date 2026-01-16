package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$BooleanValue;
import ai.bale.proto.SapStruct$CardInfo;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC7514Sa6;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class SapStruct$UserCard extends GeneratedMessageLite implements InterfaceC7514Sa6 {
    public static final int CARD_ID_FIELD_NUMBER = 1;
    public static final int CARD_INFO_FIELD_NUMBER = 2;
    private static final SapStruct$UserCard DEFAULT_INSTANCE;
    public static final int IS_ENROLLED_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private String cardId_ = "";
    private SapStruct$CardInfo cardInfo_;
    private CollectionsStruct$BooleanValue isEnrolled_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC7514Sa6 {
        private a() {
            super(SapStruct$UserCard.DEFAULT_INSTANCE);
        }
    }

    static {
        SapStruct$UserCard sapStruct$UserCard = new SapStruct$UserCard();
        DEFAULT_INSTANCE = sapStruct$UserCard;
        GeneratedMessageLite.registerDefaultInstance(SapStruct$UserCard.class, sapStruct$UserCard);
    }

    private SapStruct$UserCard() {
    }

    private void clearCardId() {
        this.cardId_ = getDefaultInstance().getCardId();
    }

    private void clearCardInfo() {
        this.cardInfo_ = null;
        this.bitField0_ &= -2;
    }

    private void clearIsEnrolled() {
        this.isEnrolled_ = null;
        this.bitField0_ &= -3;
    }

    public static SapStruct$UserCard getDefaultInstance() {
        return DEFAULT_INSTANCE;
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

    private void mergeIsEnrolled(CollectionsStruct$BooleanValue collectionsStruct$BooleanValue) {
        collectionsStruct$BooleanValue.getClass();
        CollectionsStruct$BooleanValue collectionsStruct$BooleanValue2 = this.isEnrolled_;
        if (collectionsStruct$BooleanValue2 == null || collectionsStruct$BooleanValue2 == CollectionsStruct$BooleanValue.getDefaultInstance()) {
            this.isEnrolled_ = collectionsStruct$BooleanValue;
        } else {
            this.isEnrolled_ = (CollectionsStruct$BooleanValue) ((CollectionsStruct$BooleanValue.a) CollectionsStruct$BooleanValue.newBuilder(this.isEnrolled_).v(collectionsStruct$BooleanValue)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SapStruct$UserCard parseDelimitedFrom(InputStream inputStream) {
        return (SapStruct$UserCard) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SapStruct$UserCard parseFrom(ByteBuffer byteBuffer) {
        return (SapStruct$UserCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCardId(String str) {
        str.getClass();
        this.cardId_ = str;
    }

    private void setCardIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.cardId_ = abstractC2383g.f0();
    }

    private void setCardInfo(SapStruct$CardInfo sapStruct$CardInfo) {
        sapStruct$CardInfo.getClass();
        this.cardInfo_ = sapStruct$CardInfo;
        this.bitField0_ |= 1;
    }

    private void setIsEnrolled(CollectionsStruct$BooleanValue collectionsStruct$BooleanValue) {
        collectionsStruct$BooleanValue.getClass();
        this.isEnrolled_ = collectionsStruct$BooleanValue;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (I1.a[gVar.ordinal()]) {
            case 1:
                return new SapStruct$UserCard();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000\u0003ဉ\u0001", new Object[]{"bitField0_", "cardId_", "cardInfo_", "isEnrolled_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SapStruct$UserCard.class) {
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

    public String getCardId() {
        return this.cardId_;
    }

    public AbstractC2383g getCardIdBytes() {
        return AbstractC2383g.N(this.cardId_);
    }

    public SapStruct$CardInfo getCardInfo() {
        SapStruct$CardInfo sapStruct$CardInfo = this.cardInfo_;
        return sapStruct$CardInfo == null ? SapStruct$CardInfo.getDefaultInstance() : sapStruct$CardInfo;
    }

    public CollectionsStruct$BooleanValue getIsEnrolled() {
        CollectionsStruct$BooleanValue collectionsStruct$BooleanValue = this.isEnrolled_;
        return collectionsStruct$BooleanValue == null ? CollectionsStruct$BooleanValue.getDefaultInstance() : collectionsStruct$BooleanValue;
    }

    public boolean hasCardInfo() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasIsEnrolled() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(SapStruct$UserCard sapStruct$UserCard) {
        return (a) DEFAULT_INSTANCE.createBuilder(sapStruct$UserCard);
    }

    public static SapStruct$UserCard parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SapStruct$UserCard) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SapStruct$UserCard parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SapStruct$UserCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SapStruct$UserCard parseFrom(AbstractC2383g abstractC2383g) {
        return (SapStruct$UserCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SapStruct$UserCard parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SapStruct$UserCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SapStruct$UserCard parseFrom(byte[] bArr) {
        return (SapStruct$UserCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SapStruct$UserCard parseFrom(byte[] bArr, C2394s c2394s) {
        return (SapStruct$UserCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SapStruct$UserCard parseFrom(InputStream inputStream) {
        return (SapStruct$UserCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SapStruct$UserCard parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SapStruct$UserCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SapStruct$UserCard parseFrom(AbstractC2384h abstractC2384h) {
        return (SapStruct$UserCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SapStruct$UserCard parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SapStruct$UserCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
