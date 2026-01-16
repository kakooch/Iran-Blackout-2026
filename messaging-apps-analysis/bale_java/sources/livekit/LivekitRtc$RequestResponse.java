package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitRtc$RequestResponse extends GeneratedMessageLite implements U64 {
    private static final LivekitRtc$RequestResponse DEFAULT_INSTANCE;
    public static final int MESSAGE_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int REASON_FIELD_NUMBER = 2;
    public static final int REQUEST_ID_FIELD_NUMBER = 1;
    private String message_ = "";
    private int reason_;
    private int requestId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(s sVar) {
            this();
        }

        private a() {
            super(LivekitRtc$RequestResponse.DEFAULT_INSTANCE);
        }
    }

    public enum b implements B.c {
        OK(0),
        NOT_FOUND(1),
        NOT_ALLOWED(2),
        LIMIT_EXCEEDED(3),
        UNRECOGNIZED(-1);

        private static final B.d g = new a();
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
                return OK;
            }
            if (i == 1) {
                return NOT_FOUND;
            }
            if (i == 2) {
                return NOT_ALLOWED;
            }
            if (i != 3) {
                return null;
            }
            return LIMIT_EXCEEDED;
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
        LivekitRtc$RequestResponse livekitRtc$RequestResponse = new LivekitRtc$RequestResponse();
        DEFAULT_INSTANCE = livekitRtc$RequestResponse;
        GeneratedMessageLite.registerDefaultInstance(LivekitRtc$RequestResponse.class, livekitRtc$RequestResponse);
    }

    private LivekitRtc$RequestResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMessage() {
        this.message_ = getDefaultInstance().getMessage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearReason() {
        this.reason_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRequestId() {
        this.requestId_ = 0;
    }

    public static LivekitRtc$RequestResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitRtc$RequestResponse parseDelimitedFrom(InputStream inputStream) {
        return (LivekitRtc$RequestResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$RequestResponse parseFrom(ByteBuffer byteBuffer) {
        return (LivekitRtc$RequestResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMessage(String str) {
        str.getClass();
        this.message_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMessageBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.message_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReason(b bVar) {
        this.reason_ = bVar.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReasonValue(int i) {
        this.reason_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRequestId(int i) {
        this.requestId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        s sVar = null;
        switch (s.a[gVar.ordinal()]) {
            case 1:
                return new LivekitRtc$RequestResponse();
            case 2:
                return new a(sVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\f\u0003Ȉ", new Object[]{"requestId_", "reason_", "message_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitRtc$RequestResponse.class) {
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

    public String getMessage() {
        return this.message_;
    }

    public AbstractC2383g getMessageBytes() {
        return AbstractC2383g.N(this.message_);
    }

    public b getReason() {
        b bVarJ = b.j(this.reason_);
        return bVarJ == null ? b.UNRECOGNIZED : bVarJ;
    }

    public int getReasonValue() {
        return this.reason_;
    }

    public int getRequestId() {
        return this.requestId_;
    }

    public static a newBuilder(LivekitRtc$RequestResponse livekitRtc$RequestResponse) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitRtc$RequestResponse);
    }

    public static LivekitRtc$RequestResponse parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$RequestResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$RequestResponse parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitRtc$RequestResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitRtc$RequestResponse parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitRtc$RequestResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitRtc$RequestResponse parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitRtc$RequestResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitRtc$RequestResponse parseFrom(byte[] bArr) {
        return (LivekitRtc$RequestResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitRtc$RequestResponse parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitRtc$RequestResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitRtc$RequestResponse parseFrom(InputStream inputStream) {
        return (LivekitRtc$RequestResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$RequestResponse parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$RequestResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$RequestResponse parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitRtc$RequestResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitRtc$RequestResponse parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitRtc$RequestResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
