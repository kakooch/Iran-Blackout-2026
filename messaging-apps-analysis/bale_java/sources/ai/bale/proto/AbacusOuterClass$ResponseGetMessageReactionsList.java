package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC13302g0;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes6.dex */
public final class AbacusOuterClass$ResponseGetMessageReactionsList extends GeneratedMessageLite implements U64 {
    private static final AbacusOuterClass$ResponseGetMessageReactionsList DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int USER_REACTIONS_FIELD_NUMBER = 1;
    private B.j userReactions_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AbacusOuterClass$ResponseGetMessageReactionsList.DEFAULT_INSTANCE);
        }
    }

    static {
        AbacusOuterClass$ResponseGetMessageReactionsList abacusOuterClass$ResponseGetMessageReactionsList = new AbacusOuterClass$ResponseGetMessageReactionsList();
        DEFAULT_INSTANCE = abacusOuterClass$ResponseGetMessageReactionsList;
        GeneratedMessageLite.registerDefaultInstance(AbacusOuterClass$ResponseGetMessageReactionsList.class, abacusOuterClass$ResponseGetMessageReactionsList);
    }

    private AbacusOuterClass$ResponseGetMessageReactionsList() {
    }

    private void addAllUserReactions(Iterable<? extends AbacusOuterClass$UserReaction> iterable) {
        ensureUserReactionsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.userReactions_);
    }

    private void addUserReactions(AbacusOuterClass$UserReaction abacusOuterClass$UserReaction) {
        abacusOuterClass$UserReaction.getClass();
        ensureUserReactionsIsMutable();
        this.userReactions_.add(abacusOuterClass$UserReaction);
    }

    private void clearUserReactions() {
        this.userReactions_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureUserReactionsIsMutable() {
        B.j jVar = this.userReactions_;
        if (jVar.u()) {
            return;
        }
        this.userReactions_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static AbacusOuterClass$ResponseGetMessageReactionsList getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AbacusOuterClass$ResponseGetMessageReactionsList parseDelimitedFrom(InputStream inputStream) {
        return (AbacusOuterClass$ResponseGetMessageReactionsList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AbacusOuterClass$ResponseGetMessageReactionsList parseFrom(ByteBuffer byteBuffer) {
        return (AbacusOuterClass$ResponseGetMessageReactionsList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeUserReactions(int i) {
        ensureUserReactionsIsMutable();
        this.userReactions_.remove(i);
    }

    private void setUserReactions(int i, AbacusOuterClass$UserReaction abacusOuterClass$UserReaction) {
        abacusOuterClass$UserReaction.getClass();
        ensureUserReactionsIsMutable();
        this.userReactions_.set(i, abacusOuterClass$UserReaction);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1837a.a[gVar.ordinal()]) {
            case 1:
                return new AbacusOuterClass$ResponseGetMessageReactionsList();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"userReactions_", AbacusOuterClass$UserReaction.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AbacusOuterClass$ResponseGetMessageReactionsList.class) {
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

    public AbacusOuterClass$UserReaction getUserReactions(int i) {
        return (AbacusOuterClass$UserReaction) this.userReactions_.get(i);
    }

    public int getUserReactionsCount() {
        return this.userReactions_.size();
    }

    public List<AbacusOuterClass$UserReaction> getUserReactionsList() {
        return this.userReactions_;
    }

    public InterfaceC13302g0 getUserReactionsOrBuilder(int i) {
        return (InterfaceC13302g0) this.userReactions_.get(i);
    }

    public List<? extends InterfaceC13302g0> getUserReactionsOrBuilderList() {
        return this.userReactions_;
    }

    public static a newBuilder(AbacusOuterClass$ResponseGetMessageReactionsList abacusOuterClass$ResponseGetMessageReactionsList) {
        return (a) DEFAULT_INSTANCE.createBuilder(abacusOuterClass$ResponseGetMessageReactionsList);
    }

    public static AbacusOuterClass$ResponseGetMessageReactionsList parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AbacusOuterClass$ResponseGetMessageReactionsList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AbacusOuterClass$ResponseGetMessageReactionsList parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AbacusOuterClass$ResponseGetMessageReactionsList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AbacusOuterClass$ResponseGetMessageReactionsList parseFrom(AbstractC2383g abstractC2383g) {
        return (AbacusOuterClass$ResponseGetMessageReactionsList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addUserReactions(int i, AbacusOuterClass$UserReaction abacusOuterClass$UserReaction) {
        abacusOuterClass$UserReaction.getClass();
        ensureUserReactionsIsMutable();
        this.userReactions_.add(i, abacusOuterClass$UserReaction);
    }

    public static AbacusOuterClass$ResponseGetMessageReactionsList parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AbacusOuterClass$ResponseGetMessageReactionsList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AbacusOuterClass$ResponseGetMessageReactionsList parseFrom(byte[] bArr) {
        return (AbacusOuterClass$ResponseGetMessageReactionsList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AbacusOuterClass$ResponseGetMessageReactionsList parseFrom(byte[] bArr, C2394s c2394s) {
        return (AbacusOuterClass$ResponseGetMessageReactionsList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AbacusOuterClass$ResponseGetMessageReactionsList parseFrom(InputStream inputStream) {
        return (AbacusOuterClass$ResponseGetMessageReactionsList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AbacusOuterClass$ResponseGetMessageReactionsList parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AbacusOuterClass$ResponseGetMessageReactionsList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AbacusOuterClass$ResponseGetMessageReactionsList parseFrom(AbstractC2384h abstractC2384h) {
        return (AbacusOuterClass$ResponseGetMessageReactionsList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AbacusOuterClass$ResponseGetMessageReactionsList parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AbacusOuterClass$ResponseGetMessageReactionsList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
