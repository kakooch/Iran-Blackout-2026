package ai.bale.proto;

import ai.bale.proto.GoldOuterClass$Gold;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class GoldOuterClass$ResponseGetGoldWalletBalance extends GeneratedMessageLite implements U64 {
    public static final int BALANCE_FIELD_NUMBER = 1;
    private static final GoldOuterClass$ResponseGetGoldWalletBalance DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private GoldOuterClass$Gold balance_;
    private int bitField0_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GoldOuterClass$ResponseGetGoldWalletBalance.DEFAULT_INSTANCE);
        }
    }

    static {
        GoldOuterClass$ResponseGetGoldWalletBalance goldOuterClass$ResponseGetGoldWalletBalance = new GoldOuterClass$ResponseGetGoldWalletBalance();
        DEFAULT_INSTANCE = goldOuterClass$ResponseGetGoldWalletBalance;
        GeneratedMessageLite.registerDefaultInstance(GoldOuterClass$ResponseGetGoldWalletBalance.class, goldOuterClass$ResponseGetGoldWalletBalance);
    }

    private GoldOuterClass$ResponseGetGoldWalletBalance() {
    }

    private void clearBalance() {
        this.balance_ = null;
        this.bitField0_ &= -2;
    }

    public static GoldOuterClass$ResponseGetGoldWalletBalance getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeBalance(GoldOuterClass$Gold goldOuterClass$Gold) {
        goldOuterClass$Gold.getClass();
        GoldOuterClass$Gold goldOuterClass$Gold2 = this.balance_;
        if (goldOuterClass$Gold2 == null || goldOuterClass$Gold2 == GoldOuterClass$Gold.getDefaultInstance()) {
            this.balance_ = goldOuterClass$Gold;
        } else {
            this.balance_ = (GoldOuterClass$Gold) ((GoldOuterClass$Gold.a) GoldOuterClass$Gold.newBuilder(this.balance_).v(goldOuterClass$Gold)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GoldOuterClass$ResponseGetGoldWalletBalance parseDelimitedFrom(InputStream inputStream) {
        return (GoldOuterClass$ResponseGetGoldWalletBalance) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GoldOuterClass$ResponseGetGoldWalletBalance parseFrom(ByteBuffer byteBuffer) {
        return (GoldOuterClass$ResponseGetGoldWalletBalance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBalance(GoldOuterClass$Gold goldOuterClass$Gold) {
        goldOuterClass$Gold.getClass();
        this.balance_ = goldOuterClass$Gold;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1871l0.a[gVar.ordinal()]) {
            case 1:
                return new GoldOuterClass$ResponseGetGoldWalletBalance();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "balance_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GoldOuterClass$ResponseGetGoldWalletBalance.class) {
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

    public GoldOuterClass$Gold getBalance() {
        GoldOuterClass$Gold goldOuterClass$Gold = this.balance_;
        return goldOuterClass$Gold == null ? GoldOuterClass$Gold.getDefaultInstance() : goldOuterClass$Gold;
    }

    public boolean hasBalance() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(GoldOuterClass$ResponseGetGoldWalletBalance goldOuterClass$ResponseGetGoldWalletBalance) {
        return (a) DEFAULT_INSTANCE.createBuilder(goldOuterClass$ResponseGetGoldWalletBalance);
    }

    public static GoldOuterClass$ResponseGetGoldWalletBalance parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GoldOuterClass$ResponseGetGoldWalletBalance) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GoldOuterClass$ResponseGetGoldWalletBalance parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GoldOuterClass$ResponseGetGoldWalletBalance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GoldOuterClass$ResponseGetGoldWalletBalance parseFrom(AbstractC2383g abstractC2383g) {
        return (GoldOuterClass$ResponseGetGoldWalletBalance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GoldOuterClass$ResponseGetGoldWalletBalance parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GoldOuterClass$ResponseGetGoldWalletBalance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GoldOuterClass$ResponseGetGoldWalletBalance parseFrom(byte[] bArr) {
        return (GoldOuterClass$ResponseGetGoldWalletBalance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GoldOuterClass$ResponseGetGoldWalletBalance parseFrom(byte[] bArr, C2394s c2394s) {
        return (GoldOuterClass$ResponseGetGoldWalletBalance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GoldOuterClass$ResponseGetGoldWalletBalance parseFrom(InputStream inputStream) {
        return (GoldOuterClass$ResponseGetGoldWalletBalance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GoldOuterClass$ResponseGetGoldWalletBalance parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GoldOuterClass$ResponseGetGoldWalletBalance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GoldOuterClass$ResponseGetGoldWalletBalance parseFrom(AbstractC2384h abstractC2384h) {
        return (GoldOuterClass$ResponseGetGoldWalletBalance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GoldOuterClass$ResponseGetGoldWalletBalance parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GoldOuterClass$ResponseGetGoldWalletBalance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
