package ai.bale.proto;

import ai.bale.proto.MessagingStruct$MessageId;
import ai.bale.proto.PeersStruct$ExPeer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC6845Pf4;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingOuterClass$RequestLoadReplies extends GeneratedMessageLite implements U64 {
    public static final int DATE_FIELD_NUMBER = 3;
    private static final MessagingOuterClass$RequestLoadReplies DEFAULT_INSTANCE;
    public static final int LIMIT_FIELD_NUMBER = 5;
    public static final int LOAD_MODE_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 1;
    public static final int THREAD_ID_FIELD_NUMBER = 2;
    private int bitField0_;
    private long date_;
    private int limit_;
    private int loadMode_;
    private PeersStruct$ExPeer peer_;
    private MessagingStruct$MessageId threadId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(long j) {
            q();
            ((MessagingOuterClass$RequestLoadReplies) this.b).setDate(j);
            return this;
        }

        public a B(int i) {
            q();
            ((MessagingOuterClass$RequestLoadReplies) this.b).setLimit(i);
            return this;
        }

        public a C(EnumC6845Pf4 enumC6845Pf4) {
            q();
            ((MessagingOuterClass$RequestLoadReplies) this.b).setLoadMode(enumC6845Pf4);
            return this;
        }

        public a D(PeersStruct$ExPeer peersStruct$ExPeer) {
            q();
            ((MessagingOuterClass$RequestLoadReplies) this.b).setPeer(peersStruct$ExPeer);
            return this;
        }

        public a E(MessagingStruct$MessageId messagingStruct$MessageId) {
            q();
            ((MessagingOuterClass$RequestLoadReplies) this.b).setThreadId(messagingStruct$MessageId);
            return this;
        }

        private a() {
            super(MessagingOuterClass$RequestLoadReplies.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingOuterClass$RequestLoadReplies messagingOuterClass$RequestLoadReplies = new MessagingOuterClass$RequestLoadReplies();
        DEFAULT_INSTANCE = messagingOuterClass$RequestLoadReplies;
        GeneratedMessageLite.registerDefaultInstance(MessagingOuterClass$RequestLoadReplies.class, messagingOuterClass$RequestLoadReplies);
    }

    private MessagingOuterClass$RequestLoadReplies() {
    }

    private void clearDate() {
        this.date_ = 0L;
    }

    private void clearLimit() {
        this.limit_ = 0;
    }

    private void clearLoadMode() {
        this.loadMode_ = 0;
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearThreadId() {
        this.threadId_ = null;
        this.bitField0_ &= -3;
    }

    public static MessagingOuterClass$RequestLoadReplies getDefaultInstance() {
        return DEFAULT_INSTANCE;
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

    private void mergeThreadId(MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        MessagingStruct$MessageId messagingStruct$MessageId2 = this.threadId_;
        if (messagingStruct$MessageId2 == null || messagingStruct$MessageId2 == MessagingStruct$MessageId.getDefaultInstance()) {
            this.threadId_ = messagingStruct$MessageId;
        } else {
            this.threadId_ = (MessagingStruct$MessageId) ((MessagingStruct$MessageId.a) MessagingStruct$MessageId.newBuilder(this.threadId_).v(messagingStruct$MessageId)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingOuterClass$RequestLoadReplies parseDelimitedFrom(InputStream inputStream) {
        return (MessagingOuterClass$RequestLoadReplies) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$RequestLoadReplies parseFrom(ByteBuffer byteBuffer) {
        return (MessagingOuterClass$RequestLoadReplies) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDate(long j) {
        this.date_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLimit(int i) {
        this.limit_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadMode(EnumC6845Pf4 enumC6845Pf4) {
        this.loadMode_ = enumC6845Pf4.getNumber();
    }

    private void setLoadModeValue(int i) {
        this.loadMode_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        this.peer_ = peersStruct$ExPeer;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setThreadId(MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        this.threadId_ = messagingStruct$MessageId;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (K0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingOuterClass$RequestLoadReplies();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u0002\u0004\f\u0005\u0004", new Object[]{"bitField0_", "peer_", "threadId_", "date_", "loadMode_", "limit_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingOuterClass$RequestLoadReplies.class) {
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

    public long getDate() {
        return this.date_;
    }

    public int getLimit() {
        return this.limit_;
    }

    public EnumC6845Pf4 getLoadMode() {
        EnumC6845Pf4 enumC6845Pf4J = EnumC6845Pf4.j(this.loadMode_);
        return enumC6845Pf4J == null ? EnumC6845Pf4.UNRECOGNIZED : enumC6845Pf4J;
    }

    public int getLoadModeValue() {
        return this.loadMode_;
    }

    public PeersStruct$ExPeer getPeer() {
        PeersStruct$ExPeer peersStruct$ExPeer = this.peer_;
        return peersStruct$ExPeer == null ? PeersStruct$ExPeer.getDefaultInstance() : peersStruct$ExPeer;
    }

    public MessagingStruct$MessageId getThreadId() {
        MessagingStruct$MessageId messagingStruct$MessageId = this.threadId_;
        return messagingStruct$MessageId == null ? MessagingStruct$MessageId.getDefaultInstance() : messagingStruct$MessageId;
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasThreadId() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(MessagingOuterClass$RequestLoadReplies messagingOuterClass$RequestLoadReplies) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingOuterClass$RequestLoadReplies);
    }

    public static MessagingOuterClass$RequestLoadReplies parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$RequestLoadReplies) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$RequestLoadReplies parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingOuterClass$RequestLoadReplies) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingOuterClass$RequestLoadReplies parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingOuterClass$RequestLoadReplies) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingOuterClass$RequestLoadReplies parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingOuterClass$RequestLoadReplies) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingOuterClass$RequestLoadReplies parseFrom(byte[] bArr) {
        return (MessagingOuterClass$RequestLoadReplies) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingOuterClass$RequestLoadReplies parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingOuterClass$RequestLoadReplies) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingOuterClass$RequestLoadReplies parseFrom(InputStream inputStream) {
        return (MessagingOuterClass$RequestLoadReplies) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$RequestLoadReplies parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$RequestLoadReplies) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$RequestLoadReplies parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingOuterClass$RequestLoadReplies) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingOuterClass$RequestLoadReplies parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingOuterClass$RequestLoadReplies) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
