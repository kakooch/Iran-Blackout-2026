package ai.bale.proto;

import ai.bale.proto.MtprotoInternal$AuthData;
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
public final class MtprotoInternal$ClientData extends GeneratedMessageLite implements U64 {
    public static final int AUTH_DATA_FIELD_NUMBER = 3;
    public static final int AUTH_ID_FIELD_NUMBER = 1;
    private static final MtprotoInternal$ClientData DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int REMOTE_ADDR_FIELD_NUMBER = 4;
    public static final int SESSION_ID_FIELD_NUMBER = 2;
    private MtprotoInternal$AuthData authData_;
    private long authId_;
    private int bitField0_;
    private String remoteAddr_ = "";
    private long sessionId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MtprotoInternal$ClientData.DEFAULT_INSTANCE);
        }
    }

    static {
        MtprotoInternal$ClientData mtprotoInternal$ClientData = new MtprotoInternal$ClientData();
        DEFAULT_INSTANCE = mtprotoInternal$ClientData;
        GeneratedMessageLite.registerDefaultInstance(MtprotoInternal$ClientData.class, mtprotoInternal$ClientData);
    }

    private MtprotoInternal$ClientData() {
    }

    private void clearAuthData() {
        this.authData_ = null;
        this.bitField0_ &= -2;
    }

    private void clearAuthId() {
        this.authId_ = 0L;
    }

    private void clearRemoteAddr() {
        this.remoteAddr_ = getDefaultInstance().getRemoteAddr();
    }

    private void clearSessionId() {
        this.sessionId_ = 0L;
    }

    public static MtprotoInternal$ClientData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAuthData(MtprotoInternal$AuthData mtprotoInternal$AuthData) {
        mtprotoInternal$AuthData.getClass();
        MtprotoInternal$AuthData mtprotoInternal$AuthData2 = this.authData_;
        if (mtprotoInternal$AuthData2 == null || mtprotoInternal$AuthData2 == MtprotoInternal$AuthData.getDefaultInstance()) {
            this.authData_ = mtprotoInternal$AuthData;
        } else {
            this.authData_ = (MtprotoInternal$AuthData) ((MtprotoInternal$AuthData.a) MtprotoInternal$AuthData.newBuilder(this.authData_).v(mtprotoInternal$AuthData)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MtprotoInternal$ClientData parseDelimitedFrom(InputStream inputStream) {
        return (MtprotoInternal$ClientData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MtprotoInternal$ClientData parseFrom(ByteBuffer byteBuffer) {
        return (MtprotoInternal$ClientData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAuthData(MtprotoInternal$AuthData mtprotoInternal$AuthData) {
        mtprotoInternal$AuthData.getClass();
        this.authData_ = mtprotoInternal$AuthData;
        this.bitField0_ |= 1;
    }

    private void setAuthId(long j) {
        this.authId_ = j;
    }

    private void setRemoteAddr(String str) {
        str.getClass();
        this.remoteAddr_ = str;
    }

    private void setRemoteAddrBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.remoteAddr_ = abstractC2383g.f0();
    }

    private void setSessionId(long j) {
        this.sessionId_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (P0.a[gVar.ordinal()]) {
            case 1:
                return new MtprotoInternal$ClientData();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0002\u0002\u0002\u0003ဉ\u0000\u0004Ȉ", new Object[]{"bitField0_", "authId_", "sessionId_", "authData_", "remoteAddr_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MtprotoInternal$ClientData.class) {
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

    public MtprotoInternal$AuthData getAuthData() {
        MtprotoInternal$AuthData mtprotoInternal$AuthData = this.authData_;
        return mtprotoInternal$AuthData == null ? MtprotoInternal$AuthData.getDefaultInstance() : mtprotoInternal$AuthData;
    }

    public long getAuthId() {
        return this.authId_;
    }

    public String getRemoteAddr() {
        return this.remoteAddr_;
    }

    public AbstractC2383g getRemoteAddrBytes() {
        return AbstractC2383g.N(this.remoteAddr_);
    }

    public long getSessionId() {
        return this.sessionId_;
    }

    public boolean hasAuthData() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MtprotoInternal$ClientData mtprotoInternal$ClientData) {
        return (a) DEFAULT_INSTANCE.createBuilder(mtprotoInternal$ClientData);
    }

    public static MtprotoInternal$ClientData parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MtprotoInternal$ClientData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MtprotoInternal$ClientData parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MtprotoInternal$ClientData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MtprotoInternal$ClientData parseFrom(AbstractC2383g abstractC2383g) {
        return (MtprotoInternal$ClientData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MtprotoInternal$ClientData parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MtprotoInternal$ClientData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MtprotoInternal$ClientData parseFrom(byte[] bArr) {
        return (MtprotoInternal$ClientData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MtprotoInternal$ClientData parseFrom(byte[] bArr, C2394s c2394s) {
        return (MtprotoInternal$ClientData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MtprotoInternal$ClientData parseFrom(InputStream inputStream) {
        return (MtprotoInternal$ClientData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MtprotoInternal$ClientData parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MtprotoInternal$ClientData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MtprotoInternal$ClientData parseFrom(AbstractC2384h abstractC2384h) {
        return (MtprotoInternal$ClientData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MtprotoInternal$ClientData parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MtprotoInternal$ClientData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
