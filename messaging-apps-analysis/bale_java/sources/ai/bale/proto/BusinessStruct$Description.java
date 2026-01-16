package ai.bale.proto;

import ai.bale.proto.BusinessStruct$SafirDescriptions;
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
public final class BusinessStruct$Description extends GeneratedMessageLite implements U64 {
    private static final BusinessStruct$Description DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int SAFIR_DESCRIPTIONS_FIELD_NUMBER = 101;
    public static final int TEXT_FIELD_NUMBER = 1;
    private Object trait_;
    private int traitCase_ = 0;
    private String text_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BusinessStruct$Description.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        SAFIR_DESCRIPTIONS(101),
        TRAIT_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return TRAIT_NOT_SET;
            }
            if (i != 101) {
                return null;
            }
            return SAFIR_DESCRIPTIONS;
        }
    }

    static {
        BusinessStruct$Description businessStruct$Description = new BusinessStruct$Description();
        DEFAULT_INSTANCE = businessStruct$Description;
        GeneratedMessageLite.registerDefaultInstance(BusinessStruct$Description.class, businessStruct$Description);
    }

    private BusinessStruct$Description() {
    }

    private void clearSafirDescriptions() {
        if (this.traitCase_ == 101) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearText() {
        this.text_ = getDefaultInstance().getText();
    }

    private void clearTrait() {
        this.traitCase_ = 0;
        this.trait_ = null;
    }

    public static BusinessStruct$Description getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeSafirDescriptions(BusinessStruct$SafirDescriptions businessStruct$SafirDescriptions) {
        businessStruct$SafirDescriptions.getClass();
        if (this.traitCase_ != 101 || this.trait_ == BusinessStruct$SafirDescriptions.getDefaultInstance()) {
            this.trait_ = businessStruct$SafirDescriptions;
        } else {
            this.trait_ = ((BusinessStruct$SafirDescriptions.a) BusinessStruct$SafirDescriptions.newBuilder((BusinessStruct$SafirDescriptions) this.trait_).v(businessStruct$SafirDescriptions)).j();
        }
        this.traitCase_ = 101;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BusinessStruct$Description parseDelimitedFrom(InputStream inputStream) {
        return (BusinessStruct$Description) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessStruct$Description parseFrom(ByteBuffer byteBuffer) {
        return (BusinessStruct$Description) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setSafirDescriptions(BusinessStruct$SafirDescriptions businessStruct$SafirDescriptions) {
        businessStruct$SafirDescriptions.getClass();
        this.trait_ = businessStruct$SafirDescriptions;
        this.traitCase_ = 101;
    }

    private void setText(String str) {
        str.getClass();
        this.text_ = str;
    }

    private void setTextBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.text_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1899v.a[gVar.ordinal()]) {
            case 1:
                return new BusinessStruct$Description();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001e\u0002\u0000\u0000\u0000\u0001Ȉe<\u0000", new Object[]{"trait_", "traitCase_", "text_", BusinessStruct$SafirDescriptions.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BusinessStruct$Description.class) {
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

    public BusinessStruct$SafirDescriptions getSafirDescriptions() {
        return this.traitCase_ == 101 ? (BusinessStruct$SafirDescriptions) this.trait_ : BusinessStruct$SafirDescriptions.getDefaultInstance();
    }

    public String getText() {
        return this.text_;
    }

    public AbstractC2383g getTextBytes() {
        return AbstractC2383g.N(this.text_);
    }

    public b getTraitCase() {
        return b.j(this.traitCase_);
    }

    public boolean hasSafirDescriptions() {
        return this.traitCase_ == 101;
    }

    public static a newBuilder(BusinessStruct$Description businessStruct$Description) {
        return (a) DEFAULT_INSTANCE.createBuilder(businessStruct$Description);
    }

    public static BusinessStruct$Description parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessStruct$Description) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessStruct$Description parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BusinessStruct$Description) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BusinessStruct$Description parseFrom(AbstractC2383g abstractC2383g) {
        return (BusinessStruct$Description) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BusinessStruct$Description parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BusinessStruct$Description) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BusinessStruct$Description parseFrom(byte[] bArr) {
        return (BusinessStruct$Description) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BusinessStruct$Description parseFrom(byte[] bArr, C2394s c2394s) {
        return (BusinessStruct$Description) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BusinessStruct$Description parseFrom(InputStream inputStream) {
        return (BusinessStruct$Description) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessStruct$Description parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessStruct$Description) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessStruct$Description parseFrom(AbstractC2384h abstractC2384h) {
        return (BusinessStruct$Description) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BusinessStruct$Description parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BusinessStruct$Description) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
