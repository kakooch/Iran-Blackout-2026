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

/* loaded from: classes.dex */
public final class Saba$ResponseGetChargeAmounts extends GeneratedMessageLite implements U64 {
    public static final int AMOUNTS_FIELD_NUMBER = 1;
    public static final int CAN_BE_OPTIONAL_FIELD_NUMBER = 2;
    private static final Saba$ResponseGetChargeAmounts DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private int amountsMemoizedSerializedSize = -1;
    private B.i amounts_ = GeneratedMessageLite.emptyLongList();
    private boolean canBeOptional_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Saba$ResponseGetChargeAmounts.DEFAULT_INSTANCE);
        }
    }

    static {
        Saba$ResponseGetChargeAmounts saba$ResponseGetChargeAmounts = new Saba$ResponseGetChargeAmounts();
        DEFAULT_INSTANCE = saba$ResponseGetChargeAmounts;
        GeneratedMessageLite.registerDefaultInstance(Saba$ResponseGetChargeAmounts.class, saba$ResponseGetChargeAmounts);
    }

    private Saba$ResponseGetChargeAmounts() {
    }

    private void addAllAmounts(Iterable<? extends Long> iterable) {
        ensureAmountsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.amounts_);
    }

    private void addAmounts(long j) {
        ensureAmountsIsMutable();
        this.amounts_.l1(j);
    }

    private void clearAmounts() {
        this.amounts_ = GeneratedMessageLite.emptyLongList();
    }

    private void clearCanBeOptional() {
        this.canBeOptional_ = false;
    }

    private void ensureAmountsIsMutable() {
        B.i iVar = this.amounts_;
        if (iVar.u()) {
            return;
        }
        this.amounts_ = GeneratedMessageLite.mutableCopy(iVar);
    }

    public static Saba$ResponseGetChargeAmounts getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Saba$ResponseGetChargeAmounts parseDelimitedFrom(InputStream inputStream) {
        return (Saba$ResponseGetChargeAmounts) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Saba$ResponseGetChargeAmounts parseFrom(ByteBuffer byteBuffer) {
        return (Saba$ResponseGetChargeAmounts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAmounts(int i, long j) {
        ensureAmountsIsMutable();
        this.amounts_.z1(i, j);
    }

    private void setCanBeOptional(boolean z) {
        this.canBeOptional_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (B1.a[gVar.ordinal()]) {
            case 1:
                return new Saba$ResponseGetChargeAmounts();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001%\u0002\u0007", new Object[]{"amounts_", "canBeOptional_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Saba$ResponseGetChargeAmounts.class) {
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

    public long getAmounts(int i) {
        return this.amounts_.getLong(i);
    }

    public int getAmountsCount() {
        return this.amounts_.size();
    }

    public List<Long> getAmountsList() {
        return this.amounts_;
    }

    public boolean getCanBeOptional() {
        return this.canBeOptional_;
    }

    public static a newBuilder(Saba$ResponseGetChargeAmounts saba$ResponseGetChargeAmounts) {
        return (a) DEFAULT_INSTANCE.createBuilder(saba$ResponseGetChargeAmounts);
    }

    public static Saba$ResponseGetChargeAmounts parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Saba$ResponseGetChargeAmounts) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Saba$ResponseGetChargeAmounts parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Saba$ResponseGetChargeAmounts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Saba$ResponseGetChargeAmounts parseFrom(AbstractC2383g abstractC2383g) {
        return (Saba$ResponseGetChargeAmounts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Saba$ResponseGetChargeAmounts parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Saba$ResponseGetChargeAmounts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Saba$ResponseGetChargeAmounts parseFrom(byte[] bArr) {
        return (Saba$ResponseGetChargeAmounts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Saba$ResponseGetChargeAmounts parseFrom(byte[] bArr, C2394s c2394s) {
        return (Saba$ResponseGetChargeAmounts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Saba$ResponseGetChargeAmounts parseFrom(InputStream inputStream) {
        return (Saba$ResponseGetChargeAmounts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Saba$ResponseGetChargeAmounts parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Saba$ResponseGetChargeAmounts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Saba$ResponseGetChargeAmounts parseFrom(AbstractC2384h abstractC2384h) {
        return (Saba$ResponseGetChargeAmounts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Saba$ResponseGetChargeAmounts parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Saba$ResponseGetChargeAmounts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
