# KimVolley
做了一个Volley+EventBus 整合在一起

1.注册与反注册EventBus
onCreate
EventBus.getDefault().register(this);
onDestory
EventBus.getDefault().unregister(this);

2.启动Volley加载数据
 
 HttpManager httpManager =HttpManager.getInstance(getBaseContext());
 httpManager.sendRequest(new KStringRequest("www.weibo.com",1));
 
3.在onEventMainThread中监听加载到的数据
public void onEventMainThread(KObject event) {
        if (event.request!=1)
            return;
        if (event.error!=null) {
            processHttpError(event.error);
        }else {
            processHttpResponse(event);
        }
    }
    
    取消了handler的使用 其他的请求可以自定义
