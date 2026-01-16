package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitRtc$MuteTrackRequest extends GeneratedMessageLite implements U64 {
    private static final LivekitRtc$MuteTrackRequest DEFAULT_INSTANCE;
    public static final int MUTED_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int SID_FIELD_NUMBER = 1;
    private boolean muted_;
    private String sid_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(s sVar) {
            this();
        }

        public a A(boolean z) {
            q();
            ((LivekitRtc$MuteTrackRequest) this.b).setMuted(z);
            return this;
        }

        public a B(String str) {
            q();
            ((LivekitRtc$MuteTrackRequest) this.b).setSid(str);
            return this;
        }

        private a() {
            super(LivekitRtc$MuteTrackRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitRtc$MuteTrackRequest livekitRtc$MuteTrackRequest = new LivekitRtc$MuteTrackRequest();
        DEFAULT_INSTANCE = livekitRtc$MuteTrackRequest;
        GeneratedMessageLite.registerDefaultInstance(LivekitRtc$MuteTrackRequest.class, livekitRtc$MuteTrackRequest);
    }

    private LivekitRtc$MuteTrackRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMuted() {
        this.muted_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSid() {
        this.sid_ = getDefaultInstance().getSid();
    }

    public static LivekitRtc$MuteTrackRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitRtc$MuteTrackRequest parseDelimitedFrom(InputStream inputStream) {
        return (LivekitRtc$MuteTrackRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$MuteTrackRequest parseFrom(ByteBuffer byteBuffer) {
        return (LivekitRtc$MuteTrackRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMuted(boolean z) {
        this.muted_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSid(String str) {
        str.getClass();
        this.sid_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSidBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.sid_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        s sVar = null;
        switch (s.a[gVar.ordinal()]) {
            case 1:
                return new LivekitRtc$MuteTrackRequest();
            case 2:
                return new a(sVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\u0007", new Object[]{"sid_", "muted_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitRtc$MuteTrackRequest.class) {
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

    public boolean getMuted() {
        return this.muted_;
    }

    public String getSid() {
        return this.sid_;
    }

    public AbstractC2383g getSidBytes() {
        return AbstractC2383g.N(this.sid_);
    }

    public static a newBuilder(LivekitRtc$MuteTrackRequest livekitRtc$MuteTrackRequest) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitRtc$MuteTrackRequest);
    }

    public static LivekitRtc$MuteTrackRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$MuteTrackRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$MuteTrackRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitRtc$MuteTrackRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitRtc$MuteTrackRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitRtc$MuteTrackRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitRtc$MuteTrackRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitRtc$MuteTrackRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitRtc$MuteTrackRequest parseFrom(byte[] bArr) {
        return (LivekitRtc$MuteTrackRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitRtc$MuteTrackRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitRtc$MuteTrackRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitRtc$MuteTrackRequest parseFrom(InputStream inputStream) {
        return (LivekitRtc$MuteTrackRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$MuteTrackRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$MuteTrackRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$MuteTrackRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitRtc$MuteTrackRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitRtc$MuteTrackRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitRtc$MuteTrackRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
