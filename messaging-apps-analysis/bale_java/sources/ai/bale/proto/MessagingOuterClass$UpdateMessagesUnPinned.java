package ai.bale.proto;

import ai.bale.proto.PeersStruct$ExPeer;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC13043fc4;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MessagingOuterClass$UpdateMessagesUnPinned extends GeneratedMessageLite implements U64 {
    public static final int ALL_FIELD_NUMBER = 3;
    private static final MessagingOuterClass$UpdateMessagesUnPinned DEFAULT_INSTANCE;
    public static final int MESSAGE_IDS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 2;
    private boolean all_;
    private int bitField0_;
    private B.j messageIds_ = GeneratedMessageLite.emptyProtobufList();
    private PeersStruct$ExPeer peer_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingOuterClass$UpdateMessagesUnPinned.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingOuterClass$UpdateMessagesUnPinned messagingOuterClass$UpdateMessagesUnPinned = new MessagingOuterClass$UpdateMessagesUnPinned();
        DEFAULT_INSTANCE = messagingOuterClass$UpdateMessagesUnPinned;
        GeneratedMessageLite.registerDefaultInstance(MessagingOuterClass$UpdateMessagesUnPinned.class, messagingOuterClass$UpdateMessagesUnPinned);
    }

    private MessagingOuterClass$UpdateMessagesUnPinned() {
    }

    private void addAllMessageIds(Iterable<? extends MessagingStruct$MessageId> iterable) {
        ensureMessageIdsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.messageIds_);
    }

    private void addMessageIds(MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        ensureMessageIdsIsMutable();
        this.messageIds_.add(messagingStruct$MessageId);
    }

    private void clearAll() {
        this.all_ = false;
    }

    private void clearMessageIds() {
        this.messageIds_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -2;
    }

    private void ensureMessageIdsIsMutable() {
        B.j jVar = this.messageIds_;
        if (jVar.u()) {
            return;
        }
        this.messageIds_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MessagingOuterClass$UpdateMessagesUnPinned getDefaultInstance() {
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

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingOuterClass$UpdateMessagesUnPinned parseDelimitedFrom(InputStream inputStream) {
        return (MessagingOuterClass$UpdateMessagesUnPinned) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$UpdateMessagesUnPinned parseFrom(ByteBuffer byteBuffer) {
        return (MessagingOuterClass$UpdateMessagesUnPinned) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeMessageIds(int i) {
        ensureMessageIdsIsMutable();
        this.messageIds_.remove(i);
    }

    private void setAll(boolean z) {
        this.all_ = z;
    }

    private void setMessageIds(int i, MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        ensureMessageIdsIsMutable();
        this.messageIds_.set(i, messagingStruct$MessageId);
    }

    private void setPeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        this.peer_ = peersStruct$ExPeer;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (K0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingOuterClass$UpdateMessagesUnPinned();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000\u0003\u0007", new Object[]{"bitField0_", "messageIds_", MessagingStruct$MessageId.class, "peer_", "all_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingOuterClass$UpdateMessagesUnPinned.class) {
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

    public boolean getAll() {
        return this.all_;
    }

    public MessagingStruct$MessageId getMessageIds(int i) {
        return (MessagingStruct$MessageId) this.messageIds_.get(i);
    }

    public int getMessageIdsCount() {
        return this.messageIds_.size();
    }

    public List<MessagingStruct$MessageId> getMessageIdsList() {
        return this.messageIds_;
    }

    public InterfaceC13043fc4 getMessageIdsOrBuilder(int i) {
        return (InterfaceC13043fc4) this.messageIds_.get(i);
    }

    public List<? extends InterfaceC13043fc4> getMessageIdsOrBuilderList() {
        return this.messageIds_;
    }

    public PeersStruct$ExPeer getPeer() {
        PeersStruct$ExPeer peersStruct$ExPeer = this.peer_;
        return peersStruct$ExPeer == null ? PeersStruct$ExPeer.getDefaultInstance() : peersStruct$ExPeer;
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MessagingOuterClass$UpdateMessagesUnPinned messagingOuterClass$UpdateMessagesUnPinned) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingOuterClass$UpdateMessagesUnPinned);
    }

    public static MessagingOuterClass$UpdateMessagesUnPinned parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$UpdateMessagesUnPinned) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$UpdateMessagesUnPinned parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingOuterClass$UpdateMessagesUnPinned) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingOuterClass$UpdateMessagesUnPinned parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingOuterClass$UpdateMessagesUnPinned) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addMessageIds(int i, MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        ensureMessageIdsIsMutable();
        this.messageIds_.add(i, messagingStruct$MessageId);
    }

    public static MessagingOuterClass$UpdateMessagesUnPinned parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingOuterClass$UpdateMessagesUnPinned) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingOuterClass$UpdateMessagesUnPinned parseFrom(byte[] bArr) {
        return (MessagingOuterClass$UpdateMessagesUnPinned) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingOuterClass$UpdateMessagesUnPinned parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingOuterClass$UpdateMessagesUnPinned) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingOuterClass$UpdateMessagesUnPinned parseFrom(InputStream inputStream) {
        return (MessagingOuterClass$UpdateMessagesUnPinned) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$UpdateMessagesUnPinned parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$UpdateMessagesUnPinned) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$UpdateMessagesUnPinned parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingOuterClass$UpdateMessagesUnPinned) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingOuterClass$UpdateMessagesUnPinned parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingOuterClass$UpdateMessagesUnPinned) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
