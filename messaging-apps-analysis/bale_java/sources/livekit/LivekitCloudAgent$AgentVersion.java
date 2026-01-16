package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Timestamp;
import ir.nasim.InterfaceC15824kE3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitCloudAgent$AgentVersion extends GeneratedMessageLite implements InterfaceC15824kE3 {
    public static final int CREATED_AT_FIELD_NUMBER = 3;
    public static final int CURRENT_FIELD_NUMBER = 2;
    private static final LivekitCloudAgent$AgentVersion DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private Timestamp createdAt_;
    private boolean current_;
    private String version_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC15824kE3 {
        /* synthetic */ a(e eVar) {
            this();
        }

        private a() {
            super(LivekitCloudAgent$AgentVersion.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitCloudAgent$AgentVersion livekitCloudAgent$AgentVersion = new LivekitCloudAgent$AgentVersion();
        DEFAULT_INSTANCE = livekitCloudAgent$AgentVersion;
        GeneratedMessageLite.registerDefaultInstance(LivekitCloudAgent$AgentVersion.class, livekitCloudAgent$AgentVersion);
    }

    private LivekitCloudAgent$AgentVersion() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCreatedAt() {
        this.createdAt_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCurrent() {
        this.current_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = getDefaultInstance().getVersion();
    }

    public static LivekitCloudAgent$AgentVersion getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeCreatedAt(Timestamp timestamp) {
        timestamp.getClass();
        Timestamp timestamp2 = this.createdAt_;
        if (timestamp2 == null || timestamp2 == Timestamp.getDefaultInstance()) {
            this.createdAt_ = timestamp;
        } else {
            this.createdAt_ = (Timestamp) ((Timestamp.b) Timestamp.newBuilder(this.createdAt_).v(timestamp)).j();
        }
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitCloudAgent$AgentVersion parseDelimitedFrom(InputStream inputStream) {
        return (LivekitCloudAgent$AgentVersion) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitCloudAgent$AgentVersion parseFrom(ByteBuffer byteBuffer) {
        return (LivekitCloudAgent$AgentVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCreatedAt(Timestamp timestamp) {
        timestamp.getClass();
        this.createdAt_ = timestamp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrent(boolean z) {
        this.current_ = z;
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
        e eVar = null;
        switch (e.a[gVar.ordinal()]) {
            case 1:
                return new LivekitCloudAgent$AgentVersion();
            case 2:
                return new a(eVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\u0007\u0003\t", new Object[]{"version_", "current_", "createdAt_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitCloudAgent$AgentVersion.class) {
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

    public Timestamp getCreatedAt() {
        Timestamp timestamp = this.createdAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    public boolean getCurrent() {
        return this.current_;
    }

    public String getVersion() {
        return this.version_;
    }

    public AbstractC2383g getVersionBytes() {
        return AbstractC2383g.N(this.version_);
    }

    public boolean hasCreatedAt() {
        return this.createdAt_ != null;
    }

    public static a newBuilder(LivekitCloudAgent$AgentVersion livekitCloudAgent$AgentVersion) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitCloudAgent$AgentVersion);
    }

    public static LivekitCloudAgent$AgentVersion parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitCloudAgent$AgentVersion) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitCloudAgent$AgentVersion parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitCloudAgent$AgentVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitCloudAgent$AgentVersion parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitCloudAgent$AgentVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitCloudAgent$AgentVersion parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitCloudAgent$AgentVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitCloudAgent$AgentVersion parseFrom(byte[] bArr) {
        return (LivekitCloudAgent$AgentVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitCloudAgent$AgentVersion parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitCloudAgent$AgentVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitCloudAgent$AgentVersion parseFrom(InputStream inputStream) {
        return (LivekitCloudAgent$AgentVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitCloudAgent$AgentVersion parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitCloudAgent$AgentVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitCloudAgent$AgentVersion parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitCloudAgent$AgentVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitCloudAgent$AgentVersion parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitCloudAgent$AgentVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
