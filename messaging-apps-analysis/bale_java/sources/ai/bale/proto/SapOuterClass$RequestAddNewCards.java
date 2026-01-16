package ai.bale.proto;

import ai.bale.proto.SapStruct$CardInfo;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC6563Oa6;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class SapOuterClass$RequestAddNewCards extends GeneratedMessageLite implements U64 {
    public static final int CARD_INFO_FIELD_NUMBER = 1;
    private static final SapOuterClass$RequestAddNewCards DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private B.j cardInfo_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(Iterable iterable) {
            q();
            ((SapOuterClass$RequestAddNewCards) this.b).addAllCardInfo(iterable);
            return this;
        }

        public a B(SapStruct$CardInfo.a aVar) {
            q();
            ((SapOuterClass$RequestAddNewCards) this.b).addCardInfo((SapStruct$CardInfo) aVar.a());
            return this;
        }

        private a() {
            super(SapOuterClass$RequestAddNewCards.DEFAULT_INSTANCE);
        }
    }

    static {
        SapOuterClass$RequestAddNewCards sapOuterClass$RequestAddNewCards = new SapOuterClass$RequestAddNewCards();
        DEFAULT_INSTANCE = sapOuterClass$RequestAddNewCards;
        GeneratedMessageLite.registerDefaultInstance(SapOuterClass$RequestAddNewCards.class, sapOuterClass$RequestAddNewCards);
    }

    private SapOuterClass$RequestAddNewCards() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllCardInfo(Iterable<? extends SapStruct$CardInfo> iterable) {
        ensureCardInfoIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.cardInfo_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addCardInfo(SapStruct$CardInfo sapStruct$CardInfo) {
        sapStruct$CardInfo.getClass();
        ensureCardInfoIsMutable();
        this.cardInfo_.add(sapStruct$CardInfo);
    }

    private void clearCardInfo() {
        this.cardInfo_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureCardInfoIsMutable() {
        B.j jVar = this.cardInfo_;
        if (jVar.u()) {
            return;
        }
        this.cardInfo_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static SapOuterClass$RequestAddNewCards getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SapOuterClass$RequestAddNewCards parseDelimitedFrom(InputStream inputStream) {
        return (SapOuterClass$RequestAddNewCards) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SapOuterClass$RequestAddNewCards parseFrom(ByteBuffer byteBuffer) {
        return (SapOuterClass$RequestAddNewCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeCardInfo(int i) {
        ensureCardInfoIsMutable();
        this.cardInfo_.remove(i);
    }

    private void setCardInfo(int i, SapStruct$CardInfo sapStruct$CardInfo) {
        sapStruct$CardInfo.getClass();
        ensureCardInfoIsMutable();
        this.cardInfo_.set(i, sapStruct$CardInfo);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (H1.a[gVar.ordinal()]) {
            case 1:
                return new SapOuterClass$RequestAddNewCards();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"cardInfo_", SapStruct$CardInfo.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SapOuterClass$RequestAddNewCards.class) {
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

    public SapStruct$CardInfo getCardInfo(int i) {
        return (SapStruct$CardInfo) this.cardInfo_.get(i);
    }

    public int getCardInfoCount() {
        return this.cardInfo_.size();
    }

    public List<SapStruct$CardInfo> getCardInfoList() {
        return this.cardInfo_;
    }

    public InterfaceC6563Oa6 getCardInfoOrBuilder(int i) {
        return (InterfaceC6563Oa6) this.cardInfo_.get(i);
    }

    public List<? extends InterfaceC6563Oa6> getCardInfoOrBuilderList() {
        return this.cardInfo_;
    }

    public static a newBuilder(SapOuterClass$RequestAddNewCards sapOuterClass$RequestAddNewCards) {
        return (a) DEFAULT_INSTANCE.createBuilder(sapOuterClass$RequestAddNewCards);
    }

    public static SapOuterClass$RequestAddNewCards parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SapOuterClass$RequestAddNewCards) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SapOuterClass$RequestAddNewCards parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SapOuterClass$RequestAddNewCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SapOuterClass$RequestAddNewCards parseFrom(AbstractC2383g abstractC2383g) {
        return (SapOuterClass$RequestAddNewCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addCardInfo(int i, SapStruct$CardInfo sapStruct$CardInfo) {
        sapStruct$CardInfo.getClass();
        ensureCardInfoIsMutable();
        this.cardInfo_.add(i, sapStruct$CardInfo);
    }

    public static SapOuterClass$RequestAddNewCards parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SapOuterClass$RequestAddNewCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SapOuterClass$RequestAddNewCards parseFrom(byte[] bArr) {
        return (SapOuterClass$RequestAddNewCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SapOuterClass$RequestAddNewCards parseFrom(byte[] bArr, C2394s c2394s) {
        return (SapOuterClass$RequestAddNewCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SapOuterClass$RequestAddNewCards parseFrom(InputStream inputStream) {
        return (SapOuterClass$RequestAddNewCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SapOuterClass$RequestAddNewCards parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SapOuterClass$RequestAddNewCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SapOuterClass$RequestAddNewCards parseFrom(AbstractC2384h abstractC2384h) {
        return (SapOuterClass$RequestAddNewCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SapOuterClass$RequestAddNewCards parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SapOuterClass$RequestAddNewCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
