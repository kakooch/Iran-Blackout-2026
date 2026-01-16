package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC24348yT3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MarketStruct$MarketAction extends GeneratedMessageLite implements U64 {
    private static final MarketStruct$MarketAction DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int TYPE_FIELD_NUMBER = 1;
    public static final int URL_FIELD_NUMBER = 3;
    private int id_;
    private int type_;
    private String url_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MarketStruct$MarketAction.DEFAULT_INSTANCE);
        }
    }

    static {
        MarketStruct$MarketAction marketStruct$MarketAction = new MarketStruct$MarketAction();
        DEFAULT_INSTANCE = marketStruct$MarketAction;
        GeneratedMessageLite.registerDefaultInstance(MarketStruct$MarketAction.class, marketStruct$MarketAction);
    }

    private MarketStruct$MarketAction() {
    }

    private void clearId() {
        this.id_ = 0;
    }

    private void clearType() {
        this.type_ = 0;
    }

    private void clearUrl() {
        this.url_ = getDefaultInstance().getUrl();
    }

    public static MarketStruct$MarketAction getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MarketStruct$MarketAction parseDelimitedFrom(InputStream inputStream) {
        return (MarketStruct$MarketAction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketStruct$MarketAction parseFrom(ByteBuffer byteBuffer) {
        return (MarketStruct$MarketAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setId(int i) {
        this.id_ = i;
    }

    private void setType(EnumC24348yT3 enumC24348yT3) {
        this.type_ = enumC24348yT3.getNumber();
    }

    private void setTypeValue(int i) {
        this.type_ = i;
    }

    private void setUrl(String str) {
        str.getClass();
        this.url_ = str;
    }

    private void setUrlBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.url_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (D0.a[gVar.ordinal()]) {
            case 1:
                return new MarketStruct$MarketAction();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\u0004\u0003Ȉ", new Object[]{"type_", "id_", "url_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MarketStruct$MarketAction.class) {
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

    public EnumC24348yT3 getType() {
        EnumC24348yT3 enumC24348yT3J = EnumC24348yT3.j(this.type_);
        return enumC24348yT3J == null ? EnumC24348yT3.UNRECOGNIZED : enumC24348yT3J;
    }

    public int getTypeValue() {
        return this.type_;
    }

    public String getUrl() {
        return this.url_;
    }

    public AbstractC2383g getUrlBytes() {
        return AbstractC2383g.N(this.url_);
    }

    public static a newBuilder(MarketStruct$MarketAction marketStruct$MarketAction) {
        return (a) DEFAULT_INSTANCE.createBuilder(marketStruct$MarketAction);
    }

    public static MarketStruct$MarketAction parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketStruct$MarketAction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketStruct$MarketAction parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MarketStruct$MarketAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MarketStruct$MarketAction parseFrom(AbstractC2383g abstractC2383g) {
        return (MarketStruct$MarketAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MarketStruct$MarketAction parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MarketStruct$MarketAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MarketStruct$MarketAction parseFrom(byte[] bArr) {
        return (MarketStruct$MarketAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MarketStruct$MarketAction parseFrom(byte[] bArr, C2394s c2394s) {
        return (MarketStruct$MarketAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MarketStruct$MarketAction parseFrom(InputStream inputStream) {
        return (MarketStruct$MarketAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketStruct$MarketAction parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketStruct$MarketAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketStruct$MarketAction parseFrom(AbstractC2384h abstractC2384h) {
        return (MarketStruct$MarketAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MarketStruct$MarketAction parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MarketStruct$MarketAction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
