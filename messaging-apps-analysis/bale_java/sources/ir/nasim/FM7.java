package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes.dex */
public enum FM7 implements B.c {
    Puppet_UNKNOWN(0),
    Puppet_BALE(1),
    Puppet_IGAP(2),
    Puppet_GAP(3),
    Puppet_EITTA(4),
    Puppet_RUBIKA(5),
    Puppet_SPLUS(6),
    Puppet_M7(7),
    Puppet_M8(8),
    UNRECOGNIZED(-1);

    private static final B.d l = new B.d() { // from class: ir.nasim.FM7.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public FM7 a(int i) {
            return FM7.j(i);
        }
    };
    private final int a;

    FM7(int i) {
        this.a = i;
    }

    public static FM7 j(int i) {
        switch (i) {
            case 0:
                return Puppet_UNKNOWN;
            case 1:
                return Puppet_BALE;
            case 2:
                return Puppet_IGAP;
            case 3:
                return Puppet_GAP;
            case 4:
                return Puppet_EITTA;
            case 5:
                return Puppet_RUBIKA;
            case 6:
                return Puppet_SPLUS;
            case 7:
                return Puppet_M7;
            case 8:
                return Puppet_M8;
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
