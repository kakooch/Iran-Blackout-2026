package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int64Value;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.r0;
import ir.nasim.InterfaceC15452jc4;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes9.dex */
public final class MessagingStruct$MessageReaction extends GeneratedMessageLite implements InterfaceC15452jc4 {
    public static final int CARDINALITY_FIELD_NUMBER = 3;
    public static final int CODE_FIELD_NUMBER = 2;
    private static final MessagingStruct$MessageReaction DEFAULT_INSTANCE;
    public static final int EXT_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int USERS_FIELD_NUMBER = 1;
    private int bitField0_;
    private CollectionsStruct$Int64Value cardinality_;
    private int usersMemoizedSerializedSize = -1;
    private com.google.protobuf.J ext_ = com.google.protobuf.J.e();
    private B.g users_ = GeneratedMessageLite.emptyIntList();
    private String code_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC15452jc4 {
        private a() {
            super(MessagingStruct$MessageReaction.DEFAULT_INSTANCE);
        }
    }

    private static final class b {
        static final com.google.protobuf.I a = com.google.protobuf.I.d(r0.b.k, "", r0.b.m, CollectionsStruct$RawValue.getDefaultInstance());
    }

    static {
        MessagingStruct$MessageReaction messagingStruct$MessageReaction = new MessagingStruct$MessageReaction();
        DEFAULT_INSTANCE = messagingStruct$MessageReaction;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$MessageReaction.class, messagingStruct$MessageReaction);
    }

    private MessagingStruct$MessageReaction() {
    }

    private void addAllUsers(Iterable<? extends Integer> iterable) {
        ensureUsersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.users_);
    }

    private void addUsers(int i) {
        ensureUsersIsMutable();
        this.users_.b1(i);
    }

    private void clearCardinality() {
        this.cardinality_ = null;
        this.bitField0_ &= -2;
    }

    private void clearCode() {
        this.code_ = getDefaultInstance().getCode();
    }

    private void clearUsers() {
        this.users_ = GeneratedMessageLite.emptyIntList();
    }

    private void ensureUsersIsMutable() {
        B.g gVar = this.users_;
        if (gVar.u()) {
            return;
        }
        this.users_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    public static MessagingStruct$MessageReaction getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private Map<String, CollectionsStruct$RawValue> getMutableExtMap() {
        return internalGetMutableExt();
    }

    private com.google.protobuf.J internalGetExt() {
        return this.ext_;
    }

    private com.google.protobuf.J internalGetMutableExt() {
        if (!this.ext_.n()) {
            this.ext_ = this.ext_.s();
        }
        return this.ext_;
    }

    private void mergeCardinality(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.cardinality_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.cardinality_ = collectionsStruct$Int64Value;
        } else {
            this.cardinality_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.cardinality_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$MessageReaction parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$MessageReaction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$MessageReaction parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$MessageReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCardinality(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.cardinality_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 1;
    }

    private void setCode(String str) {
        str.getClass();
        this.code_ = str;
    }

    private void setCodeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.code_ = abstractC2383g.f0();
    }

    private void setUsers(int i, int i2) {
        ensureUsersIsMutable();
        this.users_.U(i, i2);
    }

    public boolean containsExt(String str) {
        str.getClass();
        return internalGetExt().containsKey(str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$MessageReaction();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0001\u0001\u0000\u0001'\u0002Ȉ\u0003ဉ\u0000\u00042", new Object[]{"bitField0_", "users_", "code_", "cardinality_", "ext_", b.a});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$MessageReaction.class) {
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

    public CollectionsStruct$Int64Value getCardinality() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.cardinality_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public String getCode() {
        return this.code_;
    }

    public AbstractC2383g getCodeBytes() {
        return AbstractC2383g.N(this.code_);
    }

    @Deprecated
    public Map<String, CollectionsStruct$RawValue> getExt() {
        return getExtMap();
    }

    public int getExtCount() {
        return internalGetExt().size();
    }

    public Map<String, CollectionsStruct$RawValue> getExtMap() {
        return Collections.unmodifiableMap(internalGetExt());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CollectionsStruct$RawValue getExtOrDefault(String str, CollectionsStruct$RawValue collectionsStruct$RawValue) {
        str.getClass();
        com.google.protobuf.J jInternalGetExt = internalGetExt();
        return jInternalGetExt.containsKey(str) ? (CollectionsStruct$RawValue) jInternalGetExt.get(str) : collectionsStruct$RawValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CollectionsStruct$RawValue getExtOrThrow(String str) {
        str.getClass();
        com.google.protobuf.J jInternalGetExt = internalGetExt();
        if (jInternalGetExt.containsKey(str)) {
            return (CollectionsStruct$RawValue) jInternalGetExt.get(str);
        }
        throw new IllegalArgumentException();
    }

    public int getUsers(int i) {
        return this.users_.getInt(i);
    }

    public int getUsersCount() {
        return this.users_.size();
    }

    public List<Integer> getUsersList() {
        return this.users_;
    }

    public boolean hasCardinality() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MessagingStruct$MessageReaction messagingStruct$MessageReaction) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$MessageReaction);
    }

    public static MessagingStruct$MessageReaction parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$MessageReaction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$MessageReaction parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$MessageReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$MessageReaction parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$MessageReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$MessageReaction parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$MessageReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$MessageReaction parseFrom(byte[] bArr) {
        return (MessagingStruct$MessageReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$MessageReaction parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$MessageReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$MessageReaction parseFrom(InputStream inputStream) {
        return (MessagingStruct$MessageReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$MessageReaction parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$MessageReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$MessageReaction parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$MessageReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$MessageReaction parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$MessageReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
