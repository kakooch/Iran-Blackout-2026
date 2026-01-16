package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.BytesValue;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MagazineOuterClass$RequestLoadCategoryFeedMessages extends GeneratedMessageLite implements U64 {
    public static final int CATEGORY_ID_FIELD_NUMBER = 1;
    private static final MagazineOuterClass$RequestLoadCategoryFeedMessages DEFAULT_INSTANCE;
    public static final int LOAD_MORE_STATE_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private int categoryId_;
    private BytesValue loadMoreState_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(int i) {
            q();
            ((MagazineOuterClass$RequestLoadCategoryFeedMessages) this.b).setCategoryId(i);
            return this;
        }

        public a B(BytesValue bytesValue) {
            q();
            ((MagazineOuterClass$RequestLoadCategoryFeedMessages) this.b).setLoadMoreState(bytesValue);
            return this;
        }

        private a() {
            super(MagazineOuterClass$RequestLoadCategoryFeedMessages.DEFAULT_INSTANCE);
        }
    }

    static {
        MagazineOuterClass$RequestLoadCategoryFeedMessages magazineOuterClass$RequestLoadCategoryFeedMessages = new MagazineOuterClass$RequestLoadCategoryFeedMessages();
        DEFAULT_INSTANCE = magazineOuterClass$RequestLoadCategoryFeedMessages;
        GeneratedMessageLite.registerDefaultInstance(MagazineOuterClass$RequestLoadCategoryFeedMessages.class, magazineOuterClass$RequestLoadCategoryFeedMessages);
    }

    private MagazineOuterClass$RequestLoadCategoryFeedMessages() {
    }

    private void clearCategoryId() {
        this.categoryId_ = 0;
    }

    private void clearLoadMoreState() {
        this.loadMoreState_ = null;
        this.bitField0_ &= -2;
    }

    public static MagazineOuterClass$RequestLoadCategoryFeedMessages getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeLoadMoreState(BytesValue bytesValue) {
        bytesValue.getClass();
        BytesValue bytesValue2 = this.loadMoreState_;
        if (bytesValue2 == null || bytesValue2 == BytesValue.getDefaultInstance()) {
            this.loadMoreState_ = bytesValue;
        } else {
            this.loadMoreState_ = (BytesValue) ((BytesValue.b) BytesValue.newBuilder(this.loadMoreState_).v(bytesValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MagazineOuterClass$RequestLoadCategoryFeedMessages parseDelimitedFrom(InputStream inputStream) {
        return (MagazineOuterClass$RequestLoadCategoryFeedMessages) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MagazineOuterClass$RequestLoadCategoryFeedMessages parseFrom(ByteBuffer byteBuffer) {
        return (MagazineOuterClass$RequestLoadCategoryFeedMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCategoryId(int i) {
        this.categoryId_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadMoreState(BytesValue bytesValue) {
        bytesValue.getClass();
        this.loadMoreState_ = bytesValue;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (A0.a[gVar.ordinal()]) {
            case 1:
                return new MagazineOuterClass$RequestLoadCategoryFeedMessages();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002ဉ\u0000", new Object[]{"bitField0_", "categoryId_", "loadMoreState_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MagazineOuterClass$RequestLoadCategoryFeedMessages.class) {
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

    public int getCategoryId() {
        return this.categoryId_;
    }

    public BytesValue getLoadMoreState() {
        BytesValue bytesValue = this.loadMoreState_;
        return bytesValue == null ? BytesValue.getDefaultInstance() : bytesValue;
    }

    public boolean hasLoadMoreState() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MagazineOuterClass$RequestLoadCategoryFeedMessages magazineOuterClass$RequestLoadCategoryFeedMessages) {
        return (a) DEFAULT_INSTANCE.createBuilder(magazineOuterClass$RequestLoadCategoryFeedMessages);
    }

    public static MagazineOuterClass$RequestLoadCategoryFeedMessages parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MagazineOuterClass$RequestLoadCategoryFeedMessages) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MagazineOuterClass$RequestLoadCategoryFeedMessages parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MagazineOuterClass$RequestLoadCategoryFeedMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MagazineOuterClass$RequestLoadCategoryFeedMessages parseFrom(AbstractC2383g abstractC2383g) {
        return (MagazineOuterClass$RequestLoadCategoryFeedMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MagazineOuterClass$RequestLoadCategoryFeedMessages parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MagazineOuterClass$RequestLoadCategoryFeedMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MagazineOuterClass$RequestLoadCategoryFeedMessages parseFrom(byte[] bArr) {
        return (MagazineOuterClass$RequestLoadCategoryFeedMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MagazineOuterClass$RequestLoadCategoryFeedMessages parseFrom(byte[] bArr, C2394s c2394s) {
        return (MagazineOuterClass$RequestLoadCategoryFeedMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MagazineOuterClass$RequestLoadCategoryFeedMessages parseFrom(InputStream inputStream) {
        return (MagazineOuterClass$RequestLoadCategoryFeedMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MagazineOuterClass$RequestLoadCategoryFeedMessages parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MagazineOuterClass$RequestLoadCategoryFeedMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MagazineOuterClass$RequestLoadCategoryFeedMessages parseFrom(AbstractC2384h abstractC2384h) {
        return (MagazineOuterClass$RequestLoadCategoryFeedMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MagazineOuterClass$RequestLoadCategoryFeedMessages parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MagazineOuterClass$RequestLoadCategoryFeedMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
