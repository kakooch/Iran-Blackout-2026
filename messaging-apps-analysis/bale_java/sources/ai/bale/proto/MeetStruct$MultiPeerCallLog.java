package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC10067b14;
import ir.nasim.InterfaceC12702f35;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MeetStruct$MultiPeerCallLog extends GeneratedMessageLite implements U64 {
    private static final MeetStruct$MultiPeerCallLog DEFAULT_INSTANCE;
    public static final int MISSED_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int PEERS_FIELD_NUMBER = 3;
    public static final int STATUS_FIELD_NUMBER = 1;
    private boolean missed_;
    private B.j peers_ = GeneratedMessageLite.emptyProtobufList();
    private int status_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MeetStruct$MultiPeerCallLog.DEFAULT_INSTANCE);
        }
    }

    static {
        MeetStruct$MultiPeerCallLog meetStruct$MultiPeerCallLog = new MeetStruct$MultiPeerCallLog();
        DEFAULT_INSTANCE = meetStruct$MultiPeerCallLog;
        GeneratedMessageLite.registerDefaultInstance(MeetStruct$MultiPeerCallLog.class, meetStruct$MultiPeerCallLog);
    }

    private MeetStruct$MultiPeerCallLog() {
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
        this.missed_ = false;
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

    public static MeetStruct$MultiPeerCallLog getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MeetStruct$MultiPeerCallLog parseDelimitedFrom(InputStream inputStream) {
        return (MeetStruct$MultiPeerCallLog) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetStruct$MultiPeerCallLog parseFrom(ByteBuffer byteBuffer) {
        return (MeetStruct$MultiPeerCallLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removePeers(int i) {
        ensurePeersIsMutable();
        this.peers_.remove(i);
    }

    private void setMissed(boolean z) {
        this.missed_ = z;
    }

    private void setPeers(int i, PeersStruct$OutExPeer peersStruct$OutExPeer) {
        peersStruct$OutExPeer.getClass();
        ensurePeersIsMutable();
        this.peers_.set(i, peersStruct$OutExPeer);
    }

    private void setStatus(EnumC10067b14 enumC10067b14) {
        this.status_ = enumC10067b14.getNumber();
    }

    private void setStatusValue(int i) {
        this.status_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (G0.a[gVar.ordinal()]) {
            case 1:
                return new MeetStruct$MultiPeerCallLog();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001\f\u0002\u0007\u0003\u001b", new Object[]{"status_", "missed_", "peers_", PeersStruct$OutExPeer.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MeetStruct$MultiPeerCallLog.class) {
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

    public boolean getMissed() {
        return this.missed_;
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

    public EnumC10067b14 getStatus() {
        EnumC10067b14 enumC10067b14J = EnumC10067b14.j(this.status_);
        return enumC10067b14J == null ? EnumC10067b14.UNRECOGNIZED : enumC10067b14J;
    }

    public int getStatusValue() {
        return this.status_;
    }

    public static a newBuilder(MeetStruct$MultiPeerCallLog meetStruct$MultiPeerCallLog) {
        return (a) DEFAULT_INSTANCE.createBuilder(meetStruct$MultiPeerCallLog);
    }

    public static MeetStruct$MultiPeerCallLog parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetStruct$MultiPeerCallLog) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetStruct$MultiPeerCallLog parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MeetStruct$MultiPeerCallLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MeetStruct$MultiPeerCallLog parseFrom(AbstractC2383g abstractC2383g) {
        return (MeetStruct$MultiPeerCallLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addPeers(int i, PeersStruct$OutExPeer peersStruct$OutExPeer) {
        peersStruct$OutExPeer.getClass();
        ensurePeersIsMutable();
        this.peers_.add(i, peersStruct$OutExPeer);
    }

    public static MeetStruct$MultiPeerCallLog parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MeetStruct$MultiPeerCallLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MeetStruct$MultiPeerCallLog parseFrom(byte[] bArr) {
        return (MeetStruct$MultiPeerCallLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MeetStruct$MultiPeerCallLog parseFrom(byte[] bArr, C2394s c2394s) {
        return (MeetStruct$MultiPeerCallLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MeetStruct$MultiPeerCallLog parseFrom(InputStream inputStream) {
        return (MeetStruct$MultiPeerCallLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetStruct$MultiPeerCallLog parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetStruct$MultiPeerCallLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetStruct$MultiPeerCallLog parseFrom(AbstractC2384h abstractC2384h) {
        return (MeetStruct$MultiPeerCallLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MeetStruct$MultiPeerCallLog parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MeetStruct$MultiPeerCallLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
