package bale.struct.v1;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.G55;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class PersonaStruct$UserPersona extends GeneratedMessageLite implements U64 {
    private static final PersonaStruct$UserPersona DEFAULT_INSTANCE;
    public static final int GENDER_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int gender_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PersonaStruct$UserPersona.DEFAULT_INSTANCE);
        }
    }

    static {
        PersonaStruct$UserPersona personaStruct$UserPersona = new PersonaStruct$UserPersona();
        DEFAULT_INSTANCE = personaStruct$UserPersona;
        GeneratedMessageLite.registerDefaultInstance(PersonaStruct$UserPersona.class, personaStruct$UserPersona);
    }

    private PersonaStruct$UserPersona() {
    }

    private void clearGender() {
        this.gender_ = 0;
    }

    public static PersonaStruct$UserPersona getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PersonaStruct$UserPersona parseDelimitedFrom(InputStream inputStream) {
        return (PersonaStruct$UserPersona) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PersonaStruct$UserPersona parseFrom(ByteBuffer byteBuffer) {
        return (PersonaStruct$UserPersona) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setGender(G55 g55) {
        this.gender_ = g55.getNumber();
    }

    private void setGenderValue(int i) {
        this.gender_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (b.a[gVar.ordinal()]) {
            case 1:
                return new PersonaStruct$UserPersona();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"gender_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PersonaStruct$UserPersona.class) {
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

    public G55 getGender() {
        G55 g55J = G55.j(this.gender_);
        return g55J == null ? G55.UNRECOGNIZED : g55J;
    }

    public int getGenderValue() {
        return this.gender_;
    }

    public static a newBuilder(PersonaStruct$UserPersona personaStruct$UserPersona) {
        return (a) DEFAULT_INSTANCE.createBuilder(personaStruct$UserPersona);
    }

    public static PersonaStruct$UserPersona parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PersonaStruct$UserPersona) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PersonaStruct$UserPersona parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PersonaStruct$UserPersona) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PersonaStruct$UserPersona parseFrom(AbstractC2383g abstractC2383g) {
        return (PersonaStruct$UserPersona) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PersonaStruct$UserPersona parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PersonaStruct$UserPersona) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PersonaStruct$UserPersona parseFrom(byte[] bArr) {
        return (PersonaStruct$UserPersona) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PersonaStruct$UserPersona parseFrom(byte[] bArr, C2394s c2394s) {
        return (PersonaStruct$UserPersona) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PersonaStruct$UserPersona parseFrom(InputStream inputStream) {
        return (PersonaStruct$UserPersona) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PersonaStruct$UserPersona parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PersonaStruct$UserPersona) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PersonaStruct$UserPersona parseFrom(AbstractC2384h abstractC2384h) {
        return (PersonaStruct$UserPersona) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PersonaStruct$UserPersona parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PersonaStruct$UserPersona) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
