package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC7528Sc2;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class ExchangeStruct$Station extends GeneratedMessageLite implements InterfaceC7528Sc2 {
    private static final ExchangeStruct$Station DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private String name_ = "";
    private String id_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC7528Sc2 {
        private a() {
            super(ExchangeStruct$Station.DEFAULT_INSTANCE);
        }
    }

    static {
        ExchangeStruct$Station exchangeStruct$Station = new ExchangeStruct$Station();
        DEFAULT_INSTANCE = exchangeStruct$Station;
        GeneratedMessageLite.registerDefaultInstance(ExchangeStruct$Station.class, exchangeStruct$Station);
    }

    private ExchangeStruct$Station() {
    }

    private void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    private void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    public static ExchangeStruct$Station getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static ExchangeStruct$Station parseDelimitedFrom(InputStream inputStream) {
        return (ExchangeStruct$Station) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ExchangeStruct$Station parseFrom(ByteBuffer byteBuffer) {
        return (ExchangeStruct$Station) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setId(String str) {
        str.getClass();
        this.id_ = str;
    }

    private void setIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.id_ = abstractC2383g.f0();
    }

    private void setName(String str) {
        str.getClass();
        this.name_ = str;
    }

    private void setNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.name_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (V.a[gVar.ordinal()]) {
            case 1:
                return new ExchangeStruct$Station();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"name_", "id_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ExchangeStruct$Station.class) {
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

    public String getId() {
        return this.id_;
    }

    public AbstractC2383g getIdBytes() {
        return AbstractC2383g.N(this.id_);
    }

    public String getName() {
        return this.name_;
    }

    public AbstractC2383g getNameBytes() {
        return AbstractC2383g.N(this.name_);
    }

    public static a newBuilder(ExchangeStruct$Station exchangeStruct$Station) {
        return (a) DEFAULT_INSTANCE.createBuilder(exchangeStruct$Station);
    }

    public static ExchangeStruct$Station parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ExchangeStruct$Station) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ExchangeStruct$Station parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ExchangeStruct$Station) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ExchangeStruct$Station parseFrom(AbstractC2383g abstractC2383g) {
        return (ExchangeStruct$Station) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static ExchangeStruct$Station parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ExchangeStruct$Station) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ExchangeStruct$Station parseFrom(byte[] bArr) {
        return (ExchangeStruct$Station) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ExchangeStruct$Station parseFrom(byte[] bArr, C2394s c2394s) {
        return (ExchangeStruct$Station) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ExchangeStruct$Station parseFrom(InputStream inputStream) {
        return (ExchangeStruct$Station) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ExchangeStruct$Station parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ExchangeStruct$Station) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ExchangeStruct$Station parseFrom(AbstractC2384h abstractC2384h) {
        return (ExchangeStruct$Station) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ExchangeStruct$Station parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ExchangeStruct$Station) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
