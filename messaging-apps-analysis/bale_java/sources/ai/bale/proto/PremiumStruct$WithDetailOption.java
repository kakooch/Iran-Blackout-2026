package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class PremiumStruct$WithDetailOption extends GeneratedMessageLite implements U64 {
    private static final PremiumStruct$WithDetailOption DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int WITH_BADGE_FIELD_NUMBER = 1;
    private boolean withBadge_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(boolean z) {
            q();
            ((PremiumStruct$WithDetailOption) this.b).setWithBadge(z);
            return this;
        }

        private a() {
            super(PremiumStruct$WithDetailOption.DEFAULT_INSTANCE);
        }
    }

    static {
        PremiumStruct$WithDetailOption premiumStruct$WithDetailOption = new PremiumStruct$WithDetailOption();
        DEFAULT_INSTANCE = premiumStruct$WithDetailOption;
        GeneratedMessageLite.registerDefaultInstance(PremiumStruct$WithDetailOption.class, premiumStruct$WithDetailOption);
    }

    private PremiumStruct$WithDetailOption() {
    }

    private void clearWithBadge() {
        this.withBadge_ = false;
    }

    public static PremiumStruct$WithDetailOption getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PremiumStruct$WithDetailOption parseDelimitedFrom(InputStream inputStream) {
        return (PremiumStruct$WithDetailOption) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PremiumStruct$WithDetailOption parseFrom(ByteBuffer byteBuffer) {
        return (PremiumStruct$WithDetailOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWithBadge(boolean z) {
        this.withBadge_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1863i1.a[gVar.ordinal()]) {
            case 1:
                return new PremiumStruct$WithDetailOption();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0007", new Object[]{"withBadge_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PremiumStruct$WithDetailOption.class) {
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

    public boolean getWithBadge() {
        return this.withBadge_;
    }

    public static a newBuilder(PremiumStruct$WithDetailOption premiumStruct$WithDetailOption) {
        return (a) DEFAULT_INSTANCE.createBuilder(premiumStruct$WithDetailOption);
    }

    public static PremiumStruct$WithDetailOption parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PremiumStruct$WithDetailOption) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PremiumStruct$WithDetailOption parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PremiumStruct$WithDetailOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PremiumStruct$WithDetailOption parseFrom(AbstractC2383g abstractC2383g) {
        return (PremiumStruct$WithDetailOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PremiumStruct$WithDetailOption parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PremiumStruct$WithDetailOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PremiumStruct$WithDetailOption parseFrom(byte[] bArr) {
        return (PremiumStruct$WithDetailOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PremiumStruct$WithDetailOption parseFrom(byte[] bArr, C2394s c2394s) {
        return (PremiumStruct$WithDetailOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PremiumStruct$WithDetailOption parseFrom(InputStream inputStream) {
        return (PremiumStruct$WithDetailOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PremiumStruct$WithDetailOption parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PremiumStruct$WithDetailOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PremiumStruct$WithDetailOption parseFrom(AbstractC2384h abstractC2384h) {
        return (PremiumStruct$WithDetailOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PremiumStruct$WithDetailOption parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PremiumStruct$WithDetailOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
