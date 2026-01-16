package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC14644iF3;
import ir.nasim.KW4;
import ir.nasim.QE3;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitRtc$ConnectionQualityInfo extends GeneratedMessageLite implements InterfaceC14644iF3 {
    private static final LivekitRtc$ConnectionQualityInfo DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PARTICIPANT_SID_FIELD_NUMBER = 1;
    public static final int QUALITY_FIELD_NUMBER = 2;
    public static final int SCORE_FIELD_NUMBER = 3;
    private String participantSid_ = "";
    private int quality_;
    private float score_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC14644iF3 {
        /* synthetic */ a(s sVar) {
            this();
        }

        private a() {
            super(LivekitRtc$ConnectionQualityInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitRtc$ConnectionQualityInfo livekitRtc$ConnectionQualityInfo = new LivekitRtc$ConnectionQualityInfo();
        DEFAULT_INSTANCE = livekitRtc$ConnectionQualityInfo;
        GeneratedMessageLite.registerDefaultInstance(LivekitRtc$ConnectionQualityInfo.class, livekitRtc$ConnectionQualityInfo);
    }

    private LivekitRtc$ConnectionQualityInfo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParticipantSid() {
        this.participantSid_ = getDefaultInstance().getParticipantSid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearQuality() {
        this.quality_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearScore() {
        this.score_ = 0.0f;
    }

    public static LivekitRtc$ConnectionQualityInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitRtc$ConnectionQualityInfo parseDelimitedFrom(InputStream inputStream) {
        return (LivekitRtc$ConnectionQualityInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$ConnectionQualityInfo parseFrom(ByteBuffer byteBuffer) {
        return (LivekitRtc$ConnectionQualityInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParticipantSid(String str) {
        str.getClass();
        this.participantSid_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParticipantSidBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.participantSid_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setQuality(QE3 qe3) {
        this.quality_ = qe3.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setQualityValue(int i) {
        this.quality_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScore(float f) {
        this.score_ = f;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        s sVar = null;
        switch (s.a[gVar.ordinal()]) {
            case 1:
                return new LivekitRtc$ConnectionQualityInfo();
            case 2:
                return new a(sVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u0001", new Object[]{"participantSid_", "quality_", "score_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitRtc$ConnectionQualityInfo.class) {
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

    public String getParticipantSid() {
        return this.participantSid_;
    }

    public AbstractC2383g getParticipantSidBytes() {
        return AbstractC2383g.N(this.participantSid_);
    }

    public QE3 getQuality() {
        QE3 qe3J = QE3.j(this.quality_);
        return qe3J == null ? QE3.UNRECOGNIZED : qe3J;
    }

    public int getQualityValue() {
        return this.quality_;
    }

    public float getScore() {
        return this.score_;
    }

    public static a newBuilder(LivekitRtc$ConnectionQualityInfo livekitRtc$ConnectionQualityInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitRtc$ConnectionQualityInfo);
    }

    public static LivekitRtc$ConnectionQualityInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$ConnectionQualityInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$ConnectionQualityInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitRtc$ConnectionQualityInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitRtc$ConnectionQualityInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitRtc$ConnectionQualityInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitRtc$ConnectionQualityInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitRtc$ConnectionQualityInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitRtc$ConnectionQualityInfo parseFrom(byte[] bArr) {
        return (LivekitRtc$ConnectionQualityInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitRtc$ConnectionQualityInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitRtc$ConnectionQualityInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitRtc$ConnectionQualityInfo parseFrom(InputStream inputStream) {
        return (LivekitRtc$ConnectionQualityInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$ConnectionQualityInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$ConnectionQualityInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$ConnectionQualityInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitRtc$ConnectionQualityInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitRtc$ConnectionQualityInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitRtc$ConnectionQualityInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
