package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MeetStruct$LowerHand extends GeneratedMessageLite implements U64 {
    private static final MeetStruct$LowerHand DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int USER_IDENTITY_FIELD_NUMBER = 1;
    private String userIdentity_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MeetStruct$LowerHand.DEFAULT_INSTANCE);
        }
    }

    static {
        MeetStruct$LowerHand meetStruct$LowerHand = new MeetStruct$LowerHand();
        DEFAULT_INSTANCE = meetStruct$LowerHand;
        GeneratedMessageLite.registerDefaultInstance(MeetStruct$LowerHand.class, meetStruct$LowerHand);
    }

    private MeetStruct$LowerHand() {
    }

    private void clearUserIdentity() {
        this.userIdentity_ = getDefaultInstance().getUserIdentity();
    }

    public static MeetStruct$LowerHand getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MeetStruct$LowerHand parseDelimitedFrom(InputStream inputStream) {
        return (MeetStruct$LowerHand) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetStruct$LowerHand parseFrom(ByteBuffer byteBuffer) {
        return (MeetStruct$LowerHand) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setUserIdentity(String str) {
        str.getClass();
        this.userIdentity_ = str;
    }

    private void setUserIdentityBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.userIdentity_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (G0.a[gVar.ordinal()]) {
            case 1:
                return new MeetStruct$LowerHand();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"userIdentity_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MeetStruct$LowerHand.class) {
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

    public String getUserIdentity() {
        return this.userIdentity_;
    }

    public AbstractC2383g getUserIdentityBytes() {
        return AbstractC2383g.N(this.userIdentity_);
    }

    public static a newBuilder(MeetStruct$LowerHand meetStruct$LowerHand) {
        return (a) DEFAULT_INSTANCE.createBuilder(meetStruct$LowerHand);
    }

    public static MeetStruct$LowerHand parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetStruct$LowerHand) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetStruct$LowerHand parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MeetStruct$LowerHand) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MeetStruct$LowerHand parseFrom(AbstractC2383g abstractC2383g) {
        return (MeetStruct$LowerHand) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MeetStruct$LowerHand parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MeetStruct$LowerHand) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MeetStruct$LowerHand parseFrom(byte[] bArr) {
        return (MeetStruct$LowerHand) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MeetStruct$LowerHand parseFrom(byte[] bArr, C2394s c2394s) {
        return (MeetStruct$LowerHand) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MeetStruct$LowerHand parseFrom(InputStream inputStream) {
        return (MeetStruct$LowerHand) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetStruct$LowerHand parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetStruct$LowerHand) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetStruct$LowerHand parseFrom(AbstractC2384h abstractC2384h) {
        return (MeetStruct$LowerHand) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MeetStruct$LowerHand parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MeetStruct$LowerHand) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
