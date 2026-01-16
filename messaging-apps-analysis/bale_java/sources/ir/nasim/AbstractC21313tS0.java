package ir.nasim;

/* renamed from: ir.nasim.tS0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC21313tS0 {
    public static final void a(long j, EnumC24286yM4 enumC24286yM4) {
        if (enumC24286yM4 == EnumC24286yM4.a) {
            if (C17833ne1.k(j) != Integer.MAX_VALUE) {
                return;
            }
            P73.c("Vertically scrollable component was measured with an infinity maximum height constraints, which is disallowed. One of the common reasons is nesting layouts like LazyColumn and Column(Modifier.verticalScroll()). If you want to add a header before the list of items please add a header as a separate item() before the main items() inside the LazyColumn scope. There could be other reasons for this to happen: your ComposeView was added into a LinearLayout with some weight, you applied Modifier.wrapContentSize(unbounded = true) or wrote a custom layout. Please try to remove the source of infinite constraints in the hierarchy above the scrolling container.");
        } else {
            if (C17833ne1.l(j) != Integer.MAX_VALUE) {
                return;
            }
            P73.c("Horizontally scrollable component was measured with an infinity maximum width constraints, which is disallowed. One of the common reasons is nesting layouts like LazyRow and Row(Modifier.horizontalScroll()). If you want to add a header before the list of items please add a header as a separate item() before the main items() inside the LazyRow scope. There could be other reasons for this to happen: your ComposeView was added into a LinearLayout with some weight, you applied Modifier.wrapContentSize(unbounded = true) or wrote a custom layout. Please try to remove the source of infinite constraints in the hierarchy above the scrolling container.");
        }
    }
}
