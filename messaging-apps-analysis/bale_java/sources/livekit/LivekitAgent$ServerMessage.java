package livekit;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import livekit.LivekitAgent$AvailabilityRequest;
import livekit.LivekitAgent$JobAssignment;
import livekit.LivekitAgent$JobTermination;
import livekit.LivekitAgent$RegisterWorkerResponse;
import livekit.LivekitAgent$WorkerPong;

/* loaded from: classes8.dex */
public final class LivekitAgent$ServerMessage extends GeneratedMessageLite implements U64 {
    public static final int ASSIGNMENT_FIELD_NUMBER = 3;
    public static final int AVAILABILITY_FIELD_NUMBER = 2;
    private static final LivekitAgent$ServerMessage DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PONG_FIELD_NUMBER = 4;
    public static final int REGISTER_FIELD_NUMBER = 1;
    public static final int TERMINATION_FIELD_NUMBER = 5;
    private int messageCase_ = 0;
    private Object message_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(livekit.a aVar) {
            this();
        }

        private a() {
            super(LivekitAgent$ServerMessage.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        REGISTER(1),
        AVAILABILITY(2),
        ASSIGNMENT(3),
        TERMINATION(5),
        PONG(4),
        MESSAGE_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return MESSAGE_NOT_SET;
            }
            if (i == 1) {
                return REGISTER;
            }
            if (i == 2) {
                return AVAILABILITY;
            }
            if (i == 3) {
                return ASSIGNMENT;
            }
            if (i == 4) {
                return PONG;
            }
            if (i != 5) {
                return null;
            }
            return TERMINATION;
        }
    }

    static {
        LivekitAgent$ServerMessage livekitAgent$ServerMessage = new LivekitAgent$ServerMessage();
        DEFAULT_INSTANCE = livekitAgent$ServerMessage;
        GeneratedMessageLite.registerDefaultInstance(LivekitAgent$ServerMessage.class, livekitAgent$ServerMessage);
    }

    private LivekitAgent$ServerMessage() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAssignment() {
        if (this.messageCase_ == 3) {
            this.messageCase_ = 0;
            this.message_ = null;
        }
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
    public void clearPong() {
        if (this.messageCase_ == 4) {
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
    public void clearTermination() {
        if (this.messageCase_ == 5) {
            this.messageCase_ = 0;
            this.message_ = null;
        }
    }

    public static LivekitAgent$ServerMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeAssignment(LivekitAgent$JobAssignment livekitAgent$JobAssignment) {
        livekitAgent$JobAssignment.getClass();
        if (this.messageCase_ != 3 || this.message_ == LivekitAgent$JobAssignment.getDefaultInstance()) {
            this.message_ = livekitAgent$JobAssignment;
        } else {
            this.message_ = ((LivekitAgent$JobAssignment.a) LivekitAgent$JobAssignment.newBuilder((LivekitAgent$JobAssignment) this.message_).v(livekitAgent$JobAssignment)).j();
        }
        this.messageCase_ = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeAvailability(LivekitAgent$AvailabilityRequest livekitAgent$AvailabilityRequest) {
        livekitAgent$AvailabilityRequest.getClass();
        if (this.messageCase_ != 2 || this.message_ == LivekitAgent$AvailabilityRequest.getDefaultInstance()) {
            this.message_ = livekitAgent$AvailabilityRequest;
        } else {
            this.message_ = ((LivekitAgent$AvailabilityRequest.a) LivekitAgent$AvailabilityRequest.newBuilder((LivekitAgent$AvailabilityRequest) this.message_).v(livekitAgent$AvailabilityRequest)).j();
        }
        this.messageCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergePong(LivekitAgent$WorkerPong livekitAgent$WorkerPong) {
        livekitAgent$WorkerPong.getClass();
        if (this.messageCase_ != 4 || this.message_ == LivekitAgent$WorkerPong.getDefaultInstance()) {
            this.message_ = livekitAgent$WorkerPong;
        } else {
            this.message_ = ((LivekitAgent$WorkerPong.a) LivekitAgent$WorkerPong.newBuilder((LivekitAgent$WorkerPong) this.message_).v(livekitAgent$WorkerPong)).j();
        }
        this.messageCase_ = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeRegister(LivekitAgent$RegisterWorkerResponse livekitAgent$RegisterWorkerResponse) {
        livekitAgent$RegisterWorkerResponse.getClass();
        if (this.messageCase_ != 1 || this.message_ == LivekitAgent$RegisterWorkerResponse.getDefaultInstance()) {
            this.message_ = livekitAgent$RegisterWorkerResponse;
        } else {
            this.message_ = ((LivekitAgent$RegisterWorkerResponse.a) LivekitAgent$RegisterWorkerResponse.newBuilder((LivekitAgent$RegisterWorkerResponse) this.message_).v(livekitAgent$RegisterWorkerResponse)).j();
        }
        this.messageCase_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeTermination(LivekitAgent$JobTermination livekitAgent$JobTermination) {
        livekitAgent$JobTermination.getClass();
        if (this.messageCase_ != 5 || this.message_ == LivekitAgent$JobTermination.getDefaultInstance()) {
            this.message_ = livekitAgent$JobTermination;
        } else {
            this.message_ = ((LivekitAgent$JobTermination.a) LivekitAgent$JobTermination.newBuilder((LivekitAgent$JobTermination) this.message_).v(livekitAgent$JobTermination)).j();
        }
        this.messageCase_ = 5;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitAgent$ServerMessage parseDelimitedFrom(InputStream inputStream) {
        return (LivekitAgent$ServerMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAgent$ServerMessage parseFrom(ByteBuffer byteBuffer) {
        return (LivekitAgent$ServerMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAssignment(LivekitAgent$JobAssignment livekitAgent$JobAssignment) {
        livekitAgent$JobAssignment.getClass();
        this.message_ = livekitAgent$JobAssignment;
        this.messageCase_ = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAvailability(LivekitAgent$AvailabilityRequest livekitAgent$AvailabilityRequest) {
        livekitAgent$AvailabilityRequest.getClass();
        this.message_ = livekitAgent$AvailabilityRequest;
        this.messageCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPong(LivekitAgent$WorkerPong livekitAgent$WorkerPong) {
        livekitAgent$WorkerPong.getClass();
        this.message_ = livekitAgent$WorkerPong;
        this.messageCase_ = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRegister(LivekitAgent$RegisterWorkerResponse livekitAgent$RegisterWorkerResponse) {
        livekitAgent$RegisterWorkerResponse.getClass();
        this.message_ = livekitAgent$RegisterWorkerResponse;
        this.messageCase_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTermination(LivekitAgent$JobTermination livekitAgent$JobTermination) {
        livekitAgent$JobTermination.getClass();
        this.message_ = livekitAgent$JobTermination;
        this.messageCase_ = 5;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        livekit.a aVar = null;
        switch (livekit.a.a[gVar.ordinal()]) {
            case 1:
                return new LivekitAgent$ServerMessage();
            case 2:
                return new a(aVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0001\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000", new Object[]{"message_", "messageCase_", LivekitAgent$RegisterWorkerResponse.class, LivekitAgent$AvailabilityRequest.class, LivekitAgent$JobAssignment.class, LivekitAgent$WorkerPong.class, LivekitAgent$JobTermination.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitAgent$ServerMessage.class) {
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

    public LivekitAgent$JobAssignment getAssignment() {
        return this.messageCase_ == 3 ? (LivekitAgent$JobAssignment) this.message_ : LivekitAgent$JobAssignment.getDefaultInstance();
    }

    public LivekitAgent$AvailabilityRequest getAvailability() {
        return this.messageCase_ == 2 ? (LivekitAgent$AvailabilityRequest) this.message_ : LivekitAgent$AvailabilityRequest.getDefaultInstance();
    }

    public b getMessageCase() {
        return b.j(this.messageCase_);
    }

    public LivekitAgent$WorkerPong getPong() {
        return this.messageCase_ == 4 ? (LivekitAgent$WorkerPong) this.message_ : LivekitAgent$WorkerPong.getDefaultInstance();
    }

    public LivekitAgent$RegisterWorkerResponse getRegister() {
        return this.messageCase_ == 1 ? (LivekitAgent$RegisterWorkerResponse) this.message_ : LivekitAgent$RegisterWorkerResponse.getDefaultInstance();
    }

    public LivekitAgent$JobTermination getTermination() {
        return this.messageCase_ == 5 ? (LivekitAgent$JobTermination) this.message_ : LivekitAgent$JobTermination.getDefaultInstance();
    }

    public boolean hasAssignment() {
        return this.messageCase_ == 3;
    }

    public boolean hasAvailability() {
        return this.messageCase_ == 2;
    }

    public boolean hasPong() {
        return this.messageCase_ == 4;
    }

    public boolean hasRegister() {
        return this.messageCase_ == 1;
    }

    public boolean hasTermination() {
        return this.messageCase_ == 5;
    }

    public static a newBuilder(LivekitAgent$ServerMessage livekitAgent$ServerMessage) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitAgent$ServerMessage);
    }

    public static LivekitAgent$ServerMessage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAgent$ServerMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAgent$ServerMessage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitAgent$ServerMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitAgent$ServerMessage parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitAgent$ServerMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitAgent$ServerMessage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitAgent$ServerMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitAgent$ServerMessage parseFrom(byte[] bArr) {
        return (LivekitAgent$ServerMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitAgent$ServerMessage parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitAgent$ServerMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitAgent$ServerMessage parseFrom(InputStream inputStream) {
        return (LivekitAgent$ServerMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAgent$ServerMessage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAgent$ServerMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAgent$ServerMessage parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitAgent$ServerMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitAgent$ServerMessage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitAgent$ServerMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
