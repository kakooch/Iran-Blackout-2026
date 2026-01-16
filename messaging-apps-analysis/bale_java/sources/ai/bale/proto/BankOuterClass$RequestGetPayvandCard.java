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
public final class BankOuterClass$RequestGetPayvandCard extends GeneratedMessageLite implements U64 {
    private static final BankOuterClass$RequestGetPayvandCard DEFAULT_INSTANCE;
    public static final int INDEX_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private String index_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BankOuterClass$RequestGetPayvandCard.DEFAULT_INSTANCE);
        }
    }

    static {
        BankOuterClass$RequestGetPayvandCard bankOuterClass$RequestGetPayvandCard = new BankOuterClass$RequestGetPayvandCard();
        DEFAULT_INSTANCE = bankOuterClass$RequestGetPayvandCard;
        GeneratedMessageLite.registerDefaultInstance(BankOuterClass$RequestGetPayvandCard.class, bankOuterClass$RequestGetPayvandCard);
    }

    private BankOuterClass$RequestGetPayvandCard() {
    }

    private void clearIndex() {
        this.index_ = getDefaultInstance().getIndex();
    }

    public static BankOuterClass$RequestGetPayvandCard getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BankOuterClass$RequestGetPayvandCard parseDelimitedFrom(InputStream inputStream) {
        return (BankOuterClass$RequestGetPayvandCard) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankOuterClass$RequestGetPayvandCard parseFrom(ByteBuffer byteBuffer) {
        return (BankOuterClass$RequestGetPayvandCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setIndex(String str) {
        str.getClass();
        this.index_ = str;
    }

    private void setIndexBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.index_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1876n.a[gVar.ordinal()]) {
            case 1:
                return new BankOuterClass$RequestGetPayvandCard();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"index_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BankOuterClass$RequestGetPayvandCard.class) {
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

    public String getIndex() {
        return this.index_;
    }

    public AbstractC2383g getIndexBytes() {
        return AbstractC2383g.N(this.index_);
    }

    public static a newBuilder(BankOuterClass$RequestGetPayvandCard bankOuterClass$RequestGetPayvandCard) {
        return (a) DEFAULT_INSTANCE.createBuilder(bankOuterClass$RequestGetPayvandCard);
    }

    public static BankOuterClass$RequestGetPayvandCard parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BankOuterClass$RequestGetPayvandCard) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankOuterClass$RequestGetPayvandCard parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BankOuterClass$RequestGetPayvandCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BankOuterClass$RequestGetPayvandCard parseFrom(AbstractC2383g abstractC2383g) {
        return (BankOuterClass$RequestGetPayvandCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BankOuterClass$RequestGetPayvandCard parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BankOuterClass$RequestGetPayvandCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BankOuterClass$RequestGetPayvandCard parseFrom(byte[] bArr) {
        return (BankOuterClass$RequestGetPayvandCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BankOuterClass$RequestGetPayvandCard parseFrom(byte[] bArr, C2394s c2394s) {
        return (BankOuterClass$RequestGetPayvandCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BankOuterClass$RequestGetPayvandCard parseFrom(InputStream inputStream) {
        return (BankOuterClass$RequestGetPayvandCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankOuterClass$RequestGetPayvandCard parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BankOuterClass$RequestGetPayvandCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankOuterClass$RequestGetPayvandCard parseFrom(AbstractC2384h abstractC2384h) {
        return (BankOuterClass$RequestGetPayvandCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BankOuterClass$RequestGetPayvandCard parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BankOuterClass$RequestGetPayvandCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
