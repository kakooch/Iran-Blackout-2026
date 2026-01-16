package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.GS2;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class GroupsStruct$FilterRestriction extends GeneratedMessageLite implements U64 {
    private static final GroupsStruct$FilterRestriction DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int RESTRICTION_FIELD_NUMBER = 1;
    private int restriction_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GroupsStruct$FilterRestriction.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsStruct$FilterRestriction groupsStruct$FilterRestriction = new GroupsStruct$FilterRestriction();
        DEFAULT_INSTANCE = groupsStruct$FilterRestriction;
        GeneratedMessageLite.registerDefaultInstance(GroupsStruct$FilterRestriction.class, groupsStruct$FilterRestriction);
    }

    private GroupsStruct$FilterRestriction() {
    }

    private void clearRestriction() {
        this.restriction_ = 0;
    }

    public static GroupsStruct$FilterRestriction getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsStruct$FilterRestriction parseDelimitedFrom(InputStream inputStream) {
        return (GroupsStruct$FilterRestriction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsStruct$FilterRestriction parseFrom(ByteBuffer byteBuffer) {
        return (GroupsStruct$FilterRestriction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setRestriction(GS2 gs2) {
        this.restriction_ = gs2.getNumber();
    }

    private void setRestrictionValue(int i) {
        this.restriction_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1877n0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsStruct$FilterRestriction();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"restriction_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsStruct$FilterRestriction.class) {
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

    public GS2 getRestriction() {
        GS2 gs2J = GS2.j(this.restriction_);
        return gs2J == null ? GS2.UNRECOGNIZED : gs2J;
    }

    public int getRestrictionValue() {
        return this.restriction_;
    }

    public static a newBuilder(GroupsStruct$FilterRestriction groupsStruct$FilterRestriction) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsStruct$FilterRestriction);
    }

    public static GroupsStruct$FilterRestriction parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsStruct$FilterRestriction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsStruct$FilterRestriction parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsStruct$FilterRestriction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsStruct$FilterRestriction parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsStruct$FilterRestriction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GroupsStruct$FilterRestriction parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsStruct$FilterRestriction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsStruct$FilterRestriction parseFrom(byte[] bArr) {
        return (GroupsStruct$FilterRestriction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsStruct$FilterRestriction parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsStruct$FilterRestriction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsStruct$FilterRestriction parseFrom(InputStream inputStream) {
        return (GroupsStruct$FilterRestriction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsStruct$FilterRestriction parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsStruct$FilterRestriction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsStruct$FilterRestriction parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsStruct$FilterRestriction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsStruct$FilterRestriction parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsStruct$FilterRestriction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
