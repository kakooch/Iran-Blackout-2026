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
public final class LivekitSip$SIPDispatchRuleCallee extends GeneratedMessageLite implements U64 {
    private static final LivekitSip$SIPDispatchRuleCallee DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PIN_FIELD_NUMBER = 2;
    public static final int RANDOMIZE_FIELD_NUMBER = 3;
    public static final int ROOM_PREFIX_FIELD_NUMBER = 1;
    private boolean randomize_;
    private String roomPrefix_ = "";
    private String pin_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(t tVar) {
            this();
        }

        private a() {
            super(LivekitSip$SIPDispatchRuleCallee.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitSip$SIPDispatchRuleCallee livekitSip$SIPDispatchRuleCallee = new LivekitSip$SIPDispatchRuleCallee();
        DEFAULT_INSTANCE = livekitSip$SIPDispatchRuleCallee;
        GeneratedMessageLite.registerDefaultInstance(LivekitSip$SIPDispatchRuleCallee.class, livekitSip$SIPDispatchRuleCallee);
    }

    private LivekitSip$SIPDispatchRuleCallee() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPin() {
        this.pin_ = getDefaultInstance().getPin();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRandomize() {
        this.randomize_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRoomPrefix() {
        this.roomPrefix_ = getDefaultInstance().getRoomPrefix();
    }

    public static LivekitSip$SIPDispatchRuleCallee getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitSip$SIPDispatchRuleCallee parseDelimitedFrom(InputStream inputStream) {
        return (LivekitSip$SIPDispatchRuleCallee) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitSip$SIPDispatchRuleCallee parseFrom(ByteBuffer byteBuffer) {
        return (LivekitSip$SIPDispatchRuleCallee) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPin(String str) {
        str.getClass();
        this.pin_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPinBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.pin_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRandomize(boolean z) {
        this.randomize_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRoomPrefix(String str) {
        str.getClass();
        this.roomPrefix_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRoomPrefixBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.roomPrefix_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        t tVar = null;
        switch (t.a[gVar.ordinal()]) {
            case 1:
                return new LivekitSip$SIPDispatchRuleCallee();
            case 2:
                return new a(tVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0007", new Object[]{"roomPrefix_", "pin_", "randomize_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitSip$SIPDispatchRuleCallee.class) {
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

    public String getPin() {
        return this.pin_;
    }

    public AbstractC2383g getPinBytes() {
        return AbstractC2383g.N(this.pin_);
    }

    public boolean getRandomize() {
        return this.randomize_;
    }

    public String getRoomPrefix() {
        return this.roomPrefix_;
    }

    public AbstractC2383g getRoomPrefixBytes() {
        return AbstractC2383g.N(this.roomPrefix_);
    }

    public static a newBuilder(LivekitSip$SIPDispatchRuleCallee livekitSip$SIPDispatchRuleCallee) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitSip$SIPDispatchRuleCallee);
    }

    public static LivekitSip$SIPDispatchRuleCallee parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitSip$SIPDispatchRuleCallee) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitSip$SIPDispatchRuleCallee parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitSip$SIPDispatchRuleCallee) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitSip$SIPDispatchRuleCallee parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitSip$SIPDispatchRuleCallee) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitSip$SIPDispatchRuleCallee parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitSip$SIPDispatchRuleCallee) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitSip$SIPDispatchRuleCallee parseFrom(byte[] bArr) {
        return (LivekitSip$SIPDispatchRuleCallee) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitSip$SIPDispatchRuleCallee parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitSip$SIPDispatchRuleCallee) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitSip$SIPDispatchRuleCallee parseFrom(InputStream inputStream) {
        return (LivekitSip$SIPDispatchRuleCallee) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitSip$SIPDispatchRuleCallee parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitSip$SIPDispatchRuleCallee) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitSip$SIPDispatchRuleCallee parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitSip$SIPDispatchRuleCallee) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitSip$SIPDispatchRuleCallee parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitSip$SIPDispatchRuleCallee) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
