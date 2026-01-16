package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class BillOuterClass$ResponseCreateSavedBill extends GeneratedMessageLite implements U64 {
    private static final BillOuterClass$ResponseCreateSavedBill DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private long id_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BillOuterClass$ResponseCreateSavedBill.DEFAULT_INSTANCE);
        }
    }

    static {
        BillOuterClass$ResponseCreateSavedBill billOuterClass$ResponseCreateSavedBill = new BillOuterClass$ResponseCreateSavedBill();
        DEFAULT_INSTANCE = billOuterClass$ResponseCreateSavedBill;
        GeneratedMessageLite.registerDefaultInstance(BillOuterClass$ResponseCreateSavedBill.class, billOuterClass$ResponseCreateSavedBill);
    }

    private BillOuterClass$ResponseCreateSavedBill() {
    }

    private void clearId() {
        this.id_ = 0L;
    }

    public static BillOuterClass$ResponseCreateSavedBill getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BillOuterClass$ResponseCreateSavedBill parseDelimitedFrom(InputStream inputStream) {
        return (BillOuterClass$ResponseCreateSavedBill) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BillOuterClass$ResponseCreateSavedBill parseFrom(ByteBuffer byteBuffer) {
        return (BillOuterClass$ResponseCreateSavedBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setId(long j) {
        this.id_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (r.a[gVar.ordinal()]) {
            case 1:
                return new BillOuterClass$ResponseCreateSavedBill();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0002", new Object[]{"id_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BillOuterClass$ResponseCreateSavedBill.class) {
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

    public long getId() {
        return this.id_;
    }

    public static a newBuilder(BillOuterClass$ResponseCreateSavedBill billOuterClass$ResponseCreateSavedBill) {
        return (a) DEFAULT_INSTANCE.createBuilder(billOuterClass$ResponseCreateSavedBill);
    }

    public static BillOuterClass$ResponseCreateSavedBill parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BillOuterClass$ResponseCreateSavedBill) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BillOuterClass$ResponseCreateSavedBill parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BillOuterClass$ResponseCreateSavedBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BillOuterClass$ResponseCreateSavedBill parseFrom(AbstractC2383g abstractC2383g) {
        return (BillOuterClass$ResponseCreateSavedBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BillOuterClass$ResponseCreateSavedBill parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BillOuterClass$ResponseCreateSavedBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BillOuterClass$ResponseCreateSavedBill parseFrom(byte[] bArr) {
        return (BillOuterClass$ResponseCreateSavedBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BillOuterClass$ResponseCreateSavedBill parseFrom(byte[] bArr, C2394s c2394s) {
        return (BillOuterClass$ResponseCreateSavedBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BillOuterClass$ResponseCreateSavedBill parseFrom(InputStream inputStream) {
        return (BillOuterClass$ResponseCreateSavedBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BillOuterClass$ResponseCreateSavedBill parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BillOuterClass$ResponseCreateSavedBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BillOuterClass$ResponseCreateSavedBill parseFrom(AbstractC2384h abstractC2384h) {
        return (BillOuterClass$ResponseCreateSavedBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BillOuterClass$ResponseCreateSavedBill parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BillOuterClass$ResponseCreateSavedBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
