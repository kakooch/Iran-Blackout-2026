package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC13451gF3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import livekit.LivekitEgress$DirectFileOutput;

/* loaded from: classes8.dex */
public final class LivekitEgress$TrackEgressRequest extends GeneratedMessageLite implements U64 {
    private static final LivekitEgress$TrackEgressRequest DEFAULT_INSTANCE;
    public static final int FILE_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int ROOM_NAME_FIELD_NUMBER = 1;
    public static final int TRACK_ID_FIELD_NUMBER = 2;
    public static final int WEBHOOKS_FIELD_NUMBER = 5;
    public static final int WEBSOCKET_URL_FIELD_NUMBER = 4;
    private Object output_;
    private int outputCase_ = 0;
    private String roomName_ = "";
    private String trackId_ = "";
    private B.j webhooks_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(f fVar) {
            this();
        }

        private a() {
            super(LivekitEgress$TrackEgressRequest.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        FILE(3),
        WEBSOCKET_URL(4),
        OUTPUT_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return OUTPUT_NOT_SET;
            }
            if (i == 3) {
                return FILE;
            }
            if (i != 4) {
                return null;
            }
            return WEBSOCKET_URL;
        }
    }

    static {
        LivekitEgress$TrackEgressRequest livekitEgress$TrackEgressRequest = new LivekitEgress$TrackEgressRequest();
        DEFAULT_INSTANCE = livekitEgress$TrackEgressRequest;
        GeneratedMessageLite.registerDefaultInstance(LivekitEgress$TrackEgressRequest.class, livekitEgress$TrackEgressRequest);
    }

    private LivekitEgress$TrackEgressRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllWebhooks(Iterable<? extends LivekitModels$WebhookConfig> iterable) {
        ensureWebhooksIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.webhooks_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addWebhooks(LivekitModels$WebhookConfig livekitModels$WebhookConfig) {
        livekitModels$WebhookConfig.getClass();
        ensureWebhooksIsMutable();
        this.webhooks_.add(livekitModels$WebhookConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFile() {
        if (this.outputCase_ == 3) {
            this.outputCase_ = 0;
            this.output_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOutput() {
        this.outputCase_ = 0;
        this.output_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRoomName() {
        this.roomName_ = getDefaultInstance().getRoomName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTrackId() {
        this.trackId_ = getDefaultInstance().getTrackId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearWebhooks() {
        this.webhooks_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearWebsocketUrl() {
        if (this.outputCase_ == 4) {
            this.outputCase_ = 0;
            this.output_ = null;
        }
    }

    private void ensureWebhooksIsMutable() {
        B.j jVar = this.webhooks_;
        if (jVar.u()) {
            return;
        }
        this.webhooks_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitEgress$TrackEgressRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeFile(LivekitEgress$DirectFileOutput livekitEgress$DirectFileOutput) {
        livekitEgress$DirectFileOutput.getClass();
        if (this.outputCase_ != 3 || this.output_ == LivekitEgress$DirectFileOutput.getDefaultInstance()) {
            this.output_ = livekitEgress$DirectFileOutput;
        } else {
            this.output_ = ((LivekitEgress$DirectFileOutput.a) LivekitEgress$DirectFileOutput.newBuilder((LivekitEgress$DirectFileOutput) this.output_).v(livekitEgress$DirectFileOutput)).j();
        }
        this.outputCase_ = 3;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitEgress$TrackEgressRequest parseDelimitedFrom(InputStream inputStream) {
        return (LivekitEgress$TrackEgressRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitEgress$TrackEgressRequest parseFrom(ByteBuffer byteBuffer) {
        return (LivekitEgress$TrackEgressRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeWebhooks(int i) {
        ensureWebhooksIsMutable();
        this.webhooks_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFile(LivekitEgress$DirectFileOutput livekitEgress$DirectFileOutput) {
        livekitEgress$DirectFileOutput.getClass();
        this.output_ = livekitEgress$DirectFileOutput;
        this.outputCase_ = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRoomName(String str) {
        str.getClass();
        this.roomName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRoomNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.roomName_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTrackId(String str) {
        str.getClass();
        this.trackId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTrackIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.trackId_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWebhooks(int i, LivekitModels$WebhookConfig livekitModels$WebhookConfig) {
        livekitModels$WebhookConfig.getClass();
        ensureWebhooksIsMutable();
        this.webhooks_.set(i, livekitModels$WebhookConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWebsocketUrl(String str) {
        str.getClass();
        this.outputCase_ = 4;
        this.output_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWebsocketUrlBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.output_ = abstractC2383g.f0();
        this.outputCase_ = 4;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        f fVar = null;
        switch (f.a[gVar.ordinal()]) {
            case 1:
                return new LivekitEgress$TrackEgressRequest();
            case 2:
                return new a(fVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0001\u0000\u0001\u0005\u0005\u0000\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003<\u0000\u0004Ȼ\u0000\u0005\u001b", new Object[]{"output_", "outputCase_", "roomName_", "trackId_", LivekitEgress$DirectFileOutput.class, "webhooks_", LivekitModels$WebhookConfig.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitEgress$TrackEgressRequest.class) {
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

    public LivekitEgress$DirectFileOutput getFile() {
        return this.outputCase_ == 3 ? (LivekitEgress$DirectFileOutput) this.output_ : LivekitEgress$DirectFileOutput.getDefaultInstance();
    }

    public b getOutputCase() {
        return b.j(this.outputCase_);
    }

    public String getRoomName() {
        return this.roomName_;
    }

    public AbstractC2383g getRoomNameBytes() {
        return AbstractC2383g.N(this.roomName_);
    }

    public String getTrackId() {
        return this.trackId_;
    }

    public AbstractC2383g getTrackIdBytes() {
        return AbstractC2383g.N(this.trackId_);
    }

    public LivekitModels$WebhookConfig getWebhooks(int i) {
        return (LivekitModels$WebhookConfig) this.webhooks_.get(i);
    }

    public int getWebhooksCount() {
        return this.webhooks_.size();
    }

    public List<LivekitModels$WebhookConfig> getWebhooksList() {
        return this.webhooks_;
    }

    public InterfaceC13451gF3 getWebhooksOrBuilder(int i) {
        return (InterfaceC13451gF3) this.webhooks_.get(i);
    }

    public List<? extends InterfaceC13451gF3> getWebhooksOrBuilderList() {
        return this.webhooks_;
    }

    public String getWebsocketUrl() {
        return this.outputCase_ == 4 ? (String) this.output_ : "";
    }

    public AbstractC2383g getWebsocketUrlBytes() {
        return AbstractC2383g.N(this.outputCase_ == 4 ? (String) this.output_ : "");
    }

    public boolean hasFile() {
        return this.outputCase_ == 3;
    }

    public boolean hasWebsocketUrl() {
        return this.outputCase_ == 4;
    }

    public static a newBuilder(LivekitEgress$TrackEgressRequest livekitEgress$TrackEgressRequest) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitEgress$TrackEgressRequest);
    }

    public static LivekitEgress$TrackEgressRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitEgress$TrackEgressRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitEgress$TrackEgressRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitEgress$TrackEgressRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitEgress$TrackEgressRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitEgress$TrackEgressRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addWebhooks(int i, LivekitModels$WebhookConfig livekitModels$WebhookConfig) {
        livekitModels$WebhookConfig.getClass();
        ensureWebhooksIsMutable();
        this.webhooks_.add(i, livekitModels$WebhookConfig);
    }

    public static LivekitEgress$TrackEgressRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitEgress$TrackEgressRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitEgress$TrackEgressRequest parseFrom(byte[] bArr) {
        return (LivekitEgress$TrackEgressRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitEgress$TrackEgressRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitEgress$TrackEgressRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitEgress$TrackEgressRequest parseFrom(InputStream inputStream) {
        return (LivekitEgress$TrackEgressRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitEgress$TrackEgressRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitEgress$TrackEgressRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitEgress$TrackEgressRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitEgress$TrackEgressRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitEgress$TrackEgressRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitEgress$TrackEgressRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
