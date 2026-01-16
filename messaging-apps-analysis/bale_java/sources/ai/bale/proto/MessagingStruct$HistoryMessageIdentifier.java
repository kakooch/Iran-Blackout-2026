package ai.bale.proto;

import ai.bale.proto.PeersStruct$OutPeer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC5375Jb4;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingStruct$HistoryMessageIdentifier extends GeneratedMessageLite implements InterfaceC5375Jb4 {
    public static final int DATE_FIELD_NUMBER = 3;
    private static final MessagingStruct$HistoryMessageIdentifier DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 1;
    public static final int RANDOM_ID_FIELD_NUMBER = 2;
    private int bitField0_;
    private long date_;
    private PeersStruct$OutPeer peer_;
    private long randomId_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC5375Jb4 {
        public a A(long j) {
            q();
            ((MessagingStruct$HistoryMessageIdentifier) this.b).setDate(j);
            return this;
        }

        public a B(PeersStruct$OutPeer.a aVar) {
            q();
            ((MessagingStruct$HistoryMessageIdentifier) this.b).setPeer((PeersStruct$OutPeer) aVar.a());
            return this;
        }

        public a C(PeersStruct$OutPeer peersStruct$OutPeer) {
            q();
            ((MessagingStruct$HistoryMessageIdentifier) this.b).setPeer(peersStruct$OutPeer);
            return this;
        }

        public a D(long j) {
            q();
            ((MessagingStruct$HistoryMessageIdentifier) this.b).setRandomId(j);
            return this;
        }

        private a() {
            super(MessagingStruct$HistoryMessageIdentifier.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier = new MessagingStruct$HistoryMessageIdentifier();
        DEFAULT_INSTANCE = messagingStruct$HistoryMessageIdentifier;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$HistoryMessageIdentifier.class, messagingStruct$HistoryMessageIdentifier);
    }

    private MessagingStruct$HistoryMessageIdentifier() {
    }

    private void clearDate() {
        this.date_ = 0L;
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearRandomId() {
        this.randomId_ = 0L;
    }

    public static MessagingStruct$HistoryMessageIdentifier getDefaultInstance() {
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

    public static MessagingStruct$HistoryMessageIdentifier parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$HistoryMessageIdentifier) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$HistoryMessageIdentifier parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$HistoryMessageIdentifier) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDate(long j) {
        this.date_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPeer(PeersStruct$OutPeer peersStruct$OutPeer) {
        peersStruct$OutPeer.getClass();
        this.peer_ = peersStruct$OutPeer;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRandomId(long j) {
        this.randomId_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$HistoryMessageIdentifier();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0002\u0003\u0002", new Object[]{"bitField0_", "peer_", "randomId_", "date_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$HistoryMessageIdentifier.class) {
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

    public PeersStruct$OutPeer getPeer() {
        PeersStruct$OutPeer peersStruct$OutPeer = this.peer_;
        return peersStruct$OutPeer == null ? PeersStruct$OutPeer.getDefaultInstance() : peersStruct$OutPeer;
    }

    public long getRandomId() {
        return this.randomId_;
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$HistoryMessageIdentifier);
    }

    public static MessagingStruct$HistoryMessageIdentifier parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$HistoryMessageIdentifier) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$HistoryMessageIdentifier parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$HistoryMessageIdentifier) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$HistoryMessageIdentifier parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$HistoryMessageIdentifier) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$HistoryMessageIdentifier parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$HistoryMessageIdentifier) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$HistoryMessageIdentifier parseFrom(byte[] bArr) {
        return (MessagingStruct$HistoryMessageIdentifier) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$HistoryMessageIdentifier parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$HistoryMessageIdentifier) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$HistoryMessageIdentifier parseFrom(InputStream inputStream) {
        return (MessagingStruct$HistoryMessageIdentifier) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$HistoryMessageIdentifier parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$HistoryMessageIdentifier) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$HistoryMessageIdentifier parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$HistoryMessageIdentifier) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$HistoryMessageIdentifier parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$HistoryMessageIdentifier) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
