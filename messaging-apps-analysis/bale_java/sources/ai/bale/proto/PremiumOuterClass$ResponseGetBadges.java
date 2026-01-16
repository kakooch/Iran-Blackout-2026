package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC24543yn5;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class PremiumOuterClass$ResponseGetBadges extends GeneratedMessageLite implements U64 {
    public static final int CATEGORIES_FIELD_NUMBER = 1;
    private static final PremiumOuterClass$ResponseGetBadges DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private B.j categories_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PremiumOuterClass$ResponseGetBadges.DEFAULT_INSTANCE);
        }
    }

    static {
        PremiumOuterClass$ResponseGetBadges premiumOuterClass$ResponseGetBadges = new PremiumOuterClass$ResponseGetBadges();
        DEFAULT_INSTANCE = premiumOuterClass$ResponseGetBadges;
        GeneratedMessageLite.registerDefaultInstance(PremiumOuterClass$ResponseGetBadges.class, premiumOuterClass$ResponseGetBadges);
    }

    private PremiumOuterClass$ResponseGetBadges() {
    }

    private void addAllCategories(Iterable<? extends PremiumStruct$BadgeCategory> iterable) {
        ensureCategoriesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.categories_);
    }

    private void addCategories(PremiumStruct$BadgeCategory premiumStruct$BadgeCategory) {
        premiumStruct$BadgeCategory.getClass();
        ensureCategoriesIsMutable();
        this.categories_.add(premiumStruct$BadgeCategory);
    }

    private void clearCategories() {
        this.categories_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureCategoriesIsMutable() {
        B.j jVar = this.categories_;
        if (jVar.u()) {
            return;
        }
        this.categories_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static PremiumOuterClass$ResponseGetBadges getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PremiumOuterClass$ResponseGetBadges parseDelimitedFrom(InputStream inputStream) {
        return (PremiumOuterClass$ResponseGetBadges) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PremiumOuterClass$ResponseGetBadges parseFrom(ByteBuffer byteBuffer) {
        return (PremiumOuterClass$ResponseGetBadges) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeCategories(int i) {
        ensureCategoriesIsMutable();
        this.categories_.remove(i);
    }

    private void setCategories(int i, PremiumStruct$BadgeCategory premiumStruct$BadgeCategory) {
        premiumStruct$BadgeCategory.getClass();
        ensureCategoriesIsMutable();
        this.categories_.set(i, premiumStruct$BadgeCategory);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1860h1.a[gVar.ordinal()]) {
            case 1:
                return new PremiumOuterClass$ResponseGetBadges();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"categories_", PremiumStruct$BadgeCategory.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PremiumOuterClass$ResponseGetBadges.class) {
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

    public PremiumStruct$BadgeCategory getCategories(int i) {
        return (PremiumStruct$BadgeCategory) this.categories_.get(i);
    }

    public int getCategoriesCount() {
        return this.categories_.size();
    }

    public List<PremiumStruct$BadgeCategory> getCategoriesList() {
        return this.categories_;
    }

    public InterfaceC24543yn5 getCategoriesOrBuilder(int i) {
        return (InterfaceC24543yn5) this.categories_.get(i);
    }

    public List<? extends InterfaceC24543yn5> getCategoriesOrBuilderList() {
        return this.categories_;
    }

    public static a newBuilder(PremiumOuterClass$ResponseGetBadges premiumOuterClass$ResponseGetBadges) {
        return (a) DEFAULT_INSTANCE.createBuilder(premiumOuterClass$ResponseGetBadges);
    }

    public static PremiumOuterClass$ResponseGetBadges parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PremiumOuterClass$ResponseGetBadges) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PremiumOuterClass$ResponseGetBadges parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PremiumOuterClass$ResponseGetBadges) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PremiumOuterClass$ResponseGetBadges parseFrom(AbstractC2383g abstractC2383g) {
        return (PremiumOuterClass$ResponseGetBadges) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addCategories(int i, PremiumStruct$BadgeCategory premiumStruct$BadgeCategory) {
        premiumStruct$BadgeCategory.getClass();
        ensureCategoriesIsMutable();
        this.categories_.add(i, premiumStruct$BadgeCategory);
    }

    public static PremiumOuterClass$ResponseGetBadges parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PremiumOuterClass$ResponseGetBadges) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PremiumOuterClass$ResponseGetBadges parseFrom(byte[] bArr) {
        return (PremiumOuterClass$ResponseGetBadges) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PremiumOuterClass$ResponseGetBadges parseFrom(byte[] bArr, C2394s c2394s) {
        return (PremiumOuterClass$ResponseGetBadges) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PremiumOuterClass$ResponseGetBadges parseFrom(InputStream inputStream) {
        return (PremiumOuterClass$ResponseGetBadges) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PremiumOuterClass$ResponseGetBadges parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PremiumOuterClass$ResponseGetBadges) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PremiumOuterClass$ResponseGetBadges parseFrom(AbstractC2384h abstractC2384h) {
        return (PremiumOuterClass$ResponseGetBadges) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PremiumOuterClass$ResponseGetBadges parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PremiumOuterClass$ResponseGetBadges) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
