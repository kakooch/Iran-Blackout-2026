package com.google.protobuf;

import com.google.protobuf.B;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes3.dex */
public final class DescriptorProtos$SourceCodeInfo extends GeneratedMessageLite implements U64 {
    private static final DescriptorProtos$SourceCodeInfo DEFAULT_INSTANCE;
    public static final int LOCATION_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j location_ = GeneratedMessageLite.emptyProtobufList();

    public static final class Location extends GeneratedMessageLite implements b {
        private static final Location DEFAULT_INSTANCE;
        public static final int LEADING_COMMENTS_FIELD_NUMBER = 3;
        public static final int LEADING_DETACHED_COMMENTS_FIELD_NUMBER = 6;
        private static volatile KW4 PARSER = null;
        public static final int PATH_FIELD_NUMBER = 1;
        public static final int SPAN_FIELD_NUMBER = 2;
        public static final int TRAILING_COMMENTS_FIELD_NUMBER = 4;
        private int bitField0_;
        private int pathMemoizedSerializedSize = -1;
        private int spanMemoizedSerializedSize = -1;
        private B.g path_ = GeneratedMessageLite.emptyIntList();
        private B.g span_ = GeneratedMessageLite.emptyIntList();
        private String leadingComments_ = "";
        private String trailingComments_ = "";
        private B.j leadingDetachedComments_ = GeneratedMessageLite.emptyProtobufList();

        public static final class a extends GeneratedMessageLite.b implements b {
            /* synthetic */ a(AbstractC2387k abstractC2387k) {
                this();
            }

            private a() {
                super(Location.DEFAULT_INSTANCE);
            }
        }

        static {
            Location location = new Location();
            DEFAULT_INSTANCE = location;
            GeneratedMessageLite.registerDefaultInstance(Location.class, location);
        }

        private Location() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllLeadingDetachedComments(Iterable<String> iterable) {
            ensureLeadingDetachedCommentsIsMutable();
            AbstractC2377a.addAll((Iterable) iterable, (List) this.leadingDetachedComments_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllPath(Iterable<? extends Integer> iterable) {
            ensurePathIsMutable();
            AbstractC2377a.addAll((Iterable) iterable, (List) this.path_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllSpan(Iterable<? extends Integer> iterable) {
            ensureSpanIsMutable();
            AbstractC2377a.addAll((Iterable) iterable, (List) this.span_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addLeadingDetachedComments(String str) {
            str.getClass();
            ensureLeadingDetachedCommentsIsMutable();
            this.leadingDetachedComments_.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addLeadingDetachedCommentsBytes(AbstractC2383g abstractC2383g) {
            ensureLeadingDetachedCommentsIsMutable();
            this.leadingDetachedComments_.add(abstractC2383g.f0());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addPath(int i) {
            ensurePathIsMutable();
            this.path_.b1(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addSpan(int i) {
            ensureSpanIsMutable();
            this.span_.b1(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLeadingComments() {
            this.bitField0_ &= -2;
            this.leadingComments_ = getDefaultInstance().getLeadingComments();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLeadingDetachedComments() {
            this.leadingDetachedComments_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPath() {
            this.path_ = GeneratedMessageLite.emptyIntList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSpan() {
            this.span_ = GeneratedMessageLite.emptyIntList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTrailingComments() {
            this.bitField0_ &= -3;
            this.trailingComments_ = getDefaultInstance().getTrailingComments();
        }

        private void ensureLeadingDetachedCommentsIsMutable() {
            B.j jVar = this.leadingDetachedComments_;
            if (jVar.u()) {
                return;
            }
            this.leadingDetachedComments_ = GeneratedMessageLite.mutableCopy(jVar);
        }

        private void ensurePathIsMutable() {
            B.g gVar = this.path_;
            if (gVar.u()) {
                return;
            }
            this.path_ = GeneratedMessageLite.mutableCopy(gVar);
        }

        private void ensureSpanIsMutable() {
            B.g gVar = this.span_;
            if (gVar.u()) {
                return;
            }
            this.span_ = GeneratedMessageLite.mutableCopy(gVar);
        }

        public static Location getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static a newBuilder() {
            return (a) DEFAULT_INSTANCE.createBuilder();
        }

        public static Location parseDelimitedFrom(InputStream inputStream) {
            return (Location) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Location parseFrom(ByteBuffer byteBuffer) {
            return (Location) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static KW4 parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLeadingComments(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.leadingComments_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLeadingCommentsBytes(AbstractC2383g abstractC2383g) {
            this.leadingComments_ = abstractC2383g.f0();
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLeadingDetachedComments(int i, String str) {
            str.getClass();
            ensureLeadingDetachedCommentsIsMutable();
            this.leadingDetachedComments_.set(i, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPath(int i, int i2) {
            ensurePathIsMutable();
            this.path_.U(i, i2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSpan(int i, int i2) {
            ensureSpanIsMutable();
            this.span_.U(i, i2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTrailingComments(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.trailingComments_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTrailingCommentsBytes(AbstractC2383g abstractC2383g) {
            this.trailingComments_ = abstractC2383g.f0();
            this.bitField0_ |= 2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
            AbstractC2387k abstractC2387k = null;
            switch (AbstractC2387k.a[gVar.ordinal()]) {
                case 1:
                    return new Location();
                case 2:
                    return new a(abstractC2387k);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0006\u0005\u0000\u0003\u0000\u0001'\u0002'\u0003ဈ\u0000\u0004ဈ\u0001\u0006\u001a", new Object[]{"bitField0_", "path_", "span_", "leadingComments_", "trailingComments_", "leadingDetachedComments_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    KW4 cVar = PARSER;
                    if (cVar == null) {
                        synchronized (Location.class) {
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

        public String getLeadingComments() {
            return this.leadingComments_;
        }

        public AbstractC2383g getLeadingCommentsBytes() {
            return AbstractC2383g.N(this.leadingComments_);
        }

        public String getLeadingDetachedComments(int i) {
            return (String) this.leadingDetachedComments_.get(i);
        }

        public AbstractC2383g getLeadingDetachedCommentsBytes(int i) {
            return AbstractC2383g.N((String) this.leadingDetachedComments_.get(i));
        }

        public int getLeadingDetachedCommentsCount() {
            return this.leadingDetachedComments_.size();
        }

        public List<String> getLeadingDetachedCommentsList() {
            return this.leadingDetachedComments_;
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

        public int getSpan(int i) {
            return this.span_.getInt(i);
        }

        public int getSpanCount() {
            return this.span_.size();
        }

        public List<Integer> getSpanList() {
            return this.span_;
        }

        public String getTrailingComments() {
            return this.trailingComments_;
        }

        public AbstractC2383g getTrailingCommentsBytes() {
            return AbstractC2383g.N(this.trailingComments_);
        }

        public boolean hasLeadingComments() {
            return (this.bitField0_ & 1) != 0;
        }

        public boolean hasTrailingComments() {
            return (this.bitField0_ & 2) != 0;
        }

        public static a newBuilder(Location location) {
            return (a) DEFAULT_INSTANCE.createBuilder(location);
        }

        public static Location parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
            return (Location) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
        }

        public static Location parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
            return (Location) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
        }

        public static Location parseFrom(AbstractC2383g abstractC2383g) {
            return (Location) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
        }

        public static Location parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
            return (Location) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
        }

        public static Location parseFrom(byte[] bArr) {
            return (Location) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Location parseFrom(byte[] bArr, C2394s c2394s) {
            return (Location) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
        }

        public static Location parseFrom(InputStream inputStream) {
            return (Location) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Location parseFrom(InputStream inputStream, C2394s c2394s) {
            return (Location) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
        }

        public static Location parseFrom(AbstractC2384h abstractC2384h) {
            return (Location) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
        }

        public static Location parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
            return (Location) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
        }
    }

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(AbstractC2387k abstractC2387k) {
            this();
        }

        private a() {
            super(DescriptorProtos$SourceCodeInfo.DEFAULT_INSTANCE);
        }
    }

    public interface b extends U64 {
    }

    static {
        DescriptorProtos$SourceCodeInfo descriptorProtos$SourceCodeInfo = new DescriptorProtos$SourceCodeInfo();
        DEFAULT_INSTANCE = descriptorProtos$SourceCodeInfo;
        GeneratedMessageLite.registerDefaultInstance(DescriptorProtos$SourceCodeInfo.class, descriptorProtos$SourceCodeInfo);
    }

    private DescriptorProtos$SourceCodeInfo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllLocation(Iterable<? extends Location> iterable) {
        ensureLocationIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.location_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLocation(Location location) {
        location.getClass();
        ensureLocationIsMutable();
        this.location_.add(location);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLocation() {
        this.location_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureLocationIsMutable() {
        B.j jVar = this.location_;
        if (jVar.u()) {
            return;
        }
        this.location_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static DescriptorProtos$SourceCodeInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static DescriptorProtos$SourceCodeInfo parseDelimitedFrom(InputStream inputStream) {
        return (DescriptorProtos$SourceCodeInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DescriptorProtos$SourceCodeInfo parseFrom(ByteBuffer byteBuffer) {
        return (DescriptorProtos$SourceCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeLocation(int i) {
        ensureLocationIsMutable();
        this.location_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLocation(int i, Location location) {
        location.getClass();
        ensureLocationIsMutable();
        this.location_.set(i, location);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        AbstractC2387k abstractC2387k = null;
        switch (AbstractC2387k.a[gVar.ordinal()]) {
            case 1:
                return new DescriptorProtos$SourceCodeInfo();
            case 2:
                return new a(abstractC2387k);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"location_", Location.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (DescriptorProtos$SourceCodeInfo.class) {
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

    public Location getLocation(int i) {
        return (Location) this.location_.get(i);
    }

    public int getLocationCount() {
        return this.location_.size();
    }

    public List<Location> getLocationList() {
        return this.location_;
    }

    public b getLocationOrBuilder(int i) {
        return (b) this.location_.get(i);
    }

    public List<? extends b> getLocationOrBuilderList() {
        return this.location_;
    }

    public static a newBuilder(DescriptorProtos$SourceCodeInfo descriptorProtos$SourceCodeInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(descriptorProtos$SourceCodeInfo);
    }

    public static DescriptorProtos$SourceCodeInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (DescriptorProtos$SourceCodeInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static DescriptorProtos$SourceCodeInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (DescriptorProtos$SourceCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static DescriptorProtos$SourceCodeInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (DescriptorProtos$SourceCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLocation(int i, Location location) {
        location.getClass();
        ensureLocationIsMutable();
        this.location_.add(i, location);
    }

    public static DescriptorProtos$SourceCodeInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (DescriptorProtos$SourceCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static DescriptorProtos$SourceCodeInfo parseFrom(byte[] bArr) {
        return (DescriptorProtos$SourceCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static DescriptorProtos$SourceCodeInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (DescriptorProtos$SourceCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static DescriptorProtos$SourceCodeInfo parseFrom(InputStream inputStream) {
        return (DescriptorProtos$SourceCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DescriptorProtos$SourceCodeInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (DescriptorProtos$SourceCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static DescriptorProtos$SourceCodeInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (DescriptorProtos$SourceCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static DescriptorProtos$SourceCodeInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (DescriptorProtos$SourceCodeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
