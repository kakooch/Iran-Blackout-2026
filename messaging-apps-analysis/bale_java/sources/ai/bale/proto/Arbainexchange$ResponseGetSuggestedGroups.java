package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.LI;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class Arbainexchange$ResponseGetSuggestedGroups extends GeneratedMessageLite implements U64 {
    private static final Arbainexchange$ResponseGetSuggestedGroups DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int SUGGESTED_GROUPS_FIELD_NUMBER = 1;
    private B.j suggestedGroups_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Arbainexchange$ResponseGetSuggestedGroups.DEFAULT_INSTANCE);
        }
    }

    static {
        Arbainexchange$ResponseGetSuggestedGroups arbainexchange$ResponseGetSuggestedGroups = new Arbainexchange$ResponseGetSuggestedGroups();
        DEFAULT_INSTANCE = arbainexchange$ResponseGetSuggestedGroups;
        GeneratedMessageLite.registerDefaultInstance(Arbainexchange$ResponseGetSuggestedGroups.class, arbainexchange$ResponseGetSuggestedGroups);
    }

    private Arbainexchange$ResponseGetSuggestedGroups() {
    }

    private void addAllSuggestedGroups(Iterable<? extends ArbainexchangeStruct$ArbaeenSuggestedGroups> iterable) {
        ensureSuggestedGroupsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.suggestedGroups_);
    }

    private void addSuggestedGroups(ArbainexchangeStruct$ArbaeenSuggestedGroups arbainexchangeStruct$ArbaeenSuggestedGroups) {
        arbainexchangeStruct$ArbaeenSuggestedGroups.getClass();
        ensureSuggestedGroupsIsMutable();
        this.suggestedGroups_.add(arbainexchangeStruct$ArbaeenSuggestedGroups);
    }

    private void clearSuggestedGroups() {
        this.suggestedGroups_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureSuggestedGroupsIsMutable() {
        B.j jVar = this.suggestedGroups_;
        if (jVar.u()) {
            return;
        }
        this.suggestedGroups_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static Arbainexchange$ResponseGetSuggestedGroups getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Arbainexchange$ResponseGetSuggestedGroups parseDelimitedFrom(InputStream inputStream) {
        return (Arbainexchange$ResponseGetSuggestedGroups) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Arbainexchange$ResponseGetSuggestedGroups parseFrom(ByteBuffer byteBuffer) {
        return (Arbainexchange$ResponseGetSuggestedGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeSuggestedGroups(int i) {
        ensureSuggestedGroupsIsMutable();
        this.suggestedGroups_.remove(i);
    }

    private void setSuggestedGroups(int i, ArbainexchangeStruct$ArbaeenSuggestedGroups arbainexchangeStruct$ArbaeenSuggestedGroups) {
        arbainexchangeStruct$ArbaeenSuggestedGroups.getClass();
        ensureSuggestedGroupsIsMutable();
        this.suggestedGroups_.set(i, arbainexchangeStruct$ArbaeenSuggestedGroups);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1861i.a[gVar.ordinal()]) {
            case 1:
                return new Arbainexchange$ResponseGetSuggestedGroups();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"suggestedGroups_", ArbainexchangeStruct$ArbaeenSuggestedGroups.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Arbainexchange$ResponseGetSuggestedGroups.class) {
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

    public ArbainexchangeStruct$ArbaeenSuggestedGroups getSuggestedGroups(int i) {
        return (ArbainexchangeStruct$ArbaeenSuggestedGroups) this.suggestedGroups_.get(i);
    }

    public int getSuggestedGroupsCount() {
        return this.suggestedGroups_.size();
    }

    public List<ArbainexchangeStruct$ArbaeenSuggestedGroups> getSuggestedGroupsList() {
        return this.suggestedGroups_;
    }

    public LI getSuggestedGroupsOrBuilder(int i) {
        return (LI) this.suggestedGroups_.get(i);
    }

    public List<? extends LI> getSuggestedGroupsOrBuilderList() {
        return this.suggestedGroups_;
    }

    public static a newBuilder(Arbainexchange$ResponseGetSuggestedGroups arbainexchange$ResponseGetSuggestedGroups) {
        return (a) DEFAULT_INSTANCE.createBuilder(arbainexchange$ResponseGetSuggestedGroups);
    }

    public static Arbainexchange$ResponseGetSuggestedGroups parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Arbainexchange$ResponseGetSuggestedGroups) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Arbainexchange$ResponseGetSuggestedGroups parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Arbainexchange$ResponseGetSuggestedGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Arbainexchange$ResponseGetSuggestedGroups parseFrom(AbstractC2383g abstractC2383g) {
        return (Arbainexchange$ResponseGetSuggestedGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addSuggestedGroups(int i, ArbainexchangeStruct$ArbaeenSuggestedGroups arbainexchangeStruct$ArbaeenSuggestedGroups) {
        arbainexchangeStruct$ArbaeenSuggestedGroups.getClass();
        ensureSuggestedGroupsIsMutable();
        this.suggestedGroups_.add(i, arbainexchangeStruct$ArbaeenSuggestedGroups);
    }

    public static Arbainexchange$ResponseGetSuggestedGroups parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Arbainexchange$ResponseGetSuggestedGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Arbainexchange$ResponseGetSuggestedGroups parseFrom(byte[] bArr) {
        return (Arbainexchange$ResponseGetSuggestedGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Arbainexchange$ResponseGetSuggestedGroups parseFrom(byte[] bArr, C2394s c2394s) {
        return (Arbainexchange$ResponseGetSuggestedGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Arbainexchange$ResponseGetSuggestedGroups parseFrom(InputStream inputStream) {
        return (Arbainexchange$ResponseGetSuggestedGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Arbainexchange$ResponseGetSuggestedGroups parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Arbainexchange$ResponseGetSuggestedGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Arbainexchange$ResponseGetSuggestedGroups parseFrom(AbstractC2384h abstractC2384h) {
        return (Arbainexchange$ResponseGetSuggestedGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Arbainexchange$ResponseGetSuggestedGroups parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Arbainexchange$ResponseGetSuggestedGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
