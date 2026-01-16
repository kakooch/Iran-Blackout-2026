package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC18197oF3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitRtc$SimulcastCodec extends GeneratedMessageLite implements InterfaceC18197oF3 {
    public static final int CID_FIELD_NUMBER = 2;
    public static final int CODEC_FIELD_NUMBER = 1;
    private static final LivekitRtc$SimulcastCodec DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private String codec_ = "";
    private String cid_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC18197oF3 {
        /* synthetic */ a(s sVar) {
            this();
        }

        public a A(String str) {
            q();
            ((LivekitRtc$SimulcastCodec) this.b).setCid(str);
            return this;
        }

        public a B(String str) {
            q();
            ((LivekitRtc$SimulcastCodec) this.b).setCodec(str);
            return this;
        }

        private a() {
            super(LivekitRtc$SimulcastCodec.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitRtc$SimulcastCodec livekitRtc$SimulcastCodec = new LivekitRtc$SimulcastCodec();
        DEFAULT_INSTANCE = livekitRtc$SimulcastCodec;
        GeneratedMessageLite.registerDefaultInstance(LivekitRtc$SimulcastCodec.class, livekitRtc$SimulcastCodec);
    }

    private LivekitRtc$SimulcastCodec() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCid() {
        this.cid_ = getDefaultInstance().getCid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCodec() {
        this.codec_ = getDefaultInstance().getCodec();
    }

    public static LivekitRtc$SimulcastCodec getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitRtc$SimulcastCodec parseDelimitedFrom(InputStream inputStream) {
        return (LivekitRtc$SimulcastCodec) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$SimulcastCodec parseFrom(ByteBuffer byteBuffer) {
        return (LivekitRtc$SimulcastCodec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCid(String str) {
        str.getClass();
        this.cid_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCidBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.cid_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCodec(String str) {
        str.getClass();
        this.codec_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCodecBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.codec_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        s sVar = null;
        switch (s.a[gVar.ordinal()]) {
            case 1:
                return new LivekitRtc$SimulcastCodec();
            case 2:
                return new a(sVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"codec_", "cid_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitRtc$SimulcastCodec.class) {
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

    public String getCid() {
        return this.cid_;
    }

    public AbstractC2383g getCidBytes() {
        return AbstractC2383g.N(this.cid_);
    }

    public String getCodec() {
        return this.codec_;
    }

    public AbstractC2383g getCodecBytes() {
        return AbstractC2383g.N(this.codec_);
    }

    public static a newBuilder(LivekitRtc$SimulcastCodec livekitRtc$SimulcastCodec) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitRtc$SimulcastCodec);
    }

    public static LivekitRtc$SimulcastCodec parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$SimulcastCodec) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$SimulcastCodec parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitRtc$SimulcastCodec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitRtc$SimulcastCodec parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitRtc$SimulcastCodec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitRtc$SimulcastCodec parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitRtc$SimulcastCodec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitRtc$SimulcastCodec parseFrom(byte[] bArr) {
        return (LivekitRtc$SimulcastCodec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitRtc$SimulcastCodec parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitRtc$SimulcastCodec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitRtc$SimulcastCodec parseFrom(InputStream inputStream) {
        return (LivekitRtc$SimulcastCodec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$SimulcastCodec parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$SimulcastCodec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$SimulcastCodec parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitRtc$SimulcastCodec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitRtc$SimulcastCodec parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitRtc$SimulcastCodec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
