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
import livekit.LivekitSip$SIPInboundTrunkInfo;
import livekit.LivekitSip$SIPInboundTrunkUpdate;

/* loaded from: classes8.dex */
public final class LivekitSip$UpdateSIPInboundTrunkRequest extends GeneratedMessageLite implements U64 {
    private static final LivekitSip$UpdateSIPInboundTrunkRequest DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int REPLACE_FIELD_NUMBER = 2;
    public static final int SIP_TRUNK_ID_FIELD_NUMBER = 1;
    public static final int UPDATE_FIELD_NUMBER = 3;
    private Object action_;
    private int actionCase_ = 0;
    private String sipTrunkId_ = "";

    public enum a {
        REPLACE(2),
        UPDATE(3),
        ACTION_NOT_SET(0);

        private final int a;

        a(int i) {
            this.a = i;
        }

        public static a j(int i) {
            if (i == 0) {
                return ACTION_NOT_SET;
            }
            if (i == 2) {
                return REPLACE;
            }
            if (i != 3) {
                return null;
            }
            return UPDATE;
        }
    }

    public static final class b extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ b(t tVar) {
            this();
        }

        private b() {
            super(LivekitSip$UpdateSIPInboundTrunkRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitSip$UpdateSIPInboundTrunkRequest livekitSip$UpdateSIPInboundTrunkRequest = new LivekitSip$UpdateSIPInboundTrunkRequest();
        DEFAULT_INSTANCE = livekitSip$UpdateSIPInboundTrunkRequest;
        GeneratedMessageLite.registerDefaultInstance(LivekitSip$UpdateSIPInboundTrunkRequest.class, livekitSip$UpdateSIPInboundTrunkRequest);
    }

    private LivekitSip$UpdateSIPInboundTrunkRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAction() {
        this.actionCase_ = 0;
        this.action_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearReplace() {
        if (this.actionCase_ == 2) {
            this.actionCase_ = 0;
            this.action_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSipTrunkId() {
        this.sipTrunkId_ = getDefaultInstance().getSipTrunkId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUpdate() {
        if (this.actionCase_ == 3) {
            this.actionCase_ = 0;
            this.action_ = null;
        }
    }

    public static LivekitSip$UpdateSIPInboundTrunkRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeReplace(LivekitSip$SIPInboundTrunkInfo livekitSip$SIPInboundTrunkInfo) {
        livekitSip$SIPInboundTrunkInfo.getClass();
        if (this.actionCase_ != 2 || this.action_ == LivekitSip$SIPInboundTrunkInfo.getDefaultInstance()) {
            this.action_ = livekitSip$SIPInboundTrunkInfo;
        } else {
            this.action_ = ((LivekitSip$SIPInboundTrunkInfo.b) LivekitSip$SIPInboundTrunkInfo.newBuilder((LivekitSip$SIPInboundTrunkInfo) this.action_).v(livekitSip$SIPInboundTrunkInfo)).j();
        }
        this.actionCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeUpdate(LivekitSip$SIPInboundTrunkUpdate livekitSip$SIPInboundTrunkUpdate) {
        livekitSip$SIPInboundTrunkUpdate.getClass();
        if (this.actionCase_ != 3 || this.action_ == LivekitSip$SIPInboundTrunkUpdate.getDefaultInstance()) {
            this.action_ = livekitSip$SIPInboundTrunkUpdate;
        } else {
            this.action_ = ((LivekitSip$SIPInboundTrunkUpdate.a) LivekitSip$SIPInboundTrunkUpdate.newBuilder((LivekitSip$SIPInboundTrunkUpdate) this.action_).v(livekitSip$SIPInboundTrunkUpdate)).j();
        }
        this.actionCase_ = 3;
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitSip$UpdateSIPInboundTrunkRequest parseDelimitedFrom(InputStream inputStream) {
        return (LivekitSip$UpdateSIPInboundTrunkRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitSip$UpdateSIPInboundTrunkRequest parseFrom(ByteBuffer byteBuffer) {
        return (LivekitSip$UpdateSIPInboundTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReplace(LivekitSip$SIPInboundTrunkInfo livekitSip$SIPInboundTrunkInfo) {
        livekitSip$SIPInboundTrunkInfo.getClass();
        this.action_ = livekitSip$SIPInboundTrunkInfo;
        this.actionCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSipTrunkId(String str) {
        str.getClass();
        this.sipTrunkId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSipTrunkIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.sipTrunkId_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUpdate(LivekitSip$SIPInboundTrunkUpdate livekitSip$SIPInboundTrunkUpdate) {
        livekitSip$SIPInboundTrunkUpdate.getClass();
        this.action_ = livekitSip$SIPInboundTrunkUpdate;
        this.actionCase_ = 3;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        t tVar = null;
        switch (t.a[gVar.ordinal()]) {
            case 1:
                return new LivekitSip$UpdateSIPInboundTrunkRequest();
            case 2:
                return new b(tVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002<\u0000\u0003<\u0000", new Object[]{"action_", "actionCase_", "sipTrunkId_", LivekitSip$SIPInboundTrunkInfo.class, LivekitSip$SIPInboundTrunkUpdate.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitSip$UpdateSIPInboundTrunkRequest.class) {
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

    public a getActionCase() {
        return a.j(this.actionCase_);
    }

    public LivekitSip$SIPInboundTrunkInfo getReplace() {
        return this.actionCase_ == 2 ? (LivekitSip$SIPInboundTrunkInfo) this.action_ : LivekitSip$SIPInboundTrunkInfo.getDefaultInstance();
    }

    public String getSipTrunkId() {
        return this.sipTrunkId_;
    }

    public AbstractC2383g getSipTrunkIdBytes() {
        return AbstractC2383g.N(this.sipTrunkId_);
    }

    public LivekitSip$SIPInboundTrunkUpdate getUpdate() {
        return this.actionCase_ == 3 ? (LivekitSip$SIPInboundTrunkUpdate) this.action_ : LivekitSip$SIPInboundTrunkUpdate.getDefaultInstance();
    }

    public boolean hasReplace() {
        return this.actionCase_ == 2;
    }

    public boolean hasUpdate() {
        return this.actionCase_ == 3;
    }

    public static b newBuilder(LivekitSip$UpdateSIPInboundTrunkRequest livekitSip$UpdateSIPInboundTrunkRequest) {
        return (b) DEFAULT_INSTANCE.createBuilder(livekitSip$UpdateSIPInboundTrunkRequest);
    }

    public static LivekitSip$UpdateSIPInboundTrunkRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitSip$UpdateSIPInboundTrunkRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitSip$UpdateSIPInboundTrunkRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitSip$UpdateSIPInboundTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitSip$UpdateSIPInboundTrunkRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitSip$UpdateSIPInboundTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitSip$UpdateSIPInboundTrunkRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitSip$UpdateSIPInboundTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitSip$UpdateSIPInboundTrunkRequest parseFrom(byte[] bArr) {
        return (LivekitSip$UpdateSIPInboundTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitSip$UpdateSIPInboundTrunkRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitSip$UpdateSIPInboundTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitSip$UpdateSIPInboundTrunkRequest parseFrom(InputStream inputStream) {
        return (LivekitSip$UpdateSIPInboundTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitSip$UpdateSIPInboundTrunkRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitSip$UpdateSIPInboundTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitSip$UpdateSIPInboundTrunkRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitSip$UpdateSIPInboundTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitSip$UpdateSIPInboundTrunkRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitSip$UpdateSIPInboundTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
