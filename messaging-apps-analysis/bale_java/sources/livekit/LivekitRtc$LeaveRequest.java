package livekit;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.RE3;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import livekit.LivekitRtc$RegionSettings;

/* loaded from: classes8.dex */
public final class LivekitRtc$LeaveRequest extends GeneratedMessageLite implements U64 {
    public static final int ACTION_FIELD_NUMBER = 3;
    public static final int CAN_RECONNECT_FIELD_NUMBER = 1;
    private static final LivekitRtc$LeaveRequest DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int REASON_FIELD_NUMBER = 2;
    public static final int REGIONS_FIELD_NUMBER = 4;
    private int action_;
    private boolean canReconnect_;
    private int reason_;
    private LivekitRtc$RegionSettings regions_;

    public enum a implements B.c {
        DISCONNECT(0),
        RESUME(1),
        RECONNECT(2),
        UNRECOGNIZED(-1);

        private static final B.d f = new C1833a();
        private final int a;

        /* renamed from: livekit.LivekitRtc$LeaveRequest$a$a, reason: collision with other inner class name */
        class C1833a implements B.d {
            C1833a() {
            }

            @Override // com.google.protobuf.B.d
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public a a(int i) {
                return a.j(i);
            }
        }

        a(int i) {
            this.a = i;
        }

        public static a j(int i) {
            if (i == 0) {
                return DISCONNECT;
            }
            if (i == 1) {
                return RESUME;
            }
            if (i != 2) {
                return null;
            }
            return RECONNECT;
        }

        @Override // com.google.protobuf.B.c
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.a;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    public static final class b extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ b(s sVar) {
            this();
        }

        public b A(a aVar) {
            q();
            ((LivekitRtc$LeaveRequest) this.b).setAction(aVar);
            return this;
        }

        public b B(RE3 re3) {
            q();
            ((LivekitRtc$LeaveRequest) this.b).setReason(re3);
            return this;
        }

        private b() {
            super(LivekitRtc$LeaveRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitRtc$LeaveRequest livekitRtc$LeaveRequest = new LivekitRtc$LeaveRequest();
        DEFAULT_INSTANCE = livekitRtc$LeaveRequest;
        GeneratedMessageLite.registerDefaultInstance(LivekitRtc$LeaveRequest.class, livekitRtc$LeaveRequest);
    }

    private LivekitRtc$LeaveRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAction() {
        this.action_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCanReconnect() {
        this.canReconnect_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearReason() {
        this.reason_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRegions() {
        this.regions_ = null;
    }

    public static LivekitRtc$LeaveRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeRegions(LivekitRtc$RegionSettings livekitRtc$RegionSettings) {
        livekitRtc$RegionSettings.getClass();
        LivekitRtc$RegionSettings livekitRtc$RegionSettings2 = this.regions_;
        if (livekitRtc$RegionSettings2 == null || livekitRtc$RegionSettings2 == LivekitRtc$RegionSettings.getDefaultInstance()) {
            this.regions_ = livekitRtc$RegionSettings;
        } else {
            this.regions_ = (LivekitRtc$RegionSettings) ((LivekitRtc$RegionSettings.a) LivekitRtc$RegionSettings.newBuilder(this.regions_).v(livekitRtc$RegionSettings)).j();
        }
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitRtc$LeaveRequest parseDelimitedFrom(InputStream inputStream) {
        return (LivekitRtc$LeaveRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$LeaveRequest parseFrom(ByteBuffer byteBuffer) {
        return (LivekitRtc$LeaveRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAction(a aVar) {
        this.action_ = aVar.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setActionValue(int i) {
        this.action_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanReconnect(boolean z) {
        this.canReconnect_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReason(RE3 re3) {
        this.reason_ = re3.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReasonValue(int i) {
        this.reason_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRegions(LivekitRtc$RegionSettings livekitRtc$RegionSettings) {
        livekitRtc$RegionSettings.getClass();
        this.regions_ = livekitRtc$RegionSettings;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        s sVar = null;
        switch (s.a[gVar.ordinal()]) {
            case 1:
                return new LivekitRtc$LeaveRequest();
            case 2:
                return new b(sVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0007\u0002\f\u0003\f\u0004\t", new Object[]{"canReconnect_", "reason_", "action_", "regions_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitRtc$LeaveRequest.class) {
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

    public a getAction() {
        a aVarJ = a.j(this.action_);
        return aVarJ == null ? a.UNRECOGNIZED : aVarJ;
    }

    public int getActionValue() {
        return this.action_;
    }

    public boolean getCanReconnect() {
        return this.canReconnect_;
    }

    public RE3 getReason() {
        RE3 re3J = RE3.j(this.reason_);
        return re3J == null ? RE3.UNRECOGNIZED : re3J;
    }

    public int getReasonValue() {
        return this.reason_;
    }

    public LivekitRtc$RegionSettings getRegions() {
        LivekitRtc$RegionSettings livekitRtc$RegionSettings = this.regions_;
        return livekitRtc$RegionSettings == null ? LivekitRtc$RegionSettings.getDefaultInstance() : livekitRtc$RegionSettings;
    }

    public boolean hasRegions() {
        return this.regions_ != null;
    }

    public static b newBuilder(LivekitRtc$LeaveRequest livekitRtc$LeaveRequest) {
        return (b) DEFAULT_INSTANCE.createBuilder(livekitRtc$LeaveRequest);
    }

    public static LivekitRtc$LeaveRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$LeaveRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$LeaveRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitRtc$LeaveRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitRtc$LeaveRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitRtc$LeaveRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitRtc$LeaveRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitRtc$LeaveRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitRtc$LeaveRequest parseFrom(byte[] bArr) {
        return (LivekitRtc$LeaveRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitRtc$LeaveRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitRtc$LeaveRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitRtc$LeaveRequest parseFrom(InputStream inputStream) {
        return (LivekitRtc$LeaveRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$LeaveRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$LeaveRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$LeaveRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitRtc$LeaveRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitRtc$LeaveRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitRtc$LeaveRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
