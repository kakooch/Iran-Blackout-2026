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

/* loaded from: classes9.dex */
public final class MavizStreamOuterClass$RequestUnsubscribeFromThreadUpdates extends GeneratedMessageLite implements U64 {
    private static final MavizStreamOuterClass$RequestUnsubscribeFromThreadUpdates DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 1;
    public static final int THREAD_ID_FIELD_NUMBER = 2;
    private int bitField0_;
    private PeersStruct$ExPeer peer_;
    private MessagingStruct$MessageId threadId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(PeersStruct$ExPeer.a aVar) {
            q();
            ((MavizStreamOuterClass$RequestUnsubscribeFromThreadUpdates) this.b).setPeer((PeersStruct$ExPeer) aVar.a());
            return this;
        }

        public a B(MessagingStruct$MessageId messagingStruct$MessageId) {
            q();
            ((MavizStreamOuterClass$RequestUnsubscribeFromThreadUpdates) this.b).setThreadId(messagingStruct$MessageId);
            return this;
        }

        private a() {
            super(MavizStreamOuterClass$RequestUnsubscribeFromThreadUpdates.DEFAULT_INSTANCE);
        }
    }

    static {
        MavizStreamOuterClass$RequestUnsubscribeFromThreadUpdates mavizStreamOuterClass$RequestUnsubscribeFromThreadUpdates = new MavizStreamOuterClass$RequestUnsubscribeFromThreadUpdates();
        DEFAULT_INSTANCE = mavizStreamOuterClass$RequestUnsubscribeFromThreadUpdates;
        GeneratedMessageLite.registerDefaultInstance(MavizStreamOuterClass$RequestUnsubscribeFromThreadUpdates.class, mavizStreamOuterClass$RequestUnsubscribeFromThreadUpdates);
    }

    private MavizStreamOuterClass$RequestUnsubscribeFromThreadUpdates() {
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearThreadId() {
        this.threadId_ = null;
        this.bitField0_ &= -3;
    }

    public static MavizStreamOuterClass$RequestUnsubscribeFromThreadUpdates getDefaultInstance() {
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

    public static MavizStreamOuterClass$RequestUnsubscribeFromThreadUpdates parseDelimitedFrom(InputStream inputStream) {
        return (MavizStreamOuterClass$RequestUnsubscribeFromThreadUpdates) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MavizStreamOuterClass$RequestUnsubscribeFromThreadUpdates parseFrom(ByteBuffer byteBuffer) {
        return (MavizStreamOuterClass$RequestUnsubscribeFromThreadUpdates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
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
        switch (E0.a[gVar.ordinal()]) {
            case 1:
                return new MavizStreamOuterClass$RequestUnsubscribeFromThreadUpdates();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"bitField0_", "peer_", "threadId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MavizStreamOuterClass$RequestUnsubscribeFromThreadUpdates.class) {
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

    public static a newBuilder(MavizStreamOuterClass$RequestUnsubscribeFromThreadUpdates mavizStreamOuterClass$RequestUnsubscribeFromThreadUpdates) {
        return (a) DEFAULT_INSTANCE.createBuilder(mavizStreamOuterClass$RequestUnsubscribeFromThreadUpdates);
    }

    public static MavizStreamOuterClass$RequestUnsubscribeFromThreadUpdates parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MavizStreamOuterClass$RequestUnsubscribeFromThreadUpdates) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MavizStreamOuterClass$RequestUnsubscribeFromThreadUpdates parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MavizStreamOuterClass$RequestUnsubscribeFromThreadUpdates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MavizStreamOuterClass$RequestUnsubscribeFromThreadUpdates parseFrom(AbstractC2383g abstractC2383g) {
        return (MavizStreamOuterClass$RequestUnsubscribeFromThreadUpdates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MavizStreamOuterClass$RequestUnsubscribeFromThreadUpdates parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MavizStreamOuterClass$RequestUnsubscribeFromThreadUpdates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MavizStreamOuterClass$RequestUnsubscribeFromThreadUpdates parseFrom(byte[] bArr) {
        return (MavizStreamOuterClass$RequestUnsubscribeFromThreadUpdates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MavizStreamOuterClass$RequestUnsubscribeFromThreadUpdates parseFrom(byte[] bArr, C2394s c2394s) {
        return (MavizStreamOuterClass$RequestUnsubscribeFromThreadUpdates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MavizStreamOuterClass$RequestUnsubscribeFromThreadUpdates parseFrom(InputStream inputStream) {
        return (MavizStreamOuterClass$RequestUnsubscribeFromThreadUpdates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MavizStreamOuterClass$RequestUnsubscribeFromThreadUpdates parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MavizStreamOuterClass$RequestUnsubscribeFromThreadUpdates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MavizStreamOuterClass$RequestUnsubscribeFromThreadUpdates parseFrom(AbstractC2384h abstractC2384h) {
        return (MavizStreamOuterClass$RequestUnsubscribeFromThreadUpdates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MavizStreamOuterClass$RequestUnsubscribeFromThreadUpdates parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MavizStreamOuterClass$RequestUnsubscribeFromThreadUpdates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
