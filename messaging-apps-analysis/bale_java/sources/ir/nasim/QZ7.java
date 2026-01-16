package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class QZ7 extends VL {
    private String e;
    private T74 f;
    private final long g;
    private final int h;
    private final J44 i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZ7(String str, T74 t74, long j, int i, J44 j44) {
        super(str, t74, j44, j, null);
        AbstractC13042fc3.i(str, "filePath");
        AbstractC13042fc3.i(t74, "messageId");
        this.e = str;
        this.f = t74;
        this.g = j;
        this.h = i;
        this.i = j44;
    }

    public static /* synthetic */ QZ7 g(QZ7 qz7, String str, T74 t74, long j, int i, J44 j44, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = qz7.e;
        }
        if ((i2 & 2) != 0) {
            t74 = qz7.f;
        }
        T74 t742 = t74;
        if ((i2 & 4) != 0) {
            j = qz7.g;
        }
        long j2 = j;
        if ((i2 & 8) != 0) {
            i = qz7.h;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            j44 = qz7.i;
        }
        return qz7.f(str, t742, j2, i3, j44);
    }

    @Override // ir.nasim.VL
    public J44 a() {
        return this.i;
    }

    @Override // ir.nasim.VL
    public long b() {
        return this.g;
    }

    @Override // ir.nasim.VL
    public String c() {
        return this.e;
    }

    @Override // ir.nasim.VL
    public T74 d() {
        return this.f;
    }

    @Override // ir.nasim.VL
    public void e(String str) {
        AbstractC13042fc3.i(str, "<set-?>");
        this.e = str;
    }

    @Override // ir.nasim.VL
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final QZ7 f(String str, T74 t74, long j, int i, J44 j44) {
        AbstractC13042fc3.i(str, "filePath");
        AbstractC13042fc3.i(t74, "messageId");
        return new QZ7(str, t74, j, i, j44);
    }

    public final int h() {
        return this.h;
    }

    @Override // ir.nasim.VL
    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return "Voice(filePath=" + this.e + ", messageId=" + this.f + ", duration=" + this.g + ", senderId=" + this.h + ", currentMessage=" + this.i + Separators.RPAREN;
    }
}
