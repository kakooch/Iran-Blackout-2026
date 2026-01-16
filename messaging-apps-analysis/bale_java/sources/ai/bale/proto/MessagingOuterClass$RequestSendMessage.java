package ai.bale.proto;

import ai.bale.proto.MessagingStruct$Message;
import ai.bale.proto.MessagingStruct$MessageId;
import ai.bale.proto.MessagingStruct$MessageOutReference;
import ai.bale.proto.PeersStruct$OutExPeer;
import ai.bale.proto.PeersStruct$OutPeer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int32Value;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingOuterClass$RequestSendMessage extends GeneratedMessageLite implements U64 {
    private static final MessagingOuterClass$RequestSendMessage DEFAULT_INSTANCE;
    public static final int EX_PEER_FIELD_NUMBER = 6;
    public static final int IS_ONLY_FOR_USER_FIELD_NUMBER = 4;
    public static final int IS_SILENT_FIELD_NUMBER = 7;
    public static final int MESSAGE_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 1;
    public static final int QUOTED_MESSAGE_REFERENCE_FIELD_NUMBER = 5;
    public static final int RID_FIELD_NUMBER = 2;
    public static final int THREAD_ID_FIELD_NUMBER = 8;
    private int bitField0_;
    private PeersStruct$OutExPeer exPeer_;
    private Int32Value isOnlyForUser_;
    private boolean isSilent_;
    private MessagingStruct$Message message_;
    private PeersStruct$OutPeer peer_;
    private MessagingStruct$MessageOutReference quotedMessageReference_;
    private long rid_;
    private MessagingStruct$MessageId threadId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingOuterClass$RequestSendMessage.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingOuterClass$RequestSendMessage messagingOuterClass$RequestSendMessage = new MessagingOuterClass$RequestSendMessage();
        DEFAULT_INSTANCE = messagingOuterClass$RequestSendMessage;
        GeneratedMessageLite.registerDefaultInstance(MessagingOuterClass$RequestSendMessage.class, messagingOuterClass$RequestSendMessage);
    }

    private MessagingOuterClass$RequestSendMessage() {
    }

    private void clearExPeer() {
        this.exPeer_ = null;
        this.bitField0_ &= -17;
    }

    private void clearIsOnlyForUser() {
        this.isOnlyForUser_ = null;
        this.bitField0_ &= -5;
    }

    private void clearIsSilent() {
        this.isSilent_ = false;
    }

    private void clearMessage() {
        this.message_ = null;
        this.bitField0_ &= -3;
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearQuotedMessageReference() {
        this.quotedMessageReference_ = null;
        this.bitField0_ &= -9;
    }

    private void clearRid() {
        this.rid_ = 0L;
    }

    private void clearThreadId() {
        this.threadId_ = null;
        this.bitField0_ &= -33;
    }

    public static MessagingOuterClass$RequestSendMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeExPeer(PeersStruct$OutExPeer peersStruct$OutExPeer) {
        peersStruct$OutExPeer.getClass();
        PeersStruct$OutExPeer peersStruct$OutExPeer2 = this.exPeer_;
        if (peersStruct$OutExPeer2 == null || peersStruct$OutExPeer2 == PeersStruct$OutExPeer.getDefaultInstance()) {
            this.exPeer_ = peersStruct$OutExPeer;
        } else {
            this.exPeer_ = (PeersStruct$OutExPeer) ((PeersStruct$OutExPeer.a) PeersStruct$OutExPeer.newBuilder(this.exPeer_).v(peersStruct$OutExPeer)).j();
        }
        this.bitField0_ |= 16;
    }

    private void mergeIsOnlyForUser(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.isOnlyForUser_;
        if (int32Value2 == null || int32Value2 == Int32Value.getDefaultInstance()) {
            this.isOnlyForUser_ = int32Value;
        } else {
            this.isOnlyForUser_ = (Int32Value) ((Int32Value.b) Int32Value.newBuilder(this.isOnlyForUser_).v(int32Value)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeMessage(MessagingStruct$Message messagingStruct$Message) {
        messagingStruct$Message.getClass();
        MessagingStruct$Message messagingStruct$Message2 = this.message_;
        if (messagingStruct$Message2 == null || messagingStruct$Message2 == MessagingStruct$Message.getDefaultInstance()) {
            this.message_ = messagingStruct$Message;
        } else {
            this.message_ = (MessagingStruct$Message) ((MessagingStruct$Message.a) MessagingStruct$Message.newBuilder(this.message_).v(messagingStruct$Message)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergePeer(PeersStruct$OutPeer peersStruct$OutPeer) {
        peersStruct$OutPeer.getClass();
        PeersStruct$OutPeer peersStruct$OutPeer2 = this.peer_;
        if (peersStruct$OutPeer2 == null || peersStruct$OutPeer2 == PeersStruct$OutPeer.getDefaultInstance()) {
            this.peer_ = peersStruct$OutPeer;
        } else {
            this.peer_ = (PeersStruct$OutPeer) ((PeersStruct$OutPeer.a) PeersStruct$OutPeer.newBuilder(this.peer_).v(peersStruct$OutPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeQuotedMessageReference(MessagingStruct$MessageOutReference messagingStruct$MessageOutReference) {
        messagingStruct$MessageOutReference.getClass();
        MessagingStruct$MessageOutReference messagingStruct$MessageOutReference2 = this.quotedMessageReference_;
        if (messagingStruct$MessageOutReference2 == null || messagingStruct$MessageOutReference2 == MessagingStruct$MessageOutReference.getDefaultInstance()) {
            this.quotedMessageReference_ = messagingStruct$MessageOutReference;
        } else {
            this.quotedMessageReference_ = (MessagingStruct$MessageOutReference) ((MessagingStruct$MessageOutReference.a) MessagingStruct$MessageOutReference.newBuilder(this.quotedMessageReference_).v(messagingStruct$MessageOutReference)).j();
        }
        this.bitField0_ |= 8;
    }

    private void mergeThreadId(MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        MessagingStruct$MessageId messagingStruct$MessageId2 = this.threadId_;
        if (messagingStruct$MessageId2 == null || messagingStruct$MessageId2 == MessagingStruct$MessageId.getDefaultInstance()) {
            this.threadId_ = messagingStruct$MessageId;
        } else {
            this.threadId_ = (MessagingStruct$MessageId) ((MessagingStruct$MessageId.a) MessagingStruct$MessageId.newBuilder(this.threadId_).v(messagingStruct$MessageId)).j();
        }
        this.bitField0_ |= 32;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingOuterClass$RequestSendMessage parseDelimitedFrom(InputStream inputStream) {
        return (MessagingOuterClass$RequestSendMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$RequestSendMessage parseFrom(ByteBuffer byteBuffer) {
        return (MessagingOuterClass$RequestSendMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setExPeer(PeersStruct$OutExPeer peersStruct$OutExPeer) {
        peersStruct$OutExPeer.getClass();
        this.exPeer_ = peersStruct$OutExPeer;
        this.bitField0_ |= 16;
    }

    private void setIsOnlyForUser(Int32Value int32Value) {
        int32Value.getClass();
        this.isOnlyForUser_ = int32Value;
        this.bitField0_ |= 4;
    }

    private void setIsSilent(boolean z) {
        this.isSilent_ = z;
    }

    private void setMessage(MessagingStruct$Message messagingStruct$Message) {
        messagingStruct$Message.getClass();
        this.message_ = messagingStruct$Message;
        this.bitField0_ |= 2;
    }

    private void setPeer(PeersStruct$OutPeer peersStruct$OutPeer) {
        peersStruct$OutPeer.getClass();
        this.peer_ = peersStruct$OutPeer;
        this.bitField0_ |= 1;
    }

    private void setQuotedMessageReference(MessagingStruct$MessageOutReference messagingStruct$MessageOutReference) {
        messagingStruct$MessageOutReference.getClass();
        this.quotedMessageReference_ = messagingStruct$MessageOutReference;
        this.bitField0_ |= 8;
    }

    private void setRid(long j) {
        this.rid_ = j;
    }

    private void setThreadId(MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        this.threadId_ = messagingStruct$MessageId;
        this.bitField0_ |= 32;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (K0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingOuterClass$RequestSendMessage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0002\u0003ဉ\u0001\u0004ဉ\u0002\u0005ဉ\u0003\u0006ဉ\u0004\u0007\u0007\bဉ\u0005", new Object[]{"bitField0_", "peer_", "rid_", "message_", "isOnlyForUser_", "quotedMessageReference_", "exPeer_", "isSilent_", "threadId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingOuterClass$RequestSendMessage.class) {
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

    public PeersStruct$OutExPeer getExPeer() {
        PeersStruct$OutExPeer peersStruct$OutExPeer = this.exPeer_;
        return peersStruct$OutExPeer == null ? PeersStruct$OutExPeer.getDefaultInstance() : peersStruct$OutExPeer;
    }

    @Deprecated
    public Int32Value getIsOnlyForUser() {
        Int32Value int32Value = this.isOnlyForUser_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public boolean getIsSilent() {
        return this.isSilent_;
    }

    public MessagingStruct$Message getMessage() {
        MessagingStruct$Message messagingStruct$Message = this.message_;
        return messagingStruct$Message == null ? MessagingStruct$Message.getDefaultInstance() : messagingStruct$Message;
    }

    @Deprecated
    public PeersStruct$OutPeer getPeer() {
        PeersStruct$OutPeer peersStruct$OutPeer = this.peer_;
        return peersStruct$OutPeer == null ? PeersStruct$OutPeer.getDefaultInstance() : peersStruct$OutPeer;
    }

    public MessagingStruct$MessageOutReference getQuotedMessageReference() {
        MessagingStruct$MessageOutReference messagingStruct$MessageOutReference = this.quotedMessageReference_;
        return messagingStruct$MessageOutReference == null ? MessagingStruct$MessageOutReference.getDefaultInstance() : messagingStruct$MessageOutReference;
    }

    public long getRid() {
        return this.rid_;
    }

    public MessagingStruct$MessageId getThreadId() {
        MessagingStruct$MessageId messagingStruct$MessageId = this.threadId_;
        return messagingStruct$MessageId == null ? MessagingStruct$MessageId.getDefaultInstance() : messagingStruct$MessageId;
    }

    public boolean hasExPeer() {
        return (this.bitField0_ & 16) != 0;
    }

    @Deprecated
    public boolean hasIsOnlyForUser() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasMessage() {
        return (this.bitField0_ & 2) != 0;
    }

    @Deprecated
    public boolean hasPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasQuotedMessageReference() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasThreadId() {
        return (this.bitField0_ & 32) != 0;
    }

    public static a newBuilder(MessagingOuterClass$RequestSendMessage messagingOuterClass$RequestSendMessage) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingOuterClass$RequestSendMessage);
    }

    public static MessagingOuterClass$RequestSendMessage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$RequestSendMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$RequestSendMessage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingOuterClass$RequestSendMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingOuterClass$RequestSendMessage parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingOuterClass$RequestSendMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingOuterClass$RequestSendMessage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingOuterClass$RequestSendMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingOuterClass$RequestSendMessage parseFrom(byte[] bArr) {
        return (MessagingOuterClass$RequestSendMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingOuterClass$RequestSendMessage parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingOuterClass$RequestSendMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingOuterClass$RequestSendMessage parseFrom(InputStream inputStream) {
        return (MessagingOuterClass$RequestSendMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$RequestSendMessage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$RequestSendMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$RequestSendMessage parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingOuterClass$RequestSendMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingOuterClass$RequestSendMessage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingOuterClass$RequestSendMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
