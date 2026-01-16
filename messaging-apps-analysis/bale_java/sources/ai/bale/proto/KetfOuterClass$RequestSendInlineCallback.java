package ai.bale.proto;

import ai.bale.proto.MessagingStruct$MessageId;
import ai.bale.proto.PeersStruct$ExPeer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class KetfOuterClass$RequestSendInlineCallback extends GeneratedMessageLite implements U64 {
    public static final int DATA_FIELD_NUMBER = 3;
    private static final KetfOuterClass$RequestSendInlineCallback DEFAULT_INSTANCE;
    public static final int MESSAGE_ID_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 1;
    private int bitField0_;
    private StringValue data_;
    private MessagingStruct$MessageId messageId_;
    private PeersStruct$ExPeer peer_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(StringValue stringValue) {
            q();
            ((KetfOuterClass$RequestSendInlineCallback) this.b).setData(stringValue);
            return this;
        }

        public a B(MessagingStruct$MessageId messagingStruct$MessageId) {
            q();
            ((KetfOuterClass$RequestSendInlineCallback) this.b).setMessageId(messagingStruct$MessageId);
            return this;
        }

        public a C(PeersStruct$ExPeer peersStruct$ExPeer) {
            q();
            ((KetfOuterClass$RequestSendInlineCallback) this.b).setPeer(peersStruct$ExPeer);
            return this;
        }

        private a() {
            super(KetfOuterClass$RequestSendInlineCallback.DEFAULT_INSTANCE);
        }
    }

    static {
        KetfOuterClass$RequestSendInlineCallback ketfOuterClass$RequestSendInlineCallback = new KetfOuterClass$RequestSendInlineCallback();
        DEFAULT_INSTANCE = ketfOuterClass$RequestSendInlineCallback;
        GeneratedMessageLite.registerDefaultInstance(KetfOuterClass$RequestSendInlineCallback.class, ketfOuterClass$RequestSendInlineCallback);
    }

    private KetfOuterClass$RequestSendInlineCallback() {
    }

    private void clearData() {
        this.data_ = null;
        this.bitField0_ &= -5;
    }

    private void clearMessageId() {
        this.messageId_ = null;
        this.bitField0_ &= -3;
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -2;
    }

    public static KetfOuterClass$RequestSendInlineCallback getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeData(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.data_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.data_ = stringValue;
        } else {
            this.data_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.data_).v(stringValue)).j();
        }
        this.bitField0_ |= 4;
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

    private void mergePeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        PeersStruct$ExPeer peersStruct$ExPeer2 = this.peer_;
        if (peersStruct$ExPeer2 == null || peersStruct$ExPeer2 == PeersStruct$ExPeer.getDefaultInstance()) {
            this.peer_ = peersStruct$ExPeer;
        } else {
            this.peer_ = (PeersStruct$ExPeer) ((PeersStruct$ExPeer.a) PeersStruct$ExPeer.newBuilder(this.peer_).v(peersStruct$ExPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KetfOuterClass$RequestSendInlineCallback parseDelimitedFrom(InputStream inputStream) {
        return (KetfOuterClass$RequestSendInlineCallback) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfOuterClass$RequestSendInlineCallback parseFrom(ByteBuffer byteBuffer) {
        return (KetfOuterClass$RequestSendInlineCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(StringValue stringValue) {
        stringValue.getClass();
        this.data_ = stringValue;
        this.bitField0_ |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMessageId(MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        this.messageId_ = messagingStruct$MessageId;
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        this.peer_ = peersStruct$ExPeer;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1888r0.a[gVar.ordinal()]) {
            case 1:
                return new KetfOuterClass$RequestSendInlineCallback();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"bitField0_", "peer_", "messageId_", "data_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KetfOuterClass$RequestSendInlineCallback.class) {
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

    public StringValue getData() {
        StringValue stringValue = this.data_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public MessagingStruct$MessageId getMessageId() {
        MessagingStruct$MessageId messagingStruct$MessageId = this.messageId_;
        return messagingStruct$MessageId == null ? MessagingStruct$MessageId.getDefaultInstance() : messagingStruct$MessageId;
    }

    public PeersStruct$ExPeer getPeer() {
        PeersStruct$ExPeer peersStruct$ExPeer = this.peer_;
        return peersStruct$ExPeer == null ? PeersStruct$ExPeer.getDefaultInstance() : peersStruct$ExPeer;
    }

    public boolean hasData() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasMessageId() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(KetfOuterClass$RequestSendInlineCallback ketfOuterClass$RequestSendInlineCallback) {
        return (a) DEFAULT_INSTANCE.createBuilder(ketfOuterClass$RequestSendInlineCallback);
    }

    public static KetfOuterClass$RequestSendInlineCallback parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfOuterClass$RequestSendInlineCallback) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfOuterClass$RequestSendInlineCallback parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KetfOuterClass$RequestSendInlineCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KetfOuterClass$RequestSendInlineCallback parseFrom(AbstractC2383g abstractC2383g) {
        return (KetfOuterClass$RequestSendInlineCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KetfOuterClass$RequestSendInlineCallback parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KetfOuterClass$RequestSendInlineCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KetfOuterClass$RequestSendInlineCallback parseFrom(byte[] bArr) {
        return (KetfOuterClass$RequestSendInlineCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KetfOuterClass$RequestSendInlineCallback parseFrom(byte[] bArr, C2394s c2394s) {
        return (KetfOuterClass$RequestSendInlineCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KetfOuterClass$RequestSendInlineCallback parseFrom(InputStream inputStream) {
        return (KetfOuterClass$RequestSendInlineCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfOuterClass$RequestSendInlineCallback parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfOuterClass$RequestSendInlineCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfOuterClass$RequestSendInlineCallback parseFrom(AbstractC2384h abstractC2384h) {
        return (KetfOuterClass$RequestSendInlineCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KetfOuterClass$RequestSendInlineCallback parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KetfOuterClass$RequestSendInlineCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
