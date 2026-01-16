package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import ir.nasim.YK0;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes9.dex */
public final class Charnet$RequestGetRecentChargeOrders extends GeneratedMessageLite implements U64 {
    public static final int COUNT_FIELD_NUMBER = 1;
    private static final Charnet$RequestGetRecentChargeOrders DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TYPES_FIELD_NUMBER = 2;
    private static final B.h.a types_converter_ = new a();
    private int count_;
    private int typesMemoizedSerializedSize;
    private B.g types_ = GeneratedMessageLite.emptyIntList();

    class a implements B.h.a {
        a() {
        }

        @Override // com.google.protobuf.B.h.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public YK0 a(Integer num) {
            YK0 yk0J = YK0.j(num.intValue());
            return yk0J == null ? YK0.UNRECOGNIZED : yk0J;
        }
    }

    public static final class b extends GeneratedMessageLite.b implements U64 {
        private b() {
            super(Charnet$RequestGetRecentChargeOrders.DEFAULT_INSTANCE);
        }
    }

    static {
        Charnet$RequestGetRecentChargeOrders charnet$RequestGetRecentChargeOrders = new Charnet$RequestGetRecentChargeOrders();
        DEFAULT_INSTANCE = charnet$RequestGetRecentChargeOrders;
        GeneratedMessageLite.registerDefaultInstance(Charnet$RequestGetRecentChargeOrders.class, charnet$RequestGetRecentChargeOrders);
    }

    private Charnet$RequestGetRecentChargeOrders() {
    }

    private void addAllTypes(Iterable<? extends YK0> iterable) {
        ensureTypesIsMutable();
        Iterator<? extends YK0> it = iterable.iterator();
        while (it.hasNext()) {
            this.types_.b1(it.next().getNumber());
        }
    }

    private void addAllTypesValue(Iterable<Integer> iterable) {
        ensureTypesIsMutable();
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext()) {
            this.types_.b1(it.next().intValue());
        }
    }

    private void addTypes(YK0 yk0) {
        yk0.getClass();
        ensureTypesIsMutable();
        this.types_.b1(yk0.getNumber());
    }

    private void addTypesValue(int i) {
        ensureTypesIsMutable();
        this.types_.b1(i);
    }

    private void clearCount() {
        this.count_ = 0;
    }

    private void clearTypes() {
        this.types_ = GeneratedMessageLite.emptyIntList();
    }

    private void ensureTypesIsMutable() {
        B.g gVar = this.types_;
        if (gVar.u()) {
            return;
        }
        this.types_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    public static Charnet$RequestGetRecentChargeOrders getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static Charnet$RequestGetRecentChargeOrders parseDelimitedFrom(InputStream inputStream) {
        return (Charnet$RequestGetRecentChargeOrders) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Charnet$RequestGetRecentChargeOrders parseFrom(ByteBuffer byteBuffer) {
        return (Charnet$RequestGetRecentChargeOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCount(int i) {
        this.count_ = i;
    }

    private void setTypes(int i, YK0 yk0) {
        yk0.getClass();
        ensureTypesIsMutable();
        this.types_.U(i, yk0.getNumber());
    }

    private void setTypesValue(int i, int i2) {
        ensureTypesIsMutable();
        this.types_.U(i, i2);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1911z.a[gVar.ordinal()]) {
            case 1:
                return new Charnet$RequestGetRecentChargeOrders();
            case 2:
                return new b();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u0004\u0002,", new Object[]{"count_", "types_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Charnet$RequestGetRecentChargeOrders.class) {
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

    public int getCount() {
        return this.count_;
    }

    public YK0 getTypes(int i) {
        YK0 yk0J = YK0.j(this.types_.getInt(i));
        return yk0J == null ? YK0.UNRECOGNIZED : yk0J;
    }

    public int getTypesCount() {
        return this.types_.size();
    }

    public List<YK0> getTypesList() {
        return new B.h(this.types_, types_converter_);
    }

    public int getTypesValue(int i) {
        return this.types_.getInt(i);
    }

    public List<Integer> getTypesValueList() {
        return this.types_;
    }

    public static b newBuilder(Charnet$RequestGetRecentChargeOrders charnet$RequestGetRecentChargeOrders) {
        return (b) DEFAULT_INSTANCE.createBuilder(charnet$RequestGetRecentChargeOrders);
    }

    public static Charnet$RequestGetRecentChargeOrders parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Charnet$RequestGetRecentChargeOrders) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Charnet$RequestGetRecentChargeOrders parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Charnet$RequestGetRecentChargeOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Charnet$RequestGetRecentChargeOrders parseFrom(AbstractC2383g abstractC2383g) {
        return (Charnet$RequestGetRecentChargeOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Charnet$RequestGetRecentChargeOrders parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Charnet$RequestGetRecentChargeOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Charnet$RequestGetRecentChargeOrders parseFrom(byte[] bArr) {
        return (Charnet$RequestGetRecentChargeOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Charnet$RequestGetRecentChargeOrders parseFrom(byte[] bArr, C2394s c2394s) {
        return (Charnet$RequestGetRecentChargeOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Charnet$RequestGetRecentChargeOrders parseFrom(InputStream inputStream) {
        return (Charnet$RequestGetRecentChargeOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Charnet$RequestGetRecentChargeOrders parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Charnet$RequestGetRecentChargeOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Charnet$RequestGetRecentChargeOrders parseFrom(AbstractC2384h abstractC2384h) {
        return (Charnet$RequestGetRecentChargeOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Charnet$RequestGetRecentChargeOrders parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Charnet$RequestGetRecentChargeOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
