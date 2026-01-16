package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC6074Mb2;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class EvexOuterClass$ResponseLoadEvexHistory extends GeneratedMessageLite implements U64 {
    public static final int APPROVAL_TEXT_FIELD_NUMBER = 2;
    private static final EvexOuterClass$ResponseLoadEvexHistory DEFAULT_INSTANCE;
    public static final int ORDERS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j orders_ = GeneratedMessageLite.emptyProtobufList();
    private String approvalText_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(EvexOuterClass$ResponseLoadEvexHistory.DEFAULT_INSTANCE);
        }
    }

    static {
        EvexOuterClass$ResponseLoadEvexHistory evexOuterClass$ResponseLoadEvexHistory = new EvexOuterClass$ResponseLoadEvexHistory();
        DEFAULT_INSTANCE = evexOuterClass$ResponseLoadEvexHistory;
        GeneratedMessageLite.registerDefaultInstance(EvexOuterClass$ResponseLoadEvexHistory.class, evexOuterClass$ResponseLoadEvexHistory);
    }

    private EvexOuterClass$ResponseLoadEvexHistory() {
    }

    private void addAllOrders(Iterable<? extends EvexStruct$EvexHistoryItem> iterable) {
        ensureOrdersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.orders_);
    }

    private void addOrders(EvexStruct$EvexHistoryItem evexStruct$EvexHistoryItem) {
        evexStruct$EvexHistoryItem.getClass();
        ensureOrdersIsMutable();
        this.orders_.add(evexStruct$EvexHistoryItem);
    }

    private void clearApprovalText() {
        this.approvalText_ = getDefaultInstance().getApprovalText();
    }

    private void clearOrders() {
        this.orders_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureOrdersIsMutable() {
        B.j jVar = this.orders_;
        if (jVar.u()) {
            return;
        }
        this.orders_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static EvexOuterClass$ResponseLoadEvexHistory getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static EvexOuterClass$ResponseLoadEvexHistory parseDelimitedFrom(InputStream inputStream) {
        return (EvexOuterClass$ResponseLoadEvexHistory) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EvexOuterClass$ResponseLoadEvexHistory parseFrom(ByteBuffer byteBuffer) {
        return (EvexOuterClass$ResponseLoadEvexHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeOrders(int i) {
        ensureOrdersIsMutable();
        this.orders_.remove(i);
    }

    private void setApprovalText(String str) {
        str.getClass();
        this.approvalText_ = str;
    }

    private void setApprovalTextBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.approvalText_ = abstractC2383g.f0();
    }

    private void setOrders(int i, EvexStruct$EvexHistoryItem evexStruct$EvexHistoryItem) {
        evexStruct$EvexHistoryItem.getClass();
        ensureOrdersIsMutable();
        this.orders_.set(i, evexStruct$EvexHistoryItem);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (S.a[gVar.ordinal()]) {
            case 1:
                return new EvexOuterClass$ResponseLoadEvexHistory();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002Ȉ", new Object[]{"orders_", EvexStruct$EvexHistoryItem.class, "approvalText_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (EvexOuterClass$ResponseLoadEvexHistory.class) {
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

    public String getApprovalText() {
        return this.approvalText_;
    }

    public AbstractC2383g getApprovalTextBytes() {
        return AbstractC2383g.N(this.approvalText_);
    }

    public EvexStruct$EvexHistoryItem getOrders(int i) {
        return (EvexStruct$EvexHistoryItem) this.orders_.get(i);
    }

    public int getOrdersCount() {
        return this.orders_.size();
    }

    public List<EvexStruct$EvexHistoryItem> getOrdersList() {
        return this.orders_;
    }

    public InterfaceC6074Mb2 getOrdersOrBuilder(int i) {
        return (InterfaceC6074Mb2) this.orders_.get(i);
    }

    public List<? extends InterfaceC6074Mb2> getOrdersOrBuilderList() {
        return this.orders_;
    }

    public static a newBuilder(EvexOuterClass$ResponseLoadEvexHistory evexOuterClass$ResponseLoadEvexHistory) {
        return (a) DEFAULT_INSTANCE.createBuilder(evexOuterClass$ResponseLoadEvexHistory);
    }

    public static EvexOuterClass$ResponseLoadEvexHistory parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (EvexOuterClass$ResponseLoadEvexHistory) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static EvexOuterClass$ResponseLoadEvexHistory parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (EvexOuterClass$ResponseLoadEvexHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static EvexOuterClass$ResponseLoadEvexHistory parseFrom(AbstractC2383g abstractC2383g) {
        return (EvexOuterClass$ResponseLoadEvexHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addOrders(int i, EvexStruct$EvexHistoryItem evexStruct$EvexHistoryItem) {
        evexStruct$EvexHistoryItem.getClass();
        ensureOrdersIsMutable();
        this.orders_.add(i, evexStruct$EvexHistoryItem);
    }

    public static EvexOuterClass$ResponseLoadEvexHistory parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (EvexOuterClass$ResponseLoadEvexHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static EvexOuterClass$ResponseLoadEvexHistory parseFrom(byte[] bArr) {
        return (EvexOuterClass$ResponseLoadEvexHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static EvexOuterClass$ResponseLoadEvexHistory parseFrom(byte[] bArr, C2394s c2394s) {
        return (EvexOuterClass$ResponseLoadEvexHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static EvexOuterClass$ResponseLoadEvexHistory parseFrom(InputStream inputStream) {
        return (EvexOuterClass$ResponseLoadEvexHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EvexOuterClass$ResponseLoadEvexHistory parseFrom(InputStream inputStream, C2394s c2394s) {
        return (EvexOuterClass$ResponseLoadEvexHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static EvexOuterClass$ResponseLoadEvexHistory parseFrom(AbstractC2384h abstractC2384h) {
        return (EvexOuterClass$ResponseLoadEvexHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static EvexOuterClass$ResponseLoadEvexHistory parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (EvexOuterClass$ResponseLoadEvexHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
