package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EJ5;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class RecommenderOuterClass$ResponseGetRelatedGroups extends GeneratedMessageLite implements U64 {
    private static final RecommenderOuterClass$ResponseGetRelatedGroups DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int RELATED_GROUPS_FIELD_NUMBER = 1;
    private B.j relatedGroups_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(RecommenderOuterClass$ResponseGetRelatedGroups.DEFAULT_INSTANCE);
        }
    }

    static {
        RecommenderOuterClass$ResponseGetRelatedGroups recommenderOuterClass$ResponseGetRelatedGroups = new RecommenderOuterClass$ResponseGetRelatedGroups();
        DEFAULT_INSTANCE = recommenderOuterClass$ResponseGetRelatedGroups;
        GeneratedMessageLite.registerDefaultInstance(RecommenderOuterClass$ResponseGetRelatedGroups.class, recommenderOuterClass$ResponseGetRelatedGroups);
    }

    private RecommenderOuterClass$ResponseGetRelatedGroups() {
    }

    private void addAllRelatedGroups(Iterable<? extends RecommenderOuterClass$RelatedGroup> iterable) {
        ensureRelatedGroupsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.relatedGroups_);
    }

    private void addRelatedGroups(RecommenderOuterClass$RelatedGroup recommenderOuterClass$RelatedGroup) {
        recommenderOuterClass$RelatedGroup.getClass();
        ensureRelatedGroupsIsMutable();
        this.relatedGroups_.add(recommenderOuterClass$RelatedGroup);
    }

    private void clearRelatedGroups() {
        this.relatedGroups_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureRelatedGroupsIsMutable() {
        B.j jVar = this.relatedGroups_;
        if (jVar.u()) {
            return;
        }
        this.relatedGroups_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static RecommenderOuterClass$ResponseGetRelatedGroups getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static RecommenderOuterClass$ResponseGetRelatedGroups parseDelimitedFrom(InputStream inputStream) {
        return (RecommenderOuterClass$ResponseGetRelatedGroups) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RecommenderOuterClass$ResponseGetRelatedGroups parseFrom(ByteBuffer byteBuffer) {
        return (RecommenderOuterClass$ResponseGetRelatedGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeRelatedGroups(int i) {
        ensureRelatedGroupsIsMutable();
        this.relatedGroups_.remove(i);
    }

    private void setRelatedGroups(int i, RecommenderOuterClass$RelatedGroup recommenderOuterClass$RelatedGroup) {
        recommenderOuterClass$RelatedGroup.getClass();
        ensureRelatedGroupsIsMutable();
        this.relatedGroups_.set(i, recommenderOuterClass$RelatedGroup);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1895t1.a[gVar.ordinal()]) {
            case 1:
                return new RecommenderOuterClass$ResponseGetRelatedGroups();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"relatedGroups_", RecommenderOuterClass$RelatedGroup.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (RecommenderOuterClass$ResponseGetRelatedGroups.class) {
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

    public RecommenderOuterClass$RelatedGroup getRelatedGroups(int i) {
        return (RecommenderOuterClass$RelatedGroup) this.relatedGroups_.get(i);
    }

    public int getRelatedGroupsCount() {
        return this.relatedGroups_.size();
    }

    public List<RecommenderOuterClass$RelatedGroup> getRelatedGroupsList() {
        return this.relatedGroups_;
    }

    public EJ5 getRelatedGroupsOrBuilder(int i) {
        return (EJ5) this.relatedGroups_.get(i);
    }

    public List<? extends EJ5> getRelatedGroupsOrBuilderList() {
        return this.relatedGroups_;
    }

    public static a newBuilder(RecommenderOuterClass$ResponseGetRelatedGroups recommenderOuterClass$ResponseGetRelatedGroups) {
        return (a) DEFAULT_INSTANCE.createBuilder(recommenderOuterClass$ResponseGetRelatedGroups);
    }

    public static RecommenderOuterClass$ResponseGetRelatedGroups parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (RecommenderOuterClass$ResponseGetRelatedGroups) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static RecommenderOuterClass$ResponseGetRelatedGroups parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (RecommenderOuterClass$ResponseGetRelatedGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static RecommenderOuterClass$ResponseGetRelatedGroups parseFrom(AbstractC2383g abstractC2383g) {
        return (RecommenderOuterClass$ResponseGetRelatedGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addRelatedGroups(int i, RecommenderOuterClass$RelatedGroup recommenderOuterClass$RelatedGroup) {
        recommenderOuterClass$RelatedGroup.getClass();
        ensureRelatedGroupsIsMutable();
        this.relatedGroups_.add(i, recommenderOuterClass$RelatedGroup);
    }

    public static RecommenderOuterClass$ResponseGetRelatedGroups parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (RecommenderOuterClass$ResponseGetRelatedGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static RecommenderOuterClass$ResponseGetRelatedGroups parseFrom(byte[] bArr) {
        return (RecommenderOuterClass$ResponseGetRelatedGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static RecommenderOuterClass$ResponseGetRelatedGroups parseFrom(byte[] bArr, C2394s c2394s) {
        return (RecommenderOuterClass$ResponseGetRelatedGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static RecommenderOuterClass$ResponseGetRelatedGroups parseFrom(InputStream inputStream) {
        return (RecommenderOuterClass$ResponseGetRelatedGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RecommenderOuterClass$ResponseGetRelatedGroups parseFrom(InputStream inputStream, C2394s c2394s) {
        return (RecommenderOuterClass$ResponseGetRelatedGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static RecommenderOuterClass$ResponseGetRelatedGroups parseFrom(AbstractC2384h abstractC2384h) {
        return (RecommenderOuterClass$ResponseGetRelatedGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static RecommenderOuterClass$ResponseGetRelatedGroups parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (RecommenderOuterClass$ResponseGetRelatedGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
