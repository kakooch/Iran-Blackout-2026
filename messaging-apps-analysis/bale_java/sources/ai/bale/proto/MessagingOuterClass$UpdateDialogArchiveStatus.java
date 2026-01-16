package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC9494a35;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MessagingOuterClass$UpdateDialogArchiveStatus extends GeneratedMessageLite implements U64 {
    private static final MessagingOuterClass$UpdateDialogArchiveStatus DEFAULT_INSTANCE;
    public static final int EX_PEERS_FIELD_NUMBER = 1;
    public static final int IS_ARCHIVED_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private B.j exPeers_ = GeneratedMessageLite.emptyProtobufList();
    private boolean isArchived_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingOuterClass$UpdateDialogArchiveStatus.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingOuterClass$UpdateDialogArchiveStatus messagingOuterClass$UpdateDialogArchiveStatus = new MessagingOuterClass$UpdateDialogArchiveStatus();
        DEFAULT_INSTANCE = messagingOuterClass$UpdateDialogArchiveStatus;
        GeneratedMessageLite.registerDefaultInstance(MessagingOuterClass$UpdateDialogArchiveStatus.class, messagingOuterClass$UpdateDialogArchiveStatus);
    }

    private MessagingOuterClass$UpdateDialogArchiveStatus() {
    }

    private void addAllExPeers(Iterable<? extends PeersStruct$ExPeer> iterable) {
        ensureExPeersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.exPeers_);
    }

    private void addExPeers(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        ensureExPeersIsMutable();
        this.exPeers_.add(peersStruct$ExPeer);
    }

    private void clearExPeers() {
        this.exPeers_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearIsArchived() {
        this.isArchived_ = false;
    }

    private void ensureExPeersIsMutable() {
        B.j jVar = this.exPeers_;
        if (jVar.u()) {
            return;
        }
        this.exPeers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MessagingOuterClass$UpdateDialogArchiveStatus getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingOuterClass$UpdateDialogArchiveStatus parseDelimitedFrom(InputStream inputStream) {
        return (MessagingOuterClass$UpdateDialogArchiveStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$UpdateDialogArchiveStatus parseFrom(ByteBuffer byteBuffer) {
        return (MessagingOuterClass$UpdateDialogArchiveStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeExPeers(int i) {
        ensureExPeersIsMutable();
        this.exPeers_.remove(i);
    }

    private void setExPeers(int i, PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        ensureExPeersIsMutable();
        this.exPeers_.set(i, peersStruct$ExPeer);
    }

    private void setIsArchived(boolean z) {
        this.isArchived_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (K0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingOuterClass$UpdateDialogArchiveStatus();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002\u0007", new Object[]{"exPeers_", PeersStruct$ExPeer.class, "isArchived_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingOuterClass$UpdateDialogArchiveStatus.class) {
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

    public PeersStruct$ExPeer getExPeers(int i) {
        return (PeersStruct$ExPeer) this.exPeers_.get(i);
    }

    public int getExPeersCount() {
        return this.exPeers_.size();
    }

    public List<PeersStruct$ExPeer> getExPeersList() {
        return this.exPeers_;
    }

    public InterfaceC9494a35 getExPeersOrBuilder(int i) {
        return (InterfaceC9494a35) this.exPeers_.get(i);
    }

    public List<? extends InterfaceC9494a35> getExPeersOrBuilderList() {
        return this.exPeers_;
    }

    public boolean getIsArchived() {
        return this.isArchived_;
    }

    public static a newBuilder(MessagingOuterClass$UpdateDialogArchiveStatus messagingOuterClass$UpdateDialogArchiveStatus) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingOuterClass$UpdateDialogArchiveStatus);
    }

    public static MessagingOuterClass$UpdateDialogArchiveStatus parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$UpdateDialogArchiveStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$UpdateDialogArchiveStatus parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingOuterClass$UpdateDialogArchiveStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingOuterClass$UpdateDialogArchiveStatus parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingOuterClass$UpdateDialogArchiveStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addExPeers(int i, PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        ensureExPeersIsMutable();
        this.exPeers_.add(i, peersStruct$ExPeer);
    }

    public static MessagingOuterClass$UpdateDialogArchiveStatus parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingOuterClass$UpdateDialogArchiveStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingOuterClass$UpdateDialogArchiveStatus parseFrom(byte[] bArr) {
        return (MessagingOuterClass$UpdateDialogArchiveStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingOuterClass$UpdateDialogArchiveStatus parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingOuterClass$UpdateDialogArchiveStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingOuterClass$UpdateDialogArchiveStatus parseFrom(InputStream inputStream) {
        return (MessagingOuterClass$UpdateDialogArchiveStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$UpdateDialogArchiveStatus parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$UpdateDialogArchiveStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$UpdateDialogArchiveStatus parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingOuterClass$UpdateDialogArchiveStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingOuterClass$UpdateDialogArchiveStatus parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingOuterClass$UpdateDialogArchiveStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
