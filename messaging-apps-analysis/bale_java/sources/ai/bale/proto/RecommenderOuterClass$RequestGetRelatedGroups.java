package ai.bale.proto;

import ai.bale.proto.PeersStruct$ExPeer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class RecommenderOuterClass$RequestGetRelatedGroups extends GeneratedMessageLite implements U64 {
    private static final RecommenderOuterClass$RequestGetRelatedGroups DEFAULT_INSTANCE;
    public static final int EX_PEER_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private PeersStruct$ExPeer exPeer_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(RecommenderOuterClass$RequestGetRelatedGroups.DEFAULT_INSTANCE);
        }
    }

    static {
        RecommenderOuterClass$RequestGetRelatedGroups recommenderOuterClass$RequestGetRelatedGroups = new RecommenderOuterClass$RequestGetRelatedGroups();
        DEFAULT_INSTANCE = recommenderOuterClass$RequestGetRelatedGroups;
        GeneratedMessageLite.registerDefaultInstance(RecommenderOuterClass$RequestGetRelatedGroups.class, recommenderOuterClass$RequestGetRelatedGroups);
    }

    private RecommenderOuterClass$RequestGetRelatedGroups() {
    }

    private void clearExPeer() {
        this.exPeer_ = null;
        this.bitField0_ &= -2;
    }

    public static RecommenderOuterClass$RequestGetRelatedGroups getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeExPeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        PeersStruct$ExPeer peersStruct$ExPeer2 = this.exPeer_;
        if (peersStruct$ExPeer2 == null || peersStruct$ExPeer2 == PeersStruct$ExPeer.getDefaultInstance()) {
            this.exPeer_ = peersStruct$ExPeer;
        } else {
            this.exPeer_ = (PeersStruct$ExPeer) ((PeersStruct$ExPeer.a) PeersStruct$ExPeer.newBuilder(this.exPeer_).v(peersStruct$ExPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static RecommenderOuterClass$RequestGetRelatedGroups parseDelimitedFrom(InputStream inputStream) {
        return (RecommenderOuterClass$RequestGetRelatedGroups) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RecommenderOuterClass$RequestGetRelatedGroups parseFrom(ByteBuffer byteBuffer) {
        return (RecommenderOuterClass$RequestGetRelatedGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setExPeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        this.exPeer_ = peersStruct$ExPeer;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1895t1.a[gVar.ordinal()]) {
            case 1:
                return new RecommenderOuterClass$RequestGetRelatedGroups();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "exPeer_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (RecommenderOuterClass$RequestGetRelatedGroups.class) {
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

    public PeersStruct$ExPeer getExPeer() {
        PeersStruct$ExPeer peersStruct$ExPeer = this.exPeer_;
        return peersStruct$ExPeer == null ? PeersStruct$ExPeer.getDefaultInstance() : peersStruct$ExPeer;
    }

    public boolean hasExPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(RecommenderOuterClass$RequestGetRelatedGroups recommenderOuterClass$RequestGetRelatedGroups) {
        return (a) DEFAULT_INSTANCE.createBuilder(recommenderOuterClass$RequestGetRelatedGroups);
    }

    public static RecommenderOuterClass$RequestGetRelatedGroups parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (RecommenderOuterClass$RequestGetRelatedGroups) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static RecommenderOuterClass$RequestGetRelatedGroups parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (RecommenderOuterClass$RequestGetRelatedGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static RecommenderOuterClass$RequestGetRelatedGroups parseFrom(AbstractC2383g abstractC2383g) {
        return (RecommenderOuterClass$RequestGetRelatedGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static RecommenderOuterClass$RequestGetRelatedGroups parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (RecommenderOuterClass$RequestGetRelatedGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static RecommenderOuterClass$RequestGetRelatedGroups parseFrom(byte[] bArr) {
        return (RecommenderOuterClass$RequestGetRelatedGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static RecommenderOuterClass$RequestGetRelatedGroups parseFrom(byte[] bArr, C2394s c2394s) {
        return (RecommenderOuterClass$RequestGetRelatedGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static RecommenderOuterClass$RequestGetRelatedGroups parseFrom(InputStream inputStream) {
        return (RecommenderOuterClass$RequestGetRelatedGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RecommenderOuterClass$RequestGetRelatedGroups parseFrom(InputStream inputStream, C2394s c2394s) {
        return (RecommenderOuterClass$RequestGetRelatedGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static RecommenderOuterClass$RequestGetRelatedGroups parseFrom(AbstractC2384h abstractC2384h) {
        return (RecommenderOuterClass$RequestGetRelatedGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static RecommenderOuterClass$RequestGetRelatedGroups parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (RecommenderOuterClass$RequestGetRelatedGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
