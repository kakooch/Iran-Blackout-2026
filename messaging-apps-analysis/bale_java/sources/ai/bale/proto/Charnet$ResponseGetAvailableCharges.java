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
public final class Charnet$ResponseGetAvailableCharges extends GeneratedMessageLite implements U64 {
    public static final int AMOUNTS_FIELD_NUMBER = 1;
    public static final int CAN_BE_OPTIONAL_FIELD_NUMBER = 2;
    private static final Charnet$ResponseGetAvailableCharges DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private int amountsMemoizedSerializedSize = -1;
    private B.i amounts_ = GeneratedMessageLite.emptyLongList();
    private boolean canBeOptional_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Charnet$ResponseGetAvailableCharges.DEFAULT_INSTANCE);
        }
    }

    static {
        Charnet$ResponseGetAvailableCharges charnet$ResponseGetAvailableCharges = new Charnet$ResponseGetAvailableCharges();
        DEFAULT_INSTANCE = charnet$ResponseGetAvailableCharges;
        GeneratedMessageLite.registerDefaultInstance(Charnet$ResponseGetAvailableCharges.class, charnet$ResponseGetAvailableCharges);
    }

    private Charnet$ResponseGetAvailableCharges() {
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

    public static Charnet$ResponseGetAvailableCharges getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Charnet$ResponseGetAvailableCharges parseDelimitedFrom(InputStream inputStream) {
        return (Charnet$ResponseGetAvailableCharges) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Charnet$ResponseGetAvailableCharges parseFrom(ByteBuffer byteBuffer) {
        return (Charnet$ResponseGetAvailableCharges) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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
        switch (AbstractC1911z.a[gVar.ordinal()]) {
            case 1:
                return new Charnet$ResponseGetAvailableCharges();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001%\u0002\u0007", new Object[]{"amounts_", "canBeOptional_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Charnet$ResponseGetAvailableCharges.class) {
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

    public static a newBuilder(Charnet$ResponseGetAvailableCharges charnet$ResponseGetAvailableCharges) {
        return (a) DEFAULT_INSTANCE.createBuilder(charnet$ResponseGetAvailableCharges);
    }

    public static Charnet$ResponseGetAvailableCharges parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Charnet$ResponseGetAvailableCharges) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Charnet$ResponseGetAvailableCharges parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Charnet$ResponseGetAvailableCharges) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Charnet$ResponseGetAvailableCharges parseFrom(AbstractC2383g abstractC2383g) {
        return (Charnet$ResponseGetAvailableCharges) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Charnet$ResponseGetAvailableCharges parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Charnet$ResponseGetAvailableCharges) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Charnet$ResponseGetAvailableCharges parseFrom(byte[] bArr) {
        return (Charnet$ResponseGetAvailableCharges) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Charnet$ResponseGetAvailableCharges parseFrom(byte[] bArr, C2394s c2394s) {
        return (Charnet$ResponseGetAvailableCharges) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Charnet$ResponseGetAvailableCharges parseFrom(InputStream inputStream) {
        return (Charnet$ResponseGetAvailableCharges) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Charnet$ResponseGetAvailableCharges parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Charnet$ResponseGetAvailableCharges) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Charnet$ResponseGetAvailableCharges parseFrom(AbstractC2384h abstractC2384h) {
        return (Charnet$ResponseGetAvailableCharges) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Charnet$ResponseGetAvailableCharges parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Charnet$ResponseGetAvailableCharges) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
