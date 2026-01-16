package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC18397ob4;
import ir.nasim.InterfaceC9494a35;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MessagingOuterClass$ResponseReorderPinnedDialogs extends GeneratedMessageLite implements U64 {
    private static final MessagingOuterClass$ResponseReorderPinnedDialogs DEFAULT_INSTANCE;
    public static final int DIALOGS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int PEERS_FIELD_NUMBER = 2;
    private B.j dialogs_ = GeneratedMessageLite.emptyProtobufList();
    private B.j peers_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingOuterClass$ResponseReorderPinnedDialogs.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingOuterClass$ResponseReorderPinnedDialogs messagingOuterClass$ResponseReorderPinnedDialogs = new MessagingOuterClass$ResponseReorderPinnedDialogs();
        DEFAULT_INSTANCE = messagingOuterClass$ResponseReorderPinnedDialogs;
        GeneratedMessageLite.registerDefaultInstance(MessagingOuterClass$ResponseReorderPinnedDialogs.class, messagingOuterClass$ResponseReorderPinnedDialogs);
    }

    private MessagingOuterClass$ResponseReorderPinnedDialogs() {
    }

    private void addAllDialogs(Iterable<? extends MessagingStruct$Dialog> iterable) {
        ensureDialogsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.dialogs_);
    }

    private void addAllPeers(Iterable<? extends PeersStruct$ExPeer> iterable) {
        ensurePeersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.peers_);
    }

    private void addDialogs(MessagingStruct$Dialog messagingStruct$Dialog) {
        messagingStruct$Dialog.getClass();
        ensureDialogsIsMutable();
        this.dialogs_.add(messagingStruct$Dialog);
    }

    private void addPeers(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        ensurePeersIsMutable();
        this.peers_.add(peersStruct$ExPeer);
    }

    private void clearDialogs() {
        this.dialogs_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearPeers() {
        this.peers_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureDialogsIsMutable() {
        B.j jVar = this.dialogs_;
        if (jVar.u()) {
            return;
        }
        this.dialogs_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensurePeersIsMutable() {
        B.j jVar = this.peers_;
        if (jVar.u()) {
            return;
        }
        this.peers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MessagingOuterClass$ResponseReorderPinnedDialogs getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingOuterClass$ResponseReorderPinnedDialogs parseDelimitedFrom(InputStream inputStream) {
        return (MessagingOuterClass$ResponseReorderPinnedDialogs) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$ResponseReorderPinnedDialogs parseFrom(ByteBuffer byteBuffer) {
        return (MessagingOuterClass$ResponseReorderPinnedDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeDialogs(int i) {
        ensureDialogsIsMutable();
        this.dialogs_.remove(i);
    }

    private void removePeers(int i) {
        ensurePeersIsMutable();
        this.peers_.remove(i);
    }

    private void setDialogs(int i, MessagingStruct$Dialog messagingStruct$Dialog) {
        messagingStruct$Dialog.getClass();
        ensureDialogsIsMutable();
        this.dialogs_.set(i, messagingStruct$Dialog);
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
                return new MessagingOuterClass$ResponseReorderPinnedDialogs();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0002\u0000\u0001\u001b\u0002\u001b", new Object[]{"dialogs_", MessagingStruct$Dialog.class, "peers_", PeersStruct$ExPeer.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingOuterClass$ResponseReorderPinnedDialogs.class) {
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

    public MessagingStruct$Dialog getDialogs(int i) {
        return (MessagingStruct$Dialog) this.dialogs_.get(i);
    }

    public int getDialogsCount() {
        return this.dialogs_.size();
    }

    public List<MessagingStruct$Dialog> getDialogsList() {
        return this.dialogs_;
    }

    public InterfaceC18397ob4 getDialogsOrBuilder(int i) {
        return (InterfaceC18397ob4) this.dialogs_.get(i);
    }

    public List<? extends InterfaceC18397ob4> getDialogsOrBuilderList() {
        return this.dialogs_;
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

    public static a newBuilder(MessagingOuterClass$ResponseReorderPinnedDialogs messagingOuterClass$ResponseReorderPinnedDialogs) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingOuterClass$ResponseReorderPinnedDialogs);
    }

    public static MessagingOuterClass$ResponseReorderPinnedDialogs parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$ResponseReorderPinnedDialogs) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$ResponseReorderPinnedDialogs parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingOuterClass$ResponseReorderPinnedDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingOuterClass$ResponseReorderPinnedDialogs parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingOuterClass$ResponseReorderPinnedDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addDialogs(int i, MessagingStruct$Dialog messagingStruct$Dialog) {
        messagingStruct$Dialog.getClass();
        ensureDialogsIsMutable();
        this.dialogs_.add(i, messagingStruct$Dialog);
    }

    private void addPeers(int i, PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        ensurePeersIsMutable();
        this.peers_.add(i, peersStruct$ExPeer);
    }

    public static MessagingOuterClass$ResponseReorderPinnedDialogs parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingOuterClass$ResponseReorderPinnedDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingOuterClass$ResponseReorderPinnedDialogs parseFrom(byte[] bArr) {
        return (MessagingOuterClass$ResponseReorderPinnedDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingOuterClass$ResponseReorderPinnedDialogs parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingOuterClass$ResponseReorderPinnedDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingOuterClass$ResponseReorderPinnedDialogs parseFrom(InputStream inputStream) {
        return (MessagingOuterClass$ResponseReorderPinnedDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$ResponseReorderPinnedDialogs parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$ResponseReorderPinnedDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$ResponseReorderPinnedDialogs parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingOuterClass$ResponseReorderPinnedDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingOuterClass$ResponseReorderPinnedDialogs parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingOuterClass$ResponseReorderPinnedDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
