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
public final class MavizStreamOuterClass$SerializedUpdate extends GeneratedMessageLite implements U64 {
    public static final int BODY_FIELD_NUMBER = 2;
    private static final MavizStreamOuterClass$SerializedUpdate DEFAULT_INSTANCE;
    public static final int GROUP_IDS_FIELD_NUMBER = 4;
    public static final int HEADER_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int USER_IDS_FIELD_NUMBER = 3;
    private int header_;
    private int userIdsMemoizedSerializedSize = -1;
    private int groupIdsMemoizedSerializedSize = -1;
    private AbstractC2383g body_ = AbstractC2383g.b;
    private B.g userIds_ = GeneratedMessageLite.emptyIntList();
    private B.g groupIds_ = GeneratedMessageLite.emptyIntList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MavizStreamOuterClass$SerializedUpdate.DEFAULT_INSTANCE);
        }
    }

    static {
        MavizStreamOuterClass$SerializedUpdate mavizStreamOuterClass$SerializedUpdate = new MavizStreamOuterClass$SerializedUpdate();
        DEFAULT_INSTANCE = mavizStreamOuterClass$SerializedUpdate;
        GeneratedMessageLite.registerDefaultInstance(MavizStreamOuterClass$SerializedUpdate.class, mavizStreamOuterClass$SerializedUpdate);
    }

    private MavizStreamOuterClass$SerializedUpdate() {
    }

    private void addAllGroupIds(Iterable<? extends Integer> iterable) {
        ensureGroupIdsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.groupIds_);
    }

    private void addAllUserIds(Iterable<? extends Integer> iterable) {
        ensureUserIdsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.userIds_);
    }

    private void addGroupIds(int i) {
        ensureGroupIdsIsMutable();
        this.groupIds_.b1(i);
    }

    private void addUserIds(int i) {
        ensureUserIdsIsMutable();
        this.userIds_.b1(i);
    }

    private void clearBody() {
        this.body_ = getDefaultInstance().getBody();
    }

    private void clearGroupIds() {
        this.groupIds_ = GeneratedMessageLite.emptyIntList();
    }

    private void clearHeader() {
        this.header_ = 0;
    }

    private void clearUserIds() {
        this.userIds_ = GeneratedMessageLite.emptyIntList();
    }

    private void ensureGroupIdsIsMutable() {
        B.g gVar = this.groupIds_;
        if (gVar.u()) {
            return;
        }
        this.groupIds_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    private void ensureUserIdsIsMutable() {
        B.g gVar = this.userIds_;
        if (gVar.u()) {
            return;
        }
        this.userIds_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    public static MavizStreamOuterClass$SerializedUpdate getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MavizStreamOuterClass$SerializedUpdate parseDelimitedFrom(InputStream inputStream) {
        return (MavizStreamOuterClass$SerializedUpdate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MavizStreamOuterClass$SerializedUpdate parseFrom(ByteBuffer byteBuffer) {
        return (MavizStreamOuterClass$SerializedUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBody(AbstractC2383g abstractC2383g) {
        abstractC2383g.getClass();
        this.body_ = abstractC2383g;
    }

    private void setGroupIds(int i, int i2) {
        ensureGroupIdsIsMutable();
        this.groupIds_.U(i, i2);
    }

    private void setHeader(int i) {
        this.header_ = i;
    }

    private void setUserIds(int i, int i2) {
        ensureUserIdsIsMutable();
        this.userIds_.U(i, i2);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (E0.a[gVar.ordinal()]) {
            case 1:
                return new MavizStreamOuterClass$SerializedUpdate();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0002\u0000\u0001\u0004\u0002\n\u0003'\u0004'", new Object[]{"header_", "body_", "userIds_", "groupIds_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MavizStreamOuterClass$SerializedUpdate.class) {
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

    public AbstractC2383g getBody() {
        return this.body_;
    }

    public int getGroupIds(int i) {
        return this.groupIds_.getInt(i);
    }

    public int getGroupIdsCount() {
        return this.groupIds_.size();
    }

    public List<Integer> getGroupIdsList() {
        return this.groupIds_;
    }

    public int getHeader() {
        return this.header_;
    }

    public int getUserIds(int i) {
        return this.userIds_.getInt(i);
    }

    public int getUserIdsCount() {
        return this.userIds_.size();
    }

    public List<Integer> getUserIdsList() {
        return this.userIds_;
    }

    public static a newBuilder(MavizStreamOuterClass$SerializedUpdate mavizStreamOuterClass$SerializedUpdate) {
        return (a) DEFAULT_INSTANCE.createBuilder(mavizStreamOuterClass$SerializedUpdate);
    }

    public static MavizStreamOuterClass$SerializedUpdate parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MavizStreamOuterClass$SerializedUpdate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MavizStreamOuterClass$SerializedUpdate parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MavizStreamOuterClass$SerializedUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MavizStreamOuterClass$SerializedUpdate parseFrom(AbstractC2383g abstractC2383g) {
        return (MavizStreamOuterClass$SerializedUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MavizStreamOuterClass$SerializedUpdate parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MavizStreamOuterClass$SerializedUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MavizStreamOuterClass$SerializedUpdate parseFrom(byte[] bArr) {
        return (MavizStreamOuterClass$SerializedUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MavizStreamOuterClass$SerializedUpdate parseFrom(byte[] bArr, C2394s c2394s) {
        return (MavizStreamOuterClass$SerializedUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MavizStreamOuterClass$SerializedUpdate parseFrom(InputStream inputStream) {
        return (MavizStreamOuterClass$SerializedUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MavizStreamOuterClass$SerializedUpdate parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MavizStreamOuterClass$SerializedUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MavizStreamOuterClass$SerializedUpdate parseFrom(AbstractC2384h abstractC2384h) {
        return (MavizStreamOuterClass$SerializedUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MavizStreamOuterClass$SerializedUpdate parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MavizStreamOuterClass$SerializedUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
