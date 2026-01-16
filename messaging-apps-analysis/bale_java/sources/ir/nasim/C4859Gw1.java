package ir.nasim;

import android.database.Cursor;
import android.widget.Filter;

/* renamed from: ir.nasim.Gw1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C4859Gw1 extends Filter {
    a a;

    /* renamed from: ir.nasim.Gw1$a */
    interface a {
        void a(Cursor cursor);

        CharSequence b(Cursor cursor);

        Cursor c(CharSequence charSequence);

        Cursor d();
    }

    C4859Gw1(a aVar) {
        this.a = aVar;
    }

    @Override // android.widget.Filter
    public CharSequence convertResultToString(Object obj) {
        return this.a.b((Cursor) obj);
    }

    @Override // android.widget.Filter
    protected Filter.FilterResults performFiltering(CharSequence charSequence) {
        Cursor cursorC = this.a.c(charSequence);
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (cursorC != null) {
            filterResults.count = cursorC.getCount();
            filterResults.values = cursorC;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    @Override // android.widget.Filter
    protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        Cursor cursorD = this.a.d();
        Object obj = filterResults.values;
        if (obj == null || obj == cursorD) {
            return;
        }
        this.a.a((Cursor) obj);
    }
}
