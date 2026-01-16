package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
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
public final class KifpoolOuterClass$RequestTransferMoney extends GeneratedMessageLite implements U64 {
    public static final int AMOUNT_FIELD_NUMBER = 5;
    private static final KifpoolOuterClass$RequestTransferMoney DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 6;
    public static final int DESTINATION_PHONE_FIELD_NUMBER = 3;
    public static final int DESTINATION_TOKEN_FIELD_NUMBER = 2;
    public static final int DESTINATION_USERID_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int SOURCE_TOKEN_FIELD_NUMBER = 1;
    private long amount_;
    private int bitField0_;
    private StringValue description_;
    private StringValue destinationPhone_;
    private StringValue destinationToken_;
    private Int32Value destinationUserid_;
    private String sourceToken_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KifpoolOuterClass$RequestTransferMoney.DEFAULT_INSTANCE);
        }
    }

    static {
        KifpoolOuterClass$RequestTransferMoney kifpoolOuterClass$RequestTransferMoney = new KifpoolOuterClass$RequestTransferMoney();
        DEFAULT_INSTANCE = kifpoolOuterClass$RequestTransferMoney;
        GeneratedMessageLite.registerDefaultInstance(KifpoolOuterClass$RequestTransferMoney.class, kifpoolOuterClass$RequestTransferMoney);
    }

    private KifpoolOuterClass$RequestTransferMoney() {
    }

    private void clearAmount() {
        this.amount_ = 0L;
    }

    private void clearDescription() {
        this.description_ = null;
        this.bitField0_ &= -9;
    }

    private void clearDestinationPhone() {
        this.destinationPhone_ = null;
        this.bitField0_ &= -3;
    }

    private void clearDestinationToken() {
        this.destinationToken_ = null;
        this.bitField0_ &= -2;
    }

    private void clearDestinationUserid() {
        this.destinationUserid_ = null;
        this.bitField0_ &= -5;
    }

    private void clearSourceToken() {
        this.sourceToken_ = getDefaultInstance().getSourceToken();
    }

    public static KifpoolOuterClass$RequestTransferMoney getDefaultInstance() {
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
        this.bitField0_ |= 8;
    }

    private void mergeDestinationPhone(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.destinationPhone_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.destinationPhone_ = stringValue;
        } else {
            this.destinationPhone_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.destinationPhone_).v(stringValue)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeDestinationToken(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.destinationToken_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.destinationToken_ = stringValue;
        } else {
            this.destinationToken_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.destinationToken_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeDestinationUserid(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.destinationUserid_;
        if (int32Value2 == null || int32Value2 == Int32Value.getDefaultInstance()) {
            this.destinationUserid_ = int32Value;
        } else {
            this.destinationUserid_ = (Int32Value) ((Int32Value.b) Int32Value.newBuilder(this.destinationUserid_).v(int32Value)).j();
        }
        this.bitField0_ |= 4;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KifpoolOuterClass$RequestTransferMoney parseDelimitedFrom(InputStream inputStream) {
        return (KifpoolOuterClass$RequestTransferMoney) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$RequestTransferMoney parseFrom(ByteBuffer byteBuffer) {
        return (KifpoolOuterClass$RequestTransferMoney) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAmount(long j) {
        this.amount_ = j;
    }

    private void setDescription(StringValue stringValue) {
        stringValue.getClass();
        this.description_ = stringValue;
        this.bitField0_ |= 8;
    }

    private void setDestinationPhone(StringValue stringValue) {
        stringValue.getClass();
        this.destinationPhone_ = stringValue;
        this.bitField0_ |= 2;
    }

    private void setDestinationToken(StringValue stringValue) {
        stringValue.getClass();
        this.destinationToken_ = stringValue;
        this.bitField0_ |= 1;
    }

    private void setDestinationUserid(Int32Value int32Value) {
        int32Value.getClass();
        this.destinationUserid_ = int32Value;
        this.bitField0_ |= 4;
    }

    private void setSourceToken(String str) {
        str.getClass();
        this.sourceToken_ = str;
    }

    private void setSourceTokenBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.sourceToken_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1897u0.a[gVar.ordinal()]) {
            case 1:
                return new KifpoolOuterClass$RequestTransferMoney();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000\u0003ဉ\u0001\u0004ဉ\u0002\u0005\u0002\u0006ဉ\u0003", new Object[]{"bitField0_", "sourceToken_", "destinationToken_", "destinationPhone_", "destinationUserid_", "amount_", "description_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KifpoolOuterClass$RequestTransferMoney.class) {
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

    public long getAmount() {
        return this.amount_;
    }

    public StringValue getDescription() {
        StringValue stringValue = this.description_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public StringValue getDestinationPhone() {
        StringValue stringValue = this.destinationPhone_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public StringValue getDestinationToken() {
        StringValue stringValue = this.destinationToken_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public Int32Value getDestinationUserid() {
        Int32Value int32Value = this.destinationUserid_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public String getSourceToken() {
        return this.sourceToken_;
    }

    public AbstractC2383g getSourceTokenBytes() {
        return AbstractC2383g.N(this.sourceToken_);
    }

    public boolean hasDescription() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasDestinationPhone() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasDestinationToken() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasDestinationUserid() {
        return (this.bitField0_ & 4) != 0;
    }

    public static a newBuilder(KifpoolOuterClass$RequestTransferMoney kifpoolOuterClass$RequestTransferMoney) {
        return (a) DEFAULT_INSTANCE.createBuilder(kifpoolOuterClass$RequestTransferMoney);
    }

    public static KifpoolOuterClass$RequestTransferMoney parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$RequestTransferMoney) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$RequestTransferMoney parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KifpoolOuterClass$RequestTransferMoney) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KifpoolOuterClass$RequestTransferMoney parseFrom(AbstractC2383g abstractC2383g) {
        return (KifpoolOuterClass$RequestTransferMoney) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KifpoolOuterClass$RequestTransferMoney parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KifpoolOuterClass$RequestTransferMoney) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KifpoolOuterClass$RequestTransferMoney parseFrom(byte[] bArr) {
        return (KifpoolOuterClass$RequestTransferMoney) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KifpoolOuterClass$RequestTransferMoney parseFrom(byte[] bArr, C2394s c2394s) {
        return (KifpoolOuterClass$RequestTransferMoney) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KifpoolOuterClass$RequestTransferMoney parseFrom(InputStream inputStream) {
        return (KifpoolOuterClass$RequestTransferMoney) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$RequestTransferMoney parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$RequestTransferMoney) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$RequestTransferMoney parseFrom(AbstractC2384h abstractC2384h) {
        return (KifpoolOuterClass$RequestTransferMoney) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KifpoolOuterClass$RequestTransferMoney parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KifpoolOuterClass$RequestTransferMoney) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
