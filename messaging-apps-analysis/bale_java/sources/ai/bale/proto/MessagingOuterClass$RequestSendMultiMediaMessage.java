package ai.bale.proto;

import ai.bale.proto.MessagingStruct$MessageOutReference;
import ai.bale.proto.PeersStruct$OutExPeer;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC22666vd4;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MessagingOuterClass$RequestSendMultiMediaMessage extends GeneratedMessageLite implements U64 {
    private static final MessagingOuterClass$RequestSendMultiMediaMessage DEFAULT_INSTANCE;
    public static final int GROUPED_ID_FIELD_NUMBER = 4;
    public static final int MULTI_MEDIA_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 1;
    public static final int REPLIED_MESSAGE_FIELD_NUMBER = 3;
    private int bitField0_;
    private long groupedId_;
    private B.j multiMedia_ = GeneratedMessageLite.emptyProtobufList();
    private PeersStruct$OutExPeer peer_;
    private MessagingStruct$MessageOutReference repliedMessage_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingOuterClass$RequestSendMultiMediaMessage.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingOuterClass$RequestSendMultiMediaMessage messagingOuterClass$RequestSendMultiMediaMessage = new MessagingOuterClass$RequestSendMultiMediaMessage();
        DEFAULT_INSTANCE = messagingOuterClass$RequestSendMultiMediaMessage;
        GeneratedMessageLite.registerDefaultInstance(MessagingOuterClass$RequestSendMultiMediaMessage.class, messagingOuterClass$RequestSendMultiMediaMessage);
    }

    private MessagingOuterClass$RequestSendMultiMediaMessage() {
    }

    private void addAllMultiMedia(Iterable<? extends MessagingStruct$SingleMedia> iterable) {
        ensureMultiMediaIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.multiMedia_);
    }

    private void addMultiMedia(MessagingStruct$SingleMedia messagingStruct$SingleMedia) {
        messagingStruct$SingleMedia.getClass();
        ensureMultiMediaIsMutable();
        this.multiMedia_.add(messagingStruct$SingleMedia);
    }

    private void clearGroupedId() {
        this.groupedId_ = 0L;
    }

    private void clearMultiMedia() {
        this.multiMedia_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearRepliedMessage() {
        this.repliedMessage_ = null;
        this.bitField0_ &= -3;
    }

    private void ensureMultiMediaIsMutable() {
        B.j jVar = this.multiMedia_;
        if (jVar.u()) {
            return;
        }
        this.multiMedia_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MessagingOuterClass$RequestSendMultiMediaMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
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

    private void mergeRepliedMessage(MessagingStruct$MessageOutReference messagingStruct$MessageOutReference) {
        messagingStruct$MessageOutReference.getClass();
        MessagingStruct$MessageOutReference messagingStruct$MessageOutReference2 = this.repliedMessage_;
        if (messagingStruct$MessageOutReference2 == null || messagingStruct$MessageOutReference2 == MessagingStruct$MessageOutReference.getDefaultInstance()) {
            this.repliedMessage_ = messagingStruct$MessageOutReference;
        } else {
            this.repliedMessage_ = (MessagingStruct$MessageOutReference) ((MessagingStruct$MessageOutReference.a) MessagingStruct$MessageOutReference.newBuilder(this.repliedMessage_).v(messagingStruct$MessageOutReference)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingOuterClass$RequestSendMultiMediaMessage parseDelimitedFrom(InputStream inputStream) {
        return (MessagingOuterClass$RequestSendMultiMediaMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$RequestSendMultiMediaMessage parseFrom(ByteBuffer byteBuffer) {
        return (MessagingOuterClass$RequestSendMultiMediaMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeMultiMedia(int i) {
        ensureMultiMediaIsMutable();
        this.multiMedia_.remove(i);
    }

    private void setGroupedId(long j) {
        this.groupedId_ = j;
    }

    private void setMultiMedia(int i, MessagingStruct$SingleMedia messagingStruct$SingleMedia) {
        messagingStruct$SingleMedia.getClass();
        ensureMultiMediaIsMutable();
        this.multiMedia_.set(i, messagingStruct$SingleMedia);
    }

    private void setPeer(PeersStruct$OutExPeer peersStruct$OutExPeer) {
        peersStruct$OutExPeer.getClass();
        this.peer_ = peersStruct$OutExPeer;
        this.bitField0_ |= 1;
    }

    private void setRepliedMessage(MessagingStruct$MessageOutReference messagingStruct$MessageOutReference) {
        messagingStruct$MessageOutReference.getClass();
        this.repliedMessage_ = messagingStruct$MessageOutReference;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (K0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingOuterClass$RequestSendMultiMediaMessage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001b\u0003ဉ\u0001\u0004\u0002", new Object[]{"bitField0_", "peer_", "multiMedia_", MessagingStruct$SingleMedia.class, "repliedMessage_", "groupedId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingOuterClass$RequestSendMultiMediaMessage.class) {
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

    public long getGroupedId() {
        return this.groupedId_;
    }

    public MessagingStruct$SingleMedia getMultiMedia(int i) {
        return (MessagingStruct$SingleMedia) this.multiMedia_.get(i);
    }

    public int getMultiMediaCount() {
        return this.multiMedia_.size();
    }

    public List<MessagingStruct$SingleMedia> getMultiMediaList() {
        return this.multiMedia_;
    }

    public InterfaceC22666vd4 getMultiMediaOrBuilder(int i) {
        return (InterfaceC22666vd4) this.multiMedia_.get(i);
    }

    public List<? extends InterfaceC22666vd4> getMultiMediaOrBuilderList() {
        return this.multiMedia_;
    }

    public PeersStruct$OutExPeer getPeer() {
        PeersStruct$OutExPeer peersStruct$OutExPeer = this.peer_;
        return peersStruct$OutExPeer == null ? PeersStruct$OutExPeer.getDefaultInstance() : peersStruct$OutExPeer;
    }

    public MessagingStruct$MessageOutReference getRepliedMessage() {
        MessagingStruct$MessageOutReference messagingStruct$MessageOutReference = this.repliedMessage_;
        return messagingStruct$MessageOutReference == null ? MessagingStruct$MessageOutReference.getDefaultInstance() : messagingStruct$MessageOutReference;
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasRepliedMessage() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(MessagingOuterClass$RequestSendMultiMediaMessage messagingOuterClass$RequestSendMultiMediaMessage) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingOuterClass$RequestSendMultiMediaMessage);
    }

    public static MessagingOuterClass$RequestSendMultiMediaMessage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$RequestSendMultiMediaMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$RequestSendMultiMediaMessage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingOuterClass$RequestSendMultiMediaMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingOuterClass$RequestSendMultiMediaMessage parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingOuterClass$RequestSendMultiMediaMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addMultiMedia(int i, MessagingStruct$SingleMedia messagingStruct$SingleMedia) {
        messagingStruct$SingleMedia.getClass();
        ensureMultiMediaIsMutable();
        this.multiMedia_.add(i, messagingStruct$SingleMedia);
    }

    public static MessagingOuterClass$RequestSendMultiMediaMessage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingOuterClass$RequestSendMultiMediaMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingOuterClass$RequestSendMultiMediaMessage parseFrom(byte[] bArr) {
        return (MessagingOuterClass$RequestSendMultiMediaMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingOuterClass$RequestSendMultiMediaMessage parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingOuterClass$RequestSendMultiMediaMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingOuterClass$RequestSendMultiMediaMessage parseFrom(InputStream inputStream) {
        return (MessagingOuterClass$RequestSendMultiMediaMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$RequestSendMultiMediaMessage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$RequestSendMultiMediaMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$RequestSendMultiMediaMessage parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingOuterClass$RequestSendMultiMediaMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingOuterClass$RequestSendMultiMediaMessage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingOuterClass$RequestSendMultiMediaMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
