package io.envoyproxy.pgv.validate;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import io.envoyproxy.pgv.validate.Validate$AnyRules;
import io.envoyproxy.pgv.validate.Validate$BoolRules;
import io.envoyproxy.pgv.validate.Validate$BytesRules;
import io.envoyproxy.pgv.validate.Validate$DoubleRules;
import io.envoyproxy.pgv.validate.Validate$DurationRules;
import io.envoyproxy.pgv.validate.Validate$EnumRules;
import io.envoyproxy.pgv.validate.Validate$Fixed32Rules;
import io.envoyproxy.pgv.validate.Validate$Fixed64Rules;
import io.envoyproxy.pgv.validate.Validate$FloatRules;
import io.envoyproxy.pgv.validate.Validate$Int32Rules;
import io.envoyproxy.pgv.validate.Validate$Int64Rules;
import io.envoyproxy.pgv.validate.Validate$MapRules;
import io.envoyproxy.pgv.validate.Validate$MessageRules;
import io.envoyproxy.pgv.validate.Validate$RepeatedRules;
import io.envoyproxy.pgv.validate.Validate$SFixed32Rules;
import io.envoyproxy.pgv.validate.Validate$SFixed64Rules;
import io.envoyproxy.pgv.validate.Validate$SInt32Rules;
import io.envoyproxy.pgv.validate.Validate$SInt64Rules;
import io.envoyproxy.pgv.validate.Validate$StringRules;
import io.envoyproxy.pgv.validate.Validate$TimestampRules;
import io.envoyproxy.pgv.validate.Validate$UInt32Rules;
import io.envoyproxy.pgv.validate.Validate$UInt64Rules;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public final class Validate$FieldRules extends GeneratedMessageLite implements U64 {
    public static final int ANY_FIELD_NUMBER = 20;
    public static final int BOOL_FIELD_NUMBER = 13;
    public static final int BYTES_FIELD_NUMBER = 15;
    private static final Validate$FieldRules DEFAULT_INSTANCE;
    public static final int DOUBLE_FIELD_NUMBER = 2;
    public static final int DURATION_FIELD_NUMBER = 21;
    public static final int ENUM_FIELD_NUMBER = 16;
    public static final int FIXED32_FIELD_NUMBER = 9;
    public static final int FIXED64_FIELD_NUMBER = 10;
    public static final int FLOAT_FIELD_NUMBER = 1;
    public static final int INT32_FIELD_NUMBER = 3;
    public static final int INT64_FIELD_NUMBER = 4;
    public static final int MAP_FIELD_NUMBER = 19;
    public static final int MESSAGE_FIELD_NUMBER = 17;
    private static volatile KW4 PARSER = null;
    public static final int REPEATED_FIELD_NUMBER = 18;
    public static final int SFIXED32_FIELD_NUMBER = 11;
    public static final int SFIXED64_FIELD_NUMBER = 12;
    public static final int SINT32_FIELD_NUMBER = 7;
    public static final int SINT64_FIELD_NUMBER = 8;
    public static final int STRING_FIELD_NUMBER = 14;
    public static final int TIMESTAMP_FIELD_NUMBER = 22;
    public static final int UINT32_FIELD_NUMBER = 5;
    public static final int UINT64_FIELD_NUMBER = 6;
    private int bitField0_;
    private Validate$MessageRules message_;
    private int typeCase_ = 0;
    private Object type_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Validate$FieldRules.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        FLOAT(1),
        DOUBLE(2),
        INT32(3),
        INT64(4),
        UINT32(5),
        UINT64(6),
        SINT32(7),
        SINT64(8),
        FIXED32(9),
        FIXED64(10),
        SFIXED32(11),
        SFIXED64(12),
        BOOL(13),
        STRING(14),
        BYTES(15),
        ENUM(16),
        REPEATED(18),
        MAP(19),
        ANY(20),
        DURATION(21),
        TIMESTAMP(22),
        TYPE_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            switch (i) {
                case 0:
                    return TYPE_NOT_SET;
                case 1:
                    return FLOAT;
                case 2:
                    return DOUBLE;
                case 3:
                    return INT32;
                case 4:
                    return INT64;
                case 5:
                    return UINT32;
                case 6:
                    return UINT64;
                case 7:
                    return SINT32;
                case 8:
                    return SINT64;
                case 9:
                    return FIXED32;
                case 10:
                    return FIXED64;
                case 11:
                    return SFIXED32;
                case 12:
                    return SFIXED64;
                case 13:
                    return BOOL;
                case 14:
                    return STRING;
                case 15:
                    return BYTES;
                case 16:
                    return ENUM;
                case 17:
                default:
                    return null;
                case 18:
                    return REPEATED;
                case 19:
                    return MAP;
                case 20:
                    return ANY;
                case 21:
                    return DURATION;
                case 22:
                    return TIMESTAMP;
            }
        }
    }

    static {
        Validate$FieldRules validate$FieldRules = new Validate$FieldRules();
        DEFAULT_INSTANCE = validate$FieldRules;
        GeneratedMessageLite.registerDefaultInstance(Validate$FieldRules.class, validate$FieldRules);
    }

    private Validate$FieldRules() {
    }

    private void clearAny() {
        if (this.typeCase_ == 20) {
            this.typeCase_ = 0;
            this.type_ = null;
        }
    }

    private void clearBool() {
        if (this.typeCase_ == 13) {
            this.typeCase_ = 0;
            this.type_ = null;
        }
    }

    private void clearBytes() {
        if (this.typeCase_ == 15) {
            this.typeCase_ = 0;
            this.type_ = null;
        }
    }

    private void clearDouble() {
        if (this.typeCase_ == 2) {
            this.typeCase_ = 0;
            this.type_ = null;
        }
    }

    private void clearDuration() {
        if (this.typeCase_ == 21) {
            this.typeCase_ = 0;
            this.type_ = null;
        }
    }

    private void clearEnum() {
        if (this.typeCase_ == 16) {
            this.typeCase_ = 0;
            this.type_ = null;
        }
    }

    private void clearFixed32() {
        if (this.typeCase_ == 9) {
            this.typeCase_ = 0;
            this.type_ = null;
        }
    }

    private void clearFixed64() {
        if (this.typeCase_ == 10) {
            this.typeCase_ = 0;
            this.type_ = null;
        }
    }

    private void clearFloat() {
        if (this.typeCase_ == 1) {
            this.typeCase_ = 0;
            this.type_ = null;
        }
    }

    private void clearInt32() {
        if (this.typeCase_ == 3) {
            this.typeCase_ = 0;
            this.type_ = null;
        }
    }

    private void clearInt64() {
        if (this.typeCase_ == 4) {
            this.typeCase_ = 0;
            this.type_ = null;
        }
    }

    private void clearMap() {
        if (this.typeCase_ == 19) {
            this.typeCase_ = 0;
            this.type_ = null;
        }
    }

    private void clearMessage() {
        this.message_ = null;
        this.bitField0_ &= -2;
    }

    private void clearRepeated() {
        if (this.typeCase_ == 18) {
            this.typeCase_ = 0;
            this.type_ = null;
        }
    }

    private void clearSfixed32() {
        if (this.typeCase_ == 11) {
            this.typeCase_ = 0;
            this.type_ = null;
        }
    }

    private void clearSfixed64() {
        if (this.typeCase_ == 12) {
            this.typeCase_ = 0;
            this.type_ = null;
        }
    }

    private void clearSint32() {
        if (this.typeCase_ == 7) {
            this.typeCase_ = 0;
            this.type_ = null;
        }
    }

    private void clearSint64() {
        if (this.typeCase_ == 8) {
            this.typeCase_ = 0;
            this.type_ = null;
        }
    }

    private void clearString() {
        if (this.typeCase_ == 14) {
            this.typeCase_ = 0;
            this.type_ = null;
        }
    }

    private void clearTimestamp() {
        if (this.typeCase_ == 22) {
            this.typeCase_ = 0;
            this.type_ = null;
        }
    }

    private void clearType() {
        this.typeCase_ = 0;
        this.type_ = null;
    }

    private void clearUint32() {
        if (this.typeCase_ == 5) {
            this.typeCase_ = 0;
            this.type_ = null;
        }
    }

    private void clearUint64() {
        if (this.typeCase_ == 6) {
            this.typeCase_ = 0;
            this.type_ = null;
        }
    }

    public static Validate$FieldRules getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAny(Validate$AnyRules validate$AnyRules) {
        validate$AnyRules.getClass();
        if (this.typeCase_ != 20 || this.type_ == Validate$AnyRules.getDefaultInstance()) {
            this.type_ = validate$AnyRules;
        } else {
            this.type_ = ((Validate$AnyRules.a) Validate$AnyRules.newBuilder((Validate$AnyRules) this.type_).v(validate$AnyRules)).j();
        }
        this.typeCase_ = 20;
    }

    private void mergeBool(Validate$BoolRules validate$BoolRules) {
        validate$BoolRules.getClass();
        if (this.typeCase_ != 13 || this.type_ == Validate$BoolRules.getDefaultInstance()) {
            this.type_ = validate$BoolRules;
        } else {
            this.type_ = ((Validate$BoolRules.a) Validate$BoolRules.newBuilder((Validate$BoolRules) this.type_).v(validate$BoolRules)).j();
        }
        this.typeCase_ = 13;
    }

    private void mergeBytes(Validate$BytesRules validate$BytesRules) {
        validate$BytesRules.getClass();
        if (this.typeCase_ != 15 || this.type_ == Validate$BytesRules.getDefaultInstance()) {
            this.type_ = validate$BytesRules;
        } else {
            this.type_ = ((Validate$BytesRules.a) Validate$BytesRules.newBuilder((Validate$BytesRules) this.type_).v(validate$BytesRules)).j();
        }
        this.typeCase_ = 15;
    }

    private void mergeDouble(Validate$DoubleRules validate$DoubleRules) {
        validate$DoubleRules.getClass();
        if (this.typeCase_ != 2 || this.type_ == Validate$DoubleRules.getDefaultInstance()) {
            this.type_ = validate$DoubleRules;
        } else {
            this.type_ = ((Validate$DoubleRules.a) Validate$DoubleRules.newBuilder((Validate$DoubleRules) this.type_).v(validate$DoubleRules)).j();
        }
        this.typeCase_ = 2;
    }

    private void mergeDuration(Validate$DurationRules validate$DurationRules) {
        validate$DurationRules.getClass();
        if (this.typeCase_ != 21 || this.type_ == Validate$DurationRules.getDefaultInstance()) {
            this.type_ = validate$DurationRules;
        } else {
            this.type_ = ((Validate$DurationRules.a) Validate$DurationRules.newBuilder((Validate$DurationRules) this.type_).v(validate$DurationRules)).j();
        }
        this.typeCase_ = 21;
    }

    private void mergeEnum(Validate$EnumRules validate$EnumRules) {
        validate$EnumRules.getClass();
        if (this.typeCase_ != 16 || this.type_ == Validate$EnumRules.getDefaultInstance()) {
            this.type_ = validate$EnumRules;
        } else {
            this.type_ = ((Validate$EnumRules.a) Validate$EnumRules.newBuilder((Validate$EnumRules) this.type_).v(validate$EnumRules)).j();
        }
        this.typeCase_ = 16;
    }

    private void mergeFixed32(Validate$Fixed32Rules validate$Fixed32Rules) {
        validate$Fixed32Rules.getClass();
        if (this.typeCase_ != 9 || this.type_ == Validate$Fixed32Rules.getDefaultInstance()) {
            this.type_ = validate$Fixed32Rules;
        } else {
            this.type_ = ((Validate$Fixed32Rules.a) Validate$Fixed32Rules.newBuilder((Validate$Fixed32Rules) this.type_).v(validate$Fixed32Rules)).j();
        }
        this.typeCase_ = 9;
    }

    private void mergeFixed64(Validate$Fixed64Rules validate$Fixed64Rules) {
        validate$Fixed64Rules.getClass();
        if (this.typeCase_ != 10 || this.type_ == Validate$Fixed64Rules.getDefaultInstance()) {
            this.type_ = validate$Fixed64Rules;
        } else {
            this.type_ = ((Validate$Fixed64Rules.a) Validate$Fixed64Rules.newBuilder((Validate$Fixed64Rules) this.type_).v(validate$Fixed64Rules)).j();
        }
        this.typeCase_ = 10;
    }

    private void mergeFloat(Validate$FloatRules validate$FloatRules) {
        validate$FloatRules.getClass();
        if (this.typeCase_ != 1 || this.type_ == Validate$FloatRules.getDefaultInstance()) {
            this.type_ = validate$FloatRules;
        } else {
            this.type_ = ((Validate$FloatRules.a) Validate$FloatRules.newBuilder((Validate$FloatRules) this.type_).v(validate$FloatRules)).j();
        }
        this.typeCase_ = 1;
    }

    private void mergeInt32(Validate$Int32Rules validate$Int32Rules) {
        validate$Int32Rules.getClass();
        if (this.typeCase_ != 3 || this.type_ == Validate$Int32Rules.getDefaultInstance()) {
            this.type_ = validate$Int32Rules;
        } else {
            this.type_ = ((Validate$Int32Rules.a) Validate$Int32Rules.newBuilder((Validate$Int32Rules) this.type_).v(validate$Int32Rules)).j();
        }
        this.typeCase_ = 3;
    }

    private void mergeInt64(Validate$Int64Rules validate$Int64Rules) {
        validate$Int64Rules.getClass();
        if (this.typeCase_ != 4 || this.type_ == Validate$Int64Rules.getDefaultInstance()) {
            this.type_ = validate$Int64Rules;
        } else {
            this.type_ = ((Validate$Int64Rules.a) Validate$Int64Rules.newBuilder((Validate$Int64Rules) this.type_).v(validate$Int64Rules)).j();
        }
        this.typeCase_ = 4;
    }

    private void mergeMap(Validate$MapRules validate$MapRules) {
        validate$MapRules.getClass();
        if (this.typeCase_ != 19 || this.type_ == Validate$MapRules.getDefaultInstance()) {
            this.type_ = validate$MapRules;
        } else {
            this.type_ = ((Validate$MapRules.a) Validate$MapRules.newBuilder((Validate$MapRules) this.type_).v(validate$MapRules)).j();
        }
        this.typeCase_ = 19;
    }

    private void mergeMessage(Validate$MessageRules validate$MessageRules) {
        validate$MessageRules.getClass();
        Validate$MessageRules validate$MessageRules2 = this.message_;
        if (validate$MessageRules2 == null || validate$MessageRules2 == Validate$MessageRules.getDefaultInstance()) {
            this.message_ = validate$MessageRules;
        } else {
            this.message_ = (Validate$MessageRules) ((Validate$MessageRules.a) Validate$MessageRules.newBuilder(this.message_).v(validate$MessageRules)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeRepeated(Validate$RepeatedRules validate$RepeatedRules) {
        validate$RepeatedRules.getClass();
        if (this.typeCase_ != 18 || this.type_ == Validate$RepeatedRules.getDefaultInstance()) {
            this.type_ = validate$RepeatedRules;
        } else {
            this.type_ = ((Validate$RepeatedRules.a) Validate$RepeatedRules.newBuilder((Validate$RepeatedRules) this.type_).v(validate$RepeatedRules)).j();
        }
        this.typeCase_ = 18;
    }

    private void mergeSfixed32(Validate$SFixed32Rules validate$SFixed32Rules) {
        validate$SFixed32Rules.getClass();
        if (this.typeCase_ != 11 || this.type_ == Validate$SFixed32Rules.getDefaultInstance()) {
            this.type_ = validate$SFixed32Rules;
        } else {
            this.type_ = ((Validate$SFixed32Rules.a) Validate$SFixed32Rules.newBuilder((Validate$SFixed32Rules) this.type_).v(validate$SFixed32Rules)).j();
        }
        this.typeCase_ = 11;
    }

    private void mergeSfixed64(Validate$SFixed64Rules validate$SFixed64Rules) {
        validate$SFixed64Rules.getClass();
        if (this.typeCase_ != 12 || this.type_ == Validate$SFixed64Rules.getDefaultInstance()) {
            this.type_ = validate$SFixed64Rules;
        } else {
            this.type_ = ((Validate$SFixed64Rules.a) Validate$SFixed64Rules.newBuilder((Validate$SFixed64Rules) this.type_).v(validate$SFixed64Rules)).j();
        }
        this.typeCase_ = 12;
    }

    private void mergeSint32(Validate$SInt32Rules validate$SInt32Rules) {
        validate$SInt32Rules.getClass();
        if (this.typeCase_ != 7 || this.type_ == Validate$SInt32Rules.getDefaultInstance()) {
            this.type_ = validate$SInt32Rules;
        } else {
            this.type_ = ((Validate$SInt32Rules.a) Validate$SInt32Rules.newBuilder((Validate$SInt32Rules) this.type_).v(validate$SInt32Rules)).j();
        }
        this.typeCase_ = 7;
    }

    private void mergeSint64(Validate$SInt64Rules validate$SInt64Rules) {
        validate$SInt64Rules.getClass();
        if (this.typeCase_ != 8 || this.type_ == Validate$SInt64Rules.getDefaultInstance()) {
            this.type_ = validate$SInt64Rules;
        } else {
            this.type_ = ((Validate$SInt64Rules.a) Validate$SInt64Rules.newBuilder((Validate$SInt64Rules) this.type_).v(validate$SInt64Rules)).j();
        }
        this.typeCase_ = 8;
    }

    private void mergeString(Validate$StringRules validate$StringRules) {
        validate$StringRules.getClass();
        if (this.typeCase_ != 14 || this.type_ == Validate$StringRules.getDefaultInstance()) {
            this.type_ = validate$StringRules;
        } else {
            this.type_ = ((Validate$StringRules.a) Validate$StringRules.newBuilder((Validate$StringRules) this.type_).v(validate$StringRules)).j();
        }
        this.typeCase_ = 14;
    }

    private void mergeTimestamp(Validate$TimestampRules validate$TimestampRules) {
        validate$TimestampRules.getClass();
        if (this.typeCase_ != 22 || this.type_ == Validate$TimestampRules.getDefaultInstance()) {
            this.type_ = validate$TimestampRules;
        } else {
            this.type_ = ((Validate$TimestampRules.a) Validate$TimestampRules.newBuilder((Validate$TimestampRules) this.type_).v(validate$TimestampRules)).j();
        }
        this.typeCase_ = 22;
    }

    private void mergeUint32(Validate$UInt32Rules validate$UInt32Rules) {
        validate$UInt32Rules.getClass();
        if (this.typeCase_ != 5 || this.type_ == Validate$UInt32Rules.getDefaultInstance()) {
            this.type_ = validate$UInt32Rules;
        } else {
            this.type_ = ((Validate$UInt32Rules.a) Validate$UInt32Rules.newBuilder((Validate$UInt32Rules) this.type_).v(validate$UInt32Rules)).j();
        }
        this.typeCase_ = 5;
    }

    private void mergeUint64(Validate$UInt64Rules validate$UInt64Rules) {
        validate$UInt64Rules.getClass();
        if (this.typeCase_ != 6 || this.type_ == Validate$UInt64Rules.getDefaultInstance()) {
            this.type_ = validate$UInt64Rules;
        } else {
            this.type_ = ((Validate$UInt64Rules.a) Validate$UInt64Rules.newBuilder((Validate$UInt64Rules) this.type_).v(validate$UInt64Rules)).j();
        }
        this.typeCase_ = 6;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Validate$FieldRules parseDelimitedFrom(InputStream inputStream) {
        return (Validate$FieldRules) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Validate$FieldRules parseFrom(ByteBuffer byteBuffer) {
        return (Validate$FieldRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAny(Validate$AnyRules validate$AnyRules) {
        validate$AnyRules.getClass();
        this.type_ = validate$AnyRules;
        this.typeCase_ = 20;
    }

    private void setBool(Validate$BoolRules validate$BoolRules) {
        validate$BoolRules.getClass();
        this.type_ = validate$BoolRules;
        this.typeCase_ = 13;
    }

    private void setBytes(Validate$BytesRules validate$BytesRules) {
        validate$BytesRules.getClass();
        this.type_ = validate$BytesRules;
        this.typeCase_ = 15;
    }

    private void setDouble(Validate$DoubleRules validate$DoubleRules) {
        validate$DoubleRules.getClass();
        this.type_ = validate$DoubleRules;
        this.typeCase_ = 2;
    }

    private void setDuration(Validate$DurationRules validate$DurationRules) {
        validate$DurationRules.getClass();
        this.type_ = validate$DurationRules;
        this.typeCase_ = 21;
    }

    private void setEnum(Validate$EnumRules validate$EnumRules) {
        validate$EnumRules.getClass();
        this.type_ = validate$EnumRules;
        this.typeCase_ = 16;
    }

    private void setFixed32(Validate$Fixed32Rules validate$Fixed32Rules) {
        validate$Fixed32Rules.getClass();
        this.type_ = validate$Fixed32Rules;
        this.typeCase_ = 9;
    }

    private void setFixed64(Validate$Fixed64Rules validate$Fixed64Rules) {
        validate$Fixed64Rules.getClass();
        this.type_ = validate$Fixed64Rules;
        this.typeCase_ = 10;
    }

    private void setFloat(Validate$FloatRules validate$FloatRules) {
        validate$FloatRules.getClass();
        this.type_ = validate$FloatRules;
        this.typeCase_ = 1;
    }

    private void setInt32(Validate$Int32Rules validate$Int32Rules) {
        validate$Int32Rules.getClass();
        this.type_ = validate$Int32Rules;
        this.typeCase_ = 3;
    }

    private void setInt64(Validate$Int64Rules validate$Int64Rules) {
        validate$Int64Rules.getClass();
        this.type_ = validate$Int64Rules;
        this.typeCase_ = 4;
    }

    private void setMap(Validate$MapRules validate$MapRules) {
        validate$MapRules.getClass();
        this.type_ = validate$MapRules;
        this.typeCase_ = 19;
    }

    private void setMessage(Validate$MessageRules validate$MessageRules) {
        validate$MessageRules.getClass();
        this.message_ = validate$MessageRules;
        this.bitField0_ |= 1;
    }

    private void setRepeated(Validate$RepeatedRules validate$RepeatedRules) {
        validate$RepeatedRules.getClass();
        this.type_ = validate$RepeatedRules;
        this.typeCase_ = 18;
    }

    private void setSfixed32(Validate$SFixed32Rules validate$SFixed32Rules) {
        validate$SFixed32Rules.getClass();
        this.type_ = validate$SFixed32Rules;
        this.typeCase_ = 11;
    }

    private void setSfixed64(Validate$SFixed64Rules validate$SFixed64Rules) {
        validate$SFixed64Rules.getClass();
        this.type_ = validate$SFixed64Rules;
        this.typeCase_ = 12;
    }

    private void setSint32(Validate$SInt32Rules validate$SInt32Rules) {
        validate$SInt32Rules.getClass();
        this.type_ = validate$SInt32Rules;
        this.typeCase_ = 7;
    }

    private void setSint64(Validate$SInt64Rules validate$SInt64Rules) {
        validate$SInt64Rules.getClass();
        this.type_ = validate$SInt64Rules;
        this.typeCase_ = 8;
    }

    private void setString(Validate$StringRules validate$StringRules) {
        validate$StringRules.getClass();
        this.type_ = validate$StringRules;
        this.typeCase_ = 14;
    }

    private void setTimestamp(Validate$TimestampRules validate$TimestampRules) {
        validate$TimestampRules.getClass();
        this.type_ = validate$TimestampRules;
        this.typeCase_ = 22;
    }

    private void setUint32(Validate$UInt32Rules validate$UInt32Rules) {
        validate$UInt32Rules.getClass();
        this.type_ = validate$UInt32Rules;
        this.typeCase_ = 5;
    }

    private void setUint64(Validate$UInt64Rules validate$UInt64Rules) {
        validate$UInt64Rules.getClass();
        this.type_ = validate$UInt64Rules;
        this.typeCase_ = 6;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (io.envoyproxy.pgv.validate.a.a[gVar.ordinal()]) {
            case 1:
                return new Validate$FieldRules();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0016\u0001\u0001\u0001\u0016\u0016\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000\u0006<\u0000\u0007<\u0000\b<\u0000\t<\u0000\n<\u0000\u000b<\u0000\f<\u0000\r<\u0000\u000e<\u0000\u000f<\u0000\u0010<\u0000\u0011ဉ\u0000\u0012<\u0000\u0013<\u0000\u0014<\u0000\u0015<\u0000\u0016<\u0000", new Object[]{"type_", "typeCase_", "bitField0_", Validate$FloatRules.class, Validate$DoubleRules.class, Validate$Int32Rules.class, Validate$Int64Rules.class, Validate$UInt32Rules.class, Validate$UInt64Rules.class, Validate$SInt32Rules.class, Validate$SInt64Rules.class, Validate$Fixed32Rules.class, Validate$Fixed64Rules.class, Validate$SFixed32Rules.class, Validate$SFixed64Rules.class, Validate$BoolRules.class, Validate$StringRules.class, Validate$BytesRules.class, Validate$EnumRules.class, "message_", Validate$RepeatedRules.class, Validate$MapRules.class, Validate$AnyRules.class, Validate$DurationRules.class, Validate$TimestampRules.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Validate$FieldRules.class) {
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

    public Validate$AnyRules getAny() {
        return this.typeCase_ == 20 ? (Validate$AnyRules) this.type_ : Validate$AnyRules.getDefaultInstance();
    }

    public Validate$BoolRules getBool() {
        return this.typeCase_ == 13 ? (Validate$BoolRules) this.type_ : Validate$BoolRules.getDefaultInstance();
    }

    public Validate$BytesRules getBytes() {
        return this.typeCase_ == 15 ? (Validate$BytesRules) this.type_ : Validate$BytesRules.getDefaultInstance();
    }

    public Validate$DoubleRules getDouble() {
        return this.typeCase_ == 2 ? (Validate$DoubleRules) this.type_ : Validate$DoubleRules.getDefaultInstance();
    }

    public Validate$DurationRules getDuration() {
        return this.typeCase_ == 21 ? (Validate$DurationRules) this.type_ : Validate$DurationRules.getDefaultInstance();
    }

    public Validate$EnumRules getEnum() {
        return this.typeCase_ == 16 ? (Validate$EnumRules) this.type_ : Validate$EnumRules.getDefaultInstance();
    }

    public Validate$Fixed32Rules getFixed32() {
        return this.typeCase_ == 9 ? (Validate$Fixed32Rules) this.type_ : Validate$Fixed32Rules.getDefaultInstance();
    }

    public Validate$Fixed64Rules getFixed64() {
        return this.typeCase_ == 10 ? (Validate$Fixed64Rules) this.type_ : Validate$Fixed64Rules.getDefaultInstance();
    }

    public Validate$FloatRules getFloat() {
        return this.typeCase_ == 1 ? (Validate$FloatRules) this.type_ : Validate$FloatRules.getDefaultInstance();
    }

    public Validate$Int32Rules getInt32() {
        return this.typeCase_ == 3 ? (Validate$Int32Rules) this.type_ : Validate$Int32Rules.getDefaultInstance();
    }

    public Validate$Int64Rules getInt64() {
        return this.typeCase_ == 4 ? (Validate$Int64Rules) this.type_ : Validate$Int64Rules.getDefaultInstance();
    }

    public Validate$MapRules getMap() {
        return this.typeCase_ == 19 ? (Validate$MapRules) this.type_ : Validate$MapRules.getDefaultInstance();
    }

    public Validate$MessageRules getMessage() {
        Validate$MessageRules validate$MessageRules = this.message_;
        return validate$MessageRules == null ? Validate$MessageRules.getDefaultInstance() : validate$MessageRules;
    }

    public Validate$RepeatedRules getRepeated() {
        return this.typeCase_ == 18 ? (Validate$RepeatedRules) this.type_ : Validate$RepeatedRules.getDefaultInstance();
    }

    public Validate$SFixed32Rules getSfixed32() {
        return this.typeCase_ == 11 ? (Validate$SFixed32Rules) this.type_ : Validate$SFixed32Rules.getDefaultInstance();
    }

    public Validate$SFixed64Rules getSfixed64() {
        return this.typeCase_ == 12 ? (Validate$SFixed64Rules) this.type_ : Validate$SFixed64Rules.getDefaultInstance();
    }

    public Validate$SInt32Rules getSint32() {
        return this.typeCase_ == 7 ? (Validate$SInt32Rules) this.type_ : Validate$SInt32Rules.getDefaultInstance();
    }

    public Validate$SInt64Rules getSint64() {
        return this.typeCase_ == 8 ? (Validate$SInt64Rules) this.type_ : Validate$SInt64Rules.getDefaultInstance();
    }

    public Validate$StringRules getString() {
        return this.typeCase_ == 14 ? (Validate$StringRules) this.type_ : Validate$StringRules.getDefaultInstance();
    }

    public Validate$TimestampRules getTimestamp() {
        return this.typeCase_ == 22 ? (Validate$TimestampRules) this.type_ : Validate$TimestampRules.getDefaultInstance();
    }

    public b getTypeCase() {
        return b.j(this.typeCase_);
    }

    public Validate$UInt32Rules getUint32() {
        return this.typeCase_ == 5 ? (Validate$UInt32Rules) this.type_ : Validate$UInt32Rules.getDefaultInstance();
    }

    public Validate$UInt64Rules getUint64() {
        return this.typeCase_ == 6 ? (Validate$UInt64Rules) this.type_ : Validate$UInt64Rules.getDefaultInstance();
    }

    public boolean hasAny() {
        return this.typeCase_ == 20;
    }

    public boolean hasBool() {
        return this.typeCase_ == 13;
    }

    public boolean hasBytes() {
        return this.typeCase_ == 15;
    }

    public boolean hasDouble() {
        return this.typeCase_ == 2;
    }

    public boolean hasDuration() {
        return this.typeCase_ == 21;
    }

    public boolean hasEnum() {
        return this.typeCase_ == 16;
    }

    public boolean hasFixed32() {
        return this.typeCase_ == 9;
    }

    public boolean hasFixed64() {
        return this.typeCase_ == 10;
    }

    public boolean hasFloat() {
        return this.typeCase_ == 1;
    }

    public boolean hasInt32() {
        return this.typeCase_ == 3;
    }

    public boolean hasInt64() {
        return this.typeCase_ == 4;
    }

    public boolean hasMap() {
        return this.typeCase_ == 19;
    }

    public boolean hasMessage() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasRepeated() {
        return this.typeCase_ == 18;
    }

    public boolean hasSfixed32() {
        return this.typeCase_ == 11;
    }

    public boolean hasSfixed64() {
        return this.typeCase_ == 12;
    }

    public boolean hasSint32() {
        return this.typeCase_ == 7;
    }

    public boolean hasSint64() {
        return this.typeCase_ == 8;
    }

    public boolean hasString() {
        return this.typeCase_ == 14;
    }

    public boolean hasTimestamp() {
        return this.typeCase_ == 22;
    }

    public boolean hasUint32() {
        return this.typeCase_ == 5;
    }

    public boolean hasUint64() {
        return this.typeCase_ == 6;
    }

    public static a newBuilder(Validate$FieldRules validate$FieldRules) {
        return (a) DEFAULT_INSTANCE.createBuilder(validate$FieldRules);
    }

    public static Validate$FieldRules parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Validate$FieldRules) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Validate$FieldRules parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Validate$FieldRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Validate$FieldRules parseFrom(AbstractC2383g abstractC2383g) {
        return (Validate$FieldRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Validate$FieldRules parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Validate$FieldRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Validate$FieldRules parseFrom(byte[] bArr) {
        return (Validate$FieldRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Validate$FieldRules parseFrom(byte[] bArr, C2394s c2394s) {
        return (Validate$FieldRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Validate$FieldRules parseFrom(InputStream inputStream) {
        return (Validate$FieldRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Validate$FieldRules parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Validate$FieldRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Validate$FieldRules parseFrom(AbstractC2384h abstractC2384h) {
        return (Validate$FieldRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Validate$FieldRules parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Validate$FieldRules) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
