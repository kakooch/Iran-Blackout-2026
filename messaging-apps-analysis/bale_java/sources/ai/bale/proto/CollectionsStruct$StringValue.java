package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class CollectionsStruct$StringValue extends GeneratedMessageLite implements U64 {
    private static final CollectionsStruct$StringValue DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TEXT_FIELD_NUMBER = 1;
    private String text_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(String str) {
            q();
            ((CollectionsStruct$StringValue) this.b).setText(str);
            return this;
        }

        private a() {
            super(CollectionsStruct$StringValue.DEFAULT_INSTANCE);
        }
    }

    static {
        CollectionsStruct$StringValue collectionsStruct$StringValue = new CollectionsStruct$StringValue();
        DEFAULT_INSTANCE = collectionsStruct$StringValue;
        GeneratedMessageLite.registerDefaultInstance(CollectionsStruct$StringValue.class, collectionsStruct$StringValue);
    }

    private CollectionsStruct$StringValue() {
    }

    private void clearText() {
        this.text_ = getDefaultInstance().getText();
    }

    public static CollectionsStruct$StringValue getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static CollectionsStruct$StringValue parseDelimitedFrom(InputStream inputStream) {
        return (CollectionsStruct$StringValue) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CollectionsStruct$StringValue parseFrom(ByteBuffer byteBuffer) {
        return (CollectionsStruct$StringValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setText(String str) {
        str.getClass();
        this.text_ = str;
    }

    private void setTextBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.text_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (D.a[gVar.ordinal()]) {
            case 1:
                return new CollectionsStruct$StringValue();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"text_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (CollectionsStruct$StringValue.class) {
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

    public String getText() {
        return this.text_;
    }

    public AbstractC2383g getTextBytes() {
        return AbstractC2383g.N(this.text_);
    }

    public static a newBuilder(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        return (a) DEFAULT_INSTANCE.createBuilder(collectionsStruct$StringValue);
    }

    public static CollectionsStruct$StringValue parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (CollectionsStruct$StringValue) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CollectionsStruct$StringValue parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (CollectionsStruct$StringValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static CollectionsStruct$StringValue parseFrom(AbstractC2383g abstractC2383g) {
        return (CollectionsStruct$StringValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static CollectionsStruct$StringValue parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (CollectionsStruct$StringValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static CollectionsStruct$StringValue parseFrom(byte[] bArr) {
        return (CollectionsStruct$StringValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static CollectionsStruct$StringValue parseFrom(byte[] bArr, C2394s c2394s) {
        return (CollectionsStruct$StringValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static CollectionsStruct$StringValue parseFrom(InputStream inputStream) {
        return (CollectionsStruct$StringValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CollectionsStruct$StringValue parseFrom(InputStream inputStream, C2394s c2394s) {
        return (CollectionsStruct$StringValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CollectionsStruct$StringValue parseFrom(AbstractC2384h abstractC2384h) {
        return (CollectionsStruct$StringValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static CollectionsStruct$StringValue parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (CollectionsStruct$StringValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
