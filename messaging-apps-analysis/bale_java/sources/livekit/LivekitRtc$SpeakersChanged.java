package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import ir.nasim.YE3;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class LivekitRtc$SpeakersChanged extends GeneratedMessageLite implements U64 {
    private static final LivekitRtc$SpeakersChanged DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int SPEAKERS_FIELD_NUMBER = 1;
    private B.j speakers_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(s sVar) {
            this();
        }

        private a() {
            super(LivekitRtc$SpeakersChanged.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitRtc$SpeakersChanged livekitRtc$SpeakersChanged = new LivekitRtc$SpeakersChanged();
        DEFAULT_INSTANCE = livekitRtc$SpeakersChanged;
        GeneratedMessageLite.registerDefaultInstance(LivekitRtc$SpeakersChanged.class, livekitRtc$SpeakersChanged);
    }

    private LivekitRtc$SpeakersChanged() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllSpeakers(Iterable<? extends LivekitModels$SpeakerInfo> iterable) {
        ensureSpeakersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.speakers_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSpeakers(LivekitModels$SpeakerInfo livekitModels$SpeakerInfo) {
        livekitModels$SpeakerInfo.getClass();
        ensureSpeakersIsMutable();
        this.speakers_.add(livekitModels$SpeakerInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSpeakers() {
        this.speakers_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureSpeakersIsMutable() {
        B.j jVar = this.speakers_;
        if (jVar.u()) {
            return;
        }
        this.speakers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitRtc$SpeakersChanged getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitRtc$SpeakersChanged parseDelimitedFrom(InputStream inputStream) {
        return (LivekitRtc$SpeakersChanged) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$SpeakersChanged parseFrom(ByteBuffer byteBuffer) {
        return (LivekitRtc$SpeakersChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeSpeakers(int i) {
        ensureSpeakersIsMutable();
        this.speakers_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSpeakers(int i, LivekitModels$SpeakerInfo livekitModels$SpeakerInfo) {
        livekitModels$SpeakerInfo.getClass();
        ensureSpeakersIsMutable();
        this.speakers_.set(i, livekitModels$SpeakerInfo);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        s sVar = null;
        switch (s.a[gVar.ordinal()]) {
            case 1:
                return new LivekitRtc$SpeakersChanged();
            case 2:
                return new a(sVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"speakers_", LivekitModels$SpeakerInfo.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitRtc$SpeakersChanged.class) {
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

    public LivekitModels$SpeakerInfo getSpeakers(int i) {
        return (LivekitModels$SpeakerInfo) this.speakers_.get(i);
    }

    public int getSpeakersCount() {
        return this.speakers_.size();
    }

    public List<LivekitModels$SpeakerInfo> getSpeakersList() {
        return this.speakers_;
    }

    public YE3 getSpeakersOrBuilder(int i) {
        return (YE3) this.speakers_.get(i);
    }

    public List<? extends YE3> getSpeakersOrBuilderList() {
        return this.speakers_;
    }

    public static a newBuilder(LivekitRtc$SpeakersChanged livekitRtc$SpeakersChanged) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitRtc$SpeakersChanged);
    }

    public static LivekitRtc$SpeakersChanged parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$SpeakersChanged) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$SpeakersChanged parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitRtc$SpeakersChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitRtc$SpeakersChanged parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitRtc$SpeakersChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSpeakers(int i, LivekitModels$SpeakerInfo livekitModels$SpeakerInfo) {
        livekitModels$SpeakerInfo.getClass();
        ensureSpeakersIsMutable();
        this.speakers_.add(i, livekitModels$SpeakerInfo);
    }

    public static LivekitRtc$SpeakersChanged parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitRtc$SpeakersChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitRtc$SpeakersChanged parseFrom(byte[] bArr) {
        return (LivekitRtc$SpeakersChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitRtc$SpeakersChanged parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitRtc$SpeakersChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitRtc$SpeakersChanged parseFrom(InputStream inputStream) {
        return (LivekitRtc$SpeakersChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$SpeakersChanged parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$SpeakersChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$SpeakersChanged parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitRtc$SpeakersChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitRtc$SpeakersChanged parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitRtc$SpeakersChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
