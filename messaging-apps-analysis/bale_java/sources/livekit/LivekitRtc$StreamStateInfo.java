package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC18788pF3;
import ir.nasim.InterfaceC19379qF3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitRtc$StreamStateInfo extends GeneratedMessageLite implements InterfaceC19379qF3 {
    private static final LivekitRtc$StreamStateInfo DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PARTICIPANT_SID_FIELD_NUMBER = 1;
    public static final int STATE_FIELD_NUMBER = 3;
    public static final int TRACK_SID_FIELD_NUMBER = 2;
    private int state_;
    private String participantSid_ = "";
    private String trackSid_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC19379qF3 {
        /* synthetic */ a(s sVar) {
            this();
        }

        private a() {
            super(LivekitRtc$StreamStateInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitRtc$StreamStateInfo livekitRtc$StreamStateInfo = new LivekitRtc$StreamStateInfo();
        DEFAULT_INSTANCE = livekitRtc$StreamStateInfo;
        GeneratedMessageLite.registerDefaultInstance(LivekitRtc$StreamStateInfo.class, livekitRtc$StreamStateInfo);
    }

    private LivekitRtc$StreamStateInfo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParticipantSid() {
        this.participantSid_ = getDefaultInstance().getParticipantSid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearState() {
        this.state_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTrackSid() {
        this.trackSid_ = getDefaultInstance().getTrackSid();
    }

    public static LivekitRtc$StreamStateInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitRtc$StreamStateInfo parseDelimitedFrom(InputStream inputStream) {
        return (LivekitRtc$StreamStateInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$StreamStateInfo parseFrom(ByteBuffer byteBuffer) {
        return (LivekitRtc$StreamStateInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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
    public void setState(EnumC18788pF3 enumC18788pF3) {
        this.state_ = enumC18788pF3.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStateValue(int i) {
        this.state_ = i;
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
                return new LivekitRtc$StreamStateInfo();
            case 2:
                return new a(sVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\f", new Object[]{"participantSid_", "trackSid_", "state_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitRtc$StreamStateInfo.class) {
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

    public EnumC18788pF3 getState() {
        EnumC18788pF3 enumC18788pF3J = EnumC18788pF3.j(this.state_);
        return enumC18788pF3J == null ? EnumC18788pF3.UNRECOGNIZED : enumC18788pF3J;
    }

    public int getStateValue() {
        return this.state_;
    }

    public String getTrackSid() {
        return this.trackSid_;
    }

    public AbstractC2383g getTrackSidBytes() {
        return AbstractC2383g.N(this.trackSid_);
    }

    public static a newBuilder(LivekitRtc$StreamStateInfo livekitRtc$StreamStateInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitRtc$StreamStateInfo);
    }

    public static LivekitRtc$StreamStateInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$StreamStateInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$StreamStateInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitRtc$StreamStateInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitRtc$StreamStateInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitRtc$StreamStateInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitRtc$StreamStateInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitRtc$StreamStateInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitRtc$StreamStateInfo parseFrom(byte[] bArr) {
        return (LivekitRtc$StreamStateInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitRtc$StreamStateInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitRtc$StreamStateInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitRtc$StreamStateInfo parseFrom(InputStream inputStream) {
        return (LivekitRtc$StreamStateInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$StreamStateInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$StreamStateInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$StreamStateInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitRtc$StreamStateInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitRtc$StreamStateInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitRtc$StreamStateInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
