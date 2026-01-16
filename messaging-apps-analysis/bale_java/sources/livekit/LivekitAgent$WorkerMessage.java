package livekit;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import livekit.LivekitAgent$AvailabilityResponse;
import livekit.LivekitAgent$MigrateJobRequest;
import livekit.LivekitAgent$RegisterWorkerRequest;
import livekit.LivekitAgent$SimulateJobRequest;
import livekit.LivekitAgent$UpdateJobStatus;
import livekit.LivekitAgent$UpdateWorkerStatus;
import livekit.LivekitAgent$WorkerPing;

/* loaded from: classes8.dex */
public final class LivekitAgent$WorkerMessage extends GeneratedMessageLite implements U64 {
    public static final int AVAILABILITY_FIELD_NUMBER = 2;
    private static final LivekitAgent$WorkerMessage DEFAULT_INSTANCE;
    public static final int MIGRATE_JOB_FIELD_NUMBER = 7;
    private static volatile KW4 PARSER = null;
    public static final int PING_FIELD_NUMBER = 5;
    public static final int REGISTER_FIELD_NUMBER = 1;
    public static final int SIMULATE_JOB_FIELD_NUMBER = 6;
    public static final int UPDATE_JOB_FIELD_NUMBER = 4;
    public static final int UPDATE_WORKER_FIELD_NUMBER = 3;
    private int messageCase_ = 0;
    private Object message_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(livekit.a aVar) {
            this();
        }

        private a() {
            super(LivekitAgent$WorkerMessage.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        REGISTER(1),
        AVAILABILITY(2),
        UPDATE_WORKER(3),
        UPDATE_JOB(4),
        PING(5),
        SIMULATE_JOB(6),
        MIGRATE_JOB(7),
        MESSAGE_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            switch (i) {
                case 0:
                    return MESSAGE_NOT_SET;
                case 1:
                    return REGISTER;
                case 2:
                    return AVAILABILITY;
                case 3:
                    return UPDATE_WORKER;
                case 4:
                    return UPDATE_JOB;
                case 5:
                    return PING;
                case 6:
                    return SIMULATE_JOB;
                case 7:
                    return MIGRATE_JOB;
                default:
                    return null;
            }
        }
    }

    static {
        LivekitAgent$WorkerMessage livekitAgent$WorkerMessage = new LivekitAgent$WorkerMessage();
        DEFAULT_INSTANCE = livekitAgent$WorkerMessage;
        GeneratedMessageLite.registerDefaultInstance(LivekitAgent$WorkerMessage.class, livekitAgent$WorkerMessage);
    }

    private LivekitAgent$WorkerMessage() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAvailability() {
        if (this.messageCase_ == 2) {
            this.messageCase_ = 0;
            this.message_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMessage() {
        this.messageCase_ = 0;
        this.message_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMigrateJob() {
        if (this.messageCase_ == 7) {
            this.messageCase_ = 0;
            this.message_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPing() {
        if (this.messageCase_ == 5) {
            this.messageCase_ = 0;
            this.message_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRegister() {
        if (this.messageCase_ == 1) {
            this.messageCase_ = 0;
            this.message_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSimulateJob() {
        if (this.messageCase_ == 6) {
            this.messageCase_ = 0;
            this.message_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUpdateJob() {
        if (this.messageCase_ == 4) {
            this.messageCase_ = 0;
            this.message_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUpdateWorker() {
        if (this.messageCase_ == 3) {
            this.messageCase_ = 0;
            this.message_ = null;
        }
    }

    public static LivekitAgent$WorkerMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeAvailability(LivekitAgent$AvailabilityResponse livekitAgent$AvailabilityResponse) {
        livekitAgent$AvailabilityResponse.getClass();
        if (this.messageCase_ != 2 || this.message_ == LivekitAgent$AvailabilityResponse.getDefaultInstance()) {
            this.message_ = livekitAgent$AvailabilityResponse;
        } else {
            this.message_ = ((LivekitAgent$AvailabilityResponse.a) LivekitAgent$AvailabilityResponse.newBuilder((LivekitAgent$AvailabilityResponse) this.message_).v(livekitAgent$AvailabilityResponse)).j();
        }
        this.messageCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeMigrateJob(LivekitAgent$MigrateJobRequest livekitAgent$MigrateJobRequest) {
        livekitAgent$MigrateJobRequest.getClass();
        if (this.messageCase_ != 7 || this.message_ == LivekitAgent$MigrateJobRequest.getDefaultInstance()) {
            this.message_ = livekitAgent$MigrateJobRequest;
        } else {
            this.message_ = ((LivekitAgent$MigrateJobRequest.a) LivekitAgent$MigrateJobRequest.newBuilder((LivekitAgent$MigrateJobRequest) this.message_).v(livekitAgent$MigrateJobRequest)).j();
        }
        this.messageCase_ = 7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergePing(LivekitAgent$WorkerPing livekitAgent$WorkerPing) {
        livekitAgent$WorkerPing.getClass();
        if (this.messageCase_ != 5 || this.message_ == LivekitAgent$WorkerPing.getDefaultInstance()) {
            this.message_ = livekitAgent$WorkerPing;
        } else {
            this.message_ = ((LivekitAgent$WorkerPing.a) LivekitAgent$WorkerPing.newBuilder((LivekitAgent$WorkerPing) this.message_).v(livekitAgent$WorkerPing)).j();
        }
        this.messageCase_ = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeRegister(LivekitAgent$RegisterWorkerRequest livekitAgent$RegisterWorkerRequest) {
        livekitAgent$RegisterWorkerRequest.getClass();
        if (this.messageCase_ != 1 || this.message_ == LivekitAgent$RegisterWorkerRequest.getDefaultInstance()) {
            this.message_ = livekitAgent$RegisterWorkerRequest;
        } else {
            this.message_ = ((LivekitAgent$RegisterWorkerRequest.a) LivekitAgent$RegisterWorkerRequest.newBuilder((LivekitAgent$RegisterWorkerRequest) this.message_).v(livekitAgent$RegisterWorkerRequest)).j();
        }
        this.messageCase_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeSimulateJob(LivekitAgent$SimulateJobRequest livekitAgent$SimulateJobRequest) {
        livekitAgent$SimulateJobRequest.getClass();
        if (this.messageCase_ != 6 || this.message_ == LivekitAgent$SimulateJobRequest.getDefaultInstance()) {
            this.message_ = livekitAgent$SimulateJobRequest;
        } else {
            this.message_ = ((LivekitAgent$SimulateJobRequest.a) LivekitAgent$SimulateJobRequest.newBuilder((LivekitAgent$SimulateJobRequest) this.message_).v(livekitAgent$SimulateJobRequest)).j();
        }
        this.messageCase_ = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeUpdateJob(LivekitAgent$UpdateJobStatus livekitAgent$UpdateJobStatus) {
        livekitAgent$UpdateJobStatus.getClass();
        if (this.messageCase_ != 4 || this.message_ == LivekitAgent$UpdateJobStatus.getDefaultInstance()) {
            this.message_ = livekitAgent$UpdateJobStatus;
        } else {
            this.message_ = ((LivekitAgent$UpdateJobStatus.a) LivekitAgent$UpdateJobStatus.newBuilder((LivekitAgent$UpdateJobStatus) this.message_).v(livekitAgent$UpdateJobStatus)).j();
        }
        this.messageCase_ = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeUpdateWorker(LivekitAgent$UpdateWorkerStatus livekitAgent$UpdateWorkerStatus) {
        livekitAgent$UpdateWorkerStatus.getClass();
        if (this.messageCase_ != 3 || this.message_ == LivekitAgent$UpdateWorkerStatus.getDefaultInstance()) {
            this.message_ = livekitAgent$UpdateWorkerStatus;
        } else {
            this.message_ = ((LivekitAgent$UpdateWorkerStatus.a) LivekitAgent$UpdateWorkerStatus.newBuilder((LivekitAgent$UpdateWorkerStatus) this.message_).v(livekitAgent$UpdateWorkerStatus)).j();
        }
        this.messageCase_ = 3;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitAgent$WorkerMessage parseDelimitedFrom(InputStream inputStream) {
        return (LivekitAgent$WorkerMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAgent$WorkerMessage parseFrom(ByteBuffer byteBuffer) {
        return (LivekitAgent$WorkerMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAvailability(LivekitAgent$AvailabilityResponse livekitAgent$AvailabilityResponse) {
        livekitAgent$AvailabilityResponse.getClass();
        this.message_ = livekitAgent$AvailabilityResponse;
        this.messageCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMigrateJob(LivekitAgent$MigrateJobRequest livekitAgent$MigrateJobRequest) {
        livekitAgent$MigrateJobRequest.getClass();
        this.message_ = livekitAgent$MigrateJobRequest;
        this.messageCase_ = 7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPing(LivekitAgent$WorkerPing livekitAgent$WorkerPing) {
        livekitAgent$WorkerPing.getClass();
        this.message_ = livekitAgent$WorkerPing;
        this.messageCase_ = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRegister(LivekitAgent$RegisterWorkerRequest livekitAgent$RegisterWorkerRequest) {
        livekitAgent$RegisterWorkerRequest.getClass();
        this.message_ = livekitAgent$RegisterWorkerRequest;
        this.messageCase_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSimulateJob(LivekitAgent$SimulateJobRequest livekitAgent$SimulateJobRequest) {
        livekitAgent$SimulateJobRequest.getClass();
        this.message_ = livekitAgent$SimulateJobRequest;
        this.messageCase_ = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUpdateJob(LivekitAgent$UpdateJobStatus livekitAgent$UpdateJobStatus) {
        livekitAgent$UpdateJobStatus.getClass();
        this.message_ = livekitAgent$UpdateJobStatus;
        this.messageCase_ = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUpdateWorker(LivekitAgent$UpdateWorkerStatus livekitAgent$UpdateWorkerStatus) {
        livekitAgent$UpdateWorkerStatus.getClass();
        this.message_ = livekitAgent$UpdateWorkerStatus;
        this.messageCase_ = 3;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        livekit.a aVar = null;
        switch (livekit.a.a[gVar.ordinal()]) {
            case 1:
                return new LivekitAgent$WorkerMessage();
            case 2:
                return new a(aVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0001\u0000\u0001\u0007\u0007\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000\u0006<\u0000\u0007<\u0000", new Object[]{"message_", "messageCase_", LivekitAgent$RegisterWorkerRequest.class, LivekitAgent$AvailabilityResponse.class, LivekitAgent$UpdateWorkerStatus.class, LivekitAgent$UpdateJobStatus.class, LivekitAgent$WorkerPing.class, LivekitAgent$SimulateJobRequest.class, LivekitAgent$MigrateJobRequest.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitAgent$WorkerMessage.class) {
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

    public LivekitAgent$AvailabilityResponse getAvailability() {
        return this.messageCase_ == 2 ? (LivekitAgent$AvailabilityResponse) this.message_ : LivekitAgent$AvailabilityResponse.getDefaultInstance();
    }

    public b getMessageCase() {
        return b.j(this.messageCase_);
    }

    public LivekitAgent$MigrateJobRequest getMigrateJob() {
        return this.messageCase_ == 7 ? (LivekitAgent$MigrateJobRequest) this.message_ : LivekitAgent$MigrateJobRequest.getDefaultInstance();
    }

    public LivekitAgent$WorkerPing getPing() {
        return this.messageCase_ == 5 ? (LivekitAgent$WorkerPing) this.message_ : LivekitAgent$WorkerPing.getDefaultInstance();
    }

    public LivekitAgent$RegisterWorkerRequest getRegister() {
        return this.messageCase_ == 1 ? (LivekitAgent$RegisterWorkerRequest) this.message_ : LivekitAgent$RegisterWorkerRequest.getDefaultInstance();
    }

    public LivekitAgent$SimulateJobRequest getSimulateJob() {
        return this.messageCase_ == 6 ? (LivekitAgent$SimulateJobRequest) this.message_ : LivekitAgent$SimulateJobRequest.getDefaultInstance();
    }

    public LivekitAgent$UpdateJobStatus getUpdateJob() {
        return this.messageCase_ == 4 ? (LivekitAgent$UpdateJobStatus) this.message_ : LivekitAgent$UpdateJobStatus.getDefaultInstance();
    }

    public LivekitAgent$UpdateWorkerStatus getUpdateWorker() {
        return this.messageCase_ == 3 ? (LivekitAgent$UpdateWorkerStatus) this.message_ : LivekitAgent$UpdateWorkerStatus.getDefaultInstance();
    }

    public boolean hasAvailability() {
        return this.messageCase_ == 2;
    }

    public boolean hasMigrateJob() {
        return this.messageCase_ == 7;
    }

    public boolean hasPing() {
        return this.messageCase_ == 5;
    }

    public boolean hasRegister() {
        return this.messageCase_ == 1;
    }

    public boolean hasSimulateJob() {
        return this.messageCase_ == 6;
    }

    public boolean hasUpdateJob() {
        return this.messageCase_ == 4;
    }

    public boolean hasUpdateWorker() {
        return this.messageCase_ == 3;
    }

    public static a newBuilder(LivekitAgent$WorkerMessage livekitAgent$WorkerMessage) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitAgent$WorkerMessage);
    }

    public static LivekitAgent$WorkerMessage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAgent$WorkerMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAgent$WorkerMessage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitAgent$WorkerMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitAgent$WorkerMessage parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitAgent$WorkerMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitAgent$WorkerMessage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitAgent$WorkerMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitAgent$WorkerMessage parseFrom(byte[] bArr) {
        return (LivekitAgent$WorkerMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitAgent$WorkerMessage parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitAgent$WorkerMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitAgent$WorkerMessage parseFrom(InputStream inputStream) {
        return (LivekitAgent$WorkerMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAgent$WorkerMessage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAgent$WorkerMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAgent$WorkerMessage parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitAgent$WorkerMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitAgent$WorkerMessage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitAgent$WorkerMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
