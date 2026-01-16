package ai.bale.proto;

import ai.bale.proto.PeersStruct$GroupOutPeer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC8356Vp6;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class SequenceStruct$SeqState extends GeneratedMessageLite implements InterfaceC8356Vp6 {
    private static final SequenceStruct$SeqState DEFAULT_INSTANCE;
    public static final int GROUP_PEER_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int SEQ_FIELD_NUMBER = 2;
    public static final int STATE_FIELD_NUMBER = 3;
    private int bitField0_;
    private PeersStruct$GroupOutPeer groupPeer_;
    private int seq_;
    private AbstractC2383g state_ = AbstractC2383g.b;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC8356Vp6 {
        private a() {
            super(SequenceStruct$SeqState.DEFAULT_INSTANCE);
        }
    }

    static {
        SequenceStruct$SeqState sequenceStruct$SeqState = new SequenceStruct$SeqState();
        DEFAULT_INSTANCE = sequenceStruct$SeqState;
        GeneratedMessageLite.registerDefaultInstance(SequenceStruct$SeqState.class, sequenceStruct$SeqState);
    }

    private SequenceStruct$SeqState() {
    }

    private void clearGroupPeer() {
        this.groupPeer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearSeq() {
        this.seq_ = 0;
    }

    private void clearState() {
        this.state_ = getDefaultInstance().getState();
    }

    public static SequenceStruct$SeqState getDefaultInstance() {
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

    public static SequenceStruct$SeqState parseDelimitedFrom(InputStream inputStream) {
        return (SequenceStruct$SeqState) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SequenceStruct$SeqState parseFrom(ByteBuffer byteBuffer) {
        return (SequenceStruct$SeqState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setGroupPeer(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        this.groupPeer_ = peersStruct$GroupOutPeer;
        this.bitField0_ |= 1;
    }

    private void setSeq(int i) {
        this.seq_ = i;
    }

    private void setState(AbstractC2383g abstractC2383g) {
        abstractC2383g.getClass();
        this.state_ = abstractC2383g;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (T1.a[gVar.ordinal()]) {
            case 1:
                return new SequenceStruct$SeqState();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0004\u0003\n", new Object[]{"bitField0_", "groupPeer_", "seq_", "state_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SequenceStruct$SeqState.class) {
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

    public AbstractC2383g getState() {
        return this.state_;
    }

    public boolean hasGroupPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(SequenceStruct$SeqState sequenceStruct$SeqState) {
        return (a) DEFAULT_INSTANCE.createBuilder(sequenceStruct$SeqState);
    }

    public static SequenceStruct$SeqState parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SequenceStruct$SeqState) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SequenceStruct$SeqState parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SequenceStruct$SeqState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SequenceStruct$SeqState parseFrom(AbstractC2383g abstractC2383g) {
        return (SequenceStruct$SeqState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SequenceStruct$SeqState parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SequenceStruct$SeqState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SequenceStruct$SeqState parseFrom(byte[] bArr) {
        return (SequenceStruct$SeqState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SequenceStruct$SeqState parseFrom(byte[] bArr, C2394s c2394s) {
        return (SequenceStruct$SeqState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SequenceStruct$SeqState parseFrom(InputStream inputStream) {
        return (SequenceStruct$SeqState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SequenceStruct$SeqState parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SequenceStruct$SeqState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SequenceStruct$SeqState parseFrom(AbstractC2384h abstractC2384h) {
        return (SequenceStruct$SeqState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SequenceStruct$SeqState parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SequenceStruct$SeqState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
