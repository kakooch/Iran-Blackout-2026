package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.FI;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class Arbainexchange$ResponseGetListOfBranches extends GeneratedMessageLite implements U64 {
    public static final int BRANCHES_FIELD_NUMBER = 1;
    private static final Arbainexchange$ResponseGetListOfBranches DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private B.j branches_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Arbainexchange$ResponseGetListOfBranches.DEFAULT_INSTANCE);
        }
    }

    static {
        Arbainexchange$ResponseGetListOfBranches arbainexchange$ResponseGetListOfBranches = new Arbainexchange$ResponseGetListOfBranches();
        DEFAULT_INSTANCE = arbainexchange$ResponseGetListOfBranches;
        GeneratedMessageLite.registerDefaultInstance(Arbainexchange$ResponseGetListOfBranches.class, arbainexchange$ResponseGetListOfBranches);
    }

    private Arbainexchange$ResponseGetListOfBranches() {
    }

    private void addAllBranches(Iterable<? extends ArbainexchangeStruct$ArbaeenPostBranches> iterable) {
        ensureBranchesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.branches_);
    }

    private void addBranches(ArbainexchangeStruct$ArbaeenPostBranches arbainexchangeStruct$ArbaeenPostBranches) {
        arbainexchangeStruct$ArbaeenPostBranches.getClass();
        ensureBranchesIsMutable();
        this.branches_.add(arbainexchangeStruct$ArbaeenPostBranches);
    }

    private void clearBranches() {
        this.branches_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureBranchesIsMutable() {
        B.j jVar = this.branches_;
        if (jVar.u()) {
            return;
        }
        this.branches_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static Arbainexchange$ResponseGetListOfBranches getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Arbainexchange$ResponseGetListOfBranches parseDelimitedFrom(InputStream inputStream) {
        return (Arbainexchange$ResponseGetListOfBranches) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Arbainexchange$ResponseGetListOfBranches parseFrom(ByteBuffer byteBuffer) {
        return (Arbainexchange$ResponseGetListOfBranches) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeBranches(int i) {
        ensureBranchesIsMutable();
        this.branches_.remove(i);
    }

    private void setBranches(int i, ArbainexchangeStruct$ArbaeenPostBranches arbainexchangeStruct$ArbaeenPostBranches) {
        arbainexchangeStruct$ArbaeenPostBranches.getClass();
        ensureBranchesIsMutable();
        this.branches_.set(i, arbainexchangeStruct$ArbaeenPostBranches);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1861i.a[gVar.ordinal()]) {
            case 1:
                return new Arbainexchange$ResponseGetListOfBranches();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"branches_", ArbainexchangeStruct$ArbaeenPostBranches.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Arbainexchange$ResponseGetListOfBranches.class) {
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

    public ArbainexchangeStruct$ArbaeenPostBranches getBranches(int i) {
        return (ArbainexchangeStruct$ArbaeenPostBranches) this.branches_.get(i);
    }

    public int getBranchesCount() {
        return this.branches_.size();
    }

    public List<ArbainexchangeStruct$ArbaeenPostBranches> getBranchesList() {
        return this.branches_;
    }

    public FI getBranchesOrBuilder(int i) {
        return (FI) this.branches_.get(i);
    }

    public List<? extends FI> getBranchesOrBuilderList() {
        return this.branches_;
    }

    public static a newBuilder(Arbainexchange$ResponseGetListOfBranches arbainexchange$ResponseGetListOfBranches) {
        return (a) DEFAULT_INSTANCE.createBuilder(arbainexchange$ResponseGetListOfBranches);
    }

    public static Arbainexchange$ResponseGetListOfBranches parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Arbainexchange$ResponseGetListOfBranches) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Arbainexchange$ResponseGetListOfBranches parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Arbainexchange$ResponseGetListOfBranches) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Arbainexchange$ResponseGetListOfBranches parseFrom(AbstractC2383g abstractC2383g) {
        return (Arbainexchange$ResponseGetListOfBranches) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addBranches(int i, ArbainexchangeStruct$ArbaeenPostBranches arbainexchangeStruct$ArbaeenPostBranches) {
        arbainexchangeStruct$ArbaeenPostBranches.getClass();
        ensureBranchesIsMutable();
        this.branches_.add(i, arbainexchangeStruct$ArbaeenPostBranches);
    }

    public static Arbainexchange$ResponseGetListOfBranches parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Arbainexchange$ResponseGetListOfBranches) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Arbainexchange$ResponseGetListOfBranches parseFrom(byte[] bArr) {
        return (Arbainexchange$ResponseGetListOfBranches) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Arbainexchange$ResponseGetListOfBranches parseFrom(byte[] bArr, C2394s c2394s) {
        return (Arbainexchange$ResponseGetListOfBranches) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Arbainexchange$ResponseGetListOfBranches parseFrom(InputStream inputStream) {
        return (Arbainexchange$ResponseGetListOfBranches) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Arbainexchange$ResponseGetListOfBranches parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Arbainexchange$ResponseGetListOfBranches) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Arbainexchange$ResponseGetListOfBranches parseFrom(AbstractC2384h abstractC2384h) {
        return (Arbainexchange$ResponseGetListOfBranches) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Arbainexchange$ResponseGetListOfBranches parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Arbainexchange$ResponseGetListOfBranches) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
