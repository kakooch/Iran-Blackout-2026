package ai.bale.proto;

import ai.bale.proto.ArbainexchangeStruct$VerifyByArbaeenNakhodaCode;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class Arbainexchange$RequestVerifyUserArbaeenExtraInfo extends GeneratedMessageLite implements U64 {
    private static final Arbainexchange$RequestVerifyUserArbaeenExtraInfo DEFAULT_INSTANCE;
    public static final int NAKHODA_INFO_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int verifyByCase_ = 0;
    private Object verifyBy_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Arbainexchange$RequestVerifyUserArbaeenExtraInfo.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        NAKHODA_INFO(1),
        VERIFYBY_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return VERIFYBY_NOT_SET;
            }
            if (i != 1) {
                return null;
            }
            return NAKHODA_INFO;
        }
    }

    static {
        Arbainexchange$RequestVerifyUserArbaeenExtraInfo arbainexchange$RequestVerifyUserArbaeenExtraInfo = new Arbainexchange$RequestVerifyUserArbaeenExtraInfo();
        DEFAULT_INSTANCE = arbainexchange$RequestVerifyUserArbaeenExtraInfo;
        GeneratedMessageLite.registerDefaultInstance(Arbainexchange$RequestVerifyUserArbaeenExtraInfo.class, arbainexchange$RequestVerifyUserArbaeenExtraInfo);
    }

    private Arbainexchange$RequestVerifyUserArbaeenExtraInfo() {
    }

    private void clearNakhodaInfo() {
        if (this.verifyByCase_ == 1) {
            this.verifyByCase_ = 0;
            this.verifyBy_ = null;
        }
    }

    private void clearVerifyBy() {
        this.verifyByCase_ = 0;
        this.verifyBy_ = null;
    }

    public static Arbainexchange$RequestVerifyUserArbaeenExtraInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeNakhodaInfo(ArbainexchangeStruct$VerifyByArbaeenNakhodaCode arbainexchangeStruct$VerifyByArbaeenNakhodaCode) {
        arbainexchangeStruct$VerifyByArbaeenNakhodaCode.getClass();
        if (this.verifyByCase_ != 1 || this.verifyBy_ == ArbainexchangeStruct$VerifyByArbaeenNakhodaCode.getDefaultInstance()) {
            this.verifyBy_ = arbainexchangeStruct$VerifyByArbaeenNakhodaCode;
        } else {
            this.verifyBy_ = ((ArbainexchangeStruct$VerifyByArbaeenNakhodaCode.a) ArbainexchangeStruct$VerifyByArbaeenNakhodaCode.newBuilder((ArbainexchangeStruct$VerifyByArbaeenNakhodaCode) this.verifyBy_).v(arbainexchangeStruct$VerifyByArbaeenNakhodaCode)).j();
        }
        this.verifyByCase_ = 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Arbainexchange$RequestVerifyUserArbaeenExtraInfo parseDelimitedFrom(InputStream inputStream) {
        return (Arbainexchange$RequestVerifyUserArbaeenExtraInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Arbainexchange$RequestVerifyUserArbaeenExtraInfo parseFrom(ByteBuffer byteBuffer) {
        return (Arbainexchange$RequestVerifyUserArbaeenExtraInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setNakhodaInfo(ArbainexchangeStruct$VerifyByArbaeenNakhodaCode arbainexchangeStruct$VerifyByArbaeenNakhodaCode) {
        arbainexchangeStruct$VerifyByArbaeenNakhodaCode.getClass();
        this.verifyBy_ = arbainexchangeStruct$VerifyByArbaeenNakhodaCode;
        this.verifyByCase_ = 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1861i.a[gVar.ordinal()]) {
            case 1:
                return new Arbainexchange$RequestVerifyUserArbaeenExtraInfo();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001<\u0000", new Object[]{"verifyBy_", "verifyByCase_", ArbainexchangeStruct$VerifyByArbaeenNakhodaCode.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Arbainexchange$RequestVerifyUserArbaeenExtraInfo.class) {
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

    public ArbainexchangeStruct$VerifyByArbaeenNakhodaCode getNakhodaInfo() {
        return this.verifyByCase_ == 1 ? (ArbainexchangeStruct$VerifyByArbaeenNakhodaCode) this.verifyBy_ : ArbainexchangeStruct$VerifyByArbaeenNakhodaCode.getDefaultInstance();
    }

    public b getVerifyByCase() {
        return b.j(this.verifyByCase_);
    }

    public boolean hasNakhodaInfo() {
        return this.verifyByCase_ == 1;
    }

    public static a newBuilder(Arbainexchange$RequestVerifyUserArbaeenExtraInfo arbainexchange$RequestVerifyUserArbaeenExtraInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(arbainexchange$RequestVerifyUserArbaeenExtraInfo);
    }

    public static Arbainexchange$RequestVerifyUserArbaeenExtraInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Arbainexchange$RequestVerifyUserArbaeenExtraInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Arbainexchange$RequestVerifyUserArbaeenExtraInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Arbainexchange$RequestVerifyUserArbaeenExtraInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Arbainexchange$RequestVerifyUserArbaeenExtraInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (Arbainexchange$RequestVerifyUserArbaeenExtraInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Arbainexchange$RequestVerifyUserArbaeenExtraInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Arbainexchange$RequestVerifyUserArbaeenExtraInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Arbainexchange$RequestVerifyUserArbaeenExtraInfo parseFrom(byte[] bArr) {
        return (Arbainexchange$RequestVerifyUserArbaeenExtraInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Arbainexchange$RequestVerifyUserArbaeenExtraInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (Arbainexchange$RequestVerifyUserArbaeenExtraInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Arbainexchange$RequestVerifyUserArbaeenExtraInfo parseFrom(InputStream inputStream) {
        return (Arbainexchange$RequestVerifyUserArbaeenExtraInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Arbainexchange$RequestVerifyUserArbaeenExtraInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Arbainexchange$RequestVerifyUserArbaeenExtraInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Arbainexchange$RequestVerifyUserArbaeenExtraInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (Arbainexchange$RequestVerifyUserArbaeenExtraInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Arbainexchange$RequestVerifyUserArbaeenExtraInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Arbainexchange$RequestVerifyUserArbaeenExtraInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
