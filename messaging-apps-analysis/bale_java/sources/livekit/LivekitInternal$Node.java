package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EE3;
import ir.nasim.GE3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import livekit.LivekitInternal$NodeStats;

/* loaded from: classes8.dex */
public final class LivekitInternal$Node extends GeneratedMessageLite implements U64 {
    private static final LivekitInternal$Node DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int IP_FIELD_NUMBER = 2;
    public static final int NUM_CPUS_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int REGION_FIELD_NUMBER = 7;
    public static final int STATE_FIELD_NUMBER = 6;
    public static final int STATS_FIELD_NUMBER = 4;
    public static final int TYPE_FIELD_NUMBER = 5;
    private int numCpus_;
    private int state_;
    private LivekitInternal$NodeStats stats_;
    private int type_;
    private String id_ = "";
    private String ip_ = "";
    private String region_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(m mVar) {
            this();
        }

        private a() {
            super(LivekitInternal$Node.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitInternal$Node livekitInternal$Node = new LivekitInternal$Node();
        DEFAULT_INSTANCE = livekitInternal$Node;
        GeneratedMessageLite.registerDefaultInstance(LivekitInternal$Node.class, livekitInternal$Node);
    }

    private LivekitInternal$Node() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIp() {
        this.ip_ = getDefaultInstance().getIp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNumCpus() {
        this.numCpus_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRegion() {
        this.region_ = getDefaultInstance().getRegion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearState() {
        this.state_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStats() {
        this.stats_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearType() {
        this.type_ = 0;
    }

    public static LivekitInternal$Node getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeStats(LivekitInternal$NodeStats livekitInternal$NodeStats) {
        livekitInternal$NodeStats.getClass();
        LivekitInternal$NodeStats livekitInternal$NodeStats2 = this.stats_;
        if (livekitInternal$NodeStats2 == null || livekitInternal$NodeStats2 == LivekitInternal$NodeStats.getDefaultInstance()) {
            this.stats_ = livekitInternal$NodeStats;
        } else {
            this.stats_ = (LivekitInternal$NodeStats) ((LivekitInternal$NodeStats.a) LivekitInternal$NodeStats.newBuilder(this.stats_).v(livekitInternal$NodeStats)).j();
        }
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitInternal$Node parseDelimitedFrom(InputStream inputStream) {
        return (LivekitInternal$Node) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitInternal$Node parseFrom(ByteBuffer byteBuffer) {
        return (LivekitInternal$Node) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setId(String str) {
        str.getClass();
        this.id_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.id_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIp(String str) {
        str.getClass();
        this.ip_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIpBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.ip_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNumCpus(int i) {
        this.numCpus_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRegion(String str) {
        str.getClass();
        this.region_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRegionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.region_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setState(EE3 ee3) {
        this.state_ = ee3.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStateValue(int i) {
        this.state_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStats(LivekitInternal$NodeStats livekitInternal$NodeStats) {
        livekitInternal$NodeStats.getClass();
        this.stats_ = livekitInternal$NodeStats;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setType(GE3 ge3) {
        this.type_ = ge3.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTypeValue(int i) {
        this.type_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        m mVar = null;
        switch (m.a[gVar.ordinal()]) {
            case 1:
                return new LivekitInternal$Node();
            case 2:
                return new a(mVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u000b\u0004\t\u0005\f\u0006\f\u0007Ȉ", new Object[]{"id_", "ip_", "numCpus_", "stats_", "type_", "state_", "region_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitInternal$Node.class) {
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

    public String getId() {
        return this.id_;
    }

    public AbstractC2383g getIdBytes() {
        return AbstractC2383g.N(this.id_);
    }

    public String getIp() {
        return this.ip_;
    }

    public AbstractC2383g getIpBytes() {
        return AbstractC2383g.N(this.ip_);
    }

    public int getNumCpus() {
        return this.numCpus_;
    }

    public String getRegion() {
        return this.region_;
    }

    public AbstractC2383g getRegionBytes() {
        return AbstractC2383g.N(this.region_);
    }

    public EE3 getState() {
        EE3 ee3J = EE3.j(this.state_);
        return ee3J == null ? EE3.UNRECOGNIZED : ee3J;
    }

    public int getStateValue() {
        return this.state_;
    }

    public LivekitInternal$NodeStats getStats() {
        LivekitInternal$NodeStats livekitInternal$NodeStats = this.stats_;
        return livekitInternal$NodeStats == null ? LivekitInternal$NodeStats.getDefaultInstance() : livekitInternal$NodeStats;
    }

    public GE3 getType() {
        GE3 ge3J = GE3.j(this.type_);
        return ge3J == null ? GE3.UNRECOGNIZED : ge3J;
    }

    public int getTypeValue() {
        return this.type_;
    }

    public boolean hasStats() {
        return this.stats_ != null;
    }

    public static a newBuilder(LivekitInternal$Node livekitInternal$Node) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitInternal$Node);
    }

    public static LivekitInternal$Node parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitInternal$Node) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitInternal$Node parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitInternal$Node) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitInternal$Node parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitInternal$Node) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitInternal$Node parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitInternal$Node) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitInternal$Node parseFrom(byte[] bArr) {
        return (LivekitInternal$Node) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitInternal$Node parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitInternal$Node) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitInternal$Node parseFrom(InputStream inputStream) {
        return (LivekitInternal$Node) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitInternal$Node parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitInternal$Node) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitInternal$Node parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitInternal$Node) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitInternal$Node parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitInternal$Node) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
