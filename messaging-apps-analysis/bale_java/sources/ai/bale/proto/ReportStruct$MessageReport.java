package ai.bale.proto;

import ai.bale.proto.PeersStruct$ExPeer;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC13043fc4;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class ReportStruct$MessageReport extends GeneratedMessageLite implements U64 {
    private static final ReportStruct$MessageReport DEFAULT_INSTANCE;
    public static final int MIDS_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 1;
    private int bitField0_;
    private B.j mids_ = GeneratedMessageLite.emptyProtobufList();
    private PeersStruct$ExPeer peer_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(Iterable iterable) {
            q();
            ((ReportStruct$MessageReport) this.b).addAllMids(iterable);
            return this;
        }

        public a B(PeersStruct$ExPeer peersStruct$ExPeer) {
            q();
            ((ReportStruct$MessageReport) this.b).setPeer(peersStruct$ExPeer);
            return this;
        }

        private a() {
            super(ReportStruct$MessageReport.DEFAULT_INSTANCE);
        }
    }

    static {
        ReportStruct$MessageReport reportStruct$MessageReport = new ReportStruct$MessageReport();
        DEFAULT_INSTANCE = reportStruct$MessageReport;
        GeneratedMessageLite.registerDefaultInstance(ReportStruct$MessageReport.class, reportStruct$MessageReport);
    }

    private ReportStruct$MessageReport() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllMids(Iterable<? extends MessagingStruct$MessageId> iterable) {
        ensureMidsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.mids_);
    }

    private void addMids(MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        ensureMidsIsMutable();
        this.mids_.add(messagingStruct$MessageId);
    }

    private void clearMids() {
        this.mids_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -2;
    }

    private void ensureMidsIsMutable() {
        B.j jVar = this.mids_;
        if (jVar.u()) {
            return;
        }
        this.mids_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static ReportStruct$MessageReport getDefaultInstance() {
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

    public static ReportStruct$MessageReport parseDelimitedFrom(InputStream inputStream) {
        return (ReportStruct$MessageReport) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ReportStruct$MessageReport parseFrom(ByteBuffer byteBuffer) {
        return (ReportStruct$MessageReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeMids(int i) {
        ensureMidsIsMutable();
        this.mids_.remove(i);
    }

    private void setMids(int i, MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        ensureMidsIsMutable();
        this.mids_.set(i, messagingStruct$MessageId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        this.peer_ = peersStruct$ExPeer;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1913z1.a[gVar.ordinal()]) {
            case 1:
                return new ReportStruct$MessageReport();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001b", new Object[]{"bitField0_", "peer_", "mids_", MessagingStruct$MessageId.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ReportStruct$MessageReport.class) {
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

    public MessagingStruct$MessageId getMids(int i) {
        return (MessagingStruct$MessageId) this.mids_.get(i);
    }

    public int getMidsCount() {
        return this.mids_.size();
    }

    public List<MessagingStruct$MessageId> getMidsList() {
        return this.mids_;
    }

    public InterfaceC13043fc4 getMidsOrBuilder(int i) {
        return (InterfaceC13043fc4) this.mids_.get(i);
    }

    public List<? extends InterfaceC13043fc4> getMidsOrBuilderList() {
        return this.mids_;
    }

    public PeersStruct$ExPeer getPeer() {
        PeersStruct$ExPeer peersStruct$ExPeer = this.peer_;
        return peersStruct$ExPeer == null ? PeersStruct$ExPeer.getDefaultInstance() : peersStruct$ExPeer;
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(ReportStruct$MessageReport reportStruct$MessageReport) {
        return (a) DEFAULT_INSTANCE.createBuilder(reportStruct$MessageReport);
    }

    public static ReportStruct$MessageReport parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ReportStruct$MessageReport) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ReportStruct$MessageReport parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ReportStruct$MessageReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ReportStruct$MessageReport parseFrom(AbstractC2383g abstractC2383g) {
        return (ReportStruct$MessageReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addMids(int i, MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        ensureMidsIsMutable();
        this.mids_.add(i, messagingStruct$MessageId);
    }

    public static ReportStruct$MessageReport parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ReportStruct$MessageReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ReportStruct$MessageReport parseFrom(byte[] bArr) {
        return (ReportStruct$MessageReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ReportStruct$MessageReport parseFrom(byte[] bArr, C2394s c2394s) {
        return (ReportStruct$MessageReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ReportStruct$MessageReport parseFrom(InputStream inputStream) {
        return (ReportStruct$MessageReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ReportStruct$MessageReport parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ReportStruct$MessageReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ReportStruct$MessageReport parseFrom(AbstractC2384h abstractC2384h) {
        return (ReportStruct$MessageReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ReportStruct$MessageReport parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ReportStruct$MessageReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
