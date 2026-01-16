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
public final class Arbainexchange$RequestGetListOfBoxOffice extends GeneratedMessageLite implements U64 {
    private static final Arbainexchange$RequestGetListOfBoxOffice DEFAULT_INSTANCE;
    public static final int EXIT_DATE_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int STATION_ID_FIELD_NUMBER = 1;
    private String stationId_ = "";
    private String exitDate_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Arbainexchange$RequestGetListOfBoxOffice.DEFAULT_INSTANCE);
        }
    }

    static {
        Arbainexchange$RequestGetListOfBoxOffice arbainexchange$RequestGetListOfBoxOffice = new Arbainexchange$RequestGetListOfBoxOffice();
        DEFAULT_INSTANCE = arbainexchange$RequestGetListOfBoxOffice;
        GeneratedMessageLite.registerDefaultInstance(Arbainexchange$RequestGetListOfBoxOffice.class, arbainexchange$RequestGetListOfBoxOffice);
    }

    private Arbainexchange$RequestGetListOfBoxOffice() {
    }

    private void clearExitDate() {
        this.exitDate_ = getDefaultInstance().getExitDate();
    }

    private void clearStationId() {
        this.stationId_ = getDefaultInstance().getStationId();
    }

    public static Arbainexchange$RequestGetListOfBoxOffice getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Arbainexchange$RequestGetListOfBoxOffice parseDelimitedFrom(InputStream inputStream) {
        return (Arbainexchange$RequestGetListOfBoxOffice) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Arbainexchange$RequestGetListOfBoxOffice parseFrom(ByteBuffer byteBuffer) {
        return (Arbainexchange$RequestGetListOfBoxOffice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setExitDate(String str) {
        str.getClass();
        this.exitDate_ = str;
    }

    private void setExitDateBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.exitDate_ = abstractC2383g.f0();
    }

    private void setStationId(String str) {
        str.getClass();
        this.stationId_ = str;
    }

    private void setStationIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.stationId_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1861i.a[gVar.ordinal()]) {
            case 1:
                return new Arbainexchange$RequestGetListOfBoxOffice();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"stationId_", "exitDate_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Arbainexchange$RequestGetListOfBoxOffice.class) {
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

    public String getExitDate() {
        return this.exitDate_;
    }

    public AbstractC2383g getExitDateBytes() {
        return AbstractC2383g.N(this.exitDate_);
    }

    public String getStationId() {
        return this.stationId_;
    }

    public AbstractC2383g getStationIdBytes() {
        return AbstractC2383g.N(this.stationId_);
    }

    public static a newBuilder(Arbainexchange$RequestGetListOfBoxOffice arbainexchange$RequestGetListOfBoxOffice) {
        return (a) DEFAULT_INSTANCE.createBuilder(arbainexchange$RequestGetListOfBoxOffice);
    }

    public static Arbainexchange$RequestGetListOfBoxOffice parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Arbainexchange$RequestGetListOfBoxOffice) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Arbainexchange$RequestGetListOfBoxOffice parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Arbainexchange$RequestGetListOfBoxOffice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Arbainexchange$RequestGetListOfBoxOffice parseFrom(AbstractC2383g abstractC2383g) {
        return (Arbainexchange$RequestGetListOfBoxOffice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Arbainexchange$RequestGetListOfBoxOffice parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Arbainexchange$RequestGetListOfBoxOffice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Arbainexchange$RequestGetListOfBoxOffice parseFrom(byte[] bArr) {
        return (Arbainexchange$RequestGetListOfBoxOffice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Arbainexchange$RequestGetListOfBoxOffice parseFrom(byte[] bArr, C2394s c2394s) {
        return (Arbainexchange$RequestGetListOfBoxOffice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Arbainexchange$RequestGetListOfBoxOffice parseFrom(InputStream inputStream) {
        return (Arbainexchange$RequestGetListOfBoxOffice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Arbainexchange$RequestGetListOfBoxOffice parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Arbainexchange$RequestGetListOfBoxOffice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Arbainexchange$RequestGetListOfBoxOffice parseFrom(AbstractC2384h abstractC2384h) {
        return (Arbainexchange$RequestGetListOfBoxOffice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Arbainexchange$RequestGetListOfBoxOffice parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Arbainexchange$RequestGetListOfBoxOffice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
