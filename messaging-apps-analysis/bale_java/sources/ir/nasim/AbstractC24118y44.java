package ir.nasim;

import android.view.Menu;
import android.view.MenuItem;
import java.util.Iterator;

/* renamed from: ir.nasim.y44, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC24118y44 {

    /* renamed from: ir.nasim.y44$a */
    public static final class a implements Iterator, InterfaceC17915nm3 {
        private int a;
        final /* synthetic */ Menu b;

        a(Menu menu) {
            this.b = menu;
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public MenuItem next() {
            Menu menu = this.b;
            int i = this.a;
            this.a = i + 1;
            MenuItem item = menu.getItem(i);
            if (item != null) {
                return item;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a < this.b.size();
        }

        @Override // java.util.Iterator
        public void remove() {
            C19938rB7 c19938rB7;
            Menu menu = this.b;
            int i = this.a - 1;
            this.a = i;
            MenuItem item = menu.getItem(i);
            if (item != null) {
                menu.removeItem(item.getItemId());
                c19938rB7 = C19938rB7.a;
            } else {
                c19938rB7 = null;
            }
            if (c19938rB7 == null) {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    public static final Iterator a(Menu menu) {
        return new a(menu);
    }
}
