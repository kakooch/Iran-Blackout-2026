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

/* loaded from: classes8.dex */
public final class LivekitSip$DeleteSIPDispatchRuleRequest extends GeneratedMessageLite implements U64 {
    private static final LivekitSip$DeleteSIPDispatchRuleRequest DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int SIP_DISPATCH_RULE_ID_FIELD_NUMBER = 1;
    private String sipDispatchRuleId_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(t tVar) {
            this();
        }

        private a() {
            super(LivekitSip$DeleteSIPDispatchRuleRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitSip$DeleteSIPDispatchRuleRequest livekitSip$DeleteSIPDispatchRuleRequest = new LivekitSip$DeleteSIPDispatchRuleRequest();
        DEFAULT_INSTANCE = livekitSip$DeleteSIPDispatchRuleRequest;
        GeneratedMessageLite.registerDefaultInstance(LivekitSip$DeleteSIPDispatchRuleRequest.class, livekitSip$DeleteSIPDispatchRuleRequest);
    }

    private LivekitSip$DeleteSIPDispatchRuleRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSipDispatchRuleId() {
        this.sipDispatchRuleId_ = getDefaultInstance().getSipDispatchRuleId();
    }

    public static LivekitSip$DeleteSIPDispatchRuleRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitSip$DeleteSIPDispatchRuleRequest parseDelimitedFrom(InputStream inputStream) {
        return (LivekitSip$DeleteSIPDispatchRuleRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitSip$DeleteSIPDispatchRuleRequest parseFrom(ByteBuffer byteBuffer) {
        return (LivekitSip$DeleteSIPDispatchRuleRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
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

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        t tVar = null;
        switch (t.a[gVar.ordinal()]) {
            case 1:
                return new LivekitSip$DeleteSIPDispatchRuleRequest();
            case 2:
                return new a(tVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"sipDispatchRuleId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitSip$DeleteSIPDispatchRuleRequest.class) {
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

    public String getSipDispatchRuleId() {
        return this.sipDispatchRuleId_;
    }

    public AbstractC2383g getSipDispatchRuleIdBytes() {
        return AbstractC2383g.N(this.sipDispatchRuleId_);
    }

    public static a newBuilder(LivekitSip$DeleteSIPDispatchRuleRequest livekitSip$DeleteSIPDispatchRuleRequest) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitSip$DeleteSIPDispatchRuleRequest);
    }

    public static LivekitSip$DeleteSIPDispatchRuleRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitSip$DeleteSIPDispatchRuleRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitSip$DeleteSIPDispatchRuleRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitSip$DeleteSIPDispatchRuleRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitSip$DeleteSIPDispatchRuleRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitSip$DeleteSIPDispatchRuleRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitSip$DeleteSIPDispatchRuleRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitSip$DeleteSIPDispatchRuleRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitSip$DeleteSIPDispatchRuleRequest parseFrom(byte[] bArr) {
        return (LivekitSip$DeleteSIPDispatchRuleRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitSip$DeleteSIPDispatchRuleRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitSip$DeleteSIPDispatchRuleRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitSip$DeleteSIPDispatchRuleRequest parseFrom(InputStream inputStream) {
        return (LivekitSip$DeleteSIPDispatchRuleRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitSip$DeleteSIPDispatchRuleRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitSip$DeleteSIPDispatchRuleRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitSip$DeleteSIPDispatchRuleRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitSip$DeleteSIPDispatchRuleRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitSip$DeleteSIPDispatchRuleRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitSip$DeleteSIPDispatchRuleRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
