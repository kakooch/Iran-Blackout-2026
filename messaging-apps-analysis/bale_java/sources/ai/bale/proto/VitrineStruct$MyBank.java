package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.MZ7;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class VitrineStruct$MyBank extends GeneratedMessageLite implements U64 {
    private static final VitrineStruct$MyBank DEFAULT_INSTANCE;
    public static final int ITEMS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j items_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(VitrineStruct$MyBank.DEFAULT_INSTANCE);
        }
    }

    static {
        VitrineStruct$MyBank vitrineStruct$MyBank = new VitrineStruct$MyBank();
        DEFAULT_INSTANCE = vitrineStruct$MyBank;
        GeneratedMessageLite.registerDefaultInstance(VitrineStruct$MyBank.class, vitrineStruct$MyBank);
    }

    private VitrineStruct$MyBank() {
    }

    private void addAllItems(Iterable<? extends VitrineStruct$MyBankItem> iterable) {
        ensureItemsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.items_);
    }

    private void addItems(VitrineStruct$MyBankItem vitrineStruct$MyBankItem) {
        vitrineStruct$MyBankItem.getClass();
        ensureItemsIsMutable();
        this.items_.add(vitrineStruct$MyBankItem);
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

    public static VitrineStruct$MyBank getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static VitrineStruct$MyBank parseDelimitedFrom(InputStream inputStream) {
        return (VitrineStruct$MyBank) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VitrineStruct$MyBank parseFrom(ByteBuffer byteBuffer) {
        return (VitrineStruct$MyBank) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeItems(int i) {
        ensureItemsIsMutable();
        this.items_.remove(i);
    }

    private void setItems(int i, VitrineStruct$MyBankItem vitrineStruct$MyBankItem) {
        vitrineStruct$MyBankItem.getClass();
        ensureItemsIsMutable();
        this.items_.set(i, vitrineStruct$MyBankItem);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (t2.a[gVar.ordinal()]) {
            case 1:
                return new VitrineStruct$MyBank();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"items_", VitrineStruct$MyBankItem.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (VitrineStruct$MyBank.class) {
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

    public VitrineStruct$MyBankItem getItems(int i) {
        return (VitrineStruct$MyBankItem) this.items_.get(i);
    }

    public int getItemsCount() {
        return this.items_.size();
    }

    public List<VitrineStruct$MyBankItem> getItemsList() {
        return this.items_;
    }

    public MZ7 getItemsOrBuilder(int i) {
        return (MZ7) this.items_.get(i);
    }

    public List<? extends MZ7> getItemsOrBuilderList() {
        return this.items_;
    }

    public static a newBuilder(VitrineStruct$MyBank vitrineStruct$MyBank) {
        return (a) DEFAULT_INSTANCE.createBuilder(vitrineStruct$MyBank);
    }

    public static VitrineStruct$MyBank parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (VitrineStruct$MyBank) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static VitrineStruct$MyBank parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (VitrineStruct$MyBank) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static VitrineStruct$MyBank parseFrom(AbstractC2383g abstractC2383g) {
        return (VitrineStruct$MyBank) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addItems(int i, VitrineStruct$MyBankItem vitrineStruct$MyBankItem) {
        vitrineStruct$MyBankItem.getClass();
        ensureItemsIsMutable();
        this.items_.add(i, vitrineStruct$MyBankItem);
    }

    public static VitrineStruct$MyBank parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (VitrineStruct$MyBank) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static VitrineStruct$MyBank parseFrom(byte[] bArr) {
        return (VitrineStruct$MyBank) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static VitrineStruct$MyBank parseFrom(byte[] bArr, C2394s c2394s) {
        return (VitrineStruct$MyBank) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static VitrineStruct$MyBank parseFrom(InputStream inputStream) {
        return (VitrineStruct$MyBank) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VitrineStruct$MyBank parseFrom(InputStream inputStream, C2394s c2394s) {
        return (VitrineStruct$MyBank) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static VitrineStruct$MyBank parseFrom(AbstractC2384h abstractC2384h) {
        return (VitrineStruct$MyBank) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static VitrineStruct$MyBank parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (VitrineStruct$MyBank) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
