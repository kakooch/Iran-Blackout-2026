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
import livekit.LivekitAgent$Job;

/* loaded from: classes8.dex */
public final class LivekitAgent$JobAssignment extends GeneratedMessageLite implements U64 {
    private static final LivekitAgent$JobAssignment DEFAULT_INSTANCE;
    public static final int JOB_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int TOKEN_FIELD_NUMBER = 3;
    public static final int URL_FIELD_NUMBER = 2;
    private int bitField0_;
    private LivekitAgent$Job job_;
    private String url_ = "";
    private String token_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(livekit.a aVar) {
            this();
        }

        private a() {
            super(LivekitAgent$JobAssignment.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitAgent$JobAssignment livekitAgent$JobAssignment = new LivekitAgent$JobAssignment();
        DEFAULT_INSTANCE = livekitAgent$JobAssignment;
        GeneratedMessageLite.registerDefaultInstance(LivekitAgent$JobAssignment.class, livekitAgent$JobAssignment);
    }

    private LivekitAgent$JobAssignment() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearJob() {
        this.job_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearToken() {
        this.token_ = getDefaultInstance().getToken();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUrl() {
        this.bitField0_ &= -2;
        this.url_ = getDefaultInstance().getUrl();
    }

    public static LivekitAgent$JobAssignment getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeJob(LivekitAgent$Job livekitAgent$Job) {
        livekitAgent$Job.getClass();
        LivekitAgent$Job livekitAgent$Job2 = this.job_;
        if (livekitAgent$Job2 == null || livekitAgent$Job2 == LivekitAgent$Job.getDefaultInstance()) {
            this.job_ = livekitAgent$Job;
        } else {
            this.job_ = (LivekitAgent$Job) ((LivekitAgent$Job.a) LivekitAgent$Job.newBuilder(this.job_).v(livekitAgent$Job)).j();
        }
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitAgent$JobAssignment parseDelimitedFrom(InputStream inputStream) {
        return (LivekitAgent$JobAssignment) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAgent$JobAssignment parseFrom(ByteBuffer byteBuffer) {
        return (LivekitAgent$JobAssignment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setJob(LivekitAgent$Job livekitAgent$Job) {
        livekitAgent$Job.getClass();
        this.job_ = livekitAgent$Job;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setToken(String str) {
        str.getClass();
        this.token_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTokenBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.token_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUrl(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.url_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUrlBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.url_ = abstractC2383g.f0();
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        livekit.a aVar = null;
        switch (livekit.a.a[gVar.ordinal()]) {
            case 1:
                return new LivekitAgent$JobAssignment();
            case 2:
                return new a(aVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002ለ\u0000\u0003Ȉ", new Object[]{"bitField0_", "job_", "url_", "token_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitAgent$JobAssignment.class) {
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

    public LivekitAgent$Job getJob() {
        LivekitAgent$Job livekitAgent$Job = this.job_;
        return livekitAgent$Job == null ? LivekitAgent$Job.getDefaultInstance() : livekitAgent$Job;
    }

    public String getToken() {
        return this.token_;
    }

    public AbstractC2383g getTokenBytes() {
        return AbstractC2383g.N(this.token_);
    }

    public String getUrl() {
        return this.url_;
    }

    public AbstractC2383g getUrlBytes() {
        return AbstractC2383g.N(this.url_);
    }

    public boolean hasJob() {
        return this.job_ != null;
    }

    public boolean hasUrl() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(LivekitAgent$JobAssignment livekitAgent$JobAssignment) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitAgent$JobAssignment);
    }

    public static LivekitAgent$JobAssignment parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAgent$JobAssignment) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAgent$JobAssignment parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitAgent$JobAssignment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitAgent$JobAssignment parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitAgent$JobAssignment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitAgent$JobAssignment parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitAgent$JobAssignment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitAgent$JobAssignment parseFrom(byte[] bArr) {
        return (LivekitAgent$JobAssignment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitAgent$JobAssignment parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitAgent$JobAssignment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitAgent$JobAssignment parseFrom(InputStream inputStream) {
        return (LivekitAgent$JobAssignment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAgent$JobAssignment parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAgent$JobAssignment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAgent$JobAssignment parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitAgent$JobAssignment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitAgent$JobAssignment parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitAgent$JobAssignment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
