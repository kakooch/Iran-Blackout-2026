package com.google.protobuf;

import com.google.protobuf.B;
import com.google.protobuf.DescriptorProtos$FieldOptions;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public final class DescriptorProtos$FieldDescriptorProto extends GeneratedMessageLite implements InterfaceC2390n {
    private static final DescriptorProtos$FieldDescriptorProto DEFAULT_INSTANCE;
    public static final int DEFAULT_VALUE_FIELD_NUMBER = 7;
    public static final int EXTENDEE_FIELD_NUMBER = 2;
    public static final int JSON_NAME_FIELD_NUMBER = 10;
    public static final int LABEL_FIELD_NUMBER = 4;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int NUMBER_FIELD_NUMBER = 3;
    public static final int ONEOF_INDEX_FIELD_NUMBER = 9;
    public static final int OPTIONS_FIELD_NUMBER = 8;
    private static volatile KW4 PARSER = null;
    public static final int PROTO3_OPTIONAL_FIELD_NUMBER = 17;
    public static final int TYPE_FIELD_NUMBER = 5;
    public static final int TYPE_NAME_FIELD_NUMBER = 6;
    private int bitField0_;
    private int number_;
    private int oneofIndex_;
    private DescriptorProtos$FieldOptions options_;
    private boolean proto3Optional_;
    private byte memoizedIsInitialized = 2;
    private String name_ = "";
    private int label_ = 1;
    private int type_ = 1;
    private String typeName_ = "";
    private String extendee_ = "";
    private String defaultValue_ = "";
    private String jsonName_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC2390n {
        /* synthetic */ a(AbstractC2387k abstractC2387k) {
            this();
        }

        private a() {
            super(DescriptorProtos$FieldDescriptorProto.DEFAULT_INSTANCE);
        }
    }

    public enum b implements B.c {
        LABEL_OPTIONAL(1),
        LABEL_REQUIRED(2),
        LABEL_REPEATED(3);

        private static final B.d e = new a();
        private final int a;

        class a implements B.d {
            a() {
            }

            @Override // com.google.protobuf.B.d
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public b a(int i) {
                return b.a(i);
            }
        }

        /* renamed from: com.google.protobuf.DescriptorProtos$FieldDescriptorProto$b$b, reason: collision with other inner class name */
        private static final class C0200b implements B.e {
            static final B.e a = new C0200b();

            private C0200b() {
            }

            @Override // com.google.protobuf.B.e
            public boolean a(int i) {
                return b.a(i) != null;
            }
        }

        b(int i) {
            this.a = i;
        }

        public static b a(int i) {
            if (i == 1) {
                return LABEL_OPTIONAL;
            }
            if (i == 2) {
                return LABEL_REQUIRED;
            }
            if (i != 3) {
                return null;
            }
            return LABEL_REPEATED;
        }

        public static B.e j() {
            return C0200b.a;
        }

        @Override // com.google.protobuf.B.c
        public final int getNumber() {
            return this.a;
        }
    }

    public enum c implements B.c {
        TYPE_DOUBLE(1),
        TYPE_FLOAT(2),
        TYPE_INT64(3),
        TYPE_UINT64(4),
        TYPE_INT32(5),
        TYPE_FIXED64(6),
        TYPE_FIXED32(7),
        TYPE_BOOL(8),
        TYPE_STRING(9),
        TYPE_GROUP(10),
        TYPE_MESSAGE(11),
        TYPE_BYTES(12),
        TYPE_UINT32(13),
        TYPE_ENUM(14),
        TYPE_SFIXED32(15),
        TYPE_SFIXED64(16),
        TYPE_SINT32(17),
        TYPE_SINT64(18);

        private static final B.d t = new a();
        private final int a;

        class a implements B.d {
            a() {
            }

            @Override // com.google.protobuf.B.d
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public c a(int i) {
                return c.a(i);
            }
        }

        private static final class b implements B.e {
            static final B.e a = new b();

            private b() {
            }

            @Override // com.google.protobuf.B.e
            public boolean a(int i) {
                return c.a(i) != null;
            }
        }

        c(int i) {
            this.a = i;
        }

        public static c a(int i) {
            switch (i) {
                case 1:
                    return TYPE_DOUBLE;
                case 2:
                    return TYPE_FLOAT;
                case 3:
                    return TYPE_INT64;
                case 4:
                    return TYPE_UINT64;
                case 5:
                    return TYPE_INT32;
                case 6:
                    return TYPE_FIXED64;
                case 7:
                    return TYPE_FIXED32;
                case 8:
                    return TYPE_BOOL;
                case 9:
                    return TYPE_STRING;
                case 10:
                    return TYPE_GROUP;
                case 11:
                    return TYPE_MESSAGE;
                case 12:
                    return TYPE_BYTES;
                case 13:
                    return TYPE_UINT32;
                case 14:
                    return TYPE_ENUM;
                case 15:
                    return TYPE_SFIXED32;
                case 16:
                    return TYPE_SFIXED64;
                case 17:
                    return TYPE_SINT32;
                case 18:
                    return TYPE_SINT64;
                default:
                    return null;
            }
        }

        public static B.e j() {
            return b.a;
        }

        @Override // com.google.protobuf.B.c
        public final int getNumber() {
            return this.a;
        }
    }

    static {
        DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto = new DescriptorProtos$FieldDescriptorProto();
        DEFAULT_INSTANCE = descriptorProtos$FieldDescriptorProto;
        GeneratedMessageLite.registerDefaultInstance(DescriptorProtos$FieldDescriptorProto.class, descriptorProtos$FieldDescriptorProto);
    }

    private DescriptorProtos$FieldDescriptorProto() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDefaultValue() {
        this.bitField0_ &= -65;
        this.defaultValue_ = getDefaultInstance().getDefaultValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearExtendee() {
        this.bitField0_ &= -33;
        this.extendee_ = getDefaultInstance().getExtendee();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearJsonName() {
        this.bitField0_ &= -257;
        this.jsonName_ = getDefaultInstance().getJsonName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLabel() {
        this.bitField0_ &= -5;
        this.label_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.bitField0_ &= -2;
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNumber() {
        this.bitField0_ &= -3;
        this.number_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOneofIndex() {
        this.bitField0_ &= -129;
        this.oneofIndex_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOptions() {
        this.options_ = null;
        this.bitField0_ &= -513;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearProto3Optional() {
        this.bitField0_ &= -1025;
        this.proto3Optional_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearType() {
        this.bitField0_ &= -9;
        this.type_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTypeName() {
        this.bitField0_ &= -17;
        this.typeName_ = getDefaultInstance().getTypeName();
    }

    public static DescriptorProtos$FieldDescriptorProto getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeOptions(DescriptorProtos$FieldOptions descriptorProtos$FieldOptions) {
        descriptorProtos$FieldOptions.getClass();
        DescriptorProtos$FieldOptions descriptorProtos$FieldOptions2 = this.options_;
        if (descriptorProtos$FieldOptions2 == null || descriptorProtos$FieldOptions2 == DescriptorProtos$FieldOptions.getDefaultInstance()) {
            this.options_ = descriptorProtos$FieldOptions;
        } else {
            this.options_ = (DescriptorProtos$FieldOptions) ((DescriptorProtos$FieldOptions.a) DescriptorProtos$FieldOptions.newBuilder(this.options_).v(descriptorProtos$FieldOptions)).j();
        }
        this.bitField0_ |= 512;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static DescriptorProtos$FieldDescriptorProto parseDelimitedFrom(InputStream inputStream) {
        return (DescriptorProtos$FieldDescriptorProto) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DescriptorProtos$FieldDescriptorProto parseFrom(ByteBuffer byteBuffer) {
        return (DescriptorProtos$FieldDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDefaultValue(String str) {
        str.getClass();
        this.bitField0_ |= 64;
        this.defaultValue_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDefaultValueBytes(AbstractC2383g abstractC2383g) {
        this.defaultValue_ = abstractC2383g.f0();
        this.bitField0_ |= 64;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setExtendee(String str) {
        str.getClass();
        this.bitField0_ |= 32;
        this.extendee_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setExtendeeBytes(AbstractC2383g abstractC2383g) {
        this.extendee_ = abstractC2383g.f0();
        this.bitField0_ |= 32;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setJsonName(String str) {
        str.getClass();
        this.bitField0_ |= 256;
        this.jsonName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setJsonNameBytes(AbstractC2383g abstractC2383g) {
        this.jsonName_ = abstractC2383g.f0();
        this.bitField0_ |= 256;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLabel(b bVar) {
        this.label_ = bVar.getNumber();
        this.bitField0_ |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setName(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.name_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNameBytes(AbstractC2383g abstractC2383g) {
        this.name_ = abstractC2383g.f0();
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNumber(int i) {
        this.bitField0_ |= 2;
        this.number_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOneofIndex(int i) {
        this.bitField0_ |= 128;
        this.oneofIndex_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOptions(DescriptorProtos$FieldOptions descriptorProtos$FieldOptions) {
        descriptorProtos$FieldOptions.getClass();
        this.options_ = descriptorProtos$FieldOptions;
        this.bitField0_ |= 512;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProto3Optional(boolean z) {
        this.bitField0_ |= 1024;
        this.proto3Optional_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setType(c cVar) {
        this.type_ = cVar.getNumber();
        this.bitField0_ |= 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTypeName(String str) {
        str.getClass();
        this.bitField0_ |= 16;
        this.typeName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTypeNameBytes(AbstractC2383g abstractC2383g) {
        this.typeName_ = abstractC2383g.f0();
        this.bitField0_ |= 16;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        AbstractC2387k abstractC2387k = null;
        switch (AbstractC2387k.a[gVar.ordinal()]) {
            case 1:
                return new DescriptorProtos$FieldDescriptorProto();
            case 2:
                return new a(abstractC2387k);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u000b\u0000\u0001\u0001\u0011\u000b\u0000\u0000\u0001\u0001ဈ\u0000\u0002ဈ\u0005\u0003င\u0001\u0004ဌ\u0002\u0005ဌ\u0003\u0006ဈ\u0004\u0007ဈ\u0006\bᐉ\t\tင\u0007\nဈ\b\u0011ဇ\n", new Object[]{"bitField0_", "name_", "extendee_", "number_", "label_", b.j(), "type_", c.j(), "typeName_", "defaultValue_", "options_", "oneofIndex_", "jsonName_", "proto3Optional_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (DescriptorProtos$FieldDescriptorProto.class) {
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
                return Byte.valueOf(this.memoizedIsInitialized);
            case 7:
                this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public String getDefaultValue() {
        return this.defaultValue_;
    }

    public AbstractC2383g getDefaultValueBytes() {
        return AbstractC2383g.N(this.defaultValue_);
    }

    public String getExtendee() {
        return this.extendee_;
    }

    public AbstractC2383g getExtendeeBytes() {
        return AbstractC2383g.N(this.extendee_);
    }

    public String getJsonName() {
        return this.jsonName_;
    }

    public AbstractC2383g getJsonNameBytes() {
        return AbstractC2383g.N(this.jsonName_);
    }

    public b getLabel() {
        b bVarA = b.a(this.label_);
        return bVarA == null ? b.LABEL_OPTIONAL : bVarA;
    }

    public String getName() {
        return this.name_;
    }

    public AbstractC2383g getNameBytes() {
        return AbstractC2383g.N(this.name_);
    }

    public int getNumber() {
        return this.number_;
    }

    public int getOneofIndex() {
        return this.oneofIndex_;
    }

    public DescriptorProtos$FieldOptions getOptions() {
        DescriptorProtos$FieldOptions descriptorProtos$FieldOptions = this.options_;
        return descriptorProtos$FieldOptions == null ? DescriptorProtos$FieldOptions.getDefaultInstance() : descriptorProtos$FieldOptions;
    }

    public boolean getProto3Optional() {
        return this.proto3Optional_;
    }

    public c getType() {
        c cVarA = c.a(this.type_);
        return cVarA == null ? c.TYPE_DOUBLE : cVarA;
    }

    public String getTypeName() {
        return this.typeName_;
    }

    public AbstractC2383g getTypeNameBytes() {
        return AbstractC2383g.N(this.typeName_);
    }

    public boolean hasDefaultValue() {
        return (this.bitField0_ & 64) != 0;
    }

    public boolean hasExtendee() {
        return (this.bitField0_ & 32) != 0;
    }

    public boolean hasJsonName() {
        return (this.bitField0_ & 256) != 0;
    }

    public boolean hasLabel() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasName() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasNumber() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasOneofIndex() {
        return (this.bitField0_ & 128) != 0;
    }

    public boolean hasOptions() {
        return (this.bitField0_ & 512) != 0;
    }

    public boolean hasProto3Optional() {
        return (this.bitField0_ & 1024) != 0;
    }

    public boolean hasType() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasTypeName() {
        return (this.bitField0_ & 16) != 0;
    }

    public static a newBuilder(DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto) {
        return (a) DEFAULT_INSTANCE.createBuilder(descriptorProtos$FieldDescriptorProto);
    }

    public static DescriptorProtos$FieldDescriptorProto parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (DescriptorProtos$FieldDescriptorProto) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static DescriptorProtos$FieldDescriptorProto parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (DescriptorProtos$FieldDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static DescriptorProtos$FieldDescriptorProto parseFrom(AbstractC2383g abstractC2383g) {
        return (DescriptorProtos$FieldDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static DescriptorProtos$FieldDescriptorProto parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (DescriptorProtos$FieldDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static DescriptorProtos$FieldDescriptorProto parseFrom(byte[] bArr) {
        return (DescriptorProtos$FieldDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static DescriptorProtos$FieldDescriptorProto parseFrom(byte[] bArr, C2394s c2394s) {
        return (DescriptorProtos$FieldDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static DescriptorProtos$FieldDescriptorProto parseFrom(InputStream inputStream) {
        return (DescriptorProtos$FieldDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DescriptorProtos$FieldDescriptorProto parseFrom(InputStream inputStream, C2394s c2394s) {
        return (DescriptorProtos$FieldDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static DescriptorProtos$FieldDescriptorProto parseFrom(AbstractC2384h abstractC2384h) {
        return (DescriptorProtos$FieldDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static DescriptorProtos$FieldDescriptorProto parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (DescriptorProtos$FieldDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
