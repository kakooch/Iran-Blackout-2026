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
import livekit.LivekitEgress$AliOSSUpload;
import livekit.LivekitEgress$AzureBlobUpload;
import livekit.LivekitEgress$GCPUpload;
import livekit.LivekitEgress$S3Upload;

/* loaded from: classes8.dex */
public final class LivekitEgress$DirectFileOutput extends GeneratedMessageLite implements U64 {
    public static final int ALIOSS_FIELD_NUMBER = 6;
    public static final int AZURE_FIELD_NUMBER = 4;
    private static final LivekitEgress$DirectFileOutput DEFAULT_INSTANCE;
    public static final int DISABLE_MANIFEST_FIELD_NUMBER = 5;
    public static final int FILEPATH_FIELD_NUMBER = 1;
    public static final int GCP_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int S3_FIELD_NUMBER = 2;
    private boolean disableManifest_;
    private Object output_;
    private int outputCase_ = 0;
    private String filepath_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(f fVar) {
            this();
        }

        private a() {
            super(LivekitEgress$DirectFileOutput.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        S3(2),
        GCP(3),
        AZURE(4),
        ALIOSS(6),
        OUTPUT_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return OUTPUT_NOT_SET;
            }
            if (i == 6) {
                return ALIOSS;
            }
            if (i == 2) {
                return S3;
            }
            if (i == 3) {
                return GCP;
            }
            if (i != 4) {
                return null;
            }
            return AZURE;
        }
    }

    static {
        LivekitEgress$DirectFileOutput livekitEgress$DirectFileOutput = new LivekitEgress$DirectFileOutput();
        DEFAULT_INSTANCE = livekitEgress$DirectFileOutput;
        GeneratedMessageLite.registerDefaultInstance(LivekitEgress$DirectFileOutput.class, livekitEgress$DirectFileOutput);
    }

    private LivekitEgress$DirectFileOutput() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAliOSS() {
        if (this.outputCase_ == 6) {
            this.outputCase_ = 0;
            this.output_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAzure() {
        if (this.outputCase_ == 4) {
            this.outputCase_ = 0;
            this.output_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDisableManifest() {
        this.disableManifest_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFilepath() {
        this.filepath_ = getDefaultInstance().getFilepath();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearGcp() {
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
    public void clearS3() {
        if (this.outputCase_ == 2) {
            this.outputCase_ = 0;
            this.output_ = null;
        }
    }

    public static LivekitEgress$DirectFileOutput getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeAliOSS(LivekitEgress$AliOSSUpload livekitEgress$AliOSSUpload) {
        livekitEgress$AliOSSUpload.getClass();
        if (this.outputCase_ != 6 || this.output_ == LivekitEgress$AliOSSUpload.getDefaultInstance()) {
            this.output_ = livekitEgress$AliOSSUpload;
        } else {
            this.output_ = ((LivekitEgress$AliOSSUpload.a) LivekitEgress$AliOSSUpload.newBuilder((LivekitEgress$AliOSSUpload) this.output_).v(livekitEgress$AliOSSUpload)).j();
        }
        this.outputCase_ = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeAzure(LivekitEgress$AzureBlobUpload livekitEgress$AzureBlobUpload) {
        livekitEgress$AzureBlobUpload.getClass();
        if (this.outputCase_ != 4 || this.output_ == LivekitEgress$AzureBlobUpload.getDefaultInstance()) {
            this.output_ = livekitEgress$AzureBlobUpload;
        } else {
            this.output_ = ((LivekitEgress$AzureBlobUpload.a) LivekitEgress$AzureBlobUpload.newBuilder((LivekitEgress$AzureBlobUpload) this.output_).v(livekitEgress$AzureBlobUpload)).j();
        }
        this.outputCase_ = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeGcp(LivekitEgress$GCPUpload livekitEgress$GCPUpload) {
        livekitEgress$GCPUpload.getClass();
        if (this.outputCase_ != 3 || this.output_ == LivekitEgress$GCPUpload.getDefaultInstance()) {
            this.output_ = livekitEgress$GCPUpload;
        } else {
            this.output_ = ((LivekitEgress$GCPUpload.a) LivekitEgress$GCPUpload.newBuilder((LivekitEgress$GCPUpload) this.output_).v(livekitEgress$GCPUpload)).j();
        }
        this.outputCase_ = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeS3(LivekitEgress$S3Upload livekitEgress$S3Upload) {
        livekitEgress$S3Upload.getClass();
        if (this.outputCase_ != 2 || this.output_ == LivekitEgress$S3Upload.getDefaultInstance()) {
            this.output_ = livekitEgress$S3Upload;
        } else {
            this.output_ = ((LivekitEgress$S3Upload.a) LivekitEgress$S3Upload.newBuilder((LivekitEgress$S3Upload) this.output_).v(livekitEgress$S3Upload)).j();
        }
        this.outputCase_ = 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitEgress$DirectFileOutput parseDelimitedFrom(InputStream inputStream) {
        return (LivekitEgress$DirectFileOutput) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitEgress$DirectFileOutput parseFrom(ByteBuffer byteBuffer) {
        return (LivekitEgress$DirectFileOutput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAliOSS(LivekitEgress$AliOSSUpload livekitEgress$AliOSSUpload) {
        livekitEgress$AliOSSUpload.getClass();
        this.output_ = livekitEgress$AliOSSUpload;
        this.outputCase_ = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAzure(LivekitEgress$AzureBlobUpload livekitEgress$AzureBlobUpload) {
        livekitEgress$AzureBlobUpload.getClass();
        this.output_ = livekitEgress$AzureBlobUpload;
        this.outputCase_ = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDisableManifest(boolean z) {
        this.disableManifest_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFilepath(String str) {
        str.getClass();
        this.filepath_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFilepathBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.filepath_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGcp(LivekitEgress$GCPUpload livekitEgress$GCPUpload) {
        livekitEgress$GCPUpload.getClass();
        this.output_ = livekitEgress$GCPUpload;
        this.outputCase_ = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setS3(LivekitEgress$S3Upload livekitEgress$S3Upload) {
        livekitEgress$S3Upload.getClass();
        this.output_ = livekitEgress$S3Upload;
        this.outputCase_ = 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        f fVar = null;
        switch (f.a[gVar.ordinal()]) {
            case 1:
                return new LivekitEgress$DirectFileOutput();
            case 2:
                return new a(fVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0001\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001Ȉ\u0002<\u0000\u0003<\u0000\u0004<\u0000\u0005\u0007\u0006<\u0000", new Object[]{"output_", "outputCase_", "filepath_", LivekitEgress$S3Upload.class, LivekitEgress$GCPUpload.class, LivekitEgress$AzureBlobUpload.class, "disableManifest_", LivekitEgress$AliOSSUpload.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitEgress$DirectFileOutput.class) {
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
        return this.outputCase_ == 6 ? (LivekitEgress$AliOSSUpload) this.output_ : LivekitEgress$AliOSSUpload.getDefaultInstance();
    }

    public LivekitEgress$AzureBlobUpload getAzure() {
        return this.outputCase_ == 4 ? (LivekitEgress$AzureBlobUpload) this.output_ : LivekitEgress$AzureBlobUpload.getDefaultInstance();
    }

    public boolean getDisableManifest() {
        return this.disableManifest_;
    }

    public String getFilepath() {
        return this.filepath_;
    }

    public AbstractC2383g getFilepathBytes() {
        return AbstractC2383g.N(this.filepath_);
    }

    public LivekitEgress$GCPUpload getGcp() {
        return this.outputCase_ == 3 ? (LivekitEgress$GCPUpload) this.output_ : LivekitEgress$GCPUpload.getDefaultInstance();
    }

    public b getOutputCase() {
        return b.j(this.outputCase_);
    }

    public LivekitEgress$S3Upload getS3() {
        return this.outputCase_ == 2 ? (LivekitEgress$S3Upload) this.output_ : LivekitEgress$S3Upload.getDefaultInstance();
    }

    public boolean hasAliOSS() {
        return this.outputCase_ == 6;
    }

    public boolean hasAzure() {
        return this.outputCase_ == 4;
    }

    public boolean hasGcp() {
        return this.outputCase_ == 3;
    }

    public boolean hasS3() {
        return this.outputCase_ == 2;
    }

    public static a newBuilder(LivekitEgress$DirectFileOutput livekitEgress$DirectFileOutput) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitEgress$DirectFileOutput);
    }

    public static LivekitEgress$DirectFileOutput parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitEgress$DirectFileOutput) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitEgress$DirectFileOutput parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitEgress$DirectFileOutput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitEgress$DirectFileOutput parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitEgress$DirectFileOutput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitEgress$DirectFileOutput parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitEgress$DirectFileOutput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitEgress$DirectFileOutput parseFrom(byte[] bArr) {
        return (LivekitEgress$DirectFileOutput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitEgress$DirectFileOutput parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitEgress$DirectFileOutput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitEgress$DirectFileOutput parseFrom(InputStream inputStream) {
        return (LivekitEgress$DirectFileOutput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitEgress$DirectFileOutput parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitEgress$DirectFileOutput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitEgress$DirectFileOutput parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitEgress$DirectFileOutput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitEgress$DirectFileOutput parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitEgress$DirectFileOutput) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
