package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC7318Rf;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes9.dex */
public final class AdvertisementStruct$LocationsTarget extends GeneratedMessageLite implements U64 {
    private static final AdvertisementStruct$LocationsTarget DEFAULT_INSTANCE;
    public static final int LOCATIONS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private static final B.h.a locations_converter_ = new a();
    private int locationsMemoizedSerializedSize;
    private B.g locations_ = GeneratedMessageLite.emptyIntList();

    class a implements B.h.a {
        a() {
        }

        @Override // com.google.protobuf.B.h.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC7318Rf a(Integer num) {
            EnumC7318Rf enumC7318RfJ = EnumC7318Rf.j(num.intValue());
            return enumC7318RfJ == null ? EnumC7318Rf.UNRECOGNIZED : enumC7318RfJ;
        }
    }

    public static final class b extends GeneratedMessageLite.b implements U64 {
        private b() {
            super(AdvertisementStruct$LocationsTarget.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementStruct$LocationsTarget advertisementStruct$LocationsTarget = new AdvertisementStruct$LocationsTarget();
        DEFAULT_INSTANCE = advertisementStruct$LocationsTarget;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementStruct$LocationsTarget.class, advertisementStruct$LocationsTarget);
    }

    private AdvertisementStruct$LocationsTarget() {
    }

    private void addAllLocations(Iterable<? extends EnumC7318Rf> iterable) {
        ensureLocationsIsMutable();
        Iterator<? extends EnumC7318Rf> it = iterable.iterator();
        while (it.hasNext()) {
            this.locations_.b1(it.next().getNumber());
        }
    }

    private void addAllLocationsValue(Iterable<Integer> iterable) {
        ensureLocationsIsMutable();
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext()) {
            this.locations_.b1(it.next().intValue());
        }
    }

    private void addLocations(EnumC7318Rf enumC7318Rf) {
        enumC7318Rf.getClass();
        ensureLocationsIsMutable();
        this.locations_.b1(enumC7318Rf.getNumber());
    }

    private void addLocationsValue(int i) {
        ensureLocationsIsMutable();
        this.locations_.b1(i);
    }

    private void clearLocations() {
        this.locations_ = GeneratedMessageLite.emptyIntList();
    }

    private void ensureLocationsIsMutable() {
        B.g gVar = this.locations_;
        if (gVar.u()) {
            return;
        }
        this.locations_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    public static AdvertisementStruct$LocationsTarget getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementStruct$LocationsTarget parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementStruct$LocationsTarget) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$LocationsTarget parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementStruct$LocationsTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setLocations(int i, EnumC7318Rf enumC7318Rf) {
        enumC7318Rf.getClass();
        ensureLocationsIsMutable();
        this.locations_.U(i, enumC7318Rf.getNumber());
    }

    private void setLocationsValue(int i, int i2) {
        ensureLocationsIsMutable();
        this.locations_.U(i, i2);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1843c.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementStruct$LocationsTarget();
            case 2:
                return new b();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001,", new Object[]{"locations_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementStruct$LocationsTarget.class) {
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

    public EnumC7318Rf getLocations(int i) {
        EnumC7318Rf enumC7318RfJ = EnumC7318Rf.j(this.locations_.getInt(i));
        return enumC7318RfJ == null ? EnumC7318Rf.UNRECOGNIZED : enumC7318RfJ;
    }

    public int getLocationsCount() {
        return this.locations_.size();
    }

    public List<EnumC7318Rf> getLocationsList() {
        return new B.h(this.locations_, locations_converter_);
    }

    public int getLocationsValue(int i) {
        return this.locations_.getInt(i);
    }

    public List<Integer> getLocationsValueList() {
        return this.locations_;
    }

    public static b newBuilder(AdvertisementStruct$LocationsTarget advertisementStruct$LocationsTarget) {
        return (b) DEFAULT_INSTANCE.createBuilder(advertisementStruct$LocationsTarget);
    }

    public static AdvertisementStruct$LocationsTarget parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$LocationsTarget) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$LocationsTarget parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementStruct$LocationsTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementStruct$LocationsTarget parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementStruct$LocationsTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementStruct$LocationsTarget parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementStruct$LocationsTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementStruct$LocationsTarget parseFrom(byte[] bArr) {
        return (AdvertisementStruct$LocationsTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementStruct$LocationsTarget parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementStruct$LocationsTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementStruct$LocationsTarget parseFrom(InputStream inputStream) {
        return (AdvertisementStruct$LocationsTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$LocationsTarget parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$LocationsTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$LocationsTarget parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementStruct$LocationsTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementStruct$LocationsTarget parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementStruct$LocationsTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
