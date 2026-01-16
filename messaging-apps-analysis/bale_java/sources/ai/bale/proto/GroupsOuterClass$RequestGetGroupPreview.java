package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$BooleanValue;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class GroupsOuterClass$RequestGetGroupPreview extends GeneratedMessageLite implements U64 {
    private static final GroupsOuterClass$RequestGetGroupPreview DEFAULT_INSTANCE;
    public static final int IS_OPENED_OUTSIDE_BALE_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int TOKEN_FIELD_NUMBER = 1;
    private int bitField0_;
    private CollectionsStruct$BooleanValue isOpenedOutsideBale_;
    private String token_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(CollectionsStruct$BooleanValue collectionsStruct$BooleanValue) {
            q();
            ((GroupsOuterClass$RequestGetGroupPreview) this.b).setIsOpenedOutsideBale(collectionsStruct$BooleanValue);
            return this;
        }

        public a B(String str) {
            q();
            ((GroupsOuterClass$RequestGetGroupPreview) this.b).setToken(str);
            return this;
        }

        private a() {
            super(GroupsOuterClass$RequestGetGroupPreview.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsOuterClass$RequestGetGroupPreview groupsOuterClass$RequestGetGroupPreview = new GroupsOuterClass$RequestGetGroupPreview();
        DEFAULT_INSTANCE = groupsOuterClass$RequestGetGroupPreview;
        GeneratedMessageLite.registerDefaultInstance(GroupsOuterClass$RequestGetGroupPreview.class, groupsOuterClass$RequestGetGroupPreview);
    }

    private GroupsOuterClass$RequestGetGroupPreview() {
    }

    private void clearIsOpenedOutsideBale() {
        this.isOpenedOutsideBale_ = null;
        this.bitField0_ &= -2;
    }

    private void clearToken() {
        this.token_ = getDefaultInstance().getToken();
    }

    public static GroupsOuterClass$RequestGetGroupPreview getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeIsOpenedOutsideBale(CollectionsStruct$BooleanValue collectionsStruct$BooleanValue) {
        collectionsStruct$BooleanValue.getClass();
        CollectionsStruct$BooleanValue collectionsStruct$BooleanValue2 = this.isOpenedOutsideBale_;
        if (collectionsStruct$BooleanValue2 == null || collectionsStruct$BooleanValue2 == CollectionsStruct$BooleanValue.getDefaultInstance()) {
            this.isOpenedOutsideBale_ = collectionsStruct$BooleanValue;
        } else {
            this.isOpenedOutsideBale_ = (CollectionsStruct$BooleanValue) ((CollectionsStruct$BooleanValue.a) CollectionsStruct$BooleanValue.newBuilder(this.isOpenedOutsideBale_).v(collectionsStruct$BooleanValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsOuterClass$RequestGetGroupPreview parseDelimitedFrom(InputStream inputStream) {
        return (GroupsOuterClass$RequestGetGroupPreview) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$RequestGetGroupPreview parseFrom(ByteBuffer byteBuffer) {
        return (GroupsOuterClass$RequestGetGroupPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIsOpenedOutsideBale(CollectionsStruct$BooleanValue collectionsStruct$BooleanValue) {
        collectionsStruct$BooleanValue.getClass();
        this.isOpenedOutsideBale_ = collectionsStruct$BooleanValue;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setToken(String str) {
        str.getClass();
        this.token_ = str;
    }

    private void setTokenBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.token_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1874m0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsOuterClass$RequestGetGroupPreview();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000", new Object[]{"bitField0_", "token_", "isOpenedOutsideBale_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsOuterClass$RequestGetGroupPreview.class) {
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

    public CollectionsStruct$BooleanValue getIsOpenedOutsideBale() {
        CollectionsStruct$BooleanValue collectionsStruct$BooleanValue = this.isOpenedOutsideBale_;
        return collectionsStruct$BooleanValue == null ? CollectionsStruct$BooleanValue.getDefaultInstance() : collectionsStruct$BooleanValue;
    }

    public String getToken() {
        return this.token_;
    }

    public AbstractC2383g getTokenBytes() {
        return AbstractC2383g.N(this.token_);
    }

    public boolean hasIsOpenedOutsideBale() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(GroupsOuterClass$RequestGetGroupPreview groupsOuterClass$RequestGetGroupPreview) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsOuterClass$RequestGetGroupPreview);
    }

    public static GroupsOuterClass$RequestGetGroupPreview parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$RequestGetGroupPreview) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$RequestGetGroupPreview parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsOuterClass$RequestGetGroupPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsOuterClass$RequestGetGroupPreview parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsOuterClass$RequestGetGroupPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GroupsOuterClass$RequestGetGroupPreview parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsOuterClass$RequestGetGroupPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsOuterClass$RequestGetGroupPreview parseFrom(byte[] bArr) {
        return (GroupsOuterClass$RequestGetGroupPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsOuterClass$RequestGetGroupPreview parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsOuterClass$RequestGetGroupPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsOuterClass$RequestGetGroupPreview parseFrom(InputStream inputStream) {
        return (GroupsOuterClass$RequestGetGroupPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$RequestGetGroupPreview parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$RequestGetGroupPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$RequestGetGroupPreview parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsOuterClass$RequestGetGroupPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsOuterClass$RequestGetGroupPreview parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsOuterClass$RequestGetGroupPreview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
