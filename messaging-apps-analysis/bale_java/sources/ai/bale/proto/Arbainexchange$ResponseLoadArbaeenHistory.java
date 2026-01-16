package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.DI;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class Arbainexchange$ResponseLoadArbaeenHistory extends GeneratedMessageLite implements U64 {
    public static final int APPROVAL_TEXT_FIELD_NUMBER = 2;
    private static final Arbainexchange$ResponseLoadArbaeenHistory DEFAULT_INSTANCE;
    public static final int ORDERS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j orders_ = GeneratedMessageLite.emptyProtobufList();
    private String approvalText_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Arbainexchange$ResponseLoadArbaeenHistory.DEFAULT_INSTANCE);
        }
    }

    static {
        Arbainexchange$ResponseLoadArbaeenHistory arbainexchange$ResponseLoadArbaeenHistory = new Arbainexchange$ResponseLoadArbaeenHistory();
        DEFAULT_INSTANCE = arbainexchange$ResponseLoadArbaeenHistory;
        GeneratedMessageLite.registerDefaultInstance(Arbainexchange$ResponseLoadArbaeenHistory.class, arbainexchange$ResponseLoadArbaeenHistory);
    }

    private Arbainexchange$ResponseLoadArbaeenHistory() {
    }

    private void addAllOrders(Iterable<? extends ArbainexchangeStruct$ArbaeenHistoryItem> iterable) {
        ensureOrdersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.orders_);
    }

    private void addOrders(ArbainexchangeStruct$ArbaeenHistoryItem arbainexchangeStruct$ArbaeenHistoryItem) {
        arbainexchangeStruct$ArbaeenHistoryItem.getClass();
        ensureOrdersIsMutable();
        this.orders_.add(arbainexchangeStruct$ArbaeenHistoryItem);
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

    public static Arbainexchange$ResponseLoadArbaeenHistory getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Arbainexchange$ResponseLoadArbaeenHistory parseDelimitedFrom(InputStream inputStream) {
        return (Arbainexchange$ResponseLoadArbaeenHistory) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Arbainexchange$ResponseLoadArbaeenHistory parseFrom(ByteBuffer byteBuffer) {
        return (Arbainexchange$ResponseLoadArbaeenHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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

    private void setOrders(int i, ArbainexchangeStruct$ArbaeenHistoryItem arbainexchangeStruct$ArbaeenHistoryItem) {
        arbainexchangeStruct$ArbaeenHistoryItem.getClass();
        ensureOrdersIsMutable();
        this.orders_.set(i, arbainexchangeStruct$ArbaeenHistoryItem);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1861i.a[gVar.ordinal()]) {
            case 1:
                return new Arbainexchange$ResponseLoadArbaeenHistory();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002Ȉ", new Object[]{"orders_", ArbainexchangeStruct$ArbaeenHistoryItem.class, "approvalText_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Arbainexchange$ResponseLoadArbaeenHistory.class) {
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

    public ArbainexchangeStruct$ArbaeenHistoryItem getOrders(int i) {
        return (ArbainexchangeStruct$ArbaeenHistoryItem) this.orders_.get(i);
    }

    public int getOrdersCount() {
        return this.orders_.size();
    }

    public List<ArbainexchangeStruct$ArbaeenHistoryItem> getOrdersList() {
        return this.orders_;
    }

    public DI getOrdersOrBuilder(int i) {
        return (DI) this.orders_.get(i);
    }

    public List<? extends DI> getOrdersOrBuilderList() {
        return this.orders_;
    }

    public static a newBuilder(Arbainexchange$ResponseLoadArbaeenHistory arbainexchange$ResponseLoadArbaeenHistory) {
        return (a) DEFAULT_INSTANCE.createBuilder(arbainexchange$ResponseLoadArbaeenHistory);
    }

    public static Arbainexchange$ResponseLoadArbaeenHistory parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Arbainexchange$ResponseLoadArbaeenHistory) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Arbainexchange$ResponseLoadArbaeenHistory parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Arbainexchange$ResponseLoadArbaeenHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Arbainexchange$ResponseLoadArbaeenHistory parseFrom(AbstractC2383g abstractC2383g) {
        return (Arbainexchange$ResponseLoadArbaeenHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addOrders(int i, ArbainexchangeStruct$ArbaeenHistoryItem arbainexchangeStruct$ArbaeenHistoryItem) {
        arbainexchangeStruct$ArbaeenHistoryItem.getClass();
        ensureOrdersIsMutable();
        this.orders_.add(i, arbainexchangeStruct$ArbaeenHistoryItem);
    }

    public static Arbainexchange$ResponseLoadArbaeenHistory parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Arbainexchange$ResponseLoadArbaeenHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Arbainexchange$ResponseLoadArbaeenHistory parseFrom(byte[] bArr) {
        return (Arbainexchange$ResponseLoadArbaeenHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Arbainexchange$ResponseLoadArbaeenHistory parseFrom(byte[] bArr, C2394s c2394s) {
        return (Arbainexchange$ResponseLoadArbaeenHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Arbainexchange$ResponseLoadArbaeenHistory parseFrom(InputStream inputStream) {
        return (Arbainexchange$ResponseLoadArbaeenHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Arbainexchange$ResponseLoadArbaeenHistory parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Arbainexchange$ResponseLoadArbaeenHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Arbainexchange$ResponseLoadArbaeenHistory parseFrom(AbstractC2384h abstractC2384h) {
        return (Arbainexchange$ResponseLoadArbaeenHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Arbainexchange$ResponseLoadArbaeenHistory parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Arbainexchange$ResponseLoadArbaeenHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
