package ai.bale.proto;

import ai.bale.proto.MessagingStruct$MessageId;
import ai.bale.proto.PeersStruct$ExPeer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public final class AbacusOuterClass$UpdateMessageReactionsReadByMe extends GeneratedMessageLite implements U64 {
    private static final AbacusOuterClass$UpdateMessageReactionsReadByMe DEFAULT_INSTANCE;
    public static final int EX_PEER_FIELD_NUMBER = 1;
    public static final int MESSAGE_ID_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private PeersStruct$ExPeer exPeer_;
    private MessagingStruct$MessageId messageId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AbacusOuterClass$UpdateMessageReactionsReadByMe.DEFAULT_INSTANCE);
        }
    }

    static {
        AbacusOuterClass$UpdateMessageReactionsReadByMe abacusOuterClass$UpdateMessageReactionsReadByMe = new AbacusOuterClass$UpdateMessageReactionsReadByMe();
        DEFAULT_INSTANCE = abacusOuterClass$UpdateMessageReactionsReadByMe;
        GeneratedMessageLite.registerDefaultInstance(AbacusOuterClass$UpdateMessageReactionsReadByMe.class, abacusOuterClass$UpdateMessageReactionsReadByMe);
    }

    private AbacusOuterClass$UpdateMessageReactionsReadByMe() {
    }

    private void clearExPeer() {
        this.exPeer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearMessageId() {
        this.messageId_ = null;
        this.bitField0_ &= -3;
    }

    public static AbacusOuterClass$UpdateMessageReactionsReadByMe getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeExPeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        PeersStruct$ExPeer peersStruct$ExPeer2 = this.exPeer_;
        if (peersStruct$ExPeer2 == null || peersStruct$ExPeer2 == PeersStruct$ExPeer.getDefaultInstance()) {
            this.exPeer_ = peersStruct$ExPeer;
        } else {
            this.exPeer_ = (PeersStruct$ExPeer) ((PeersStruct$ExPeer.a) PeersStruct$ExPeer.newBuilder(this.exPeer_).v(peersStruct$ExPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeMessageId(MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        MessagingStruct$MessageId messagingStruct$MessageId2 = this.messageId_;
        if (messagingStruct$MessageId2 == null || messagingStruct$MessageId2 == MessagingStruct$MessageId.getDefaultInstance()) {
            this.messageId_ = messagingStruct$MessageId;
        } else {
            this.messageId_ = (MessagingStruct$MessageId) ((MessagingStruct$MessageId.a) MessagingStruct$MessageId.newBuilder(this.messageId_).v(messagingStruct$MessageId)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AbacusOuterClass$UpdateMessageReactionsReadByMe parseDelimitedFrom(InputStream inputStream) {
        return (AbacusOuterClass$UpdateMessageReactionsReadByMe) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AbacusOuterClass$UpdateMessageReactionsReadByMe parseFrom(ByteBuffer byteBuffer) {
        return (AbacusOuterClass$UpdateMessageReactionsReadByMe) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setExPeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        this.exPeer_ = peersStruct$ExPeer;
        this.bitField0_ |= 1;
    }

    private void setMessageId(MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        this.messageId_ = messagingStruct$MessageId;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1837a.a[gVar.ordinal()]) {
            case 1:
                return new AbacusOuterClass$UpdateMessageReactionsReadByMe();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"bitField0_", "exPeer_", "messageId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AbacusOuterClass$UpdateMessageReactionsReadByMe.class) {
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

    public PeersStruct$ExPeer getExPeer() {
        PeersStruct$ExPeer peersStruct$ExPeer = this.exPeer_;
        return peersStruct$ExPeer == null ? PeersStruct$ExPeer.getDefaultInstance() : peersStruct$ExPeer;
    }

    public MessagingStruct$MessageId getMessageId() {
        MessagingStruct$MessageId messagingStruct$MessageId = this.messageId_;
        return messagingStruct$MessageId == null ? MessagingStruct$MessageId.getDefaultInstance() : messagingStruct$MessageId;
    }

    public boolean hasExPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasMessageId() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(AbacusOuterClass$UpdateMessageReactionsReadByMe abacusOuterClass$UpdateMessageReactionsReadByMe) {
        return (a) DEFAULT_INSTANCE.createBuilder(abacusOuterClass$UpdateMessageReactionsReadByMe);
    }

    public static AbacusOuterClass$UpdateMessageReactionsReadByMe parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AbacusOuterClass$UpdateMessageReactionsReadByMe) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AbacusOuterClass$UpdateMessageReactionsReadByMe parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AbacusOuterClass$UpdateMessageReactionsReadByMe) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AbacusOuterClass$UpdateMessageReactionsReadByMe parseFrom(AbstractC2383g abstractC2383g) {
        return (AbacusOuterClass$UpdateMessageReactionsReadByMe) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AbacusOuterClass$UpdateMessageReactionsReadByMe parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AbacusOuterClass$UpdateMessageReactionsReadByMe) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AbacusOuterClass$UpdateMessageReactionsReadByMe parseFrom(byte[] bArr) {
        return (AbacusOuterClass$UpdateMessageReactionsReadByMe) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AbacusOuterClass$UpdateMessageReactionsReadByMe parseFrom(byte[] bArr, C2394s c2394s) {
        return (AbacusOuterClass$UpdateMessageReactionsReadByMe) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AbacusOuterClass$UpdateMessageReactionsReadByMe parseFrom(InputStream inputStream) {
        return (AbacusOuterClass$UpdateMessageReactionsReadByMe) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AbacusOuterClass$UpdateMessageReactionsReadByMe parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AbacusOuterClass$UpdateMessageReactionsReadByMe) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AbacusOuterClass$UpdateMessageReactionsReadByMe parseFrom(AbstractC2384h abstractC2384h) {
        return (AbacusOuterClass$UpdateMessageReactionsReadByMe) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AbacusOuterClass$UpdateMessageReactionsReadByMe parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AbacusOuterClass$UpdateMessageReactionsReadByMe) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
