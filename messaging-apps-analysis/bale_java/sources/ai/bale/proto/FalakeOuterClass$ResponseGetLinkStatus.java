package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC4707Gf2;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class FalakeOuterClass$ResponseGetLinkStatus extends GeneratedMessageLite implements U64 {
    private static final FalakeOuterClass$ResponseGetLinkStatus DEFAULT_INSTANCE;
    public static final int LINK_STATUS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int linkStatus_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(FalakeOuterClass$ResponseGetLinkStatus.DEFAULT_INSTANCE);
        }
    }

    static {
        FalakeOuterClass$ResponseGetLinkStatus falakeOuterClass$ResponseGetLinkStatus = new FalakeOuterClass$ResponseGetLinkStatus();
        DEFAULT_INSTANCE = falakeOuterClass$ResponseGetLinkStatus;
        GeneratedMessageLite.registerDefaultInstance(FalakeOuterClass$ResponseGetLinkStatus.class, falakeOuterClass$ResponseGetLinkStatus);
    }

    private FalakeOuterClass$ResponseGetLinkStatus() {
    }

    private void clearLinkStatus() {
        this.linkStatus_ = 0;
    }

    public static FalakeOuterClass$ResponseGetLinkStatus getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static FalakeOuterClass$ResponseGetLinkStatus parseDelimitedFrom(InputStream inputStream) {
        return (FalakeOuterClass$ResponseGetLinkStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FalakeOuterClass$ResponseGetLinkStatus parseFrom(ByteBuffer byteBuffer) {
        return (FalakeOuterClass$ResponseGetLinkStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setLinkStatus(EnumC4707Gf2 enumC4707Gf2) {
        this.linkStatus_ = enumC4707Gf2.getNumber();
    }

    private void setLinkStatusValue(int i) {
        this.linkStatus_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (X.a[gVar.ordinal()]) {
            case 1:
                return new FalakeOuterClass$ResponseGetLinkStatus();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"linkStatus_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (FalakeOuterClass$ResponseGetLinkStatus.class) {
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

    public EnumC4707Gf2 getLinkStatus() {
        EnumC4707Gf2 enumC4707Gf2J = EnumC4707Gf2.j(this.linkStatus_);
        return enumC4707Gf2J == null ? EnumC4707Gf2.UNRECOGNIZED : enumC4707Gf2J;
    }

    public int getLinkStatusValue() {
        return this.linkStatus_;
    }

    public static a newBuilder(FalakeOuterClass$ResponseGetLinkStatus falakeOuterClass$ResponseGetLinkStatus) {
        return (a) DEFAULT_INSTANCE.createBuilder(falakeOuterClass$ResponseGetLinkStatus);
    }

    public static FalakeOuterClass$ResponseGetLinkStatus parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (FalakeOuterClass$ResponseGetLinkStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static FalakeOuterClass$ResponseGetLinkStatus parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (FalakeOuterClass$ResponseGetLinkStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static FalakeOuterClass$ResponseGetLinkStatus parseFrom(AbstractC2383g abstractC2383g) {
        return (FalakeOuterClass$ResponseGetLinkStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static FalakeOuterClass$ResponseGetLinkStatus parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (FalakeOuterClass$ResponseGetLinkStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static FalakeOuterClass$ResponseGetLinkStatus parseFrom(byte[] bArr) {
        return (FalakeOuterClass$ResponseGetLinkStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static FalakeOuterClass$ResponseGetLinkStatus parseFrom(byte[] bArr, C2394s c2394s) {
        return (FalakeOuterClass$ResponseGetLinkStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static FalakeOuterClass$ResponseGetLinkStatus parseFrom(InputStream inputStream) {
        return (FalakeOuterClass$ResponseGetLinkStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FalakeOuterClass$ResponseGetLinkStatus parseFrom(InputStream inputStream, C2394s c2394s) {
        return (FalakeOuterClass$ResponseGetLinkStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static FalakeOuterClass$ResponseGetLinkStatus parseFrom(AbstractC2384h abstractC2384h) {
        return (FalakeOuterClass$ResponseGetLinkStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static FalakeOuterClass$ResponseGetLinkStatus parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (FalakeOuterClass$ResponseGetLinkStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
