package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.DF3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitSip$SIPStatus extends GeneratedMessageLite implements U64 {
    public static final int CODE_FIELD_NUMBER = 1;
    private static final LivekitSip$SIPStatus DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int STATUS_FIELD_NUMBER = 2;
    private int code_;
    private String status_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(t tVar) {
            this();
        }

        private a() {
            super(LivekitSip$SIPStatus.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitSip$SIPStatus livekitSip$SIPStatus = new LivekitSip$SIPStatus();
        DEFAULT_INSTANCE = livekitSip$SIPStatus;
        GeneratedMessageLite.registerDefaultInstance(LivekitSip$SIPStatus.class, livekitSip$SIPStatus);
    }

    private LivekitSip$SIPStatus() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCode() {
        this.code_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStatus() {
        this.status_ = getDefaultInstance().getStatus();
    }

    public static LivekitSip$SIPStatus getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitSip$SIPStatus parseDelimitedFrom(InputStream inputStream) {
        return (LivekitSip$SIPStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitSip$SIPStatus parseFrom(ByteBuffer byteBuffer) {
        return (LivekitSip$SIPStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCode(DF3 df3) {
        this.code_ = df3.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCodeValue(int i) {
        this.code_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatus(String str) {
        str.getClass();
        this.status_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatusBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.status_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        t tVar = null;
        switch (t.a[gVar.ordinal()]) {
            case 1:
                return new LivekitSip$SIPStatus();
            case 2:
                return new a(tVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002Ȉ", new Object[]{"code_", "status_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitSip$SIPStatus.class) {
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

    public DF3 getCode() {
        DF3 df3J = DF3.j(this.code_);
        return df3J == null ? DF3.UNRECOGNIZED : df3J;
    }

    public int getCodeValue() {
        return this.code_;
    }

    public String getStatus() {
        return this.status_;
    }

    public AbstractC2383g getStatusBytes() {
        return AbstractC2383g.N(this.status_);
    }

    public static a newBuilder(LivekitSip$SIPStatus livekitSip$SIPStatus) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitSip$SIPStatus);
    }

    public static LivekitSip$SIPStatus parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitSip$SIPStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitSip$SIPStatus parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitSip$SIPStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitSip$SIPStatus parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitSip$SIPStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitSip$SIPStatus parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitSip$SIPStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitSip$SIPStatus parseFrom(byte[] bArr) {
        return (LivekitSip$SIPStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitSip$SIPStatus parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitSip$SIPStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitSip$SIPStatus parseFrom(InputStream inputStream) {
        return (LivekitSip$SIPStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitSip$SIPStatus parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitSip$SIPStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitSip$SIPStatus parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitSip$SIPStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitSip$SIPStatus parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitSip$SIPStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
