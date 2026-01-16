package com.google.protobuf;

import com.google.protobuf.B;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes3.dex */
public final class DescriptorProtos$GeneratedCodeInfo extends GeneratedMessageLite implements U64 {
    public static final int ANNOTATION_FIELD_NUMBER = 1;
    private static final DescriptorProtos$GeneratedCodeInfo DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private B.j annotation_ = GeneratedMessageLite.emptyProtobufList();

    public static final class Annotation extends GeneratedMessageLite implements a {
        public static final int BEGIN_FIELD_NUMBER = 3;
        private static final Annotation DEFAULT_INSTANCE;
        public static final int END_FIELD_NUMBER = 4;
        private static volatile KW4 PARSER = null;
        public static final int PATH_FIELD_NUMBER = 1;
        public static final int SOURCE_FILE_FIELD_NUMBER = 2;
        private int begin_;
        private int bitField0_;
        private int end_;
        private int pathMemoizedSerializedSize = -1;
        private B.g path_ = GeneratedMessageLite.emptyIntList();
        private String sourceFile_ = "";

        public static final class a extends GeneratedMessageLite.b implements a {
            /* synthetic */ a(AbstractC2387k abstractC2387k) {
                this();
            }

            private a() {
                super(Annotation.DEFAULT_INSTANCE);
            }
        }

        static {
            Annotation annotation = new Annotation();
            DEFAULT_INSTANCE = annotation;
            GeneratedMessageLite.registerDefaultInstance(Annotation.class, annotation);
        }

        private Annotation() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllPath(Iterable<? extends Integer> iterable) {
            ensurePathIsMutable();
            AbstractC2377a.addAll((Iterable) iterable, (List) this.path_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addPath(int i) {
            ensurePathIsMutable();
            this.path_.b1(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearBegin() {
            this.bitField0_ &= -3;
            this.begin_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEnd() {
            this.bitField0_ &= -5;
            this.end_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPath() {
            this.path_ = GeneratedMessageLite.emptyIntList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSourceFile() {
            this.bitField0_ &= -2;
            this.sourceFile_ = getDefaultInstance().getSourceFile();
        }

        private void ensurePathIsMutable() {
            B.g gVar = this.path_;
            if (gVar.u()) {
                return;
            }
            this.path_ = GeneratedMessageLite.mutableCopy(gVar);
        }

        public static Annotation getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static a newBuilder() {
            return (a) DEFAULT_INSTANCE.createBuilder();
        }

        public static Annotation parseDelimitedFrom(InputStream inputStream) {
            return (Annotation) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Annotation parseFrom(ByteBuffer byteBuffer) {
            return (Annotation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static KW4 parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBegin(int i) {
            this.bitField0_ |= 2;
            this.begin_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEnd(int i) {
            this.bitField0_ |= 4;
            this.end_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPath(int i, int i2) {
            ensurePathIsMutable();
            this.path_.U(i, i2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSourceFile(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.sourceFile_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSourceFileBytes(AbstractC2383g abstractC2383g) {
            this.sourceFile_ = abstractC2383g.f0();
            this.bitField0_ |= 1;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
            AbstractC2387k abstractC2387k = null;
            switch (AbstractC2387k.a[gVar.ordinal()]) {
                case 1:
                    return new Annotation();
                case 2:
                    return new a(abstractC2387k);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001'\u0002ဈ\u0000\u0003င\u0001\u0004င\u0002", new Object[]{"bitField0_", "path_", "sourceFile_", "begin_", "end_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    KW4 cVar = PARSER;
                    if (cVar == null) {
                        synchronized (Annotation.class) {
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

        public int getBegin() {
            return this.begin_;
        }

        public int getEnd() {
            return this.end_;
        }

        public int getPath(int i) {
            return this.path_.getInt(i);
        }

        public int getPathCount() {
            return this.path_.size();
        }

        public List<Integer> getPathList() {
            return this.path_;
        }

        public String getSourceFile() {
            return this.sourceFile_;
        }

        public AbstractC2383g getSourceFileBytes() {
            return AbstractC2383g.N(this.sourceFile_);
        }

        public boolean hasBegin() {
            return (this.bitField0_ & 2) != 0;
        }

        public boolean hasEnd() {
            return (this.bitField0_ & 4) != 0;
        }

        public boolean hasSourceFile() {
            return (this.bitField0_ & 1) != 0;
        }

        public static a newBuilder(Annotation annotation) {
            return (a) DEFAULT_INSTANCE.createBuilder(annotation);
        }

        public static Annotation parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
            return (Annotation) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
        }

        public static Annotation parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
            return (Annotation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
        }

        public static Annotation parseFrom(AbstractC2383g abstractC2383g) {
            return (Annotation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
        }

        public static Annotation parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
            return (Annotation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
        }

        public static Annotation parseFrom(byte[] bArr) {
            return (Annotation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Annotation parseFrom(byte[] bArr, C2394s c2394s) {
            return (Annotation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
        }

        public static Annotation parseFrom(InputStream inputStream) {
            return (Annotation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Annotation parseFrom(InputStream inputStream, C2394s c2394s) {
            return (Annotation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
        }

        public static Annotation parseFrom(AbstractC2384h abstractC2384h) {
            return (Annotation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
        }

        public static Annotation parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
            return (Annotation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
        }
    }

    public interface a extends U64 {
    }

    public static final class b extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ b(AbstractC2387k abstractC2387k) {
            this();
        }

        private b() {
            super(DescriptorProtos$GeneratedCodeInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        DescriptorProtos$GeneratedCodeInfo descriptorProtos$GeneratedCodeInfo = new DescriptorProtos$GeneratedCodeInfo();
        DEFAULT_INSTANCE = descriptorProtos$GeneratedCodeInfo;
        GeneratedMessageLite.registerDefaultInstance(DescriptorProtos$GeneratedCodeInfo.class, descriptorProtos$GeneratedCodeInfo);
    }

    private DescriptorProtos$GeneratedCodeInfo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllAnnotation(Iterable<? extends Annotation> iterable) {
        ensureAnnotationIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.annotation_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAnnotation(Annotation annotation) {
        annotation.getClass();
        ensureAnnotationIsMutable();
        this.annotation_.add(annotation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAnnotation() {
        this.annotation_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureAnnotationIsMutable() {
        B.j jVar = this.annotation_;
        if (jVar.u()) {
            return;
        }
        this.annotation_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static DescriptorProtos$GeneratedCodeInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static DescriptorProtos$GeneratedCodeInfo parseDelimitedFrom(InputStream inputStream) {
        return (DescriptorProtos$GeneratedCodeInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DescriptorProtos$GeneratedCodeInfo parseFrom(ByteBuffer byteBuffer) {
        return (DescriptorProtos$GeneratedCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeAnnotation(int i) {
        ensureAnnotationIsMutable();
        this.annotation_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAnnotation(int i, Annotation annotation) {
        annotation.getClass();
        ensureAnnotationIsMutable();
        this.annotation_.set(i, annotation);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        AbstractC2387k abstractC2387k = null;
        switch (AbstractC2387k.a[gVar.ordinal()]) {
            case 1:
                return new DescriptorProtos$GeneratedCodeInfo();
            case 2:
                return new b(abstractC2387k);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"annotation_", Annotation.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (DescriptorProtos$GeneratedCodeInfo.class) {
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

    public Annotation getAnnotation(int i) {
        return (Annotation) this.annotation_.get(i);
    }

    public int getAnnotationCount() {
        return this.annotation_.size();
    }

    public List<Annotation> getAnnotationList() {
        return this.annotation_;
    }

    public a getAnnotationOrBuilder(int i) {
        return (a) this.annotation_.get(i);
    }

    public List<? extends a> getAnnotationOrBuilderList() {
        return this.annotation_;
    }

    public static b newBuilder(DescriptorProtos$GeneratedCodeInfo descriptorProtos$GeneratedCodeInfo) {
        return (b) DEFAULT_INSTANCE.createBuilder(descriptorProtos$GeneratedCodeInfo);
    }

    public static DescriptorProtos$GeneratedCodeInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (DescriptorProtos$GeneratedCodeInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static DescriptorProtos$GeneratedCodeInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (DescriptorProtos$GeneratedCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static DescriptorProtos$GeneratedCodeInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (DescriptorProtos$GeneratedCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAnnotation(int i, Annotation annotation) {
        annotation.getClass();
        ensureAnnotationIsMutable();
        this.annotation_.add(i, annotation);
    }

    public static DescriptorProtos$GeneratedCodeInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (DescriptorProtos$GeneratedCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static DescriptorProtos$GeneratedCodeInfo parseFrom(byte[] bArr) {
        return (DescriptorProtos$GeneratedCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static DescriptorProtos$GeneratedCodeInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (DescriptorProtos$GeneratedCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static DescriptorProtos$GeneratedCodeInfo parseFrom(InputStream inputStream) {
        return (DescriptorProtos$GeneratedCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DescriptorProtos$GeneratedCodeInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (DescriptorProtos$GeneratedCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static DescriptorProtos$GeneratedCodeInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (DescriptorProtos$GeneratedCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static DescriptorProtos$GeneratedCodeInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (DescriptorProtos$GeneratedCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
