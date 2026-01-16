package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC7628Sn3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class KetfStruct$LabeledPrice extends GeneratedMessageLite implements InterfaceC7628Sn3 {
    private static final KetfStruct$LabeledPrice DEFAULT_INSTANCE;
    public static final int LABEL_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int PRICE_FIELD_NUMBER = 2;
    private String label_ = "";
    private long price_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC7628Sn3 {
        private a() {
            super(KetfStruct$LabeledPrice.DEFAULT_INSTANCE);
        }
    }

    static {
        KetfStruct$LabeledPrice ketfStruct$LabeledPrice = new KetfStruct$LabeledPrice();
        DEFAULT_INSTANCE = ketfStruct$LabeledPrice;
        GeneratedMessageLite.registerDefaultInstance(KetfStruct$LabeledPrice.class, ketfStruct$LabeledPrice);
    }

    private KetfStruct$LabeledPrice() {
    }

    private void clearLabel() {
        this.label_ = getDefaultInstance().getLabel();
    }

    private void clearPrice() {
        this.price_ = 0L;
    }

    public static KetfStruct$LabeledPrice getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KetfStruct$LabeledPrice parseDelimitedFrom(InputStream inputStream) {
        return (KetfStruct$LabeledPrice) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfStruct$LabeledPrice parseFrom(ByteBuffer byteBuffer) {
        return (KetfStruct$LabeledPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setLabel(String str) {
        str.getClass();
        this.label_ = str;
    }

    private void setLabelBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.label_ = abstractC2383g.f0();
    }

    private void setPrice(long j) {
        this.price_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1891s0.a[gVar.ordinal()]) {
            case 1:
                return new KetfStruct$LabeledPrice();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\u0002", new Object[]{"label_", "price_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KetfStruct$LabeledPrice.class) {
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

    public String getLabel() {
        return this.label_;
    }

    public AbstractC2383g getLabelBytes() {
        return AbstractC2383g.N(this.label_);
    }

    public long getPrice() {
        return this.price_;
    }

    public static a newBuilder(KetfStruct$LabeledPrice ketfStruct$LabeledPrice) {
        return (a) DEFAULT_INSTANCE.createBuilder(ketfStruct$LabeledPrice);
    }

    public static KetfStruct$LabeledPrice parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfStruct$LabeledPrice) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfStruct$LabeledPrice parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KetfStruct$LabeledPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KetfStruct$LabeledPrice parseFrom(AbstractC2383g abstractC2383g) {
        return (KetfStruct$LabeledPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KetfStruct$LabeledPrice parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KetfStruct$LabeledPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KetfStruct$LabeledPrice parseFrom(byte[] bArr) {
        return (KetfStruct$LabeledPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KetfStruct$LabeledPrice parseFrom(byte[] bArr, C2394s c2394s) {
        return (KetfStruct$LabeledPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KetfStruct$LabeledPrice parseFrom(InputStream inputStream) {
        return (KetfStruct$LabeledPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfStruct$LabeledPrice parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfStruct$LabeledPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfStruct$LabeledPrice parseFrom(AbstractC2384h abstractC2384h) {
        return (KetfStruct$LabeledPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KetfStruct$LabeledPrice parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KetfStruct$LabeledPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
