package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC19970rF3;
import ir.nasim.InterfaceC20579sF3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class LivekitRtc$SubscribedCodec extends GeneratedMessageLite implements InterfaceC19970rF3 {
    public static final int CODEC_FIELD_NUMBER = 1;
    private static final LivekitRtc$SubscribedCodec DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int QUALITIES_FIELD_NUMBER = 2;
    private String codec_ = "";
    private B.j qualities_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements InterfaceC19970rF3 {
        /* synthetic */ a(s sVar) {
            this();
        }

        private a() {
            super(LivekitRtc$SubscribedCodec.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitRtc$SubscribedCodec livekitRtc$SubscribedCodec = new LivekitRtc$SubscribedCodec();
        DEFAULT_INSTANCE = livekitRtc$SubscribedCodec;
        GeneratedMessageLite.registerDefaultInstance(LivekitRtc$SubscribedCodec.class, livekitRtc$SubscribedCodec);
    }

    private LivekitRtc$SubscribedCodec() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllQualities(Iterable<? extends LivekitRtc$SubscribedQuality> iterable) {
        ensureQualitiesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.qualities_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addQualities(LivekitRtc$SubscribedQuality livekitRtc$SubscribedQuality) {
        livekitRtc$SubscribedQuality.getClass();
        ensureQualitiesIsMutable();
        this.qualities_.add(livekitRtc$SubscribedQuality);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCodec() {
        this.codec_ = getDefaultInstance().getCodec();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearQualities() {
        this.qualities_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureQualitiesIsMutable() {
        B.j jVar = this.qualities_;
        if (jVar.u()) {
            return;
        }
        this.qualities_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitRtc$SubscribedCodec getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitRtc$SubscribedCodec parseDelimitedFrom(InputStream inputStream) {
        return (LivekitRtc$SubscribedCodec) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$SubscribedCodec parseFrom(ByteBuffer byteBuffer) {
        return (LivekitRtc$SubscribedCodec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeQualities(int i) {
        ensureQualitiesIsMutable();
        this.qualities_.remove(i);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void setQualities(int i, LivekitRtc$SubscribedQuality livekitRtc$SubscribedQuality) {
        livekitRtc$SubscribedQuality.getClass();
        ensureQualitiesIsMutable();
        this.qualities_.set(i, livekitRtc$SubscribedQuality);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        s sVar = null;
        switch (s.a[gVar.ordinal()]) {
            case 1:
                return new LivekitRtc$SubscribedCodec();
            case 2:
                return new a(sVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"codec_", "qualities_", LivekitRtc$SubscribedQuality.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitRtc$SubscribedCodec.class) {
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

    public String getCodec() {
        return this.codec_;
    }

    public AbstractC2383g getCodecBytes() {
        return AbstractC2383g.N(this.codec_);
    }

    public LivekitRtc$SubscribedQuality getQualities(int i) {
        return (LivekitRtc$SubscribedQuality) this.qualities_.get(i);
    }

    public int getQualitiesCount() {
        return this.qualities_.size();
    }

    public List<LivekitRtc$SubscribedQuality> getQualitiesList() {
        return this.qualities_;
    }

    public InterfaceC20579sF3 getQualitiesOrBuilder(int i) {
        return (InterfaceC20579sF3) this.qualities_.get(i);
    }

    public List<? extends InterfaceC20579sF3> getQualitiesOrBuilderList() {
        return this.qualities_;
    }

    public static a newBuilder(LivekitRtc$SubscribedCodec livekitRtc$SubscribedCodec) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitRtc$SubscribedCodec);
    }

    public static LivekitRtc$SubscribedCodec parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$SubscribedCodec) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$SubscribedCodec parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitRtc$SubscribedCodec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitRtc$SubscribedCodec parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitRtc$SubscribedCodec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addQualities(int i, LivekitRtc$SubscribedQuality livekitRtc$SubscribedQuality) {
        livekitRtc$SubscribedQuality.getClass();
        ensureQualitiesIsMutable();
        this.qualities_.add(i, livekitRtc$SubscribedQuality);
    }

    public static LivekitRtc$SubscribedCodec parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitRtc$SubscribedCodec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitRtc$SubscribedCodec parseFrom(byte[] bArr) {
        return (LivekitRtc$SubscribedCodec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitRtc$SubscribedCodec parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitRtc$SubscribedCodec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitRtc$SubscribedCodec parseFrom(InputStream inputStream) {
        return (LivekitRtc$SubscribedCodec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$SubscribedCodec parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$SubscribedCodec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$SubscribedCodec parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitRtc$SubscribedCodec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitRtc$SubscribedCodec parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitRtc$SubscribedCodec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
