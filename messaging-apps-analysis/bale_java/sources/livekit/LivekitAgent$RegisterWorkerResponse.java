package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import livekit.LivekitModels$ServerInfo;

/* loaded from: classes8.dex */
public final class LivekitAgent$RegisterWorkerResponse extends GeneratedMessageLite implements U64 {
    private static final LivekitAgent$RegisterWorkerResponse DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int SERVER_INFO_FIELD_NUMBER = 3;
    public static final int WORKER_ID_FIELD_NUMBER = 1;
    private LivekitModels$ServerInfo serverInfo_;
    private String workerId_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(livekit.a aVar) {
            this();
        }

        private a() {
            super(LivekitAgent$RegisterWorkerResponse.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitAgent$RegisterWorkerResponse livekitAgent$RegisterWorkerResponse = new LivekitAgent$RegisterWorkerResponse();
        DEFAULT_INSTANCE = livekitAgent$RegisterWorkerResponse;
        GeneratedMessageLite.registerDefaultInstance(LivekitAgent$RegisterWorkerResponse.class, livekitAgent$RegisterWorkerResponse);
    }

    private LivekitAgent$RegisterWorkerResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearServerInfo() {
        this.serverInfo_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearWorkerId() {
        this.workerId_ = getDefaultInstance().getWorkerId();
    }

    public static LivekitAgent$RegisterWorkerResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeServerInfo(LivekitModels$ServerInfo livekitModels$ServerInfo) {
        livekitModels$ServerInfo.getClass();
        LivekitModels$ServerInfo livekitModels$ServerInfo2 = this.serverInfo_;
        if (livekitModels$ServerInfo2 == null || livekitModels$ServerInfo2 == LivekitModels$ServerInfo.getDefaultInstance()) {
            this.serverInfo_ = livekitModels$ServerInfo;
        } else {
            this.serverInfo_ = (LivekitModels$ServerInfo) ((LivekitModels$ServerInfo.a) LivekitModels$ServerInfo.newBuilder(this.serverInfo_).v(livekitModels$ServerInfo)).j();
        }
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitAgent$RegisterWorkerResponse parseDelimitedFrom(InputStream inputStream) {
        return (LivekitAgent$RegisterWorkerResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAgent$RegisterWorkerResponse parseFrom(ByteBuffer byteBuffer) {
        return (LivekitAgent$RegisterWorkerResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setServerInfo(LivekitModels$ServerInfo livekitModels$ServerInfo) {
        livekitModels$ServerInfo.getClass();
        this.serverInfo_ = livekitModels$ServerInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWorkerId(String str) {
        str.getClass();
        this.workerId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWorkerIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.workerId_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        livekit.a aVar = null;
        switch (livekit.a.a[gVar.ordinal()]) {
            case 1:
                return new LivekitAgent$RegisterWorkerResponse();
            case 2:
                return new a(aVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001Ȉ\u0003\t", new Object[]{"workerId_", "serverInfo_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitAgent$RegisterWorkerResponse.class) {
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

    public LivekitModels$ServerInfo getServerInfo() {
        LivekitModels$ServerInfo livekitModels$ServerInfo = this.serverInfo_;
        return livekitModels$ServerInfo == null ? LivekitModels$ServerInfo.getDefaultInstance() : livekitModels$ServerInfo;
    }

    public String getWorkerId() {
        return this.workerId_;
    }

    public AbstractC2383g getWorkerIdBytes() {
        return AbstractC2383g.N(this.workerId_);
    }

    public boolean hasServerInfo() {
        return this.serverInfo_ != null;
    }

    public static a newBuilder(LivekitAgent$RegisterWorkerResponse livekitAgent$RegisterWorkerResponse) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitAgent$RegisterWorkerResponse);
    }

    public static LivekitAgent$RegisterWorkerResponse parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAgent$RegisterWorkerResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAgent$RegisterWorkerResponse parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitAgent$RegisterWorkerResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitAgent$RegisterWorkerResponse parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitAgent$RegisterWorkerResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitAgent$RegisterWorkerResponse parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitAgent$RegisterWorkerResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitAgent$RegisterWorkerResponse parseFrom(byte[] bArr) {
        return (LivekitAgent$RegisterWorkerResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitAgent$RegisterWorkerResponse parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitAgent$RegisterWorkerResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitAgent$RegisterWorkerResponse parseFrom(InputStream inputStream) {
        return (LivekitAgent$RegisterWorkerResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAgent$RegisterWorkerResponse parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAgent$RegisterWorkerResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAgent$RegisterWorkerResponse parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitAgent$RegisterWorkerResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitAgent$RegisterWorkerResponse parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitAgent$RegisterWorkerResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
