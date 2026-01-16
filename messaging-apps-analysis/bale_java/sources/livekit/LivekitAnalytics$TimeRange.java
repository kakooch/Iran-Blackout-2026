package livekit;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Timestamp;
import ir.nasim.InterfaceC13442gE3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitAnalytics$TimeRange extends GeneratedMessageLite implements InterfaceC13442gE3 {
    private static final LivekitAnalytics$TimeRange DEFAULT_INSTANCE;
    public static final int ENDED_AT_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int STARTED_AT_FIELD_NUMBER = 1;
    private Timestamp endedAt_;
    private Timestamp startedAt_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC13442gE3 {
        /* synthetic */ a(c cVar) {
            this();
        }

        private a() {
            super(LivekitAnalytics$TimeRange.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitAnalytics$TimeRange livekitAnalytics$TimeRange = new LivekitAnalytics$TimeRange();
        DEFAULT_INSTANCE = livekitAnalytics$TimeRange;
        GeneratedMessageLite.registerDefaultInstance(LivekitAnalytics$TimeRange.class, livekitAnalytics$TimeRange);
    }

    private LivekitAnalytics$TimeRange() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEndedAt() {
        this.endedAt_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStartedAt() {
        this.startedAt_ = null;
    }

    public static LivekitAnalytics$TimeRange getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeEndedAt(Timestamp timestamp) {
        timestamp.getClass();
        Timestamp timestamp2 = this.endedAt_;
        if (timestamp2 == null || timestamp2 == Timestamp.getDefaultInstance()) {
            this.endedAt_ = timestamp;
        } else {
            this.endedAt_ = (Timestamp) ((Timestamp.b) Timestamp.newBuilder(this.endedAt_).v(timestamp)).j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeStartedAt(Timestamp timestamp) {
        timestamp.getClass();
        Timestamp timestamp2 = this.startedAt_;
        if (timestamp2 == null || timestamp2 == Timestamp.getDefaultInstance()) {
            this.startedAt_ = timestamp;
        } else {
            this.startedAt_ = (Timestamp) ((Timestamp.b) Timestamp.newBuilder(this.startedAt_).v(timestamp)).j();
        }
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitAnalytics$TimeRange parseDelimitedFrom(InputStream inputStream) {
        return (LivekitAnalytics$TimeRange) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAnalytics$TimeRange parseFrom(ByteBuffer byteBuffer) {
        return (LivekitAnalytics$TimeRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEndedAt(Timestamp timestamp) {
        timestamp.getClass();
        this.endedAt_ = timestamp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStartedAt(Timestamp timestamp) {
        timestamp.getClass();
        this.startedAt_ = timestamp;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        c cVar = null;
        switch (c.a[gVar.ordinal()]) {
            case 1:
                return new LivekitAnalytics$TimeRange();
            case 2:
                return new a(cVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"startedAt_", "endedAt_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar2 = PARSER;
                if (cVar2 == null) {
                    synchronized (LivekitAnalytics$TimeRange.class) {
                        try {
                            cVar2 = PARSER;
                            if (cVar2 == null) {
                                cVar2 = new GeneratedMessageLite.c(DEFAULT_INSTANCE);
                                PARSER = cVar2;
                            }
                        } finally {
                        }
                    }
                }
                return cVar2;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public Timestamp getEndedAt() {
        Timestamp timestamp = this.endedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    public Timestamp getStartedAt() {
        Timestamp timestamp = this.startedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    public boolean hasEndedAt() {
        return this.endedAt_ != null;
    }

    public boolean hasStartedAt() {
        return this.startedAt_ != null;
    }

    public static a newBuilder(LivekitAnalytics$TimeRange livekitAnalytics$TimeRange) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitAnalytics$TimeRange);
    }

    public static LivekitAnalytics$TimeRange parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAnalytics$TimeRange) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAnalytics$TimeRange parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitAnalytics$TimeRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitAnalytics$TimeRange parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitAnalytics$TimeRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitAnalytics$TimeRange parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitAnalytics$TimeRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitAnalytics$TimeRange parseFrom(byte[] bArr) {
        return (LivekitAnalytics$TimeRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitAnalytics$TimeRange parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitAnalytics$TimeRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitAnalytics$TimeRange parseFrom(InputStream inputStream) {
        return (LivekitAnalytics$TimeRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAnalytics$TimeRange parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAnalytics$TimeRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAnalytics$TimeRange parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitAnalytics$TimeRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitAnalytics$TimeRange parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitAnalytics$TimeRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
