package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitEgress$StreamInfo extends GeneratedMessageLite implements k {
    private static final LivekitEgress$StreamInfo DEFAULT_INSTANCE;
    public static final int DURATION_FIELD_NUMBER = 4;
    public static final int ENDED_AT_FIELD_NUMBER = 3;
    public static final int ERROR_FIELD_NUMBER = 6;
    private static volatile KW4 PARSER = null;
    public static final int STARTED_AT_FIELD_NUMBER = 2;
    public static final int STATUS_FIELD_NUMBER = 5;
    public static final int URL_FIELD_NUMBER = 1;
    private long duration_;
    private long endedAt_;
    private long startedAt_;
    private int status_;
    private String url_ = "";
    private String error_ = "";

    public static final class a extends GeneratedMessageLite.b implements k {
        /* synthetic */ a(f fVar) {
            this();
        }

        private a() {
            super(LivekitEgress$StreamInfo.DEFAULT_INSTANCE);
        }
    }

    public enum b implements B.c {
        ACTIVE(0),
        FINISHED(1),
        FAILED(2),
        UNRECOGNIZED(-1);

        private static final B.d f = new a();
        private final int a;

        class a implements B.d {
            a() {
            }

            @Override // com.google.protobuf.B.d
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public b a(int i) {
                return b.j(i);
            }
        }

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return ACTIVE;
            }
            if (i == 1) {
                return FINISHED;
            }
            if (i != 2) {
                return null;
            }
            return FAILED;
        }

        @Override // com.google.protobuf.B.c
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.a;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    static {
        LivekitEgress$StreamInfo livekitEgress$StreamInfo = new LivekitEgress$StreamInfo();
        DEFAULT_INSTANCE = livekitEgress$StreamInfo;
        GeneratedMessageLite.registerDefaultInstance(LivekitEgress$StreamInfo.class, livekitEgress$StreamInfo);
    }

    private LivekitEgress$StreamInfo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDuration() {
        this.duration_ = 0L;
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
    public void clearStartedAt() {
        this.startedAt_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStatus() {
        this.status_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUrl() {
        this.url_ = getDefaultInstance().getUrl();
    }

    public static LivekitEgress$StreamInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitEgress$StreamInfo parseDelimitedFrom(InputStream inputStream) {
        return (LivekitEgress$StreamInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitEgress$StreamInfo parseFrom(ByteBuffer byteBuffer) {
        return (LivekitEgress$StreamInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDuration(long j) {
        this.duration_ = j;
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
    public void setStartedAt(long j) {
        this.startedAt_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatus(b bVar) {
        this.status_ = bVar.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatusValue(int i) {
        this.status_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUrl(String str) {
        str.getClass();
        this.url_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUrlBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.url_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        f fVar = null;
        switch (f.a[gVar.ordinal()]) {
            case 1:
                return new LivekitEgress$StreamInfo();
            case 2:
                return new a(fVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001Ȉ\u0002\u0002\u0003\u0002\u0004\u0002\u0005\f\u0006Ȉ", new Object[]{"url_", "startedAt_", "endedAt_", "duration_", "status_", "error_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitEgress$StreamInfo.class) {
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

    public long getDuration() {
        return this.duration_;
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

    public long getStartedAt() {
        return this.startedAt_;
    }

    public b getStatus() {
        b bVarJ = b.j(this.status_);
        return bVarJ == null ? b.UNRECOGNIZED : bVarJ;
    }

    public int getStatusValue() {
        return this.status_;
    }

    public String getUrl() {
        return this.url_;
    }

    public AbstractC2383g getUrlBytes() {
        return AbstractC2383g.N(this.url_);
    }

    public static a newBuilder(LivekitEgress$StreamInfo livekitEgress$StreamInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitEgress$StreamInfo);
    }

    public static LivekitEgress$StreamInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitEgress$StreamInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitEgress$StreamInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitEgress$StreamInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitEgress$StreamInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitEgress$StreamInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitEgress$StreamInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitEgress$StreamInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitEgress$StreamInfo parseFrom(byte[] bArr) {
        return (LivekitEgress$StreamInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitEgress$StreamInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitEgress$StreamInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitEgress$StreamInfo parseFrom(InputStream inputStream) {
        return (LivekitEgress$StreamInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitEgress$StreamInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitEgress$StreamInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitEgress$StreamInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitEgress$StreamInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitEgress$StreamInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitEgress$StreamInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
