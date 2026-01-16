package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC7415Rp6;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class SequenceStruct$ContainerUpdates extends GeneratedMessageLite implements InterfaceC7415Rp6 {
    private static final SequenceStruct$ContainerUpdates DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int UPDATE_FIELD_NUMBER = 2;
    public static final int UPDATE_HEADER_FIELD_NUMBER = 1;
    private int updateHeader_;
    private AbstractC2383g update_ = AbstractC2383g.b;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC7415Rp6 {
        private a() {
            super(SequenceStruct$ContainerUpdates.DEFAULT_INSTANCE);
        }
    }

    static {
        SequenceStruct$ContainerUpdates sequenceStruct$ContainerUpdates = new SequenceStruct$ContainerUpdates();
        DEFAULT_INSTANCE = sequenceStruct$ContainerUpdates;
        GeneratedMessageLite.registerDefaultInstance(SequenceStruct$ContainerUpdates.class, sequenceStruct$ContainerUpdates);
    }

    private SequenceStruct$ContainerUpdates() {
    }

    private void clearUpdate() {
        this.update_ = getDefaultInstance().getUpdate();
    }

    private void clearUpdateHeader() {
        this.updateHeader_ = 0;
    }

    public static SequenceStruct$ContainerUpdates getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SequenceStruct$ContainerUpdates parseDelimitedFrom(InputStream inputStream) {
        return (SequenceStruct$ContainerUpdates) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SequenceStruct$ContainerUpdates parseFrom(ByteBuffer byteBuffer) {
        return (SequenceStruct$ContainerUpdates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setUpdate(AbstractC2383g abstractC2383g) {
        abstractC2383g.getClass();
        this.update_ = abstractC2383g;
    }

    private void setUpdateHeader(int i) {
        this.updateHeader_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (T1.a[gVar.ordinal()]) {
            case 1:
                return new SequenceStruct$ContainerUpdates();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002\n", new Object[]{"updateHeader_", "update_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SequenceStruct$ContainerUpdates.class) {
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

    public AbstractC2383g getUpdate() {
        return this.update_;
    }

    public int getUpdateHeader() {
        return this.updateHeader_;
    }

    public static a newBuilder(SequenceStruct$ContainerUpdates sequenceStruct$ContainerUpdates) {
        return (a) DEFAULT_INSTANCE.createBuilder(sequenceStruct$ContainerUpdates);
    }

    public static SequenceStruct$ContainerUpdates parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SequenceStruct$ContainerUpdates) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SequenceStruct$ContainerUpdates parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SequenceStruct$ContainerUpdates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SequenceStruct$ContainerUpdates parseFrom(AbstractC2383g abstractC2383g) {
        return (SequenceStruct$ContainerUpdates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SequenceStruct$ContainerUpdates parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SequenceStruct$ContainerUpdates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SequenceStruct$ContainerUpdates parseFrom(byte[] bArr) {
        return (SequenceStruct$ContainerUpdates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SequenceStruct$ContainerUpdates parseFrom(byte[] bArr, C2394s c2394s) {
        return (SequenceStruct$ContainerUpdates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SequenceStruct$ContainerUpdates parseFrom(InputStream inputStream) {
        return (SequenceStruct$ContainerUpdates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SequenceStruct$ContainerUpdates parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SequenceStruct$ContainerUpdates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SequenceStruct$ContainerUpdates parseFrom(AbstractC2384h abstractC2384h) {
        return (SequenceStruct$ContainerUpdates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SequenceStruct$ContainerUpdates parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SequenceStruct$ContainerUpdates) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
