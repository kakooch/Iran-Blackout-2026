package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int64Value;
import ai.bale.proto.MessagingStruct$StoryReference;
import ai.bale.proto.PeersStruct$OutPeer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC14252hc4;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingStruct$MessageOutReference extends GeneratedMessageLite implements InterfaceC14252hc4 {
    public static final int DATE_FIELD_NUMBER = 3;
    private static final MessagingStruct$MessageOutReference DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 1;
    public static final int RID_FIELD_NUMBER = 2;
    public static final int SEQ_FIELD_NUMBER = 4;
    public static final int STORY_FIELD_NUMBER = 5;
    private int bitField0_;
    private CollectionsStruct$Int64Value date_;
    private PeersStruct$OutPeer peer_;
    private long rid_;
    private CollectionsStruct$Int64Value seq_;
    private MessagingStruct$StoryReference story_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC14252hc4 {
        public a A(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
            q();
            ((MessagingStruct$MessageOutReference) this.b).setDate(collectionsStruct$Int64Value);
            return this;
        }

        public a B(PeersStruct$OutPeer peersStruct$OutPeer) {
            q();
            ((MessagingStruct$MessageOutReference) this.b).setPeer(peersStruct$OutPeer);
            return this;
        }

        public a C(long j) {
            q();
            ((MessagingStruct$MessageOutReference) this.b).setRid(j);
            return this;
        }

        private a() {
            super(MessagingStruct$MessageOutReference.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$MessageOutReference messagingStruct$MessageOutReference = new MessagingStruct$MessageOutReference();
        DEFAULT_INSTANCE = messagingStruct$MessageOutReference;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$MessageOutReference.class, messagingStruct$MessageOutReference);
    }

    private MessagingStruct$MessageOutReference() {
    }

    private void clearDate() {
        this.date_ = null;
        this.bitField0_ &= -3;
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearRid() {
        this.rid_ = 0L;
    }

    private void clearSeq() {
        this.seq_ = null;
        this.bitField0_ &= -5;
    }

    private void clearStory() {
        this.story_ = null;
        this.bitField0_ &= -9;
    }

    public static MessagingStruct$MessageOutReference getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeDate(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.date_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.date_ = collectionsStruct$Int64Value;
        } else {
            this.date_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.date_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 2;
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

    private void mergeSeq(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.seq_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.seq_ = collectionsStruct$Int64Value;
        } else {
            this.seq_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.seq_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeStory(MessagingStruct$StoryReference messagingStruct$StoryReference) {
        messagingStruct$StoryReference.getClass();
        MessagingStruct$StoryReference messagingStruct$StoryReference2 = this.story_;
        if (messagingStruct$StoryReference2 == null || messagingStruct$StoryReference2 == MessagingStruct$StoryReference.getDefaultInstance()) {
            this.story_ = messagingStruct$StoryReference;
        } else {
            this.story_ = (MessagingStruct$StoryReference) ((MessagingStruct$StoryReference.a) MessagingStruct$StoryReference.newBuilder(this.story_).v(messagingStruct$StoryReference)).j();
        }
        this.bitField0_ |= 8;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$MessageOutReference parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$MessageOutReference) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$MessageOutReference parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$MessageOutReference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDate(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.date_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPeer(PeersStruct$OutPeer peersStruct$OutPeer) {
        peersStruct$OutPeer.getClass();
        this.peer_ = peersStruct$OutPeer;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRid(long j) {
        this.rid_ = j;
    }

    private void setSeq(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.seq_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 4;
    }

    private void setStory(MessagingStruct$StoryReference messagingStruct$StoryReference) {
        messagingStruct$StoryReference.getClass();
        this.story_ = messagingStruct$StoryReference;
        this.bitField0_ |= 8;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$MessageOutReference();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0002\u0003ဉ\u0001\u0004ဉ\u0002\u0005ဉ\u0003", new Object[]{"bitField0_", "peer_", "rid_", "date_", "seq_", "story_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$MessageOutReference.class) {
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

    public CollectionsStruct$Int64Value getDate() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.date_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public PeersStruct$OutPeer getPeer() {
        PeersStruct$OutPeer peersStruct$OutPeer = this.peer_;
        return peersStruct$OutPeer == null ? PeersStruct$OutPeer.getDefaultInstance() : peersStruct$OutPeer;
    }

    public long getRid() {
        return this.rid_;
    }

    public CollectionsStruct$Int64Value getSeq() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.seq_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public MessagingStruct$StoryReference getStory() {
        MessagingStruct$StoryReference messagingStruct$StoryReference = this.story_;
        return messagingStruct$StoryReference == null ? MessagingStruct$StoryReference.getDefaultInstance() : messagingStruct$StoryReference;
    }

    public boolean hasDate() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasSeq() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasStory() {
        return (this.bitField0_ & 8) != 0;
    }

    public static a newBuilder(MessagingStruct$MessageOutReference messagingStruct$MessageOutReference) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$MessageOutReference);
    }

    public static MessagingStruct$MessageOutReference parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$MessageOutReference) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$MessageOutReference parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$MessageOutReference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$MessageOutReference parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$MessageOutReference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$MessageOutReference parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$MessageOutReference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$MessageOutReference parseFrom(byte[] bArr) {
        return (MessagingStruct$MessageOutReference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$MessageOutReference parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$MessageOutReference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$MessageOutReference parseFrom(InputStream inputStream) {
        return (MessagingStruct$MessageOutReference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$MessageOutReference parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$MessageOutReference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$MessageOutReference parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$MessageOutReference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$MessageOutReference parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$MessageOutReference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
