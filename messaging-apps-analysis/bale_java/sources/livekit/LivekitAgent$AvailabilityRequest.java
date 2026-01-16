package livekit;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import livekit.LivekitAgent$Job;

/* loaded from: classes8.dex */
public final class LivekitAgent$AvailabilityRequest extends GeneratedMessageLite implements U64 {
    private static final LivekitAgent$AvailabilityRequest DEFAULT_INSTANCE;
    public static final int JOB_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int RESUMING_FIELD_NUMBER = 2;
    private LivekitAgent$Job job_;
    private boolean resuming_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(livekit.a aVar) {
            this();
        }

        private a() {
            super(LivekitAgent$AvailabilityRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitAgent$AvailabilityRequest livekitAgent$AvailabilityRequest = new LivekitAgent$AvailabilityRequest();
        DEFAULT_INSTANCE = livekitAgent$AvailabilityRequest;
        GeneratedMessageLite.registerDefaultInstance(LivekitAgent$AvailabilityRequest.class, livekitAgent$AvailabilityRequest);
    }

    private LivekitAgent$AvailabilityRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearJob() {
        this.job_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearResuming() {
        this.resuming_ = false;
    }

    public static LivekitAgent$AvailabilityRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeJob(LivekitAgent$Job livekitAgent$Job) {
        livekitAgent$Job.getClass();
        LivekitAgent$Job livekitAgent$Job2 = this.job_;
        if (livekitAgent$Job2 == null || livekitAgent$Job2 == LivekitAgent$Job.getDefaultInstance()) {
            this.job_ = livekitAgent$Job;
        } else {
            this.job_ = (LivekitAgent$Job) ((LivekitAgent$Job.a) LivekitAgent$Job.newBuilder(this.job_).v(livekitAgent$Job)).j();
        }
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitAgent$AvailabilityRequest parseDelimitedFrom(InputStream inputStream) {
        return (LivekitAgent$AvailabilityRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAgent$AvailabilityRequest parseFrom(ByteBuffer byteBuffer) {
        return (LivekitAgent$AvailabilityRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setJob(LivekitAgent$Job livekitAgent$Job) {
        livekitAgent$Job.getClass();
        this.job_ = livekitAgent$Job;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResuming(boolean z) {
        this.resuming_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        livekit.a aVar = null;
        switch (livekit.a.a[gVar.ordinal()]) {
            case 1:
                return new LivekitAgent$AvailabilityRequest();
            case 2:
                return new a(aVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u0007", new Object[]{"job_", "resuming_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitAgent$AvailabilityRequest.class) {
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

    public LivekitAgent$Job getJob() {
        LivekitAgent$Job livekitAgent$Job = this.job_;
        return livekitAgent$Job == null ? LivekitAgent$Job.getDefaultInstance() : livekitAgent$Job;
    }

    public boolean getResuming() {
        return this.resuming_;
    }

    public boolean hasJob() {
        return this.job_ != null;
    }

    public static a newBuilder(LivekitAgent$AvailabilityRequest livekitAgent$AvailabilityRequest) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitAgent$AvailabilityRequest);
    }

    public static LivekitAgent$AvailabilityRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAgent$AvailabilityRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAgent$AvailabilityRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitAgent$AvailabilityRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitAgent$AvailabilityRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitAgent$AvailabilityRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitAgent$AvailabilityRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitAgent$AvailabilityRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitAgent$AvailabilityRequest parseFrom(byte[] bArr) {
        return (LivekitAgent$AvailabilityRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitAgent$AvailabilityRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitAgent$AvailabilityRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitAgent$AvailabilityRequest parseFrom(InputStream inputStream) {
        return (LivekitAgent$AvailabilityRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAgent$AvailabilityRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAgent$AvailabilityRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAgent$AvailabilityRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitAgent$AvailabilityRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitAgent$AvailabilityRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitAgent$AvailabilityRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
