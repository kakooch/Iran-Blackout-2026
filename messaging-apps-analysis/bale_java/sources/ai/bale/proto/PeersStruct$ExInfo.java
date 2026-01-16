package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.EnumC10088b35;
import ir.nasim.EnumC15129j35;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class PeersStruct$ExInfo extends GeneratedMessageLite implements U64 {
    private static final PeersStruct$ExInfo DEFAULT_INSTANCE;
    public static final int EX_PEER_TYPE_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int PEER_CATEGORY_FIELD_NUMBER = 3;
    public static final int PEER_IDENTITY_FIELD_NUMBER = 2;
    private int bitField0_;
    private int exPeerType_;
    private StringValue peerCategory_;
    private int peerIdentity_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PeersStruct$ExInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        PeersStruct$ExInfo peersStruct$ExInfo = new PeersStruct$ExInfo();
        DEFAULT_INSTANCE = peersStruct$ExInfo;
        GeneratedMessageLite.registerDefaultInstance(PeersStruct$ExInfo.class, peersStruct$ExInfo);
    }

    private PeersStruct$ExInfo() {
    }

    private void clearExPeerType() {
        this.exPeerType_ = 0;
    }

    private void clearPeerCategory() {
        this.peerCategory_ = null;
        this.bitField0_ &= -2;
    }

    private void clearPeerIdentity() {
        this.peerIdentity_ = 0;
    }

    public static PeersStruct$ExInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePeerCategory(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.peerCategory_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.peerCategory_ = stringValue;
        } else {
            this.peerCategory_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.peerCategory_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PeersStruct$ExInfo parseDelimitedFrom(InputStream inputStream) {
        return (PeersStruct$ExInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PeersStruct$ExInfo parseFrom(ByteBuffer byteBuffer) {
        return (PeersStruct$ExInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setExPeerType(EnumC10088b35 enumC10088b35) {
        this.exPeerType_ = enumC10088b35.getNumber();
    }

    private void setExPeerTypeValue(int i) {
        this.exPeerType_ = i;
    }

    private void setPeerCategory(StringValue stringValue) {
        stringValue.getClass();
        this.peerCategory_ = stringValue;
        this.bitField0_ |= 1;
    }

    private void setPeerIdentity(EnumC15129j35 enumC15129j35) {
        this.peerIdentity_ = enumC15129j35.getNumber();
    }

    private void setPeerIdentityValue(int i) {
        this.peerIdentity_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1845c1.a[gVar.ordinal()]) {
            case 1:
                return new PeersStruct$ExInfo();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u0003ဉ\u0000", new Object[]{"bitField0_", "exPeerType_", "peerIdentity_", "peerCategory_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PeersStruct$ExInfo.class) {
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

    public EnumC10088b35 getExPeerType() {
        EnumC10088b35 enumC10088b35J = EnumC10088b35.j(this.exPeerType_);
        return enumC10088b35J == null ? EnumC10088b35.UNRECOGNIZED : enumC10088b35J;
    }

    public int getExPeerTypeValue() {
        return this.exPeerType_;
    }

    public StringValue getPeerCategory() {
        StringValue stringValue = this.peerCategory_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public EnumC15129j35 getPeerIdentity() {
        EnumC15129j35 enumC15129j35J = EnumC15129j35.j(this.peerIdentity_);
        return enumC15129j35J == null ? EnumC15129j35.UNRECOGNIZED : enumC15129j35J;
    }

    public int getPeerIdentityValue() {
        return this.peerIdentity_;
    }

    public boolean hasPeerCategory() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(PeersStruct$ExInfo peersStruct$ExInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(peersStruct$ExInfo);
    }

    public static PeersStruct$ExInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PeersStruct$ExInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PeersStruct$ExInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PeersStruct$ExInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PeersStruct$ExInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (PeersStruct$ExInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PeersStruct$ExInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PeersStruct$ExInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PeersStruct$ExInfo parseFrom(byte[] bArr) {
        return (PeersStruct$ExInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PeersStruct$ExInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (PeersStruct$ExInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PeersStruct$ExInfo parseFrom(InputStream inputStream) {
        return (PeersStruct$ExInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PeersStruct$ExInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PeersStruct$ExInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PeersStruct$ExInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (PeersStruct$ExInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PeersStruct$ExInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PeersStruct$ExInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
