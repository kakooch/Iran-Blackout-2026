package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC22748vl6;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class SefteOuterClass$ResponseGetStates extends GeneratedMessageLite implements U64 {
    private static final SefteOuterClass$ResponseGetStates DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int STATES_FIELD_NUMBER = 1;
    private B.j states_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SefteOuterClass$ResponseGetStates.DEFAULT_INSTANCE);
        }
    }

    static {
        SefteOuterClass$ResponseGetStates sefteOuterClass$ResponseGetStates = new SefteOuterClass$ResponseGetStates();
        DEFAULT_INSTANCE = sefteOuterClass$ResponseGetStates;
        GeneratedMessageLite.registerDefaultInstance(SefteOuterClass$ResponseGetStates.class, sefteOuterClass$ResponseGetStates);
    }

    private SefteOuterClass$ResponseGetStates() {
    }

    private void addAllStates(Iterable<? extends SefteStruct$StateInfo> iterable) {
        ensureStatesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.states_);
    }

    private void addStates(SefteStruct$StateInfo sefteStruct$StateInfo) {
        sefteStruct$StateInfo.getClass();
        ensureStatesIsMutable();
        this.states_.add(sefteStruct$StateInfo);
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

    public static SefteOuterClass$ResponseGetStates getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SefteOuterClass$ResponseGetStates parseDelimitedFrom(InputStream inputStream) {
        return (SefteOuterClass$ResponseGetStates) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SefteOuterClass$ResponseGetStates parseFrom(ByteBuffer byteBuffer) {
        return (SefteOuterClass$ResponseGetStates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeStates(int i) {
        ensureStatesIsMutable();
        this.states_.remove(i);
    }

    private void setStates(int i, SefteStruct$StateInfo sefteStruct$StateInfo) {
        sefteStruct$StateInfo.getClass();
        ensureStatesIsMutable();
        this.states_.set(i, sefteStruct$StateInfo);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (P1.a[gVar.ordinal()]) {
            case 1:
                return new SefteOuterClass$ResponseGetStates();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"states_", SefteStruct$StateInfo.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SefteOuterClass$ResponseGetStates.class) {
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

    public SefteStruct$StateInfo getStates(int i) {
        return (SefteStruct$StateInfo) this.states_.get(i);
    }

    public int getStatesCount() {
        return this.states_.size();
    }

    public List<SefteStruct$StateInfo> getStatesList() {
        return this.states_;
    }

    public InterfaceC22748vl6 getStatesOrBuilder(int i) {
        return (InterfaceC22748vl6) this.states_.get(i);
    }

    public List<? extends InterfaceC22748vl6> getStatesOrBuilderList() {
        return this.states_;
    }

    public static a newBuilder(SefteOuterClass$ResponseGetStates sefteOuterClass$ResponseGetStates) {
        return (a) DEFAULT_INSTANCE.createBuilder(sefteOuterClass$ResponseGetStates);
    }

    public static SefteOuterClass$ResponseGetStates parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SefteOuterClass$ResponseGetStates) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SefteOuterClass$ResponseGetStates parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SefteOuterClass$ResponseGetStates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SefteOuterClass$ResponseGetStates parseFrom(AbstractC2383g abstractC2383g) {
        return (SefteOuterClass$ResponseGetStates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addStates(int i, SefteStruct$StateInfo sefteStruct$StateInfo) {
        sefteStruct$StateInfo.getClass();
        ensureStatesIsMutable();
        this.states_.add(i, sefteStruct$StateInfo);
    }

    public static SefteOuterClass$ResponseGetStates parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SefteOuterClass$ResponseGetStates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SefteOuterClass$ResponseGetStates parseFrom(byte[] bArr) {
        return (SefteOuterClass$ResponseGetStates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SefteOuterClass$ResponseGetStates parseFrom(byte[] bArr, C2394s c2394s) {
        return (SefteOuterClass$ResponseGetStates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SefteOuterClass$ResponseGetStates parseFrom(InputStream inputStream) {
        return (SefteOuterClass$ResponseGetStates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SefteOuterClass$ResponseGetStates parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SefteOuterClass$ResponseGetStates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SefteOuterClass$ResponseGetStates parseFrom(AbstractC2384h abstractC2384h) {
        return (SefteOuterClass$ResponseGetStates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SefteOuterClass$ResponseGetStates parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SefteOuterClass$ResponseGetStates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
