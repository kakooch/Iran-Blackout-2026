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
public final class BillOuterClass$RequestDeleteSavedBills extends GeneratedMessageLite implements U64 {
    private static final BillOuterClass$RequestDeleteSavedBills DEFAULT_INSTANCE;
    public static final int IDS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int idsMemoizedSerializedSize = -1;
    private B.i ids_ = GeneratedMessageLite.emptyLongList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BillOuterClass$RequestDeleteSavedBills.DEFAULT_INSTANCE);
        }
    }

    static {
        BillOuterClass$RequestDeleteSavedBills billOuterClass$RequestDeleteSavedBills = new BillOuterClass$RequestDeleteSavedBills();
        DEFAULT_INSTANCE = billOuterClass$RequestDeleteSavedBills;
        GeneratedMessageLite.registerDefaultInstance(BillOuterClass$RequestDeleteSavedBills.class, billOuterClass$RequestDeleteSavedBills);
    }

    private BillOuterClass$RequestDeleteSavedBills() {
    }

    private void addAllIds(Iterable<? extends Long> iterable) {
        ensureIdsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.ids_);
    }

    private void addIds(long j) {
        ensureIdsIsMutable();
        this.ids_.l1(j);
    }

    private void clearIds() {
        this.ids_ = GeneratedMessageLite.emptyLongList();
    }

    private void ensureIdsIsMutable() {
        B.i iVar = this.ids_;
        if (iVar.u()) {
            return;
        }
        this.ids_ = GeneratedMessageLite.mutableCopy(iVar);
    }

    public static BillOuterClass$RequestDeleteSavedBills getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BillOuterClass$RequestDeleteSavedBills parseDelimitedFrom(InputStream inputStream) {
        return (BillOuterClass$RequestDeleteSavedBills) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BillOuterClass$RequestDeleteSavedBills parseFrom(ByteBuffer byteBuffer) {
        return (BillOuterClass$RequestDeleteSavedBills) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setIds(int i, long j) {
        ensureIdsIsMutable();
        this.ids_.z1(i, j);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (r.a[gVar.ordinal()]) {
            case 1:
                return new BillOuterClass$RequestDeleteSavedBills();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001%", new Object[]{"ids_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BillOuterClass$RequestDeleteSavedBills.class) {
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

    public long getIds(int i) {
        return this.ids_.getLong(i);
    }

    public int getIdsCount() {
        return this.ids_.size();
    }

    public List<Long> getIdsList() {
        return this.ids_;
    }

    public static a newBuilder(BillOuterClass$RequestDeleteSavedBills billOuterClass$RequestDeleteSavedBills) {
        return (a) DEFAULT_INSTANCE.createBuilder(billOuterClass$RequestDeleteSavedBills);
    }

    public static BillOuterClass$RequestDeleteSavedBills parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BillOuterClass$RequestDeleteSavedBills) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BillOuterClass$RequestDeleteSavedBills parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BillOuterClass$RequestDeleteSavedBills) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BillOuterClass$RequestDeleteSavedBills parseFrom(AbstractC2383g abstractC2383g) {
        return (BillOuterClass$RequestDeleteSavedBills) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BillOuterClass$RequestDeleteSavedBills parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BillOuterClass$RequestDeleteSavedBills) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BillOuterClass$RequestDeleteSavedBills parseFrom(byte[] bArr) {
        return (BillOuterClass$RequestDeleteSavedBills) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BillOuterClass$RequestDeleteSavedBills parseFrom(byte[] bArr, C2394s c2394s) {
        return (BillOuterClass$RequestDeleteSavedBills) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BillOuterClass$RequestDeleteSavedBills parseFrom(InputStream inputStream) {
        return (BillOuterClass$RequestDeleteSavedBills) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BillOuterClass$RequestDeleteSavedBills parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BillOuterClass$RequestDeleteSavedBills) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BillOuterClass$RequestDeleteSavedBills parseFrom(AbstractC2384h abstractC2384h) {
        return (BillOuterClass$RequestDeleteSavedBills) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BillOuterClass$RequestDeleteSavedBills parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BillOuterClass$RequestDeleteSavedBills) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
