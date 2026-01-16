package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC9529a70;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class BankOuterClass$ResponseGetRecentCharges extends GeneratedMessageLite implements U64 {
    private static final BankOuterClass$ResponseGetRecentCharges DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int RECENT_CHARGES_FIELD_NUMBER = 1;
    private B.j recentCharges_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BankOuterClass$ResponseGetRecentCharges.DEFAULT_INSTANCE);
        }
    }

    static {
        BankOuterClass$ResponseGetRecentCharges bankOuterClass$ResponseGetRecentCharges = new BankOuterClass$ResponseGetRecentCharges();
        DEFAULT_INSTANCE = bankOuterClass$ResponseGetRecentCharges;
        GeneratedMessageLite.registerDefaultInstance(BankOuterClass$ResponseGetRecentCharges.class, bankOuterClass$ResponseGetRecentCharges);
    }

    private BankOuterClass$ResponseGetRecentCharges() {
    }

    private void addAllRecentCharges(Iterable<? extends BankStruct$RecentCharge> iterable) {
        ensureRecentChargesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.recentCharges_);
    }

    private void addRecentCharges(BankStruct$RecentCharge bankStruct$RecentCharge) {
        bankStruct$RecentCharge.getClass();
        ensureRecentChargesIsMutable();
        this.recentCharges_.add(bankStruct$RecentCharge);
    }

    private void clearRecentCharges() {
        this.recentCharges_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureRecentChargesIsMutable() {
        B.j jVar = this.recentCharges_;
        if (jVar.u()) {
            return;
        }
        this.recentCharges_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static BankOuterClass$ResponseGetRecentCharges getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BankOuterClass$ResponseGetRecentCharges parseDelimitedFrom(InputStream inputStream) {
        return (BankOuterClass$ResponseGetRecentCharges) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankOuterClass$ResponseGetRecentCharges parseFrom(ByteBuffer byteBuffer) {
        return (BankOuterClass$ResponseGetRecentCharges) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeRecentCharges(int i) {
        ensureRecentChargesIsMutable();
        this.recentCharges_.remove(i);
    }

    private void setRecentCharges(int i, BankStruct$RecentCharge bankStruct$RecentCharge) {
        bankStruct$RecentCharge.getClass();
        ensureRecentChargesIsMutable();
        this.recentCharges_.set(i, bankStruct$RecentCharge);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1876n.a[gVar.ordinal()]) {
            case 1:
                return new BankOuterClass$ResponseGetRecentCharges();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"recentCharges_", BankStruct$RecentCharge.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BankOuterClass$ResponseGetRecentCharges.class) {
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

    public BankStruct$RecentCharge getRecentCharges(int i) {
        return (BankStruct$RecentCharge) this.recentCharges_.get(i);
    }

    public int getRecentChargesCount() {
        return this.recentCharges_.size();
    }

    public List<BankStruct$RecentCharge> getRecentChargesList() {
        return this.recentCharges_;
    }

    public InterfaceC9529a70 getRecentChargesOrBuilder(int i) {
        return (InterfaceC9529a70) this.recentCharges_.get(i);
    }

    public List<? extends InterfaceC9529a70> getRecentChargesOrBuilderList() {
        return this.recentCharges_;
    }

    public static a newBuilder(BankOuterClass$ResponseGetRecentCharges bankOuterClass$ResponseGetRecentCharges) {
        return (a) DEFAULT_INSTANCE.createBuilder(bankOuterClass$ResponseGetRecentCharges);
    }

    public static BankOuterClass$ResponseGetRecentCharges parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BankOuterClass$ResponseGetRecentCharges) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankOuterClass$ResponseGetRecentCharges parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BankOuterClass$ResponseGetRecentCharges) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BankOuterClass$ResponseGetRecentCharges parseFrom(AbstractC2383g abstractC2383g) {
        return (BankOuterClass$ResponseGetRecentCharges) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addRecentCharges(int i, BankStruct$RecentCharge bankStruct$RecentCharge) {
        bankStruct$RecentCharge.getClass();
        ensureRecentChargesIsMutable();
        this.recentCharges_.add(i, bankStruct$RecentCharge);
    }

    public static BankOuterClass$ResponseGetRecentCharges parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BankOuterClass$ResponseGetRecentCharges) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BankOuterClass$ResponseGetRecentCharges parseFrom(byte[] bArr) {
        return (BankOuterClass$ResponseGetRecentCharges) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BankOuterClass$ResponseGetRecentCharges parseFrom(byte[] bArr, C2394s c2394s) {
        return (BankOuterClass$ResponseGetRecentCharges) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BankOuterClass$ResponseGetRecentCharges parseFrom(InputStream inputStream) {
        return (BankOuterClass$ResponseGetRecentCharges) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankOuterClass$ResponseGetRecentCharges parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BankOuterClass$ResponseGetRecentCharges) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankOuterClass$ResponseGetRecentCharges parseFrom(AbstractC2384h abstractC2384h) {
        return (BankOuterClass$ResponseGetRecentCharges) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BankOuterClass$ResponseGetRecentCharges parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BankOuterClass$ResponseGetRecentCharges) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
