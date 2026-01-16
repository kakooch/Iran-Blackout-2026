package ai.bale.proto;

import ai.bale.proto.PeersStruct$ExPeer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.LP5;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class ReportStruct$PeerReport extends GeneratedMessageLite implements U64 {
    private static final ReportStruct$PeerReport DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 2;
    public static final int SOURCE_FIELD_NUMBER = 1;
    private int bitField0_;
    private PeersStruct$ExPeer peer_;
    private int source_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(PeersStruct$ExPeer peersStruct$ExPeer) {
            q();
            ((ReportStruct$PeerReport) this.b).setPeer(peersStruct$ExPeer);
            return this;
        }

        public a B(LP5 lp5) {
            q();
            ((ReportStruct$PeerReport) this.b).setSource(lp5);
            return this;
        }

        private a() {
            super(ReportStruct$PeerReport.DEFAULT_INSTANCE);
        }
    }

    static {
        ReportStruct$PeerReport reportStruct$PeerReport = new ReportStruct$PeerReport();
        DEFAULT_INSTANCE = reportStruct$PeerReport;
        GeneratedMessageLite.registerDefaultInstance(ReportStruct$PeerReport.class, reportStruct$PeerReport);
    }

    private ReportStruct$PeerReport() {
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearSource() {
        this.source_ = 0;
    }

    public static ReportStruct$PeerReport getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        PeersStruct$ExPeer peersStruct$ExPeer2 = this.peer_;
        if (peersStruct$ExPeer2 == null || peersStruct$ExPeer2 == PeersStruct$ExPeer.getDefaultInstance()) {
            this.peer_ = peersStruct$ExPeer;
        } else {
            this.peer_ = (PeersStruct$ExPeer) ((PeersStruct$ExPeer.a) PeersStruct$ExPeer.newBuilder(this.peer_).v(peersStruct$ExPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static ReportStruct$PeerReport parseDelimitedFrom(InputStream inputStream) {
        return (ReportStruct$PeerReport) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ReportStruct$PeerReport parseFrom(ByteBuffer byteBuffer) {
        return (ReportStruct$PeerReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        this.peer_ = peersStruct$ExPeer;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSource(LP5 lp5) {
        this.source_ = lp5.getNumber();
    }

    private void setSourceValue(int i) {
        this.source_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1913z1.a[gVar.ordinal()]) {
            case 1:
                return new ReportStruct$PeerReport();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002ဉ\u0000", new Object[]{"bitField0_", "source_", "peer_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ReportStruct$PeerReport.class) {
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

    public PeersStruct$ExPeer getPeer() {
        PeersStruct$ExPeer peersStruct$ExPeer = this.peer_;
        return peersStruct$ExPeer == null ? PeersStruct$ExPeer.getDefaultInstance() : peersStruct$ExPeer;
    }

    public LP5 getSource() {
        LP5 lp5J = LP5.j(this.source_);
        return lp5J == null ? LP5.UNRECOGNIZED : lp5J;
    }

    public int getSourceValue() {
        return this.source_;
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(ReportStruct$PeerReport reportStruct$PeerReport) {
        return (a) DEFAULT_INSTANCE.createBuilder(reportStruct$PeerReport);
    }

    public static ReportStruct$PeerReport parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ReportStruct$PeerReport) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ReportStruct$PeerReport parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ReportStruct$PeerReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ReportStruct$PeerReport parseFrom(AbstractC2383g abstractC2383g) {
        return (ReportStruct$PeerReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static ReportStruct$PeerReport parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ReportStruct$PeerReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ReportStruct$PeerReport parseFrom(byte[] bArr) {
        return (ReportStruct$PeerReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ReportStruct$PeerReport parseFrom(byte[] bArr, C2394s c2394s) {
        return (ReportStruct$PeerReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ReportStruct$PeerReport parseFrom(InputStream inputStream) {
        return (ReportStruct$PeerReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ReportStruct$PeerReport parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ReportStruct$PeerReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ReportStruct$PeerReport parseFrom(AbstractC2384h abstractC2384h) {
        return (ReportStruct$PeerReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ReportStruct$PeerReport parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ReportStruct$PeerReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
