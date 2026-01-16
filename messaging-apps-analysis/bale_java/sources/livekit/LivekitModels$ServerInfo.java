package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitModels$ServerInfo extends GeneratedMessageLite implements U64 {
    public static final int AGENT_PROTOCOL_FIELD_NUMBER = 7;
    public static final int DEBUG_INFO_FIELD_NUMBER = 6;
    private static final LivekitModels$ServerInfo DEFAULT_INSTANCE;
    public static final int EDITION_FIELD_NUMBER = 1;
    public static final int NODE_ID_FIELD_NUMBER = 5;
    private static volatile KW4 PARSER = null;
    public static final int PROTOCOL_FIELD_NUMBER = 3;
    public static final int REGION_FIELD_NUMBER = 4;
    public static final int VERSION_FIELD_NUMBER = 2;
    private int agentProtocol_;
    private int edition_;
    private int protocol_;
    private String version_ = "";
    private String region_ = "";
    private String nodeId_ = "";
    private String debugInfo_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(o oVar) {
            this();
        }

        private a() {
            super(LivekitModels$ServerInfo.DEFAULT_INSTANCE);
        }
    }

    public enum b implements B.c {
        Standard(0),
        Cloud(1),
        UNRECOGNIZED(-1);

        private static final B.d e = new a();
        private final int a;

        class a implements B.d {
            a() {
            }

            @Override // com.google.protobuf.B.d
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public b a(int i) {
                return b.j(i);
            }
        }

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return Standard;
            }
            if (i != 1) {
                return null;
            }
            return Cloud;
        }

        @Override // com.google.protobuf.B.c
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.a;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    static {
        LivekitModels$ServerInfo livekitModels$ServerInfo = new LivekitModels$ServerInfo();
        DEFAULT_INSTANCE = livekitModels$ServerInfo;
        GeneratedMessageLite.registerDefaultInstance(LivekitModels$ServerInfo.class, livekitModels$ServerInfo);
    }

    private LivekitModels$ServerInfo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAgentProtocol() {
        this.agentProtocol_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDebugInfo() {
        this.debugInfo_ = getDefaultInstance().getDebugInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEdition() {
        this.edition_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNodeId() {
        this.nodeId_ = getDefaultInstance().getNodeId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearProtocol() {
        this.protocol_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRegion() {
        this.region_ = getDefaultInstance().getRegion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = getDefaultInstance().getVersion();
    }

    public static LivekitModels$ServerInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitModels$ServerInfo parseDelimitedFrom(InputStream inputStream) {
        return (LivekitModels$ServerInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$ServerInfo parseFrom(ByteBuffer byteBuffer) {
        return (LivekitModels$ServerInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAgentProtocol(int i) {
        this.agentProtocol_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDebugInfo(String str) {
        str.getClass();
        this.debugInfo_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDebugInfoBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.debugInfo_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEdition(b bVar) {
        this.edition_ = bVar.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEditionValue(int i) {
        this.edition_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNodeId(String str) {
        str.getClass();
        this.nodeId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNodeIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.nodeId_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProtocol(int i) {
        this.protocol_ = i;
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
    public void setVersion(String str) {
        str.getClass();
        this.version_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.version_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        o oVar = null;
        switch (o.a[gVar.ordinal()]) {
            case 1:
                return new LivekitModels$ServerInfo();
            case 2:
                return new a(oVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0000\u0000\u0001\f\u0002Ȉ\u0003\u0004\u0004Ȉ\u0005Ȉ\u0006Ȉ\u0007\u0004", new Object[]{"edition_", "version_", "protocol_", "region_", "nodeId_", "debugInfo_", "agentProtocol_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitModels$ServerInfo.class) {
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

    public int getAgentProtocol() {
        return this.agentProtocol_;
    }

    public String getDebugInfo() {
        return this.debugInfo_;
    }

    public AbstractC2383g getDebugInfoBytes() {
        return AbstractC2383g.N(this.debugInfo_);
    }

    public b getEdition() {
        b bVarJ = b.j(this.edition_);
        return bVarJ == null ? b.UNRECOGNIZED : bVarJ;
    }

    public int getEditionValue() {
        return this.edition_;
    }

    public String getNodeId() {
        return this.nodeId_;
    }

    public AbstractC2383g getNodeIdBytes() {
        return AbstractC2383g.N(this.nodeId_);
    }

    public int getProtocol() {
        return this.protocol_;
    }

    public String getRegion() {
        return this.region_;
    }

    public AbstractC2383g getRegionBytes() {
        return AbstractC2383g.N(this.region_);
    }

    public String getVersion() {
        return this.version_;
    }

    public AbstractC2383g getVersionBytes() {
        return AbstractC2383g.N(this.version_);
    }

    public static a newBuilder(LivekitModels$ServerInfo livekitModels$ServerInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitModels$ServerInfo);
    }

    public static LivekitModels$ServerInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$ServerInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$ServerInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitModels$ServerInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitModels$ServerInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitModels$ServerInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitModels$ServerInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitModels$ServerInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitModels$ServerInfo parseFrom(byte[] bArr) {
        return (LivekitModels$ServerInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitModels$ServerInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitModels$ServerInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitModels$ServerInfo parseFrom(InputStream inputStream) {
        return (LivekitModels$ServerInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$ServerInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$ServerInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$ServerInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitModels$ServerInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitModels$ServerInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitModels$ServerInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
