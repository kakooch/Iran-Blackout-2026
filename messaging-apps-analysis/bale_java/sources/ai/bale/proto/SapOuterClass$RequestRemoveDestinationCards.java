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
public final class SapOuterClass$RequestRemoveDestinationCards extends GeneratedMessageLite implements U64 {
    private static final SapOuterClass$RequestRemoveDestinationCards DEFAULT_INSTANCE;
    public static final int IDS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j ids_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(Iterable iterable) {
            q();
            ((SapOuterClass$RequestRemoveDestinationCards) this.b).addAllIds(iterable);
            return this;
        }

        private a() {
            super(SapOuterClass$RequestRemoveDestinationCards.DEFAULT_INSTANCE);
        }
    }

    static {
        SapOuterClass$RequestRemoveDestinationCards sapOuterClass$RequestRemoveDestinationCards = new SapOuterClass$RequestRemoveDestinationCards();
        DEFAULT_INSTANCE = sapOuterClass$RequestRemoveDestinationCards;
        GeneratedMessageLite.registerDefaultInstance(SapOuterClass$RequestRemoveDestinationCards.class, sapOuterClass$RequestRemoveDestinationCards);
    }

    private SapOuterClass$RequestRemoveDestinationCards() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllIds(Iterable<String> iterable) {
        ensureIdsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.ids_);
    }

    private void addIds(String str) {
        str.getClass();
        ensureIdsIsMutable();
        this.ids_.add(str);
    }

    private void addIdsBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        ensureIdsIsMutable();
        this.ids_.add(abstractC2383g.f0());
    }

    private void clearIds() {
        this.ids_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureIdsIsMutable() {
        B.j jVar = this.ids_;
        if (jVar.u()) {
            return;
        }
        this.ids_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static SapOuterClass$RequestRemoveDestinationCards getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SapOuterClass$RequestRemoveDestinationCards parseDelimitedFrom(InputStream inputStream) {
        return (SapOuterClass$RequestRemoveDestinationCards) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SapOuterClass$RequestRemoveDestinationCards parseFrom(ByteBuffer byteBuffer) {
        return (SapOuterClass$RequestRemoveDestinationCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setIds(int i, String str) {
        str.getClass();
        ensureIdsIsMutable();
        this.ids_.set(i, str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (H1.a[gVar.ordinal()]) {
            case 1:
                return new SapOuterClass$RequestRemoveDestinationCards();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001Ț", new Object[]{"ids_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SapOuterClass$RequestRemoveDestinationCards.class) {
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

    public String getIds(int i) {
        return (String) this.ids_.get(i);
    }

    public AbstractC2383g getIdsBytes(int i) {
        return AbstractC2383g.N((String) this.ids_.get(i));
    }

    public int getIdsCount() {
        return this.ids_.size();
    }

    public List<String> getIdsList() {
        return this.ids_;
    }

    public static a newBuilder(SapOuterClass$RequestRemoveDestinationCards sapOuterClass$RequestRemoveDestinationCards) {
        return (a) DEFAULT_INSTANCE.createBuilder(sapOuterClass$RequestRemoveDestinationCards);
    }

    public static SapOuterClass$RequestRemoveDestinationCards parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SapOuterClass$RequestRemoveDestinationCards) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SapOuterClass$RequestRemoveDestinationCards parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SapOuterClass$RequestRemoveDestinationCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SapOuterClass$RequestRemoveDestinationCards parseFrom(AbstractC2383g abstractC2383g) {
        return (SapOuterClass$RequestRemoveDestinationCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SapOuterClass$RequestRemoveDestinationCards parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SapOuterClass$RequestRemoveDestinationCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SapOuterClass$RequestRemoveDestinationCards parseFrom(byte[] bArr) {
        return (SapOuterClass$RequestRemoveDestinationCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SapOuterClass$RequestRemoveDestinationCards parseFrom(byte[] bArr, C2394s c2394s) {
        return (SapOuterClass$RequestRemoveDestinationCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SapOuterClass$RequestRemoveDestinationCards parseFrom(InputStream inputStream) {
        return (SapOuterClass$RequestRemoveDestinationCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SapOuterClass$RequestRemoveDestinationCards parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SapOuterClass$RequestRemoveDestinationCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SapOuterClass$RequestRemoveDestinationCards parseFrom(AbstractC2384h abstractC2384h) {
        return (SapOuterClass$RequestRemoveDestinationCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SapOuterClass$RequestRemoveDestinationCards parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SapOuterClass$RequestRemoveDestinationCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
