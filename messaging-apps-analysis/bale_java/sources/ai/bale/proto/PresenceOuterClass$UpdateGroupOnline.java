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
public final class PresenceOuterClass$UpdateGroupOnline extends GeneratedMessageLite implements U64 {
    public static final int COUNT_FIELD_NUMBER = 2;
    private static final PresenceOuterClass$UpdateGroupOnline DEFAULT_INSTANCE;
    public static final int GROUP_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int count_;
    private int groupId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PresenceOuterClass$UpdateGroupOnline.DEFAULT_INSTANCE);
        }
    }

    static {
        PresenceOuterClass$UpdateGroupOnline presenceOuterClass$UpdateGroupOnline = new PresenceOuterClass$UpdateGroupOnline();
        DEFAULT_INSTANCE = presenceOuterClass$UpdateGroupOnline;
        GeneratedMessageLite.registerDefaultInstance(PresenceOuterClass$UpdateGroupOnline.class, presenceOuterClass$UpdateGroupOnline);
    }

    private PresenceOuterClass$UpdateGroupOnline() {
    }

    private void clearCount() {
        this.count_ = 0;
    }

    private void clearGroupId() {
        this.groupId_ = 0;
    }

    public static PresenceOuterClass$UpdateGroupOnline getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PresenceOuterClass$UpdateGroupOnline parseDelimitedFrom(InputStream inputStream) {
        return (PresenceOuterClass$UpdateGroupOnline) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PresenceOuterClass$UpdateGroupOnline parseFrom(ByteBuffer byteBuffer) {
        return (PresenceOuterClass$UpdateGroupOnline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCount(int i) {
        this.count_ = i;
    }

    private void setGroupId(int i) {
        this.groupId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1866j1.a[gVar.ordinal()]) {
            case 1:
                return new PresenceOuterClass$UpdateGroupOnline();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002\u0004", new Object[]{"groupId_", "count_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PresenceOuterClass$UpdateGroupOnline.class) {
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

    public int getCount() {
        return this.count_;
    }

    public int getGroupId() {
        return this.groupId_;
    }

    public static a newBuilder(PresenceOuterClass$UpdateGroupOnline presenceOuterClass$UpdateGroupOnline) {
        return (a) DEFAULT_INSTANCE.createBuilder(presenceOuterClass$UpdateGroupOnline);
    }

    public static PresenceOuterClass$UpdateGroupOnline parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PresenceOuterClass$UpdateGroupOnline) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PresenceOuterClass$UpdateGroupOnline parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PresenceOuterClass$UpdateGroupOnline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PresenceOuterClass$UpdateGroupOnline parseFrom(AbstractC2383g abstractC2383g) {
        return (PresenceOuterClass$UpdateGroupOnline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PresenceOuterClass$UpdateGroupOnline parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PresenceOuterClass$UpdateGroupOnline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PresenceOuterClass$UpdateGroupOnline parseFrom(byte[] bArr) {
        return (PresenceOuterClass$UpdateGroupOnline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PresenceOuterClass$UpdateGroupOnline parseFrom(byte[] bArr, C2394s c2394s) {
        return (PresenceOuterClass$UpdateGroupOnline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PresenceOuterClass$UpdateGroupOnline parseFrom(InputStream inputStream) {
        return (PresenceOuterClass$UpdateGroupOnline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PresenceOuterClass$UpdateGroupOnline parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PresenceOuterClass$UpdateGroupOnline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PresenceOuterClass$UpdateGroupOnline parseFrom(AbstractC2384h abstractC2384h) {
        return (PresenceOuterClass$UpdateGroupOnline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PresenceOuterClass$UpdateGroupOnline parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PresenceOuterClass$UpdateGroupOnline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
