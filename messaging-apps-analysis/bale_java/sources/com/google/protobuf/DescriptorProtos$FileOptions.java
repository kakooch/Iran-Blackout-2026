package com.google.protobuf;

import com.google.protobuf.B;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes3.dex */
public final class DescriptorProtos$FileOptions extends GeneratedMessageLite.ExtendableMessage<DescriptorProtos$FileOptions, a> implements U64 {
    public static final int CC_ENABLE_ARENAS_FIELD_NUMBER = 31;
    public static final int CC_GENERIC_SERVICES_FIELD_NUMBER = 16;
    public static final int CSHARP_NAMESPACE_FIELD_NUMBER = 37;
    private static final DescriptorProtos$FileOptions DEFAULT_INSTANCE;
    public static final int DEPRECATED_FIELD_NUMBER = 23;
    public static final int GO_PACKAGE_FIELD_NUMBER = 11;
    public static final int JAVA_GENERATE_EQUALS_AND_HASH_FIELD_NUMBER = 20;
    public static final int JAVA_GENERIC_SERVICES_FIELD_NUMBER = 17;
    public static final int JAVA_MULTIPLE_FILES_FIELD_NUMBER = 10;
    public static final int JAVA_OUTER_CLASSNAME_FIELD_NUMBER = 8;
    public static final int JAVA_PACKAGE_FIELD_NUMBER = 1;
    public static final int JAVA_STRING_CHECK_UTF8_FIELD_NUMBER = 27;
    public static final int OBJC_CLASS_PREFIX_FIELD_NUMBER = 36;
    public static final int OPTIMIZE_FOR_FIELD_NUMBER = 9;
    private static volatile KW4 PARSER = null;
    public static final int PHP_CLASS_PREFIX_FIELD_NUMBER = 40;
    public static final int PHP_GENERIC_SERVICES_FIELD_NUMBER = 42;
    public static final int PHP_METADATA_NAMESPACE_FIELD_NUMBER = 44;
    public static final int PHP_NAMESPACE_FIELD_NUMBER = 41;
    public static final int PY_GENERIC_SERVICES_FIELD_NUMBER = 18;
    public static final int RUBY_PACKAGE_FIELD_NUMBER = 45;
    public static final int SWIFT_PREFIX_FIELD_NUMBER = 39;
    public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
    private int bitField0_;
    private boolean ccGenericServices_;
    private boolean deprecated_;
    private boolean javaGenerateEqualsAndHash_;
    private boolean javaGenericServices_;
    private boolean javaMultipleFiles_;
    private boolean javaStringCheckUtf8_;
    private boolean phpGenericServices_;
    private boolean pyGenericServices_;
    private byte memoizedIsInitialized = 2;
    private String javaPackage_ = "";
    private String javaOuterClassname_ = "";
    private int optimizeFor_ = 1;
    private String goPackage_ = "";
    private boolean ccEnableArenas_ = true;
    private String objcClassPrefix_ = "";
    private String csharpNamespace_ = "";
    private String swiftPrefix_ = "";
    private String phpClassPrefix_ = "";
    private String phpNamespace_ = "";
    private String phpMetadataNamespace_ = "";
    private String rubyPackage_ = "";
    private B.j uninterpretedOption_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.d implements U64 {
        /* synthetic */ a(AbstractC2387k abstractC2387k) {
            this();
        }

        private a() {
            super(DescriptorProtos$FileOptions.DEFAULT_INSTANCE);
        }
    }

    public enum b implements B.c {
        SPEED(1),
        CODE_SIZE(2),
        LITE_RUNTIME(3);

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

        /* renamed from: com.google.protobuf.DescriptorProtos$FileOptions$b$b, reason: collision with other inner class name */
        private static final class C0202b implements B.e {
            static final B.e a = new C0202b();

            private C0202b() {
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
                return SPEED;
            }
            if (i == 2) {
                return CODE_SIZE;
            }
            if (i != 3) {
                return null;
            }
            return LITE_RUNTIME;
        }

        public static B.e j() {
            return C0202b.a;
        }

        @Override // com.google.protobuf.B.c
        public final int getNumber() {
            return this.a;
        }
    }

    static {
        DescriptorProtos$FileOptions descriptorProtos$FileOptions = new DescriptorProtos$FileOptions();
        DEFAULT_INSTANCE = descriptorProtos$FileOptions;
        GeneratedMessageLite.registerDefaultInstance(DescriptorProtos$FileOptions.class, descriptorProtos$FileOptions);
    }

    private DescriptorProtos$FileOptions() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllUninterpretedOption(Iterable<? extends DescriptorProtos$UninterpretedOption> iterable) {
        ensureUninterpretedOptionIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.uninterpretedOption_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addUninterpretedOption(DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
        descriptorProtos$UninterpretedOption.getClass();
        ensureUninterpretedOptionIsMutable();
        this.uninterpretedOption_.add(descriptorProtos$UninterpretedOption);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCcEnableArenas() {
        this.bitField0_ &= -4097;
        this.ccEnableArenas_ = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCcGenericServices() {
        this.bitField0_ &= -129;
        this.ccGenericServices_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCsharpNamespace() {
        this.bitField0_ &= -16385;
        this.csharpNamespace_ = getDefaultInstance().getCsharpNamespace();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDeprecated() {
        this.bitField0_ &= -2049;
        this.deprecated_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearGoPackage() {
        this.bitField0_ &= -65;
        this.goPackage_ = getDefaultInstance().getGoPackage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearJavaGenerateEqualsAndHash() {
        this.bitField0_ &= -9;
        this.javaGenerateEqualsAndHash_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearJavaGenericServices() {
        this.bitField0_ &= -257;
        this.javaGenericServices_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearJavaMultipleFiles() {
        this.bitField0_ &= -5;
        this.javaMultipleFiles_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearJavaOuterClassname() {
        this.bitField0_ &= -3;
        this.javaOuterClassname_ = getDefaultInstance().getJavaOuterClassname();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearJavaPackage() {
        this.bitField0_ &= -2;
        this.javaPackage_ = getDefaultInstance().getJavaPackage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearJavaStringCheckUtf8() {
        this.bitField0_ &= -17;
        this.javaStringCheckUtf8_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearObjcClassPrefix() {
        this.bitField0_ &= -8193;
        this.objcClassPrefix_ = getDefaultInstance().getObjcClassPrefix();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOptimizeFor() {
        this.bitField0_ &= -33;
        this.optimizeFor_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPhpClassPrefix() {
        this.bitField0_ &= -65537;
        this.phpClassPrefix_ = getDefaultInstance().getPhpClassPrefix();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPhpGenericServices() {
        this.bitField0_ &= -1025;
        this.phpGenericServices_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPhpMetadataNamespace() {
        this.bitField0_ &= -262145;
        this.phpMetadataNamespace_ = getDefaultInstance().getPhpMetadataNamespace();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPhpNamespace() {
        this.bitField0_ &= -131073;
        this.phpNamespace_ = getDefaultInstance().getPhpNamespace();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPyGenericServices() {
        this.bitField0_ &= -513;
        this.pyGenericServices_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRubyPackage() {
        this.bitField0_ &= -524289;
        this.rubyPackage_ = getDefaultInstance().getRubyPackage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSwiftPrefix() {
        this.bitField0_ &= -32769;
        this.swiftPrefix_ = getDefaultInstance().getSwiftPrefix();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUninterpretedOption() {
        this.uninterpretedOption_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureUninterpretedOptionIsMutable() {
        B.j jVar = this.uninterpretedOption_;
        if (jVar.u()) {
            return;
        }
        this.uninterpretedOption_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static DescriptorProtos$FileOptions getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static DescriptorProtos$FileOptions parseDelimitedFrom(InputStream inputStream) {
        return (DescriptorProtos$FileOptions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DescriptorProtos$FileOptions parseFrom(ByteBuffer byteBuffer) {
        return (DescriptorProtos$FileOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeUninterpretedOption(int i) {
        ensureUninterpretedOptionIsMutable();
        this.uninterpretedOption_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCcEnableArenas(boolean z) {
        this.bitField0_ |= 4096;
        this.ccEnableArenas_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCcGenericServices(boolean z) {
        this.bitField0_ |= 128;
        this.ccGenericServices_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCsharpNamespace(String str) {
        str.getClass();
        this.bitField0_ |= 16384;
        this.csharpNamespace_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCsharpNamespaceBytes(AbstractC2383g abstractC2383g) {
        this.csharpNamespace_ = abstractC2383g.f0();
        this.bitField0_ |= 16384;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDeprecated(boolean z) {
        this.bitField0_ |= 2048;
        this.deprecated_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGoPackage(String str) {
        str.getClass();
        this.bitField0_ |= 64;
        this.goPackage_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGoPackageBytes(AbstractC2383g abstractC2383g) {
        this.goPackage_ = abstractC2383g.f0();
        this.bitField0_ |= 64;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setJavaGenerateEqualsAndHash(boolean z) {
        this.bitField0_ |= 8;
        this.javaGenerateEqualsAndHash_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setJavaGenericServices(boolean z) {
        this.bitField0_ |= 256;
        this.javaGenericServices_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setJavaMultipleFiles(boolean z) {
        this.bitField0_ |= 4;
        this.javaMultipleFiles_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setJavaOuterClassname(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.javaOuterClassname_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setJavaOuterClassnameBytes(AbstractC2383g abstractC2383g) {
        this.javaOuterClassname_ = abstractC2383g.f0();
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setJavaPackage(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.javaPackage_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setJavaPackageBytes(AbstractC2383g abstractC2383g) {
        this.javaPackage_ = abstractC2383g.f0();
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setJavaStringCheckUtf8(boolean z) {
        this.bitField0_ |= 16;
        this.javaStringCheckUtf8_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setObjcClassPrefix(String str) {
        str.getClass();
        this.bitField0_ |= 8192;
        this.objcClassPrefix_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setObjcClassPrefixBytes(AbstractC2383g abstractC2383g) {
        this.objcClassPrefix_ = abstractC2383g.f0();
        this.bitField0_ |= 8192;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOptimizeFor(b bVar) {
        this.optimizeFor_ = bVar.getNumber();
        this.bitField0_ |= 32;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPhpClassPrefix(String str) {
        str.getClass();
        this.bitField0_ |= 65536;
        this.phpClassPrefix_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPhpClassPrefixBytes(AbstractC2383g abstractC2383g) {
        this.phpClassPrefix_ = abstractC2383g.f0();
        this.bitField0_ |= 65536;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPhpGenericServices(boolean z) {
        this.bitField0_ |= 1024;
        this.phpGenericServices_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPhpMetadataNamespace(String str) {
        str.getClass();
        this.bitField0_ |= 262144;
        this.phpMetadataNamespace_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPhpMetadataNamespaceBytes(AbstractC2383g abstractC2383g) {
        this.phpMetadataNamespace_ = abstractC2383g.f0();
        this.bitField0_ |= 262144;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPhpNamespace(String str) {
        str.getClass();
        this.bitField0_ |= 131072;
        this.phpNamespace_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPhpNamespaceBytes(AbstractC2383g abstractC2383g) {
        this.phpNamespace_ = abstractC2383g.f0();
        this.bitField0_ |= 131072;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPyGenericServices(boolean z) {
        this.bitField0_ |= 512;
        this.pyGenericServices_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRubyPackage(String str) {
        str.getClass();
        this.bitField0_ |= 524288;
        this.rubyPackage_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRubyPackageBytes(AbstractC2383g abstractC2383g) {
        this.rubyPackage_ = abstractC2383g.f0();
        this.bitField0_ |= 524288;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSwiftPrefix(String str) {
        str.getClass();
        this.bitField0_ |= 32768;
        this.swiftPrefix_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSwiftPrefixBytes(AbstractC2383g abstractC2383g) {
        this.swiftPrefix_ = abstractC2383g.f0();
        this.bitField0_ |= 32768;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUninterpretedOption(int i, DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
        descriptorProtos$UninterpretedOption.getClass();
        ensureUninterpretedOptionIsMutable();
        this.uninterpretedOption_.set(i, descriptorProtos$UninterpretedOption);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        AbstractC2387k abstractC2387k = null;
        switch (AbstractC2387k.a[gVar.ordinal()]) {
            case 1:
                return new DescriptorProtos$FileOptions();
            case 2:
                return new a(abstractC2387k);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0015\u0000\u0001\u0001ϧ\u0015\u0000\u0001\u0001\u0001ဈ\u0000\bဈ\u0001\tဌ\u0005\nဇ\u0002\u000bဈ\u0006\u0010ဇ\u0007\u0011ဇ\b\u0012ဇ\t\u0014ဇ\u0003\u0017ဇ\u000b\u001bဇ\u0004\u001fဇ\f$ဈ\r%ဈ\u000e'ဈ\u000f(ဈ\u0010)ဈ\u0011*ဇ\n,ဈ\u0012-ဈ\u0013ϧЛ", new Object[]{"bitField0_", "javaPackage_", "javaOuterClassname_", "optimizeFor_", b.j(), "javaMultipleFiles_", "goPackage_", "ccGenericServices_", "javaGenericServices_", "pyGenericServices_", "javaGenerateEqualsAndHash_", "deprecated_", "javaStringCheckUtf8_", "ccEnableArenas_", "objcClassPrefix_", "csharpNamespace_", "swiftPrefix_", "phpClassPrefix_", "phpNamespace_", "phpGenericServices_", "phpMetadataNamespace_", "rubyPackage_", "uninterpretedOption_", DescriptorProtos$UninterpretedOption.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (DescriptorProtos$FileOptions.class) {
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

    public boolean getCcEnableArenas() {
        return this.ccEnableArenas_;
    }

    public boolean getCcGenericServices() {
        return this.ccGenericServices_;
    }

    public String getCsharpNamespace() {
        return this.csharpNamespace_;
    }

    public AbstractC2383g getCsharpNamespaceBytes() {
        return AbstractC2383g.N(this.csharpNamespace_);
    }

    public boolean getDeprecated() {
        return this.deprecated_;
    }

    public String getGoPackage() {
        return this.goPackage_;
    }

    public AbstractC2383g getGoPackageBytes() {
        return AbstractC2383g.N(this.goPackage_);
    }

    @Deprecated
    public boolean getJavaGenerateEqualsAndHash() {
        return this.javaGenerateEqualsAndHash_;
    }

    public boolean getJavaGenericServices() {
        return this.javaGenericServices_;
    }

    public boolean getJavaMultipleFiles() {
        return this.javaMultipleFiles_;
    }

    public String getJavaOuterClassname() {
        return this.javaOuterClassname_;
    }

    public AbstractC2383g getJavaOuterClassnameBytes() {
        return AbstractC2383g.N(this.javaOuterClassname_);
    }

    public String getJavaPackage() {
        return this.javaPackage_;
    }

    public AbstractC2383g getJavaPackageBytes() {
        return AbstractC2383g.N(this.javaPackage_);
    }

    public boolean getJavaStringCheckUtf8() {
        return this.javaStringCheckUtf8_;
    }

    public String getObjcClassPrefix() {
        return this.objcClassPrefix_;
    }

    public AbstractC2383g getObjcClassPrefixBytes() {
        return AbstractC2383g.N(this.objcClassPrefix_);
    }

    public b getOptimizeFor() {
        b bVarA = b.a(this.optimizeFor_);
        return bVarA == null ? b.SPEED : bVarA;
    }

    public String getPhpClassPrefix() {
        return this.phpClassPrefix_;
    }

    public AbstractC2383g getPhpClassPrefixBytes() {
        return AbstractC2383g.N(this.phpClassPrefix_);
    }

    public boolean getPhpGenericServices() {
        return this.phpGenericServices_;
    }

    public String getPhpMetadataNamespace() {
        return this.phpMetadataNamespace_;
    }

    public AbstractC2383g getPhpMetadataNamespaceBytes() {
        return AbstractC2383g.N(this.phpMetadataNamespace_);
    }

    public String getPhpNamespace() {
        return this.phpNamespace_;
    }

    public AbstractC2383g getPhpNamespaceBytes() {
        return AbstractC2383g.N(this.phpNamespace_);
    }

    public boolean getPyGenericServices() {
        return this.pyGenericServices_;
    }

    public String getRubyPackage() {
        return this.rubyPackage_;
    }

    public AbstractC2383g getRubyPackageBytes() {
        return AbstractC2383g.N(this.rubyPackage_);
    }

    public String getSwiftPrefix() {
        return this.swiftPrefix_;
    }

    public AbstractC2383g getSwiftPrefixBytes() {
        return AbstractC2383g.N(this.swiftPrefix_);
    }

    public DescriptorProtos$UninterpretedOption getUninterpretedOption(int i) {
        return (DescriptorProtos$UninterpretedOption) this.uninterpretedOption_.get(i);
    }

    public int getUninterpretedOptionCount() {
        return this.uninterpretedOption_.size();
    }

    public List<DescriptorProtos$UninterpretedOption> getUninterpretedOptionList() {
        return this.uninterpretedOption_;
    }

    public InterfaceC2391o getUninterpretedOptionOrBuilder(int i) {
        return (InterfaceC2391o) this.uninterpretedOption_.get(i);
    }

    public List<? extends InterfaceC2391o> getUninterpretedOptionOrBuilderList() {
        return this.uninterpretedOption_;
    }

    public boolean hasCcEnableArenas() {
        return (this.bitField0_ & 4096) != 0;
    }

    public boolean hasCcGenericServices() {
        return (this.bitField0_ & 128) != 0;
    }

    public boolean hasCsharpNamespace() {
        return (this.bitField0_ & 16384) != 0;
    }

    public boolean hasDeprecated() {
        return (this.bitField0_ & 2048) != 0;
    }

    public boolean hasGoPackage() {
        return (this.bitField0_ & 64) != 0;
    }

    @Deprecated
    public boolean hasJavaGenerateEqualsAndHash() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasJavaGenericServices() {
        return (this.bitField0_ & 256) != 0;
    }

    public boolean hasJavaMultipleFiles() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasJavaOuterClassname() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasJavaPackage() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasJavaStringCheckUtf8() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasObjcClassPrefix() {
        return (this.bitField0_ & 8192) != 0;
    }

    public boolean hasOptimizeFor() {
        return (this.bitField0_ & 32) != 0;
    }

    public boolean hasPhpClassPrefix() {
        return (this.bitField0_ & 65536) != 0;
    }

    public boolean hasPhpGenericServices() {
        return (this.bitField0_ & 1024) != 0;
    }

    public boolean hasPhpMetadataNamespace() {
        return (this.bitField0_ & 262144) != 0;
    }

    public boolean hasPhpNamespace() {
        return (this.bitField0_ & 131072) != 0;
    }

    public boolean hasPyGenericServices() {
        return (this.bitField0_ & 512) != 0;
    }

    public boolean hasRubyPackage() {
        return (this.bitField0_ & 524288) != 0;
    }

    public boolean hasSwiftPrefix() {
        return (this.bitField0_ & 32768) != 0;
    }

    public static a newBuilder(DescriptorProtos$FileOptions descriptorProtos$FileOptions) {
        return (a) DEFAULT_INSTANCE.createBuilder(descriptorProtos$FileOptions);
    }

    public static DescriptorProtos$FileOptions parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (DescriptorProtos$FileOptions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static DescriptorProtos$FileOptions parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (DescriptorProtos$FileOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static DescriptorProtos$FileOptions parseFrom(AbstractC2383g abstractC2383g) {
        return (DescriptorProtos$FileOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addUninterpretedOption(int i, DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
        descriptorProtos$UninterpretedOption.getClass();
        ensureUninterpretedOptionIsMutable();
        this.uninterpretedOption_.add(i, descriptorProtos$UninterpretedOption);
    }

    public static DescriptorProtos$FileOptions parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (DescriptorProtos$FileOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static DescriptorProtos$FileOptions parseFrom(byte[] bArr) {
        return (DescriptorProtos$FileOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static DescriptorProtos$FileOptions parseFrom(byte[] bArr, C2394s c2394s) {
        return (DescriptorProtos$FileOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static DescriptorProtos$FileOptions parseFrom(InputStream inputStream) {
        return (DescriptorProtos$FileOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DescriptorProtos$FileOptions parseFrom(InputStream inputStream, C2394s c2394s) {
        return (DescriptorProtos$FileOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static DescriptorProtos$FileOptions parseFrom(AbstractC2384h abstractC2384h) {
        return (DescriptorProtos$FileOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static DescriptorProtos$FileOptions parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (DescriptorProtos$FileOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
