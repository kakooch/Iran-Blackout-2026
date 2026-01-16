package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC11728dV6;
import ir.nasim.KW4;
import ir.nasim.OU6;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class StoryStruct$Viewer extends GeneratedMessageLite implements InterfaceC11728dV6 {
    private static final StoryStruct$Viewer DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int REACTED_AT_FIELD_NUMBER = 3;
    public static final int REACTION_DATA_FIELD_NUMBER = 4;
    public static final int REACTION_FIELD_NUMBER = 1;
    public static final int USER_ID_FIELD_NUMBER = 2;
    private long reactedAt_;
    private int userId_;
    private String reaction_ = "";
    private B.j reactionData_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements InterfaceC11728dV6 {
        private a() {
            super(StoryStruct$Viewer.DEFAULT_INSTANCE);
        }
    }

    static {
        StoryStruct$Viewer storyStruct$Viewer = new StoryStruct$Viewer();
        DEFAULT_INSTANCE = storyStruct$Viewer;
        GeneratedMessageLite.registerDefaultInstance(StoryStruct$Viewer.class, storyStruct$Viewer);
    }

    private StoryStruct$Viewer() {
    }

    private void addAllReactionData(Iterable<? extends StoryStruct$StoryReaction> iterable) {
        ensureReactionDataIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.reactionData_);
    }

    private void addReactionData(StoryStruct$StoryReaction storyStruct$StoryReaction) {
        storyStruct$StoryReaction.getClass();
        ensureReactionDataIsMutable();
        this.reactionData_.add(storyStruct$StoryReaction);
    }

    private void clearReactedAt() {
        this.reactedAt_ = 0L;
    }

    private void clearReaction() {
        this.reaction_ = getDefaultInstance().getReaction();
    }

    private void clearReactionData() {
        this.reactionData_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearUserId() {
        this.userId_ = 0;
    }

    private void ensureReactionDataIsMutable() {
        B.j jVar = this.reactionData_;
        if (jVar.u()) {
            return;
        }
        this.reactionData_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static StoryStruct$Viewer getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static StoryStruct$Viewer parseDelimitedFrom(InputStream inputStream) {
        return (StoryStruct$Viewer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryStruct$Viewer parseFrom(ByteBuffer byteBuffer) {
        return (StoryStruct$Viewer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeReactionData(int i) {
        ensureReactionDataIsMutable();
        this.reactionData_.remove(i);
    }

    private void setReactedAt(long j) {
        this.reactedAt_ = j;
    }

    private void setReaction(String str) {
        str.getClass();
        this.reaction_ = str;
    }

    private void setReactionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.reaction_ = abstractC2383g.f0();
    }

    private void setReactionData(int i, StoryStruct$StoryReaction storyStruct$StoryReaction) {
        storyStruct$StoryReaction.getClass();
        ensureReactionDataIsMutable();
        this.reactionData_.set(i, storyStruct$StoryReaction);
    }

    private void setUserId(int i) {
        this.userId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (d2.a[gVar.ordinal()]) {
            case 1:
                return new StoryStruct$Viewer();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0001\u0000\u0001Ȉ\u0002\u0004\u0003\u0002\u0004\u001b", new Object[]{"reaction_", "userId_", "reactedAt_", "reactionData_", StoryStruct$StoryReaction.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (StoryStruct$Viewer.class) {
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

    public long getReactedAt() {
        return this.reactedAt_;
    }

    public String getReaction() {
        return this.reaction_;
    }

    public AbstractC2383g getReactionBytes() {
        return AbstractC2383g.N(this.reaction_);
    }

    public StoryStruct$StoryReaction getReactionData(int i) {
        return (StoryStruct$StoryReaction) this.reactionData_.get(i);
    }

    public int getReactionDataCount() {
        return this.reactionData_.size();
    }

    public List<StoryStruct$StoryReaction> getReactionDataList() {
        return this.reactionData_;
    }

    public OU6 getReactionDataOrBuilder(int i) {
        return (OU6) this.reactionData_.get(i);
    }

    public List<? extends OU6> getReactionDataOrBuilderList() {
        return this.reactionData_;
    }

    public int getUserId() {
        return this.userId_;
    }

    public static a newBuilder(StoryStruct$Viewer storyStruct$Viewer) {
        return (a) DEFAULT_INSTANCE.createBuilder(storyStruct$Viewer);
    }

    public static StoryStruct$Viewer parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryStruct$Viewer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryStruct$Viewer parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (StoryStruct$Viewer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static StoryStruct$Viewer parseFrom(AbstractC2383g abstractC2383g) {
        return (StoryStruct$Viewer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addReactionData(int i, StoryStruct$StoryReaction storyStruct$StoryReaction) {
        storyStruct$StoryReaction.getClass();
        ensureReactionDataIsMutable();
        this.reactionData_.add(i, storyStruct$StoryReaction);
    }

    public static StoryStruct$Viewer parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (StoryStruct$Viewer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static StoryStruct$Viewer parseFrom(byte[] bArr) {
        return (StoryStruct$Viewer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StoryStruct$Viewer parseFrom(byte[] bArr, C2394s c2394s) {
        return (StoryStruct$Viewer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static StoryStruct$Viewer parseFrom(InputStream inputStream) {
        return (StoryStruct$Viewer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryStruct$Viewer parseFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryStruct$Viewer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryStruct$Viewer parseFrom(AbstractC2384h abstractC2384h) {
        return (StoryStruct$Viewer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static StoryStruct$Viewer parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (StoryStruct$Viewer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
