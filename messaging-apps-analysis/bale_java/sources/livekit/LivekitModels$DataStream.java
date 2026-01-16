package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.I;
import com.google.protobuf.J;
import com.google.protobuf.r0;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import livekit.LivekitModels$Encryption;

/* loaded from: classes8.dex */
public final class LivekitModels$DataStream extends GeneratedMessageLite implements U64 {
    private static final LivekitModels$DataStream DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;

    public static final class ByteHeader extends GeneratedMessageLite implements U64 {
        private static final ByteHeader DEFAULT_INSTANCE;
        public static final int NAME_FIELD_NUMBER = 1;
        private static volatile KW4 PARSER;
        private String name_ = "";

        public static final class a extends GeneratedMessageLite.b implements U64 {
            /* synthetic */ a(o oVar) {
                this();
            }

            private a() {
                super(ByteHeader.DEFAULT_INSTANCE);
            }
        }

        static {
            ByteHeader byteHeader = new ByteHeader();
            DEFAULT_INSTANCE = byteHeader;
            GeneratedMessageLite.registerDefaultInstance(ByteHeader.class, byteHeader);
        }

        private ByteHeader() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearName() {
            this.name_ = getDefaultInstance().getName();
        }

        public static ByteHeader getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static a newBuilder() {
            return (a) DEFAULT_INSTANCE.createBuilder();
        }

        public static ByteHeader parseDelimitedFrom(InputStream inputStream) {
            return (ByteHeader) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ByteHeader parseFrom(ByteBuffer byteBuffer) {
            return (ByteHeader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static KW4 parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setName(String str) {
            str.getClass();
            this.name_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNameBytes(AbstractC2383g abstractC2383g) {
            AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
            this.name_ = abstractC2383g.f0();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
            o oVar = null;
            switch (o.a[gVar.ordinal()]) {
                case 1:
                    return new ByteHeader();
                case 2:
                    return new a(oVar);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"name_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    KW4 cVar = PARSER;
                    if (cVar == null) {
                        synchronized (ByteHeader.class) {
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

        public String getName() {
            return this.name_;
        }

        public AbstractC2383g getNameBytes() {
            return AbstractC2383g.N(this.name_);
        }

        public static a newBuilder(ByteHeader byteHeader) {
            return (a) DEFAULT_INSTANCE.createBuilder(byteHeader);
        }

        public static ByteHeader parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
            return (ByteHeader) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
        }

        public static ByteHeader parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
            return (ByteHeader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
        }

        public static ByteHeader parseFrom(AbstractC2383g abstractC2383g) {
            return (ByteHeader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
        }

        public static ByteHeader parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
            return (ByteHeader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
        }

        public static ByteHeader parseFrom(byte[] bArr) {
            return (ByteHeader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ByteHeader parseFrom(byte[] bArr, C2394s c2394s) {
            return (ByteHeader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
        }

        public static ByteHeader parseFrom(InputStream inputStream) {
            return (ByteHeader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ByteHeader parseFrom(InputStream inputStream, C2394s c2394s) {
            return (ByteHeader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
        }

        public static ByteHeader parseFrom(AbstractC2384h abstractC2384h) {
            return (ByteHeader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
        }

        public static ByteHeader parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
            return (ByteHeader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
        }
    }

    public static final class Chunk extends GeneratedMessageLite implements U64 {
        public static final int CHUNK_INDEX_FIELD_NUMBER = 2;
        public static final int CONTENT_FIELD_NUMBER = 3;
        private static final Chunk DEFAULT_INSTANCE;
        public static final int IV_FIELD_NUMBER = 5;
        private static volatile KW4 PARSER = null;
        public static final int STREAM_ID_FIELD_NUMBER = 1;
        public static final int VERSION_FIELD_NUMBER = 4;
        private int bitField0_;
        private long chunkIndex_;
        private AbstractC2383g content_;
        private AbstractC2383g iv_;
        private String streamId_ = "";
        private int version_;

        public static final class a extends GeneratedMessageLite.b implements U64 {
            /* synthetic */ a(o oVar) {
                this();
            }

            private a() {
                super(Chunk.DEFAULT_INSTANCE);
            }
        }

        static {
            Chunk chunk = new Chunk();
            DEFAULT_INSTANCE = chunk;
            GeneratedMessageLite.registerDefaultInstance(Chunk.class, chunk);
        }

        private Chunk() {
            AbstractC2383g abstractC2383g = AbstractC2383g.b;
            this.content_ = abstractC2383g;
            this.iv_ = abstractC2383g;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearChunkIndex() {
            this.chunkIndex_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearContent() {
            this.content_ = getDefaultInstance().getContent();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIv() {
            this.bitField0_ &= -2;
            this.iv_ = getDefaultInstance().getIv();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStreamId() {
            this.streamId_ = getDefaultInstance().getStreamId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearVersion() {
            this.version_ = 0;
        }

        public static Chunk getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static a newBuilder() {
            return (a) DEFAULT_INSTANCE.createBuilder();
        }

        public static Chunk parseDelimitedFrom(InputStream inputStream) {
            return (Chunk) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Chunk parseFrom(ByteBuffer byteBuffer) {
            return (Chunk) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static KW4 parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setChunkIndex(long j) {
            this.chunkIndex_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setContent(AbstractC2383g abstractC2383g) {
            abstractC2383g.getClass();
            this.content_ = abstractC2383g;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIv(AbstractC2383g abstractC2383g) {
            abstractC2383g.getClass();
            this.bitField0_ |= 1;
            this.iv_ = abstractC2383g;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStreamId(String str) {
            str.getClass();
            this.streamId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStreamIdBytes(AbstractC2383g abstractC2383g) {
            AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
            this.streamId_ = abstractC2383g.f0();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVersion(int i) {
            this.version_ = i;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
            o oVar = null;
            switch (o.a[gVar.ordinal()]) {
                case 1:
                    return new Chunk();
                case 2:
                    return new a(oVar);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002\u0003\u0003\n\u0004\u0004\u0005ည\u0000", new Object[]{"bitField0_", "streamId_", "chunkIndex_", "content_", "version_", "iv_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    KW4 cVar = PARSER;
                    if (cVar == null) {
                        synchronized (Chunk.class) {
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

        public long getChunkIndex() {
            return this.chunkIndex_;
        }

        public AbstractC2383g getContent() {
            return this.content_;
        }

        public AbstractC2383g getIv() {
            return this.iv_;
        }

        public String getStreamId() {
            return this.streamId_;
        }

        public AbstractC2383g getStreamIdBytes() {
            return AbstractC2383g.N(this.streamId_);
        }

        public int getVersion() {
            return this.version_;
        }

        public boolean hasIv() {
            return (this.bitField0_ & 1) != 0;
        }

        public static a newBuilder(Chunk chunk) {
            return (a) DEFAULT_INSTANCE.createBuilder(chunk);
        }

        public static Chunk parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
            return (Chunk) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
        }

        public static Chunk parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
            return (Chunk) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
        }

        public static Chunk parseFrom(AbstractC2383g abstractC2383g) {
            return (Chunk) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
        }

        public static Chunk parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
            return (Chunk) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
        }

        public static Chunk parseFrom(byte[] bArr) {
            return (Chunk) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Chunk parseFrom(byte[] bArr, C2394s c2394s) {
            return (Chunk) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
        }

        public static Chunk parseFrom(InputStream inputStream) {
            return (Chunk) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Chunk parseFrom(InputStream inputStream, C2394s c2394s) {
            return (Chunk) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
        }

        public static Chunk parseFrom(AbstractC2384h abstractC2384h) {
            return (Chunk) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
        }

        public static Chunk parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
            return (Chunk) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
        }
    }

    public static final class Header extends GeneratedMessageLite implements U64 {
        public static final int ATTRIBUTES_FIELD_NUMBER = 8;
        public static final int BYTE_HEADER_FIELD_NUMBER = 10;
        private static final Header DEFAULT_INSTANCE;
        public static final int ENCRYPTION_TYPE_FIELD_NUMBER = 7;
        public static final int MIME_TYPE_FIELD_NUMBER = 4;
        private static volatile KW4 PARSER = null;
        public static final int STREAM_ID_FIELD_NUMBER = 1;
        public static final int TEXT_HEADER_FIELD_NUMBER = 9;
        public static final int TIMESTAMP_FIELD_NUMBER = 2;
        public static final int TOPIC_FIELD_NUMBER = 3;
        public static final int TOTAL_LENGTH_FIELD_NUMBER = 5;
        private int bitField0_;
        private Object contentHeader_;
        private int encryptionType_;
        private long timestamp_;
        private long totalLength_;
        private int contentHeaderCase_ = 0;
        private J attributes_ = J.e();
        private String streamId_ = "";
        private String topic_ = "";
        private String mimeType_ = "";

        private static final class a {
            static final I a;

            static {
                r0.b bVar = r0.b.k;
                a = I.d(bVar, "", bVar, "");
            }
        }

        public static final class b extends GeneratedMessageLite.b implements U64 {
            /* synthetic */ b(o oVar) {
                this();
            }

            private b() {
                super(Header.DEFAULT_INSTANCE);
            }
        }

        public enum c {
            TEXT_HEADER(9),
            BYTE_HEADER(10),
            CONTENTHEADER_NOT_SET(0);

            private final int a;

            c(int i) {
                this.a = i;
            }

            public static c j(int i) {
                if (i == 0) {
                    return CONTENTHEADER_NOT_SET;
                }
                if (i == 9) {
                    return TEXT_HEADER;
                }
                if (i != 10) {
                    return null;
                }
                return BYTE_HEADER;
            }
        }

        static {
            Header header = new Header();
            DEFAULT_INSTANCE = header;
            GeneratedMessageLite.registerDefaultInstance(Header.class, header);
        }

        private Header() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearByteHeader() {
            if (this.contentHeaderCase_ == 10) {
                this.contentHeaderCase_ = 0;
                this.contentHeader_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearContentHeader() {
            this.contentHeaderCase_ = 0;
            this.contentHeader_ = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEncryptionType() {
            this.encryptionType_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMimeType() {
            this.mimeType_ = getDefaultInstance().getMimeType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStreamId() {
            this.streamId_ = getDefaultInstance().getStreamId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTextHeader() {
            if (this.contentHeaderCase_ == 9) {
                this.contentHeaderCase_ = 0;
                this.contentHeader_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTimestamp() {
            this.timestamp_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTopic() {
            this.topic_ = getDefaultInstance().getTopic();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTotalLength() {
            this.bitField0_ &= -2;
            this.totalLength_ = 0L;
        }

        public static Header getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, String> getMutableAttributesMap() {
            return internalGetMutableAttributes();
        }

        private J internalGetAttributes() {
            return this.attributes_;
        }

        private J internalGetMutableAttributes() {
            if (!this.attributes_.n()) {
                this.attributes_ = this.attributes_.s();
            }
            return this.attributes_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeByteHeader(ByteHeader byteHeader) {
            byteHeader.getClass();
            if (this.contentHeaderCase_ != 10 || this.contentHeader_ == ByteHeader.getDefaultInstance()) {
                this.contentHeader_ = byteHeader;
            } else {
                this.contentHeader_ = ((ByteHeader.a) ByteHeader.newBuilder((ByteHeader) this.contentHeader_).v(byteHeader)).j();
            }
            this.contentHeaderCase_ = 10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeTextHeader(TextHeader textHeader) {
            textHeader.getClass();
            if (this.contentHeaderCase_ != 9 || this.contentHeader_ == TextHeader.getDefaultInstance()) {
                this.contentHeader_ = textHeader;
            } else {
                this.contentHeader_ = ((TextHeader.a) TextHeader.newBuilder((TextHeader) this.contentHeader_).v(textHeader)).j();
            }
            this.contentHeaderCase_ = 9;
        }

        public static b newBuilder() {
            return (b) DEFAULT_INSTANCE.createBuilder();
        }

        public static Header parseDelimitedFrom(InputStream inputStream) {
            return (Header) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Header parseFrom(ByteBuffer byteBuffer) {
            return (Header) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static KW4 parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setByteHeader(ByteHeader byteHeader) {
            byteHeader.getClass();
            this.contentHeader_ = byteHeader;
            this.contentHeaderCase_ = 10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEncryptionType(LivekitModels$Encryption.b bVar) {
            this.encryptionType_ = bVar.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEncryptionTypeValue(int i) {
            this.encryptionType_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMimeType(String str) {
            str.getClass();
            this.mimeType_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMimeTypeBytes(AbstractC2383g abstractC2383g) {
            AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
            this.mimeType_ = abstractC2383g.f0();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStreamId(String str) {
            str.getClass();
            this.streamId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStreamIdBytes(AbstractC2383g abstractC2383g) {
            AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
            this.streamId_ = abstractC2383g.f0();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTextHeader(TextHeader textHeader) {
            textHeader.getClass();
            this.contentHeader_ = textHeader;
            this.contentHeaderCase_ = 9;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTimestamp(long j) {
            this.timestamp_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTopic(String str) {
            str.getClass();
            this.topic_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTopicBytes(AbstractC2383g abstractC2383g) {
            AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
            this.topic_ = abstractC2383g.f0();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTotalLength(long j) {
            this.bitField0_ |= 1;
            this.totalLength_ = j;
        }

        public boolean containsAttributes(String str) {
            str.getClass();
            return internalGetAttributes().containsKey(str);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
            o oVar = null;
            switch (o.a[gVar.ordinal()]) {
                case 1:
                    return new Header();
                case 2:
                    return new b(oVar);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\t\u0001\u0001\u0001\n\t\u0001\u0000\u0000\u0001Ȉ\u0002\u0002\u0003Ȉ\u0004Ȉ\u0005ဃ\u0000\u0007\f\b2\t<\u0000\n<\u0000", new Object[]{"contentHeader_", "contentHeaderCase_", "bitField0_", "streamId_", "timestamp_", "topic_", "mimeType_", "totalLength_", "encryptionType_", "attributes_", a.a, TextHeader.class, ByteHeader.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    KW4 cVar = PARSER;
                    if (cVar == null) {
                        synchronized (Header.class) {
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

        @Deprecated
        public Map<String, String> getAttributes() {
            return getAttributesMap();
        }

        public int getAttributesCount() {
            return internalGetAttributes().size();
        }

        public Map<String, String> getAttributesMap() {
            return Collections.unmodifiableMap(internalGetAttributes());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public String getAttributesOrDefault(String str, String str2) {
            str.getClass();
            J jInternalGetAttributes = internalGetAttributes();
            return jInternalGetAttributes.containsKey(str) ? (String) jInternalGetAttributes.get(str) : str2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public String getAttributesOrThrow(String str) {
            str.getClass();
            J jInternalGetAttributes = internalGetAttributes();
            if (jInternalGetAttributes.containsKey(str)) {
                return (String) jInternalGetAttributes.get(str);
            }
            throw new IllegalArgumentException();
        }

        public ByteHeader getByteHeader() {
            return this.contentHeaderCase_ == 10 ? (ByteHeader) this.contentHeader_ : ByteHeader.getDefaultInstance();
        }

        public c getContentHeaderCase() {
            return c.j(this.contentHeaderCase_);
        }

        public LivekitModels$Encryption.b getEncryptionType() {
            LivekitModels$Encryption.b bVarJ = LivekitModels$Encryption.b.j(this.encryptionType_);
            return bVarJ == null ? LivekitModels$Encryption.b.UNRECOGNIZED : bVarJ;
        }

        public int getEncryptionTypeValue() {
            return this.encryptionType_;
        }

        public String getMimeType() {
            return this.mimeType_;
        }

        public AbstractC2383g getMimeTypeBytes() {
            return AbstractC2383g.N(this.mimeType_);
        }

        public String getStreamId() {
            return this.streamId_;
        }

        public AbstractC2383g getStreamIdBytes() {
            return AbstractC2383g.N(this.streamId_);
        }

        public TextHeader getTextHeader() {
            return this.contentHeaderCase_ == 9 ? (TextHeader) this.contentHeader_ : TextHeader.getDefaultInstance();
        }

        public long getTimestamp() {
            return this.timestamp_;
        }

        public String getTopic() {
            return this.topic_;
        }

        public AbstractC2383g getTopicBytes() {
            return AbstractC2383g.N(this.topic_);
        }

        public long getTotalLength() {
            return this.totalLength_;
        }

        public boolean hasByteHeader() {
            return this.contentHeaderCase_ == 10;
        }

        public boolean hasTextHeader() {
            return this.contentHeaderCase_ == 9;
        }

        public boolean hasTotalLength() {
            return (this.bitField0_ & 1) != 0;
        }

        public static b newBuilder(Header header) {
            return (b) DEFAULT_INSTANCE.createBuilder(header);
        }

        public static Header parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
            return (Header) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
        }

        public static Header parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
            return (Header) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
        }

        public static Header parseFrom(AbstractC2383g abstractC2383g) {
            return (Header) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
        }

        public static Header parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
            return (Header) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
        }

        public static Header parseFrom(byte[] bArr) {
            return (Header) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Header parseFrom(byte[] bArr, C2394s c2394s) {
            return (Header) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
        }

        public static Header parseFrom(InputStream inputStream) {
            return (Header) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Header parseFrom(InputStream inputStream, C2394s c2394s) {
            return (Header) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
        }

        public static Header parseFrom(AbstractC2384h abstractC2384h) {
            return (Header) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
        }

        public static Header parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
            return (Header) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
        }
    }

    public static final class TextHeader extends GeneratedMessageLite implements U64 {
        public static final int ATTACHED_STREAM_IDS_FIELD_NUMBER = 4;
        private static final TextHeader DEFAULT_INSTANCE;
        public static final int GENERATED_FIELD_NUMBER = 5;
        public static final int OPERATION_TYPE_FIELD_NUMBER = 1;
        private static volatile KW4 PARSER = null;
        public static final int REPLY_TO_STREAM_ID_FIELD_NUMBER = 3;
        public static final int VERSION_FIELD_NUMBER = 2;
        private boolean generated_;
        private int operationType_;
        private int version_;
        private String replyToStreamId_ = "";
        private B.j attachedStreamIds_ = GeneratedMessageLite.emptyProtobufList();

        public static final class a extends GeneratedMessageLite.b implements U64 {
            /* synthetic */ a(o oVar) {
                this();
            }

            private a() {
                super(TextHeader.DEFAULT_INSTANCE);
            }
        }

        static {
            TextHeader textHeader = new TextHeader();
            DEFAULT_INSTANCE = textHeader;
            GeneratedMessageLite.registerDefaultInstance(TextHeader.class, textHeader);
        }

        private TextHeader() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllAttachedStreamIds(Iterable<String> iterable) {
            ensureAttachedStreamIdsIsMutable();
            AbstractC2377a.addAll((Iterable) iterable, (List) this.attachedStreamIds_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAttachedStreamIds(String str) {
            str.getClass();
            ensureAttachedStreamIdsIsMutable();
            this.attachedStreamIds_.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAttachedStreamIdsBytes(AbstractC2383g abstractC2383g) {
            AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
            ensureAttachedStreamIdsIsMutable();
            this.attachedStreamIds_.add(abstractC2383g.f0());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAttachedStreamIds() {
            this.attachedStreamIds_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearGenerated() {
            this.generated_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOperationType() {
            this.operationType_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearReplyToStreamId() {
            this.replyToStreamId_ = getDefaultInstance().getReplyToStreamId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearVersion() {
            this.version_ = 0;
        }

        private void ensureAttachedStreamIdsIsMutable() {
            B.j jVar = this.attachedStreamIds_;
            if (jVar.u()) {
                return;
            }
            this.attachedStreamIds_ = GeneratedMessageLite.mutableCopy(jVar);
        }

        public static TextHeader getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static a newBuilder() {
            return (a) DEFAULT_INSTANCE.createBuilder();
        }

        public static TextHeader parseDelimitedFrom(InputStream inputStream) {
            return (TextHeader) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TextHeader parseFrom(ByteBuffer byteBuffer) {
            return (TextHeader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static KW4 parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAttachedStreamIds(int i, String str) {
            str.getClass();
            ensureAttachedStreamIdsIsMutable();
            this.attachedStreamIds_.set(i, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setGenerated(boolean z) {
            this.generated_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOperationType(b bVar) {
            this.operationType_ = bVar.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOperationTypeValue(int i) {
            this.operationType_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setReplyToStreamId(String str) {
            str.getClass();
            this.replyToStreamId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setReplyToStreamIdBytes(AbstractC2383g abstractC2383g) {
            AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
            this.replyToStreamId_ = abstractC2383g.f0();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVersion(int i) {
            this.version_ = i;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
            o oVar = null;
            switch (o.a[gVar.ordinal()]) {
                case 1:
                    return new TextHeader();
                case 2:
                    return new a(oVar);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0001\u0000\u0001\f\u0002\u0004\u0003Ȉ\u0004Ț\u0005\u0007", new Object[]{"operationType_", "version_", "replyToStreamId_", "attachedStreamIds_", "generated_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    KW4 cVar = PARSER;
                    if (cVar == null) {
                        synchronized (TextHeader.class) {
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

        public String getAttachedStreamIds(int i) {
            return (String) this.attachedStreamIds_.get(i);
        }

        public AbstractC2383g getAttachedStreamIdsBytes(int i) {
            return AbstractC2383g.N((String) this.attachedStreamIds_.get(i));
        }

        public int getAttachedStreamIdsCount() {
            return this.attachedStreamIds_.size();
        }

        public List<String> getAttachedStreamIdsList() {
            return this.attachedStreamIds_;
        }

        public boolean getGenerated() {
            return this.generated_;
        }

        public b getOperationType() {
            b bVarJ = b.j(this.operationType_);
            return bVarJ == null ? b.UNRECOGNIZED : bVarJ;
        }

        public int getOperationTypeValue() {
            return this.operationType_;
        }

        public String getReplyToStreamId() {
            return this.replyToStreamId_;
        }

        public AbstractC2383g getReplyToStreamIdBytes() {
            return AbstractC2383g.N(this.replyToStreamId_);
        }

        public int getVersion() {
            return this.version_;
        }

        public static a newBuilder(TextHeader textHeader) {
            return (a) DEFAULT_INSTANCE.createBuilder(textHeader);
        }

        public static TextHeader parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
            return (TextHeader) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
        }

        public static TextHeader parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
            return (TextHeader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
        }

        public static TextHeader parseFrom(AbstractC2383g abstractC2383g) {
            return (TextHeader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
        }

        public static TextHeader parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
            return (TextHeader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
        }

        public static TextHeader parseFrom(byte[] bArr) {
            return (TextHeader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static TextHeader parseFrom(byte[] bArr, C2394s c2394s) {
            return (TextHeader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
        }

        public static TextHeader parseFrom(InputStream inputStream) {
            return (TextHeader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TextHeader parseFrom(InputStream inputStream, C2394s c2394s) {
            return (TextHeader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
        }

        public static TextHeader parseFrom(AbstractC2384h abstractC2384h) {
            return (TextHeader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
        }

        public static TextHeader parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
            return (TextHeader) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
        }
    }

    public static final class Trailer extends GeneratedMessageLite implements U64 {
        public static final int ATTRIBUTES_FIELD_NUMBER = 3;
        private static final Trailer DEFAULT_INSTANCE;
        private static volatile KW4 PARSER = null;
        public static final int REASON_FIELD_NUMBER = 2;
        public static final int STREAM_ID_FIELD_NUMBER = 1;
        private J attributes_ = J.e();
        private String streamId_ = "";
        private String reason_ = "";

        private static final class a {
            static final I a;

            static {
                r0.b bVar = r0.b.k;
                a = I.d(bVar, "", bVar, "");
            }
        }

        public static final class b extends GeneratedMessageLite.b implements U64 {
            /* synthetic */ b(o oVar) {
                this();
            }

            private b() {
                super(Trailer.DEFAULT_INSTANCE);
            }
        }

        static {
            Trailer trailer = new Trailer();
            DEFAULT_INSTANCE = trailer;
            GeneratedMessageLite.registerDefaultInstance(Trailer.class, trailer);
        }

        private Trailer() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearReason() {
            this.reason_ = getDefaultInstance().getReason();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStreamId() {
            this.streamId_ = getDefaultInstance().getStreamId();
        }

        public static Trailer getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, String> getMutableAttributesMap() {
            return internalGetMutableAttributes();
        }

        private J internalGetAttributes() {
            return this.attributes_;
        }

        private J internalGetMutableAttributes() {
            if (!this.attributes_.n()) {
                this.attributes_ = this.attributes_.s();
            }
            return this.attributes_;
        }

        public static b newBuilder() {
            return (b) DEFAULT_INSTANCE.createBuilder();
        }

        public static Trailer parseDelimitedFrom(InputStream inputStream) {
            return (Trailer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Trailer parseFrom(ByteBuffer byteBuffer) {
            return (Trailer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static KW4 parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setReason(String str) {
            str.getClass();
            this.reason_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setReasonBytes(AbstractC2383g abstractC2383g) {
            AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
            this.reason_ = abstractC2383g.f0();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStreamId(String str) {
            str.getClass();
            this.streamId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStreamIdBytes(AbstractC2383g abstractC2383g) {
            AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
            this.streamId_ = abstractC2383g.f0();
        }

        public boolean containsAttributes(String str) {
            str.getClass();
            return internalGetAttributes().containsKey(str);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
            o oVar = null;
            switch (o.a[gVar.ordinal()]) {
                case 1:
                    return new Trailer();
                case 2:
                    return new b(oVar);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u00032", new Object[]{"streamId_", "reason_", "attributes_", a.a});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    KW4 cVar = PARSER;
                    if (cVar == null) {
                        synchronized (Trailer.class) {
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

        @Deprecated
        public Map<String, String> getAttributes() {
            return getAttributesMap();
        }

        public int getAttributesCount() {
            return internalGetAttributes().size();
        }

        public Map<String, String> getAttributesMap() {
            return Collections.unmodifiableMap(internalGetAttributes());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public String getAttributesOrDefault(String str, String str2) {
            str.getClass();
            J jInternalGetAttributes = internalGetAttributes();
            return jInternalGetAttributes.containsKey(str) ? (String) jInternalGetAttributes.get(str) : str2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public String getAttributesOrThrow(String str) {
            str.getClass();
            J jInternalGetAttributes = internalGetAttributes();
            if (jInternalGetAttributes.containsKey(str)) {
                return (String) jInternalGetAttributes.get(str);
            }
            throw new IllegalArgumentException();
        }

        public String getReason() {
            return this.reason_;
        }

        public AbstractC2383g getReasonBytes() {
            return AbstractC2383g.N(this.reason_);
        }

        public String getStreamId() {
            return this.streamId_;
        }

        public AbstractC2383g getStreamIdBytes() {
            return AbstractC2383g.N(this.streamId_);
        }

        public static b newBuilder(Trailer trailer) {
            return (b) DEFAULT_INSTANCE.createBuilder(trailer);
        }

        public static Trailer parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
            return (Trailer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
        }

        public static Trailer parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
            return (Trailer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
        }

        public static Trailer parseFrom(AbstractC2383g abstractC2383g) {
            return (Trailer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
        }

        public static Trailer parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
            return (Trailer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
        }

        public static Trailer parseFrom(byte[] bArr) {
            return (Trailer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Trailer parseFrom(byte[] bArr, C2394s c2394s) {
            return (Trailer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
        }

        public static Trailer parseFrom(InputStream inputStream) {
            return (Trailer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Trailer parseFrom(InputStream inputStream, C2394s c2394s) {
            return (Trailer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
        }

        public static Trailer parseFrom(AbstractC2384h abstractC2384h) {
            return (Trailer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
        }

        public static Trailer parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
            return (Trailer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
        }
    }

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(o oVar) {
            this();
        }

        private a() {
            super(LivekitModels$DataStream.DEFAULT_INSTANCE);
        }
    }

    public enum b implements B.c {
        CREATE(0),
        UPDATE(1),
        DELETE(2),
        REACTION(3),
        UNRECOGNIZED(-1);

        private static final B.d g = new a();
        private final int a;

        class a implements B.d {
            a() {
            }

            @Override // com.google.protobuf.B.d
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public b a(int i) {
                return b.j(i);
            }
        }

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return CREATE;
            }
            if (i == 1) {
                return UPDATE;
            }
            if (i == 2) {
                return DELETE;
            }
            if (i != 3) {
                return null;
            }
            return REACTION;
        }

        @Override // com.google.protobuf.B.c
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.a;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    static {
        LivekitModels$DataStream livekitModels$DataStream = new LivekitModels$DataStream();
        DEFAULT_INSTANCE = livekitModels$DataStream;
        GeneratedMessageLite.registerDefaultInstance(LivekitModels$DataStream.class, livekitModels$DataStream);
    }

    private LivekitModels$DataStream() {
    }

    public static LivekitModels$DataStream getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitModels$DataStream parseDelimitedFrom(InputStream inputStream) {
        return (LivekitModels$DataStream) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$DataStream parseFrom(ByteBuffer byteBuffer) {
        return (LivekitModels$DataStream) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        o oVar = null;
        switch (o.a[gVar.ordinal()]) {
            case 1:
                return new LivekitModels$DataStream();
            case 2:
                return new a(oVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitModels$DataStream.class) {
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

    public static a newBuilder(LivekitModels$DataStream livekitModels$DataStream) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitModels$DataStream);
    }

    public static LivekitModels$DataStream parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$DataStream) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$DataStream parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitModels$DataStream) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitModels$DataStream parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitModels$DataStream) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitModels$DataStream parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitModels$DataStream) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitModels$DataStream parseFrom(byte[] bArr) {
        return (LivekitModels$DataStream) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitModels$DataStream parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitModels$DataStream) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitModels$DataStream parseFrom(InputStream inputStream) {
        return (LivekitModels$DataStream) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$DataStream parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$DataStream) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$DataStream parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitModels$DataStream) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitModels$DataStream parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitModels$DataStream) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
