package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int32Value;
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
public final class SapOuterClass$RequestGetDestinationCardInfo extends GeneratedMessageLite implements U64 {
    public static final int AMOUNT_FIELD_NUMBER = 3;
    public static final int CARD_ID_FIELD_NUMBER = 1;
    private static final SapOuterClass$RequestGetDestinationCardInfo DEFAULT_INSTANCE;
    public static final int DESTINATION_PAN_FIELD_NUMBER = 2;
    public static final int LOCALIZE_FIELD_NUMBER = 5;
    public static final int MESSAGE_DATA_FIELD_NUMBER = 7;
    private static volatile KW4 PARSER = null;
    public static final int SOURCE_ADDRESS_FIELD_NUMBER = 4;
    public static final int TARGET_USER_ID_FIELD_NUMBER = 6;
    private int amount_;
    private int bitField0_;
    private int localize_;
    private MessagingStruct$HistoryMessageIdentifier messageData_;
    private CollectionsStruct$Int32Value targetUserId_;
    private String cardId_ = "";
    private String destinationPan_ = "";
    private String sourceAddress_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(int i) {
            q();
            ((SapOuterClass$RequestGetDestinationCardInfo) this.b).setAmount(i);
            return this;
        }

        public a B(String str) {
            q();
            ((SapOuterClass$RequestGetDestinationCardInfo) this.b).setCardId(str);
            return this;
        }

        public a C(String str) {
            q();
            ((SapOuterClass$RequestGetDestinationCardInfo) this.b).setDestinationPan(str);
            return this;
        }

        public a D(int i) {
            q();
            ((SapOuterClass$RequestGetDestinationCardInfo) this.b).setLocalize(i);
            return this;
        }

        public a E(MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier) {
            q();
            ((SapOuterClass$RequestGetDestinationCardInfo) this.b).setMessageData(messagingStruct$HistoryMessageIdentifier);
            return this;
        }

        public a F(String str) {
            q();
            ((SapOuterClass$RequestGetDestinationCardInfo) this.b).setSourceAddress(str);
            return this;
        }

        public a G(CollectionsStruct$Int32Value collectionsStruct$Int32Value) {
            q();
            ((SapOuterClass$RequestGetDestinationCardInfo) this.b).setTargetUserId(collectionsStruct$Int32Value);
            return this;
        }

        private a() {
            super(SapOuterClass$RequestGetDestinationCardInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        SapOuterClass$RequestGetDestinationCardInfo sapOuterClass$RequestGetDestinationCardInfo = new SapOuterClass$RequestGetDestinationCardInfo();
        DEFAULT_INSTANCE = sapOuterClass$RequestGetDestinationCardInfo;
        GeneratedMessageLite.registerDefaultInstance(SapOuterClass$RequestGetDestinationCardInfo.class, sapOuterClass$RequestGetDestinationCardInfo);
    }

    private SapOuterClass$RequestGetDestinationCardInfo() {
    }

    private void clearAmount() {
        this.amount_ = 0;
    }

    private void clearCardId() {
        this.cardId_ = getDefaultInstance().getCardId();
    }

    private void clearDestinationPan() {
        this.destinationPan_ = getDefaultInstance().getDestinationPan();
    }

    private void clearLocalize() {
        this.localize_ = 0;
    }

    private void clearMessageData() {
        this.messageData_ = null;
        this.bitField0_ &= -3;
    }

    private void clearSourceAddress() {
        this.sourceAddress_ = getDefaultInstance().getSourceAddress();
    }

    private void clearTargetUserId() {
        this.targetUserId_ = null;
        this.bitField0_ &= -2;
    }

    public static SapOuterClass$RequestGetDestinationCardInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
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

    private void mergeTargetUserId(CollectionsStruct$Int32Value collectionsStruct$Int32Value) {
        collectionsStruct$Int32Value.getClass();
        CollectionsStruct$Int32Value collectionsStruct$Int32Value2 = this.targetUserId_;
        if (collectionsStruct$Int32Value2 == null || collectionsStruct$Int32Value2 == CollectionsStruct$Int32Value.getDefaultInstance()) {
            this.targetUserId_ = collectionsStruct$Int32Value;
        } else {
            this.targetUserId_ = (CollectionsStruct$Int32Value) ((CollectionsStruct$Int32Value.a) CollectionsStruct$Int32Value.newBuilder(this.targetUserId_).v(collectionsStruct$Int32Value)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SapOuterClass$RequestGetDestinationCardInfo parseDelimitedFrom(InputStream inputStream) {
        return (SapOuterClass$RequestGetDestinationCardInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SapOuterClass$RequestGetDestinationCardInfo parseFrom(ByteBuffer byteBuffer) {
        return (SapOuterClass$RequestGetDestinationCardInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAmount(int i) {
        this.amount_ = i;
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
    public void setLocalize(int i) {
        this.localize_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMessageData(MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier) {
        messagingStruct$HistoryMessageIdentifier.getClass();
        this.messageData_ = messagingStruct$HistoryMessageIdentifier;
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSourceAddress(String str) {
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
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (H1.a[gVar.ordinal()]) {
            case 1:
                return new SapOuterClass$RequestGetDestinationCardInfo();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0004\u0004Ȉ\u0005\u0004\u0006ဉ\u0000\u0007ဉ\u0001", new Object[]{"bitField0_", "cardId_", "destinationPan_", "amount_", "sourceAddress_", "localize_", "targetUserId_", "messageData_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SapOuterClass$RequestGetDestinationCardInfo.class) {
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

    public String getCardId() {
        return this.cardId_;
    }

    public AbstractC2383g getCardIdBytes() {
        return AbstractC2383g.N(this.cardId_);
    }

    public String getDestinationPan() {
        return this.destinationPan_;
    }

    public AbstractC2383g getDestinationPanBytes() {
        return AbstractC2383g.N(this.destinationPan_);
    }

    public int getLocalize() {
        return this.localize_;
    }

    public MessagingStruct$HistoryMessageIdentifier getMessageData() {
        MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier = this.messageData_;
        return messagingStruct$HistoryMessageIdentifier == null ? MessagingStruct$HistoryMessageIdentifier.getDefaultInstance() : messagingStruct$HistoryMessageIdentifier;
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

    public boolean hasMessageData() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasTargetUserId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(SapOuterClass$RequestGetDestinationCardInfo sapOuterClass$RequestGetDestinationCardInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(sapOuterClass$RequestGetDestinationCardInfo);
    }

    public static SapOuterClass$RequestGetDestinationCardInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SapOuterClass$RequestGetDestinationCardInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SapOuterClass$RequestGetDestinationCardInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SapOuterClass$RequestGetDestinationCardInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SapOuterClass$RequestGetDestinationCardInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (SapOuterClass$RequestGetDestinationCardInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SapOuterClass$RequestGetDestinationCardInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SapOuterClass$RequestGetDestinationCardInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SapOuterClass$RequestGetDestinationCardInfo parseFrom(byte[] bArr) {
        return (SapOuterClass$RequestGetDestinationCardInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SapOuterClass$RequestGetDestinationCardInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (SapOuterClass$RequestGetDestinationCardInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SapOuterClass$RequestGetDestinationCardInfo parseFrom(InputStream inputStream) {
        return (SapOuterClass$RequestGetDestinationCardInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SapOuterClass$RequestGetDestinationCardInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SapOuterClass$RequestGetDestinationCardInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SapOuterClass$RequestGetDestinationCardInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (SapOuterClass$RequestGetDestinationCardInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SapOuterClass$RequestGetDestinationCardInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SapOuterClass$RequestGetDestinationCardInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
