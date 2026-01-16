package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MeetOuterClass$RequestStartSipCall extends GeneratedMessageLite implements U64 {
    public static final int CALLEE_PHONE_FIELD_NUMBER = 3;
    public static final int CALLER_PHONE_FIELD_NUMBER = 2;
    private static final MeetOuterClass$RequestStartSipCall DEFAULT_INSTANCE;
    public static final int IMEI_FIELD_NUMBER = 4;
    public static final int LAT_FIELD_NUMBER = 5;
    public static final int LON_FIELD_NUMBER = 6;
    private static volatile KW4 PARSER = null;
    public static final int RID_FIELD_NUMBER = 1;
    private int bitField0_;
    private StringValue imei_;
    private double lat_;
    private double lon_;
    private long rid_;
    private String callerPhone_ = "";
    private String calleePhone_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MeetOuterClass$RequestStartSipCall.DEFAULT_INSTANCE);
        }
    }

    static {
        MeetOuterClass$RequestStartSipCall meetOuterClass$RequestStartSipCall = new MeetOuterClass$RequestStartSipCall();
        DEFAULT_INSTANCE = meetOuterClass$RequestStartSipCall;
        GeneratedMessageLite.registerDefaultInstance(MeetOuterClass$RequestStartSipCall.class, meetOuterClass$RequestStartSipCall);
    }

    private MeetOuterClass$RequestStartSipCall() {
    }

    private void clearCalleePhone() {
        this.calleePhone_ = getDefaultInstance().getCalleePhone();
    }

    private void clearCallerPhone() {
        this.callerPhone_ = getDefaultInstance().getCallerPhone();
    }

    private void clearImei() {
        this.imei_ = null;
        this.bitField0_ &= -2;
    }

    private void clearLat() {
        this.lat_ = 0.0d;
    }

    private void clearLon() {
        this.lon_ = 0.0d;
    }

    private void clearRid() {
        this.rid_ = 0L;
    }

    public static MeetOuterClass$RequestStartSipCall getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeImei(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.imei_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.imei_ = stringValue;
        } else {
            this.imei_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.imei_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MeetOuterClass$RequestStartSipCall parseDelimitedFrom(InputStream inputStream) {
        return (MeetOuterClass$RequestStartSipCall) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$RequestStartSipCall parseFrom(ByteBuffer byteBuffer) {
        return (MeetOuterClass$RequestStartSipCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCalleePhone(String str) {
        str.getClass();
        this.calleePhone_ = str;
    }

    private void setCalleePhoneBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.calleePhone_ = abstractC2383g.f0();
    }

    private void setCallerPhone(String str) {
        str.getClass();
        this.callerPhone_ = str;
    }

    private void setCallerPhoneBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.callerPhone_ = abstractC2383g.f0();
    }

    private void setImei(StringValue stringValue) {
        stringValue.getClass();
        this.imei_ = stringValue;
        this.bitField0_ |= 1;
    }

    private void setLat(double d) {
        this.lat_ = d;
    }

    private void setLon(double d) {
        this.lon_ = d;
    }

    private void setRid(long j) {
        this.rid_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (F0.a[gVar.ordinal()]) {
            case 1:
                return new MeetOuterClass$RequestStartSipCall();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u0002\u0002Ȉ\u0003Ȉ\u0004ဉ\u0000\u0005\u0000\u0006\u0000", new Object[]{"bitField0_", "rid_", "callerPhone_", "calleePhone_", "imei_", "lat_", "lon_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MeetOuterClass$RequestStartSipCall.class) {
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

    public String getCalleePhone() {
        return this.calleePhone_;
    }

    public AbstractC2383g getCalleePhoneBytes() {
        return AbstractC2383g.N(this.calleePhone_);
    }

    public String getCallerPhone() {
        return this.callerPhone_;
    }

    public AbstractC2383g getCallerPhoneBytes() {
        return AbstractC2383g.N(this.callerPhone_);
    }

    public StringValue getImei() {
        StringValue stringValue = this.imei_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public double getLat() {
        return this.lat_;
    }

    public double getLon() {
        return this.lon_;
    }

    public long getRid() {
        return this.rid_;
    }

    public boolean hasImei() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MeetOuterClass$RequestStartSipCall meetOuterClass$RequestStartSipCall) {
        return (a) DEFAULT_INSTANCE.createBuilder(meetOuterClass$RequestStartSipCall);
    }

    public static MeetOuterClass$RequestStartSipCall parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$RequestStartSipCall) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$RequestStartSipCall parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MeetOuterClass$RequestStartSipCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MeetOuterClass$RequestStartSipCall parseFrom(AbstractC2383g abstractC2383g) {
        return (MeetOuterClass$RequestStartSipCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MeetOuterClass$RequestStartSipCall parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MeetOuterClass$RequestStartSipCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MeetOuterClass$RequestStartSipCall parseFrom(byte[] bArr) {
        return (MeetOuterClass$RequestStartSipCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MeetOuterClass$RequestStartSipCall parseFrom(byte[] bArr, C2394s c2394s) {
        return (MeetOuterClass$RequestStartSipCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MeetOuterClass$RequestStartSipCall parseFrom(InputStream inputStream) {
        return (MeetOuterClass$RequestStartSipCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$RequestStartSipCall parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$RequestStartSipCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$RequestStartSipCall parseFrom(AbstractC2384h abstractC2384h) {
        return (MeetOuterClass$RequestStartSipCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MeetOuterClass$RequestStartSipCall parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MeetOuterClass$RequestStartSipCall) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
