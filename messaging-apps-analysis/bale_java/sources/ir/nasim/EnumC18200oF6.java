package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.oF6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public enum EnumC18200oF6 implements B.c {
    FileType_UNSPECIFIED(0),
    Question(1),
    PDF(2),
    CSV(3),
    Text(4),
    Docx(5),
    AddFromButton(6),
    Image(7),
    EXCEL(8),
    GROUP(9),
    JSON(10),
    UNRECOGNIZED(-1);

    private static final B.d n = new B.d() { // from class: ir.nasim.oF6.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC18200oF6 a(int i) {
            return EnumC18200oF6.j(i);
        }
    };
    private final int a;

    EnumC18200oF6(int i) {
        this.a = i;
    }

    public static EnumC18200oF6 j(int i) {
        switch (i) {
            case 0:
                return FileType_UNSPECIFIED;
            case 1:
                return Question;
            case 2:
                return PDF;
            case 3:
                return CSV;
            case 4:
                return Text;
            case 5:
                return Docx;
            case 6:
                return AddFromButton;
            case 7:
                return Image;
            case 8:
                return EXCEL;
            case 9:
                return GROUP;
            case 10:
                return JSON;
            default:
                return null;
        }
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
