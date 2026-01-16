package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.HS2;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class GroupsOuterClass$RequestGetGroupRecommendations extends GeneratedMessageLite implements U64 {
    private static final GroupsOuterClass$RequestGetGroupRecommendations DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int SOURCE_FIELD_NUMBER = 1;
    private int source_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GroupsOuterClass$RequestGetGroupRecommendations.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsOuterClass$RequestGetGroupRecommendations groupsOuterClass$RequestGetGroupRecommendations = new GroupsOuterClass$RequestGetGroupRecommendations();
        DEFAULT_INSTANCE = groupsOuterClass$RequestGetGroupRecommendations;
        GeneratedMessageLite.registerDefaultInstance(GroupsOuterClass$RequestGetGroupRecommendations.class, groupsOuterClass$RequestGetGroupRecommendations);
    }

    private GroupsOuterClass$RequestGetGroupRecommendations() {
    }

    private void clearSource() {
        this.source_ = 0;
    }

    public static GroupsOuterClass$RequestGetGroupRecommendations getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsOuterClass$RequestGetGroupRecommendations parseDelimitedFrom(InputStream inputStream) {
        return (GroupsOuterClass$RequestGetGroupRecommendations) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$RequestGetGroupRecommendations parseFrom(ByteBuffer byteBuffer) {
        return (GroupsOuterClass$RequestGetGroupRecommendations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setSource(HS2 hs2) {
        this.source_ = hs2.getNumber();
    }

    private void setSourceValue(int i) {
        this.source_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1874m0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsOuterClass$RequestGetGroupRecommendations();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"source_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsOuterClass$RequestGetGroupRecommendations.class) {
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

    public HS2 getSource() {
        HS2 hs2J = HS2.j(this.source_);
        return hs2J == null ? HS2.UNRECOGNIZED : hs2J;
    }

    public int getSourceValue() {
        return this.source_;
    }

    public static a newBuilder(GroupsOuterClass$RequestGetGroupRecommendations groupsOuterClass$RequestGetGroupRecommendations) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsOuterClass$RequestGetGroupRecommendations);
    }

    public static GroupsOuterClass$RequestGetGroupRecommendations parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$RequestGetGroupRecommendations) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$RequestGetGroupRecommendations parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsOuterClass$RequestGetGroupRecommendations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsOuterClass$RequestGetGroupRecommendations parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsOuterClass$RequestGetGroupRecommendations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GroupsOuterClass$RequestGetGroupRecommendations parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsOuterClass$RequestGetGroupRecommendations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsOuterClass$RequestGetGroupRecommendations parseFrom(byte[] bArr) {
        return (GroupsOuterClass$RequestGetGroupRecommendations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsOuterClass$RequestGetGroupRecommendations parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsOuterClass$RequestGetGroupRecommendations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsOuterClass$RequestGetGroupRecommendations parseFrom(InputStream inputStream) {
        return (GroupsOuterClass$RequestGetGroupRecommendations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$RequestGetGroupRecommendations parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$RequestGetGroupRecommendations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$RequestGetGroupRecommendations parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsOuterClass$RequestGetGroupRecommendations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsOuterClass$RequestGetGroupRecommendations parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsOuterClass$RequestGetGroupRecommendations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
