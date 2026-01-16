package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC19408qI5;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class ReactionsOuterClass$ResponseGetReactions extends GeneratedMessageLite implements U64 {
    private static final ReactionsOuterClass$ResponseGetReactions DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int REACTIONS_FIELD_NUMBER = 1;
    private B.j reactions_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(ReactionsOuterClass$ResponseGetReactions.DEFAULT_INSTANCE);
        }
    }

    static {
        ReactionsOuterClass$ResponseGetReactions reactionsOuterClass$ResponseGetReactions = new ReactionsOuterClass$ResponseGetReactions();
        DEFAULT_INSTANCE = reactionsOuterClass$ResponseGetReactions;
        GeneratedMessageLite.registerDefaultInstance(ReactionsOuterClass$ResponseGetReactions.class, reactionsOuterClass$ResponseGetReactions);
    }

    private ReactionsOuterClass$ResponseGetReactions() {
    }

    private void addAllReactions(Iterable<? extends ReactionsStruct$Reaction> iterable) {
        ensureReactionsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.reactions_);
    }

    private void addReactions(ReactionsStruct$Reaction reactionsStruct$Reaction) {
        reactionsStruct$Reaction.getClass();
        ensureReactionsIsMutable();
        this.reactions_.add(reactionsStruct$Reaction);
    }

    private void clearReactions() {
        this.reactions_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureReactionsIsMutable() {
        B.j jVar = this.reactions_;
        if (jVar.u()) {
            return;
        }
        this.reactions_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static ReactionsOuterClass$ResponseGetReactions getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static ReactionsOuterClass$ResponseGetReactions parseDelimitedFrom(InputStream inputStream) {
        return (ReactionsOuterClass$ResponseGetReactions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ReactionsOuterClass$ResponseGetReactions parseFrom(ByteBuffer byteBuffer) {
        return (ReactionsOuterClass$ResponseGetReactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeReactions(int i) {
        ensureReactionsIsMutable();
        this.reactions_.remove(i);
    }

    private void setReactions(int i, ReactionsStruct$Reaction reactionsStruct$Reaction) {
        reactionsStruct$Reaction.getClass();
        ensureReactionsIsMutable();
        this.reactions_.set(i, reactionsStruct$Reaction);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1889r1.a[gVar.ordinal()]) {
            case 1:
                return new ReactionsOuterClass$ResponseGetReactions();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"reactions_", ReactionsStruct$Reaction.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ReactionsOuterClass$ResponseGetReactions.class) {
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

    public ReactionsStruct$Reaction getReactions(int i) {
        return (ReactionsStruct$Reaction) this.reactions_.get(i);
    }

    public int getReactionsCount() {
        return this.reactions_.size();
    }

    public List<ReactionsStruct$Reaction> getReactionsList() {
        return this.reactions_;
    }

    public InterfaceC19408qI5 getReactionsOrBuilder(int i) {
        return (InterfaceC19408qI5) this.reactions_.get(i);
    }

    public List<? extends InterfaceC19408qI5> getReactionsOrBuilderList() {
        return this.reactions_;
    }

    public static a newBuilder(ReactionsOuterClass$ResponseGetReactions reactionsOuterClass$ResponseGetReactions) {
        return (a) DEFAULT_INSTANCE.createBuilder(reactionsOuterClass$ResponseGetReactions);
    }

    public static ReactionsOuterClass$ResponseGetReactions parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ReactionsOuterClass$ResponseGetReactions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ReactionsOuterClass$ResponseGetReactions parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ReactionsOuterClass$ResponseGetReactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ReactionsOuterClass$ResponseGetReactions parseFrom(AbstractC2383g abstractC2383g) {
        return (ReactionsOuterClass$ResponseGetReactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addReactions(int i, ReactionsStruct$Reaction reactionsStruct$Reaction) {
        reactionsStruct$Reaction.getClass();
        ensureReactionsIsMutable();
        this.reactions_.add(i, reactionsStruct$Reaction);
    }

    public static ReactionsOuterClass$ResponseGetReactions parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ReactionsOuterClass$ResponseGetReactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ReactionsOuterClass$ResponseGetReactions parseFrom(byte[] bArr) {
        return (ReactionsOuterClass$ResponseGetReactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ReactionsOuterClass$ResponseGetReactions parseFrom(byte[] bArr, C2394s c2394s) {
        return (ReactionsOuterClass$ResponseGetReactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ReactionsOuterClass$ResponseGetReactions parseFrom(InputStream inputStream) {
        return (ReactionsOuterClass$ResponseGetReactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ReactionsOuterClass$ResponseGetReactions parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ReactionsOuterClass$ResponseGetReactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ReactionsOuterClass$ResponseGetReactions parseFrom(AbstractC2384h abstractC2384h) {
        return (ReactionsOuterClass$ResponseGetReactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ReactionsOuterClass$ResponseGetReactions parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ReactionsOuterClass$ResponseGetReactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
