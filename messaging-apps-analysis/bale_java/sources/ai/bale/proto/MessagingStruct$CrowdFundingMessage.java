package ai.bale.proto;

import ai.bale.proto.MessagingStruct$DocumentMessage;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC12424eb4;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingStruct$CrowdFundingMessage extends GeneratedMessageLite implements U64 {
    public static final int CARD_NUMBER_FIELD_NUMBER = 2;
    private static final MessagingStruct$CrowdFundingMessage DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 5;
    public static final int END_DATE_FIELD_NUMBER = 6;
    private static volatile KW4 PARSER = null;
    public static final int PHOTO_FIELD_NUMBER = 8;
    public static final int SLICE_AMOUNT_FIELD_NUMBER = 3;
    public static final int STATUS_FIELD_NUMBER = 7;
    public static final int TITLE_FIELD_NUMBER = 4;
    public static final int TOTAL_AMOUNT_FIELD_NUMBER = 1;
    private int bitField0_;
    private long endDate_;
    private MessagingStruct$DocumentMessage photo_;
    private long sliceAmount_;
    private int status_;
    private long totalAmount_;
    private String cardNumber_ = "";
    private String title_ = "";
    private String description_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$CrowdFundingMessage.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$CrowdFundingMessage messagingStruct$CrowdFundingMessage = new MessagingStruct$CrowdFundingMessage();
        DEFAULT_INSTANCE = messagingStruct$CrowdFundingMessage;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$CrowdFundingMessage.class, messagingStruct$CrowdFundingMessage);
    }

    private MessagingStruct$CrowdFundingMessage() {
    }

    private void clearCardNumber() {
        this.cardNumber_ = getDefaultInstance().getCardNumber();
    }

    private void clearDescription() {
        this.description_ = getDefaultInstance().getDescription();
    }

    private void clearEndDate() {
        this.endDate_ = 0L;
    }

    private void clearPhoto() {
        this.photo_ = null;
        this.bitField0_ &= -2;
    }

    private void clearSliceAmount() {
        this.sliceAmount_ = 0L;
    }

    private void clearStatus() {
        this.status_ = 0;
    }

    private void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    private void clearTotalAmount() {
        this.totalAmount_ = 0L;
    }

    public static MessagingStruct$CrowdFundingMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePhoto(MessagingStruct$DocumentMessage messagingStruct$DocumentMessage) {
        messagingStruct$DocumentMessage.getClass();
        MessagingStruct$DocumentMessage messagingStruct$DocumentMessage2 = this.photo_;
        if (messagingStruct$DocumentMessage2 == null || messagingStruct$DocumentMessage2 == MessagingStruct$DocumentMessage.getDefaultInstance()) {
            this.photo_ = messagingStruct$DocumentMessage;
        } else {
            this.photo_ = (MessagingStruct$DocumentMessage) ((MessagingStruct$DocumentMessage.a) MessagingStruct$DocumentMessage.newBuilder(this.photo_).v(messagingStruct$DocumentMessage)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$CrowdFundingMessage parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$CrowdFundingMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$CrowdFundingMessage parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$CrowdFundingMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCardNumber(String str) {
        str.getClass();
        this.cardNumber_ = str;
    }

    private void setCardNumberBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.cardNumber_ = abstractC2383g.f0();
    }

    private void setDescription(String str) {
        str.getClass();
        this.description_ = str;
    }

    private void setDescriptionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.description_ = abstractC2383g.f0();
    }

    private void setEndDate(long j) {
        this.endDate_ = j;
    }

    private void setPhoto(MessagingStruct$DocumentMessage messagingStruct$DocumentMessage) {
        messagingStruct$DocumentMessage.getClass();
        this.photo_ = messagingStruct$DocumentMessage;
        this.bitField0_ |= 1;
    }

    private void setSliceAmount(long j) {
        this.sliceAmount_ = j;
    }

    private void setStatus(EnumC12424eb4 enumC12424eb4) {
        this.status_ = enumC12424eb4.getNumber();
    }

    private void setStatusValue(int i) {
        this.status_ = i;
    }

    private void setTitle(String str) {
        str.getClass();
        this.title_ = str;
    }

    private void setTitleBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.title_ = abstractC2383g.f0();
    }

    private void setTotalAmount(long j) {
        this.totalAmount_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$CrowdFundingMessage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001\u0002\u0002Ȉ\u0003\u0002\u0004Ȉ\u0005Ȉ\u0006\u0002\u0007\f\bဉ\u0000", new Object[]{"bitField0_", "totalAmount_", "cardNumber_", "sliceAmount_", "title_", "description_", "endDate_", "status_", "photo_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$CrowdFundingMessage.class) {
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

    public String getCardNumber() {
        return this.cardNumber_;
    }

    public AbstractC2383g getCardNumberBytes() {
        return AbstractC2383g.N(this.cardNumber_);
    }

    public String getDescription() {
        return this.description_;
    }

    public AbstractC2383g getDescriptionBytes() {
        return AbstractC2383g.N(this.description_);
    }

    public long getEndDate() {
        return this.endDate_;
    }

    public MessagingStruct$DocumentMessage getPhoto() {
        MessagingStruct$DocumentMessage messagingStruct$DocumentMessage = this.photo_;
        return messagingStruct$DocumentMessage == null ? MessagingStruct$DocumentMessage.getDefaultInstance() : messagingStruct$DocumentMessage;
    }

    public long getSliceAmount() {
        return this.sliceAmount_;
    }

    public EnumC12424eb4 getStatus() {
        EnumC12424eb4 enumC12424eb4J = EnumC12424eb4.j(this.status_);
        return enumC12424eb4J == null ? EnumC12424eb4.UNRECOGNIZED : enumC12424eb4J;
    }

    public int getStatusValue() {
        return this.status_;
    }

    public String getTitle() {
        return this.title_;
    }

    public AbstractC2383g getTitleBytes() {
        return AbstractC2383g.N(this.title_);
    }

    public long getTotalAmount() {
        return this.totalAmount_;
    }

    public boolean hasPhoto() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MessagingStruct$CrowdFundingMessage messagingStruct$CrowdFundingMessage) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$CrowdFundingMessage);
    }

    public static MessagingStruct$CrowdFundingMessage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$CrowdFundingMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$CrowdFundingMessage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$CrowdFundingMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$CrowdFundingMessage parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$CrowdFundingMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$CrowdFundingMessage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$CrowdFundingMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$CrowdFundingMessage parseFrom(byte[] bArr) {
        return (MessagingStruct$CrowdFundingMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$CrowdFundingMessage parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$CrowdFundingMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$CrowdFundingMessage parseFrom(InputStream inputStream) {
        return (MessagingStruct$CrowdFundingMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$CrowdFundingMessage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$CrowdFundingMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$CrowdFundingMessage parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$CrowdFundingMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$CrowdFundingMessage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$CrowdFundingMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
