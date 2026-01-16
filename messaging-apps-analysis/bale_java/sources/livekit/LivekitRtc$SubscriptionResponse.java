package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import ir.nasim.ZE3;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitRtc$SubscriptionResponse extends GeneratedMessageLite implements U64 {
    private static final LivekitRtc$SubscriptionResponse DEFAULT_INSTANCE;
    public static final int ERR_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int TRACK_SID_FIELD_NUMBER = 1;
    private int err_;
    private String trackSid_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(s sVar) {
            this();
        }

        private a() {
            super(LivekitRtc$SubscriptionResponse.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitRtc$SubscriptionResponse livekitRtc$SubscriptionResponse = new LivekitRtc$SubscriptionResponse();
        DEFAULT_INSTANCE = livekitRtc$SubscriptionResponse;
        GeneratedMessageLite.registerDefaultInstance(LivekitRtc$SubscriptionResponse.class, livekitRtc$SubscriptionResponse);
    }

    private LivekitRtc$SubscriptionResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearErr() {
        this.err_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTrackSid() {
        this.trackSid_ = getDefaultInstance().getTrackSid();
    }

    public static LivekitRtc$SubscriptionResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitRtc$SubscriptionResponse parseDelimitedFrom(InputStream inputStream) {
        return (LivekitRtc$SubscriptionResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$SubscriptionResponse parseFrom(ByteBuffer byteBuffer) {
        return (LivekitRtc$SubscriptionResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setErr(ZE3 ze3) {
        this.err_ = ze3.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setErrValue(int i) {
        this.err_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTrackSid(String str) {
        str.getClass();
        this.trackSid_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTrackSidBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.trackSid_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        s sVar = null;
        switch (s.a[gVar.ordinal()]) {
            case 1:
                return new LivekitRtc$SubscriptionResponse();
            case 2:
                return new a(sVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\f", new Object[]{"trackSid_", "err_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitRtc$SubscriptionResponse.class) {
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

    public ZE3 getErr() {
        ZE3 ze3J = ZE3.j(this.err_);
        return ze3J == null ? ZE3.UNRECOGNIZED : ze3J;
    }

    public int getErrValue() {
        return this.err_;
    }

    public String getTrackSid() {
        return this.trackSid_;
    }

    public AbstractC2383g getTrackSidBytes() {
        return AbstractC2383g.N(this.trackSid_);
    }

    public static a newBuilder(LivekitRtc$SubscriptionResponse livekitRtc$SubscriptionResponse) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitRtc$SubscriptionResponse);
    }

    public static LivekitRtc$SubscriptionResponse parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$SubscriptionResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$SubscriptionResponse parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitRtc$SubscriptionResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitRtc$SubscriptionResponse parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitRtc$SubscriptionResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitRtc$SubscriptionResponse parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitRtc$SubscriptionResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitRtc$SubscriptionResponse parseFrom(byte[] bArr) {
        return (LivekitRtc$SubscriptionResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitRtc$SubscriptionResponse parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitRtc$SubscriptionResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitRtc$SubscriptionResponse parseFrom(InputStream inputStream) {
        return (LivekitRtc$SubscriptionResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$SubscriptionResponse parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$SubscriptionResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$SubscriptionResponse parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitRtc$SubscriptionResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitRtc$SubscriptionResponse parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitRtc$SubscriptionResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
