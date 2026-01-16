package ai.bale.proto;

import ai.bale.proto.PeersStruct$ExPeer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC8956Xy5;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class PushStruct$PeerConfig extends GeneratedMessageLite implements U64 {
    private static final PushStruct$PeerConfig DEFAULT_INSTANCE;
    public static final int ENABLE_FIELD_NUMBER = 3;
    public static final int EX_PEER_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int TYPE_FIELD_NUMBER = 2;
    private int bitField0_;
    private boolean enable_;
    private PeersStruct$ExPeer exPeer_;
    private int type_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PushStruct$PeerConfig.DEFAULT_INSTANCE);
        }
    }

    static {
        PushStruct$PeerConfig pushStruct$PeerConfig = new PushStruct$PeerConfig();
        DEFAULT_INSTANCE = pushStruct$PeerConfig;
        GeneratedMessageLite.registerDefaultInstance(PushStruct$PeerConfig.class, pushStruct$PeerConfig);
    }

    private PushStruct$PeerConfig() {
    }

    private void clearEnable() {
        this.enable_ = false;
    }

    private void clearExPeer() {
        this.exPeer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearType() {
        this.type_ = 0;
    }

    public static PushStruct$PeerConfig getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeExPeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        PeersStruct$ExPeer peersStruct$ExPeer2 = this.exPeer_;
        if (peersStruct$ExPeer2 == null || peersStruct$ExPeer2 == PeersStruct$ExPeer.getDefaultInstance()) {
            this.exPeer_ = peersStruct$ExPeer;
        } else {
            this.exPeer_ = (PeersStruct$ExPeer) ((PeersStruct$ExPeer.a) PeersStruct$ExPeer.newBuilder(this.exPeer_).v(peersStruct$ExPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PushStruct$PeerConfig parseDelimitedFrom(InputStream inputStream) {
        return (PushStruct$PeerConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PushStruct$PeerConfig parseFrom(ByteBuffer byteBuffer) {
        return (PushStruct$PeerConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setEnable(boolean z) {
        this.enable_ = z;
    }

    private void setExPeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        this.exPeer_ = peersStruct$ExPeer;
        this.bitField0_ |= 1;
    }

    private void setType(EnumC8956Xy5 enumC8956Xy5) {
        this.type_ = enumC8956Xy5.getNumber();
    }

    private void setTypeValue(int i) {
        this.type_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1881o1.a[gVar.ordinal()]) {
            case 1:
                return new PushStruct$PeerConfig();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002\f\u0003\u0007", new Object[]{"bitField0_", "exPeer_", "type_", "enable_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PushStruct$PeerConfig.class) {
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

    public boolean getEnable() {
        return this.enable_;
    }

    public PeersStruct$ExPeer getExPeer() {
        PeersStruct$ExPeer peersStruct$ExPeer = this.exPeer_;
        return peersStruct$ExPeer == null ? PeersStruct$ExPeer.getDefaultInstance() : peersStruct$ExPeer;
    }

    public EnumC8956Xy5 getType() {
        EnumC8956Xy5 enumC8956Xy5J = EnumC8956Xy5.j(this.type_);
        return enumC8956Xy5J == null ? EnumC8956Xy5.UNRECOGNIZED : enumC8956Xy5J;
    }

    public int getTypeValue() {
        return this.type_;
    }

    public boolean hasExPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(PushStruct$PeerConfig pushStruct$PeerConfig) {
        return (a) DEFAULT_INSTANCE.createBuilder(pushStruct$PeerConfig);
    }

    public static PushStruct$PeerConfig parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PushStruct$PeerConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PushStruct$PeerConfig parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PushStruct$PeerConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PushStruct$PeerConfig parseFrom(AbstractC2383g abstractC2383g) {
        return (PushStruct$PeerConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PushStruct$PeerConfig parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PushStruct$PeerConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PushStruct$PeerConfig parseFrom(byte[] bArr) {
        return (PushStruct$PeerConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PushStruct$PeerConfig parseFrom(byte[] bArr, C2394s c2394s) {
        return (PushStruct$PeerConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PushStruct$PeerConfig parseFrom(InputStream inputStream) {
        return (PushStruct$PeerConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PushStruct$PeerConfig parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PushStruct$PeerConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PushStruct$PeerConfig parseFrom(AbstractC2384h abstractC2384h) {
        return (PushStruct$PeerConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PushStruct$PeerConfig parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PushStruct$PeerConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
