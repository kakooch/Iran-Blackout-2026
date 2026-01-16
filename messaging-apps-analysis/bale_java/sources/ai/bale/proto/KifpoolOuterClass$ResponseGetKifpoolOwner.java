package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.EnumC8862Xq3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class KifpoolOuterClass$ResponseGetKifpoolOwner extends GeneratedMessageLite implements U64 {
    public static final int APPROVAL_CODE_FIELD_NUMBER = 4;
    private static final KifpoolOuterClass$ResponseGetKifpoolOwner DEFAULT_INSTANCE;
    public static final int FIRST_NAME_FIELD_NUMBER = 1;
    public static final int LAST_NAME_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int WALLET_STATUS_FIELD_NUMBER = 3;
    private long approvalCode_;
    private int bitField0_;
    private StringValue firstName_;
    private StringValue lastName_;
    private int walletStatus_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KifpoolOuterClass$ResponseGetKifpoolOwner.DEFAULT_INSTANCE);
        }
    }

    static {
        KifpoolOuterClass$ResponseGetKifpoolOwner kifpoolOuterClass$ResponseGetKifpoolOwner = new KifpoolOuterClass$ResponseGetKifpoolOwner();
        DEFAULT_INSTANCE = kifpoolOuterClass$ResponseGetKifpoolOwner;
        GeneratedMessageLite.registerDefaultInstance(KifpoolOuterClass$ResponseGetKifpoolOwner.class, kifpoolOuterClass$ResponseGetKifpoolOwner);
    }

    private KifpoolOuterClass$ResponseGetKifpoolOwner() {
    }

    private void clearApprovalCode() {
        this.approvalCode_ = 0L;
    }

    private void clearFirstName() {
        this.firstName_ = null;
        this.bitField0_ &= -2;
    }

    private void clearLastName() {
        this.lastName_ = null;
        this.bitField0_ &= -3;
    }

    private void clearWalletStatus() {
        this.walletStatus_ = 0;
    }

    public static KifpoolOuterClass$ResponseGetKifpoolOwner getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeFirstName(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.firstName_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.firstName_ = stringValue;
        } else {
            this.firstName_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.firstName_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeLastName(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.lastName_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.lastName_ = stringValue;
        } else {
            this.lastName_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.lastName_).v(stringValue)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KifpoolOuterClass$ResponseGetKifpoolOwner parseDelimitedFrom(InputStream inputStream) {
        return (KifpoolOuterClass$ResponseGetKifpoolOwner) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$ResponseGetKifpoolOwner parseFrom(ByteBuffer byteBuffer) {
        return (KifpoolOuterClass$ResponseGetKifpoolOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setApprovalCode(long j) {
        this.approvalCode_ = j;
    }

    private void setFirstName(StringValue stringValue) {
        stringValue.getClass();
        this.firstName_ = stringValue;
        this.bitField0_ |= 1;
    }

    private void setLastName(StringValue stringValue) {
        stringValue.getClass();
        this.lastName_ = stringValue;
        this.bitField0_ |= 2;
    }

    private void setWalletStatus(EnumC8862Xq3 enumC8862Xq3) {
        this.walletStatus_ = enumC8862Xq3.getNumber();
    }

    private void setWalletStatusValue(int i) {
        this.walletStatus_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1897u0.a[gVar.ordinal()]) {
            case 1:
                return new KifpoolOuterClass$ResponseGetKifpoolOwner();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\f\u0004\u0002", new Object[]{"bitField0_", "firstName_", "lastName_", "walletStatus_", "approvalCode_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KifpoolOuterClass$ResponseGetKifpoolOwner.class) {
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

    public long getApprovalCode() {
        return this.approvalCode_;
    }

    public StringValue getFirstName() {
        StringValue stringValue = this.firstName_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public StringValue getLastName() {
        StringValue stringValue = this.lastName_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public EnumC8862Xq3 getWalletStatus() {
        EnumC8862Xq3 enumC8862Xq3J = EnumC8862Xq3.j(this.walletStatus_);
        return enumC8862Xq3J == null ? EnumC8862Xq3.UNRECOGNIZED : enumC8862Xq3J;
    }

    public int getWalletStatusValue() {
        return this.walletStatus_;
    }

    public boolean hasFirstName() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasLastName() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(KifpoolOuterClass$ResponseGetKifpoolOwner kifpoolOuterClass$ResponseGetKifpoolOwner) {
        return (a) DEFAULT_INSTANCE.createBuilder(kifpoolOuterClass$ResponseGetKifpoolOwner);
    }

    public static KifpoolOuterClass$ResponseGetKifpoolOwner parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseGetKifpoolOwner) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$ResponseGetKifpoolOwner parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseGetKifpoolOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KifpoolOuterClass$ResponseGetKifpoolOwner parseFrom(AbstractC2383g abstractC2383g) {
        return (KifpoolOuterClass$ResponseGetKifpoolOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KifpoolOuterClass$ResponseGetKifpoolOwner parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseGetKifpoolOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KifpoolOuterClass$ResponseGetKifpoolOwner parseFrom(byte[] bArr) {
        return (KifpoolOuterClass$ResponseGetKifpoolOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KifpoolOuterClass$ResponseGetKifpoolOwner parseFrom(byte[] bArr, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseGetKifpoolOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KifpoolOuterClass$ResponseGetKifpoolOwner parseFrom(InputStream inputStream) {
        return (KifpoolOuterClass$ResponseGetKifpoolOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$ResponseGetKifpoolOwner parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseGetKifpoolOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$ResponseGetKifpoolOwner parseFrom(AbstractC2384h abstractC2384h) {
        return (KifpoolOuterClass$ResponseGetKifpoolOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KifpoolOuterClass$ResponseGetKifpoolOwner parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseGetKifpoolOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
