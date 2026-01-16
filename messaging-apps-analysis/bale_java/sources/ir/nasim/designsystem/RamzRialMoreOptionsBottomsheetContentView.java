package ir.nasim.designsystem;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PictureDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC14828iY7;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC15087iz3;
import ir.nasim.AbstractC19224pz3;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC4151Dx1;
import ir.nasim.C14486i0;
import ir.nasim.C15253jG5;
import ir.nasim.C19406qI3;
import ir.nasim.C19938rB7;
import ir.nasim.C22078ud6;
import ir.nasim.C22186uo4;
import ir.nasim.C4100Dr4;
import ir.nasim.C5495Jo7;
import ir.nasim.C6011Lu2;
import ir.nasim.HG1;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC16866m0;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC21596to4;
import ir.nasim.InterfaceC22855vv7;
import ir.nasim.OI2;
import ir.nasim.core.modules.banking.entity.MyBankData;
import ir.nasim.designsystem.RamzRialMoreOptionsBottomsheetContentView;
import ir.nasim.designsystem.base.activity.BaseActivity;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 '2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001cB\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u001a\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010\u001bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006("}, d2 = {"Lir/nasim/designsystem/RamzRialMoreOptionsBottomsheetContentView;", "Landroid/widget/RelativeLayout;", "Lir/nasim/m0;", "Lir/nasim/to4;", "Lir/nasim/designsystem/base/activity/BaseActivity;", "parent", "Lir/nasim/uo4;", "item", "<init>", "(Lir/nasim/designsystem/base/activity/BaseActivity;Lir/nasim/uo4;)V", "Lir/nasim/rB7;", "h", "(Lir/nasim/uo4;)V", "setupBottomsheet", "", "url", "i", "(Ljava/lang/String;)V", "Landroid/view/View;", "getDivider", "()Landroid/view/View;", "Lir/nasim/core/modules/banking/entity/MyBankData$Item;", "e", "(Lir/nasim/core/modules/banking/entity/MyBankData$Item;)Landroid/view/View;", "Lir/nasim/i0;", "abol", "setAbolInstance", "(Lir/nasim/i0;)V", "a", "Lir/nasim/i0;", "getAbol", "()Lir/nasim/i0;", "setAbol", "b", "Lir/nasim/designsystem/base/activity/BaseActivity;", "Lir/nasim/jG5;", "c", "Lir/nasim/jG5;", "binding", "d", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class RamzRialMoreOptionsBottomsheetContentView extends RelativeLayout implements InterfaceC16866m0, InterfaceC21596to4 {
    public static final int e = 8;

    /* renamed from: a, reason: from kotlin metadata */
    private C14486i0 abol;

    /* renamed from: b, reason: from kotlin metadata */
    private BaseActivity parent;

    /* renamed from: c, reason: from kotlin metadata */
    private C15253jG5 binding;

    public static final class b extends AbstractC4151Dx1 {
        final /* synthetic */ TextView d;

        b(TextView textView) {
            this.d = textView;
        }

        @Override // ir.nasim.InterfaceC21549tj7
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(PictureDrawable pictureDrawable, InterfaceC22855vv7 interfaceC22855vv7) {
            AbstractC13042fc3.i(pictureDrawable, "resource");
            try {
                this.d.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, pictureDrawable, (Drawable) null);
            } catch (Exception e) {
                C19406qI3.d("RamzRialMoreOptionsBottomsheetContentView", e);
            }
        }

        @Override // ir.nasim.InterfaceC21549tj7
        public void g(Drawable drawable) {
        }
    }

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return RamzRialMoreOptionsBottomsheetContentView.this.new c(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                this.b = 1;
                if (HG1.b(100L, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            RamzRialMoreOptionsBottomsheetContentView ramzRialMoreOptionsBottomsheetContentView = RamzRialMoreOptionsBottomsheetContentView.this;
            ramzRialMoreOptionsBottomsheetContentView.f0(ramzRialMoreOptionsBottomsheetContentView.parent, RamzRialMoreOptionsBottomsheetContentView.this.parent, this.d);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RamzRialMoreOptionsBottomsheetContentView(BaseActivity baseActivity, C22186uo4 c22186uo4) {
        super(baseActivity);
        AbstractC13042fc3.i(baseActivity, "parent");
        AbstractC13042fc3.i(c22186uo4, "item");
        this.parent = baseActivity;
        C15253jG5 c15253jG5C = C15253jG5.c(LayoutInflater.from(getContext()), this, true);
        AbstractC13042fc3.h(c15253jG5C, "inflate(...)");
        this.binding = c15253jG5C;
        h(c22186uo4);
    }

    private final View e(final MyBankData.Item item) {
        TextView textView = new TextView(this.parent);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, AbstractC14828iY7.b(this, 56.0f)));
        Float fValueOf = Float.valueOf(16.0f);
        AbstractC14828iY7.k(textView, fValueOf, null, fValueOf, null, 10, null);
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        textView.setBackgroundColor(c5495Jo7.P0());
        textView.setTextColor(c5495Jo7.g1());
        textView.setTextSize(16.0f);
        textView.setText(item.getTitle());
        textView.setTypeface(C6011Lu2.k());
        textView.setGravity(16);
        textView.setCompoundDrawablePadding(AbstractC14828iY7.b(this, 8.0f));
        textView.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.iG5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RamzRialMoreOptionsBottomsheetContentView.g(item, this, view);
            }
        });
        OI2.c(this).b(PictureDrawable.class).A1(new URL(item.getIcon())).c0(C22078ud6.a(24.0f), C22078ud6.a(24.0f)).M0(new b(textView));
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(MyBankData.Item item, RamzRialMoreOptionsBottomsheetContentView ramzRialMoreOptionsBottomsheetContentView, View view) {
        String url;
        AbstractC13042fc3.i(item, "$item");
        AbstractC13042fc3.i(ramzRialMoreOptionsBottomsheetContentView, "this$0");
        MyBankData.Payload payload = item.getPayload();
        if (payload == null || (url = payload.getUrl()) == null) {
            return;
        }
        ramzRialMoreOptionsBottomsheetContentView.i(url);
    }

    private final View getDivider() {
        ImageView imageView = new ImageView(this.parent);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-1, AbstractC14828iY7.b(this, 1.0f)));
        imageView.setBackgroundColor(C5495Jo7.a.a1());
        return imageView;
    }

    private final void h(C22186uo4 item) {
        setupBottomsheet(item);
    }

    private final void i(String url) {
        AbstractC15087iz3 abstractC15087iz3A;
        Context context = getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        if (!C4100Dr4.a(context)) {
            Toast.makeText(getContext(), AbstractC12217eE5.bank_first_toast_for_check_network_description, 0).show();
            return;
        }
        BaseActivity baseActivity = this.parent;
        if (baseActivity != null && (abstractC15087iz3A = AbstractC19224pz3.a(baseActivity)) != null) {
            AbstractC10533bm0.d(abstractC15087iz3A, null, null, new c(url, null), 3, null);
        }
        C14486i0 c14486i0 = this.abol;
        if (c14486i0 != null) {
            c14486i0.g();
        }
    }

    private final void setupBottomsheet(C22186uo4 item) {
        MyBankData.Payload payloadA = item.a();
        ArrayList<MyBankData.Item> menuItems = payloadA != null ? payloadA.getMenuItems() : null;
        if (menuItems != null) {
            Iterator<MyBankData.Item> it = menuItems.iterator();
            AbstractC13042fc3.h(it, "iterator(...)");
            while (it.hasNext()) {
                MyBankData.Item next = it.next();
                AbstractC13042fc3.h(next, "next(...)");
                MyBankData.Item item2 = next;
                if (this.binding.b.getChildCount() > 0) {
                    this.binding.b.addView(getDivider());
                }
                this.binding.b.addView(e(item2));
            }
        }
    }

    public final C14486i0 getAbol() {
        return this.abol;
    }

    public final void setAbol(C14486i0 c14486i0) {
        this.abol = c14486i0;
    }

    public void setAbolInstance(C14486i0 abol) {
        this.abol = abol;
    }
}
