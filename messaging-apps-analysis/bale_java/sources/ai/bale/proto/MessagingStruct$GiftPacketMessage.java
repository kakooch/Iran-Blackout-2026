package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.BoolValue;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int32Value;
import com.google.protobuf.StringValue;
import ir.nasim.EnumC4424Fb4;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingStruct$GiftPacketMessage extends GeneratedMessageLite implements U64 {
    public static final int COVER_ID_FIELD_NUMBER = 7;
    private static final MessagingStruct$GiftPacketMessage DEFAULT_INSTANCE;
    public static final int GIFT_COUNT_FIELD_NUMBER = 1;
    public static final int GIVING_TYPE_FIELD_NUMBER = 3;
    public static final int OWNER_USER_ID_FIELD_NUMBER = 6;
    private static volatile KW4 PARSER = null;
    public static final int REGARDING_FIELD_NUMBER = 5;
    public static final int SHOW_TOTAL_AMOUNT_FIELD_NUMBER = 8;
    public static final int TOTAL_AMOUNT_FIELD_NUMBER = 2;
    public static final int WALLET_ID_FIELD_NUMBER = 4;
    private int bitField0_;
    private Int32Value coverId_;
    private int giftCount_;
    private int givingType_;
    private int ownerUserId_;
    private StringValue regarding_;
    private BoolValue showTotalAmount_;
    private long totalAmount_;
    private StringValue walletId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$GiftPacketMessage.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$GiftPacketMessage messagingStruct$GiftPacketMessage = new MessagingStruct$GiftPacketMessage();
        DEFAULT_INSTANCE = messagingStruct$GiftPacketMessage;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$GiftPacketMessage.class, messagingStruct$GiftPacketMessage);
    }

    private MessagingStruct$GiftPacketMessage() {
    }

    private void clearCoverId() {
        this.coverId_ = null;
        this.bitField0_ &= -5;
    }

    private void clearGiftCount() {
        this.giftCount_ = 0;
    }

    private void clearGivingType() {
        this.givingType_ = 0;
    }

    private void clearOwnerUserId() {
        this.ownerUserId_ = 0;
    }

    private void clearRegarding() {
        this.regarding_ = null;
        this.bitField0_ &= -3;
    }

    private void clearShowTotalAmount() {
        this.showTotalAmount_ = null;
        this.bitField0_ &= -9;
    }

    private void clearTotalAmount() {
        this.totalAmount_ = 0L;
    }

    private void clearWalletId() {
        this.walletId_ = null;
        this.bitField0_ &= -2;
    }

    public static MessagingStruct$GiftPacketMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeCoverId(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.coverId_;
        if (int32Value2 == null || int32Value2 == Int32Value.getDefaultInstance()) {
            this.coverId_ = int32Value;
        } else {
            this.coverId_ = (Int32Value) ((Int32Value.b) Int32Value.newBuilder(this.coverId_).v(int32Value)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeRegarding(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.regarding_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.regarding_ = stringValue;
        } else {
            this.regarding_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.regarding_).v(stringValue)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeShowTotalAmount(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.showTotalAmount_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.showTotalAmount_ = boolValue;
        } else {
            this.showTotalAmount_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.showTotalAmount_).v(boolValue)).j();
        }
        this.bitField0_ |= 8;
    }

    private void mergeWalletId(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.walletId_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.walletId_ = stringValue;
        } else {
            this.walletId_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.walletId_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$GiftPacketMessage parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$GiftPacketMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$GiftPacketMessage parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$GiftPacketMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCoverId(Int32Value int32Value) {
        int32Value.getClass();
        this.coverId_ = int32Value;
        this.bitField0_ |= 4;
    }

    private void setGiftCount(int i) {
        this.giftCount_ = i;
    }

    private void setGivingType(EnumC4424Fb4 enumC4424Fb4) {
        this.givingType_ = enumC4424Fb4.getNumber();
    }

    private void setGivingTypeValue(int i) {
        this.givingType_ = i;
    }

    private void setOwnerUserId(int i) {
        this.ownerUserId_ = i;
    }

    private void setRegarding(StringValue stringValue) {
        stringValue.getClass();
        this.regarding_ = stringValue;
        this.bitField0_ |= 2;
    }

    private void setShowTotalAmount(BoolValue boolValue) {
        boolValue.getClass();
        this.showTotalAmount_ = boolValue;
        this.bitField0_ |= 8;
    }

    private void setTotalAmount(long j) {
        this.totalAmount_ = j;
    }

    private void setWalletId(StringValue stringValue) {
        stringValue.getClass();
        this.walletId_ = stringValue;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$GiftPacketMessage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001\u0004\u0002\u0002\u0003\f\u0004ဉ\u0000\u0005ဉ\u0001\u0006\u0004\u0007ဉ\u0002\bဉ\u0003", new Object[]{"bitField0_", "giftCount_", "totalAmount_", "givingType_", "walletId_", "regarding_", "ownerUserId_", "coverId_", "showTotalAmount_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$GiftPacketMessage.class) {
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

    public Int32Value getCoverId() {
        Int32Value int32Value = this.coverId_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public int getGiftCount() {
        return this.giftCount_;
    }

    public EnumC4424Fb4 getGivingType() {
        EnumC4424Fb4 enumC4424Fb4J = EnumC4424Fb4.j(this.givingType_);
        return enumC4424Fb4J == null ? EnumC4424Fb4.UNRECOGNIZED : enumC4424Fb4J;
    }

    public int getGivingTypeValue() {
        return this.givingType_;
    }

    public int getOwnerUserId() {
        return this.ownerUserId_;
    }

    public StringValue getRegarding() {
        StringValue stringValue = this.regarding_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public BoolValue getShowTotalAmount() {
        BoolValue boolValue = this.showTotalAmount_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public long getTotalAmount() {
        return this.totalAmount_;
    }

    public StringValue getWalletId() {
        StringValue stringValue = this.walletId_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public boolean hasCoverId() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasRegarding() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasShowTotalAmount() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasWalletId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MessagingStruct$GiftPacketMessage messagingStruct$GiftPacketMessage) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$GiftPacketMessage);
    }

    public static MessagingStruct$GiftPacketMessage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$GiftPacketMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$GiftPacketMessage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$GiftPacketMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$GiftPacketMessage parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$GiftPacketMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$GiftPacketMessage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$GiftPacketMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$GiftPacketMessage parseFrom(byte[] bArr) {
        return (MessagingStruct$GiftPacketMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$GiftPacketMessage parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$GiftPacketMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$GiftPacketMessage parseFrom(InputStream inputStream) {
        return (MessagingStruct$GiftPacketMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$GiftPacketMessage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$GiftPacketMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$GiftPacketMessage parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$GiftPacketMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$GiftPacketMessage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$GiftPacketMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
