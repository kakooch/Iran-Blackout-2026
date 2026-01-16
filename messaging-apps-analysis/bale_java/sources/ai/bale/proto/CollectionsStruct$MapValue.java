package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$MapValueItem;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC22015uX0;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class CollectionsStruct$MapValue extends GeneratedMessageLite implements U64 {
    private static final CollectionsStruct$MapValue DEFAULT_INSTANCE;
    public static final int ITEMS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j items_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(Iterable iterable) {
            q();
            ((CollectionsStruct$MapValue) this.b).addAllItems(iterable);
            return this;
        }

        public a B(CollectionsStruct$MapValueItem.a aVar) {
            q();
            ((CollectionsStruct$MapValue) this.b).addItems((CollectionsStruct$MapValueItem) aVar.a());
            return this;
        }

        private a() {
            super(CollectionsStruct$MapValue.DEFAULT_INSTANCE);
        }
    }

    static {
        CollectionsStruct$MapValue collectionsStruct$MapValue = new CollectionsStruct$MapValue();
        DEFAULT_INSTANCE = collectionsStruct$MapValue;
        GeneratedMessageLite.registerDefaultInstance(CollectionsStruct$MapValue.class, collectionsStruct$MapValue);
    }

    private CollectionsStruct$MapValue() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllItems(Iterable<? extends CollectionsStruct$MapValueItem> iterable) {
        ensureItemsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.items_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addItems(CollectionsStruct$MapValueItem collectionsStruct$MapValueItem) {
        collectionsStruct$MapValueItem.getClass();
        ensureItemsIsMutable();
        this.items_.add(collectionsStruct$MapValueItem);
    }

    private void clearItems() {
        this.items_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureItemsIsMutable() {
        B.j jVar = this.items_;
        if (jVar.u()) {
            return;
        }
        this.items_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static CollectionsStruct$MapValue getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static CollectionsStruct$MapValue parseDelimitedFrom(InputStream inputStream) {
        return (CollectionsStruct$MapValue) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CollectionsStruct$MapValue parseFrom(ByteBuffer byteBuffer) {
        return (CollectionsStruct$MapValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeItems(int i) {
        ensureItemsIsMutable();
        this.items_.remove(i);
    }

    private void setItems(int i, CollectionsStruct$MapValueItem collectionsStruct$MapValueItem) {
        collectionsStruct$MapValueItem.getClass();
        ensureItemsIsMutable();
        this.items_.set(i, collectionsStruct$MapValueItem);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (D.a[gVar.ordinal()]) {
            case 1:
                return new CollectionsStruct$MapValue();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"items_", CollectionsStruct$MapValueItem.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (CollectionsStruct$MapValue.class) {
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

    public CollectionsStruct$MapValueItem getItems(int i) {
        return (CollectionsStruct$MapValueItem) this.items_.get(i);
    }

    public int getItemsCount() {
        return this.items_.size();
    }

    public List<CollectionsStruct$MapValueItem> getItemsList() {
        return this.items_;
    }

    public InterfaceC22015uX0 getItemsOrBuilder(int i) {
        return (InterfaceC22015uX0) this.items_.get(i);
    }

    public List<? extends InterfaceC22015uX0> getItemsOrBuilderList() {
        return this.items_;
    }

    public static a newBuilder(CollectionsStruct$MapValue collectionsStruct$MapValue) {
        return (a) DEFAULT_INSTANCE.createBuilder(collectionsStruct$MapValue);
    }

    public static CollectionsStruct$MapValue parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (CollectionsStruct$MapValue) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CollectionsStruct$MapValue parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (CollectionsStruct$MapValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static CollectionsStruct$MapValue parseFrom(AbstractC2383g abstractC2383g) {
        return (CollectionsStruct$MapValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addItems(int i, CollectionsStruct$MapValueItem collectionsStruct$MapValueItem) {
        collectionsStruct$MapValueItem.getClass();
        ensureItemsIsMutable();
        this.items_.add(i, collectionsStruct$MapValueItem);
    }

    public static CollectionsStruct$MapValue parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (CollectionsStruct$MapValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static CollectionsStruct$MapValue parseFrom(byte[] bArr) {
        return (CollectionsStruct$MapValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static CollectionsStruct$MapValue parseFrom(byte[] bArr, C2394s c2394s) {
        return (CollectionsStruct$MapValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static CollectionsStruct$MapValue parseFrom(InputStream inputStream) {
        return (CollectionsStruct$MapValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CollectionsStruct$MapValue parseFrom(InputStream inputStream, C2394s c2394s) {
        return (CollectionsStruct$MapValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CollectionsStruct$MapValue parseFrom(AbstractC2384h abstractC2384h) {
        return (CollectionsStruct$MapValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static CollectionsStruct$MapValue parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (CollectionsStruct$MapValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
