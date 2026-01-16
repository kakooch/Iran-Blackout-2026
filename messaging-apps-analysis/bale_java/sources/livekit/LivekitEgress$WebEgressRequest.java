package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC19370qE3;
import ir.nasim.InterfaceC13451gF3;
import ir.nasim.InterfaceC23623xE3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import livekit.LivekitEgress$EncodedFileOutput;
import livekit.LivekitEgress$EncodingOptions;
import livekit.LivekitEgress$SegmentedFileOutput;
import livekit.LivekitEgress$StreamOutput;

/* loaded from: classes8.dex */
public final class LivekitEgress$WebEgressRequest extends GeneratedMessageLite implements U64 {
    public static final int ADVANCED_FIELD_NUMBER = 8;
    public static final int AUDIO_ONLY_FIELD_NUMBER = 2;
    public static final int AWAIT_START_SIGNAL_FIELD_NUMBER = 12;
    private static final LivekitEgress$WebEgressRequest DEFAULT_INSTANCE;
    public static final int FILE_FIELD_NUMBER = 4;
    public static final int FILE_OUTPUTS_FIELD_NUMBER = 9;
    public static final int IMAGE_OUTPUTS_FIELD_NUMBER = 13;
    private static volatile KW4 PARSER = null;
    public static final int PRESET_FIELD_NUMBER = 7;
    public static final int SEGMENTS_FIELD_NUMBER = 6;
    public static final int SEGMENT_OUTPUTS_FIELD_NUMBER = 11;
    public static final int STREAM_FIELD_NUMBER = 5;
    public static final int STREAM_OUTPUTS_FIELD_NUMBER = 10;
    public static final int URL_FIELD_NUMBER = 1;
    public static final int VIDEO_ONLY_FIELD_NUMBER = 3;
    public static final int WEBHOOKS_FIELD_NUMBER = 14;
    private boolean audioOnly_;
    private boolean awaitStartSignal_;
    private Object options_;
    private Object output_;
    private boolean videoOnly_;
    private int outputCase_ = 0;
    private int optionsCase_ = 0;
    private String url_ = "";
    private B.j fileOutputs_ = GeneratedMessageLite.emptyProtobufList();
    private B.j streamOutputs_ = GeneratedMessageLite.emptyProtobufList();
    private B.j segmentOutputs_ = GeneratedMessageLite.emptyProtobufList();
    private B.j imageOutputs_ = GeneratedMessageLite.emptyProtobufList();
    private B.j webhooks_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(f fVar) {
            this();
        }

        private a() {
            super(LivekitEgress$WebEgressRequest.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        PRESET(7),
        ADVANCED(8),
        OPTIONS_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return OPTIONS_NOT_SET;
            }
            if (i == 7) {
                return PRESET;
            }
            if (i != 8) {
                return null;
            }
            return ADVANCED;
        }
    }

    public enum c {
        FILE(4),
        STREAM(5),
        SEGMENTS(6),
        OUTPUT_NOT_SET(0);

        private final int a;

        c(int i) {
            this.a = i;
        }

        public static c j(int i) {
            if (i == 0) {
                return OUTPUT_NOT_SET;
            }
            if (i == 4) {
                return FILE;
            }
            if (i == 5) {
                return STREAM;
            }
            if (i != 6) {
                return null;
            }
            return SEGMENTS;
        }
    }

    static {
        LivekitEgress$WebEgressRequest livekitEgress$WebEgressRequest = new LivekitEgress$WebEgressRequest();
        DEFAULT_INSTANCE = livekitEgress$WebEgressRequest;
        GeneratedMessageLite.registerDefaultInstance(LivekitEgress$WebEgressRequest.class, livekitEgress$WebEgressRequest);
    }

    private LivekitEgress$WebEgressRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllFileOutputs(Iterable<? extends LivekitEgress$EncodedFileOutput> iterable) {
        ensureFileOutputsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.fileOutputs_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllImageOutputs(Iterable<? extends LivekitEgress$ImageOutput> iterable) {
        ensureImageOutputsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.imageOutputs_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllSegmentOutputs(Iterable<? extends LivekitEgress$SegmentedFileOutput> iterable) {
        ensureSegmentOutputsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.segmentOutputs_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllStreamOutputs(Iterable<? extends LivekitEgress$StreamOutput> iterable) {
        ensureStreamOutputsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.streamOutputs_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllWebhooks(Iterable<? extends LivekitModels$WebhookConfig> iterable) {
        ensureWebhooksIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.webhooks_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFileOutputs(LivekitEgress$EncodedFileOutput livekitEgress$EncodedFileOutput) {
        livekitEgress$EncodedFileOutput.getClass();
        ensureFileOutputsIsMutable();
        this.fileOutputs_.add(livekitEgress$EncodedFileOutput);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addImageOutputs(LivekitEgress$ImageOutput livekitEgress$ImageOutput) {
        livekitEgress$ImageOutput.getClass();
        ensureImageOutputsIsMutable();
        this.imageOutputs_.add(livekitEgress$ImageOutput);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSegmentOutputs(LivekitEgress$SegmentedFileOutput livekitEgress$SegmentedFileOutput) {
        livekitEgress$SegmentedFileOutput.getClass();
        ensureSegmentOutputsIsMutable();
        this.segmentOutputs_.add(livekitEgress$SegmentedFileOutput);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addStreamOutputs(LivekitEgress$StreamOutput livekitEgress$StreamOutput) {
        livekitEgress$StreamOutput.getClass();
        ensureStreamOutputsIsMutable();
        this.streamOutputs_.add(livekitEgress$StreamOutput);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addWebhooks(LivekitModels$WebhookConfig livekitModels$WebhookConfig) {
        livekitModels$WebhookConfig.getClass();
        ensureWebhooksIsMutable();
        this.webhooks_.add(livekitModels$WebhookConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAdvanced() {
        if (this.optionsCase_ == 8) {
            this.optionsCase_ = 0;
            this.options_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAudioOnly() {
        this.audioOnly_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAwaitStartSignal() {
        this.awaitStartSignal_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFile() {
        if (this.outputCase_ == 4) {
            this.outputCase_ = 0;
            this.output_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFileOutputs() {
        this.fileOutputs_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearImageOutputs() {
        this.imageOutputs_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOptions() {
        this.optionsCase_ = 0;
        this.options_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOutput() {
        this.outputCase_ = 0;
        this.output_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPreset() {
        if (this.optionsCase_ == 7) {
            this.optionsCase_ = 0;
            this.options_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSegmentOutputs() {
        this.segmentOutputs_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSegments() {
        if (this.outputCase_ == 6) {
            this.outputCase_ = 0;
            this.output_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStream() {
        if (this.outputCase_ == 5) {
            this.outputCase_ = 0;
            this.output_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStreamOutputs() {
        this.streamOutputs_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUrl() {
        this.url_ = getDefaultInstance().getUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVideoOnly() {
        this.videoOnly_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearWebhooks() {
        this.webhooks_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureFileOutputsIsMutable() {
        B.j jVar = this.fileOutputs_;
        if (jVar.u()) {
            return;
        }
        this.fileOutputs_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureImageOutputsIsMutable() {
        B.j jVar = this.imageOutputs_;
        if (jVar.u()) {
            return;
        }
        this.imageOutputs_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureSegmentOutputsIsMutable() {
        B.j jVar = this.segmentOutputs_;
        if (jVar.u()) {
            return;
        }
        this.segmentOutputs_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureStreamOutputsIsMutable() {
        B.j jVar = this.streamOutputs_;
        if (jVar.u()) {
            return;
        }
        this.streamOutputs_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureWebhooksIsMutable() {
        B.j jVar = this.webhooks_;
        if (jVar.u()) {
            return;
        }
        this.webhooks_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitEgress$WebEgressRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeAdvanced(LivekitEgress$EncodingOptions livekitEgress$EncodingOptions) {
        livekitEgress$EncodingOptions.getClass();
        if (this.optionsCase_ != 8 || this.options_ == LivekitEgress$EncodingOptions.getDefaultInstance()) {
            this.options_ = livekitEgress$EncodingOptions;
        } else {
            this.options_ = ((LivekitEgress$EncodingOptions.a) LivekitEgress$EncodingOptions.newBuilder((LivekitEgress$EncodingOptions) this.options_).v(livekitEgress$EncodingOptions)).j();
        }
        this.optionsCase_ = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeFile(LivekitEgress$EncodedFileOutput livekitEgress$EncodedFileOutput) {
        livekitEgress$EncodedFileOutput.getClass();
        if (this.outputCase_ != 4 || this.output_ == LivekitEgress$EncodedFileOutput.getDefaultInstance()) {
            this.output_ = livekitEgress$EncodedFileOutput;
        } else {
            this.output_ = ((LivekitEgress$EncodedFileOutput.a) LivekitEgress$EncodedFileOutput.newBuilder((LivekitEgress$EncodedFileOutput) this.output_).v(livekitEgress$EncodedFileOutput)).j();
        }
        this.outputCase_ = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeSegments(LivekitEgress$SegmentedFileOutput livekitEgress$SegmentedFileOutput) {
        livekitEgress$SegmentedFileOutput.getClass();
        if (this.outputCase_ != 6 || this.output_ == LivekitEgress$SegmentedFileOutput.getDefaultInstance()) {
            this.output_ = livekitEgress$SegmentedFileOutput;
        } else {
            this.output_ = ((LivekitEgress$SegmentedFileOutput.a) LivekitEgress$SegmentedFileOutput.newBuilder((LivekitEgress$SegmentedFileOutput) this.output_).v(livekitEgress$SegmentedFileOutput)).j();
        }
        this.outputCase_ = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeStream(LivekitEgress$StreamOutput livekitEgress$StreamOutput) {
        livekitEgress$StreamOutput.getClass();
        if (this.outputCase_ != 5 || this.output_ == LivekitEgress$StreamOutput.getDefaultInstance()) {
            this.output_ = livekitEgress$StreamOutput;
        } else {
            this.output_ = ((LivekitEgress$StreamOutput.a) LivekitEgress$StreamOutput.newBuilder((LivekitEgress$StreamOutput) this.output_).v(livekitEgress$StreamOutput)).j();
        }
        this.outputCase_ = 5;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitEgress$WebEgressRequest parseDelimitedFrom(InputStream inputStream) {
        return (LivekitEgress$WebEgressRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitEgress$WebEgressRequest parseFrom(ByteBuffer byteBuffer) {
        return (LivekitEgress$WebEgressRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeFileOutputs(int i) {
        ensureFileOutputsIsMutable();
        this.fileOutputs_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeImageOutputs(int i) {
        ensureImageOutputsIsMutable();
        this.imageOutputs_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeSegmentOutputs(int i) {
        ensureSegmentOutputsIsMutable();
        this.segmentOutputs_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeStreamOutputs(int i) {
        ensureStreamOutputsIsMutable();
        this.streamOutputs_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeWebhooks(int i) {
        ensureWebhooksIsMutable();
        this.webhooks_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdvanced(LivekitEgress$EncodingOptions livekitEgress$EncodingOptions) {
        livekitEgress$EncodingOptions.getClass();
        this.options_ = livekitEgress$EncodingOptions;
        this.optionsCase_ = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAudioOnly(boolean z) {
        this.audioOnly_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAwaitStartSignal(boolean z) {
        this.awaitStartSignal_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFile(LivekitEgress$EncodedFileOutput livekitEgress$EncodedFileOutput) {
        livekitEgress$EncodedFileOutput.getClass();
        this.output_ = livekitEgress$EncodedFileOutput;
        this.outputCase_ = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFileOutputs(int i, LivekitEgress$EncodedFileOutput livekitEgress$EncodedFileOutput) {
        livekitEgress$EncodedFileOutput.getClass();
        ensureFileOutputsIsMutable();
        this.fileOutputs_.set(i, livekitEgress$EncodedFileOutput);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImageOutputs(int i, LivekitEgress$ImageOutput livekitEgress$ImageOutput) {
        livekitEgress$ImageOutput.getClass();
        ensureImageOutputsIsMutable();
        this.imageOutputs_.set(i, livekitEgress$ImageOutput);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPreset(EnumC19370qE3 enumC19370qE3) {
        this.options_ = Integer.valueOf(enumC19370qE3.getNumber());
        this.optionsCase_ = 7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPresetValue(int i) {
        this.optionsCase_ = 7;
        this.options_ = Integer.valueOf(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSegmentOutputs(int i, LivekitEgress$SegmentedFileOutput livekitEgress$SegmentedFileOutput) {
        livekitEgress$SegmentedFileOutput.getClass();
        ensureSegmentOutputsIsMutable();
        this.segmentOutputs_.set(i, livekitEgress$SegmentedFileOutput);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSegments(LivekitEgress$SegmentedFileOutput livekitEgress$SegmentedFileOutput) {
        livekitEgress$SegmentedFileOutput.getClass();
        this.output_ = livekitEgress$SegmentedFileOutput;
        this.outputCase_ = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStream(LivekitEgress$StreamOutput livekitEgress$StreamOutput) {
        livekitEgress$StreamOutput.getClass();
        this.output_ = livekitEgress$StreamOutput;
        this.outputCase_ = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStreamOutputs(int i, LivekitEgress$StreamOutput livekitEgress$StreamOutput) {
        livekitEgress$StreamOutput.getClass();
        ensureStreamOutputsIsMutable();
        this.streamOutputs_.set(i, livekitEgress$StreamOutput);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUrl(String str) {
        str.getClass();
        this.url_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUrlBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.url_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoOnly(boolean z) {
        this.videoOnly_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWebhooks(int i, LivekitModels$WebhookConfig livekitModels$WebhookConfig) {
        livekitModels$WebhookConfig.getClass();
        ensureWebhooksIsMutable();
        this.webhooks_.set(i, livekitModels$WebhookConfig);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        f fVar = null;
        switch (f.a[gVar.ordinal()]) {
            case 1:
                return new LivekitEgress$WebEgressRequest();
            case 2:
                return new a(fVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u000e\u0002\u0000\u0001\u000e\u000e\u0000\u0005\u0000\u0001Ȉ\u0002\u0007\u0003\u0007\u0004<\u0000\u0005<\u0000\u0006<\u0000\u0007?\u0001\b<\u0001\t\u001b\n\u001b\u000b\u001b\f\u0007\r\u001b\u000e\u001b", new Object[]{"output_", "outputCase_", "options_", "optionsCase_", "url_", "audioOnly_", "videoOnly_", LivekitEgress$EncodedFileOutput.class, LivekitEgress$StreamOutput.class, LivekitEgress$SegmentedFileOutput.class, LivekitEgress$EncodingOptions.class, "fileOutputs_", LivekitEgress$EncodedFileOutput.class, "streamOutputs_", LivekitEgress$StreamOutput.class, "segmentOutputs_", LivekitEgress$SegmentedFileOutput.class, "awaitStartSignal_", "imageOutputs_", LivekitEgress$ImageOutput.class, "webhooks_", LivekitModels$WebhookConfig.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitEgress$WebEgressRequest.class) {
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

    public LivekitEgress$EncodingOptions getAdvanced() {
        return this.optionsCase_ == 8 ? (LivekitEgress$EncodingOptions) this.options_ : LivekitEgress$EncodingOptions.getDefaultInstance();
    }

    public boolean getAudioOnly() {
        return this.audioOnly_;
    }

    public boolean getAwaitStartSignal() {
        return this.awaitStartSignal_;
    }

    @Deprecated
    public LivekitEgress$EncodedFileOutput getFile() {
        return this.outputCase_ == 4 ? (LivekitEgress$EncodedFileOutput) this.output_ : LivekitEgress$EncodedFileOutput.getDefaultInstance();
    }

    public LivekitEgress$EncodedFileOutput getFileOutputs(int i) {
        return (LivekitEgress$EncodedFileOutput) this.fileOutputs_.get(i);
    }

    public int getFileOutputsCount() {
        return this.fileOutputs_.size();
    }

    public List<LivekitEgress$EncodedFileOutput> getFileOutputsList() {
        return this.fileOutputs_;
    }

    public h getFileOutputsOrBuilder(int i) {
        return (h) this.fileOutputs_.get(i);
    }

    public List<? extends h> getFileOutputsOrBuilderList() {
        return this.fileOutputs_;
    }

    public LivekitEgress$ImageOutput getImageOutputs(int i) {
        return (LivekitEgress$ImageOutput) this.imageOutputs_.get(i);
    }

    public int getImageOutputsCount() {
        return this.imageOutputs_.size();
    }

    public List<LivekitEgress$ImageOutput> getImageOutputsList() {
        return this.imageOutputs_;
    }

    public i getImageOutputsOrBuilder(int i) {
        return (i) this.imageOutputs_.get(i);
    }

    public List<? extends i> getImageOutputsOrBuilderList() {
        return this.imageOutputs_;
    }

    public b getOptionsCase() {
        return b.j(this.optionsCase_);
    }

    public c getOutputCase() {
        return c.j(this.outputCase_);
    }

    public EnumC19370qE3 getPreset() {
        if (this.optionsCase_ != 7) {
            return EnumC19370qE3.H264_720P_30;
        }
        EnumC19370qE3 enumC19370qE3J = EnumC19370qE3.j(((Integer) this.options_).intValue());
        return enumC19370qE3J == null ? EnumC19370qE3.UNRECOGNIZED : enumC19370qE3J;
    }

    public int getPresetValue() {
        if (this.optionsCase_ == 7) {
            return ((Integer) this.options_).intValue();
        }
        return 0;
    }

    public LivekitEgress$SegmentedFileOutput getSegmentOutputs(int i) {
        return (LivekitEgress$SegmentedFileOutput) this.segmentOutputs_.get(i);
    }

    public int getSegmentOutputsCount() {
        return this.segmentOutputs_.size();
    }

    public List<LivekitEgress$SegmentedFileOutput> getSegmentOutputsList() {
        return this.segmentOutputs_;
    }

    public j getSegmentOutputsOrBuilder(int i) {
        return (j) this.segmentOutputs_.get(i);
    }

    public List<? extends j> getSegmentOutputsOrBuilderList() {
        return this.segmentOutputs_;
    }

    @Deprecated
    public LivekitEgress$SegmentedFileOutput getSegments() {
        return this.outputCase_ == 6 ? (LivekitEgress$SegmentedFileOutput) this.output_ : LivekitEgress$SegmentedFileOutput.getDefaultInstance();
    }

    @Deprecated
    public LivekitEgress$StreamOutput getStream() {
        return this.outputCase_ == 5 ? (LivekitEgress$StreamOutput) this.output_ : LivekitEgress$StreamOutput.getDefaultInstance();
    }

    public LivekitEgress$StreamOutput getStreamOutputs(int i) {
        return (LivekitEgress$StreamOutput) this.streamOutputs_.get(i);
    }

    public int getStreamOutputsCount() {
        return this.streamOutputs_.size();
    }

    public List<LivekitEgress$StreamOutput> getStreamOutputsList() {
        return this.streamOutputs_;
    }

    public InterfaceC23623xE3 getStreamOutputsOrBuilder(int i) {
        return (InterfaceC23623xE3) this.streamOutputs_.get(i);
    }

    public List<? extends InterfaceC23623xE3> getStreamOutputsOrBuilderList() {
        return this.streamOutputs_;
    }

    public String getUrl() {
        return this.url_;
    }

    public AbstractC2383g getUrlBytes() {
        return AbstractC2383g.N(this.url_);
    }

    public boolean getVideoOnly() {
        return this.videoOnly_;
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

    public boolean hasAdvanced() {
        return this.optionsCase_ == 8;
    }

    @Deprecated
    public boolean hasFile() {
        return this.outputCase_ == 4;
    }

    public boolean hasPreset() {
        return this.optionsCase_ == 7;
    }

    @Deprecated
    public boolean hasSegments() {
        return this.outputCase_ == 6;
    }

    @Deprecated
    public boolean hasStream() {
        return this.outputCase_ == 5;
    }

    public static a newBuilder(LivekitEgress$WebEgressRequest livekitEgress$WebEgressRequest) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitEgress$WebEgressRequest);
    }

    public static LivekitEgress$WebEgressRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitEgress$WebEgressRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitEgress$WebEgressRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitEgress$WebEgressRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitEgress$WebEgressRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitEgress$WebEgressRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFileOutputs(int i, LivekitEgress$EncodedFileOutput livekitEgress$EncodedFileOutput) {
        livekitEgress$EncodedFileOutput.getClass();
        ensureFileOutputsIsMutable();
        this.fileOutputs_.add(i, livekitEgress$EncodedFileOutput);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addImageOutputs(int i, LivekitEgress$ImageOutput livekitEgress$ImageOutput) {
        livekitEgress$ImageOutput.getClass();
        ensureImageOutputsIsMutable();
        this.imageOutputs_.add(i, livekitEgress$ImageOutput);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSegmentOutputs(int i, LivekitEgress$SegmentedFileOutput livekitEgress$SegmentedFileOutput) {
        livekitEgress$SegmentedFileOutput.getClass();
        ensureSegmentOutputsIsMutable();
        this.segmentOutputs_.add(i, livekitEgress$SegmentedFileOutput);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addStreamOutputs(int i, LivekitEgress$StreamOutput livekitEgress$StreamOutput) {
        livekitEgress$StreamOutput.getClass();
        ensureStreamOutputsIsMutable();
        this.streamOutputs_.add(i, livekitEgress$StreamOutput);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addWebhooks(int i, LivekitModels$WebhookConfig livekitModels$WebhookConfig) {
        livekitModels$WebhookConfig.getClass();
        ensureWebhooksIsMutable();
        this.webhooks_.add(i, livekitModels$WebhookConfig);
    }

    public static LivekitEgress$WebEgressRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitEgress$WebEgressRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitEgress$WebEgressRequest parseFrom(byte[] bArr) {
        return (LivekitEgress$WebEgressRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitEgress$WebEgressRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitEgress$WebEgressRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitEgress$WebEgressRequest parseFrom(InputStream inputStream) {
        return (LivekitEgress$WebEgressRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitEgress$WebEgressRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitEgress$WebEgressRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitEgress$WebEgressRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitEgress$WebEgressRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitEgress$WebEgressRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitEgress$WebEgressRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
