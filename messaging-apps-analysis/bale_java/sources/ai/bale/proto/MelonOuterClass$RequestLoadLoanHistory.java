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
public final class MelonOuterClass$RequestLoadLoanHistory extends GeneratedMessageLite implements U64 {
    private static final MelonOuterClass$RequestLoadLoanHistory DEFAULT_INSTANCE;
    public static final int NATIONAL_CODE_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private String nationalCode_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MelonOuterClass$RequestLoadLoanHistory.DEFAULT_INSTANCE);
        }
    }

    static {
        MelonOuterClass$RequestLoadLoanHistory melonOuterClass$RequestLoadLoanHistory = new MelonOuterClass$RequestLoadLoanHistory();
        DEFAULT_INSTANCE = melonOuterClass$RequestLoadLoanHistory;
        GeneratedMessageLite.registerDefaultInstance(MelonOuterClass$RequestLoadLoanHistory.class, melonOuterClass$RequestLoadLoanHistory);
    }

    private MelonOuterClass$RequestLoadLoanHistory() {
    }

    private void clearNationalCode() {
        this.nationalCode_ = getDefaultInstance().getNationalCode();
    }

    public static MelonOuterClass$RequestLoadLoanHistory getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MelonOuterClass$RequestLoadLoanHistory parseDelimitedFrom(InputStream inputStream) {
        return (MelonOuterClass$RequestLoadLoanHistory) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MelonOuterClass$RequestLoadLoanHistory parseFrom(ByteBuffer byteBuffer) {
        return (MelonOuterClass$RequestLoadLoanHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setNationalCode(String str) {
        str.getClass();
        this.nationalCode_ = str;
    }

    private void setNationalCodeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.nationalCode_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (I0.a[gVar.ordinal()]) {
            case 1:
                return new MelonOuterClass$RequestLoadLoanHistory();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"nationalCode_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MelonOuterClass$RequestLoadLoanHistory.class) {
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

    public String getNationalCode() {
        return this.nationalCode_;
    }

    public AbstractC2383g getNationalCodeBytes() {
        return AbstractC2383g.N(this.nationalCode_);
    }

    public static a newBuilder(MelonOuterClass$RequestLoadLoanHistory melonOuterClass$RequestLoadLoanHistory) {
        return (a) DEFAULT_INSTANCE.createBuilder(melonOuterClass$RequestLoadLoanHistory);
    }

    public static MelonOuterClass$RequestLoadLoanHistory parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MelonOuterClass$RequestLoadLoanHistory) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MelonOuterClass$RequestLoadLoanHistory parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MelonOuterClass$RequestLoadLoanHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MelonOuterClass$RequestLoadLoanHistory parseFrom(AbstractC2383g abstractC2383g) {
        return (MelonOuterClass$RequestLoadLoanHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MelonOuterClass$RequestLoadLoanHistory parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MelonOuterClass$RequestLoadLoanHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MelonOuterClass$RequestLoadLoanHistory parseFrom(byte[] bArr) {
        return (MelonOuterClass$RequestLoadLoanHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MelonOuterClass$RequestLoadLoanHistory parseFrom(byte[] bArr, C2394s c2394s) {
        return (MelonOuterClass$RequestLoadLoanHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MelonOuterClass$RequestLoadLoanHistory parseFrom(InputStream inputStream) {
        return (MelonOuterClass$RequestLoadLoanHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MelonOuterClass$RequestLoadLoanHistory parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MelonOuterClass$RequestLoadLoanHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MelonOuterClass$RequestLoadLoanHistory parseFrom(AbstractC2384h abstractC2384h) {
        return (MelonOuterClass$RequestLoadLoanHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MelonOuterClass$RequestLoadLoanHistory parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MelonOuterClass$RequestLoadLoanHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
