package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import ir.nasim.UD3;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitAgent$UpdateJobStatus extends GeneratedMessageLite implements U64 {
    private static final LivekitAgent$UpdateJobStatus DEFAULT_INSTANCE;
    public static final int ERROR_FIELD_NUMBER = 3;
    public static final int JOB_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int STATUS_FIELD_NUMBER = 2;
    private int status_;
    private String jobId_ = "";
    private String error_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(livekit.a aVar) {
            this();
        }

        private a() {
            super(LivekitAgent$UpdateJobStatus.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitAgent$UpdateJobStatus livekitAgent$UpdateJobStatus = new LivekitAgent$UpdateJobStatus();
        DEFAULT_INSTANCE = livekitAgent$UpdateJobStatus;
        GeneratedMessageLite.registerDefaultInstance(LivekitAgent$UpdateJobStatus.class, livekitAgent$UpdateJobStatus);
    }

    private LivekitAgent$UpdateJobStatus() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearError() {
        this.error_ = getDefaultInstance().getError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearJobId() {
        this.jobId_ = getDefaultInstance().getJobId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStatus() {
        this.status_ = 0;
    }

    public static LivekitAgent$UpdateJobStatus getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitAgent$UpdateJobStatus parseDelimitedFrom(InputStream inputStream) {
        return (LivekitAgent$UpdateJobStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAgent$UpdateJobStatus parseFrom(ByteBuffer byteBuffer) {
        return (LivekitAgent$UpdateJobStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setError(String str) {
        str.getClass();
        this.error_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setErrorBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.error_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setJobId(String str) {
        str.getClass();
        this.jobId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setJobIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.jobId_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatus(UD3 ud3) {
        this.status_ = ud3.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatusValue(int i) {
        this.status_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        livekit.a aVar = null;
        switch (livekit.a.a[gVar.ordinal()]) {
            case 1:
                return new LivekitAgent$UpdateJobStatus();
            case 2:
                return new a(aVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003Ȉ", new Object[]{"jobId_", "status_", "error_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitAgent$UpdateJobStatus.class) {
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

    public String getError() {
        return this.error_;
    }

    public AbstractC2383g getErrorBytes() {
        return AbstractC2383g.N(this.error_);
    }

    public String getJobId() {
        return this.jobId_;
    }

    public AbstractC2383g getJobIdBytes() {
        return AbstractC2383g.N(this.jobId_);
    }

    public UD3 getStatus() {
        UD3 ud3J = UD3.j(this.status_);
        return ud3J == null ? UD3.UNRECOGNIZED : ud3J;
    }

    public int getStatusValue() {
        return this.status_;
    }

    public static a newBuilder(LivekitAgent$UpdateJobStatus livekitAgent$UpdateJobStatus) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitAgent$UpdateJobStatus);
    }

    public static LivekitAgent$UpdateJobStatus parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAgent$UpdateJobStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAgent$UpdateJobStatus parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitAgent$UpdateJobStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitAgent$UpdateJobStatus parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitAgent$UpdateJobStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitAgent$UpdateJobStatus parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitAgent$UpdateJobStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitAgent$UpdateJobStatus parseFrom(byte[] bArr) {
        return (LivekitAgent$UpdateJobStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitAgent$UpdateJobStatus parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitAgent$UpdateJobStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitAgent$UpdateJobStatus parseFrom(InputStream inputStream) {
        return (LivekitAgent$UpdateJobStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAgent$UpdateJobStatus parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAgent$UpdateJobStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAgent$UpdateJobStatus parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitAgent$UpdateJobStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitAgent$UpdateJobStatus parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitAgent$UpdateJobStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
