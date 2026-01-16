package ai.bale.proto;

import ai.bale.proto.PeersStruct$GroupOutPeer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.PG2;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class Ghasedak$RouteSeqState extends GeneratedMessageLite implements PG2 {
    private static final Ghasedak$RouteSeqState DEFAULT_INSTANCE;
    public static final int GROUP_PEER_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int SEQ_FIELD_NUMBER = 2;
    private int bitField0_;
    private PeersStruct$GroupOutPeer groupPeer_;
    private int seq_;

    public static final class a extends GeneratedMessageLite.b implements PG2 {
        public a A(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
            q();
            ((Ghasedak$RouteSeqState) this.b).setGroupPeer(peersStruct$GroupOutPeer);
            return this;
        }

        public a B(int i) {
            q();
            ((Ghasedak$RouteSeqState) this.b).setSeq(i);
            return this;
        }

        private a() {
            super(Ghasedak$RouteSeqState.DEFAULT_INSTANCE);
        }
    }

    static {
        Ghasedak$RouteSeqState ghasedak$RouteSeqState = new Ghasedak$RouteSeqState();
        DEFAULT_INSTANCE = ghasedak$RouteSeqState;
        GeneratedMessageLite.registerDefaultInstance(Ghasedak$RouteSeqState.class, ghasedak$RouteSeqState);
    }

    private Ghasedak$RouteSeqState() {
    }

    private void clearGroupPeer() {
        this.groupPeer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearSeq() {
        this.seq_ = 0;
    }

    public static Ghasedak$RouteSeqState getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeGroupPeer(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        PeersStruct$GroupOutPeer peersStruct$GroupOutPeer2 = this.groupPeer_;
        if (peersStruct$GroupOutPeer2 == null || peersStruct$GroupOutPeer2 == PeersStruct$GroupOutPeer.getDefaultInstance()) {
            this.groupPeer_ = peersStruct$GroupOutPeer;
        } else {
            this.groupPeer_ = (PeersStruct$GroupOutPeer) ((PeersStruct$GroupOutPeer.a) PeersStruct$GroupOutPeer.newBuilder(this.groupPeer_).v(peersStruct$GroupOutPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Ghasedak$RouteSeqState parseDelimitedFrom(InputStream inputStream) {
        return (Ghasedak$RouteSeqState) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Ghasedak$RouteSeqState parseFrom(ByteBuffer byteBuffer) {
        return (Ghasedak$RouteSeqState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGroupPeer(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        this.groupPeer_ = peersStruct$GroupOutPeer;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSeq(int i) {
        this.seq_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1862i0.a[gVar.ordinal()]) {
            case 1:
                return new Ghasedak$RouteSeqState();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0004", new Object[]{"bitField0_", "groupPeer_", "seq_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Ghasedak$RouteSeqState.class) {
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

    public PeersStruct$GroupOutPeer getGroupPeer() {
        PeersStruct$GroupOutPeer peersStruct$GroupOutPeer = this.groupPeer_;
        return peersStruct$GroupOutPeer == null ? PeersStruct$GroupOutPeer.getDefaultInstance() : peersStruct$GroupOutPeer;
    }

    public int getSeq() {
        return this.seq_;
    }

    public boolean hasGroupPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(Ghasedak$RouteSeqState ghasedak$RouteSeqState) {
        return (a) DEFAULT_INSTANCE.createBuilder(ghasedak$RouteSeqState);
    }

    public static Ghasedak$RouteSeqState parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Ghasedak$RouteSeqState) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Ghasedak$RouteSeqState parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Ghasedak$RouteSeqState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Ghasedak$RouteSeqState parseFrom(AbstractC2383g abstractC2383g) {
        return (Ghasedak$RouteSeqState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Ghasedak$RouteSeqState parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Ghasedak$RouteSeqState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Ghasedak$RouteSeqState parseFrom(byte[] bArr) {
        return (Ghasedak$RouteSeqState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Ghasedak$RouteSeqState parseFrom(byte[] bArr, C2394s c2394s) {
        return (Ghasedak$RouteSeqState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Ghasedak$RouteSeqState parseFrom(InputStream inputStream) {
        return (Ghasedak$RouteSeqState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Ghasedak$RouteSeqState parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Ghasedak$RouteSeqState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Ghasedak$RouteSeqState parseFrom(AbstractC2384h abstractC2384h) {
        return (Ghasedak$RouteSeqState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Ghasedak$RouteSeqState parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Ghasedak$RouteSeqState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
