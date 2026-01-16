package ai.bale.proto;

import ai.bale.proto.ClubStruct$WheelPrize;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class ClubOuterClass$ResponseSpinWheel extends GeneratedMessageLite implements U64 {
    private static final ClubOuterClass$ResponseSpinWheel DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PRIZE_FIELD_NUMBER = 1;
    private int bitField0_;
    private ClubStruct$WheelPrize prize_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(ClubOuterClass$ResponseSpinWheel.DEFAULT_INSTANCE);
        }
    }

    static {
        ClubOuterClass$ResponseSpinWheel clubOuterClass$ResponseSpinWheel = new ClubOuterClass$ResponseSpinWheel();
        DEFAULT_INSTANCE = clubOuterClass$ResponseSpinWheel;
        GeneratedMessageLite.registerDefaultInstance(ClubOuterClass$ResponseSpinWheel.class, clubOuterClass$ResponseSpinWheel);
    }

    private ClubOuterClass$ResponseSpinWheel() {
    }

    private void clearPrize() {
        this.prize_ = null;
        this.bitField0_ &= -2;
    }

    public static ClubOuterClass$ResponseSpinWheel getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePrize(ClubStruct$WheelPrize clubStruct$WheelPrize) {
        clubStruct$WheelPrize.getClass();
        ClubStruct$WheelPrize clubStruct$WheelPrize2 = this.prize_;
        if (clubStruct$WheelPrize2 == null || clubStruct$WheelPrize2 == ClubStruct$WheelPrize.getDefaultInstance()) {
            this.prize_ = clubStruct$WheelPrize;
        } else {
            this.prize_ = (ClubStruct$WheelPrize) ((ClubStruct$WheelPrize.a) ClubStruct$WheelPrize.newBuilder(this.prize_).v(clubStruct$WheelPrize)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static ClubOuterClass$ResponseSpinWheel parseDelimitedFrom(InputStream inputStream) {
        return (ClubOuterClass$ResponseSpinWheel) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ClubOuterClass$ResponseSpinWheel parseFrom(ByteBuffer byteBuffer) {
        return (ClubOuterClass$ResponseSpinWheel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPrize(ClubStruct$WheelPrize clubStruct$WheelPrize) {
        clubStruct$WheelPrize.getClass();
        this.prize_ = clubStruct$WheelPrize;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (B.a[gVar.ordinal()]) {
            case 1:
                return new ClubOuterClass$ResponseSpinWheel();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "prize_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ClubOuterClass$ResponseSpinWheel.class) {
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

    public ClubStruct$WheelPrize getPrize() {
        ClubStruct$WheelPrize clubStruct$WheelPrize = this.prize_;
        return clubStruct$WheelPrize == null ? ClubStruct$WheelPrize.getDefaultInstance() : clubStruct$WheelPrize;
    }

    public boolean hasPrize() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(ClubOuterClass$ResponseSpinWheel clubOuterClass$ResponseSpinWheel) {
        return (a) DEFAULT_INSTANCE.createBuilder(clubOuterClass$ResponseSpinWheel);
    }

    public static ClubOuterClass$ResponseSpinWheel parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ClubOuterClass$ResponseSpinWheel) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ClubOuterClass$ResponseSpinWheel parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ClubOuterClass$ResponseSpinWheel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ClubOuterClass$ResponseSpinWheel parseFrom(AbstractC2383g abstractC2383g) {
        return (ClubOuterClass$ResponseSpinWheel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static ClubOuterClass$ResponseSpinWheel parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ClubOuterClass$ResponseSpinWheel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ClubOuterClass$ResponseSpinWheel parseFrom(byte[] bArr) {
        return (ClubOuterClass$ResponseSpinWheel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ClubOuterClass$ResponseSpinWheel parseFrom(byte[] bArr, C2394s c2394s) {
        return (ClubOuterClass$ResponseSpinWheel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ClubOuterClass$ResponseSpinWheel parseFrom(InputStream inputStream) {
        return (ClubOuterClass$ResponseSpinWheel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ClubOuterClass$ResponseSpinWheel parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ClubOuterClass$ResponseSpinWheel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ClubOuterClass$ResponseSpinWheel parseFrom(AbstractC2384h abstractC2384h) {
        return (ClubOuterClass$ResponseSpinWheel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ClubOuterClass$ResponseSpinWheel parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ClubOuterClass$ResponseSpinWheel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
