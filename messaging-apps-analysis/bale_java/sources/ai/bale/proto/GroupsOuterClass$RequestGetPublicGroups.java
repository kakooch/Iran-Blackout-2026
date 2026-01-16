package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class GroupsOuterClass$RequestGetPublicGroups extends GeneratedMessageLite implements U64 {
    private static final GroupsOuterClass$RequestGetPublicGroups DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GroupsOuterClass$RequestGetPublicGroups.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsOuterClass$RequestGetPublicGroups groupsOuterClass$RequestGetPublicGroups = new GroupsOuterClass$RequestGetPublicGroups();
        DEFAULT_INSTANCE = groupsOuterClass$RequestGetPublicGroups;
        GeneratedMessageLite.registerDefaultInstance(GroupsOuterClass$RequestGetPublicGroups.class, groupsOuterClass$RequestGetPublicGroups);
    }

    private GroupsOuterClass$RequestGetPublicGroups() {
    }

    public static GroupsOuterClass$RequestGetPublicGroups getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsOuterClass$RequestGetPublicGroups parseDelimitedFrom(InputStream inputStream) {
        return (GroupsOuterClass$RequestGetPublicGroups) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$RequestGetPublicGroups parseFrom(ByteBuffer byteBuffer) {
        return (GroupsOuterClass$RequestGetPublicGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1874m0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsOuterClass$RequestGetPublicGroups();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsOuterClass$RequestGetPublicGroups.class) {
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

    public static a newBuilder(GroupsOuterClass$RequestGetPublicGroups groupsOuterClass$RequestGetPublicGroups) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsOuterClass$RequestGetPublicGroups);
    }

    public static GroupsOuterClass$RequestGetPublicGroups parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$RequestGetPublicGroups) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$RequestGetPublicGroups parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsOuterClass$RequestGetPublicGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsOuterClass$RequestGetPublicGroups parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsOuterClass$RequestGetPublicGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GroupsOuterClass$RequestGetPublicGroups parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsOuterClass$RequestGetPublicGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsOuterClass$RequestGetPublicGroups parseFrom(byte[] bArr) {
        return (GroupsOuterClass$RequestGetPublicGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsOuterClass$RequestGetPublicGroups parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsOuterClass$RequestGetPublicGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsOuterClass$RequestGetPublicGroups parseFrom(InputStream inputStream) {
        return (GroupsOuterClass$RequestGetPublicGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$RequestGetPublicGroups parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$RequestGetPublicGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$RequestGetPublicGroups parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsOuterClass$RequestGetPublicGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsOuterClass$RequestGetPublicGroups parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsOuterClass$RequestGetPublicGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
