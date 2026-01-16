package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.N14;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MelonOuterClass$ResponseLoadLastStates extends GeneratedMessageLite implements U64 {
    private static final MelonOuterClass$ResponseLoadLastStates DEFAULT_INSTANCE;
    public static final int LOANS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j loans_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MelonOuterClass$ResponseLoadLastStates.DEFAULT_INSTANCE);
        }
    }

    static {
        MelonOuterClass$ResponseLoadLastStates melonOuterClass$ResponseLoadLastStates = new MelonOuterClass$ResponseLoadLastStates();
        DEFAULT_INSTANCE = melonOuterClass$ResponseLoadLastStates;
        GeneratedMessageLite.registerDefaultInstance(MelonOuterClass$ResponseLoadLastStates.class, melonOuterClass$ResponseLoadLastStates);
    }

    private MelonOuterClass$ResponseLoadLastStates() {
    }

    private void addAllLoans(Iterable<? extends MelonStruct$Loan> iterable) {
        ensureLoansIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.loans_);
    }

    private void addLoans(MelonStruct$Loan melonStruct$Loan) {
        melonStruct$Loan.getClass();
        ensureLoansIsMutable();
        this.loans_.add(melonStruct$Loan);
    }

    private void clearLoans() {
        this.loans_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureLoansIsMutable() {
        B.j jVar = this.loans_;
        if (jVar.u()) {
            return;
        }
        this.loans_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MelonOuterClass$ResponseLoadLastStates getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MelonOuterClass$ResponseLoadLastStates parseDelimitedFrom(InputStream inputStream) {
        return (MelonOuterClass$ResponseLoadLastStates) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MelonOuterClass$ResponseLoadLastStates parseFrom(ByteBuffer byteBuffer) {
        return (MelonOuterClass$ResponseLoadLastStates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeLoans(int i) {
        ensureLoansIsMutable();
        this.loans_.remove(i);
    }

    private void setLoans(int i, MelonStruct$Loan melonStruct$Loan) {
        melonStruct$Loan.getClass();
        ensureLoansIsMutable();
        this.loans_.set(i, melonStruct$Loan);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (I0.a[gVar.ordinal()]) {
            case 1:
                return new MelonOuterClass$ResponseLoadLastStates();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"loans_", MelonStruct$Loan.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MelonOuterClass$ResponseLoadLastStates.class) {
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

    public MelonStruct$Loan getLoans(int i) {
        return (MelonStruct$Loan) this.loans_.get(i);
    }

    public int getLoansCount() {
        return this.loans_.size();
    }

    public List<MelonStruct$Loan> getLoansList() {
        return this.loans_;
    }

    public N14 getLoansOrBuilder(int i) {
        return (N14) this.loans_.get(i);
    }

    public List<? extends N14> getLoansOrBuilderList() {
        return this.loans_;
    }

    public static a newBuilder(MelonOuterClass$ResponseLoadLastStates melonOuterClass$ResponseLoadLastStates) {
        return (a) DEFAULT_INSTANCE.createBuilder(melonOuterClass$ResponseLoadLastStates);
    }

    public static MelonOuterClass$ResponseLoadLastStates parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MelonOuterClass$ResponseLoadLastStates) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MelonOuterClass$ResponseLoadLastStates parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MelonOuterClass$ResponseLoadLastStates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MelonOuterClass$ResponseLoadLastStates parseFrom(AbstractC2383g abstractC2383g) {
        return (MelonOuterClass$ResponseLoadLastStates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addLoans(int i, MelonStruct$Loan melonStruct$Loan) {
        melonStruct$Loan.getClass();
        ensureLoansIsMutable();
        this.loans_.add(i, melonStruct$Loan);
    }

    public static MelonOuterClass$ResponseLoadLastStates parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MelonOuterClass$ResponseLoadLastStates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MelonOuterClass$ResponseLoadLastStates parseFrom(byte[] bArr) {
        return (MelonOuterClass$ResponseLoadLastStates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MelonOuterClass$ResponseLoadLastStates parseFrom(byte[] bArr, C2394s c2394s) {
        return (MelonOuterClass$ResponseLoadLastStates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MelonOuterClass$ResponseLoadLastStates parseFrom(InputStream inputStream) {
        return (MelonOuterClass$ResponseLoadLastStates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MelonOuterClass$ResponseLoadLastStates parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MelonOuterClass$ResponseLoadLastStates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MelonOuterClass$ResponseLoadLastStates parseFrom(AbstractC2384h abstractC2384h) {
        return (MelonOuterClass$ResponseLoadLastStates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MelonOuterClass$ResponseLoadLastStates parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MelonOuterClass$ResponseLoadLastStates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
