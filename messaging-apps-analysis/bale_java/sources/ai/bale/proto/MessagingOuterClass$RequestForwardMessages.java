package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int64Value;
import ai.bale.proto.PeersStruct$OutExPeer;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC14252hc4;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MessagingOuterClass$RequestForwardMessages extends GeneratedMessageLite implements U64 {
    private static final MessagingOuterClass$RequestForwardMessages DEFAULT_INSTANCE;
    public static final int FORWARDED_MESSAGES_FIELD_NUMBER = 3;
    public static final int GROUPED_ID_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 1;
    public static final int RID_FIELD_NUMBER = 2;
    private int bitField0_;
    private CollectionsStruct$Int64Value groupedId_;
    private PeersStruct$OutExPeer peer_;
    private int ridMemoizedSerializedSize = -1;
    private B.i rid_ = GeneratedMessageLite.emptyLongList();
    private B.j forwardedMessages_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(MessagingStruct$MessageOutReference messagingStruct$MessageOutReference) {
            q();
            ((MessagingOuterClass$RequestForwardMessages) this.b).addForwardedMessages(messagingStruct$MessageOutReference);
            return this;
        }

        public a B(long j) {
            q();
            ((MessagingOuterClass$RequestForwardMessages) this.b).addRid(j);
            return this;
        }

        public a C(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
            q();
            ((MessagingOuterClass$RequestForwardMessages) this.b).setGroupedId(collectionsStruct$Int64Value);
            return this;
        }

        public a D(PeersStruct$OutExPeer peersStruct$OutExPeer) {
            q();
            ((MessagingOuterClass$RequestForwardMessages) this.b).setPeer(peersStruct$OutExPeer);
            return this;
        }

        private a() {
            super(MessagingOuterClass$RequestForwardMessages.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingOuterClass$RequestForwardMessages messagingOuterClass$RequestForwardMessages = new MessagingOuterClass$RequestForwardMessages();
        DEFAULT_INSTANCE = messagingOuterClass$RequestForwardMessages;
        GeneratedMessageLite.registerDefaultInstance(MessagingOuterClass$RequestForwardMessages.class, messagingOuterClass$RequestForwardMessages);
    }

    private MessagingOuterClass$RequestForwardMessages() {
    }

    private void addAllForwardedMessages(Iterable<? extends MessagingStruct$MessageOutReference> iterable) {
        ensureForwardedMessagesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.forwardedMessages_);
    }

    private void addAllRid(Iterable<? extends Long> iterable) {
        ensureRidIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.rid_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addForwardedMessages(MessagingStruct$MessageOutReference messagingStruct$MessageOutReference) {
        messagingStruct$MessageOutReference.getClass();
        ensureForwardedMessagesIsMutable();
        this.forwardedMessages_.add(messagingStruct$MessageOutReference);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRid(long j) {
        ensureRidIsMutable();
        this.rid_.l1(j);
    }

    private void clearForwardedMessages() {
        this.forwardedMessages_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearGroupedId() {
        this.groupedId_ = null;
        this.bitField0_ &= -3;
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearRid() {
        this.rid_ = GeneratedMessageLite.emptyLongList();
    }

    private void ensureForwardedMessagesIsMutable() {
        B.j jVar = this.forwardedMessages_;
        if (jVar.u()) {
            return;
        }
        this.forwardedMessages_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureRidIsMutable() {
        B.i iVar = this.rid_;
        if (iVar.u()) {
            return;
        }
        this.rid_ = GeneratedMessageLite.mutableCopy(iVar);
    }

    public static MessagingOuterClass$RequestForwardMessages getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeGroupedId(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.groupedId_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.groupedId_ = collectionsStruct$Int64Value;
        } else {
            this.groupedId_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.groupedId_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergePeer(PeersStruct$OutExPeer peersStruct$OutExPeer) {
        peersStruct$OutExPeer.getClass();
        PeersStruct$OutExPeer peersStruct$OutExPeer2 = this.peer_;
        if (peersStruct$OutExPeer2 == null || peersStruct$OutExPeer2 == PeersStruct$OutExPeer.getDefaultInstance()) {
            this.peer_ = peersStruct$OutExPeer;
        } else {
            this.peer_ = (PeersStruct$OutExPeer) ((PeersStruct$OutExPeer.a) PeersStruct$OutExPeer.newBuilder(this.peer_).v(peersStruct$OutExPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingOuterClass$RequestForwardMessages parseDelimitedFrom(InputStream inputStream) {
        return (MessagingOuterClass$RequestForwardMessages) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$RequestForwardMessages parseFrom(ByteBuffer byteBuffer) {
        return (MessagingOuterClass$RequestForwardMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeForwardedMessages(int i) {
        ensureForwardedMessagesIsMutable();
        this.forwardedMessages_.remove(i);
    }

    private void setForwardedMessages(int i, MessagingStruct$MessageOutReference messagingStruct$MessageOutReference) {
        messagingStruct$MessageOutReference.getClass();
        ensureForwardedMessagesIsMutable();
        this.forwardedMessages_.set(i, messagingStruct$MessageOutReference);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGroupedId(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.groupedId_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPeer(PeersStruct$OutExPeer peersStruct$OutExPeer) {
        peersStruct$OutExPeer.getClass();
        this.peer_ = peersStruct$OutExPeer;
        this.bitField0_ |= 1;
    }

    private void setRid(int i, long j) {
        ensureRidIsMutable();
        this.rid_.z1(i, j);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (K0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingOuterClass$RequestForwardMessages();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001ဉ\u0000\u0002%\u0003\u001b\u0004ဉ\u0001", new Object[]{"bitField0_", "peer_", "rid_", "forwardedMessages_", MessagingStruct$MessageOutReference.class, "groupedId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingOuterClass$RequestForwardMessages.class) {
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

    public MessagingStruct$MessageOutReference getForwardedMessages(int i) {
        return (MessagingStruct$MessageOutReference) this.forwardedMessages_.get(i);
    }

    public int getForwardedMessagesCount() {
        return this.forwardedMessages_.size();
    }

    public List<MessagingStruct$MessageOutReference> getForwardedMessagesList() {
        return this.forwardedMessages_;
    }

    public InterfaceC14252hc4 getForwardedMessagesOrBuilder(int i) {
        return (InterfaceC14252hc4) this.forwardedMessages_.get(i);
    }

    public List<? extends InterfaceC14252hc4> getForwardedMessagesOrBuilderList() {
        return this.forwardedMessages_;
    }

    public CollectionsStruct$Int64Value getGroupedId() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.groupedId_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public PeersStruct$OutExPeer getPeer() {
        PeersStruct$OutExPeer peersStruct$OutExPeer = this.peer_;
        return peersStruct$OutExPeer == null ? PeersStruct$OutExPeer.getDefaultInstance() : peersStruct$OutExPeer;
    }

    public long getRid(int i) {
        return this.rid_.getLong(i);
    }

    public int getRidCount() {
        return this.rid_.size();
    }

    public List<Long> getRidList() {
        return this.rid_;
    }

    public boolean hasGroupedId() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MessagingOuterClass$RequestForwardMessages messagingOuterClass$RequestForwardMessages) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingOuterClass$RequestForwardMessages);
    }

    public static MessagingOuterClass$RequestForwardMessages parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$RequestForwardMessages) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$RequestForwardMessages parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingOuterClass$RequestForwardMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingOuterClass$RequestForwardMessages parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingOuterClass$RequestForwardMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addForwardedMessages(int i, MessagingStruct$MessageOutReference messagingStruct$MessageOutReference) {
        messagingStruct$MessageOutReference.getClass();
        ensureForwardedMessagesIsMutable();
        this.forwardedMessages_.add(i, messagingStruct$MessageOutReference);
    }

    public static MessagingOuterClass$RequestForwardMessages parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingOuterClass$RequestForwardMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingOuterClass$RequestForwardMessages parseFrom(byte[] bArr) {
        return (MessagingOuterClass$RequestForwardMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingOuterClass$RequestForwardMessages parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingOuterClass$RequestForwardMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingOuterClass$RequestForwardMessages parseFrom(InputStream inputStream) {
        return (MessagingOuterClass$RequestForwardMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$RequestForwardMessages parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$RequestForwardMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$RequestForwardMessages parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingOuterClass$RequestForwardMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingOuterClass$RequestForwardMessages parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingOuterClass$RequestForwardMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
