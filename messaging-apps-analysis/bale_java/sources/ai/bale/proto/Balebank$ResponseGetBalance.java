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
public final class Balebank$ResponseGetBalance extends GeneratedMessageLite implements U64 {
    public static final int BALANCE_FIELD_NUMBER = 1;
    private static final Balebank$ResponseGetBalance DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private long balance_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Balebank$ResponseGetBalance.DEFAULT_INSTANCE);
        }
    }

    static {
        Balebank$ResponseGetBalance balebank$ResponseGetBalance = new Balebank$ResponseGetBalance();
        DEFAULT_INSTANCE = balebank$ResponseGetBalance;
        GeneratedMessageLite.registerDefaultInstance(Balebank$ResponseGetBalance.class, balebank$ResponseGetBalance);
    }

    private Balebank$ResponseGetBalance() {
    }

    private void clearBalance() {
        this.balance_ = 0L;
    }

    public static Balebank$ResponseGetBalance getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Balebank$ResponseGetBalance parseDelimitedFrom(InputStream inputStream) {
        return (Balebank$ResponseGetBalance) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Balebank$ResponseGetBalance parseFrom(ByteBuffer byteBuffer) {
        return (Balebank$ResponseGetBalance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBalance(long j) {
        this.balance_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1873m.a[gVar.ordinal()]) {
            case 1:
                return new Balebank$ResponseGetBalance();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0002", new Object[]{"balance_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Balebank$ResponseGetBalance.class) {
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

    public long getBalance() {
        return this.balance_;
    }

    public static a newBuilder(Balebank$ResponseGetBalance balebank$ResponseGetBalance) {
        return (a) DEFAULT_INSTANCE.createBuilder(balebank$ResponseGetBalance);
    }

    public static Balebank$ResponseGetBalance parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Balebank$ResponseGetBalance) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Balebank$ResponseGetBalance parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Balebank$ResponseGetBalance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Balebank$ResponseGetBalance parseFrom(AbstractC2383g abstractC2383g) {
        return (Balebank$ResponseGetBalance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Balebank$ResponseGetBalance parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Balebank$ResponseGetBalance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Balebank$ResponseGetBalance parseFrom(byte[] bArr) {
        return (Balebank$ResponseGetBalance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Balebank$ResponseGetBalance parseFrom(byte[] bArr, C2394s c2394s) {
        return (Balebank$ResponseGetBalance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Balebank$ResponseGetBalance parseFrom(InputStream inputStream) {
        return (Balebank$ResponseGetBalance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Balebank$ResponseGetBalance parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Balebank$ResponseGetBalance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Balebank$ResponseGetBalance parseFrom(AbstractC2384h abstractC2384h) {
        return (Balebank$ResponseGetBalance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Balebank$ResponseGetBalance parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Balebank$ResponseGetBalance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
