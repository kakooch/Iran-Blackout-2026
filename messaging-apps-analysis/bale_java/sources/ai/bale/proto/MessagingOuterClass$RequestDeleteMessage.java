package ai.bale.proto;

import ai.bale.proto.MessagingStruct$MessagesDeleteDates;
import ai.bale.proto.PeersStruct$OutPeer;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.BoolValue;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MessagingOuterClass$RequestDeleteMessage extends GeneratedMessageLite implements U64 {
    public static final int DATES_FIELD_NUMBER = 3;
    private static final MessagingOuterClass$RequestDeleteMessage DEFAULT_INSTANCE;
    public static final int JUST_MINE_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 1;
    public static final int RIDS_FIELD_NUMBER = 2;
    private int bitField0_;
    private MessagingStruct$MessagesDeleteDates dates_;
    private BoolValue justMine_;
    private PeersStruct$OutPeer peer_;
    private int ridsMemoizedSerializedSize = -1;
    private B.i rids_ = GeneratedMessageLite.emptyLongList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(Iterable iterable) {
            q();
            ((MessagingOuterClass$RequestDeleteMessage) this.b).addAllRids(iterable);
            return this;
        }

        public a B(MessagingStruct$MessagesDeleteDates messagingStruct$MessagesDeleteDates) {
            q();
            ((MessagingOuterClass$RequestDeleteMessage) this.b).setDates(messagingStruct$MessagesDeleteDates);
            return this;
        }

        public a C(BoolValue boolValue) {
            q();
            ((MessagingOuterClass$RequestDeleteMessage) this.b).setJustMine(boolValue);
            return this;
        }

        public a D(PeersStruct$OutPeer peersStruct$OutPeer) {
            q();
            ((MessagingOuterClass$RequestDeleteMessage) this.b).setPeer(peersStruct$OutPeer);
            return this;
        }

        private a() {
            super(MessagingOuterClass$RequestDeleteMessage.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingOuterClass$RequestDeleteMessage messagingOuterClass$RequestDeleteMessage = new MessagingOuterClass$RequestDeleteMessage();
        DEFAULT_INSTANCE = messagingOuterClass$RequestDeleteMessage;
        GeneratedMessageLite.registerDefaultInstance(MessagingOuterClass$RequestDeleteMessage.class, messagingOuterClass$RequestDeleteMessage);
    }

    private MessagingOuterClass$RequestDeleteMessage() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllRids(Iterable<? extends Long> iterable) {
        ensureRidsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.rids_);
    }

    private void addRids(long j) {
        ensureRidsIsMutable();
        this.rids_.l1(j);
    }

    private void clearDates() {
        this.dates_ = null;
        this.bitField0_ &= -3;
    }

    private void clearJustMine() {
        this.justMine_ = null;
        this.bitField0_ &= -5;
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearRids() {
        this.rids_ = GeneratedMessageLite.emptyLongList();
    }

    private void ensureRidsIsMutable() {
        B.i iVar = this.rids_;
        if (iVar.u()) {
            return;
        }
        this.rids_ = GeneratedMessageLite.mutableCopy(iVar);
    }

    public static MessagingOuterClass$RequestDeleteMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeDates(MessagingStruct$MessagesDeleteDates messagingStruct$MessagesDeleteDates) {
        messagingStruct$MessagesDeleteDates.getClass();
        MessagingStruct$MessagesDeleteDates messagingStruct$MessagesDeleteDates2 = this.dates_;
        if (messagingStruct$MessagesDeleteDates2 == null || messagingStruct$MessagesDeleteDates2 == MessagingStruct$MessagesDeleteDates.getDefaultInstance()) {
            this.dates_ = messagingStruct$MessagesDeleteDates;
        } else {
            this.dates_ = (MessagingStruct$MessagesDeleteDates) ((MessagingStruct$MessagesDeleteDates.a) MessagingStruct$MessagesDeleteDates.newBuilder(this.dates_).v(messagingStruct$MessagesDeleteDates)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeJustMine(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.justMine_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.justMine_ = boolValue;
        } else {
            this.justMine_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.justMine_).v(boolValue)).j();
        }
        this.bitField0_ |= 4;
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

    public static MessagingOuterClass$RequestDeleteMessage parseDelimitedFrom(InputStream inputStream) {
        return (MessagingOuterClass$RequestDeleteMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$RequestDeleteMessage parseFrom(ByteBuffer byteBuffer) {
        return (MessagingOuterClass$RequestDeleteMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDates(MessagingStruct$MessagesDeleteDates messagingStruct$MessagesDeleteDates) {
        messagingStruct$MessagesDeleteDates.getClass();
        this.dates_ = messagingStruct$MessagesDeleteDates;
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setJustMine(BoolValue boolValue) {
        boolValue.getClass();
        this.justMine_ = boolValue;
        this.bitField0_ |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPeer(PeersStruct$OutPeer peersStruct$OutPeer) {
        peersStruct$OutPeer.getClass();
        this.peer_ = peersStruct$OutPeer;
        this.bitField0_ |= 1;
    }

    private void setRids(int i, long j) {
        ensureRidsIsMutable();
        this.rids_.z1(i, j);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (K0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingOuterClass$RequestDeleteMessage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဉ\u0000\u0002%\u0003ဉ\u0001\u0004ဉ\u0002", new Object[]{"bitField0_", "peer_", "rids_", "dates_", "justMine_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingOuterClass$RequestDeleteMessage.class) {
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

    public MessagingStruct$MessagesDeleteDates getDates() {
        MessagingStruct$MessagesDeleteDates messagingStruct$MessagesDeleteDates = this.dates_;
        return messagingStruct$MessagesDeleteDates == null ? MessagingStruct$MessagesDeleteDates.getDefaultInstance() : messagingStruct$MessagesDeleteDates;
    }

    public BoolValue getJustMine() {
        BoolValue boolValue = this.justMine_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public PeersStruct$OutPeer getPeer() {
        PeersStruct$OutPeer peersStruct$OutPeer = this.peer_;
        return peersStruct$OutPeer == null ? PeersStruct$OutPeer.getDefaultInstance() : peersStruct$OutPeer;
    }

    public long getRids(int i) {
        return this.rids_.getLong(i);
    }

    public int getRidsCount() {
        return this.rids_.size();
    }

    public List<Long> getRidsList() {
        return this.rids_;
    }

    public boolean hasDates() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasJustMine() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MessagingOuterClass$RequestDeleteMessage messagingOuterClass$RequestDeleteMessage) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingOuterClass$RequestDeleteMessage);
    }

    public static MessagingOuterClass$RequestDeleteMessage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$RequestDeleteMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$RequestDeleteMessage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingOuterClass$RequestDeleteMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingOuterClass$RequestDeleteMessage parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingOuterClass$RequestDeleteMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingOuterClass$RequestDeleteMessage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingOuterClass$RequestDeleteMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingOuterClass$RequestDeleteMessage parseFrom(byte[] bArr) {
        return (MessagingOuterClass$RequestDeleteMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingOuterClass$RequestDeleteMessage parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingOuterClass$RequestDeleteMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingOuterClass$RequestDeleteMessage parseFrom(InputStream inputStream) {
        return (MessagingOuterClass$RequestDeleteMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$RequestDeleteMessage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$RequestDeleteMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$RequestDeleteMessage parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingOuterClass$RequestDeleteMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingOuterClass$RequestDeleteMessage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingOuterClass$RequestDeleteMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
