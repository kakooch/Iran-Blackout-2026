package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.HI;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class Arbainexchange$ResponseGetListOfStates extends GeneratedMessageLite implements U64 {
    private static final Arbainexchange$ResponseGetListOfStates DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int STATES_FIELD_NUMBER = 1;
    private B.j states_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Arbainexchange$ResponseGetListOfStates.DEFAULT_INSTANCE);
        }
    }

    static {
        Arbainexchange$ResponseGetListOfStates arbainexchange$ResponseGetListOfStates = new Arbainexchange$ResponseGetListOfStates();
        DEFAULT_INSTANCE = arbainexchange$ResponseGetListOfStates;
        GeneratedMessageLite.registerDefaultInstance(Arbainexchange$ResponseGetListOfStates.class, arbainexchange$ResponseGetListOfStates);
    }

    private Arbainexchange$ResponseGetListOfStates() {
    }

    private void addAllStates(Iterable<? extends ArbainexchangeStruct$ArbaeenPostStates> iterable) {
        ensureStatesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.states_);
    }

    private void addStates(ArbainexchangeStruct$ArbaeenPostStates arbainexchangeStruct$ArbaeenPostStates) {
        arbainexchangeStruct$ArbaeenPostStates.getClass();
        ensureStatesIsMutable();
        this.states_.add(arbainexchangeStruct$ArbaeenPostStates);
    }

    private void clearStates() {
        this.states_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureStatesIsMutable() {
        B.j jVar = this.states_;
        if (jVar.u()) {
            return;
        }
        this.states_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static Arbainexchange$ResponseGetListOfStates getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Arbainexchange$ResponseGetListOfStates parseDelimitedFrom(InputStream inputStream) {
        return (Arbainexchange$ResponseGetListOfStates) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Arbainexchange$ResponseGetListOfStates parseFrom(ByteBuffer byteBuffer) {
        return (Arbainexchange$ResponseGetListOfStates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeStates(int i) {
        ensureStatesIsMutable();
        this.states_.remove(i);
    }

    private void setStates(int i, ArbainexchangeStruct$ArbaeenPostStates arbainexchangeStruct$ArbaeenPostStates) {
        arbainexchangeStruct$ArbaeenPostStates.getClass();
        ensureStatesIsMutable();
        this.states_.set(i, arbainexchangeStruct$ArbaeenPostStates);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1861i.a[gVar.ordinal()]) {
            case 1:
                return new Arbainexchange$ResponseGetListOfStates();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"states_", ArbainexchangeStruct$ArbaeenPostStates.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Arbainexchange$ResponseGetListOfStates.class) {
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

    public ArbainexchangeStruct$ArbaeenPostStates getStates(int i) {
        return (ArbainexchangeStruct$ArbaeenPostStates) this.states_.get(i);
    }

    public int getStatesCount() {
        return this.states_.size();
    }

    public List<ArbainexchangeStruct$ArbaeenPostStates> getStatesList() {
        return this.states_;
    }

    public HI getStatesOrBuilder(int i) {
        return (HI) this.states_.get(i);
    }

    public List<? extends HI> getStatesOrBuilderList() {
        return this.states_;
    }

    public static a newBuilder(Arbainexchange$ResponseGetListOfStates arbainexchange$ResponseGetListOfStates) {
        return (a) DEFAULT_INSTANCE.createBuilder(arbainexchange$ResponseGetListOfStates);
    }

    public static Arbainexchange$ResponseGetListOfStates parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Arbainexchange$ResponseGetListOfStates) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Arbainexchange$ResponseGetListOfStates parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Arbainexchange$ResponseGetListOfStates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Arbainexchange$ResponseGetListOfStates parseFrom(AbstractC2383g abstractC2383g) {
        return (Arbainexchange$ResponseGetListOfStates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addStates(int i, ArbainexchangeStruct$ArbaeenPostStates arbainexchangeStruct$ArbaeenPostStates) {
        arbainexchangeStruct$ArbaeenPostStates.getClass();
        ensureStatesIsMutable();
        this.states_.add(i, arbainexchangeStruct$ArbaeenPostStates);
    }

    public static Arbainexchange$ResponseGetListOfStates parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Arbainexchange$ResponseGetListOfStates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Arbainexchange$ResponseGetListOfStates parseFrom(byte[] bArr) {
        return (Arbainexchange$ResponseGetListOfStates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Arbainexchange$ResponseGetListOfStates parseFrom(byte[] bArr, C2394s c2394s) {
        return (Arbainexchange$ResponseGetListOfStates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Arbainexchange$ResponseGetListOfStates parseFrom(InputStream inputStream) {
        return (Arbainexchange$ResponseGetListOfStates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Arbainexchange$ResponseGetListOfStates parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Arbainexchange$ResponseGetListOfStates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Arbainexchange$ResponseGetListOfStates parseFrom(AbstractC2384h abstractC2384h) {
        return (Arbainexchange$ResponseGetListOfStates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Arbainexchange$ResponseGetListOfStates parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Arbainexchange$ResponseGetListOfStates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
