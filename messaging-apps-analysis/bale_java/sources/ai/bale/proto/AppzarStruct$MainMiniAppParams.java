package ai.bale.proto;

import ai.bale.proto.PeersStruct$ExPeer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class AppzarStruct$MainMiniAppParams extends GeneratedMessageLite implements U64 {
    private static final AppzarStruct$MainMiniAppParams DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 2;
    public static final int START_PARAM_FIELD_NUMBER = 1;
    private int bitField0_;
    private PeersStruct$ExPeer peer_;
    private StringValue startParam_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(PeersStruct$ExPeer peersStruct$ExPeer) {
            q();
            ((AppzarStruct$MainMiniAppParams) this.b).setPeer(peersStruct$ExPeer);
            return this;
        }

        public a B(StringValue stringValue) {
            q();
            ((AppzarStruct$MainMiniAppParams) this.b).setStartParam(stringValue);
            return this;
        }

        private a() {
            super(AppzarStruct$MainMiniAppParams.DEFAULT_INSTANCE);
        }
    }

    static {
        AppzarStruct$MainMiniAppParams appzarStruct$MainMiniAppParams = new AppzarStruct$MainMiniAppParams();
        DEFAULT_INSTANCE = appzarStruct$MainMiniAppParams;
        GeneratedMessageLite.registerDefaultInstance(AppzarStruct$MainMiniAppParams.class, appzarStruct$MainMiniAppParams);
    }

    private AppzarStruct$MainMiniAppParams() {
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -3;
    }

    private void clearStartParam() {
        this.startParam_ = null;
        this.bitField0_ &= -2;
    }

    public static AppzarStruct$MainMiniAppParams getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        PeersStruct$ExPeer peersStruct$ExPeer2 = this.peer_;
        if (peersStruct$ExPeer2 == null || peersStruct$ExPeer2 == PeersStruct$ExPeer.getDefaultInstance()) {
            this.peer_ = peersStruct$ExPeer;
        } else {
            this.peer_ = (PeersStruct$ExPeer) ((PeersStruct$ExPeer.a) PeersStruct$ExPeer.newBuilder(this.peer_).v(peersStruct$ExPeer)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeStartParam(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.startParam_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.startParam_ = stringValue;
        } else {
            this.startParam_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.startParam_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AppzarStruct$MainMiniAppParams parseDelimitedFrom(InputStream inputStream) {
        return (AppzarStruct$MainMiniAppParams) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AppzarStruct$MainMiniAppParams parseFrom(ByteBuffer byteBuffer) {
        return (AppzarStruct$MainMiniAppParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        this.peer_ = peersStruct$ExPeer;
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStartParam(StringValue stringValue) {
        stringValue.getClass();
        this.startParam_ = stringValue;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1858h.a[gVar.ordinal()]) {
            case 1:
                return new AppzarStruct$MainMiniAppParams();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"bitField0_", "startParam_", "peer_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AppzarStruct$MainMiniAppParams.class) {
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

    public PeersStruct$ExPeer getPeer() {
        PeersStruct$ExPeer peersStruct$ExPeer = this.peer_;
        return peersStruct$ExPeer == null ? PeersStruct$ExPeer.getDefaultInstance() : peersStruct$ExPeer;
    }

    public StringValue getStartParam() {
        StringValue stringValue = this.startParam_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasStartParam() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(AppzarStruct$MainMiniAppParams appzarStruct$MainMiniAppParams) {
        return (a) DEFAULT_INSTANCE.createBuilder(appzarStruct$MainMiniAppParams);
    }

    public static AppzarStruct$MainMiniAppParams parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AppzarStruct$MainMiniAppParams) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AppzarStruct$MainMiniAppParams parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AppzarStruct$MainMiniAppParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AppzarStruct$MainMiniAppParams parseFrom(AbstractC2383g abstractC2383g) {
        return (AppzarStruct$MainMiniAppParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AppzarStruct$MainMiniAppParams parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AppzarStruct$MainMiniAppParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AppzarStruct$MainMiniAppParams parseFrom(byte[] bArr) {
        return (AppzarStruct$MainMiniAppParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AppzarStruct$MainMiniAppParams parseFrom(byte[] bArr, C2394s c2394s) {
        return (AppzarStruct$MainMiniAppParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AppzarStruct$MainMiniAppParams parseFrom(InputStream inputStream) {
        return (AppzarStruct$MainMiniAppParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AppzarStruct$MainMiniAppParams parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AppzarStruct$MainMiniAppParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AppzarStruct$MainMiniAppParams parseFrom(AbstractC2384h abstractC2384h) {
        return (AppzarStruct$MainMiniAppParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AppzarStruct$MainMiniAppParams parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AppzarStruct$MainMiniAppParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
