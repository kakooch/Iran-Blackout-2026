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
public final class MessagingOuterClass$UpdatePinnedDialogsChanged extends GeneratedMessageLite implements U64 {
    private static final MessagingOuterClass$UpdatePinnedDialogsChanged DEFAULT_INSTANCE;
    public static final int FOLDER_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int PINNED_DIALOGS_FIELD_NUMBER = 2;
    public static final int PINNED_PEERS_FIELD_NUMBER = 3;
    private int folderId_;
    private B.j pinnedDialogs_ = GeneratedMessageLite.emptyProtobufList();
    private B.j pinnedPeers_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingOuterClass$UpdatePinnedDialogsChanged.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingOuterClass$UpdatePinnedDialogsChanged messagingOuterClass$UpdatePinnedDialogsChanged = new MessagingOuterClass$UpdatePinnedDialogsChanged();
        DEFAULT_INSTANCE = messagingOuterClass$UpdatePinnedDialogsChanged;
        GeneratedMessageLite.registerDefaultInstance(MessagingOuterClass$UpdatePinnedDialogsChanged.class, messagingOuterClass$UpdatePinnedDialogsChanged);
    }

    private MessagingOuterClass$UpdatePinnedDialogsChanged() {
    }

    private void addAllPinnedDialogs(Iterable<? extends MessagingStruct$Dialog> iterable) {
        ensurePinnedDialogsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.pinnedDialogs_);
    }

    private void addAllPinnedPeers(Iterable<? extends PeersStruct$ExPeer> iterable) {
        ensurePinnedPeersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.pinnedPeers_);
    }

    private void addPinnedDialogs(MessagingStruct$Dialog messagingStruct$Dialog) {
        messagingStruct$Dialog.getClass();
        ensurePinnedDialogsIsMutable();
        this.pinnedDialogs_.add(messagingStruct$Dialog);
    }

    private void addPinnedPeers(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        ensurePinnedPeersIsMutable();
        this.pinnedPeers_.add(peersStruct$ExPeer);
    }

    private void clearFolderId() {
        this.folderId_ = 0;
    }

    private void clearPinnedDialogs() {
        this.pinnedDialogs_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearPinnedPeers() {
        this.pinnedPeers_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensurePinnedDialogsIsMutable() {
        B.j jVar = this.pinnedDialogs_;
        if (jVar.u()) {
            return;
        }
        this.pinnedDialogs_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensurePinnedPeersIsMutable() {
        B.j jVar = this.pinnedPeers_;
        if (jVar.u()) {
            return;
        }
        this.pinnedPeers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MessagingOuterClass$UpdatePinnedDialogsChanged getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingOuterClass$UpdatePinnedDialogsChanged parseDelimitedFrom(InputStream inputStream) {
        return (MessagingOuterClass$UpdatePinnedDialogsChanged) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$UpdatePinnedDialogsChanged parseFrom(ByteBuffer byteBuffer) {
        return (MessagingOuterClass$UpdatePinnedDialogsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removePinnedDialogs(int i) {
        ensurePinnedDialogsIsMutable();
        this.pinnedDialogs_.remove(i);
    }

    private void removePinnedPeers(int i) {
        ensurePinnedPeersIsMutable();
        this.pinnedPeers_.remove(i);
    }

    private void setFolderId(int i) {
        this.folderId_ = i;
    }

    private void setPinnedDialogs(int i, MessagingStruct$Dialog messagingStruct$Dialog) {
        messagingStruct$Dialog.getClass();
        ensurePinnedDialogsIsMutable();
        this.pinnedDialogs_.set(i, messagingStruct$Dialog);
    }

    private void setPinnedPeers(int i, PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        ensurePinnedPeersIsMutable();
        this.pinnedPeers_.set(i, peersStruct$ExPeer);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (K0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingOuterClass$UpdatePinnedDialogsChanged();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0002\u0000\u0001\u0004\u0002\u001b\u0003\u001b", new Object[]{"folderId_", "pinnedDialogs_", MessagingStruct$Dialog.class, "pinnedPeers_", PeersStruct$ExPeer.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingOuterClass$UpdatePinnedDialogsChanged.class) {
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

    public MessagingStruct$Dialog getPinnedDialogs(int i) {
        return (MessagingStruct$Dialog) this.pinnedDialogs_.get(i);
    }

    public int getPinnedDialogsCount() {
        return this.pinnedDialogs_.size();
    }

    public List<MessagingStruct$Dialog> getPinnedDialogsList() {
        return this.pinnedDialogs_;
    }

    public InterfaceC18397ob4 getPinnedDialogsOrBuilder(int i) {
        return (InterfaceC18397ob4) this.pinnedDialogs_.get(i);
    }

    public List<? extends InterfaceC18397ob4> getPinnedDialogsOrBuilderList() {
        return this.pinnedDialogs_;
    }

    public PeersStruct$ExPeer getPinnedPeers(int i) {
        return (PeersStruct$ExPeer) this.pinnedPeers_.get(i);
    }

    public int getPinnedPeersCount() {
        return this.pinnedPeers_.size();
    }

    public List<PeersStruct$ExPeer> getPinnedPeersList() {
        return this.pinnedPeers_;
    }

    public InterfaceC9494a35 getPinnedPeersOrBuilder(int i) {
        return (InterfaceC9494a35) this.pinnedPeers_.get(i);
    }

    public List<? extends InterfaceC9494a35> getPinnedPeersOrBuilderList() {
        return this.pinnedPeers_;
    }

    public static a newBuilder(MessagingOuterClass$UpdatePinnedDialogsChanged messagingOuterClass$UpdatePinnedDialogsChanged) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingOuterClass$UpdatePinnedDialogsChanged);
    }

    public static MessagingOuterClass$UpdatePinnedDialogsChanged parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$UpdatePinnedDialogsChanged) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$UpdatePinnedDialogsChanged parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingOuterClass$UpdatePinnedDialogsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingOuterClass$UpdatePinnedDialogsChanged parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingOuterClass$UpdatePinnedDialogsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addPinnedDialogs(int i, MessagingStruct$Dialog messagingStruct$Dialog) {
        messagingStruct$Dialog.getClass();
        ensurePinnedDialogsIsMutable();
        this.pinnedDialogs_.add(i, messagingStruct$Dialog);
    }

    private void addPinnedPeers(int i, PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        ensurePinnedPeersIsMutable();
        this.pinnedPeers_.add(i, peersStruct$ExPeer);
    }

    public static MessagingOuterClass$UpdatePinnedDialogsChanged parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingOuterClass$UpdatePinnedDialogsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingOuterClass$UpdatePinnedDialogsChanged parseFrom(byte[] bArr) {
        return (MessagingOuterClass$UpdatePinnedDialogsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingOuterClass$UpdatePinnedDialogsChanged parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingOuterClass$UpdatePinnedDialogsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingOuterClass$UpdatePinnedDialogsChanged parseFrom(InputStream inputStream) {
        return (MessagingOuterClass$UpdatePinnedDialogsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$UpdatePinnedDialogsChanged parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$UpdatePinnedDialogsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$UpdatePinnedDialogsChanged parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingOuterClass$UpdatePinnedDialogsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingOuterClass$UpdatePinnedDialogsChanged parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingOuterClass$UpdatePinnedDialogsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
