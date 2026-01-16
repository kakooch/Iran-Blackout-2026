package ai.bale.proto;

import ai.bale.proto.PeersStruct$OutPeer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingOuterClass$RequestClearChat extends GeneratedMessageLite implements U64 {
    private static final MessagingOuterClass$RequestClearChat DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 1;
    private int bitField0_;
    private PeersStruct$OutPeer peer_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(PeersStruct$OutPeer peersStruct$OutPeer) {
            q();
            ((MessagingOuterClass$RequestClearChat) this.b).setPeer(peersStruct$OutPeer);
            return this;
        }

        private a() {
            super(MessagingOuterClass$RequestClearChat.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingOuterClass$RequestClearChat messagingOuterClass$RequestClearChat = new MessagingOuterClass$RequestClearChat();
        DEFAULT_INSTANCE = messagingOuterClass$RequestClearChat;
        GeneratedMessageLite.registerDefaultInstance(MessagingOuterClass$RequestClearChat.class, messagingOuterClass$RequestClearChat);
    }

    private MessagingOuterClass$RequestClearChat() {
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -2;
    }

    public static MessagingOuterClass$RequestClearChat getDefaultInstance() {
        return DEFAULT_INSTANCE;
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

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingOuterClass$RequestClearChat parseDelimitedFrom(InputStream inputStream) {
        return (MessagingOuterClass$RequestClearChat) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$RequestClearChat parseFrom(ByteBuffer byteBuffer) {
        return (MessagingOuterClass$RequestClearChat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPeer(PeersStruct$OutPeer peersStruct$OutPeer) {
        peersStruct$OutPeer.getClass();
        this.peer_ = peersStruct$OutPeer;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (K0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingOuterClass$RequestClearChat();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "peer_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingOuterClass$RequestClearChat.class) {
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

    public PeersStruct$OutPeer getPeer() {
        PeersStruct$OutPeer peersStruct$OutPeer = this.peer_;
        return peersStruct$OutPeer == null ? PeersStruct$OutPeer.getDefaultInstance() : peersStruct$OutPeer;
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MessagingOuterClass$RequestClearChat messagingOuterClass$RequestClearChat) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingOuterClass$RequestClearChat);
    }

    public static MessagingOuterClass$RequestClearChat parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$RequestClearChat) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$RequestClearChat parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingOuterClass$RequestClearChat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingOuterClass$RequestClearChat parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingOuterClass$RequestClearChat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingOuterClass$RequestClearChat parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingOuterClass$RequestClearChat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingOuterClass$RequestClearChat parseFrom(byte[] bArr) {
        return (MessagingOuterClass$RequestClearChat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingOuterClass$RequestClearChat parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingOuterClass$RequestClearChat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingOuterClass$RequestClearChat parseFrom(InputStream inputStream) {
        return (MessagingOuterClass$RequestClearChat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$RequestClearChat parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$RequestClearChat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$RequestClearChat parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingOuterClass$RequestClearChat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingOuterClass$RequestClearChat parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingOuterClass$RequestClearChat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
