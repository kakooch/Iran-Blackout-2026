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
import livekit.LivekitSip$SIPDispatchRuleInfo;
import livekit.LivekitSip$SIPDispatchRuleUpdate;

/* loaded from: classes8.dex */
public final class LivekitSip$UpdateSIPDispatchRuleRequest extends GeneratedMessageLite implements U64 {
    private static final LivekitSip$UpdateSIPDispatchRuleRequest DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int REPLACE_FIELD_NUMBER = 2;
    public static final int SIP_DISPATCH_RULE_ID_FIELD_NUMBER = 1;
    public static final int UPDATE_FIELD_NUMBER = 3;
    private Object action_;
    private int actionCase_ = 0;
    private String sipDispatchRuleId_ = "";

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
            super(LivekitSip$UpdateSIPDispatchRuleRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitSip$UpdateSIPDispatchRuleRequest livekitSip$UpdateSIPDispatchRuleRequest = new LivekitSip$UpdateSIPDispatchRuleRequest();
        DEFAULT_INSTANCE = livekitSip$UpdateSIPDispatchRuleRequest;
        GeneratedMessageLite.registerDefaultInstance(LivekitSip$UpdateSIPDispatchRuleRequest.class, livekitSip$UpdateSIPDispatchRuleRequest);
    }

    private LivekitSip$UpdateSIPDispatchRuleRequest() {
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
    public void clearSipDispatchRuleId() {
        this.sipDispatchRuleId_ = getDefaultInstance().getSipDispatchRuleId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUpdate() {
        if (this.actionCase_ == 3) {
            this.actionCase_ = 0;
            this.action_ = null;
        }
    }

    public static LivekitSip$UpdateSIPDispatchRuleRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeReplace(LivekitSip$SIPDispatchRuleInfo livekitSip$SIPDispatchRuleInfo) {
        livekitSip$SIPDispatchRuleInfo.getClass();
        if (this.actionCase_ != 2 || this.action_ == LivekitSip$SIPDispatchRuleInfo.getDefaultInstance()) {
            this.action_ = livekitSip$SIPDispatchRuleInfo;
        } else {
            this.action_ = ((LivekitSip$SIPDispatchRuleInfo.b) LivekitSip$SIPDispatchRuleInfo.newBuilder((LivekitSip$SIPDispatchRuleInfo) this.action_).v(livekitSip$SIPDispatchRuleInfo)).j();
        }
        this.actionCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeUpdate(LivekitSip$SIPDispatchRuleUpdate livekitSip$SIPDispatchRuleUpdate) {
        livekitSip$SIPDispatchRuleUpdate.getClass();
        if (this.actionCase_ != 3 || this.action_ == LivekitSip$SIPDispatchRuleUpdate.getDefaultInstance()) {
            this.action_ = livekitSip$SIPDispatchRuleUpdate;
        } else {
            this.action_ = ((LivekitSip$SIPDispatchRuleUpdate.b) LivekitSip$SIPDispatchRuleUpdate.newBuilder((LivekitSip$SIPDispatchRuleUpdate) this.action_).v(livekitSip$SIPDispatchRuleUpdate)).j();
        }
        this.actionCase_ = 3;
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitSip$UpdateSIPDispatchRuleRequest parseDelimitedFrom(InputStream inputStream) {
        return (LivekitSip$UpdateSIPDispatchRuleRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitSip$UpdateSIPDispatchRuleRequest parseFrom(ByteBuffer byteBuffer) {
        return (LivekitSip$UpdateSIPDispatchRuleRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReplace(LivekitSip$SIPDispatchRuleInfo livekitSip$SIPDispatchRuleInfo) {
        livekitSip$SIPDispatchRuleInfo.getClass();
        this.action_ = livekitSip$SIPDispatchRuleInfo;
        this.actionCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSipDispatchRuleId(String str) {
        str.getClass();
        this.sipDispatchRuleId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSipDispatchRuleIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.sipDispatchRuleId_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUpdate(LivekitSip$SIPDispatchRuleUpdate livekitSip$SIPDispatchRuleUpdate) {
        livekitSip$SIPDispatchRuleUpdate.getClass();
        this.action_ = livekitSip$SIPDispatchRuleUpdate;
        this.actionCase_ = 3;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        t tVar = null;
        switch (t.a[gVar.ordinal()]) {
            case 1:
                return new LivekitSip$UpdateSIPDispatchRuleRequest();
            case 2:
                return new b(tVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002<\u0000\u0003<\u0000", new Object[]{"action_", "actionCase_", "sipDispatchRuleId_", LivekitSip$SIPDispatchRuleInfo.class, LivekitSip$SIPDispatchRuleUpdate.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitSip$UpdateSIPDispatchRuleRequest.class) {
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

    public LivekitSip$SIPDispatchRuleInfo getReplace() {
        return this.actionCase_ == 2 ? (LivekitSip$SIPDispatchRuleInfo) this.action_ : LivekitSip$SIPDispatchRuleInfo.getDefaultInstance();
    }

    public String getSipDispatchRuleId() {
        return this.sipDispatchRuleId_;
    }

    public AbstractC2383g getSipDispatchRuleIdBytes() {
        return AbstractC2383g.N(this.sipDispatchRuleId_);
    }

    public LivekitSip$SIPDispatchRuleUpdate getUpdate() {
        return this.actionCase_ == 3 ? (LivekitSip$SIPDispatchRuleUpdate) this.action_ : LivekitSip$SIPDispatchRuleUpdate.getDefaultInstance();
    }

    public boolean hasReplace() {
        return this.actionCase_ == 2;
    }

    public boolean hasUpdate() {
        return this.actionCase_ == 3;
    }

    public static b newBuilder(LivekitSip$UpdateSIPDispatchRuleRequest livekitSip$UpdateSIPDispatchRuleRequest) {
        return (b) DEFAULT_INSTANCE.createBuilder(livekitSip$UpdateSIPDispatchRuleRequest);
    }

    public static LivekitSip$UpdateSIPDispatchRuleRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitSip$UpdateSIPDispatchRuleRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitSip$UpdateSIPDispatchRuleRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitSip$UpdateSIPDispatchRuleRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitSip$UpdateSIPDispatchRuleRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitSip$UpdateSIPDispatchRuleRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitSip$UpdateSIPDispatchRuleRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitSip$UpdateSIPDispatchRuleRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitSip$UpdateSIPDispatchRuleRequest parseFrom(byte[] bArr) {
        return (LivekitSip$UpdateSIPDispatchRuleRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitSip$UpdateSIPDispatchRuleRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitSip$UpdateSIPDispatchRuleRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitSip$UpdateSIPDispatchRuleRequest parseFrom(InputStream inputStream) {
        return (LivekitSip$UpdateSIPDispatchRuleRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitSip$UpdateSIPDispatchRuleRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitSip$UpdateSIPDispatchRuleRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitSip$UpdateSIPDispatchRuleRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitSip$UpdateSIPDispatchRuleRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitSip$UpdateSIPDispatchRuleRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitSip$UpdateSIPDispatchRuleRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
