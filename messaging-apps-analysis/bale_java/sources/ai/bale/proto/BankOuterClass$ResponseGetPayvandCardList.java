package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import ir.nasim.V60;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class BankOuterClass$ResponseGetPayvandCardList extends GeneratedMessageLite implements U64 {
    private static final BankOuterClass$ResponseGetPayvandCardList DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PAYVAND_CARDS_FIELD_NUMBER = 1;
    private B.j payvandCards_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BankOuterClass$ResponseGetPayvandCardList.DEFAULT_INSTANCE);
        }
    }

    static {
        BankOuterClass$ResponseGetPayvandCardList bankOuterClass$ResponseGetPayvandCardList = new BankOuterClass$ResponseGetPayvandCardList();
        DEFAULT_INSTANCE = bankOuterClass$ResponseGetPayvandCardList;
        GeneratedMessageLite.registerDefaultInstance(BankOuterClass$ResponseGetPayvandCardList.class, bankOuterClass$ResponseGetPayvandCardList);
    }

    private BankOuterClass$ResponseGetPayvandCardList() {
    }

    private void addAllPayvandCards(Iterable<? extends BankStruct$PayvandCard> iterable) {
        ensurePayvandCardsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.payvandCards_);
    }

    private void addPayvandCards(BankStruct$PayvandCard bankStruct$PayvandCard) {
        bankStruct$PayvandCard.getClass();
        ensurePayvandCardsIsMutable();
        this.payvandCards_.add(bankStruct$PayvandCard);
    }

    private void clearPayvandCards() {
        this.payvandCards_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensurePayvandCardsIsMutable() {
        B.j jVar = this.payvandCards_;
        if (jVar.u()) {
            return;
        }
        this.payvandCards_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static BankOuterClass$ResponseGetPayvandCardList getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BankOuterClass$ResponseGetPayvandCardList parseDelimitedFrom(InputStream inputStream) {
        return (BankOuterClass$ResponseGetPayvandCardList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankOuterClass$ResponseGetPayvandCardList parseFrom(ByteBuffer byteBuffer) {
        return (BankOuterClass$ResponseGetPayvandCardList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removePayvandCards(int i) {
        ensurePayvandCardsIsMutable();
        this.payvandCards_.remove(i);
    }

    private void setPayvandCards(int i, BankStruct$PayvandCard bankStruct$PayvandCard) {
        bankStruct$PayvandCard.getClass();
        ensurePayvandCardsIsMutable();
        this.payvandCards_.set(i, bankStruct$PayvandCard);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1876n.a[gVar.ordinal()]) {
            case 1:
                return new BankOuterClass$ResponseGetPayvandCardList();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"payvandCards_", BankStruct$PayvandCard.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BankOuterClass$ResponseGetPayvandCardList.class) {
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

    public BankStruct$PayvandCard getPayvandCards(int i) {
        return (BankStruct$PayvandCard) this.payvandCards_.get(i);
    }

    public int getPayvandCardsCount() {
        return this.payvandCards_.size();
    }

    public List<BankStruct$PayvandCard> getPayvandCardsList() {
        return this.payvandCards_;
    }

    public V60 getPayvandCardsOrBuilder(int i) {
        return (V60) this.payvandCards_.get(i);
    }

    public List<? extends V60> getPayvandCardsOrBuilderList() {
        return this.payvandCards_;
    }

    public static a newBuilder(BankOuterClass$ResponseGetPayvandCardList bankOuterClass$ResponseGetPayvandCardList) {
        return (a) DEFAULT_INSTANCE.createBuilder(bankOuterClass$ResponseGetPayvandCardList);
    }

    public static BankOuterClass$ResponseGetPayvandCardList parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BankOuterClass$ResponseGetPayvandCardList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankOuterClass$ResponseGetPayvandCardList parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BankOuterClass$ResponseGetPayvandCardList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BankOuterClass$ResponseGetPayvandCardList parseFrom(AbstractC2383g abstractC2383g) {
        return (BankOuterClass$ResponseGetPayvandCardList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addPayvandCards(int i, BankStruct$PayvandCard bankStruct$PayvandCard) {
        bankStruct$PayvandCard.getClass();
        ensurePayvandCardsIsMutable();
        this.payvandCards_.add(i, bankStruct$PayvandCard);
    }

    public static BankOuterClass$ResponseGetPayvandCardList parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BankOuterClass$ResponseGetPayvandCardList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BankOuterClass$ResponseGetPayvandCardList parseFrom(byte[] bArr) {
        return (BankOuterClass$ResponseGetPayvandCardList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BankOuterClass$ResponseGetPayvandCardList parseFrom(byte[] bArr, C2394s c2394s) {
        return (BankOuterClass$ResponseGetPayvandCardList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BankOuterClass$ResponseGetPayvandCardList parseFrom(InputStream inputStream) {
        return (BankOuterClass$ResponseGetPayvandCardList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankOuterClass$ResponseGetPayvandCardList parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BankOuterClass$ResponseGetPayvandCardList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankOuterClass$ResponseGetPayvandCardList parseFrom(AbstractC2384h abstractC2384h) {
        return (BankOuterClass$ResponseGetPayvandCardList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BankOuterClass$ResponseGetPayvandCardList parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BankOuterClass$ResponseGetPayvandCardList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
