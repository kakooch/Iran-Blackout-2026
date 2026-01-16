package ai.bale.proto;

import ai.bale.proto.MessagingStruct$HistoryMessageIdentifier;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int32Value;
import ir.nasim.KW4;
import ir.nasim.LI2;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class Giftpacket$RequestOpenGiftPacket extends GeneratedMessageLite implements U64 {
    private static final Giftpacket$RequestOpenGiftPacket DEFAULT_INSTANCE;
    public static final int MSG_IDENTIFIER_FIELD_NUMBER = 1;
    public static final int ORDER_TYPE_FIELD_NUMBER = 4;
    public static final int PAGE_NO_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int RECEIVER_WALLET_ID_FIELD_NUMBER = 2;
    private int bitField0_;
    private MessagingStruct$HistoryMessageIdentifier msgIdentifier_;
    private int orderType_;
    private Int32Value pageNo_;
    private String receiverWalletId_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier) {
            q();
            ((Giftpacket$RequestOpenGiftPacket) this.b).setMsgIdentifier(messagingStruct$HistoryMessageIdentifier);
            return this;
        }

        public a B(LI2 li2) {
            q();
            ((Giftpacket$RequestOpenGiftPacket) this.b).setOrderType(li2);
            return this;
        }

        public a C(Int32Value int32Value) {
            q();
            ((Giftpacket$RequestOpenGiftPacket) this.b).setPageNo(int32Value);
            return this;
        }

        public a D(String str) {
            q();
            ((Giftpacket$RequestOpenGiftPacket) this.b).setReceiverWalletId(str);
            return this;
        }

        private a() {
            super(Giftpacket$RequestOpenGiftPacket.DEFAULT_INSTANCE);
        }
    }

    static {
        Giftpacket$RequestOpenGiftPacket giftpacket$RequestOpenGiftPacket = new Giftpacket$RequestOpenGiftPacket();
        DEFAULT_INSTANCE = giftpacket$RequestOpenGiftPacket;
        GeneratedMessageLite.registerDefaultInstance(Giftpacket$RequestOpenGiftPacket.class, giftpacket$RequestOpenGiftPacket);
    }

    private Giftpacket$RequestOpenGiftPacket() {
    }

    private void clearMsgIdentifier() {
        this.msgIdentifier_ = null;
        this.bitField0_ &= -2;
    }

    private void clearOrderType() {
        this.orderType_ = 0;
    }

    private void clearPageNo() {
        this.pageNo_ = null;
        this.bitField0_ &= -3;
    }

    private void clearReceiverWalletId() {
        this.receiverWalletId_ = getDefaultInstance().getReceiverWalletId();
    }

    public static Giftpacket$RequestOpenGiftPacket getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeMsgIdentifier(MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier) {
        messagingStruct$HistoryMessageIdentifier.getClass();
        MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier2 = this.msgIdentifier_;
        if (messagingStruct$HistoryMessageIdentifier2 == null || messagingStruct$HistoryMessageIdentifier2 == MessagingStruct$HistoryMessageIdentifier.getDefaultInstance()) {
            this.msgIdentifier_ = messagingStruct$HistoryMessageIdentifier;
        } else {
            this.msgIdentifier_ = (MessagingStruct$HistoryMessageIdentifier) ((MessagingStruct$HistoryMessageIdentifier.a) MessagingStruct$HistoryMessageIdentifier.newBuilder(this.msgIdentifier_).v(messagingStruct$HistoryMessageIdentifier)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergePageNo(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.pageNo_;
        if (int32Value2 == null || int32Value2 == Int32Value.getDefaultInstance()) {
            this.pageNo_ = int32Value;
        } else {
            this.pageNo_ = (Int32Value) ((Int32Value.b) Int32Value.newBuilder(this.pageNo_).v(int32Value)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Giftpacket$RequestOpenGiftPacket parseDelimitedFrom(InputStream inputStream) {
        return (Giftpacket$RequestOpenGiftPacket) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Giftpacket$RequestOpenGiftPacket parseFrom(ByteBuffer byteBuffer) {
        return (Giftpacket$RequestOpenGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMsgIdentifier(MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier) {
        messagingStruct$HistoryMessageIdentifier.getClass();
        this.msgIdentifier_ = messagingStruct$HistoryMessageIdentifier;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOrderType(LI2 li2) {
        this.orderType_ = li2.getNumber();
    }

    private void setOrderTypeValue(int i) {
        this.orderType_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPageNo(Int32Value int32Value) {
        int32Value.getClass();
        this.pageNo_ = int32Value;
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReceiverWalletId(String str) {
        str.getClass();
        this.receiverWalletId_ = str;
    }

    private void setReceiverWalletIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.receiverWalletId_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1865j0.a[gVar.ordinal()]) {
            case 1:
                return new Giftpacket$RequestOpenGiftPacket();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002Ȉ\u0003ဉ\u0001\u0004\f", new Object[]{"bitField0_", "msgIdentifier_", "receiverWalletId_", "pageNo_", "orderType_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Giftpacket$RequestOpenGiftPacket.class) {
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

    public MessagingStruct$HistoryMessageIdentifier getMsgIdentifier() {
        MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier = this.msgIdentifier_;
        return messagingStruct$HistoryMessageIdentifier == null ? MessagingStruct$HistoryMessageIdentifier.getDefaultInstance() : messagingStruct$HistoryMessageIdentifier;
    }

    public LI2 getOrderType() {
        LI2 li2J = LI2.j(this.orderType_);
        return li2J == null ? LI2.UNRECOGNIZED : li2J;
    }

    public int getOrderTypeValue() {
        return this.orderType_;
    }

    public Int32Value getPageNo() {
        Int32Value int32Value = this.pageNo_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public String getReceiverWalletId() {
        return this.receiverWalletId_;
    }

    public AbstractC2383g getReceiverWalletIdBytes() {
        return AbstractC2383g.N(this.receiverWalletId_);
    }

    public boolean hasMsgIdentifier() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasPageNo() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(Giftpacket$RequestOpenGiftPacket giftpacket$RequestOpenGiftPacket) {
        return (a) DEFAULT_INSTANCE.createBuilder(giftpacket$RequestOpenGiftPacket);
    }

    public static Giftpacket$RequestOpenGiftPacket parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Giftpacket$RequestOpenGiftPacket) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Giftpacket$RequestOpenGiftPacket parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Giftpacket$RequestOpenGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Giftpacket$RequestOpenGiftPacket parseFrom(AbstractC2383g abstractC2383g) {
        return (Giftpacket$RequestOpenGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Giftpacket$RequestOpenGiftPacket parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Giftpacket$RequestOpenGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Giftpacket$RequestOpenGiftPacket parseFrom(byte[] bArr) {
        return (Giftpacket$RequestOpenGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Giftpacket$RequestOpenGiftPacket parseFrom(byte[] bArr, C2394s c2394s) {
        return (Giftpacket$RequestOpenGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Giftpacket$RequestOpenGiftPacket parseFrom(InputStream inputStream) {
        return (Giftpacket$RequestOpenGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Giftpacket$RequestOpenGiftPacket parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Giftpacket$RequestOpenGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Giftpacket$RequestOpenGiftPacket parseFrom(AbstractC2384h abstractC2384h) {
        return (Giftpacket$RequestOpenGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Giftpacket$RequestOpenGiftPacket parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Giftpacket$RequestOpenGiftPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
