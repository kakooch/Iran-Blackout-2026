package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.ME3;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public final class LivekitRtc$UpdateLocalAudioTrack extends GeneratedMessageLite implements U64 {
    private static final LivekitRtc$UpdateLocalAudioTrack DEFAULT_INSTANCE;
    public static final int FEATURES_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int TRACK_SID_FIELD_NUMBER = 1;
    private static final B.h.a features_converter_ = new a();
    private int featuresMemoizedSerializedSize;
    private String trackSid_ = "";
    private B.g features_ = GeneratedMessageLite.emptyIntList();

    class a implements B.h.a {
        a() {
        }

        @Override // com.google.protobuf.B.h.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ME3 a(Integer num) {
            ME3 me3J = ME3.j(num.intValue());
            return me3J == null ? ME3.UNRECOGNIZED : me3J;
        }
    }

    public static final class b extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ b(s sVar) {
            this();
        }

        public b A(Iterable iterable) {
            q();
            ((LivekitRtc$UpdateLocalAudioTrack) this.b).addAllFeatures(iterable);
            return this;
        }

        public b B(String str) {
            q();
            ((LivekitRtc$UpdateLocalAudioTrack) this.b).setTrackSid(str);
            return this;
        }

        private b() {
            super(LivekitRtc$UpdateLocalAudioTrack.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitRtc$UpdateLocalAudioTrack livekitRtc$UpdateLocalAudioTrack = new LivekitRtc$UpdateLocalAudioTrack();
        DEFAULT_INSTANCE = livekitRtc$UpdateLocalAudioTrack;
        GeneratedMessageLite.registerDefaultInstance(LivekitRtc$UpdateLocalAudioTrack.class, livekitRtc$UpdateLocalAudioTrack);
    }

    private LivekitRtc$UpdateLocalAudioTrack() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllFeatures(Iterable<? extends ME3> iterable) {
        ensureFeaturesIsMutable();
        Iterator<? extends ME3> it = iterable.iterator();
        while (it.hasNext()) {
            this.features_.b1(it.next().getNumber());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllFeaturesValue(Iterable<Integer> iterable) {
        ensureFeaturesIsMutable();
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext()) {
            this.features_.b1(it.next().intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFeatures(ME3 me3) {
        me3.getClass();
        ensureFeaturesIsMutable();
        this.features_.b1(me3.getNumber());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFeaturesValue(int i) {
        ensureFeaturesIsMutable();
        this.features_.b1(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFeatures() {
        this.features_ = GeneratedMessageLite.emptyIntList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTrackSid() {
        this.trackSid_ = getDefaultInstance().getTrackSid();
    }

    private void ensureFeaturesIsMutable() {
        B.g gVar = this.features_;
        if (gVar.u()) {
            return;
        }
        this.features_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    public static LivekitRtc$UpdateLocalAudioTrack getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitRtc$UpdateLocalAudioTrack parseDelimitedFrom(InputStream inputStream) {
        return (LivekitRtc$UpdateLocalAudioTrack) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$UpdateLocalAudioTrack parseFrom(ByteBuffer byteBuffer) {
        return (LivekitRtc$UpdateLocalAudioTrack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFeatures(int i, ME3 me3) {
        me3.getClass();
        ensureFeaturesIsMutable();
        this.features_.U(i, me3.getNumber());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFeaturesValue(int i, int i2) {
        ensureFeaturesIsMutable();
        this.features_.U(i, i2);
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
                return new LivekitRtc$UpdateLocalAudioTrack();
            case 2:
                return new b(sVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002,", new Object[]{"trackSid_", "features_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitRtc$UpdateLocalAudioTrack.class) {
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

    public ME3 getFeatures(int i) {
        ME3 me3J = ME3.j(this.features_.getInt(i));
        return me3J == null ? ME3.UNRECOGNIZED : me3J;
    }

    public int getFeaturesCount() {
        return this.features_.size();
    }

    public List<ME3> getFeaturesList() {
        return new B.h(this.features_, features_converter_);
    }

    public int getFeaturesValue(int i) {
        return this.features_.getInt(i);
    }

    public List<Integer> getFeaturesValueList() {
        return this.features_;
    }

    public String getTrackSid() {
        return this.trackSid_;
    }

    public AbstractC2383g getTrackSidBytes() {
        return AbstractC2383g.N(this.trackSid_);
    }

    public static b newBuilder(LivekitRtc$UpdateLocalAudioTrack livekitRtc$UpdateLocalAudioTrack) {
        return (b) DEFAULT_INSTANCE.createBuilder(livekitRtc$UpdateLocalAudioTrack);
    }

    public static LivekitRtc$UpdateLocalAudioTrack parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$UpdateLocalAudioTrack) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$UpdateLocalAudioTrack parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitRtc$UpdateLocalAudioTrack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitRtc$UpdateLocalAudioTrack parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitRtc$UpdateLocalAudioTrack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitRtc$UpdateLocalAudioTrack parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitRtc$UpdateLocalAudioTrack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitRtc$UpdateLocalAudioTrack parseFrom(byte[] bArr) {
        return (LivekitRtc$UpdateLocalAudioTrack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitRtc$UpdateLocalAudioTrack parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitRtc$UpdateLocalAudioTrack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitRtc$UpdateLocalAudioTrack parseFrom(InputStream inputStream) {
        return (LivekitRtc$UpdateLocalAudioTrack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$UpdateLocalAudioTrack parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$UpdateLocalAudioTrack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$UpdateLocalAudioTrack parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitRtc$UpdateLocalAudioTrack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitRtc$UpdateLocalAudioTrack parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitRtc$UpdateLocalAudioTrack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
