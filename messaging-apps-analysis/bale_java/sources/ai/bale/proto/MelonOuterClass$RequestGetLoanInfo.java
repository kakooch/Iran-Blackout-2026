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

/* loaded from: classes9.dex */
public final class MelonOuterClass$RequestGetLoanInfo extends GeneratedMessageLite implements U64 {
    public static final int CONTRACT_ID_FIELD_NUMBER = 1;
    private static final MelonOuterClass$RequestGetLoanInfo DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private String contractId_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MelonOuterClass$RequestGetLoanInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        MelonOuterClass$RequestGetLoanInfo melonOuterClass$RequestGetLoanInfo = new MelonOuterClass$RequestGetLoanInfo();
        DEFAULT_INSTANCE = melonOuterClass$RequestGetLoanInfo;
        GeneratedMessageLite.registerDefaultInstance(MelonOuterClass$RequestGetLoanInfo.class, melonOuterClass$RequestGetLoanInfo);
    }

    private MelonOuterClass$RequestGetLoanInfo() {
    }

    private void clearContractId() {
        this.contractId_ = getDefaultInstance().getContractId();
    }

    public static MelonOuterClass$RequestGetLoanInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MelonOuterClass$RequestGetLoanInfo parseDelimitedFrom(InputStream inputStream) {
        return (MelonOuterClass$RequestGetLoanInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MelonOuterClass$RequestGetLoanInfo parseFrom(ByteBuffer byteBuffer) {
        return (MelonOuterClass$RequestGetLoanInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setContractId(String str) {
        str.getClass();
        this.contractId_ = str;
    }

    private void setContractIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.contractId_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (I0.a[gVar.ordinal()]) {
            case 1:
                return new MelonOuterClass$RequestGetLoanInfo();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"contractId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MelonOuterClass$RequestGetLoanInfo.class) {
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

    public String getContractId() {
        return this.contractId_;
    }

    public AbstractC2383g getContractIdBytes() {
        return AbstractC2383g.N(this.contractId_);
    }

    public static a newBuilder(MelonOuterClass$RequestGetLoanInfo melonOuterClass$RequestGetLoanInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(melonOuterClass$RequestGetLoanInfo);
    }

    public static MelonOuterClass$RequestGetLoanInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MelonOuterClass$RequestGetLoanInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MelonOuterClass$RequestGetLoanInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MelonOuterClass$RequestGetLoanInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MelonOuterClass$RequestGetLoanInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (MelonOuterClass$RequestGetLoanInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MelonOuterClass$RequestGetLoanInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MelonOuterClass$RequestGetLoanInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MelonOuterClass$RequestGetLoanInfo parseFrom(byte[] bArr) {
        return (MelonOuterClass$RequestGetLoanInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MelonOuterClass$RequestGetLoanInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (MelonOuterClass$RequestGetLoanInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MelonOuterClass$RequestGetLoanInfo parseFrom(InputStream inputStream) {
        return (MelonOuterClass$RequestGetLoanInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MelonOuterClass$RequestGetLoanInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MelonOuterClass$RequestGetLoanInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MelonOuterClass$RequestGetLoanInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (MelonOuterClass$RequestGetLoanInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MelonOuterClass$RequestGetLoanInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MelonOuterClass$RequestGetLoanInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
