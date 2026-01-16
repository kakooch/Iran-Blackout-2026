package ai.bale.proto;

import ai.bale.proto.MessagingStruct$PollMessage;
import ai.bale.proto.PeersStruct$ExPeer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class PollOuterClass$RequestCreatePoll extends GeneratedMessageLite implements U64 {
    public static final int CREATE_AT_FIELD_NUMBER = 2;
    private static final PollOuterClass$RequestCreatePoll DEFAULT_INSTANCE;
    public static final int EXPEER_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int POLL_MESSAGE_FIELD_NUMBER = 1;
    private int bitField0_;
    private long createAt_;
    private PeersStruct$ExPeer expeer_;
    private MessagingStruct$PollMessage pollMessage_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(PeersStruct$ExPeer.a aVar) {
            q();
            ((PollOuterClass$RequestCreatePoll) this.b).setExpeer((PeersStruct$ExPeer) aVar.a());
            return this;
        }

        public a B(MessagingStruct$PollMessage messagingStruct$PollMessage) {
            q();
            ((PollOuterClass$RequestCreatePoll) this.b).setPollMessage(messagingStruct$PollMessage);
            return this;
        }

        private a() {
            super(PollOuterClass$RequestCreatePoll.DEFAULT_INSTANCE);
        }
    }

    static {
        PollOuterClass$RequestCreatePoll pollOuterClass$RequestCreatePoll = new PollOuterClass$RequestCreatePoll();
        DEFAULT_INSTANCE = pollOuterClass$RequestCreatePoll;
        GeneratedMessageLite.registerDefaultInstance(PollOuterClass$RequestCreatePoll.class, pollOuterClass$RequestCreatePoll);
    }

    private PollOuterClass$RequestCreatePoll() {
    }

    private void clearCreateAt() {
        this.createAt_ = 0L;
    }

    private void clearExpeer() {
        this.expeer_ = null;
        this.bitField0_ &= -3;
    }

    private void clearPollMessage() {
        this.pollMessage_ = null;
        this.bitField0_ &= -2;
    }

    public static PollOuterClass$RequestCreatePoll getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeExpeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        PeersStruct$ExPeer peersStruct$ExPeer2 = this.expeer_;
        if (peersStruct$ExPeer2 == null || peersStruct$ExPeer2 == PeersStruct$ExPeer.getDefaultInstance()) {
            this.expeer_ = peersStruct$ExPeer;
        } else {
            this.expeer_ = (PeersStruct$ExPeer) ((PeersStruct$ExPeer.a) PeersStruct$ExPeer.newBuilder(this.expeer_).v(peersStruct$ExPeer)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergePollMessage(MessagingStruct$PollMessage messagingStruct$PollMessage) {
        messagingStruct$PollMessage.getClass();
        MessagingStruct$PollMessage messagingStruct$PollMessage2 = this.pollMessage_;
        if (messagingStruct$PollMessage2 == null || messagingStruct$PollMessage2 == MessagingStruct$PollMessage.getDefaultInstance()) {
            this.pollMessage_ = messagingStruct$PollMessage;
        } else {
            this.pollMessage_ = (MessagingStruct$PollMessage) ((MessagingStruct$PollMessage.a) MessagingStruct$PollMessage.newBuilder(this.pollMessage_).v(messagingStruct$PollMessage)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PollOuterClass$RequestCreatePoll parseDelimitedFrom(InputStream inputStream) {
        return (PollOuterClass$RequestCreatePoll) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PollOuterClass$RequestCreatePoll parseFrom(ByteBuffer byteBuffer) {
        return (PollOuterClass$RequestCreatePoll) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCreateAt(long j) {
        this.createAt_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setExpeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        this.expeer_ = peersStruct$ExPeer;
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPollMessage(MessagingStruct$PollMessage messagingStruct$PollMessage) {
        messagingStruct$PollMessage.getClass();
        this.pollMessage_ = messagingStruct$PollMessage;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1854f1.a[gVar.ordinal()]) {
            case 1:
                return new PollOuterClass$RequestCreatePoll();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0002\u0003ဉ\u0001", new Object[]{"bitField0_", "pollMessage_", "createAt_", "expeer_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PollOuterClass$RequestCreatePoll.class) {
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

    @Deprecated
    public long getCreateAt() {
        return this.createAt_;
    }

    public PeersStruct$ExPeer getExpeer() {
        PeersStruct$ExPeer peersStruct$ExPeer = this.expeer_;
        return peersStruct$ExPeer == null ? PeersStruct$ExPeer.getDefaultInstance() : peersStruct$ExPeer;
    }

    public MessagingStruct$PollMessage getPollMessage() {
        MessagingStruct$PollMessage messagingStruct$PollMessage = this.pollMessage_;
        return messagingStruct$PollMessage == null ? MessagingStruct$PollMessage.getDefaultInstance() : messagingStruct$PollMessage;
    }

    public boolean hasExpeer() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasPollMessage() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(PollOuterClass$RequestCreatePoll pollOuterClass$RequestCreatePoll) {
        return (a) DEFAULT_INSTANCE.createBuilder(pollOuterClass$RequestCreatePoll);
    }

    public static PollOuterClass$RequestCreatePoll parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PollOuterClass$RequestCreatePoll) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PollOuterClass$RequestCreatePoll parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PollOuterClass$RequestCreatePoll) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PollOuterClass$RequestCreatePoll parseFrom(AbstractC2383g abstractC2383g) {
        return (PollOuterClass$RequestCreatePoll) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PollOuterClass$RequestCreatePoll parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PollOuterClass$RequestCreatePoll) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PollOuterClass$RequestCreatePoll parseFrom(byte[] bArr) {
        return (PollOuterClass$RequestCreatePoll) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PollOuterClass$RequestCreatePoll parseFrom(byte[] bArr, C2394s c2394s) {
        return (PollOuterClass$RequestCreatePoll) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PollOuterClass$RequestCreatePoll parseFrom(InputStream inputStream) {
        return (PollOuterClass$RequestCreatePoll) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PollOuterClass$RequestCreatePoll parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PollOuterClass$RequestCreatePoll) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PollOuterClass$RequestCreatePoll parseFrom(AbstractC2384h abstractC2384h) {
        return (PollOuterClass$RequestCreatePoll) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PollOuterClass$RequestCreatePoll parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PollOuterClass$RequestCreatePoll) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
