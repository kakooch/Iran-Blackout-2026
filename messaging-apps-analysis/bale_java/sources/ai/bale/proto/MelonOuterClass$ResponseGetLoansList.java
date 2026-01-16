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
public final class MelonOuterClass$ResponseGetLoansList extends GeneratedMessageLite implements U64 {
    private static final MelonOuterClass$ResponseGetLoansList DEFAULT_INSTANCE;
    public static final int LIST_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j list_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MelonOuterClass$ResponseGetLoansList.DEFAULT_INSTANCE);
        }
    }

    static {
        MelonOuterClass$ResponseGetLoansList melonOuterClass$ResponseGetLoansList = new MelonOuterClass$ResponseGetLoansList();
        DEFAULT_INSTANCE = melonOuterClass$ResponseGetLoansList;
        GeneratedMessageLite.registerDefaultInstance(MelonOuterClass$ResponseGetLoansList.class, melonOuterClass$ResponseGetLoansList);
    }

    private MelonOuterClass$ResponseGetLoansList() {
    }

    private void addAllList(Iterable<? extends MelonStruct$Loan> iterable) {
        ensureListIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.list_);
    }

    private void addList(MelonStruct$Loan melonStruct$Loan) {
        melonStruct$Loan.getClass();
        ensureListIsMutable();
        this.list_.add(melonStruct$Loan);
    }

    private void clearList() {
        this.list_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureListIsMutable() {
        B.j jVar = this.list_;
        if (jVar.u()) {
            return;
        }
        this.list_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MelonOuterClass$ResponseGetLoansList getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MelonOuterClass$ResponseGetLoansList parseDelimitedFrom(InputStream inputStream) {
        return (MelonOuterClass$ResponseGetLoansList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MelonOuterClass$ResponseGetLoansList parseFrom(ByteBuffer byteBuffer) {
        return (MelonOuterClass$ResponseGetLoansList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeList(int i) {
        ensureListIsMutable();
        this.list_.remove(i);
    }

    private void setList(int i, MelonStruct$Loan melonStruct$Loan) {
        melonStruct$Loan.getClass();
        ensureListIsMutable();
        this.list_.set(i, melonStruct$Loan);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (I0.a[gVar.ordinal()]) {
            case 1:
                return new MelonOuterClass$ResponseGetLoansList();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"list_", MelonStruct$Loan.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MelonOuterClass$ResponseGetLoansList.class) {
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

    public MelonStruct$Loan getList(int i) {
        return (MelonStruct$Loan) this.list_.get(i);
    }

    public int getListCount() {
        return this.list_.size();
    }

    public List<MelonStruct$Loan> getListList() {
        return this.list_;
    }

    public N14 getListOrBuilder(int i) {
        return (N14) this.list_.get(i);
    }

    public List<? extends N14> getListOrBuilderList() {
        return this.list_;
    }

    public static a newBuilder(MelonOuterClass$ResponseGetLoansList melonOuterClass$ResponseGetLoansList) {
        return (a) DEFAULT_INSTANCE.createBuilder(melonOuterClass$ResponseGetLoansList);
    }

    public static MelonOuterClass$ResponseGetLoansList parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MelonOuterClass$ResponseGetLoansList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MelonOuterClass$ResponseGetLoansList parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MelonOuterClass$ResponseGetLoansList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MelonOuterClass$ResponseGetLoansList parseFrom(AbstractC2383g abstractC2383g) {
        return (MelonOuterClass$ResponseGetLoansList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addList(int i, MelonStruct$Loan melonStruct$Loan) {
        melonStruct$Loan.getClass();
        ensureListIsMutable();
        this.list_.add(i, melonStruct$Loan);
    }

    public static MelonOuterClass$ResponseGetLoansList parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MelonOuterClass$ResponseGetLoansList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MelonOuterClass$ResponseGetLoansList parseFrom(byte[] bArr) {
        return (MelonOuterClass$ResponseGetLoansList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MelonOuterClass$ResponseGetLoansList parseFrom(byte[] bArr, C2394s c2394s) {
        return (MelonOuterClass$ResponseGetLoansList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MelonOuterClass$ResponseGetLoansList parseFrom(InputStream inputStream) {
        return (MelonOuterClass$ResponseGetLoansList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MelonOuterClass$ResponseGetLoansList parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MelonOuterClass$ResponseGetLoansList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MelonOuterClass$ResponseGetLoansList parseFrom(AbstractC2384h abstractC2384h) {
        return (MelonOuterClass$ResponseGetLoansList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MelonOuterClass$ResponseGetLoansList parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MelonOuterClass$ResponseGetLoansList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
