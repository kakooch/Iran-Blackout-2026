package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC20570sE3;
import ir.nasim.KW4;
import ir.nasim.SE3;
import java.io.InputStream;
import java.nio.ByteBuffer;
import livekit.LivekitEgress$AliOSSUpload;
import livekit.LivekitEgress$AzureBlobUpload;
import livekit.LivekitEgress$GCPUpload;
import livekit.LivekitEgress$S3Upload;

/* loaded from: classes8.dex */
public final class LivekitEgress$ImageOutput extends GeneratedMessageLite implements i {
    public static final int ALIOSS_FIELD_NUMBER = 11;
    public static final int AZURE_FIELD_NUMBER = 10;
    public static final int CAPTURE_INTERVAL_FIELD_NUMBER = 1;
    private static final LivekitEgress$ImageOutput DEFAULT_INSTANCE;
    public static final int DISABLE_MANIFEST_FIELD_NUMBER = 7;
    public static final int FILENAME_PREFIX_FIELD_NUMBER = 4;
    public static final int FILENAME_SUFFIX_FIELD_NUMBER = 5;
    public static final int GCP_FIELD_NUMBER = 9;
    public static final int HEIGHT_FIELD_NUMBER = 3;
    public static final int IMAGE_CODEC_FIELD_NUMBER = 6;
    private static volatile KW4 PARSER = null;
    public static final int S3_FIELD_NUMBER = 8;
    public static final int WIDTH_FIELD_NUMBER = 2;
    private int captureInterval_;
    private boolean disableManifest_;
    private int filenameSuffix_;
    private int height_;
    private int imageCodec_;
    private Object output_;
    private int width_;
    private int outputCase_ = 0;
    private String filenamePrefix_ = "";

    public static final class a extends GeneratedMessageLite.b implements i {
        /* synthetic */ a(f fVar) {
            this();
        }

        private a() {
            super(LivekitEgress$ImageOutput.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        S3(8),
        GCP(9),
        AZURE(10),
        ALIOSS(11),
        OUTPUT_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return OUTPUT_NOT_SET;
            }
            switch (i) {
                case 8:
                    return S3;
                case 9:
                    return GCP;
                case 10:
                    return AZURE;
                case 11:
                    return ALIOSS;
                default:
                    return null;
            }
        }
    }

    static {
        LivekitEgress$ImageOutput livekitEgress$ImageOutput = new LivekitEgress$ImageOutput();
        DEFAULT_INSTANCE = livekitEgress$ImageOutput;
        GeneratedMessageLite.registerDefaultInstance(LivekitEgress$ImageOutput.class, livekitEgress$ImageOutput);
    }

    private LivekitEgress$ImageOutput() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAliOSS() {
        if (this.outputCase_ == 11) {
            this.outputCase_ = 0;
            this.output_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAzure() {
        if (this.outputCase_ == 10) {
            this.outputCase_ = 0;
            this.output_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCaptureInterval() {
        this.captureInterval_ = 0;
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
        if (this.outputCase_ == 9) {
            this.outputCase_ = 0;
            this.output_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHeight() {
        this.height_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearImageCodec() {
        this.imageCodec_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOutput() {
        this.outputCase_ = 0;
        this.output_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearS3() {
        if (this.outputCase_ == 8) {
            this.outputCase_ = 0;
            this.output_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearWidth() {
        this.width_ = 0;
    }

    public static LivekitEgress$ImageOutput getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeAliOSS(LivekitEgress$AliOSSUpload livekitEgress$AliOSSUpload) {
        livekitEgress$AliOSSUpload.getClass();
        if (this.outputCase_ != 11 || this.output_ == LivekitEgress$AliOSSUpload.getDefaultInstance()) {
            this.output_ = livekitEgress$AliOSSUpload;
        } else {
            this.output_ = ((LivekitEgress$AliOSSUpload.a) LivekitEgress$AliOSSUpload.newBuilder((LivekitEgress$AliOSSUpload) this.output_).v(livekitEgress$AliOSSUpload)).j();
        }
        this.outputCase_ = 11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeAzure(LivekitEgress$AzureBlobUpload livekitEgress$AzureBlobUpload) {
        livekitEgress$AzureBlobUpload.getClass();
        if (this.outputCase_ != 10 || this.output_ == LivekitEgress$AzureBlobUpload.getDefaultInstance()) {
            this.output_ = livekitEgress$AzureBlobUpload;
        } else {
            this.output_ = ((LivekitEgress$AzureBlobUpload.a) LivekitEgress$AzureBlobUpload.newBuilder((LivekitEgress$AzureBlobUpload) this.output_).v(livekitEgress$AzureBlobUpload)).j();
        }
        this.outputCase_ = 10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeGcp(LivekitEgress$GCPUpload livekitEgress$GCPUpload) {
        livekitEgress$GCPUpload.getClass();
        if (this.outputCase_ != 9 || this.output_ == LivekitEgress$GCPUpload.getDefaultInstance()) {
            this.output_ = livekitEgress$GCPUpload;
        } else {
            this.output_ = ((LivekitEgress$GCPUpload.a) LivekitEgress$GCPUpload.newBuilder((LivekitEgress$GCPUpload) this.output_).v(livekitEgress$GCPUpload)).j();
        }
        this.outputCase_ = 9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeS3(LivekitEgress$S3Upload livekitEgress$S3Upload) {
        livekitEgress$S3Upload.getClass();
        if (this.outputCase_ != 8 || this.output_ == LivekitEgress$S3Upload.getDefaultInstance()) {
            this.output_ = livekitEgress$S3Upload;
        } else {
            this.output_ = ((LivekitEgress$S3Upload.a) LivekitEgress$S3Upload.newBuilder((LivekitEgress$S3Upload) this.output_).v(livekitEgress$S3Upload)).j();
        }
        this.outputCase_ = 8;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitEgress$ImageOutput parseDelimitedFrom(InputStream inputStream) {
        return (LivekitEgress$ImageOutput) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitEgress$ImageOutput parseFrom(ByteBuffer byteBuffer) {
        return (LivekitEgress$ImageOutput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAliOSS(LivekitEgress$AliOSSUpload livekitEgress$AliOSSUpload) {
        livekitEgress$AliOSSUpload.getClass();
        this.output_ = livekitEgress$AliOSSUpload;
        this.outputCase_ = 11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAzure(LivekitEgress$AzureBlobUpload livekitEgress$AzureBlobUpload) {
        livekitEgress$AzureBlobUpload.getClass();
        this.output_ = livekitEgress$AzureBlobUpload;
        this.outputCase_ = 10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCaptureInterval(int i) {
        this.captureInterval_ = i;
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
    public void setFilenameSuffix(EnumC20570sE3 enumC20570sE3) {
        this.filenameSuffix_ = enumC20570sE3.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFilenameSuffixValue(int i) {
        this.filenameSuffix_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGcp(LivekitEgress$GCPUpload livekitEgress$GCPUpload) {
        livekitEgress$GCPUpload.getClass();
        this.output_ = livekitEgress$GCPUpload;
        this.outputCase_ = 9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeight(int i) {
        this.height_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImageCodec(SE3 se3) {
        this.imageCodec_ = se3.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImageCodecValue(int i) {
        this.imageCodec_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setS3(LivekitEgress$S3Upload livekitEgress$S3Upload) {
        livekitEgress$S3Upload.getClass();
        this.output_ = livekitEgress$S3Upload;
        this.outputCase_ = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWidth(int i) {
        this.width_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        f fVar = null;
        switch (f.a[gVar.ordinal()]) {
            case 1:
                return new LivekitEgress$ImageOutput();
            case 2:
                return new a(fVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u000b\u0001\u0000\u0001\u000b\u000b\u0000\u0000\u0000\u0001\u000b\u0002\u0004\u0003\u0004\u0004Ȉ\u0005\f\u0006\f\u0007\u0007\b<\u0000\t<\u0000\n<\u0000\u000b<\u0000", new Object[]{"output_", "outputCase_", "captureInterval_", "width_", "height_", "filenamePrefix_", "filenameSuffix_", "imageCodec_", "disableManifest_", LivekitEgress$S3Upload.class, LivekitEgress$GCPUpload.class, LivekitEgress$AzureBlobUpload.class, LivekitEgress$AliOSSUpload.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitEgress$ImageOutput.class) {
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
        return this.outputCase_ == 11 ? (LivekitEgress$AliOSSUpload) this.output_ : LivekitEgress$AliOSSUpload.getDefaultInstance();
    }

    public LivekitEgress$AzureBlobUpload getAzure() {
        return this.outputCase_ == 10 ? (LivekitEgress$AzureBlobUpload) this.output_ : LivekitEgress$AzureBlobUpload.getDefaultInstance();
    }

    public int getCaptureInterval() {
        return this.captureInterval_;
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

    public EnumC20570sE3 getFilenameSuffix() {
        EnumC20570sE3 enumC20570sE3J = EnumC20570sE3.j(this.filenameSuffix_);
        return enumC20570sE3J == null ? EnumC20570sE3.UNRECOGNIZED : enumC20570sE3J;
    }

    public int getFilenameSuffixValue() {
        return this.filenameSuffix_;
    }

    public LivekitEgress$GCPUpload getGcp() {
        return this.outputCase_ == 9 ? (LivekitEgress$GCPUpload) this.output_ : LivekitEgress$GCPUpload.getDefaultInstance();
    }

    public int getHeight() {
        return this.height_;
    }

    public SE3 getImageCodec() {
        SE3 se3J = SE3.j(this.imageCodec_);
        return se3J == null ? SE3.UNRECOGNIZED : se3J;
    }

    public int getImageCodecValue() {
        return this.imageCodec_;
    }

    public b getOutputCase() {
        return b.j(this.outputCase_);
    }

    public LivekitEgress$S3Upload getS3() {
        return this.outputCase_ == 8 ? (LivekitEgress$S3Upload) this.output_ : LivekitEgress$S3Upload.getDefaultInstance();
    }

    public int getWidth() {
        return this.width_;
    }

    public boolean hasAliOSS() {
        return this.outputCase_ == 11;
    }

    public boolean hasAzure() {
        return this.outputCase_ == 10;
    }

    public boolean hasGcp() {
        return this.outputCase_ == 9;
    }

    public boolean hasS3() {
        return this.outputCase_ == 8;
    }

    public static a newBuilder(LivekitEgress$ImageOutput livekitEgress$ImageOutput) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitEgress$ImageOutput);
    }

    public static LivekitEgress$ImageOutput parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitEgress$ImageOutput) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitEgress$ImageOutput parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitEgress$ImageOutput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitEgress$ImageOutput parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitEgress$ImageOutput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitEgress$ImageOutput parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitEgress$ImageOutput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitEgress$ImageOutput parseFrom(byte[] bArr) {
        return (LivekitEgress$ImageOutput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitEgress$ImageOutput parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitEgress$ImageOutput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitEgress$ImageOutput parseFrom(InputStream inputStream) {
        return (LivekitEgress$ImageOutput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitEgress$ImageOutput parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitEgress$ImageOutput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitEgress$ImageOutput parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitEgress$ImageOutput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitEgress$ImageOutput parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitEgress$ImageOutput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
