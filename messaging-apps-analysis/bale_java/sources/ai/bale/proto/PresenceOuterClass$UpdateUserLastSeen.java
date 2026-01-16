package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.EnumC4791Go5;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class PresenceOuterClass$UpdateUserLastSeen extends GeneratedMessageLite implements U64 {
    public static final int DATE_FIELD_NUMBER = 2;
    private static final PresenceOuterClass$UpdateUserLastSeen DEFAULT_INSTANCE;
    public static final int DEVICE_CATEGORY_FIELD_NUMBER = 4;
    public static final int DEVICE_TYPE_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int UID_FIELD_NUMBER = 1;
    private int bitField0_;
    private long date_;
    private StringValue deviceCategory_;
    private int deviceType_;
    private int uid_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PresenceOuterClass$UpdateUserLastSeen.DEFAULT_INSTANCE);
        }
    }

    static {
        PresenceOuterClass$UpdateUserLastSeen presenceOuterClass$UpdateUserLastSeen = new PresenceOuterClass$UpdateUserLastSeen();
        DEFAULT_INSTANCE = presenceOuterClass$UpdateUserLastSeen;
        GeneratedMessageLite.registerDefaultInstance(PresenceOuterClass$UpdateUserLastSeen.class, presenceOuterClass$UpdateUserLastSeen);
    }

    private PresenceOuterClass$UpdateUserLastSeen() {
    }

    private void clearDate() {
        this.date_ = 0L;
    }

    private void clearDeviceCategory() {
        this.deviceCategory_ = null;
        this.bitField0_ &= -2;
    }

    private void clearDeviceType() {
        this.deviceType_ = 0;
    }

    private void clearUid() {
        this.uid_ = 0;
    }

    public static PresenceOuterClass$UpdateUserLastSeen getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeDeviceCategory(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.deviceCategory_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.deviceCategory_ = stringValue;
        } else {
            this.deviceCategory_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.deviceCategory_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PresenceOuterClass$UpdateUserLastSeen parseDelimitedFrom(InputStream inputStream) {
        return (PresenceOuterClass$UpdateUserLastSeen) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PresenceOuterClass$UpdateUserLastSeen parseFrom(ByteBuffer byteBuffer) {
        return (PresenceOuterClass$UpdateUserLastSeen) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDate(long j) {
        this.date_ = j;
    }

    private void setDeviceCategory(StringValue stringValue) {
        stringValue.getClass();
        this.deviceCategory_ = stringValue;
        this.bitField0_ |= 1;
    }

    private void setDeviceType(EnumC4791Go5 enumC4791Go5) {
        this.deviceType_ = enumC4791Go5.getNumber();
    }

    private void setDeviceTypeValue(int i) {
        this.deviceType_ = i;
    }

    private void setUid(int i) {
        this.uid_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1866j1.a[gVar.ordinal()]) {
            case 1:
                return new PresenceOuterClass$UpdateUserLastSeen();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0004\u0002\u0002\u0003\f\u0004ဉ\u0000", new Object[]{"bitField0_", "uid_", "date_", "deviceType_", "deviceCategory_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PresenceOuterClass$UpdateUserLastSeen.class) {
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

    public long getDate() {
        return this.date_;
    }

    public StringValue getDeviceCategory() {
        StringValue stringValue = this.deviceCategory_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public EnumC4791Go5 getDeviceType() {
        EnumC4791Go5 enumC4791Go5J = EnumC4791Go5.j(this.deviceType_);
        return enumC4791Go5J == null ? EnumC4791Go5.UNRECOGNIZED : enumC4791Go5J;
    }

    public int getDeviceTypeValue() {
        return this.deviceType_;
    }

    public int getUid() {
        return this.uid_;
    }

    public boolean hasDeviceCategory() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(PresenceOuterClass$UpdateUserLastSeen presenceOuterClass$UpdateUserLastSeen) {
        return (a) DEFAULT_INSTANCE.createBuilder(presenceOuterClass$UpdateUserLastSeen);
    }

    public static PresenceOuterClass$UpdateUserLastSeen parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PresenceOuterClass$UpdateUserLastSeen) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PresenceOuterClass$UpdateUserLastSeen parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PresenceOuterClass$UpdateUserLastSeen) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PresenceOuterClass$UpdateUserLastSeen parseFrom(AbstractC2383g abstractC2383g) {
        return (PresenceOuterClass$UpdateUserLastSeen) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PresenceOuterClass$UpdateUserLastSeen parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PresenceOuterClass$UpdateUserLastSeen) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PresenceOuterClass$UpdateUserLastSeen parseFrom(byte[] bArr) {
        return (PresenceOuterClass$UpdateUserLastSeen) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PresenceOuterClass$UpdateUserLastSeen parseFrom(byte[] bArr, C2394s c2394s) {
        return (PresenceOuterClass$UpdateUserLastSeen) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PresenceOuterClass$UpdateUserLastSeen parseFrom(InputStream inputStream) {
        return (PresenceOuterClass$UpdateUserLastSeen) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PresenceOuterClass$UpdateUserLastSeen parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PresenceOuterClass$UpdateUserLastSeen) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PresenceOuterClass$UpdateUserLastSeen parseFrom(AbstractC2384h abstractC2384h) {
        return (PresenceOuterClass$UpdateUserLastSeen) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PresenceOuterClass$UpdateUserLastSeen parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PresenceOuterClass$UpdateUserLastSeen) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
