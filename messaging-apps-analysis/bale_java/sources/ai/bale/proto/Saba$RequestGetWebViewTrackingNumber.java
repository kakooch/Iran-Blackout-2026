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
public final class Saba$RequestGetWebViewTrackingNumber extends GeneratedMessageLite implements U64 {
    private static final Saba$RequestGetWebViewTrackingNumber DEFAULT_INSTANCE;
    public static final int NATIONAL_CODE_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private String nationalCode_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Saba$RequestGetWebViewTrackingNumber.DEFAULT_INSTANCE);
        }
    }

    static {
        Saba$RequestGetWebViewTrackingNumber saba$RequestGetWebViewTrackingNumber = new Saba$RequestGetWebViewTrackingNumber();
        DEFAULT_INSTANCE = saba$RequestGetWebViewTrackingNumber;
        GeneratedMessageLite.registerDefaultInstance(Saba$RequestGetWebViewTrackingNumber.class, saba$RequestGetWebViewTrackingNumber);
    }

    private Saba$RequestGetWebViewTrackingNumber() {
    }

    private void clearNationalCode() {
        this.nationalCode_ = getDefaultInstance().getNationalCode();
    }

    public static Saba$RequestGetWebViewTrackingNumber getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Saba$RequestGetWebViewTrackingNumber parseDelimitedFrom(InputStream inputStream) {
        return (Saba$RequestGetWebViewTrackingNumber) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Saba$RequestGetWebViewTrackingNumber parseFrom(ByteBuffer byteBuffer) {
        return (Saba$RequestGetWebViewTrackingNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setNationalCode(String str) {
        str.getClass();
        this.nationalCode_ = str;
    }

    private void setNationalCodeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.nationalCode_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (B1.a[gVar.ordinal()]) {
            case 1:
                return new Saba$RequestGetWebViewTrackingNumber();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"nationalCode_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Saba$RequestGetWebViewTrackingNumber.class) {
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

    public String getNationalCode() {
        return this.nationalCode_;
    }

    public AbstractC2383g getNationalCodeBytes() {
        return AbstractC2383g.N(this.nationalCode_);
    }

    public static a newBuilder(Saba$RequestGetWebViewTrackingNumber saba$RequestGetWebViewTrackingNumber) {
        return (a) DEFAULT_INSTANCE.createBuilder(saba$RequestGetWebViewTrackingNumber);
    }

    public static Saba$RequestGetWebViewTrackingNumber parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Saba$RequestGetWebViewTrackingNumber) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Saba$RequestGetWebViewTrackingNumber parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Saba$RequestGetWebViewTrackingNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Saba$RequestGetWebViewTrackingNumber parseFrom(AbstractC2383g abstractC2383g) {
        return (Saba$RequestGetWebViewTrackingNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Saba$RequestGetWebViewTrackingNumber parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Saba$RequestGetWebViewTrackingNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Saba$RequestGetWebViewTrackingNumber parseFrom(byte[] bArr) {
        return (Saba$RequestGetWebViewTrackingNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Saba$RequestGetWebViewTrackingNumber parseFrom(byte[] bArr, C2394s c2394s) {
        return (Saba$RequestGetWebViewTrackingNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Saba$RequestGetWebViewTrackingNumber parseFrom(InputStream inputStream) {
        return (Saba$RequestGetWebViewTrackingNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Saba$RequestGetWebViewTrackingNumber parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Saba$RequestGetWebViewTrackingNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Saba$RequestGetWebViewTrackingNumber parseFrom(AbstractC2384h abstractC2384h) {
        return (Saba$RequestGetWebViewTrackingNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Saba$RequestGetWebViewTrackingNumber parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Saba$RequestGetWebViewTrackingNumber) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
