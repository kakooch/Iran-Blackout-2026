package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$BooleanValue;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC12702f35;
import ir.nasim.KW4;
import ir.nasim.U04;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MeetStruct$GroupCallLog extends GeneratedMessageLite implements U64 {
    private static final MeetStruct$GroupCallLog DEFAULT_INSTANCE;
    public static final int MISSED_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int PEERS_FIELD_NUMBER = 3;
    public static final int STATUS_FIELD_NUMBER = 1;
    private int bitField0_;
    private CollectionsStruct$BooleanValue missed_;
    private B.j peers_ = GeneratedMessageLite.emptyProtobufList();
    private int status_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MeetStruct$GroupCallLog.DEFAULT_INSTANCE);
        }
    }

    static {
        MeetStruct$GroupCallLog meetStruct$GroupCallLog = new MeetStruct$GroupCallLog();
        DEFAULT_INSTANCE = meetStruct$GroupCallLog;
        GeneratedMessageLite.registerDefaultInstance(MeetStruct$GroupCallLog.class, meetStruct$GroupCallLog);
    }

    private MeetStruct$GroupCallLog() {
    }

    private void addAllPeers(Iterable<? extends PeersStruct$OutExPeer> iterable) {
        ensurePeersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.peers_);
    }

    private void addPeers(PeersStruct$OutExPeer peersStruct$OutExPeer) {
        peersStruct$OutExPeer.getClass();
        ensurePeersIsMutable();
        this.peers_.add(peersStruct$OutExPeer);
    }

    private void clearMissed() {
        this.missed_ = null;
        this.bitField0_ &= -2;
    }

    private void clearPeers() {
        this.peers_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearStatus() {
        this.status_ = 0;
    }

    private void ensurePeersIsMutable() {
        B.j jVar = this.peers_;
        if (jVar.u()) {
            return;
        }
        this.peers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MeetStruct$GroupCallLog getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeMissed(CollectionsStruct$BooleanValue collectionsStruct$BooleanValue) {
        collectionsStruct$BooleanValue.getClass();
        CollectionsStruct$BooleanValue collectionsStruct$BooleanValue2 = this.missed_;
        if (collectionsStruct$BooleanValue2 == null || collectionsStruct$BooleanValue2 == CollectionsStruct$BooleanValue.getDefaultInstance()) {
            this.missed_ = collectionsStruct$BooleanValue;
        } else {
            this.missed_ = (CollectionsStruct$BooleanValue) ((CollectionsStruct$BooleanValue.a) CollectionsStruct$BooleanValue.newBuilder(this.missed_).v(collectionsStruct$BooleanValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MeetStruct$GroupCallLog parseDelimitedFrom(InputStream inputStream) {
        return (MeetStruct$GroupCallLog) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetStruct$GroupCallLog parseFrom(ByteBuffer byteBuffer) {
        return (MeetStruct$GroupCallLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removePeers(int i) {
        ensurePeersIsMutable();
        this.peers_.remove(i);
    }

    private void setMissed(CollectionsStruct$BooleanValue collectionsStruct$BooleanValue) {
        collectionsStruct$BooleanValue.getClass();
        this.missed_ = collectionsStruct$BooleanValue;
        this.bitField0_ |= 1;
    }

    private void setPeers(int i, PeersStruct$OutExPeer peersStruct$OutExPeer) {
        peersStruct$OutExPeer.getClass();
        ensurePeersIsMutable();
        this.peers_.set(i, peersStruct$OutExPeer);
    }

    private void setStatus(U04 u04) {
        this.status_ = u04.getNumber();
    }

    private void setStatusValue(int i) {
        this.status_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (G0.a[gVar.ordinal()]) {
            case 1:
                return new MeetStruct$GroupCallLog();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\f\u0002ဉ\u0000\u0003\u001b", new Object[]{"bitField0_", "status_", "missed_", "peers_", PeersStruct$OutExPeer.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MeetStruct$GroupCallLog.class) {
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

    public CollectionsStruct$BooleanValue getMissed() {
        CollectionsStruct$BooleanValue collectionsStruct$BooleanValue = this.missed_;
        return collectionsStruct$BooleanValue == null ? CollectionsStruct$BooleanValue.getDefaultInstance() : collectionsStruct$BooleanValue;
    }

    public PeersStruct$OutExPeer getPeers(int i) {
        return (PeersStruct$OutExPeer) this.peers_.get(i);
    }

    public int getPeersCount() {
        return this.peers_.size();
    }

    public List<PeersStruct$OutExPeer> getPeersList() {
        return this.peers_;
    }

    public InterfaceC12702f35 getPeersOrBuilder(int i) {
        return (InterfaceC12702f35) this.peers_.get(i);
    }

    public List<? extends InterfaceC12702f35> getPeersOrBuilderList() {
        return this.peers_;
    }

    public U04 getStatus() {
        U04 u04J = U04.j(this.status_);
        return u04J == null ? U04.UNRECOGNIZED : u04J;
    }

    public int getStatusValue() {
        return this.status_;
    }

    public boolean hasMissed() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MeetStruct$GroupCallLog meetStruct$GroupCallLog) {
        return (a) DEFAULT_INSTANCE.createBuilder(meetStruct$GroupCallLog);
    }

    public static MeetStruct$GroupCallLog parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetStruct$GroupCallLog) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetStruct$GroupCallLog parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MeetStruct$GroupCallLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MeetStruct$GroupCallLog parseFrom(AbstractC2383g abstractC2383g) {
        return (MeetStruct$GroupCallLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addPeers(int i, PeersStruct$OutExPeer peersStruct$OutExPeer) {
        peersStruct$OutExPeer.getClass();
        ensurePeersIsMutable();
        this.peers_.add(i, peersStruct$OutExPeer);
    }

    public static MeetStruct$GroupCallLog parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MeetStruct$GroupCallLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MeetStruct$GroupCallLog parseFrom(byte[] bArr) {
        return (MeetStruct$GroupCallLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MeetStruct$GroupCallLog parseFrom(byte[] bArr, C2394s c2394s) {
        return (MeetStruct$GroupCallLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MeetStruct$GroupCallLog parseFrom(InputStream inputStream) {
        return (MeetStruct$GroupCallLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetStruct$GroupCallLog parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetStruct$GroupCallLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetStruct$GroupCallLog parseFrom(AbstractC2384h abstractC2384h) {
        return (MeetStruct$GroupCallLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MeetStruct$GroupCallLog parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MeetStruct$GroupCallLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
