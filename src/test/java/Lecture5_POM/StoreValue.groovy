package Lecture5_POM

/**
 * Created by aleksandrs on 21/05/2017.
 */
class StoreValue {

    static valueStore = new HashMap<String, Object>()

    static reset() {
        valueStore = new HashMap<String, Object>()
    }

    static store(String key, Object value) {
        valueStore.remove(key)
        valueStore.put(key, value)
    }

    static <T> T get(String key) {
        valueStore.get(key) as T
    }
}

