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
public final class GarsonStruct$GarsonCustomItems extends GeneratedMessageLite implements U64 {
    private static final GarsonStruct$GarsonCustomItems DEFAULT_INSTANCE;
    public static final int ITEMS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int itemsMemoizedSerializedSize = -1;
    private B.g items_ = GeneratedMessageLite.emptyIntList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GarsonStruct$GarsonCustomItems.DEFAULT_INSTANCE);
        }
    }

    static {
        GarsonStruct$GarsonCustomItems garsonStruct$GarsonCustomItems = new GarsonStruct$GarsonCustomItems();
        DEFAULT_INSTANCE = garsonStruct$GarsonCustomItems;
        GeneratedMessageLite.registerDefaultInstance(GarsonStruct$GarsonCustomItems.class, garsonStruct$GarsonCustomItems);
    }

    private GarsonStruct$GarsonCustomItems() {
    }

    private void addAllItems(Iterable<? extends Integer> iterable) {
        ensureItemsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.items_);
    }

    private void addItems(int i) {
        ensureItemsIsMutable();
        this.items_.b1(i);
    }

    private void clearItems() {
        this.items_ = GeneratedMessageLite.emptyIntList();
    }

    private void ensureItemsIsMutable() {
        B.g gVar = this.items_;
        if (gVar.u()) {
            return;
        }
        this.items_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    public static GarsonStruct$GarsonCustomItems getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GarsonStruct$GarsonCustomItems parseDelimitedFrom(InputStream inputStream) {
        return (GarsonStruct$GarsonCustomItems) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GarsonStruct$GarsonCustomItems parseFrom(ByteBuffer byteBuffer) {
        return (GarsonStruct$GarsonCustomItems) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setItems(int i, int i2) {
        ensureItemsIsMutable();
        this.items_.U(i, i2);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1850e0.a[gVar.ordinal()]) {
            case 1:
                return new GarsonStruct$GarsonCustomItems();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001'", new Object[]{"items_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GarsonStruct$GarsonCustomItems.class) {
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

    public int getItems(int i) {
        return this.items_.getInt(i);
    }

    public int getItemsCount() {
        return this.items_.size();
    }

    public List<Integer> getItemsList() {
        return this.items_;
    }

    public static a newBuilder(GarsonStruct$GarsonCustomItems garsonStruct$GarsonCustomItems) {
        return (a) DEFAULT_INSTANCE.createBuilder(garsonStruct$GarsonCustomItems);
    }

    public static GarsonStruct$GarsonCustomItems parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GarsonStruct$GarsonCustomItems) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GarsonStruct$GarsonCustomItems parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GarsonStruct$GarsonCustomItems) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GarsonStruct$GarsonCustomItems parseFrom(AbstractC2383g abstractC2383g) {
        return (GarsonStruct$GarsonCustomItems) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GarsonStruct$GarsonCustomItems parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GarsonStruct$GarsonCustomItems) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GarsonStruct$GarsonCustomItems parseFrom(byte[] bArr) {
        return (GarsonStruct$GarsonCustomItems) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GarsonStruct$GarsonCustomItems parseFrom(byte[] bArr, C2394s c2394s) {
        return (GarsonStruct$GarsonCustomItems) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GarsonStruct$GarsonCustomItems parseFrom(InputStream inputStream) {
        return (GarsonStruct$GarsonCustomItems) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GarsonStruct$GarsonCustomItems parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GarsonStruct$GarsonCustomItems) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GarsonStruct$GarsonCustomItems parseFrom(AbstractC2384h abstractC2384h) {
        return (GarsonStruct$GarsonCustomItems) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GarsonStruct$GarsonCustomItems parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GarsonStruct$GarsonCustomItems) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
