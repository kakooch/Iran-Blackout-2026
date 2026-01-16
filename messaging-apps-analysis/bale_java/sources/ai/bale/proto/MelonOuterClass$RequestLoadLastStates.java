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
public final class MelonOuterClass$RequestLoadLastStates extends GeneratedMessageLite implements U64 {
    public static final int CONTRACT_IDS_FIELD_NUMBER = 1;
    private static final MelonOuterClass$RequestLoadLastStates DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private B.j contractIds_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MelonOuterClass$RequestLoadLastStates.DEFAULT_INSTANCE);
        }
    }

    static {
        MelonOuterClass$RequestLoadLastStates melonOuterClass$RequestLoadLastStates = new MelonOuterClass$RequestLoadLastStates();
        DEFAULT_INSTANCE = melonOuterClass$RequestLoadLastStates;
        GeneratedMessageLite.registerDefaultInstance(MelonOuterClass$RequestLoadLastStates.class, melonOuterClass$RequestLoadLastStates);
    }

    private MelonOuterClass$RequestLoadLastStates() {
    }

    private void addAllContractIds(Iterable<String> iterable) {
        ensureContractIdsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.contractIds_);
    }

    private void addContractIds(String str) {
        str.getClass();
        ensureContractIdsIsMutable();
        this.contractIds_.add(str);
    }

    private void addContractIdsBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        ensureContractIdsIsMutable();
        this.contractIds_.add(abstractC2383g.f0());
    }

    private void clearContractIds() {
        this.contractIds_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureContractIdsIsMutable() {
        B.j jVar = this.contractIds_;
        if (jVar.u()) {
            return;
        }
        this.contractIds_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MelonOuterClass$RequestLoadLastStates getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MelonOuterClass$RequestLoadLastStates parseDelimitedFrom(InputStream inputStream) {
        return (MelonOuterClass$RequestLoadLastStates) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MelonOuterClass$RequestLoadLastStates parseFrom(ByteBuffer byteBuffer) {
        return (MelonOuterClass$RequestLoadLastStates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setContractIds(int i, String str) {
        str.getClass();
        ensureContractIdsIsMutable();
        this.contractIds_.set(i, str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (I0.a[gVar.ordinal()]) {
            case 1:
                return new MelonOuterClass$RequestLoadLastStates();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001Ț", new Object[]{"contractIds_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MelonOuterClass$RequestLoadLastStates.class) {
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

    public String getContractIds(int i) {
        return (String) this.contractIds_.get(i);
    }

    public AbstractC2383g getContractIdsBytes(int i) {
        return AbstractC2383g.N((String) this.contractIds_.get(i));
    }

    public int getContractIdsCount() {
        return this.contractIds_.size();
    }

    public List<String> getContractIdsList() {
        return this.contractIds_;
    }

    public static a newBuilder(MelonOuterClass$RequestLoadLastStates melonOuterClass$RequestLoadLastStates) {
        return (a) DEFAULT_INSTANCE.createBuilder(melonOuterClass$RequestLoadLastStates);
    }

    public static MelonOuterClass$RequestLoadLastStates parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MelonOuterClass$RequestLoadLastStates) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MelonOuterClass$RequestLoadLastStates parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MelonOuterClass$RequestLoadLastStates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MelonOuterClass$RequestLoadLastStates parseFrom(AbstractC2383g abstractC2383g) {
        return (MelonOuterClass$RequestLoadLastStates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MelonOuterClass$RequestLoadLastStates parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MelonOuterClass$RequestLoadLastStates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MelonOuterClass$RequestLoadLastStates parseFrom(byte[] bArr) {
        return (MelonOuterClass$RequestLoadLastStates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MelonOuterClass$RequestLoadLastStates parseFrom(byte[] bArr, C2394s c2394s) {
        return (MelonOuterClass$RequestLoadLastStates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MelonOuterClass$RequestLoadLastStates parseFrom(InputStream inputStream) {
        return (MelonOuterClass$RequestLoadLastStates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MelonOuterClass$RequestLoadLastStates parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MelonOuterClass$RequestLoadLastStates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MelonOuterClass$RequestLoadLastStates parseFrom(AbstractC2384h abstractC2384h) {
        return (MelonOuterClass$RequestLoadLastStates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MelonOuterClass$RequestLoadLastStates parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MelonOuterClass$RequestLoadLastStates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
