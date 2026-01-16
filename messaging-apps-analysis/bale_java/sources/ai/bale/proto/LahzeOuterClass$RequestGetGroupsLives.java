package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class LahzeOuterClass$RequestGetGroupsLives extends GeneratedMessageLite implements U64 {
    private static final LahzeOuterClass$RequestGetGroupsLives DEFAULT_INSTANCE;
    public static final int GROUP_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int groupIdMemoizedSerializedSize = -1;
    private B.g groupId_ = GeneratedMessageLite.emptyIntList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(Iterable iterable) {
            q();
            ((LahzeOuterClass$RequestGetGroupsLives) this.b).addAllGroupId(iterable);
            return this;
        }

        private a() {
            super(LahzeOuterClass$RequestGetGroupsLives.DEFAULT_INSTANCE);
        }
    }

    static {
        LahzeOuterClass$RequestGetGroupsLives lahzeOuterClass$RequestGetGroupsLives = new LahzeOuterClass$RequestGetGroupsLives();
        DEFAULT_INSTANCE = lahzeOuterClass$RequestGetGroupsLives;
        GeneratedMessageLite.registerDefaultInstance(LahzeOuterClass$RequestGetGroupsLives.class, lahzeOuterClass$RequestGetGroupsLives);
    }

    private LahzeOuterClass$RequestGetGroupsLives() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllGroupId(Iterable<? extends Integer> iterable) {
        ensureGroupIdIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.groupId_);
    }

    private void addGroupId(int i) {
        ensureGroupIdIsMutable();
        this.groupId_.b1(i);
    }

    private void clearGroupId() {
        this.groupId_ = GeneratedMessageLite.emptyIntList();
    }

    private void ensureGroupIdIsMutable() {
        B.g gVar = this.groupId_;
        if (gVar.u()) {
            return;
        }
        this.groupId_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    public static LahzeOuterClass$RequestGetGroupsLives getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LahzeOuterClass$RequestGetGroupsLives parseDelimitedFrom(InputStream inputStream) {
        return (LahzeOuterClass$RequestGetGroupsLives) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LahzeOuterClass$RequestGetGroupsLives parseFrom(ByteBuffer byteBuffer) {
        return (LahzeOuterClass$RequestGetGroupsLives) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setGroupId(int i, int i2) {
        ensureGroupIdIsMutable();
        this.groupId_.U(i, i2);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1903w0.a[gVar.ordinal()]) {
            case 1:
                return new LahzeOuterClass$RequestGetGroupsLives();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001'", new Object[]{"groupId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LahzeOuterClass$RequestGetGroupsLives.class) {
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

    public int getGroupId(int i) {
        return this.groupId_.getInt(i);
    }

    public int getGroupIdCount() {
        return this.groupId_.size();
    }

    public List<Integer> getGroupIdList() {
        return this.groupId_;
    }

    public static a newBuilder(LahzeOuterClass$RequestGetGroupsLives lahzeOuterClass$RequestGetGroupsLives) {
        return (a) DEFAULT_INSTANCE.createBuilder(lahzeOuterClass$RequestGetGroupsLives);
    }

    public static LahzeOuterClass$RequestGetGroupsLives parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LahzeOuterClass$RequestGetGroupsLives) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LahzeOuterClass$RequestGetGroupsLives parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LahzeOuterClass$RequestGetGroupsLives) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LahzeOuterClass$RequestGetGroupsLives parseFrom(AbstractC2383g abstractC2383g) {
        return (LahzeOuterClass$RequestGetGroupsLives) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LahzeOuterClass$RequestGetGroupsLives parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LahzeOuterClass$RequestGetGroupsLives) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LahzeOuterClass$RequestGetGroupsLives parseFrom(byte[] bArr) {
        return (LahzeOuterClass$RequestGetGroupsLives) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LahzeOuterClass$RequestGetGroupsLives parseFrom(byte[] bArr, C2394s c2394s) {
        return (LahzeOuterClass$RequestGetGroupsLives) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LahzeOuterClass$RequestGetGroupsLives parseFrom(InputStream inputStream) {
        return (LahzeOuterClass$RequestGetGroupsLives) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LahzeOuterClass$RequestGetGroupsLives parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LahzeOuterClass$RequestGetGroupsLives) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LahzeOuterClass$RequestGetGroupsLives parseFrom(AbstractC2384h abstractC2384h) {
        return (LahzeOuterClass$RequestGetGroupsLives) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LahzeOuterClass$RequestGetGroupsLives parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LahzeOuterClass$RequestGetGroupsLives) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
