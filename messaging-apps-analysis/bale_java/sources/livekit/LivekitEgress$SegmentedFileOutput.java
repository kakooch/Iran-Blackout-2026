package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC21847uE3;
import ir.nasim.EnumC22437vE3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import livekit.LivekitEgress$AliOSSUpload;
import livekit.LivekitEgress$AzureBlobUpload;
import livekit.LivekitEgress$GCPUpload;
import livekit.LivekitEgress$S3Upload;

/* loaded from: classes8.dex */
public final class LivekitEgress$SegmentedFileOutput extends GeneratedMessageLite implements j {
    public static final int ALIOSS_FIELD_NUMBER = 9;
    public static final int AZURE_FIELD_NUMBER = 7;
    private static final LivekitEgress$SegmentedFileOutput DEFAULT_INSTANCE;
    public static final int DISABLE_MANIFEST_FIELD_NUMBER = 8;
    public static final int FILENAME_PREFIX_FIELD_NUMBER = 2;
    public static final int FILENAME_SUFFIX_FIELD_NUMBER = 10;
    public static final int GCP_FIELD_NUMBER = 6;
    public static final int LIVE_PLAYLIST_NAME_FIELD_NUMBER = 11;
    private static volatile KW4 PARSER = null;
    public static final int PLAYLIST_NAME_FIELD_NUMBER = 3;
    public static final int PROTOCOL_FIELD_NUMBER = 1;
    public static final int S3_FIELD_NUMBER = 5;
    public static final int SEGMENT_DURATION_FIELD_NUMBER = 4;
    private boolean disableManifest_;
    private int filenameSuffix_;
    private Object output_;
    private int protocol_;
    private int segmentDuration_;
    private int outputCase_ = 0;
    private String filenamePrefix_ = "";
    private String playlistName_ = "";
    private String livePlaylistName_ = "";

    public static final class a extends GeneratedMessageLite.b implements j {
        /* synthetic */ a(f fVar) {
            this();
        }

        private a() {
            super(LivekitEgress$SegmentedFileOutput.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        S3(5),
        GCP(6),
        AZURE(7),
        ALIOSS(9),
        OUTPUT_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return OUTPUT_NOT_SET;
            }
            if (i == 9) {
                return ALIOSS;
            }
            if (i == 5) {
                return S3;
            }
            if (i == 6) {
                return GCP;
            }
            if (i != 7) {
                return null;
            }
            return AZURE;
        }
    }

    static {
        LivekitEgress$SegmentedFileOutput livekitEgress$SegmentedFileOutput = new LivekitEgress$SegmentedFileOutput();
        DEFAULT_INSTANCE = livekitEgress$SegmentedFileOutput;
        GeneratedMessageLite.registerDefaultInstance(LivekitEgress$SegmentedFileOutput.class, livekitEgress$SegmentedFileOutput);
    }

    private LivekitEgress$SegmentedFileOutput() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAliOSS() {
        if (this.outputCase_ == 9) {
            this.outputCase_ = 0;
            this.output_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAzure() {
        if (this.outputCase_ == 7) {
            this.outputCase_ = 0;
            this.output_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDisableManifest() {
        this.disableManifest_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFilenamePrefix() {
        this.filenamePrefix_ = getDefaultInstance().getFilenamePrefix();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFilenameSuffix() {
        this.filenameSuffix_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearGcp() {
        if (this.outputCase_ == 6) {
            this.outputCase_ = 0;
            this.output_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLivePlaylistName() {
        this.livePlaylistName_ = getDefaultInstance().getLivePlaylistName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOutput() {
        this.outputCase_ = 0;
        this.output_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPlaylistName() {
        this.playlistName_ = getDefaultInstance().getPlaylistName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearProtocol() {
        this.protocol_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearS3() {
        if (this.outputCase_ == 5) {
            this.outputCase_ = 0;
            this.output_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSegmentDuration() {
        this.segmentDuration_ = 0;
    }

    public static LivekitEgress$SegmentedFileOutput getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeAliOSS(LivekitEgress$AliOSSUpload livekitEgress$AliOSSUpload) {
        livekitEgress$AliOSSUpload.getClass();
        if (this.outputCase_ != 9 || this.output_ == LivekitEgress$AliOSSUpload.getDefaultInstance()) {
            this.output_ = livekitEgress$AliOSSUpload;
        } else {
            this.output_ = ((LivekitEgress$AliOSSUpload.a) LivekitEgress$AliOSSUpload.newBuilder((LivekitEgress$AliOSSUpload) this.output_).v(livekitEgress$AliOSSUpload)).j();
        }
        this.outputCase_ = 9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeAzure(LivekitEgress$AzureBlobUpload livekitEgress$AzureBlobUpload) {
        livekitEgress$AzureBlobUpload.getClass();
        if (this.outputCase_ != 7 || this.output_ == LivekitEgress$AzureBlobUpload.getDefaultInstance()) {
            this.output_ = livekitEgress$AzureBlobUpload;
        } else {
            this.output_ = ((LivekitEgress$AzureBlobUpload.a) LivekitEgress$AzureBlobUpload.newBuilder((LivekitEgress$AzureBlobUpload) this.output_).v(livekitEgress$AzureBlobUpload)).j();
        }
        this.outputCase_ = 7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeGcp(LivekitEgress$GCPUpload livekitEgress$GCPUpload) {
        livekitEgress$GCPUpload.getClass();
        if (this.outputCase_ != 6 || this.output_ == LivekitEgress$GCPUpload.getDefaultInstance()) {
            this.output_ = livekitEgress$GCPUpload;
        } else {
            this.output_ = ((LivekitEgress$GCPUpload.a) LivekitEgress$GCPUpload.newBuilder((LivekitEgress$GCPUpload) this.output_).v(livekitEgress$GCPUpload)).j();
        }
        this.outputCase_ = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeS3(LivekitEgress$S3Upload livekitEgress$S3Upload) {
        livekitEgress$S3Upload.getClass();
        if (this.outputCase_ != 5 || this.output_ == LivekitEgress$S3Upload.getDefaultInstance()) {
            this.output_ = livekitEgress$S3Upload;
        } else {
            this.output_ = ((LivekitEgress$S3Upload.a) LivekitEgress$S3Upload.newBuilder((LivekitEgress$S3Upload) this.output_).v(livekitEgress$S3Upload)).j();
        }
        this.outputCase_ = 5;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitEgress$SegmentedFileOutput parseDelimitedFrom(InputStream inputStream) {
        return (LivekitEgress$SegmentedFileOutput) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitEgress$SegmentedFileOutput parseFrom(ByteBuffer byteBuffer) {
        return (LivekitEgress$SegmentedFileOutput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAliOSS(LivekitEgress$AliOSSUpload livekitEgress$AliOSSUpload) {
        livekitEgress$AliOSSUpload.getClass();
        this.output_ = livekitEgress$AliOSSUpload;
        this.outputCase_ = 9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAzure(LivekitEgress$AzureBlobUpload livekitEgress$AzureBlobUpload) {
        livekitEgress$AzureBlobUpload.getClass();
        this.output_ = livekitEgress$AzureBlobUpload;
        this.outputCase_ = 7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDisableManifest(boolean z) {
        this.disableManifest_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFilenamePrefix(String str) {
        str.getClass();
        this.filenamePrefix_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFilenamePrefixBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.filenamePrefix_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFilenameSuffix(EnumC22437vE3 enumC22437vE3) {
        this.filenameSuffix_ = enumC22437vE3.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFilenameSuffixValue(int i) {
        this.filenameSuffix_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGcp(LivekitEgress$GCPUpload livekitEgress$GCPUpload) {
        livekitEgress$GCPUpload.getClass();
        this.output_ = livekitEgress$GCPUpload;
        this.outputCase_ = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLivePlaylistName(String str) {
        str.getClass();
        this.livePlaylistName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLivePlaylistNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.livePlaylistName_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlaylistName(String str) {
        str.getClass();
        this.playlistName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlaylistNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.playlistName_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProtocol(EnumC21847uE3 enumC21847uE3) {
        this.protocol_ = enumC21847uE3.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProtocolValue(int i) {
        this.protocol_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setS3(LivekitEgress$S3Upload livekitEgress$S3Upload) {
        livekitEgress$S3Upload.getClass();
        this.output_ = livekitEgress$S3Upload;
        this.outputCase_ = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSegmentDuration(int i) {
        this.segmentDuration_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        f fVar = null;
        switch (f.a[gVar.ordinal()]) {
            case 1:
                return new LivekitEgress$SegmentedFileOutput();
            case 2:
                return new a(fVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u000b\u0001\u0000\u0001\u000b\u000b\u0000\u0000\u0000\u0001\f\u0002Ȉ\u0003Ȉ\u0004\u000b\u0005<\u0000\u0006<\u0000\u0007<\u0000\b\u0007\t<\u0000\n\f\u000bȈ", new Object[]{"output_", "outputCase_", "protocol_", "filenamePrefix_", "playlistName_", "segmentDuration_", LivekitEgress$S3Upload.class, LivekitEgress$GCPUpload.class, LivekitEgress$AzureBlobUpload.class, "disableManifest_", LivekitEgress$AliOSSUpload.class, "filenameSuffix_", "livePlaylistName_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitEgress$SegmentedFileOutput.class) {
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

    public LivekitEgress$AliOSSUpload getAliOSS() {
        return this.outputCase_ == 9 ? (LivekitEgress$AliOSSUpload) this.output_ : LivekitEgress$AliOSSUpload.getDefaultInstance();
    }

    public LivekitEgress$AzureBlobUpload getAzure() {
        return this.outputCase_ == 7 ? (LivekitEgress$AzureBlobUpload) this.output_ : LivekitEgress$AzureBlobUpload.getDefaultInstance();
    }

    public boolean getDisableManifest() {
        return this.disableManifest_;
    }

    public String getFilenamePrefix() {
        return this.filenamePrefix_;
    }

    public AbstractC2383g getFilenamePrefixBytes() {
        return AbstractC2383g.N(this.filenamePrefix_);
    }

    public EnumC22437vE3 getFilenameSuffix() {
        EnumC22437vE3 enumC22437vE3J = EnumC22437vE3.j(this.filenameSuffix_);
        return enumC22437vE3J == null ? EnumC22437vE3.UNRECOGNIZED : enumC22437vE3J;
    }

    public int getFilenameSuffixValue() {
        return this.filenameSuffix_;
    }

    public LivekitEgress$GCPUpload getGcp() {
        return this.outputCase_ == 6 ? (LivekitEgress$GCPUpload) this.output_ : LivekitEgress$GCPUpload.getDefaultInstance();
    }

    public String getLivePlaylistName() {
        return this.livePlaylistName_;
    }

    public AbstractC2383g getLivePlaylistNameBytes() {
        return AbstractC2383g.N(this.livePlaylistName_);
    }

    public b getOutputCase() {
        return b.j(this.outputCase_);
    }

    public String getPlaylistName() {
        return this.playlistName_;
    }

    public AbstractC2383g getPlaylistNameBytes() {
        return AbstractC2383g.N(this.playlistName_);
    }

    public EnumC21847uE3 getProtocol() {
        EnumC21847uE3 enumC21847uE3J = EnumC21847uE3.j(this.protocol_);
        return enumC21847uE3J == null ? EnumC21847uE3.UNRECOGNIZED : enumC21847uE3J;
    }

    public int getProtocolValue() {
        return this.protocol_;
    }

    public LivekitEgress$S3Upload getS3() {
        return this.outputCase_ == 5 ? (LivekitEgress$S3Upload) this.output_ : LivekitEgress$S3Upload.getDefaultInstance();
    }

    public int getSegmentDuration() {
        return this.segmentDuration_;
    }

    public boolean hasAliOSS() {
        return this.outputCase_ == 9;
    }

    public boolean hasAzure() {
        return this.outputCase_ == 7;
    }

    public boolean hasGcp() {
        return this.outputCase_ == 6;
    }

    public boolean hasS3() {
        return this.outputCase_ == 5;
    }

    public static a newBuilder(LivekitEgress$SegmentedFileOutput livekitEgress$SegmentedFileOutput) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitEgress$SegmentedFileOutput);
    }

    public static LivekitEgress$SegmentedFileOutput parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitEgress$SegmentedFileOutput) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitEgress$SegmentedFileOutput parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitEgress$SegmentedFileOutput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitEgress$SegmentedFileOutput parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitEgress$SegmentedFileOutput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitEgress$SegmentedFileOutput parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitEgress$SegmentedFileOutput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitEgress$SegmentedFileOutput parseFrom(byte[] bArr) {
        return (LivekitEgress$SegmentedFileOutput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitEgress$SegmentedFileOutput parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitEgress$SegmentedFileOutput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitEgress$SegmentedFileOutput parseFrom(InputStream inputStream) {
        return (LivekitEgress$SegmentedFileOutput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitEgress$SegmentedFileOutput parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitEgress$SegmentedFileOutput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitEgress$SegmentedFileOutput parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitEgress$SegmentedFileOutput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitEgress$SegmentedFileOutput parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitEgress$SegmentedFileOutput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
