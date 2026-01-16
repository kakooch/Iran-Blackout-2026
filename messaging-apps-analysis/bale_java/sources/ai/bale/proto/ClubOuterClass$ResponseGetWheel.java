package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC22596vW0;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class ClubOuterClass$ResponseGetWheel extends GeneratedMessageLite implements U64 {
    public static final int CHANCES_FIELD_NUMBER = 1;
    private static final ClubOuterClass$ResponseGetWheel DEFAULT_INSTANCE;
    public static final int HISTORY_ID_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int PRIZES_FIELD_NUMBER = 3;
    private int chances_;
    private String historyId_ = "";
    private B.j prizes_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(ClubOuterClass$ResponseGetWheel.DEFAULT_INSTANCE);
        }
    }

    static {
        ClubOuterClass$ResponseGetWheel clubOuterClass$ResponseGetWheel = new ClubOuterClass$ResponseGetWheel();
        DEFAULT_INSTANCE = clubOuterClass$ResponseGetWheel;
        GeneratedMessageLite.registerDefaultInstance(ClubOuterClass$ResponseGetWheel.class, clubOuterClass$ResponseGetWheel);
    }

    private ClubOuterClass$ResponseGetWheel() {
    }

    private void addAllPrizes(Iterable<? extends ClubStruct$WheelPrize> iterable) {
        ensurePrizesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.prizes_);
    }

    private void addPrizes(ClubStruct$WheelPrize clubStruct$WheelPrize) {
        clubStruct$WheelPrize.getClass();
        ensurePrizesIsMutable();
        this.prizes_.add(clubStruct$WheelPrize);
    }

    private void clearChances() {
        this.chances_ = 0;
    }

    private void clearHistoryId() {
        this.historyId_ = getDefaultInstance().getHistoryId();
    }

    private void clearPrizes() {
        this.prizes_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensurePrizesIsMutable() {
        B.j jVar = this.prizes_;
        if (jVar.u()) {
            return;
        }
        this.prizes_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static ClubOuterClass$ResponseGetWheel getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static ClubOuterClass$ResponseGetWheel parseDelimitedFrom(InputStream inputStream) {
        return (ClubOuterClass$ResponseGetWheel) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ClubOuterClass$ResponseGetWheel parseFrom(ByteBuffer byteBuffer) {
        return (ClubOuterClass$ResponseGetWheel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removePrizes(int i) {
        ensurePrizesIsMutable();
        this.prizes_.remove(i);
    }

    private void setChances(int i) {
        this.chances_ = i;
    }

    private void setHistoryId(String str) {
        str.getClass();
        this.historyId_ = str;
    }

    private void setHistoryIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.historyId_ = abstractC2383g.f0();
    }

    private void setPrizes(int i, ClubStruct$WheelPrize clubStruct$WheelPrize) {
        clubStruct$WheelPrize.getClass();
        ensurePrizesIsMutable();
        this.prizes_.set(i, clubStruct$WheelPrize);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (B.a[gVar.ordinal()]) {
            case 1:
                return new ClubOuterClass$ResponseGetWheel();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u0004\u0002Ȉ\u0003\u001b", new Object[]{"chances_", "historyId_", "prizes_", ClubStruct$WheelPrize.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ClubOuterClass$ResponseGetWheel.class) {
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

    public int getChances() {
        return this.chances_;
    }

    public String getHistoryId() {
        return this.historyId_;
    }

    public AbstractC2383g getHistoryIdBytes() {
        return AbstractC2383g.N(this.historyId_);
    }

    public ClubStruct$WheelPrize getPrizes(int i) {
        return (ClubStruct$WheelPrize) this.prizes_.get(i);
    }

    public int getPrizesCount() {
        return this.prizes_.size();
    }

    public List<ClubStruct$WheelPrize> getPrizesList() {
        return this.prizes_;
    }

    public InterfaceC22596vW0 getPrizesOrBuilder(int i) {
        return (InterfaceC22596vW0) this.prizes_.get(i);
    }

    public List<? extends InterfaceC22596vW0> getPrizesOrBuilderList() {
        return this.prizes_;
    }

    public static a newBuilder(ClubOuterClass$ResponseGetWheel clubOuterClass$ResponseGetWheel) {
        return (a) DEFAULT_INSTANCE.createBuilder(clubOuterClass$ResponseGetWheel);
    }

    public static ClubOuterClass$ResponseGetWheel parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ClubOuterClass$ResponseGetWheel) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ClubOuterClass$ResponseGetWheel parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ClubOuterClass$ResponseGetWheel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ClubOuterClass$ResponseGetWheel parseFrom(AbstractC2383g abstractC2383g) {
        return (ClubOuterClass$ResponseGetWheel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addPrizes(int i, ClubStruct$WheelPrize clubStruct$WheelPrize) {
        clubStruct$WheelPrize.getClass();
        ensurePrizesIsMutable();
        this.prizes_.add(i, clubStruct$WheelPrize);
    }

    public static ClubOuterClass$ResponseGetWheel parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ClubOuterClass$ResponseGetWheel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ClubOuterClass$ResponseGetWheel parseFrom(byte[] bArr) {
        return (ClubOuterClass$ResponseGetWheel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ClubOuterClass$ResponseGetWheel parseFrom(byte[] bArr, C2394s c2394s) {
        return (ClubOuterClass$ResponseGetWheel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ClubOuterClass$ResponseGetWheel parseFrom(InputStream inputStream) {
        return (ClubOuterClass$ResponseGetWheel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ClubOuterClass$ResponseGetWheel parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ClubOuterClass$ResponseGetWheel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ClubOuterClass$ResponseGetWheel parseFrom(AbstractC2384h abstractC2384h) {
        return (ClubOuterClass$ResponseGetWheel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ClubOuterClass$ResponseGetWheel parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ClubOuterClass$ResponseGetWheel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
