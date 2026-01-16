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

/* loaded from: classes.dex */
public final class WarriorOuterClass$RequestAcceptReferralInvite extends GeneratedMessageLite implements U64 {
    private static final WarriorOuterClass$RequestAcceptReferralInvite DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TOKEN_FIELD_NUMBER = 1;
    private String token_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(WarriorOuterClass$RequestAcceptReferralInvite.DEFAULT_INSTANCE);
        }
    }

    static {
        WarriorOuterClass$RequestAcceptReferralInvite warriorOuterClass$RequestAcceptReferralInvite = new WarriorOuterClass$RequestAcceptReferralInvite();
        DEFAULT_INSTANCE = warriorOuterClass$RequestAcceptReferralInvite;
        GeneratedMessageLite.registerDefaultInstance(WarriorOuterClass$RequestAcceptReferralInvite.class, warriorOuterClass$RequestAcceptReferralInvite);
    }

    private WarriorOuterClass$RequestAcceptReferralInvite() {
    }

    private void clearToken() {
        this.token_ = getDefaultInstance().getToken();
    }

    public static WarriorOuterClass$RequestAcceptReferralInvite getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static WarriorOuterClass$RequestAcceptReferralInvite parseDelimitedFrom(InputStream inputStream) {
        return (WarriorOuterClass$RequestAcceptReferralInvite) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WarriorOuterClass$RequestAcceptReferralInvite parseFrom(ByteBuffer byteBuffer) {
        return (WarriorOuterClass$RequestAcceptReferralInvite) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setToken(String str) {
        str.getClass();
        this.token_ = str;
    }

    private void setTokenBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.token_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (w2.a[gVar.ordinal()]) {
            case 1:
                return new WarriorOuterClass$RequestAcceptReferralInvite();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"token_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (WarriorOuterClass$RequestAcceptReferralInvite.class) {
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

    public String getToken() {
        return this.token_;
    }

    public AbstractC2383g getTokenBytes() {
        return AbstractC2383g.N(this.token_);
    }

    public static a newBuilder(WarriorOuterClass$RequestAcceptReferralInvite warriorOuterClass$RequestAcceptReferralInvite) {
        return (a) DEFAULT_INSTANCE.createBuilder(warriorOuterClass$RequestAcceptReferralInvite);
    }

    public static WarriorOuterClass$RequestAcceptReferralInvite parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (WarriorOuterClass$RequestAcceptReferralInvite) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WarriorOuterClass$RequestAcceptReferralInvite parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (WarriorOuterClass$RequestAcceptReferralInvite) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static WarriorOuterClass$RequestAcceptReferralInvite parseFrom(AbstractC2383g abstractC2383g) {
        return (WarriorOuterClass$RequestAcceptReferralInvite) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static WarriorOuterClass$RequestAcceptReferralInvite parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (WarriorOuterClass$RequestAcceptReferralInvite) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static WarriorOuterClass$RequestAcceptReferralInvite parseFrom(byte[] bArr) {
        return (WarriorOuterClass$RequestAcceptReferralInvite) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static WarriorOuterClass$RequestAcceptReferralInvite parseFrom(byte[] bArr, C2394s c2394s) {
        return (WarriorOuterClass$RequestAcceptReferralInvite) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static WarriorOuterClass$RequestAcceptReferralInvite parseFrom(InputStream inputStream) {
        return (WarriorOuterClass$RequestAcceptReferralInvite) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WarriorOuterClass$RequestAcceptReferralInvite parseFrom(InputStream inputStream, C2394s c2394s) {
        return (WarriorOuterClass$RequestAcceptReferralInvite) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WarriorOuterClass$RequestAcceptReferralInvite parseFrom(AbstractC2384h abstractC2384h) {
        return (WarriorOuterClass$RequestAcceptReferralInvite) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static WarriorOuterClass$RequestAcceptReferralInvite parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (WarriorOuterClass$RequestAcceptReferralInvite) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
