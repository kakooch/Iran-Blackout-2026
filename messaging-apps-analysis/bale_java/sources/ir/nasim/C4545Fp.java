package ir.nasim;

import android.os.LocaleList;
import android.util.Log;
import java.util.ArrayList;
import java.util.Locale;

/* renamed from: ir.nasim.Fp, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C4545Fp implements InterfaceC13692gf5 {
    private LocaleList a;
    private IH3 b;
    private final C47 c = new C47();

    @Override // ir.nasim.InterfaceC13692gf5
    public Locale a(String str) {
        Locale localeForLanguageTag = Locale.forLanguageTag(str);
        if (AbstractC13042fc3.d(localeForLanguageTag.toLanguageTag(), "und")) {
            Log.e(AbstractC4794Gp.a, "The language tag " + str + " is not well-formed. Locale is resolved to Undetermined. Note that underscore '_' is not a valid subtag delimiter and must be replaced with '-'.");
        }
        return localeForLanguageTag;
    }

    @Override // ir.nasim.InterfaceC13692gf5
    public IH3 b() {
        LocaleList localeList = LocaleList.getDefault();
        synchronized (this.c) {
            IH3 ih3 = this.b;
            if (ih3 != null && localeList == this.a) {
                return ih3;
            }
            int size = localeList.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                arrayList.add(new CH3(localeList.get(i)));
            }
            IH3 ih32 = new IH3(arrayList);
            this.a = localeList;
            this.b = ih32;
            return ih32;
        }
    }
}
