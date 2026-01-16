package ir.nasim;

import androidx.recyclerview.widget.i;
import ir.nasim.AbstractC5909Li7;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Pi7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C6875Pi7 extends i.f {
    @Override // androidx.recyclerview.widget.i.f
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(AbstractC5909Li7 abstractC5909Li7, AbstractC5909Li7 abstractC5909Li72) {
        AbstractC13042fc3.i(abstractC5909Li7, "oldItem");
        AbstractC13042fc3.i(abstractC5909Li72, "newItem");
        if (abstractC5909Li7 instanceof AbstractC5909Li7.a) {
            if (!(abstractC5909Li72 instanceof AbstractC5909Li7.a)) {
                return false;
            }
            AbstractC5909Li7.a aVar = (AbstractC5909Li7.a) abstractC5909Li7;
            AbstractC5909Li7.a aVar2 = (AbstractC5909Li7.a) abstractC5909Li72;
            if (!AbstractC13042fc3.d(aVar.e(), aVar2.e()) || !AbstractC13042fc3.d(aVar.c(), aVar2.c()) || !AbstractC13042fc3.d(aVar.b(), aVar2.b())) {
                return false;
            }
        } else {
            if (!(abstractC5909Li7 instanceof AbstractC5909Li7.b)) {
                throw new NoWhenBranchMatchedException();
            }
            if (!(abstractC5909Li72 instanceof AbstractC5909Li7.b) || !AbstractC13042fc3.d(((AbstractC5909Li7.b) abstractC5909Li7).a(), ((AbstractC5909Li7.b) abstractC5909Li72).a())) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.i.f
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean b(AbstractC5909Li7 abstractC5909Li7, AbstractC5909Li7 abstractC5909Li72) {
        AbstractC13042fc3.i(abstractC5909Li7, "oldItem");
        AbstractC13042fc3.i(abstractC5909Li72, "newItem");
        if (abstractC5909Li7 instanceof AbstractC5909Li7.a) {
            if (!(abstractC5909Li72 instanceof AbstractC5909Li7.a) || ((AbstractC5909Li7.a) abstractC5909Li7).d() != ((AbstractC5909Li7.a) abstractC5909Li72).d()) {
                return false;
            }
        } else {
            if (!(abstractC5909Li7 instanceof AbstractC5909Li7.b)) {
                throw new NoWhenBranchMatchedException();
            }
            if (!(abstractC5909Li72 instanceof AbstractC5909Li7.b) || !AbstractC13042fc3.d(((AbstractC5909Li7.b) abstractC5909Li7).a(), ((AbstractC5909Li7.b) abstractC5909Li72).a())) {
                return false;
            }
        }
        return true;
    }
}
