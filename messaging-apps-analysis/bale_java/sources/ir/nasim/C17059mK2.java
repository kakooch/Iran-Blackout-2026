package ir.nasim;

import java.text.BreakIterator;

/* renamed from: ir.nasim.mK2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C17059mK2 extends AbstractC15286jK2 {
    private final CharSequence a;
    private final BreakIterator b;

    public C17059mK2(CharSequence charSequence) {
        this.a = charSequence;
        BreakIterator characterInstance = BreakIterator.getCharacterInstance();
        characterInstance.setText(charSequence.toString());
        this.b = characterInstance;
    }

    @Override // ir.nasim.AbstractC15286jK2
    public int e(int i) {
        return this.b.following(i);
    }

    @Override // ir.nasim.AbstractC15286jK2
    public int f(int i) {
        return this.b.preceding(i);
    }
}
