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
public final class LivekitAgent$JobState extends GeneratedMessageLite implements U64 {
    private static final LivekitAgent$JobState DEFAULT_INSTANCE;
    public static final int ENDED_AT_FIELD_NUMBER = 4;
    public static final int ERROR_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int PARTICIPANT_IDENTITY_FIELD_NUMBER = 6;
    public static final int STARTED_AT_FIELD_NUMBER = 3;
    public static final int STATUS_FIELD_NUMBER = 1;
    public static final int UPDATED_AT_FIELD_NUMBER = 5;
    public static final int WORKER_ID_FIELD_NUMBER = 7;
    private long endedAt_;
    private long startedAt_;
    private int status_;
    private long updatedAt_;
    private String error_ = "";
    private String participantIdentity_ = "";
    private String workerId_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(livekit.a aVar) {
            this();
        }

        private a() {
            super(LivekitAgent$JobState.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitAgent$JobState livekitAgent$JobState = new LivekitAgent$JobState();
        DEFAULT_INSTANCE = livekitAgent$JobState;
        GeneratedMessageLite.registerDefaultInstance(LivekitAgent$JobState.class, livekitAgent$JobState);
    }

    private LivekitAgent$JobState() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEndedAt() {
        this.endedAt_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearError() {
        this.error_ = getDefaultInstance().getError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParticipantIdentity() {
        this.participantIdentity_ = getDefaultInstance().getParticipantIdentity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStartedAt() {
        this.startedAt_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStatus() {
        this.status_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUpdatedAt() {
        this.updatedAt_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearWorkerId() {
        this.workerId_ = getDefaultInstance().getWorkerId();
    }

    public static LivekitAgent$JobState getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitAgent$JobState parseDelimitedFrom(InputStream inputStream) {
        return (LivekitAgent$JobState) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAgent$JobState parseFrom(ByteBuffer byteBuffer) {
        return (LivekitAgent$JobState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEndedAt(long j) {
        this.endedAt_ = j;
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
    public void setParticipantIdentity(String str) {
        str.getClass();
        this.participantIdentity_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParticipantIdentityBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.participantIdentity_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStartedAt(long j) {
        this.startedAt_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatus(UD3 ud3) {
        this.status_ = ud3.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatusValue(int i) {
        this.status_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUpdatedAt(long j) {
        this.updatedAt_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWorkerId(String str) {
        str.getClass();
        this.workerId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWorkerIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.workerId_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        livekit.a aVar = null;
        switch (livekit.a.a[gVar.ordinal()]) {
            case 1:
                return new LivekitAgent$JobState();
            case 2:
                return new a(aVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0000\u0000\u0001\f\u0002Ȉ\u0003\u0002\u0004\u0002\u0005\u0002\u0006Ȉ\u0007Ȉ", new Object[]{"status_", "error_", "startedAt_", "endedAt_", "updatedAt_", "participantIdentity_", "workerId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitAgent$JobState.class) {
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

    public long getEndedAt() {
        return this.endedAt_;
    }

    public String getError() {
        return this.error_;
    }

    public AbstractC2383g getErrorBytes() {
        return AbstractC2383g.N(this.error_);
    }

    public String getParticipantIdentity() {
        return this.participantIdentity_;
    }

    public AbstractC2383g getParticipantIdentityBytes() {
        return AbstractC2383g.N(this.participantIdentity_);
    }

    public long getStartedAt() {
        return this.startedAt_;
    }

    public UD3 getStatus() {
        UD3 ud3J = UD3.j(this.status_);
        return ud3J == null ? UD3.UNRECOGNIZED : ud3J;
    }

    public int getStatusValue() {
        return this.status_;
    }

    public long getUpdatedAt() {
        return this.updatedAt_;
    }

    public String getWorkerId() {
        return this.workerId_;
    }

    public AbstractC2383g getWorkerIdBytes() {
        return AbstractC2383g.N(this.workerId_);
    }

    public static a newBuilder(LivekitAgent$JobState livekitAgent$JobState) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitAgent$JobState);
    }

    public static LivekitAgent$JobState parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAgent$JobState) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAgent$JobState parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitAgent$JobState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitAgent$JobState parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitAgent$JobState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitAgent$JobState parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitAgent$JobState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitAgent$JobState parseFrom(byte[] bArr) {
        return (LivekitAgent$JobState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitAgent$JobState parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitAgent$JobState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitAgent$JobState parseFrom(InputStream inputStream) {
        return (LivekitAgent$JobState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAgent$JobState parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAgent$JobState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAgent$JobState parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitAgent$JobState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitAgent$JobState parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitAgent$JobState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
