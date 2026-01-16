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
public final class Car$RequestRemovePlates extends GeneratedMessageLite implements U64 {
    private static final Car$RequestRemovePlates DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PLATE_IDS_FIELD_NUMBER = 1;
    private B.j plateIds_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Car$RequestRemovePlates.DEFAULT_INSTANCE);
        }
    }

    static {
        Car$RequestRemovePlates car$RequestRemovePlates = new Car$RequestRemovePlates();
        DEFAULT_INSTANCE = car$RequestRemovePlates;
        GeneratedMessageLite.registerDefaultInstance(Car$RequestRemovePlates.class, car$RequestRemovePlates);
    }

    private Car$RequestRemovePlates() {
    }

    private void addAllPlateIds(Iterable<String> iterable) {
        ensurePlateIdsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.plateIds_);
    }

    private void addPlateIds(String str) {
        str.getClass();
        ensurePlateIdsIsMutable();
        this.plateIds_.add(str);
    }

    private void addPlateIdsBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        ensurePlateIdsIsMutable();
        this.plateIds_.add(abstractC2383g.f0());
    }

    private void clearPlateIds() {
        this.plateIds_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensurePlateIdsIsMutable() {
        B.j jVar = this.plateIds_;
        if (jVar.u()) {
            return;
        }
        this.plateIds_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static Car$RequestRemovePlates getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Car$RequestRemovePlates parseDelimitedFrom(InputStream inputStream) {
        return (Car$RequestRemovePlates) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Car$RequestRemovePlates parseFrom(ByteBuffer byteBuffer) {
        return (Car$RequestRemovePlates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPlateIds(int i, String str) {
        str.getClass();
        ensurePlateIdsIsMutable();
        this.plateIds_.set(i, str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1905x.a[gVar.ordinal()]) {
            case 1:
                return new Car$RequestRemovePlates();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001Ț", new Object[]{"plateIds_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Car$RequestRemovePlates.class) {
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

    public String getPlateIds(int i) {
        return (String) this.plateIds_.get(i);
    }

    public AbstractC2383g getPlateIdsBytes(int i) {
        return AbstractC2383g.N((String) this.plateIds_.get(i));
    }

    public int getPlateIdsCount() {
        return this.plateIds_.size();
    }

    public List<String> getPlateIdsList() {
        return this.plateIds_;
    }

    public static a newBuilder(Car$RequestRemovePlates car$RequestRemovePlates) {
        return (a) DEFAULT_INSTANCE.createBuilder(car$RequestRemovePlates);
    }

    public static Car$RequestRemovePlates parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Car$RequestRemovePlates) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Car$RequestRemovePlates parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Car$RequestRemovePlates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Car$RequestRemovePlates parseFrom(AbstractC2383g abstractC2383g) {
        return (Car$RequestRemovePlates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Car$RequestRemovePlates parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Car$RequestRemovePlates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Car$RequestRemovePlates parseFrom(byte[] bArr) {
        return (Car$RequestRemovePlates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Car$RequestRemovePlates parseFrom(byte[] bArr, C2394s c2394s) {
        return (Car$RequestRemovePlates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Car$RequestRemovePlates parseFrom(InputStream inputStream) {
        return (Car$RequestRemovePlates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Car$RequestRemovePlates parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Car$RequestRemovePlates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Car$RequestRemovePlates parseFrom(AbstractC2384h abstractC2384h) {
        return (Car$RequestRemovePlates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Car$RequestRemovePlates parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Car$RequestRemovePlates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
