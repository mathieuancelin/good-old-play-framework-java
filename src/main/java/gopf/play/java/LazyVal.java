package gopf.play.java;

import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.function.Supplier;

class LazyVal<T> {

    private final Supplier<T> supplier;

    private final AtomicReference<T> ref = new AtomicReference<T>(null);

    private LazyVal(Supplier<T> supplier) {
        this.supplier = supplier;
    }

    public static <T> LazyVal<T> of(Supplier<T> supplier) {
        return new LazyVal<T>(supplier);
    }

    public T get() {
        T val = ref.get();
        if (val == null) {
            T valNew = supplier.get();
            if (ref.compareAndSet(null, valNew)) {
                return valNew;
            } else {
                return ref.get();
            }
        }
        return val;
    }

    public <A> LazyVal<A> map(Function<T, A> f) {
        return new LazyVal<A>(() -> f.apply(get()));
    }
}
