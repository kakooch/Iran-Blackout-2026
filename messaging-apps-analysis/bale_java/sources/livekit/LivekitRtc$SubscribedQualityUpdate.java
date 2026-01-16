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
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class LivekitRtc$SubscribedQualityUpdate extends GeneratedMessageLite implements U64 {
    private static final LivekitRtc$SubscribedQualityUpdate DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int SUBSCRIBED_CODECS_FIELD_NUMBER = 3;
    public static final int SUBSCRIBED_QUALITIES_FIELD_NUMBER = 2;
    public static final int TRACK_SID_FIELD_NUMBER = 1;
    private String trackSid_ = "";
    private B.j subscribedQualities_ = GeneratedMessageLite.emptyProtobufList();
    private B.j subscribedCodecs_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(s sVar) {
            this();
        }

        private a() {
            super(LivekitRtc$SubscribedQualityUpdate.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitRtc$SubscribedQualityUpdate livekitRtc$SubscribedQualityUpdate = new LivekitRtc$SubscribedQualityUpdate();
        DEFAULT_INSTANCE = livekitRtc$SubscribedQualityUpdate;
        GeneratedMessageLite.registerDefaultInstance(LivekitRtc$SubscribedQualityUpdate.class, livekitRtc$SubscribedQualityUpdate);
    }

    private LivekitRtc$SubscribedQualityUpdate() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllSubscribedCodecs(Iterable<? extends LivekitRtc$SubscribedCodec> iterable) {
        ensureSubscribedCodecsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.subscribedCodecs_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllSubscribedQualities(Iterable<? extends LivekitRtc$SubscribedQuality> iterable) {
        ensureSubscribedQualitiesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.subscribedQualities_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSubscribedCodecs(LivekitRtc$SubscribedCodec livekitRtc$SubscribedCodec) {
        livekitRtc$SubscribedCodec.getClass();
        ensureSubscribedCodecsIsMutable();
        this.subscribedCodecs_.add(livekitRtc$SubscribedCodec);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSubscribedQualities(LivekitRtc$SubscribedQuality livekitRtc$SubscribedQuality) {
        livekitRtc$SubscribedQuality.getClass();
        ensureSubscribedQualitiesIsMutable();
        this.subscribedQualities_.add(livekitRtc$SubscribedQuality);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSubscribedCodecs() {
        this.subscribedCodecs_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSubscribedQualities() {
        this.subscribedQualities_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTrackSid() {
        this.trackSid_ = getDefaultInstance().getTrackSid();
    }

    private void ensureSubscribedCodecsIsMutable() {
        B.j jVar = this.subscribedCodecs_;
        if (jVar.u()) {
            return;
        }
        this.subscribedCodecs_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureSubscribedQualitiesIsMutable() {
        B.j jVar = this.subscribedQualities_;
        if (jVar.u()) {
            return;
        }
        this.subscribedQualities_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitRtc$SubscribedQualityUpdate getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitRtc$SubscribedQualityUpdate parseDelimitedFrom(InputStream inputStream) {
        return (LivekitRtc$SubscribedQualityUpdate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$SubscribedQualityUpdate parseFrom(ByteBuffer byteBuffer) {
        return (LivekitRtc$SubscribedQualityUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeSubscribedCodecs(int i) {
        ensureSubscribedCodecsIsMutable();
        this.subscribedCodecs_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeSubscribedQualities(int i) {
        ensureSubscribedQualitiesIsMutable();
        this.subscribedQualities_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSubscribedCodecs(int i, LivekitRtc$SubscribedCodec livekitRtc$SubscribedCodec) {
        livekitRtc$SubscribedCodec.getClass();
        ensureSubscribedCodecsIsMutable();
        this.subscribedCodecs_.set(i, livekitRtc$SubscribedCodec);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSubscribedQualities(int i, LivekitRtc$SubscribedQuality livekitRtc$SubscribedQuality) {
        livekitRtc$SubscribedQuality.getClass();
        ensureSubscribedQualitiesIsMutable();
        this.subscribedQualities_.set(i, livekitRtc$SubscribedQuality);
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
                return new LivekitRtc$SubscribedQualityUpdate();
            case 2:
                return new a(sVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0002\u0000\u0001Ȉ\u0002\u001b\u0003\u001b", new Object[]{"trackSid_", "subscribedQualities_", LivekitRtc$SubscribedQuality.class, "subscribedCodecs_", LivekitRtc$SubscribedCodec.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitRtc$SubscribedQualityUpdate.class) {
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

    public LivekitRtc$SubscribedCodec getSubscribedCodecs(int i) {
        return (LivekitRtc$SubscribedCodec) this.subscribedCodecs_.get(i);
    }

    public int getSubscribedCodecsCount() {
        return this.subscribedCodecs_.size();
    }

    public List<LivekitRtc$SubscribedCodec> getSubscribedCodecsList() {
        return this.subscribedCodecs_;
    }

    public InterfaceC19970rF3 getSubscribedCodecsOrBuilder(int i) {
        return (InterfaceC19970rF3) this.subscribedCodecs_.get(i);
    }

    public List<? extends InterfaceC19970rF3> getSubscribedCodecsOrBuilderList() {
        return this.subscribedCodecs_;
    }

    @Deprecated
    public LivekitRtc$SubscribedQuality getSubscribedQualities(int i) {
        return (LivekitRtc$SubscribedQuality) this.subscribedQualities_.get(i);
    }

    @Deprecated
    public int getSubscribedQualitiesCount() {
        return this.subscribedQualities_.size();
    }

    @Deprecated
    public List<LivekitRtc$SubscribedQuality> getSubscribedQualitiesList() {
        return this.subscribedQualities_;
    }

    @Deprecated
    public InterfaceC20579sF3 getSubscribedQualitiesOrBuilder(int i) {
        return (InterfaceC20579sF3) this.subscribedQualities_.get(i);
    }

    @Deprecated
    public List<? extends InterfaceC20579sF3> getSubscribedQualitiesOrBuilderList() {
        return this.subscribedQualities_;
    }

    public String getTrackSid() {
        return this.trackSid_;
    }

    public AbstractC2383g getTrackSidBytes() {
        return AbstractC2383g.N(this.trackSid_);
    }

    public static a newBuilder(LivekitRtc$SubscribedQualityUpdate livekitRtc$SubscribedQualityUpdate) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitRtc$SubscribedQualityUpdate);
    }

    public static LivekitRtc$SubscribedQualityUpdate parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$SubscribedQualityUpdate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$SubscribedQualityUpdate parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitRtc$SubscribedQualityUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitRtc$SubscribedQualityUpdate parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitRtc$SubscribedQualityUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSubscribedCodecs(int i, LivekitRtc$SubscribedCodec livekitRtc$SubscribedCodec) {
        livekitRtc$SubscribedCodec.getClass();
        ensureSubscribedCodecsIsMutable();
        this.subscribedCodecs_.add(i, livekitRtc$SubscribedCodec);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSubscribedQualities(int i, LivekitRtc$SubscribedQuality livekitRtc$SubscribedQuality) {
        livekitRtc$SubscribedQuality.getClass();
        ensureSubscribedQualitiesIsMutable();
        this.subscribedQualities_.add(i, livekitRtc$SubscribedQuality);
    }

    public static LivekitRtc$SubscribedQualityUpdate parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitRtc$SubscribedQualityUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitRtc$SubscribedQualityUpdate parseFrom(byte[] bArr) {
        return (LivekitRtc$SubscribedQualityUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitRtc$SubscribedQualityUpdate parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitRtc$SubscribedQualityUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitRtc$SubscribedQualityUpdate parseFrom(InputStream inputStream) {
        return (LivekitRtc$SubscribedQualityUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$SubscribedQualityUpdate parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$SubscribedQualityUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$SubscribedQualityUpdate parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitRtc$SubscribedQualityUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitRtc$SubscribedQualityUpdate parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitRtc$SubscribedQualityUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
