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

/* loaded from: classes.dex */
public final class VitrineOuterClass$ResponseRequisitionEnterToVitrine extends GeneratedMessageLite implements U64 {
    private static final VitrineOuterClass$ResponseRequisitionEnterToVitrine DEFAULT_INSTANCE;
    public static final int MESSAGE_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private String message_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(VitrineOuterClass$ResponseRequisitionEnterToVitrine.DEFAULT_INSTANCE);
        }
    }

    static {
        VitrineOuterClass$ResponseRequisitionEnterToVitrine vitrineOuterClass$ResponseRequisitionEnterToVitrine = new VitrineOuterClass$ResponseRequisitionEnterToVitrine();
        DEFAULT_INSTANCE = vitrineOuterClass$ResponseRequisitionEnterToVitrine;
        GeneratedMessageLite.registerDefaultInstance(VitrineOuterClass$ResponseRequisitionEnterToVitrine.class, vitrineOuterClass$ResponseRequisitionEnterToVitrine);
    }

    private VitrineOuterClass$ResponseRequisitionEnterToVitrine() {
    }

    private void clearMessage() {
        this.message_ = getDefaultInstance().getMessage();
    }

    public static VitrineOuterClass$ResponseRequisitionEnterToVitrine getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static VitrineOuterClass$ResponseRequisitionEnterToVitrine parseDelimitedFrom(InputStream inputStream) {
        return (VitrineOuterClass$ResponseRequisitionEnterToVitrine) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VitrineOuterClass$ResponseRequisitionEnterToVitrine parseFrom(ByteBuffer byteBuffer) {
        return (VitrineOuterClass$ResponseRequisitionEnterToVitrine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setMessage(String str) {
        str.getClass();
        this.message_ = str;
    }

    private void setMessageBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.message_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (r2.a[gVar.ordinal()]) {
            case 1:
                return new VitrineOuterClass$ResponseRequisitionEnterToVitrine();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"message_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (VitrineOuterClass$ResponseRequisitionEnterToVitrine.class) {
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

    public String getMessage() {
        return this.message_;
    }

    public AbstractC2383g getMessageBytes() {
        return AbstractC2383g.N(this.message_);
    }

    public static a newBuilder(VitrineOuterClass$ResponseRequisitionEnterToVitrine vitrineOuterClass$ResponseRequisitionEnterToVitrine) {
        return (a) DEFAULT_INSTANCE.createBuilder(vitrineOuterClass$ResponseRequisitionEnterToVitrine);
    }

    public static VitrineOuterClass$ResponseRequisitionEnterToVitrine parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (VitrineOuterClass$ResponseRequisitionEnterToVitrine) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static VitrineOuterClass$ResponseRequisitionEnterToVitrine parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (VitrineOuterClass$ResponseRequisitionEnterToVitrine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static VitrineOuterClass$ResponseRequisitionEnterToVitrine parseFrom(AbstractC2383g abstractC2383g) {
        return (VitrineOuterClass$ResponseRequisitionEnterToVitrine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static VitrineOuterClass$ResponseRequisitionEnterToVitrine parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (VitrineOuterClass$ResponseRequisitionEnterToVitrine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static VitrineOuterClass$ResponseRequisitionEnterToVitrine parseFrom(byte[] bArr) {
        return (VitrineOuterClass$ResponseRequisitionEnterToVitrine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static VitrineOuterClass$ResponseRequisitionEnterToVitrine parseFrom(byte[] bArr, C2394s c2394s) {
        return (VitrineOuterClass$ResponseRequisitionEnterToVitrine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static VitrineOuterClass$ResponseRequisitionEnterToVitrine parseFrom(InputStream inputStream) {
        return (VitrineOuterClass$ResponseRequisitionEnterToVitrine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VitrineOuterClass$ResponseRequisitionEnterToVitrine parseFrom(InputStream inputStream, C2394s c2394s) {
        return (VitrineOuterClass$ResponseRequisitionEnterToVitrine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static VitrineOuterClass$ResponseRequisitionEnterToVitrine parseFrom(AbstractC2384h abstractC2384h) {
        return (VitrineOuterClass$ResponseRequisitionEnterToVitrine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static VitrineOuterClass$ResponseRequisitionEnterToVitrine parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (VitrineOuterClass$ResponseRequisitionEnterToVitrine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
