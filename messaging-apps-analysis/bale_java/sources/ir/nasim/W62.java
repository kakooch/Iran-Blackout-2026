package ir.nasim;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;
import ir.nasim.X62;
import ir.nasim.Y62;
import ir.nasim.features.smiles.widget.ImageViewEmoji;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes6.dex */
public final class W62 extends androidx.recyclerview.widget.q {
    private final UA2 f;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[V62.values().length];
            try {
                iArr[V62.c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[V62.e.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[V62.d.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public W62(UA2 ua2) {
        super(new V52());
        AbstractC13042fc3.i(ua2, "onEmojiSelect");
        this.f = ua2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(Y62 y62, int i) {
        AbstractC13042fc3.i(y62, "holder");
        Object objA = A(i);
        AbstractC13042fc3.h(objA, "getItem(...)");
        y62.C0((X62) objA);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public Y62 onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        Context context = viewGroup.getContext();
        int i2 = a.a[V62.b.a(i).ordinal()];
        if (i2 == 1) {
            return new Y62.b(new TextView(context));
        }
        if (i2 != 2 && i2 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        AbstractC13042fc3.f(context);
        ImageViewEmoji imageViewEmoji = new ImageViewEmoji(context, null, 0, 6, null);
        RF6 rf6 = RF6.a;
        imageViewEmoji.setPaddingRatio(rf6.c() / rf6.e());
        return new Y62.a(imageViewEmoji, this.f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemViewType(int i) {
        V62 v62;
        X62 x62 = (X62) A(i);
        if (x62 instanceof X62.a) {
            v62 = ((X62.a) x62).d() ? V62.e : V62.d;
        } else {
            if (!(x62 instanceof X62.b)) {
                throw new NoWhenBranchMatchedException();
            }
            v62 = V62.c;
        }
        return v62.getNumber();
    }
}
