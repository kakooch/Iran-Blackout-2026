package ai.bale.proto;

import ai.bale.proto.PeersStruct$ExPeer;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC11027cc4;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MessagingOuterClass$UpdateMessages extends GeneratedMessageLite implements U64 {
    private static final MessagingOuterClass$UpdateMessages DEFAULT_INSTANCE;
    public static final int MESSAGE_CONTAINERS_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 1;
    private int bitField0_;
    private B.j messageContainers_ = GeneratedMessageLite.emptyProtobufList();
    private PeersStruct$ExPeer peer_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingOuterClass$UpdateMessages.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingOuterClass$UpdateMessages messagingOuterClass$UpdateMessages = new MessagingOuterClass$UpdateMessages();
        DEFAULT_INSTANCE = messagingOuterClass$UpdateMessages;
        GeneratedMessageLite.registerDefaultInstance(MessagingOuterClass$UpdateMessages.class, messagingOuterClass$UpdateMessages);
    }

    private MessagingOuterClass$UpdateMessages() {
    }

    private void addAllMessageContainers(Iterable<? extends MessagingStruct$MessageContainer> iterable) {
        ensureMessageContainersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.messageContainers_);
    }

    private void addMessageContainers(MessagingStruct$MessageContainer messagingStruct$MessageContainer) {
        messagingStruct$MessageContainer.getClass();
        ensureMessageContainersIsMutable();
        this.messageContainers_.add(messagingStruct$MessageContainer);
    }

    private void clearMessageContainers() {
        this.messageContainers_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -2;
    }

    private void ensureMessageContainersIsMutable() {
        B.j jVar = this.messageContainers_;
        if (jVar.u()) {
            return;
        }
        this.messageContainers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MessagingOuterClass$UpdateMessages getDefaultInstance() {
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

    public static MessagingOuterClass$UpdateMessages parseDelimitedFrom(InputStream inputStream) {
        return (MessagingOuterClass$UpdateMessages) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$UpdateMessages parseFrom(ByteBuffer byteBuffer) {
        return (MessagingOuterClass$UpdateMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeMessageContainers(int i) {
        ensureMessageContainersIsMutable();
        this.messageContainers_.remove(i);
    }

    private void setMessageContainers(int i, MessagingStruct$MessageContainer messagingStruct$MessageContainer) {
        messagingStruct$MessageContainer.getClass();
        ensureMessageContainersIsMutable();
        this.messageContainers_.set(i, messagingStruct$MessageContainer);
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
                return new MessagingOuterClass$UpdateMessages();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001b", new Object[]{"bitField0_", "peer_", "messageContainers_", MessagingStruct$MessageContainer.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingOuterClass$UpdateMessages.class) {
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

    public MessagingStruct$MessageContainer getMessageContainers(int i) {
        return (MessagingStruct$MessageContainer) this.messageContainers_.get(i);
    }

    public int getMessageContainersCount() {
        return this.messageContainers_.size();
    }

    public List<MessagingStruct$MessageContainer> getMessageContainersList() {
        return this.messageContainers_;
    }

    public InterfaceC11027cc4 getMessageContainersOrBuilder(int i) {
        return (InterfaceC11027cc4) this.messageContainers_.get(i);
    }

    public List<? extends InterfaceC11027cc4> getMessageContainersOrBuilderList() {
        return this.messageContainers_;
    }

    public PeersStruct$ExPeer getPeer() {
        PeersStruct$ExPeer peersStruct$ExPeer = this.peer_;
        return peersStruct$ExPeer == null ? PeersStruct$ExPeer.getDefaultInstance() : peersStruct$ExPeer;
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MessagingOuterClass$UpdateMessages messagingOuterClass$UpdateMessages) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingOuterClass$UpdateMessages);
    }

    public static MessagingOuterClass$UpdateMessages parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$UpdateMessages) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$UpdateMessages parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingOuterClass$UpdateMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingOuterClass$UpdateMessages parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingOuterClass$UpdateMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addMessageContainers(int i, MessagingStruct$MessageContainer messagingStruct$MessageContainer) {
        messagingStruct$MessageContainer.getClass();
        ensureMessageContainersIsMutable();
        this.messageContainers_.add(i, messagingStruct$MessageContainer);
    }

    public static MessagingOuterClass$UpdateMessages parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingOuterClass$UpdateMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingOuterClass$UpdateMessages parseFrom(byte[] bArr) {
        return (MessagingOuterClass$UpdateMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingOuterClass$UpdateMessages parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingOuterClass$UpdateMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingOuterClass$UpdateMessages parseFrom(InputStream inputStream) {
        return (MessagingOuterClass$UpdateMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$UpdateMessages parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$UpdateMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$UpdateMessages parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingOuterClass$UpdateMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingOuterClass$UpdateMessages parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingOuterClass$UpdateMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
