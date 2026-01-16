package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingStruct$DocumentExGif extends GeneratedMessageLite implements U64 {
    private static final MessagingStruct$DocumentExGif DEFAULT_INSTANCE;
    public static final int DURATION_FIELD_NUMBER = 3;
    public static final int H_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int W_FIELD_NUMBER = 1;
    private int duration_;
    private int h_;
    private int w_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$DocumentExGif.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$DocumentExGif messagingStruct$DocumentExGif = new MessagingStruct$DocumentExGif();
        DEFAULT_INSTANCE = messagingStruct$DocumentExGif;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$DocumentExGif.class, messagingStruct$DocumentExGif);
    }

    private MessagingStruct$DocumentExGif() {
    }

    private void clearDuration() {
        this.duration_ = 0;
    }

    private void clearH() {
        this.h_ = 0;
    }

    private void clearW() {
        this.w_ = 0;
    }

    public static MessagingStruct$DocumentExGif getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$DocumentExGif parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$DocumentExGif) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$DocumentExGif parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$DocumentExGif) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDuration(int i) {
        this.duration_ = i;
    }

    private void setH(int i) {
        this.h_ = i;
    }

    private void setW(int i) {
        this.w_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$DocumentExGif();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0002\u0004\u0003\u0004", new Object[]{"w_", "h_", "duration_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$DocumentExGif.class) {
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

    public int getDuration() {
        return this.duration_;
    }

    public int getH() {
        return this.h_;
    }

    public int getW() {
        return this.w_;
    }

    public static a newBuilder(MessagingStruct$DocumentExGif messagingStruct$DocumentExGif) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$DocumentExGif);
    }

    public static MessagingStruct$DocumentExGif parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$DocumentExGif) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$DocumentExGif parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$DocumentExGif) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$DocumentExGif parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$DocumentExGif) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$DocumentExGif parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$DocumentExGif) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$DocumentExGif parseFrom(byte[] bArr) {
        return (MessagingStruct$DocumentExGif) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$DocumentExGif parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$DocumentExGif) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$DocumentExGif parseFrom(InputStream inputStream) {
        return (MessagingStruct$DocumentExGif) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$DocumentExGif parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$DocumentExGif) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$DocumentExGif parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$DocumentExGif) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$DocumentExGif parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$DocumentExGif) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
