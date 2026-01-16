package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC17606nF3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitRtc$TrickleRequest extends GeneratedMessageLite implements U64 {
    public static final int CANDIDATEINIT_FIELD_NUMBER = 1;
    private static final LivekitRtc$TrickleRequest DEFAULT_INSTANCE;
    public static final int FINAL_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int TARGET_FIELD_NUMBER = 2;
    private String candidateInit_ = "";
    private boolean final_;
    private int target_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(s sVar) {
            this();
        }

        public a A(String str) {
            q();
            ((LivekitRtc$TrickleRequest) this.b).setCandidateInit(str);
            return this;
        }

        public a B(EnumC17606nF3 enumC17606nF3) {
            q();
            ((LivekitRtc$TrickleRequest) this.b).setTarget(enumC17606nF3);
            return this;
        }

        private a() {
            super(LivekitRtc$TrickleRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitRtc$TrickleRequest livekitRtc$TrickleRequest = new LivekitRtc$TrickleRequest();
        DEFAULT_INSTANCE = livekitRtc$TrickleRequest;
        GeneratedMessageLite.registerDefaultInstance(LivekitRtc$TrickleRequest.class, livekitRtc$TrickleRequest);
    }

    private LivekitRtc$TrickleRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCandidateInit() {
        this.candidateInit_ = getDefaultInstance().getCandidateInit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFinal() {
        this.final_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTarget() {
        this.target_ = 0;
    }

    public static LivekitRtc$TrickleRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitRtc$TrickleRequest parseDelimitedFrom(InputStream inputStream) {
        return (LivekitRtc$TrickleRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$TrickleRequest parseFrom(ByteBuffer byteBuffer) {
        return (LivekitRtc$TrickleRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCandidateInit(String str) {
        str.getClass();
        this.candidateInit_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCandidateInitBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.candidateInit_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFinal(boolean z) {
        this.final_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTarget(EnumC17606nF3 enumC17606nF3) {
        this.target_ = enumC17606nF3.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTargetValue(int i) {
        this.target_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        s sVar = null;
        switch (s.a[gVar.ordinal()]) {
            case 1:
                return new LivekitRtc$TrickleRequest();
            case 2:
                return new a(sVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u0007", new Object[]{"candidateInit_", "target_", "final_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitRtc$TrickleRequest.class) {
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

    public String getCandidateInit() {
        return this.candidateInit_;
    }

    public AbstractC2383g getCandidateInitBytes() {
        return AbstractC2383g.N(this.candidateInit_);
    }

    public boolean getFinal() {
        return this.final_;
    }

    public EnumC17606nF3 getTarget() {
        EnumC17606nF3 enumC17606nF3J = EnumC17606nF3.j(this.target_);
        return enumC17606nF3J == null ? EnumC17606nF3.UNRECOGNIZED : enumC17606nF3J;
    }

    public int getTargetValue() {
        return this.target_;
    }

    public static a newBuilder(LivekitRtc$TrickleRequest livekitRtc$TrickleRequest) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitRtc$TrickleRequest);
    }

    public static LivekitRtc$TrickleRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$TrickleRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$TrickleRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitRtc$TrickleRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitRtc$TrickleRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitRtc$TrickleRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitRtc$TrickleRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitRtc$TrickleRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitRtc$TrickleRequest parseFrom(byte[] bArr) {
        return (LivekitRtc$TrickleRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitRtc$TrickleRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitRtc$TrickleRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitRtc$TrickleRequest parseFrom(InputStream inputStream) {
        return (LivekitRtc$TrickleRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$TrickleRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$TrickleRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$TrickleRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitRtc$TrickleRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitRtc$TrickleRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitRtc$TrickleRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
