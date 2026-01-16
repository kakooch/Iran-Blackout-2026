package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC7576Sh5;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class PollStruct$PollOption extends GeneratedMessageLite implements InterfaceC7576Sh5 {
    private static final PollStruct$PollOption DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int TEXT_FIELD_NUMBER = 2;
    private int id_;
    private String text_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC7576Sh5 {
        public a A(int i) {
            q();
            ((PollStruct$PollOption) this.b).setId(i);
            return this;
        }

        public a B(String str) {
            q();
            ((PollStruct$PollOption) this.b).setText(str);
            return this;
        }

        private a() {
            super(PollStruct$PollOption.DEFAULT_INSTANCE);
        }
    }

    static {
        PollStruct$PollOption pollStruct$PollOption = new PollStruct$PollOption();
        DEFAULT_INSTANCE = pollStruct$PollOption;
        GeneratedMessageLite.registerDefaultInstance(PollStruct$PollOption.class, pollStruct$PollOption);
    }

    private PollStruct$PollOption() {
    }

    private void clearId() {
        this.id_ = 0;
    }

    private void clearText() {
        this.text_ = getDefaultInstance().getText();
    }

    public static PollStruct$PollOption getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PollStruct$PollOption parseDelimitedFrom(InputStream inputStream) {
        return (PollStruct$PollOption) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PollStruct$PollOption parseFrom(ByteBuffer byteBuffer) {
        return (PollStruct$PollOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setId(int i) {
        this.id_ = i;
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
        switch (AbstractC1857g1.a[gVar.ordinal()]) {
            case 1:
                return new PollStruct$PollOption();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002Ȉ", new Object[]{"id_", "text_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PollStruct$PollOption.class) {
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

    public int getId() {
        return this.id_;
    }

    public String getText() {
        return this.text_;
    }

    public AbstractC2383g getTextBytes() {
        return AbstractC2383g.N(this.text_);
    }

    public static a newBuilder(PollStruct$PollOption pollStruct$PollOption) {
        return (a) DEFAULT_INSTANCE.createBuilder(pollStruct$PollOption);
    }

    public static PollStruct$PollOption parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PollStruct$PollOption) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PollStruct$PollOption parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PollStruct$PollOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PollStruct$PollOption parseFrom(AbstractC2383g abstractC2383g) {
        return (PollStruct$PollOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PollStruct$PollOption parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PollStruct$PollOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PollStruct$PollOption parseFrom(byte[] bArr) {
        return (PollStruct$PollOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PollStruct$PollOption parseFrom(byte[] bArr, C2394s c2394s) {
        return (PollStruct$PollOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PollStruct$PollOption parseFrom(InputStream inputStream) {
        return (PollStruct$PollOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PollStruct$PollOption parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PollStruct$PollOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PollStruct$PollOption parseFrom(AbstractC2384h abstractC2384h) {
        return (PollStruct$PollOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PollStruct$PollOption parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PollStruct$PollOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
