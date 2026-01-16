package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC15705k20;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class Balebank$ResponseGetWinners extends GeneratedMessageLite implements U64 {
    private static final Balebank$ResponseGetWinners DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int WINNERS_FIELD_NUMBER = 1;
    private B.j winners_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Balebank$ResponseGetWinners.DEFAULT_INSTANCE);
        }
    }

    static {
        Balebank$ResponseGetWinners balebank$ResponseGetWinners = new Balebank$ResponseGetWinners();
        DEFAULT_INSTANCE = balebank$ResponseGetWinners;
        GeneratedMessageLite.registerDefaultInstance(Balebank$ResponseGetWinners.class, balebank$ResponseGetWinners);
    }

    private Balebank$ResponseGetWinners() {
    }

    private void addAllWinners(Iterable<? extends Balebank$GoldGiftPacketWinner> iterable) {
        ensureWinnersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.winners_);
    }

    private void addWinners(Balebank$GoldGiftPacketWinner balebank$GoldGiftPacketWinner) {
        balebank$GoldGiftPacketWinner.getClass();
        ensureWinnersIsMutable();
        this.winners_.add(balebank$GoldGiftPacketWinner);
    }

    private void clearWinners() {
        this.winners_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureWinnersIsMutable() {
        B.j jVar = this.winners_;
        if (jVar.u()) {
            return;
        }
        this.winners_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static Balebank$ResponseGetWinners getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Balebank$ResponseGetWinners parseDelimitedFrom(InputStream inputStream) {
        return (Balebank$ResponseGetWinners) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Balebank$ResponseGetWinners parseFrom(ByteBuffer byteBuffer) {
        return (Balebank$ResponseGetWinners) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeWinners(int i) {
        ensureWinnersIsMutable();
        this.winners_.remove(i);
    }

    private void setWinners(int i, Balebank$GoldGiftPacketWinner balebank$GoldGiftPacketWinner) {
        balebank$GoldGiftPacketWinner.getClass();
        ensureWinnersIsMutable();
        this.winners_.set(i, balebank$GoldGiftPacketWinner);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1873m.a[gVar.ordinal()]) {
            case 1:
                return new Balebank$ResponseGetWinners();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"winners_", Balebank$GoldGiftPacketWinner.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Balebank$ResponseGetWinners.class) {
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

    public Balebank$GoldGiftPacketWinner getWinners(int i) {
        return (Balebank$GoldGiftPacketWinner) this.winners_.get(i);
    }

    public int getWinnersCount() {
        return this.winners_.size();
    }

    public List<Balebank$GoldGiftPacketWinner> getWinnersList() {
        return this.winners_;
    }

    public InterfaceC15705k20 getWinnersOrBuilder(int i) {
        return (InterfaceC15705k20) this.winners_.get(i);
    }

    public List<? extends InterfaceC15705k20> getWinnersOrBuilderList() {
        return this.winners_;
    }

    public static a newBuilder(Balebank$ResponseGetWinners balebank$ResponseGetWinners) {
        return (a) DEFAULT_INSTANCE.createBuilder(balebank$ResponseGetWinners);
    }

    public static Balebank$ResponseGetWinners parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Balebank$ResponseGetWinners) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Balebank$ResponseGetWinners parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Balebank$ResponseGetWinners) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Balebank$ResponseGetWinners parseFrom(AbstractC2383g abstractC2383g) {
        return (Balebank$ResponseGetWinners) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addWinners(int i, Balebank$GoldGiftPacketWinner balebank$GoldGiftPacketWinner) {
        balebank$GoldGiftPacketWinner.getClass();
        ensureWinnersIsMutable();
        this.winners_.add(i, balebank$GoldGiftPacketWinner);
    }

    public static Balebank$ResponseGetWinners parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Balebank$ResponseGetWinners) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Balebank$ResponseGetWinners parseFrom(byte[] bArr) {
        return (Balebank$ResponseGetWinners) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Balebank$ResponseGetWinners parseFrom(byte[] bArr, C2394s c2394s) {
        return (Balebank$ResponseGetWinners) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Balebank$ResponseGetWinners parseFrom(InputStream inputStream) {
        return (Balebank$ResponseGetWinners) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Balebank$ResponseGetWinners parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Balebank$ResponseGetWinners) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Balebank$ResponseGetWinners parseFrom(AbstractC2384h abstractC2384h) {
        return (Balebank$ResponseGetWinners) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Balebank$ResponseGetWinners parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Balebank$ResponseGetWinners) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
