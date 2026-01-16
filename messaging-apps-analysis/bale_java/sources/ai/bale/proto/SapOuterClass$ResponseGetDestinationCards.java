package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC7046Qa6;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class SapOuterClass$ResponseGetDestinationCards extends GeneratedMessageLite implements U64 {
    public static final int CARDS_FIELD_NUMBER = 1;
    private static final SapOuterClass$ResponseGetDestinationCards DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private B.j cards_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SapOuterClass$ResponseGetDestinationCards.DEFAULT_INSTANCE);
        }
    }

    static {
        SapOuterClass$ResponseGetDestinationCards sapOuterClass$ResponseGetDestinationCards = new SapOuterClass$ResponseGetDestinationCards();
        DEFAULT_INSTANCE = sapOuterClass$ResponseGetDestinationCards;
        GeneratedMessageLite.registerDefaultInstance(SapOuterClass$ResponseGetDestinationCards.class, sapOuterClass$ResponseGetDestinationCards);
    }

    private SapOuterClass$ResponseGetDestinationCards() {
    }

    private void addAllCards(Iterable<? extends SapStruct$DestinationCard> iterable) {
        ensureCardsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.cards_);
    }

    private void addCards(SapStruct$DestinationCard sapStruct$DestinationCard) {
        sapStruct$DestinationCard.getClass();
        ensureCardsIsMutable();
        this.cards_.add(sapStruct$DestinationCard);
    }

    private void clearCards() {
        this.cards_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureCardsIsMutable() {
        B.j jVar = this.cards_;
        if (jVar.u()) {
            return;
        }
        this.cards_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static SapOuterClass$ResponseGetDestinationCards getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SapOuterClass$ResponseGetDestinationCards parseDelimitedFrom(InputStream inputStream) {
        return (SapOuterClass$ResponseGetDestinationCards) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SapOuterClass$ResponseGetDestinationCards parseFrom(ByteBuffer byteBuffer) {
        return (SapOuterClass$ResponseGetDestinationCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeCards(int i) {
        ensureCardsIsMutable();
        this.cards_.remove(i);
    }

    private void setCards(int i, SapStruct$DestinationCard sapStruct$DestinationCard) {
        sapStruct$DestinationCard.getClass();
        ensureCardsIsMutable();
        this.cards_.set(i, sapStruct$DestinationCard);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (H1.a[gVar.ordinal()]) {
            case 1:
                return new SapOuterClass$ResponseGetDestinationCards();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"cards_", SapStruct$DestinationCard.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SapOuterClass$ResponseGetDestinationCards.class) {
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

    public SapStruct$DestinationCard getCards(int i) {
        return (SapStruct$DestinationCard) this.cards_.get(i);
    }

    public int getCardsCount() {
        return this.cards_.size();
    }

    public List<SapStruct$DestinationCard> getCardsList() {
        return this.cards_;
    }

    public InterfaceC7046Qa6 getCardsOrBuilder(int i) {
        return (InterfaceC7046Qa6) this.cards_.get(i);
    }

    public List<? extends InterfaceC7046Qa6> getCardsOrBuilderList() {
        return this.cards_;
    }

    public static a newBuilder(SapOuterClass$ResponseGetDestinationCards sapOuterClass$ResponseGetDestinationCards) {
        return (a) DEFAULT_INSTANCE.createBuilder(sapOuterClass$ResponseGetDestinationCards);
    }

    public static SapOuterClass$ResponseGetDestinationCards parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SapOuterClass$ResponseGetDestinationCards) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SapOuterClass$ResponseGetDestinationCards parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SapOuterClass$ResponseGetDestinationCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SapOuterClass$ResponseGetDestinationCards parseFrom(AbstractC2383g abstractC2383g) {
        return (SapOuterClass$ResponseGetDestinationCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addCards(int i, SapStruct$DestinationCard sapStruct$DestinationCard) {
        sapStruct$DestinationCard.getClass();
        ensureCardsIsMutable();
        this.cards_.add(i, sapStruct$DestinationCard);
    }

    public static SapOuterClass$ResponseGetDestinationCards parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SapOuterClass$ResponseGetDestinationCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SapOuterClass$ResponseGetDestinationCards parseFrom(byte[] bArr) {
        return (SapOuterClass$ResponseGetDestinationCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SapOuterClass$ResponseGetDestinationCards parseFrom(byte[] bArr, C2394s c2394s) {
        return (SapOuterClass$ResponseGetDestinationCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SapOuterClass$ResponseGetDestinationCards parseFrom(InputStream inputStream) {
        return (SapOuterClass$ResponseGetDestinationCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SapOuterClass$ResponseGetDestinationCards parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SapOuterClass$ResponseGetDestinationCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SapOuterClass$ResponseGetDestinationCards parseFrom(AbstractC2384h abstractC2384h) {
        return (SapOuterClass$ResponseGetDestinationCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SapOuterClass$ResponseGetDestinationCards parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SapOuterClass$ResponseGetDestinationCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
