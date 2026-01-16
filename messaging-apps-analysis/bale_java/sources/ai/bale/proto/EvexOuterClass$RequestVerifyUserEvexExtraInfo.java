package ai.bale.proto;

import ai.bale.proto.EvexStruct$VerifyByNakhodaCode;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class EvexOuterClass$RequestVerifyUserEvexExtraInfo extends GeneratedMessageLite implements U64 {
    private static final EvexOuterClass$RequestVerifyUserEvexExtraInfo DEFAULT_INSTANCE;
    public static final int NAKHODA_INFO_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int verifyByCase_ = 0;
    private Object verifyBy_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(EvexOuterClass$RequestVerifyUserEvexExtraInfo.DEFAULT_INSTANCE);
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
        EvexOuterClass$RequestVerifyUserEvexExtraInfo evexOuterClass$RequestVerifyUserEvexExtraInfo = new EvexOuterClass$RequestVerifyUserEvexExtraInfo();
        DEFAULT_INSTANCE = evexOuterClass$RequestVerifyUserEvexExtraInfo;
        GeneratedMessageLite.registerDefaultInstance(EvexOuterClass$RequestVerifyUserEvexExtraInfo.class, evexOuterClass$RequestVerifyUserEvexExtraInfo);
    }

    private EvexOuterClass$RequestVerifyUserEvexExtraInfo() {
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

    public static EvexOuterClass$RequestVerifyUserEvexExtraInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeNakhodaInfo(EvexStruct$VerifyByNakhodaCode evexStruct$VerifyByNakhodaCode) {
        evexStruct$VerifyByNakhodaCode.getClass();
        if (this.verifyByCase_ != 1 || this.verifyBy_ == EvexStruct$VerifyByNakhodaCode.getDefaultInstance()) {
            this.verifyBy_ = evexStruct$VerifyByNakhodaCode;
        } else {
            this.verifyBy_ = ((EvexStruct$VerifyByNakhodaCode.a) EvexStruct$VerifyByNakhodaCode.newBuilder((EvexStruct$VerifyByNakhodaCode) this.verifyBy_).v(evexStruct$VerifyByNakhodaCode)).j();
        }
        this.verifyByCase_ = 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static EvexOuterClass$RequestVerifyUserEvexExtraInfo parseDelimitedFrom(InputStream inputStream) {
        return (EvexOuterClass$RequestVerifyUserEvexExtraInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EvexOuterClass$RequestVerifyUserEvexExtraInfo parseFrom(ByteBuffer byteBuffer) {
        return (EvexOuterClass$RequestVerifyUserEvexExtraInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setNakhodaInfo(EvexStruct$VerifyByNakhodaCode evexStruct$VerifyByNakhodaCode) {
        evexStruct$VerifyByNakhodaCode.getClass();
        this.verifyBy_ = evexStruct$VerifyByNakhodaCode;
        this.verifyByCase_ = 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (S.a[gVar.ordinal()]) {
            case 1:
                return new EvexOuterClass$RequestVerifyUserEvexExtraInfo();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001<\u0000", new Object[]{"verifyBy_", "verifyByCase_", EvexStruct$VerifyByNakhodaCode.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (EvexOuterClass$RequestVerifyUserEvexExtraInfo.class) {
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

    public EvexStruct$VerifyByNakhodaCode getNakhodaInfo() {
        return this.verifyByCase_ == 1 ? (EvexStruct$VerifyByNakhodaCode) this.verifyBy_ : EvexStruct$VerifyByNakhodaCode.getDefaultInstance();
    }

    public b getVerifyByCase() {
        return b.j(this.verifyByCase_);
    }

    public boolean hasNakhodaInfo() {
        return this.verifyByCase_ == 1;
    }

    public static a newBuilder(EvexOuterClass$RequestVerifyUserEvexExtraInfo evexOuterClass$RequestVerifyUserEvexExtraInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(evexOuterClass$RequestVerifyUserEvexExtraInfo);
    }

    public static EvexOuterClass$RequestVerifyUserEvexExtraInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (EvexOuterClass$RequestVerifyUserEvexExtraInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static EvexOuterClass$RequestVerifyUserEvexExtraInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (EvexOuterClass$RequestVerifyUserEvexExtraInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static EvexOuterClass$RequestVerifyUserEvexExtraInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (EvexOuterClass$RequestVerifyUserEvexExtraInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static EvexOuterClass$RequestVerifyUserEvexExtraInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (EvexOuterClass$RequestVerifyUserEvexExtraInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static EvexOuterClass$RequestVerifyUserEvexExtraInfo parseFrom(byte[] bArr) {
        return (EvexOuterClass$RequestVerifyUserEvexExtraInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static EvexOuterClass$RequestVerifyUserEvexExtraInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (EvexOuterClass$RequestVerifyUserEvexExtraInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static EvexOuterClass$RequestVerifyUserEvexExtraInfo parseFrom(InputStream inputStream) {
        return (EvexOuterClass$RequestVerifyUserEvexExtraInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EvexOuterClass$RequestVerifyUserEvexExtraInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (EvexOuterClass$RequestVerifyUserEvexExtraInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static EvexOuterClass$RequestVerifyUserEvexExtraInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (EvexOuterClass$RequestVerifyUserEvexExtraInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static EvexOuterClass$RequestVerifyUserEvexExtraInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (EvexOuterClass$RequestVerifyUserEvexExtraInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
