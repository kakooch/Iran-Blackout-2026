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
public final class CollectionsStruct$ArrayValue extends GeneratedMessageLite implements U64 {
    public static final int ARRAY_FIELD_NUMBER = 1;
    private static final CollectionsStruct$ArrayValue DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private B.j array_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(CollectionsStruct$RawValue collectionsStruct$RawValue) {
            q();
            ((CollectionsStruct$ArrayValue) this.b).addArray(collectionsStruct$RawValue);
            return this;
        }

        private a() {
            super(CollectionsStruct$ArrayValue.DEFAULT_INSTANCE);
        }
    }

    static {
        CollectionsStruct$ArrayValue collectionsStruct$ArrayValue = new CollectionsStruct$ArrayValue();
        DEFAULT_INSTANCE = collectionsStruct$ArrayValue;
        GeneratedMessageLite.registerDefaultInstance(CollectionsStruct$ArrayValue.class, collectionsStruct$ArrayValue);
    }

    private CollectionsStruct$ArrayValue() {
    }

    private void addAllArray(Iterable<? extends CollectionsStruct$RawValue> iterable) {
        ensureArrayIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.array_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addArray(CollectionsStruct$RawValue collectionsStruct$RawValue) {
        collectionsStruct$RawValue.getClass();
        ensureArrayIsMutable();
        this.array_.add(collectionsStruct$RawValue);
    }

    private void clearArray() {
        this.array_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureArrayIsMutable() {
        B.j jVar = this.array_;
        if (jVar.u()) {
            return;
        }
        this.array_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static CollectionsStruct$ArrayValue getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static CollectionsStruct$ArrayValue parseDelimitedFrom(InputStream inputStream) {
        return (CollectionsStruct$ArrayValue) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CollectionsStruct$ArrayValue parseFrom(ByteBuffer byteBuffer) {
        return (CollectionsStruct$ArrayValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeArray(int i) {
        ensureArrayIsMutable();
        this.array_.remove(i);
    }

    private void setArray(int i, CollectionsStruct$RawValue collectionsStruct$RawValue) {
        collectionsStruct$RawValue.getClass();
        ensureArrayIsMutable();
        this.array_.set(i, collectionsStruct$RawValue);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (D.a[gVar.ordinal()]) {
            case 1:
                return new CollectionsStruct$ArrayValue();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"array_", CollectionsStruct$RawValue.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (CollectionsStruct$ArrayValue.class) {
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

    public CollectionsStruct$RawValue getArray(int i) {
        return (CollectionsStruct$RawValue) this.array_.get(i);
    }

    public int getArrayCount() {
        return this.array_.size();
    }

    public List<CollectionsStruct$RawValue> getArrayList() {
        return this.array_;
    }

    public E getArrayOrBuilder(int i) {
        return (E) this.array_.get(i);
    }

    public List<? extends E> getArrayOrBuilderList() {
        return this.array_;
    }

    public static a newBuilder(CollectionsStruct$ArrayValue collectionsStruct$ArrayValue) {
        return (a) DEFAULT_INSTANCE.createBuilder(collectionsStruct$ArrayValue);
    }

    public static CollectionsStruct$ArrayValue parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (CollectionsStruct$ArrayValue) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CollectionsStruct$ArrayValue parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (CollectionsStruct$ArrayValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static CollectionsStruct$ArrayValue parseFrom(AbstractC2383g abstractC2383g) {
        return (CollectionsStruct$ArrayValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addArray(int i, CollectionsStruct$RawValue collectionsStruct$RawValue) {
        collectionsStruct$RawValue.getClass();
        ensureArrayIsMutable();
        this.array_.add(i, collectionsStruct$RawValue);
    }

    public static CollectionsStruct$ArrayValue parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (CollectionsStruct$ArrayValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static CollectionsStruct$ArrayValue parseFrom(byte[] bArr) {
        return (CollectionsStruct$ArrayValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static CollectionsStruct$ArrayValue parseFrom(byte[] bArr, C2394s c2394s) {
        return (CollectionsStruct$ArrayValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static CollectionsStruct$ArrayValue parseFrom(InputStream inputStream) {
        return (CollectionsStruct$ArrayValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CollectionsStruct$ArrayValue parseFrom(InputStream inputStream, C2394s c2394s) {
        return (CollectionsStruct$ArrayValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CollectionsStruct$ArrayValue parseFrom(AbstractC2384h abstractC2384h) {
        return (CollectionsStruct$ArrayValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static CollectionsStruct$ArrayValue parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (CollectionsStruct$ArrayValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
