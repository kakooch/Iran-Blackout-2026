package ir.nasim;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;

/* renamed from: ir.nasim.yW7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC24379yW7 {

    /* renamed from: ir.nasim.yW7$a */
    public static final class a implements InterfaceC23384wp6 {
        final /* synthetic */ ViewGroup a;

        a(ViewGroup viewGroup) {
            this.a = viewGroup;
        }

        @Override // ir.nasim.InterfaceC23384wp6
        public Iterator iterator() {
            return AbstractC24379yW7.d(this.a);
        }
    }

    /* renamed from: ir.nasim.yW7$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        public static final b e = new b();

        b() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Iterator invoke(View view) {
            InterfaceC23384wp6 interfaceC23384wp6B;
            ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
            if (viewGroup == null || (interfaceC23384wp6B = AbstractC24379yW7.b(viewGroup)) == null) {
                return null;
            }
            return interfaceC23384wp6B.iterator();
        }
    }

    /* renamed from: ir.nasim.yW7$c */
    public static final class c implements Iterator, InterfaceC17915nm3 {
        private int a;
        final /* synthetic */ ViewGroup b;

        c(ViewGroup viewGroup) {
            this.b = viewGroup;
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public View next() {
            ViewGroup viewGroup = this.b;
            int i = this.a;
            this.a = i + 1;
            View childAt = viewGroup.getChildAt(i);
            if (childAt != null) {
                return childAt;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a < this.b.getChildCount();
        }

        @Override // java.util.Iterator
        public void remove() {
            ViewGroup viewGroup = this.b;
            int i = this.a - 1;
            this.a = i;
            viewGroup.removeViewAt(i);
        }
    }

    /* renamed from: ir.nasim.yW7$d */
    public static final class d implements InterfaceC23384wp6 {
        final /* synthetic */ ViewGroup a;

        public d(ViewGroup viewGroup) {
            this.a = viewGroup;
        }

        @Override // ir.nasim.InterfaceC23384wp6
        public Iterator iterator() {
            return new C9186Yv7(AbstractC24379yW7.b(this.a).iterator(), b.e);
        }
    }

    public static final View a(ViewGroup viewGroup, int i) {
        View childAt = viewGroup.getChildAt(i);
        if (childAt != null) {
            return childAt;
        }
        throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + viewGroup.getChildCount());
    }

    public static final InterfaceC23384wp6 b(ViewGroup viewGroup) {
        return new a(viewGroup);
    }

    public static final InterfaceC23384wp6 c(ViewGroup viewGroup) {
        return new d(viewGroup);
    }

    public static final Iterator d(ViewGroup viewGroup) {
        return new c(viewGroup);
    }
}
