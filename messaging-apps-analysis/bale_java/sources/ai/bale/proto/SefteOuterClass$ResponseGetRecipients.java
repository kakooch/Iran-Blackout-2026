package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC20290rl6;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class SefteOuterClass$ResponseGetRecipients extends GeneratedMessageLite implements U64 {
    private static final SefteOuterClass$ResponseGetRecipients DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int RECIPIENTS_FIELD_NUMBER = 1;
    private B.j recipients_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SefteOuterClass$ResponseGetRecipients.DEFAULT_INSTANCE);
        }
    }

    static {
        SefteOuterClass$ResponseGetRecipients sefteOuterClass$ResponseGetRecipients = new SefteOuterClass$ResponseGetRecipients();
        DEFAULT_INSTANCE = sefteOuterClass$ResponseGetRecipients;
        GeneratedMessageLite.registerDefaultInstance(SefteOuterClass$ResponseGetRecipients.class, sefteOuterClass$ResponseGetRecipients);
    }

    private SefteOuterClass$ResponseGetRecipients() {
    }

    private void addAllRecipients(Iterable<? extends SefteStruct$Recipient> iterable) {
        ensureRecipientsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.recipients_);
    }

    private void addRecipients(SefteStruct$Recipient sefteStruct$Recipient) {
        sefteStruct$Recipient.getClass();
        ensureRecipientsIsMutable();
        this.recipients_.add(sefteStruct$Recipient);
    }

    private void clearRecipients() {
        this.recipients_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureRecipientsIsMutable() {
        B.j jVar = this.recipients_;
        if (jVar.u()) {
            return;
        }
        this.recipients_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static SefteOuterClass$ResponseGetRecipients getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SefteOuterClass$ResponseGetRecipients parseDelimitedFrom(InputStream inputStream) {
        return (SefteOuterClass$ResponseGetRecipients) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SefteOuterClass$ResponseGetRecipients parseFrom(ByteBuffer byteBuffer) {
        return (SefteOuterClass$ResponseGetRecipients) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeRecipients(int i) {
        ensureRecipientsIsMutable();
        this.recipients_.remove(i);
    }

    private void setRecipients(int i, SefteStruct$Recipient sefteStruct$Recipient) {
        sefteStruct$Recipient.getClass();
        ensureRecipientsIsMutable();
        this.recipients_.set(i, sefteStruct$Recipient);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (P1.a[gVar.ordinal()]) {
            case 1:
                return new SefteOuterClass$ResponseGetRecipients();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"recipients_", SefteStruct$Recipient.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SefteOuterClass$ResponseGetRecipients.class) {
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

    public SefteStruct$Recipient getRecipients(int i) {
        return (SefteStruct$Recipient) this.recipients_.get(i);
    }

    public int getRecipientsCount() {
        return this.recipients_.size();
    }

    public List<SefteStruct$Recipient> getRecipientsList() {
        return this.recipients_;
    }

    public InterfaceC20290rl6 getRecipientsOrBuilder(int i) {
        return (InterfaceC20290rl6) this.recipients_.get(i);
    }

    public List<? extends InterfaceC20290rl6> getRecipientsOrBuilderList() {
        return this.recipients_;
    }

    public static a newBuilder(SefteOuterClass$ResponseGetRecipients sefteOuterClass$ResponseGetRecipients) {
        return (a) DEFAULT_INSTANCE.createBuilder(sefteOuterClass$ResponseGetRecipients);
    }

    public static SefteOuterClass$ResponseGetRecipients parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SefteOuterClass$ResponseGetRecipients) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SefteOuterClass$ResponseGetRecipients parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SefteOuterClass$ResponseGetRecipients) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SefteOuterClass$ResponseGetRecipients parseFrom(AbstractC2383g abstractC2383g) {
        return (SefteOuterClass$ResponseGetRecipients) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addRecipients(int i, SefteStruct$Recipient sefteStruct$Recipient) {
        sefteStruct$Recipient.getClass();
        ensureRecipientsIsMutable();
        this.recipients_.add(i, sefteStruct$Recipient);
    }

    public static SefteOuterClass$ResponseGetRecipients parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SefteOuterClass$ResponseGetRecipients) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SefteOuterClass$ResponseGetRecipients parseFrom(byte[] bArr) {
        return (SefteOuterClass$ResponseGetRecipients) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SefteOuterClass$ResponseGetRecipients parseFrom(byte[] bArr, C2394s c2394s) {
        return (SefteOuterClass$ResponseGetRecipients) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SefteOuterClass$ResponseGetRecipients parseFrom(InputStream inputStream) {
        return (SefteOuterClass$ResponseGetRecipients) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SefteOuterClass$ResponseGetRecipients parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SefteOuterClass$ResponseGetRecipients) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SefteOuterClass$ResponseGetRecipients parseFrom(AbstractC2384h abstractC2384h) {
        return (SefteOuterClass$ResponseGetRecipients) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SefteOuterClass$ResponseGetRecipients parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SefteOuterClass$ResponseGetRecipients) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
