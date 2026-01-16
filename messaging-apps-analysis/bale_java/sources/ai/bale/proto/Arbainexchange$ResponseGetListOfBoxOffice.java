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
public final class Arbainexchange$ResponseGetListOfBoxOffice extends GeneratedMessageLite implements U64 {
    public static final int BOX_OFFICE_FIELD_NUMBER = 1;
    private static final Arbainexchange$ResponseGetListOfBoxOffice DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private B.j boxOffice_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Arbainexchange$ResponseGetListOfBoxOffice.DEFAULT_INSTANCE);
        }
    }

    static {
        Arbainexchange$ResponseGetListOfBoxOffice arbainexchange$ResponseGetListOfBoxOffice = new Arbainexchange$ResponseGetListOfBoxOffice();
        DEFAULT_INSTANCE = arbainexchange$ResponseGetListOfBoxOffice;
        GeneratedMessageLite.registerDefaultInstance(Arbainexchange$ResponseGetListOfBoxOffice.class, arbainexchange$ResponseGetListOfBoxOffice);
    }

    private Arbainexchange$ResponseGetListOfBoxOffice() {
    }

    private void addAllBoxOffice(Iterable<? extends ArbainexchangeStruct$ArbaeenPostBranches> iterable) {
        ensureBoxOfficeIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.boxOffice_);
    }

    private void addBoxOffice(ArbainexchangeStruct$ArbaeenPostBranches arbainexchangeStruct$ArbaeenPostBranches) {
        arbainexchangeStruct$ArbaeenPostBranches.getClass();
        ensureBoxOfficeIsMutable();
        this.boxOffice_.add(arbainexchangeStruct$ArbaeenPostBranches);
    }

    private void clearBoxOffice() {
        this.boxOffice_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureBoxOfficeIsMutable() {
        B.j jVar = this.boxOffice_;
        if (jVar.u()) {
            return;
        }
        this.boxOffice_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static Arbainexchange$ResponseGetListOfBoxOffice getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Arbainexchange$ResponseGetListOfBoxOffice parseDelimitedFrom(InputStream inputStream) {
        return (Arbainexchange$ResponseGetListOfBoxOffice) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Arbainexchange$ResponseGetListOfBoxOffice parseFrom(ByteBuffer byteBuffer) {
        return (Arbainexchange$ResponseGetListOfBoxOffice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeBoxOffice(int i) {
        ensureBoxOfficeIsMutable();
        this.boxOffice_.remove(i);
    }

    private void setBoxOffice(int i, ArbainexchangeStruct$ArbaeenPostBranches arbainexchangeStruct$ArbaeenPostBranches) {
        arbainexchangeStruct$ArbaeenPostBranches.getClass();
        ensureBoxOfficeIsMutable();
        this.boxOffice_.set(i, arbainexchangeStruct$ArbaeenPostBranches);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1861i.a[gVar.ordinal()]) {
            case 1:
                return new Arbainexchange$ResponseGetListOfBoxOffice();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"boxOffice_", ArbainexchangeStruct$ArbaeenPostBranches.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Arbainexchange$ResponseGetListOfBoxOffice.class) {
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

    public ArbainexchangeStruct$ArbaeenPostBranches getBoxOffice(int i) {
        return (ArbainexchangeStruct$ArbaeenPostBranches) this.boxOffice_.get(i);
    }

    public int getBoxOfficeCount() {
        return this.boxOffice_.size();
    }

    public List<ArbainexchangeStruct$ArbaeenPostBranches> getBoxOfficeList() {
        return this.boxOffice_;
    }

    public FI getBoxOfficeOrBuilder(int i) {
        return (FI) this.boxOffice_.get(i);
    }

    public List<? extends FI> getBoxOfficeOrBuilderList() {
        return this.boxOffice_;
    }

    public static a newBuilder(Arbainexchange$ResponseGetListOfBoxOffice arbainexchange$ResponseGetListOfBoxOffice) {
        return (a) DEFAULT_INSTANCE.createBuilder(arbainexchange$ResponseGetListOfBoxOffice);
    }

    public static Arbainexchange$ResponseGetListOfBoxOffice parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Arbainexchange$ResponseGetListOfBoxOffice) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Arbainexchange$ResponseGetListOfBoxOffice parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Arbainexchange$ResponseGetListOfBoxOffice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Arbainexchange$ResponseGetListOfBoxOffice parseFrom(AbstractC2383g abstractC2383g) {
        return (Arbainexchange$ResponseGetListOfBoxOffice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addBoxOffice(int i, ArbainexchangeStruct$ArbaeenPostBranches arbainexchangeStruct$ArbaeenPostBranches) {
        arbainexchangeStruct$ArbaeenPostBranches.getClass();
        ensureBoxOfficeIsMutable();
        this.boxOffice_.add(i, arbainexchangeStruct$ArbaeenPostBranches);
    }

    public static Arbainexchange$ResponseGetListOfBoxOffice parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Arbainexchange$ResponseGetListOfBoxOffice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Arbainexchange$ResponseGetListOfBoxOffice parseFrom(byte[] bArr) {
        return (Arbainexchange$ResponseGetListOfBoxOffice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Arbainexchange$ResponseGetListOfBoxOffice parseFrom(byte[] bArr, C2394s c2394s) {
        return (Arbainexchange$ResponseGetListOfBoxOffice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Arbainexchange$ResponseGetListOfBoxOffice parseFrom(InputStream inputStream) {
        return (Arbainexchange$ResponseGetListOfBoxOffice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Arbainexchange$ResponseGetListOfBoxOffice parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Arbainexchange$ResponseGetListOfBoxOffice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Arbainexchange$ResponseGetListOfBoxOffice parseFrom(AbstractC2384h abstractC2384h) {
        return (Arbainexchange$ResponseGetListOfBoxOffice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Arbainexchange$ResponseGetListOfBoxOffice parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Arbainexchange$ResponseGetListOfBoxOffice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
