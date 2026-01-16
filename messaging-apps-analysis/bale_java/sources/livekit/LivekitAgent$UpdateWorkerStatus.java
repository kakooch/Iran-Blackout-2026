package livekit;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import ir.nasim.WD3;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitAgent$UpdateWorkerStatus extends GeneratedMessageLite implements U64 {
    private static final LivekitAgent$UpdateWorkerStatus DEFAULT_INSTANCE;
    public static final int JOB_COUNT_FIELD_NUMBER = 4;
    public static final int LOAD_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int STATUS_FIELD_NUMBER = 1;
    private int bitField0_;
    private int jobCount_;
    private float load_;
    private int status_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(livekit.a aVar) {
            this();
        }

        private a() {
            super(LivekitAgent$UpdateWorkerStatus.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitAgent$UpdateWorkerStatus livekitAgent$UpdateWorkerStatus = new LivekitAgent$UpdateWorkerStatus();
        DEFAULT_INSTANCE = livekitAgent$UpdateWorkerStatus;
        GeneratedMessageLite.registerDefaultInstance(LivekitAgent$UpdateWorkerStatus.class, livekitAgent$UpdateWorkerStatus);
    }

    private LivekitAgent$UpdateWorkerStatus() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearJobCount() {
        this.jobCount_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLoad() {
        this.load_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStatus() {
        this.bitField0_ &= -2;
        this.status_ = 0;
    }

    public static LivekitAgent$UpdateWorkerStatus getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitAgent$UpdateWorkerStatus parseDelimitedFrom(InputStream inputStream) {
        return (LivekitAgent$UpdateWorkerStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAgent$UpdateWorkerStatus parseFrom(ByteBuffer byteBuffer) {
        return (LivekitAgent$UpdateWorkerStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setJobCount(int i) {
        this.jobCount_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoad(float f) {
        this.load_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatus(WD3 wd3) {
        this.status_ = wd3.getNumber();
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatusValue(int i) {
        this.bitField0_ |= 1;
        this.status_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        livekit.a aVar = null;
        switch (livekit.a.a[gVar.ordinal()]) {
            case 1:
                return new LivekitAgent$UpdateWorkerStatus();
            case 2:
                return new a(aVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0003\u0001\u0004\u000b", new Object[]{"bitField0_", "status_", "load_", "jobCount_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitAgent$UpdateWorkerStatus.class) {
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

    public int getJobCount() {
        return this.jobCount_;
    }

    public float getLoad() {
        return this.load_;
    }

    public WD3 getStatus() {
        WD3 wd3J = WD3.j(this.status_);
        return wd3J == null ? WD3.UNRECOGNIZED : wd3J;
    }

    public int getStatusValue() {
        return this.status_;
    }

    public boolean hasStatus() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(LivekitAgent$UpdateWorkerStatus livekitAgent$UpdateWorkerStatus) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitAgent$UpdateWorkerStatus);
    }

    public static LivekitAgent$UpdateWorkerStatus parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAgent$UpdateWorkerStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAgent$UpdateWorkerStatus parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitAgent$UpdateWorkerStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitAgent$UpdateWorkerStatus parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitAgent$UpdateWorkerStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitAgent$UpdateWorkerStatus parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitAgent$UpdateWorkerStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitAgent$UpdateWorkerStatus parseFrom(byte[] bArr) {
        return (LivekitAgent$UpdateWorkerStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitAgent$UpdateWorkerStatus parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitAgent$UpdateWorkerStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitAgent$UpdateWorkerStatus parseFrom(InputStream inputStream) {
        return (LivekitAgent$UpdateWorkerStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAgent$UpdateWorkerStatus parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAgent$UpdateWorkerStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAgent$UpdateWorkerStatus parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitAgent$UpdateWorkerStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitAgent$UpdateWorkerStatus parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitAgent$UpdateWorkerStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
