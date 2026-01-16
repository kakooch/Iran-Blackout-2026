package ai.bale.proto;

import ai.bale.proto.PeersStruct$ExPeer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC7071Qd4;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingStruct$UnreadPeer extends GeneratedMessageLite implements InterfaceC7071Qd4 {
    private static final MessagingStruct$UnreadPeer DEFAULT_INSTANCE;
    public static final int IS_MUTED_FIELD_NUMBER = 3;
    public static final int LAST_MESSAGE_DATE_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 1;
    private int bitField0_;
    private boolean isMuted_;
    private long lastMessageDate_;
    private PeersStruct$ExPeer peer_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC7071Qd4 {
        private a() {
            super(MessagingStruct$UnreadPeer.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$UnreadPeer messagingStruct$UnreadPeer = new MessagingStruct$UnreadPeer();
        DEFAULT_INSTANCE = messagingStruct$UnreadPeer;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$UnreadPeer.class, messagingStruct$UnreadPeer);
    }

    private MessagingStruct$UnreadPeer() {
    }

    private void clearIsMuted() {
        this.isMuted_ = false;
    }

    private void clearLastMessageDate() {
        this.lastMessageDate_ = 0L;
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -2;
    }

    public static MessagingStruct$UnreadPeer getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        PeersStruct$ExPeer peersStruct$ExPeer2 = this.peer_;
        if (peersStruct$ExPeer2 != null && peersStruct$ExPeer2 != PeersStruct$ExPeer.getDefaultInstance()) {
            peersStruct$ExPeer = (PeersStruct$ExPeer) ((PeersStruct$ExPeer.a) PeersStruct$ExPeer.newBuilder(this.peer_).v(peersStruct$ExPeer)).j();
        }
        this.peer_ = peersStruct$ExPeer;
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$UnreadPeer parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$UnreadPeer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$UnreadPeer parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$UnreadPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setIsMuted(boolean z) {
        this.isMuted_ = z;
    }

    private void setLastMessageDate(long j) {
        this.lastMessageDate_ = j;
    }

    private void setPeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        this.peer_ = peersStruct$ExPeer;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$UnreadPeer();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0002\u0003\u0007", new Object[]{"bitField0_", "peer_", "lastMessageDate_", "isMuted_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$UnreadPeer.class) {
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

    public boolean getIsMuted() {
        return this.isMuted_;
    }

    public long getLastMessageDate() {
        return this.lastMessageDate_;
    }

    public PeersStruct$ExPeer getPeer() {
        PeersStruct$ExPeer peersStruct$ExPeer = this.peer_;
        return peersStruct$ExPeer == null ? PeersStruct$ExPeer.getDefaultInstance() : peersStruct$ExPeer;
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MessagingStruct$UnreadPeer messagingStruct$UnreadPeer) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$UnreadPeer);
    }

    public static MessagingStruct$UnreadPeer parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$UnreadPeer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$UnreadPeer parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$UnreadPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$UnreadPeer parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$UnreadPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$UnreadPeer parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$UnreadPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }

    public static MessagingStruct$UnreadPeer parseFrom(InputStream inputStream) {
        return (MessagingStruct$UnreadPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$UnreadPeer parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$UnreadPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$UnreadPeer parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$UnreadPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static MessagingStruct$UnreadPeer parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$UnreadPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$UnreadPeer parseFrom(byte[] bArr) {
        return (MessagingStruct$UnreadPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$UnreadPeer parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$UnreadPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }
}
