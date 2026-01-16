package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class SapOuterClass$RequestDeliverOtp extends GeneratedMessageLite implements U64 {
    public static final int ACCESS_ADDRESS_FIELD_NUMBER = 4;
    public static final int AMOUNT_FIELD_NUMBER = 3;
    public static final int APPROVAL_CODE_FIELD_NUMBER = 5;
    public static final int CARD_ID_FIELD_NUMBER = 1;
    private static final SapOuterClass$RequestDeliverOtp DEFAULT_INSTANCE;
    public static final int DESTINATION_PAN_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private int amount_;
    private String cardId_ = "";
    private String destinationPan_ = "";
    private String accessAddress_ = "";
    private String approvalCode_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(int i) {
            q();
            ((SapOuterClass$RequestDeliverOtp) this.b).setAmount(i);
            return this;
        }

        public a B(String str) {
            q();
            ((SapOuterClass$RequestDeliverOtp) this.b).setApprovalCode(str);
            return this;
        }

        public a C(String str) {
            q();
            ((SapOuterClass$RequestDeliverOtp) this.b).setCardId(str);
            return this;
        }

        public a D(String str) {
            q();
            ((SapOuterClass$RequestDeliverOtp) this.b).setDestinationPan(str);
            return this;
        }

        private a() {
            super(SapOuterClass$RequestDeliverOtp.DEFAULT_INSTANCE);
        }
    }

    static {
        SapOuterClass$RequestDeliverOtp sapOuterClass$RequestDeliverOtp = new SapOuterClass$RequestDeliverOtp();
        DEFAULT_INSTANCE = sapOuterClass$RequestDeliverOtp;
        GeneratedMessageLite.registerDefaultInstance(SapOuterClass$RequestDeliverOtp.class, sapOuterClass$RequestDeliverOtp);
    }

    private SapOuterClass$RequestDeliverOtp() {
    }

    private void clearAccessAddress() {
        this.accessAddress_ = getDefaultInstance().getAccessAddress();
    }

    private void clearAmount() {
        this.amount_ = 0;
    }

    private void clearApprovalCode() {
        this.approvalCode_ = getDefaultInstance().getApprovalCode();
    }

    private void clearCardId() {
        this.cardId_ = getDefaultInstance().getCardId();
    }

    private void clearDestinationPan() {
        this.destinationPan_ = getDefaultInstance().getDestinationPan();
    }

    public static SapOuterClass$RequestDeliverOtp getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SapOuterClass$RequestDeliverOtp parseDelimitedFrom(InputStream inputStream) {
        return (SapOuterClass$RequestDeliverOtp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SapOuterClass$RequestDeliverOtp parseFrom(ByteBuffer byteBuffer) {
        return (SapOuterClass$RequestDeliverOtp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAccessAddress(String str) {
        str.getClass();
        this.accessAddress_ = str;
    }

    private void setAccessAddressBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.accessAddress_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAmount(int i) {
        this.amount_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setApprovalCode(String str) {
        str.getClass();
        this.approvalCode_ = str;
    }

    private void setApprovalCodeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.approvalCode_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCardId(String str) {
        str.getClass();
        this.cardId_ = str;
    }

    private void setCardIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.cardId_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDestinationPan(String str) {
        str.getClass();
        this.destinationPan_ = str;
    }

    private void setDestinationPanBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.destinationPan_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (H1.a[gVar.ordinal()]) {
            case 1:
                return new SapOuterClass$RequestDeliverOtp();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0004\u0004Ȉ\u0005Ȉ", new Object[]{"cardId_", "destinationPan_", "amount_", "accessAddress_", "approvalCode_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SapOuterClass$RequestDeliverOtp.class) {
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

    public String getAccessAddress() {
        return this.accessAddress_;
    }

    public AbstractC2383g getAccessAddressBytes() {
        return AbstractC2383g.N(this.accessAddress_);
    }

    public int getAmount() {
        return this.amount_;
    }

    public String getApprovalCode() {
        return this.approvalCode_;
    }

    public AbstractC2383g getApprovalCodeBytes() {
        return AbstractC2383g.N(this.approvalCode_);
    }

    public String getCardId() {
        return this.cardId_;
    }

    public AbstractC2383g getCardIdBytes() {
        return AbstractC2383g.N(this.cardId_);
    }

    public String getDestinationPan() {
        return this.destinationPan_;
    }

    public AbstractC2383g getDestinationPanBytes() {
        return AbstractC2383g.N(this.destinationPan_);
    }

    public static a newBuilder(SapOuterClass$RequestDeliverOtp sapOuterClass$RequestDeliverOtp) {
        return (a) DEFAULT_INSTANCE.createBuilder(sapOuterClass$RequestDeliverOtp);
    }

    public static SapOuterClass$RequestDeliverOtp parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SapOuterClass$RequestDeliverOtp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SapOuterClass$RequestDeliverOtp parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SapOuterClass$RequestDeliverOtp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SapOuterClass$RequestDeliverOtp parseFrom(AbstractC2383g abstractC2383g) {
        return (SapOuterClass$RequestDeliverOtp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SapOuterClass$RequestDeliverOtp parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SapOuterClass$RequestDeliverOtp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SapOuterClass$RequestDeliverOtp parseFrom(byte[] bArr) {
        return (SapOuterClass$RequestDeliverOtp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SapOuterClass$RequestDeliverOtp parseFrom(byte[] bArr, C2394s c2394s) {
        return (SapOuterClass$RequestDeliverOtp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SapOuterClass$RequestDeliverOtp parseFrom(InputStream inputStream) {
        return (SapOuterClass$RequestDeliverOtp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SapOuterClass$RequestDeliverOtp parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SapOuterClass$RequestDeliverOtp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SapOuterClass$RequestDeliverOtp parseFrom(AbstractC2384h abstractC2384h) {
        return (SapOuterClass$RequestDeliverOtp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SapOuterClass$RequestDeliverOtp parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SapOuterClass$RequestDeliverOtp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
