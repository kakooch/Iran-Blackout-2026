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
public final class SefteOuterClass$ResponseAuthorizeUser extends GeneratedMessageLite implements U64 {
    private static final SefteOuterClass$ResponseAuthorizeUser DEFAULT_INSTANCE;
    public static final int IS_AUTHORIZED_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int STATUS_MESSAGE_FIELD_NUMBER = 2;
    private boolean isAuthorized_;
    private String statusMessage_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SefteOuterClass$ResponseAuthorizeUser.DEFAULT_INSTANCE);
        }
    }

    static {
        SefteOuterClass$ResponseAuthorizeUser sefteOuterClass$ResponseAuthorizeUser = new SefteOuterClass$ResponseAuthorizeUser();
        DEFAULT_INSTANCE = sefteOuterClass$ResponseAuthorizeUser;
        GeneratedMessageLite.registerDefaultInstance(SefteOuterClass$ResponseAuthorizeUser.class, sefteOuterClass$ResponseAuthorizeUser);
    }

    private SefteOuterClass$ResponseAuthorizeUser() {
    }

    private void clearIsAuthorized() {
        this.isAuthorized_ = false;
    }

    private void clearStatusMessage() {
        this.statusMessage_ = getDefaultInstance().getStatusMessage();
    }

    public static SefteOuterClass$ResponseAuthorizeUser getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SefteOuterClass$ResponseAuthorizeUser parseDelimitedFrom(InputStream inputStream) {
        return (SefteOuterClass$ResponseAuthorizeUser) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SefteOuterClass$ResponseAuthorizeUser parseFrom(ByteBuffer byteBuffer) {
        return (SefteOuterClass$ResponseAuthorizeUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setIsAuthorized(boolean z) {
        this.isAuthorized_ = z;
    }

    private void setStatusMessage(String str) {
        str.getClass();
        this.statusMessage_ = str;
    }

    private void setStatusMessageBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.statusMessage_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (P1.a[gVar.ordinal()]) {
            case 1:
                return new SefteOuterClass$ResponseAuthorizeUser();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0007\u0002Ȉ", new Object[]{"isAuthorized_", "statusMessage_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SefteOuterClass$ResponseAuthorizeUser.class) {
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

    public boolean getIsAuthorized() {
        return this.isAuthorized_;
    }

    public String getStatusMessage() {
        return this.statusMessage_;
    }

    public AbstractC2383g getStatusMessageBytes() {
        return AbstractC2383g.N(this.statusMessage_);
    }

    public static a newBuilder(SefteOuterClass$ResponseAuthorizeUser sefteOuterClass$ResponseAuthorizeUser) {
        return (a) DEFAULT_INSTANCE.createBuilder(sefteOuterClass$ResponseAuthorizeUser);
    }

    public static SefteOuterClass$ResponseAuthorizeUser parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SefteOuterClass$ResponseAuthorizeUser) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SefteOuterClass$ResponseAuthorizeUser parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SefteOuterClass$ResponseAuthorizeUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SefteOuterClass$ResponseAuthorizeUser parseFrom(AbstractC2383g abstractC2383g) {
        return (SefteOuterClass$ResponseAuthorizeUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SefteOuterClass$ResponseAuthorizeUser parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SefteOuterClass$ResponseAuthorizeUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SefteOuterClass$ResponseAuthorizeUser parseFrom(byte[] bArr) {
        return (SefteOuterClass$ResponseAuthorizeUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SefteOuterClass$ResponseAuthorizeUser parseFrom(byte[] bArr, C2394s c2394s) {
        return (SefteOuterClass$ResponseAuthorizeUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SefteOuterClass$ResponseAuthorizeUser parseFrom(InputStream inputStream) {
        return (SefteOuterClass$ResponseAuthorizeUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SefteOuterClass$ResponseAuthorizeUser parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SefteOuterClass$ResponseAuthorizeUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SefteOuterClass$ResponseAuthorizeUser parseFrom(AbstractC2384h abstractC2384h) {
        return (SefteOuterClass$ResponseAuthorizeUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SefteOuterClass$ResponseAuthorizeUser parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SefteOuterClass$ResponseAuthorizeUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
