package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC19370qE3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import livekit.LivekitEgress$EncodingOptions;

/* loaded from: classes8.dex */
public final class LivekitEgress$AutoParticipantEgress extends GeneratedMessageLite implements U64 {
    public static final int ADVANCED_FIELD_NUMBER = 2;
    private static final LivekitEgress$AutoParticipantEgress DEFAULT_INSTANCE;
    public static final int FILE_OUTPUTS_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int PRESET_FIELD_NUMBER = 1;
    public static final int SEGMENT_OUTPUTS_FIELD_NUMBER = 4;
    private Object options_;
    private int optionsCase_ = 0;
    private B.j fileOutputs_ = GeneratedMessageLite.emptyProtobufList();
    private B.j segmentOutputs_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(f fVar) {
            this();
        }

        private a() {
            super(LivekitEgress$AutoParticipantEgress.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        PRESET(1),
        ADVANCED(2),
        OPTIONS_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return OPTIONS_NOT_SET;
            }
            if (i == 1) {
                return PRESET;
            }
            if (i != 2) {
                return null;
            }
            return ADVANCED;
        }
    }

    static {
        LivekitEgress$AutoParticipantEgress livekitEgress$AutoParticipantEgress = new LivekitEgress$AutoParticipantEgress();
        DEFAULT_INSTANCE = livekitEgress$AutoParticipantEgress;
        GeneratedMessageLite.registerDefaultInstance(LivekitEgress$AutoParticipantEgress.class, livekitEgress$AutoParticipantEgress);
    }

    private LivekitEgress$AutoParticipantEgress() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllFileOutputs(Iterable<? extends LivekitEgress$EncodedFileOutput> iterable) {
        ensureFileOutputsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.fileOutputs_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllSegmentOutputs(Iterable<? extends LivekitEgress$SegmentedFileOutput> iterable) {
        ensureSegmentOutputsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.segmentOutputs_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFileOutputs(LivekitEgress$EncodedFileOutput livekitEgress$EncodedFileOutput) {
        livekitEgress$EncodedFileOutput.getClass();
        ensureFileOutputsIsMutable();
        this.fileOutputs_.add(livekitEgress$EncodedFileOutput);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSegmentOutputs(LivekitEgress$SegmentedFileOutput livekitEgress$SegmentedFileOutput) {
        livekitEgress$SegmentedFileOutput.getClass();
        ensureSegmentOutputsIsMutable();
        this.segmentOutputs_.add(livekitEgress$SegmentedFileOutput);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAdvanced() {
        if (this.optionsCase_ == 2) {
            this.optionsCase_ = 0;
            this.options_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFileOutputs() {
        this.fileOutputs_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOptions() {
        this.optionsCase_ = 0;
        this.options_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPreset() {
        if (this.optionsCase_ == 1) {
            this.optionsCase_ = 0;
            this.options_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSegmentOutputs() {
        this.segmentOutputs_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureFileOutputsIsMutable() {
        B.j jVar = this.fileOutputs_;
        if (jVar.u()) {
            return;
        }
        this.fileOutputs_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureSegmentOutputsIsMutable() {
        B.j jVar = this.segmentOutputs_;
        if (jVar.u()) {
            return;
        }
        this.segmentOutputs_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitEgress$AutoParticipantEgress getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeAdvanced(LivekitEgress$EncodingOptions livekitEgress$EncodingOptions) {
        livekitEgress$EncodingOptions.getClass();
        if (this.optionsCase_ != 2 || this.options_ == LivekitEgress$EncodingOptions.getDefaultInstance()) {
            this.options_ = livekitEgress$EncodingOptions;
        } else {
            this.options_ = ((LivekitEgress$EncodingOptions.a) LivekitEgress$EncodingOptions.newBuilder((LivekitEgress$EncodingOptions) this.options_).v(livekitEgress$EncodingOptions)).j();
        }
        this.optionsCase_ = 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitEgress$AutoParticipantEgress parseDelimitedFrom(InputStream inputStream) {
        return (LivekitEgress$AutoParticipantEgress) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitEgress$AutoParticipantEgress parseFrom(ByteBuffer byteBuffer) {
        return (LivekitEgress$AutoParticipantEgress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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
    public void removeSegmentOutputs(int i) {
        ensureSegmentOutputsIsMutable();
        this.segmentOutputs_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdvanced(LivekitEgress$EncodingOptions livekitEgress$EncodingOptions) {
        livekitEgress$EncodingOptions.getClass();
        this.options_ = livekitEgress$EncodingOptions;
        this.optionsCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFileOutputs(int i, LivekitEgress$EncodedFileOutput livekitEgress$EncodedFileOutput) {
        livekitEgress$EncodedFileOutput.getClass();
        ensureFileOutputsIsMutable();
        this.fileOutputs_.set(i, livekitEgress$EncodedFileOutput);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPreset(EnumC19370qE3 enumC19370qE3) {
        this.options_ = Integer.valueOf(enumC19370qE3.getNumber());
        this.optionsCase_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPresetValue(int i) {
        this.optionsCase_ = 1;
        this.options_ = Integer.valueOf(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSegmentOutputs(int i, LivekitEgress$SegmentedFileOutput livekitEgress$SegmentedFileOutput) {
        livekitEgress$SegmentedFileOutput.getClass();
        ensureSegmentOutputsIsMutable();
        this.segmentOutputs_.set(i, livekitEgress$SegmentedFileOutput);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        f fVar = null;
        switch (f.a[gVar.ordinal()]) {
            case 1:
                return new LivekitEgress$AutoParticipantEgress();
            case 2:
                return new a(fVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0001\u0000\u0001\u0004\u0004\u0000\u0002\u0000\u0001?\u0000\u0002<\u0000\u0003\u001b\u0004\u001b", new Object[]{"options_", "optionsCase_", LivekitEgress$EncodingOptions.class, "fileOutputs_", LivekitEgress$EncodedFileOutput.class, "segmentOutputs_", LivekitEgress$SegmentedFileOutput.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitEgress$AutoParticipantEgress.class) {
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
        return this.optionsCase_ == 2 ? (LivekitEgress$EncodingOptions) this.options_ : LivekitEgress$EncodingOptions.getDefaultInstance();
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

    public b getOptionsCase() {
        return b.j(this.optionsCase_);
    }

    public EnumC19370qE3 getPreset() {
        if (this.optionsCase_ != 1) {
            return EnumC19370qE3.H264_720P_30;
        }
        EnumC19370qE3 enumC19370qE3J = EnumC19370qE3.j(((Integer) this.options_).intValue());
        return enumC19370qE3J == null ? EnumC19370qE3.UNRECOGNIZED : enumC19370qE3J;
    }

    public int getPresetValue() {
        if (this.optionsCase_ == 1) {
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

    public boolean hasAdvanced() {
        return this.optionsCase_ == 2;
    }

    public boolean hasPreset() {
        return this.optionsCase_ == 1;
    }

    public static a newBuilder(LivekitEgress$AutoParticipantEgress livekitEgress$AutoParticipantEgress) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitEgress$AutoParticipantEgress);
    }

    public static LivekitEgress$AutoParticipantEgress parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitEgress$AutoParticipantEgress) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitEgress$AutoParticipantEgress parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitEgress$AutoParticipantEgress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitEgress$AutoParticipantEgress parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitEgress$AutoParticipantEgress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFileOutputs(int i, LivekitEgress$EncodedFileOutput livekitEgress$EncodedFileOutput) {
        livekitEgress$EncodedFileOutput.getClass();
        ensureFileOutputsIsMutable();
        this.fileOutputs_.add(i, livekitEgress$EncodedFileOutput);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSegmentOutputs(int i, LivekitEgress$SegmentedFileOutput livekitEgress$SegmentedFileOutput) {
        livekitEgress$SegmentedFileOutput.getClass();
        ensureSegmentOutputsIsMutable();
        this.segmentOutputs_.add(i, livekitEgress$SegmentedFileOutput);
    }

    public static LivekitEgress$AutoParticipantEgress parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitEgress$AutoParticipantEgress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitEgress$AutoParticipantEgress parseFrom(byte[] bArr) {
        return (LivekitEgress$AutoParticipantEgress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitEgress$AutoParticipantEgress parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitEgress$AutoParticipantEgress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitEgress$AutoParticipantEgress parseFrom(InputStream inputStream) {
        return (LivekitEgress$AutoParticipantEgress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitEgress$AutoParticipantEgress parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitEgress$AutoParticipantEgress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitEgress$AutoParticipantEgress parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitEgress$AutoParticipantEgress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitEgress$AutoParticipantEgress parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitEgress$AutoParticipantEgress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
