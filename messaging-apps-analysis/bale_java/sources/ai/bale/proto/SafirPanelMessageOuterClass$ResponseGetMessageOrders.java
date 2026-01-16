package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.P96;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class SafirPanelMessageOuterClass$ResponseGetMessageOrders extends GeneratedMessageLite implements U64 {
    public static final int COUNT_FIELD_NUMBER = 2;
    private static final SafirPanelMessageOuterClass$ResponseGetMessageOrders DEFAULT_INSTANCE;
    public static final int MESSAGE_ORDERS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private long count_;
    private B.j messageOrders_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SafirPanelMessageOuterClass$ResponseGetMessageOrders.DEFAULT_INSTANCE);
        }
    }

    static {
        SafirPanelMessageOuterClass$ResponseGetMessageOrders safirPanelMessageOuterClass$ResponseGetMessageOrders = new SafirPanelMessageOuterClass$ResponseGetMessageOrders();
        DEFAULT_INSTANCE = safirPanelMessageOuterClass$ResponseGetMessageOrders;
        GeneratedMessageLite.registerDefaultInstance(SafirPanelMessageOuterClass$ResponseGetMessageOrders.class, safirPanelMessageOuterClass$ResponseGetMessageOrders);
    }

    private SafirPanelMessageOuterClass$ResponseGetMessageOrders() {
    }

    private void addAllMessageOrders(Iterable<? extends SafirStruct$MessageOrder> iterable) {
        ensureMessageOrdersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.messageOrders_);
    }

    private void addMessageOrders(SafirStruct$MessageOrder safirStruct$MessageOrder) {
        safirStruct$MessageOrder.getClass();
        ensureMessageOrdersIsMutable();
        this.messageOrders_.add(safirStruct$MessageOrder);
    }

    private void clearCount() {
        this.count_ = 0L;
    }

    private void clearMessageOrders() {
        this.messageOrders_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureMessageOrdersIsMutable() {
        B.j jVar = this.messageOrders_;
        if (jVar.u()) {
            return;
        }
        this.messageOrders_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static SafirPanelMessageOuterClass$ResponseGetMessageOrders getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SafirPanelMessageOuterClass$ResponseGetMessageOrders parseDelimitedFrom(InputStream inputStream) {
        return (SafirPanelMessageOuterClass$ResponseGetMessageOrders) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SafirPanelMessageOuterClass$ResponseGetMessageOrders parseFrom(ByteBuffer byteBuffer) {
        return (SafirPanelMessageOuterClass$ResponseGetMessageOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeMessageOrders(int i) {
        ensureMessageOrdersIsMutable();
        this.messageOrders_.remove(i);
    }

    private void setCount(long j) {
        this.count_ = j;
    }

    private void setMessageOrders(int i, SafirStruct$MessageOrder safirStruct$MessageOrder) {
        safirStruct$MessageOrder.getClass();
        ensureMessageOrdersIsMutable();
        this.messageOrders_.set(i, safirStruct$MessageOrder);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (F1.a[gVar.ordinal()]) {
            case 1:
                return new SafirPanelMessageOuterClass$ResponseGetMessageOrders();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002\u0002", new Object[]{"messageOrders_", SafirStruct$MessageOrder.class, "count_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SafirPanelMessageOuterClass$ResponseGetMessageOrders.class) {
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

    public long getCount() {
        return this.count_;
    }

    public SafirStruct$MessageOrder getMessageOrders(int i) {
        return (SafirStruct$MessageOrder) this.messageOrders_.get(i);
    }

    public int getMessageOrdersCount() {
        return this.messageOrders_.size();
    }

    public List<SafirStruct$MessageOrder> getMessageOrdersList() {
        return this.messageOrders_;
    }

    public P96 getMessageOrdersOrBuilder(int i) {
        return (P96) this.messageOrders_.get(i);
    }

    public List<? extends P96> getMessageOrdersOrBuilderList() {
        return this.messageOrders_;
    }

    public static a newBuilder(SafirPanelMessageOuterClass$ResponseGetMessageOrders safirPanelMessageOuterClass$ResponseGetMessageOrders) {
        return (a) DEFAULT_INSTANCE.createBuilder(safirPanelMessageOuterClass$ResponseGetMessageOrders);
    }

    public static SafirPanelMessageOuterClass$ResponseGetMessageOrders parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SafirPanelMessageOuterClass$ResponseGetMessageOrders) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SafirPanelMessageOuterClass$ResponseGetMessageOrders parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SafirPanelMessageOuterClass$ResponseGetMessageOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SafirPanelMessageOuterClass$ResponseGetMessageOrders parseFrom(AbstractC2383g abstractC2383g) {
        return (SafirPanelMessageOuterClass$ResponseGetMessageOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addMessageOrders(int i, SafirStruct$MessageOrder safirStruct$MessageOrder) {
        safirStruct$MessageOrder.getClass();
        ensureMessageOrdersIsMutable();
        this.messageOrders_.add(i, safirStruct$MessageOrder);
    }

    public static SafirPanelMessageOuterClass$ResponseGetMessageOrders parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SafirPanelMessageOuterClass$ResponseGetMessageOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SafirPanelMessageOuterClass$ResponseGetMessageOrders parseFrom(byte[] bArr) {
        return (SafirPanelMessageOuterClass$ResponseGetMessageOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SafirPanelMessageOuterClass$ResponseGetMessageOrders parseFrom(byte[] bArr, C2394s c2394s) {
        return (SafirPanelMessageOuterClass$ResponseGetMessageOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SafirPanelMessageOuterClass$ResponseGetMessageOrders parseFrom(InputStream inputStream) {
        return (SafirPanelMessageOuterClass$ResponseGetMessageOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SafirPanelMessageOuterClass$ResponseGetMessageOrders parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SafirPanelMessageOuterClass$ResponseGetMessageOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SafirPanelMessageOuterClass$ResponseGetMessageOrders parseFrom(AbstractC2384h abstractC2384h) {
        return (SafirPanelMessageOuterClass$ResponseGetMessageOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SafirPanelMessageOuterClass$ResponseGetMessageOrders parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SafirPanelMessageOuterClass$ResponseGetMessageOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
