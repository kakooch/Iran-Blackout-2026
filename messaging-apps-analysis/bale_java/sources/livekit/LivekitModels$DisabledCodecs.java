package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.PE3;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class LivekitModels$DisabledCodecs extends GeneratedMessageLite implements U64 {
    public static final int CODECS_FIELD_NUMBER = 1;
    private static final LivekitModels$DisabledCodecs DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PUBLISH_FIELD_NUMBER = 2;
    private B.j codecs_ = GeneratedMessageLite.emptyProtobufList();
    private B.j publish_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(o oVar) {
            this();
        }

        private a() {
            super(LivekitModels$DisabledCodecs.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitModels$DisabledCodecs livekitModels$DisabledCodecs = new LivekitModels$DisabledCodecs();
        DEFAULT_INSTANCE = livekitModels$DisabledCodecs;
        GeneratedMessageLite.registerDefaultInstance(LivekitModels$DisabledCodecs.class, livekitModels$DisabledCodecs);
    }

    private LivekitModels$DisabledCodecs() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllCodecs(Iterable<? extends LivekitModels$Codec> iterable) {
        ensureCodecsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.codecs_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllPublish(Iterable<? extends LivekitModels$Codec> iterable) {
        ensurePublishIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.publish_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addCodecs(LivekitModels$Codec livekitModels$Codec) {
        livekitModels$Codec.getClass();
        ensureCodecsIsMutable();
        this.codecs_.add(livekitModels$Codec);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPublish(LivekitModels$Codec livekitModels$Codec) {
        livekitModels$Codec.getClass();
        ensurePublishIsMutable();
        this.publish_.add(livekitModels$Codec);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCodecs() {
        this.codecs_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPublish() {
        this.publish_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureCodecsIsMutable() {
        B.j jVar = this.codecs_;
        if (jVar.u()) {
            return;
        }
        this.codecs_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensurePublishIsMutable() {
        B.j jVar = this.publish_;
        if (jVar.u()) {
            return;
        }
        this.publish_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitModels$DisabledCodecs getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitModels$DisabledCodecs parseDelimitedFrom(InputStream inputStream) {
        return (LivekitModels$DisabledCodecs) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$DisabledCodecs parseFrom(ByteBuffer byteBuffer) {
        return (LivekitModels$DisabledCodecs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeCodecs(int i) {
        ensureCodecsIsMutable();
        this.codecs_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removePublish(int i) {
        ensurePublishIsMutable();
        this.publish_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCodecs(int i, LivekitModels$Codec livekitModels$Codec) {
        livekitModels$Codec.getClass();
        ensureCodecsIsMutable();
        this.codecs_.set(i, livekitModels$Codec);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPublish(int i, LivekitModels$Codec livekitModels$Codec) {
        livekitModels$Codec.getClass();
        ensurePublishIsMutable();
        this.publish_.set(i, livekitModels$Codec);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        o oVar = null;
        switch (o.a[gVar.ordinal()]) {
            case 1:
                return new LivekitModels$DisabledCodecs();
            case 2:
                return new a(oVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0002\u0000\u0001\u001b\u0002\u001b", new Object[]{"codecs_", LivekitModels$Codec.class, "publish_", LivekitModels$Codec.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitModels$DisabledCodecs.class) {
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

    public LivekitModels$Codec getCodecs(int i) {
        return (LivekitModels$Codec) this.codecs_.get(i);
    }

    public int getCodecsCount() {
        return this.codecs_.size();
    }

    public List<LivekitModels$Codec> getCodecsList() {
        return this.codecs_;
    }

    public PE3 getCodecsOrBuilder(int i) {
        return (PE3) this.codecs_.get(i);
    }

    public List<? extends PE3> getCodecsOrBuilderList() {
        return this.codecs_;
    }

    public LivekitModels$Codec getPublish(int i) {
        return (LivekitModels$Codec) this.publish_.get(i);
    }

    public int getPublishCount() {
        return this.publish_.size();
    }

    public List<LivekitModels$Codec> getPublishList() {
        return this.publish_;
    }

    public PE3 getPublishOrBuilder(int i) {
        return (PE3) this.publish_.get(i);
    }

    public List<? extends PE3> getPublishOrBuilderList() {
        return this.publish_;
    }

    public static a newBuilder(LivekitModels$DisabledCodecs livekitModels$DisabledCodecs) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitModels$DisabledCodecs);
    }

    public static LivekitModels$DisabledCodecs parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$DisabledCodecs) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$DisabledCodecs parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitModels$DisabledCodecs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitModels$DisabledCodecs parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitModels$DisabledCodecs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addCodecs(int i, LivekitModels$Codec livekitModels$Codec) {
        livekitModels$Codec.getClass();
        ensureCodecsIsMutable();
        this.codecs_.add(i, livekitModels$Codec);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPublish(int i, LivekitModels$Codec livekitModels$Codec) {
        livekitModels$Codec.getClass();
        ensurePublishIsMutable();
        this.publish_.add(i, livekitModels$Codec);
    }

    public static LivekitModels$DisabledCodecs parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitModels$DisabledCodecs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitModels$DisabledCodecs parseFrom(byte[] bArr) {
        return (LivekitModels$DisabledCodecs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitModels$DisabledCodecs parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitModels$DisabledCodecs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitModels$DisabledCodecs parseFrom(InputStream inputStream) {
        return (LivekitModels$DisabledCodecs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$DisabledCodecs parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$DisabledCodecs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$DisabledCodecs parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitModels$DisabledCodecs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitModels$DisabledCodecs parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitModels$DisabledCodecs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
