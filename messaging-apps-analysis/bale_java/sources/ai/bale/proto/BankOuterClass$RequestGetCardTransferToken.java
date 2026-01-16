package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int64Value;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int32Value;
import com.google.protobuf.StringValue;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class BankOuterClass$RequestGetCardTransferToken extends GeneratedMessageLite implements U64 {
    private static final BankOuterClass$RequestGetCardTransferToken DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 3;
    public static final int MSG_RID_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int PEER_USER_ID_FIELD_NUMBER = 1;
    private int bitField0_;
    private StringValue description_;
    private CollectionsStruct$Int64Value msgRid_;
    private Int32Value peerUserId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BankOuterClass$RequestGetCardTransferToken.DEFAULT_INSTANCE);
        }
    }

    static {
        BankOuterClass$RequestGetCardTransferToken bankOuterClass$RequestGetCardTransferToken = new BankOuterClass$RequestGetCardTransferToken();
        DEFAULT_INSTANCE = bankOuterClass$RequestGetCardTransferToken;
        GeneratedMessageLite.registerDefaultInstance(BankOuterClass$RequestGetCardTransferToken.class, bankOuterClass$RequestGetCardTransferToken);
    }

    private BankOuterClass$RequestGetCardTransferToken() {
    }

    private void clearDescription() {
        this.description_ = null;
        this.bitField0_ &= -5;
    }

    private void clearMsgRid() {
        this.msgRid_ = null;
        this.bitField0_ &= -3;
    }

    private void clearPeerUserId() {
        this.peerUserId_ = null;
        this.bitField0_ &= -2;
    }

    public static BankOuterClass$RequestGetCardTransferToken getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeDescription(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.description_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.description_ = stringValue;
        } else {
            this.description_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.description_).v(stringValue)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeMsgRid(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.msgRid_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.msgRid_ = collectionsStruct$Int64Value;
        } else {
            this.msgRid_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.msgRid_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergePeerUserId(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.peerUserId_;
        if (int32Value2 == null || int32Value2 == Int32Value.getDefaultInstance()) {
            this.peerUserId_ = int32Value;
        } else {
            this.peerUserId_ = (Int32Value) ((Int32Value.b) Int32Value.newBuilder(this.peerUserId_).v(int32Value)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BankOuterClass$RequestGetCardTransferToken parseDelimitedFrom(InputStream inputStream) {
        return (BankOuterClass$RequestGetCardTransferToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankOuterClass$RequestGetCardTransferToken parseFrom(ByteBuffer byteBuffer) {
        return (BankOuterClass$RequestGetCardTransferToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDescription(StringValue stringValue) {
        stringValue.getClass();
        this.description_ = stringValue;
        this.bitField0_ |= 4;
    }

    private void setMsgRid(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.msgRid_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 2;
    }

    private void setPeerUserId(Int32Value int32Value) {
        int32Value.getClass();
        this.peerUserId_ = int32Value;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1876n.a[gVar.ordinal()]) {
            case 1:
                return new BankOuterClass$RequestGetCardTransferToken();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"bitField0_", "peerUserId_", "msgRid_", "description_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BankOuterClass$RequestGetCardTransferToken.class) {
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

    public StringValue getDescription() {
        StringValue stringValue = this.description_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public CollectionsStruct$Int64Value getMsgRid() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.msgRid_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public Int32Value getPeerUserId() {
        Int32Value int32Value = this.peerUserId_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public boolean hasDescription() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasMsgRid() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasPeerUserId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(BankOuterClass$RequestGetCardTransferToken bankOuterClass$RequestGetCardTransferToken) {
        return (a) DEFAULT_INSTANCE.createBuilder(bankOuterClass$RequestGetCardTransferToken);
    }

    public static BankOuterClass$RequestGetCardTransferToken parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BankOuterClass$RequestGetCardTransferToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankOuterClass$RequestGetCardTransferToken parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BankOuterClass$RequestGetCardTransferToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BankOuterClass$RequestGetCardTransferToken parseFrom(AbstractC2383g abstractC2383g) {
        return (BankOuterClass$RequestGetCardTransferToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BankOuterClass$RequestGetCardTransferToken parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BankOuterClass$RequestGetCardTransferToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BankOuterClass$RequestGetCardTransferToken parseFrom(byte[] bArr) {
        return (BankOuterClass$RequestGetCardTransferToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BankOuterClass$RequestGetCardTransferToken parseFrom(byte[] bArr, C2394s c2394s) {
        return (BankOuterClass$RequestGetCardTransferToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BankOuterClass$RequestGetCardTransferToken parseFrom(InputStream inputStream) {
        return (BankOuterClass$RequestGetCardTransferToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankOuterClass$RequestGetCardTransferToken parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BankOuterClass$RequestGetCardTransferToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankOuterClass$RequestGetCardTransferToken parseFrom(AbstractC2384h abstractC2384h) {
        return (BankOuterClass$RequestGetCardTransferToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BankOuterClass$RequestGetCardTransferToken parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BankOuterClass$RequestGetCardTransferToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
