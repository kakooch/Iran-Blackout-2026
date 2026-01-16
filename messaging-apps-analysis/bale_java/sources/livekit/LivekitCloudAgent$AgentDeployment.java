package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC14033hE3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitCloudAgent$AgentDeployment extends GeneratedMessageLite implements InterfaceC14033hE3 {
    public static final int AGENT_ID_FIELD_NUMBER = 2;
    public static final int CPU_LIMIT_FIELD_NUMBER = 12;
    public static final int CPU_REQ_FIELD_NUMBER = 7;
    public static final int CUR_CPU_FIELD_NUMBER = 8;
    public static final int CUR_MEM_FIELD_NUMBER = 9;
    private static final LivekitCloudAgent$AgentDeployment DEFAULT_INSTANCE;
    public static final int MAX_REPLICAS_FIELD_NUMBER = 6;
    public static final int MEM_LIMIT_FIELD_NUMBER = 11;
    public static final int MEM_REQ_FIELD_NUMBER = 10;
    public static final int MIN_REPLICAS_FIELD_NUMBER = 5;
    private static volatile KW4 PARSER = null;
    public static final int REGION_FIELD_NUMBER = 1;
    public static final int REPLICAS_FIELD_NUMBER = 4;
    public static final int STATUS_FIELD_NUMBER = 3;
    private int maxReplicas_;
    private int minReplicas_;
    private int replicas_;
    private String region_ = "";
    private String agentId_ = "";
    private String status_ = "";
    private String cpuReq_ = "";
    private String curCpu_ = "";
    private String curMem_ = "";
    private String memReq_ = "";
    private String memLimit_ = "";
    private String cpuLimit_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC14033hE3 {
        /* synthetic */ a(e eVar) {
            this();
        }

        private a() {
            super(LivekitCloudAgent$AgentDeployment.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitCloudAgent$AgentDeployment livekitCloudAgent$AgentDeployment = new LivekitCloudAgent$AgentDeployment();
        DEFAULT_INSTANCE = livekitCloudAgent$AgentDeployment;
        GeneratedMessageLite.registerDefaultInstance(LivekitCloudAgent$AgentDeployment.class, livekitCloudAgent$AgentDeployment);
    }

    private LivekitCloudAgent$AgentDeployment() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAgentId() {
        this.agentId_ = getDefaultInstance().getAgentId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCpuLimit() {
        this.cpuLimit_ = getDefaultInstance().getCpuLimit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCpuReq() {
        this.cpuReq_ = getDefaultInstance().getCpuReq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCurCpu() {
        this.curCpu_ = getDefaultInstance().getCurCpu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCurMem() {
        this.curMem_ = getDefaultInstance().getCurMem();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMaxReplicas() {
        this.maxReplicas_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMemLimit() {
        this.memLimit_ = getDefaultInstance().getMemLimit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMemReq() {
        this.memReq_ = getDefaultInstance().getMemReq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMinReplicas() {
        this.minReplicas_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRegion() {
        this.region_ = getDefaultInstance().getRegion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearReplicas() {
        this.replicas_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStatus() {
        this.status_ = getDefaultInstance().getStatus();
    }

    public static LivekitCloudAgent$AgentDeployment getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitCloudAgent$AgentDeployment parseDelimitedFrom(InputStream inputStream) {
        return (LivekitCloudAgent$AgentDeployment) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitCloudAgent$AgentDeployment parseFrom(ByteBuffer byteBuffer) {
        return (LivekitCloudAgent$AgentDeployment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAgentId(String str) {
        str.getClass();
        this.agentId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAgentIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.agentId_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCpuLimit(String str) {
        str.getClass();
        this.cpuLimit_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCpuLimitBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.cpuLimit_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCpuReq(String str) {
        str.getClass();
        this.cpuReq_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCpuReqBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.cpuReq_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurCpu(String str) {
        str.getClass();
        this.curCpu_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurCpuBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.curCpu_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurMem(String str) {
        str.getClass();
        this.curMem_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurMemBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.curMem_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaxReplicas(int i) {
        this.maxReplicas_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMemLimit(String str) {
        str.getClass();
        this.memLimit_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMemLimitBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.memLimit_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMemReq(String str) {
        str.getClass();
        this.memReq_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMemReqBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.memReq_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMinReplicas(int i) {
        this.minReplicas_ = i;
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
    public void setReplicas(int i) {
        this.replicas_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatus(String str) {
        str.getClass();
        this.status_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatusBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.status_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        e eVar = null;
        switch (e.a[gVar.ordinal()]) {
            case 1:
                return new LivekitCloudAgent$AgentDeployment();
            case 2:
                return new a(eVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\f\u0000\u0000\u0001\f\f\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004\u0004\u0005\u0004\u0006\u0004\u0007Ȉ\bȈ\tȈ\nȈ\u000bȈ\fȈ", new Object[]{"region_", "agentId_", "status_", "replicas_", "minReplicas_", "maxReplicas_", "cpuReq_", "curCpu_", "curMem_", "memReq_", "memLimit_", "cpuLimit_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitCloudAgent$AgentDeployment.class) {
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

    public String getAgentId() {
        return this.agentId_;
    }

    public AbstractC2383g getAgentIdBytes() {
        return AbstractC2383g.N(this.agentId_);
    }

    public String getCpuLimit() {
        return this.cpuLimit_;
    }

    public AbstractC2383g getCpuLimitBytes() {
        return AbstractC2383g.N(this.cpuLimit_);
    }

    public String getCpuReq() {
        return this.cpuReq_;
    }

    public AbstractC2383g getCpuReqBytes() {
        return AbstractC2383g.N(this.cpuReq_);
    }

    public String getCurCpu() {
        return this.curCpu_;
    }

    public AbstractC2383g getCurCpuBytes() {
        return AbstractC2383g.N(this.curCpu_);
    }

    public String getCurMem() {
        return this.curMem_;
    }

    public AbstractC2383g getCurMemBytes() {
        return AbstractC2383g.N(this.curMem_);
    }

    public int getMaxReplicas() {
        return this.maxReplicas_;
    }

    public String getMemLimit() {
        return this.memLimit_;
    }

    public AbstractC2383g getMemLimitBytes() {
        return AbstractC2383g.N(this.memLimit_);
    }

    public String getMemReq() {
        return this.memReq_;
    }

    public AbstractC2383g getMemReqBytes() {
        return AbstractC2383g.N(this.memReq_);
    }

    public int getMinReplicas() {
        return this.minReplicas_;
    }

    public String getRegion() {
        return this.region_;
    }

    public AbstractC2383g getRegionBytes() {
        return AbstractC2383g.N(this.region_);
    }

    public int getReplicas() {
        return this.replicas_;
    }

    public String getStatus() {
        return this.status_;
    }

    public AbstractC2383g getStatusBytes() {
        return AbstractC2383g.N(this.status_);
    }

    public static a newBuilder(LivekitCloudAgent$AgentDeployment livekitCloudAgent$AgentDeployment) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitCloudAgent$AgentDeployment);
    }

    public static LivekitCloudAgent$AgentDeployment parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitCloudAgent$AgentDeployment) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitCloudAgent$AgentDeployment parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitCloudAgent$AgentDeployment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitCloudAgent$AgentDeployment parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitCloudAgent$AgentDeployment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitCloudAgent$AgentDeployment parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitCloudAgent$AgentDeployment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitCloudAgent$AgentDeployment parseFrom(byte[] bArr) {
        return (LivekitCloudAgent$AgentDeployment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitCloudAgent$AgentDeployment parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitCloudAgent$AgentDeployment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitCloudAgent$AgentDeployment parseFrom(InputStream inputStream) {
        return (LivekitCloudAgent$AgentDeployment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitCloudAgent$AgentDeployment parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitCloudAgent$AgentDeployment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitCloudAgent$AgentDeployment parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitCloudAgent$AgentDeployment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitCloudAgent$AgentDeployment parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitCloudAgent$AgentDeployment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
