package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC6422Nn3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class KetfStruct$InlineCallbackAnswer extends GeneratedMessageLite implements U64 {
    private static final KetfStruct$InlineCallbackAnswer DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TEXT_FIELD_NUMBER = 1;
    public static final int TYPE_FIELD_NUMBER = 2;
    private String text_ = "";
    private int type_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KetfStruct$InlineCallbackAnswer.DEFAULT_INSTANCE);
        }
    }

    static {
        KetfStruct$InlineCallbackAnswer ketfStruct$InlineCallbackAnswer = new KetfStruct$InlineCallbackAnswer();
        DEFAULT_INSTANCE = ketfStruct$InlineCallbackAnswer;
        GeneratedMessageLite.registerDefaultInstance(KetfStruct$InlineCallbackAnswer.class, ketfStruct$InlineCallbackAnswer);
    }

    private KetfStruct$InlineCallbackAnswer() {
    }

    private void clearText() {
        this.text_ = getDefaultInstance().getText();
    }

    private void clearType() {
        this.type_ = 0;
    }

    public static KetfStruct$InlineCallbackAnswer getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KetfStruct$InlineCallbackAnswer parseDelimitedFrom(InputStream inputStream) {
        return (KetfStruct$InlineCallbackAnswer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfStruct$InlineCallbackAnswer parseFrom(ByteBuffer byteBuffer) {
        return (KetfStruct$InlineCallbackAnswer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setText(String str) {
        str.getClass();
        this.text_ = str;
    }

    private void setTextBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.text_ = abstractC2383g.f0();
    }

    private void setType(EnumC6422Nn3 enumC6422Nn3) {
        this.type_ = enumC6422Nn3.getNumber();
    }

    private void setTypeValue(int i) {
        this.type_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1891s0.a[gVar.ordinal()]) {
            case 1:
                return new KetfStruct$InlineCallbackAnswer();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\f", new Object[]{"text_", "type_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KetfStruct$InlineCallbackAnswer.class) {
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

    public EnumC6422Nn3 getType() {
        EnumC6422Nn3 enumC6422Nn3J = EnumC6422Nn3.j(this.type_);
        return enumC6422Nn3J == null ? EnumC6422Nn3.UNRECOGNIZED : enumC6422Nn3J;
    }

    public int getTypeValue() {
        return this.type_;
    }

    public static a newBuilder(KetfStruct$InlineCallbackAnswer ketfStruct$InlineCallbackAnswer) {
        return (a) DEFAULT_INSTANCE.createBuilder(ketfStruct$InlineCallbackAnswer);
    }

    public static KetfStruct$InlineCallbackAnswer parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfStruct$InlineCallbackAnswer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfStruct$InlineCallbackAnswer parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KetfStruct$InlineCallbackAnswer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KetfStruct$InlineCallbackAnswer parseFrom(AbstractC2383g abstractC2383g) {
        return (KetfStruct$InlineCallbackAnswer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KetfStruct$InlineCallbackAnswer parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KetfStruct$InlineCallbackAnswer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KetfStruct$InlineCallbackAnswer parseFrom(byte[] bArr) {
        return (KetfStruct$InlineCallbackAnswer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KetfStruct$InlineCallbackAnswer parseFrom(byte[] bArr, C2394s c2394s) {
        return (KetfStruct$InlineCallbackAnswer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KetfStruct$InlineCallbackAnswer parseFrom(InputStream inputStream) {
        return (KetfStruct$InlineCallbackAnswer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfStruct$InlineCallbackAnswer parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfStruct$InlineCallbackAnswer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfStruct$InlineCallbackAnswer parseFrom(AbstractC2384h abstractC2384h) {
        return (KetfStruct$InlineCallbackAnswer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KetfStruct$InlineCallbackAnswer parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KetfStruct$InlineCallbackAnswer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
