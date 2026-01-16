package ai.bale.proto;

import ai.bale.proto.ArbainexchangeStruct$ArbaeenBankApprovalText;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class Arbainexchange$ResponseVerifyUserArbaeenAuthority extends GeneratedMessageLite implements U64 {
    public static final int APPROVAL_FIELD_NUMBER = 1;
    private static final Arbainexchange$ResponseVerifyUserArbaeenAuthority DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private ArbainexchangeStruct$ArbaeenBankApprovalText approval_;
    private int bitField0_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Arbainexchange$ResponseVerifyUserArbaeenAuthority.DEFAULT_INSTANCE);
        }
    }

    static {
        Arbainexchange$ResponseVerifyUserArbaeenAuthority arbainexchange$ResponseVerifyUserArbaeenAuthority = new Arbainexchange$ResponseVerifyUserArbaeenAuthority();
        DEFAULT_INSTANCE = arbainexchange$ResponseVerifyUserArbaeenAuthority;
        GeneratedMessageLite.registerDefaultInstance(Arbainexchange$ResponseVerifyUserArbaeenAuthority.class, arbainexchange$ResponseVerifyUserArbaeenAuthority);
    }

    private Arbainexchange$ResponseVerifyUserArbaeenAuthority() {
    }

    private void clearApproval() {
        this.approval_ = null;
        this.bitField0_ &= -2;
    }

    public static Arbainexchange$ResponseVerifyUserArbaeenAuthority getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeApproval(ArbainexchangeStruct$ArbaeenBankApprovalText arbainexchangeStruct$ArbaeenBankApprovalText) {
        arbainexchangeStruct$ArbaeenBankApprovalText.getClass();
        ArbainexchangeStruct$ArbaeenBankApprovalText arbainexchangeStruct$ArbaeenBankApprovalText2 = this.approval_;
        if (arbainexchangeStruct$ArbaeenBankApprovalText2 == null || arbainexchangeStruct$ArbaeenBankApprovalText2 == ArbainexchangeStruct$ArbaeenBankApprovalText.getDefaultInstance()) {
            this.approval_ = arbainexchangeStruct$ArbaeenBankApprovalText;
        } else {
            this.approval_ = (ArbainexchangeStruct$ArbaeenBankApprovalText) ((ArbainexchangeStruct$ArbaeenBankApprovalText.a) ArbainexchangeStruct$ArbaeenBankApprovalText.newBuilder(this.approval_).v(arbainexchangeStruct$ArbaeenBankApprovalText)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Arbainexchange$ResponseVerifyUserArbaeenAuthority parseDelimitedFrom(InputStream inputStream) {
        return (Arbainexchange$ResponseVerifyUserArbaeenAuthority) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Arbainexchange$ResponseVerifyUserArbaeenAuthority parseFrom(ByteBuffer byteBuffer) {
        return (Arbainexchange$ResponseVerifyUserArbaeenAuthority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setApproval(ArbainexchangeStruct$ArbaeenBankApprovalText arbainexchangeStruct$ArbaeenBankApprovalText) {
        arbainexchangeStruct$ArbaeenBankApprovalText.getClass();
        this.approval_ = arbainexchangeStruct$ArbaeenBankApprovalText;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1861i.a[gVar.ordinal()]) {
            case 1:
                return new Arbainexchange$ResponseVerifyUserArbaeenAuthority();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "approval_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Arbainexchange$ResponseVerifyUserArbaeenAuthority.class) {
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

    public ArbainexchangeStruct$ArbaeenBankApprovalText getApproval() {
        ArbainexchangeStruct$ArbaeenBankApprovalText arbainexchangeStruct$ArbaeenBankApprovalText = this.approval_;
        return arbainexchangeStruct$ArbaeenBankApprovalText == null ? ArbainexchangeStruct$ArbaeenBankApprovalText.getDefaultInstance() : arbainexchangeStruct$ArbaeenBankApprovalText;
    }

    public boolean hasApproval() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(Arbainexchange$ResponseVerifyUserArbaeenAuthority arbainexchange$ResponseVerifyUserArbaeenAuthority) {
        return (a) DEFAULT_INSTANCE.createBuilder(arbainexchange$ResponseVerifyUserArbaeenAuthority);
    }

    public static Arbainexchange$ResponseVerifyUserArbaeenAuthority parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Arbainexchange$ResponseVerifyUserArbaeenAuthority) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Arbainexchange$ResponseVerifyUserArbaeenAuthority parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Arbainexchange$ResponseVerifyUserArbaeenAuthority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Arbainexchange$ResponseVerifyUserArbaeenAuthority parseFrom(AbstractC2383g abstractC2383g) {
        return (Arbainexchange$ResponseVerifyUserArbaeenAuthority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Arbainexchange$ResponseVerifyUserArbaeenAuthority parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Arbainexchange$ResponseVerifyUserArbaeenAuthority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Arbainexchange$ResponseVerifyUserArbaeenAuthority parseFrom(byte[] bArr) {
        return (Arbainexchange$ResponseVerifyUserArbaeenAuthority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Arbainexchange$ResponseVerifyUserArbaeenAuthority parseFrom(byte[] bArr, C2394s c2394s) {
        return (Arbainexchange$ResponseVerifyUserArbaeenAuthority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Arbainexchange$ResponseVerifyUserArbaeenAuthority parseFrom(InputStream inputStream) {
        return (Arbainexchange$ResponseVerifyUserArbaeenAuthority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Arbainexchange$ResponseVerifyUserArbaeenAuthority parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Arbainexchange$ResponseVerifyUserArbaeenAuthority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Arbainexchange$ResponseVerifyUserArbaeenAuthority parseFrom(AbstractC2384h abstractC2384h) {
        return (Arbainexchange$ResponseVerifyUserArbaeenAuthority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Arbainexchange$ResponseVerifyUserArbaeenAuthority parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Arbainexchange$ResponseVerifyUserArbaeenAuthority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
