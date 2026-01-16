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
public final class LivekitSip$SIPDispatchRuleDirect extends GeneratedMessageLite implements U64 {
    private static final LivekitSip$SIPDispatchRuleDirect DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PIN_FIELD_NUMBER = 2;
    public static final int ROOM_NAME_FIELD_NUMBER = 1;
    private String roomName_ = "";
    private String pin_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(t tVar) {
            this();
        }

        private a() {
            super(LivekitSip$SIPDispatchRuleDirect.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitSip$SIPDispatchRuleDirect livekitSip$SIPDispatchRuleDirect = new LivekitSip$SIPDispatchRuleDirect();
        DEFAULT_INSTANCE = livekitSip$SIPDispatchRuleDirect;
        GeneratedMessageLite.registerDefaultInstance(LivekitSip$SIPDispatchRuleDirect.class, livekitSip$SIPDispatchRuleDirect);
    }

    private LivekitSip$SIPDispatchRuleDirect() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPin() {
        this.pin_ = getDefaultInstance().getPin();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRoomName() {
        this.roomName_ = getDefaultInstance().getRoomName();
    }

    public static LivekitSip$SIPDispatchRuleDirect getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitSip$SIPDispatchRuleDirect parseDelimitedFrom(InputStream inputStream) {
        return (LivekitSip$SIPDispatchRuleDirect) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitSip$SIPDispatchRuleDirect parseFrom(ByteBuffer byteBuffer) {
        return (LivekitSip$SIPDispatchRuleDirect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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
    public void setRoomName(String str) {
        str.getClass();
        this.roomName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRoomNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.roomName_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        t tVar = null;
        switch (t.a[gVar.ordinal()]) {
            case 1:
                return new LivekitSip$SIPDispatchRuleDirect();
            case 2:
                return new a(tVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"roomName_", "pin_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitSip$SIPDispatchRuleDirect.class) {
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

    public String getRoomName() {
        return this.roomName_;
    }

    public AbstractC2383g getRoomNameBytes() {
        return AbstractC2383g.N(this.roomName_);
    }

    public static a newBuilder(LivekitSip$SIPDispatchRuleDirect livekitSip$SIPDispatchRuleDirect) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitSip$SIPDispatchRuleDirect);
    }

    public static LivekitSip$SIPDispatchRuleDirect parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitSip$SIPDispatchRuleDirect) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitSip$SIPDispatchRuleDirect parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitSip$SIPDispatchRuleDirect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitSip$SIPDispatchRuleDirect parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitSip$SIPDispatchRuleDirect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitSip$SIPDispatchRuleDirect parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitSip$SIPDispatchRuleDirect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitSip$SIPDispatchRuleDirect parseFrom(byte[] bArr) {
        return (LivekitSip$SIPDispatchRuleDirect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitSip$SIPDispatchRuleDirect parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitSip$SIPDispatchRuleDirect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitSip$SIPDispatchRuleDirect parseFrom(InputStream inputStream) {
        return (LivekitSip$SIPDispatchRuleDirect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitSip$SIPDispatchRuleDirect parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitSip$SIPDispatchRuleDirect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitSip$SIPDispatchRuleDirect parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitSip$SIPDispatchRuleDirect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitSip$SIPDispatchRuleDirect parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitSip$SIPDispatchRuleDirect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
