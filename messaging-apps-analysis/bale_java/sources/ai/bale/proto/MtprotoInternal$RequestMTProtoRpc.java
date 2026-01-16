package ai.bale.proto;

import ai.bale.proto.MtprotoInternal$ClientData;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MtprotoInternal$RequestMTProtoRpc extends GeneratedMessageLite implements U64 {
    public static final int CLIENT_DATA_FIELD_NUMBER = 1;
    private static final MtprotoInternal$RequestMTProtoRpc DEFAULT_INSTANCE;
    public static final int MESSAGE_ID_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int PAYLOAD_FIELD_NUMBER = 2;
    private int bitField0_;
    private MtprotoInternal$ClientData clientData_;
    private long messageId_;
    private AbstractC2383g payload_ = AbstractC2383g.b;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MtprotoInternal$RequestMTProtoRpc.DEFAULT_INSTANCE);
        }
    }

    static {
        MtprotoInternal$RequestMTProtoRpc mtprotoInternal$RequestMTProtoRpc = new MtprotoInternal$RequestMTProtoRpc();
        DEFAULT_INSTANCE = mtprotoInternal$RequestMTProtoRpc;
        GeneratedMessageLite.registerDefaultInstance(MtprotoInternal$RequestMTProtoRpc.class, mtprotoInternal$RequestMTProtoRpc);
    }

    private MtprotoInternal$RequestMTProtoRpc() {
    }

    private void clearClientData() {
        this.clientData_ = null;
        this.bitField0_ &= -2;
    }

    private void clearMessageId() {
        this.messageId_ = 0L;
    }

    private void clearPayload() {
        this.payload_ = getDefaultInstance().getPayload();
    }

    public static MtprotoInternal$RequestMTProtoRpc getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeClientData(MtprotoInternal$ClientData mtprotoInternal$ClientData) {
        mtprotoInternal$ClientData.getClass();
        MtprotoInternal$ClientData mtprotoInternal$ClientData2 = this.clientData_;
        if (mtprotoInternal$ClientData2 == null || mtprotoInternal$ClientData2 == MtprotoInternal$ClientData.getDefaultInstance()) {
            this.clientData_ = mtprotoInternal$ClientData;
        } else {
            this.clientData_ = (MtprotoInternal$ClientData) ((MtprotoInternal$ClientData.a) MtprotoInternal$ClientData.newBuilder(this.clientData_).v(mtprotoInternal$ClientData)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MtprotoInternal$RequestMTProtoRpc parseDelimitedFrom(InputStream inputStream) {
        return (MtprotoInternal$RequestMTProtoRpc) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MtprotoInternal$RequestMTProtoRpc parseFrom(ByteBuffer byteBuffer) {
        return (MtprotoInternal$RequestMTProtoRpc) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setClientData(MtprotoInternal$ClientData mtprotoInternal$ClientData) {
        mtprotoInternal$ClientData.getClass();
        this.clientData_ = mtprotoInternal$ClientData;
        this.bitField0_ |= 1;
    }

    private void setMessageId(long j) {
        this.messageId_ = j;
    }

    private void setPayload(AbstractC2383g abstractC2383g) {
        abstractC2383g.getClass();
        this.payload_ = abstractC2383g;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (P0.a[gVar.ordinal()]) {
            case 1:
                return new MtprotoInternal$RequestMTProtoRpc();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002\n\u0003\u0002", new Object[]{"bitField0_", "clientData_", "payload_", "messageId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MtprotoInternal$RequestMTProtoRpc.class) {
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

    public MtprotoInternal$ClientData getClientData() {
        MtprotoInternal$ClientData mtprotoInternal$ClientData = this.clientData_;
        return mtprotoInternal$ClientData == null ? MtprotoInternal$ClientData.getDefaultInstance() : mtprotoInternal$ClientData;
    }

    public long getMessageId() {
        return this.messageId_;
    }

    public AbstractC2383g getPayload() {
        return this.payload_;
    }

    public boolean hasClientData() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MtprotoInternal$RequestMTProtoRpc mtprotoInternal$RequestMTProtoRpc) {
        return (a) DEFAULT_INSTANCE.createBuilder(mtprotoInternal$RequestMTProtoRpc);
    }

    public static MtprotoInternal$RequestMTProtoRpc parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MtprotoInternal$RequestMTProtoRpc) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MtprotoInternal$RequestMTProtoRpc parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MtprotoInternal$RequestMTProtoRpc) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MtprotoInternal$RequestMTProtoRpc parseFrom(AbstractC2383g abstractC2383g) {
        return (MtprotoInternal$RequestMTProtoRpc) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MtprotoInternal$RequestMTProtoRpc parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MtprotoInternal$RequestMTProtoRpc) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MtprotoInternal$RequestMTProtoRpc parseFrom(byte[] bArr) {
        return (MtprotoInternal$RequestMTProtoRpc) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MtprotoInternal$RequestMTProtoRpc parseFrom(byte[] bArr, C2394s c2394s) {
        return (MtprotoInternal$RequestMTProtoRpc) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MtprotoInternal$RequestMTProtoRpc parseFrom(InputStream inputStream) {
        return (MtprotoInternal$RequestMTProtoRpc) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MtprotoInternal$RequestMTProtoRpc parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MtprotoInternal$RequestMTProtoRpc) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MtprotoInternal$RequestMTProtoRpc parseFrom(AbstractC2384h abstractC2384h) {
        return (MtprotoInternal$RequestMTProtoRpc) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MtprotoInternal$RequestMTProtoRpc parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MtprotoInternal$RequestMTProtoRpc) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
