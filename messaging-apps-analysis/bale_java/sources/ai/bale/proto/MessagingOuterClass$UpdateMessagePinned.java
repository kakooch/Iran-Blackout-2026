package ai.bale.proto;

import ai.bale.proto.MessagingStruct$MessageContainer;
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
public final class MessagingOuterClass$UpdateMessagePinned extends GeneratedMessageLite implements U64 {
    private static final MessagingOuterClass$UpdateMessagePinned DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 1;
    public static final int PINNED_MESSAGE_FIELD_NUMBER = 2;
    private int bitField0_;
    private PeersStruct$ExPeer peer_;
    private MessagingStruct$MessageContainer pinnedMessage_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingOuterClass$UpdateMessagePinned.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingOuterClass$UpdateMessagePinned messagingOuterClass$UpdateMessagePinned = new MessagingOuterClass$UpdateMessagePinned();
        DEFAULT_INSTANCE = messagingOuterClass$UpdateMessagePinned;
        GeneratedMessageLite.registerDefaultInstance(MessagingOuterClass$UpdateMessagePinned.class, messagingOuterClass$UpdateMessagePinned);
    }

    private MessagingOuterClass$UpdateMessagePinned() {
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearPinnedMessage() {
        this.pinnedMessage_ = null;
        this.bitField0_ &= -3;
    }

    public static MessagingOuterClass$UpdateMessagePinned getDefaultInstance() {
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

    private void mergePinnedMessage(MessagingStruct$MessageContainer messagingStruct$MessageContainer) {
        messagingStruct$MessageContainer.getClass();
        MessagingStruct$MessageContainer messagingStruct$MessageContainer2 = this.pinnedMessage_;
        if (messagingStruct$MessageContainer2 == null || messagingStruct$MessageContainer2 == MessagingStruct$MessageContainer.getDefaultInstance()) {
            this.pinnedMessage_ = messagingStruct$MessageContainer;
        } else {
            this.pinnedMessage_ = (MessagingStruct$MessageContainer) ((MessagingStruct$MessageContainer.a) MessagingStruct$MessageContainer.newBuilder(this.pinnedMessage_).v(messagingStruct$MessageContainer)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingOuterClass$UpdateMessagePinned parseDelimitedFrom(InputStream inputStream) {
        return (MessagingOuterClass$UpdateMessagePinned) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$UpdateMessagePinned parseFrom(ByteBuffer byteBuffer) {
        return (MessagingOuterClass$UpdateMessagePinned) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        this.peer_ = peersStruct$ExPeer;
        this.bitField0_ |= 1;
    }

    private void setPinnedMessage(MessagingStruct$MessageContainer messagingStruct$MessageContainer) {
        messagingStruct$MessageContainer.getClass();
        this.pinnedMessage_ = messagingStruct$MessageContainer;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (K0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingOuterClass$UpdateMessagePinned();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"bitField0_", "peer_", "pinnedMessage_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingOuterClass$UpdateMessagePinned.class) {
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

    public MessagingStruct$MessageContainer getPinnedMessage() {
        MessagingStruct$MessageContainer messagingStruct$MessageContainer = this.pinnedMessage_;
        return messagingStruct$MessageContainer == null ? MessagingStruct$MessageContainer.getDefaultInstance() : messagingStruct$MessageContainer;
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasPinnedMessage() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(MessagingOuterClass$UpdateMessagePinned messagingOuterClass$UpdateMessagePinned) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingOuterClass$UpdateMessagePinned);
    }

    public static MessagingOuterClass$UpdateMessagePinned parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$UpdateMessagePinned) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$UpdateMessagePinned parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingOuterClass$UpdateMessagePinned) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingOuterClass$UpdateMessagePinned parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingOuterClass$UpdateMessagePinned) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingOuterClass$UpdateMessagePinned parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingOuterClass$UpdateMessagePinned) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingOuterClass$UpdateMessagePinned parseFrom(byte[] bArr) {
        return (MessagingOuterClass$UpdateMessagePinned) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingOuterClass$UpdateMessagePinned parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingOuterClass$UpdateMessagePinned) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingOuterClass$UpdateMessagePinned parseFrom(InputStream inputStream) {
        return (MessagingOuterClass$UpdateMessagePinned) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$UpdateMessagePinned parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$UpdateMessagePinned) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$UpdateMessagePinned parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingOuterClass$UpdateMessagePinned) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingOuterClass$UpdateMessagePinned parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingOuterClass$UpdateMessagePinned) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
