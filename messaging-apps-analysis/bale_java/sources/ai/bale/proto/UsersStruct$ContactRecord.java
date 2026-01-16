package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int64Value;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.EnumC17082mM7;
import ir.nasim.InterfaceC16491lM7;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class UsersStruct$ContactRecord extends GeneratedMessageLite implements InterfaceC16491lM7 {
    private static final UsersStruct$ContactRecord DEFAULT_INSTANCE;
    public static final int LONG_VALUE_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int STRING_VALUE_FIELD_NUMBER = 2;
    public static final int SUBTITLE_FIELD_NUMBER = 5;
    public static final int TITLE_FIELD_NUMBER = 4;
    public static final int TYPE_FIELD_NUMBER = 1;
    public static final int TYPE_SPEC_FIELD_NUMBER = 6;
    private int bitField0_;
    private CollectionsStruct$Int64Value longValue_;
    private StringValue stringValue_;
    private StringValue subtitle_;
    private StringValue title_;
    private StringValue typeSpec_;
    private int type_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC16491lM7 {
        @Override // ir.nasim.InterfaceC16491lM7
        public CollectionsStruct$Int64Value getLongValue() {
            return ((UsersStruct$ContactRecord) this.b).getLongValue();
        }

        @Override // ir.nasim.InterfaceC16491lM7
        public StringValue getStringValue() {
            return ((UsersStruct$ContactRecord) this.b).getStringValue();
        }

        @Override // ir.nasim.InterfaceC16491lM7
        public StringValue getSubtitle() {
            return ((UsersStruct$ContactRecord) this.b).getSubtitle();
        }

        @Override // ir.nasim.InterfaceC16491lM7
        public StringValue getTitle() {
            return ((UsersStruct$ContactRecord) this.b).getTitle();
        }

        @Override // ir.nasim.InterfaceC16491lM7
        public EnumC17082mM7 getType() {
            return ((UsersStruct$ContactRecord) this.b).getType();
        }

        @Override // ir.nasim.InterfaceC16491lM7
        public StringValue getTypeSpec() {
            return ((UsersStruct$ContactRecord) this.b).getTypeSpec();
        }

        private a() {
            super(UsersStruct$ContactRecord.DEFAULT_INSTANCE);
        }
    }

    static {
        UsersStruct$ContactRecord usersStruct$ContactRecord = new UsersStruct$ContactRecord();
        DEFAULT_INSTANCE = usersStruct$ContactRecord;
        GeneratedMessageLite.registerDefaultInstance(UsersStruct$ContactRecord.class, usersStruct$ContactRecord);
    }

    private UsersStruct$ContactRecord() {
    }

    private void clearLongValue() {
        this.longValue_ = null;
        this.bitField0_ &= -3;
    }

    private void clearStringValue() {
        this.stringValue_ = null;
        this.bitField0_ &= -2;
    }

    private void clearSubtitle() {
        this.subtitle_ = null;
        this.bitField0_ &= -9;
    }

    private void clearTitle() {
        this.title_ = null;
        this.bitField0_ &= -5;
    }

    private void clearType() {
        this.type_ = 0;
    }

    private void clearTypeSpec() {
        this.typeSpec_ = null;
        this.bitField0_ &= -17;
    }

    public static UsersStruct$ContactRecord getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeLongValue(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.longValue_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.longValue_ = collectionsStruct$Int64Value;
        } else {
            this.longValue_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.longValue_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeStringValue(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.stringValue_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.stringValue_ = stringValue;
        } else {
            this.stringValue_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.stringValue_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeSubtitle(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.subtitle_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.subtitle_ = stringValue;
        } else {
            this.subtitle_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.subtitle_).v(stringValue)).j();
        }
        this.bitField0_ |= 8;
    }

    private void mergeTitle(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.title_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.title_ = stringValue;
        } else {
            this.title_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.title_).v(stringValue)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeTypeSpec(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.typeSpec_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.typeSpec_ = stringValue;
        } else {
            this.typeSpec_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.typeSpec_).v(stringValue)).j();
        }
        this.bitField0_ |= 16;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static UsersStruct$ContactRecord parseDelimitedFrom(InputStream inputStream) {
        return (UsersStruct$ContactRecord) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersStruct$ContactRecord parseFrom(ByteBuffer byteBuffer) {
        return (UsersStruct$ContactRecord) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setLongValue(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.longValue_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 2;
    }

    private void setStringValue(StringValue stringValue) {
        stringValue.getClass();
        this.stringValue_ = stringValue;
        this.bitField0_ |= 1;
    }

    private void setSubtitle(StringValue stringValue) {
        stringValue.getClass();
        this.subtitle_ = stringValue;
        this.bitField0_ |= 8;
    }

    private void setTitle(StringValue stringValue) {
        stringValue.getClass();
        this.title_ = stringValue;
        this.bitField0_ |= 4;
    }

    private void setType(EnumC17082mM7 enumC17082mM7) {
        this.type_ = enumC17082mM7.getNumber();
    }

    private void setTypeSpec(StringValue stringValue) {
        stringValue.getClass();
        this.typeSpec_ = stringValue;
        this.bitField0_ |= 16;
    }

    private void setTypeValue(int i) {
        this.type_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (q2.a[gVar.ordinal()]) {
            case 1:
                return new UsersStruct$ContactRecord();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\f\u0002ဉ\u0000\u0003ဉ\u0001\u0004ဉ\u0002\u0005ဉ\u0003\u0006ဉ\u0004", new Object[]{"bitField0_", "type_", "stringValue_", "longValue_", "title_", "subtitle_", "typeSpec_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UsersStruct$ContactRecord.class) {
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

    @Override // ir.nasim.InterfaceC16491lM7
    public CollectionsStruct$Int64Value getLongValue() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.longValue_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    @Override // ir.nasim.InterfaceC16491lM7
    public StringValue getStringValue() {
        StringValue stringValue = this.stringValue_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    @Override // ir.nasim.InterfaceC16491lM7
    public StringValue getSubtitle() {
        StringValue stringValue = this.subtitle_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    @Override // ir.nasim.InterfaceC16491lM7
    public StringValue getTitle() {
        StringValue stringValue = this.title_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    @Override // ir.nasim.InterfaceC16491lM7
    public EnumC17082mM7 getType() {
        EnumC17082mM7 enumC17082mM7J = EnumC17082mM7.j(this.type_);
        return enumC17082mM7J == null ? EnumC17082mM7.UNRECOGNIZED : enumC17082mM7J;
    }

    @Override // ir.nasim.InterfaceC16491lM7
    public StringValue getTypeSpec() {
        StringValue stringValue = this.typeSpec_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public int getTypeValue() {
        return this.type_;
    }

    public boolean hasLongValue() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasStringValue() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasSubtitle() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasTitle() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasTypeSpec() {
        return (this.bitField0_ & 16) != 0;
    }

    public static a newBuilder(UsersStruct$ContactRecord usersStruct$ContactRecord) {
        return (a) DEFAULT_INSTANCE.createBuilder(usersStruct$ContactRecord);
    }

    public static UsersStruct$ContactRecord parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersStruct$ContactRecord) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersStruct$ContactRecord parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UsersStruct$ContactRecord) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UsersStruct$ContactRecord parseFrom(AbstractC2383g abstractC2383g) {
        return (UsersStruct$ContactRecord) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static UsersStruct$ContactRecord parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UsersStruct$ContactRecord) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UsersStruct$ContactRecord parseFrom(byte[] bArr) {
        return (UsersStruct$ContactRecord) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UsersStruct$ContactRecord parseFrom(byte[] bArr, C2394s c2394s) {
        return (UsersStruct$ContactRecord) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UsersStruct$ContactRecord parseFrom(InputStream inputStream) {
        return (UsersStruct$ContactRecord) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersStruct$ContactRecord parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersStruct$ContactRecord) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersStruct$ContactRecord parseFrom(AbstractC2384h abstractC2384h) {
        return (UsersStruct$ContactRecord) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UsersStruct$ContactRecord parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UsersStruct$ContactRecord) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
