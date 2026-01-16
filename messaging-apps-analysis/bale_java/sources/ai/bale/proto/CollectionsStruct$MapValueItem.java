package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$RawValue;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC22015uX0;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class CollectionsStruct$MapValueItem extends GeneratedMessageLite implements InterfaceC22015uX0 {
    private static final CollectionsStruct$MapValueItem DEFAULT_INSTANCE;
    public static final int KEY_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 2;
    private int bitField0_;
    private String key_ = "";
    private CollectionsStruct$RawValue value_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC22015uX0 {
        public a A(String str) {
            q();
            ((CollectionsStruct$MapValueItem) this.b).setKey(str);
            return this;
        }

        public a B(CollectionsStruct$RawValue.a aVar) {
            q();
            ((CollectionsStruct$MapValueItem) this.b).setValue((CollectionsStruct$RawValue) aVar.a());
            return this;
        }

        private a() {
            super(CollectionsStruct$MapValueItem.DEFAULT_INSTANCE);
        }
    }

    static {
        CollectionsStruct$MapValueItem collectionsStruct$MapValueItem = new CollectionsStruct$MapValueItem();
        DEFAULT_INSTANCE = collectionsStruct$MapValueItem;
        GeneratedMessageLite.registerDefaultInstance(CollectionsStruct$MapValueItem.class, collectionsStruct$MapValueItem);
    }

    private CollectionsStruct$MapValueItem() {
    }

    private void clearKey() {
        this.key_ = getDefaultInstance().getKey();
    }

    private void clearValue() {
        this.value_ = null;
        this.bitField0_ &= -2;
    }

    public static CollectionsStruct$MapValueItem getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeValue(CollectionsStruct$RawValue collectionsStruct$RawValue) {
        collectionsStruct$RawValue.getClass();
        CollectionsStruct$RawValue collectionsStruct$RawValue2 = this.value_;
        if (collectionsStruct$RawValue2 == null || collectionsStruct$RawValue2 == CollectionsStruct$RawValue.getDefaultInstance()) {
            this.value_ = collectionsStruct$RawValue;
        } else {
            this.value_ = (CollectionsStruct$RawValue) ((CollectionsStruct$RawValue.a) CollectionsStruct$RawValue.newBuilder(this.value_).v(collectionsStruct$RawValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static CollectionsStruct$MapValueItem parseDelimitedFrom(InputStream inputStream) {
        return (CollectionsStruct$MapValueItem) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CollectionsStruct$MapValueItem parseFrom(ByteBuffer byteBuffer) {
        return (CollectionsStruct$MapValueItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKey(String str) {
        str.getClass();
        this.key_ = str;
    }

    private void setKeyBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.key_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValue(CollectionsStruct$RawValue collectionsStruct$RawValue) {
        collectionsStruct$RawValue.getClass();
        this.value_ = collectionsStruct$RawValue;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (D.a[gVar.ordinal()]) {
            case 1:
                return new CollectionsStruct$MapValueItem();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000", new Object[]{"bitField0_", "key_", "value_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (CollectionsStruct$MapValueItem.class) {
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

    public String getKey() {
        return this.key_;
    }

    public AbstractC2383g getKeyBytes() {
        return AbstractC2383g.N(this.key_);
    }

    public CollectionsStruct$RawValue getValue() {
        CollectionsStruct$RawValue collectionsStruct$RawValue = this.value_;
        return collectionsStruct$RawValue == null ? CollectionsStruct$RawValue.getDefaultInstance() : collectionsStruct$RawValue;
    }

    public boolean hasValue() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(CollectionsStruct$MapValueItem collectionsStruct$MapValueItem) {
        return (a) DEFAULT_INSTANCE.createBuilder(collectionsStruct$MapValueItem);
    }

    public static CollectionsStruct$MapValueItem parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (CollectionsStruct$MapValueItem) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CollectionsStruct$MapValueItem parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (CollectionsStruct$MapValueItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static CollectionsStruct$MapValueItem parseFrom(AbstractC2383g abstractC2383g) {
        return (CollectionsStruct$MapValueItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static CollectionsStruct$MapValueItem parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (CollectionsStruct$MapValueItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static CollectionsStruct$MapValueItem parseFrom(byte[] bArr) {
        return (CollectionsStruct$MapValueItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static CollectionsStruct$MapValueItem parseFrom(byte[] bArr, C2394s c2394s) {
        return (CollectionsStruct$MapValueItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static CollectionsStruct$MapValueItem parseFrom(InputStream inputStream) {
        return (CollectionsStruct$MapValueItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CollectionsStruct$MapValueItem parseFrom(InputStream inputStream, C2394s c2394s) {
        return (CollectionsStruct$MapValueItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CollectionsStruct$MapValueItem parseFrom(AbstractC2384h abstractC2384h) {
        return (CollectionsStruct$MapValueItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static CollectionsStruct$MapValueItem parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (CollectionsStruct$MapValueItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
