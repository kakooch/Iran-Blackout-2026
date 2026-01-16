package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC4422Fb2;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes9.dex */
public final class EvexOuterClass$ResponseGetValidBanks extends GeneratedMessageLite implements U64 {
    public static final int BANKS_FIELD_NUMBER = 1;
    private static final EvexOuterClass$ResponseGetValidBanks DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private static final B.h.a banks_converter_ = new a();
    private int banksMemoizedSerializedSize;
    private B.g banks_ = GeneratedMessageLite.emptyIntList();

    class a implements B.h.a {
        a() {
        }

        @Override // com.google.protobuf.B.h.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC4422Fb2 a(Integer num) {
            EnumC4422Fb2 enumC4422Fb2J = EnumC4422Fb2.j(num.intValue());
            return enumC4422Fb2J == null ? EnumC4422Fb2.UNRECOGNIZED : enumC4422Fb2J;
        }
    }

    public static final class b extends GeneratedMessageLite.b implements U64 {
        private b() {
            super(EvexOuterClass$ResponseGetValidBanks.DEFAULT_INSTANCE);
        }
    }

    static {
        EvexOuterClass$ResponseGetValidBanks evexOuterClass$ResponseGetValidBanks = new EvexOuterClass$ResponseGetValidBanks();
        DEFAULT_INSTANCE = evexOuterClass$ResponseGetValidBanks;
        GeneratedMessageLite.registerDefaultInstance(EvexOuterClass$ResponseGetValidBanks.class, evexOuterClass$ResponseGetValidBanks);
    }

    private EvexOuterClass$ResponseGetValidBanks() {
    }

    private void addAllBanks(Iterable<? extends EnumC4422Fb2> iterable) {
        ensureBanksIsMutable();
        Iterator<? extends EnumC4422Fb2> it = iterable.iterator();
        while (it.hasNext()) {
            this.banks_.b1(it.next().getNumber());
        }
    }

    private void addAllBanksValue(Iterable<Integer> iterable) {
        ensureBanksIsMutable();
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext()) {
            this.banks_.b1(it.next().intValue());
        }
    }

    private void addBanks(EnumC4422Fb2 enumC4422Fb2) {
        enumC4422Fb2.getClass();
        ensureBanksIsMutable();
        this.banks_.b1(enumC4422Fb2.getNumber());
    }

    private void addBanksValue(int i) {
        ensureBanksIsMutable();
        this.banks_.b1(i);
    }

    private void clearBanks() {
        this.banks_ = GeneratedMessageLite.emptyIntList();
    }

    private void ensureBanksIsMutable() {
        B.g gVar = this.banks_;
        if (gVar.u()) {
            return;
        }
        this.banks_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    public static EvexOuterClass$ResponseGetValidBanks getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static EvexOuterClass$ResponseGetValidBanks parseDelimitedFrom(InputStream inputStream) {
        return (EvexOuterClass$ResponseGetValidBanks) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EvexOuterClass$ResponseGetValidBanks parseFrom(ByteBuffer byteBuffer) {
        return (EvexOuterClass$ResponseGetValidBanks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBanks(int i, EnumC4422Fb2 enumC4422Fb2) {
        enumC4422Fb2.getClass();
        ensureBanksIsMutable();
        this.banks_.U(i, enumC4422Fb2.getNumber());
    }

    private void setBanksValue(int i, int i2) {
        ensureBanksIsMutable();
        this.banks_.U(i, i2);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (S.a[gVar.ordinal()]) {
            case 1:
                return new EvexOuterClass$ResponseGetValidBanks();
            case 2:
                return new b();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001,", new Object[]{"banks_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (EvexOuterClass$ResponseGetValidBanks.class) {
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

    public EnumC4422Fb2 getBanks(int i) {
        EnumC4422Fb2 enumC4422Fb2J = EnumC4422Fb2.j(this.banks_.getInt(i));
        return enumC4422Fb2J == null ? EnumC4422Fb2.UNRECOGNIZED : enumC4422Fb2J;
    }

    public int getBanksCount() {
        return this.banks_.size();
    }

    public List<EnumC4422Fb2> getBanksList() {
        return new B.h(this.banks_, banks_converter_);
    }

    public int getBanksValue(int i) {
        return this.banks_.getInt(i);
    }

    public List<Integer> getBanksValueList() {
        return this.banks_;
    }

    public static b newBuilder(EvexOuterClass$ResponseGetValidBanks evexOuterClass$ResponseGetValidBanks) {
        return (b) DEFAULT_INSTANCE.createBuilder(evexOuterClass$ResponseGetValidBanks);
    }

    public static EvexOuterClass$ResponseGetValidBanks parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (EvexOuterClass$ResponseGetValidBanks) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static EvexOuterClass$ResponseGetValidBanks parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (EvexOuterClass$ResponseGetValidBanks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static EvexOuterClass$ResponseGetValidBanks parseFrom(AbstractC2383g abstractC2383g) {
        return (EvexOuterClass$ResponseGetValidBanks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static EvexOuterClass$ResponseGetValidBanks parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (EvexOuterClass$ResponseGetValidBanks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static EvexOuterClass$ResponseGetValidBanks parseFrom(byte[] bArr) {
        return (EvexOuterClass$ResponseGetValidBanks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static EvexOuterClass$ResponseGetValidBanks parseFrom(byte[] bArr, C2394s c2394s) {
        return (EvexOuterClass$ResponseGetValidBanks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static EvexOuterClass$ResponseGetValidBanks parseFrom(InputStream inputStream) {
        return (EvexOuterClass$ResponseGetValidBanks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EvexOuterClass$ResponseGetValidBanks parseFrom(InputStream inputStream, C2394s c2394s) {
        return (EvexOuterClass$ResponseGetValidBanks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static EvexOuterClass$ResponseGetValidBanks parseFrom(AbstractC2384h abstractC2384h) {
        return (EvexOuterClass$ResponseGetValidBanks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static EvexOuterClass$ResponseGetValidBanks parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (EvexOuterClass$ResponseGetValidBanks) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
