package ir.nasim;

/* loaded from: classes3.dex */
final class Vu8 extends vv8 {
    final /* synthetic */ C12628ev8 h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Vu8(C12628ev8 c12628ev8, Cv8 cv8, CharSequence charSequence) {
        super(cv8, charSequence);
        this.h = c12628ev8;
    }

    @Override // ir.nasim.vv8
    final int c(int i) {
        return i + 1;
    }

    @Override // ir.nasim.vv8
    final int d(int i) {
        CharSequence charSequence = this.c;
        int length = charSequence.length();
        Hu8.a(i, length, "index");
        while (i < length) {
            C12628ev8 c12628ev8 = this.h;
            if (c12628ev8.a.a(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
