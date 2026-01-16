package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class SapOuterClass$ResponseAddNewCards extends GeneratedMessageLite implements U64 {
    public static final int CARD_ID_FIELD_NUMBER = 1;
    private static final SapOuterClass$ResponseAddNewCards DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private B.j cardId_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SapOuterClass$ResponseAddNewCards.DEFAULT_INSTANCE);
        }
    }

    static {
        SapOuterClass$ResponseAddNewCards sapOuterClass$ResponseAddNewCards = new SapOuterClass$ResponseAddNewCards();
        DEFAULT_INSTANCE = sapOuterClass$ResponseAddNewCards;
        GeneratedMessageLite.registerDefaultInstance(SapOuterClass$ResponseAddNewCards.class, sapOuterClass$ResponseAddNewCards);
    }

    private SapOuterClass$ResponseAddNewCards() {
    }

    private void addAllCardId(Iterable<String> iterable) {
        ensureCardIdIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.cardId_);
    }

    private void addCardId(String str) {
        str.getClass();
        ensureCardIdIsMutable();
        this.cardId_.add(str);
    }

    private void addCardIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        ensureCardIdIsMutable();
        this.cardId_.add(abstractC2383g.f0());
    }

    private void clearCardId() {
        this.cardId_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureCardIdIsMutable() {
        B.j jVar = this.cardId_;
        if (jVar.u()) {
            return;
        }
        this.cardId_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static SapOuterClass$ResponseAddNewCards getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SapOuterClass$ResponseAddNewCards parseDelimitedFrom(InputStream inputStream) {
        return (SapOuterClass$ResponseAddNewCards) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SapOuterClass$ResponseAddNewCards parseFrom(ByteBuffer byteBuffer) {
        return (SapOuterClass$ResponseAddNewCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCardId(int i, String str) {
        str.getClass();
        ensureCardIdIsMutable();
        this.cardId_.set(i, str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (H1.a[gVar.ordinal()]) {
            case 1:
                return new SapOuterClass$ResponseAddNewCards();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001Ț", new Object[]{"cardId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SapOuterClass$ResponseAddNewCards.class) {
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

    public String getCardId(int i) {
        return (String) this.cardId_.get(i);
    }

    public AbstractC2383g getCardIdBytes(int i) {
        return AbstractC2383g.N((String) this.cardId_.get(i));
    }

    public int getCardIdCount() {
        return this.cardId_.size();
    }

    public List<String> getCardIdList() {
        return this.cardId_;
    }

    public static a newBuilder(SapOuterClass$ResponseAddNewCards sapOuterClass$ResponseAddNewCards) {
        return (a) DEFAULT_INSTANCE.createBuilder(sapOuterClass$ResponseAddNewCards);
    }

    public static SapOuterClass$ResponseAddNewCards parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SapOuterClass$ResponseAddNewCards) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SapOuterClass$ResponseAddNewCards parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SapOuterClass$ResponseAddNewCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SapOuterClass$ResponseAddNewCards parseFrom(AbstractC2383g abstractC2383g) {
        return (SapOuterClass$ResponseAddNewCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SapOuterClass$ResponseAddNewCards parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SapOuterClass$ResponseAddNewCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SapOuterClass$ResponseAddNewCards parseFrom(byte[] bArr) {
        return (SapOuterClass$ResponseAddNewCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SapOuterClass$ResponseAddNewCards parseFrom(byte[] bArr, C2394s c2394s) {
        return (SapOuterClass$ResponseAddNewCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SapOuterClass$ResponseAddNewCards parseFrom(InputStream inputStream) {
        return (SapOuterClass$ResponseAddNewCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SapOuterClass$ResponseAddNewCards parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SapOuterClass$ResponseAddNewCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SapOuterClass$ResponseAddNewCards parseFrom(AbstractC2384h abstractC2384h) {
        return (SapOuterClass$ResponseAddNewCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SapOuterClass$ResponseAddNewCards parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SapOuterClass$ResponseAddNewCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
