package kimxu.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import kimxu.HttpManager;
import kimxu.event.EventBus;
import kimxu.model.KObject;
import kimxu.volley.VolleyError;
import kimxu.volley.ktoolbox.KStringRequest;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
        HttpManager httpManager =HttpManager.getInstance(getBaseContext());
        httpManager.sendRequest(new KStringRequest("asas",1));
    }
    public void onEventMainThread(KObject event) {
        if (event.request!=1)
            return;
        if (event.error!=null) {
            processHttpError(event.error);
        }else {
            processHttpResponse(event);
        }

    }
    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }





    private void processHttpResponse(KObject event) {
        FirstEvent firstEvent = new FirstEvent(event);
        String msg = "onEventMainThread收到了消息：" + firstEvent.getMsg();
        Log.d("harvic", msg);
    }

    private void processHttpError(VolleyError msg) {
        Log.d("harvic", msg.getMessage());
    }
}
