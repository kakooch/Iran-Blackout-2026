package ai.bale.proto;

import ai.bale.proto.EvexStruct$BankApprovalText;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class EvexOuterClass$ResponseVerifyUserEvexAuthority extends GeneratedMessageLite implements U64 {
    public static final int APPROVAL_FIELD_NUMBER = 1;
    private static final EvexOuterClass$ResponseVerifyUserEvexAuthority DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private EvexStruct$BankApprovalText approval_;
    private int bitField0_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(EvexOuterClass$ResponseVerifyUserEvexAuthority.DEFAULT_INSTANCE);
        }
    }

    static {
        EvexOuterClass$ResponseVerifyUserEvexAuthority evexOuterClass$ResponseVerifyUserEvexAuthority = new EvexOuterClass$ResponseVerifyUserEvexAuthority();
        DEFAULT_INSTANCE = evexOuterClass$ResponseVerifyUserEvexAuthority;
        GeneratedMessageLite.registerDefaultInstance(EvexOuterClass$ResponseVerifyUserEvexAuthority.class, evexOuterClass$ResponseVerifyUserEvexAuthority);
    }

    private EvexOuterClass$ResponseVerifyUserEvexAuthority() {
    }

    private void clearApproval() {
        this.approval_ = null;
        this.bitField0_ &= -2;
    }

    public static EvexOuterClass$ResponseVerifyUserEvexAuthority getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeApproval(EvexStruct$BankApprovalText evexStruct$BankApprovalText) {
        evexStruct$BankApprovalText.getClass();
        EvexStruct$BankApprovalText evexStruct$BankApprovalText2 = this.approval_;
        if (evexStruct$BankApprovalText2 == null || evexStruct$BankApprovalText2 == EvexStruct$BankApprovalText.getDefaultInstance()) {
            this.approval_ = evexStruct$BankApprovalText;
        } else {
            this.approval_ = (EvexStruct$BankApprovalText) ((EvexStruct$BankApprovalText.a) EvexStruct$BankApprovalText.newBuilder(this.approval_).v(evexStruct$BankApprovalText)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static EvexOuterClass$ResponseVerifyUserEvexAuthority parseDelimitedFrom(InputStream inputStream) {
        return (EvexOuterClass$ResponseVerifyUserEvexAuthority) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EvexOuterClass$ResponseVerifyUserEvexAuthority parseFrom(ByteBuffer byteBuffer) {
        return (EvexOuterClass$ResponseVerifyUserEvexAuthority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setApproval(EvexStruct$BankApprovalText evexStruct$BankApprovalText) {
        evexStruct$BankApprovalText.getClass();
        this.approval_ = evexStruct$BankApprovalText;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (S.a[gVar.ordinal()]) {
            case 1:
                return new EvexOuterClass$ResponseVerifyUserEvexAuthority();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "approval_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (EvexOuterClass$ResponseVerifyUserEvexAuthority.class) {
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

    public EvexStruct$BankApprovalText getApproval() {
        EvexStruct$BankApprovalText evexStruct$BankApprovalText = this.approval_;
        return evexStruct$BankApprovalText == null ? EvexStruct$BankApprovalText.getDefaultInstance() : evexStruct$BankApprovalText;
    }

    public boolean hasApproval() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(EvexOuterClass$ResponseVerifyUserEvexAuthority evexOuterClass$ResponseVerifyUserEvexAuthority) {
        return (a) DEFAULT_INSTANCE.createBuilder(evexOuterClass$ResponseVerifyUserEvexAuthority);
    }

    public static EvexOuterClass$ResponseVerifyUserEvexAuthority parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (EvexOuterClass$ResponseVerifyUserEvexAuthority) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static EvexOuterClass$ResponseVerifyUserEvexAuthority parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (EvexOuterClass$ResponseVerifyUserEvexAuthority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static EvexOuterClass$ResponseVerifyUserEvexAuthority parseFrom(AbstractC2383g abstractC2383g) {
        return (EvexOuterClass$ResponseVerifyUserEvexAuthority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static EvexOuterClass$ResponseVerifyUserEvexAuthority parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (EvexOuterClass$ResponseVerifyUserEvexAuthority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static EvexOuterClass$ResponseVerifyUserEvexAuthority parseFrom(byte[] bArr) {
        return (EvexOuterClass$ResponseVerifyUserEvexAuthority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static EvexOuterClass$ResponseVerifyUserEvexAuthority parseFrom(byte[] bArr, C2394s c2394s) {
        return (EvexOuterClass$ResponseVerifyUserEvexAuthority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static EvexOuterClass$ResponseVerifyUserEvexAuthority parseFrom(InputStream inputStream) {
        return (EvexOuterClass$ResponseVerifyUserEvexAuthority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EvexOuterClass$ResponseVerifyUserEvexAuthority parseFrom(InputStream inputStream, C2394s c2394s) {
        return (EvexOuterClass$ResponseVerifyUserEvexAuthority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static EvexOuterClass$ResponseVerifyUserEvexAuthority parseFrom(AbstractC2384h abstractC2384h) {
        return (EvexOuterClass$ResponseVerifyUserEvexAuthority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static EvexOuterClass$ResponseVerifyUserEvexAuthority parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (EvexOuterClass$ResponseVerifyUserEvexAuthority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
