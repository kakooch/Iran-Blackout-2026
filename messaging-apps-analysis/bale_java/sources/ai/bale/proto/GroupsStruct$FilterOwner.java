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
public final class GroupsStruct$FilterOwner extends GeneratedMessageLite implements U64 {
    private static final GroupsStruct$FilterOwner DEFAULT_INSTANCE;
    public static final int IS_OWNER_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private boolean isOwner_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(boolean z) {
            q();
            ((GroupsStruct$FilterOwner) this.b).setIsOwner(z);
            return this;
        }

        private a() {
            super(GroupsStruct$FilterOwner.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsStruct$FilterOwner groupsStruct$FilterOwner = new GroupsStruct$FilterOwner();
        DEFAULT_INSTANCE = groupsStruct$FilterOwner;
        GeneratedMessageLite.registerDefaultInstance(GroupsStruct$FilterOwner.class, groupsStruct$FilterOwner);
    }

    private GroupsStruct$FilterOwner() {
    }

    private void clearIsOwner() {
        this.isOwner_ = false;
    }

    public static GroupsStruct$FilterOwner getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsStruct$FilterOwner parseDelimitedFrom(InputStream inputStream) {
        return (GroupsStruct$FilterOwner) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsStruct$FilterOwner parseFrom(ByteBuffer byteBuffer) {
        return (GroupsStruct$FilterOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIsOwner(boolean z) {
        this.isOwner_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1877n0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsStruct$FilterOwner();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0007", new Object[]{"isOwner_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsStruct$FilterOwner.class) {
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

    public boolean getIsOwner() {
        return this.isOwner_;
    }

    public static a newBuilder(GroupsStruct$FilterOwner groupsStruct$FilterOwner) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsStruct$FilterOwner);
    }

    public static GroupsStruct$FilterOwner parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsStruct$FilterOwner) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsStruct$FilterOwner parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsStruct$FilterOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsStruct$FilterOwner parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsStruct$FilterOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GroupsStruct$FilterOwner parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsStruct$FilterOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsStruct$FilterOwner parseFrom(byte[] bArr) {
        return (GroupsStruct$FilterOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsStruct$FilterOwner parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsStruct$FilterOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsStruct$FilterOwner parseFrom(InputStream inputStream) {
        return (GroupsStruct$FilterOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsStruct$FilterOwner parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsStruct$FilterOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsStruct$FilterOwner parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsStruct$FilterOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsStruct$FilterOwner parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsStruct$FilterOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
