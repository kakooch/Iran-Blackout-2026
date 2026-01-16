package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int64Value;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class UsersOuterClass$RequestRemoveAvatar extends GeneratedMessageLite implements U64 {
    public static final int AVATER_ID_FIELD_NUMBER = 1;
    private static final UsersOuterClass$RequestRemoveAvatar DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private CollectionsStruct$Int64Value avaterId_;
    private int bitField0_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
            q();
            ((UsersOuterClass$RequestRemoveAvatar) this.b).setAvaterId(collectionsStruct$Int64Value);
            return this;
        }

        private a() {
            super(UsersOuterClass$RequestRemoveAvatar.DEFAULT_INSTANCE);
        }
    }

    static {
        UsersOuterClass$RequestRemoveAvatar usersOuterClass$RequestRemoveAvatar = new UsersOuterClass$RequestRemoveAvatar();
        DEFAULT_INSTANCE = usersOuterClass$RequestRemoveAvatar;
        GeneratedMessageLite.registerDefaultInstance(UsersOuterClass$RequestRemoveAvatar.class, usersOuterClass$RequestRemoveAvatar);
    }

    private UsersOuterClass$RequestRemoveAvatar() {
    }

    private void clearAvaterId() {
        this.avaterId_ = null;
        this.bitField0_ &= -2;
    }

    public static UsersOuterClass$RequestRemoveAvatar getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAvaterId(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.avaterId_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.avaterId_ = collectionsStruct$Int64Value;
        } else {
            this.avaterId_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.avaterId_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static UsersOuterClass$RequestRemoveAvatar parseDelimitedFrom(InputStream inputStream) {
        return (UsersOuterClass$RequestRemoveAvatar) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$RequestRemoveAvatar parseFrom(ByteBuffer byteBuffer) {
        return (UsersOuterClass$RequestRemoveAvatar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAvaterId(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.avaterId_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (p2.a[gVar.ordinal()]) {
            case 1:
                return new UsersOuterClass$RequestRemoveAvatar();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "avaterId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UsersOuterClass$RequestRemoveAvatar.class) {
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

    public CollectionsStruct$Int64Value getAvaterId() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.avaterId_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public boolean hasAvaterId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(UsersOuterClass$RequestRemoveAvatar usersOuterClass$RequestRemoveAvatar) {
        return (a) DEFAULT_INSTANCE.createBuilder(usersOuterClass$RequestRemoveAvatar);
    }

    public static UsersOuterClass$RequestRemoveAvatar parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$RequestRemoveAvatar) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$RequestRemoveAvatar parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UsersOuterClass$RequestRemoveAvatar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UsersOuterClass$RequestRemoveAvatar parseFrom(AbstractC2383g abstractC2383g) {
        return (UsersOuterClass$RequestRemoveAvatar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static UsersOuterClass$RequestRemoveAvatar parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UsersOuterClass$RequestRemoveAvatar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UsersOuterClass$RequestRemoveAvatar parseFrom(byte[] bArr) {
        return (UsersOuterClass$RequestRemoveAvatar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UsersOuterClass$RequestRemoveAvatar parseFrom(byte[] bArr, C2394s c2394s) {
        return (UsersOuterClass$RequestRemoveAvatar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UsersOuterClass$RequestRemoveAvatar parseFrom(InputStream inputStream) {
        return (UsersOuterClass$RequestRemoveAvatar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$RequestRemoveAvatar parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$RequestRemoveAvatar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$RequestRemoveAvatar parseFrom(AbstractC2384h abstractC2384h) {
        return (UsersOuterClass$RequestRemoveAvatar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UsersOuterClass$RequestRemoveAvatar parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UsersOuterClass$RequestRemoveAvatar) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
