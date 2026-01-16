package ir.nasim;

import ai.bale.proto.PassportStruct$PassportDate;
import ai.bale.proto.PassportStruct$PassportField;
import ai.bale.proto.PassportStruct$PassportFieldDate;
import ai.bale.proto.PassportStruct$PassportFieldNumber;
import ai.bale.proto.PassportStruct$PassportFieldText;
import ai.bale.proto.PassportStruct$PassportRegexValidation;
import com.google.protobuf.Int32Value;
import com.google.protobuf.StringValue;
import ir.nasim.AbstractC11684dQ7;
import ir.nasim.C9475a16;
import ir.nasim.DX4;
import ir.nasim.EX4;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.uA, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C21807uA implements InterfaceC14123hO3 {

    /* renamed from: ir.nasim.uA$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[EnumC13308g05.values().length];
            try {
                iArr[EnumC13308g05.TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC13308g05.MULTILINE_TEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC13308g05.NUMERIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC13308g05.UNSPECIFIED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[EnumC13308g05.UNRECOGNIZED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            a = iArr;
            int[] iArr2 = new int[EnumC13899h05.values().length];
            try {
                iArr2[EnumC13899h05.NATIONAL_CODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[EnumC13899h05.UNRECOGNIZED.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[EnumC13899h05.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            b = iArr2;
        }
    }

    private final EX4.a c(PassportStruct$PassportFieldDate passportStruct$PassportFieldDate) {
        PassportStruct$PassportDate maxDate;
        PassportStruct$PassportDate minDate;
        PassportStruct$PassportDate value;
        Long lValueOf = null;
        PassportStruct$PassportFieldDate passportStruct$PassportFieldDate2 = passportStruct$PassportFieldDate.hasValue() ? passportStruct$PassportFieldDate : null;
        Long lValueOf2 = (passportStruct$PassportFieldDate2 == null || (value = passportStruct$PassportFieldDate2.getValue()) == null) ? null : Long.valueOf(value.getUnixMilli());
        PassportStruct$PassportFieldDate passportStruct$PassportFieldDate3 = passportStruct$PassportFieldDate.hasMinDate() ? passportStruct$PassportFieldDate : null;
        Long lValueOf3 = (passportStruct$PassportFieldDate3 == null || (minDate = passportStruct$PassportFieldDate3.getMinDate()) == null) ? null : Long.valueOf(minDate.getUnixMilli());
        if (!passportStruct$PassportFieldDate.hasMaxDate()) {
            passportStruct$PassportFieldDate = null;
        }
        if (passportStruct$PassportFieldDate != null && (maxDate = passportStruct$PassportFieldDate.getMaxDate()) != null) {
            lValueOf = Long.valueOf(maxDate.getUnixMilli());
        }
        return new EX4.a(lValueOf2, lValueOf3, lValueOf);
    }

    private final EX4.b d(PassportStruct$PassportFieldNumber passportStruct$PassportFieldNumber) {
        Int32Value maxValue;
        Int32Value minValue;
        Int32Value value;
        Integer numValueOf = null;
        PassportStruct$PassportFieldNumber passportStruct$PassportFieldNumber2 = passportStruct$PassportFieldNumber.hasValue() ? passportStruct$PassportFieldNumber : null;
        Integer numValueOf2 = (passportStruct$PassportFieldNumber2 == null || (value = passportStruct$PassportFieldNumber2.getValue()) == null) ? null : Integer.valueOf(value.getValue());
        PassportStruct$PassportFieldNumber passportStruct$PassportFieldNumber3 = passportStruct$PassportFieldNumber.hasMinValue() ? passportStruct$PassportFieldNumber : null;
        Integer numValueOf3 = (passportStruct$PassportFieldNumber3 == null || (minValue = passportStruct$PassportFieldNumber3.getMinValue()) == null) ? null : Integer.valueOf(minValue.getValue());
        if (!passportStruct$PassportFieldNumber.hasMaxValue()) {
            passportStruct$PassportFieldNumber = null;
        }
        if (passportStruct$PassportFieldNumber != null && (maxValue = passportStruct$PassportFieldNumber.getMaxValue()) != null) {
            numValueOf = Integer.valueOf(maxValue.getValue());
        }
        return new EX4.b(numValueOf2, numValueOf3, numValueOf);
    }

    private final DX4 e(PassportStruct$PassportField passportStruct$PassportField) {
        if (!passportStruct$PassportField.hasErrorMessage()) {
            return DX4.a.a;
        }
        String value = passportStruct$PassportField.getErrorMessage().getValue();
        AbstractC13042fc3.h(value, "getValue(...)");
        return new DX4.b(new AbstractC11684dQ7.a(value));
    }

    private final EX4 f(PassportStruct$PassportField passportStruct$PassportField) {
        if (passportStruct$PassportField.hasText()) {
            PassportStruct$PassportFieldText text = passportStruct$PassportField.getText();
            AbstractC13042fc3.h(text, "getText(...)");
            return g(text);
        }
        if (passportStruct$PassportField.hasNumber()) {
            PassportStruct$PassportFieldNumber number = passportStruct$PassportField.getNumber();
            AbstractC13042fc3.h(number, "getNumber(...)");
            return d(number);
        }
        if (!passportStruct$PassportField.hasDate()) {
            return EX4.d.a;
        }
        PassportStruct$PassportFieldDate date = passportStruct$PassportField.getDate();
        AbstractC13042fc3.h(date, "getDate(...)");
        return c(date);
    }

    private final EX4.c g(PassportStruct$PassportFieldText passportStruct$PassportFieldText) {
        EnumC15099j05 enumC15099j05I;
        PassportStruct$PassportRegexValidation customRegex;
        String regex;
        Int32Value maxLength;
        Int32Value minLength;
        StringValue value;
        C20644sM5 c20644sM5J = null;
        PassportStruct$PassportFieldText passportStruct$PassportFieldText2 = passportStruct$PassportFieldText.hasValue() ? passportStruct$PassportFieldText : null;
        String value2 = (passportStruct$PassportFieldText2 == null || (value = passportStruct$PassportFieldText2.getValue()) == null) ? null : value.getValue();
        EnumC13308g05 inputMode = passportStruct$PassportFieldText.getInputMode();
        AbstractC13042fc3.h(inputMode, "getInputMode(...)");
        EnumC14492i05 enumC14492i05H = h(inputMode);
        PassportStruct$PassportFieldText passportStruct$PassportFieldText3 = passportStruct$PassportFieldText.hasMinLength() ? passportStruct$PassportFieldText : null;
        Integer numValueOf = (passportStruct$PassportFieldText3 == null || (minLength = passportStruct$PassportFieldText3.getMinLength()) == null) ? null : Integer.valueOf(minLength.getValue());
        PassportStruct$PassportFieldText passportStruct$PassportFieldText4 = passportStruct$PassportFieldText.hasMaxLength() ? passportStruct$PassportFieldText : null;
        Integer numValueOf2 = (passportStruct$PassportFieldText4 == null || (maxLength = passportStruct$PassportFieldText4.getMaxLength()) == null) ? null : Integer.valueOf(maxLength.getValue());
        PassportStruct$PassportFieldText passportStruct$PassportFieldText5 = passportStruct$PassportFieldText.hasBuiltInValidation() ? passportStruct$PassportFieldText : null;
        if (passportStruct$PassportFieldText5 != null) {
            EnumC13899h05 builtInValidation = passportStruct$PassportFieldText5.getBuiltInValidation();
            AbstractC13042fc3.h(builtInValidation, "getBuiltInValidation(...)");
            enumC15099j05I = i(builtInValidation);
        } else {
            enumC15099j05I = null;
        }
        if (!passportStruct$PassportFieldText.hasCustomRegex()) {
            passportStruct$PassportFieldText = null;
        }
        if (passportStruct$PassportFieldText != null && (customRegex = passportStruct$PassportFieldText.getCustomRegex()) != null && (regex = customRegex.getRegex()) != null) {
            c20644sM5J = j(regex);
        }
        return new EX4.c(value2, enumC14492i05H, numValueOf, numValueOf2, enumC15099j05I, c20644sM5J);
    }

    private final EnumC14492i05 h(EnumC13308g05 enumC13308g05) {
        int i = a.a[enumC13308g05.ordinal()];
        if (i == 1) {
            return EnumC14492i05.a;
        }
        if (i == 2) {
            return EnumC14492i05.c;
        }
        if (i == 3) {
            return EnumC14492i05.b;
        }
        if (i == 4 || i == 5) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final EnumC15099j05 i(EnumC13899h05 enumC13899h05) {
        int i = a.b[enumC13899h05.ordinal()];
        if (i == 1) {
            return EnumC15099j05.a;
        }
        if (i == 2 || i == 3) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final C20644sM5 j(String str) {
        Object objB;
        try {
            C9475a16.a aVar = C9475a16.b;
            objB = C9475a16.b(new C20644sM5(str));
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            objB = C9475a16.b(AbstractC10685c16.a(th));
        }
        if (C9475a16.g(objB)) {
            objB = null;
        }
        return (C20644sM5) objB;
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public BX4 a(PassportStruct$PassportField passportStruct$PassportField) {
        AbstractC13042fc3.i(passportStruct$PassportField, "input");
        int id = passportStruct$PassportField.getId();
        String title = passportStruct$PassportField.getTitle();
        AbstractC13042fc3.h(title, "getTitle(...)");
        String placeholder = passportStruct$PassportField.getPlaceholder();
        AbstractC13042fc3.h(placeholder, "getPlaceholder(...)");
        return new BX4(id, title, placeholder, e(passportStruct$PassportField), passportStruct$PassportField.getValidateWithBackend(), f(passportStruct$PassportField), !passportStruct$PassportField.getUneditable());
    }
}
