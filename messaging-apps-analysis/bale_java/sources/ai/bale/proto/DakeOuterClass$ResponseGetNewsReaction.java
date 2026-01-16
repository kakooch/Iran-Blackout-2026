package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC4643Fy1;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class DakeOuterClass$ResponseGetNewsReaction extends GeneratedMessageLite implements U64 {
    private static final DakeOuterClass$ResponseGetNewsReaction DEFAULT_INSTANCE;
    public static final int NEWS_REACTIONS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j newsReactions_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(DakeOuterClass$ResponseGetNewsReaction.DEFAULT_INSTANCE);
        }
    }

    static {
        DakeOuterClass$ResponseGetNewsReaction dakeOuterClass$ResponseGetNewsReaction = new DakeOuterClass$ResponseGetNewsReaction();
        DEFAULT_INSTANCE = dakeOuterClass$ResponseGetNewsReaction;
        GeneratedMessageLite.registerDefaultInstance(DakeOuterClass$ResponseGetNewsReaction.class, dakeOuterClass$ResponseGetNewsReaction);
    }

    private DakeOuterClass$ResponseGetNewsReaction() {
    }

    private void addAllNewsReactions(Iterable<? extends DakeStruct$NewsReaction> iterable) {
        ensureNewsReactionsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.newsReactions_);
    }

    private void addNewsReactions(DakeStruct$NewsReaction dakeStruct$NewsReaction) {
        dakeStruct$NewsReaction.getClass();
        ensureNewsReactionsIsMutable();
        this.newsReactions_.add(dakeStruct$NewsReaction);
    }

    private void clearNewsReactions() {
        this.newsReactions_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureNewsReactionsIsMutable() {
        B.j jVar = this.newsReactions_;
        if (jVar.u()) {
            return;
        }
        this.newsReactions_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static DakeOuterClass$ResponseGetNewsReaction getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static DakeOuterClass$ResponseGetNewsReaction parseDelimitedFrom(InputStream inputStream) {
        return (DakeOuterClass$ResponseGetNewsReaction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DakeOuterClass$ResponseGetNewsReaction parseFrom(ByteBuffer byteBuffer) {
        return (DakeOuterClass$ResponseGetNewsReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeNewsReactions(int i) {
        ensureNewsReactionsIsMutable();
        this.newsReactions_.remove(i);
    }

    private void setNewsReactions(int i, DakeStruct$NewsReaction dakeStruct$NewsReaction) {
        dakeStruct$NewsReaction.getClass();
        ensureNewsReactionsIsMutable();
        this.newsReactions_.set(i, dakeStruct$NewsReaction);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (M.a[gVar.ordinal()]) {
            case 1:
                return new DakeOuterClass$ResponseGetNewsReaction();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"newsReactions_", DakeStruct$NewsReaction.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (DakeOuterClass$ResponseGetNewsReaction.class) {
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

    public DakeStruct$NewsReaction getNewsReactions(int i) {
        return (DakeStruct$NewsReaction) this.newsReactions_.get(i);
    }

    public int getNewsReactionsCount() {
        return this.newsReactions_.size();
    }

    public List<DakeStruct$NewsReaction> getNewsReactionsList() {
        return this.newsReactions_;
    }

    public InterfaceC4643Fy1 getNewsReactionsOrBuilder(int i) {
        return (InterfaceC4643Fy1) this.newsReactions_.get(i);
    }

    public List<? extends InterfaceC4643Fy1> getNewsReactionsOrBuilderList() {
        return this.newsReactions_;
    }

    public static a newBuilder(DakeOuterClass$ResponseGetNewsReaction dakeOuterClass$ResponseGetNewsReaction) {
        return (a) DEFAULT_INSTANCE.createBuilder(dakeOuterClass$ResponseGetNewsReaction);
    }

    public static DakeOuterClass$ResponseGetNewsReaction parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (DakeOuterClass$ResponseGetNewsReaction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static DakeOuterClass$ResponseGetNewsReaction parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (DakeOuterClass$ResponseGetNewsReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static DakeOuterClass$ResponseGetNewsReaction parseFrom(AbstractC2383g abstractC2383g) {
        return (DakeOuterClass$ResponseGetNewsReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addNewsReactions(int i, DakeStruct$NewsReaction dakeStruct$NewsReaction) {
        dakeStruct$NewsReaction.getClass();
        ensureNewsReactionsIsMutable();
        this.newsReactions_.add(i, dakeStruct$NewsReaction);
    }

    public static DakeOuterClass$ResponseGetNewsReaction parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (DakeOuterClass$ResponseGetNewsReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static DakeOuterClass$ResponseGetNewsReaction parseFrom(byte[] bArr) {
        return (DakeOuterClass$ResponseGetNewsReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static DakeOuterClass$ResponseGetNewsReaction parseFrom(byte[] bArr, C2394s c2394s) {
        return (DakeOuterClass$ResponseGetNewsReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static DakeOuterClass$ResponseGetNewsReaction parseFrom(InputStream inputStream) {
        return (DakeOuterClass$ResponseGetNewsReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DakeOuterClass$ResponseGetNewsReaction parseFrom(InputStream inputStream, C2394s c2394s) {
        return (DakeOuterClass$ResponseGetNewsReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static DakeOuterClass$ResponseGetNewsReaction parseFrom(AbstractC2384h abstractC2384h) {
        return (DakeOuterClass$ResponseGetNewsReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static DakeOuterClass$ResponseGetNewsReaction parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (DakeOuterClass$ResponseGetNewsReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
