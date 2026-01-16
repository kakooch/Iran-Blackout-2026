package ir.nasim;

import android.view.View;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillManager;
import kotlin.KotlinNothingValueException;

/* renamed from: ir.nasim.gn, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C13766gn implements TT {
    private final View a;
    private final C22577vU b;
    private final AutofillManager c;
    private AutofillId d;

    public C13766gn(View view, C22577vU c22577vU) {
        this.a = view;
        this.b = c22577vU;
        AutofillManager autofillManagerA = AbstractC12539en.a(view.getContext().getSystemService(AbstractC11927dn.a()));
        if (autofillManagerA == null) {
            throw new IllegalStateException("Autofill service could not be located.".toString());
        }
        this.c = autofillManagerA;
        view.setImportantForAutofill(1);
        C21330tU c21330tUA = AbstractC14199hW7.a(view);
        AutofillId autofillIdA = c21330tUA != null ? c21330tUA.a() : null;
        if (autofillIdA != null) {
            this.d = autofillIdA;
        } else {
            M73.c("Required value was null.");
            throw new KotlinNothingValueException();
        }
    }

    public final AutofillManager a() {
        return this.c;
    }

    public final C22577vU b() {
        return this.b;
    }

    public final AutofillId c() {
        return this.d;
    }

    public final View d() {
        return this.a;
    }
}
