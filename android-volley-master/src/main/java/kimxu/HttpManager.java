package kimxu;

import android.content.Context;

import kimxu.volley.Request;
import kimxu.volley.RequestQueue;

public class HttpManager {
    private static volatile HttpManager instance;
    private static Context context;
    public static HttpManager getInstance(Context context) {
        if (instance == null) {
            synchronized (HttpManager.class) {
                instance = new HttpManager();
                HttpManager.context=context;
            }
        }
        return instance;
    }
    private HttpManager() {}


    public void sendRequest(Request<?> request) {
        RequestQueue queue = RequestFactory.getRequestQueue(context);
        queue.add((Request<?>) request);
    }
}
