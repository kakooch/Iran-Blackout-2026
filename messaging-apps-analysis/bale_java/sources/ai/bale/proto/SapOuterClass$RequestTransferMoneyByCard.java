package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int32Value;
import ai.bale.proto.CollectionsStruct$StringValue;
import ai.bale.proto.MessagingStruct$HistoryMessageIdentifier;
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
public final class SapOuterClass$RequestTransferMoneyByCard extends GeneratedMessageLite implements U64 {
    public static final int AMOUNT_FIELD_NUMBER = 4;
    public static final int APPROVAL_CODE_FIELD_NUMBER = 10;
    public static final int CARD_ID_FIELD_NUMBER = 1;
    public static final int CVV2_FIELD_NUMBER = 6;
    private static final SapOuterClass$RequestTransferMoneyByCard DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 14;
    public static final int DESTINATION_PAN_FIELD_NUMBER = 3;
    public static final int ENCRYPTED_TRANSFER_INFO_FIELD_NUMBER = 11;
    public static final int EXPIRYDATE_FIELD_NUMBER = 7;
    public static final int LOCALIZE_FIELD_NUMBER = 9;
    public static final int MESSAGE_DATA_FIELD_NUMBER = 12;
    private static volatile KW4 PARSER = null;
    public static final int PIN_FIELD_NUMBER = 5;
    public static final int RAMZ_TOKEN_FIELD_NUMBER = 15;
    public static final int SOURCE_ADDRESS_FIELD_NUMBER = 8;
    public static final int TARGET_USER_ID_FIELD_NUMBER = 13;
    public static final int TRANSFER_CODE_FIELD_NUMBER = 2;
    private int amount_;
    private int bitField0_;
    private CollectionsStruct$StringValue description_;
    private CollectionsStruct$StringValue encryptedTransferInfo_;
    private int localize_;
    private MessagingStruct$HistoryMessageIdentifier messageData_;
    private CollectionsStruct$StringValue ramzToken_;
    private CollectionsStruct$Int32Value targetUserId_;
    private long transferCode_;
    private String cardId_ = "";
    private String destinationPan_ = "";
    private String pin_ = "";
    private String cvv2_ = "";
    private String expiryDate_ = "";
    private String sourceAddress_ = "";
    private String approvalCode_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(int i) {
            q();
            ((SapOuterClass$RequestTransferMoneyByCard) this.b).setAmount(i);
            return this;
        }

        public a B(String str) {
            q();
            ((SapOuterClass$RequestTransferMoneyByCard) this.b).setApprovalCode(str);
            return this;
        }

        public a C(String str) {
            q();
            ((SapOuterClass$RequestTransferMoneyByCard) this.b).setCardId(str);
            return this;
        }

        public a D(CollectionsStruct$StringValue.a aVar) {
            q();
            ((SapOuterClass$RequestTransferMoneyByCard) this.b).setDescription((CollectionsStruct$StringValue) aVar.a());
            return this;
        }

        public a E(String str) {
            q();
            ((SapOuterClass$RequestTransferMoneyByCard) this.b).setDestinationPan(str);
            return this;
        }

        public a F(CollectionsStruct$StringValue collectionsStruct$StringValue) {
            q();
            ((SapOuterClass$RequestTransferMoneyByCard) this.b).setEncryptedTransferInfo(collectionsStruct$StringValue);
            return this;
        }

        public a G(MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier) {
            q();
            ((SapOuterClass$RequestTransferMoneyByCard) this.b).setMessageData(messagingStruct$HistoryMessageIdentifier);
            return this;
        }

        public a H(CollectionsStruct$StringValue.a aVar) {
            q();
            ((SapOuterClass$RequestTransferMoneyByCard) this.b).setRamzToken((CollectionsStruct$StringValue) aVar.a());
            return this;
        }

        public a I(CollectionsStruct$Int32Value collectionsStruct$Int32Value) {
            q();
            ((SapOuterClass$RequestTransferMoneyByCard) this.b).setTargetUserId(collectionsStruct$Int32Value);
            return this;
        }

        private a() {
            super(SapOuterClass$RequestTransferMoneyByCard.DEFAULT_INSTANCE);
        }
    }

    static {
        SapOuterClass$RequestTransferMoneyByCard sapOuterClass$RequestTransferMoneyByCard = new SapOuterClass$RequestTransferMoneyByCard();
        DEFAULT_INSTANCE = sapOuterClass$RequestTransferMoneyByCard;
        GeneratedMessageLite.registerDefaultInstance(SapOuterClass$RequestTransferMoneyByCard.class, sapOuterClass$RequestTransferMoneyByCard);
    }

    private SapOuterClass$RequestTransferMoneyByCard() {
    }

    private void clearAmount() {
        this.amount_ = 0;
    }

    private void clearApprovalCode() {
        this.approvalCode_ = getDefaultInstance().getApprovalCode();
    }

    private void clearCardId() {
        this.cardId_ = getDefaultInstance().getCardId();
    }

    private void clearCvv2() {
        this.cvv2_ = getDefaultInstance().getCvv2();
    }

    private void clearDescription() {
        this.description_ = null;
        this.bitField0_ &= -9;
    }

    private void clearDestinationPan() {
        this.destinationPan_ = getDefaultInstance().getDestinationPan();
    }

    private void clearEncryptedTransferInfo() {
        this.encryptedTransferInfo_ = null;
        this.bitField0_ &= -2;
    }

    private void clearExpiryDate() {
        this.expiryDate_ = getDefaultInstance().getExpiryDate();
    }

    private void clearLocalize() {
        this.localize_ = 0;
    }

    private void clearMessageData() {
        this.messageData_ = null;
        this.bitField0_ &= -3;
    }

    private void clearPin() {
        this.pin_ = getDefaultInstance().getPin();
    }

    private void clearRamzToken() {
        this.ramzToken_ = null;
        this.bitField0_ &= -17;
    }

    private void clearSourceAddress() {
        this.sourceAddress_ = getDefaultInstance().getSourceAddress();
    }

    private void clearTargetUserId() {
        this.targetUserId_ = null;
        this.bitField0_ &= -5;
    }

    private void clearTransferCode() {
        this.transferCode_ = 0L;
    }

    public static SapOuterClass$RequestTransferMoneyByCard getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeDescription(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        CollectionsStruct$StringValue collectionsStruct$StringValue2 = this.description_;
        if (collectionsStruct$StringValue2 == null || collectionsStruct$StringValue2 == CollectionsStruct$StringValue.getDefaultInstance()) {
            this.description_ = collectionsStruct$StringValue;
        } else {
            this.description_ = (CollectionsStruct$StringValue) ((CollectionsStruct$StringValue.a) CollectionsStruct$StringValue.newBuilder(this.description_).v(collectionsStruct$StringValue)).j();
        }
        this.bitField0_ |= 8;
    }

    private void mergeEncryptedTransferInfo(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        CollectionsStruct$StringValue collectionsStruct$StringValue2 = this.encryptedTransferInfo_;
        if (collectionsStruct$StringValue2 == null || collectionsStruct$StringValue2 == CollectionsStruct$StringValue.getDefaultInstance()) {
            this.encryptedTransferInfo_ = collectionsStruct$StringValue;
        } else {
            this.encryptedTransferInfo_ = (CollectionsStruct$StringValue) ((CollectionsStruct$StringValue.a) CollectionsStruct$StringValue.newBuilder(this.encryptedTransferInfo_).v(collectionsStruct$StringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeMessageData(MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier) {
        messagingStruct$HistoryMessageIdentifier.getClass();
        MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier2 = this.messageData_;
        if (messagingStruct$HistoryMessageIdentifier2 == null || messagingStruct$HistoryMessageIdentifier2 == MessagingStruct$HistoryMessageIdentifier.getDefaultInstance()) {
            this.messageData_ = messagingStruct$HistoryMessageIdentifier;
        } else {
            this.messageData_ = (MessagingStruct$HistoryMessageIdentifier) ((MessagingStruct$HistoryMessageIdentifier.a) MessagingStruct$HistoryMessageIdentifier.newBuilder(this.messageData_).v(messagingStruct$HistoryMessageIdentifier)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeRamzToken(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        CollectionsStruct$StringValue collectionsStruct$StringValue2 = this.ramzToken_;
        if (collectionsStruct$StringValue2 == null || collectionsStruct$StringValue2 == CollectionsStruct$StringValue.getDefaultInstance()) {
            this.ramzToken_ = collectionsStruct$StringValue;
        } else {
            this.ramzToken_ = (CollectionsStruct$StringValue) ((CollectionsStruct$StringValue.a) CollectionsStruct$StringValue.newBuilder(this.ramzToken_).v(collectionsStruct$StringValue)).j();
        }
        this.bitField0_ |= 16;
    }

    private void mergeTargetUserId(CollectionsStruct$Int32Value collectionsStruct$Int32Value) {
        collectionsStruct$Int32Value.getClass();
        CollectionsStruct$Int32Value collectionsStruct$Int32Value2 = this.targetUserId_;
        if (collectionsStruct$Int32Value2 == null || collectionsStruct$Int32Value2 == CollectionsStruct$Int32Value.getDefaultInstance()) {
            this.targetUserId_ = collectionsStruct$Int32Value;
        } else {
            this.targetUserId_ = (CollectionsStruct$Int32Value) ((CollectionsStruct$Int32Value.a) CollectionsStruct$Int32Value.newBuilder(this.targetUserId_).v(collectionsStruct$Int32Value)).j();
        }
        this.bitField0_ |= 4;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SapOuterClass$RequestTransferMoneyByCard parseDelimitedFrom(InputStream inputStream) {
        return (SapOuterClass$RequestTransferMoneyByCard) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SapOuterClass$RequestTransferMoneyByCard parseFrom(ByteBuffer byteBuffer) {
        return (SapOuterClass$RequestTransferMoneyByCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAmount(int i) {
        this.amount_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setApprovalCode(String str) {
        str.getClass();
        this.approvalCode_ = str;
    }

    private void setApprovalCodeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.approvalCode_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCardId(String str) {
        str.getClass();
        this.cardId_ = str;
    }

    private void setCardIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.cardId_ = abstractC2383g.f0();
    }

    private void setCvv2(String str) {
        str.getClass();
        this.cvv2_ = str;
    }

    private void setCvv2Bytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.cvv2_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDescription(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        this.description_ = collectionsStruct$StringValue;
        this.bitField0_ |= 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDestinationPan(String str) {
        str.getClass();
        this.destinationPan_ = str;
    }

    private void setDestinationPanBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.destinationPan_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEncryptedTransferInfo(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        this.encryptedTransferInfo_ = collectionsStruct$StringValue;
        this.bitField0_ |= 1;
    }

    private void setExpiryDate(String str) {
        str.getClass();
        this.expiryDate_ = str;
    }

    private void setExpiryDateBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.expiryDate_ = abstractC2383g.f0();
    }

    private void setLocalize(int i) {
        this.localize_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMessageData(MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier) {
        messagingStruct$HistoryMessageIdentifier.getClass();
        this.messageData_ = messagingStruct$HistoryMessageIdentifier;
        this.bitField0_ |= 2;
    }

    private void setPin(String str) {
        str.getClass();
        this.pin_ = str;
    }

    private void setPinBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.pin_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRamzToken(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        this.ramzToken_ = collectionsStruct$StringValue;
        this.bitField0_ |= 16;
    }

    private void setSourceAddress(String str) {
        str.getClass();
        this.sourceAddress_ = str;
    }

    private void setSourceAddressBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.sourceAddress_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTargetUserId(CollectionsStruct$Int32Value collectionsStruct$Int32Value) {
        collectionsStruct$Int32Value.getClass();
        this.targetUserId_ = collectionsStruct$Int32Value;
        this.bitField0_ |= 4;
    }

    private void setTransferCode(long j) {
        this.transferCode_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (H1.a[gVar.ordinal()]) {
            case 1:
                return new SapOuterClass$RequestTransferMoneyByCard();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u000f\u0000\u0001\u0001\u000f\u000f\u0000\u0000\u0000\u0001Ȉ\u0002\u0002\u0003Ȉ\u0004\u0004\u0005Ȉ\u0006Ȉ\u0007Ȉ\bȈ\t\u0004\nȈ\u000bဉ\u0000\fဉ\u0001\rဉ\u0002\u000eဉ\u0003\u000fဉ\u0004", new Object[]{"bitField0_", "cardId_", "transferCode_", "destinationPan_", "amount_", "pin_", "cvv2_", "expiryDate_", "sourceAddress_", "localize_", "approvalCode_", "encryptedTransferInfo_", "messageData_", "targetUserId_", "description_", "ramzToken_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SapOuterClass$RequestTransferMoneyByCard.class) {
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

    public String getApprovalCode() {
        return this.approvalCode_;
    }

    public AbstractC2383g getApprovalCodeBytes() {
        return AbstractC2383g.N(this.approvalCode_);
    }

    public String getCardId() {
        return this.cardId_;
    }

    public AbstractC2383g getCardIdBytes() {
        return AbstractC2383g.N(this.cardId_);
    }

    public String getCvv2() {
        return this.cvv2_;
    }

    public AbstractC2383g getCvv2Bytes() {
        return AbstractC2383g.N(this.cvv2_);
    }

    public CollectionsStruct$StringValue getDescription() {
        CollectionsStruct$StringValue collectionsStruct$StringValue = this.description_;
        return collectionsStruct$StringValue == null ? CollectionsStruct$StringValue.getDefaultInstance() : collectionsStruct$StringValue;
    }

    public String getDestinationPan() {
        return this.destinationPan_;
    }

    public AbstractC2383g getDestinationPanBytes() {
        return AbstractC2383g.N(this.destinationPan_);
    }

    public CollectionsStruct$StringValue getEncryptedTransferInfo() {
        CollectionsStruct$StringValue collectionsStruct$StringValue = this.encryptedTransferInfo_;
        return collectionsStruct$StringValue == null ? CollectionsStruct$StringValue.getDefaultInstance() : collectionsStruct$StringValue;
    }

    public String getExpiryDate() {
        return this.expiryDate_;
    }

    public AbstractC2383g getExpiryDateBytes() {
        return AbstractC2383g.N(this.expiryDate_);
    }

    public int getLocalize() {
        return this.localize_;
    }

    public MessagingStruct$HistoryMessageIdentifier getMessageData() {
        MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier = this.messageData_;
        return messagingStruct$HistoryMessageIdentifier == null ? MessagingStruct$HistoryMessageIdentifier.getDefaultInstance() : messagingStruct$HistoryMessageIdentifier;
    }

    public String getPin() {
        return this.pin_;
    }

    public AbstractC2383g getPinBytes() {
        return AbstractC2383g.N(this.pin_);
    }

    public CollectionsStruct$StringValue getRamzToken() {
        CollectionsStruct$StringValue collectionsStruct$StringValue = this.ramzToken_;
        return collectionsStruct$StringValue == null ? CollectionsStruct$StringValue.getDefaultInstance() : collectionsStruct$StringValue;
    }

    public String getSourceAddress() {
        return this.sourceAddress_;
    }

    public AbstractC2383g getSourceAddressBytes() {
        return AbstractC2383g.N(this.sourceAddress_);
    }

    public CollectionsStruct$Int32Value getTargetUserId() {
        CollectionsStruct$Int32Value collectionsStruct$Int32Value = this.targetUserId_;
        return collectionsStruct$Int32Value == null ? CollectionsStruct$Int32Value.getDefaultInstance() : collectionsStruct$Int32Value;
    }

    public long getTransferCode() {
        return this.transferCode_;
    }

    public boolean hasDescription() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasEncryptedTransferInfo() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasMessageData() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasRamzToken() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasTargetUserId() {
        return (this.bitField0_ & 4) != 0;
    }

    public static a newBuilder(SapOuterClass$RequestTransferMoneyByCard sapOuterClass$RequestTransferMoneyByCard) {
        return (a) DEFAULT_INSTANCE.createBuilder(sapOuterClass$RequestTransferMoneyByCard);
    }

    public static SapOuterClass$RequestTransferMoneyByCard parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SapOuterClass$RequestTransferMoneyByCard) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SapOuterClass$RequestTransferMoneyByCard parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SapOuterClass$RequestTransferMoneyByCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SapOuterClass$RequestTransferMoneyByCard parseFrom(AbstractC2383g abstractC2383g) {
        return (SapOuterClass$RequestTransferMoneyByCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SapOuterClass$RequestTransferMoneyByCard parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SapOuterClass$RequestTransferMoneyByCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SapOuterClass$RequestTransferMoneyByCard parseFrom(byte[] bArr) {
        return (SapOuterClass$RequestTransferMoneyByCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SapOuterClass$RequestTransferMoneyByCard parseFrom(byte[] bArr, C2394s c2394s) {
        return (SapOuterClass$RequestTransferMoneyByCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SapOuterClass$RequestTransferMoneyByCard parseFrom(InputStream inputStream) {
        return (SapOuterClass$RequestTransferMoneyByCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SapOuterClass$RequestTransferMoneyByCard parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SapOuterClass$RequestTransferMoneyByCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SapOuterClass$RequestTransferMoneyByCard parseFrom(AbstractC2384h abstractC2384h) {
        return (SapOuterClass$RequestTransferMoneyByCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SapOuterClass$RequestTransferMoneyByCard parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SapOuterClass$RequestTransferMoneyByCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
