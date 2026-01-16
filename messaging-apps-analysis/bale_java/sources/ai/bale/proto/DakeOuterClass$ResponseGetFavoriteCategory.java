package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC3692By1;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes9.dex */
public final class DakeOuterClass$ResponseGetFavoriteCategory extends GeneratedMessageLite implements U64 {
    public static final int CATEGORY_FIELD_NUMBER = 1;
    private static final DakeOuterClass$ResponseGetFavoriteCategory DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private static final B.h.a category_converter_ = new a();
    private int categoryMemoizedSerializedSize;
    private B.g category_ = GeneratedMessageLite.emptyIntList();

    class a implements B.h.a {
        a() {
        }

        @Override // com.google.protobuf.B.h.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC3692By1 a(Integer num) {
            EnumC3692By1 enumC3692By1J = EnumC3692By1.j(num.intValue());
            return enumC3692By1J == null ? EnumC3692By1.UNRECOGNIZED : enumC3692By1J;
        }
    }

    public static final class b extends GeneratedMessageLite.b implements U64 {
        private b() {
            super(DakeOuterClass$ResponseGetFavoriteCategory.DEFAULT_INSTANCE);
        }
    }

    static {
        DakeOuterClass$ResponseGetFavoriteCategory dakeOuterClass$ResponseGetFavoriteCategory = new DakeOuterClass$ResponseGetFavoriteCategory();
        DEFAULT_INSTANCE = dakeOuterClass$ResponseGetFavoriteCategory;
        GeneratedMessageLite.registerDefaultInstance(DakeOuterClass$ResponseGetFavoriteCategory.class, dakeOuterClass$ResponseGetFavoriteCategory);
    }

    private DakeOuterClass$ResponseGetFavoriteCategory() {
    }

    private void addAllCategory(Iterable<? extends EnumC3692By1> iterable) {
        ensureCategoryIsMutable();
        Iterator<? extends EnumC3692By1> it = iterable.iterator();
        while (it.hasNext()) {
            this.category_.b1(it.next().getNumber());
        }
    }

    private void addAllCategoryValue(Iterable<Integer> iterable) {
        ensureCategoryIsMutable();
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext()) {
            this.category_.b1(it.next().intValue());
        }
    }

    private void addCategory(EnumC3692By1 enumC3692By1) {
        enumC3692By1.getClass();
        ensureCategoryIsMutable();
        this.category_.b1(enumC3692By1.getNumber());
    }

    private void addCategoryValue(int i) {
        ensureCategoryIsMutable();
        this.category_.b1(i);
    }

    private void clearCategory() {
        this.category_ = GeneratedMessageLite.emptyIntList();
    }

    private void ensureCategoryIsMutable() {
        B.g gVar = this.category_;
        if (gVar.u()) {
            return;
        }
        this.category_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    public static DakeOuterClass$ResponseGetFavoriteCategory getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static DakeOuterClass$ResponseGetFavoriteCategory parseDelimitedFrom(InputStream inputStream) {
        return (DakeOuterClass$ResponseGetFavoriteCategory) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DakeOuterClass$ResponseGetFavoriteCategory parseFrom(ByteBuffer byteBuffer) {
        return (DakeOuterClass$ResponseGetFavoriteCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCategory(int i, EnumC3692By1 enumC3692By1) {
        enumC3692By1.getClass();
        ensureCategoryIsMutable();
        this.category_.U(i, enumC3692By1.getNumber());
    }

    private void setCategoryValue(int i, int i2) {
        ensureCategoryIsMutable();
        this.category_.U(i, i2);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (M.a[gVar.ordinal()]) {
            case 1:
                return new DakeOuterClass$ResponseGetFavoriteCategory();
            case 2:
                return new b();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001,", new Object[]{"category_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (DakeOuterClass$ResponseGetFavoriteCategory.class) {
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

    public EnumC3692By1 getCategory(int i) {
        EnumC3692By1 enumC3692By1J = EnumC3692By1.j(this.category_.getInt(i));
        return enumC3692By1J == null ? EnumC3692By1.UNRECOGNIZED : enumC3692By1J;
    }

    public int getCategoryCount() {
        return this.category_.size();
    }

    public List<EnumC3692By1> getCategoryList() {
        return new B.h(this.category_, category_converter_);
    }

    public int getCategoryValue(int i) {
        return this.category_.getInt(i);
    }

    public List<Integer> getCategoryValueList() {
        return this.category_;
    }

    public static b newBuilder(DakeOuterClass$ResponseGetFavoriteCategory dakeOuterClass$ResponseGetFavoriteCategory) {
        return (b) DEFAULT_INSTANCE.createBuilder(dakeOuterClass$ResponseGetFavoriteCategory);
    }

    public static DakeOuterClass$ResponseGetFavoriteCategory parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (DakeOuterClass$ResponseGetFavoriteCategory) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static DakeOuterClass$ResponseGetFavoriteCategory parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (DakeOuterClass$ResponseGetFavoriteCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static DakeOuterClass$ResponseGetFavoriteCategory parseFrom(AbstractC2383g abstractC2383g) {
        return (DakeOuterClass$ResponseGetFavoriteCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static DakeOuterClass$ResponseGetFavoriteCategory parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (DakeOuterClass$ResponseGetFavoriteCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static DakeOuterClass$ResponseGetFavoriteCategory parseFrom(byte[] bArr) {
        return (DakeOuterClass$ResponseGetFavoriteCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static DakeOuterClass$ResponseGetFavoriteCategory parseFrom(byte[] bArr, C2394s c2394s) {
        return (DakeOuterClass$ResponseGetFavoriteCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static DakeOuterClass$ResponseGetFavoriteCategory parseFrom(InputStream inputStream) {
        return (DakeOuterClass$ResponseGetFavoriteCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DakeOuterClass$ResponseGetFavoriteCategory parseFrom(InputStream inputStream, C2394s c2394s) {
        return (DakeOuterClass$ResponseGetFavoriteCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static DakeOuterClass$ResponseGetFavoriteCategory parseFrom(AbstractC2384h abstractC2384h) {
        return (DakeOuterClass$ResponseGetFavoriteCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static DakeOuterClass$ResponseGetFavoriteCategory parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (DakeOuterClass$ResponseGetFavoriteCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
