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
public final class MessagingOuterClass$RequestUnpinDialogs extends GeneratedMessageLite implements U64 {
    private static final MessagingOuterClass$RequestUnpinDialogs DEFAULT_INSTANCE;
    public static final int FOLDER_ID_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int PEERS_FIELD_NUMBER = 1;
    private int folderId_;
    private B.j peers_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(Iterable iterable) {
            q();
            ((MessagingOuterClass$RequestUnpinDialogs) this.b).addAllPeers(iterable);
            return this;
        }

        public a B(int i) {
            q();
            ((MessagingOuterClass$RequestUnpinDialogs) this.b).setFolderId(i);
            return this;
        }

        private a() {
            super(MessagingOuterClass$RequestUnpinDialogs.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingOuterClass$RequestUnpinDialogs messagingOuterClass$RequestUnpinDialogs = new MessagingOuterClass$RequestUnpinDialogs();
        DEFAULT_INSTANCE = messagingOuterClass$RequestUnpinDialogs;
        GeneratedMessageLite.registerDefaultInstance(MessagingOuterClass$RequestUnpinDialogs.class, messagingOuterClass$RequestUnpinDialogs);
    }

    private MessagingOuterClass$RequestUnpinDialogs() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllPeers(Iterable<? extends PeersStruct$ExPeer> iterable) {
        ensurePeersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.peers_);
    }

    private void addPeers(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        ensurePeersIsMutable();
        this.peers_.add(peersStruct$ExPeer);
    }

    private void clearFolderId() {
        this.folderId_ = 0;
    }

    private void clearPeers() {
        this.peers_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensurePeersIsMutable() {
        B.j jVar = this.peers_;
        if (jVar.u()) {
            return;
        }
        this.peers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MessagingOuterClass$RequestUnpinDialogs getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingOuterClass$RequestUnpinDialogs parseDelimitedFrom(InputStream inputStream) {
        return (MessagingOuterClass$RequestUnpinDialogs) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$RequestUnpinDialogs parseFrom(ByteBuffer byteBuffer) {
        return (MessagingOuterClass$RequestUnpinDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removePeers(int i) {
        ensurePeersIsMutable();
        this.peers_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFolderId(int i) {
        this.folderId_ = i;
    }

    private void setPeers(int i, PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        ensurePeersIsMutable();
        this.peers_.set(i, peersStruct$ExPeer);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (K0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingOuterClass$RequestUnpinDialogs();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002\u0004", new Object[]{"peers_", PeersStruct$ExPeer.class, "folderId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingOuterClass$RequestUnpinDialogs.class) {
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

    public int getFolderId() {
        return this.folderId_;
    }

    public PeersStruct$ExPeer getPeers(int i) {
        return (PeersStruct$ExPeer) this.peers_.get(i);
    }

    public int getPeersCount() {
        return this.peers_.size();
    }

    public List<PeersStruct$ExPeer> getPeersList() {
        return this.peers_;
    }

    public InterfaceC9494a35 getPeersOrBuilder(int i) {
        return (InterfaceC9494a35) this.peers_.get(i);
    }

    public List<? extends InterfaceC9494a35> getPeersOrBuilderList() {
        return this.peers_;
    }

    public static a newBuilder(MessagingOuterClass$RequestUnpinDialogs messagingOuterClass$RequestUnpinDialogs) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingOuterClass$RequestUnpinDialogs);
    }

    public static MessagingOuterClass$RequestUnpinDialogs parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$RequestUnpinDialogs) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$RequestUnpinDialogs parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingOuterClass$RequestUnpinDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingOuterClass$RequestUnpinDialogs parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingOuterClass$RequestUnpinDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addPeers(int i, PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        ensurePeersIsMutable();
        this.peers_.add(i, peersStruct$ExPeer);
    }

    public static MessagingOuterClass$RequestUnpinDialogs parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingOuterClass$RequestUnpinDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingOuterClass$RequestUnpinDialogs parseFrom(byte[] bArr) {
        return (MessagingOuterClass$RequestUnpinDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingOuterClass$RequestUnpinDialogs parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingOuterClass$RequestUnpinDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingOuterClass$RequestUnpinDialogs parseFrom(InputStream inputStream) {
        return (MessagingOuterClass$RequestUnpinDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$RequestUnpinDialogs parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$RequestUnpinDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$RequestUnpinDialogs parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingOuterClass$RequestUnpinDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingOuterClass$RequestUnpinDialogs parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingOuterClass$RequestUnpinDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
