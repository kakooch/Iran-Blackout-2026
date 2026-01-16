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

/* loaded from: classes.dex */
public final class ReportOuterClass$RequestReportDismiss extends GeneratedMessageLite implements U64 {
    private static final ReportOuterClass$RequestReportDismiss DEFAULT_INSTANCE;
    public static final int EX_PEER_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private PeersStruct$ExPeer exPeer_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(PeersStruct$ExPeer peersStruct$ExPeer) {
            q();
            ((ReportOuterClass$RequestReportDismiss) this.b).setExPeer(peersStruct$ExPeer);
            return this;
        }

        private a() {
            super(ReportOuterClass$RequestReportDismiss.DEFAULT_INSTANCE);
        }
    }

    static {
        ReportOuterClass$RequestReportDismiss reportOuterClass$RequestReportDismiss = new ReportOuterClass$RequestReportDismiss();
        DEFAULT_INSTANCE = reportOuterClass$RequestReportDismiss;
        GeneratedMessageLite.registerDefaultInstance(ReportOuterClass$RequestReportDismiss.class, reportOuterClass$RequestReportDismiss);
    }

    private ReportOuterClass$RequestReportDismiss() {
    }

    private void clearExPeer() {
        this.exPeer_ = null;
        this.bitField0_ &= -2;
    }

    public static ReportOuterClass$RequestReportDismiss getDefaultInstance() {
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

    public static ReportOuterClass$RequestReportDismiss parseDelimitedFrom(InputStream inputStream) {
        return (ReportOuterClass$RequestReportDismiss) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ReportOuterClass$RequestReportDismiss parseFrom(ByteBuffer byteBuffer) {
        return (ReportOuterClass$RequestReportDismiss) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setExPeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        this.exPeer_ = peersStruct$ExPeer;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1910y1.a[gVar.ordinal()]) {
            case 1:
                return new ReportOuterClass$RequestReportDismiss();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0002\u0002\u0001\u0000\u0000\u0000\u0002ဉ\u0000", new Object[]{"bitField0_", "exPeer_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ReportOuterClass$RequestReportDismiss.class) {
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

    public static a newBuilder(ReportOuterClass$RequestReportDismiss reportOuterClass$RequestReportDismiss) {
        return (a) DEFAULT_INSTANCE.createBuilder(reportOuterClass$RequestReportDismiss);
    }

    public static ReportOuterClass$RequestReportDismiss parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ReportOuterClass$RequestReportDismiss) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ReportOuterClass$RequestReportDismiss parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ReportOuterClass$RequestReportDismiss) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ReportOuterClass$RequestReportDismiss parseFrom(AbstractC2383g abstractC2383g) {
        return (ReportOuterClass$RequestReportDismiss) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static ReportOuterClass$RequestReportDismiss parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ReportOuterClass$RequestReportDismiss) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ReportOuterClass$RequestReportDismiss parseFrom(byte[] bArr) {
        return (ReportOuterClass$RequestReportDismiss) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ReportOuterClass$RequestReportDismiss parseFrom(byte[] bArr, C2394s c2394s) {
        return (ReportOuterClass$RequestReportDismiss) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ReportOuterClass$RequestReportDismiss parseFrom(InputStream inputStream) {
        return (ReportOuterClass$RequestReportDismiss) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ReportOuterClass$RequestReportDismiss parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ReportOuterClass$RequestReportDismiss) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ReportOuterClass$RequestReportDismiss parseFrom(AbstractC2384h abstractC2384h) {
        return (ReportOuterClass$RequestReportDismiss) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ReportOuterClass$RequestReportDismiss parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ReportOuterClass$RequestReportDismiss) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
