package ai.bale.proto;

import ai.bale.proto.RpcEnvelopOuterClass$RpcError;
import ai.bale.proto.SetRpcStruct$ComposedRpc;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.P66;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class RpcEnvelopOuterClass$RpcEnvelop extends GeneratedMessageLite implements U64 {
    public static final int AUTH_ID_FIELD_NUMBER = 2;
    public static final int AUTH_SID_FIELD_NUMBER = 3;
    public static final int CLIENT_TYPE_FIELD_NUMBER = 5;
    private static final RpcEnvelopOuterClass$RpcEnvelop DEFAULT_INSTANCE;
    public static final int ERROR_FIELD_NUMBER = 7;
    public static final int LATENCY_FIELD_NUMBER = 9;
    private static volatile KW4 PARSER = null;
    public static final int REMOTE_ADDR_FIELD_NUMBER = 4;
    public static final int REQUEST_FIELD_NUMBER = 6;
    public static final int RSP_FIELD_NUMBER = 8;
    public static final int USER_ID_FIELD_NUMBER = 1;
    private long authId_;
    private int authSid_;
    private int bitField0_;
    private int clientType_;
    private long latency_;
    private SetRpcStruct$ComposedRpc request_;
    private Object response_;
    private int userId_;
    private int responseCase_ = 0;
    private String remoteAddr_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(RpcEnvelopOuterClass$RpcEnvelop.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        ERROR(7),
        RSP(8),
        RESPONSE_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return RESPONSE_NOT_SET;
            }
            if (i == 7) {
                return ERROR;
            }
            if (i != 8) {
                return null;
            }
            return RSP;
        }
    }

    static {
        RpcEnvelopOuterClass$RpcEnvelop rpcEnvelopOuterClass$RpcEnvelop = new RpcEnvelopOuterClass$RpcEnvelop();
        DEFAULT_INSTANCE = rpcEnvelopOuterClass$RpcEnvelop;
        GeneratedMessageLite.registerDefaultInstance(RpcEnvelopOuterClass$RpcEnvelop.class, rpcEnvelopOuterClass$RpcEnvelop);
    }

    private RpcEnvelopOuterClass$RpcEnvelop() {
    }

    private void clearAuthId() {
        this.authId_ = 0L;
    }

    private void clearAuthSid() {
        this.authSid_ = 0;
    }

    private void clearClientType() {
        this.clientType_ = 0;
    }

    private void clearError() {
        if (this.responseCase_ == 7) {
            this.responseCase_ = 0;
            this.response_ = null;
        }
    }

    private void clearLatency() {
        this.latency_ = 0L;
    }

    private void clearRemoteAddr() {
        this.remoteAddr_ = getDefaultInstance().getRemoteAddr();
    }

    private void clearRequest() {
        this.request_ = null;
        this.bitField0_ &= -2;
    }

    private void clearResponse() {
        this.responseCase_ = 0;
        this.response_ = null;
    }

    private void clearRsp() {
        if (this.responseCase_ == 8) {
            this.responseCase_ = 0;
            this.response_ = null;
        }
    }

    private void clearUserId() {
        this.userId_ = 0;
    }

    public static RpcEnvelopOuterClass$RpcEnvelop getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeError(RpcEnvelopOuterClass$RpcError rpcEnvelopOuterClass$RpcError) {
        rpcEnvelopOuterClass$RpcError.getClass();
        if (this.responseCase_ != 7 || this.response_ == RpcEnvelopOuterClass$RpcError.getDefaultInstance()) {
            this.response_ = rpcEnvelopOuterClass$RpcError;
        } else {
            this.response_ = ((RpcEnvelopOuterClass$RpcError.a) RpcEnvelopOuterClass$RpcError.newBuilder((RpcEnvelopOuterClass$RpcError) this.response_).v(rpcEnvelopOuterClass$RpcError)).j();
        }
        this.responseCase_ = 7;
    }

    private void mergeRequest(SetRpcStruct$ComposedRpc setRpcStruct$ComposedRpc) {
        setRpcStruct$ComposedRpc.getClass();
        SetRpcStruct$ComposedRpc setRpcStruct$ComposedRpc2 = this.request_;
        if (setRpcStruct$ComposedRpc2 == null || setRpcStruct$ComposedRpc2 == SetRpcStruct$ComposedRpc.getDefaultInstance()) {
            this.request_ = setRpcStruct$ComposedRpc;
        } else {
            this.request_ = (SetRpcStruct$ComposedRpc) ((SetRpcStruct$ComposedRpc.a) SetRpcStruct$ComposedRpc.newBuilder(this.request_).v(setRpcStruct$ComposedRpc)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeRsp(SetRpcStruct$ComposedRpc setRpcStruct$ComposedRpc) {
        setRpcStruct$ComposedRpc.getClass();
        if (this.responseCase_ != 8 || this.response_ == SetRpcStruct$ComposedRpc.getDefaultInstance()) {
            this.response_ = setRpcStruct$ComposedRpc;
        } else {
            this.response_ = ((SetRpcStruct$ComposedRpc.a) SetRpcStruct$ComposedRpc.newBuilder((SetRpcStruct$ComposedRpc) this.response_).v(setRpcStruct$ComposedRpc)).j();
        }
        this.responseCase_ = 8;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static RpcEnvelopOuterClass$RpcEnvelop parseDelimitedFrom(InputStream inputStream) {
        return (RpcEnvelopOuterClass$RpcEnvelop) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RpcEnvelopOuterClass$RpcEnvelop parseFrom(ByteBuffer byteBuffer) {
        return (RpcEnvelopOuterClass$RpcEnvelop) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAuthId(long j) {
        this.authId_ = j;
    }

    private void setAuthSid(int i) {
        this.authSid_ = i;
    }

    private void setClientType(P66 p66) {
        this.clientType_ = p66.getNumber();
    }

    private void setClientTypeValue(int i) {
        this.clientType_ = i;
    }

    private void setError(RpcEnvelopOuterClass$RpcError rpcEnvelopOuterClass$RpcError) {
        rpcEnvelopOuterClass$RpcError.getClass();
        this.response_ = rpcEnvelopOuterClass$RpcError;
        this.responseCase_ = 7;
    }

    private void setLatency(long j) {
        this.latency_ = j;
    }

    private void setRemoteAddr(String str) {
        str.getClass();
        this.remoteAddr_ = str;
    }

    private void setRemoteAddrBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.remoteAddr_ = abstractC2383g.f0();
    }

    private void setRequest(SetRpcStruct$ComposedRpc setRpcStruct$ComposedRpc) {
        setRpcStruct$ComposedRpc.getClass();
        this.request_ = setRpcStruct$ComposedRpc;
        this.bitField0_ |= 1;
    }

    private void setRsp(SetRpcStruct$ComposedRpc setRpcStruct$ComposedRpc) {
        setRpcStruct$ComposedRpc.getClass();
        this.response_ = setRpcStruct$ComposedRpc;
        this.responseCase_ = 8;
    }

    private void setUserId(int i) {
        this.userId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (A1.a[gVar.ordinal()]) {
            case 1:
                return new RpcEnvelopOuterClass$RpcEnvelop();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\t\u0001\u0001\u0001\t\t\u0000\u0000\u0000\u0001\u0004\u0002\u0002\u0003\u0004\u0004Ȉ\u0005\f\u0006ဉ\u0000\u0007<\u0000\b<\u0000\t\u0002", new Object[]{"response_", "responseCase_", "bitField0_", "userId_", "authId_", "authSid_", "remoteAddr_", "clientType_", "request_", RpcEnvelopOuterClass$RpcError.class, SetRpcStruct$ComposedRpc.class, "latency_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (RpcEnvelopOuterClass$RpcEnvelop.class) {
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

    public long getAuthId() {
        return this.authId_;
    }

    public int getAuthSid() {
        return this.authSid_;
    }

    public P66 getClientType() {
        P66 p66J = P66.j(this.clientType_);
        return p66J == null ? P66.UNRECOGNIZED : p66J;
    }

    public int getClientTypeValue() {
        return this.clientType_;
    }

    public RpcEnvelopOuterClass$RpcError getError() {
        return this.responseCase_ == 7 ? (RpcEnvelopOuterClass$RpcError) this.response_ : RpcEnvelopOuterClass$RpcError.getDefaultInstance();
    }

    public long getLatency() {
        return this.latency_;
    }

    public String getRemoteAddr() {
        return this.remoteAddr_;
    }

    public AbstractC2383g getRemoteAddrBytes() {
        return AbstractC2383g.N(this.remoteAddr_);
    }

    public SetRpcStruct$ComposedRpc getRequest() {
        SetRpcStruct$ComposedRpc setRpcStruct$ComposedRpc = this.request_;
        return setRpcStruct$ComposedRpc == null ? SetRpcStruct$ComposedRpc.getDefaultInstance() : setRpcStruct$ComposedRpc;
    }

    public b getResponseCase() {
        return b.j(this.responseCase_);
    }

    public SetRpcStruct$ComposedRpc getRsp() {
        return this.responseCase_ == 8 ? (SetRpcStruct$ComposedRpc) this.response_ : SetRpcStruct$ComposedRpc.getDefaultInstance();
    }

    public int getUserId() {
        return this.userId_;
    }

    public boolean hasError() {
        return this.responseCase_ == 7;
    }

    public boolean hasRequest() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasRsp() {
        return this.responseCase_ == 8;
    }

    public static a newBuilder(RpcEnvelopOuterClass$RpcEnvelop rpcEnvelopOuterClass$RpcEnvelop) {
        return (a) DEFAULT_INSTANCE.createBuilder(rpcEnvelopOuterClass$RpcEnvelop);
    }

    public static RpcEnvelopOuterClass$RpcEnvelop parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (RpcEnvelopOuterClass$RpcEnvelop) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static RpcEnvelopOuterClass$RpcEnvelop parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (RpcEnvelopOuterClass$RpcEnvelop) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static RpcEnvelopOuterClass$RpcEnvelop parseFrom(AbstractC2383g abstractC2383g) {
        return (RpcEnvelopOuterClass$RpcEnvelop) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static RpcEnvelopOuterClass$RpcEnvelop parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (RpcEnvelopOuterClass$RpcEnvelop) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static RpcEnvelopOuterClass$RpcEnvelop parseFrom(byte[] bArr) {
        return (RpcEnvelopOuterClass$RpcEnvelop) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static RpcEnvelopOuterClass$RpcEnvelop parseFrom(byte[] bArr, C2394s c2394s) {
        return (RpcEnvelopOuterClass$RpcEnvelop) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static RpcEnvelopOuterClass$RpcEnvelop parseFrom(InputStream inputStream) {
        return (RpcEnvelopOuterClass$RpcEnvelop) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RpcEnvelopOuterClass$RpcEnvelop parseFrom(InputStream inputStream, C2394s c2394s) {
        return (RpcEnvelopOuterClass$RpcEnvelop) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static RpcEnvelopOuterClass$RpcEnvelop parseFrom(AbstractC2384h abstractC2384h) {
        return (RpcEnvelopOuterClass$RpcEnvelop) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static RpcEnvelopOuterClass$RpcEnvelop parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (RpcEnvelopOuterClass$RpcEnvelop) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
