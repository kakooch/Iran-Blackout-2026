package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC7084Qf;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class AdvertisementStruct$GenderTarget extends GeneratedMessageLite implements U64 {
    private static final AdvertisementStruct$GenderTarget DEFAULT_INSTANCE;
    public static final int GENDER_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int gender_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementStruct$GenderTarget.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementStruct$GenderTarget advertisementStruct$GenderTarget = new AdvertisementStruct$GenderTarget();
        DEFAULT_INSTANCE = advertisementStruct$GenderTarget;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementStruct$GenderTarget.class, advertisementStruct$GenderTarget);
    }

    private AdvertisementStruct$GenderTarget() {
    }

    private void clearGender() {
        this.gender_ = 0;
    }

    public static AdvertisementStruct$GenderTarget getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementStruct$GenderTarget parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementStruct$GenderTarget) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$GenderTarget parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementStruct$GenderTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setGender(EnumC7084Qf enumC7084Qf) {
        this.gender_ = enumC7084Qf.getNumber();
    }

    private void setGenderValue(int i) {
        this.gender_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1843c.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementStruct$GenderTarget();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"gender_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementStruct$GenderTarget.class) {
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

    public EnumC7084Qf getGender() {
        EnumC7084Qf enumC7084QfJ = EnumC7084Qf.j(this.gender_);
        return enumC7084QfJ == null ? EnumC7084Qf.UNRECOGNIZED : enumC7084QfJ;
    }

    public int getGenderValue() {
        return this.gender_;
    }

    public static a newBuilder(AdvertisementStruct$GenderTarget advertisementStruct$GenderTarget) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementStruct$GenderTarget);
    }

    public static AdvertisementStruct$GenderTarget parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$GenderTarget) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$GenderTarget parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementStruct$GenderTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementStruct$GenderTarget parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementStruct$GenderTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementStruct$GenderTarget parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementStruct$GenderTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementStruct$GenderTarget parseFrom(byte[] bArr) {
        return (AdvertisementStruct$GenderTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementStruct$GenderTarget parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementStruct$GenderTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementStruct$GenderTarget parseFrom(InputStream inputStream) {
        return (AdvertisementStruct$GenderTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$GenderTarget parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$GenderTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$GenderTarget parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementStruct$GenderTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementStruct$GenderTarget parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementStruct$GenderTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
