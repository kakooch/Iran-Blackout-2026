package com.github.faucamp.simplertmp.amf;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class AmfDecoder {
    public static AmfData readFrom(InputStream inputStream) throws IOException {
        AmfData amfNumber;
        AmfType amfTypeValueOf = AmfType.valueOf((byte) inputStream.read());
        if (amfTypeValueOf != null) {
            switch (AnonymousClass1.$SwitchMap$com$github$faucamp$simplertmp$amf$AmfType[amfTypeValueOf.ordinal()]) {
                case 1:
                    amfNumber = new AmfNumber();
                    break;
                case 2:
                    amfNumber = new AmfBoolean();
                    break;
                case 3:
                    amfNumber = new AmfString();
                    break;
                case 4:
                    amfNumber = new AmfObject();
                    break;
                case 5:
                    return new AmfNull();
                case 6:
                    return new AmfUndefined();
                case 7:
                    amfNumber = new AmfMap();
                    break;
                case 8:
                    amfNumber = new AmfArray();
                    break;
                default:
                    throw new IOException("Unknown/unimplemented AMF data type: " + amfTypeValueOf);
            }
            amfNumber.readFrom(inputStream);
            return amfNumber;
        }
        throw new IOException("Unknown AMF data type");
    }

    /* renamed from: com.github.faucamp.simplertmp.amf.AmfDecoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$github$faucamp$simplertmp$amf$AmfType;

        static {
            int[] iArr = new int[AmfType.values().length];
            $SwitchMap$com$github$faucamp$simplertmp$amf$AmfType = iArr;
            try {
                iArr[AmfType.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$github$faucamp$simplertmp$amf$AmfType[AmfType.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$github$faucamp$simplertmp$amf$AmfType[AmfType.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$github$faucamp$simplertmp$amf$AmfType[AmfType.OBJECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$github$faucamp$simplertmp$amf$AmfType[AmfType.NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$github$faucamp$simplertmp$amf$AmfType[AmfType.UNDEFINED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$github$faucamp$simplertmp$amf$AmfType[AmfType.ECMA_MAP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$github$faucamp$simplertmp$amf$AmfType[AmfType.STRICT_ARRAY.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }
}
