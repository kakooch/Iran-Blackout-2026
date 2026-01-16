package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC7514Sa6;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class SapOuterClass$ResponseGetCards extends GeneratedMessageLite implements U64 {
    private static final SapOuterClass$ResponseGetCards DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int USER_CARDS_FIELD_NUMBER = 1;
    private B.j userCards_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SapOuterClass$ResponseGetCards.DEFAULT_INSTANCE);
        }
    }

    static {
        SapOuterClass$ResponseGetCards sapOuterClass$ResponseGetCards = new SapOuterClass$ResponseGetCards();
        DEFAULT_INSTANCE = sapOuterClass$ResponseGetCards;
        GeneratedMessageLite.registerDefaultInstance(SapOuterClass$ResponseGetCards.class, sapOuterClass$ResponseGetCards);
    }

    private SapOuterClass$ResponseGetCards() {
    }

    private void addAllUserCards(Iterable<? extends SapStruct$UserCard> iterable) {
        ensureUserCardsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.userCards_);
    }

    private void addUserCards(SapStruct$UserCard sapStruct$UserCard) {
        sapStruct$UserCard.getClass();
        ensureUserCardsIsMutable();
        this.userCards_.add(sapStruct$UserCard);
    }

    private void clearUserCards() {
        this.userCards_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureUserCardsIsMutable() {
        B.j jVar = this.userCards_;
        if (jVar.u()) {
            return;
        }
        this.userCards_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static SapOuterClass$ResponseGetCards getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SapOuterClass$ResponseGetCards parseDelimitedFrom(InputStream inputStream) {
        return (SapOuterClass$ResponseGetCards) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SapOuterClass$ResponseGetCards parseFrom(ByteBuffer byteBuffer) {
        return (SapOuterClass$ResponseGetCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeUserCards(int i) {
        ensureUserCardsIsMutable();
        this.userCards_.remove(i);
    }

    private void setUserCards(int i, SapStruct$UserCard sapStruct$UserCard) {
        sapStruct$UserCard.getClass();
        ensureUserCardsIsMutable();
        this.userCards_.set(i, sapStruct$UserCard);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (H1.a[gVar.ordinal()]) {
            case 1:
                return new SapOuterClass$ResponseGetCards();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"userCards_", SapStruct$UserCard.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SapOuterClass$ResponseGetCards.class) {
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

    public SapStruct$UserCard getUserCards(int i) {
        return (SapStruct$UserCard) this.userCards_.get(i);
    }

    public int getUserCardsCount() {
        return this.userCards_.size();
    }

    public List<SapStruct$UserCard> getUserCardsList() {
        return this.userCards_;
    }

    public InterfaceC7514Sa6 getUserCardsOrBuilder(int i) {
        return (InterfaceC7514Sa6) this.userCards_.get(i);
    }

    public List<? extends InterfaceC7514Sa6> getUserCardsOrBuilderList() {
        return this.userCards_;
    }

    public static a newBuilder(SapOuterClass$ResponseGetCards sapOuterClass$ResponseGetCards) {
        return (a) DEFAULT_INSTANCE.createBuilder(sapOuterClass$ResponseGetCards);
    }

    public static SapOuterClass$ResponseGetCards parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SapOuterClass$ResponseGetCards) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SapOuterClass$ResponseGetCards parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SapOuterClass$ResponseGetCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SapOuterClass$ResponseGetCards parseFrom(AbstractC2383g abstractC2383g) {
        return (SapOuterClass$ResponseGetCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addUserCards(int i, SapStruct$UserCard sapStruct$UserCard) {
        sapStruct$UserCard.getClass();
        ensureUserCardsIsMutable();
        this.userCards_.add(i, sapStruct$UserCard);
    }

    public static SapOuterClass$ResponseGetCards parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SapOuterClass$ResponseGetCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SapOuterClass$ResponseGetCards parseFrom(byte[] bArr) {
        return (SapOuterClass$ResponseGetCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SapOuterClass$ResponseGetCards parseFrom(byte[] bArr, C2394s c2394s) {
        return (SapOuterClass$ResponseGetCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SapOuterClass$ResponseGetCards parseFrom(InputStream inputStream) {
        return (SapOuterClass$ResponseGetCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SapOuterClass$ResponseGetCards parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SapOuterClass$ResponseGetCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SapOuterClass$ResponseGetCards parseFrom(AbstractC2384h abstractC2384h) {
        return (SapOuterClass$ResponseGetCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SapOuterClass$ResponseGetCards parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SapOuterClass$ResponseGetCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
