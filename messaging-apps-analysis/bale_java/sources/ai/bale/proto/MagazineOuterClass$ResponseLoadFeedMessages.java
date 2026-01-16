package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.BytesValue;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.BM3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MagazineOuterClass$ResponseLoadFeedMessages extends GeneratedMessageLite implements U64 {
    private static final MagazineOuterClass$ResponseLoadFeedMessages DEFAULT_INSTANCE;
    public static final int LOAD_MORE_STATE_FIELD_NUMBER = 2;
    public static final int MESSAGES_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private BytesValue loadMoreState_;
    private B.j messages_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MagazineOuterClass$ResponseLoadFeedMessages.DEFAULT_INSTANCE);
        }
    }

    static {
        MagazineOuterClass$ResponseLoadFeedMessages magazineOuterClass$ResponseLoadFeedMessages = new MagazineOuterClass$ResponseLoadFeedMessages();
        DEFAULT_INSTANCE = magazineOuterClass$ResponseLoadFeedMessages;
        GeneratedMessageLite.registerDefaultInstance(MagazineOuterClass$ResponseLoadFeedMessages.class, magazineOuterClass$ResponseLoadFeedMessages);
    }

    private MagazineOuterClass$ResponseLoadFeedMessages() {
    }

    private void addAllMessages(Iterable<? extends MagazineStruct$FeedMessageContainer> iterable) {
        ensureMessagesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.messages_);
    }

    private void addMessages(MagazineStruct$FeedMessageContainer magazineStruct$FeedMessageContainer) {
        magazineStruct$FeedMessageContainer.getClass();
        ensureMessagesIsMutable();
        this.messages_.add(magazineStruct$FeedMessageContainer);
    }

    private void clearLoadMoreState() {
        this.loadMoreState_ = null;
        this.bitField0_ &= -2;
    }

    private void clearMessages() {
        this.messages_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureMessagesIsMutable() {
        B.j jVar = this.messages_;
        if (jVar.u()) {
            return;
        }
        this.messages_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MagazineOuterClass$ResponseLoadFeedMessages getDefaultInstance() {
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

    public static MagazineOuterClass$ResponseLoadFeedMessages parseDelimitedFrom(InputStream inputStream) {
        return (MagazineOuterClass$ResponseLoadFeedMessages) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MagazineOuterClass$ResponseLoadFeedMessages parseFrom(ByteBuffer byteBuffer) {
        return (MagazineOuterClass$ResponseLoadFeedMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeMessages(int i) {
        ensureMessagesIsMutable();
        this.messages_.remove(i);
    }

    private void setLoadMoreState(BytesValue bytesValue) {
        bytesValue.getClass();
        this.loadMoreState_ = bytesValue;
        this.bitField0_ |= 1;
    }

    private void setMessages(int i, MagazineStruct$FeedMessageContainer magazineStruct$FeedMessageContainer) {
        magazineStruct$FeedMessageContainer.getClass();
        ensureMessagesIsMutable();
        this.messages_.set(i, magazineStruct$FeedMessageContainer);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (A0.a[gVar.ordinal()]) {
            case 1:
                return new MagazineOuterClass$ResponseLoadFeedMessages();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0002\u0003\u0002\u0000\u0001\u0000\u0002ဉ\u0000\u0003\u001b", new Object[]{"bitField0_", "loadMoreState_", "messages_", MagazineStruct$FeedMessageContainer.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MagazineOuterClass$ResponseLoadFeedMessages.class) {
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

    public BytesValue getLoadMoreState() {
        BytesValue bytesValue = this.loadMoreState_;
        return bytesValue == null ? BytesValue.getDefaultInstance() : bytesValue;
    }

    public MagazineStruct$FeedMessageContainer getMessages(int i) {
        return (MagazineStruct$FeedMessageContainer) this.messages_.get(i);
    }

    public int getMessagesCount() {
        return this.messages_.size();
    }

    public List<MagazineStruct$FeedMessageContainer> getMessagesList() {
        return this.messages_;
    }

    public BM3 getMessagesOrBuilder(int i) {
        return (BM3) this.messages_.get(i);
    }

    public List<? extends BM3> getMessagesOrBuilderList() {
        return this.messages_;
    }

    public boolean hasLoadMoreState() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MagazineOuterClass$ResponseLoadFeedMessages magazineOuterClass$ResponseLoadFeedMessages) {
        return (a) DEFAULT_INSTANCE.createBuilder(magazineOuterClass$ResponseLoadFeedMessages);
    }

    public static MagazineOuterClass$ResponseLoadFeedMessages parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MagazineOuterClass$ResponseLoadFeedMessages) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MagazineOuterClass$ResponseLoadFeedMessages parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MagazineOuterClass$ResponseLoadFeedMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MagazineOuterClass$ResponseLoadFeedMessages parseFrom(AbstractC2383g abstractC2383g) {
        return (MagazineOuterClass$ResponseLoadFeedMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addMessages(int i, MagazineStruct$FeedMessageContainer magazineStruct$FeedMessageContainer) {
        magazineStruct$FeedMessageContainer.getClass();
        ensureMessagesIsMutable();
        this.messages_.add(i, magazineStruct$FeedMessageContainer);
    }

    public static MagazineOuterClass$ResponseLoadFeedMessages parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MagazineOuterClass$ResponseLoadFeedMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MagazineOuterClass$ResponseLoadFeedMessages parseFrom(byte[] bArr) {
        return (MagazineOuterClass$ResponseLoadFeedMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MagazineOuterClass$ResponseLoadFeedMessages parseFrom(byte[] bArr, C2394s c2394s) {
        return (MagazineOuterClass$ResponseLoadFeedMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MagazineOuterClass$ResponseLoadFeedMessages parseFrom(InputStream inputStream) {
        return (MagazineOuterClass$ResponseLoadFeedMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MagazineOuterClass$ResponseLoadFeedMessages parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MagazineOuterClass$ResponseLoadFeedMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MagazineOuterClass$ResponseLoadFeedMessages parseFrom(AbstractC2384h abstractC2384h) {
        return (MagazineOuterClass$ResponseLoadFeedMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MagazineOuterClass$ResponseLoadFeedMessages parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MagazineOuterClass$ResponseLoadFeedMessages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
