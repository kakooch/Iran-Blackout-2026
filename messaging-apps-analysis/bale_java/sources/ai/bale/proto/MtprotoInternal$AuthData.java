package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MtprotoInternal$AuthData extends GeneratedMessageLite implements U64 {
    public static final int APP_ID_FIELD_NUMBER = 3;
    public static final int AUTH_SID_FIELD_NUMBER = 2;
    private static final MtprotoInternal$AuthData DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int USER_ID_FIELD_NUMBER = 1;
    private int appId_;
    private int authSid_;
    private int userId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MtprotoInternal$AuthData.DEFAULT_INSTANCE);
        }
    }

    static {
        MtprotoInternal$AuthData mtprotoInternal$AuthData = new MtprotoInternal$AuthData();
        DEFAULT_INSTANCE = mtprotoInternal$AuthData;
        GeneratedMessageLite.registerDefaultInstance(MtprotoInternal$AuthData.class, mtprotoInternal$AuthData);
    }

    private MtprotoInternal$AuthData() {
    }

    private void clearAppId() {
        this.appId_ = 0;
    }

    private void clearAuthSid() {
        this.authSid_ = 0;
    }

    private void clearUserId() {
        this.userId_ = 0;
    }

    public static MtprotoInternal$AuthData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MtprotoInternal$AuthData parseDelimitedFrom(InputStream inputStream) {
        return (MtprotoInternal$AuthData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MtprotoInternal$AuthData parseFrom(ByteBuffer byteBuffer) {
        return (MtprotoInternal$AuthData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAppId(int i) {
        this.appId_ = i;
    }

    private void setAuthSid(int i) {
        this.authSid_ = i;
    }

    private void setUserId(int i) {
        this.userId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (P0.a[gVar.ordinal()]) {
            case 1:
                return new MtprotoInternal$AuthData();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0002\u0004\u0003\u0004", new Object[]{"userId_", "authSid_", "appId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MtprotoInternal$AuthData.class) {
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

    public int getAppId() {
        return this.appId_;
    }

    public int getAuthSid() {
        return this.authSid_;
    }

    public int getUserId() {
        return this.userId_;
    }

    public static a newBuilder(MtprotoInternal$AuthData mtprotoInternal$AuthData) {
        return (a) DEFAULT_INSTANCE.createBuilder(mtprotoInternal$AuthData);
    }

    public static MtprotoInternal$AuthData parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MtprotoInternal$AuthData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MtprotoInternal$AuthData parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MtprotoInternal$AuthData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MtprotoInternal$AuthData parseFrom(AbstractC2383g abstractC2383g) {
        return (MtprotoInternal$AuthData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MtprotoInternal$AuthData parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MtprotoInternal$AuthData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MtprotoInternal$AuthData parseFrom(byte[] bArr) {
        return (MtprotoInternal$AuthData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MtprotoInternal$AuthData parseFrom(byte[] bArr, C2394s c2394s) {
        return (MtprotoInternal$AuthData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MtprotoInternal$AuthData parseFrom(InputStream inputStream) {
        return (MtprotoInternal$AuthData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MtprotoInternal$AuthData parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MtprotoInternal$AuthData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MtprotoInternal$AuthData parseFrom(AbstractC2384h abstractC2384h) {
        return (MtprotoInternal$AuthData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MtprotoInternal$AuthData parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MtprotoInternal$AuthData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
