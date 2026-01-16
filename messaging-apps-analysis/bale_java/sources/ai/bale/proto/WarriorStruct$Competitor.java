package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC17506n48;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class WarriorStruct$Competitor extends GeneratedMessageLite implements InterfaceC17506n48 {
    private static final WarriorStruct$Competitor DEFAULT_INSTANCE;
    public static final int MASKED_PHONE_NUMBER_FIELD_NUMBER = 1;
    public static final int ME_FIELD_NUMBER = 3;
    public static final int NAME_FIELD_NUMBER = 5;
    public static final int NUMBER_OF_GEMS_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int RANK_FIELD_NUMBER = 4;
    private boolean me_;
    private int numberOfGems_;
    private int rank_;
    private String maskedPhoneNumber_ = "";
    private String name_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC17506n48 {
        private a() {
            super(WarriorStruct$Competitor.DEFAULT_INSTANCE);
        }
    }

    static {
        WarriorStruct$Competitor warriorStruct$Competitor = new WarriorStruct$Competitor();
        DEFAULT_INSTANCE = warriorStruct$Competitor;
        GeneratedMessageLite.registerDefaultInstance(WarriorStruct$Competitor.class, warriorStruct$Competitor);
    }

    private WarriorStruct$Competitor() {
    }

    private void clearMaskedPhoneNumber() {
        this.maskedPhoneNumber_ = getDefaultInstance().getMaskedPhoneNumber();
    }

    private void clearMe() {
        this.me_ = false;
    }

    private void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    private void clearNumberOfGems() {
        this.numberOfGems_ = 0;
    }

    private void clearRank() {
        this.rank_ = 0;
    }

    public static WarriorStruct$Competitor getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static WarriorStruct$Competitor parseDelimitedFrom(InputStream inputStream) {
        return (WarriorStruct$Competitor) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WarriorStruct$Competitor parseFrom(ByteBuffer byteBuffer) {
        return (WarriorStruct$Competitor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setMaskedPhoneNumber(String str) {
        str.getClass();
        this.maskedPhoneNumber_ = str;
    }

    private void setMaskedPhoneNumberBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.maskedPhoneNumber_ = abstractC2383g.f0();
    }

    private void setMe(boolean z) {
        this.me_ = z;
    }

    private void setName(String str) {
        str.getClass();
        this.name_ = str;
    }

    private void setNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.name_ = abstractC2383g.f0();
    }

    private void setNumberOfGems(int i) {
        this.numberOfGems_ = i;
    }

    private void setRank(int i) {
        this.rank_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (x2.a[gVar.ordinal()]) {
            case 1:
                return new WarriorStruct$Competitor();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002\u0004\u0003\u0007\u0004\u0004\u0005Ȉ", new Object[]{"maskedPhoneNumber_", "numberOfGems_", "me_", "rank_", "name_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (WarriorStruct$Competitor.class) {
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

    public String getMaskedPhoneNumber() {
        return this.maskedPhoneNumber_;
    }

    public AbstractC2383g getMaskedPhoneNumberBytes() {
        return AbstractC2383g.N(this.maskedPhoneNumber_);
    }

    public boolean getMe() {
        return this.me_;
    }

    public String getName() {
        return this.name_;
    }

    public AbstractC2383g getNameBytes() {
        return AbstractC2383g.N(this.name_);
    }

    public int getNumberOfGems() {
        return this.numberOfGems_;
    }

    public int getRank() {
        return this.rank_;
    }

    public static a newBuilder(WarriorStruct$Competitor warriorStruct$Competitor) {
        return (a) DEFAULT_INSTANCE.createBuilder(warriorStruct$Competitor);
    }

    public static WarriorStruct$Competitor parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (WarriorStruct$Competitor) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WarriorStruct$Competitor parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (WarriorStruct$Competitor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static WarriorStruct$Competitor parseFrom(AbstractC2383g abstractC2383g) {
        return (WarriorStruct$Competitor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static WarriorStruct$Competitor parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (WarriorStruct$Competitor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static WarriorStruct$Competitor parseFrom(byte[] bArr) {
        return (WarriorStruct$Competitor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static WarriorStruct$Competitor parseFrom(byte[] bArr, C2394s c2394s) {
        return (WarriorStruct$Competitor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static WarriorStruct$Competitor parseFrom(InputStream inputStream) {
        return (WarriorStruct$Competitor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WarriorStruct$Competitor parseFrom(InputStream inputStream, C2394s c2394s) {
        return (WarriorStruct$Competitor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WarriorStruct$Competitor parseFrom(AbstractC2384h abstractC2384h) {
        return (WarriorStruct$Competitor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static WarriorStruct$Competitor parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (WarriorStruct$Competitor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
