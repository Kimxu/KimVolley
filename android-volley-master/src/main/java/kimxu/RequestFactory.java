package kimxu;

import android.content.Context;

import kimxu.volley.RequestQueue;
import kimxu.volley.toolbox.Volley;

public class RequestFactory {
    private static RequestQueue queue;

    public static RequestQueue getRequestQueue(Context context) {
        if (queue == null) {
            synchronized (RequestFactory.class) {
                queue = Volley.newRequestQueue(context);
            }
        }
        return queue;
    }
}
